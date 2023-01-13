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
public class sr6 implements gs6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public eo b;
    public List<ln> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<yn> e;
    public FrsViewData f;
    public boolean g;
    public final nn6 h;
    public fs6 i;
    public ln j;
    public as6 k;
    public mr6 l;
    public xr6 m;
    public ur6 n;
    public lr6 o;
    public or6 p;
    public yr6 q;
    public cs6 r;
    public wr6 s;
    public tr6 t;
    public bs6 u;
    public nr6 v;
    public vr6 w;

    public sr6(FrsFragment frsFragment, eo eoVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, eoVar, Boolean.valueOf(z)};
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
        this.b = eoVar;
        this.h = new nn6();
        o(frsFragment, eoVar);
        this.d = new HashMap<>();
        m(z);
    }

    @Override // com.baidu.tieba.gs6
    public void a(String str) {
        List<ln> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (ln lnVar : list) {
            if (lnVar instanceof x86) {
                ((x86) lnVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.gs6
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && this.g != z) {
            this.g = z;
        }
    }

    public final boolean p(yn ynVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, ynVar)) == null) {
            if (ynVar == null) {
                return false;
            }
            BdUniqueId type = ynVar.getType();
            if (type != ThreadData.TYPE_NORMAL && type != ThreadData.TYPE_GOD_NORMAL && type != ThreadData.TYPE_VIDEO && type != ThreadData.TYPE_VIDEO_GOD && type != ThreadData.TYPE_INSERT_VIDEO) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void s(String str) {
        List<ln> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (ln lnVar : list) {
            if (lnVar instanceof bs5) {
                ((bs5) lnVar).g(str);
            }
        }
    }

    public final void z(List<ln> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, list) != null) || list == null) {
            return;
        }
        for (ln lnVar : list) {
            if (lnVar instanceof pn6) {
                ((pn6) lnVar).w(this.h);
            }
        }
    }

    @Override // com.baidu.tieba.gs6
    public void b() {
        eo eoVar;
        List<yn> data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (eoVar = this.b) != null && eoVar.getData() != null && this.b.getData().size() != 0 && (data = this.b.getData()) != null && data.size() != 0) {
            for (yn ynVar : data) {
                if (ynVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) ynVar;
                    if (threadData.getIs_top() != 0) {
                        threadData.parser_title();
                    }
                } else if (ynVar instanceof jv4) {
                    jv4 jv4Var = (jv4) ynVar;
                    if (jv4Var.t.getIs_top() != 0) {
                        jv4Var.t.parser_title();
                    }
                }
            }
        }
    }

    public final void w() {
        qy6 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.f == null) {
            return;
        }
        for (ln lnVar : this.c) {
            if ((lnVar instanceof sy6) && (i = ((sy6) lnVar).i()) != null) {
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
                if (frsFragment != null && frsFragment.P0() != null) {
                    int b0 = this.a.P0().b0();
                    if (b0 == -1) {
                        b0 = this.a.P0().a0();
                    }
                    i.b = b0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.gs6
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090b61;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.gs6
    public List<yn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            eo eoVar = this.b;
            if (eoVar != null) {
                return eoVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gs6
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gs6
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090b3c;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.gs6
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090c06;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.gs6
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.b.getListAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList<yn> arrayList = this.e;
            if (arrayList != null) {
                this.b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.gs6
    public void d(io ioVar) {
        List<ln> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, ioVar) == null) && (list = this.c) != null && list.size() != 0) {
            for (ln lnVar : this.c) {
                if (lnVar instanceof pn6) {
                    ((pn6) lnVar).setOnAdapterItemClickListener(ioVar);
                } else if ((lnVar instanceof vr6) || (lnVar instanceof bs6)) {
                    lnVar.setOnAdapterItemClickListener(ioVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.gs6
    public boolean k(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (ln lnVar : this.c) {
                if (lnVar != null && lnVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.gs6
    public void l(kn6 kn6Var) {
        List<ln> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, kn6Var) == null) && (list = this.c) != null && list.size() != 0) {
            for (ln lnVar : this.c) {
                if (lnVar instanceof pn6) {
                    ((pn6) lnVar).x(kn6Var);
                }
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<ln> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && (list = this.c) != null && list.size() != 0) {
            for (ln lnVar : this.c) {
                if (lnVar instanceof pn6) {
                    ((pn6) lnVar).y(frsViewData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.gs6
    public void e() {
        List<ln> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.c) != null && list.size() != 0) {
            for (ln lnVar : this.c) {
                if (lnVar instanceof pn6) {
                    ((pn6) lnVar).m(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            z(this.c);
        }
    }

    @Override // com.baidu.tieba.gs6
    public void g(ArrayList<yn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            hw8.f(arrayList, 1);
            n(arrayList);
            x(arrayList);
            r(arrayList);
            Iterator<yn> it = arrayList.iterator();
            while (it.hasNext()) {
                yn next = it.next();
                if ((next instanceof jv4) && ((jv4) next).t.isTop()) {
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

    public final ArrayList<Integer> n(ArrayList<yn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                for (int i = 0; i < arrayList.size(); i++) {
                    yn ynVar = arrayList.get(i);
                    if (ynVar instanceof AdvertAppInfo) {
                        arrayList2.add(Integer.valueOf(i));
                        HashMap<Integer, ThreadData> hashMap = this.d;
                        if (hashMap != null && !hashMap.containsValue(ynVar)) {
                            this.d.put(Integer.valueOf(i), (ThreadData) ynVar);
                        }
                    }
                }
                return arrayList2;
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void x(ArrayList<yn> arrayList) {
        List<ln> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, arrayList) == null) && (list = this.c) != null && list.size() != 0) {
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<yn> it = arrayList.iterator();
                while (it.hasNext() && it.next().getType().getId() == ThreadData.TYPE_TOP.getId()) {
                    i++;
                }
            }
            for (ln lnVar : this.c) {
                if (lnVar instanceof pn6) {
                    ((pn6) lnVar).D(i);
                }
            }
        }
    }

    public void o(FrsFragment frsFragment, eo eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, frsFragment, eoVar) == null) {
            this.a = frsFragment;
            this.j = jn6.e().c(frsFragment.getPageContext(), kw8.d, this.a.getUniqueId(), false);
            as6 as6Var = new as6(frsFragment.p(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = as6Var;
            as6Var.A(eoVar);
            mr6 mr6Var = new mr6(frsFragment.p(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = mr6Var;
            mr6Var.A(eoVar);
            xr6 xr6Var = new xr6(frsFragment.p(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = xr6Var;
            xr6Var.A(eoVar);
            ur6 ur6Var = new ur6(frsFragment.p(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = ur6Var;
            ur6Var.A(eoVar);
            lr6 lr6Var = new lr6(frsFragment.p(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = lr6Var;
            lr6Var.A(eoVar);
            or6 or6Var = new or6(frsFragment.p(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = or6Var;
            or6Var.A(eoVar);
            cs6 cs6Var = new cs6(frsFragment.p(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = cs6Var;
            cs6Var.A(eoVar);
            yr6 yr6Var = new yr6(frsFragment.p(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = yr6Var;
            yr6Var.A(eoVar);
            wr6 wr6Var = new wr6(frsFragment.p(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = wr6Var;
            wr6Var.A(eoVar);
            tr6 tr6Var = new tr6(frsFragment.p(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = tr6Var;
            tr6Var.A(eoVar);
            bs6 bs6Var = new bs6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = bs6Var;
            bs6Var.A(eoVar);
            nr6 nr6Var = new nr6(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = nr6Var;
            nr6Var.A(eoVar);
            rr6 rr6Var = new rr6(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            rr6Var.A(eoVar);
            zr6 zr6Var = new zr6(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            zr6Var.A(eoVar);
            ar6 ar6Var = new ar6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            ar6Var.A(eoVar);
            ar6Var.p(1);
            cr6 cr6Var = new cr6(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            cr6Var.A(eoVar);
            br6 br6Var = new br6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            br6Var.A(eoVar);
            br6Var.e0(true);
            hr6 hr6Var = new hr6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            hr6Var.A(eoVar);
            hr6Var.e0(true);
            ir6 ir6Var = new ir6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            ir6Var.A(eoVar);
            ir6Var.f0(true);
            bs6 bs6Var2 = new bs6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            bs6Var2.A(eoVar);
            qr6 qr6Var = new qr6(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            qr6Var.A(eoVar);
            pr6 pr6Var = new pr6(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            pr6Var.A(eoVar);
            this.i = new fs6(frsFragment.getPageContext(), cw8.c, this.a.getUniqueId());
            vr6 vr6Var = new vr6(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = vr6Var;
            vr6Var.A(eoVar);
            ln<? extends jv4, ? extends TypeAdapter.ViewHolder> a = jn6.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            ln<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = jn6.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            wn6 wn6Var = new wn6(frsFragment.getPageContext(), xn6.b);
            jr6 jr6Var = new jr6(frsFragment.getPageContext(), ao6.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), co6.e, this.a.getUniqueId());
            fr6 fr6Var = new fr6(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            fr6Var.v((BdTypeRecyclerView) eoVar);
            kr6 kr6Var = new kr6(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            zq6 zq6Var = new zq6(frsFragment.p(), gt5.g);
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
            this.c.add(rr6Var);
            this.c.add(zr6Var);
            this.c.add(ar6Var);
            this.c.add(cr6Var);
            this.c.add(br6Var);
            this.c.add(hr6Var);
            this.c.add(ir6Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(wn6Var);
            this.c.add(jr6Var);
            this.c.add(qr6Var);
            this.c.add(pr6Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(bs6Var2);
            this.c.add(fr6Var);
            this.c.add(kr6Var);
            this.c.add(zq6Var);
            this.c.add(new er6(frsFragment.getPageContext()));
            this.c.add(u17.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_hot_tab"));
            yq5 yq5Var = new yq5(this.a, 1);
            yq5Var.u(this.c);
            yq5Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, yq5Var));
            z(this.c);
            eoVar.a(this.c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            s("page_frs");
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<ln<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    ln<?, ?> next = it.next();
                    if (next instanceof pn6) {
                        ((pn6) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<ln> list = this.c;
                if (list != null) {
                    list.addAll(arrayList);
                }
                eo eoVar2 = this.b;
                if (eoVar2 != null) {
                    eoVar2.a(arrayList);
                }
            }
        }
    }

    @Override // com.baidu.tieba.gs6
    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (ln lnVar : this.c) {
                if (lnVar instanceof pn6) {
                    ((pn6) lnVar).v();
                } else if (lnVar instanceof in8) {
                    ((in8) lnVar).onDestroy();
                }
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || ListUtils.isEmpty(this.c) || this.a == null) {
            return;
        }
        for (ln lnVar : this.c) {
            if (lnVar instanceof pn6) {
                ((pn6) lnVar).C(this.a.getTbPageTag());
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        fs6 fs6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (frsViewData = this.f) != null && frsViewData.getForum() != null && !StringUtils.isNull(this.f.getForum().getId()) && (fs6Var = this.i) != null) {
            fs6Var.K(this.f.getForum().getId());
        }
    }

    public final void r(ArrayList<yn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                yn ynVar = (yn) ListUtils.getItem(arrayList, i - 1);
                yn ynVar2 = (yn) ListUtils.getItem(arrayList, i);
                if (ynVar2 instanceof jv4) {
                    ThreadData threadData = ((jv4) ynVar2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (ynVar instanceof ao6) {
                        threadData.needTopMargin = false;
                    } else if (ynVar != null && !p(ynVar)) {
                        threadData.needTopMargin = false;
                    } else if ((ynVar instanceof jv4) && p(ynVar) && !TextUtils.isEmpty(((jv4) ynVar).t.getRecomReason())) {
                        threadData.needTopMargin = true;
                    } else if (p(ynVar2) && !TextUtils.isEmpty(recomReason)) {
                        threadData.needTopMargin = true;
                    } else {
                        threadData.needTopMargin = false;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.gs6
    public void setFromCDN(boolean z) {
        List<ln> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (list = this.c) != null && list.size() != 0) {
            for (ln lnVar : this.c) {
                if (lnVar instanceof pn6) {
                    ((pn6) lnVar).setFromCDN(z);
                }
            }
            as6 as6Var = this.k;
            if (as6Var != null) {
                as6Var.setFromCDN(z);
            }
            mr6 mr6Var = this.l;
            if (mr6Var != null) {
                mr6Var.setFromCDN(z);
            }
            xr6 xr6Var = this.m;
            if (xr6Var != null) {
                xr6Var.setFromCDN(z);
            }
            ur6 ur6Var = this.n;
            if (ur6Var != null) {
                ur6Var.setFromCDN(z);
            }
            lr6 lr6Var = this.o;
            if (lr6Var != null) {
                lr6Var.setFromCDN(z);
            }
            or6 or6Var = this.p;
            if (or6Var != null) {
                or6Var.setFromCDN(z);
            }
            bs6 bs6Var = this.u;
            if (bs6Var != null) {
                bs6Var.setFromCDN(z);
            }
            vr6 vr6Var = this.w;
            if (vr6Var != null) {
                vr6Var.setFromCDN(z);
            }
        }
    }

    public void t(String str) {
        List<ln> list;
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
            for (ln lnVar : this.c) {
                if (lnVar != null) {
                    Class<?> cls3 = lnVar.getClass();
                    if (cls3 == cls) {
                        try {
                            cls3.getDeclaredMethod("setTab", String.class).invoke(lnVar, str);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else if (cls3 == cls2) {
                        try {
                            cls3.getDeclaredMethod("setPageTab", String.class).invoke(lnVar, str);
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
