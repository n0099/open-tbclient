package com.baidu.yuyinala.privatemessage.implugin.imagechooser;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.sumeru.universalimageloader.core.DisplayImageOptions;
import com.baidu.sumeru.universalimageloader.core.ImageLoader;
import com.baidu.sumeru.universalimageloader.core.assist.ImageLoadingListener;
import java.util.List;
/* loaded from: classes11.dex */
public class ImagePagerAdapter extends PagerAdapter {
    private List<String> mDatas;
    private ImageLoader oTV;
    private String oTW;
    private DisplayImageOptions oTX;

    public Object getItem(int i) {
        if (i < this.mDatas.size()) {
            return this.mDatas.get(i);
        }
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mDatas.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: U */
    public View instantiateItem(ViewGroup viewGroup, int i) {
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.oTW = (String) getItem(i);
        this.oTV.displayImage(Yi(this.oTW), imageView, this.oTX, (ImageLoadingListener) null);
        viewGroup.addView(imageView, -1, -1);
        return imageView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    private static String Yi(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return !str.startsWith("file://") ? "file://" + str : str;
    }
}
