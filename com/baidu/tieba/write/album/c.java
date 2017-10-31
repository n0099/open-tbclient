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
    private com.baidu.tbadk.img.b axU;
    private Map<Integer, Boolean> gQH = new HashMap();
    private ColorDrawable gQI;
    private AlbumActivity gQv;
    private List<ImageFileInfo> mList;
    private int mMaxHeight;
    private int mMaxWidth;

    public c(AlbumActivity albumActivity, com.baidu.tbadk.img.b bVar) {
        this.gQv = albumActivity;
        this.axU = bVar;
        this.mMaxWidth = com.baidu.adp.lib.util.l.ac(this.gQv.getPageContext().getContext());
        this.mMaxHeight = com.baidu.adp.lib.util.l.ae(this.gQv.getPageContext().getContext()) - ((int) this.gQv.getResources().getDimension(d.e.ds166));
        this.gQI = new ColorDrawable(this.gQv.getResources().getColor(d.C0080d.black_alpha100));
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

    public ImageFileInfo pi(int i) {
        return (ImageFileInfo) v.c(this.mList, i);
    }

    public boolean vi(int i) {
        if (this.gQH.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.gQH.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(final ViewGroup viewGroup, final int i) {
        View inflate = LayoutInflater.from(this.gQv.getPageContext().getContext()).inflate(d.h.album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(d.g.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setDefaultBgResource(d.C0080d.black_alpha100);
        tbImageView.setBg(this.gQI);
        ImageFileInfo pi = pi(i);
        this.gQH.put(Integer.valueOf(i), false);
        if (pi != null) {
            pi.clearPageActions();
            pi.addPageAction(com.baidu.tbadk.img.effect.d.K(this.mMaxWidth, this.mMaxHeight));
            tbImageView.setTag(pi.toCachedKey(false));
            if (this.axU.a(pi, false) != null) {
                tbImageView.invalidate();
                this.gQH.put(Integer.valueOf(i), true);
            } else {
                this.axU.a(pi, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.album.c.1
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                        TbImageView tbImageView2 = (TbImageView) viewGroup.findViewWithTag(str);
                        if (tbImageView2 != null && aVar != null) {
                            tbImageView2.invalidate();
                            c.this.gQH.put(Integer.valueOf(i), true);
                        }
                    }
                }, false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
