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
/* loaded from: classes6.dex */
public class vz8 extends b9<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public zz8 c;
    public Fragment[] d;
    public String[] e;
    public ImageListFragment f;
    public AlbumImageBrowseFragment g;

    /* loaded from: classes6.dex */
    public class a implements TbCameraView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCameraView a;

        public a(vz8 vz8Var, TbCameraView tbCameraView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz8Var, tbCameraView};
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

        @Override // com.baidu.tieba.write.album.TbCameraView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.o();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vz8(TbPageContext tbPageContext, zz8 zz8Var) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, zz8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "tag_image";
        this.b = "tag_b_image";
        this.c = zz8Var;
    }

    public void A() {
        TbCameraView n;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (n = n()) == null) {
            return;
        }
        n.o();
        n.setVisibility(4);
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.g;
            if (albumImageBrowseFragment == null) {
                return null;
            }
            return albumImageBrowseFragment.E1();
        }
        return (View) invokeV.objValue;
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.M1();
        }
        return (View) invokeV.objValue;
    }

    public View l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.g;
            if (albumImageBrowseFragment == null) {
                return null;
            }
            return albumImageBrowseFragment.F1();
        }
        return (View) invokeV.objValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.N1();
        }
        return (View) invokeV.objValue;
    }

    public TbCameraView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.O1();
        }
        return (TbCameraView) invokeV.objValue;
    }

    public Fragment o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (i < 0 || i > 1) {
                return null;
            }
            return this.d[i];
        }
        return (Fragment) invokeI.objValue;
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048583, this, i) != null) {
            return;
        }
        int i2 = 0;
        while (true) {
            Fragment[] fragmentArr = this.d;
            if (i2 >= fragmentArr.length) {
                return;
            }
            if (fragmentArr[i2] != null && (fragmentArr[i2] instanceof ImageListFragment)) {
                ((ImageListFragment) fragmentArr[i2]).onChangeSkinType(i);
            }
            i2++;
        }
    }

    public String p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (i < 0 || i > 1) {
                return null;
            }
            return this.e[i];
        }
        return (String) invokeI.objValue;
    }

    public ImageListFragment q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f : (ImageListFragment) invokeV.objValue;
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.Q1();
        }
        return (View) invokeV.objValue;
    }

    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.g;
            if (albumImageBrowseFragment == null) {
                return null;
            }
            return albumImageBrowseFragment.G1();
        }
        return (View) invokeV.objValue;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.d = new Fragment[2];
            this.e = new String[2];
            ImageListFragment imageListFragment = new ImageListFragment();
            this.f = imageListFragment;
            imageListFragment.W1(this.c);
            this.d[0] = this.f;
            this.e[0] = this.a;
            AlbumImageBrowseFragment albumImageBrowseFragment = new AlbumImageBrowseFragment();
            this.g = albumImageBrowseFragment;
            albumImageBrowseFragment.L1(this.c);
            this.d[1] = this.g;
            this.e[1] = this.b;
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            TbCameraView n = n();
            if (n != null) {
                n.setOnOpenCameraFailedListener(new a(this, n));
                n.m(false);
                n.setVisibility(0);
            }
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment == null || imageListFragment.P1() == null) {
                return;
            }
            this.f.P1().n();
        }
    }

    public void w() {
        ImageListFragment imageListFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (imageListFragment = this.f) == null) {
            return;
        }
        imageListFragment.R1();
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.g;
            if (albumImageBrowseFragment != null) {
                albumImageBrowseFragment.K1(z);
            }
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment != null) {
                imageListFragment.V1(z);
            }
        }
    }

    public void y(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, navigationBar) == null) {
            this.f.X1(navigationBar);
        }
    }

    public void z(e09 e09Var) {
        ImageListFragment imageListFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, e09Var) == null) || (imageListFragment = this.f) == null) {
            return;
        }
        imageListFragment.Y1(e09Var);
    }
}
