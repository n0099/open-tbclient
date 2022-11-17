package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class in6 implements wn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public Cdo b;
    public List<kn> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<xn> e;
    public FrsViewData f;
    public boolean g;
    public final fj6 h;
    public vn6 i;
    public kn j;
    public qn6 k;
    public cn6 l;
    public nn6 m;
    public kn6 n;
    public bn6 o;
    public en6 p;
    public on6 q;
    public sn6 r;
    public mn6 s;
    public jn6 t;
    public rn6 u;
    public dn6 v;
    public ln6 w;

    public in6(FrsFragment frsFragment, Cdo cdo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, cdo, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new LinkedList();
        this.g = false;
        this.b = cdo;
        this.h = new fj6();
        o(frsFragment, cdo);
        this.d = new HashMap<>();
        m(z);
    }

    @Override // com.baidu.tieba.wn6
    public void a(String str) {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (kn knVar : list) {
            if (knVar instanceof k46) {
                ((k46) knVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.wn6
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && this.g != z) {
            this.g = z;
        }
    }

    public final boolean p(xn xnVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, xnVar)) == null) {
            if (xnVar == null) {
                return false;
            }
            BdUniqueId type = xnVar.getType();
            if (type != ThreadData.TYPE_NORMAL && type != ThreadData.TYPE_GOD_NORMAL && type != ThreadData.TYPE_VIDEO && type != ThreadData.TYPE_VIDEO_GOD && type != ThreadData.TYPE_INSERT_VIDEO) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void s(String str) {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (kn knVar : list) {
            if (knVar instanceof mq5) {
                ((mq5) knVar).g(str);
            }
        }
    }

    public final void z(List<kn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, list) != null) || list == null) {
            return;
        }
        for (kn knVar : list) {
            if (knVar instanceof hj6) {
                ((hj6) knVar).w(this.h);
            }
        }
    }

    @Override // com.baidu.tieba.wn6
    public void b() {
        Cdo cdo;
        List<xn> data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (cdo = this.b) != null && cdo.getData() != null && this.b.getData().size() != 0 && (data = this.b.getData()) != null && data.size() != 0) {
            for (xn xnVar : data) {
                if (xnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) xnVar;
                    if (threadData.getIs_top() != 0) {
                        threadData.parser_title();
                    }
                } else if (xnVar instanceof xu4) {
                    xu4 xu4Var = (xu4) xnVar;
                    if (xu4Var.t.getIs_top() != 0) {
                        xu4Var.t.parser_title();
                    }
                }
            }
        }
    }

    public final void w() {
        du6 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.f == null) {
            return;
        }
        for (kn knVar : this.c) {
            if ((knVar instanceof fu6) && (i = ((fu6) knVar).i()) != null) {
                if (this.f.needLog == 1) {
                    i.a = true;
                } else {
                    i.a = false;
                }
                if (this.f.getForum() != null) {
                    i.c = this.f.getForum().getId();
                    i.d = this.f.getForum().getName();
                }
                FrsFragment frsFragment = this.a;
                if (frsFragment != null && frsFragment.J0() != null) {
                    int U = this.a.J0().U();
                    if (U == -1) {
                        U = this.a.J0().T();
                    }
                    i.b = U;
                }
            }
        }
    }

    @Override // com.baidu.tieba.wn6
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090b38;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.wn6
    public List<xn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Cdo cdo = this.b;
            if (cdo != null) {
                return cdo.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wn6
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wn6
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090b13;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.wn6
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090bde;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.wn6
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.b.getListAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList<xn> arrayList = this.e;
            if (arrayList != null) {
                this.b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.wn6
    public void d(ho hoVar) {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, hoVar) == null) && (list = this.c) != null && list.size() != 0) {
            for (kn knVar : this.c) {
                if (knVar instanceof hj6) {
                    ((hj6) knVar).setOnAdapterItemClickListener(hoVar);
                } else if ((knVar instanceof ln6) || (knVar instanceof rn6)) {
                    knVar.setOnAdapterItemClickListener(hoVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.wn6
    public boolean k(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (kn knVar : this.c) {
                if (knVar != null && knVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.wn6
    public void l(cj6 cj6Var) {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, cj6Var) == null) && (list = this.c) != null && list.size() != 0) {
            for (kn knVar : this.c) {
                if (knVar instanceof hj6) {
                    ((hj6) knVar).x(cj6Var);
                }
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && (list = this.c) != null && list.size() != 0) {
            for (kn knVar : this.c) {
                if (knVar instanceof hj6) {
                    ((hj6) knVar).y(frsViewData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.wn6
    public void e() {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.c) != null && list.size() != 0) {
            for (kn knVar : this.c) {
                if (knVar instanceof hj6) {
                    ((hj6) knVar).m(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            z(this.c);
        }
    }

    @Override // com.baidu.tieba.wn6
    public void g(ArrayList<xn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            lo8.f(arrayList, 1);
            n(arrayList);
            x(arrayList);
            r(arrayList);
            Iterator<xn> it = arrayList.iterator();
            while (it.hasNext()) {
                xn next = it.next();
                if ((next instanceof xu4) && ((xu4) next).t.isTop()) {
                    it.remove();
                }
            }
            this.b.setData(arrayList);
            this.f = frsViewData;
            w();
            y();
            this.e = arrayList;
        }
    }

    public final ArrayList<Integer> n(ArrayList<xn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                for (int i = 0; i < arrayList.size(); i++) {
                    xn xnVar = arrayList.get(i);
                    if (xnVar instanceof AdvertAppInfo) {
                        arrayList2.add(Integer.valueOf(i));
                        HashMap<Integer, ThreadData> hashMap = this.d;
                        if (hashMap != null && !hashMap.containsValue(xnVar)) {
                            this.d.put(Integer.valueOf(i), (ThreadData) xnVar);
                        }
                    }
                }
                return arrayList2;
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void x(ArrayList<xn> arrayList) {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, arrayList) == null) && (list = this.c) != null && list.size() != 0) {
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<xn> it = arrayList.iterator();
                while (it.hasNext() && it.next().getType().getId() == ThreadData.TYPE_TOP.getId()) {
                    i++;
                }
            }
            for (kn knVar : this.c) {
                if (knVar instanceof hj6) {
                    ((hj6) knVar).D(i);
                }
            }
        }
    }

    public void o(FrsFragment frsFragment, Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, frsFragment, cdo) == null) {
            this.a = frsFragment;
            this.j = bj6.e().c(frsFragment.getPageContext(), oo8.d, this.a.getUniqueId(), false);
            qn6 qn6Var = new qn6(frsFragment.o(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = qn6Var;
            qn6Var.A(cdo);
            cn6 cn6Var = new cn6(frsFragment.o(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = cn6Var;
            cn6Var.A(cdo);
            nn6 nn6Var = new nn6(frsFragment.o(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = nn6Var;
            nn6Var.A(cdo);
            kn6 kn6Var = new kn6(frsFragment.o(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = kn6Var;
            kn6Var.A(cdo);
            bn6 bn6Var = new bn6(frsFragment.o(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = bn6Var;
            bn6Var.A(cdo);
            en6 en6Var = new en6(frsFragment.o(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = en6Var;
            en6Var.A(cdo);
            sn6 sn6Var = new sn6(frsFragment.o(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = sn6Var;
            sn6Var.A(cdo);
            on6 on6Var = new on6(frsFragment.o(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = on6Var;
            on6Var.A(cdo);
            mn6 mn6Var = new mn6(frsFragment.o(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = mn6Var;
            mn6Var.A(cdo);
            jn6 jn6Var = new jn6(frsFragment.o(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = jn6Var;
            jn6Var.A(cdo);
            rn6 rn6Var = new rn6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = rn6Var;
            rn6Var.A(cdo);
            dn6 dn6Var = new dn6(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = dn6Var;
            dn6Var.A(cdo);
            hn6 hn6Var = new hn6(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            hn6Var.A(cdo);
            pn6 pn6Var = new pn6(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            pn6Var.A(cdo);
            rm6 rm6Var = new rm6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            rm6Var.A(cdo);
            rm6Var.p(1);
            tm6 tm6Var = new tm6(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            tm6Var.A(cdo);
            sm6 sm6Var = new sm6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            sm6Var.A(cdo);
            sm6Var.e0(true);
            xm6 xm6Var = new xm6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            xm6Var.A(cdo);
            xm6Var.e0(true);
            ym6 ym6Var = new ym6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            ym6Var.A(cdo);
            ym6Var.f0(true);
            rn6 rn6Var2 = new rn6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            rn6Var2.A(cdo);
            gn6 gn6Var = new gn6(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            gn6Var.A(cdo);
            fn6 fn6Var = new fn6(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            fn6Var.A(cdo);
            this.i = new vn6(frsFragment.getPageContext(), go8.c, this.a.getUniqueId());
            ln6 ln6Var = new ln6(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = ln6Var;
            ln6Var.A(cdo);
            kn<? extends xu4, ? extends TypeAdapter.ViewHolder> a = bj6.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            kn<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = bj6.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            oj6 oj6Var = new oj6(frsFragment.getPageContext(), pj6.b);
            zm6 zm6Var = new zm6(frsFragment.getPageContext(), sj6.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), uj6.e, this.a.getUniqueId());
            vm6 vm6Var = new vm6(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            vm6Var.v((BdTypeRecyclerView) cdo);
            an6 an6Var = new an6(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            qm6 qm6Var = new qm6(frsFragment.o(), rr5.g);
            this.c.add(this.j);
            this.c.add(this.k);
            this.c.add(this.l);
            this.c.add(this.m);
            this.c.add(this.n);
            this.c.add(this.o);
            this.c.add(this.p);
            this.c.add(this.q);
            this.c.add(this.r);
            this.c.add(this.s);
            this.c.add(this.t);
            this.c.add(this.i);
            this.c.add(hn6Var);
            this.c.add(pn6Var);
            this.c.add(rm6Var);
            this.c.add(tm6Var);
            this.c.add(sm6Var);
            this.c.add(xm6Var);
            this.c.add(ym6Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(oj6Var);
            this.c.add(zm6Var);
            this.c.add(gn6Var);
            this.c.add(fn6Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(rn6Var2);
            this.c.add(vm6Var);
            this.c.add(an6Var);
            this.c.add(qm6Var);
            this.c.add(zw6.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_hot_tab"));
            jp5 jp5Var = new jp5(this.a, 1);
            jp5Var.u(this.c);
            jp5Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, jp5Var));
            z(this.c);
            cdo.a(this.c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            s("page_frs");
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<kn<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    kn<?, ?> next = it.next();
                    if (next instanceof hj6) {
                        ((hj6) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<kn> list = this.c;
                if (list != null) {
                    list.addAll(arrayList);
                }
                Cdo cdo2 = this.b;
                if (cdo2 != null) {
                    cdo2.a(arrayList);
                }
            }
        }
    }

    @Override // com.baidu.tieba.wn6
    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (kn knVar : this.c) {
                if (knVar instanceof hj6) {
                    ((hj6) knVar).v();
                } else if (knVar instanceof yf8) {
                    ((yf8) knVar).onDestroy();
                }
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || ListUtils.isEmpty(this.c) || this.a == null) {
            return;
        }
        for (kn knVar : this.c) {
            if (knVar instanceof hj6) {
                ((hj6) knVar).C(this.a.getTbPageTag());
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        vn6 vn6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (frsViewData = this.f) != null && frsViewData.getForum() != null && !StringUtils.isNull(this.f.getForum().getId()) && (vn6Var = this.i) != null) {
            vn6Var.K(this.f.getForum().getId());
        }
    }

    public final void r(ArrayList<xn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                xn xnVar = (xn) ListUtils.getItem(arrayList, i - 1);
                xn xnVar2 = (xn) ListUtils.getItem(arrayList, i);
                if (xnVar2 instanceof xu4) {
                    ThreadData threadData = ((xu4) xnVar2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (xnVar instanceof sj6) {
                        threadData.needTopMargin = false;
                    } else if (xnVar != null && !p(xnVar)) {
                        threadData.needTopMargin = false;
                    } else if ((xnVar instanceof xu4) && p(xnVar) && !TextUtils.isEmpty(((xu4) xnVar).t.getRecomReason())) {
                        threadData.needTopMargin = true;
                    } else if (p(xnVar2) && !TextUtils.isEmpty(recomReason)) {
                        threadData.needTopMargin = true;
                    } else {
                        threadData.needTopMargin = false;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.wn6
    public void setFromCDN(boolean z) {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (list = this.c) != null && list.size() != 0) {
            for (kn knVar : this.c) {
                if (knVar instanceof hj6) {
                    ((hj6) knVar).setFromCDN(z);
                }
            }
            qn6 qn6Var = this.k;
            if (qn6Var != null) {
                qn6Var.setFromCDN(z);
            }
            cn6 cn6Var = this.l;
            if (cn6Var != null) {
                cn6Var.setFromCDN(z);
            }
            nn6 nn6Var = this.m;
            if (nn6Var != null) {
                nn6Var.setFromCDN(z);
            }
            kn6 kn6Var = this.n;
            if (kn6Var != null) {
                kn6Var.setFromCDN(z);
            }
            bn6 bn6Var = this.o;
            if (bn6Var != null) {
                bn6Var.setFromCDN(z);
            }
            en6 en6Var = this.p;
            if (en6Var != null) {
                en6Var.setFromCDN(z);
            }
            rn6 rn6Var = this.u;
            if (rn6Var != null) {
                rn6Var.setFromCDN(z);
            }
            ln6 ln6Var = this.w;
            if (ln6Var != null) {
                ln6Var.setFromCDN(z);
            }
        }
    }

    public void t(String str) {
        List<kn> list;
        Class<?> cls;
        Class<?> cls2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, str) == null) && (list = this.c) != null && list.size() != 0) {
            try {
                cls = Class.forName("com.baidu.tieba.InjectPlugin.FrsFeedAd.FrsFeedAdAdapter");
                cls2 = Class.forName("com.baidu.tieba.funad.adapter.FunAdNativeNewAdapter");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return;
            }
            for (kn knVar : this.c) {
                if (knVar != null) {
                    Class<?> cls3 = knVar.getClass();
                    if (cls3 == cls) {
                        try {
                            cls3.getDeclaredMethod("setTab", String.class).invoke(knVar, str);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else if (cls3 == cls2) {
                        try {
                            cls3.getDeclaredMethod("setPageTab", String.class).invoke(knVar, str);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    e.printStackTrace();
                    return;
                }
            }
        }
    }
}
