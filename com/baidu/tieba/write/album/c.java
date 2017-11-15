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
    private com.baidu.tbadk.img.b ayc;
    private AlbumActivity gRD;
    private Map<Integer, Boolean> gRP = new HashMap();
    private ColorDrawable gRQ;
    private List<ImageFileInfo> mList;
    private int mMaxHeight;
    private int mMaxWidth;

    public c(AlbumActivity albumActivity, com.baidu.tbadk.img.b bVar) {
        this.gRD = albumActivity;
        this.ayc = bVar;
        this.mMaxWidth = com.baidu.adp.lib.util.l.ac(this.gRD.getPageContext().getContext());
        this.mMaxHeight = com.baidu.adp.lib.util.l.ae(this.gRD.getPageContext().getContext()) - ((int) this.gRD.getResources().getDimension(d.e.ds166));
        this.gRQ = new ColorDrawable(this.gRD.getResources().getColor(d.C0080d.black_alpha100));
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

    public ImageFileInfo pj(int i) {
        return (ImageFileInfo) v.c(this.mList, i);
    }

    public boolean vm(int i) {
        if (this.gRP.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.gRP.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(final ViewGroup viewGroup, final int i) {
        View inflate = LayoutInflater.from(this.gRD.getPageContext().getContext()).inflate(d.h.album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(d.g.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setDefaultBgResource(d.C0080d.black_alpha100);
        tbImageView.setBg(this.gRQ);
        ImageFileInfo pj = pj(i);
        this.gRP.put(Integer.valueOf(i), false);
        if (pj != null) {
            pj.clearPageActions();
            pj.addPageAction(com.baidu.tbadk.img.effect.d.K(this.mMaxWidth, this.mMaxHeight));
            tbImageView.setTag(pj.toCachedKey(false));
            if (this.ayc.a(pj, false) != null) {
                tbImageView.invalidate();
                this.gRP.put(Integer.valueOf(i), true);
            } else {
                this.ayc.a(pj, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.album.c.1
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                        TbImageView tbImageView2 = (TbImageView) viewGroup.findViewWithTag(str);
                        if (tbImageView2 != null && aVar != null) {
                            tbImageView2.invalidate();
                            c.this.gRP.put(Integer.valueOf(i), true);
                        }
                    }
                }, false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
