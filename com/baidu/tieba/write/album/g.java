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
public class g extends PagerAdapter {
    private int Bo;
    private com.baidu.tbadk.img.b amf;
    private Map<Integer, Boolean> djM = new HashMap();
    private AlbumActivity djw;
    private List<ImageFileInfo> mList;
    private int mMaxHeight;

    public g(AlbumActivity albumActivity, com.baidu.tbadk.img.b bVar) {
        this.djw = albumActivity;
        this.amf = bVar;
        this.Bo = com.baidu.adp.lib.util.k.K(this.djw.getPageContext().getContext());
        this.mMaxHeight = com.baidu.adp.lib.util.k.L(this.djw.getPageContext().getContext()) - ((int) this.djw.getResources().getDimension(i.d.album_bottom_height));
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

    public ImageFileInfo lG(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.mList.get(i);
    }

    public boolean lH(int i) {
        if (this.djM.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.djM.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.djw.getPageContext().getContext()).inflate(i.g.album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(i.f.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultBgResource(0);
        ImageFileInfo lG = lG(i);
        this.djM.put(Integer.valueOf(i), false);
        if (lG != null) {
            lG.clearPageActions();
            lG.addPageAction(com.baidu.tbadk.img.effect.d.J(this.Bo, this.mMaxHeight));
            tbImageView.setTag(lG.toCachedKey(false));
            if (this.amf.a(lG, false) != null) {
                tbImageView.invalidate();
                this.djM.put(Integer.valueOf(i), true);
            } else {
                this.amf.a(lG, new h(this, viewGroup, i), false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
