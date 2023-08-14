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
public class lj7 implements zj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public en b;
    public List<lm> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<ym> e;
    public FrsViewData f;
    public boolean g;
    public final ff7 h;
    public yj7 i;
    public lm j;
    public tj7 k;
    public fj7 l;
    public qj7 m;
    public nj7 n;
    public ej7 o;
    public hj7 p;
    public rj7 q;
    public vj7 r;
    public pj7 s;
    public mj7 t;
    public uj7 u;
    public gj7 v;
    public oj7 w;

    public lj7(FrsFragment frsFragment, en enVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, enVar, Boolean.valueOf(z)};
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
        this.b = enVar;
        this.h = new ff7();
        o(frsFragment, enVar);
        this.d = new HashMap<>();
        m(z);
    }

    @Override // com.baidu.tieba.zj7
    public void a(String str) {
        List<lm> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (lm lmVar : list) {
            if (lmVar instanceof an6) {
                ((an6) lmVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.zj7
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && this.g != z) {
            this.g = z;
        }
    }

    public final boolean p(ym ymVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, ymVar)) == null) {
            if (ymVar == null) {
                return false;
            }
            BdUniqueId type = ymVar.getType();
            if (type != ThreadData.TYPE_NORMAL && type != ThreadData.TYPE_GOD_NORMAL && type != ThreadData.TYPE_VIDEO && type != ThreadData.TYPE_VIDEO_GOD && type != ThreadData.TYPE_INSERT_VIDEO) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void s(String str) {
        List<lm> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (lm lmVar : list) {
            if (lmVar instanceof b46) {
                ((b46) lmVar).g(str);
            }
        }
    }

    public final void z(List<lm> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, list) != null) || list == null) {
            return;
        }
        for (lm lmVar : list) {
            if (lmVar instanceof hf7) {
                ((hf7) lmVar).y(this.h);
            }
        }
    }

    @Override // com.baidu.tieba.zj7
    public void b() {
        en enVar;
        List<ym> data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (enVar = this.b) != null && enVar.getData() != null && this.b.getData().size() != 0 && (data = this.b.getData()) != null && data.size() != 0) {
            for (ym ymVar : data) {
                if (ymVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) ymVar;
                    if (threadData.getIs_top() != 0) {
                        threadData.parser_title();
                    }
                } else if (ymVar instanceof w35) {
                    w35 w35Var = (w35) ymVar;
                    if (w35Var.t.getIs_top() != 0) {
                        w35Var.t.parser_title();
                    }
                }
            }
        }
    }

    public final void w() {
        rq7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.f == null) {
            return;
        }
        for (lm lmVar : this.c) {
            if ((lmVar instanceof tq7) && (i = ((tq7) lmVar).i()) != null) {
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
                if (frsFragment != null && frsFragment.W0() != null) {
                    int i0 = this.a.W0().i0();
                    if (i0 == -1) {
                        i0 = this.a.W0().h0();
                    }
                    i.b = i0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.zj7
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090c8c;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.zj7
    public List<ym> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            en enVar = this.b;
            if (enVar != null) {
                return enVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zj7
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zj7
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090c67;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.zj7
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090d33;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.zj7
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.b.getListAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList<ym> arrayList = this.e;
            if (arrayList != null) {
                this.b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.zj7
    public void d(in inVar) {
        List<lm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, inVar) == null) && (list = this.c) != null && list.size() != 0) {
            for (lm lmVar : this.c) {
                if (lmVar instanceof hf7) {
                    ((hf7) lmVar).setOnAdapterItemClickListener(inVar);
                } else if ((lmVar instanceof oj7) || (lmVar instanceof uj7)) {
                    lmVar.setOnAdapterItemClickListener(inVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.zj7
    public boolean k(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (lm lmVar : this.c) {
                if (lmVar != null && lmVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.zj7
    public void l(cf7 cf7Var) {
        List<lm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, cf7Var) == null) && (list = this.c) != null && list.size() != 0) {
            for (lm lmVar : this.c) {
                if (lmVar instanceof hf7) {
                    ((hf7) lmVar).z(cf7Var);
                }
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<lm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && (list = this.c) != null && list.size() != 0) {
            for (lm lmVar : this.c) {
                if (lmVar instanceof hf7) {
                    ((hf7) lmVar).A(frsViewData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.zj7
    public void e() {
        List<lm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.c) != null && list.size() != 0) {
            for (lm lmVar : this.c) {
                if (lmVar instanceof hf7) {
                    ((hf7) lmVar).m(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            z(this.c);
        }
    }

    @Override // com.baidu.tieba.zj7
    public void g(ArrayList<ym> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            saa.f(arrayList, 1);
            n(arrayList);
            x(arrayList);
            r(arrayList);
            Iterator<ym> it = arrayList.iterator();
            while (it.hasNext()) {
                ym next = it.next();
                if ((next instanceof w35) && ((w35) next).t.isTop()) {
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

    public final ArrayList<Integer> n(ArrayList<ym> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                for (int i = 0; i < arrayList.size(); i++) {
                    ym ymVar = arrayList.get(i);
                    if (ymVar instanceof AdvertAppInfo) {
                        arrayList2.add(Integer.valueOf(i));
                        HashMap<Integer, ThreadData> hashMap = this.d;
                        if (hashMap != null && !hashMap.containsValue(ymVar)) {
                            this.d.put(Integer.valueOf(i), (ThreadData) ymVar);
                        }
                    }
                }
                return arrayList2;
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void x(ArrayList<ym> arrayList) {
        List<lm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, arrayList) == null) && (list = this.c) != null && list.size() != 0) {
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<ym> it = arrayList.iterator();
                while (it.hasNext() && it.next().getType().getId() == ThreadData.TYPE_TOP.getId()) {
                    i++;
                }
            }
            for (lm lmVar : this.c) {
                if (lmVar instanceof hf7) {
                    ((hf7) lmVar).F(i);
                }
            }
        }
    }

    public void o(FrsFragment frsFragment, en enVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, frsFragment, enVar) == null) {
            this.a = frsFragment;
            this.j = bf7.e().c(frsFragment.getPageContext(), uaa.d, this.a.getUniqueId(), false);
            tj7 tj7Var = new tj7(frsFragment.u(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = tj7Var;
            tj7Var.C(enVar);
            fj7 fj7Var = new fj7(frsFragment.u(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = fj7Var;
            fj7Var.C(enVar);
            qj7 qj7Var = new qj7(frsFragment.u(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = qj7Var;
            qj7Var.C(enVar);
            nj7 nj7Var = new nj7(frsFragment.u(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = nj7Var;
            nj7Var.C(enVar);
            ej7 ej7Var = new ej7(frsFragment.u(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = ej7Var;
            ej7Var.C(enVar);
            hj7 hj7Var = new hj7(frsFragment.u(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = hj7Var;
            hj7Var.C(enVar);
            vj7 vj7Var = new vj7(frsFragment.u(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = vj7Var;
            vj7Var.C(enVar);
            rj7 rj7Var = new rj7(frsFragment.u(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = rj7Var;
            rj7Var.C(enVar);
            pj7 pj7Var = new pj7(frsFragment.u(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = pj7Var;
            pj7Var.C(enVar);
            mj7 mj7Var = new mj7(frsFragment.u(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = mj7Var;
            mj7Var.C(enVar);
            uj7 uj7Var = new uj7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = uj7Var;
            uj7Var.C(enVar);
            gj7 gj7Var = new gj7(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = gj7Var;
            gj7Var.C(enVar);
            kj7 kj7Var = new kj7(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            kj7Var.C(enVar);
            sj7 sj7Var = new sj7(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            sj7Var.C(enVar);
            si7 si7Var = new si7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            si7Var.C(enVar);
            si7Var.p(1);
            ui7 ui7Var = new ui7(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            ui7Var.C(enVar);
            ti7 ti7Var = new ti7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            ti7Var.C(enVar);
            ti7Var.g0(true);
            aj7 aj7Var = new aj7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            aj7Var.C(enVar);
            aj7Var.g0(true);
            bj7 bj7Var = new bj7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            bj7Var.C(enVar);
            bj7Var.h0(true);
            uj7 uj7Var2 = new uj7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            uj7Var2.C(enVar);
            jj7 jj7Var = new jj7(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            jj7Var.C(enVar);
            ij7 ij7Var = new ij7(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            ij7Var.C(enVar);
            this.i = new yj7(frsFragment.getPageContext(), naa.c, this.a.getUniqueId());
            oj7 oj7Var = new oj7(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = oj7Var;
            oj7Var.C(enVar);
            lm<? extends w35, ? extends TypeAdapter.ViewHolder> a = bf7.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            lm<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = bf7.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            of7 of7Var = new of7(frsFragment.getPageContext(), pf7.b);
            cj7 cj7Var = new cj7(frsFragment.getPageContext(), sf7.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), uf7.e, this.a.getUniqueId());
            yi7 yi7Var = new yi7(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            yi7Var.x((BdTypeRecyclerView) enVar);
            dj7 dj7Var = new dj7(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            ri7 ri7Var = new ri7(frsFragment.u(), i56.g);
            xi7 xi7Var = new xi7(frsFragment.getPageContext(), sn6.A0);
            xi7Var.u(enVar);
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
            this.c.add(kj7Var);
            this.c.add(sj7Var);
            this.c.add(si7Var);
            this.c.add(ui7Var);
            this.c.add(ti7Var);
            this.c.add(aj7Var);
            this.c.add(bj7Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(of7Var);
            this.c.add(cj7Var);
            this.c.add(jj7Var);
            this.c.add(ij7Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(uj7Var2);
            this.c.add(yi7Var);
            this.c.add(dj7Var);
            this.c.add(ri7Var);
            this.c.add(new wi7(frsFragment.getPageContext()));
            this.c.add(xi7Var);
            this.c.add(ev7.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.I, "frs_hot_tab"));
            y26 y26Var = new y26(this.a, 1);
            y26Var.u(this.c);
            y26Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, y26Var));
            z(this.c);
            enVar.addAdapters(this.c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            s("page_frs");
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<lm<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    lm<?, ?> next = it.next();
                    if (next instanceof hf7) {
                        ((hf7) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<lm> list = this.c;
                if (list != null) {
                    list.addAll(arrayList);
                }
                en enVar2 = this.b;
                if (enVar2 != null) {
                    enVar2.addAdapters(arrayList);
                }
            }
        }
    }

    @Override // com.baidu.tieba.zj7
    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (lm lmVar : this.c) {
                if (lmVar instanceof hf7) {
                    ((hf7) lmVar).x();
                } else if (lmVar instanceof cx9) {
                    ((cx9) lmVar).onDestroy();
                }
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || ListUtils.isEmpty(this.c) || this.a == null) {
            return;
        }
        for (lm lmVar : this.c) {
            if (lmVar instanceof hf7) {
                ((hf7) lmVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        yj7 yj7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (frsViewData = this.f) != null && frsViewData.getForum() != null && !StringUtils.isNull(this.f.getForum().getId()) && (yj7Var = this.i) != null) {
            yj7Var.M(this.f.getForum().getId());
        }
    }

    public final void r(ArrayList<ym> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                ym ymVar = (ym) ListUtils.getItem(arrayList, i - 1);
                ym ymVar2 = (ym) ListUtils.getItem(arrayList, i);
                if (ymVar2 instanceof w35) {
                    ThreadData threadData = ((w35) ymVar2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (ymVar instanceof sf7) {
                        threadData.needTopMargin = false;
                    } else if (ymVar != null && !p(ymVar)) {
                        threadData.needTopMargin = false;
                    } else if ((ymVar instanceof w35) && p(ymVar) && !TextUtils.isEmpty(((w35) ymVar).t.getRecomReason())) {
                        threadData.needTopMargin = true;
                    } else if (p(ymVar2) && !TextUtils.isEmpty(recomReason)) {
                        threadData.needTopMargin = true;
                    } else {
                        threadData.needTopMargin = false;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.zj7
    public void setFromCDN(boolean z) {
        List<lm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (list = this.c) != null && list.size() != 0) {
            for (lm lmVar : this.c) {
                if (lmVar instanceof hf7) {
                    ((hf7) lmVar).setFromCDN(z);
                }
            }
            tj7 tj7Var = this.k;
            if (tj7Var != null) {
                tj7Var.setFromCDN(z);
            }
            fj7 fj7Var = this.l;
            if (fj7Var != null) {
                fj7Var.setFromCDN(z);
            }
            qj7 qj7Var = this.m;
            if (qj7Var != null) {
                qj7Var.setFromCDN(z);
            }
            nj7 nj7Var = this.n;
            if (nj7Var != null) {
                nj7Var.setFromCDN(z);
            }
            ej7 ej7Var = this.o;
            if (ej7Var != null) {
                ej7Var.setFromCDN(z);
            }
            hj7 hj7Var = this.p;
            if (hj7Var != null) {
                hj7Var.setFromCDN(z);
            }
            uj7 uj7Var = this.u;
            if (uj7Var != null) {
                uj7Var.setFromCDN(z);
            }
            oj7 oj7Var = this.w;
            if (oj7Var != null) {
                oj7Var.setFromCDN(z);
            }
        }
    }

    public void t(String str) {
        List<lm> list;
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
            for (lm lmVar : this.c) {
                if (lmVar != null) {
                    Class<?> cls3 = lmVar.getClass();
                    if (cls3 == cls) {
                        try {
                            cls3.getDeclaredMethod("setTab", String.class).invoke(lmVar, str);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else if (cls3 == cls2) {
                        try {
                            cls3.getDeclaredMethod("setPageTab", String.class).invoke(lmVar, str);
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
