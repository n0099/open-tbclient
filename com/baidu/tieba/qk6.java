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
public class qk6 implements el6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public jo b;
    public List<qn> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<Cdo> e;
    public FrsViewData f;
    public boolean g;
    public final og6 h;
    public dl6 i;
    public qn j;
    public yk6 k;
    public kk6 l;
    public vk6 m;
    public sk6 n;
    public jk6 o;
    public mk6 p;
    public wk6 q;
    public al6 r;
    public uk6 s;
    public rk6 t;
    public zk6 u;
    public lk6 v;
    public tk6 w;

    public qk6(FrsFragment frsFragment, jo joVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, joVar, Boolean.valueOf(z)};
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
        this.b = joVar;
        this.h = new og6();
        o(frsFragment, joVar);
        this.d = new HashMap<>();
        m(z);
    }

    @Override // com.baidu.tieba.el6
    public void a(String str) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (list = this.c) == null) {
            return;
        }
        for (qn qnVar : list) {
            if (qnVar instanceof t16) {
                ((t16) qnVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.el6
    public void b() {
        jo joVar;
        List<Cdo> data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (joVar = this.b) == null || joVar.getData() == null || this.b.getData().size() == 0 || (data = this.b.getData()) == null || data.size() == 0) {
            return;
        }
        for (Cdo cdo : data) {
            if (cdo instanceof ThreadData) {
                ThreadData threadData = (ThreadData) cdo;
                if (threadData.getIs_top() != 0) {
                    threadData.parser_title();
                }
            } else if (cdo instanceof ot4) {
                ot4 ot4Var = (ot4) cdo;
                if (ot4Var.t.getIs_top() != 0) {
                    ot4Var.t.parser_title();
                }
            }
        }
    }

    @Override // com.baidu.tieba.el6
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090b1b;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.el6
    public void d(no noVar) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, noVar) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (qn qnVar : this.c) {
            if (qnVar instanceof qg6) {
                ((qg6) qnVar).setOnAdapterItemClickListener(noVar);
            } else if ((qnVar instanceof tk6) || (qnVar instanceof zk6)) {
                qnVar.setOnAdapterItemClickListener(noVar);
            }
        }
    }

    @Override // com.baidu.tieba.el6
    public void e() {
        List<qn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (qn qnVar : this.c) {
            if (qnVar instanceof qg6) {
                ((qg6) qnVar).m(this.a.getPageContext(), this.a.getUniqueId());
            }
        }
        z(this.c);
    }

    @Override // com.baidu.tieba.el6
    public List<Cdo> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            jo joVar = this.b;
            if (joVar != null) {
                return joVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.el6
    public void g(ArrayList<Cdo> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            ul8.f(arrayList, 1);
            n(arrayList);
            x(arrayList);
            r(arrayList);
            Iterator<Cdo> it = arrayList.iterator();
            while (it.hasNext()) {
                Cdo next = it.next();
                if ((next instanceof ot4) && ((ot4) next).t.isTop()) {
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

    @Override // com.baidu.tieba.el6
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.d : (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.el6
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090af6;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.el6
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090bc1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.el6
    public boolean k(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (qn qnVar : this.c) {
                if (qnVar != null && qnVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.el6
    public void l(lg6 lg6Var) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, lg6Var) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (qn qnVar : this.c) {
            if (qnVar instanceof qg6) {
                ((qg6) qnVar).x(lg6Var);
            }
        }
    }

    @Override // com.baidu.tieba.el6
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || this.g == z) {
            return;
        }
        this.g = z;
    }

    public final ArrayList<Integer> n(ArrayList<Cdo> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, arrayList)) == null) {
            if (arrayList == null || arrayList.size() == 0) {
                return null;
            }
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            for (int i = 0; i < arrayList.size(); i++) {
                Cdo cdo = arrayList.get(i);
                if (cdo instanceof AdvertAppInfo) {
                    arrayList2.add(Integer.valueOf(i));
                    HashMap<Integer, ThreadData> hashMap = this.d;
                    if (hashMap != null && !hashMap.containsValue(cdo)) {
                        this.d.put(Integer.valueOf(i), (ThreadData) cdo);
                    }
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    @Override // com.baidu.tieba.el6
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.b.getListAdapter() == null) {
            return;
        }
        this.b.getListAdapter().notifyDataSetChanged();
    }

    public void o(FrsFragment frsFragment, jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, frsFragment, joVar) == null) {
            this.a = frsFragment;
            this.j = kg6.e().c(frsFragment.getPageContext(), xl8.d, this.a.getUniqueId(), false);
            yk6 yk6Var = new yk6(frsFragment.o(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = yk6Var;
            yk6Var.A(joVar);
            kk6 kk6Var = new kk6(frsFragment.o(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = kk6Var;
            kk6Var.A(joVar);
            vk6 vk6Var = new vk6(frsFragment.o(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = vk6Var;
            vk6Var.A(joVar);
            sk6 sk6Var = new sk6(frsFragment.o(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = sk6Var;
            sk6Var.A(joVar);
            jk6 jk6Var = new jk6(frsFragment.o(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = jk6Var;
            jk6Var.A(joVar);
            mk6 mk6Var = new mk6(frsFragment.o(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = mk6Var;
            mk6Var.A(joVar);
            al6 al6Var = new al6(frsFragment.o(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = al6Var;
            al6Var.A(joVar);
            wk6 wk6Var = new wk6(frsFragment.o(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = wk6Var;
            wk6Var.A(joVar);
            uk6 uk6Var = new uk6(frsFragment.o(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = uk6Var;
            uk6Var.A(joVar);
            rk6 rk6Var = new rk6(frsFragment.o(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = rk6Var;
            rk6Var.A(joVar);
            zk6 zk6Var = new zk6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = zk6Var;
            zk6Var.A(joVar);
            lk6 lk6Var = new lk6(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = lk6Var;
            lk6Var.A(joVar);
            pk6 pk6Var = new pk6(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            pk6Var.A(joVar);
            xk6 xk6Var = new xk6(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            xk6Var.A(joVar);
            zj6 zj6Var = new zj6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            zj6Var.A(joVar);
            zj6Var.p(1);
            bk6 bk6Var = new bk6(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            bk6Var.A(joVar);
            ak6 ak6Var = new ak6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            ak6Var.A(joVar);
            ak6Var.e0(true);
            fk6 fk6Var = new fk6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            fk6Var.A(joVar);
            fk6Var.e0(true);
            gk6 gk6Var = new gk6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            gk6Var.A(joVar);
            gk6Var.f0(true);
            zk6 zk6Var2 = new zk6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            zk6Var2.A(joVar);
            ok6 ok6Var = new ok6(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            ok6Var.A(joVar);
            nk6 nk6Var = new nk6(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            nk6Var.A(joVar);
            this.i = new dl6(frsFragment.getPageContext(), pl8.c, this.a.getUniqueId());
            tk6 tk6Var = new tk6(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = tk6Var;
            tk6Var.A(joVar);
            qn<? extends ot4, ? extends TypeAdapter.ViewHolder> a = kg6.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            qn<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = kg6.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            xg6 xg6Var = new xg6(frsFragment.getPageContext(), yg6.b);
            hk6 hk6Var = new hk6(frsFragment.getPageContext(), bh6.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), dh6.e, this.a.getUniqueId());
            dk6 dk6Var = new dk6(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            dk6Var.v((BdTypeRecyclerView) joVar);
            ik6 ik6Var = new ik6(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
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
            this.c.add(pk6Var);
            this.c.add(xk6Var);
            this.c.add(zj6Var);
            this.c.add(bk6Var);
            this.c.add(ak6Var);
            this.c.add(fk6Var);
            this.c.add(gk6Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(xg6Var);
            this.c.add(hk6Var);
            this.c.add(ok6Var);
            this.c.add(nk6Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(zk6Var2);
            this.c.add(dk6Var);
            this.c.add(ik6Var);
            this.c.add(ju6.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_hot_tab"));
            dn5 dn5Var = new dn5(this.a, 1);
            dn5Var.u(this.c);
            dn5Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, dn5Var));
            z(this.c);
            joVar.a(this.c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            s("page_frs");
            if (absDelegateAdapterList.isEmpty()) {
                return;
            }
            Iterator<qn<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                qn<?, ?> next = it.next();
                if (next instanceof qg6) {
                    ((qg6) next).m(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            List<qn> list = this.c;
            if (list != null) {
                list.addAll(arrayList);
            }
            jo joVar2 = this.b;
            if (joVar2 != null) {
                joVar2.a(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.el6
    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (qn qnVar : this.c) {
                if (qnVar instanceof qg6) {
                    ((qg6) qnVar).v();
                } else if (qnVar instanceof dd8) {
                    ((dd8) qnVar).onDestroy();
                }
            }
        }
    }

    public final boolean p(Cdo cdo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, cdo)) == null) {
            if (cdo == null) {
                return false;
            }
            BdUniqueId type = cdo.getType();
            return type == ThreadData.TYPE_NORMAL || type == ThreadData.TYPE_GOD_NORMAL || type == ThreadData.TYPE_VIDEO || type == ThreadData.TYPE_VIDEO_GOD || type == ThreadData.TYPE_INSERT_VIDEO;
        }
        return invokeL.booleanValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList<Cdo> arrayList = this.e;
            if (arrayList != null) {
                this.b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    public final void r(ArrayList<Cdo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                Cdo cdo = (Cdo) ListUtils.getItem(arrayList, i - 1);
                Cdo cdo2 = (Cdo) ListUtils.getItem(arrayList, i);
                if (cdo2 instanceof ot4) {
                    ThreadData threadData = ((ot4) cdo2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (cdo instanceof bh6) {
                        threadData.needTopMargin = false;
                    } else if (cdo != null && !p(cdo)) {
                        threadData.needTopMargin = false;
                    } else if ((cdo instanceof ot4) && p(cdo) && !TextUtils.isEmpty(((ot4) cdo).t.getRecomReason())) {
                        threadData.needTopMargin = true;
                    } else if (p(cdo2) && !TextUtils.isEmpty(recomReason)) {
                        threadData.needTopMargin = true;
                    } else {
                        threadData.needTopMargin = false;
                    }
                }
            }
        }
    }

    public final void s(String str) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || (list = this.c) == null) {
            return;
        }
        for (qn qnVar : list) {
            if (qnVar instanceof go5) {
                ((go5) qnVar).g(str);
            }
        }
    }

    @Override // com.baidu.tieba.el6
    public void setFromCDN(boolean z) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (qn qnVar : this.c) {
            if (qnVar instanceof qg6) {
                ((qg6) qnVar).setFromCDN(z);
            }
        }
        yk6 yk6Var = this.k;
        if (yk6Var != null) {
            yk6Var.setFromCDN(z);
        }
        kk6 kk6Var = this.l;
        if (kk6Var != null) {
            kk6Var.setFromCDN(z);
        }
        vk6 vk6Var = this.m;
        if (vk6Var != null) {
            vk6Var.setFromCDN(z);
        }
        sk6 sk6Var = this.n;
        if (sk6Var != null) {
            sk6Var.setFromCDN(z);
        }
        jk6 jk6Var = this.o;
        if (jk6Var != null) {
            jk6Var.setFromCDN(z);
        }
        mk6 mk6Var = this.p;
        if (mk6Var != null) {
            mk6Var.setFromCDN(z);
        }
        zk6 zk6Var = this.u;
        if (zk6Var != null) {
            zk6Var.setFromCDN(z);
        }
        tk6 tk6Var = this.w;
        if (tk6Var != null) {
            tk6Var.setFromCDN(z);
        }
    }

    public void t(String str) {
        List<qn> list;
        Class<?> cls;
        Class<?> cls2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, str) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        try {
            cls = Class.forName("com.baidu.tieba.InjectPlugin.FrsFeedAd.FrsFeedAdAdapter");
            cls2 = Class.forName("com.baidu.tieba.funad.adapter.FunAdNativeNewAdapter");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        for (qn qnVar : this.c) {
            if (qnVar != null) {
                Class<?> cls3 = qnVar.getClass();
                if (cls3 == cls) {
                    try {
                        cls3.getDeclaredMethod("setTab", String.class).invoke(qnVar, str);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else if (cls3 == cls2) {
                    try {
                        cls3.getDeclaredMethod("setPageTab", String.class).invoke(qnVar, str);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                e.printStackTrace();
                return;
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || ListUtils.isEmpty(this.c) || this.a == null) {
            return;
        }
        for (qn qnVar : this.c) {
            if (qnVar instanceof qg6) {
                ((qg6) qnVar).C(this.a.getTbPageTag());
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (qn qnVar : this.c) {
            if (qnVar instanceof qg6) {
                ((qg6) qnVar).y(frsViewData);
            }
        }
    }

    public final void w() {
        nr6 i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || this.f == null) {
            return;
        }
        for (qn qnVar : this.c) {
            if ((qnVar instanceof pr6) && (i = ((pr6) qnVar).i()) != null) {
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

    public final void x(ArrayList<Cdo> arrayList) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, arrayList) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        int i = 0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<Cdo> it = arrayList.iterator();
            while (it.hasNext() && it.next().getType().getId() == ThreadData.TYPE_TOP.getId()) {
                i++;
            }
        }
        for (qn qnVar : this.c) {
            if (qnVar instanceof qg6) {
                ((qg6) qnVar).D(i);
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        dl6 dl6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (frsViewData = this.f) == null || frsViewData.getForum() == null || StringUtils.isNull(this.f.getForum().getId()) || (dl6Var = this.i) == null) {
            return;
        }
        dl6Var.K(this.f.getForum().getId());
    }

    public final void z(List<qn> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, list) == null) || list == null) {
            return;
        }
        for (qn qnVar : list) {
            if (qnVar instanceof qg6) {
                ((qg6) qnVar).w(this.h);
            }
        }
    }
}
