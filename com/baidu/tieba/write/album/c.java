package com.baidu.tieba.write.album;

import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class c extends PagerAdapter {
    private int Bp;
    private com.baidu.tbadk.img.b axw;
    private AlbumActivity gGN;
    private Map<Integer, Boolean> gGZ = new HashMap();
    private ColorDrawable gHa;
    private List<ImageFileInfo> mList;
    private int mMaxHeight;

    public c(AlbumActivity albumActivity, com.baidu.tbadk.img.b bVar) {
        this.gGN = albumActivity;
        this.axw = bVar;
        this.Bp = com.baidu.adp.lib.util.l.ad(this.gGN.getPageContext().getContext());
        this.mMaxHeight = com.baidu.adp.lib.util.l.af(this.gGN.getPageContext().getContext()) - ((int) this.gGN.getResources().getDimension(d.f.ds166));
        this.gHa = new ColorDrawable(this.gGN.getResources().getColor(d.e.black_alpha100));
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

    public ImageFileInfo oP(int i) {
        return (ImageFileInfo) v.c(this.mList, i);
    }

    public boolean uP(int i) {
        if (this.gGZ.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.gGZ.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(final ViewGroup viewGroup, final int i) {
        View inflate = LayoutInflater.from(this.gGN.getPageContext().getContext()).inflate(d.j.album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(d.h.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setDefaultBgResource(d.e.black_alpha100);
        tbImageView.setBg(this.gHa);
        ImageFileInfo oP = oP(i);
        this.gGZ.put(Integer.valueOf(i), false);
        if (oP != null) {
            oP.clearPageActions();
            oP.addPageAction(com.baidu.tbadk.img.effect.d.K(this.Bp, this.mMaxHeight));
            tbImageView.setTag(oP.toCachedKey(false));
            if (this.axw.a(oP, false) != null) {
                tbImageView.invalidate();
                this.gGZ.put(Integer.valueOf(i), true);
            } else {
                this.axw.a(oP, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.album.c.1
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        TbImageView tbImageView2 = (TbImageView) viewGroup.findViewWithTag(str);
                        if (tbImageView2 != null && aVar != null) {
                            tbImageView2.invalidate();
                            c.this.gGZ.put(Integer.valueOf(i), true);
                        }
                    }
                }, false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
