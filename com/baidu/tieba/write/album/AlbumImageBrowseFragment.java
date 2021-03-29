package com.baidu.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.i0.u3.l.c;
import d.b.i0.u3.l.e;
import java.util.List;
/* loaded from: classes5.dex */
public class AlbumImageBrowseFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f22236e;

    /* renamed from: f  reason: collision with root package name */
    public c f22237f;

    /* renamed from: g  reason: collision with root package name */
    public e f22238g;

    /* renamed from: h  reason: collision with root package name */
    public AlbumImagePagerAdapter f22239h;
    public View i;
    public ImageView j;
    public ImageView k;
    public View l;
    public TBSpecificationBtn m;
    public TextView n;
    public View o;
    public ViewPager p;
    public int q = -1;
    public View.OnClickListener r = new a();
    public ViewPager.OnPageChangeListener s = new b();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == AlbumImageBrowseFragment.this.l || view != AlbumImageBrowseFragment.this.k || AlbumImageBrowseFragment.this.f22239h == null || AlbumImageBrowseFragment.this.f22237f == null || AlbumImageBrowseFragment.this.f22236e == null) {
                return;
            }
            if (AlbumImageBrowseFragment.this.f22237f.p()) {
                AlbumImageBrowseFragment.this.f22236e.showToast(R.string.album_choose_switch_tip);
            } else if (AlbumImageBrowseFragment.this.f22239h.j(AlbumImageBrowseFragment.this.q)) {
                ImageFileInfo i = AlbumImageBrowseFragment.this.f22239h.i(AlbumImageBrowseFragment.this.q);
                if (d.b.i0.u3.s.b.a(i)) {
                    AlbumImageBrowseFragment.this.f22236e.showToast(R.string.album_choose_image_low_quality_tip);
                    return;
                }
                if (AlbumImageBrowseFragment.this.f22237f.n(i)) {
                    if (AlbumImageBrowseFragment.this.f22238g.i(i)) {
                        AlbumImageBrowseFragment albumImageBrowseFragment = AlbumImageBrowseFragment.this;
                        albumImageBrowseFragment.U0(albumImageBrowseFragment.k, false);
                        AlbumImageBrowseFragment.this.f22238g.K(i, false);
                    }
                } else if (AlbumImageBrowseFragment.this.f22238g.c(i)) {
                    AlbumImageBrowseFragment albumImageBrowseFragment2 = AlbumImageBrowseFragment.this;
                    albumImageBrowseFragment2.U0(albumImageBrowseFragment2.k, true);
                    AlbumImageBrowseFragment.this.f22238g.K(i, true);
                }
                AlbumImageBrowseFragment.this.P0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            AlbumImageBrowseFragment.this.q = i;
            if (AlbumImageBrowseFragment.this.f22239h == null || AlbumImageBrowseFragment.this.f22237f == null) {
                return;
            }
            ImageFileInfo i2 = AlbumImageBrowseFragment.this.f22239h.i(AlbumImageBrowseFragment.this.q);
            boolean z = true;
            if (AlbumImageBrowseFragment.this.f22237f.n(i2)) {
                AlbumImageBrowseFragment albumImageBrowseFragment = AlbumImageBrowseFragment.this;
                albumImageBrowseFragment.U0(albumImageBrowseFragment.k, true);
            } else {
                AlbumImageBrowseFragment albumImageBrowseFragment2 = AlbumImageBrowseFragment.this;
                albumImageBrowseFragment2.U0(albumImageBrowseFragment2.k, false);
            }
            if (AlbumImageBrowseFragment.this.f22237f != null && AlbumImageBrowseFragment.this.f22237f.m() != null) {
                z = AlbumImageBrowseFragment.this.f22237f.m().isEnableChooseOriginalImg();
            }
            if (!z) {
                AlbumImageBrowseFragment.this.n.setVisibility(8);
            } else if (i2 == null || !i2.isGif()) {
                AlbumImageBrowseFragment.this.n.setVisibility(0);
            } else {
                AlbumImageBrowseFragment.this.n.setVisibility(8);
            }
            AlbumImageBrowseFragment albumImageBrowseFragment3 = AlbumImageBrowseFragment.this;
            albumImageBrowseFragment3.W0(albumImageBrowseFragment3.f22237f.s());
        }
    }

    public final void P0() {
        this.f22238g.L();
    }

    public View Q0() {
        return this.j;
    }

    public View R0() {
        return this.m;
    }

    public View S0() {
        return this.n;
    }

    public final void T0() {
        List<ImageFileInfo> i;
        int j;
        e eVar;
        if (this.f22237f == null && (eVar = this.f22238g) != null) {
            this.f22237f = eVar.p();
        }
        c cVar = this.f22237f;
        if (cVar == null || (i = cVar.i()) == null || (j = this.f22237f.j()) < 0) {
            return;
        }
        this.q = j;
        AlbumImagePagerAdapter albumImagePagerAdapter = new AlbumImagePagerAdapter(this.f22236e);
        this.f22239h = albumImagePagerAdapter;
        this.p.setAdapter(albumImagePagerAdapter);
        int i2 = this.q;
        if (i2 == 0 && i != null) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(i, i2);
            boolean z = true;
            if (this.f22237f.n(imageFileInfo)) {
                U0(this.k, true);
            } else {
                U0(this.k, false);
            }
            c cVar2 = this.f22237f;
            if (cVar2 != null && cVar2.m() != null) {
                z = this.f22237f.m().isEnableChooseOriginalImg();
            }
            if (!z) {
                this.n.setVisibility(8);
            } else if (imageFileInfo.isGif()) {
                this.n.setVisibility(8);
            } else {
                this.n.setVisibility(0);
            }
        }
        this.f22239h.k(i);
        this.p.setCurrentItem(this.q, false);
        W0(this.f22237f.s());
    }

    public final void U0(ImageView imageView, boolean z) {
        if (imageView == null || this.f22236e == null) {
            return;
        }
        if (z) {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324_select, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        } else {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
        }
        if (this.m != null) {
            c cVar = this.f22237f;
            int count = cVar != null ? ListUtils.getCount(cVar.g()) : 0;
            c cVar2 = this.f22237f;
            this.m.setText(this.f22236e.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(cVar2 != null ? cVar2.l() : 1)}));
            this.m.setEnabled(count > 0);
        }
    }

    public void V0(ImageFileInfo imageFileInfo, boolean z) {
        AlbumImagePagerAdapter albumImagePagerAdapter;
        ImageFileInfo i;
        if (imageFileInfo == null || imageFileInfo.getFilePath() == null || (albumImagePagerAdapter = this.f22239h) == null || (i = albumImagePagerAdapter.i(this.q)) == null || i.getFilePath() == null || !i.getFilePath().equals(imageFileInfo.getFilePath())) {
            return;
        }
        U0(this.k, z);
    }

    public void W0(boolean z) {
        ImageFileInfo i;
        if (this.f22236e == null || this.n == null) {
            return;
        }
        AlbumImagePagerAdapter albumImagePagerAdapter = this.f22239h;
        long fileSize = (albumImagePagerAdapter == null || (i = albumImagePagerAdapter.i(this.q)) == null) ? 0L : FileHelper.getFileSize(i.getFilePath());
        String string = this.f22236e.getResources().getString(R.string.original_img);
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            if (fileSize > 0) {
                sb.append("(");
                sb.append(StringHelper.getFormatSize(fileSize));
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
            }
            String sb2 = sb.toString();
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0302);
            this.n.setText(sb2);
            this.n.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.icon_pure_image_ok_select16, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0106);
        this.n.setText(string);
        this.n.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.icon_pure_image_ok_selection16, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void X0(e eVar) {
        this.f22238g = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        d.b.h0.s0.a.a(getPageContext(), this.i);
        SkinManager.setNavbarIconSrc(this.j, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
        c cVar = this.f22237f;
        if (cVar != null) {
            W0(cVar.s());
        }
        AlbumImagePagerAdapter albumImagePagerAdapter = this.f22239h;
        if (albumImagePagerAdapter != null) {
            albumImagePagerAdapter.notifyDataSetChanged();
        }
        this.m.k();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        this.f22236e = baseFragmentActivity;
        if (this.f22238g == null) {
            if (baseFragmentActivity instanceof AlbumFloatActivity) {
                this.f22238g = ((AlbumFloatActivity) baseFragmentActivity).albumView;
            } else if (baseFragmentActivity instanceof AlbumActivity) {
                this.f22238g = ((AlbumActivity) baseFragmentActivity).albumView;
            }
        }
        e eVar = this.f22238g;
        if (eVar != null) {
            this.f22237f = eVar.p();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        this.f22236e = baseFragmentActivity;
        if (this.f22238g == null) {
            if (baseFragmentActivity instanceof AlbumFloatActivity) {
                this.f22238g = ((AlbumFloatActivity) baseFragmentActivity).albumView;
            } else if (baseFragmentActivity instanceof AlbumActivity) {
                this.f22238g = ((AlbumActivity) baseFragmentActivity).albumView;
            }
        }
        e eVar = this.f22238g;
        if (eVar != null) {
            this.f22237f = eVar.p();
        }
        View inflate = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.i = inflate;
        this.j = (ImageView) inflate.findViewById(R.id.img_back);
        this.k = (ImageView) this.i.findViewById(R.id.img_choose);
        this.p = (ViewPager) this.i.findViewById(R.id.viewPager);
        this.o = this.i.findViewById(R.id.album_no_data);
        this.n = (TextView) this.i.findViewById(R.id.original_select_btn);
        this.l = this.i.findViewById(R.id.layout_bottom);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.i.findViewById(R.id.next_step);
        this.m = tBSpecificationBtn;
        tBSpecificationBtn.setTextSize(R.dimen.tbds34);
        this.m.getStyleConfig().k(l.g(this.f22236e, R.dimen.tbds25));
        this.j.setOnClickListener(this.f22236e);
        this.m.setOnClickListener(this.f22236e);
        this.k.setOnClickListener(this.r);
        this.n.setOnClickListener(this.f22236e);
        this.l.setOnClickListener(this.r);
        this.p.setOnPageChangeListener(this.s);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        c cVar = this.f22237f;
        if (cVar != null && cVar.m() != null) {
            this.n.setVisibility(this.f22237f.m().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (getBaseFragmentActivity() instanceof AlbumFloatActivity) {
            this.i.setPadding(0, UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0, 0, 0);
        }
        return this.i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        AlbumImagePagerAdapter albumImagePagerAdapter;
        super.onHiddenChanged(z);
        if (!z || (albumImagePagerAdapter = this.f22239h) == null) {
            return;
        }
        albumImagePagerAdapter.k(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            w();
        }
    }

    public final void w() {
        if (isHidden()) {
            return;
        }
        this.o.setVisibility(8);
        this.p.setVisibility(0);
        T0();
    }
}
