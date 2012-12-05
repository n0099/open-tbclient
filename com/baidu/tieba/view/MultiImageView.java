package com.baidu.tieba.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.BaseViewPager;
import com.baidu.tieba.view.DragImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MultiImageView extends RelativeLayout {
    private ImagePagerAdapter mAdapter;
    private GalleryViewPager mGalleryViewPager;
    private int mGifMaxMemory;
    private boolean mGifPlayRealseOther;
    private boolean mIsSupportGesture;
    private View.OnClickListener mOnClickListener;
    private DragImageView.OnGifSetListener mOnGifSetListener;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private DragImageView.OnSizeChangedListener mOnSizeChangedListener;
    private LinearLayout mTools;
    private ViewPager.OnPageChangeListener mUserOnPageChangeListener;
    private Button mZoomIn;
    private Button mZoomOut;

    public MultiImageView(Context context) {
        super(context);
        this.mZoomIn = null;
        this.mZoomOut = null;
        this.mTools = null;
        this.mOnClickListener = null;
        this.mGalleryViewPager = null;
        this.mOnPageChangeListener = null;
        this.mUserOnPageChangeListener = null;
        this.mOnSizeChangedListener = null;
        this.mAdapter = null;
        this.mOnGifSetListener = null;
        this.mGifMaxMemory = 0;
        this.mGifPlayRealseOther = true;
        this.mIsSupportGesture = false;
        init();
    }

    public void setOnScrollOutListener(BaseViewPager.OnScrollOutListener listener) {
        if (this.mGalleryViewPager != null) {
            this.mGalleryViewPager.setOnScrollOutListener(listener);
        }
    }

    public MultiImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mZoomIn = null;
        this.mZoomOut = null;
        this.mTools = null;
        this.mOnClickListener = null;
        this.mGalleryViewPager = null;
        this.mOnPageChangeListener = null;
        this.mUserOnPageChangeListener = null;
        this.mOnSizeChangedListener = null;
        this.mAdapter = null;
        this.mOnGifSetListener = null;
        this.mGifMaxMemory = 0;
        this.mGifPlayRealseOther = true;
        this.mIsSupportGesture = false;
        init();
    }

    public MultiImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mZoomIn = null;
        this.mZoomOut = null;
        this.mTools = null;
        this.mOnClickListener = null;
        this.mGalleryViewPager = null;
        this.mOnPageChangeListener = null;
        this.mUserOnPageChangeListener = null;
        this.mOnSizeChangedListener = null;
        this.mAdapter = null;
        this.mOnGifSetListener = null;
        this.mGifMaxMemory = 0;
        this.mGifPlayRealseOther = true;
        this.mIsSupportGesture = false;
        init();
    }

    private void init() {
        this.mIsSupportGesture = UtilHelper.isSupportGesture(getContext());
        initEvent();
        initUI();
    }

    private void initEvent() {
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.MultiImageView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DragImageView view;
                if (v != MultiImageView.this.mZoomIn) {
                    if (v == MultiImageView.this.mZoomOut && (view = MultiImageView.this.getCurrentImageView()) != null) {
                        view.zoomOutBitmap();
                        return;
                    }
                    return;
                }
                DragImageView view2 = MultiImageView.this.getCurrentImageView();
                if (view2 != null) {
                    view2.zoomInBitmap();
                }
            }
        };
        this.mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.view.MultiImageView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int arg0) {
                if (MultiImageView.this.mUserOnPageChangeListener != null) {
                    MultiImageView.this.mUserOnPageChangeListener.onPageScrollStateChanged(arg0);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                if (MultiImageView.this.mUserOnPageChangeListener != null) {
                    MultiImageView.this.mUserOnPageChangeListener.onPageScrolled(arg0, arg1, arg2);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int postion) {
                DragImageView drag;
                TiebaLog.d(getClass().getName(), "onPageSelected", "postion = " + String.valueOf(postion));
                View view = MultiImageView.this.mGalleryViewPager.findViewWithTag(String.valueOf(postion));
                if (view != null && (view instanceof UrlDragImageView) && (drag = ((UrlDragImageView) view).getImageView()) != null) {
                    MultiImageView.this.mGalleryViewPager.setSelectedView(drag);
                    drag.restoreSize();
                }
                int num = MultiImageView.this.mGalleryViewPager.getChildCount();
                for (int i = 0; i < num; i++) {
                    View child = MultiImageView.this.mGalleryViewPager.getChildAt(i);
                    if (child != null && (child instanceof UrlDragImageView)) {
                        ((UrlDragImageView) child).stopGif();
                    }
                }
                NetWorkCore.NetworkStateInfo info = NetWorkCore.getStatusInfo(MultiImageView.this.getContext());
                if (MultiImageView.this.mGifPlayRealseOther && (info == NetWorkCore.NetworkStateInfo.WIFI || info == NetWorkCore.NetworkStateInfo.ThreeG)) {
                    for (int i2 = 0; i2 < num; i2++) {
                        View child2 = MultiImageView.this.mGalleryViewPager.getChildAt(i2);
                        if (child2 != null && (child2 instanceof UrlDragImageView)) {
                            ((UrlDragImageView) child2).checkImage();
                        }
                    }
                }
                if (MultiImageView.this.mUserOnPageChangeListener != null) {
                    MultiImageView.this.mUserOnPageChangeListener.onPageSelected(postion);
                }
            }
        };
        this.mOnSizeChangedListener = new DragImageView.OnSizeChangedListener() { // from class: com.baidu.tieba.view.MultiImageView.3
            @Override // com.baidu.tieba.view.DragImageView.OnSizeChangedListener
            public void sizeChenged(DragImageView view, boolean canZoomIn, boolean canZoomOut) {
                if (MultiImageView.this.mGalleryViewPager.getSelectedView() == view) {
                    MultiImageView.this.setZoomButton(view);
                }
            }
        };
        this.mOnGifSetListener = new DragImageView.OnGifSetListener() { // from class: com.baidu.tieba.view.MultiImageView.4
            @Override // com.baidu.tieba.view.DragImageView.OnGifSetListener
            public void gifSet(DragImageView view) {
                if (view == MultiImageView.this.mGalleryViewPager.getCurrentView()) {
                    if (MultiImageView.this.mGifPlayRealseOther) {
                        int num = MultiImageView.this.mGalleryViewPager.getChildCount();
                        for (int i = 0; i < num; i++) {
                            View child = MultiImageView.this.mGalleryViewPager.getChildAt(i);
                            if (child != null && (child instanceof UrlDragImageView) && ((UrlDragImageView) child).getImageView() != view) {
                                ((UrlDragImageView) child).release();
                            }
                        }
                    }
                    view.play();
                }
            }
        };
    }

    public void onResume() {
        if (this.mGalleryViewPager.getCurrentView() != null) {
            if (this.mGifPlayRealseOther) {
                int num = this.mGalleryViewPager.getChildCount();
                for (int i = 0; i < num; i++) {
                    View child = this.mGalleryViewPager.getChildAt(i);
                    if (child != null && (child instanceof UrlDragImageView) && ((UrlDragImageView) child).getImageView() != this.mGalleryViewPager.getCurrentView()) {
                        ((UrlDragImageView) child).release();
                    }
                }
            }
            int index = this.mGalleryViewPager.getCurrentItem();
            View view = this.mGalleryViewPager.findViewWithTag(String.valueOf(index));
            if (view != null && (view instanceof UrlDragImageView)) {
                ((UrlDragImageView) view).checkImage();
            }
            this.mGalleryViewPager.getCurrentView().play();
        }
    }

    public void onPause() {
        if (this.mGalleryViewPager.getCurrentView() != null) {
            this.mGalleryViewPager.getCurrentView().pause();
        }
    }

    public void onDestroy() {
        if (this.mGalleryViewPager != null) {
            int num = this.mGalleryViewPager.getChildCount();
            for (int i = 0; i < num; i++) {
                View child = this.mGalleryViewPager.getChildAt(i);
                if (child != null && (child instanceof UrlDragImageView)) {
                    ((UrlDragImageView) child).onDestroy();
                }
            }
        }
    }

    private void initUI() {
        this.mGalleryViewPager = new GalleryViewPager(getContext());
        this.mGalleryViewPager.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mGalleryViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
        addView(this.mGalleryViewPager);
        this.mTools = new LinearLayout(getContext());
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(-2, -2);
        params.bottomMargin = UtilHelper.dip2px(getContext(), 10.0f);
        params.addRule(12);
        params.addRule(14);
        this.mTools.setOrientation(0);
        this.mTools.setLayoutParams(params);
        addView(this.mTools);
        LinearLayout.LayoutParams l_param = new LinearLayout.LayoutParams(-2, -2);
        this.mZoomOut = new Button(getContext());
        this.mZoomOut.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.image_zoomout));
        this.mZoomOut.setLayoutParams(l_param);
        this.mZoomOut.setOnClickListener(this.mOnClickListener);
        this.mZoomOut.setEnabled(false);
        this.mTools.addView(this.mZoomOut);
        this.mZoomIn = new Button(getContext());
        this.mZoomIn.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.image_zoomin));
        this.mZoomIn.setLayoutParams(l_param);
        this.mZoomIn.setOnClickListener(this.mOnClickListener);
        this.mZoomIn.setEnabled(false);
        this.mTools.addView(this.mZoomIn);
        if (this.mIsSupportGesture) {
            this.mTools.setVisibility(8);
        }
        this.mAdapter = new ImagePagerAdapter(getContext(), null, this.mOnGifSetListener);
        setAdapter(this.mAdapter);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener listener) {
        this.mUserOnPageChangeListener = listener;
    }

    public void setZoomButton(DragImageView view) {
        if (view != null) {
            if (view.canZoomIn()) {
                this.mZoomIn.setEnabled(true);
            } else {
                this.mZoomIn.setEnabled(false);
            }
            if (view.canZoomOut()) {
                this.mZoomOut.setEnabled(true);
                return;
            } else {
                this.mZoomOut.setEnabled(false);
                return;
            }
        }
        this.mZoomOut.setEnabled(false);
        this.mZoomIn.setEnabled(false);
    }

    public void switchTools() {
        if (!this.mIsSupportGesture) {
            if (this.mTools.getVisibility() != 0) {
                this.mTools.setVisibility(0);
            } else {
                this.mTools.setVisibility(8);
            }
        }
    }

    public void showTools() {
        if (!this.mIsSupportGesture) {
            this.mTools.setVisibility(0);
        }
    }

    public void hideTools() {
        if (!this.mIsSupportGesture) {
            this.mTools.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DragImageView getCurrentImageView() {
        return this.mGalleryViewPager.getCurrentView();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    public void setPageMargin(int px) {
        this.mGalleryViewPager.setPageMargin(px);
    }

    public void setOffscreenPageLimit(int limit, int image_size) {
        this.mGalleryViewPager.setOffscreenPageLimit(limit);
        this.mGifMaxMemory = UtilHelper.getBitmapMaxMemory(getContext()) - ((((limit * 2) + 1) * image_size) * 2);
        this.mGifMaxMemory = (int) (this.mGifMaxMemory * 0.8d);
        if (this.mGifMaxMemory < Config.THREAD_GIF_MIN_USE_MEMORY) {
            this.mGifPlayRealseOther = true;
            this.mGifMaxMemory = (int) (UtilHelper.getBitmapMaxMemory(getContext()) * 0.7d);
        } else {
            this.mGifPlayRealseOther = false;
        }
        PagerAdapter adapter = this.mGalleryViewPager.getAdapter();
        if (adapter != null && (adapter instanceof ImagePagerAdapter)) {
            ((ImagePagerAdapter) adapter).setGifMaxUseableMem(this.mGifMaxMemory);
        }
    }

    private void setAdapter(ImagePagerAdapter adapter) {
        adapter.setmOnSizeChangedListener(this.mOnSizeChangedListener);
        this.mGalleryViewPager.setAdapter(adapter);
    }

    public void setCurrentItem(int item, boolean smoothScroll) {
        this.mGalleryViewPager.setCurrentItem(item, smoothScroll);
    }

    public void setItemOnclickListener(View.OnClickListener listener) {
        this.mAdapter.setOnClickListener(listener);
    }

    public void setUrlData(ArrayList<String> data) {
        this.mAdapter.setData(data);
        this.mAdapter.notifyDataSetChanged();
    }

    public void setHasNext(boolean hasNext) {
        this.mAdapter.setHasNext(hasNext);
    }

    public void setNextTitle(String title) {
        this.mAdapter.setNextTitle(title);
    }

    public byte[] getCurrentImageData() {
        byte[] data = null;
        DragImageView view = this.mGalleryViewPager.getSelectedView();
        if (view != null) {
            byte[] data2 = view.getImageData();
            return data2;
        }
        return data;
    }

    public String getCurrentImageUrl() {
        DragImageView view = this.mGalleryViewPager.getSelectedView();
        if (!(view.getTag() instanceof String)) {
            return null;
        }
        String url = (String) view.getTag();
        return url;
    }
}
