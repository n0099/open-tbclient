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
public class nv8 implements ow5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Object> a;
    public tw5 b;
    public zv8 c;
    public qn d;
    public qn e;
    public qn f;
    public qn g;
    public qn h;

    @Override // com.baidu.tieba.ow5
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    @Override // com.baidu.tieba.rw5
    public void b(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
        }
    }

    public nv8() {
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

    @Override // com.baidu.tieba.ow5
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

    @Override // com.baidu.tieba.ow5
    public void e(List<nw5> list, String str, String str2, String str3, String str4, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{list, str, str2, str3, str4, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || ry7.e(list)) {
            return;
        }
        Set<Cdo> a = nx8.a("FRS");
        if (a == null) {
            a = new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (nw5 nw5Var : list) {
            if (nw5Var != null) {
                Object a2 = nw5Var.a();
                for (Cdo cdo : a) {
                    if (a2 != null && nw5Var.c() == 3 && (a2 instanceof AdvertAppInfo) && cdo != null && (cdo instanceof AdvertAppInfo) && a2.hashCode() == cdo.hashCode()) {
                        ((AdvertAppInfo) a2).i = ((AdvertAppInfo) cdo).i;
                    }
                }
                if (a2 != null && nw5Var.c() == 3 && (a2 instanceof AdvertAppInfo)) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) a2;
                    if (advertAppInfo.i == null) {
                        ey4 ey4Var = new ey4();
                        advertAppInfo.i = ey4Var;
                        ey4Var.a = "FRS";
                        String.valueOf(z);
                        ey4 ey4Var2 = advertAppInfo.i;
                        ey4Var2.b = i;
                        ey4Var2.c = str;
                        ey4Var2.d = str2;
                        ey4Var2.e = str3;
                        ey4Var2.f = str4;
                        ey4Var2.g = advertAppInfo.g;
                        ey4Var2.h = false;
                        hashSet.add(advertAppInfo);
                    }
                }
            }
        }
        a.addAll(hashSet);
        nx8.b("FRS", a);
    }

    @Override // com.baidu.tieba.ow5
    public TypeAdapter.ViewHolder g(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        qn qnVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, viewGroup, obj)) == null) {
            if (!(obj instanceof AdvertAppInfo)) {
                return null;
            }
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.z) {
                qnVar = this.e;
            } else if (type == AdvertAppInfo.w) {
                qnVar = this.d;
            } else if (type == AdvertAppInfo.A) {
                qnVar = this.f;
            } else if (type == AdvertAppInfo.B) {
                qnVar = this.g;
            } else if (type == AdvertAppInfo.C) {
                qnVar = this.h;
            } else {
                qnVar = null;
            }
            if (qnVar == null) {
                return null;
            }
            return qnVar.onCreateViewHolder(viewGroup, obj);
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rw5
    /* renamed from: q */
    public void f(tw5 tw5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, tw5Var, str) == null) {
            this.b = tw5Var;
            if (tw5Var != null && (tw5Var.a() instanceof zv8)) {
                this.c = (zv8) this.b.a();
                this.d = new hw8(this.c, AdvertAppInfo.w);
                this.e = new iw8(this.c, AdvertAppInfo.z, str);
                this.f = new iw8(this.c, AdvertAppInfo.A, str);
                this.g = new iw8(this.c, AdvertAppInfo.B, str);
                this.h = new iw8(this.c, AdvertAppInfo.C, str);
            }
        }
    }

    @Override // com.baidu.tieba.ow5
    public void i(List<nw5> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048582, this, list, i) != null) || ry7.e(this.a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                ry7.a(arrayList, (AdvertAppInfo) obj);
            }
        }
        Iterator<nw5> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int i2 = ry7.i(list);
        int i3 = 0;
        int i4 = 0;
        for (nw5 nw5Var : list) {
            if (nw5Var.c() == 1) {
                i4++;
            }
        }
        int i5 = ry7.i(arrayList);
        if (i5 < 1) {
            return;
        }
        int i6 = i2 - i4;
        HashSet hashSet = new HashSet();
        int i7 = 0;
        while (i7 < i5) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) ry7.d(arrayList, i7);
            advertAppInfo.j = "FRS";
            int l = advertAppInfo.l();
            if (l != 0) {
                px8.h(advertAppInfo, i, l);
                if (l != 28 && l != 31) {
                    advertAppInfo.c = -1001;
                }
                i7++;
                i3 = 0;
            }
            if (advertAppInfo.getType() == null) {
                px8.h(advertAppInfo, i, 100);
            } else {
                int e = (dh.e(advertAppInfo.f, i3) + i4) - 1;
                if (hashSet.contains(Integer.valueOf(e))) {
                    px8.h(advertAppInfo, i, 29);
                } else if (e < 0) {
                    px8.h(advertAppInfo, i, 33);
                } else if (e >= i2 && i6 > 3) {
                    px8.i(advertAppInfo, i, 2, e, i2);
                } else {
                    nw5 nw5Var2 = new nw5();
                    nw5Var2.d(advertAppInfo);
                    nw5Var2.e(advertAppInfo.getType().getId());
                    nw5Var2.f(3);
                    if (advertAppInfo.g()) {
                        if (dw8.i(advertAppInfo.p) && cw5.a().p()) {
                            px8.h(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.p) && !TextUtils.isEmpty(advertAppInfo.l)) {
                            hashSet.add(Integer.valueOf(e));
                            if (e < i2) {
                                ry7.b(list, nw5Var2, e);
                            } else if (e == i2) {
                                ry7.a(list, nw5Var2);
                            }
                        }
                    } else if (advertAppInfo.j()) {
                        hashSet.add(Integer.valueOf(e));
                        if (e < i2) {
                            ry7.b(list, nw5Var2, e);
                        } else if (e == i2) {
                            ry7.a(list, nw5Var2);
                        }
                    } else {
                        px8.h(advertAppInfo, i, 21);
                    }
                }
            }
            i7++;
            i3 = 0;
        }
    }

    @Override // com.baidu.tieba.ow5
    public void k(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.a = list;
        }
    }

    @Override // com.baidu.tieba.ow5
    public View m(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        qn qnVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (!(obj instanceof AdvertAppInfo)) {
                return null;
            }
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.z) {
                qnVar = this.e;
            } else if (type == AdvertAppInfo.w) {
                qnVar = this.d;
            } else if (type == AdvertAppInfo.A) {
                qnVar = this.f;
            } else if (type == AdvertAppInfo.B) {
                qnVar = this.g;
            } else if (type == AdvertAppInfo.C) {
                qnVar = this.h;
            } else {
                qnVar = null;
            }
            if (qnVar == null) {
                return null;
            }
            return qnVar.getView(i, view2, viewGroup, advertAppInfo);
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.ow5
    public void n(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) != null) || !(obj instanceof AdvertAppInfo)) {
            return;
        }
        qn qnVar = null;
        BdUniqueId type = ((AdvertAppInfo) obj).getType();
        if (type == AdvertAppInfo.z) {
            qnVar = this.e;
        } else if (type == AdvertAppInfo.w) {
            qnVar = this.d;
        } else if (type == AdvertAppInfo.A) {
            qnVar = this.f;
        } else if (type == AdvertAppInfo.B) {
            qnVar = this.g;
        } else if (type == AdvertAppInfo.C) {
            qnVar = this.h;
        }
        if (qnVar != null) {
            qnVar.onFillViewHolder(i, viewGroup, viewHolder, obj);
        }
    }

    @Override // com.baidu.tieba.ow5
    public void o(List<nw5> list, List<nw5> list2, boolean z, int i) {
        ArrayList arrayList;
        int i2;
        int i3;
        int e;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048586, this, new Object[]{list, list2, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || ry7.e(this.a)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                ry7.a(arrayList2, (AdvertAppInfo) obj);
            }
        }
        Iterator<nw5> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int i4 = ry7.i(list);
        int i5 = 0;
        int i6 = 0;
        for (nw5 nw5Var : list) {
            if (nw5Var.c() == 1) {
                i6++;
            }
        }
        int i7 = ry7.i(arrayList2);
        if (i7 < 1) {
            return;
        }
        int i8 = 9;
        if (ry7.i(arrayList2) > 1 && (e = (dh.e(((AdvertAppInfo) ry7.d(arrayList2, 1)).f, 0) - dh.e(((AdvertAppInfo) ry7.d(arrayList2, 0)).f, 0)) - 1) > 0) {
            i8 = e;
        }
        int e2 = dh.e(((AdvertAppInfo) ry7.d(arrayList2, 0)).f, 0) - 1;
        int i9 = i4 - i6;
        HashSet hashSet = new HashSet();
        int i10 = 0;
        while (i10 < i7) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) ry7.d(arrayList2, i10);
            advertAppInfo.j = "SMART_FRS";
            int l = advertAppInfo.l();
            if (l != 0) {
                px8.h(advertAppInfo, i, l);
                if (l != 28 && l != 31) {
                    advertAppInfo.c = -1001;
                }
                arrayList = arrayList2;
                i10++;
                arrayList2 = arrayList;
                i5 = 0;
            }
            if (advertAppInfo.getType() == null) {
                px8.h(advertAppInfo, i, 100);
                arrayList = arrayList2;
                i10++;
                arrayList2 = arrayList;
                i5 = 0;
            } else {
                int e3 = dh.e(advertAppInfo.f, i5);
                int i11 = (e3 + i6) - 1;
                if (i11 >= 0 && !hashSet.contains(Integer.valueOf(i11)) && i11 <= i4) {
                    if (e3 > (i9 - i8) + e2 && z) {
                        if (!ry7.e(list2)) {
                            int i12 = ry7.i(list2);
                            int i13 = (i8 - ((i9 - e3) + 1)) - 1;
                            int i14 = 0;
                            while (i14 < i12 && i14 < i13) {
                                arrayList = arrayList2;
                                if (((nw5) ry7.d(list2, i14)).a() instanceof AdvertAppInfo) {
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
                            if (cw5.a().o()) {
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
                        px8.i(advertAppInfo, i, 2, i11, i4);
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
                    px8.h(advertAppInfo, i, i2);
                    i10++;
                    arrayList2 = arrayList;
                    i5 = 0;
                } else {
                    nw5 nw5Var2 = new nw5();
                    nw5Var2.d(advertAppInfo);
                    nw5Var2.e(advertAppInfo.getType().getId());
                    nw5Var2.f(3);
                    if (advertAppInfo.g()) {
                        if (dw8.i(advertAppInfo.p) && cw5.a().p()) {
                            px8.h(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.p) && !TextUtils.isEmpty(advertAppInfo.l)) {
                            hashSet.add(Integer.valueOf(i11));
                            if (i11 < i4) {
                                ry7.b(list, nw5Var2, i11);
                            } else if (i11 == i4) {
                                ry7.a(list, nw5Var2);
                            }
                        }
                    } else if (advertAppInfo.j()) {
                        hashSet.add(Integer.valueOf(i11));
                        if (i11 < i4) {
                            ry7.b(list, nw5Var2, i11);
                        } else if (i11 == i4) {
                            ry7.a(list, nw5Var2);
                        }
                    }
                    i10++;
                    arrayList2 = arrayList;
                    i5 = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.ow5
    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            qn qnVar = this.e;
            if (qnVar instanceof iw8) {
                ((iw8) qnVar).K(str);
            }
            qn qnVar2 = this.f;
            if (qnVar2 instanceof iw8) {
                ((iw8) qnVar2).K(str);
            }
            qn qnVar3 = this.g;
            if (qnVar3 instanceof iw8) {
                ((iw8) qnVar3).K(str);
            }
            qn qnVar4 = this.h;
            if (qnVar4 instanceof iw8) {
                ((iw8) qnVar4).K(str);
            }
        }
    }
}
