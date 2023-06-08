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
/* loaded from: classes7.dex */
public class tl9 implements q36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Object> a;
    public v36 b;
    public fm9 c;
    public in d;
    public in e;
    public in f;
    public in g;
    public in h;

    @Override // com.baidu.tieba.q36
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    @Override // com.baidu.tieba.t36
    public void b(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
        }
    }

    public tl9() {
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

    @Override // com.baidu.tieba.q36
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

    @Override // com.baidu.tieba.q36
    public void e(List<p36> list, String str, String str2, String str3, String str4, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{list, str, str2, str3, str4, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || yo8.e(list)) {
            return;
        }
        Set<vn> a = vn9.a("FRS");
        if (a == null) {
            a = new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (p36 p36Var : list) {
            if (p36Var != null) {
                Object a2 = p36Var.a();
                for (vn vnVar : a) {
                    if (a2 != null && p36Var.c() == 3 && (a2 instanceof AdvertAppInfo) && vnVar != null && (vnVar instanceof AdvertAppInfo) && a2.hashCode() == vnVar.hashCode()) {
                        ((AdvertAppInfo) a2).i = ((AdvertAppInfo) vnVar).i;
                    }
                }
                if (a2 != null && p36Var.c() == 3 && (a2 instanceof AdvertAppInfo)) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) a2;
                    if (advertAppInfo.i == null) {
                        m15 m15Var = new m15();
                        advertAppInfo.i = m15Var;
                        m15Var.a = "FRS";
                        String.valueOf(z);
                        m15 m15Var2 = advertAppInfo.i;
                        m15Var2.b = i;
                        m15Var2.c = str;
                        m15Var2.d = str2;
                        m15Var2.e = str3;
                        m15Var2.f = str4;
                        m15Var2.g = advertAppInfo.g;
                        m15Var2.h = false;
                        hashSet.add(advertAppInfo);
                    }
                }
            }
        }
        a.addAll(hashSet);
        vn9.b("FRS", a);
    }

    @Override // com.baidu.tieba.q36
    public TypeAdapter.ViewHolder g(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        in inVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, viewGroup, obj)) == null) {
            if (!(obj instanceof AdvertAppInfo)) {
                return null;
            }
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.z) {
                inVar = this.e;
            } else if (type == AdvertAppInfo.w) {
                inVar = this.d;
            } else if (type == AdvertAppInfo.A) {
                inVar = this.f;
            } else if (type == AdvertAppInfo.B) {
                inVar = this.g;
            } else if (type == AdvertAppInfo.C) {
                inVar = this.h;
            } else {
                inVar = null;
            }
            if (inVar == null) {
                return null;
            }
            return inVar.onCreateViewHolder(viewGroup, obj);
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.t36
    /* renamed from: q */
    public void f(v36 v36Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, v36Var, str) == null) {
            this.b = v36Var;
            if (v36Var != null && (v36Var.a() instanceof fm9)) {
                this.c = (fm9) this.b.a();
                this.d = new om9(this.c, AdvertAppInfo.w);
                this.e = new pm9(this.c, AdvertAppInfo.z, str);
                this.f = new pm9(this.c, AdvertAppInfo.A, str);
                this.g = new pm9(this.c, AdvertAppInfo.B, str);
                this.h = new pm9(this.c, AdvertAppInfo.C, str);
            }
        }
    }

    @Override // com.baidu.tieba.q36
    public void i(List<p36> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048582, this, list, i) != null) || yo8.e(this.a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                yo8.a(arrayList, (AdvertAppInfo) obj);
            }
        }
        Iterator<p36> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int i2 = yo8.i(list);
        int i3 = 0;
        int i4 = 0;
        for (p36 p36Var : list) {
            if (p36Var.c() == 1) {
                i4++;
            }
        }
        int i5 = yo8.i(arrayList);
        if (i5 < 1) {
            return;
        }
        int i6 = i2 - i4;
        HashSet hashSet = new HashSet();
        int i7 = 0;
        while (i7 < i5) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) yo8.d(arrayList, i7);
            advertAppInfo.j = "FRS";
            int i8 = advertAppInfo.i();
            if (i8 != 0) {
                xn9.h(advertAppInfo, i, i8);
                if (i8 != 28 && i8 != 31) {
                    advertAppInfo.c = -1001;
                }
                i7++;
                i3 = 0;
            }
            if (advertAppInfo.getType() == null) {
                xn9.h(advertAppInfo, i, 100);
            } else {
                int e = (tg.e(advertAppInfo.f, i3) + i4) - 1;
                if (hashSet.contains(Integer.valueOf(e))) {
                    xn9.h(advertAppInfo, i, 29);
                } else if (e < 0) {
                    xn9.h(advertAppInfo, i, 33);
                } else if (e >= i2 && i6 > 3) {
                    xn9.i(advertAppInfo, i, 2, e, i2);
                } else {
                    p36 p36Var2 = new p36();
                    p36Var2.d(advertAppInfo);
                    p36Var2.e(advertAppInfo.getType().getId());
                    p36Var2.f(3);
                    if (advertAppInfo.e()) {
                        if (km9.i(advertAppInfo.p) && e36.a().o()) {
                            xn9.h(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.p) && !TextUtils.isEmpty(advertAppInfo.l)) {
                            hashSet.add(Integer.valueOf(e));
                            if (e < i2) {
                                yo8.b(list, p36Var2, e);
                            } else if (e == i2) {
                                yo8.a(list, p36Var2);
                            }
                        }
                    } else if (advertAppInfo.h()) {
                        hashSet.add(Integer.valueOf(e));
                        if (e < i2) {
                            yo8.b(list, p36Var2, e);
                        } else if (e == i2) {
                            yo8.a(list, p36Var2);
                        }
                    } else {
                        xn9.h(advertAppInfo, i, 21);
                    }
                }
            }
            i7++;
            i3 = 0;
        }
    }

    @Override // com.baidu.tieba.q36
    public void k(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.a = list;
        }
    }

    @Override // com.baidu.tieba.q36
    public View m(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        in inVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (!(obj instanceof AdvertAppInfo)) {
                return null;
            }
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.z) {
                inVar = this.e;
            } else if (type == AdvertAppInfo.w) {
                inVar = this.d;
            } else if (type == AdvertAppInfo.A) {
                inVar = this.f;
            } else if (type == AdvertAppInfo.B) {
                inVar = this.g;
            } else if (type == AdvertAppInfo.C) {
                inVar = this.h;
            } else {
                inVar = null;
            }
            if (inVar == null) {
                return null;
            }
            return inVar.getView(i, view2, viewGroup, advertAppInfo);
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.q36
    public void n(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) != null) || !(obj instanceof AdvertAppInfo)) {
            return;
        }
        in inVar = null;
        BdUniqueId type = ((AdvertAppInfo) obj).getType();
        if (type == AdvertAppInfo.z) {
            inVar = this.e;
        } else if (type == AdvertAppInfo.w) {
            inVar = this.d;
        } else if (type == AdvertAppInfo.A) {
            inVar = this.f;
        } else if (type == AdvertAppInfo.B) {
            inVar = this.g;
        } else if (type == AdvertAppInfo.C) {
            inVar = this.h;
        }
        if (inVar != null) {
            inVar.onFillViewHolder(i, viewGroup, viewHolder, obj);
        }
    }

    @Override // com.baidu.tieba.q36
    public void o(List<p36> list, List<p36> list2, boolean z, int i) {
        ArrayList arrayList;
        int i2;
        int i3;
        int e;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048586, this, new Object[]{list, list2, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || yo8.e(this.a)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                yo8.a(arrayList2, (AdvertAppInfo) obj);
            }
        }
        Iterator<p36> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int i4 = yo8.i(list);
        int i5 = 0;
        int i6 = 0;
        for (p36 p36Var : list) {
            if (p36Var.c() == 1) {
                i6++;
            }
        }
        int i7 = yo8.i(arrayList2);
        if (i7 < 1) {
            return;
        }
        int i8 = 9;
        if (yo8.i(arrayList2) > 1 && (e = (tg.e(((AdvertAppInfo) yo8.d(arrayList2, 1)).f, 0) - tg.e(((AdvertAppInfo) yo8.d(arrayList2, 0)).f, 0)) - 1) > 0) {
            i8 = e;
        }
        int e2 = tg.e(((AdvertAppInfo) yo8.d(arrayList2, 0)).f, 0) - 1;
        int i9 = i4 - i6;
        HashSet hashSet = new HashSet();
        int i10 = 0;
        while (i10 < i7) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) yo8.d(arrayList2, i10);
            advertAppInfo.j = "SMART_FRS";
            int i11 = advertAppInfo.i();
            if (i11 != 0) {
                xn9.h(advertAppInfo, i, i11);
                if (i11 != 28 && i11 != 31) {
                    advertAppInfo.c = -1001;
                }
                arrayList = arrayList2;
                i10++;
                arrayList2 = arrayList;
                i5 = 0;
            }
            if (advertAppInfo.getType() == null) {
                xn9.h(advertAppInfo, i, 100);
                arrayList = arrayList2;
                i10++;
                arrayList2 = arrayList;
                i5 = 0;
            } else {
                int e3 = tg.e(advertAppInfo.f, i5);
                int i12 = (e3 + i6) - 1;
                if (i12 >= 0 && !hashSet.contains(Integer.valueOf(i12)) && i12 <= i4) {
                    if (e3 > (i9 - i8) + e2 && z) {
                        if (!yo8.e(list2)) {
                            int i13 = yo8.i(list2);
                            int i14 = (i8 - ((i9 - e3) + 1)) - 1;
                            int i15 = 0;
                            while (i15 < i13 && i15 < i14) {
                                arrayList = arrayList2;
                                if (((p36) yo8.d(list2, i15)).a() instanceof AdvertAppInfo) {
                                    i3 = 0;
                                    break;
                                } else {
                                    i15++;
                                    arrayList2 = arrayList;
                                }
                            }
                            arrayList = arrayList2;
                            i3 = 1;
                            i2 = i3 ^ 1;
                        } else {
                            arrayList = arrayList2;
                            if (e36.a().n()) {
                                i2 = 36;
                            }
                        }
                    } else {
                        arrayList = arrayList2;
                    }
                    i2 = 0;
                } else {
                    arrayList = arrayList2;
                    if (i12 > i4) {
                        xn9.i(advertAppInfo, i, 2, i12, i4);
                        i10++;
                        arrayList2 = arrayList;
                        i5 = 0;
                    } else if (i12 < 0) {
                        i2 = 33;
                    } else {
                        i2 = 29;
                    }
                }
                if (i2 != 0) {
                    xn9.h(advertAppInfo, i, i2);
                    i10++;
                    arrayList2 = arrayList;
                    i5 = 0;
                } else {
                    p36 p36Var2 = new p36();
                    p36Var2.d(advertAppInfo);
                    p36Var2.e(advertAppInfo.getType().getId());
                    p36Var2.f(3);
                    if (advertAppInfo.e()) {
                        if (km9.i(advertAppInfo.p) && e36.a().o()) {
                            xn9.h(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.p) && !TextUtils.isEmpty(advertAppInfo.l)) {
                            hashSet.add(Integer.valueOf(i12));
                            if (i12 < i4) {
                                yo8.b(list, p36Var2, i12);
                            } else if (i12 == i4) {
                                yo8.a(list, p36Var2);
                            }
                        }
                    } else if (advertAppInfo.h()) {
                        hashSet.add(Integer.valueOf(i12));
                        if (i12 < i4) {
                            yo8.b(list, p36Var2, i12);
                        } else if (i12 == i4) {
                            yo8.a(list, p36Var2);
                        }
                    }
                    i10++;
                    arrayList2 = arrayList;
                    i5 = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.q36
    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            in inVar = this.e;
            if (inVar instanceof pm9) {
                ((pm9) inVar).M(str);
            }
            in inVar2 = this.f;
            if (inVar2 instanceof pm9) {
                ((pm9) inVar2).M(str);
            }
            in inVar3 = this.g;
            if (inVar3 instanceof pm9) {
                ((pm9) inVar3).M(str);
            }
            in inVar4 = this.h;
            if (inVar4 instanceof pm9) {
                ((pm9) inVar4).M(str);
            }
        }
    }
}
