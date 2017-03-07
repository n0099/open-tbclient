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
    private int Co;
    private com.baidu.tbadk.img.b avJ;
    private Map<Integer, Boolean> fLD = new HashMap();
    private ColorDrawable fLE;
    private AlbumActivity fLm;
    private List<ImageFileInfo> mList;
    private int mMaxHeight;

    public j(AlbumActivity albumActivity, com.baidu.tbadk.img.b bVar) {
        this.fLm = albumActivity;
        this.avJ = bVar;
        this.Co = com.baidu.adp.lib.util.k.ag(this.fLm.getPageContext().getContext());
        this.mMaxHeight = com.baidu.adp.lib.util.k.ah(this.fLm.getPageContext().getContext()) - ((int) this.fLm.getResources().getDimension(w.f.ds166));
        this.fLE = new ColorDrawable(this.fLm.getResources().getColor(w.e.black_alpha100));
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

    public ImageFileInfo sP(int i) {
        return (ImageFileInfo) com.baidu.tbadk.core.util.x.c(this.mList, i);
    }

    public boolean sQ(int i) {
        if (this.fLD.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.fLD.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ImageFileInfo sP;
        View inflate = LayoutInflater.from(this.fLm.getPageContext().getContext()).inflate(w.j.album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(w.h.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setDefaultBgResource(w.e.black_alpha100);
        tbImageView.setBg(this.fLE);
        ImageFileInfo imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.x.c(this.mList, 0);
        if (imageFileInfo != null && "-2".equals(imageFileInfo.getAlbumId())) {
            sP = sP(i + 1);
        } else {
            sP = sP(i);
        }
        this.fLD.put(Integer.valueOf(i), false);
        if (sP != null) {
            sP.clearPageActions();
            sP.addPageAction(com.baidu.tbadk.img.effect.d.M(this.Co, this.mMaxHeight));
            tbImageView.setTag(sP.toCachedKey(false));
            if (this.avJ.a(sP, false) != null) {
                tbImageView.invalidate();
                this.fLD.put(Integer.valueOf(i), true);
            } else {
                this.avJ.a(sP, new k(this, viewGroup, i), false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
