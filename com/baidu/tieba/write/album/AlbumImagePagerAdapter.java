package com.baidu.tieba.write.album;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class AlbumImagePagerAdapter extends PagerAdapter {
    private Map<Integer, Boolean> hoG = new HashMap();
    private AlbumActivity how;
    private LayoutInflater mLayoutInflater;
    private List<ImageFileInfo> mList;

    public AlbumImagePagerAdapter(AlbumActivity albumActivity) {
        this.how = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.how.getPageContext().getPageActivity());
    }

    public void setData(List<ImageFileInfo> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return w.y(this.mList);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public ImageFileInfo pY(int i) {
        return (ImageFileInfo) w.c(this.mList, i);
    }

    public boolean vi(int i) {
        if (this.hoG.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.hoG.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate = this.mLayoutInflater.inflate(d.i.album_big_image_item, (ViewGroup) null);
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
        ImageFileInfo pY = pY(i);
        if (pY != null) {
            tbImageView2.startLoad(pY.getFilePath(), 35, false, true);
            tbImageView.startLoad(pY.getFilePath(), 36, false);
            this.hoG.put(Integer.valueOf(i), true);
        }
        viewGroup.addView(inflate, 0);
        al.j(inflate, d.C0141d.cp_bg_line_d);
        return inflate;
    }
}
