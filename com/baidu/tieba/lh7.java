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
public class lh7 implements zh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public bo b;
    public List<in> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<vn> e;
    public FrsViewData f;
    public boolean g;
    public final gd7 h;
    public yh7 i;
    public in j;
    public th7 k;
    public fh7 l;
    public qh7 m;
    public nh7 n;
    public eh7 o;
    public hh7 p;
    public rh7 q;
    public vh7 r;
    public ph7 s;
    public mh7 t;
    public uh7 u;
    public gh7 v;
    public oh7 w;

    public lh7(FrsFragment frsFragment, bo boVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, boVar, Boolean.valueOf(z)};
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
        this.b = boVar;
        this.h = new gd7();
        o(frsFragment, boVar);
        this.d = new HashMap<>();
        m(z);
    }

    @Override // com.baidu.tieba.zh7
    public void a(String str) {
        List<in> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (in inVar : list) {
            if (inVar instanceof eo6) {
                ((eo6) inVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.zh7
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && this.g != z) {
            this.g = z;
        }
    }

    public final boolean p(vn vnVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, vnVar)) == null) {
            if (vnVar == null) {
                return false;
            }
            BdUniqueId type = vnVar.getType();
            if (type != ThreadData.TYPE_NORMAL && type != ThreadData.TYPE_GOD_NORMAL && type != ThreadData.TYPE_VIDEO && type != ThreadData.TYPE_VIDEO_GOD && type != ThreadData.TYPE_INSERT_VIDEO) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void s(String str) {
        List<in> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (in inVar : list) {
            if (inVar instanceof f56) {
                ((f56) inVar).g(str);
            }
        }
    }

    public final void z(List<in> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, list) != null) || list == null) {
            return;
        }
        for (in inVar : list) {
            if (inVar instanceof id7) {
                ((id7) inVar).y(this.h);
            }
        }
    }

    @Override // com.baidu.tieba.zh7
    public void b() {
        bo boVar;
        List<vn> data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (boVar = this.b) != null && boVar.getData() != null && this.b.getData().size() != 0 && (data = this.b.getData()) != null && data.size() != 0) {
            for (vn vnVar : data) {
                if (vnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) vnVar;
                    if (threadData.getIs_top() != 0) {
                        threadData.parser_title();
                    }
                } else if (vnVar instanceof n45) {
                    n45 n45Var = (n45) vnVar;
                    if (n45Var.t.getIs_top() != 0) {
                        n45Var.t.parser_title();
                    }
                }
            }
        }
    }

    public final void w() {
        mo7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.f == null) {
            return;
        }
        for (in inVar : this.c) {
            if ((inVar instanceof oo7) && (i = ((oo7) inVar).i()) != null) {
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

    @Override // com.baidu.tieba.zh7
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090c66;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.zh7
    public List<vn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            bo boVar = this.b;
            if (boVar != null) {
                return boVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zh7
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zh7
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090c41;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.zh7
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090d0d;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.zh7
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.b.getListAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList<vn> arrayList = this.e;
            if (arrayList != null) {
                this.b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.zh7
    public void d(fo foVar) {
        List<in> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, foVar) == null) && (list = this.c) != null && list.size() != 0) {
            for (in inVar : this.c) {
                if (inVar instanceof id7) {
                    ((id7) inVar).setOnAdapterItemClickListener(foVar);
                } else if ((inVar instanceof oh7) || (inVar instanceof uh7)) {
                    inVar.setOnAdapterItemClickListener(foVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.zh7
    public boolean k(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (in inVar : this.c) {
                if (inVar != null && inVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.zh7
    public void l(dd7 dd7Var) {
        List<in> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, dd7Var) == null) && (list = this.c) != null && list.size() != 0) {
            for (in inVar : this.c) {
                if (inVar instanceof id7) {
                    ((id7) inVar).z(dd7Var);
                }
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<in> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && (list = this.c) != null && list.size() != 0) {
            for (in inVar : this.c) {
                if (inVar instanceof id7) {
                    ((id7) inVar).A(frsViewData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.zh7
    public void e() {
        List<in> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.c) != null && list.size() != 0) {
            for (in inVar : this.c) {
                if (inVar instanceof id7) {
                    ((id7) inVar).m(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            z(this.c);
        }
    }

    @Override // com.baidu.tieba.zh7
    public void g(ArrayList<vn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            ix9.f(arrayList, 1);
            n(arrayList);
            x(arrayList);
            r(arrayList);
            Iterator<vn> it = arrayList.iterator();
            while (it.hasNext()) {
                vn next = it.next();
                if ((next instanceof n45) && ((n45) next).t.isTop()) {
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

    public final ArrayList<Integer> n(ArrayList<vn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                for (int i = 0; i < arrayList.size(); i++) {
                    vn vnVar = arrayList.get(i);
                    if (vnVar instanceof AdvertAppInfo) {
                        arrayList2.add(Integer.valueOf(i));
                        HashMap<Integer, ThreadData> hashMap = this.d;
                        if (hashMap != null && !hashMap.containsValue(vnVar)) {
                            this.d.put(Integer.valueOf(i), (ThreadData) vnVar);
                        }
                    }
                }
                return arrayList2;
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void x(ArrayList<vn> arrayList) {
        List<in> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, arrayList) == null) && (list = this.c) != null && list.size() != 0) {
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<vn> it = arrayList.iterator();
                while (it.hasNext() && it.next().getType().getId() == ThreadData.TYPE_TOP.getId()) {
                    i++;
                }
            }
            for (in inVar : this.c) {
                if (inVar instanceof id7) {
                    ((id7) inVar).F(i);
                }
            }
        }
    }

    public void o(FrsFragment frsFragment, bo boVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, frsFragment, boVar) == null) {
            this.a = frsFragment;
            this.j = cd7.e().c(frsFragment.getPageContext(), lx9.d, this.a.getUniqueId(), false);
            th7 th7Var = new th7(frsFragment.t(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = th7Var;
            th7Var.C(boVar);
            fh7 fh7Var = new fh7(frsFragment.t(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = fh7Var;
            fh7Var.C(boVar);
            qh7 qh7Var = new qh7(frsFragment.t(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = qh7Var;
            qh7Var.C(boVar);
            nh7 nh7Var = new nh7(frsFragment.t(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = nh7Var;
            nh7Var.C(boVar);
            eh7 eh7Var = new eh7(frsFragment.t(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = eh7Var;
            eh7Var.C(boVar);
            hh7 hh7Var = new hh7(frsFragment.t(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = hh7Var;
            hh7Var.C(boVar);
            vh7 vh7Var = new vh7(frsFragment.t(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = vh7Var;
            vh7Var.C(boVar);
            rh7 rh7Var = new rh7(frsFragment.t(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = rh7Var;
            rh7Var.C(boVar);
            ph7 ph7Var = new ph7(frsFragment.t(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = ph7Var;
            ph7Var.C(boVar);
            mh7 mh7Var = new mh7(frsFragment.t(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = mh7Var;
            mh7Var.C(boVar);
            uh7 uh7Var = new uh7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = uh7Var;
            uh7Var.C(boVar);
            gh7 gh7Var = new gh7(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = gh7Var;
            gh7Var.C(boVar);
            kh7 kh7Var = new kh7(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            kh7Var.C(boVar);
            sh7 sh7Var = new sh7(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            sh7Var.C(boVar);
            tg7 tg7Var = new tg7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            tg7Var.C(boVar);
            tg7Var.p(1);
            vg7 vg7Var = new vg7(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            vg7Var.C(boVar);
            ug7 ug7Var = new ug7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            ug7Var.C(boVar);
            ug7Var.g0(true);
            ah7 ah7Var = new ah7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            ah7Var.C(boVar);
            ah7Var.g0(true);
            bh7 bh7Var = new bh7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            bh7Var.C(boVar);
            bh7Var.h0(true);
            uh7 uh7Var2 = new uh7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            uh7Var2.C(boVar);
            jh7 jh7Var = new jh7(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            jh7Var.C(boVar);
            ih7 ih7Var = new ih7(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            ih7Var.C(boVar);
            this.i = new yh7(frsFragment.getPageContext(), dx9.c, this.a.getUniqueId());
            oh7 oh7Var = new oh7(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = oh7Var;
            oh7Var.C(boVar);
            in<? extends n45, ? extends TypeAdapter.ViewHolder> a = cd7.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            in<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = cd7.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            pd7 pd7Var = new pd7(frsFragment.getPageContext(), qd7.b);
            ch7 ch7Var = new ch7(frsFragment.getPageContext(), td7.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), vd7.e, this.a.getUniqueId());
            yg7 yg7Var = new yg7(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            yg7Var.x((BdTypeRecyclerView) boVar);
            dh7 dh7Var = new dh7(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            sg7 sg7Var = new sg7(frsFragment.t(), m66.g);
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
            this.c.add(kh7Var);
            this.c.add(sh7Var);
            this.c.add(tg7Var);
            this.c.add(vg7Var);
            this.c.add(ug7Var);
            this.c.add(ah7Var);
            this.c.add(bh7Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(pd7Var);
            this.c.add(ch7Var);
            this.c.add(jh7Var);
            this.c.add(ih7Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(uh7Var2);
            this.c.add(yg7Var);
            this.c.add(dh7Var);
            this.c.add(sg7Var);
            this.c.add(new xg7(frsFragment.getPageContext()));
            this.c.add(ts7.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_hot_tab"));
            c46 c46Var = new c46(this.a, 1);
            c46Var.u(this.c);
            c46Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, c46Var));
            z(this.c);
            boVar.addAdapters(this.c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            s("page_frs");
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<in<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    in<?, ?> next = it.next();
                    if (next instanceof id7) {
                        ((id7) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<in> list = this.c;
                if (list != null) {
                    list.addAll(arrayList);
                }
                bo boVar2 = this.b;
                if (boVar2 != null) {
                    boVar2.addAdapters(arrayList);
                }
            }
        }
    }

    @Override // com.baidu.tieba.zh7
    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (in inVar : this.c) {
                if (inVar instanceof id7) {
                    ((id7) inVar).x();
                } else if (inVar instanceof zl9) {
                    ((zl9) inVar).onDestroy();
                }
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || ListUtils.isEmpty(this.c) || this.a == null) {
            return;
        }
        for (in inVar : this.c) {
            if (inVar instanceof id7) {
                ((id7) inVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        yh7 yh7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (frsViewData = this.f) != null && frsViewData.getForum() != null && !StringUtils.isNull(this.f.getForum().getId()) && (yh7Var = this.i) != null) {
            yh7Var.M(this.f.getForum().getId());
        }
    }

    public final void r(ArrayList<vn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                vn vnVar = (vn) ListUtils.getItem(arrayList, i - 1);
                vn vnVar2 = (vn) ListUtils.getItem(arrayList, i);
                if (vnVar2 instanceof n45) {
                    ThreadData threadData = ((n45) vnVar2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (vnVar instanceof td7) {
                        threadData.needTopMargin = false;
                    } else if (vnVar != null && !p(vnVar)) {
                        threadData.needTopMargin = false;
                    } else if ((vnVar instanceof n45) && p(vnVar) && !TextUtils.isEmpty(((n45) vnVar).t.getRecomReason())) {
                        threadData.needTopMargin = true;
                    } else if (p(vnVar2) && !TextUtils.isEmpty(recomReason)) {
                        threadData.needTopMargin = true;
                    } else {
                        threadData.needTopMargin = false;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.zh7
    public void setFromCDN(boolean z) {
        List<in> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (list = this.c) != null && list.size() != 0) {
            for (in inVar : this.c) {
                if (inVar instanceof id7) {
                    ((id7) inVar).setFromCDN(z);
                }
            }
            th7 th7Var = this.k;
            if (th7Var != null) {
                th7Var.setFromCDN(z);
            }
            fh7 fh7Var = this.l;
            if (fh7Var != null) {
                fh7Var.setFromCDN(z);
            }
            qh7 qh7Var = this.m;
            if (qh7Var != null) {
                qh7Var.setFromCDN(z);
            }
            nh7 nh7Var = this.n;
            if (nh7Var != null) {
                nh7Var.setFromCDN(z);
            }
            eh7 eh7Var = this.o;
            if (eh7Var != null) {
                eh7Var.setFromCDN(z);
            }
            hh7 hh7Var = this.p;
            if (hh7Var != null) {
                hh7Var.setFromCDN(z);
            }
            uh7 uh7Var = this.u;
            if (uh7Var != null) {
                uh7Var.setFromCDN(z);
            }
            oh7 oh7Var = this.w;
            if (oh7Var != null) {
                oh7Var.setFromCDN(z);
            }
        }
    }

    public void t(String str) {
        List<in> list;
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
            for (in inVar : this.c) {
                if (inVar != null) {
                    Class<?> cls3 = inVar.getClass();
                    if (cls3 == cls) {
                        try {
                            cls3.getDeclaredMethod("setTab", String.class).invoke(inVar, str);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else if (cls3 == cls2) {
                        try {
                            cls3.getDeclaredMethod("setPageTab", String.class).invoke(inVar, str);
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
