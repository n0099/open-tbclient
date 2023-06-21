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
/* loaded from: classes7.dex */
public class qh7 implements ei7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public co b;
    public List<jn> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<wn> e;
    public FrsViewData f;
    public boolean g;
    public final ld7 h;
    public di7 i;
    public jn j;
    public yh7 k;
    public kh7 l;
    public vh7 m;
    public sh7 n;
    public jh7 o;
    public mh7 p;
    public wh7 q;
    public ai7 r;
    public uh7 s;
    public rh7 t;
    public zh7 u;
    public lh7 v;
    public th7 w;

    public qh7(FrsFragment frsFragment, co coVar, boolean z) {
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
        this.h = new ld7();
        o(frsFragment, coVar);
        this.d = new HashMap<>();
        m(z);
    }

    @Override // com.baidu.tieba.ei7
    public void a(String str) {
        List<jn> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (jn jnVar : list) {
            if (jnVar instanceof jo6) {
                ((jo6) jnVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.ei7
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
            if (jnVar instanceof k56) {
                ((k56) jnVar).g(str);
            }
        }
    }

    public final void z(List<jn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, list) != null) || list == null) {
            return;
        }
        for (jn jnVar : list) {
            if (jnVar instanceof nd7) {
                ((nd7) jnVar).y(this.h);
            }
        }
    }

    @Override // com.baidu.tieba.ei7
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
                } else if (wnVar instanceof o45) {
                    o45 o45Var = (o45) wnVar;
                    if (o45Var.t.getIs_top() != 0) {
                        o45Var.t.parser_title();
                    }
                }
            }
        }
    }

    public final void w() {
        uo7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.f == null) {
            return;
        }
        for (jn jnVar : this.c) {
            if ((jnVar instanceof wo7) && (i = ((wo7) jnVar).i()) != null) {
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

    @Override // com.baidu.tieba.ei7
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090c64;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ei7
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

    @Override // com.baidu.tieba.ei7
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ei7
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090c3f;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ei7
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090d0b;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ei7
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

    @Override // com.baidu.tieba.ei7
    public void d(go goVar) {
        List<jn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, goVar) == null) && (list = this.c) != null && list.size() != 0) {
            for (jn jnVar : this.c) {
                if (jnVar instanceof nd7) {
                    ((nd7) jnVar).setOnAdapterItemClickListener(goVar);
                } else if ((jnVar instanceof th7) || (jnVar instanceof zh7)) {
                    jnVar.setOnAdapterItemClickListener(goVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ei7
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

    @Override // com.baidu.tieba.ei7
    public void l(id7 id7Var) {
        List<jn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, id7Var) == null) && (list = this.c) != null && list.size() != 0) {
            for (jn jnVar : this.c) {
                if (jnVar instanceof nd7) {
                    ((nd7) jnVar).z(id7Var);
                }
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<jn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && (list = this.c) != null && list.size() != 0) {
            for (jn jnVar : this.c) {
                if (jnVar instanceof nd7) {
                    ((nd7) jnVar).A(frsViewData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ei7
    public void e() {
        List<jn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.c) != null && list.size() != 0) {
            for (jn jnVar : this.c) {
                if (jnVar instanceof nd7) {
                    ((nd7) jnVar).m(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            z(this.c);
        }
    }

    @Override // com.baidu.tieba.ei7
    public void g(ArrayList<wn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            az9.f(arrayList, 1);
            n(arrayList);
            x(arrayList);
            r(arrayList);
            Iterator<wn> it = arrayList.iterator();
            while (it.hasNext()) {
                wn next = it.next();
                if ((next instanceof o45) && ((o45) next).t.isTop()) {
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
                if (jnVar instanceof nd7) {
                    ((nd7) jnVar).F(i);
                }
            }
        }
    }

    public void o(FrsFragment frsFragment, co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, frsFragment, coVar) == null) {
            this.a = frsFragment;
            this.j = hd7.e().c(frsFragment.getPageContext(), dz9.d, this.a.getUniqueId(), false);
            yh7 yh7Var = new yh7(frsFragment.t(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = yh7Var;
            yh7Var.C(coVar);
            kh7 kh7Var = new kh7(frsFragment.t(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = kh7Var;
            kh7Var.C(coVar);
            vh7 vh7Var = new vh7(frsFragment.t(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = vh7Var;
            vh7Var.C(coVar);
            sh7 sh7Var = new sh7(frsFragment.t(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = sh7Var;
            sh7Var.C(coVar);
            jh7 jh7Var = new jh7(frsFragment.t(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = jh7Var;
            jh7Var.C(coVar);
            mh7 mh7Var = new mh7(frsFragment.t(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = mh7Var;
            mh7Var.C(coVar);
            ai7 ai7Var = new ai7(frsFragment.t(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = ai7Var;
            ai7Var.C(coVar);
            wh7 wh7Var = new wh7(frsFragment.t(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = wh7Var;
            wh7Var.C(coVar);
            uh7 uh7Var = new uh7(frsFragment.t(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = uh7Var;
            uh7Var.C(coVar);
            rh7 rh7Var = new rh7(frsFragment.t(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = rh7Var;
            rh7Var.C(coVar);
            zh7 zh7Var = new zh7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = zh7Var;
            zh7Var.C(coVar);
            lh7 lh7Var = new lh7(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = lh7Var;
            lh7Var.C(coVar);
            ph7 ph7Var = new ph7(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            ph7Var.C(coVar);
            xh7 xh7Var = new xh7(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            xh7Var.C(coVar);
            yg7 yg7Var = new yg7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            yg7Var.C(coVar);
            yg7Var.p(1);
            ah7 ah7Var = new ah7(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            ah7Var.C(coVar);
            zg7 zg7Var = new zg7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            zg7Var.C(coVar);
            zg7Var.g0(true);
            fh7 fh7Var = new fh7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            fh7Var.C(coVar);
            fh7Var.g0(true);
            gh7 gh7Var = new gh7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            gh7Var.C(coVar);
            gh7Var.h0(true);
            zh7 zh7Var2 = new zh7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            zh7Var2.C(coVar);
            oh7 oh7Var = new oh7(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            oh7Var.C(coVar);
            nh7 nh7Var = new nh7(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            nh7Var.C(coVar);
            this.i = new di7(frsFragment.getPageContext(), vy9.c, this.a.getUniqueId());
            th7 th7Var = new th7(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = th7Var;
            th7Var.C(coVar);
            jn<? extends o45, ? extends TypeAdapter.ViewHolder> a = hd7.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            jn<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = hd7.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            ud7 ud7Var = new ud7(frsFragment.getPageContext(), vd7.b);
            hh7 hh7Var = new hh7(frsFragment.getPageContext(), yd7.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), ae7.e, this.a.getUniqueId());
            dh7 dh7Var = new dh7(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            dh7Var.x((BdTypeRecyclerView) coVar);
            ih7 ih7Var = new ih7(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            xg7 xg7Var = new xg7(frsFragment.t(), r66.g);
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
            this.c.add(ph7Var);
            this.c.add(xh7Var);
            this.c.add(yg7Var);
            this.c.add(ah7Var);
            this.c.add(zg7Var);
            this.c.add(fh7Var);
            this.c.add(gh7Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(ud7Var);
            this.c.add(hh7Var);
            this.c.add(oh7Var);
            this.c.add(nh7Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(zh7Var2);
            this.c.add(dh7Var);
            this.c.add(ih7Var);
            this.c.add(xg7Var);
            this.c.add(new ch7(frsFragment.getPageContext()));
            this.c.add(bt7.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_hot_tab"));
            h46 h46Var = new h46(this.a, 1);
            h46Var.u(this.c);
            h46Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, h46Var));
            z(this.c);
            coVar.addAdapters(this.c);
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
                    if (next instanceof nd7) {
                        ((nd7) next).m(this.a.getPageContext(), this.a.getUniqueId());
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
                    coVar2.addAdapters(arrayList);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ei7
    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (jn jnVar : this.c) {
                if (jnVar instanceof nd7) {
                    ((nd7) jnVar).x();
                } else if (jnVar instanceof rn9) {
                    ((rn9) jnVar).onDestroy();
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
            if (jnVar instanceof nd7) {
                ((nd7) jnVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        di7 di7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (frsViewData = this.f) != null && frsViewData.getForum() != null && !StringUtils.isNull(this.f.getForum().getId()) && (di7Var = this.i) != null) {
            di7Var.M(this.f.getForum().getId());
        }
    }

    public final void r(ArrayList<wn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                wn wnVar = (wn) ListUtils.getItem(arrayList, i - 1);
                wn wnVar2 = (wn) ListUtils.getItem(arrayList, i);
                if (wnVar2 instanceof o45) {
                    ThreadData threadData = ((o45) wnVar2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (wnVar instanceof yd7) {
                        threadData.needTopMargin = false;
                    } else if (wnVar != null && !p(wnVar)) {
                        threadData.needTopMargin = false;
                    } else if ((wnVar instanceof o45) && p(wnVar) && !TextUtils.isEmpty(((o45) wnVar).t.getRecomReason())) {
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

    @Override // com.baidu.tieba.ei7
    public void setFromCDN(boolean z) {
        List<jn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (list = this.c) != null && list.size() != 0) {
            for (jn jnVar : this.c) {
                if (jnVar instanceof nd7) {
                    ((nd7) jnVar).setFromCDN(z);
                }
            }
            yh7 yh7Var = this.k;
            if (yh7Var != null) {
                yh7Var.setFromCDN(z);
            }
            kh7 kh7Var = this.l;
            if (kh7Var != null) {
                kh7Var.setFromCDN(z);
            }
            vh7 vh7Var = this.m;
            if (vh7Var != null) {
                vh7Var.setFromCDN(z);
            }
            sh7 sh7Var = this.n;
            if (sh7Var != null) {
                sh7Var.setFromCDN(z);
            }
            jh7 jh7Var = this.o;
            if (jh7Var != null) {
                jh7Var.setFromCDN(z);
            }
            mh7 mh7Var = this.p;
            if (mh7Var != null) {
                mh7Var.setFromCDN(z);
            }
            zh7 zh7Var = this.u;
            if (zh7Var != null) {
                zh7Var.setFromCDN(z);
            }
            th7 th7Var = this.w;
            if (th7Var != null) {
                th7Var.setFromCDN(z);
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
