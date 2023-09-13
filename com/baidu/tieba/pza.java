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
/* loaded from: classes7.dex */
public class pza extends BdBaseView<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public tza c;
    public Fragment[] d;
    public String[] e;
    public ImageListFragment f;
    public AlbumImageBrowseFragment g;

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements TbCameraView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCameraView a;

        public a(pza pzaVar, TbCameraView tbCameraView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pzaVar, tbCameraView};
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
    public pza(TbPageContext tbPageContext, tza tzaVar) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, tzaVar};
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
        this.c = tzaVar;
    }

    public Fragment C(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i >= 0 && i <= 1) {
                return this.d[i];
            }
            return null;
        }
        return (Fragment) invokeI.objValue;
    }

    public String D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i >= 0 && i <= 1) {
                return this.e[i];
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.g;
            if (albumImageBrowseFragment != null) {
                albumImageBrowseFragment.o2(z);
            }
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment != null) {
                imageListFragment.D2(z);
            }
        }
    }

    public void L(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, navigationBar) == null) {
            this.f.F2(navigationBar);
        }
    }

    public void M(yza yzaVar) {
        ImageListFragment imageListFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, yzaVar) == null) && (imageListFragment = this.f) != null) {
            imageListFragment.G2(yzaVar);
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
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

    public ImageListFragment E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (ImageListFragment) invokeV.objValue;
    }

    public View F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.y2();
        }
        return (View) invokeV.objValue;
    }

    public View G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.g;
            if (albumImageBrowseFragment == null) {
                return null;
            }
            return albumImageBrowseFragment.k2();
        }
        return (View) invokeV.objValue;
    }

    public void J() {
        ImageListFragment imageListFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (imageListFragment = this.f) != null) {
            imageListFragment.z2();
        }
    }

    public void N() {
        TbCameraView z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (z = z()) != null) {
            z.p();
            z.setVisibility(4);
        }
    }

    public View t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.g;
            if (albumImageBrowseFragment == null) {
                return null;
            }
            return albumImageBrowseFragment.i2();
        }
        return (View) invokeV.objValue;
    }

    public View u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.u2();
        }
        return (View) invokeV.objValue;
    }

    public View x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            AlbumImageBrowseFragment albumImageBrowseFragment = this.g;
            if (albumImageBrowseFragment == null) {
                return null;
            }
            return albumImageBrowseFragment.j2();
        }
        return (View) invokeV.objValue;
    }

    public View y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.v2();
        }
        return (View) invokeV.objValue;
    }

    public TbCameraView z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment == null) {
                return null;
            }
            return imageListFragment.w2();
        }
        return (TbCameraView) invokeV.objValue;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.d = new Fragment[2];
            this.e = new String[2];
            ImageListFragment imageListFragment = new ImageListFragment();
            this.f = imageListFragment;
            imageListFragment.E2(this.c);
            this.d[0] = this.f;
            this.e[0] = this.a;
            AlbumImageBrowseFragment albumImageBrowseFragment = new AlbumImageBrowseFragment();
            this.g = albumImageBrowseFragment;
            albumImageBrowseFragment.p2(this.c);
            this.d[1] = this.g;
            this.e[1] = this.b;
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            TbCameraView z = z();
            if (z != null) {
                z.setOnOpenCameraFailedListener(new a(this, z));
                z.n(false);
                z.setVisibility(0);
            }
            ImageListFragment imageListFragment = this.f;
            if (imageListFragment != null && imageListFragment.x2() != null) {
                this.f.x2().n();
            }
        }
    }
}
