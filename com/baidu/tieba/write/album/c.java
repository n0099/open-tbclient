package com.baidu.tieba.write.album;

import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c extends PagerAdapter {
    private int BS;
    private com.baidu.tbadk.img.b axK;
    private AlbumActivity gyW;
    private Map<Integer, Boolean> gzh = new HashMap();
    private ColorDrawable gzi;
    private List<ImageFileInfo> mList;
    private int mMaxHeight;

    public c(AlbumActivity albumActivity, com.baidu.tbadk.img.b bVar) {
        this.gyW = albumActivity;
        this.axK = bVar;
        this.BS = com.baidu.adp.lib.util.k.af(this.gyW.getPageContext().getContext());
        this.mMaxHeight = com.baidu.adp.lib.util.k.ag(this.gyW.getPageContext().getContext()) - ((int) this.gyW.getResources().getDimension(d.f.ds166));
        this.gzi = new ColorDrawable(this.gyW.getResources().getColor(d.e.black_alpha100));
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

    public ImageFileInfo ot(int i) {
        return (ImageFileInfo) u.c(this.mList, i);
    }

    public boolean ug(int i) {
        if (this.gzh.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.gzh.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(final ViewGroup viewGroup, final int i) {
        View inflate = LayoutInflater.from(this.gyW.getPageContext().getContext()).inflate(d.j.album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(d.h.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setDefaultBgResource(d.e.black_alpha100);
        tbImageView.setBg(this.gzi);
        ImageFileInfo ot = ot(i);
        this.gzh.put(Integer.valueOf(i), false);
        if (ot != null) {
            ot.clearPageActions();
            ot.addPageAction(com.baidu.tbadk.img.effect.d.L(this.BS, this.mMaxHeight));
            tbImageView.setTag(ot.toCachedKey(false));
            if (this.axK.a(ot, false) != null) {
                tbImageView.invalidate();
                this.gzh.put(Integer.valueOf(i), true);
            } else {
                this.axK.a(ot, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.album.c.1
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                        TbImageView tbImageView2 = (TbImageView) viewGroup.findViewWithTag(str);
                        if (tbImageView2 != null && aVar != null) {
                            tbImageView2.invalidate();
                            c.this.gzh.put(Integer.valueOf(i), true);
                        }
                    }
                }, false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
