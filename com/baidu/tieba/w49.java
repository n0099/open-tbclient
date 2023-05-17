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
public abstract class w49 extends c59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DetailInfoAndReplyFragment a;
    public BdTypeRecyclerView b;
    public lx8 c;
    public final List<en> d;
    public boolean e;
    public ArrayList<rn> f;
    public String g;
    public boolean h;
    public boolean i;
    public int j;
    public int k;
    public int l;

    public abstract void A(View.OnClickListener onClickListener);

    public abstract void B(View.OnClickListener onClickListener);

    public abstract void C(lx8 lx8Var);

    public void D(py8 py8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, py8Var) == null) {
        }
    }

    public abstract void E(lx8 lx8Var);

    public abstract void F(String str);

    public abstract f19 e();

    public abstract c09 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public abstract void l();

    public abstract void m();

    public abstract void n();

    public abstract void p(boolean z);

    public abstract void q(lx8 lx8Var, boolean z, String str, boolean z2);

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

    public w49(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        lx8 lx8Var;
        qr9 qr9Var;
        qr9 qr9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (lx8Var = this.c) == null || lx8Var.Z || lx8Var.a0 == 2) {
            return;
        }
        ArrayList<rr9> F = lx8Var.F();
        ArrayList<qr9> d = this.c.d();
        if (d != null && !d.isEmpty() && F != null && !F.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<qr9> it = d.iterator();
            while (it.hasNext()) {
                qr9 next = it.next();
                if (next != null && next.t1() != null) {
                    sb.append(next.t1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<qr9> it2 = d.iterator();
            while (it2.hasNext()) {
                qr9 next2 = it2.next();
                if (next2 != null) {
                    next2.j1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<qr9> it3 = d.iterator();
            while (it3.hasNext()) {
                qr9 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int i = next3.getAdvertAppInfo().i();
                    if (i != 0) {
                        kh9.j(next3, i);
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
                qr9 qr9Var3 = (qr9) sparseArray.get(sparseArray.keyAt(i2));
                if (qr9Var3 != null && (qr9Var2 = (qr9) hashMap.put(qr9Var3.s1(), qr9Var3)) != null) {
                    kh9.j(qr9Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (qr9Var = (qr9) entry.getValue()) != null) {
                    sparseArray.put(qr9Var.getPosition(), qr9Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i3)));
            }
            Collections.sort(arrayList);
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                qr9 qr9Var4 = (qr9) sparseArray.get(((Integer) arrayList.get(i4)).intValue());
                if (this.c.k() != null) {
                    qr9Var4.d1 = this.c.k().getId();
                }
                if (this.c.M() != null) {
                    qr9Var4.g1 = pg.g(this.c.M().getId(), 0L);
                }
                lx8 lx8Var2 = this.c;
                if (lx8Var2 != null && lx8Var2.y() != null) {
                    qr9Var4.h1 = this.c.y().a();
                }
                b(qr9Var4);
                int position = qr9Var4.getPosition() + this.c.Y;
                if (position >= F.size()) {
                    qr9Var4.j1 = position;
                    kh9.k(qr9Var4, 2, position + i4, F.size());
                    return;
                }
                if (!this.e) {
                    position--;
                    qr9Var4.j1 = position;
                }
                if (position < 0) {
                    kh9.j(qr9Var4, 23);
                } else if (h(F, position)) {
                    kh9.j(qr9Var4, 1);
                } else {
                    F.add(position, qr9Var4);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", qr9Var4.getAdvertAppInfo().p);
                }
            }
        }
    }

    @Override // com.baidu.tieba.c59
    public ArrayList<rn> a() {
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
                return this.a.P().b1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void b(qr9 qr9Var) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qr9Var) == null) && qr9Var != null && this.c != null && qr9Var.getAdvertAppInfo() != null) {
            qr9Var.getAdvertAppInfo().i = new oy4();
            if (this.c.y() != null) {
                qr9Var.getAdvertAppInfo().i.b = this.c.y().a();
            }
            qr9Var.getAdvertAppInfo().i.a = qr9Var.u1();
            if (this.c.k() != null && (k = this.c.k()) != null) {
                qr9Var.getAdvertAppInfo().i.c = k.getId();
                qr9Var.getAdvertAppInfo().i.d = k.getFirst_class();
                qr9Var.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                qr9Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            qr9Var.getAdvertAppInfo().i.g = qr9Var.getAdvertAppInfo().g;
            qr9Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean h(ArrayList<rr9> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof qr9) {
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
                if (this.f.get(i) instanceof zx8) {
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

    public void r(lx8 lx8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, lx8Var) == null) {
            s(lx8Var, false);
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.e = z;
        }
    }

    public void s(lx8 lx8Var, boolean z) {
        qr9 qr9Var;
        rr9 rr9Var;
        boolean z2;
        lx8 lx8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048601, this, lx8Var, z) != null) || lx8Var == null) {
            return;
        }
        this.c = lx8Var;
        if (lx8Var != null && lx8Var.M() != null && lx8Var.M().getAuthor() != null) {
            this.g = lx8Var.M().getAuthor().getUserId();
        }
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        this.f.clear();
        Iterator<rr9> it = lx8Var.F().iterator();
        while (true) {
            qr9Var = null;
            if (it.hasNext()) {
                rr9 next = it.next();
                if (next instanceof rr9) {
                    rr9Var = next;
                    if (rr9Var.D() == 1) {
                        break;
                    }
                }
            } else {
                rr9Var = null;
                break;
            }
        }
        if (rr9Var == null && lx8Var.i() != null) {
            rr9Var = lx8Var.i();
        }
        if (rr9Var != null) {
            this.f.add(rr9Var);
        }
        E(lx8Var);
        F(this.g);
        int i = 0;
        if (!ListUtils.isEmpty(lx8Var.F()) && lx8Var.F().get(0) != null && lx8Var.M() != null) {
            lx8Var.M().setItem(lx8Var.F().get(0).S());
            lx8Var.M().setItemStar(lx8Var.F().get(0).T());
        }
        if (lx8Var.M() != null && lx8Var.M().getRawThreadInfo() != null) {
            o15 o15Var = new o15();
            o15Var.t = lx8Var.M();
            o15Var.n = true;
            this.f.add(o15Var);
        }
        ay8 ay8Var = new ay8(lx8Var.M(), lx8Var.c());
        ay8Var.h(false);
        ay8Var.b = false;
        this.f.add(ay8Var);
        if (rr9Var != null && rr9Var.r0 != null && (lx8Var.k() == null || !TextUtils.equals(lx8Var.k().getName(), this.a.P().X0()) || !this.a.P().d1())) {
            ox8 ox8Var = new ox8(rr9Var.r0);
            ox8Var.b = this.a.P().R1();
            this.f.add(ox8Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && lx8Var.k() != null && !StringUtils.isNull(lx8Var.k().getName()) && (!TextUtils.equals(lx8Var.k().getName(), this.a.P().X0()) || !this.a.P().d1())) {
            nx8 nx8Var = new nx8(lx8Var.k());
            nx8Var.g = this.a.P().R1();
            nx8Var.e = false;
            this.f.add(nx8Var);
            ay8Var.h(false);
            ay8Var.b = false;
        }
        if (lx8Var.M() != null && !StringUtils.isNull(lx8Var.M().getForum_name())) {
            fy8 fy8Var = new fy8();
            fy8Var.a = lx8Var.M();
            this.f.add(fy8Var);
        } else if (lx8Var.M() != null && !StringUtils.isNull(lx8Var.m())) {
            lx8Var.M().setForum_name(lx8Var.m());
            fy8 fy8Var2 = new fy8();
            fy8Var2.a = lx8Var.M();
            this.f.add(fy8Var2);
        }
        if (j() && lx8Var.y() != null && lx8Var.y().c() == 1) {
            ux8 ux8Var = new ux8(ux8.c);
            ux8Var.b(true);
            this.f.add(ux8Var);
        }
        zx8 zx8Var = new zx8(zx8.g);
        zx8Var.c = k();
        zx8Var.b = lx8Var.g;
        zx8Var.d = lx8Var.h0();
        zx8Var.e = lx8Var.f;
        C(lx8Var);
        this.f.add(zx8Var);
        if (lx8Var.J() == 4) {
            this.f.add(new yx8());
        }
        G();
        p(i());
        Iterator<rr9> it2 = lx8Var.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            rr9 next2 = it2.next();
            if ((next2 instanceof rr9) && next2.D() != 1) {
                this.f.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((lx8Var2 = this.c) == null || !lx8Var2.s()))) {
            wx8 wx8Var = new wx8();
            wx8Var.c1 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            wx8Var.b1 = R.drawable.new_pic_emotion_03;
            wx8Var.d1 = ri.g(this.a.getContext(), R.dimen.tbds74);
            this.f.add(wx8Var);
        }
        q(lx8Var, this.i, this.g, this.h);
        if (lx8Var.y().b() == 0) {
            lx8 lx8Var3 = this.c;
            if (lx8Var3 != null && lx8Var3.s()) {
                B(this.a.M().s3());
                this.f.add(new tx8());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.c.l());
                statisticItem.param("fname", this.c.m());
                statisticItem.param("tid", this.c.O());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                A(this.a.M().s3());
                sx8 sx8Var = new sx8();
                sx8Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.f.add(sx8Var);
            }
            List<qr9> Y = lx8Var.Y();
            int i2 = -1;
            if (Y != null && !Y.isEmpty()) {
                qr9Var = Y.get(0);
                i2 = qr9Var.getPosition();
            }
            if (!ListUtils.isEmpty(lx8Var.e())) {
                int i3 = 1;
                for (az4 az4Var : lx8Var.e()) {
                    if (Y != null && i3 == i2) {
                        if (qr9Var != null) {
                            b(qr9Var);
                            this.f.add(qr9Var);
                            i++;
                            if (qr9Var.getType() != AdvertAppInfo.x) {
                                i3++;
                            }
                        }
                        if (i < Y.size()) {
                            qr9 qr9Var2 = Y.get(i);
                            qr9Var = qr9Var2;
                            i2 = qr9Var2.getPosition();
                        }
                    }
                    this.f.add(az4Var);
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
