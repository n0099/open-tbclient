package com.baidu.tieba.write.album;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class h extends PagerAdapter {
    private int Bo;
    private com.baidu.tbadk.img.b aml;
    private AlbumActivity dlE;
    private Map<Integer, Boolean> dlU = new HashMap();
    private List<ImageFileInfo> mList;
    private int mMaxHeight;

    public h(AlbumActivity albumActivity, com.baidu.tbadk.img.b bVar) {
        this.dlE = albumActivity;
        this.aml = bVar;
        this.Bo = com.baidu.adp.lib.util.k.K(this.dlE.getPageContext().getContext());
        this.mMaxHeight = com.baidu.adp.lib.util.k.L(this.dlE.getPageContext().getContext()) - ((int) this.dlE.getResources().getDimension(i.d.album_bottom_height));
    }

    public void setData(List<ImageFileInfo> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.mList != null) {
            return this.mList.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
    }

    public ImageFileInfo lW(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.mList.get(i);
    }

    public boolean lX(int i) {
        if (this.dlU.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.dlU.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.dlE.getPageContext().getContext()).inflate(i.g.album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(i.f.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultBgResource(0);
        ImageFileInfo lW = lW(i);
        this.dlU.put(Integer.valueOf(i), false);
        if (lW != null) {
            lW.clearPageActions();
            lW.addPageAction(com.baidu.tbadk.img.effect.d.J(this.Bo, this.mMaxHeight));
            tbImageView.setTag(lW.toCachedKey(false));
            if (this.aml.a(lW, false) != null) {
                tbImageView.invalidate();
                this.dlU.put(Integer.valueOf(i), true);
            } else {
                this.aml.a(lW, new i(this, viewGroup, i), false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
