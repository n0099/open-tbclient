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
public abstract class x49 extends d59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DetailInfoAndReplyFragment a;
    public BdTypeRecyclerView b;
    public mx8 c;
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

    public abstract void C(mx8 mx8Var);

    public void D(qy8 qy8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, qy8Var) == null) {
        }
    }

    public abstract void E(mx8 mx8Var);

    public abstract void F(String str);

    public abstract g19 e();

    public abstract d09 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public abstract void l();

    public abstract void m();

    public abstract void n();

    public abstract void p(boolean z);

    public abstract void q(mx8 mx8Var, boolean z, String str, boolean z2);

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

    public x49(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        mx8 mx8Var;
        rr9 rr9Var;
        rr9 rr9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (mx8Var = this.c) == null || mx8Var.Z || mx8Var.a0 == 2) {
            return;
        }
        ArrayList<sr9> F = mx8Var.F();
        ArrayList<rr9> d = this.c.d();
        if (d != null && !d.isEmpty() && F != null && !F.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<rr9> it = d.iterator();
            while (it.hasNext()) {
                rr9 next = it.next();
                if (next != null && next.t1() != null) {
                    sb.append(next.t1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<rr9> it2 = d.iterator();
            while (it2.hasNext()) {
                rr9 next2 = it2.next();
                if (next2 != null) {
                    next2.j1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<rr9> it3 = d.iterator();
            while (it3.hasNext()) {
                rr9 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int i = next3.getAdvertAppInfo().i();
                    if (i != 0) {
                        lh9.j(next3, i);
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
                rr9 rr9Var3 = (rr9) sparseArray.get(sparseArray.keyAt(i2));
                if (rr9Var3 != null && (rr9Var2 = (rr9) hashMap.put(rr9Var3.s1(), rr9Var3)) != null) {
                    lh9.j(rr9Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (rr9Var = (rr9) entry.getValue()) != null) {
                    sparseArray.put(rr9Var.getPosition(), rr9Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i3)));
            }
            Collections.sort(arrayList);
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                rr9 rr9Var4 = (rr9) sparseArray.get(((Integer) arrayList.get(i4)).intValue());
                if (this.c.k() != null) {
                    rr9Var4.d1 = this.c.k().getId();
                }
                if (this.c.M() != null) {
                    rr9Var4.g1 = pg.g(this.c.M().getId(), 0L);
                }
                mx8 mx8Var2 = this.c;
                if (mx8Var2 != null && mx8Var2.y() != null) {
                    rr9Var4.h1 = this.c.y().a();
                }
                b(rr9Var4);
                int position = rr9Var4.getPosition() + this.c.Y;
                if (position >= F.size()) {
                    rr9Var4.j1 = position;
                    lh9.k(rr9Var4, 2, position + i4, F.size());
                    return;
                }
                if (!this.e) {
                    position--;
                    rr9Var4.j1 = position;
                }
                if (position < 0) {
                    lh9.j(rr9Var4, 23);
                } else if (h(F, position)) {
                    lh9.j(rr9Var4, 1);
                } else {
                    F.add(position, rr9Var4);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", rr9Var4.getAdvertAppInfo().p);
                }
            }
        }
    }

    @Override // com.baidu.tieba.d59
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

    public final void b(rr9 rr9Var) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rr9Var) == null) && rr9Var != null && this.c != null && rr9Var.getAdvertAppInfo() != null) {
            rr9Var.getAdvertAppInfo().i = new oy4();
            if (this.c.y() != null) {
                rr9Var.getAdvertAppInfo().i.b = this.c.y().a();
            }
            rr9Var.getAdvertAppInfo().i.a = rr9Var.u1();
            if (this.c.k() != null && (k = this.c.k()) != null) {
                rr9Var.getAdvertAppInfo().i.c = k.getId();
                rr9Var.getAdvertAppInfo().i.d = k.getFirst_class();
                rr9Var.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                rr9Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            rr9Var.getAdvertAppInfo().i.g = rr9Var.getAdvertAppInfo().g;
            rr9Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean h(ArrayList<sr9> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof rr9) {
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
                if (this.f.get(i) instanceof ay8) {
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

    public void r(mx8 mx8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, mx8Var) == null) {
            s(mx8Var, false);
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.e = z;
        }
    }

    public void s(mx8 mx8Var, boolean z) {
        rr9 rr9Var;
        sr9 sr9Var;
        boolean z2;
        mx8 mx8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048601, this, mx8Var, z) != null) || mx8Var == null) {
            return;
        }
        this.c = mx8Var;
        if (mx8Var != null && mx8Var.M() != null && mx8Var.M().getAuthor() != null) {
            this.g = mx8Var.M().getAuthor().getUserId();
        }
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        this.f.clear();
        Iterator<sr9> it = mx8Var.F().iterator();
        while (true) {
            rr9Var = null;
            if (it.hasNext()) {
                sr9 next = it.next();
                if (next instanceof sr9) {
                    sr9Var = next;
                    if (sr9Var.D() == 1) {
                        break;
                    }
                }
            } else {
                sr9Var = null;
                break;
            }
        }
        if (sr9Var == null && mx8Var.i() != null) {
            sr9Var = mx8Var.i();
        }
        if (sr9Var != null) {
            this.f.add(sr9Var);
        }
        E(mx8Var);
        F(this.g);
        int i = 0;
        if (!ListUtils.isEmpty(mx8Var.F()) && mx8Var.F().get(0) != null && mx8Var.M() != null) {
            mx8Var.M().setItem(mx8Var.F().get(0).S());
            mx8Var.M().setItemStar(mx8Var.F().get(0).T());
        }
        if (mx8Var.M() != null && mx8Var.M().getRawThreadInfo() != null) {
            o15 o15Var = new o15();
            o15Var.t = mx8Var.M();
            o15Var.n = true;
            this.f.add(o15Var);
        }
        by8 by8Var = new by8(mx8Var.M(), mx8Var.c());
        by8Var.h(false);
        by8Var.b = false;
        this.f.add(by8Var);
        if (sr9Var != null && sr9Var.r0 != null && (mx8Var.k() == null || !TextUtils.equals(mx8Var.k().getName(), this.a.P().X0()) || !this.a.P().d1())) {
            px8 px8Var = new px8(sr9Var.r0);
            px8Var.b = this.a.P().R1();
            this.f.add(px8Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && mx8Var.k() != null && !StringUtils.isNull(mx8Var.k().getName()) && (!TextUtils.equals(mx8Var.k().getName(), this.a.P().X0()) || !this.a.P().d1())) {
            ox8 ox8Var = new ox8(mx8Var.k());
            ox8Var.g = this.a.P().R1();
            ox8Var.e = false;
            this.f.add(ox8Var);
            by8Var.h(false);
            by8Var.b = false;
        }
        if (mx8Var.M() != null && !StringUtils.isNull(mx8Var.M().getForum_name())) {
            gy8 gy8Var = new gy8();
            gy8Var.a = mx8Var.M();
            this.f.add(gy8Var);
        } else if (mx8Var.M() != null && !StringUtils.isNull(mx8Var.m())) {
            mx8Var.M().setForum_name(mx8Var.m());
            gy8 gy8Var2 = new gy8();
            gy8Var2.a = mx8Var.M();
            this.f.add(gy8Var2);
        }
        if (j() && mx8Var.y() != null && mx8Var.y().c() == 1) {
            vx8 vx8Var = new vx8(vx8.c);
            vx8Var.b(true);
            this.f.add(vx8Var);
        }
        ay8 ay8Var = new ay8(ay8.g);
        ay8Var.c = k();
        ay8Var.b = mx8Var.g;
        ay8Var.d = mx8Var.h0();
        ay8Var.e = mx8Var.f;
        C(mx8Var);
        this.f.add(ay8Var);
        if (mx8Var.J() == 4) {
            this.f.add(new zx8());
        }
        G();
        p(i());
        Iterator<sr9> it2 = mx8Var.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            sr9 next2 = it2.next();
            if ((next2 instanceof sr9) && next2.D() != 1) {
                this.f.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((mx8Var2 = this.c) == null || !mx8Var2.s()))) {
            xx8 xx8Var = new xx8();
            xx8Var.c1 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            xx8Var.b1 = R.drawable.new_pic_emotion_03;
            xx8Var.d1 = ri.g(this.a.getContext(), R.dimen.tbds74);
            this.f.add(xx8Var);
        }
        q(mx8Var, this.i, this.g, this.h);
        if (mx8Var.y().b() == 0) {
            mx8 mx8Var3 = this.c;
            if (mx8Var3 != null && mx8Var3.s()) {
                B(this.a.M().s3());
                this.f.add(new ux8());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.c.l());
                statisticItem.param("fname", this.c.m());
                statisticItem.param("tid", this.c.O());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                A(this.a.M().s3());
                tx8 tx8Var = new tx8();
                tx8Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.f.add(tx8Var);
            }
            List<rr9> Y = mx8Var.Y();
            int i2 = -1;
            if (Y != null && !Y.isEmpty()) {
                rr9Var = Y.get(0);
                i2 = rr9Var.getPosition();
            }
            if (!ListUtils.isEmpty(mx8Var.e())) {
                int i3 = 1;
                for (az4 az4Var : mx8Var.e()) {
                    if (Y != null && i3 == i2) {
                        if (rr9Var != null) {
                            b(rr9Var);
                            this.f.add(rr9Var);
                            i++;
                            if (rr9Var.getType() != AdvertAppInfo.x) {
                                i3++;
                            }
                        }
                        if (i < Y.size()) {
                            rr9 rr9Var2 = Y.get(i);
                            rr9Var = rr9Var2;
                            i2 = rr9Var2.getPosition();
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
