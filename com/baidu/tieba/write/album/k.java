package com.baidu.tieba.write.album;

import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class k extends PagerAdapter {
    private int BS;
    private com.baidu.tbadk.img.b awf;
    private Map<Integer, Boolean> fME = new HashMap();
    private ColorDrawable fMF;
    private AlbumActivity fMg;
    private List<ImageFileInfo> mList;
    private int mMaxHeight;

    public k(AlbumActivity albumActivity, com.baidu.tbadk.img.b bVar) {
        this.fMg = albumActivity;
        this.awf = bVar;
        this.BS = com.baidu.adp.lib.util.k.af(this.fMg.getPageContext().getContext());
        this.mMaxHeight = com.baidu.adp.lib.util.k.ag(this.fMg.getPageContext().getContext()) - ((int) this.fMg.getResources().getDimension(w.f.ds166));
        this.fMF = new ColorDrawable(this.fMg.getResources().getColor(w.e.black_alpha100));
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

    public ImageFileInfo sN(int i) {
        return (ImageFileInfo) com.baidu.tbadk.core.util.x.c(this.mList, i);
    }

    public boolean sO(int i) {
        if (this.fME.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.fME.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.fMg.getPageContext().getContext()).inflate(w.j.album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(w.h.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setDefaultBgResource(w.e.black_alpha100);
        tbImageView.setBg(this.fMF);
        ImageFileInfo sN = sN(i);
        this.fME.put(Integer.valueOf(i), false);
        if (sN != null) {
            sN.clearPageActions();
            sN.addPageAction(com.baidu.tbadk.img.effect.d.M(this.BS, this.mMaxHeight));
            tbImageView.setTag(sN.toCachedKey(false));
            if (this.awf.a(sN, false) != null) {
                tbImageView.invalidate();
                this.fME.put(Integer.valueOf(i), true);
            } else {
                this.awf.a(sN, new l(this, viewGroup, i), false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
