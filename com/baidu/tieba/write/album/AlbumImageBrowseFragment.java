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
import c.a.d.f.p.n;
import c.a.p0.s4.k.c;
import c.a.p0.s4.k.e;
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
import com.baidu.tieba.write.util.PhotoType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public c f37270b;

    /* renamed from: c  reason: collision with root package name */
    public e f37271c;

    /* renamed from: d  reason: collision with root package name */
    public AlbumImagePagerAdapter f37272d;

    /* renamed from: e  reason: collision with root package name */
    public View f37273e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f37274f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f37275g;

    /* renamed from: h  reason: collision with root package name */
    public View f37276h;
    public TBSpecificationBtn i;
    public TextView j;
    public View k;
    public ViewPager l;
    public int m;
    public View.OnClickListener n;
    public ViewPager.OnPageChangeListener o;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlbumImageBrowseFragment a;

        public a(AlbumImageBrowseFragment albumImageBrowseFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {albumImageBrowseFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = albumImageBrowseFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == this.a.f37276h || view != this.a.f37275g || this.a.f37272d == null || this.a.f37270b == null || this.a.a == null) {
                return;
            }
            if (this.a.f37270b.p()) {
                this.a.a.showToast(R.string.obfuscated_res_0x7f0f024d);
            } else if (this.a.f37272d.c(this.a.m)) {
                ImageFileInfo b2 = this.a.f37272d.b(this.a.m);
                if (b2 != null && c.a.p0.s4.r.a.a(b2.getFilePath()) == PhotoType.APNG) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c69);
                } else if (c.a.p0.s4.r.b.a(b2)) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f024b);
                } else if (!c.a.p0.s4.r.b.b(b2)) {
                    if (this.a.f37270b.n(b2)) {
                        if (this.a.f37271c.j(b2)) {
                            AlbumImageBrowseFragment albumImageBrowseFragment = this.a;
                            albumImageBrowseFragment.S0(albumImageBrowseFragment.f37275g, false);
                            this.a.f37271c.J(b2, false);
                        }
                    } else if (this.a.f37271c.c(b2)) {
                        AlbumImageBrowseFragment albumImageBrowseFragment2 = this.a;
                        albumImageBrowseFragment2.S0(albumImageBrowseFragment2.f37275g, true);
                        this.a.f37271c.J(b2, true);
                    }
                    this.a.N0();
                } else {
                    this.a.a.showToast(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f024c), Integer.valueOf(c.a.o0.r.j0.b.k().l("key_upload_pic_max_width", 0)), Integer.valueOf(c.a.o0.r.j0.b.k().l("key_upload_pic_max_height", 0))));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlbumImageBrowseFragment a;

        public b(AlbumImageBrowseFragment albumImageBrowseFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {albumImageBrowseFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = albumImageBrowseFragment;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.a.m = i;
                if (this.a.f37272d == null || this.a.f37270b == null) {
                    return;
                }
                ImageFileInfo b2 = this.a.f37272d.b(this.a.m);
                boolean z = true;
                if (this.a.f37270b.n(b2)) {
                    AlbumImageBrowseFragment albumImageBrowseFragment = this.a;
                    albumImageBrowseFragment.S0(albumImageBrowseFragment.f37275g, true);
                } else {
                    AlbumImageBrowseFragment albumImageBrowseFragment2 = this.a;
                    albumImageBrowseFragment2.S0(albumImageBrowseFragment2.f37275g, false);
                }
                if (this.a.f37270b != null && this.a.f37270b.m() != null) {
                    z = this.a.f37270b.m().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.a.j.setVisibility(8);
                } else if (b2 == null || !b2.isGif()) {
                    this.a.j.setVisibility(0);
                } else {
                    this.a.j.setVisibility(8);
                }
                AlbumImageBrowseFragment albumImageBrowseFragment3 = this.a;
                albumImageBrowseFragment3.U0(albumImageBrowseFragment3.f37270b.s());
            }
        }
    }

    public AlbumImageBrowseFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = -1;
        this.n = new a(this);
        this.o = new b(this);
    }

    public final void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f37271c.K();
        }
    }

    public View O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f37274f : (View) invokeV.objValue;
    }

    public View P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.i : (View) invokeV.objValue;
    }

    public View Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    public final void R0() {
        List<ImageFileInfo> i;
        int j;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f37270b == null && (eVar = this.f37271c) != null) {
                this.f37270b = eVar.q();
            }
            c cVar = this.f37270b;
            if (cVar == null || (i = cVar.i()) == null || (j = this.f37270b.j()) < 0) {
                return;
            }
            this.m = j;
            AlbumImagePagerAdapter albumImagePagerAdapter = new AlbumImagePagerAdapter(this.a);
            this.f37272d = albumImagePagerAdapter;
            this.l.setAdapter(albumImagePagerAdapter);
            int i2 = this.m;
            if (i2 == 0 && i != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(i, i2);
                boolean z = true;
                if (this.f37270b.n(imageFileInfo)) {
                    S0(this.f37275g, true);
                } else {
                    S0(this.f37275g, false);
                }
                c cVar2 = this.f37270b;
                if (cVar2 != null && cVar2.m() != null) {
                    z = this.f37270b.m().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.j.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.j.setVisibility(8);
                } else {
                    this.j.setVisibility(0);
                }
            }
            this.f37272d.d(i);
            this.l.setCurrentItem(this.m, false);
            U0(this.f37270b.s());
        }
    }

    public final void S0(ImageView imageView, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, imageView, z) == null) || imageView == null || this.a == null) {
            return;
        }
        if (z) {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080998, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        } else {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080997, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
        }
        if (this.i != null) {
            c cVar = this.f37270b;
            int count = cVar != null ? ListUtils.getCount(cVar.g()) : 0;
            c cVar2 = this.f37270b;
            this.i.setText(this.a.getString(R.string.obfuscated_res_0x7f0f08af, new Object[]{Integer.valueOf(count), Integer.valueOf(cVar2 != null ? cVar2.l() : 1)}));
            this.i.setEnabled(count > 0);
        }
    }

    public void T0(ImageFileInfo imageFileInfo, boolean z) {
        AlbumImagePagerAdapter albumImagePagerAdapter;
        ImageFileInfo b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048582, this, imageFileInfo, z) == null) || imageFileInfo == null || imageFileInfo.getFilePath() == null || (albumImagePagerAdapter = this.f37272d) == null || (b2 = albumImagePagerAdapter.b(this.m)) == null || b2.getFilePath() == null || !b2.getFilePath().equals(imageFileInfo.getFilePath())) {
            return;
        }
        S0(this.f37275g, z);
    }

    public void U0(boolean z) {
        ImageFileInfo b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || this.a == null || this.j == null) {
            return;
        }
        AlbumImagePagerAdapter albumImagePagerAdapter = this.f37272d;
        long fileSize = (albumImagePagerAdapter == null || (b2 = albumImagePagerAdapter.b(this.m)) == null) ? 0L : FileHelper.getFileSize(b2.getFilePath());
        String string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0ce3);
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            if (fileSize > 0) {
                sb.append("(");
                sb.append(StringHelper.getFormatSize(fileSize));
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
            }
            String sb2 = sb.toString();
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0302);
            this.j.setText(sb2);
            this.j.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080910, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0106);
        this.j.setText(string);
        this.j.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080911, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void V0(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) {
            this.f37271c = eVar;
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || isHidden()) {
            return;
        }
        this.k.setVisibility(8);
        this.l.setVisibility(0);
        R0();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            super.onChangeSkinType(i);
            c.a.o0.w0.a.a(getPageContext(), this.f37273e);
            SkinManager.setNavbarIconSrc(this.f37274f, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
            c cVar = this.f37270b;
            if (cVar != null) {
                U0(cVar.s());
            }
            AlbumImagePagerAdapter albumImagePagerAdapter = this.f37272d;
            if (albumImagePagerAdapter != null) {
                albumImagePagerAdapter.notifyDataSetChanged();
            }
            this.i.k();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            this.a = baseFragmentActivity;
            if (this.f37271c == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.f37271c = ((AlbumFloatActivity) baseFragmentActivity).albumView;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.f37271c = ((AlbumActivity) baseFragmentActivity).albumView;
                }
            }
            e eVar = this.f37271c;
            if (eVar != null) {
                this.f37270b = eVar.q();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            this.a = baseFragmentActivity;
            if (this.f37271c == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.f37271c = ((AlbumFloatActivity) baseFragmentActivity).albumView;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.f37271c = ((AlbumActivity) baseFragmentActivity).albumView;
                }
            }
            e eVar = this.f37271c;
            if (eVar != null) {
                this.f37270b = eVar.q();
            }
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0117, (ViewGroup) null);
            this.f37273e = inflate;
            this.f37274f = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090e9d);
            this.f37275g = (ImageView) this.f37273e.findViewById(R.id.obfuscated_res_0x7f090ea9);
            this.l = (ViewPager) this.f37273e.findViewById(R.id.obfuscated_res_0x7f0923a5);
            this.k = this.f37273e.findViewById(R.id.obfuscated_res_0x7f090247);
            this.j = (TextView) this.f37273e.findViewById(R.id.obfuscated_res_0x7f09161f);
            this.f37276h = this.f37273e.findViewById(R.id.obfuscated_res_0x7f0911c6);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f37273e.findViewById(R.id.obfuscated_res_0x7f091573);
            this.i = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.tbds34);
            this.i.getStyleConfig().l(n.f(this.a, R.dimen.tbds25));
            this.f37274f.setOnClickListener(this.a);
            this.i.setOnClickListener(this.a);
            this.f37275g.setOnClickListener(this.n);
            this.j.setOnClickListener(this.a);
            this.f37276h.setOnClickListener(this.n);
            this.l.setOnPageChangeListener(this.o);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            c cVar = this.f37270b;
            if (cVar != null && cVar.m() != null) {
                this.j.setVisibility(this.f37270b.m().isEnableChooseOriginalImg() ? 0 : 4);
            }
            if (getBaseFragmentActivity() instanceof AlbumFloatActivity) {
                this.f37273e.setPadding(0, UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0, 0, 0);
            }
            return this.f37273e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        AlbumImagePagerAdapter albumImagePagerAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            super.onHiddenChanged(z);
            if (!z || (albumImagePagerAdapter = this.f37272d) == null) {
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
                n();
            }
        }
    }
}
