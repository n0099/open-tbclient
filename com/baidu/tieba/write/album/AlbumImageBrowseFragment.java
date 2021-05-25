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
import d.a.c.e.p.l;
import d.a.n0.w3.k.c;
import d.a.n0.w3.k.e;
import java.util.List;
/* loaded from: classes5.dex */
public class AlbumImageBrowseFragment extends BaseFragment {

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f21773e;

    /* renamed from: f  reason: collision with root package name */
    public c f21774f;

    /* renamed from: g  reason: collision with root package name */
    public e f21775g;

    /* renamed from: h  reason: collision with root package name */
    public AlbumImagePagerAdapter f21776h;

    /* renamed from: i  reason: collision with root package name */
    public View f21777i;
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
            if (view == AlbumImageBrowseFragment.this.l || view != AlbumImageBrowseFragment.this.k || AlbumImageBrowseFragment.this.f21776h == null || AlbumImageBrowseFragment.this.f21774f == null || AlbumImageBrowseFragment.this.f21773e == null) {
                return;
            }
            if (AlbumImageBrowseFragment.this.f21774f.p()) {
                AlbumImageBrowseFragment.this.f21773e.showToast(R.string.album_choose_switch_tip);
            } else if (AlbumImageBrowseFragment.this.f21776h.c(AlbumImageBrowseFragment.this.q)) {
                ImageFileInfo b2 = AlbumImageBrowseFragment.this.f21776h.b(AlbumImageBrowseFragment.this.q);
                if (d.a.n0.w3.r.b.a(b2)) {
                    AlbumImageBrowseFragment.this.f21773e.showToast(R.string.album_choose_image_low_quality_tip);
                    return;
                }
                if (AlbumImageBrowseFragment.this.f21774f.n(b2)) {
                    if (AlbumImageBrowseFragment.this.f21775g.h(b2)) {
                        AlbumImageBrowseFragment albumImageBrowseFragment = AlbumImageBrowseFragment.this;
                        albumImageBrowseFragment.T0(albumImageBrowseFragment.k, false);
                        AlbumImageBrowseFragment.this.f21775g.I(b2, false);
                    }
                } else if (AlbumImageBrowseFragment.this.f21775g.c(b2)) {
                    AlbumImageBrowseFragment albumImageBrowseFragment2 = AlbumImageBrowseFragment.this;
                    albumImageBrowseFragment2.T0(albumImageBrowseFragment2.k, true);
                    AlbumImageBrowseFragment.this.f21775g.I(b2, true);
                }
                AlbumImageBrowseFragment.this.O0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            AlbumImageBrowseFragment.this.q = i2;
            if (AlbumImageBrowseFragment.this.f21776h == null || AlbumImageBrowseFragment.this.f21774f == null) {
                return;
            }
            ImageFileInfo b2 = AlbumImageBrowseFragment.this.f21776h.b(AlbumImageBrowseFragment.this.q);
            boolean z = true;
            if (AlbumImageBrowseFragment.this.f21774f.n(b2)) {
                AlbumImageBrowseFragment albumImageBrowseFragment = AlbumImageBrowseFragment.this;
                albumImageBrowseFragment.T0(albumImageBrowseFragment.k, true);
            } else {
                AlbumImageBrowseFragment albumImageBrowseFragment2 = AlbumImageBrowseFragment.this;
                albumImageBrowseFragment2.T0(albumImageBrowseFragment2.k, false);
            }
            if (AlbumImageBrowseFragment.this.f21774f != null && AlbumImageBrowseFragment.this.f21774f.m() != null) {
                z = AlbumImageBrowseFragment.this.f21774f.m().isEnableChooseOriginalImg();
            }
            if (!z) {
                AlbumImageBrowseFragment.this.n.setVisibility(8);
            } else if (b2 == null || !b2.isGif()) {
                AlbumImageBrowseFragment.this.n.setVisibility(0);
            } else {
                AlbumImageBrowseFragment.this.n.setVisibility(8);
            }
            AlbumImageBrowseFragment albumImageBrowseFragment3 = AlbumImageBrowseFragment.this;
            albumImageBrowseFragment3.V0(albumImageBrowseFragment3.f21774f.s());
        }
    }

    public final void O0() {
        this.f21775g.J();
    }

    public View P0() {
        return this.j;
    }

    public View Q0() {
        return this.m;
    }

    public View R0() {
        return this.n;
    }

    public final void S0() {
        List<ImageFileInfo> i2;
        int j;
        e eVar;
        if (this.f21774f == null && (eVar = this.f21775g) != null) {
            this.f21774f = eVar.o();
        }
        c cVar = this.f21774f;
        if (cVar == null || (i2 = cVar.i()) == null || (j = this.f21774f.j()) < 0) {
            return;
        }
        this.q = j;
        AlbumImagePagerAdapter albumImagePagerAdapter = new AlbumImagePagerAdapter(this.f21773e);
        this.f21776h = albumImagePagerAdapter;
        this.p.setAdapter(albumImagePagerAdapter);
        int i3 = this.q;
        if (i3 == 0 && i2 != null) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(i2, i3);
            boolean z = true;
            if (this.f21774f.n(imageFileInfo)) {
                T0(this.k, true);
            } else {
                T0(this.k, false);
            }
            c cVar2 = this.f21774f;
            if (cVar2 != null && cVar2.m() != null) {
                z = this.f21774f.m().isEnableChooseOriginalImg();
            }
            if (!z) {
                this.n.setVisibility(8);
            } else if (imageFileInfo.isGif()) {
                this.n.setVisibility(8);
            } else {
                this.n.setVisibility(0);
            }
        }
        this.f21776h.d(i2);
        this.p.setCurrentItem(this.q, false);
        V0(this.f21774f.s());
    }

    public final void T0(ImageView imageView, boolean z) {
        if (imageView == null || this.f21773e == null) {
            return;
        }
        if (z) {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324_select, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        } else {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
        }
        if (this.m != null) {
            c cVar = this.f21774f;
            int count = cVar != null ? ListUtils.getCount(cVar.g()) : 0;
            c cVar2 = this.f21774f;
            this.m.setText(this.f21773e.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(cVar2 != null ? cVar2.l() : 1)}));
            this.m.setEnabled(count > 0);
        }
    }

    public void U0(ImageFileInfo imageFileInfo, boolean z) {
        AlbumImagePagerAdapter albumImagePagerAdapter;
        ImageFileInfo b2;
        if (imageFileInfo == null || imageFileInfo.getFilePath() == null || (albumImagePagerAdapter = this.f21776h) == null || (b2 = albumImagePagerAdapter.b(this.q)) == null || b2.getFilePath() == null || !b2.getFilePath().equals(imageFileInfo.getFilePath())) {
            return;
        }
        T0(this.k, z);
    }

    public void V0(boolean z) {
        ImageFileInfo b2;
        if (this.f21773e == null || this.n == null) {
            return;
        }
        AlbumImagePagerAdapter albumImagePagerAdapter = this.f21776h;
        long fileSize = (albumImagePagerAdapter == null || (b2 = albumImagePagerAdapter.b(this.q)) == null) ? 0L : FileHelper.getFileSize(b2.getFilePath());
        String string = this.f21773e.getResources().getString(R.string.original_img);
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

    public void W0(e eVar) {
        this.f21775g = eVar;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.m0.s0.a.a(getPageContext(), this.f21777i);
        SkinManager.setNavbarIconSrc(this.j, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i2);
        c cVar = this.f21774f;
        if (cVar != null) {
            V0(cVar.s());
        }
        AlbumImagePagerAdapter albumImagePagerAdapter = this.f21776h;
        if (albumImagePagerAdapter != null) {
            albumImagePagerAdapter.notifyDataSetChanged();
        }
        this.m.k();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        this.f21773e = baseFragmentActivity;
        if (this.f21775g == null) {
            if (baseFragmentActivity instanceof AlbumFloatActivity) {
                this.f21775g = ((AlbumFloatActivity) baseFragmentActivity).albumView;
            } else if (baseFragmentActivity instanceof AlbumActivity) {
                this.f21775g = ((AlbumActivity) baseFragmentActivity).albumView;
            }
        }
        e eVar = this.f21775g;
        if (eVar != null) {
            this.f21774f = eVar.o();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        this.f21773e = baseFragmentActivity;
        if (this.f21775g == null) {
            if (baseFragmentActivity instanceof AlbumFloatActivity) {
                this.f21775g = ((AlbumFloatActivity) baseFragmentActivity).albumView;
            } else if (baseFragmentActivity instanceof AlbumActivity) {
                this.f21775g = ((AlbumActivity) baseFragmentActivity).albumView;
            }
        }
        e eVar = this.f21775g;
        if (eVar != null) {
            this.f21774f = eVar.o();
        }
        View inflate = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
        this.f21777i = inflate;
        this.j = (ImageView) inflate.findViewById(R.id.img_back);
        this.k = (ImageView) this.f21777i.findViewById(R.id.img_choose);
        this.p = (ViewPager) this.f21777i.findViewById(R.id.viewPager);
        this.o = this.f21777i.findViewById(R.id.album_no_data);
        this.n = (TextView) this.f21777i.findViewById(R.id.original_select_btn);
        this.l = this.f21777i.findViewById(R.id.layout_bottom);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f21777i.findViewById(R.id.next_step);
        this.m = tBSpecificationBtn;
        tBSpecificationBtn.setTextSize(R.dimen.tbds34);
        this.m.getStyleConfig().k(l.g(this.f21773e, R.dimen.tbds25));
        this.j.setOnClickListener(this.f21773e);
        this.m.setOnClickListener(this.f21773e);
        this.k.setOnClickListener(this.r);
        this.n.setOnClickListener(this.f21773e);
        this.l.setOnClickListener(this.r);
        this.p.setOnPageChangeListener(this.s);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        c cVar = this.f21774f;
        if (cVar != null && cVar.m() != null) {
            this.n.setVisibility(this.f21774f.m().isEnableChooseOriginalImg() ? 0 : 4);
        }
        if (getBaseFragmentActivity() instanceof AlbumFloatActivity) {
            this.f21777i.setPadding(0, UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0, 0, 0);
        }
        return this.f21777i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        AlbumImagePagerAdapter albumImagePagerAdapter;
        super.onHiddenChanged(z);
        if (!z || (albumImagePagerAdapter = this.f21776h) == null) {
            return;
        }
        albumImagePagerAdapter.d(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (isShow()) {
            p();
        }
    }

    public final void p() {
        if (isHidden()) {
            return;
        }
        this.o.setVisibility(8);
        this.p.setVisibility(0);
        S0();
    }
}
