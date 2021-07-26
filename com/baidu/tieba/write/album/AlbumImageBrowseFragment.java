package com.baidu.tieba.write.album;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.q0.a4.k.c;
import d.a.q0.a4.k.e;
import java.util.List;
/* loaded from: classes4.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f22697e;

    /* renamed from: f  reason: collision with root package name */
    public c f22698f;

    /* renamed from: g  reason: collision with root package name */
    public e f22699g;

    /* renamed from: h  reason: collision with root package name */
    public AlbumImagePagerAdapter f22700h;

    /* renamed from: i  reason: collision with root package name */
    public View f22701i;
    public ImageView j;
    public ImageView k;
    public View l;
    public TBSpecificationBtn m;
    public TextView n;
    public View o;
    public ViewPager p;
    public int q;
    public View.OnClickListener r;
    public ViewPager.OnPageChangeListener s;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlbumImageBrowseFragment f22702e;

        public a(AlbumImageBrowseFragment albumImageBrowseFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {albumImageBrowseFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22702e = albumImageBrowseFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == this.f22702e.l || view != this.f22702e.k || this.f22702e.f22700h == null || this.f22702e.f22698f == null || this.f22702e.f22697e == null) {
                return;
            }
            if (this.f22702e.f22698f.p()) {
                this.f22702e.f22697e.showToast(R.string.album_choose_switch_tip);
            } else if (this.f22702e.f22700h.c(this.f22702e.q)) {
                ImageFileInfo b2 = this.f22702e.f22700h.b(this.f22702e.q);
                if (d.a.q0.a4.r.a.a(b2)) {
                    this.f22702e.f22697e.showToast(R.string.album_choose_image_low_quality_tip);
                    return;
                }
                if (this.f22702e.f22698f.n(b2)) {
                    if (this.f22702e.f22699g.j(b2)) {
                        AlbumImageBrowseFragment albumImageBrowseFragment = this.f22702e;
                        albumImageBrowseFragment.c1(albumImageBrowseFragment.k, false);
                        this.f22702e.f22699g.N(b2, false);
                    }
                } else if (this.f22702e.f22699g.c(b2)) {
                    AlbumImageBrowseFragment albumImageBrowseFragment2 = this.f22702e;
                    albumImageBrowseFragment2.c1(albumImageBrowseFragment2.k, true);
                    this.f22702e.f22699g.N(b2, true);
                }
                this.f22702e.X0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlbumImageBrowseFragment f22703e;

        public b(AlbumImageBrowseFragment albumImageBrowseFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {albumImageBrowseFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22703e = albumImageBrowseFragment;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.f22703e.q = i2;
                if (this.f22703e.f22700h == null || this.f22703e.f22698f == null) {
                    return;
                }
                ImageFileInfo b2 = this.f22703e.f22700h.b(this.f22703e.q);
                boolean z = true;
                if (this.f22703e.f22698f.n(b2)) {
                    AlbumImageBrowseFragment albumImageBrowseFragment = this.f22703e;
                    albumImageBrowseFragment.c1(albumImageBrowseFragment.k, true);
                } else {
                    AlbumImageBrowseFragment albumImageBrowseFragment2 = this.f22703e;
                    albumImageBrowseFragment2.c1(albumImageBrowseFragment2.k, false);
                }
                if (this.f22703e.f22698f != null && this.f22703e.f22698f.m() != null) {
                    z = this.f22703e.f22698f.m().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.f22703e.n.setVisibility(8);
                } else if (b2 == null || !b2.isGif()) {
                    this.f22703e.n.setVisibility(0);
                } else {
                    this.f22703e.n.setVisibility(8);
                }
                AlbumImageBrowseFragment albumImageBrowseFragment3 = this.f22703e;
                albumImageBrowseFragment3.e1(albumImageBrowseFragment3.f22698f.s());
            }
        }
    }

    public AlbumImageBrowseFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = -1;
        this.r = new a(this);
        this.s = new b(this);
    }

    public final void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f22699g.O();
        }
    }

    public View Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    public View Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.m : (View) invokeV.objValue;
    }

    public View a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.n : (View) invokeV.objValue;
    }

    public final void b1() {
        List<ImageFileInfo> i2;
        int j;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f22698f == null && (eVar = this.f22699g) != null) {
                this.f22698f = eVar.q();
            }
            c cVar = this.f22698f;
            if (cVar == null || (i2 = cVar.i()) == null || (j = this.f22698f.j()) < 0) {
                return;
            }
            this.q = j;
            AlbumImagePagerAdapter albumImagePagerAdapter = new AlbumImagePagerAdapter(this.f22697e);
            this.f22700h = albumImagePagerAdapter;
            this.p.setAdapter(albumImagePagerAdapter);
            int i3 = this.q;
            if (i3 == 0 && i2 != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(i2, i3);
                boolean z = true;
                if (this.f22698f.n(imageFileInfo)) {
                    c1(this.k, true);
                } else {
                    c1(this.k, false);
                }
                c cVar2 = this.f22698f;
                if (cVar2 != null && cVar2.m() != null) {
                    z = this.f22698f.m().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.n.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.n.setVisibility(8);
                } else {
                    this.n.setVisibility(0);
                }
            }
            this.f22700h.d(i2);
            this.p.setCurrentItem(this.q, false);
            e1(this.f22698f.s());
        }
    }

    public final void c1(ImageView imageView, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, imageView, z) == null) || imageView == null || this.f22697e == null) {
            return;
        }
        if (z) {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324_select, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        } else {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
        }
        if (this.m != null) {
            c cVar = this.f22698f;
            int count = cVar != null ? ListUtils.getCount(cVar.g()) : 0;
            c cVar2 = this.f22698f;
            this.m.setText(this.f22697e.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(cVar2 != null ? cVar2.l() : 1)}));
            this.m.setEnabled(count > 0);
        }
    }

    public void d1(ImageFileInfo imageFileInfo, boolean z) {
        AlbumImagePagerAdapter albumImagePagerAdapter;
        ImageFileInfo b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048582, this, imageFileInfo, z) == null) || imageFileInfo == null || imageFileInfo.getFilePath() == null || (albumImagePagerAdapter = this.f22700h) == null || (b2 = albumImagePagerAdapter.b(this.q)) == null || b2.getFilePath() == null || !b2.getFilePath().equals(imageFileInfo.getFilePath())) {
            return;
        }
        c1(this.k, z);
    }

    public void e1(boolean z) {
        ImageFileInfo b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || this.f22697e == null || this.n == null) {
            return;
        }
        AlbumImagePagerAdapter albumImagePagerAdapter = this.f22700h;
        long fileSize = (albumImagePagerAdapter == null || (b2 = albumImagePagerAdapter.b(this.q)) == null) ? 0L : FileHelper.getFileSize(b2.getFilePath());
        String string = this.f22697e.getResources().getString(R.string.original_img);
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

    public void f1(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            this.f22699g = eVar;
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || isHidden()) {
            return;
        }
        this.o.setVisibility(8);
        this.p.setVisibility(0);
        b1();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            super.onChangeSkinType(i2);
            d.a.p0.u0.a.a(getPageContext(), this.f22701i);
            SkinManager.setNavbarIconSrc(this.j, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i2);
            c cVar = this.f22698f;
            if (cVar != null) {
                e1(cVar.s());
            }
            AlbumImagePagerAdapter albumImagePagerAdapter = this.f22700h;
            if (albumImagePagerAdapter != null) {
                albumImagePagerAdapter.notifyDataSetChanged();
            }
            this.m.k();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            this.f22697e = baseFragmentActivity;
            if (this.f22699g == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.f22699g = ((AlbumFloatActivity) baseFragmentActivity).albumView;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.f22699g = ((AlbumActivity) baseFragmentActivity).albumView;
                }
            }
            e eVar = this.f22699g;
            if (eVar != null) {
                this.f22698f = eVar.q();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            this.f22697e = baseFragmentActivity;
            if (this.f22699g == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.f22699g = ((AlbumFloatActivity) baseFragmentActivity).albumView;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.f22699g = ((AlbumActivity) baseFragmentActivity).albumView;
                }
            }
            e eVar = this.f22699g;
            if (eVar != null) {
                this.f22698f = eVar.q();
            }
            View inflate = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
            this.f22701i = inflate;
            this.j = (ImageView) inflate.findViewById(R.id.img_back);
            this.k = (ImageView) this.f22701i.findViewById(R.id.img_choose);
            this.p = (ViewPager) this.f22701i.findViewById(R.id.viewPager);
            this.o = this.f22701i.findViewById(R.id.album_no_data);
            this.n = (TextView) this.f22701i.findViewById(R.id.original_select_btn);
            this.l = this.f22701i.findViewById(R.id.layout_bottom);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f22701i.findViewById(R.id.next_step);
            this.m = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.tbds34);
            this.m.getStyleConfig().k(l.g(this.f22697e, R.dimen.tbds25));
            this.j.setOnClickListener(this.f22697e);
            this.m.setOnClickListener(this.f22697e);
            this.k.setOnClickListener(this.r);
            this.n.setOnClickListener(this.f22697e);
            this.l.setOnClickListener(this.r);
            this.p.setOnPageChangeListener(this.s);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            c cVar = this.f22698f;
            if (cVar != null && cVar.m() != null) {
                this.n.setVisibility(this.f22698f.m().isEnableChooseOriginalImg() ? 0 : 4);
            }
            if (getBaseFragmentActivity() instanceof AlbumFloatActivity) {
                this.f22701i.setPadding(0, UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0, 0, 0);
            }
            return this.f22701i;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        AlbumImagePagerAdapter albumImagePagerAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            super.onHiddenChanged(z);
            if (!z || (albumImagePagerAdapter = this.f22700h) == null) {
                return;
            }
            albumImagePagerAdapter.d(null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onResume();
            if (isShow()) {
                o();
            }
        }
    }
}
