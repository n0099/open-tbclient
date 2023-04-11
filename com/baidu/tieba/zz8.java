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
/* loaded from: classes7.dex */
public abstract class zz8 extends f09 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DetailInfoAndReplyFragment a;
    public BdTypeRecyclerView b;
    public zs8 c;
    public final List<um> d;
    public boolean e;
    public ArrayList<hn> f;
    public String g;
    public boolean h;
    public boolean i;
    public int j;
    public int k;
    public int l;

    public abstract void A(View.OnClickListener onClickListener);

    public abstract void B(View.OnClickListener onClickListener);

    public abstract void C(zs8 zs8Var);

    public void D(cu8 cu8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cu8Var) == null) {
        }
    }

    public abstract void E(zs8 zs8Var);

    public abstract void F(String str);

    public abstract pw8 e();

    public abstract nv8 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public abstract void l();

    public abstract void m();

    public abstract void n();

    public abstract void p(boolean z);

    public abstract void q(zs8 zs8Var, boolean z, String str, boolean z2);

    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onClickListener) == null) {
        }
    }

    public abstract void v(boolean z);

    public void w(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, a0Var) == null) {
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

    public zz8(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        if (detailInfoAndReplyFragment != null && detailInfoAndReplyFragment.M() != null && detailInfoAndReplyFragment.M().getArguments() != null) {
            this.j = detailInfoAndReplyFragment.M().getArguments().getInt(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE);
        }
        this.b = bdTypeRecyclerView;
    }

    public final void G() {
        zs8 zs8Var;
        rl9 rl9Var;
        rl9 rl9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (zs8Var = this.c) == null || zs8Var.Z || zs8Var.a0 == 2) {
            return;
        }
        ArrayList<sl9> F = zs8Var.F();
        ArrayList<rl9> d = this.c.d();
        if (d != null && !d.isEmpty() && F != null && !F.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<rl9> it = d.iterator();
            while (it.hasNext()) {
                rl9 next = it.next();
                if (next != null && next.r1() != null) {
                    sb.append(next.r1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<rl9> it2 = d.iterator();
            while (it2.hasNext()) {
                rl9 next2 = it2.next();
                if (next2 != null) {
                    next2.i1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<rl9> it3 = d.iterator();
            while (it3.hasNext()) {
                rl9 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int i = next3.getAdvertAppInfo().i();
                    if (i != 0) {
                        jc9.j(next3, i);
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
                rl9 rl9Var3 = (rl9) sparseArray.get(sparseArray.keyAt(i2));
                if (rl9Var3 != null && (rl9Var2 = (rl9) hashMap.put(rl9Var3.q1(), rl9Var3)) != null) {
                    jc9.j(rl9Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (rl9Var = (rl9) entry.getValue()) != null) {
                    sparseArray.put(rl9Var.getPosition(), rl9Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i3)));
            }
            Collections.sort(arrayList);
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                rl9 rl9Var4 = (rl9) sparseArray.get(((Integer) arrayList.get(i4)).intValue());
                if (this.c.k() != null) {
                    rl9Var4.c1 = this.c.k().getId();
                }
                if (this.c.M() != null) {
                    rl9Var4.f1 = gg.g(this.c.M().getId(), 0L);
                }
                zs8 zs8Var2 = this.c;
                if (zs8Var2 != null && zs8Var2.y() != null) {
                    rl9Var4.g1 = this.c.y().a();
                }
                b(rl9Var4);
                int position = rl9Var4.getPosition() + this.c.Y;
                if (position >= F.size()) {
                    rl9Var4.i1 = position;
                    jc9.k(rl9Var4, 2, position + i4, F.size());
                    return;
                }
                if (!this.e) {
                    position--;
                    rl9Var4.i1 = position;
                }
                if (position < 0) {
                    jc9.j(rl9Var4, 23);
                } else if (h(F, position)) {
                    jc9.j(rl9Var4, 1);
                } else {
                    F.add(position, rl9Var4);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", rl9Var4.getAdvertAppInfo().p);
                }
            }
        }
    }

    @Override // com.baidu.tieba.f09
    public ArrayList<hn> a() {
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
            if (this.a.P() != null) {
                return this.a.P().X0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void b(rl9 rl9Var) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rl9Var) == null) && rl9Var != null && this.c != null && rl9Var.getAdvertAppInfo() != null) {
            rl9Var.getAdvertAppInfo().i = new ow4();
            if (this.c.y() != null) {
                rl9Var.getAdvertAppInfo().i.b = this.c.y().a();
            }
            rl9Var.getAdvertAppInfo().i.a = rl9Var.s1();
            if (this.c.k() != null && (k = this.c.k()) != null) {
                rl9Var.getAdvertAppInfo().i.c = k.getId();
                rl9Var.getAdvertAppInfo().i.d = k.getFirst_class();
                rl9Var.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                rl9Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            rl9Var.getAdvertAppInfo().i.g = rl9Var.getAdvertAppInfo().g;
            rl9Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean h(ArrayList<sl9> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof rl9) {
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
                if (this.f.get(i) instanceof mt8) {
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

    public void r(zs8 zs8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, zs8Var) == null) {
            s(zs8Var, false);
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.e = z;
        }
    }

    public void s(zs8 zs8Var, boolean z) {
        rl9 rl9Var;
        sl9 sl9Var;
        boolean z2;
        zs8 zs8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048601, this, zs8Var, z) != null) || zs8Var == null) {
            return;
        }
        this.c = zs8Var;
        if (zs8Var != null && zs8Var.M() != null && zs8Var.M().getAuthor() != null) {
            this.g = zs8Var.M().getAuthor().getUserId();
        }
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        this.f.clear();
        Iterator<sl9> it = zs8Var.F().iterator();
        while (true) {
            rl9Var = null;
            if (it.hasNext()) {
                sl9 next = it.next();
                if (next instanceof sl9) {
                    sl9Var = next;
                    if (sl9Var.E() == 1) {
                        break;
                    }
                }
            } else {
                sl9Var = null;
                break;
            }
        }
        if (sl9Var == null && zs8Var.i() != null) {
            sl9Var = zs8Var.i();
        }
        if (sl9Var != null) {
            this.f.add(sl9Var);
        }
        E(zs8Var);
        F(this.g);
        int i = 0;
        if (!ListUtils.isEmpty(zs8Var.F()) && zs8Var.F().get(0) != null && zs8Var.M() != null) {
            zs8Var.M().setItem(zs8Var.F().get(0).S());
            zs8Var.M().setItemStar(zs8Var.F().get(0).T());
        }
        if (zs8Var.M() != null && zs8Var.M().getRawThreadInfo() != null) {
            oz4 oz4Var = new oz4();
            oz4Var.t = zs8Var.M();
            oz4Var.n = true;
            this.f.add(oz4Var);
        }
        nt8 nt8Var = new nt8(zs8Var.M(), zs8Var.c());
        nt8Var.h(false);
        nt8Var.b = false;
        this.f.add(nt8Var);
        if (sl9Var != null && sl9Var.r0 != null && (zs8Var.k() == null || !TextUtils.equals(zs8Var.k().getName(), this.a.P().T0()) || !this.a.P().Z0())) {
            ct8 ct8Var = new ct8(sl9Var.r0);
            ct8Var.b = this.a.P().N1();
            this.f.add(ct8Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && zs8Var.k() != null && !StringUtils.isNull(zs8Var.k().getName()) && (!TextUtils.equals(zs8Var.k().getName(), this.a.P().T0()) || !this.a.P().Z0())) {
            bt8 bt8Var = new bt8(zs8Var.k());
            bt8Var.g = this.a.P().N1();
            bt8Var.e = false;
            this.f.add(bt8Var);
            nt8Var.h(false);
            nt8Var.b = false;
        }
        if (zs8Var.M() != null && !StringUtils.isNull(zs8Var.M().getForum_name())) {
            st8 st8Var = new st8();
            st8Var.a = zs8Var.M();
            this.f.add(st8Var);
        } else if (zs8Var.M() != null && !StringUtils.isNull(zs8Var.m())) {
            zs8Var.M().setForum_name(zs8Var.m());
            st8 st8Var2 = new st8();
            st8Var2.a = zs8Var.M();
            this.f.add(st8Var2);
        }
        if (j() && zs8Var.y() != null && zs8Var.y().c() == 1) {
            ht8 ht8Var = new ht8(ht8.c);
            ht8Var.b(true);
            this.f.add(ht8Var);
        }
        mt8 mt8Var = new mt8(mt8.g);
        mt8Var.c = k();
        mt8Var.b = zs8Var.g;
        mt8Var.d = zs8Var.h0();
        mt8Var.e = zs8Var.f;
        C(zs8Var);
        this.f.add(mt8Var);
        if (zs8Var.J() == 4) {
            this.f.add(new lt8());
        }
        G();
        p(i());
        Iterator<sl9> it2 = zs8Var.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            sl9 next2 = it2.next();
            if ((next2 instanceof sl9) && next2.E() != 1) {
                this.f.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((zs8Var2 = this.c) == null || !zs8Var2.s()))) {
            jt8 jt8Var = new jt8();
            jt8Var.b1 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            jt8Var.a1 = R.drawable.new_pic_emotion_03;
            jt8Var.c1 = -2;
            jt8Var.d1 = ii.g(this.a.getContext(), R.dimen.tbds74);
            this.f.add(jt8Var);
        }
        q(zs8Var, this.i, this.g, this.h);
        if (zs8Var.y().b() == 0) {
            zs8 zs8Var3 = this.c;
            if (zs8Var3 != null && zs8Var3.s()) {
                B(this.a.M().q3());
                this.f.add(new gt8());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.c.l());
                statisticItem.param("fname", this.c.m());
                statisticItem.param("tid", this.c.O());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                A(this.a.M().q3());
                ft8 ft8Var = new ft8();
                ft8Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.f.add(ft8Var);
            }
            List<rl9> Y = zs8Var.Y();
            int i2 = -1;
            if (Y != null && !Y.isEmpty()) {
                rl9Var = Y.get(0);
                i2 = rl9Var.getPosition();
            }
            if (!ListUtils.isEmpty(zs8Var.e())) {
                int i3 = 1;
                for (ax4 ax4Var : zs8Var.e()) {
                    if (Y != null && i3 == i2) {
                        if (rl9Var != null) {
                            b(rl9Var);
                            this.f.add(rl9Var);
                            i++;
                            if (rl9Var.getType() != AdvertAppInfo.x) {
                                i3++;
                            }
                        }
                        if (i < Y.size()) {
                            rl9 rl9Var2 = Y.get(i);
                            rl9Var = rl9Var2;
                            i2 = rl9Var2.getPosition();
                        }
                    }
                    this.f.add(ax4Var);
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
