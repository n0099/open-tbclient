package com.baidu.tieba.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Gallery;
import android.widget.TextView;
import com.baidu.tieba.R;
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
    private boolean mHasNext = false;
    private String mNextTitle = null;

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

    public void setNextTitle(String nextTitle) {
        this.mNextTitle = nextTitle;
    }

    public void setHasNext(boolean hasNext) {
        this.mHasNext = hasNext;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.mUrl == null) {
            return 0;
        }
        int num = this.mUrl.size();
        if (this.mHasNext) {
            return num + 1;
        }
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
        if (position == this.mUrl.size()) {
            LayoutInflater mInflater = LayoutInflater.from(this.mContext);
            View nextView = mInflater.inflate(R.layout.big_image_next, (ViewGroup) null);
            TextView threadText = (TextView) nextView.findViewById(R.id.thread_name);
            threadText.setText(this.mNextTitle);
            container.addView(nextView);
            nextView.setOnClickListener(this.mOnClickListener);
            return nextView;
        }
        UrlDragImageView iv = new UrlDragImageView(this.mContext);
        String url = null;
        if (position < this.mUrl.size()) {
            String url2 = this.mUrl.get(position);
            url = url2;
        }
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
