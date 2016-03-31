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
    private int Ca;
    private com.baidu.tbadk.img.b aqL;
    private AlbumActivity eGS;
    private Map<Integer, Boolean> eHe = new HashMap();
    private List<ImageFileInfo> mList;
    private int mMaxHeight;

    public j(AlbumActivity albumActivity, com.baidu.tbadk.img.b bVar) {
        this.eGS = albumActivity;
        this.aqL = bVar;
        this.Ca = com.baidu.adp.lib.util.k.B(this.eGS.getPageContext().getContext());
        this.mMaxHeight = com.baidu.adp.lib.util.k.C(this.eGS.getPageContext().getContext()) - ((int) this.eGS.getResources().getDimension(t.e.album_bottom_height));
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

    public ImageFileInfo qo(int i) {
        return (ImageFileInfo) com.baidu.tbadk.core.util.y.b(this.mList, i);
    }

    public boolean qp(int i) {
        if (this.eHe.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.eHe.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ImageFileInfo qo;
        View inflate = LayoutInflater.from(this.eGS.getPageContext().getContext()).inflate(t.h.album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(t.g.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setDefaultBgResource(0);
        ImageFileInfo imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.y.b(this.mList, 0);
        if (imageFileInfo != null && "-2".equals(imageFileInfo.getAlbumId())) {
            qo = qo(i + 1);
        } else {
            qo = qo(i);
        }
        this.eHe.put(Integer.valueOf(i), false);
        if (qo != null) {
            qo.clearPageActions();
            qo.addPageAction(com.baidu.tbadk.img.effect.d.D(this.Ca, this.mMaxHeight));
            tbImageView.setTag(qo.toCachedKey(false));
            if (this.aqL.a(qo, false) != null) {
                tbImageView.invalidate();
                this.eHe.put(Integer.valueOf(i), true);
            } else {
                this.aqL.a(qo, new k(this, viewGroup, i), false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
