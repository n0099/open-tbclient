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
    private com.baidu.tbadk.img.b amz;
    private AlbumActivity eXM;
    private Map<Integer, Boolean> eXY = new HashMap();
    private List<ImageFileInfo> mList;
    private int mMaxHeight;
    private int so;

    public j(AlbumActivity albumActivity, com.baidu.tbadk.img.b bVar) {
        this.eXM = albumActivity;
        this.amz = bVar;
        this.so = com.baidu.adp.lib.util.k.B(this.eXM.getPageContext().getContext());
        this.mMaxHeight = com.baidu.adp.lib.util.k.C(this.eXM.getPageContext().getContext()) - ((int) this.eXM.getResources().getDimension(t.e.album_bottom_height));
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

    public ImageFileInfo qL(int i) {
        return (ImageFileInfo) com.baidu.tbadk.core.util.y.c(this.mList, i);
    }

    public boolean qM(int i) {
        if (this.eXY.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.eXY.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ImageFileInfo qL;
        View inflate = LayoutInflater.from(this.eXM.getPageContext().getContext()).inflate(t.h.album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(t.g.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setDefaultBgResource(0);
        ImageFileInfo imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.y.c(this.mList, 0);
        if (imageFileInfo != null && "-2".equals(imageFileInfo.getAlbumId())) {
            qL = qL(i + 1);
        } else {
            qL = qL(i);
        }
        this.eXY.put(Integer.valueOf(i), false);
        if (qL != null) {
            qL.clearPageActions();
            qL.addPageAction(com.baidu.tbadk.img.effect.d.D(this.so, this.mMaxHeight));
            tbImageView.setTag(qL.toCachedKey(false));
            if (this.amz.a(qL, false) != null) {
                tbImageView.invalidate();
                this.eXY.put(Integer.valueOf(i), true);
            } else {
                this.amz.a(qL, new k(this, viewGroup, i), false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
