package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.JavaTypesHelper;
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
/* loaded from: classes7.dex */
public class s2a implements z36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Object> a;
    public e46 b;
    public e3a c;
    public pm d;
    public pm e;
    public pm f;
    public pm g;
    public pm h;

    @Override // com.baidu.tieba.z36
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    @Override // com.baidu.tieba.c46
    public void b(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
        }
    }

    public s2a() {
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

    @Override // com.baidu.tieba.z36
    public List<Integer> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(AdvertAppInfo.A.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.x.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.B.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.C.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.D.getId()));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z36
    public void e(List<y36> list, String str, String str2, String str3, String str4, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{list, str, str2, str3, str4, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || i39.e(list)) {
            return;
        }
        Set<cn> a = v4a.a("FRS");
        if (a == null) {
            a = new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (y36 y36Var : list) {
            if (y36Var != null) {
                Object a2 = y36Var.a();
                for (cn cnVar : a) {
                    if (a2 != null && y36Var.c() == 3 && (a2 instanceof AdvertAppInfo) && cnVar != null && (cnVar instanceof AdvertAppInfo) && a2.hashCode() == cnVar.hashCode()) {
                        ((AdvertAppInfo) a2).i = ((AdvertAppInfo) cnVar).i;
                    }
                }
                if (a2 != null && y36Var.c() == 3 && (a2 instanceof AdvertAppInfo)) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) a2;
                    if (advertAppInfo.i == null) {
                        g15 g15Var = new g15();
                        advertAppInfo.i = g15Var;
                        g15Var.a = "FRS";
                        String.valueOf(z);
                        g15 g15Var2 = advertAppInfo.i;
                        g15Var2.b = i;
                        g15Var2.c = str;
                        g15Var2.d = str2;
                        g15Var2.e = str3;
                        g15Var2.f = str4;
                        g15Var2.g = advertAppInfo.g;
                        g15Var2.h = false;
                        hashSet.add(advertAppInfo);
                    }
                }
            }
        }
        a.addAll(hashSet);
        v4a.b("FRS", a);
    }

    @Override // com.baidu.tieba.z36
    public TypeAdapter.ViewHolder g(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        pm pmVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, viewGroup, obj)) == null) {
            if (!(obj instanceof AdvertAppInfo)) {
                return null;
            }
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.A) {
                pmVar = this.e;
            } else if (type == AdvertAppInfo.x) {
                pmVar = this.d;
            } else if (type == AdvertAppInfo.B) {
                pmVar = this.f;
            } else if (type == AdvertAppInfo.C) {
                pmVar = this.g;
            } else if (type == AdvertAppInfo.D) {
                pmVar = this.h;
            } else {
                pmVar = null;
            }
            if (pmVar == null) {
                return null;
            }
            return pmVar.onCreateViewHolder(viewGroup, obj);
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.c46
    /* renamed from: q */
    public void f(e46 e46Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, e46Var, str) == null) {
            this.b = e46Var;
            if (e46Var != null && (e46Var.a() instanceof e3a)) {
                this.c = (e3a) this.b.a();
                this.d = new n3a(this.c, AdvertAppInfo.x);
                this.e = new o3a(this.c, AdvertAppInfo.A, str);
                this.f = new o3a(this.c, AdvertAppInfo.B, str);
                this.g = new o3a(this.c, AdvertAppInfo.C, str);
                this.h = new o3a(this.c, AdvertAppInfo.D, str);
            }
        }
    }

    @Override // com.baidu.tieba.z36
    public void i(List<y36> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048582, this, list, i) != null) || i39.e(this.a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                i39.a(arrayList, (AdvertAppInfo) obj);
            }
        }
        Iterator<y36> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int i2 = i39.i(list);
        int i3 = 0;
        int i4 = 0;
        for (y36 y36Var : list) {
            if (y36Var.c() == 1) {
                i4++;
            }
        }
        int i5 = i39.i(arrayList);
        if (i5 < 1) {
            return;
        }
        int i6 = i2 - i4;
        HashSet hashSet = new HashSet();
        int i7 = 0;
        while (i7 < i5) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) i39.d(arrayList, i7);
            advertAppInfo.j = "FRS";
            int h = advertAppInfo.h();
            if (h != 0) {
                x4a.h(advertAppInfo, i, h);
                if (h != 28 && h != 31) {
                    advertAppInfo.c = -1001;
                }
                i7++;
                i3 = 0;
            }
            if (advertAppInfo.getType() == null) {
                x4a.h(advertAppInfo, i, 100);
            } else {
                int i8 = (JavaTypesHelper.toInt(advertAppInfo.f, i3) + i4) - 1;
                if (hashSet.contains(Integer.valueOf(i8))) {
                    x4a.h(advertAppInfo, i, 29);
                } else if (i8 < 0) {
                    x4a.h(advertAppInfo, i, 33);
                } else if (i8 >= i2 && i6 > 3) {
                    x4a.i(advertAppInfo, i, 2, i8, i2);
                } else {
                    y36 y36Var2 = new y36();
                    y36Var2.d(advertAppInfo);
                    y36Var2.e(advertAppInfo.getType().getId());
                    y36Var2.f(3);
                    if (advertAppInfo.e()) {
                        if (j3a.i(advertAppInfo.q) && o36.a().o()) {
                            x4a.h(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.q) && !TextUtils.isEmpty(advertAppInfo.m)) {
                            hashSet.add(Integer.valueOf(i8));
                            if (i8 < i2) {
                                i39.b(list, y36Var2, i8);
                            } else if (i8 == i2) {
                                i39.a(list, y36Var2);
                            }
                        }
                    } else if (advertAppInfo.g()) {
                        hashSet.add(Integer.valueOf(i8));
                        if (i8 < i2) {
                            i39.b(list, y36Var2, i8);
                        } else if (i8 == i2) {
                            i39.a(list, y36Var2);
                        }
                    } else {
                        x4a.h(advertAppInfo, i, 21);
                    }
                }
            }
            i7++;
            i3 = 0;
        }
    }

    @Override // com.baidu.tieba.z36
    public void k(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.a = list;
        }
    }

    @Override // com.baidu.tieba.z36
    public View m(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        pm pmVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (!(obj instanceof AdvertAppInfo)) {
                return null;
            }
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.A) {
                pmVar = this.e;
            } else if (type == AdvertAppInfo.x) {
                pmVar = this.d;
            } else if (type == AdvertAppInfo.B) {
                pmVar = this.f;
            } else if (type == AdvertAppInfo.C) {
                pmVar = this.g;
            } else if (type == AdvertAppInfo.D) {
                pmVar = this.h;
            } else {
                pmVar = null;
            }
            if (pmVar == null) {
                return null;
            }
            return pmVar.getView(i, view2, viewGroup, advertAppInfo);
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.z36
    public void n(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) != null) || !(obj instanceof AdvertAppInfo)) {
            return;
        }
        pm pmVar = null;
        BdUniqueId type = ((AdvertAppInfo) obj).getType();
        if (type == AdvertAppInfo.A) {
            pmVar = this.e;
        } else if (type == AdvertAppInfo.x) {
            pmVar = this.d;
        } else if (type == AdvertAppInfo.B) {
            pmVar = this.f;
        } else if (type == AdvertAppInfo.C) {
            pmVar = this.g;
        } else if (type == AdvertAppInfo.D) {
            pmVar = this.h;
        }
        if (pmVar != null) {
            pmVar.onFillViewHolder(i, viewGroup, viewHolder, obj);
        }
    }

    @Override // com.baidu.tieba.z36
    public void o(List<y36> list, List<y36> list2, boolean z, int i) {
        ArrayList arrayList;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048586, this, new Object[]{list, list2, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || i39.e(this.a)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                i39.a(arrayList2, (AdvertAppInfo) obj);
            }
        }
        Iterator<y36> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int i5 = i39.i(list);
        int i6 = 0;
        int i7 = 0;
        for (y36 y36Var : list) {
            if (y36Var.c() == 1) {
                i7++;
            }
        }
        int i8 = i39.i(arrayList2);
        if (i8 < 1) {
            return;
        }
        int i9 = 9;
        if (i39.i(arrayList2) > 1 && (i4 = (JavaTypesHelper.toInt(((AdvertAppInfo) i39.d(arrayList2, 1)).f, 0) - JavaTypesHelper.toInt(((AdvertAppInfo) i39.d(arrayList2, 0)).f, 0)) - 1) > 0) {
            i9 = i4;
        }
        int i10 = JavaTypesHelper.toInt(((AdvertAppInfo) i39.d(arrayList2, 0)).f, 0) - 1;
        int i11 = i5 - i7;
        HashSet hashSet = new HashSet();
        int i12 = 0;
        while (i12 < i8) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) i39.d(arrayList2, i12);
            advertAppInfo.j = "SMART_FRS";
            int h = advertAppInfo.h();
            if (h != 0) {
                x4a.h(advertAppInfo, i, h);
                if (h != 28 && h != 31) {
                    advertAppInfo.c = -1001;
                }
                arrayList = arrayList2;
                i12++;
                arrayList2 = arrayList;
                i6 = 0;
            }
            if (advertAppInfo.getType() == null) {
                x4a.h(advertAppInfo, i, 100);
                arrayList = arrayList2;
                i12++;
                arrayList2 = arrayList;
                i6 = 0;
            } else {
                int i13 = JavaTypesHelper.toInt(advertAppInfo.f, i6);
                int i14 = (i13 + i7) - 1;
                if (i14 >= 0 && !hashSet.contains(Integer.valueOf(i14)) && i14 <= i5) {
                    if (i13 > (i11 - i9) + i10 && z) {
                        if (!i39.e(list2)) {
                            int i15 = i39.i(list2);
                            int i16 = (i9 - ((i11 - i13) + 1)) - 1;
                            int i17 = 0;
                            while (i17 < i15 && i17 < i16) {
                                arrayList = arrayList2;
                                if (((y36) i39.d(list2, i17)).a() instanceof AdvertAppInfo) {
                                    i3 = 0;
                                    break;
                                } else {
                                    i17++;
                                    arrayList2 = arrayList;
                                }
                            }
                            arrayList = arrayList2;
                            i3 = 1;
                            i2 = i3 ^ 1;
                        } else {
                            arrayList = arrayList2;
                            if (o36.a().n()) {
                                i2 = 36;
                            }
                        }
                    } else {
                        arrayList = arrayList2;
                    }
                    i2 = 0;
                } else {
                    arrayList = arrayList2;
                    if (i14 > i5) {
                        x4a.i(advertAppInfo, i, 2, i14, i5);
                        i12++;
                        arrayList2 = arrayList;
                        i6 = 0;
                    } else if (i14 < 0) {
                        i2 = 33;
                    } else {
                        i2 = 29;
                    }
                }
                if (i2 != 0) {
                    x4a.h(advertAppInfo, i, i2);
                    i12++;
                    arrayList2 = arrayList;
                    i6 = 0;
                } else {
                    y36 y36Var2 = new y36();
                    y36Var2.d(advertAppInfo);
                    y36Var2.e(advertAppInfo.getType().getId());
                    y36Var2.f(3);
                    if (advertAppInfo.e()) {
                        if (j3a.i(advertAppInfo.q) && o36.a().o()) {
                            x4a.h(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.q) && !TextUtils.isEmpty(advertAppInfo.m)) {
                            hashSet.add(Integer.valueOf(i14));
                            if (i14 < i5) {
                                i39.b(list, y36Var2, i14);
                            } else if (i14 == i5) {
                                i39.a(list, y36Var2);
                            }
                        }
                    } else if (advertAppInfo.g()) {
                        hashSet.add(Integer.valueOf(i14));
                        if (i14 < i5) {
                            i39.b(list, y36Var2, i14);
                        } else if (i14 == i5) {
                            i39.a(list, y36Var2);
                        }
                    }
                    i12++;
                    arrayList2 = arrayList;
                    i6 = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.z36
    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            pm pmVar = this.e;
            if (pmVar instanceof o3a) {
                ((o3a) pmVar).L(str);
            }
            pm pmVar2 = this.f;
            if (pmVar2 instanceof o3a) {
                ((o3a) pmVar2).L(str);
            }
            pm pmVar3 = this.g;
            if (pmVar3 instanceof o3a) {
                ((o3a) pmVar3).L(str);
            }
            pm pmVar4 = this.h;
            if (pmVar4 instanceof o3a) {
                ((o3a) pmVar4).L(str);
            }
        }
    }
}
