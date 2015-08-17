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
    private int Bp;
    private com.baidu.tbadk.img.b cPM;
    private AlbumActivity cPQ;
    private Map<Integer, Boolean> cQg = new HashMap();
    private List<ImageFileInfo> mList;
    private int mMaxHeight;

    public h(AlbumActivity albumActivity, com.baidu.tbadk.img.b bVar) {
        this.cPQ = albumActivity;
        this.cPM = bVar;
        this.Bp = com.baidu.adp.lib.util.k.K(this.cPQ.getPageContext().getContext());
        this.mMaxHeight = com.baidu.adp.lib.util.k.L(this.cPQ.getPageContext().getContext()) - ((int) this.cPQ.getResources().getDimension(i.d.album_bottom_height));
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

    public ImageFileInfo kg(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.mList.get(i);
    }

    public boolean kh(int i) {
        if (this.cQg.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.cQg.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.cPQ.getPageContext().getContext()).inflate(i.g.album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(i.f.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultBgResource(0);
        ImageFileInfo kg = kg(i);
        this.cQg.put(Integer.valueOf(i), false);
        if (kg != null) {
            kg.clearPageActions();
            kg.addPageAction(com.baidu.tbadk.img.effect.d.J(this.Bp, this.mMaxHeight));
            tbImageView.setTag(kg.toCachedKey(false));
            if (this.cPM.a(kg, false) != null) {
                tbImageView.invalidate();
                this.cQg.put(Integer.valueOf(i), true);
            } else {
                this.cPM.a(kg, new i(this, viewGroup, i), false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
