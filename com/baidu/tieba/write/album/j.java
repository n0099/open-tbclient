package com.baidu.tieba.write.album;

import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class j extends PagerAdapter {
    private int BP;
    private com.baidu.tbadk.img.b avZ;
    private AlbumActivity fMV;
    private Map<Integer, Boolean> fNm = new HashMap();
    private ColorDrawable fNn;
    private List<ImageFileInfo> mList;
    private int mMaxHeight;

    public j(AlbumActivity albumActivity, com.baidu.tbadk.img.b bVar) {
        this.fMV = albumActivity;
        this.avZ = bVar;
        this.BP = com.baidu.adp.lib.util.k.af(this.fMV.getPageContext().getContext());
        this.mMaxHeight = com.baidu.adp.lib.util.k.ag(this.fMV.getPageContext().getContext()) - ((int) this.fMV.getResources().getDimension(w.f.ds166));
        this.fNn = new ColorDrawable(this.fMV.getResources().getColor(w.e.black_alpha100));
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

    public ImageFileInfo sN(int i) {
        return (ImageFileInfo) com.baidu.tbadk.core.util.x.c(this.mList, i);
    }

    public boolean sO(int i) {
        if (this.fNm.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.fNm.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ImageFileInfo sN;
        View inflate = LayoutInflater.from(this.fMV.getPageContext().getContext()).inflate(w.j.album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(w.h.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setDefaultBgResource(w.e.black_alpha100);
        tbImageView.setBg(this.fNn);
        ImageFileInfo imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.x.c(this.mList, 0);
        if (imageFileInfo != null && "-2".equals(imageFileInfo.getAlbumId())) {
            sN = sN(i + 1);
        } else {
            sN = sN(i);
        }
        this.fNm.put(Integer.valueOf(i), false);
        if (sN != null) {
            sN.clearPageActions();
            sN.addPageAction(com.baidu.tbadk.img.effect.d.M(this.BP, this.mMaxHeight));
            tbImageView.setTag(sN.toCachedKey(false));
            if (this.avZ.a(sN, false) != null) {
                tbImageView.invalidate();
                this.fNm.put(Integer.valueOf(i), true);
            } else {
                this.avZ.a(sN, new k(this, viewGroup, i), false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
