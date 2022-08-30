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
/* loaded from: classes5.dex */
public class nj6 implements bk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public vn b;
    public List<cn> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<pn> e;
    public FrsViewData f;
    public boolean g;
    public final af6 h;
    public ak6 i;
    public cn j;
    public vj6 k;
    public hj6 l;
    public sj6 m;
    public pj6 n;
    public gj6 o;
    public jj6 p;
    public tj6 q;
    public xj6 r;
    public rj6 s;
    public oj6 t;
    public wj6 u;
    public ij6 v;
    public qj6 w;

    public nj6(FrsFragment frsFragment, vn vnVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, vnVar, Boolean.valueOf(z)};
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
        this.b = vnVar;
        this.h = new af6();
        p(frsFragment, vnVar);
        this.d = new HashMap<>();
        n(z);
    }

    public final void A(List<cn> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        for (cn cnVar : list) {
            if (cnVar instanceof cf6) {
                ((cf6) cnVar).w(this.h);
            }
        }
    }

    @Override // com.baidu.tieba.bk6
    public void a(String str) {
        List<cn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (list = this.c) == null) {
            return;
        }
        for (cn cnVar : list) {
            if (cnVar instanceof h06) {
                ((h06) cnVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.bk6
    public void b() {
        vn vnVar;
        List<pn> data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (vnVar = this.b) == null || vnVar.getData() == null || this.b.getData().size() == 0 || (data = this.b.getData()) == null || data.size() == 0) {
            return;
        }
        for (pn pnVar : data) {
            if (pnVar instanceof ThreadData) {
                ThreadData threadData = (ThreadData) pnVar;
                if (threadData.getIs_top() != 0) {
                    threadData.parser_title();
                }
            } else if (pnVar instanceof kr4) {
                kr4 kr4Var = (kr4) pnVar;
                if (kr4Var.t.getIs_top() != 0) {
                    kr4Var.t.parser_title();
                }
            }
        }
    }

    @Override // com.baidu.tieba.bk6
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090b02;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.bk6
    public void d(zn znVar) {
        List<cn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, znVar) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (cn cnVar : this.c) {
            if (cnVar instanceof cf6) {
                ((cf6) cnVar).setOnAdapterItemClickListener(znVar);
            } else if ((cnVar instanceof qj6) || (cnVar instanceof wj6)) {
                cnVar.setOnAdapterItemClickListener(znVar);
            }
        }
    }

    @Override // com.baidu.tieba.bk6
    public void e() {
        List<cn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (cn cnVar : this.c) {
            if (cnVar instanceof cf6) {
                ((cf6) cnVar).m(this.a.getPageContext(), this.a.getUniqueId());
            }
        }
        A(this.c);
    }

    @Override // com.baidu.tieba.bk6
    public List<pn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            vn vnVar = this.b;
            if (vnVar != null) {
                return vnVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bk6
    public void g(ArrayList<pn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, arrayList, frsViewData) == null) {
            w(frsViewData);
            v();
            ik8.f(arrayList, 1);
            o(arrayList);
            y(arrayList);
            s(arrayList);
            Iterator<pn> it = arrayList.iterator();
            while (it.hasNext()) {
                pn next = it.next();
                if ((next instanceof kr4) && ((kr4) next).t.isTop()) {
                    it.remove();
                }
            }
            this.b.setData(arrayList);
            this.f = frsViewData;
            x();
            z();
            this.e = arrayList;
        }
    }

    @Override // com.baidu.tieba.bk6
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.d : (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bk6
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090add;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.bk6
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090ba7;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.bk6
    public boolean k(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (cn cnVar : this.c) {
                if (cnVar != null && cnVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.bk6
    public void l(xe6 xe6Var) {
        List<cn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, xe6Var) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (cn cnVar : this.c) {
            if (cnVar instanceof cf6) {
                ((cf6) cnVar).x(xe6Var);
            }
        }
    }

    @Override // com.baidu.tieba.bk6
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            for (cn cnVar : this.c) {
                if (cnVar instanceof cf6) {
                    ((cf6) cnVar).v();
                } else if (cnVar instanceof xb8) {
                    ((xb8) cnVar).onDestroy();
                }
            }
        }
    }

    @Override // com.baidu.tieba.bk6
    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || this.g == z) {
            return;
        }
        this.g = z;
    }

    @Override // com.baidu.tieba.bk6
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.b.getListAdapter() == null) {
            return;
        }
        this.b.getListAdapter().notifyDataSetChanged();
    }

    public final ArrayList<Integer> o(ArrayList<pn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, arrayList)) == null) {
            if (arrayList == null || arrayList.size() == 0) {
                return null;
            }
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            for (int i = 0; i < arrayList.size(); i++) {
                pn pnVar = arrayList.get(i);
                if (pnVar instanceof AdvertAppInfo) {
                    arrayList2.add(Integer.valueOf(i));
                    HashMap<Integer, ThreadData> hashMap = this.d;
                    if (hashMap != null && !hashMap.containsValue(pnVar)) {
                        this.d.put(Integer.valueOf(i), (ThreadData) pnVar);
                    }
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void p(FrsFragment frsFragment, vn vnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, frsFragment, vnVar) == null) {
            this.a = frsFragment;
            this.j = we6.e().c(frsFragment.getPageContext(), lk8.d, this.a.getUniqueId(), false);
            vj6 vj6Var = new vj6(frsFragment.o(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = vj6Var;
            vj6Var.A(vnVar);
            hj6 hj6Var = new hj6(frsFragment.o(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = hj6Var;
            hj6Var.A(vnVar);
            sj6 sj6Var = new sj6(frsFragment.o(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = sj6Var;
            sj6Var.A(vnVar);
            pj6 pj6Var = new pj6(frsFragment.o(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = pj6Var;
            pj6Var.A(vnVar);
            gj6 gj6Var = new gj6(frsFragment.o(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = gj6Var;
            gj6Var.A(vnVar);
            jj6 jj6Var = new jj6(frsFragment.o(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = jj6Var;
            jj6Var.A(vnVar);
            xj6 xj6Var = new xj6(frsFragment.o(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = xj6Var;
            xj6Var.A(vnVar);
            tj6 tj6Var = new tj6(frsFragment.o(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = tj6Var;
            tj6Var.A(vnVar);
            rj6 rj6Var = new rj6(frsFragment.o(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = rj6Var;
            rj6Var.A(vnVar);
            oj6 oj6Var = new oj6(frsFragment.o(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = oj6Var;
            oj6Var.A(vnVar);
            wj6 wj6Var = new wj6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = wj6Var;
            wj6Var.A(vnVar);
            ij6 ij6Var = new ij6(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = ij6Var;
            ij6Var.A(vnVar);
            mj6 mj6Var = new mj6(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            mj6Var.A(vnVar);
            uj6 uj6Var = new uj6(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            uj6Var.A(vnVar);
            wi6 wi6Var = new wi6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            wi6Var.A(vnVar);
            wi6Var.p(1);
            yi6 yi6Var = new yi6(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            yi6Var.A(vnVar);
            xi6 xi6Var = new xi6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            xi6Var.A(vnVar);
            xi6Var.e0(true);
            cj6 cj6Var = new cj6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            cj6Var.A(vnVar);
            cj6Var.e0(true);
            dj6 dj6Var = new dj6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            dj6Var.A(vnVar);
            dj6Var.f0(true);
            wj6 wj6Var2 = new wj6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            wj6Var2.A(vnVar);
            lj6 lj6Var = new lj6(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            lj6Var.A(vnVar);
            kj6 kj6Var = new kj6(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            kj6Var.A(vnVar);
            this.i = new ak6(frsFragment.getPageContext(), dk8.c, this.a.getUniqueId());
            qj6 qj6Var = new qj6(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = qj6Var;
            qj6Var.A(vnVar);
            cn<? extends kr4, ? extends TypeAdapter.ViewHolder> a = we6.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            cn<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = we6.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            jf6 jf6Var = new jf6(frsFragment.getPageContext(), kf6.b);
            ej6 ej6Var = new ej6(frsFragment.getPageContext(), mf6.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), of6.e, this.a.getUniqueId());
            aj6 aj6Var = new aj6(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            aj6Var.v((BdTypeRecyclerView) vnVar);
            fj6 fj6Var = new fj6(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
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
            this.c.add(mj6Var);
            this.c.add(uj6Var);
            this.c.add(wi6Var);
            this.c.add(yi6Var);
            this.c.add(xi6Var);
            this.c.add(cj6Var);
            this.c.add(dj6Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(jf6Var);
            this.c.add(ej6Var);
            this.c.add(lj6Var);
            this.c.add(kj6Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(wj6Var2);
            this.c.add(aj6Var);
            this.c.add(fj6Var);
            this.c.add(at6.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_hot_tab"));
            wk5 wk5Var = new wk5(this.a, 1);
            wk5Var.u(this.c);
            wk5Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, wk5Var));
            A(this.c);
            vnVar.a(this.c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            t("page_frs");
            if (absDelegateAdapterList.isEmpty()) {
                return;
            }
            Iterator<cn<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                cn<?, ?> next = it.next();
                if (next instanceof cf6) {
                    ((cf6) next).m(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            List<cn> list = this.c;
            if (list != null) {
                list.addAll(arrayList);
            }
            vn vnVar2 = this.b;
            if (vnVar2 != null) {
                vnVar2.a(arrayList);
            }
        }
    }

    public final boolean q(pn pnVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, pnVar)) == null) {
            if (pnVar == null) {
                return false;
            }
            BdUniqueId type = pnVar.getType();
            return type == ThreadData.TYPE_NORMAL || type == ThreadData.TYPE_GOD_NORMAL || type == ThreadData.TYPE_VIDEO || type == ThreadData.TYPE_VIDEO_GOD || type == ThreadData.TYPE_INSERT_VIDEO;
        }
        return invokeL.booleanValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            ArrayList<pn> arrayList = this.e;
            if (arrayList != null) {
                this.b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    public final void s(ArrayList<pn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                pn pnVar = (pn) ListUtils.getItem(arrayList, i - 1);
                pn pnVar2 = (pn) ListUtils.getItem(arrayList, i);
                if (pnVar2 instanceof kr4) {
                    ThreadData threadData = ((kr4) pnVar2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (pnVar instanceof mf6) {
                        threadData.needTopMargin = false;
                    } else if (pnVar != null && !q(pnVar)) {
                        threadData.needTopMargin = false;
                    } else if ((pnVar instanceof kr4) && q(pnVar) && !TextUtils.isEmpty(((kr4) pnVar).t.getRecomReason())) {
                        threadData.needTopMargin = true;
                    } else if (q(pnVar2) && !TextUtils.isEmpty(recomReason)) {
                        threadData.needTopMargin = true;
                    } else {
                        threadData.needTopMargin = false;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.bk6
    public void setFromCDN(boolean z) {
        List<cn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (cn cnVar : this.c) {
            if (cnVar instanceof cf6) {
                ((cf6) cnVar).setFromCDN(z);
            }
        }
        vj6 vj6Var = this.k;
        if (vj6Var != null) {
            vj6Var.setFromCDN(z);
        }
        hj6 hj6Var = this.l;
        if (hj6Var != null) {
            hj6Var.setFromCDN(z);
        }
        sj6 sj6Var = this.m;
        if (sj6Var != null) {
            sj6Var.setFromCDN(z);
        }
        pj6 pj6Var = this.n;
        if (pj6Var != null) {
            pj6Var.setFromCDN(z);
        }
        gj6 gj6Var = this.o;
        if (gj6Var != null) {
            gj6Var.setFromCDN(z);
        }
        jj6 jj6Var = this.p;
        if (jj6Var != null) {
            jj6Var.setFromCDN(z);
        }
        wj6 wj6Var = this.u;
        if (wj6Var != null) {
            wj6Var.setFromCDN(z);
        }
        qj6 qj6Var = this.w;
        if (qj6Var != null) {
            qj6Var.setFromCDN(z);
        }
    }

    public final void t(String str) {
        List<cn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, str) == null) || (list = this.c) == null) {
            return;
        }
        for (cn cnVar : list) {
            if (cnVar instanceof xl5) {
                ((xl5) cnVar).g(str);
            }
        }
    }

    public void u(String str) {
        List<cn> list;
        Class<?> cls;
        Class<?> cls2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, str) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        try {
            cls = Class.forName("com.baidu.tieba.InjectPlugin.FrsFeedAd.FrsFeedAdAdapter");
            cls2 = Class.forName("com.baidu.tieba.funad.adapter.FunAdNativeNewAdapter");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        for (cn cnVar : this.c) {
            if (cnVar != null) {
                Class<?> cls3 = cnVar.getClass();
                if (cls3 == cls) {
                    try {
                        cls3.getDeclaredMethod("setTab", String.class).invoke(cnVar, str);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else if (cls3 == cls2) {
                    try {
                        cls3.getDeclaredMethod("setPageTab", String.class).invoke(cnVar, str);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                e.printStackTrace();
                return;
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || ListUtils.isEmpty(this.c) || this.a == null) {
            return;
        }
        for (cn cnVar : this.c) {
            if (cnVar instanceof cf6) {
                ((cf6) cnVar).C(this.a.getTbPageTag());
            }
        }
    }

    public void w(FrsViewData frsViewData) {
        List<cn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, frsViewData) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (cn cnVar : this.c) {
            if (cnVar instanceof cf6) {
                ((cf6) cnVar).y(frsViewData);
            }
        }
    }

    public final void x() {
        fq6 i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || this.f == null) {
            return;
        }
        for (cn cnVar : this.c) {
            if ((cnVar instanceof hq6) && (i = ((hq6) cnVar).i()) != null) {
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
                if (frsFragment != null && frsFragment.K0() != null) {
                    int U = this.a.K0().U();
                    if (U == -1) {
                        U = this.a.K0().T();
                    }
                    i.b = U;
                }
            }
        }
    }

    public final void y(ArrayList<pn> arrayList) {
        List<cn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, arrayList) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        int i = 0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<pn> it = arrayList.iterator();
            while (it.hasNext() && it.next().getType().getId() == ThreadData.TYPE_TOP.getId()) {
                i++;
            }
        }
        for (cn cnVar : this.c) {
            if (cnVar instanceof cf6) {
                ((cf6) cnVar).D(i);
            }
        }
    }

    public final void z() {
        FrsViewData frsViewData;
        ak6 ak6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (frsViewData = this.f) == null || frsViewData.getForum() == null || StringUtils.isNull(this.f.getForum().getId()) || (ak6Var = this.i) == null) {
            return;
        }
        ak6Var.K(this.f.getForum().getId());
    }
}
