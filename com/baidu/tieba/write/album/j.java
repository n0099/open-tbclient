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
    private int Bv;
    private com.baidu.tbadk.img.b anY;
    private AlbumActivity dKK;
    private Map<Integer, Boolean> dLa = new HashMap();
    private List<ImageFileInfo> mList;
    private int mMaxHeight;

    public j(AlbumActivity albumActivity, com.baidu.tbadk.img.b bVar) {
        this.dKK = albumActivity;
        this.anY = bVar;
        this.Bv = com.baidu.adp.lib.util.k.K(this.dKK.getPageContext().getContext());
        this.mMaxHeight = com.baidu.adp.lib.util.k.L(this.dKK.getPageContext().getContext()) - ((int) this.dKK.getResources().getDimension(n.d.album_bottom_height));
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

    public ImageFileInfo ni(int i) {
        return (ImageFileInfo) com.baidu.tbadk.core.util.y.b(this.mList, i);
    }

    public boolean nj(int i) {
        if (this.dLa.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.dLa.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ImageFileInfo ni;
        View inflate = LayoutInflater.from(this.dKK.getPageContext().getContext()).inflate(n.g.album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(n.f.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultBgResource(0);
        ImageFileInfo imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.y.b(this.mList, 0);
        if (imageFileInfo != null && "-2".equals(imageFileInfo.getAlbumId())) {
            ni = ni(i + 1);
        } else {
            ni = ni(i);
        }
        this.dLa.put(Integer.valueOf(i), false);
        if (ni != null) {
            ni.clearPageActions();
            ni.addPageAction(com.baidu.tbadk.img.effect.d.K(this.Bv, this.mMaxHeight));
            tbImageView.setTag(ni.toCachedKey(false));
            if (this.anY.a(ni, false) != null) {
                tbImageView.invalidate();
                this.dLa.put(Integer.valueOf(i), true);
            } else {
                this.anY.a(ni, new k(this, viewGroup, i), false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
