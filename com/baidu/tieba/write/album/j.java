package com.baidu.tieba.write.album;

import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class j extends PagerAdapter {
    private com.baidu.tbadk.img.b arb;
    private AlbumActivity gaf;
    private Map<Integer, Boolean> gas = new HashMap();
    private ColorDrawable gat;
    private List<ImageFileInfo> mList;
    private int mMaxHeight;
    private int vi;

    public j(AlbumActivity albumActivity, com.baidu.tbadk.img.b bVar) {
        this.gaf = albumActivity;
        this.arb = bVar;
        this.vi = com.baidu.adp.lib.util.k.K(this.gaf.getPageContext().getContext());
        this.mMaxHeight = com.baidu.adp.lib.util.k.L(this.gaf.getPageContext().getContext()) - ((int) this.gaf.getResources().getDimension(t.e.ds166));
        this.gat = new ColorDrawable(this.gaf.getResources().getColor(t.d.black_alpha100));
    }

    public void setData(List<ImageFileInfo> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.mList != null) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.y.c(this.mList, 0);
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

    public ImageFileInfo sW(int i) {
        return (ImageFileInfo) com.baidu.tbadk.core.util.y.c(this.mList, i);
    }

    public boolean sX(int i) {
        if (this.gas.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.gas.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ImageFileInfo sW;
        View inflate = LayoutInflater.from(this.gaf.getPageContext().getContext()).inflate(t.h.album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(t.g.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setDefaultBgResource(t.d.black_alpha100);
        tbImageView.setBg(this.gat);
        ImageFileInfo imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.y.c(this.mList, 0);
        if (imageFileInfo != null && "-2".equals(imageFileInfo.getAlbumId())) {
            sW = sW(i + 1);
        } else {
            sW = sW(i);
        }
        this.gas.put(Integer.valueOf(i), false);
        if (sW != null) {
            sW.clearPageActions();
            sW.addPageAction(com.baidu.tbadk.img.effect.d.F(this.vi, this.mMaxHeight));
            tbImageView.setTag(sW.toCachedKey(false));
            if (this.arb.a(sW, false) != null) {
                tbImageView.invalidate();
                this.gas.put(Integer.valueOf(i), true);
            } else {
                this.arb.a(sW, new k(this, viewGroup, i), false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
