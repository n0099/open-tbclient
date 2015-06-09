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
public class j extends PagerAdapter {
    private int BF;
    private com.baidu.tbadk.img.e cxY;
    private AlbumActivity cya;
    private Map<Integer, Boolean> cyr = new HashMap();
    private List<ImageFileInfo> mList;
    private int mMaxHeight;

    public j(AlbumActivity albumActivity, com.baidu.tbadk.img.e eVar) {
        this.cya = albumActivity;
        this.cxY = eVar;
        this.BF = com.baidu.adp.lib.util.n.M(this.cya.getPageContext().getContext());
        this.mMaxHeight = com.baidu.adp.lib.util.n.N(this.cya.getPageContext().getContext()) - ((int) this.cya.getResources().getDimension(com.baidu.tieba.o.album_bottom_height));
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

    public ImageFileInfo jm(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.mList.get(i);
    }

    public boolean jn(int i) {
        if (this.cyr.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.cyr.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate = com.baidu.adp.lib.g.b.hr().inflate(this.cya.getPageContext().getContext(), com.baidu.tieba.r.album_big_image_item, null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(com.baidu.tieba.q.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultBgResource(0);
        ImageFileInfo jm = jm(i);
        this.cyr.put(Integer.valueOf(i), false);
        if (jm != null) {
            jm.clearPageActions();
            jm.addPageAction(com.baidu.tbadk.img.effect.d.y(this.BF, this.mMaxHeight));
            tbImageView.setTag(jm.toCachedKey(false));
            if (this.cxY.a(jm, false) != null) {
                tbImageView.invalidate();
                this.cyr.put(Integer.valueOf(i), true);
            } else {
                this.cxY.a(jm, new k(this, viewGroup, i), false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
