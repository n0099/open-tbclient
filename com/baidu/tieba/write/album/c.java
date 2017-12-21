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
    private Map<Integer, Boolean> hfA = new HashMap();
    private AlbumActivity hfp;
    private LayoutInflater hfz;
    private List<ImageFileInfo> mList;

    public c(AlbumActivity albumActivity) {
        this.hfp = albumActivity;
        this.hfz = LayoutInflater.from(this.hfp.getPageContext().getPageActivity());
    }

    public void setData(List<ImageFileInfo> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return v.v(this.mList);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public ImageFileInfo pC(int i) {
        return (ImageFileInfo) v.c(this.mList, i);
    }

    public boolean vT(int i) {
        if (this.hfA.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.hfA.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate = this.hfz.inflate(d.h.album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(d.g.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultBgResource(0);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setGifIconSupport(false);
        tbImageView.setLongIconSupport(false);
        ImageFileInfo pC = pC(i);
        if (pC != null) {
            tbImageView.startLoad(pC.getFilePath(), 36, false);
            this.hfA.put(Integer.valueOf(i), true);
        }
        viewGroup.addView(inflate, 0);
        aj.k(inflate, d.C0095d.cp_bg_line_d);
        return inflate;
    }
}
