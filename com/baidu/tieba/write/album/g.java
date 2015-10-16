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
    private com.baidu.tbadk.img.b amg;
    private AlbumActivity djW;
    private Map<Integer, Boolean> dkm = new HashMap();
    private List<ImageFileInfo> mList;
    private int mMaxHeight;

    public g(AlbumActivity albumActivity, com.baidu.tbadk.img.b bVar) {
        this.djW = albumActivity;
        this.amg = bVar;
        this.Bo = com.baidu.adp.lib.util.k.K(this.djW.getPageContext().getContext());
        this.mMaxHeight = com.baidu.adp.lib.util.k.L(this.djW.getPageContext().getContext()) - ((int) this.djW.getResources().getDimension(i.d.album_bottom_height));
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

    public ImageFileInfo lI(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.mList.get(i);
    }

    public boolean lJ(int i) {
        if (this.dkm.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.dkm.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.djW.getPageContext().getContext()).inflate(i.g.album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(i.f.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultBgResource(0);
        ImageFileInfo lI = lI(i);
        this.dkm.put(Integer.valueOf(i), false);
        if (lI != null) {
            lI.clearPageActions();
            lI.addPageAction(com.baidu.tbadk.img.effect.d.J(this.Bo, this.mMaxHeight));
            tbImageView.setTag(lI.toCachedKey(false));
            if (this.amg.a(lI, false) != null) {
                tbImageView.invalidate();
                this.dkm.put(Integer.valueOf(i), true);
            } else {
                this.amg.a(lI, new h(this, viewGroup, i), false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
