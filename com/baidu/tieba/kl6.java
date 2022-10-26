package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
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
public class kl6 implements yl6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public ko b;
    public List c;
    public final HashMap d;
    public ArrayList e;
    public FrsViewData f;
    public boolean g;
    public final ih6 h;
    public xl6 i;
    public rn j;
    public sl6 k;
    public el6 l;
    public pl6 m;
    public ml6 n;
    public dl6 o;
    public gl6 p;
    public ql6 q;
    public ul6 r;
    public ol6 s;
    public ll6 t;
    public tl6 u;
    public fl6 v;
    public nl6 w;

    public kl6(FrsFragment frsFragment, ko koVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, koVar, Boolean.valueOf(z)};
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
        this.b = koVar;
        this.h = new ih6();
        o(frsFragment, koVar);
        this.d = new HashMap();
        m(z);
    }

    @Override // com.baidu.tieba.yl6
    public void a(String str) {
        List<rn> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (rn rnVar : list) {
            if (rnVar instanceof n26) {
                ((n26) rnVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.yl6
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && this.g != z) {
            this.g = z;
        }
    }

    public final boolean p(eo eoVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, eoVar)) == null) {
            if (eoVar == null) {
                return false;
            }
            BdUniqueId type = eoVar.getType();
            if (type != ThreadData.TYPE_NORMAL && type != ThreadData.TYPE_GOD_NORMAL && type != ThreadData.TYPE_VIDEO && type != ThreadData.TYPE_VIDEO_GOD && type != ThreadData.TYPE_INSERT_VIDEO) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void s(String str) {
        List<rn> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (rn rnVar : list) {
            if (rnVar instanceof ap5) {
                ((ap5) rnVar).g(str);
            }
        }
    }

    public final void z(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, list) != null) || list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            rn rnVar = (rn) it.next();
            if (rnVar instanceof kh6) {
                ((kh6) rnVar).w(this.h);
            }
        }
    }

    @Override // com.baidu.tieba.yl6
    public void b() {
        ko koVar;
        List<eo> data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (koVar = this.b) != null && koVar.getData() != null && this.b.getData().size() != 0 && (data = this.b.getData()) != null && data.size() != 0) {
            for (eo eoVar : data) {
                if (eoVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) eoVar;
                    if (threadData.getIs_top() != 0) {
                        threadData.parser_title();
                    }
                } else if (eoVar instanceof du4) {
                    du4 du4Var = (du4) eoVar;
                    if (du4Var.t.getIs_top() != 0) {
                        du4Var.t.parser_title();
                    }
                }
            }
        }
    }

    public final void w() {
        hs6 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.f == null) {
            return;
        }
        for (rn rnVar : this.c) {
            if ((rnVar instanceof js6) && (i = ((js6) rnVar).i()) != null) {
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

    @Override // com.baidu.tieba.yl6
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090b24;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.yl6
    public List f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ko koVar = this.b;
            if (koVar != null) {
                return koVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yl6
    public HashMap h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yl6
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090aff;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.yl6
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090bca;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.yl6
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.b.getListAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList arrayList = this.e;
            if (arrayList != null) {
                this.b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.yl6
    public void d(oo ooVar) {
        List list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, ooVar) == null) && (list = this.c) != null && list.size() != 0) {
            for (rn rnVar : this.c) {
                if (rnVar instanceof kh6) {
                    ((kh6) rnVar).setOnAdapterItemClickListener(ooVar);
                } else if ((rnVar instanceof nl6) || (rnVar instanceof tl6)) {
                    rnVar.setOnAdapterItemClickListener(ooVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.yl6
    public boolean k(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (rn rnVar : this.c) {
                if (rnVar != null && rnVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.yl6
    public void l(fh6 fh6Var) {
        List list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, fh6Var) == null) && (list = this.c) != null && list.size() != 0) {
            for (rn rnVar : this.c) {
                if (rnVar instanceof kh6) {
                    ((kh6) rnVar).x(fh6Var);
                }
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && (list = this.c) != null && list.size() != 0) {
            for (rn rnVar : this.c) {
                if (rnVar instanceof kh6) {
                    ((kh6) rnVar).y(frsViewData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.yl6
    public void e() {
        List list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.c) != null && list.size() != 0) {
            for (rn rnVar : this.c) {
                if (rnVar instanceof kh6) {
                    ((kh6) rnVar).m(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            z(this.c);
        }
    }

    @Override // com.baidu.tieba.yl6
    public void g(ArrayList arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            qm8.f(arrayList, 1);
            n(arrayList);
            x(arrayList);
            r(arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                eo eoVar = (eo) it.next();
                if ((eoVar instanceof du4) && ((du4) eoVar).t.isTop()) {
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

    public final ArrayList n(ArrayList arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < arrayList.size(); i++) {
                    eo eoVar = (eo) arrayList.get(i);
                    if (eoVar instanceof AdvertAppInfo) {
                        arrayList2.add(Integer.valueOf(i));
                        HashMap hashMap = this.d;
                        if (hashMap != null && !hashMap.containsValue(eoVar)) {
                            this.d.put(Integer.valueOf(i), (ThreadData) eoVar);
                        }
                    }
                }
                return arrayList2;
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void x(ArrayList arrayList) {
        List list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, arrayList) == null) && (list = this.c) != null && list.size() != 0) {
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext() && ((eo) it.next()).getType().getId() == ThreadData.TYPE_TOP.getId()) {
                    i++;
                }
            }
            for (rn rnVar : this.c) {
                if (rnVar instanceof kh6) {
                    ((kh6) rnVar).D(i);
                }
            }
        }
    }

    public void o(FrsFragment frsFragment, ko koVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, frsFragment, koVar) == null) {
            this.a = frsFragment;
            this.j = eh6.e().c(frsFragment.getPageContext(), tm8.d, this.a.getUniqueId(), false);
            sl6 sl6Var = new sl6(frsFragment.o(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = sl6Var;
            sl6Var.A(koVar);
            el6 el6Var = new el6(frsFragment.o(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = el6Var;
            el6Var.A(koVar);
            pl6 pl6Var = new pl6(frsFragment.o(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = pl6Var;
            pl6Var.A(koVar);
            ml6 ml6Var = new ml6(frsFragment.o(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = ml6Var;
            ml6Var.A(koVar);
            dl6 dl6Var = new dl6(frsFragment.o(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = dl6Var;
            dl6Var.A(koVar);
            gl6 gl6Var = new gl6(frsFragment.o(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = gl6Var;
            gl6Var.A(koVar);
            ul6 ul6Var = new ul6(frsFragment.o(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = ul6Var;
            ul6Var.A(koVar);
            ql6 ql6Var = new ql6(frsFragment.o(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = ql6Var;
            ql6Var.A(koVar);
            ol6 ol6Var = new ol6(frsFragment.o(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = ol6Var;
            ol6Var.A(koVar);
            ll6 ll6Var = new ll6(frsFragment.o(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = ll6Var;
            ll6Var.A(koVar);
            tl6 tl6Var = new tl6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = tl6Var;
            tl6Var.A(koVar);
            fl6 fl6Var = new fl6(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = fl6Var;
            fl6Var.A(koVar);
            jl6 jl6Var = new jl6(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            jl6Var.A(koVar);
            rl6 rl6Var = new rl6(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            rl6Var.A(koVar);
            tk6 tk6Var = new tk6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            tk6Var.A(koVar);
            tk6Var.p(1);
            vk6 vk6Var = new vk6(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            vk6Var.A(koVar);
            uk6 uk6Var = new uk6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            uk6Var.A(koVar);
            uk6Var.e0(true);
            zk6 zk6Var = new zk6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            zk6Var.A(koVar);
            zk6Var.e0(true);
            al6 al6Var = new al6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            al6Var.A(koVar);
            al6Var.f0(true);
            tl6 tl6Var2 = new tl6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            tl6Var2.A(koVar);
            il6 il6Var = new il6(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            il6Var.A(koVar);
            hl6 hl6Var = new hl6(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            hl6Var.A(koVar);
            this.i = new xl6(frsFragment.getPageContext(), lm8.c, this.a.getUniqueId());
            nl6 nl6Var = new nl6(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = nl6Var;
            nl6Var.A(koVar);
            rn a = eh6.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            rn d = eh6.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            rh6 rh6Var = new rh6(frsFragment.getPageContext(), sh6.b);
            bl6 bl6Var = new bl6(frsFragment.getPageContext(), vh6.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), xh6.e, this.a.getUniqueId());
            xk6 xk6Var = new xk6(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            xk6Var.v((BdTypeRecyclerView) koVar);
            cl6 cl6Var = new cl6(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
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
            this.c.add(jl6Var);
            this.c.add(rl6Var);
            this.c.add(tk6Var);
            this.c.add(vk6Var);
            this.c.add(uk6Var);
            this.c.add(zk6Var);
            this.c.add(al6Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(rh6Var);
            this.c.add(bl6Var);
            this.c.add(il6Var);
            this.c.add(hl6Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(tl6Var2);
            this.c.add(xk6Var);
            this.c.add(cl6Var);
            this.c.add(ev6.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_hot_tab"));
            xn5 xn5Var = new xn5(this.a, 1);
            xn5Var.u(this.c);
            xn5Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, xn5Var));
            z(this.c);
            koVar.a(this.c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            s("page_frs");
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<E> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    rn rnVar = (rn) it.next();
                    if (rnVar instanceof kh6) {
                        ((kh6) rnVar).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List list = this.c;
                if (list != null) {
                    list.addAll(arrayList);
                }
                ko koVar2 = this.b;
                if (koVar2 != null) {
                    koVar2.a(arrayList);
                }
            }
        }
    }

    @Override // com.baidu.tieba.yl6
    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (rn rnVar : this.c) {
                if (rnVar instanceof kh6) {
                    ((kh6) rnVar).v();
                } else if (rnVar instanceof ce8) {
                    ((ce8) rnVar).onDestroy();
                }
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || ListUtils.isEmpty(this.c) || this.a == null) {
            return;
        }
        for (rn rnVar : this.c) {
            if (rnVar instanceof kh6) {
                ((kh6) rnVar).C(this.a.getTbPageTag());
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        xl6 xl6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (frsViewData = this.f) != null && frsViewData.getForum() != null && !StringUtils.isNull(this.f.getForum().getId()) && (xl6Var = this.i) != null) {
            xl6Var.K(this.f.getForum().getId());
        }
    }

    public final void r(ArrayList arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                eo eoVar = (eo) ListUtils.getItem(arrayList, i - 1);
                eo eoVar2 = (eo) ListUtils.getItem(arrayList, i);
                if (eoVar2 instanceof du4) {
                    ThreadData threadData = ((du4) eoVar2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (eoVar instanceof vh6) {
                        threadData.needTopMargin = false;
                    } else if (eoVar != null && !p(eoVar)) {
                        threadData.needTopMargin = false;
                    } else if ((eoVar instanceof du4) && p(eoVar) && !TextUtils.isEmpty(((du4) eoVar).t.getRecomReason())) {
                        threadData.needTopMargin = true;
                    } else if (p(eoVar2) && !TextUtils.isEmpty(recomReason)) {
                        threadData.needTopMargin = true;
                    } else {
                        threadData.needTopMargin = false;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.yl6
    public void setFromCDN(boolean z) {
        List list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (list = this.c) != null && list.size() != 0) {
            for (rn rnVar : this.c) {
                if (rnVar instanceof kh6) {
                    ((kh6) rnVar).setFromCDN(z);
                }
            }
            sl6 sl6Var = this.k;
            if (sl6Var != null) {
                sl6Var.setFromCDN(z);
            }
            el6 el6Var = this.l;
            if (el6Var != null) {
                el6Var.setFromCDN(z);
            }
            pl6 pl6Var = this.m;
            if (pl6Var != null) {
                pl6Var.setFromCDN(z);
            }
            ml6 ml6Var = this.n;
            if (ml6Var != null) {
                ml6Var.setFromCDN(z);
            }
            dl6 dl6Var = this.o;
            if (dl6Var != null) {
                dl6Var.setFromCDN(z);
            }
            gl6 gl6Var = this.p;
            if (gl6Var != null) {
                gl6Var.setFromCDN(z);
            }
            tl6 tl6Var = this.u;
            if (tl6Var != null) {
                tl6Var.setFromCDN(z);
            }
            nl6 nl6Var = this.w;
            if (nl6Var != null) {
                nl6Var.setFromCDN(z);
            }
        }
    }

    public void t(String str) {
        List list;
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
            for (rn rnVar : this.c) {
                if (rnVar != null) {
                    Class<?> cls3 = rnVar.getClass();
                    if (cls3 == cls) {
                        try {
                            cls3.getDeclaredMethod("setTab", String.class).invoke(rnVar, str);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else if (cls3 == cls2) {
                        try {
                            cls3.getDeclaredMethod("setPageTab", String.class).invoke(rnVar, str);
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
