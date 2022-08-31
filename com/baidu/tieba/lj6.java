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
public class lj6 implements zj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public vn b;
    public List<cn> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<pn> e;
    public FrsViewData f;
    public boolean g;
    public final ye6 h;
    public yj6 i;
    public cn j;
    public tj6 k;
    public fj6 l;
    public qj6 m;
    public nj6 n;
    public ej6 o;
    public hj6 p;
    public rj6 q;
    public vj6 r;
    public pj6 s;
    public mj6 t;
    public uj6 u;
    public gj6 v;
    public oj6 w;

    public lj6(FrsFragment frsFragment, vn vnVar, boolean z) {
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
        this.h = new ye6();
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
            if (cnVar instanceof af6) {
                ((af6) cnVar).w(this.h);
            }
        }
    }

    @Override // com.baidu.tieba.zj6
    public void a(String str) {
        List<cn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (list = this.c) == null) {
            return;
        }
        for (cn cnVar : list) {
            if (cnVar instanceof f06) {
                ((f06) cnVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.zj6
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
            } else if (pnVar instanceof jr4) {
                jr4 jr4Var = (jr4) pnVar;
                if (jr4Var.t.getIs_top() != 0) {
                    jr4Var.t.parser_title();
                }
            }
        }
    }

    @Override // com.baidu.tieba.zj6
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

    @Override // com.baidu.tieba.zj6
    public void d(zn znVar) {
        List<cn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, znVar) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (cn cnVar : this.c) {
            if (cnVar instanceof af6) {
                ((af6) cnVar).setOnAdapterItemClickListener(znVar);
            } else if ((cnVar instanceof oj6) || (cnVar instanceof uj6)) {
                cnVar.setOnAdapterItemClickListener(znVar);
            }
        }
    }

    @Override // com.baidu.tieba.zj6
    public void e() {
        List<cn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (cn cnVar : this.c) {
            if (cnVar instanceof af6) {
                ((af6) cnVar).m(this.a.getPageContext(), this.a.getUniqueId());
            }
        }
        A(this.c);
    }

    @Override // com.baidu.tieba.zj6
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

    @Override // com.baidu.tieba.zj6
    public void g(ArrayList<pn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, arrayList, frsViewData) == null) {
            w(frsViewData);
            v();
            gk8.f(arrayList, 1);
            o(arrayList);
            y(arrayList);
            s(arrayList);
            Iterator<pn> it = arrayList.iterator();
            while (it.hasNext()) {
                pn next = it.next();
                if ((next instanceof jr4) && ((jr4) next).t.isTop()) {
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

    @Override // com.baidu.tieba.zj6
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.d : (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zj6
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

    @Override // com.baidu.tieba.zj6
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

    @Override // com.baidu.tieba.zj6
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

    @Override // com.baidu.tieba.zj6
    public void l(ve6 ve6Var) {
        List<cn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, ve6Var) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (cn cnVar : this.c) {
            if (cnVar instanceof af6) {
                ((af6) cnVar).x(ve6Var);
            }
        }
    }

    @Override // com.baidu.tieba.zj6
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            for (cn cnVar : this.c) {
                if (cnVar instanceof af6) {
                    ((af6) cnVar).v();
                } else if (cnVar instanceof vb8) {
                    ((vb8) cnVar).onDestroy();
                }
            }
        }
    }

    @Override // com.baidu.tieba.zj6
    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || this.g == z) {
            return;
        }
        this.g = z;
    }

    @Override // com.baidu.tieba.zj6
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
            this.j = ue6.e().c(frsFragment.getPageContext(), jk8.d, this.a.getUniqueId(), false);
            tj6 tj6Var = new tj6(frsFragment.o(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = tj6Var;
            tj6Var.A(vnVar);
            fj6 fj6Var = new fj6(frsFragment.o(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = fj6Var;
            fj6Var.A(vnVar);
            qj6 qj6Var = new qj6(frsFragment.o(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = qj6Var;
            qj6Var.A(vnVar);
            nj6 nj6Var = new nj6(frsFragment.o(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = nj6Var;
            nj6Var.A(vnVar);
            ej6 ej6Var = new ej6(frsFragment.o(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = ej6Var;
            ej6Var.A(vnVar);
            hj6 hj6Var = new hj6(frsFragment.o(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = hj6Var;
            hj6Var.A(vnVar);
            vj6 vj6Var = new vj6(frsFragment.o(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = vj6Var;
            vj6Var.A(vnVar);
            rj6 rj6Var = new rj6(frsFragment.o(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = rj6Var;
            rj6Var.A(vnVar);
            pj6 pj6Var = new pj6(frsFragment.o(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = pj6Var;
            pj6Var.A(vnVar);
            mj6 mj6Var = new mj6(frsFragment.o(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = mj6Var;
            mj6Var.A(vnVar);
            uj6 uj6Var = new uj6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = uj6Var;
            uj6Var.A(vnVar);
            gj6 gj6Var = new gj6(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = gj6Var;
            gj6Var.A(vnVar);
            kj6 kj6Var = new kj6(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            kj6Var.A(vnVar);
            sj6 sj6Var = new sj6(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            sj6Var.A(vnVar);
            ui6 ui6Var = new ui6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            ui6Var.A(vnVar);
            ui6Var.p(1);
            wi6 wi6Var = new wi6(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            wi6Var.A(vnVar);
            vi6 vi6Var = new vi6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            vi6Var.A(vnVar);
            vi6Var.e0(true);
            aj6 aj6Var = new aj6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            aj6Var.A(vnVar);
            aj6Var.e0(true);
            bj6 bj6Var = new bj6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            bj6Var.A(vnVar);
            bj6Var.f0(true);
            uj6 uj6Var2 = new uj6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            uj6Var2.A(vnVar);
            jj6 jj6Var = new jj6(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            jj6Var.A(vnVar);
            ij6 ij6Var = new ij6(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            ij6Var.A(vnVar);
            this.i = new yj6(frsFragment.getPageContext(), bk8.c, this.a.getUniqueId());
            oj6 oj6Var = new oj6(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = oj6Var;
            oj6Var.A(vnVar);
            cn<? extends jr4, ? extends TypeAdapter.ViewHolder> a = ue6.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            cn<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = ue6.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            hf6 hf6Var = new hf6(frsFragment.getPageContext(), if6.b);
            cj6 cj6Var = new cj6(frsFragment.getPageContext(), kf6.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), mf6.e, this.a.getUniqueId());
            yi6 yi6Var = new yi6(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            yi6Var.v((BdTypeRecyclerView) vnVar);
            dj6 dj6Var = new dj6(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
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
            this.c.add(kj6Var);
            this.c.add(sj6Var);
            this.c.add(ui6Var);
            this.c.add(wi6Var);
            this.c.add(vi6Var);
            this.c.add(aj6Var);
            this.c.add(bj6Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(hf6Var);
            this.c.add(cj6Var);
            this.c.add(jj6Var);
            this.c.add(ij6Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(uj6Var2);
            this.c.add(yi6Var);
            this.c.add(dj6Var);
            this.c.add(ys6.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_hot_tab"));
            uk5 uk5Var = new uk5(this.a, 1);
            uk5Var.u(this.c);
            uk5Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, uk5Var));
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
                if (next instanceof af6) {
                    ((af6) next).m(this.a.getPageContext(), this.a.getUniqueId());
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
                if (pnVar2 instanceof jr4) {
                    ThreadData threadData = ((jr4) pnVar2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (pnVar instanceof kf6) {
                        threadData.needTopMargin = false;
                    } else if (pnVar != null && !q(pnVar)) {
                        threadData.needTopMargin = false;
                    } else if ((pnVar instanceof jr4) && q(pnVar) && !TextUtils.isEmpty(((jr4) pnVar).t.getRecomReason())) {
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

    @Override // com.baidu.tieba.zj6
    public void setFromCDN(boolean z) {
        List<cn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (cn cnVar : this.c) {
            if (cnVar instanceof af6) {
                ((af6) cnVar).setFromCDN(z);
            }
        }
        tj6 tj6Var = this.k;
        if (tj6Var != null) {
            tj6Var.setFromCDN(z);
        }
        fj6 fj6Var = this.l;
        if (fj6Var != null) {
            fj6Var.setFromCDN(z);
        }
        qj6 qj6Var = this.m;
        if (qj6Var != null) {
            qj6Var.setFromCDN(z);
        }
        nj6 nj6Var = this.n;
        if (nj6Var != null) {
            nj6Var.setFromCDN(z);
        }
        ej6 ej6Var = this.o;
        if (ej6Var != null) {
            ej6Var.setFromCDN(z);
        }
        hj6 hj6Var = this.p;
        if (hj6Var != null) {
            hj6Var.setFromCDN(z);
        }
        uj6 uj6Var = this.u;
        if (uj6Var != null) {
            uj6Var.setFromCDN(z);
        }
        oj6 oj6Var = this.w;
        if (oj6Var != null) {
            oj6Var.setFromCDN(z);
        }
    }

    public final void t(String str) {
        List<cn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, str) == null) || (list = this.c) == null) {
            return;
        }
        for (cn cnVar : list) {
            if (cnVar instanceof vl5) {
                ((vl5) cnVar).g(str);
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
            if (cnVar instanceof af6) {
                ((af6) cnVar).C(this.a.getTbPageTag());
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
            if (cnVar instanceof af6) {
                ((af6) cnVar).y(frsViewData);
            }
        }
    }

    public final void x() {
        dq6 i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || this.f == null) {
            return;
        }
        for (cn cnVar : this.c) {
            if ((cnVar instanceof fq6) && (i = ((fq6) cnVar).i()) != null) {
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
            if (cnVar instanceof af6) {
                ((af6) cnVar).D(i);
            }
        }
    }

    public final void z() {
        FrsViewData frsViewData;
        yj6 yj6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (frsViewData = this.f) == null || frsViewData.getForum() == null || StringUtils.isNull(this.f.getForum().getId()) || (yj6Var = this.i) == null) {
            return;
        }
        yj6Var.K(this.f.getForum().getId());
    }
}
