package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.image.ImageViewerActivity;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class re7 implements IAdBaseAsyncController.a, ImagePagerAdapter.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public List<String> c;
    public zd8 d;
    public List<AdvertAppInfo> e;
    public boolean f;
    public sc8 g;
    public boolean h;
    public long i;
    public int j;
    public boolean k;
    public Map<String, ImageUrlData> l;
    public TbPageContext<ImageViewerActivity> m;

    public re7(List<String> list, String str, String str2, boolean z, boolean z2, TbPageContext<ImageViewerActivity> tbPageContext, DragImageView.h hVar, @Nullable Map<String, ImageUrlData> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), tbPageContext, hVar, map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = false;
        this.c = list;
        this.a = str;
        this.b = str2;
        this.f = z2;
        this.m = tbPageContext;
        try {
            zd8 zd8Var = (zd8) md8.l().h(IAdBaseAsyncController.Type.PIC_PAGE, this);
            this.d = zd8Var;
            zd8Var.h(tbPageContext, hVar, z);
        } catch (ClassCastException e) {
            if (np4.e()) {
                throw new RuntimeException(e);
            }
        }
        this.l = map;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i)) == null) {
            if (i >= this.c.size()) {
                return null;
            }
            String str = (String) mg7.d(this.c, i);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            boolean z = i == this.c.size() - 1;
            this.k = z;
            View b = this.d.b(str, z);
            if (b == null) {
                return null;
            }
            if (b.getParent() != null && (b.getParent() instanceof ViewGroup)) {
                ((ViewGroup) b.getParent()).removeView(b);
            }
            viewGroup.addView(b);
            AdvertAppInfo d = this.d.d(str);
            if (d != null && (this.m.getPageActivity() instanceof qh0)) {
                d.r = sh0.b(d.r, (qh0) this.m.getPageActivity(), b);
            }
            return b;
        }
        return (View) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.recapp.async.IAdBaseAsyncController.a
    public void b(@Nullable List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.e = list;
            if (this.h) {
                f(list);
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public void c(ViewGroup viewGroup, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i) == null) || i >= this.c.size()) {
            return;
        }
        String str = (String) mg7.d(this.c, i);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.d.o(str);
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d.getAdCount() : invokeV.intValue;
    }

    public final void e(@NonNull AdvertAppInfo advertAppInfo, int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{advertAppInfo, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && this.f) {
            if (i < 0) {
                this.d.k(advertAppInfo);
                return;
            }
            boolean z2 = false;
            int i2 = mg7.i(this.c);
            String f = qc8.f(advertAppInfo);
            if (i >= i2) {
                if (!qc8.j((String) mg7.d(this.c, i2 - 1)) && (z || !this.d.n())) {
                    this.k = true;
                    i = i2;
                    z2 = true;
                } else {
                    this.d.k(advertAppInfo);
                    return;
                }
            }
            advertAppInfo.position = z2 ? this.j + d() : (int) (i + this.i);
            if (qc8.l(advertAppInfo)) {
                if (i >= i2) {
                    this.d.k(advertAppInfo);
                }
                String str = (String) mg7.d(this.c, i);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.d.e(str, advertAppInfo);
                return;
            }
            mg7.b(this.c, f, i);
            String str2 = (String) mg7.d(this.c, i);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.d.e(str2, advertAppInfo);
        }
    }

    public final void f(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || mg7.e(list) || mg7.e(this.c)) {
            return;
        }
        Iterator<AdvertAppInfo> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdvertAppInfo next = it.next();
            if (next != null) {
                if (d() == gm5.a().c() - 1 && gm5.a().g()) {
                    if (!i()) {
                        break;
                    } else if (dh.e(next.f, -1) - 1 <= mg7.i(this.c)) {
                        g(next);
                        break;
                    }
                }
                e(next, dh.e(next.f, -1) - 1, false);
                it.remove();
            }
        }
        sc8 sc8Var = this.g;
        if (sc8Var != null) {
            sc8Var.a(null);
        }
    }

    public void g(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, advertAppInfo) == null) {
            e(advertAppInfo, mg7.i(this.c), true);
            sc8 sc8Var = this.g;
            if (sc8Var != null) {
                sc8Var.a(null);
            }
        }
    }

    public boolean h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            String str = (String) mg7.d(this.c, i);
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.d.f(str);
        }
        return invokeI.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            List<String> list = this.c;
            String str = (String) mg7.d(list, list.size() - 1);
            Map<String, ImageUrlData> map = this.l;
            ImageUrlData imageUrlData = (map == null || str == null) ? null : map.get(str);
            return imageUrlData != null && imageUrlData.overAllIndex == ((long) this.j);
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.d.onDestroy();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.h = true;
            f(this.e);
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            String str = (String) mg7.d(this.c, i);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.d.j(str);
        }
    }

    public void n(@Nullable sc8 sc8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, sc8Var) == null) && this.f) {
            AdvertAppInfo.v.set(true);
            this.h = false;
            this.g = sc8Var;
            this.d.l();
            hg5 hg5Var = new hg5();
            hg5Var.c = this.a;
            hg5Var.d = this.b;
            this.d.g(hg5Var);
        }
    }

    public void o(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            this.i = j - 1;
            this.j = i;
        }
    }
}
