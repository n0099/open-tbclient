package com.baidu.tieba.write.album;

import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class j extends PagerAdapter {
    private com.baidu.tbadk.img.b aqo;
    private AlbumActivity fGS;
    private Map<Integer, Boolean> fHj = new HashMap();
    private ColorDrawable fHk;
    private List<ImageFileInfo> mList;
    private int mMaxHeight;
    private int va;

    public j(AlbumActivity albumActivity, com.baidu.tbadk.img.b bVar) {
        this.fGS = albumActivity;
        this.aqo = bVar;
        this.va = com.baidu.adp.lib.util.k.I(this.fGS.getPageContext().getContext());
        this.mMaxHeight = com.baidu.adp.lib.util.k.J(this.fGS.getPageContext().getContext()) - ((int) this.fGS.getResources().getDimension(r.f.ds166));
        this.fHk = new ColorDrawable(this.fGS.getResources().getColor(r.e.black_alpha100));
    }

    public void setData(List<ImageFileInfo> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.mList != null) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.w.c(this.mList, 0);
            if (imageFileInfo != null && "-2".equals(imageFileInfo.getAlbumId()) && this.mList.size() > 1) {
                return this.mList.size() - 1;
            }
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

    public ImageFileInfo sQ(int i) {
        return (ImageFileInfo) com.baidu.tbadk.core.util.w.c(this.mList, i);
    }

    public boolean sR(int i) {
        if (this.fHj.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.fHj.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ImageFileInfo sQ;
        View inflate = LayoutInflater.from(this.fGS.getPageContext().getContext()).inflate(r.j.album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(r.h.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setDefaultBgResource(r.e.black_alpha100);
        tbImageView.setBg(this.fHk);
        ImageFileInfo imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.w.c(this.mList, 0);
        if (imageFileInfo != null && "-2".equals(imageFileInfo.getAlbumId())) {
            sQ = sQ(i + 1);
        } else {
            sQ = sQ(i);
        }
        this.fHj.put(Integer.valueOf(i), false);
        if (sQ != null) {
            sQ.clearPageActions();
            sQ.addPageAction(com.baidu.tbadk.img.effect.d.G(this.va, this.mMaxHeight));
            tbImageView.setTag(sQ.toCachedKey(false));
            if (this.aqo.a(sQ, false) != null) {
                tbImageView.invalidate();
                this.fHj.put(Integer.valueOf(i), true);
            } else {
                this.aqo.a(sQ, new k(this, viewGroup, i), false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
