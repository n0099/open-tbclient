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
    private com.baidu.tbadk.img.b aqL;
    private Map<Integer, Boolean> gcB = new HashMap();
    private ColorDrawable gcC;
    private AlbumActivity gco;
    private List<ImageFileInfo> mList;
    private int mMaxHeight;
    private int vi;

    public j(AlbumActivity albumActivity, com.baidu.tbadk.img.b bVar) {
        this.gco = albumActivity;
        this.aqL = bVar;
        this.vi = com.baidu.adp.lib.util.k.K(this.gco.getPageContext().getContext());
        this.mMaxHeight = com.baidu.adp.lib.util.k.L(this.gco.getPageContext().getContext()) - ((int) this.gco.getResources().getDimension(r.e.ds166));
        this.gcC = new ColorDrawable(this.gco.getResources().getColor(r.d.black_alpha100));
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

    public ImageFileInfo tk(int i) {
        return (ImageFileInfo) com.baidu.tbadk.core.util.y.c(this.mList, i);
    }

    public boolean tl(int i) {
        if (this.gcB.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.gcB.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ImageFileInfo tk;
        View inflate = LayoutInflater.from(this.gco.getPageContext().getContext()).inflate(r.h.album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(r.g.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setDefaultBgResource(r.d.black_alpha100);
        tbImageView.setBg(this.gcC);
        ImageFileInfo imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.y.c(this.mList, 0);
        if (imageFileInfo != null && "-2".equals(imageFileInfo.getAlbumId())) {
            tk = tk(i + 1);
        } else {
            tk = tk(i);
        }
        this.gcB.put(Integer.valueOf(i), false);
        if (tk != null) {
            tk.clearPageActions();
            tk.addPageAction(com.baidu.tbadk.img.effect.d.F(this.vi, this.mMaxHeight));
            tbImageView.setTag(tk.toCachedKey(false));
            if (this.aqL.a(tk, false) != null) {
                tbImageView.invalidate();
                this.gcB.put(Integer.valueOf(i), true);
            } else {
                this.aqL.a(tk, new k(this, viewGroup, i), false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
