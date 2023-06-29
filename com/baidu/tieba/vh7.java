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
/* loaded from: classes8.dex */
public class vh7 implements ji7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public Cdo b;
    public List<kn> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<xn> e;
    public FrsViewData f;
    public boolean g;
    public final qd7 h;
    public ii7 i;
    public kn j;
    public di7 k;
    public ph7 l;
    public ai7 m;
    public xh7 n;
    public oh7 o;
    public rh7 p;
    public bi7 q;
    public fi7 r;
    public zh7 s;
    public wh7 t;
    public ei7 u;
    public qh7 v;
    public yh7 w;

    public vh7(FrsFragment frsFragment, Cdo cdo, boolean z) {
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
        this.h = new qd7();
        o(frsFragment, cdo);
        this.d = new HashMap<>();
        m(z);
    }

    @Override // com.baidu.tieba.ji7
    public void a(String str) {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (kn knVar : list) {
            if (knVar instanceof oo6) {
                ((oo6) knVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.ji7
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
            if (knVar instanceof p56) {
                ((p56) knVar).g(str);
            }
        }
    }

    public final void z(List<kn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, list) != null) || list == null) {
            return;
        }
        for (kn knVar : list) {
            if (knVar instanceof sd7) {
                ((sd7) knVar).y(this.h);
            }
        }
    }

    @Override // com.baidu.tieba.ji7
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
                } else if (xnVar instanceof r45) {
                    r45 r45Var = (r45) xnVar;
                    if (r45Var.t.getIs_top() != 0) {
                        r45Var.t.parser_title();
                    }
                }
            }
        }
    }

    public final void w() {
        zo7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.f == null) {
            return;
        }
        for (kn knVar : this.c) {
            if ((knVar instanceof bp7) && (i = ((bp7) knVar).i()) != null) {
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
                if (frsFragment != null && frsFragment.V0() != null) {
                    int p0 = this.a.V0().p0();
                    if (p0 == -1) {
                        p0 = this.a.V0().o0();
                    }
                    i.b = p0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.ji7
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090c6e;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ji7
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

    @Override // com.baidu.tieba.ji7
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ji7
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090c49;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ji7
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090d15;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ji7
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

    @Override // com.baidu.tieba.ji7
    public void d(ho hoVar) {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, hoVar) == null) && (list = this.c) != null && list.size() != 0) {
            for (kn knVar : this.c) {
                if (knVar instanceof sd7) {
                    ((sd7) knVar).setOnAdapterItemClickListener(hoVar);
                } else if ((knVar instanceof yh7) || (knVar instanceof ei7)) {
                    knVar.setOnAdapterItemClickListener(hoVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ji7
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

    @Override // com.baidu.tieba.ji7
    public void l(nd7 nd7Var) {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, nd7Var) == null) && (list = this.c) != null && list.size() != 0) {
            for (kn knVar : this.c) {
                if (knVar instanceof sd7) {
                    ((sd7) knVar).z(nd7Var);
                }
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && (list = this.c) != null && list.size() != 0) {
            for (kn knVar : this.c) {
                if (knVar instanceof sd7) {
                    ((sd7) knVar).A(frsViewData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ji7
    public void e() {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.c) != null && list.size() != 0) {
            for (kn knVar : this.c) {
                if (knVar instanceof sd7) {
                    ((sd7) knVar).m(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            z(this.c);
        }
    }

    @Override // com.baidu.tieba.ji7
    public void g(ArrayList<xn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            m3a.f(arrayList, 1);
            n(arrayList);
            x(arrayList);
            r(arrayList);
            Iterator<xn> it = arrayList.iterator();
            while (it.hasNext()) {
                xn next = it.next();
                if ((next instanceof r45) && ((r45) next).t.isTop()) {
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
                if (knVar instanceof sd7) {
                    ((sd7) knVar).F(i);
                }
            }
        }
    }

    public void o(FrsFragment frsFragment, Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, frsFragment, cdo) == null) {
            this.a = frsFragment;
            this.j = md7.e().c(frsFragment.getPageContext(), p3a.d, this.a.getUniqueId(), false);
            di7 di7Var = new di7(frsFragment.t(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = di7Var;
            di7Var.C(cdo);
            ph7 ph7Var = new ph7(frsFragment.t(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = ph7Var;
            ph7Var.C(cdo);
            ai7 ai7Var = new ai7(frsFragment.t(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = ai7Var;
            ai7Var.C(cdo);
            xh7 xh7Var = new xh7(frsFragment.t(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = xh7Var;
            xh7Var.C(cdo);
            oh7 oh7Var = new oh7(frsFragment.t(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = oh7Var;
            oh7Var.C(cdo);
            rh7 rh7Var = new rh7(frsFragment.t(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = rh7Var;
            rh7Var.C(cdo);
            fi7 fi7Var = new fi7(frsFragment.t(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = fi7Var;
            fi7Var.C(cdo);
            bi7 bi7Var = new bi7(frsFragment.t(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = bi7Var;
            bi7Var.C(cdo);
            zh7 zh7Var = new zh7(frsFragment.t(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = zh7Var;
            zh7Var.C(cdo);
            wh7 wh7Var = new wh7(frsFragment.t(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = wh7Var;
            wh7Var.C(cdo);
            ei7 ei7Var = new ei7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = ei7Var;
            ei7Var.C(cdo);
            qh7 qh7Var = new qh7(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = qh7Var;
            qh7Var.C(cdo);
            uh7 uh7Var = new uh7(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            uh7Var.C(cdo);
            ci7 ci7Var = new ci7(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            ci7Var.C(cdo);
            dh7 dh7Var = new dh7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            dh7Var.C(cdo);
            dh7Var.p(1);
            fh7 fh7Var = new fh7(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            fh7Var.C(cdo);
            eh7 eh7Var = new eh7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            eh7Var.C(cdo);
            eh7Var.g0(true);
            kh7 kh7Var = new kh7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            kh7Var.C(cdo);
            kh7Var.g0(true);
            lh7 lh7Var = new lh7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            lh7Var.C(cdo);
            lh7Var.h0(true);
            ei7 ei7Var2 = new ei7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            ei7Var2.C(cdo);
            th7 th7Var = new th7(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            th7Var.C(cdo);
            sh7 sh7Var = new sh7(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            sh7Var.C(cdo);
            this.i = new ii7(frsFragment.getPageContext(), h3a.c, this.a.getUniqueId());
            yh7 yh7Var = new yh7(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = yh7Var;
            yh7Var.C(cdo);
            kn<? extends r45, ? extends TypeAdapter.ViewHolder> a = md7.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            kn<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = md7.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            zd7 zd7Var = new zd7(frsFragment.getPageContext(), ae7.b);
            mh7 mh7Var = new mh7(frsFragment.getPageContext(), de7.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), fe7.e, this.a.getUniqueId());
            ih7 ih7Var = new ih7(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            ih7Var.x((BdTypeRecyclerView) cdo);
            nh7 nh7Var = new nh7(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            ch7 ch7Var = new ch7(frsFragment.t(), w66.g);
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
            this.c.add(uh7Var);
            this.c.add(ci7Var);
            this.c.add(dh7Var);
            this.c.add(fh7Var);
            this.c.add(eh7Var);
            this.c.add(kh7Var);
            this.c.add(lh7Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(zd7Var);
            this.c.add(mh7Var);
            this.c.add(th7Var);
            this.c.add(sh7Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(ei7Var2);
            this.c.add(ih7Var);
            this.c.add(nh7Var);
            this.c.add(ch7Var);
            this.c.add(new hh7(frsFragment.getPageContext()));
            this.c.add(gt7.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_hot_tab"));
            m46 m46Var = new m46(this.a, 1);
            m46Var.u(this.c);
            m46Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, m46Var));
            z(this.c);
            cdo.addAdapters(this.c);
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
                    if (next instanceof sd7) {
                        ((sd7) next).m(this.a.getPageContext(), this.a.getUniqueId());
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
                    cdo2.addAdapters(arrayList);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ji7
    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (kn knVar : this.c) {
                if (knVar instanceof sd7) {
                    ((sd7) knVar).x();
                } else if (knVar instanceof ds9) {
                    ((ds9) knVar).onDestroy();
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
            if (knVar instanceof sd7) {
                ((sd7) knVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        ii7 ii7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (frsViewData = this.f) != null && frsViewData.getForum() != null && !StringUtils.isNull(this.f.getForum().getId()) && (ii7Var = this.i) != null) {
            ii7Var.M(this.f.getForum().getId());
        }
    }

    public final void r(ArrayList<xn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                xn xnVar = (xn) ListUtils.getItem(arrayList, i - 1);
                xn xnVar2 = (xn) ListUtils.getItem(arrayList, i);
                if (xnVar2 instanceof r45) {
                    ThreadData threadData = ((r45) xnVar2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (xnVar instanceof de7) {
                        threadData.needTopMargin = false;
                    } else if (xnVar != null && !p(xnVar)) {
                        threadData.needTopMargin = false;
                    } else if ((xnVar instanceof r45) && p(xnVar) && !TextUtils.isEmpty(((r45) xnVar).t.getRecomReason())) {
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

    @Override // com.baidu.tieba.ji7
    public void setFromCDN(boolean z) {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (list = this.c) != null && list.size() != 0) {
            for (kn knVar : this.c) {
                if (knVar instanceof sd7) {
                    ((sd7) knVar).setFromCDN(z);
                }
            }
            di7 di7Var = this.k;
            if (di7Var != null) {
                di7Var.setFromCDN(z);
            }
            ph7 ph7Var = this.l;
            if (ph7Var != null) {
                ph7Var.setFromCDN(z);
            }
            ai7 ai7Var = this.m;
            if (ai7Var != null) {
                ai7Var.setFromCDN(z);
            }
            xh7 xh7Var = this.n;
            if (xh7Var != null) {
                xh7Var.setFromCDN(z);
            }
            oh7 oh7Var = this.o;
            if (oh7Var != null) {
                oh7Var.setFromCDN(z);
            }
            rh7 rh7Var = this.p;
            if (rh7Var != null) {
                rh7Var.setFromCDN(z);
            }
            ei7 ei7Var = this.u;
            if (ei7Var != null) {
                ei7Var.setFromCDN(z);
            }
            yh7 yh7Var = this.w;
            if (yh7Var != null) {
                yh7Var.setFromCDN(z);
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
