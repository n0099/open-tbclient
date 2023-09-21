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
/* loaded from: classes9.dex */
public class zm7 implements nn7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public hn b;
    public List<om> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<bn> e;
    public FrsViewData f;
    public boolean g;
    public final ni7 h;
    public mn7 i;
    public om j;
    public hn7 k;
    public tm7 l;
    public en7 m;
    public bn7 n;
    public sm7 o;
    public vm7 p;
    public fn7 q;
    public jn7 r;
    public dn7 s;
    public an7 t;
    public in7 u;
    public um7 v;
    public cn7 w;

    public zm7(FrsFragment frsFragment, hn hnVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, hnVar, Boolean.valueOf(z)};
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
        this.b = hnVar;
        this.h = new ni7();
        o(frsFragment, hnVar);
        this.d = new HashMap<>();
        m(z);
    }

    @Override // com.baidu.tieba.nn7
    public void a(String str) {
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (om omVar : list) {
            if (omVar instanceof qp6) {
                ((qp6) omVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.nn7
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && this.g != z) {
            this.g = z;
        }
    }

    public final boolean p(bn bnVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, bnVar)) == null) {
            if (bnVar == null) {
                return false;
            }
            BdUniqueId type = bnVar.getType();
            if (type != ThreadData.TYPE_NORMAL && type != ThreadData.TYPE_GOD_NORMAL && type != ThreadData.TYPE_VIDEO && type != ThreadData.TYPE_VIDEO_GOD && type != ThreadData.TYPE_INSERT_VIDEO) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void s(String str) {
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (om omVar : list) {
            if (omVar instanceof p56) {
                ((p56) omVar).g(str);
            }
        }
    }

    public final void z(List<om> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, list) != null) || list == null) {
            return;
        }
        for (om omVar : list) {
            if (omVar instanceof pi7) {
                ((pi7) omVar).y(this.h);
            }
        }
    }

    @Override // com.baidu.tieba.nn7
    public void b() {
        hn hnVar;
        List<bn> data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (hnVar = this.b) != null && hnVar.getData() != null && this.b.getData().size() != 0 && (data = this.b.getData()) != null && data.size() != 0) {
            for (bn bnVar : data) {
                if (bnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) bnVar;
                    if (threadData.getIs_top() != 0) {
                        threadData.parser_title();
                    }
                } else if (bnVar instanceof h45) {
                    h45 h45Var = (h45) bnVar;
                    if (h45Var.t.getIs_top() != 0) {
                        h45Var.t.parser_title();
                    }
                }
            }
        }
    }

    public final void w() {
        wt7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.f == null) {
            return;
        }
        for (om omVar : this.c) {
            if ((omVar instanceof yt7) && (i = ((yt7) omVar).i()) != null) {
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
                if (frsFragment != null && frsFragment.m1() != null) {
                    int h0 = this.a.m1().h0();
                    if (h0 == -1) {
                        h0 = this.a.m1().g0();
                    }
                    i.b = h0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.nn7
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090c88;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.nn7
    public List<bn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            hn hnVar = this.b;
            if (hnVar != null) {
                return hnVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nn7
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nn7
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090c63;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.nn7
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090d2f;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.nn7
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.b.getListAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList<bn> arrayList = this.e;
            if (arrayList != null) {
                this.b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.nn7
    public void d(ln lnVar) {
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, lnVar) == null) && (list = this.c) != null && list.size() != 0) {
            for (om omVar : this.c) {
                if (omVar instanceof pi7) {
                    ((pi7) omVar).setOnAdapterItemClickListener(lnVar);
                } else if ((omVar instanceof cn7) || (omVar instanceof in7)) {
                    omVar.setOnAdapterItemClickListener(lnVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.nn7
    public boolean k(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (om omVar : this.c) {
                if (omVar != null && omVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.nn7
    public void l(ki7 ki7Var) {
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, ki7Var) == null) && (list = this.c) != null && list.size() != 0) {
            for (om omVar : this.c) {
                if (omVar instanceof pi7) {
                    ((pi7) omVar).z(ki7Var);
                }
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && (list = this.c) != null && list.size() != 0) {
            for (om omVar : this.c) {
                if (omVar instanceof pi7) {
                    ((pi7) omVar).A(frsViewData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.nn7
    public void e() {
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.c) != null && list.size() != 0) {
            for (om omVar : this.c) {
                if (omVar instanceof pi7) {
                    ((pi7) omVar).m(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            z(this.c);
        }
    }

    @Override // com.baidu.tieba.nn7
    public void g(ArrayList<bn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            zia.f(arrayList, 1);
            n(arrayList);
            x(arrayList);
            r(arrayList);
            Iterator<bn> it = arrayList.iterator();
            while (it.hasNext()) {
                bn next = it.next();
                if ((next instanceof h45) && ((h45) next).t.isTop()) {
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

    public final ArrayList<Integer> n(ArrayList<bn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                for (int i = 0; i < arrayList.size(); i++) {
                    bn bnVar = arrayList.get(i);
                    if (bnVar instanceof AdvertAppInfo) {
                        arrayList2.add(Integer.valueOf(i));
                        HashMap<Integer, ThreadData> hashMap = this.d;
                        if (hashMap != null && !hashMap.containsValue(bnVar)) {
                            this.d.put(Integer.valueOf(i), (ThreadData) bnVar);
                        }
                    }
                }
                return arrayList2;
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void x(ArrayList<bn> arrayList) {
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, arrayList) == null) && (list = this.c) != null && list.size() != 0) {
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<bn> it = arrayList.iterator();
                while (it.hasNext() && it.next().getType().getId() == ThreadData.TYPE_TOP.getId()) {
                    i++;
                }
            }
            for (om omVar : this.c) {
                if (omVar instanceof pi7) {
                    ((pi7) omVar).F(i);
                }
            }
        }
    }

    public void o(FrsFragment frsFragment, hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, frsFragment, hnVar) == null) {
            this.a = frsFragment;
            this.j = ji7.e().c(frsFragment.getPageContext(), bja.d, this.a.getUniqueId(), false);
            hn7 hn7Var = new hn7(frsFragment.C(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = hn7Var;
            hn7Var.C(hnVar);
            tm7 tm7Var = new tm7(frsFragment.C(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = tm7Var;
            tm7Var.C(hnVar);
            en7 en7Var = new en7(frsFragment.C(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = en7Var;
            en7Var.C(hnVar);
            bn7 bn7Var = new bn7(frsFragment.C(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = bn7Var;
            bn7Var.C(hnVar);
            sm7 sm7Var = new sm7(frsFragment.C(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = sm7Var;
            sm7Var.C(hnVar);
            vm7 vm7Var = new vm7(frsFragment.C(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = vm7Var;
            vm7Var.C(hnVar);
            jn7 jn7Var = new jn7(frsFragment.C(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = jn7Var;
            jn7Var.C(hnVar);
            fn7 fn7Var = new fn7(frsFragment.C(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = fn7Var;
            fn7Var.C(hnVar);
            dn7 dn7Var = new dn7(frsFragment.C(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = dn7Var;
            dn7Var.C(hnVar);
            an7 an7Var = new an7(frsFragment.C(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = an7Var;
            an7Var.C(hnVar);
            in7 in7Var = new in7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = in7Var;
            in7Var.C(hnVar);
            um7 um7Var = new um7(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = um7Var;
            um7Var.C(hnVar);
            ym7 ym7Var = new ym7(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            ym7Var.C(hnVar);
            gn7 gn7Var = new gn7(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            gn7Var.C(hnVar);
            fm7 fm7Var = new fm7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            fm7Var.C(hnVar);
            fm7Var.q(1);
            hm7 hm7Var = new hm7(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            hm7Var.C(hnVar);
            gm7 gm7Var = new gm7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            gm7Var.C(hnVar);
            gm7Var.g0(true);
            nm7 nm7Var = new nm7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            nm7Var.C(hnVar);
            nm7Var.P(true);
            om7 om7Var = new om7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            om7Var.C(hnVar);
            om7Var.P(true);
            in7 in7Var2 = new in7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            in7Var2.C(hnVar);
            xm7 xm7Var = new xm7(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            xm7Var.C(hnVar);
            wm7 wm7Var = new wm7(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            wm7Var.C(hnVar);
            this.i = new mn7(frsFragment.getPageContext(), uia.c, this.a.getUniqueId());
            cn7 cn7Var = new cn7(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = cn7Var;
            cn7Var.C(hnVar);
            om<? extends h45, ? extends TypeAdapter.ViewHolder> a = ji7.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            om<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = ji7.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            wi7 wi7Var = new wi7(frsFragment.getPageContext(), xi7.b);
            qm7 qm7Var = new qm7(frsFragment.getPageContext(), aj7.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), cj7.e, this.a.getUniqueId());
            lm7 lm7Var = new lm7(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            lm7Var.x((BdTypeRecyclerView) hnVar);
            rm7 rm7Var = new rm7(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            dm7 dm7Var = new dm7(frsFragment.C(), w66.g);
            km7 km7Var = new km7(frsFragment.getPageContext(), iq6.A0);
            km7Var.u(hnVar);
            pm7 pm7Var = new pm7(frsFragment.getPageContext(), nq6.j);
            pm7Var.u(hnVar);
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
            this.c.add(ym7Var);
            this.c.add(gn7Var);
            this.c.add(fm7Var);
            this.c.add(hm7Var);
            this.c.add(gm7Var);
            this.c.add(nm7Var);
            this.c.add(om7Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(wi7Var);
            this.c.add(qm7Var);
            this.c.add(xm7Var);
            this.c.add(wm7Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(in7Var2);
            this.c.add(lm7Var);
            this.c.add(rm7Var);
            this.c.add(dm7Var);
            this.c.add(new jm7(frsFragment.getPageContext()));
            this.c.add(km7Var);
            this.c.add(pm7Var);
            this.c.add(ly7.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.I, "frs_hot_tab"));
            m46 m46Var = new m46(this.a, 1);
            m46Var.u(this.c);
            m46Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, m46Var));
            z(this.c);
            hnVar.addAdapters(this.c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            s("page_frs");
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<om<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    om<?, ?> next = it.next();
                    if (next instanceof pi7) {
                        ((pi7) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<om> list = this.c;
                if (list != null) {
                    list.addAll(arrayList);
                }
                hn hnVar2 = this.b;
                if (hnVar2 != null) {
                    hnVar2.addAdapters(arrayList);
                }
            }
        }
    }

    @Override // com.baidu.tieba.nn7
    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (om omVar : this.c) {
                if (omVar instanceof pi7) {
                    ((pi7) omVar).x();
                } else if (omVar instanceof w4a) {
                    ((w4a) omVar).onDestroy();
                }
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || ListUtils.isEmpty(this.c) || this.a == null) {
            return;
        }
        for (om omVar : this.c) {
            if (omVar instanceof pi7) {
                ((pi7) omVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        mn7 mn7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (frsViewData = this.f) != null && frsViewData.getForum() != null && !StringUtils.isNull(this.f.getForum().getId()) && (mn7Var = this.i) != null) {
            mn7Var.L(this.f.getForum().getId());
        }
    }

    public final void r(ArrayList<bn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                bn bnVar = (bn) ListUtils.getItem(arrayList, i - 1);
                bn bnVar2 = (bn) ListUtils.getItem(arrayList, i);
                if (bnVar2 instanceof h45) {
                    ThreadData threadData = ((h45) bnVar2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (bnVar instanceof aj7) {
                        threadData.needTopMargin = false;
                    } else if (bnVar != null && !p(bnVar)) {
                        threadData.needTopMargin = false;
                    } else if ((bnVar instanceof h45) && p(bnVar) && !TextUtils.isEmpty(((h45) bnVar).t.getRecomReason())) {
                        threadData.needTopMargin = true;
                    } else if (p(bnVar2) && !TextUtils.isEmpty(recomReason)) {
                        threadData.needTopMargin = true;
                    } else {
                        threadData.needTopMargin = false;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.nn7
    public void setFromCDN(boolean z) {
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (list = this.c) != null && list.size() != 0) {
            for (om omVar : this.c) {
                if (omVar instanceof pi7) {
                    ((pi7) omVar).setFromCDN(z);
                }
            }
            hn7 hn7Var = this.k;
            if (hn7Var != null) {
                hn7Var.setFromCDN(z);
            }
            tm7 tm7Var = this.l;
            if (tm7Var != null) {
                tm7Var.setFromCDN(z);
            }
            en7 en7Var = this.m;
            if (en7Var != null) {
                en7Var.setFromCDN(z);
            }
            bn7 bn7Var = this.n;
            if (bn7Var != null) {
                bn7Var.setFromCDN(z);
            }
            sm7 sm7Var = this.o;
            if (sm7Var != null) {
                sm7Var.setFromCDN(z);
            }
            vm7 vm7Var = this.p;
            if (vm7Var != null) {
                vm7Var.setFromCDN(z);
            }
            in7 in7Var = this.u;
            if (in7Var != null) {
                in7Var.setFromCDN(z);
            }
            cn7 cn7Var = this.w;
            if (cn7Var != null) {
                cn7Var.setFromCDN(z);
            }
        }
    }

    public void t(String str) {
        List<om> list;
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
            for (om omVar : this.c) {
                if (omVar != null) {
                    Class<?> cls3 = omVar.getClass();
                    if (cls3 == cls) {
                        try {
                            cls3.getDeclaredMethod("setTab", String.class).invoke(omVar, str);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else if (cls3 == cls2) {
                        try {
                            cls3.getDeclaredMethod("setPageTab", String.class).invoke(omVar, str);
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
