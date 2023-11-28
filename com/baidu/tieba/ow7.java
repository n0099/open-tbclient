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
public class ow7 implements cx7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public vi b;
    public List<ci> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<pi> e;
    public FrsViewData f;
    public boolean g;
    public final as7 h;
    public bx7 i;
    public ci j;
    public ww7 k;
    public iw7 l;
    public tw7 m;
    public qw7 n;
    public hw7 o;
    public kw7 p;
    public uw7 q;
    public yw7 r;
    public sw7 s;
    public pw7 t;
    public xw7 u;
    public jw7 v;
    public rw7 w;

    public ow7(FrsFragment frsFragment, vi viVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, viVar, Boolean.valueOf(z)};
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
        this.b = viVar;
        this.h = new as7();
        o(frsFragment, viVar);
        this.d = new HashMap<>();
        m(z);
    }

    @Override // com.baidu.tieba.cx7
    public void a(String str) {
        List<ci> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (ci ciVar : list) {
            if (ciVar instanceof gm6) {
                ((gm6) ciVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.cx7
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && this.g != z) {
            this.g = z;
        }
    }

    public final boolean p(pi piVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, piVar)) == null) {
            if (piVar == null) {
                return false;
            }
            BdUniqueId type = piVar.getType();
            if (type != ThreadData.TYPE_NORMAL && type != ThreadData.TYPE_GOD_NORMAL && type != ThreadData.TYPE_VIDEO && type != ThreadData.TYPE_VIDEO_GOD && type != ThreadData.TYPE_INSERT_VIDEO) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void s(String str) {
        List<ci> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (ci ciVar : list) {
            if (ciVar instanceof a26) {
                ((a26) ciVar).g(str);
            }
        }
    }

    public final void z(List<ci> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, list) != null) || list == null) {
            return;
        }
        for (ci ciVar : list) {
            if (ciVar instanceof cs7) {
                ((cs7) ciVar).z(this.h);
            }
        }
    }

    @Override // com.baidu.tieba.cx7
    public void b() {
        vi viVar;
        List<pi> data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (viVar = this.b) != null && viVar.getData() != null && this.b.getData().size() != 0 && (data = this.b.getData()) != null && data.size() != 0) {
            for (pi piVar : data) {
                if (piVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) piVar;
                    if (threadData.getIs_top() != 0) {
                        threadData.parser_title();
                    }
                } else if (piVar instanceof jz4) {
                    jz4 jz4Var = (jz4) piVar;
                    if (jz4Var.t.getIs_top() != 0) {
                        jz4Var.t.parser_title();
                    }
                }
            }
        }
    }

    public final void w() {
        q38 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.f == null) {
            return;
        }
        for (ci ciVar : this.c) {
            if ((ciVar instanceof s38) && (i = ((s38) ciVar).i()) != null) {
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
                if (frsFragment != null && frsFragment.J1() != null) {
                    int j0 = this.a.J1().j0();
                    if (j0 == -1) {
                        j0 = this.a.J1().i0();
                    }
                    i.b = j0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.cx7
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090cf7;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.cx7
    public List<pi> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            vi viVar = this.b;
            if (viVar != null) {
                return viVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cx7
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cx7
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090cce;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.cx7
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090da0;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.cx7
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.b.getListAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList<pi> arrayList = this.e;
            if (arrayList != null) {
                this.b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.cx7
    public void d(zi ziVar) {
        List<ci> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, ziVar) == null) && (list = this.c) != null && list.size() != 0) {
            for (ci ciVar : this.c) {
                if (ciVar instanceof cs7) {
                    ((cs7) ciVar).setOnAdapterItemClickListener(ziVar);
                } else if ((ciVar instanceof rw7) || (ciVar instanceof xw7)) {
                    ciVar.setOnAdapterItemClickListener(ziVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.cx7
    public boolean k(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (ci ciVar : this.c) {
                if (ciVar != null && ciVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.cx7
    public void l(xr7 xr7Var) {
        List<ci> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, xr7Var) == null) && (list = this.c) != null && list.size() != 0) {
            for (ci ciVar : this.c) {
                if (ciVar instanceof cs7) {
                    ((cs7) ciVar).A(xr7Var);
                }
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<ci> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && (list = this.c) != null && list.size() != 0) {
            for (ci ciVar : this.c) {
                if (ciVar instanceof cs7) {
                    ((cs7) ciVar).B(frsViewData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.cx7
    public void e() {
        List<ci> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.c) != null && list.size() != 0) {
            for (ci ciVar : this.c) {
                if (ciVar instanceof cs7) {
                    ((cs7) ciVar).n(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            z(this.c);
        }
    }

    @Override // com.baidu.tieba.cx7
    public void g(ArrayList<pi> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            ova.f(arrayList, 1);
            n(arrayList);
            x(arrayList);
            r(arrayList);
            Iterator<pi> it = arrayList.iterator();
            while (it.hasNext()) {
                pi next = it.next();
                if ((next instanceof jz4) && ((jz4) next).t.isTop()) {
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

    public final ArrayList<Integer> n(ArrayList<pi> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                for (int i = 0; i < arrayList.size(); i++) {
                    pi piVar = arrayList.get(i);
                    if (piVar instanceof AdvertAppInfo) {
                        arrayList2.add(Integer.valueOf(i));
                        HashMap<Integer, ThreadData> hashMap = this.d;
                        if (hashMap != null && !hashMap.containsValue(piVar)) {
                            this.d.put(Integer.valueOf(i), (ThreadData) piVar);
                        }
                    }
                }
                return arrayList2;
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void x(ArrayList<pi> arrayList) {
        List<ci> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, arrayList) == null) && (list = this.c) != null && list.size() != 0) {
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<pi> it = arrayList.iterator();
                while (it.hasNext() && it.next().getType().getId() == ThreadData.TYPE_TOP.getId()) {
                    i++;
                }
            }
            for (ci ciVar : this.c) {
                if (ciVar instanceof cs7) {
                    ((cs7) ciVar).G(i);
                }
            }
        }
    }

    public void o(FrsFragment frsFragment, vi viVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, frsFragment, viVar) == null) {
            this.a = frsFragment;
            this.j = wr7.e().c(frsFragment.getPageContext(), qva.d, this.a.getUniqueId(), false);
            ww7 ww7Var = new ww7(frsFragment.I(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = ww7Var;
            ww7Var.D(viVar);
            iw7 iw7Var = new iw7(frsFragment.I(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = iw7Var;
            iw7Var.D(viVar);
            tw7 tw7Var = new tw7(frsFragment.I(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = tw7Var;
            tw7Var.D(viVar);
            qw7 qw7Var = new qw7(frsFragment.I(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = qw7Var;
            qw7Var.D(viVar);
            hw7 hw7Var = new hw7(frsFragment.I(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = hw7Var;
            hw7Var.D(viVar);
            kw7 kw7Var = new kw7(frsFragment.I(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = kw7Var;
            kw7Var.D(viVar);
            yw7 yw7Var = new yw7(frsFragment.I(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = yw7Var;
            yw7Var.D(viVar);
            uw7 uw7Var = new uw7(frsFragment.I(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = uw7Var;
            uw7Var.D(viVar);
            sw7 sw7Var = new sw7(frsFragment.I(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = sw7Var;
            sw7Var.D(viVar);
            pw7 pw7Var = new pw7(frsFragment.I(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = pw7Var;
            pw7Var.D(viVar);
            xw7 xw7Var = new xw7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = xw7Var;
            xw7Var.D(viVar);
            jw7 jw7Var = new jw7(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = jw7Var;
            jw7Var.D(viVar);
            nw7 nw7Var = new nw7(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            nw7Var.D(viVar);
            vw7 vw7Var = new vw7(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            vw7Var.D(viVar);
            uv7 uv7Var = new uv7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            uv7Var.D(viVar);
            uv7Var.q(1);
            wv7 wv7Var = new wv7(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            wv7Var.D(viVar);
            vv7 vv7Var = new vv7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            vv7Var.D(viVar);
            vv7Var.g0(true);
            cw7 cw7Var = new cw7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            cw7Var.D(viVar);
            cw7Var.Q(true);
            dw7 dw7Var = new dw7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            dw7Var.D(viVar);
            dw7Var.Q(true);
            xw7 xw7Var2 = new xw7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            xw7Var2.D(viVar);
            mw7 mw7Var = new mw7(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            mw7Var.D(viVar);
            lw7 lw7Var = new lw7(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            lw7Var.D(viVar);
            this.i = new bx7(frsFragment.getPageContext(), jva.c, this.a.getUniqueId());
            rw7 rw7Var = new rw7(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = rw7Var;
            rw7Var.D(viVar);
            ci<? extends jz4, ? extends TypeAdapter.ViewHolder> a = wr7.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            ci<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = wr7.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            js7 js7Var = new js7(frsFragment.getPageContext(), ks7.b);
            fw7 fw7Var = new fw7(frsFragment.getPageContext(), ns7.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), ps7.e, this.a.getUniqueId());
            aw7 aw7Var = new aw7(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            aw7Var.y((BdTypeRecyclerView) viVar);
            gw7 gw7Var = new gw7(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            sv7 sv7Var = new sv7(frsFragment.I(), h36.g);
            zv7 zv7Var = new zv7(frsFragment.getPageContext(), zm6.A0);
            zv7Var.x(viVar);
            ew7 ew7Var = new ew7(frsFragment.getPageContext(), en6.j);
            ew7Var.x(viVar);
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
            this.c.add(nw7Var);
            this.c.add(vw7Var);
            this.c.add(uv7Var);
            this.c.add(wv7Var);
            this.c.add(vv7Var);
            this.c.add(cw7Var);
            this.c.add(dw7Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(js7Var);
            this.c.add(fw7Var);
            this.c.add(mw7Var);
            this.c.add(lw7Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(xw7Var2);
            this.c.add(aw7Var);
            this.c.add(gw7Var);
            this.c.add(sv7Var);
            this.c.add(new yv7(frsFragment.getPageContext()));
            this.c.add(zv7Var);
            this.c.add(ew7Var);
            this.c.add(m88.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.J, "frs_hot_tab"));
            x06 x06Var = new x06(this.a, 1);
            x06Var.u(this.c);
            x06Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, x06Var));
            z(this.c);
            viVar.addAdapters(this.c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            s("page_frs");
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<ci<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    ci<?, ?> next = it.next();
                    if (next instanceof cs7) {
                        ((cs7) next).n(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<ci> list = this.c;
                if (list != null) {
                    list.addAll(arrayList);
                }
                vi viVar2 = this.b;
                if (viVar2 != null) {
                    viVar2.addAdapters(arrayList);
                }
            }
        }
    }

    @Override // com.baidu.tieba.cx7
    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (ci ciVar : this.c) {
                if (ciVar instanceof cs7) {
                    ((cs7) ciVar).y();
                } else if (ciVar instanceof hha) {
                    ((hha) ciVar).onDestroy();
                }
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || ListUtils.isEmpty(this.c) || this.a == null) {
            return;
        }
        for (ci ciVar : this.c) {
            if (ciVar instanceof cs7) {
                ((cs7) ciVar).F(this.a.getTbPageTag());
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        bx7 bx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (frsViewData = this.f) != null && frsViewData.getForum() != null && !StringUtils.isNull(this.f.getForum().getId()) && (bx7Var = this.i) != null) {
            bx7Var.M(this.f.getForum().getId());
        }
    }

    public final void r(ArrayList<pi> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                pi piVar = (pi) ListUtils.getItem(arrayList, i - 1);
                pi piVar2 = (pi) ListUtils.getItem(arrayList, i);
                if (piVar2 instanceof jz4) {
                    ThreadData threadData = ((jz4) piVar2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (piVar instanceof ns7) {
                        threadData.needTopMargin = false;
                    } else if (piVar != null && !p(piVar)) {
                        threadData.needTopMargin = false;
                    } else if ((piVar instanceof jz4) && p(piVar) && !TextUtils.isEmpty(((jz4) piVar).t.getRecomReason())) {
                        threadData.needTopMargin = true;
                    } else if (p(piVar2) && !TextUtils.isEmpty(recomReason)) {
                        threadData.needTopMargin = true;
                    } else {
                        threadData.needTopMargin = false;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.cx7
    public void setFromCDN(boolean z) {
        List<ci> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (list = this.c) != null && list.size() != 0) {
            for (ci ciVar : this.c) {
                if (ciVar instanceof cs7) {
                    ((cs7) ciVar).setFromCDN(z);
                }
            }
            ww7 ww7Var = this.k;
            if (ww7Var != null) {
                ww7Var.setFromCDN(z);
            }
            iw7 iw7Var = this.l;
            if (iw7Var != null) {
                iw7Var.setFromCDN(z);
            }
            tw7 tw7Var = this.m;
            if (tw7Var != null) {
                tw7Var.setFromCDN(z);
            }
            qw7 qw7Var = this.n;
            if (qw7Var != null) {
                qw7Var.setFromCDN(z);
            }
            hw7 hw7Var = this.o;
            if (hw7Var != null) {
                hw7Var.setFromCDN(z);
            }
            kw7 kw7Var = this.p;
            if (kw7Var != null) {
                kw7Var.setFromCDN(z);
            }
            xw7 xw7Var = this.u;
            if (xw7Var != null) {
                xw7Var.setFromCDN(z);
            }
            rw7 rw7Var = this.w;
            if (rw7Var != null) {
                rw7Var.setFromCDN(z);
            }
        }
    }

    public void t(String str) {
        List<ci> list;
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
            for (ci ciVar : this.c) {
                if (ciVar != null) {
                    Class<?> cls3 = ciVar.getClass();
                    if (cls3 == cls) {
                        try {
                            cls3.getDeclaredMethod("setTab", String.class).invoke(ciVar, str);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else if (cls3 == cls2) {
                        try {
                            cls3.getDeclaredMethod("setPageTab", String.class).invoke(ciVar, str);
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
