package com.baidu.tieba.write.album;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class AlbumImagePagerAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public BaseFragmentActivity f21927a;

    /* renamed from: b  reason: collision with root package name */
    public LayoutInflater f21928b;

    /* renamed from: c  reason: collision with root package name */
    public List<ImageFileInfo> f21929c;

    /* renamed from: d  reason: collision with root package name */
    public Map<Integer, Boolean> f21930d = new HashMap();

    public AlbumImagePagerAdapter(BaseFragmentActivity baseFragmentActivity) {
        this.f21927a = baseFragmentActivity;
        this.f21928b = LayoutInflater.from(baseFragmentActivity.getPageContext().getPageActivity());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.f21929c);
    }

    public ImageFileInfo i(int i) {
        return (ImageFileInfo) ListUtils.getItem(this.f21929c, i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate = this.f21928b.inflate(R.layout.album_big_image_item, (ViewGroup) null);
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
        ImageFileInfo i2 = i(i);
        if (i2 != null) {
            tbImageView2.X(i2.getFilePath(), 35, false, true);
            tbImageView.W(i2.getFilePath(), 36, false);
            this.f21930d.put(Integer.valueOf(i), Boolean.TRUE);
        }
        viewGroup.addView(inflate, 0);
        SkinManager.setBackgroundColor(inflate, R.color.CAM_X0201);
        return inflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public boolean j(int i) {
        if (this.f21930d.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.f21930d.get(Integer.valueOf(i)).booleanValue();
    }

    public void k(List<ImageFileInfo> list) {
        this.f21929c = list;
        notifyDataSetChanged();
    }
}
