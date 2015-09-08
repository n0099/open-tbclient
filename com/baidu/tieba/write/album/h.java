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
    private int Bn;
    private AlbumActivity cYB;
    private Map<Integer, Boolean> cYR = new HashMap();
    private com.baidu.tbadk.img.b cYw;
    private List<ImageFileInfo> mList;
    private int mMaxHeight;

    public h(AlbumActivity albumActivity, com.baidu.tbadk.img.b bVar) {
        this.cYB = albumActivity;
        this.cYw = bVar;
        this.Bn = com.baidu.adp.lib.util.k.K(this.cYB.getPageContext().getContext());
        this.mMaxHeight = com.baidu.adp.lib.util.k.L(this.cYB.getPageContext().getContext()) - ((int) this.cYB.getResources().getDimension(i.d.album_bottom_height));
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

    public ImageFileInfo kR(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.mList.get(i);
    }

    public boolean kS(int i) {
        if (this.cYR.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.cYR.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.cYB.getPageContext().getContext()).inflate(i.g.album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(i.f.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultBgResource(0);
        ImageFileInfo kR = kR(i);
        this.cYR.put(Integer.valueOf(i), false);
        if (kR != null) {
            kR.clearPageActions();
            kR.addPageAction(com.baidu.tbadk.img.effect.d.J(this.Bn, this.mMaxHeight));
            tbImageView.setTag(kR.toCachedKey(false));
            if (this.cYw.a(kR, false) != null) {
                tbImageView.invalidate();
                this.cYR.put(Integer.valueOf(i), true);
            } else {
                this.cYw.a(kR, new i(this, viewGroup, i), false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
