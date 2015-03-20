package com.baidu.tieba.write.album;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class h extends PagerAdapter {
    private int BQ;
    private Map<Integer, Boolean> ctI = new HashMap();
    private com.baidu.tbadk.img.e cts;
    private AlbumActivity ctu;
    private List<ImageFileInfo> mList;
    private int mMaxHeight;

    public h(AlbumActivity albumActivity, com.baidu.tbadk.img.e eVar) {
        this.ctu = albumActivity;
        this.cts = eVar;
        this.BQ = com.baidu.adp.lib.util.n.M(this.ctu.getPageContext().getContext());
        this.mMaxHeight = com.baidu.adp.lib.util.n.N(this.ctu.getPageContext().getContext()) - ((int) this.ctu.getResources().getDimension(com.baidu.tieba.t.album_bottom_height));
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

    public ImageFileInfo iN(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.mList.get(i);
    }

    public boolean iO(int i) {
        if (this.ctI.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.ctI.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.ctu.getPageContext().getContext(), com.baidu.tieba.w.album_big_image_item, null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(com.baidu.tieba.v.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultBgResource(0);
        ImageFileInfo iN = iN(i);
        this.ctI.put(Integer.valueOf(i), false);
        if (iN != null) {
            iN.clearPageActions();
            iN.addPageAction(com.baidu.tbadk.img.effect.d.x(this.BQ, this.mMaxHeight));
            tbImageView.setTag(iN.toCachedKey(false));
            if (this.cts.a(iN, false) != null) {
                tbImageView.invalidate();
                this.ctI.put(Integer.valueOf(i), true);
            } else {
                this.cts.a(iN, new i(this, viewGroup, i), false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
