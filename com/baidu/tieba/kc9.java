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
/* loaded from: classes6.dex */
public abstract class kc9 extends qc9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DetailInfoAndReplyFragment a;
    public BdTypeRecyclerView b;
    public j49 c;
    public final List<jn> d;
    public boolean e;
    public ArrayList<wn> f;
    public String g;
    public boolean h;
    public boolean i;
    public int j;
    public int k;
    public int l;

    public abstract void A(View.OnClickListener onClickListener);

    public abstract void B(View.OnClickListener onClickListener);

    public abstract void C(j49 j49Var);

    public void D(q59 q59Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, q59Var) == null) {
        }
    }

    public abstract void E(j49 j49Var);

    public abstract void F(String str);

    public abstract i89 e();

    public abstract e79 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public abstract void l();

    public abstract void m();

    public abstract void n();

    public abstract void p(boolean z);

    public abstract void q(j49 j49Var, boolean z, String str, boolean z2);

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

    public kc9(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        j49 j49Var;
        a0a a0aVar;
        a0a a0aVar2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (j49Var = this.c) == null || j49Var.Z || j49Var.a0 == 2) {
            return;
        }
        ArrayList<b0a> F = j49Var.F();
        ArrayList<a0a> d = this.c.d();
        if (d != null && !d.isEmpty() && F != null && !F.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<a0a> it = d.iterator();
            while (it.hasNext()) {
                a0a next = it.next();
                if (next != null && next.A1() != null) {
                    sb.append(next.A1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<a0a> it2 = d.iterator();
            while (it2.hasNext()) {
                a0a next2 = it2.next();
                if (next2 != null) {
                    next2.o1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<a0a> it3 = d.iterator();
            while (it3.hasNext()) {
                a0a next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int i = next3.getAdvertAppInfo().i();
                    if (i != 0) {
                        pp9.j(next3, i);
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
                a0a a0aVar3 = (a0a) sparseArray.get(sparseArray.keyAt(i2));
                if (a0aVar3 != null && (a0aVar2 = (a0a) hashMap.put(a0aVar3.z1(), a0aVar3)) != null) {
                    pp9.j(a0aVar2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (a0aVar = (a0a) entry.getValue()) != null) {
                    sparseArray.put(a0aVar.getPosition(), a0aVar);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i3)));
            }
            Collections.sort(arrayList);
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                a0a a0aVar4 = (a0a) sparseArray.get(((Integer) arrayList.get(i4)).intValue());
                if (this.c.k() != null) {
                    a0aVar4.i1 = this.c.k().getId();
                }
                if (this.c.N() != null) {
                    a0aVar4.l1 = ug.g(this.c.N().getId(), 0L);
                }
                j49 j49Var2 = this.c;
                if (j49Var2 != null && j49Var2.y() != null) {
                    a0aVar4.m1 = this.c.y().a();
                }
                b(a0aVar4);
                int position = a0aVar4.getPosition() + this.c.Y;
                if (position >= F.size()) {
                    a0aVar4.o1 = position;
                    pp9.k(a0aVar4, 2, position + i4, F.size());
                    return;
                }
                if (!this.e) {
                    position--;
                    a0aVar4.o1 = position;
                }
                if (position < 0) {
                    pp9.j(a0aVar4, 23);
                } else if (h(F, position)) {
                    pp9.j(a0aVar4, 1);
                } else {
                    F.add(position, a0aVar4);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", a0aVar4.getAdvertAppInfo().p);
                }
            }
        }
    }

    @Override // com.baidu.tieba.qc9
    public ArrayList<wn> a() {
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

    public final void b(a0a a0aVar) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, a0aVar) == null) && a0aVar != null && this.c != null && a0aVar.getAdvertAppInfo() != null) {
            a0aVar.getAdvertAppInfo().i = new n15();
            if (this.c.y() != null) {
                a0aVar.getAdvertAppInfo().i.b = this.c.y().a();
            }
            a0aVar.getAdvertAppInfo().i.a = a0aVar.B1();
            if (this.c.k() != null && (k = this.c.k()) != null) {
                a0aVar.getAdvertAppInfo().i.c = k.getId();
                a0aVar.getAdvertAppInfo().i.d = k.getFirst_class();
                a0aVar.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                a0aVar.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            a0aVar.getAdvertAppInfo().i.g = a0aVar.getAdvertAppInfo().g;
            a0aVar.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean h(ArrayList<b0a> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof a0a) {
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
                if (this.f.get(i) instanceof y49) {
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

    public void r(j49 j49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, j49Var) == null) {
            s(j49Var, false);
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.e = z;
        }
    }

    public void s(j49 j49Var, boolean z) {
        a0a a0aVar;
        b0a b0aVar;
        boolean z2;
        j49 j49Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048601, this, j49Var, z) != null) || j49Var == null) {
            return;
        }
        this.c = j49Var;
        if (j49Var != null && j49Var.N() != null && j49Var.N().getAuthor() != null) {
            this.g = j49Var.N().getAuthor().getUserId();
        }
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        this.f.clear();
        Iterator<b0a> it = j49Var.F().iterator();
        while (true) {
            a0aVar = null;
            if (it.hasNext()) {
                b0a next = it.next();
                if (next instanceof b0a) {
                    b0aVar = next;
                    if (b0aVar.I() == 1) {
                        break;
                    }
                }
            } else {
                b0aVar = null;
                break;
            }
        }
        if (b0aVar == null && j49Var.i() != null) {
            b0aVar = j49Var.i();
        }
        if (b0aVar != null) {
            this.f.add(b0aVar);
        }
        E(j49Var);
        F(this.g);
        int i = 0;
        if (!ListUtils.isEmpty(j49Var.F()) && j49Var.F().get(0) != null && j49Var.N() != null) {
            j49Var.N().setItem(j49Var.F().get(0).W());
            j49Var.N().setItemStar(j49Var.F().get(0).X());
        }
        if (j49Var.N() != null && j49Var.N().getRawThreadInfo() != null) {
            o45 o45Var = new o45();
            o45Var.t = j49Var.N();
            o45Var.n = true;
            this.f.add(o45Var);
        }
        z49 z49Var = new z49(j49Var.N(), j49Var.c());
        z49Var.h(false);
        z49Var.b = false;
        this.f.add(z49Var);
        if (b0aVar != null && b0aVar.s0 != null && (j49Var.k() == null || !TextUtils.equals(j49Var.k().getName(), this.a.Q().X0()) || !this.a.Q().d1())) {
            m49 m49Var = new m49(b0aVar.s0);
            m49Var.b = this.a.Q().R1();
            this.f.add(m49Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && j49Var.k() != null && !StringUtils.isNull(j49Var.k().getName()) && (!TextUtils.equals(j49Var.k().getName(), this.a.Q().X0()) || !this.a.Q().d1())) {
            l49 l49Var = new l49(j49Var.k());
            l49Var.g = this.a.Q().R1();
            l49Var.e = false;
            this.f.add(l49Var);
            z49Var.h(false);
            z49Var.b = false;
        }
        if (j49Var.N() != null && !StringUtils.isNull(j49Var.N().getForum_name())) {
            e59 e59Var = new e59();
            e59Var.a = j49Var.N();
            this.f.add(e59Var);
        } else if (j49Var.N() != null && !StringUtils.isNull(j49Var.m())) {
            j49Var.N().setForum_name(j49Var.m());
            e59 e59Var2 = new e59();
            e59Var2.a = j49Var.N();
            this.f.add(e59Var2);
        }
        if (j() && j49Var.y() != null && j49Var.y().c() == 1) {
            t49 t49Var = new t49(t49.c);
            t49Var.b(true);
            this.f.add(t49Var);
        }
        y49 y49Var = new y49(y49.g);
        y49Var.c = k();
        y49Var.b = j49Var.g;
        y49Var.d = j49Var.i0();
        y49Var.e = j49Var.f;
        C(j49Var);
        this.f.add(y49Var);
        if (j49Var.J() == 4) {
            this.f.add(new x49());
        }
        G();
        p(i());
        Iterator<b0a> it2 = j49Var.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            b0a next2 = it2.next();
            if ((next2 instanceof b0a) && next2.I() != 1) {
                this.f.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((j49Var2 = this.c) == null || !j49Var2.s()))) {
            v49 v49Var = new v49();
            v49Var.h1 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            v49Var.g1 = R.drawable.new_pic_emotion_03;
            v49Var.i1 = wi.g(this.a.getContext(), R.dimen.tbds74);
            this.f.add(v49Var);
        }
        q(j49Var, this.i, this.g, this.h);
        if (j49Var.y().b() == 0) {
            j49 j49Var3 = this.c;
            if (j49Var3 != null && j49Var3.s()) {
                B(this.a.N().u3());
                this.f.add(new s49());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.c.l());
                statisticItem.param("fname", this.c.m());
                statisticItem.param("tid", this.c.P());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                A(this.a.N().u3());
                r49 r49Var = new r49();
                r49Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.f.add(r49Var);
            }
            List<a0a> Z = j49Var.Z();
            int i2 = -1;
            if (Z != null && !Z.isEmpty()) {
                a0aVar = Z.get(0);
                i2 = a0aVar.getPosition();
            }
            if (!ListUtils.isEmpty(j49Var.e())) {
                int i3 = 1;
                for (z15 z15Var : j49Var.e()) {
                    if (Z != null && i3 == i2) {
                        if (a0aVar != null) {
                            b(a0aVar);
                            this.f.add(a0aVar);
                            i++;
                            if (a0aVar.getType() != AdvertAppInfo.x) {
                                i3++;
                            }
                        }
                        if (i < Z.size()) {
                            a0a a0aVar2 = Z.get(i);
                            a0aVar = a0aVar2;
                            i2 = a0aVar2.getPosition();
                        }
                    }
                    this.f.add(z15Var);
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
