package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbCommentFloatActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class rg8 extends wg8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public DetailInfoAndReplyFragment b;
    public BdTypeRecyclerView c;
    public u98 d;
    public ed8 e;
    public vc8 f;
    public wc8 g;
    public yd8 h;
    public PbReplyLoadMoreAdapter i;
    public tg8 j;
    public sg8 k;
    public xc8 l;
    public final List<qn> m;
    public boolean n;
    public ArrayList<Cdo> o;
    public String p;
    public boolean q;
    public boolean r;
    public int s;

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public jd8 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (jd8) invokeV.objValue;
    }

    public gc8 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (gc8) invokeV.objValue;
    }

    public PbFirstFloorCommentAndPraiseAdapter e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return null;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
        }
    }

    public rg8(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {detailInfoAndReplyFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = BdUniqueId.gen();
        this.m = new ArrayList();
        this.n = true;
        this.p = null;
        this.q = true;
        this.r = false;
        this.b = detailInfoAndReplyFragment;
        if (detailInfoAndReplyFragment != null && detailInfoAndReplyFragment.J() != null && detailInfoAndReplyFragment.J().getArguments() != null) {
            this.s = detailInfoAndReplyFragment.J().getArguments().getInt(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE);
        }
        this.c = bdTypeRecyclerView;
        g();
    }

    public void B(ua8 ua8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ua8Var) == null) {
            this.h.m0(ua8Var);
        }
    }

    public final void C(u98 u98Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, u98Var) == null) {
            this.j.M(u98Var);
        }
    }

    public final void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.j.o(str);
        }
    }

    public void p(u98 u98Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, u98Var) == null) {
            q(u98Var, false);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.r = z;
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.n = z;
        }
    }

    public void t(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onClickListener) == null) {
            this.h.k(onClickListener);
        }
    }

    public void v(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, a0Var) == null) {
            this.h.n(a0Var);
        }
    }

    public void w(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onLongClickListener) == null) {
            this.h.d(onLongClickListener);
        }
    }

    public void x(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, onClickListener) == null) {
            this.h.e(onClickListener);
            this.i.w(onClickListener);
            this.l.e(onClickListener);
        }
    }

    public final void y(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onClickListener) == null) {
            this.f.w(onClickListener);
        }
    }

    public final void z(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, onClickListener) == null) {
            this.g.w(onClickListener);
        }
    }

    public final void E() {
        u98 u98Var;
        f19 f19Var;
        f19 f19Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (u98Var = this.d) == null || u98Var.b0 || u98Var.c0 == 2) {
            return;
        }
        ArrayList<PostData> G = u98Var.G();
        ArrayList<f19> d = this.d.d();
        if (d != null && !d.isEmpty() && G != null && !G.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<f19> it = d.iterator();
            while (it.hasNext()) {
                f19 next = it.next();
                if (next != null && next.p1() != null) {
                    sb.append(next.p1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<f19> it2 = d.iterator();
            while (it2.hasNext()) {
                f19 next2 = it2.next();
                if (next2 != null) {
                    next2.h1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<f19> it3 = d.iterator();
            while (it3.hasNext()) {
                f19 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int m = next3.getAdvertAppInfo().m();
                    if (m != 0) {
                        zs8.j(next3, m);
                        if (m != 28 && m != 31) {
                            next3.getAdvertAppInfo().c = -1001;
                        }
                    }
                    sparseArray.put(next3.getPosition(), next3);
                }
            }
            HashMap hashMap = new HashMap();
            for (int i = 0; i < sparseArray.size(); i++) {
                f19 f19Var3 = (f19) sparseArray.get(sparseArray.keyAt(i));
                if (f19Var3 != null && (f19Var2 = (f19) hashMap.put(f19Var3.o1(), f19Var3)) != null) {
                    zs8.j(f19Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (f19Var = (f19) entry.getValue()) != null) {
                    sparseArray.put(f19Var.getPosition(), f19Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                f19 f19Var4 = (f19) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                if (this.d.k() != null) {
                    f19Var4.b1 = this.d.k().getId();
                }
                if (this.d.N() != null) {
                    f19Var4.e1 = dh.g(this.d.N().getId(), 0L);
                }
                u98 u98Var2 = this.d;
                if (u98Var2 != null && u98Var2.y() != null) {
                    f19Var4.f1 = this.d.y().a();
                }
                b(f19Var4);
                int position = f19Var4.getPosition() + this.d.a0;
                if (position >= G.size()) {
                    f19Var4.h1 = position;
                    zs8.k(f19Var4, 2, position + i3, G.size());
                    return;
                }
                if (!this.n) {
                    position--;
                    f19Var4.h1 = position;
                }
                if (position < 0) {
                    zs8.j(f19Var4, 23);
                } else if (f(G, position)) {
                    zs8.j(f19Var4, 1);
                } else {
                    G.add(position, f19Var4);
                    TiebaStatic.eventStat(this.b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", f19Var4.getAdvertAppInfo().p);
                }
            }
        }
    }

    @Override // com.baidu.tieba.wg8
    public ArrayList<Cdo> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.o;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (12 == this.s) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.b.M() != null) {
                return this.b.M().N0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void j() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (bdTypeRecyclerView = this.c) != null && bdTypeRecyclerView.getAdapter() != null) {
            this.c.getListAdapter().notifyDataSetChanged();
        }
    }

    public void k() {
        tg8 tg8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (tg8Var = this.j) != null) {
            tg8Var.notifyDataSetChanged();
        }
    }

    public final void b(f19 f19Var) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, f19Var) == null) && f19Var != null && this.d != null && f19Var.getAdvertAppInfo() != null) {
            f19Var.getAdvertAppInfo().i = new xw4();
            if (this.d.y() != null) {
                f19Var.getAdvertAppInfo().i.b = this.d.y().a();
            }
            f19Var.getAdvertAppInfo().i.a = f19Var.q1();
            if (this.d.k() != null && (k = this.d.k()) != null) {
                f19Var.getAdvertAppInfo().i.c = k.getId();
                f19Var.getAdvertAppInfo().i.d = k.getFirst_class();
                f19Var.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                f19Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            f19Var.getAdvertAppInfo().i.g = f19Var.getAdvertAppInfo().g;
            f19Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean f(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof f19) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.j = new tg8(this.b.J(), PostData.P0);
            this.f = new vc8(this.b.J(), aa8.c, this.b.getUniqueId());
            this.g = new wc8(this.b.J(), ba8.a);
            this.e = new ed8(this.b.J(), ea8.e1);
            yd8 yd8Var = new yd8(this.b.J(), PostData.Q0);
            this.h = yd8Var;
            yd8Var.n0(this.b.J());
            this.h.j0(this.b.J().k3());
            this.i = new PbReplyLoadMoreAdapter(this.b.J(), PostData.X0);
            this.k = new sg8(this.b.getContext(), na8.b, this.b.J());
            this.l = new xc8(this.b.J(), ca8.c);
            this.m.add(this.j);
            this.m.add(this.k);
            this.m.add(this.e);
            this.m.add(this.f);
            this.m.add(this.g);
            this.m.add(this.h);
            this.m.add(this.i);
            this.m.add(this.l);
            this.c.a(this.m);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            for (int i = 0; i < this.o.size(); i++) {
                Cdo cdo = this.o.get(i);
                if (!(cdo instanceof ha8) && (cdo instanceof t98)) {
                    ((t98) cdo).a();
                    BdUniqueId bdUniqueId = this.a;
                }
            }
        }
    }

    public final void o(u98 u98Var, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{u98Var, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.h.r(u98Var);
            this.h.setFromCDN(z);
            this.h.o(str);
            this.h.c(z2);
            this.h.l0(0.5f);
        }
    }

    public void q(u98 u98Var, boolean z) {
        f19 f19Var;
        PostData postData;
        boolean z2;
        u98 u98Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048597, this, u98Var, z) != null) || u98Var == null) {
            return;
        }
        this.d = u98Var;
        if (u98Var != null && u98Var.N() != null && u98Var.N().getAuthor() != null) {
            this.p = u98Var.N().getAuthor().getUserId();
        }
        if (this.o == null) {
            this.o = new ArrayList<>();
        }
        this.o.clear();
        Iterator<PostData> it = u98Var.G().iterator();
        while (true) {
            f19Var = null;
            if (it.hasNext()) {
                PostData next = it.next();
                if (next instanceof PostData) {
                    postData = next;
                    if (postData.F() == 1) {
                        break;
                    }
                }
            } else {
                postData = null;
                break;
            }
        }
        if (postData == null && u98Var.i() != null) {
            postData = u98Var.i();
        }
        if (postData != null) {
            this.o.add(postData);
        }
        C(u98Var);
        D(this.p);
        int i = 0;
        if (!ListUtils.isEmpty(u98Var.G()) && u98Var.G().get(0) != null && u98Var.N() != null) {
            u98Var.N().setItem(u98Var.G().get(0).S());
            u98Var.N().setItemStar(u98Var.G().get(0).T());
        }
        if (u98Var.N() != null && u98Var.N().getRawThreadInfo() != null) {
            wz4 wz4Var = new wz4();
            wz4Var.t = u98Var.N();
            wz4Var.n = true;
            this.o.add(wz4Var);
        }
        ia8 ia8Var = new ia8(u98Var.N(), u98Var.c());
        ia8Var.i(false);
        ia8Var.b = false;
        this.o.add(ia8Var);
        if (postData != null && postData.r0 != null && (u98Var.k() == null || !TextUtils.equals(u98Var.k().getName(), this.b.M().J0()) || !this.b.M().P0())) {
            x98 x98Var = new x98(postData.r0);
            x98Var.b = this.b.M().D1();
            this.o.add(x98Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && u98Var.k() != null && !StringUtils.isNull(u98Var.k().getName()) && (!TextUtils.equals(u98Var.k().getName(), this.b.M().J0()) || !this.b.M().P0())) {
            w98 w98Var = new w98(u98Var.k());
            w98Var.g = this.b.M().D1();
            w98Var.e = false;
            this.o.add(w98Var);
            ia8Var.i(false);
            ia8Var.b = false;
        }
        if (u98Var.N() != null && !StringUtils.isNull(u98Var.N().getForum_name())) {
            na8 na8Var = new na8();
            na8Var.a = u98Var.N();
            this.o.add(na8Var);
        } else if (u98Var.N() != null && !StringUtils.isNull(u98Var.m())) {
            u98Var.N().setForum_name(u98Var.m());
            na8 na8Var2 = new na8();
            na8Var2.a = u98Var.N();
            this.o.add(na8Var2);
        }
        if (h() && u98Var.y() != null && u98Var.y().c() == 1) {
            ca8 ca8Var = new ca8(ca8.c);
            ca8Var.b(true);
            this.o.add(ca8Var);
        }
        ha8 ha8Var = new ha8(ha8.g);
        ha8Var.c = i();
        ha8Var.b = u98Var.g;
        ha8Var.d = u98Var.i0();
        ha8Var.e = u98Var.f;
        A();
        this.o.add(ha8Var);
        if (u98Var.K() == 4) {
            this.o.add(new ga8());
        }
        E();
        n();
        Iterator<PostData> it2 = u98Var.G().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.F() != 1) {
                this.o.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((u98Var2 = this.d) == null || !u98Var2.s()))) {
            ea8 ea8Var = new ea8();
            ea8Var.a1 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            ea8Var.Z0 = R.drawable.new_pic_emotion_03;
            ea8Var.b1 = -2;
            ea8Var.c1 = ej.g(this.b.getContext(), R.dimen.tbds74);
            this.o.add(ea8Var);
        }
        o(u98Var, this.r, this.p, this.q);
        if (u98Var.y().b() == 0) {
            u98 u98Var3 = this.d;
            if (u98Var3 != null && u98Var3.s()) {
                z(this.b.J().m3());
                this.o.add(new ba8());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.d.l());
                statisticItem.param("fname", this.d.m());
                statisticItem.param("tid", this.d.P());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                y(this.b.J().m3());
                aa8 aa8Var = new aa8();
                aa8Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.o.add(aa8Var);
            }
            List<f19> Z = u98Var.Z();
            int i2 = -1;
            if (Z != null && !Z.isEmpty()) {
                f19Var = Z.get(0);
                i2 = f19Var.getPosition();
            }
            if (!ListUtils.isEmpty(u98Var.e())) {
                t98 t98Var = new t98();
                t98Var.b(this.a);
                this.o.add(t98Var);
                int i3 = 1;
                for (jx4 jx4Var : u98Var.e()) {
                    if (Z != null && i3 == i2) {
                        if (f19Var != null) {
                            b(f19Var);
                            this.o.add(f19Var);
                            i++;
                            if (f19Var.getType() != AdvertAppInfo.x) {
                                i3++;
                            }
                        }
                        if (i < Z.size()) {
                            f19 f19Var2 = Z.get(i);
                            f19Var = f19Var2;
                            i2 = f19Var2.getPosition();
                        }
                    }
                    this.o.add(jx4Var);
                    i3++;
                    if (i3 == 4 && u98Var.C() != null) {
                        this.o.add(u98Var.C());
                        i3++;
                    }
                }
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setData(this.o);
        }
        m();
    }
}
