package com.baidu.tieba.write.album;

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
    private com.baidu.tbadk.img.b anf;
    private AlbumActivity fCP;
    private Map<Integer, Boolean> fDb = new HashMap();
    private List<ImageFileInfo> mList;
    private int mMaxHeight;
    private int so;

    public j(AlbumActivity albumActivity, com.baidu.tbadk.img.b bVar) {
        this.fCP = albumActivity;
        this.anf = bVar;
        this.so = com.baidu.adp.lib.util.k.A(this.fCP.getPageContext().getContext());
        this.mMaxHeight = com.baidu.adp.lib.util.k.B(this.fCP.getPageContext().getContext()) - ((int) this.fCP.getResources().getDimension(u.e.ds166));
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

    public ImageFileInfo sb(int i) {
        return (ImageFileInfo) com.baidu.tbadk.core.util.y.c(this.mList, i);
    }

    public boolean sc(int i) {
        if (this.fDb.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.fDb.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ImageFileInfo sb;
        View inflate = LayoutInflater.from(this.fCP.getPageContext().getContext()).inflate(u.h.album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(u.g.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setDefaultBgResource(0);
        ImageFileInfo imageFileInfo = (ImageFileInfo) com.baidu.tbadk.core.util.y.c(this.mList, 0);
        if (imageFileInfo != null && "-2".equals(imageFileInfo.getAlbumId())) {
            sb = sb(i + 1);
        } else {
            sb = sb(i);
        }
        this.fDb.put(Integer.valueOf(i), false);
        if (sb != null) {
            sb.clearPageActions();
            sb.addPageAction(com.baidu.tbadk.img.effect.d.D(this.so, this.mMaxHeight));
            tbImageView.setTag(sb.toCachedKey(false));
            if (this.anf.a(sb, false) != null) {
                tbImageView.invalidate();
                this.fDb.put(Integer.valueOf(i), true);
            } else {
                this.anf.a(sb, new k(this, viewGroup, i), false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
