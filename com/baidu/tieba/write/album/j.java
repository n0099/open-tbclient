package com.baidu.tieba.write.album;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class j extends PagerAdapter {
    private int Bx;
    private com.baidu.tbadk.img.b apC;
    private AlbumActivity dSj;
    private Map<Integer, Boolean> dSz = new HashMap();
    private List<ImageFileInfo> mList;
    private int mMaxHeight;

    public j(AlbumActivity albumActivity, com.baidu.tbadk.img.b bVar) {
        this.dSj = albumActivity;
        this.apC = bVar;
        this.Bx = com.baidu.adp.lib.util.k.K(this.dSj.getPageContext().getContext());
        this.mMaxHeight = com.baidu.adp.lib.util.k.L(this.dSj.getPageContext().getContext()) - ((int) this.dSj.getResources().getDimension(n.e.album_bottom_height));
    }

    public void setData(List<ImageFileInfo> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.mList != null) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.y.b(this.mList, 0);
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

    public ImageFileInfo oa(int i) {
        return (ImageFileInfo) com.baidu.tbadk.core.util.y.b(this.mList, i);
    }

    public boolean ob(int i) {
        if (this.dSz.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.dSz.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ImageFileInfo oa;
        View inflate = LayoutInflater.from(this.dSj.getPageContext().getContext()).inflate(n.h.album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(n.g.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultBgResource(0);
        ImageFileInfo imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.y.b(this.mList, 0);
        if (imageFileInfo != null && "-2".equals(imageFileInfo.getAlbumId())) {
            oa = oa(i + 1);
        } else {
            oa = oa(i);
        }
        this.dSz.put(Integer.valueOf(i), false);
        if (oa != null) {
            oa.clearPageActions();
            oa.addPageAction(com.baidu.tbadk.img.effect.d.K(this.Bx, this.mMaxHeight));
            tbImageView.setTag(oa.toCachedKey(false));
            if (this.apC.a(oa, false) != null) {
                tbImageView.invalidate();
                this.dSz.put(Integer.valueOf(i), true);
            } else {
                this.apC.a(oa, new k(this, viewGroup, i), false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
