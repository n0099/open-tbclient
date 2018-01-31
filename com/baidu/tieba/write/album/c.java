package com.baidu.tieba.write.album;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class c extends PagerAdapter {
    private AlbumActivity hDn;
    private Map<Integer, Boolean> hDx = new HashMap();
    private LayoutInflater kh;
    private List<ImageFileInfo> mList;

    public c(AlbumActivity albumActivity) {
        this.hDn = albumActivity;
        this.kh = LayoutInflater.from(this.hDn.getPageContext().getPageActivity());
    }

    public void setData(List<ImageFileInfo> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return v.D(this.mList);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public ImageFileInfo sp(int i) {
        return (ImageFileInfo) v.f(this.mList, i);
    }

    public boolean xn(int i) {
        if (this.hDx.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.hDx.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate = this.kh.inflate(d.h.album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(d.g.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultBgResource(0);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setGifIconSupport(false);
        tbImageView.setLongIconSupport(false);
        TbImageView tbImageView2 = (TbImageView) inflate.findViewById(d.g.thumbnail_iamge);
        tbImageView2.setTag(null);
        tbImageView2.setDefaultBgResource(0);
        tbImageView2.setDefaultResource(0);
        tbImageView2.setDefaultErrorResource(0);
        tbImageView2.setGifIconSupport(false);
        tbImageView2.setLongIconSupport(false);
        ImageFileInfo sp = sp(i);
        if (sp != null) {
            tbImageView2.startLoad(sp.getFilePath(), 35, false, true);
            tbImageView.startLoad(sp.getFilePath(), 36, false);
            this.hDx.put(Integer.valueOf(i), true);
        }
        viewGroup.addView(inflate, 0);
        aj.t(inflate, d.C0108d.cp_bg_line_d);
        return inflate;
    }
}
