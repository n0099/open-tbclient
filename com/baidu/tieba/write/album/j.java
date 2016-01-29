package com.baidu.tieba.write.album;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class j extends PagerAdapter {
    private int BF;
    private com.baidu.tbadk.img.b aqu;
    private AlbumActivity emU;
    private Map<Integer, Boolean> enh = new HashMap();
    private List<ImageFileInfo> mList;
    private int mMaxHeight;

    public j(AlbumActivity albumActivity, com.baidu.tbadk.img.b bVar) {
        this.emU = albumActivity;
        this.aqu = bVar;
        this.BF = com.baidu.adp.lib.util.k.K(this.emU.getPageContext().getContext());
        this.mMaxHeight = com.baidu.adp.lib.util.k.L(this.emU.getPageContext().getContext()) - ((int) this.emU.getResources().getDimension(t.e.album_bottom_height));
    }

    public void setData(List<ImageFileInfo> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.mList != null) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.x.b(this.mList, 0);
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

    public ImageFileInfo pv(int i) {
        return (ImageFileInfo) com.baidu.tbadk.core.util.x.b(this.mList, i);
    }

    public boolean pw(int i) {
        if (this.enh.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.enh.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ImageFileInfo pv;
        View inflate = LayoutInflater.from(this.emU.getPageContext().getContext()).inflate(t.h.album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(t.g.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultBgResource(0);
        ImageFileInfo imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.x.b(this.mList, 0);
        if (imageFileInfo != null && "-2".equals(imageFileInfo.getAlbumId())) {
            pv = pv(i + 1);
        } else {
            pv = pv(i);
        }
        this.enh.put(Integer.valueOf(i), false);
        if (pv != null) {
            pv.clearPageActions();
            pv.addPageAction(com.baidu.tbadk.img.effect.d.G(this.BF, this.mMaxHeight));
            tbImageView.setTag(pv.toCachedKey(false));
            if (this.aqu.a(pv, false) != null) {
                tbImageView.invalidate();
                this.enh.put(Integer.valueOf(i), true);
            } else {
                this.aqu.a(pv, new k(this, viewGroup, i), false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
