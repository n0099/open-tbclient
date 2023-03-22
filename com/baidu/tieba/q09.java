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
public class q09 implements uv5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Object> a;
    public zv5 b;
    public c19 c;
    public tm d;
    public tm e;
    public tm f;
    public tm g;
    public tm h;

    @Override // com.baidu.tieba.uv5
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    @Override // com.baidu.tieba.xv5
    public void b(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
        }
    }

    public q09() {
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

    @Override // com.baidu.tieba.uv5
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

    @Override // com.baidu.tieba.uv5
    public void e(List<tv5> list, String str, String str2, String str3, String str4, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{list, str, str2, str3, str4, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || v38.e(list)) {
            return;
        }
        Set<gn> a = q29.a("FRS");
        if (a == null) {
            a = new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (tv5 tv5Var : list) {
            if (tv5Var != null) {
                Object a2 = tv5Var.a();
                for (gn gnVar : a) {
                    if (a2 != null && tv5Var.c() == 3 && (a2 instanceof AdvertAppInfo) && gnVar != null && (gnVar instanceof AdvertAppInfo) && a2.hashCode() == gnVar.hashCode()) {
                        ((AdvertAppInfo) a2).i = ((AdvertAppInfo) gnVar).i;
                    }
                }
                if (a2 != null && tv5Var.c() == 3 && (a2 instanceof AdvertAppInfo)) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) a2;
                    if (advertAppInfo.i == null) {
                        mw4 mw4Var = new mw4();
                        advertAppInfo.i = mw4Var;
                        mw4Var.a = "FRS";
                        String.valueOf(z);
                        mw4 mw4Var2 = advertAppInfo.i;
                        mw4Var2.b = i;
                        mw4Var2.c = str;
                        mw4Var2.d = str2;
                        mw4Var2.e = str3;
                        mw4Var2.f = str4;
                        mw4Var2.g = advertAppInfo.g;
                        mw4Var2.h = false;
                        hashSet.add(advertAppInfo);
                    }
                }
            }
        }
        a.addAll(hashSet);
        q29.b("FRS", a);
    }

    @Override // com.baidu.tieba.uv5
    public TypeAdapter.ViewHolder g(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        tm tmVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, viewGroup, obj)) == null) {
            if (!(obj instanceof AdvertAppInfo)) {
                return null;
            }
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.z) {
                tmVar = this.e;
            } else if (type == AdvertAppInfo.w) {
                tmVar = this.d;
            } else if (type == AdvertAppInfo.A) {
                tmVar = this.f;
            } else if (type == AdvertAppInfo.B) {
                tmVar = this.g;
            } else if (type == AdvertAppInfo.C) {
                tmVar = this.h;
            } else {
                tmVar = null;
            }
            if (tmVar == null) {
                return null;
            }
            return tmVar.onCreateViewHolder(viewGroup, obj);
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.xv5
    /* renamed from: q */
    public void f(zv5 zv5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, zv5Var, str) == null) {
            this.b = zv5Var;
            if (zv5Var != null && (zv5Var.a() instanceof c19)) {
                this.c = (c19) this.b.a();
                this.d = new k19(this.c, AdvertAppInfo.w);
                this.e = new l19(this.c, AdvertAppInfo.z, str);
                this.f = new l19(this.c, AdvertAppInfo.A, str);
                this.g = new l19(this.c, AdvertAppInfo.B, str);
                this.h = new l19(this.c, AdvertAppInfo.C, str);
            }
        }
    }

    @Override // com.baidu.tieba.uv5
    public void i(List<tv5> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048582, this, list, i) != null) || v38.e(this.a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                v38.a(arrayList, (AdvertAppInfo) obj);
            }
        }
        Iterator<tv5> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int i2 = v38.i(list);
        int i3 = 0;
        int i4 = 0;
        for (tv5 tv5Var : list) {
            if (tv5Var.c() == 1) {
                i4++;
            }
        }
        int i5 = v38.i(arrayList);
        if (i5 < 1) {
            return;
        }
        int i6 = i2 - i4;
        HashSet hashSet = new HashSet();
        int i7 = 0;
        while (i7 < i5) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) v38.d(arrayList, i7);
            advertAppInfo.j = "FRS";
            int k = advertAppInfo.k();
            if (k != 0) {
                s29.h(advertAppInfo, i, k);
                if (k != 28 && k != 31) {
                    advertAppInfo.c = -1001;
                }
                i7++;
                i3 = 0;
            }
            if (advertAppInfo.getType() == null) {
                s29.h(advertAppInfo, i, 100);
            } else {
                int e = (gg.e(advertAppInfo.f, i3) + i4) - 1;
                if (hashSet.contains(Integer.valueOf(e))) {
                    s29.h(advertAppInfo, i, 29);
                } else if (e < 0) {
                    s29.h(advertAppInfo, i, 33);
                } else if (e >= i2 && i6 > 3) {
                    s29.i(advertAppInfo, i, 2, e, i2);
                } else {
                    tv5 tv5Var2 = new tv5();
                    tv5Var2.d(advertAppInfo);
                    tv5Var2.e(advertAppInfo.getType().getId());
                    tv5Var2.f(3);
                    if (advertAppInfo.g()) {
                        if (g19.i(advertAppInfo.p) && iv5.a().p()) {
                            s29.h(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.p) && !TextUtils.isEmpty(advertAppInfo.l)) {
                            hashSet.add(Integer.valueOf(e));
                            if (e < i2) {
                                v38.b(list, tv5Var2, e);
                            } else if (e == i2) {
                                v38.a(list, tv5Var2);
                            }
                        }
                    } else if (advertAppInfo.i()) {
                        hashSet.add(Integer.valueOf(e));
                        if (e < i2) {
                            v38.b(list, tv5Var2, e);
                        } else if (e == i2) {
                            v38.a(list, tv5Var2);
                        }
                    } else {
                        s29.h(advertAppInfo, i, 21);
                    }
                }
            }
            i7++;
            i3 = 0;
        }
    }

    @Override // com.baidu.tieba.uv5
    public void k(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.a = list;
        }
    }

    @Override // com.baidu.tieba.uv5
    public View m(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        tm tmVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (!(obj instanceof AdvertAppInfo)) {
                return null;
            }
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.z) {
                tmVar = this.e;
            } else if (type == AdvertAppInfo.w) {
                tmVar = this.d;
            } else if (type == AdvertAppInfo.A) {
                tmVar = this.f;
            } else if (type == AdvertAppInfo.B) {
                tmVar = this.g;
            } else if (type == AdvertAppInfo.C) {
                tmVar = this.h;
            } else {
                tmVar = null;
            }
            if (tmVar == null) {
                return null;
            }
            return tmVar.getView(i, view2, viewGroup, advertAppInfo);
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.uv5
    public void n(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) != null) || !(obj instanceof AdvertAppInfo)) {
            return;
        }
        tm tmVar = null;
        BdUniqueId type = ((AdvertAppInfo) obj).getType();
        if (type == AdvertAppInfo.z) {
            tmVar = this.e;
        } else if (type == AdvertAppInfo.w) {
            tmVar = this.d;
        } else if (type == AdvertAppInfo.A) {
            tmVar = this.f;
        } else if (type == AdvertAppInfo.B) {
            tmVar = this.g;
        } else if (type == AdvertAppInfo.C) {
            tmVar = this.h;
        }
        if (tmVar != null) {
            tmVar.onFillViewHolder(i, viewGroup, viewHolder, obj);
        }
    }

    @Override // com.baidu.tieba.uv5
    public void o(List<tv5> list, List<tv5> list2, boolean z, int i) {
        ArrayList arrayList;
        int i2;
        int i3;
        int e;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048586, this, new Object[]{list, list2, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || v38.e(this.a)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                v38.a(arrayList2, (AdvertAppInfo) obj);
            }
        }
        Iterator<tv5> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int i4 = v38.i(list);
        int i5 = 0;
        int i6 = 0;
        for (tv5 tv5Var : list) {
            if (tv5Var.c() == 1) {
                i6++;
            }
        }
        int i7 = v38.i(arrayList2);
        if (i7 < 1) {
            return;
        }
        int i8 = 9;
        if (v38.i(arrayList2) > 1 && (e = (gg.e(((AdvertAppInfo) v38.d(arrayList2, 1)).f, 0) - gg.e(((AdvertAppInfo) v38.d(arrayList2, 0)).f, 0)) - 1) > 0) {
            i8 = e;
        }
        int e2 = gg.e(((AdvertAppInfo) v38.d(arrayList2, 0)).f, 0) - 1;
        int i9 = i4 - i6;
        HashSet hashSet = new HashSet();
        int i10 = 0;
        while (i10 < i7) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) v38.d(arrayList2, i10);
            advertAppInfo.j = "SMART_FRS";
            int k = advertAppInfo.k();
            if (k != 0) {
                s29.h(advertAppInfo, i, k);
                if (k != 28 && k != 31) {
                    advertAppInfo.c = -1001;
                }
                arrayList = arrayList2;
                i10++;
                arrayList2 = arrayList;
                i5 = 0;
            }
            if (advertAppInfo.getType() == null) {
                s29.h(advertAppInfo, i, 100);
                arrayList = arrayList2;
                i10++;
                arrayList2 = arrayList;
                i5 = 0;
            } else {
                int e3 = gg.e(advertAppInfo.f, i5);
                int i11 = (e3 + i6) - 1;
                if (i11 >= 0 && !hashSet.contains(Integer.valueOf(i11)) && i11 <= i4) {
                    if (e3 > (i9 - i8) + e2 && z) {
                        if (!v38.e(list2)) {
                            int i12 = v38.i(list2);
                            int i13 = (i8 - ((i9 - e3) + 1)) - 1;
                            int i14 = 0;
                            while (i14 < i12 && i14 < i13) {
                                arrayList = arrayList2;
                                if (((tv5) v38.d(list2, i14)).a() instanceof AdvertAppInfo) {
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
                            if (iv5.a().o()) {
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
                        s29.i(advertAppInfo, i, 2, i11, i4);
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
                    s29.h(advertAppInfo, i, i2);
                    i10++;
                    arrayList2 = arrayList;
                    i5 = 0;
                } else {
                    tv5 tv5Var2 = new tv5();
                    tv5Var2.d(advertAppInfo);
                    tv5Var2.e(advertAppInfo.getType().getId());
                    tv5Var2.f(3);
                    if (advertAppInfo.g()) {
                        if (g19.i(advertAppInfo.p) && iv5.a().p()) {
                            s29.h(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.p) && !TextUtils.isEmpty(advertAppInfo.l)) {
                            hashSet.add(Integer.valueOf(i11));
                            if (i11 < i4) {
                                v38.b(list, tv5Var2, i11);
                            } else if (i11 == i4) {
                                v38.a(list, tv5Var2);
                            }
                        }
                    } else if (advertAppInfo.i()) {
                        hashSet.add(Integer.valueOf(i11));
                        if (i11 < i4) {
                            v38.b(list, tv5Var2, i11);
                        } else if (i11 == i4) {
                            v38.a(list, tv5Var2);
                        }
                    }
                    i10++;
                    arrayList2 = arrayList;
                    i5 = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.uv5
    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            tm tmVar = this.e;
            if (tmVar instanceof l19) {
                ((l19) tmVar).M(str);
            }
            tm tmVar2 = this.f;
            if (tmVar2 instanceof l19) {
                ((l19) tmVar2).M(str);
            }
            tm tmVar3 = this.g;
            if (tmVar3 instanceof l19) {
                ((l19) tmVar3).M(str);
            }
            tm tmVar4 = this.h;
            if (tmVar4 instanceof l19) {
                ((l19) tmVar4).M(str);
            }
        }
    }
}
