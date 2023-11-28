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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.bfb;
import com.baidu.tieba.ceb;
import com.baidu.tieba.cfb;
import com.baidu.tieba.eeb;
import com.baidu.tieba.fq5;
import com.baidu.tieba.write.util.PhotoType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class AlbumImageBrowseFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;
    public ceb b;
    public eeb c;
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

    /* loaded from: classes8.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != this.a.h && view2 == this.a.g && this.a.d != null && this.a.b != null && this.a.a != null) {
                if (this.a.b.p()) {
                    this.a.a.showToast(R.string.obfuscated_res_0x7f0f0293);
                } else if (!this.a.d.c(this.a.m)) {
                } else {
                    ImageFileInfo b = this.a.d.b(this.a.m);
                    if (b != null && bfb.a(b.getFilePath()) == PhotoType.APNG) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0ece);
                    } else if (cfb.a(b)) {
                        this.a.a.showToast(R.string.obfuscated_res_0x7f0f0290);
                    } else if (cfb.b(b)) {
                        this.a.a.showToast(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0292), Integer.valueOf(SharedPrefHelper.getInstance().getInt("key_upload_pic_max_width", 0)), Integer.valueOf(SharedPrefHelper.getInstance().getInt("key_upload_pic_max_height", 0))));
                    } else {
                        if (this.a.b.n(b)) {
                            if (this.a.c.k(b)) {
                                AlbumImageBrowseFragment albumImageBrowseFragment = this.a;
                                albumImageBrowseFragment.W2(albumImageBrowseFragment.g, false);
                                this.a.c.M(b, false);
                            }
                        } else if (this.a.c.d(b)) {
                            AlbumImageBrowseFragment albumImageBrowseFragment2 = this.a;
                            albumImageBrowseFragment2.W2(albumImageBrowseFragment2.g, true);
                            this.a.c.M(b, true);
                        }
                        this.a.R2();
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlbumImageBrowseFragment a;

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
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) {
                return;
            }
            this.a.m = i;
            if (this.a.d != null && this.a.b != null) {
                ImageFileInfo b = this.a.d.b(this.a.m);
                boolean z = true;
                if (this.a.b.n(b)) {
                    AlbumImageBrowseFragment albumImageBrowseFragment = this.a;
                    albumImageBrowseFragment.W2(albumImageBrowseFragment.g, true);
                } else {
                    AlbumImageBrowseFragment albumImageBrowseFragment2 = this.a;
                    albumImageBrowseFragment2.W2(albumImageBrowseFragment2.g, false);
                }
                if (this.a.b != null && this.a.b.m() != null) {
                    z = this.a.b.m().isEnableChooseOriginalImg();
                }
                if (!z) {
                    this.a.j.setVisibility(8);
                } else if (b != null && b.isGif()) {
                    this.a.j.setVisibility(8);
                } else {
                    this.a.j.setVisibility(0);
                }
                AlbumImageBrowseFragment albumImageBrowseFragment3 = this.a;
                albumImageBrowseFragment3.Y2(albumImageBrowseFragment3.b.s());
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

    public void Z2(eeb eebVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, eebVar) == null) {
            this.c = eebVar;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        AlbumImagePagerAdapter albumImagePagerAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            super.onHiddenChanged(z);
            if (z && (albumImagePagerAdapter = this.d) != null) {
                albumImagePagerAdapter.e(null);
            }
        }
    }

    public final void R2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.N();
        }
    }

    public View S2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !isHidden()) {
            this.k.setVisibility(8);
            this.l.setVisibility(0);
            V2();
        }
    }

    public View T2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    public View U2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.j;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onResume();
            if (!isShow()) {
                return;
            }
            T();
        }
    }

    public final void V2() {
        List<ImageFileInfo> i;
        int j;
        eeb eebVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.b == null && (eebVar = this.c) != null) {
                this.b = eebVar.t();
            }
            ceb cebVar = this.b;
            if (cebVar != null && (i = cebVar.i()) != null && (j = this.b.j()) >= 0) {
                this.m = j;
                AlbumImagePagerAdapter albumImagePagerAdapter = new AlbumImagePagerAdapter(this.a);
                this.d = albumImagePagerAdapter;
                this.l.setAdapter(albumImagePagerAdapter);
                int i2 = this.m;
                if (i2 == 0 && i != null) {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(i, i2);
                    boolean z = true;
                    if (this.b.n(imageFileInfo)) {
                        W2(this.g, true);
                    } else {
                        W2(this.g, false);
                    }
                    ceb cebVar2 = this.b;
                    if (cebVar2 != null && cebVar2.m() != null) {
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
                this.d.e(i);
                this.l.setCurrentItem(this.m, false);
                Y2(this.b.s());
            }
        }
    }

    public final void W2(ImageView imageView, boolean z) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048582, this, imageView, z) == null) && imageView != null && this.a != null) {
            if (z) {
                imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324_select, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            } else {
                imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
            }
            if (this.i != null) {
                ceb cebVar = this.b;
                boolean z2 = false;
                if (cebVar != null) {
                    i = ListUtils.getCount(cebVar.g());
                } else {
                    i = 0;
                }
                ceb cebVar2 = this.b;
                if (cebVar2 != null) {
                    i2 = cebVar2.l();
                } else {
                    i2 = 1;
                }
                this.i.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0aa8, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
                TBSpecificationBtn tBSpecificationBtn = this.i;
                if (i > 0) {
                    z2 = true;
                }
                tBSpecificationBtn.setEnabled(z2);
            }
        }
    }

    public void X2(ImageFileInfo imageFileInfo, boolean z) {
        AlbumImagePagerAdapter albumImagePagerAdapter;
        ImageFileInfo b2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048583, this, imageFileInfo, z) == null) && imageFileInfo != null && imageFileInfo.getFilePath() != null && (albumImagePagerAdapter = this.d) != null && (b2 = albumImagePagerAdapter.b(this.m)) != null && b2.getFilePath() != null && b2.getFilePath().equals(imageFileInfo.getFilePath())) {
            W2(this.g, z);
        }
    }

    public void Y2(boolean z) {
        long j;
        ImageFileInfo b2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && this.a != null && this.j != null) {
            AlbumImagePagerAdapter albumImagePagerAdapter = this.d;
            if (albumImagePagerAdapter != null && (b2 = albumImagePagerAdapter.b(this.m)) != null) {
                j = FileHelper.getFileSize(b2.getFilePath());
            } else {
                j = 0;
            }
            String string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0f59);
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                if (j > 0) {
                    sb.append("(");
                    sb.append(StringHelper.getFormatSize(j));
                    sb.append(SmallTailInfo.EMOTION_SUFFIX);
                }
                String sb2 = sb.toString();
                SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0302);
                this.j.setText(sb2);
                this.j.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.icon_pure_image_ok_select16, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            }
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0106);
            this.j.setText(string);
            this.j.setCompoundDrawablesWithIntrinsicBounds(WebPManager.getPureDrawable(R.drawable.icon_pure_image_ok_selection16, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            super.onChangeSkinType(i);
            fq5.a(getPageContext(), this.e);
            SkinManager.setNavbarIconSrc(this.f, R.drawable.icon_return_bg_s, R.drawable.icon_return_bg, i);
            ceb cebVar = this.b;
            if (cebVar != null) {
                Y2(cebVar.s());
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
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
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
            eeb eebVar = this.c;
            if (eebVar != null) {
                this.b = eebVar.t();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            this.a = baseFragmentActivity;
            if (this.c == null) {
                if (baseFragmentActivity instanceof AlbumFloatActivity) {
                    this.c = ((AlbumFloatActivity) baseFragmentActivity).k;
                } else if (baseFragmentActivity instanceof AlbumActivity) {
                    this.c = ((AlbumActivity) baseFragmentActivity).a;
                }
            }
            eeb eebVar = this.c;
            if (eebVar != null) {
                this.b = eebVar.t();
            }
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0124, (ViewGroup) null);
            this.e = inflate;
            this.f = (ImageView) inflate.findViewById(R.id.img_back);
            this.g = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f09114b);
            this.l = (ViewPager) this.e.findViewById(R.id.obfuscated_res_0x7f092a2f);
            this.k = this.e.findViewById(R.id.obfuscated_res_0x7f090290);
            this.j = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f091b0d);
            this.h = this.e.findViewById(R.id.obfuscated_res_0x7f091555);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.e.findViewById(R.id.obfuscated_res_0x7f091a4b);
            this.i = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.tbds34);
            this.i.getStyleConfig().n(BdUtilHelper.getDimens(this.a, R.dimen.tbds25));
            this.f.setOnClickListener(this.a);
            this.i.setOnClickListener(this.a);
            this.g.setOnClickListener(this.n);
            this.j.setOnClickListener(this.a);
            this.h.setOnClickListener(this.n);
            this.l.setOnPageChangeListener(this.o);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            ceb cebVar = this.b;
            if (cebVar != null && cebVar.m() != null) {
                TextView textView = this.j;
                if (this.b.m().isEnableChooseOriginalImg()) {
                    i2 = 0;
                } else {
                    i2 = 4;
                }
                textView.setVisibility(i2);
            }
            if (getBaseFragmentActivity() instanceof AlbumFloatActivity) {
                View view2 = this.e;
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    i = UtilHelper.getStatusBarHeight();
                } else {
                    i = 0;
                }
                view2.setPadding(0, i, 0, 0);
            }
            return this.e;
        }
        return (View) invokeLLL.objValue;
    }
}
