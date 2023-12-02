package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class y09 implements IAdBaseAsyncController.a, ImagePagerAdapter.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public List<String> c;
    public iia d;
    public List<AdvertAppInfo> e;
    public boolean f;
    public aha g;
    public boolean h;
    public long i;
    public int j;
    public boolean k;
    public Map<String, ImageUrlData> l;
    public TbPageContext<?> m;

    public y09(List<String> list, String str, String str2, boolean z, boolean z2, TbPageContext<?> tbPageContext, DragImageView.h hVar, @Nullable Map<String, ImageUrlData> map) {
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
            iia iiaVar = (iia) vha.m().i(IAdBaseAsyncController.Type.PIC_PAGE, this);
            this.d = iiaVar;
            if (iiaVar != null) {
                iiaVar.h(tbPageContext, hVar, z);
            }
        } catch (ClassCastException e) {
            if (GlobalBuildConfig.isDebug()) {
                throw new RuntimeException(e);
            }
        }
        this.l = map;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i)) == null) {
            if (i >= this.c.size()) {
                return null;
            }
            String str = (String) dg9.d(this.c, i);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            boolean z = true;
            if (i != this.c.size() - 1) {
                z = false;
            }
            this.k = z;
            iia iiaVar = this.d;
            if (iiaVar != null) {
                view2 = iiaVar.b(str, z);
            } else {
                view2 = null;
            }
            if (view2 == null) {
                return null;
            }
            if (view2.getParent() != null && (view2.getParent() instanceof ViewGroup)) {
                ((ViewGroup) view2.getParent()).removeView(view2);
            }
            viewGroup.addView(view2);
            AdvertAppInfo d = this.d.d(str);
            if (d != null && (this.m.getPageActivity() instanceof le0)) {
                d.s = ne0.b(d.s, (le0) this.m.getPageActivity(), view2);
            }
            return view2;
        }
        return (View) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.recapp.async.IAdBaseAsyncController.a
    public void b(@Nullable List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.e = list;
            if (!this.h) {
                return;
            }
            f(list);
        }
    }

    public void g(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, advertAppInfo) == null) {
            e(advertAppInfo, dg9.i(this.c), true);
            aha ahaVar = this.g;
            if (ahaVar != null) {
                ahaVar.a(null);
            }
        }
    }

    public boolean h(int i) {
        InterceptResult invokeI;
        iia iiaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            String str = (String) dg9.d(this.c, i);
            if (TextUtils.isEmpty(str) || (iiaVar = this.d) == null || !iiaVar.f(str)) {
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void m(int i) {
        iia iiaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            String str = (String) dg9.d(this.c, i);
            if (!TextUtils.isEmpty(str) && (iiaVar = this.d) != null) {
                iiaVar.j(str);
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public void c(ViewGroup viewGroup, int i) {
        iia iiaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i) != null) || i >= this.c.size()) {
            return;
        }
        String str = (String) dg9.d(this.c, i);
        if (!TextUtils.isEmpty(str) && (iiaVar = this.d) != null) {
            iiaVar.o(str);
        }
    }

    public void o(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            this.i = j - 1;
            this.j = i;
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            iia iiaVar = this.d;
            if (iiaVar == null) {
                return 0;
            }
            return iiaVar.getAdCount();
        }
        return invokeV.intValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        iia iiaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (iiaVar = this.d) != null) {
            iiaVar.onDestroy();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.h = true;
            f(this.e);
        }
    }

    public final void e(@NonNull AdvertAppInfo advertAppInfo, int i, boolean z) {
        int i2;
        iia iiaVar;
        iia iiaVar2;
        iia iiaVar3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048580, this, new Object[]{advertAppInfo, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || !this.f) {
            return;
        }
        if (i < 0 && (iiaVar3 = this.d) != null) {
            iiaVar3.k(advertAppInfo);
            return;
        }
        boolean z2 = false;
        int i3 = dg9.i(this.c);
        String f = yga.f(advertAppInfo);
        if (i >= i3) {
            String str = (String) dg9.d(this.c, i3 - 1);
            if (this.d != null && (yga.j(str) || (!z && this.d.n()))) {
                this.d.k(advertAppInfo);
                return;
            } else if (StringUtils.isNotNull(str) && str.startsWith("####mLiveRoomPageProvider")) {
                TiebaStatic.log(new StatisticItem("c15097").param("obj_type", "a008"));
                iia iiaVar4 = this.d;
                if (iiaVar4 != null) {
                    iiaVar4.k(advertAppInfo);
                    return;
                }
                return;
            } else {
                this.k = true;
                i = i3;
                z2 = true;
            }
        }
        if (z2) {
            i2 = this.j + d();
        } else {
            i2 = (int) (i + this.i);
        }
        advertAppInfo.position = i2;
        if (yga.l(advertAppInfo) && (iiaVar2 = this.d) != null) {
            if (i >= i3) {
                iiaVar2.k(advertAppInfo);
            }
            String str2 = (String) dg9.d(this.c, i);
            if (!TextUtils.isEmpty(str2)) {
                this.d.e(str2, advertAppInfo);
                return;
            }
            return;
        }
        dg9.b(this.c, f, i);
        String str3 = (String) dg9.d(this.c, i);
        if (!TextUtils.isEmpty(str3) && (iiaVar = this.d) != null) {
            iiaVar.e(str3, advertAppInfo);
        }
    }

    public final void f(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            if (!dg9.e(list) && !dg9.e(this.c)) {
                Iterator<AdvertAppInfo> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    AdvertAppInfo next = it.next();
                    if (next != null) {
                        if (d() == e06.a().c() - 1 && e06.a().g()) {
                            if (!i()) {
                                break;
                            } else if (JavaTypesHelper.toInt(next.f, -1) - 1 <= dg9.i(this.c)) {
                                g(next);
                                break;
                            }
                        }
                        e(next, JavaTypesHelper.toInt(next.f, -1) - 1, false);
                        it.remove();
                    }
                }
                aha ahaVar = this.g;
                if (ahaVar != null) {
                    ahaVar.a(null);
                    return;
                }
                return;
            }
            aha ahaVar2 = this.g;
            if (ahaVar2 != null) {
                ahaVar2.a(null);
            }
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            List<String> list = this.c;
            String str = (String) dg9.d(list, list.size() - 1);
            Map<String, ImageUrlData> map = this.l;
            if (map != null && str != null) {
                imageUrlData = map.get(str);
            } else {
                imageUrlData = null;
            }
            if (imageUrlData != null && imageUrlData.overAllIndex == this.j) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void n(@Nullable aha ahaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, ahaVar) != null) || !this.f) {
            return;
        }
        AdvertAppInfo.x.set(true);
        this.h = false;
        this.g = ahaVar;
        iia iiaVar = this.d;
        if (iiaVar != null) {
            iiaVar.l();
        }
        zs5 zs5Var = new zs5();
        zs5Var.c = this.a;
        zs5Var.d = this.b;
        iia iiaVar2 = this.d;
        if (iiaVar2 != null) {
            iiaVar2.g(zs5Var);
        }
    }
}
