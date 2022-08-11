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
import com.baidu.tieba.write.util.PhotoType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fb5;
import com.repackage.k09;
import com.repackage.l09;
import com.repackage.oz8;
import com.repackage.qi;
import com.repackage.qz8;
import com.repackage.ru4;
import java.util.List;
/* loaded from: classes4.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;
    public oz8 b;
    public qz8 c;
    public AlbumImagePagerAdapter d;
    public View e;
    public ImageView f;
    public ImageView g;
    public View h;
    public TBSpecificationBtn i;
    public TextView j;
    public View k;
    public ViewPager l;
    public int m;
    public View.OnClickListener n;
    public ViewPager.OnPageChangeListener o;

    /* loaded from: classes4.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == this.a.h || view2 != this.a.g || this.a.d == null || this.a.b == null || this.a.a == null) {
                return;
            }
            if (this.a.b.p()) {
                this.a.a.showToast(R.string.obfuscated_res_0x7f0f0256);
            } else if (this.a.d.c(this.a.m)) {
                ImageFileInfo b = this.a.d.b(this.a.m);
                if (b != null && k09.a(b.getFilePath()) == PhotoType.APNG) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c94);
                } else if (l09.a(b)) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0254);
                } else if (!l09.b(b)) {
                    if (this.a.b.n(b)) {
                        if (this.a.c.j(b)) {
                            AlbumImageBrowseFragment albumImageBrowseFragment = this.a;
                            albumImageBrowseFragment.I1(albumImageBrowseFragment.g, false);
                            this.a.c.M(b, false);
                        }
                    } else if (this.a.c.c(b)) {
                        AlbumImageBrowseFragment albumImageBrowseFragment2 = this.a;
                        albumImageBrowseFragment2.I1(albumImageBrowseFragment2.g, true);
                        this.a.c.M(b, true);
                    }
                    this.a.D1();
                } else {
                    this.a.a.showToast(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0255), Integer.valueOf(ru4.k().l("key_upload_pic_max_width", 0)), Integer.valueOf(ru4.k().l("key_upload_pic_max_height", 0))));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                this.a.m = i;
                if (this.a.d == null || this.a.b == null) {
                    return;
                }
                ImageFileInfo b = this.a.d.b(this.a.m);
                boolean z = true;
                if (this.a.b.n(b)) {
                    AlbumImageBrowseFragment albumImageBrowseFragment = this.a;
                    albumImageBrowseFragment.I1(albumImageBrowseFragment.g, true);
                } else {
                    AlbumImageBrowseFragment albumImageBrowseFragment2 = this.a;
                    albumImageBrowseFragment2.I1(albumImageBrowseFragment2.g, false);
                }
                if (this.a.b != null && this.a.b.m() != null) {
                    z = this.a.b.m().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.a.j.setVisibility(8);
                } else if (b == null || !b.isGif()) {
                    this.a.j.setVisibility(0);
                } else {
                    this.a.j.setVisibility(8);
                }
                AlbumImageBrowseFragment albumImageBrowseFragment3 = this.a;
                albumImageBrowseFragment3.K1(albumImageBrowseFragment3.b.s());
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

    public final void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.N();
        }
    }

    public View E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    public View F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.i : (View) invokeV.objValue;
    }

    public View G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    public final void H1() {
        List<ImageFileInfo> i;
        int j;
        qz8 qz8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.b == null && (qz8Var = this.c) != null) {
                this.b = qz8Var.r();
            }
            oz8 oz8Var = this.b;
            if (oz8Var == null || (i = oz8Var.i()) == null || (j = this.b.j()) < 0) {
                return;
            }
            this.m = j;
            AlbumImagePagerAdapter albumImagePagerAdapter = new AlbumImagePagerAdapter(this.a);
            this.d = albumImagePagerAdapter;
            this.l.setAdapter(albumImagePagerAdapter);
            int i2 = this.m;
            if (i2 == 0 && i != null) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(i, i2);
                boolean z = true;
                if (this.b.n(imageFileInfo)) {
                    I1(this.g, true);
                } else {
                    I1(this.g, false);
                }
                oz8 oz8Var2 = this.b;
                if (oz8Var2 != null && oz8Var2.m() != null) {
                    z = this.b.m().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.j.setVisibility(8);
                } else if (imageFileInfo.isGif()) {
                    this.j.setVisibility(8);
                } else {
                    this.j.setVisibility(0);
                }
            }
            this.d.d(i);
            this.l.setCurrentItem(this.m, false);
            K1(this.b.s());
        }
    }

    public final void I1(ImageView imageView, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, imageView, z) == null) || imageView == null || this.a == null) {
            return;
        }
        if (z) {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809d9, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        } else {
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809d8, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
        }
        if (this.i != null) {
            oz8 oz8Var = this.b;
            int count = oz8Var != null ? ListUtils.getCount(oz8Var.g()) : 0;
            oz8 oz8Var2 = this.b;
            this.i.setText(this.a.getString(R.string.obfuscated_res_0x7f0f08d5, new Object[]{Integer.valueOf(count), Integer.valueOf(oz8Var2 != null ? oz8Var2.l() : 1)}));
            this.i.setEnabled(count > 0);
        }
    }

    public void J1(ImageFileInfo imageFileInfo, boolean z) {
        AlbumImagePagerAdapter albumImagePagerAdapter;
        ImageFileInfo b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048582, this, imageFileInfo, z) == null) || imageFileInfo == null || imageFileInfo.getFilePath() == null || (albumImagePagerAdapter = this.d) == null || (b2 = albumImagePagerAdapter.b(this.m)) == null || b2.getFilePath() == null || !b2.getFilePath().equals(imageFileInfo.getFilePath())) {
            return;
        }
        I1(this.g, z);
    }

    public void K1(boolean z) {
        ImageFileInfo b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || this.a == null || this.j == null) {
            return;
        }
        AlbumImagePagerAdapter albumImagePagerAdapter = this.d;
        long fileSize = (albumImagePagerAdapter == null || (b2 = albumImagePagerAdapter.b(this.m)) == null) ? 0L : FileHelper.getFileSize(b2.getFilePath());
        String string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0d0e);
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
            this.j.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080947, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0106);
        this.j.setText(string);
        this.j.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080948, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void L1(qz8 qz8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qz8Var) == null) {
            this.c = qz8Var;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            super.onChangeSkinType(i);
            fb5.a(getPageContext(), this.e);
            SkinManager.setNavbarIconSrc(this.f, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
            oz8 oz8Var = this.b;
            if (oz8Var != null) {
                K1(oz8Var.s());
            }
            AlbumImagePagerAdapter albumImagePagerAdapter = this.d;
            if (albumImagePagerAdapter != null) {
                albumImagePagerAdapter.notifyDataSetChanged();
            }
            this.i.k();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            this.a = baseFragmentActivity;
            if (this.c == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.c = ((AlbumFloatActivity) baseFragmentActivity).k;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.c = ((AlbumActivity) baseFragmentActivity).a;
                }
            }
            qz8 qz8Var = this.c;
            if (qz8Var != null) {
                this.b = qz8Var.r();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, layoutInflater, viewGroup, bundle)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            this.a = baseFragmentActivity;
            if (this.c == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.c = ((AlbumFloatActivity) baseFragmentActivity).k;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.c = ((AlbumActivity) baseFragmentActivity).a;
                }
            }
            qz8 qz8Var = this.c;
            if (qz8Var != null) {
                this.b = qz8Var.r();
            }
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0112, (ViewGroup) null);
            this.e = inflate;
            this.f = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090ead);
            this.g = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f090eba);
            this.l = (ViewPager) this.e.findViewById(R.id.obfuscated_res_0x7f092534);
            this.k = this.e.findViewById(R.id.obfuscated_res_0x7f09024d);
            this.j = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f091729);
            this.h = this.e.findViewById(R.id.obfuscated_res_0x7f091258);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.e.findViewById(R.id.obfuscated_res_0x7f091683);
            this.i = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.tbds34);
            this.i.getStyleConfig().l(qi.f(this.a, R.dimen.tbds25));
            this.f.setOnClickListener(this.a);
            this.i.setOnClickListener(this.a);
            this.g.setOnClickListener(this.n);
            this.j.setOnClickListener(this.a);
            this.h.setOnClickListener(this.n);
            this.l.setOnPageChangeListener(this.o);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            oz8 oz8Var = this.b;
            if (oz8Var != null && oz8Var.m() != null) {
                this.j.setVisibility(this.b.m().isEnableChooseOriginalImg() ? 0 : 4);
            }
            if (getBaseFragmentActivity() instanceof AlbumFloatActivity) {
                this.e.setPadding(0, UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0, 0, 0);
            }
            return this.e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        AlbumImagePagerAdapter albumImagePagerAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            super.onHiddenChanged(z);
            if (!z || (albumImagePagerAdapter = this.d) == null) {
                return;
            }
            albumImagePagerAdapter.d(null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onResume();
            if (isShow()) {
                t();
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || isHidden()) {
            return;
        }
        this.k.setVisibility(8);
        this.l.setVisibility(0);
        H1();
    }
}
