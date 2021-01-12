package com.baidu.tieba.write.album;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class AlbumImagePagerAdapter extends PagerAdapter {
    private Map<Integer, Boolean> bHS = new HashMap();
    private BaseFragmentActivity iEK;
    private LayoutInflater mLayoutInflater;
    private List<ImageFileInfo> mList;

    public AlbumImagePagerAdapter(BaseFragmentActivity baseFragmentActivity) {
        this.iEK = baseFragmentActivity;
        this.mLayoutInflater = LayoutInflater.from(this.iEK.getPageContext().getPageActivity());
    }

    public void setData(List<ImageFileInfo> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return x.getCount(this.mList);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public ImageFileInfo EP(int i) {
        return (ImageFileInfo) x.getItem(this.mList, i);
    }

    public boolean eN(int i) {
        if (this.bHS.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.bHS.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate = this.mLayoutInflater.inflate(R.layout.album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultBgResource(0);
        tbImageView.setDefaultResource(0);
        tbImageView.setGifIconSupport(false);
        tbImageView.setLongIconSupport(false);
        TbImageView tbImageView2 = (TbImageView) inflate.findViewById(R.id.thumbnail_iamge);
        tbImageView2.setTag(null);
        tbImageView2.setDefaultBgResource(0);
        tbImageView2.setDefaultResource(0);
        tbImageView2.setGifIconSupport(false);
        tbImageView2.setLongIconSupport(false);
        ImageFileInfo EP = EP(i);
        if (EP != null) {
            tbImageView2.startLoad(EP.getFilePath(), 35, false, true);
            tbImageView.startLoad(EP.getFilePath(), 36, false);
            this.bHS.put(Integer.valueOf(i), true);
        }
        viewGroup.addView(inflate, 0);
        ao.setBackgroundColor(inflate, R.color.CAM_X0201);
        return inflate;
    }
}
