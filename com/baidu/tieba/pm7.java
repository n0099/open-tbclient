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
public class pm7 implements dn7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public in b;
    public List<pm> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<cn> e;
    public FrsViewData f;
    public boolean g;
    public final di7 h;
    public cn7 i;
    public pm j;
    public xm7 k;
    public jm7 l;
    public um7 m;
    public rm7 n;
    public im7 o;
    public lm7 p;
    public vm7 q;
    public zm7 r;
    public tm7 s;
    public qm7 t;
    public ym7 u;
    public km7 v;
    public sm7 w;

    public pm7(FrsFragment frsFragment, in inVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, inVar, Boolean.valueOf(z)};
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
        this.b = inVar;
        this.h = new di7();
        o(frsFragment, inVar);
        this.d = new HashMap<>();
        m(z);
    }

    @Override // com.baidu.tieba.dn7
    public void a(String str) {
        List<pm> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (pm pmVar : list) {
            if (pmVar instanceof kp6) {
                ((kp6) pmVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.dn7
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && this.g != z) {
            this.g = z;
        }
    }

    public final boolean p(cn cnVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, cnVar)) == null) {
            if (cnVar == null) {
                return false;
            }
            BdUniqueId type = cnVar.getType();
            if (type != ThreadData.TYPE_NORMAL && type != ThreadData.TYPE_GOD_NORMAL && type != ThreadData.TYPE_VIDEO && type != ThreadData.TYPE_VIDEO_GOD && type != ThreadData.TYPE_INSERT_VIDEO) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void s(String str) {
        List<pm> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (pm pmVar : list) {
            if (pmVar instanceof o56) {
                ((o56) pmVar).g(str);
            }
        }
    }

    public final void z(List<pm> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, list) != null) || list == null) {
            return;
        }
        for (pm pmVar : list) {
            if (pmVar instanceof fi7) {
                ((fi7) pmVar).y(this.h);
            }
        }
    }

    @Override // com.baidu.tieba.dn7
    public void b() {
        in inVar;
        List<cn> data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (inVar = this.b) != null && inVar.getData() != null && this.b.getData().size() != 0 && (data = this.b.getData()) != null && data.size() != 0) {
            for (cn cnVar : data) {
                if (cnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) cnVar;
                    if (threadData.getIs_top() != 0) {
                        threadData.parser_title();
                    }
                } else if (cnVar instanceof h45) {
                    h45 h45Var = (h45) cnVar;
                    if (h45Var.t.getIs_top() != 0) {
                        h45Var.t.parser_title();
                    }
                }
            }
        }
    }

    public final void w() {
        vt7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.f == null) {
            return;
        }
        for (pm pmVar : this.c) {
            if ((pmVar instanceof xt7) && (i = ((xt7) pmVar).i()) != null) {
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
                if (frsFragment != null && frsFragment.f1() != null) {
                    int h0 = this.a.f1().h0();
                    if (h0 == -1) {
                        h0 = this.a.f1().g0();
                    }
                    i.b = h0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.dn7
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090c95;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.dn7
    public List<cn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            in inVar = this.b;
            if (inVar != null) {
                return inVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dn7
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dn7
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090c70;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.dn7
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090d3c;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.dn7
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.b.getListAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList<cn> arrayList = this.e;
            if (arrayList != null) {
                this.b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.dn7
    public void d(mn mnVar) {
        List<pm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, mnVar) == null) && (list = this.c) != null && list.size() != 0) {
            for (pm pmVar : this.c) {
                if (pmVar instanceof fi7) {
                    ((fi7) pmVar).setOnAdapterItemClickListener(mnVar);
                } else if ((pmVar instanceof sm7) || (pmVar instanceof ym7)) {
                    pmVar.setOnAdapterItemClickListener(mnVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.dn7
    public boolean k(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (pm pmVar : this.c) {
                if (pmVar != null && pmVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.dn7
    public void l(ai7 ai7Var) {
        List<pm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, ai7Var) == null) && (list = this.c) != null && list.size() != 0) {
            for (pm pmVar : this.c) {
                if (pmVar instanceof fi7) {
                    ((fi7) pmVar).z(ai7Var);
                }
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<pm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && (list = this.c) != null && list.size() != 0) {
            for (pm pmVar : this.c) {
                if (pmVar instanceof fi7) {
                    ((fi7) pmVar).A(frsViewData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.dn7
    public void e() {
        List<pm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.c) != null && list.size() != 0) {
            for (pm pmVar : this.c) {
                if (pmVar instanceof fi7) {
                    ((fi7) pmVar).m(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            z(this.c);
        }
    }

    @Override // com.baidu.tieba.dn7
    public void g(ArrayList<cn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            tga.f(arrayList, 1);
            n(arrayList);
            x(arrayList);
            r(arrayList);
            Iterator<cn> it = arrayList.iterator();
            while (it.hasNext()) {
                cn next = it.next();
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

    public final ArrayList<Integer> n(ArrayList<cn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                for (int i = 0; i < arrayList.size(); i++) {
                    cn cnVar = arrayList.get(i);
                    if (cnVar instanceof AdvertAppInfo) {
                        arrayList2.add(Integer.valueOf(i));
                        HashMap<Integer, ThreadData> hashMap = this.d;
                        if (hashMap != null && !hashMap.containsValue(cnVar)) {
                            this.d.put(Integer.valueOf(i), (ThreadData) cnVar);
                        }
                    }
                }
                return arrayList2;
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void x(ArrayList<cn> arrayList) {
        List<pm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, arrayList) == null) && (list = this.c) != null && list.size() != 0) {
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<cn> it = arrayList.iterator();
                while (it.hasNext() && it.next().getType().getId() == ThreadData.TYPE_TOP.getId()) {
                    i++;
                }
            }
            for (pm pmVar : this.c) {
                if (pmVar instanceof fi7) {
                    ((fi7) pmVar).F(i);
                }
            }
        }
    }

    public void o(FrsFragment frsFragment, in inVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, frsFragment, inVar) == null) {
            this.a = frsFragment;
            this.j = zh7.e().c(frsFragment.getPageContext(), vga.d, this.a.getUniqueId(), false);
            xm7 xm7Var = new xm7(frsFragment.u(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = xm7Var;
            xm7Var.C(inVar);
            jm7 jm7Var = new jm7(frsFragment.u(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = jm7Var;
            jm7Var.C(inVar);
            um7 um7Var = new um7(frsFragment.u(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = um7Var;
            um7Var.C(inVar);
            rm7 rm7Var = new rm7(frsFragment.u(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = rm7Var;
            rm7Var.C(inVar);
            im7 im7Var = new im7(frsFragment.u(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = im7Var;
            im7Var.C(inVar);
            lm7 lm7Var = new lm7(frsFragment.u(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = lm7Var;
            lm7Var.C(inVar);
            zm7 zm7Var = new zm7(frsFragment.u(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = zm7Var;
            zm7Var.C(inVar);
            vm7 vm7Var = new vm7(frsFragment.u(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = vm7Var;
            vm7Var.C(inVar);
            tm7 tm7Var = new tm7(frsFragment.u(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = tm7Var;
            tm7Var.C(inVar);
            qm7 qm7Var = new qm7(frsFragment.u(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = qm7Var;
            qm7Var.C(inVar);
            ym7 ym7Var = new ym7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = ym7Var;
            ym7Var.C(inVar);
            km7 km7Var = new km7(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = km7Var;
            km7Var.C(inVar);
            om7 om7Var = new om7(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            om7Var.C(inVar);
            wm7 wm7Var = new wm7(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            wm7Var.C(inVar);
            vl7 vl7Var = new vl7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            vl7Var.C(inVar);
            vl7Var.p(1);
            xl7 xl7Var = new xl7(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            xl7Var.C(inVar);
            wl7 wl7Var = new wl7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            wl7Var.C(inVar);
            wl7Var.g0(true);
            dm7 dm7Var = new dm7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            dm7Var.C(inVar);
            dm7Var.P(true);
            em7 em7Var = new em7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            em7Var.C(inVar);
            em7Var.P(true);
            ym7 ym7Var2 = new ym7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            ym7Var2.C(inVar);
            nm7 nm7Var = new nm7(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            nm7Var.C(inVar);
            mm7 mm7Var = new mm7(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            mm7Var.C(inVar);
            this.i = new cn7(frsFragment.getPageContext(), oga.c, this.a.getUniqueId());
            sm7 sm7Var = new sm7(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = sm7Var;
            sm7Var.C(inVar);
            pm<? extends h45, ? extends TypeAdapter.ViewHolder> a = zh7.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            pm<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = zh7.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            mi7 mi7Var = new mi7(frsFragment.getPageContext(), ni7.b);
            gm7 gm7Var = new gm7(frsFragment.getPageContext(), qi7.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), si7.e, this.a.getUniqueId());
            bm7 bm7Var = new bm7(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            bm7Var.x((BdTypeRecyclerView) inVar);
            hm7 hm7Var = new hm7(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            tl7 tl7Var = new tl7(frsFragment.u(), v66.g);
            am7 am7Var = new am7(frsFragment.getPageContext(), cq6.A0);
            am7Var.u(inVar);
            fm7 fm7Var = new fm7(frsFragment.getPageContext(), hq6.j);
            fm7Var.u(inVar);
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
            this.c.add(om7Var);
            this.c.add(wm7Var);
            this.c.add(vl7Var);
            this.c.add(xl7Var);
            this.c.add(wl7Var);
            this.c.add(dm7Var);
            this.c.add(em7Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(mi7Var);
            this.c.add(gm7Var);
            this.c.add(nm7Var);
            this.c.add(mm7Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(ym7Var2);
            this.c.add(bm7Var);
            this.c.add(hm7Var);
            this.c.add(tl7Var);
            this.c.add(new zl7(frsFragment.getPageContext()));
            this.c.add(am7Var);
            this.c.add(fm7Var);
            this.c.add(jy7.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.I, "frs_hot_tab"));
            l46 l46Var = new l46(this.a, 1);
            l46Var.u(this.c);
            l46Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, l46Var));
            z(this.c);
            inVar.addAdapters(this.c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            s("page_frs");
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<pm<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    pm<?, ?> next = it.next();
                    if (next instanceof fi7) {
                        ((fi7) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<pm> list = this.c;
                if (list != null) {
                    list.addAll(arrayList);
                }
                in inVar2 = this.b;
                if (inVar2 != null) {
                    inVar2.addAdapters(arrayList);
                }
            }
        }
    }

    @Override // com.baidu.tieba.dn7
    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (pm pmVar : this.c) {
                if (pmVar instanceof fi7) {
                    ((fi7) pmVar).x();
                } else if (pmVar instanceof y2a) {
                    ((y2a) pmVar).onDestroy();
                }
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || ListUtils.isEmpty(this.c) || this.a == null) {
            return;
        }
        for (pm pmVar : this.c) {
            if (pmVar instanceof fi7) {
                ((fi7) pmVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        cn7 cn7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (frsViewData = this.f) != null && frsViewData.getForum() != null && !StringUtils.isNull(this.f.getForum().getId()) && (cn7Var = this.i) != null) {
            cn7Var.L(this.f.getForum().getId());
        }
    }

    public final void r(ArrayList<cn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                cn cnVar = (cn) ListUtils.getItem(arrayList, i - 1);
                cn cnVar2 = (cn) ListUtils.getItem(arrayList, i);
                if (cnVar2 instanceof h45) {
                    ThreadData threadData = ((h45) cnVar2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (cnVar instanceof qi7) {
                        threadData.needTopMargin = false;
                    } else if (cnVar != null && !p(cnVar)) {
                        threadData.needTopMargin = false;
                    } else if ((cnVar instanceof h45) && p(cnVar) && !TextUtils.isEmpty(((h45) cnVar).t.getRecomReason())) {
                        threadData.needTopMargin = true;
                    } else if (p(cnVar2) && !TextUtils.isEmpty(recomReason)) {
                        threadData.needTopMargin = true;
                    } else {
                        threadData.needTopMargin = false;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.dn7
    public void setFromCDN(boolean z) {
        List<pm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (list = this.c) != null && list.size() != 0) {
            for (pm pmVar : this.c) {
                if (pmVar instanceof fi7) {
                    ((fi7) pmVar).setFromCDN(z);
                }
            }
            xm7 xm7Var = this.k;
            if (xm7Var != null) {
                xm7Var.setFromCDN(z);
            }
            jm7 jm7Var = this.l;
            if (jm7Var != null) {
                jm7Var.setFromCDN(z);
            }
            um7 um7Var = this.m;
            if (um7Var != null) {
                um7Var.setFromCDN(z);
            }
            rm7 rm7Var = this.n;
            if (rm7Var != null) {
                rm7Var.setFromCDN(z);
            }
            im7 im7Var = this.o;
            if (im7Var != null) {
                im7Var.setFromCDN(z);
            }
            lm7 lm7Var = this.p;
            if (lm7Var != null) {
                lm7Var.setFromCDN(z);
            }
            ym7 ym7Var = this.u;
            if (ym7Var != null) {
                ym7Var.setFromCDN(z);
            }
            sm7 sm7Var = this.w;
            if (sm7Var != null) {
                sm7Var.setFromCDN(z);
            }
        }
    }

    public void t(String str) {
        List<pm> list;
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
            for (pm pmVar : this.c) {
                if (pmVar != null) {
                    Class<?> cls3 = pmVar.getClass();
                    if (cls3 == cls) {
                        try {
                            cls3.getDeclaredMethod("setTab", String.class).invoke(pmVar, str);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else if (cls3 == cls2) {
                        try {
                            cls3.getDeclaredMethod("setPageTab", String.class).invoke(pmVar, str);
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
