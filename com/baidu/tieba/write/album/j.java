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
    private com.baidu.tbadk.img.b ari;
    private Map<Integer, Boolean> fyF = new HashMap();
    private ColorDrawable fyG;
    private AlbumActivity fyo;
    private List<ImageFileInfo> mList;
    private int mMaxHeight;
    private int vj;

    public j(AlbumActivity albumActivity, com.baidu.tbadk.img.b bVar) {
        this.fyo = albumActivity;
        this.ari = bVar;
        this.vj = com.baidu.adp.lib.util.k.I(this.fyo.getPageContext().getContext());
        this.mMaxHeight = com.baidu.adp.lib.util.k.J(this.fyo.getPageContext().getContext()) - ((int) this.fyo.getResources().getDimension(r.e.ds166));
        this.fyG = new ColorDrawable(this.fyo.getResources().getColor(r.d.black_alpha100));
    }

    public void setData(List<ImageFileInfo> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.mList != null) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.x.c(this.mList, 0);
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

    public ImageFileInfo sf(int i) {
        return (ImageFileInfo) com.baidu.tbadk.core.util.x.c(this.mList, i);
    }

    public boolean sg(int i) {
        if (this.fyF.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.fyF.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ImageFileInfo sf;
        View inflate = LayoutInflater.from(this.fyo.getPageContext().getContext()).inflate(r.h.album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(r.g.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setDefaultBgResource(r.d.black_alpha100);
        tbImageView.setBg(this.fyG);
        ImageFileInfo imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.x.c(this.mList, 0);
        if (imageFileInfo != null && "-2".equals(imageFileInfo.getAlbumId())) {
            sf = sf(i + 1);
        } else {
            sf = sf(i);
        }
        this.fyF.put(Integer.valueOf(i), false);
        if (sf != null) {
            sf.clearPageActions();
            sf.addPageAction(com.baidu.tbadk.img.effect.d.F(this.vj, this.mMaxHeight));
            tbImageView.setTag(sf.toCachedKey(false));
            if (this.ari.a(sf, false) != null) {
                tbImageView.invalidate();
                this.fyF.put(Integer.valueOf(i), true);
            } else {
                this.ari.a(sf, new k(this, viewGroup, i), false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
