package com.baidu.tieba.write.album;

import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class j extends PagerAdapter {
    private com.baidu.tbadk.img.b anU;
    private AlbumActivity fQb;
    private Map<Integer, Boolean> fQn = new HashMap();
    private ColorDrawable fQo;
    private List<ImageFileInfo> mList;
    private int mMaxHeight;
    private int sS;

    public j(AlbumActivity albumActivity, com.baidu.tbadk.img.b bVar) {
        this.fQb = albumActivity;
        this.anU = bVar;
        this.sS = com.baidu.adp.lib.util.k.A(this.fQb.getPageContext().getContext());
        this.mMaxHeight = com.baidu.adp.lib.util.k.B(this.fQb.getPageContext().getContext()) - ((int) this.fQb.getResources().getDimension(u.e.ds166));
        this.fQo = new ColorDrawable(this.fQb.getResources().getColor(u.d.black_alpha100));
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

    public ImageFileInfo sv(int i) {
        return (ImageFileInfo) com.baidu.tbadk.core.util.y.c(this.mList, i);
    }

    public boolean sw(int i) {
        if (this.fQn.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.fQn.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ImageFileInfo sv;
        View inflate = LayoutInflater.from(this.fQb.getPageContext().getContext()).inflate(u.h.album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(u.g.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setDefaultBgResource(u.d.black_alpha100);
        tbImageView.setBg(this.fQo);
        ImageFileInfo imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.y.c(this.mList, 0);
        if (imageFileInfo != null && "-2".equals(imageFileInfo.getAlbumId())) {
            sv = sv(i + 1);
        } else {
            sv = sv(i);
        }
        this.fQn.put(Integer.valueOf(i), false);
        if (sv != null) {
            sv.clearPageActions();
            sv.addPageAction(com.baidu.tbadk.img.effect.d.D(this.sS, this.mMaxHeight));
            tbImageView.setTag(sv.toCachedKey(false));
            if (this.anU.a(sv, false) != null) {
                tbImageView.invalidate();
                this.fQn.put(Integer.valueOf(i), true);
            } else {
                this.anU.a(sv, new k(this, viewGroup, i), false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
