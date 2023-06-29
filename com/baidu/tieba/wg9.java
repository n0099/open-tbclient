package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
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
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.view.SortSwitchButton;
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
/* loaded from: classes8.dex */
public abstract class wg9 extends ch9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DetailInfoAndReplyFragment a;
    public BdTypeRecyclerView b;
    public u89 c;
    public final List<kn> d;
    public boolean e;
    public ArrayList<xn> f;
    public String g;
    public boolean h;
    public boolean i;
    public int j;
    public int k;
    public int l;

    public abstract void A(View.OnClickListener onClickListener);

    public abstract void B(View.OnClickListener onClickListener);

    public abstract void C(u89 u89Var);

    public void D(ba9 ba9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ba9Var) == null) {
        }
    }

    public abstract void E(u89 u89Var);

    public abstract void F(String str);

    public abstract uc9 e();

    public abstract pb9 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public abstract void l();

    public abstract void m();

    public abstract void n();

    public abstract void p(boolean z);

    public abstract void q(u89 u89Var, boolean z, String str, boolean z2);

    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onClickListener) == null) {
        }
    }

    public abstract void v(boolean z);

    public void w(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, zVar) == null) {
        }
    }

    public void x(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, onLongClickListener) == null) {
        }
    }

    public void y(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, fVar) == null) {
        }
    }

    public void z(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onClickListener) == null) {
        }
    }

    public wg9(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.d = new ArrayList();
        this.e = true;
        this.g = null;
        this.h = true;
        this.i = false;
        this.k = -1;
        this.l = -1;
        this.a = detailInfoAndReplyFragment;
        if (detailInfoAndReplyFragment != null && detailInfoAndReplyFragment.N() != null && detailInfoAndReplyFragment.N().getArguments() != null) {
            this.j = detailInfoAndReplyFragment.N().getArguments().getInt(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE);
        }
        this.b = bdTypeRecyclerView;
    }

    public final void G() {
        u89 u89Var;
        m4a m4aVar;
        m4a m4aVar2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (u89Var = this.c) == null || u89Var.Z || u89Var.a0 == 2) {
            return;
        }
        ArrayList<n4a> F = u89Var.F();
        ArrayList<m4a> d = this.c.d();
        if (d != null && !d.isEmpty() && F != null && !F.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<m4a> it = d.iterator();
            while (it.hasNext()) {
                m4a next = it.next();
                if (next != null && next.A1() != null) {
                    sb.append(next.A1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<m4a> it2 = d.iterator();
            while (it2.hasNext()) {
                m4a next2 = it2.next();
                if (next2 != null) {
                    next2.o1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<m4a> it3 = d.iterator();
            while (it3.hasNext()) {
                m4a next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int i = next3.getAdvertAppInfo().i();
                    if (i != 0) {
                        bu9.j(next3, i);
                        if (i != 28 && i != 31) {
                            next3.getAdvertAppInfo().c = -1001;
                            Log.e("cq", "updateAppData，Data InValidate: " + i);
                        }
                    }
                    sparseArray.put(next3.getPosition(), next3);
                }
            }
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                m4a m4aVar3 = (m4a) sparseArray.get(sparseArray.keyAt(i2));
                if (m4aVar3 != null && (m4aVar2 = (m4a) hashMap.put(m4aVar3.z1(), m4aVar3)) != null) {
                    bu9.j(m4aVar2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (m4aVar = (m4a) entry.getValue()) != null) {
                    sparseArray.put(m4aVar.getPosition(), m4aVar);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i3)));
            }
            Collections.sort(arrayList);
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                m4a m4aVar4 = (m4a) sparseArray.get(((Integer) arrayList.get(i4)).intValue());
                if (this.c.k() != null) {
                    m4aVar4.i1 = this.c.k().getId();
                }
                if (this.c.N() != null) {
                    m4aVar4.l1 = vg.g(this.c.N().getId(), 0L);
                }
                u89 u89Var2 = this.c;
                if (u89Var2 != null && u89Var2.y() != null) {
                    m4aVar4.m1 = this.c.y().a();
                }
                b(m4aVar4);
                int position = m4aVar4.getPosition() + this.c.Y;
                if (position >= F.size()) {
                    m4aVar4.o1 = position;
                    bu9.k(m4aVar4, 2, position + i4, F.size());
                    return;
                }
                if (!this.e) {
                    position--;
                    m4aVar4.o1 = position;
                }
                if (position < 0) {
                    bu9.j(m4aVar4, 23);
                } else if (h(F, position)) {
                    bu9.j(m4aVar4, 1);
                } else {
                    F.add(position, m4aVar4);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", m4aVar4.getAdvertAppInfo().p);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ch9
    public ArrayList<xn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.f;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (12 == this.j) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.a.Q() != null) {
                return this.a.Q().b1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void b(m4a m4aVar) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, m4aVar) == null) && m4aVar != null && this.c != null && m4aVar.getAdvertAppInfo() != null) {
            m4aVar.getAdvertAppInfo().i = new q15();
            if (this.c.y() != null) {
                m4aVar.getAdvertAppInfo().i.b = this.c.y().a();
            }
            m4aVar.getAdvertAppInfo().i.a = m4aVar.B1();
            if (this.c.k() != null && (k = this.c.k()) != null) {
                m4aVar.getAdvertAppInfo().i.c = k.getId();
                m4aVar.getAdvertAppInfo().i.d = k.getFirst_class();
                m4aVar.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                m4aVar.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            m4aVar.getAdvertAppInfo().i.g = m4aVar.getAdvertAppInfo().g;
            m4aVar.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean h(ArrayList<n4a> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof m4a) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            boolean z = false;
            for (int i = 0; i < this.f.size(); i++) {
                if (this.f.get(i) instanceof j99) {
                    this.k = i;
                    z = true;
                }
            }
            if (!z) {
                this.k = -1;
            }
            this.l = -1;
        }
    }

    public void r(u89 u89Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, u89Var) == null) {
            s(u89Var, false);
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.e = z;
        }
    }

    public void s(u89 u89Var, boolean z) {
        m4a m4aVar;
        n4a n4aVar;
        boolean z2;
        u89 u89Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048601, this, u89Var, z) != null) || u89Var == null) {
            return;
        }
        this.c = u89Var;
        if (u89Var != null && u89Var.N() != null && u89Var.N().getAuthor() != null) {
            this.g = u89Var.N().getAuthor().getUserId();
        }
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        this.f.clear();
        Iterator<n4a> it = u89Var.F().iterator();
        while (true) {
            m4aVar = null;
            if (it.hasNext()) {
                n4a next = it.next();
                if (next instanceof n4a) {
                    n4aVar = next;
                    if (n4aVar.I() == 1) {
                        break;
                    }
                }
            } else {
                n4aVar = null;
                break;
            }
        }
        if (n4aVar == null && u89Var.i() != null) {
            n4aVar = u89Var.i();
        }
        if (n4aVar != null) {
            this.f.add(n4aVar);
        }
        E(u89Var);
        F(this.g);
        int i = 0;
        if (!ListUtils.isEmpty(u89Var.F()) && u89Var.F().get(0) != null && u89Var.N() != null) {
            u89Var.N().setItem(u89Var.F().get(0).W());
            u89Var.N().setItemStar(u89Var.F().get(0).X());
        }
        if (u89Var.N() != null && u89Var.N().getRawThreadInfo() != null) {
            r45 r45Var = new r45();
            r45Var.t = u89Var.N();
            r45Var.n = true;
            this.f.add(r45Var);
        }
        k99 k99Var = new k99(u89Var.N(), u89Var.c());
        k99Var.h(false);
        k99Var.b = false;
        this.f.add(k99Var);
        if (n4aVar != null && n4aVar.s0 != null && (u89Var.k() == null || !TextUtils.equals(u89Var.k().getName(), this.a.Q().X0()) || !this.a.Q().d1())) {
            x89 x89Var = new x89(n4aVar.s0);
            x89Var.b = this.a.Q().R1();
            this.f.add(x89Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && u89Var.k() != null && !StringUtils.isNull(u89Var.k().getName()) && (!TextUtils.equals(u89Var.k().getName(), this.a.Q().X0()) || !this.a.Q().d1())) {
            w89 w89Var = new w89(u89Var.k());
            w89Var.g = this.a.Q().R1();
            w89Var.e = false;
            this.f.add(w89Var);
            k99Var.h(false);
            k99Var.b = false;
        }
        if (u89Var.N() != null && !StringUtils.isNull(u89Var.N().getForum_name())) {
            p99 p99Var = new p99();
            p99Var.a = u89Var.N();
            this.f.add(p99Var);
        } else if (u89Var.N() != null && !StringUtils.isNull(u89Var.m())) {
            u89Var.N().setForum_name(u89Var.m());
            p99 p99Var2 = new p99();
            p99Var2.a = u89Var.N();
            this.f.add(p99Var2);
        }
        if (j() && u89Var.y() != null && u89Var.y().c() == 1) {
            e99 e99Var = new e99(e99.c);
            e99Var.b(true);
            this.f.add(e99Var);
        }
        j99 j99Var = new j99(j99.g);
        j99Var.c = k();
        j99Var.b = u89Var.g;
        j99Var.d = u89Var.i0();
        j99Var.e = u89Var.f;
        C(u89Var);
        this.f.add(j99Var);
        if (u89Var.J() == 4) {
            this.f.add(new i99());
        }
        G();
        p(i());
        Iterator<n4a> it2 = u89Var.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            n4a next2 = it2.next();
            if ((next2 instanceof n4a) && next2.I() != 1) {
                this.f.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((u89Var2 = this.c) == null || !u89Var2.s()))) {
            g99 g99Var = new g99();
            g99Var.h1 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            g99Var.g1 = R.drawable.new_pic_emotion_03;
            g99Var.i1 = xi.g(this.a.getContext(), R.dimen.tbds74);
            this.f.add(g99Var);
        }
        q(u89Var, this.i, this.g, this.h);
        if (u89Var.y().b() == 0) {
            u89 u89Var3 = this.c;
            if (u89Var3 != null && u89Var3.s()) {
                B(this.a.N().u3());
                this.f.add(new d99());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.c.l());
                statisticItem.param("fname", this.c.m());
                statisticItem.param("tid", this.c.P());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                A(this.a.N().u3());
                c99 c99Var = new c99();
                c99Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.f.add(c99Var);
            }
            List<m4a> Z = u89Var.Z();
            int i2 = -1;
            if (Z != null && !Z.isEmpty()) {
                m4aVar = Z.get(0);
                i2 = m4aVar.getPosition();
            }
            if (!ListUtils.isEmpty(u89Var.e())) {
                int i3 = 1;
                for (c25 c25Var : u89Var.e()) {
                    if (Z != null && i3 == i2) {
                        if (m4aVar != null) {
                            b(m4aVar);
                            this.f.add(m4aVar);
                            i++;
                            if (m4aVar.getType() != AdvertAppInfo.x) {
                                i3++;
                            }
                        }
                        if (i < Z.size()) {
                            m4a m4aVar2 = Z.get(i);
                            m4aVar = m4aVar2;
                            i2 = m4aVar2.getPosition();
                        }
                    }
                    this.f.add(c25Var);
                    i3++;
                }
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.b;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setData(this.f);
        }
        o();
    }
}
