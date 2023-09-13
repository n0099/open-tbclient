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
/* loaded from: classes8.dex */
public class xk8 implements IAdBaseAsyncController.a, ImagePagerAdapter.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public List<String> c;
    public v3a d;
    public List<AdvertAppInfo> e;
    public boolean f;
    public n2a g;
    public boolean h;
    public long i;
    public int j;
    public boolean k;
    public Map<String, ImageUrlData> l;
    public TbPageContext<?> m;

    public xk8(List<String> list, String str, String str2, boolean z, boolean z2, TbPageContext<?> tbPageContext, DragImageView.h hVar, @Nullable Map<String, ImageUrlData> map) {
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
            v3a v3aVar = (v3a) i3a.m().i(IAdBaseAsyncController.Type.PIC_PAGE, this);
            this.d = v3aVar;
            if (v3aVar != null) {
                v3aVar.h(tbPageContext, hVar, z);
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
            String str = (String) i39.d(this.c, i);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            boolean z = true;
            if (i != this.c.size() - 1) {
                z = false;
            }
            this.k = z;
            v3a v3aVar = this.d;
            if (v3aVar != null) {
                view2 = v3aVar.b(str, z);
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
            if (d != null && (this.m.getPageActivity() instanceof xi0)) {
                d.s = zi0.b(d.s, (xi0) this.m.getPageActivity(), view2);
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
            e(advertAppInfo, i39.i(this.c), true);
            n2a n2aVar = this.g;
            if (n2aVar != null) {
                n2aVar.a(null);
            }
        }
    }

    public boolean h(int i) {
        InterceptResult invokeI;
        v3a v3aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            String str = (String) i39.d(this.c, i);
            if (TextUtils.isEmpty(str) || (v3aVar = this.d) == null || !v3aVar.f(str)) {
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void m(int i) {
        v3a v3aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            String str = (String) i39.d(this.c, i);
            if (!TextUtils.isEmpty(str) && (v3aVar = this.d) != null) {
                v3aVar.j(str);
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public void c(ViewGroup viewGroup, int i) {
        v3a v3aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i) != null) || i >= this.c.size()) {
            return;
        }
        String str = (String) i39.d(this.c, i);
        if (!TextUtils.isEmpty(str) && (v3aVar = this.d) != null) {
            v3aVar.o(str);
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
            v3a v3aVar = this.d;
            if (v3aVar == null) {
                return 0;
            }
            return v3aVar.getAdCount();
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
        v3a v3aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (v3aVar = this.d) != null) {
            v3aVar.onDestroy();
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
        v3a v3aVar;
        v3a v3aVar2;
        v3a v3aVar3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048580, this, new Object[]{advertAppInfo, Integer.valueOf(i), Boolean.valueOf(z)}) != null) || !this.f) {
            return;
        }
        if (i < 0 && (v3aVar3 = this.d) != null) {
            v3aVar3.k(advertAppInfo);
            return;
        }
        boolean z2 = false;
        int i3 = i39.i(this.c);
        String f = l2a.f(advertAppInfo);
        if (i >= i3) {
            String str = (String) i39.d(this.c, i3 - 1);
            if (this.d != null && (l2a.j(str) || (!z && this.d.n()))) {
                this.d.k(advertAppInfo);
                return;
            } else if (StringUtils.isNotNull(str) && str.startsWith("####mLiveRoomPageProvider")) {
                TiebaStatic.log(new StatisticItem("c15097").param("obj_type", "a008"));
                v3a v3aVar4 = this.d;
                if (v3aVar4 != null) {
                    v3aVar4.k(advertAppInfo);
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
        if (l2a.l(advertAppInfo) && (v3aVar2 = this.d) != null) {
            if (i >= i3) {
                v3aVar2.k(advertAppInfo);
            }
            String str2 = (String) i39.d(this.c, i);
            if (!TextUtils.isEmpty(str2)) {
                this.d.e(str2, advertAppInfo);
                return;
            }
            return;
        }
        i39.b(this.c, f, i);
        String str3 = (String) i39.d(this.c, i);
        if (!TextUtils.isEmpty(str3) && (v3aVar = this.d) != null) {
            v3aVar.e(str3, advertAppInfo);
        }
    }

    public final void f(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, list) == null) && !i39.e(list) && !i39.e(this.c)) {
            Iterator<AdvertAppInfo> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AdvertAppInfo next = it.next();
                if (next != null) {
                    if (d() == o36.a().c() - 1 && o36.a().g()) {
                        if (!i()) {
                            break;
                        } else if (JavaTypesHelper.toInt(next.f, -1) - 1 <= i39.i(this.c)) {
                            g(next);
                            break;
                        }
                    }
                    e(next, JavaTypesHelper.toInt(next.f, -1) - 1, false);
                    it.remove();
                }
            }
            n2a n2aVar = this.g;
            if (n2aVar != null) {
                n2aVar.a(null);
            }
        }
    }

    public final boolean i() {
        InterceptResult invokeV;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            List<String> list = this.c;
            String str = (String) i39.d(list, list.size() - 1);
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

    public void n(@Nullable n2a n2aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, n2aVar) != null) || !this.f) {
            return;
        }
        AdvertAppInfo.w.set(true);
        this.h = false;
        this.g = n2aVar;
        v3a v3aVar = this.d;
        if (v3aVar != null) {
            v3aVar.l();
        }
        kw5 kw5Var = new kw5();
        kw5Var.c = this.a;
        kw5Var.d = this.b;
        v3a v3aVar2 = this.d;
        if (v3aVar2 != null) {
            v3aVar2.g(kw5Var);
        }
    }
}
