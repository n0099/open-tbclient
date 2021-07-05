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
import d.a.c.e.p.l;
import d.a.s0.a4.k.c;
import d.a.s0.a4.k.e;
import java.util.List;
/* loaded from: classes5.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseFragmentActivity f22480e;

    /* renamed from: f  reason: collision with root package name */
    public c f22481f;

    /* renamed from: g  reason: collision with root package name */
    public e f22482g;

    /* renamed from: h  reason: collision with root package name */
    public AlbumImagePagerAdapter f22483h;

    /* renamed from: i  reason: collision with root package name */
    public View f22484i;
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

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlbumImageBrowseFragment f22485e;

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
            this.f22485e = albumImageBrowseFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == this.f22485e.l || view != this.f22485e.k || this.f22485e.f22483h == null || this.f22485e.f22481f == null || this.f22485e.f22480e == null) {
                return;
            }
            if (this.f22485e.f22481f.p()) {
                this.f22485e.f22480e.showToast(R.string.album_choose_switch_tip);
            } else if (this.f22485e.f22483h.j(this.f22485e.q)) {
                ImageFileInfo i2 = this.f22485e.f22483h.i(this.f22485e.q);
                if (d.a.s0.a4.r.a.a(i2)) {
                    this.f22485e.f22480e.showToast(R.string.album_choose_image_low_quality_tip);
                    return;
                }
                if (this.f22485e.f22481f.n(i2)) {
                    if (this.f22485e.f22482g.k(i2)) {
                        AlbumImageBrowseFragment albumImageBrowseFragment = this.f22485e;
                        albumImageBrowseFragment.W0(albumImageBrowseFragment.k, false);
                        this.f22485e.f22482g.O(i2, false);
                    }
                } else if (this.f22485e.f22482g.c(i2)) {
                    AlbumImageBrowseFragment albumImageBrowseFragment2 = this.f22485e;
                    albumImageBrowseFragment2.W0(albumImageBrowseFragment2.k, true);
                    this.f22485e.f22482g.O(i2, true);
                }
                this.f22485e.R0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlbumImageBrowseFragment f22486e;

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
            this.f22486e = albumImageBrowseFragment;
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
                this.f22486e.q = i2;
                if (this.f22486e.f22483h == null || this.f22486e.f22481f == null) {
                    return;
                }
                ImageFileInfo i3 = this.f22486e.f22483h.i(this.f22486e.q);
                boolean z = true;
                if (this.f22486e.f22481f.n(i3)) {
                    AlbumImageBrowseFragment albumImageBrowseFragment = this.f22486e;
                    albumImageBrowseFragment.W0(albumImageBrowseFragment.k, true);
                } else {
                    AlbumImageBrowseFragment albumImageBrowseFragment2 = this.f22486e;
                    albumImageBrowseFragment2.W0(albumImageBrowseFragment2.k, false);
                }
                if (this.f22486e.f22481f != null && this.f22486e.f22481f.m() != null) {
                    z = this.f22486e.f22481f.m().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.f22486e.n.setVisibility(8);
                } else if (i3 == null || !i3.isGif()) {
                    this.f22486e.n.setVisibility(0);
                } else {
                    this.f22486e.n.setVisibility(8);
                }
                AlbumImageBrowseFragment albumImageBrowseFragment3 = this.f22486e;
                albumImageBrowseFragment3.Y0(albumImageBrowseFragment3.f22481f.s());
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

    public final void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f22482g.P();
        }
    }

    public View S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    public View T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.m : (View) invokeV.objValue;
    }

    public View U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.n : (View) invokeV.objValue;
    }

    public final void V0() {
        List<ImageFileInfo> i2;
        int j;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f22481f == null && (eVar = this.f22482g) != null) {
                this.f22481f = eVar.r();
            }
            c cVar = this.f22481f;
            if (cVar == null || (i2 = cVar.i()) == null || (j = this.f22481f.j()) < 0) {
                return;
            }
            this.q = j;
            AlbumImagePagerAdapter albumImagePagerAdapter = new AlbumImagePagerAdapter(this.f22480e);
            this.f22483h = albumImagePagerAdapter;
            this.p.setAdapter(albumImagePagerAdapter);
            int i3 = this.q;
            if (i3 == 0 && i2 != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(i2, i3);
                boolean z = true;
                if (this.f22481f.n(imageFileInfo)) {
                    W0(this.k, true);
                } else {
                    W0(this.k, false);
                }
                c cVar2 = this.f22481f;
                if (cVar2 != null && cVar2.m() != null) {
                    z = this.f22481f.m().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.n.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.n.setVisibility(8);
                } else {
                    this.n.setVisibility(0);
                }
            }
            this.f22483h.k(i2);
            this.p.setCurrentItem(this.q, false);
            Y0(this.f22481f.s());
        }
    }

    public final void W0(ImageView imageView, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, imageView, z) == null) || imageView == null || this.f22480e == null) {
            return;
        }
        if (z) {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324_select, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        } else {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
        }
        if (this.m != null) {
            c cVar = this.f22481f;
            int count = cVar != null ? ListUtils.getCount(cVar.g()) : 0;
            c cVar2 = this.f22481f;
            this.m.setText(this.f22480e.getString(R.string.image_selected_list_count_max, new Object[]{Integer.valueOf(count), Integer.valueOf(cVar2 != null ? cVar2.l() : 1)}));
            this.m.setEnabled(count > 0);
        }
    }

    public void X0(ImageFileInfo imageFileInfo, boolean z) {
        AlbumImagePagerAdapter albumImagePagerAdapter;
        ImageFileInfo i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048582, this, imageFileInfo, z) == null) || imageFileInfo == null || imageFileInfo.getFilePath() == null || (albumImagePagerAdapter = this.f22483h) == null || (i2 = albumImagePagerAdapter.i(this.q)) == null || i2.getFilePath() == null || !i2.getFilePath().equals(imageFileInfo.getFilePath())) {
            return;
        }
        W0(this.k, z);
    }

    public void Y0(boolean z) {
        ImageFileInfo i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || this.f22480e == null || this.n == null) {
            return;
        }
        AlbumImagePagerAdapter albumImagePagerAdapter = this.f22483h;
        long fileSize = (albumImagePagerAdapter == null || (i2 = albumImagePagerAdapter.i(this.q)) == null) ? 0L : FileHelper.getFileSize(i2.getFilePath());
        String string = this.f22480e.getResources().getString(R.string.original_img);
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

    public void Z0(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            this.f22482g = eVar;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            super.onChangeSkinType(i2);
            d.a.r0.s0.a.a(getPageContext(), this.f22484i);
            SkinManager.setNavbarIconSrc(this.j, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i2);
            c cVar = this.f22481f;
            if (cVar != null) {
                Y0(cVar.s());
            }
            AlbumImagePagerAdapter albumImagePagerAdapter = this.f22483h;
            if (albumImagePagerAdapter != null) {
                albumImagePagerAdapter.notifyDataSetChanged();
            }
            this.m.k();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            this.f22480e = baseFragmentActivity;
            if (this.f22482g == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.f22482g = ((AlbumFloatActivity) baseFragmentActivity).albumView;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.f22482g = ((AlbumActivity) baseFragmentActivity).albumView;
                }
            }
            e eVar = this.f22482g;
            if (eVar != null) {
                this.f22481f = eVar.r();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, layoutInflater, viewGroup, bundle)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            this.f22480e = baseFragmentActivity;
            if (this.f22482g == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.f22482g = ((AlbumFloatActivity) baseFragmentActivity).albumView;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.f22482g = ((AlbumActivity) baseFragmentActivity).albumView;
                }
            }
            e eVar = this.f22482g;
            if (eVar != null) {
                this.f22481f = eVar.r();
            }
            View inflate = layoutInflater.inflate(R.layout.album_big_image_view, (ViewGroup) null);
            this.f22484i = inflate;
            this.j = (ImageView) inflate.findViewById(R.id.img_back);
            this.k = (ImageView) this.f22484i.findViewById(R.id.img_choose);
            this.p = (ViewPager) this.f22484i.findViewById(R.id.viewPager);
            this.o = this.f22484i.findViewById(R.id.album_no_data);
            this.n = (TextView) this.f22484i.findViewById(R.id.original_select_btn);
            this.l = this.f22484i.findViewById(R.id.layout_bottom);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f22484i.findViewById(R.id.next_step);
            this.m = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.tbds34);
            this.m.getStyleConfig().k(l.g(this.f22480e, R.dimen.tbds25));
            this.j.setOnClickListener(this.f22480e);
            this.m.setOnClickListener(this.f22480e);
            this.k.setOnClickListener(this.r);
            this.n.setOnClickListener(this.f22480e);
            this.l.setOnClickListener(this.r);
            this.p.setOnPageChangeListener(this.s);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            c cVar = this.f22481f;
            if (cVar != null && cVar.m() != null) {
                this.n.setVisibility(this.f22481f.m().isEnableChooseOriginalImg() ? 0 : 4);
            }
            if (getBaseFragmentActivity() instanceof AlbumFloatActivity) {
                this.f22484i.setPadding(0, UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0, 0, 0);
            }
            return this.f22484i;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        AlbumImagePagerAdapter albumImagePagerAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            super.onHiddenChanged(z);
            if (!z || (albumImagePagerAdapter = this.f22483h) == null) {
                return;
            }
            albumImagePagerAdapter.k(null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onResume();
            if (isShow()) {
                p();
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || isHidden()) {
            return;
        }
        this.o.setVisibility(8);
        this.p.setVisibility(0);
        V0();
    }
}
