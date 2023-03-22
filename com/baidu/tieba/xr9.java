package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.write.album.AlbumImageBrowseFragment;
import com.baidu.tieba.write.album.ImageListFragment;
import com.baidu.tieba.write.album.TbCameraView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class xr9 extends y8<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public bs9 c;
    public Fragment[] d;
    public String[] e;
    public ImageListFragment f;
    public AlbumImageBrowseFragment g;

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements TbCameraView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCameraView a;

        public a(xr9 xr9Var, TbCameraView tbCameraView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xr9Var, tbCameraView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCameraView;
        }

        @Override // com.baidu.tieba.write.album.TbCameraView.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.p();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xr9(TbPageContext tbPageContext, bs9 bs9Var) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bs9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "tag_image";
        this.b = "tag_b_image";
        this.c = bs9Var;
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.g;
            if (albumImageBrowseFragment != null) {
                albumImageBrowseFragment.W1(z);
            }
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment != null) {
                imageListFragment.l2(z);
            }
        }
    }

    public void B(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, navigationBar) == null) {
            this.f.n2(navigationBar);
        }
    }

    public void C(gs9 gs9Var) {
        ImageListFragment imageListFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gs9Var) == null) && (imageListFragment = this.f) != null) {
            imageListFragment.o2(gs9Var);
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            int i2 = 0;
            while (true) {
                Fragment[] fragmentArr = this.d;
                if (i2 < fragmentArr.length) {
                    if (fragmentArr[i2] != null && (fragmentArr[i2] instanceof ImageListFragment)) {
                        ((ImageListFragment) fragmentArr[i2]).onChangeSkinType(i);
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public Fragment p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (i >= 0 && i <= 1) {
                return this.d[i];
            }
            return null;
        }
        return (Fragment) invokeI.objValue;
    }

    public String q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            if (i >= 0 && i <= 1) {
                return this.e[i];
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public void D() {
        TbCameraView o;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (o = o()) != null) {
            o.p();
            o.setVisibility(4);
        }
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.g;
            if (albumImageBrowseFragment == null) {
                return null;
            }
            return albumImageBrowseFragment.Q1();
        }
        return (View) invokeV.objValue;
    }

    public View l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.c2();
        }
        return (View) invokeV.objValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.g;
            if (albumImageBrowseFragment == null) {
                return null;
            }
            return albumImageBrowseFragment.R1();
        }
        return (View) invokeV.objValue;
    }

    public View n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.d2();
        }
        return (View) invokeV.objValue;
    }

    public TbCameraView o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.e2();
        }
        return (TbCameraView) invokeV.objValue;
    }

    public ImageListFragment r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.f;
        }
        return (ImageListFragment) invokeV.objValue;
    }

    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.g2();
        }
        return (View) invokeV.objValue;
    }

    public View t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.g;
            if (albumImageBrowseFragment == null) {
                return null;
            }
            return albumImageBrowseFragment.S1();
        }
        return (View) invokeV.objValue;
    }

    public void z() {
        ImageListFragment imageListFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (imageListFragment = this.f) != null) {
            imageListFragment.h2();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.d = new Fragment[2];
            this.e = new String[2];
            ImageListFragment imageListFragment = new ImageListFragment();
            this.f = imageListFragment;
            imageListFragment.m2(this.c);
            this.d[0] = this.f;
            this.e[0] = this.a;
            AlbumImageBrowseFragment albumImageBrowseFragment = new AlbumImageBrowseFragment();
            this.g = albumImageBrowseFragment;
            albumImageBrowseFragment.X1(this.c);
            this.d[1] = this.g;
            this.e[1] = this.b;
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            TbCameraView o = o();
            if (o != null) {
                o.setOnOpenCameraFailedListener(new a(this, o));
                o.n(false);
                o.setVisibility(0);
            }
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment != null && imageListFragment.f2() != null) {
                this.f.f2().n();
            }
        }
    }
}
