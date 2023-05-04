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
public class sa7 implements gb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public on b;
    public List<vm> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<in> e;
    public FrsViewData f;
    public boolean g;
    public final n67 h;
    public fb7 i;
    public vm j;
    public ab7 k;
    public ma7 l;
    public xa7 m;
    public ua7 n;
    public la7 o;
    public oa7 p;
    public ya7 q;
    public cb7 r;
    public wa7 s;
    public ta7 t;
    public bb7 u;
    public na7 v;
    public va7 w;

    public sa7(FrsFragment frsFragment, on onVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, onVar, Boolean.valueOf(z)};
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
        this.b = onVar;
        this.h = new n67();
        o(frsFragment, onVar);
        this.d = new HashMap<>();
        m(z);
    }

    @Override // com.baidu.tieba.gb7
    public void a(String str) {
        List<vm> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (vm vmVar : list) {
            if (vmVar instanceof hi6) {
                ((hi6) vmVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.gb7
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && this.g != z) {
            this.g = z;
        }
    }

    public final boolean p(in inVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, inVar)) == null) {
            if (inVar == null) {
                return false;
            }
            BdUniqueId type = inVar.getType();
            if (type != ThreadData.TYPE_NORMAL && type != ThreadData.TYPE_GOD_NORMAL && type != ThreadData.TYPE_VIDEO && type != ThreadData.TYPE_VIDEO_GOD && type != ThreadData.TYPE_INSERT_VIDEO) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void s(String str) {
        List<vm> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (vm vmVar : list) {
            if (vmVar instanceof qz5) {
                ((qz5) vmVar).g(str);
            }
        }
    }

    public final void z(List<vm> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, list) != null) || list == null) {
            return;
        }
        for (vm vmVar : list) {
            if (vmVar instanceof p67) {
                ((p67) vmVar).y(this.h);
            }
        }
    }

    @Override // com.baidu.tieba.gb7
    public void b() {
        on onVar;
        List<in> data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (onVar = this.b) != null && onVar.getData() != null && this.b.getData().size() != 0 && (data = this.b.getData()) != null && data.size() != 0) {
            for (in inVar : data) {
                if (inVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) inVar;
                    if (threadData.getIs_top() != 0) {
                        threadData.parser_title();
                    }
                } else if (inVar instanceof f05) {
                    f05 f05Var = (f05) inVar;
                    if (f05Var.t.getIs_top() != 0) {
                        f05Var.t.parser_title();
                    }
                }
            }
        }
    }

    public final void w() {
        th7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.f == null) {
            return;
        }
        for (vm vmVar : this.c) {
            if ((vmVar instanceof vh7) && (i = ((vh7) vmVar).i()) != null) {
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
                if (frsFragment != null && frsFragment.T0() != null) {
                    int q0 = this.a.T0().q0();
                    if (q0 == -1) {
                        q0 = this.a.T0().p0();
                    }
                    i.b = q0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.gb7
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090c29;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.gb7
    public List<in> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            on onVar = this.b;
            if (onVar != null) {
                return onVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gb7
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gb7
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090c04;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.gb7
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090cd0;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.gb7
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.b.getListAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList<in> arrayList = this.e;
            if (arrayList != null) {
                this.b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.gb7
    public void d(sn snVar) {
        List<vm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, snVar) == null) && (list = this.c) != null && list.size() != 0) {
            for (vm vmVar : this.c) {
                if (vmVar instanceof p67) {
                    ((p67) vmVar).setOnAdapterItemClickListener(snVar);
                } else if ((vmVar instanceof va7) || (vmVar instanceof bb7)) {
                    vmVar.setOnAdapterItemClickListener(snVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.gb7
    public boolean k(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (vm vmVar : this.c) {
                if (vmVar != null && vmVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.gb7
    public void l(k67 k67Var) {
        List<vm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, k67Var) == null) && (list = this.c) != null && list.size() != 0) {
            for (vm vmVar : this.c) {
                if (vmVar instanceof p67) {
                    ((p67) vmVar).z(k67Var);
                }
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<vm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && (list = this.c) != null && list.size() != 0) {
            for (vm vmVar : this.c) {
                if (vmVar instanceof p67) {
                    ((p67) vmVar).A(frsViewData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.gb7
    public void e() {
        List<vm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.c) != null && list.size() != 0) {
            for (vm vmVar : this.c) {
                if (vmVar instanceof p67) {
                    ((p67) vmVar).m(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            z(this.c);
        }
    }

    @Override // com.baidu.tieba.gb7
    public void g(ArrayList<in> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            oo9.f(arrayList, 1);
            n(arrayList);
            x(arrayList);
            r(arrayList);
            Iterator<in> it = arrayList.iterator();
            while (it.hasNext()) {
                in next = it.next();
                if ((next instanceof f05) && ((f05) next).t.isTop()) {
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

    public final ArrayList<Integer> n(ArrayList<in> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                for (int i = 0; i < arrayList.size(); i++) {
                    in inVar = arrayList.get(i);
                    if (inVar instanceof AdvertAppInfo) {
                        arrayList2.add(Integer.valueOf(i));
                        HashMap<Integer, ThreadData> hashMap = this.d;
                        if (hashMap != null && !hashMap.containsValue(inVar)) {
                            this.d.put(Integer.valueOf(i), (ThreadData) inVar);
                        }
                    }
                }
                return arrayList2;
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void x(ArrayList<in> arrayList) {
        List<vm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, arrayList) == null) && (list = this.c) != null && list.size() != 0) {
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<in> it = arrayList.iterator();
                while (it.hasNext() && it.next().getType().getId() == ThreadData.TYPE_TOP.getId()) {
                    i++;
                }
            }
            for (vm vmVar : this.c) {
                if (vmVar instanceof p67) {
                    ((p67) vmVar).F(i);
                }
            }
        }
    }

    public void o(FrsFragment frsFragment, on onVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, frsFragment, onVar) == null) {
            this.a = frsFragment;
            this.j = j67.e().c(frsFragment.getPageContext(), ro9.d, this.a.getUniqueId(), false);
            ab7 ab7Var = new ab7(frsFragment.t(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = ab7Var;
            ab7Var.C(onVar);
            ma7 ma7Var = new ma7(frsFragment.t(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = ma7Var;
            ma7Var.C(onVar);
            xa7 xa7Var = new xa7(frsFragment.t(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = xa7Var;
            xa7Var.C(onVar);
            ua7 ua7Var = new ua7(frsFragment.t(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = ua7Var;
            ua7Var.C(onVar);
            la7 la7Var = new la7(frsFragment.t(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = la7Var;
            la7Var.C(onVar);
            oa7 oa7Var = new oa7(frsFragment.t(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = oa7Var;
            oa7Var.C(onVar);
            cb7 cb7Var = new cb7(frsFragment.t(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = cb7Var;
            cb7Var.C(onVar);
            ya7 ya7Var = new ya7(frsFragment.t(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = ya7Var;
            ya7Var.C(onVar);
            wa7 wa7Var = new wa7(frsFragment.t(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = wa7Var;
            wa7Var.C(onVar);
            ta7 ta7Var = new ta7(frsFragment.t(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = ta7Var;
            ta7Var.C(onVar);
            bb7 bb7Var = new bb7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = bb7Var;
            bb7Var.C(onVar);
            na7 na7Var = new na7(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = na7Var;
            na7Var.C(onVar);
            ra7 ra7Var = new ra7(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            ra7Var.C(onVar);
            za7 za7Var = new za7(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            za7Var.C(onVar);
            aa7 aa7Var = new aa7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            aa7Var.C(onVar);
            aa7Var.p(1);
            ca7 ca7Var = new ca7(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            ca7Var.C(onVar);
            ba7 ba7Var = new ba7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            ba7Var.C(onVar);
            ba7Var.g0(true);
            ha7 ha7Var = new ha7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            ha7Var.C(onVar);
            ha7Var.g0(true);
            ia7 ia7Var = new ia7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            ia7Var.C(onVar);
            ia7Var.h0(true);
            bb7 bb7Var2 = new bb7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            bb7Var2.C(onVar);
            qa7 qa7Var = new qa7(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            qa7Var.C(onVar);
            pa7 pa7Var = new pa7(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            pa7Var.C(onVar);
            this.i = new fb7(frsFragment.getPageContext(), jo9.c, this.a.getUniqueId());
            va7 va7Var = new va7(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = va7Var;
            va7Var.C(onVar);
            vm<? extends f05, ? extends TypeAdapter.ViewHolder> a = j67.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            vm<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = j67.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            w67 w67Var = new w67(frsFragment.getPageContext(), x67.b);
            ja7 ja7Var = new ja7(frsFragment.getPageContext(), a77.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), c77.e, this.a.getUniqueId());
            fa7 fa7Var = new fa7(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            fa7Var.x((BdTypeRecyclerView) onVar);
            ka7 ka7Var = new ka7(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            z97 z97Var = new z97(frsFragment.t(), x06.g);
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
            this.c.add(ra7Var);
            this.c.add(za7Var);
            this.c.add(aa7Var);
            this.c.add(ca7Var);
            this.c.add(ba7Var);
            this.c.add(ha7Var);
            this.c.add(ia7Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(w67Var);
            this.c.add(ja7Var);
            this.c.add(qa7Var);
            this.c.add(pa7Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(bb7Var2);
            this.c.add(fa7Var);
            this.c.add(ka7Var);
            this.c.add(z97Var);
            this.c.add(new ea7(frsFragment.getPageContext()));
            this.c.add(am7.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_hot_tab"));
            ny5 ny5Var = new ny5(this.a, 1);
            ny5Var.u(this.c);
            ny5Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, ny5Var));
            z(this.c);
            onVar.addAdapters(this.c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            s("page_frs");
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<vm<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    vm<?, ?> next = it.next();
                    if (next instanceof p67) {
                        ((p67) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<vm> list = this.c;
                if (list != null) {
                    list.addAll(arrayList);
                }
                on onVar2 = this.b;
                if (onVar2 != null) {
                    onVar2.addAdapters(arrayList);
                }
            }
        }
    }

    @Override // com.baidu.tieba.gb7
    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (vm vmVar : this.c) {
                if (vmVar instanceof p67) {
                    ((p67) vmVar).x();
                } else if (vmVar instanceof qd9) {
                    ((qd9) vmVar).onDestroy();
                }
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || ListUtils.isEmpty(this.c) || this.a == null) {
            return;
        }
        for (vm vmVar : this.c) {
            if (vmVar instanceof p67) {
                ((p67) vmVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        fb7 fb7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (frsViewData = this.f) != null && frsViewData.getForum() != null && !StringUtils.isNull(this.f.getForum().getId()) && (fb7Var = this.i) != null) {
            fb7Var.M(this.f.getForum().getId());
        }
    }

    public final void r(ArrayList<in> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                in inVar = (in) ListUtils.getItem(arrayList, i - 1);
                in inVar2 = (in) ListUtils.getItem(arrayList, i);
                if (inVar2 instanceof f05) {
                    ThreadData threadData = ((f05) inVar2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (inVar instanceof a77) {
                        threadData.needTopMargin = false;
                    } else if (inVar != null && !p(inVar)) {
                        threadData.needTopMargin = false;
                    } else if ((inVar instanceof f05) && p(inVar) && !TextUtils.isEmpty(((f05) inVar).t.getRecomReason())) {
                        threadData.needTopMargin = true;
                    } else if (p(inVar2) && !TextUtils.isEmpty(recomReason)) {
                        threadData.needTopMargin = true;
                    } else {
                        threadData.needTopMargin = false;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.gb7
    public void setFromCDN(boolean z) {
        List<vm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (list = this.c) != null && list.size() != 0) {
            for (vm vmVar : this.c) {
                if (vmVar instanceof p67) {
                    ((p67) vmVar).setFromCDN(z);
                }
            }
            ab7 ab7Var = this.k;
            if (ab7Var != null) {
                ab7Var.setFromCDN(z);
            }
            ma7 ma7Var = this.l;
            if (ma7Var != null) {
                ma7Var.setFromCDN(z);
            }
            xa7 xa7Var = this.m;
            if (xa7Var != null) {
                xa7Var.setFromCDN(z);
            }
            ua7 ua7Var = this.n;
            if (ua7Var != null) {
                ua7Var.setFromCDN(z);
            }
            la7 la7Var = this.o;
            if (la7Var != null) {
                la7Var.setFromCDN(z);
            }
            oa7 oa7Var = this.p;
            if (oa7Var != null) {
                oa7Var.setFromCDN(z);
            }
            bb7 bb7Var = this.u;
            if (bb7Var != null) {
                bb7Var.setFromCDN(z);
            }
            va7 va7Var = this.w;
            if (va7Var != null) {
                va7Var.setFromCDN(z);
            }
        }
    }

    public void t(String str) {
        List<vm> list;
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
            for (vm vmVar : this.c) {
                if (vmVar != null) {
                    Class<?> cls3 = vmVar.getClass();
                    if (cls3 == cls) {
                        try {
                            cls3.getDeclaredMethod("setTab", String.class).invoke(vmVar, str);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else if (cls3 == cls2) {
                        try {
                            cls3.getDeclaredMethod("setPageTab", String.class).invoke(vmVar, str);
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
