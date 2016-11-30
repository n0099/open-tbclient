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
    private com.baidu.tbadk.img.b arF;
    private AlbumActivity gjT;
    private Map<Integer, Boolean> gkg = new HashMap();
    private ColorDrawable gkh;
    private List<ImageFileInfo> mList;
    private int mMaxHeight;
    private int vj;

    public j(AlbumActivity albumActivity, com.baidu.tbadk.img.b bVar) {
        this.gjT = albumActivity;
        this.arF = bVar;
        this.vj = com.baidu.adp.lib.util.k.K(this.gjT.getPageContext().getContext());
        this.mMaxHeight = com.baidu.adp.lib.util.k.L(this.gjT.getPageContext().getContext()) - ((int) this.gjT.getResources().getDimension(r.e.ds166));
        this.gkh = new ColorDrawable(this.gjT.getResources().getColor(r.d.black_alpha100));
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

    public ImageFileInfo tG(int i) {
        return (ImageFileInfo) com.baidu.tbadk.core.util.x.c(this.mList, i);
    }

    public boolean tH(int i) {
        if (this.gkg.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.gkg.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ImageFileInfo tG;
        View inflate = LayoutInflater.from(this.gjT.getPageContext().getContext()).inflate(r.h.album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(r.g.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setDefaultBgResource(r.d.black_alpha100);
        tbImageView.setBg(this.gkh);
        ImageFileInfo imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.x.c(this.mList, 0);
        if (imageFileInfo != null && "-2".equals(imageFileInfo.getAlbumId())) {
            tG = tG(i + 1);
        } else {
            tG = tG(i);
        }
        this.gkg.put(Integer.valueOf(i), false);
        if (tG != null) {
            tG.clearPageActions();
            tG.addPageAction(com.baidu.tbadk.img.effect.d.F(this.vj, this.mMaxHeight));
            tbImageView.setTag(tG.toCachedKey(false));
            if (this.arF.a(tG, false) != null) {
                tbImageView.invalidate();
                this.gkg.put(Integer.valueOf(i), true);
            } else {
                this.arF.a(tG, new k(this, viewGroup, i), false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
