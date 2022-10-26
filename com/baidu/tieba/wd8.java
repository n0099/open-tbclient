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
/* loaded from: classes6.dex */
public class wd8 implements ln5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List a;
    public qn5 b;
    public ie8 c;
    public rn d;
    public rn e;
    public rn f;
    public rn g;
    public rn h;

    @Override // com.baidu.tieba.ln5
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    @Override // com.baidu.tieba.on5
    public void b(Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
        }
    }

    public wd8() {
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

    @Override // com.baidu.tieba.ln5
    public List d() {
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

    @Override // com.baidu.tieba.ln5
    public void e(List list, String str, String str2, String str3, String str4, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{list, str, str2, str3, str4, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || lh7.e(list)) {
            return;
        }
        Set<eo> a = wf8.a("FRS");
        if (a == null) {
            a = new HashSet();
        }
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            kn5 kn5Var = (kn5) it.next();
            if (kn5Var != null) {
                Object a2 = kn5Var.a();
                for (eo eoVar : a) {
                    if (a2 != null && kn5Var.c() == 3 && (a2 instanceof AdvertAppInfo) && eoVar != null && (eoVar instanceof AdvertAppInfo) && a2.hashCode() == eoVar.hashCode()) {
                        ((AdvertAppInfo) a2).i = ((AdvertAppInfo) eoVar).i;
                    }
                }
                if (a2 != null && kn5Var.c() == 3 && (a2 instanceof AdvertAppInfo)) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) a2;
                    if (advertAppInfo.i == null) {
                        fr4 fr4Var = new fr4();
                        advertAppInfo.i = fr4Var;
                        fr4Var.a = "FRS";
                        String.valueOf(z);
                        fr4 fr4Var2 = advertAppInfo.i;
                        fr4Var2.b = i;
                        fr4Var2.c = str;
                        fr4Var2.d = str2;
                        fr4Var2.e = str3;
                        fr4Var2.f = str4;
                        fr4Var2.g = advertAppInfo.g;
                        fr4Var2.h = false;
                        hashSet.add(advertAppInfo);
                    }
                }
            }
        }
        a.addAll(hashSet);
        wf8.b("FRS", a);
    }

    @Override // com.baidu.tieba.ln5
    public TypeAdapter.ViewHolder g(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        rn rnVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, viewGroup, obj)) == null) {
            if (!(obj instanceof AdvertAppInfo)) {
                return null;
            }
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.z) {
                rnVar = this.e;
            } else if (type == AdvertAppInfo.w) {
                rnVar = this.d;
            } else if (type == AdvertAppInfo.A) {
                rnVar = this.f;
            } else if (type == AdvertAppInfo.B) {
                rnVar = this.g;
            } else if (type == AdvertAppInfo.C) {
                rnVar = this.h;
            } else {
                rnVar = null;
            }
            if (rnVar == null) {
                return null;
            }
            return rnVar.onCreateViewHolder(viewGroup, obj);
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.on5
    /* renamed from: q */
    public void f(qn5 qn5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, qn5Var, str) == null) {
            this.b = qn5Var;
            if (qn5Var != null && (qn5Var.a() instanceof ie8)) {
                this.c = (ie8) this.b.a();
                this.d = new qe8(this.c, AdvertAppInfo.w);
                this.e = new re8(this.c, AdvertAppInfo.z, str);
                this.f = new re8(this.c, AdvertAppInfo.A, str);
                this.g = new re8(this.c, AdvertAppInfo.B, str);
                this.h = new re8(this.c, AdvertAppInfo.C, str);
            }
        }
    }

    @Override // com.baidu.tieba.ln5
    public void i(List list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048582, this, list, i) != null) || lh7.e(this.a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                lh7.a(arrayList, (AdvertAppInfo) obj);
            }
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((kn5) it.next()).c() == 3) {
                it.remove();
            }
        }
        int i2 = lh7.i(list);
        Iterator it2 = list.iterator();
        int i3 = 0;
        int i4 = 0;
        while (it2.hasNext()) {
            if (((kn5) it2.next()).c() == 1) {
                i4++;
            }
        }
        int i5 = lh7.i(arrayList);
        if (i5 < 1) {
            return;
        }
        int i6 = i2 - i4;
        HashSet hashSet = new HashSet();
        int i7 = 0;
        while (i7 < i5) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) lh7.d(arrayList, i7);
            advertAppInfo.j = "FRS";
            int n = advertAppInfo.n();
            if (n != 0) {
                yf8.h(advertAppInfo, i, n);
                if (n != 28 && n != 31) {
                    advertAppInfo.c = -1001;
                }
                i7++;
                i3 = 0;
            }
            if (advertAppInfo.getType() == null) {
                yf8.h(advertAppInfo, i, 100);
            } else {
                int e = (eh.e(advertAppInfo.f, i3) + i4) - 1;
                if (hashSet.contains(Integer.valueOf(e))) {
                    yf8.h(advertAppInfo, i, 29);
                } else if (e < 0) {
                    yf8.h(advertAppInfo, i, 33);
                } else if (e >= i2 && i6 > 3) {
                    yf8.i(advertAppInfo, i, 2, e, i2);
                } else {
                    kn5 kn5Var = new kn5();
                    kn5Var.d(advertAppInfo);
                    kn5Var.e(advertAppInfo.getType().getId());
                    kn5Var.f(3);
                    if (advertAppInfo.h()) {
                        if (me8.i(advertAppInfo.p) && an5.a().p()) {
                            yf8.h(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.p) && !TextUtils.isEmpty(advertAppInfo.l)) {
                            hashSet.add(Integer.valueOf(e));
                            if (e < i2) {
                                lh7.b(list, kn5Var, e);
                            } else if (e == i2) {
                                lh7.a(list, kn5Var);
                            }
                        }
                    } else if (advertAppInfo.l()) {
                        hashSet.add(Integer.valueOf(e));
                        if (e < i2) {
                            lh7.b(list, kn5Var, e);
                        } else if (e == i2) {
                            lh7.a(list, kn5Var);
                        }
                    } else {
                        yf8.h(advertAppInfo, i, 21);
                    }
                }
            }
            i7++;
            i3 = 0;
        }
    }

    @Override // com.baidu.tieba.ln5
    public void k(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.a = list;
        }
    }

    @Override // com.baidu.tieba.ln5
    public View m(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        rn rnVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (!(obj instanceof AdvertAppInfo)) {
                return null;
            }
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.z) {
                rnVar = this.e;
            } else if (type == AdvertAppInfo.w) {
                rnVar = this.d;
            } else if (type == AdvertAppInfo.A) {
                rnVar = this.f;
            } else if (type == AdvertAppInfo.B) {
                rnVar = this.g;
            } else if (type == AdvertAppInfo.C) {
                rnVar = this.h;
            } else {
                rnVar = null;
            }
            if (rnVar == null) {
                return null;
            }
            return rnVar.getView(i, view2, viewGroup, advertAppInfo);
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.ln5
    public void n(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) != null) || !(obj instanceof AdvertAppInfo)) {
            return;
        }
        rn rnVar = null;
        BdUniqueId type = ((AdvertAppInfo) obj).getType();
        if (type == AdvertAppInfo.z) {
            rnVar = this.e;
        } else if (type == AdvertAppInfo.w) {
            rnVar = this.d;
        } else if (type == AdvertAppInfo.A) {
            rnVar = this.f;
        } else if (type == AdvertAppInfo.B) {
            rnVar = this.g;
        } else if (type == AdvertAppInfo.C) {
            rnVar = this.h;
        }
        if (rnVar != null) {
            rnVar.onFillViewHolder(i, viewGroup, viewHolder, obj);
        }
    }

    @Override // com.baidu.tieba.ln5
    public void o(List list, List list2, boolean z, int i) {
        ArrayList arrayList;
        int i2;
        int i3;
        int e;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048586, this, new Object[]{list, list2, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || lh7.e(this.a)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                lh7.a(arrayList2, (AdvertAppInfo) obj);
            }
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((kn5) it.next()).c() == 3) {
                it.remove();
            }
        }
        int i4 = lh7.i(list);
        Iterator it2 = list.iterator();
        int i5 = 0;
        int i6 = 0;
        while (it2.hasNext()) {
            if (((kn5) it2.next()).c() == 1) {
                i6++;
            }
        }
        int i7 = lh7.i(arrayList2);
        if (i7 < 1) {
            return;
        }
        int i8 = 9;
        if (lh7.i(arrayList2) > 1 && (e = (eh.e(((AdvertAppInfo) lh7.d(arrayList2, 1)).f, 0) - eh.e(((AdvertAppInfo) lh7.d(arrayList2, 0)).f, 0)) - 1) > 0) {
            i8 = e;
        }
        int e2 = eh.e(((AdvertAppInfo) lh7.d(arrayList2, 0)).f, 0) - 1;
        int i9 = i4 - i6;
        HashSet hashSet = new HashSet();
        int i10 = 0;
        while (i10 < i7) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) lh7.d(arrayList2, i10);
            advertAppInfo.j = "SMART_FRS";
            int n = advertAppInfo.n();
            if (n != 0) {
                yf8.h(advertAppInfo, i, n);
                if (n != 28 && n != 31) {
                    advertAppInfo.c = -1001;
                }
                arrayList = arrayList2;
                i10++;
                arrayList2 = arrayList;
                i5 = 0;
            }
            if (advertAppInfo.getType() == null) {
                yf8.h(advertAppInfo, i, 100);
                arrayList = arrayList2;
                i10++;
                arrayList2 = arrayList;
                i5 = 0;
            } else {
                int e3 = eh.e(advertAppInfo.f, i5);
                int i11 = (e3 + i6) - 1;
                if (i11 >= 0 && !hashSet.contains(Integer.valueOf(i11)) && i11 <= i4) {
                    if (e3 > (i9 - i8) + e2 && z) {
                        if (!lh7.e(list2)) {
                            int i12 = lh7.i(list2);
                            int i13 = (i8 - ((i9 - e3) + 1)) - 1;
                            int i14 = 0;
                            while (i14 < i12 && i14 < i13) {
                                arrayList = arrayList2;
                                if (((kn5) lh7.d(list2, i14)).a() instanceof AdvertAppInfo) {
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
                            if (an5.a().o()) {
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
                        yf8.i(advertAppInfo, i, 2, i11, i4);
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
                    yf8.h(advertAppInfo, i, i2);
                    i10++;
                    arrayList2 = arrayList;
                    i5 = 0;
                } else {
                    kn5 kn5Var = new kn5();
                    kn5Var.d(advertAppInfo);
                    kn5Var.e(advertAppInfo.getType().getId());
                    kn5Var.f(3);
                    if (advertAppInfo.h()) {
                        if (me8.i(advertAppInfo.p) && an5.a().p()) {
                            yf8.h(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.p) && !TextUtils.isEmpty(advertAppInfo.l)) {
                            hashSet.add(Integer.valueOf(i11));
                            if (i11 < i4) {
                                lh7.b(list, kn5Var, i11);
                            } else if (i11 == i4) {
                                lh7.a(list, kn5Var);
                            }
                        }
                    } else if (advertAppInfo.l()) {
                        hashSet.add(Integer.valueOf(i11));
                        if (i11 < i4) {
                            lh7.b(list, kn5Var, i11);
                        } else if (i11 == i4) {
                            lh7.a(list, kn5Var);
                        }
                    }
                    i10++;
                    arrayList2 = arrayList;
                    i5 = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.ln5
    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            rn rnVar = this.e;
            if (rnVar instanceof re8) {
                ((re8) rnVar).K(str);
            }
            rn rnVar2 = this.f;
            if (rnVar2 instanceof re8) {
                ((re8) rnVar2).K(str);
            }
            rn rnVar3 = this.g;
            if (rnVar3 instanceof re8) {
                ((re8) rnVar3).K(str);
            }
            rn rnVar4 = this.h;
            if (rnVar4 instanceof re8) {
                ((re8) rnVar4).K(str);
            }
        }
    }
}
