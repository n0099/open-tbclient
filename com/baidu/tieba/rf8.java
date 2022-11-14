package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public class rf8 implements wo5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Object> a;
    public bp5 b;
    public dg8 c;
    public kn d;
    public kn e;
    public kn f;
    public kn g;
    public kn h;

    @Override // com.baidu.tieba.wo5
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    @Override // com.baidu.tieba.zo5
    public void b(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
        }
    }

    public rf8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.wo5
    public List<Integer> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(AdvertAppInfo.z.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.w.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.A.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.B.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.C.getId()));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wo5
    public void e(List<vo5> list, String str, String str2, String str3, String str4, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{list, str, str2, str3, str4, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || gj7.e(list)) {
            return;
        }
        Set<xn> a = rh8.a("FRS");
        if (a == null) {
            a = new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (vo5 vo5Var : list) {
            if (vo5Var != null) {
                Object a2 = vo5Var.a();
                for (xn xnVar : a) {
                    if (a2 != null && vo5Var.c() == 3 && (a2 instanceof AdvertAppInfo) && xnVar != null && (xnVar instanceof AdvertAppInfo) && a2.hashCode() == xnVar.hashCode()) {
                        ((AdvertAppInfo) a2).i = ((AdvertAppInfo) xnVar).i;
                    }
                }
                if (a2 != null && vo5Var.c() == 3 && (a2 instanceof AdvertAppInfo)) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) a2;
                    if (advertAppInfo.i == null) {
                        xr4 xr4Var = new xr4();
                        advertAppInfo.i = xr4Var;
                        xr4Var.a = "FRS";
                        String.valueOf(z);
                        xr4 xr4Var2 = advertAppInfo.i;
                        xr4Var2.b = i;
                        xr4Var2.c = str;
                        xr4Var2.d = str2;
                        xr4Var2.e = str3;
                        xr4Var2.f = str4;
                        xr4Var2.g = advertAppInfo.g;
                        xr4Var2.h = false;
                        hashSet.add(advertAppInfo);
                    }
                }
            }
        }
        a.addAll(hashSet);
        rh8.b("FRS", a);
    }

    @Override // com.baidu.tieba.wo5
    public TypeAdapter.ViewHolder g(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        kn knVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, viewGroup, obj)) == null) {
            if (!(obj instanceof AdvertAppInfo)) {
                return null;
            }
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.z) {
                knVar = this.e;
            } else if (type == AdvertAppInfo.w) {
                knVar = this.d;
            } else if (type == AdvertAppInfo.A) {
                knVar = this.f;
            } else if (type == AdvertAppInfo.B) {
                knVar = this.g;
            } else if (type == AdvertAppInfo.C) {
                knVar = this.h;
            } else {
                knVar = null;
            }
            if (knVar == null) {
                return null;
            }
            return knVar.onCreateViewHolder(viewGroup, obj);
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zo5
    /* renamed from: q */
    public void f(bp5 bp5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, bp5Var, str) == null) {
            this.b = bp5Var;
            if (bp5Var != null && (bp5Var.a() instanceof dg8)) {
                this.c = (dg8) this.b.a();
                this.d = new lg8(this.c, AdvertAppInfo.w);
                this.e = new mg8(this.c, AdvertAppInfo.z, str);
                this.f = new mg8(this.c, AdvertAppInfo.A, str);
                this.g = new mg8(this.c, AdvertAppInfo.B, str);
                this.h = new mg8(this.c, AdvertAppInfo.C, str);
            }
        }
    }

    @Override // com.baidu.tieba.wo5
    public void i(List<vo5> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048582, this, list, i) != null) || gj7.e(this.a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                gj7.a(arrayList, (AdvertAppInfo) obj);
            }
        }
        Iterator<vo5> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int i2 = gj7.i(list);
        int i3 = 0;
        int i4 = 0;
        for (vo5 vo5Var : list) {
            if (vo5Var.c() == 1) {
                i4++;
            }
        }
        int i5 = gj7.i(arrayList);
        if (i5 < 1) {
            return;
        }
        int i6 = i2 - i4;
        HashSet hashSet = new HashSet();
        int i7 = 0;
        while (i7 < i5) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) gj7.d(arrayList, i7);
            advertAppInfo.j = "FRS";
            int n = advertAppInfo.n();
            if (n != 0) {
                th8.h(advertAppInfo, i, n);
                if (n != 28 && n != 31) {
                    advertAppInfo.c = -1001;
                }
                i7++;
                i3 = 0;
            }
            if (advertAppInfo.getType() == null) {
                th8.h(advertAppInfo, i, 100);
            } else {
                int e = (xg.e(advertAppInfo.f, i3) + i4) - 1;
                if (hashSet.contains(Integer.valueOf(e))) {
                    th8.h(advertAppInfo, i, 29);
                } else if (e < 0) {
                    th8.h(advertAppInfo, i, 33);
                } else if (e >= i2 && i6 > 3) {
                    th8.i(advertAppInfo, i, 2, e, i2);
                } else {
                    vo5 vo5Var2 = new vo5();
                    vo5Var2.d(advertAppInfo);
                    vo5Var2.e(advertAppInfo.getType().getId());
                    vo5Var2.f(3);
                    if (advertAppInfo.h()) {
                        if (hg8.i(advertAppInfo.p) && ko5.a().p()) {
                            th8.h(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.p) && !TextUtils.isEmpty(advertAppInfo.l)) {
                            hashSet.add(Integer.valueOf(e));
                            if (e < i2) {
                                gj7.b(list, vo5Var2, e);
                            } else if (e == i2) {
                                gj7.a(list, vo5Var2);
                            }
                        }
                    } else if (advertAppInfo.l()) {
                        hashSet.add(Integer.valueOf(e));
                        if (e < i2) {
                            gj7.b(list, vo5Var2, e);
                        } else if (e == i2) {
                            gj7.a(list, vo5Var2);
                        }
                    } else {
                        th8.h(advertAppInfo, i, 21);
                    }
                }
            }
            i7++;
            i3 = 0;
        }
    }

    @Override // com.baidu.tieba.wo5
    public void k(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.a = list;
        }
    }

    @Override // com.baidu.tieba.wo5
    public View m(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        kn knVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (!(obj instanceof AdvertAppInfo)) {
                return null;
            }
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.z) {
                knVar = this.e;
            } else if (type == AdvertAppInfo.w) {
                knVar = this.d;
            } else if (type == AdvertAppInfo.A) {
                knVar = this.f;
            } else if (type == AdvertAppInfo.B) {
                knVar = this.g;
            } else if (type == AdvertAppInfo.C) {
                knVar = this.h;
            } else {
                knVar = null;
            }
            if (knVar == null) {
                return null;
            }
            return knVar.getView(i, view2, viewGroup, advertAppInfo);
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.wo5
    public void n(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) != null) || !(obj instanceof AdvertAppInfo)) {
            return;
        }
        kn knVar = null;
        BdUniqueId type = ((AdvertAppInfo) obj).getType();
        if (type == AdvertAppInfo.z) {
            knVar = this.e;
        } else if (type == AdvertAppInfo.w) {
            knVar = this.d;
        } else if (type == AdvertAppInfo.A) {
            knVar = this.f;
        } else if (type == AdvertAppInfo.B) {
            knVar = this.g;
        } else if (type == AdvertAppInfo.C) {
            knVar = this.h;
        }
        if (knVar != null) {
            knVar.onFillViewHolder(i, viewGroup, viewHolder, obj);
        }
    }

    @Override // com.baidu.tieba.wo5
    public void o(List<vo5> list, List<vo5> list2, boolean z, int i) {
        ArrayList arrayList;
        int i2;
        int i3;
        int e;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048586, this, new Object[]{list, list2, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || gj7.e(this.a)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                gj7.a(arrayList2, (AdvertAppInfo) obj);
            }
        }
        Iterator<vo5> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int i4 = gj7.i(list);
        int i5 = 0;
        int i6 = 0;
        for (vo5 vo5Var : list) {
            if (vo5Var.c() == 1) {
                i6++;
            }
        }
        int i7 = gj7.i(arrayList2);
        if (i7 < 1) {
            return;
        }
        int i8 = 9;
        if (gj7.i(arrayList2) > 1 && (e = (xg.e(((AdvertAppInfo) gj7.d(arrayList2, 1)).f, 0) - xg.e(((AdvertAppInfo) gj7.d(arrayList2, 0)).f, 0)) - 1) > 0) {
            i8 = e;
        }
        int e2 = xg.e(((AdvertAppInfo) gj7.d(arrayList2, 0)).f, 0) - 1;
        int i9 = i4 - i6;
        HashSet hashSet = new HashSet();
        int i10 = 0;
        while (i10 < i7) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) gj7.d(arrayList2, i10);
            advertAppInfo.j = "SMART_FRS";
            int n = advertAppInfo.n();
            if (n != 0) {
                th8.h(advertAppInfo, i, n);
                if (n != 28 && n != 31) {
                    advertAppInfo.c = -1001;
                }
                arrayList = arrayList2;
                i10++;
                arrayList2 = arrayList;
                i5 = 0;
            }
            if (advertAppInfo.getType() == null) {
                th8.h(advertAppInfo, i, 100);
                arrayList = arrayList2;
                i10++;
                arrayList2 = arrayList;
                i5 = 0;
            } else {
                int e3 = xg.e(advertAppInfo.f, i5);
                int i11 = (e3 + i6) - 1;
                if (i11 >= 0 && !hashSet.contains(Integer.valueOf(i11)) && i11 <= i4) {
                    if (e3 > (i9 - i8) + e2 && z) {
                        if (!gj7.e(list2)) {
                            int i12 = gj7.i(list2);
                            int i13 = (i8 - ((i9 - e3) + 1)) - 1;
                            int i14 = 0;
                            while (i14 < i12 && i14 < i13) {
                                arrayList = arrayList2;
                                if (((vo5) gj7.d(list2, i14)).a() instanceof AdvertAppInfo) {
                                    i3 = 0;
                                    break;
                                } else {
                                    i14++;
                                    arrayList2 = arrayList;
                                }
                            }
                            arrayList = arrayList2;
                            i3 = 1;
                            i2 = i3 ^ 1;
                        } else {
                            arrayList = arrayList2;
                            if (ko5.a().o()) {
                                i2 = 36;
                            }
                        }
                    } else {
                        arrayList = arrayList2;
                    }
                    i2 = 0;
                } else {
                    arrayList = arrayList2;
                    if (i11 > i4) {
                        th8.i(advertAppInfo, i, 2, i11, i4);
                        i10++;
                        arrayList2 = arrayList;
                        i5 = 0;
                    } else if (i11 < 0) {
                        i2 = 33;
                    } else {
                        i2 = 29;
                    }
                }
                if (i2 != 0) {
                    th8.h(advertAppInfo, i, i2);
                    i10++;
                    arrayList2 = arrayList;
                    i5 = 0;
                } else {
                    vo5 vo5Var2 = new vo5();
                    vo5Var2.d(advertAppInfo);
                    vo5Var2.e(advertAppInfo.getType().getId());
                    vo5Var2.f(3);
                    if (advertAppInfo.h()) {
                        if (hg8.i(advertAppInfo.p) && ko5.a().p()) {
                            th8.h(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.p) && !TextUtils.isEmpty(advertAppInfo.l)) {
                            hashSet.add(Integer.valueOf(i11));
                            if (i11 < i4) {
                                gj7.b(list, vo5Var2, i11);
                            } else if (i11 == i4) {
                                gj7.a(list, vo5Var2);
                            }
                        }
                    } else if (advertAppInfo.l()) {
                        hashSet.add(Integer.valueOf(i11));
                        if (i11 < i4) {
                            gj7.b(list, vo5Var2, i11);
                        } else if (i11 == i4) {
                            gj7.a(list, vo5Var2);
                        }
                    }
                    i10++;
                    arrayList2 = arrayList;
                    i5 = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.wo5
    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            kn knVar = this.e;
            if (knVar instanceof mg8) {
                ((mg8) knVar).K(str);
            }
            kn knVar2 = this.f;
            if (knVar2 instanceof mg8) {
                ((mg8) knVar2).K(str);
            }
            kn knVar3 = this.g;
            if (knVar3 instanceof mg8) {
                ((mg8) knVar3).K(str);
            }
            kn knVar4 = this.h;
            if (knVar4 instanceof mg8) {
                ((mg8) knVar4).K(str);
            }
        }
    }
}
