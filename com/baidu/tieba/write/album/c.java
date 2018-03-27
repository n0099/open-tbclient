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
    private AlbumActivity hEV;
    private Map<Integer, Boolean> hFf = new HashMap();
    private LayoutInflater kh;
    private List<ImageFileInfo> mList;

    public c(AlbumActivity albumActivity) {
        this.hEV = albumActivity;
        this.kh = LayoutInflater.from(this.hEV.getPageContext().getPageActivity());
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

    public ImageFileInfo st(int i) {
        return (ImageFileInfo) v.f(this.mList, i);
    }

    public boolean xn(int i) {
        if (this.hFf.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.hFf.get(Integer.valueOf(i)).booleanValue();
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
        ImageFileInfo st = st(i);
        if (st != null) {
            tbImageView2.startLoad(st.getFilePath(), 35, false, true);
            tbImageView.startLoad(st.getFilePath(), 36, false);
            this.hFf.put(Integer.valueOf(i), true);
        }
        viewGroup.addView(inflate, 0);
        aj.t(inflate, d.C0141d.cp_bg_line_d);
        return inflate;
    }
}
