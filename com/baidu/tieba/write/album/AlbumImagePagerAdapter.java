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
    public BaseFragmentActivity f22607a;

    /* renamed from: b  reason: collision with root package name */
    public LayoutInflater f22608b;

    /* renamed from: c  reason: collision with root package name */
    public List<ImageFileInfo> f22609c;

    /* renamed from: d  reason: collision with root package name */
    public Map<Integer, Boolean> f22610d = new HashMap();

    public AlbumImagePagerAdapter(BaseFragmentActivity baseFragmentActivity) {
        this.f22607a = baseFragmentActivity;
        this.f22608b = LayoutInflater.from(baseFragmentActivity.getPageContext().getPageActivity());
    }

    public ImageFileInfo b(int i2) {
        return (ImageFileInfo) ListUtils.getItem(this.f22609c, i2);
    }

    public boolean c(int i2) {
        if (this.f22610d.get(Integer.valueOf(i2)) == null) {
            return false;
        }
        return this.f22610d.get(Integer.valueOf(i2)).booleanValue();
    }

    public void d(List<ImageFileInfo> list) {
        this.f22609c = list;
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.f22609c);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        View inflate = this.f22608b.inflate(R.layout.album_big_image_item, (ViewGroup) null);
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
        ImageFileInfo b2 = b(i2);
        if (b2 != null) {
            tbImageView2.W(b2.getFilePath(), 35, false, true);
            tbImageView.V(b2.getFilePath(), 36, false);
            this.f22610d.put(Integer.valueOf(i2), Boolean.TRUE);
        }
        viewGroup.addView(inflate, 0);
        SkinManager.setBackgroundColor(inflate, R.color.CAM_X0201);
        return inflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
