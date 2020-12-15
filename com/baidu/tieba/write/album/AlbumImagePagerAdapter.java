package com.baidu.tieba.write.album;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class AlbumImagePagerAdapter extends PagerAdapter {
    private Map<Integer, Boolean> bHQ = new HashMap();
    private BaseFragmentActivity ixe;
    private LayoutInflater mLayoutInflater;
    private List<ImageFileInfo> mList;

    public AlbumImagePagerAdapter(BaseFragmentActivity baseFragmentActivity) {
        this.ixe = baseFragmentActivity;
        this.mLayoutInflater = LayoutInflater.from(this.ixe.getPageContext().getPageActivity());
    }

    public void setData(List<ImageFileInfo> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return y.getCount(this.mList);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public ImageFileInfo GD(int i) {
        return (ImageFileInfo) y.getItem(this.mList, i);
    }

    public boolean gt(int i) {
        if (this.bHQ.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.bHQ.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate = this.mLayoutInflater.inflate(R.layout.album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultBgResource(0);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultErrorResource(0);
        tbImageView.setGifIconSupport(false);
        tbImageView.setLongIconSupport(false);
        TbImageView tbImageView2 = (TbImageView) inflate.findViewById(R.id.thumbnail_iamge);
        tbImageView2.setTag(null);
        tbImageView2.setDefaultBgResource(0);
        tbImageView2.setDefaultResource(0);
        tbImageView2.setDefaultErrorResource(0);
        tbImageView2.setGifIconSupport(false);
        tbImageView2.setLongIconSupport(false);
        ImageFileInfo GD = GD(i);
        if (GD != null) {
            tbImageView2.startLoad(GD.getFilePath(), 35, false, true);
            tbImageView.startLoad(GD.getFilePath(), 36, false);
            this.bHQ.put(Integer.valueOf(i), true);
        }
        viewGroup.addView(inflate, 0);
        ap.setBackgroundColor(inflate, R.color.CAM_X0201);
        return inflate;
    }
}
