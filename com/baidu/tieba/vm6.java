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
/* loaded from: classes6.dex */
public class vm6 implements jn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public co b;
    public List<jn> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<wn> e;
    public FrsViewData f;
    public boolean g;
    public final si6 h;
    public in6 i;
    public jn j;
    public dn6 k;
    public pm6 l;
    public an6 m;
    public xm6 n;
    public om6 o;
    public rm6 p;
    public bn6 q;
    public fn6 r;
    public zm6 s;
    public wm6 t;
    public en6 u;
    public qm6 v;
    public ym6 w;

    public vm6(FrsFragment frsFragment, co coVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, coVar, Boolean.valueOf(z)};
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
        this.b = coVar;
        this.h = new si6();
        o(frsFragment, coVar);
        this.d = new HashMap<>();
        m(z);
    }

    @Override // com.baidu.tieba.jn6
    public void a(String str) {
        List<jn> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (jn jnVar : list) {
            if (jnVar instanceof x36) {
                ((x36) jnVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.jn6
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && this.g != z) {
            this.g = z;
        }
    }

    public final boolean p(wn wnVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, wnVar)) == null) {
            if (wnVar == null) {
                return false;
            }
            BdUniqueId type = wnVar.getType();
            if (type != ThreadData.TYPE_NORMAL && type != ThreadData.TYPE_GOD_NORMAL && type != ThreadData.TYPE_VIDEO && type != ThreadData.TYPE_VIDEO_GOD && type != ThreadData.TYPE_INSERT_VIDEO) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void s(String str) {
        List<jn> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (jn jnVar : list) {
            if (jnVar instanceof zp5) {
                ((zp5) jnVar).g(str);
            }
        }
    }

    public final void z(List<jn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, list) != null) || list == null) {
            return;
        }
        for (jn jnVar : list) {
            if (jnVar instanceof ui6) {
                ((ui6) jnVar).w(this.h);
            }
        }
    }

    @Override // com.baidu.tieba.jn6
    public void b() {
        co coVar;
        List<wn> data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (coVar = this.b) != null && coVar.getData() != null && this.b.getData().size() != 0 && (data = this.b.getData()) != null && data.size() != 0) {
            for (wn wnVar : data) {
                if (wnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) wnVar;
                    if (threadData.getIs_top() != 0) {
                        threadData.parser_title();
                    }
                } else if (wnVar instanceof vu4) {
                    vu4 vu4Var = (vu4) wnVar;
                    if (vu4Var.t.getIs_top() != 0) {
                        vu4Var.t.parser_title();
                    }
                }
            }
        }
    }

    public final void w() {
        qt6 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.f == null) {
            return;
        }
        for (jn jnVar : this.c) {
            if ((jnVar instanceof st6) && (i = ((st6) jnVar).i()) != null) {
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

    @Override // com.baidu.tieba.jn6
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090b37;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.jn6
    public List<wn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            co coVar = this.b;
            if (coVar != null) {
                return coVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jn6
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jn6
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090b12;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.jn6
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090bdd;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.jn6
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.b.getListAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList<wn> arrayList = this.e;
            if (arrayList != null) {
                this.b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.jn6
    public void d(go goVar) {
        List<jn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, goVar) == null) && (list = this.c) != null && list.size() != 0) {
            for (jn jnVar : this.c) {
                if (jnVar instanceof ui6) {
                    ((ui6) jnVar).setOnAdapterItemClickListener(goVar);
                } else if ((jnVar instanceof ym6) || (jnVar instanceof en6)) {
                    jnVar.setOnAdapterItemClickListener(goVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.jn6
    public boolean k(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (jn jnVar : this.c) {
                if (jnVar != null && jnVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.jn6
    public void l(pi6 pi6Var) {
        List<jn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, pi6Var) == null) && (list = this.c) != null && list.size() != 0) {
            for (jn jnVar : this.c) {
                if (jnVar instanceof ui6) {
                    ((ui6) jnVar).x(pi6Var);
                }
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<jn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && (list = this.c) != null && list.size() != 0) {
            for (jn jnVar : this.c) {
                if (jnVar instanceof ui6) {
                    ((ui6) jnVar).y(frsViewData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.jn6
    public void e() {
        List<jn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.c) != null && list.size() != 0) {
            for (jn jnVar : this.c) {
                if (jnVar instanceof ui6) {
                    ((ui6) jnVar).m(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            z(this.c);
        }
    }

    @Override // com.baidu.tieba.jn6
    public void g(ArrayList<wn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            zn8.f(arrayList, 1);
            n(arrayList);
            x(arrayList);
            r(arrayList);
            Iterator<wn> it = arrayList.iterator();
            while (it.hasNext()) {
                wn next = it.next();
                if ((next instanceof vu4) && ((vu4) next).t.isTop()) {
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

    public final ArrayList<Integer> n(ArrayList<wn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                for (int i = 0; i < arrayList.size(); i++) {
                    wn wnVar = arrayList.get(i);
                    if (wnVar instanceof AdvertAppInfo) {
                        arrayList2.add(Integer.valueOf(i));
                        HashMap<Integer, ThreadData> hashMap = this.d;
                        if (hashMap != null && !hashMap.containsValue(wnVar)) {
                            this.d.put(Integer.valueOf(i), (ThreadData) wnVar);
                        }
                    }
                }
                return arrayList2;
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void x(ArrayList<wn> arrayList) {
        List<jn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, arrayList) == null) && (list = this.c) != null && list.size() != 0) {
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<wn> it = arrayList.iterator();
                while (it.hasNext() && it.next().getType().getId() == ThreadData.TYPE_TOP.getId()) {
                    i++;
                }
            }
            for (jn jnVar : this.c) {
                if (jnVar instanceof ui6) {
                    ((ui6) jnVar).D(i);
                }
            }
        }
    }

    public void o(FrsFragment frsFragment, co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, frsFragment, coVar) == null) {
            this.a = frsFragment;
            this.j = oi6.e().c(frsFragment.getPageContext(), co8.d, this.a.getUniqueId(), false);
            dn6 dn6Var = new dn6(frsFragment.o(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = dn6Var;
            dn6Var.A(coVar);
            pm6 pm6Var = new pm6(frsFragment.o(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = pm6Var;
            pm6Var.A(coVar);
            an6 an6Var = new an6(frsFragment.o(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = an6Var;
            an6Var.A(coVar);
            xm6 xm6Var = new xm6(frsFragment.o(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = xm6Var;
            xm6Var.A(coVar);
            om6 om6Var = new om6(frsFragment.o(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = om6Var;
            om6Var.A(coVar);
            rm6 rm6Var = new rm6(frsFragment.o(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = rm6Var;
            rm6Var.A(coVar);
            fn6 fn6Var = new fn6(frsFragment.o(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = fn6Var;
            fn6Var.A(coVar);
            bn6 bn6Var = new bn6(frsFragment.o(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = bn6Var;
            bn6Var.A(coVar);
            zm6 zm6Var = new zm6(frsFragment.o(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = zm6Var;
            zm6Var.A(coVar);
            wm6 wm6Var = new wm6(frsFragment.o(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = wm6Var;
            wm6Var.A(coVar);
            en6 en6Var = new en6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = en6Var;
            en6Var.A(coVar);
            qm6 qm6Var = new qm6(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = qm6Var;
            qm6Var.A(coVar);
            um6 um6Var = new um6(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            um6Var.A(coVar);
            cn6 cn6Var = new cn6(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            cn6Var.A(coVar);
            em6 em6Var = new em6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            em6Var.A(coVar);
            em6Var.p(1);
            gm6 gm6Var = new gm6(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            gm6Var.A(coVar);
            fm6 fm6Var = new fm6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            fm6Var.A(coVar);
            fm6Var.e0(true);
            km6 km6Var = new km6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            km6Var.A(coVar);
            km6Var.e0(true);
            lm6 lm6Var = new lm6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            lm6Var.A(coVar);
            lm6Var.f0(true);
            en6 en6Var2 = new en6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            en6Var2.A(coVar);
            tm6 tm6Var = new tm6(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            tm6Var.A(coVar);
            sm6 sm6Var = new sm6(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            sm6Var.A(coVar);
            this.i = new in6(frsFragment.getPageContext(), un8.c, this.a.getUniqueId());
            ym6 ym6Var = new ym6(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = ym6Var;
            ym6Var.A(coVar);
            jn<? extends vu4, ? extends TypeAdapter.ViewHolder> a = oi6.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            jn<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = oi6.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            bj6 bj6Var = new bj6(frsFragment.getPageContext(), cj6.b);
            mm6 mm6Var = new mm6(frsFragment.getPageContext(), fj6.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), hj6.e, this.a.getUniqueId());
            im6 im6Var = new im6(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            im6Var.v((BdTypeRecyclerView) coVar);
            nm6 nm6Var = new nm6(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            dm6 dm6Var = new dm6(frsFragment.o(), er5.g);
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
            this.c.add(um6Var);
            this.c.add(cn6Var);
            this.c.add(em6Var);
            this.c.add(gm6Var);
            this.c.add(fm6Var);
            this.c.add(km6Var);
            this.c.add(lm6Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(bj6Var);
            this.c.add(mm6Var);
            this.c.add(tm6Var);
            this.c.add(sm6Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(en6Var2);
            this.c.add(im6Var);
            this.c.add(nm6Var);
            this.c.add(dm6Var);
            this.c.add(nw6.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_hot_tab"));
            wo5 wo5Var = new wo5(this.a, 1);
            wo5Var.u(this.c);
            wo5Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, wo5Var));
            z(this.c);
            coVar.a(this.c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            s("page_frs");
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<jn<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    jn<?, ?> next = it.next();
                    if (next instanceof ui6) {
                        ((ui6) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<jn> list = this.c;
                if (list != null) {
                    list.addAll(arrayList);
                }
                co coVar2 = this.b;
                if (coVar2 != null) {
                    coVar2.a(arrayList);
                }
            }
        }
    }

    @Override // com.baidu.tieba.jn6
    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (jn jnVar : this.c) {
                if (jnVar instanceof ui6) {
                    ((ui6) jnVar).v();
                } else if (jnVar instanceof mf8) {
                    ((mf8) jnVar).onDestroy();
                }
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || ListUtils.isEmpty(this.c) || this.a == null) {
            return;
        }
        for (jn jnVar : this.c) {
            if (jnVar instanceof ui6) {
                ((ui6) jnVar).C(this.a.getTbPageTag());
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        in6 in6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (frsViewData = this.f) != null && frsViewData.getForum() != null && !StringUtils.isNull(this.f.getForum().getId()) && (in6Var = this.i) != null) {
            in6Var.K(this.f.getForum().getId());
        }
    }

    public final void r(ArrayList<wn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                wn wnVar = (wn) ListUtils.getItem(arrayList, i - 1);
                wn wnVar2 = (wn) ListUtils.getItem(arrayList, i);
                if (wnVar2 instanceof vu4) {
                    ThreadData threadData = ((vu4) wnVar2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (wnVar instanceof fj6) {
                        threadData.needTopMargin = false;
                    } else if (wnVar != null && !p(wnVar)) {
                        threadData.needTopMargin = false;
                    } else if ((wnVar instanceof vu4) && p(wnVar) && !TextUtils.isEmpty(((vu4) wnVar).t.getRecomReason())) {
                        threadData.needTopMargin = true;
                    } else if (p(wnVar2) && !TextUtils.isEmpty(recomReason)) {
                        threadData.needTopMargin = true;
                    } else {
                        threadData.needTopMargin = false;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.jn6
    public void setFromCDN(boolean z) {
        List<jn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (list = this.c) != null && list.size() != 0) {
            for (jn jnVar : this.c) {
                if (jnVar instanceof ui6) {
                    ((ui6) jnVar).setFromCDN(z);
                }
            }
            dn6 dn6Var = this.k;
            if (dn6Var != null) {
                dn6Var.setFromCDN(z);
            }
            pm6 pm6Var = this.l;
            if (pm6Var != null) {
                pm6Var.setFromCDN(z);
            }
            an6 an6Var = this.m;
            if (an6Var != null) {
                an6Var.setFromCDN(z);
            }
            xm6 xm6Var = this.n;
            if (xm6Var != null) {
                xm6Var.setFromCDN(z);
            }
            om6 om6Var = this.o;
            if (om6Var != null) {
                om6Var.setFromCDN(z);
            }
            rm6 rm6Var = this.p;
            if (rm6Var != null) {
                rm6Var.setFromCDN(z);
            }
            en6 en6Var = this.u;
            if (en6Var != null) {
                en6Var.setFromCDN(z);
            }
            ym6 ym6Var = this.w;
            if (ym6Var != null) {
                ym6Var.setFromCDN(z);
            }
        }
    }

    public void t(String str) {
        List<jn> list;
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
            for (jn jnVar : this.c) {
                if (jnVar != null) {
                    Class<?> cls3 = jnVar.getClass();
                    if (cls3 == cls) {
                        try {
                            cls3.getDeclaredMethod("setTab", String.class).invoke(jnVar, str);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else if (cls3 == cls2) {
                        try {
                            cls3.getDeclaredMethod("setPageTab", String.class).invoke(jnVar, str);
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
