package com.baidu.tieba.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Gallery;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.view.DragImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ImagePagerAdapter extends PagerAdapter {
    private Context mContext;
    private DragImageView.OnGifSetListener mOnGifSetListener;
    private ArrayList<String> mUrl;
    private View.OnClickListener mOnClickListener = null;
    private DragImageView.OnSizeChangedListener mOnSizeChangedListener = null;
    private int mGifMaxUseableMem = 0;

    /* loaded from: classes.dex */
    public interface ImageLoadCallBack {
        void callback();
    }

    public ImagePagerAdapter(Context context, ArrayList<String> url, DragImageView.OnGifSetListener onGifSetListener) {
        this.mContext = null;
        this.mUrl = null;
        this.mOnGifSetListener = null;
        this.mContext = context;
        this.mUrl = url;
        this.mOnGifSetListener = onGifSetListener;
    }

    public void setData(ArrayList<String> data) {
        this.mUrl = data;
        notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.mUrl == null) {
            return 0;
        }
        int num = this.mUrl.size();
        return num;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.mOnClickListener = listener;
    }

    public void setGifMaxUseableMem(int mem) {
        this.mGifMaxUseableMem = mem;
    }

    public void setmOnSizeChangedListener(DragImageView.OnSizeChangedListener listener) {
        this.mOnSizeChangedListener = listener;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
        if (object instanceof UrlDragImageView) {
            UrlDragImageView urlImage = (UrlDragImageView) object;
            urlImage.onDestroy();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup container, int position) {
        UrlDragImageView iv = new UrlDragImageView(this.mContext);
        String url = this.mUrl.get(position);
        iv.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        iv.setImageOnClickListener(this.mOnClickListener);
        iv.setOnSizeChangedListener(this.mOnSizeChangedListener);
        ((ViewPager) container).addView(iv, 0);
        iv.setUrl(url);
        iv.setGifMaxUseableMem(this.mGifMaxUseableMem);
        iv.setTag(String.valueOf(position));
        iv.setGifSetListener(this.mOnGifSetListener);
        return iv;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        TiebaLog.d(getClass().getName(), "setPrimaryItem", "position = " + String.valueOf(position));
        super.setPrimaryItem(container, position, object);
        if (object instanceof UrlDragImageView) {
            GalleryViewPager pager = (GalleryViewPager) container;
            DragImageView drag = ((UrlDragImageView) object).getImageView();
            if (pager.getSelectedView() == null) {
                pager.setSelectedView(drag);
                ViewParent Parent = pager.getParent();
                if (Parent != null && (Parent instanceof MultiImageView)) {
                    ((MultiImageView) Parent).setZoomButton(drag);
                }
            }
            DragImageView tmp = pager.getCurrentView();
            if (drag != tmp) {
                if (tmp != null) {
                    tmp.restoreSize();
                }
                ((UrlDragImageView) object).checkImage();
                pager.setCurrentView(drag);
                if (((UrlDragImageView) object).getImageType() == 1) {
                    this.mOnGifSetListener.gifSet(drag);
                }
            }
        }
    }
}
