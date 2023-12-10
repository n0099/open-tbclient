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
public class tw7 implements hx7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public vi b;
    public List<ci> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<pi> e;
    public FrsViewData f;
    public boolean g;
    public final fs7 h;
    public gx7 i;
    public ci j;
    public bx7 k;
    public nw7 l;
    public yw7 m;
    public vw7 n;
    public mw7 o;
    public pw7 p;
    public zw7 q;
    public dx7 r;
    public xw7 s;
    public uw7 t;
    public cx7 u;
    public ow7 v;
    public ww7 w;

    public tw7(FrsFragment frsFragment, vi viVar, boolean z) {
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
        this.h = new fs7();
        o(frsFragment, viVar);
        this.d = new HashMap<>();
        m(z);
    }

    @Override // com.baidu.tieba.hx7
    public void a(String str) {
        List<ci> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (ci ciVar : list) {
            if (ciVar instanceof km6) {
                ((km6) ciVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.hx7
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
            if (ciVar instanceof e26) {
                ((e26) ciVar).g(str);
            }
        }
    }

    public final void z(List<ci> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, list) != null) || list == null) {
            return;
        }
        for (ci ciVar : list) {
            if (ciVar instanceof hs7) {
                ((hs7) ciVar).z(this.h);
            }
        }
    }

    @Override // com.baidu.tieba.hx7
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
                } else if (piVar instanceof mz4) {
                    mz4 mz4Var = (mz4) piVar;
                    if (mz4Var.t.getIs_top() != 0) {
                        mz4Var.t.parser_title();
                    }
                }
            }
        }
    }

    public final void w() {
        v38 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.f == null) {
            return;
        }
        for (ci ciVar : this.c) {
            if ((ciVar instanceof x38) && (i = ((x38) ciVar).i()) != null) {
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

    @Override // com.baidu.tieba.hx7
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090cf8;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.hx7
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

    @Override // com.baidu.tieba.hx7
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hx7
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090ccf;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.hx7
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090da1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.hx7
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

    @Override // com.baidu.tieba.hx7
    public void d(zi ziVar) {
        List<ci> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, ziVar) == null) && (list = this.c) != null && list.size() != 0) {
            for (ci ciVar : this.c) {
                if (ciVar instanceof hs7) {
                    ((hs7) ciVar).setOnAdapterItemClickListener(ziVar);
                } else if ((ciVar instanceof ww7) || (ciVar instanceof cx7)) {
                    ciVar.setOnAdapterItemClickListener(ziVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.hx7
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

    @Override // com.baidu.tieba.hx7
    public void l(cs7 cs7Var) {
        List<ci> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, cs7Var) == null) && (list = this.c) != null && list.size() != 0) {
            for (ci ciVar : this.c) {
                if (ciVar instanceof hs7) {
                    ((hs7) ciVar).A(cs7Var);
                }
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<ci> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && (list = this.c) != null && list.size() != 0) {
            for (ci ciVar : this.c) {
                if (ciVar instanceof hs7) {
                    ((hs7) ciVar).B(frsViewData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.hx7
    public void e() {
        List<ci> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.c) != null && list.size() != 0) {
            for (ci ciVar : this.c) {
                if (ciVar instanceof hs7) {
                    ((hs7) ciVar).n(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            z(this.c);
        }
    }

    @Override // com.baidu.tieba.hx7
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
                if ((next instanceof mz4) && ((mz4) next).t.isTop()) {
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
                if (ciVar instanceof hs7) {
                    ((hs7) ciVar).G(i);
                }
            }
        }
    }

    public void o(FrsFragment frsFragment, vi viVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, frsFragment, viVar) == null) {
            this.a = frsFragment;
            this.j = bs7.e().c(frsFragment.getPageContext(), qva.d, this.a.getUniqueId(), false);
            bx7 bx7Var = new bx7(frsFragment.I(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = bx7Var;
            bx7Var.D(viVar);
            nw7 nw7Var = new nw7(frsFragment.I(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = nw7Var;
            nw7Var.D(viVar);
            yw7 yw7Var = new yw7(frsFragment.I(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = yw7Var;
            yw7Var.D(viVar);
            vw7 vw7Var = new vw7(frsFragment.I(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = vw7Var;
            vw7Var.D(viVar);
            mw7 mw7Var = new mw7(frsFragment.I(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = mw7Var;
            mw7Var.D(viVar);
            pw7 pw7Var = new pw7(frsFragment.I(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = pw7Var;
            pw7Var.D(viVar);
            dx7 dx7Var = new dx7(frsFragment.I(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = dx7Var;
            dx7Var.D(viVar);
            zw7 zw7Var = new zw7(frsFragment.I(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = zw7Var;
            zw7Var.D(viVar);
            xw7 xw7Var = new xw7(frsFragment.I(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = xw7Var;
            xw7Var.D(viVar);
            uw7 uw7Var = new uw7(frsFragment.I(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = uw7Var;
            uw7Var.D(viVar);
            cx7 cx7Var = new cx7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = cx7Var;
            cx7Var.D(viVar);
            ow7 ow7Var = new ow7(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = ow7Var;
            ow7Var.D(viVar);
            sw7 sw7Var = new sw7(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            sw7Var.D(viVar);
            ax7 ax7Var = new ax7(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            ax7Var.D(viVar);
            zv7 zv7Var = new zv7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            zv7Var.D(viVar);
            zv7Var.q(1);
            bw7 bw7Var = new bw7(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            bw7Var.D(viVar);
            aw7 aw7Var = new aw7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            aw7Var.D(viVar);
            aw7Var.g0(true);
            hw7 hw7Var = new hw7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            hw7Var.D(viVar);
            hw7Var.Q(true);
            iw7 iw7Var = new iw7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            iw7Var.D(viVar);
            iw7Var.Q(true);
            cx7 cx7Var2 = new cx7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            cx7Var2.D(viVar);
            rw7 rw7Var = new rw7(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            rw7Var.D(viVar);
            qw7 qw7Var = new qw7(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            qw7Var.D(viVar);
            this.i = new gx7(frsFragment.getPageContext(), jva.c, this.a.getUniqueId());
            ww7 ww7Var = new ww7(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = ww7Var;
            ww7Var.D(viVar);
            ci<? extends mz4, ? extends TypeAdapter.ViewHolder> a = bs7.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            ci<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = bs7.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            os7 os7Var = new os7(frsFragment.getPageContext(), ps7.b);
            kw7 kw7Var = new kw7(frsFragment.getPageContext(), ss7.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), us7.e, this.a.getUniqueId());
            fw7 fw7Var = new fw7(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            fw7Var.y((BdTypeRecyclerView) viVar);
            lw7 lw7Var = new lw7(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            xv7 xv7Var = new xv7(frsFragment.I(), l36.g);
            ew7 ew7Var = new ew7(frsFragment.getPageContext(), dn6.A0);
            ew7Var.x(viVar);
            jw7 jw7Var = new jw7(frsFragment.getPageContext(), in6.j);
            jw7Var.x(viVar);
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
            this.c.add(sw7Var);
            this.c.add(ax7Var);
            this.c.add(zv7Var);
            this.c.add(bw7Var);
            this.c.add(aw7Var);
            this.c.add(hw7Var);
            this.c.add(iw7Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(os7Var);
            this.c.add(kw7Var);
            this.c.add(rw7Var);
            this.c.add(qw7Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(cx7Var2);
            this.c.add(fw7Var);
            this.c.add(lw7Var);
            this.c.add(xv7Var);
            this.c.add(new dw7(frsFragment.getPageContext()));
            this.c.add(ew7Var);
            this.c.add(jw7Var);
            this.c.add(r88.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.J, "frs_hot_tab"));
            b16 b16Var = new b16(this.a, 1);
            b16Var.u(this.c);
            b16Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, b16Var));
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
                    if (next instanceof hs7) {
                        ((hs7) next).n(this.a.getPageContext(), this.a.getUniqueId());
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

    @Override // com.baidu.tieba.hx7
    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (ci ciVar : this.c) {
                if (ciVar instanceof hs7) {
                    ((hs7) ciVar).y();
                } else if (ciVar instanceof mha) {
                    ((mha) ciVar).onDestroy();
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
            if (ciVar instanceof hs7) {
                ((hs7) ciVar).F(this.a.getTbPageTag());
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        gx7 gx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (frsViewData = this.f) != null && frsViewData.getForum() != null && !StringUtils.isNull(this.f.getForum().getId()) && (gx7Var = this.i) != null) {
            gx7Var.M(this.f.getForum().getId());
        }
    }

    public final void r(ArrayList<pi> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                pi piVar = (pi) ListUtils.getItem(arrayList, i - 1);
                pi piVar2 = (pi) ListUtils.getItem(arrayList, i);
                if (piVar2 instanceof mz4) {
                    ThreadData threadData = ((mz4) piVar2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (piVar instanceof ss7) {
                        threadData.needTopMargin = false;
                    } else if (piVar != null && !p(piVar)) {
                        threadData.needTopMargin = false;
                    } else if ((piVar instanceof mz4) && p(piVar) && !TextUtils.isEmpty(((mz4) piVar).t.getRecomReason())) {
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

    @Override // com.baidu.tieba.hx7
    public void setFromCDN(boolean z) {
        List<ci> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (list = this.c) != null && list.size() != 0) {
            for (ci ciVar : this.c) {
                if (ciVar instanceof hs7) {
                    ((hs7) ciVar).setFromCDN(z);
                }
            }
            bx7 bx7Var = this.k;
            if (bx7Var != null) {
                bx7Var.setFromCDN(z);
            }
            nw7 nw7Var = this.l;
            if (nw7Var != null) {
                nw7Var.setFromCDN(z);
            }
            yw7 yw7Var = this.m;
            if (yw7Var != null) {
                yw7Var.setFromCDN(z);
            }
            vw7 vw7Var = this.n;
            if (vw7Var != null) {
                vw7Var.setFromCDN(z);
            }
            mw7 mw7Var = this.o;
            if (mw7Var != null) {
                mw7Var.setFromCDN(z);
            }
            pw7 pw7Var = this.p;
            if (pw7Var != null) {
                pw7Var.setFromCDN(z);
            }
            cx7 cx7Var = this.u;
            if (cx7Var != null) {
                cx7Var.setFromCDN(z);
            }
            ww7 ww7Var = this.w;
            if (ww7Var != null) {
                ww7Var.setFromCDN(z);
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
