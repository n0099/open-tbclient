package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
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
public class kxa extends BdBaseView<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public oxa c;
    public Fragment[] d;
    public String[] e;
    public ImageListFragment f;
    public AlbumImageBrowseFragment g;

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements TbCameraView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCameraView a;

        public a(kxa kxaVar, TbCameraView tbCameraView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kxaVar, tbCameraView};
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
    public kxa(TbPageContext tbPageContext, oxa oxaVar) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, oxaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "tag_image";
        this.b = "tag_b_image";
        this.c = oxaVar;
    }

    public TbCameraView A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.u2();
        }
        return (TbCameraView) invokeV.objValue;
    }

    public ImageListFragment F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (ImageListFragment) invokeV.objValue;
    }

    public View G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.w2();
        }
        return (View) invokeV.objValue;
    }

    public View H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.g;
            if (albumImageBrowseFragment == null) {
                return null;
            }
            return albumImageBrowseFragment.i2();
        }
        return (View) invokeV.objValue;
    }

    public void K() {
        ImageListFragment imageListFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (imageListFragment = this.f) != null) {
            imageListFragment.x2();
        }
    }

    public void O() {
        TbCameraView A;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (A = A()) != null) {
            A.p();
            A.setVisibility(4);
        }
    }

    public View u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.g;
            if (albumImageBrowseFragment == null) {
                return null;
            }
            return albumImageBrowseFragment.g2();
        }
        return (View) invokeV.objValue;
    }

    public View x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.s2();
        }
        return (View) invokeV.objValue;
    }

    public View y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.g;
            if (albumImageBrowseFragment == null) {
                return null;
            }
            return albumImageBrowseFragment.h2();
        }
        return (View) invokeV.objValue;
    }

    public View z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.t2();
        }
        return (View) invokeV.objValue;
    }

    public Fragment D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i >= 0 && i <= 1) {
                return this.d[i];
            }
            return null;
        }
        return (Fragment) invokeI.objValue;
    }

    public String E(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i >= 0 && i <= 1) {
                return this.e[i];
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.g;
            if (albumImageBrowseFragment != null) {
                albumImageBrowseFragment.m2(z);
            }
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment != null) {
                imageListFragment.B2(z);
            }
        }
    }

    public void M(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, navigationBar) == null) {
            this.f.D2(navigationBar);
        }
    }

    public void N(txa txaVar) {
        ImageListFragment imageListFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, txaVar) == null) && (imageListFragment = this.f) != null) {
            imageListFragment.E2(txaVar);
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
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

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.d = new Fragment[2];
            this.e = new String[2];
            ImageListFragment imageListFragment = new ImageListFragment();
            this.f = imageListFragment;
            imageListFragment.C2(this.c);
            this.d[0] = this.f;
            this.e[0] = this.a;
            AlbumImageBrowseFragment albumImageBrowseFragment = new AlbumImageBrowseFragment();
            this.g = albumImageBrowseFragment;
            albumImageBrowseFragment.n2(this.c);
            this.d[1] = this.g;
            this.e[1] = this.b;
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            TbCameraView A = A();
            if (A != null) {
                A.setOnOpenCameraFailedListener(new a(this, A));
                A.n(false);
                A.setVisibility(0);
            }
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment != null && imageListFragment.v2() != null) {
                this.f.v2().n();
            }
        }
    }
}
