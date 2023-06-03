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
public class jh7 implements xh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public bo b;
    public List<in> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<vn> e;
    public FrsViewData f;
    public boolean g;
    public final ed7 h;
    public wh7 i;
    public in j;
    public rh7 k;
    public dh7 l;
    public oh7 m;
    public lh7 n;
    public ch7 o;
    public fh7 p;
    public ph7 q;
    public th7 r;
    public nh7 s;
    public kh7 t;
    public sh7 u;
    public eh7 v;
    public mh7 w;

    public jh7(FrsFragment frsFragment, bo boVar, boolean z) {
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
        this.h = new ed7();
        o(frsFragment, boVar);
        this.d = new HashMap<>();
        m(z);
    }

    @Override // com.baidu.tieba.xh7
    public void a(String str) {
        List<in> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (in inVar : list) {
            if (inVar instanceof co6) {
                ((co6) inVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.xh7
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
            if (inVar instanceof d56) {
                ((d56) inVar).g(str);
            }
        }
    }

    public final void z(List<in> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, list) != null) || list == null) {
            return;
        }
        for (in inVar : list) {
            if (inVar instanceof gd7) {
                ((gd7) inVar).y(this.h);
            }
        }
    }

    @Override // com.baidu.tieba.xh7
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
                } else if (vnVar instanceof l45) {
                    l45 l45Var = (l45) vnVar;
                    if (l45Var.t.getIs_top() != 0) {
                        l45Var.t.parser_title();
                    }
                }
            }
        }
    }

    public final void w() {
        ko7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.f == null) {
            return;
        }
        for (in inVar : this.c) {
            if ((inVar instanceof mo7) && (i = ((mo7) inVar).i()) != null) {
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

    @Override // com.baidu.tieba.xh7
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

    @Override // com.baidu.tieba.xh7
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

    @Override // com.baidu.tieba.xh7
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xh7
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

    @Override // com.baidu.tieba.xh7
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

    @Override // com.baidu.tieba.xh7
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

    @Override // com.baidu.tieba.xh7
    public void d(fo foVar) {
        List<in> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, foVar) == null) && (list = this.c) != null && list.size() != 0) {
            for (in inVar : this.c) {
                if (inVar instanceof gd7) {
                    ((gd7) inVar).setOnAdapterItemClickListener(foVar);
                } else if ((inVar instanceof mh7) || (inVar instanceof sh7)) {
                    inVar.setOnAdapterItemClickListener(foVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.xh7
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

    @Override // com.baidu.tieba.xh7
    public void l(bd7 bd7Var) {
        List<in> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, bd7Var) == null) && (list = this.c) != null && list.size() != 0) {
            for (in inVar : this.c) {
                if (inVar instanceof gd7) {
                    ((gd7) inVar).z(bd7Var);
                }
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<in> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && (list = this.c) != null && list.size() != 0) {
            for (in inVar : this.c) {
                if (inVar instanceof gd7) {
                    ((gd7) inVar).A(frsViewData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.xh7
    public void e() {
        List<in> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.c) != null && list.size() != 0) {
            for (in inVar : this.c) {
                if (inVar instanceof gd7) {
                    ((gd7) inVar).m(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            z(this.c);
        }
    }

    @Override // com.baidu.tieba.xh7
    public void g(ArrayList<vn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            dx9.f(arrayList, 1);
            n(arrayList);
            x(arrayList);
            r(arrayList);
            Iterator<vn> it = arrayList.iterator();
            while (it.hasNext()) {
                vn next = it.next();
                if ((next instanceof l45) && ((l45) next).t.isTop()) {
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
                if (inVar instanceof gd7) {
                    ((gd7) inVar).F(i);
                }
            }
        }
    }

    public void o(FrsFragment frsFragment, bo boVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, frsFragment, boVar) == null) {
            this.a = frsFragment;
            this.j = ad7.e().c(frsFragment.getPageContext(), gx9.d, this.a.getUniqueId(), false);
            rh7 rh7Var = new rh7(frsFragment.t(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = rh7Var;
            rh7Var.C(boVar);
            dh7 dh7Var = new dh7(frsFragment.t(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = dh7Var;
            dh7Var.C(boVar);
            oh7 oh7Var = new oh7(frsFragment.t(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = oh7Var;
            oh7Var.C(boVar);
            lh7 lh7Var = new lh7(frsFragment.t(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = lh7Var;
            lh7Var.C(boVar);
            ch7 ch7Var = new ch7(frsFragment.t(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = ch7Var;
            ch7Var.C(boVar);
            fh7 fh7Var = new fh7(frsFragment.t(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = fh7Var;
            fh7Var.C(boVar);
            th7 th7Var = new th7(frsFragment.t(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = th7Var;
            th7Var.C(boVar);
            ph7 ph7Var = new ph7(frsFragment.t(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = ph7Var;
            ph7Var.C(boVar);
            nh7 nh7Var = new nh7(frsFragment.t(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = nh7Var;
            nh7Var.C(boVar);
            kh7 kh7Var = new kh7(frsFragment.t(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = kh7Var;
            kh7Var.C(boVar);
            sh7 sh7Var = new sh7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = sh7Var;
            sh7Var.C(boVar);
            eh7 eh7Var = new eh7(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = eh7Var;
            eh7Var.C(boVar);
            ih7 ih7Var = new ih7(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            ih7Var.C(boVar);
            qh7 qh7Var = new qh7(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            qh7Var.C(boVar);
            rg7 rg7Var = new rg7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            rg7Var.C(boVar);
            rg7Var.p(1);
            tg7 tg7Var = new tg7(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            tg7Var.C(boVar);
            sg7 sg7Var = new sg7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            sg7Var.C(boVar);
            sg7Var.g0(true);
            yg7 yg7Var = new yg7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            yg7Var.C(boVar);
            yg7Var.g0(true);
            zg7 zg7Var = new zg7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            zg7Var.C(boVar);
            zg7Var.h0(true);
            sh7 sh7Var2 = new sh7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            sh7Var2.C(boVar);
            hh7 hh7Var = new hh7(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            hh7Var.C(boVar);
            gh7 gh7Var = new gh7(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            gh7Var.C(boVar);
            this.i = new wh7(frsFragment.getPageContext(), yw9.c, this.a.getUniqueId());
            mh7 mh7Var = new mh7(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = mh7Var;
            mh7Var.C(boVar);
            in<? extends l45, ? extends TypeAdapter.ViewHolder> a = ad7.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            in<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = ad7.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            nd7 nd7Var = new nd7(frsFragment.getPageContext(), od7.b);
            ah7 ah7Var = new ah7(frsFragment.getPageContext(), rd7.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), td7.e, this.a.getUniqueId());
            wg7 wg7Var = new wg7(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            wg7Var.x((BdTypeRecyclerView) boVar);
            bh7 bh7Var = new bh7(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            qg7 qg7Var = new qg7(frsFragment.t(), k66.g);
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
            this.c.add(ih7Var);
            this.c.add(qh7Var);
            this.c.add(rg7Var);
            this.c.add(tg7Var);
            this.c.add(sg7Var);
            this.c.add(yg7Var);
            this.c.add(zg7Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(nd7Var);
            this.c.add(ah7Var);
            this.c.add(hh7Var);
            this.c.add(gh7Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(sh7Var2);
            this.c.add(wg7Var);
            this.c.add(bh7Var);
            this.c.add(qg7Var);
            this.c.add(new vg7(frsFragment.getPageContext()));
            this.c.add(rs7.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_hot_tab"));
            a46 a46Var = new a46(this.a, 1);
            a46Var.u(this.c);
            a46Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, a46Var));
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
                    if (next instanceof gd7) {
                        ((gd7) next).m(this.a.getPageContext(), this.a.getUniqueId());
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

    @Override // com.baidu.tieba.xh7
    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (in inVar : this.c) {
                if (inVar instanceof gd7) {
                    ((gd7) inVar).x();
                } else if (inVar instanceof ul9) {
                    ((ul9) inVar).onDestroy();
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
            if (inVar instanceof gd7) {
                ((gd7) inVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        wh7 wh7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (frsViewData = this.f) != null && frsViewData.getForum() != null && !StringUtils.isNull(this.f.getForum().getId()) && (wh7Var = this.i) != null) {
            wh7Var.M(this.f.getForum().getId());
        }
    }

    public final void r(ArrayList<vn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                vn vnVar = (vn) ListUtils.getItem(arrayList, i - 1);
                vn vnVar2 = (vn) ListUtils.getItem(arrayList, i);
                if (vnVar2 instanceof l45) {
                    ThreadData threadData = ((l45) vnVar2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (vnVar instanceof rd7) {
                        threadData.needTopMargin = false;
                    } else if (vnVar != null && !p(vnVar)) {
                        threadData.needTopMargin = false;
                    } else if ((vnVar instanceof l45) && p(vnVar) && !TextUtils.isEmpty(((l45) vnVar).t.getRecomReason())) {
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

    @Override // com.baidu.tieba.xh7
    public void setFromCDN(boolean z) {
        List<in> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (list = this.c) != null && list.size() != 0) {
            for (in inVar : this.c) {
                if (inVar instanceof gd7) {
                    ((gd7) inVar).setFromCDN(z);
                }
            }
            rh7 rh7Var = this.k;
            if (rh7Var != null) {
                rh7Var.setFromCDN(z);
            }
            dh7 dh7Var = this.l;
            if (dh7Var != null) {
                dh7Var.setFromCDN(z);
            }
            oh7 oh7Var = this.m;
            if (oh7Var != null) {
                oh7Var.setFromCDN(z);
            }
            lh7 lh7Var = this.n;
            if (lh7Var != null) {
                lh7Var.setFromCDN(z);
            }
            ch7 ch7Var = this.o;
            if (ch7Var != null) {
                ch7Var.setFromCDN(z);
            }
            fh7 fh7Var = this.p;
            if (fh7Var != null) {
                fh7Var.setFromCDN(z);
            }
            sh7 sh7Var = this.u;
            if (sh7Var != null) {
                sh7Var.setFromCDN(z);
            }
            mh7 mh7Var = this.w;
            if (mh7Var != null) {
                mh7Var.setFromCDN(z);
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
