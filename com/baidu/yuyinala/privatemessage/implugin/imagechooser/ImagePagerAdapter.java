package com.baidu.yuyinala.privatemessage.implugin.imagechooser;

import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.sumeru.universalimageloader.core.DisplayImageOptions;
import com.baidu.sumeru.universalimageloader.core.ImageLoader;
import com.baidu.sumeru.universalimageloader.core.assist.ImageLoadingListener;
import java.util.List;
/* loaded from: classes4.dex */
public class ImagePagerAdapter extends PagerAdapter {
    private List<String> mDatas;
    private ImageLoader oNK;
    private String oNL;
    private DisplayImageOptions oNM;

    public Object getItem(int i) {
        if (i < this.mDatas.size()) {
            return this.mDatas.get(i);
        }
        return null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mDatas.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v4.view.PagerAdapter
    /* renamed from: Q */
    public View instantiateItem(ViewGroup viewGroup, int i) {
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.oNL = (String) getItem(i);
        this.oNK.displayImage(Yz(this.oNL), imageView, this.oNM, (ImageLoadingListener) null);
        viewGroup.addView(imageView, -1, -1);
        return imageView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    private static String Yz(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return !str.startsWith("file://") ? "file://" + str : str;
    }
}
