package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
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
public abstract class wl9 extends cm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DetailInfoAndReplyFragment a;
    public BdTypeRecyclerView b;
    public td9 c;
    public final List<lm> d;
    public boolean e;
    public ArrayList<ym> f;
    public String g;
    public boolean h;
    public boolean i;
    public int j;
    public int k;
    public int l;
    public kn m;

    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
        }
    }

    public abstract void B(View.OnClickListener onClickListener);

    public abstract void C(View.OnClickListener onClickListener);

    public abstract void D(td9 td9Var);

    public void E(af9 af9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, af9Var) == null) {
        }
    }

    public abstract void F(td9 td9Var);

    public abstract void G(String str);

    public abstract uh9 f();

    public abstract og9 g();

    public abstract PbFirstFloorCommentAndPraiseAdapter h();

    public abstract void m();

    public abstract void n();

    public abstract void o();

    public abstract void q(boolean z);

    public abstract void r(td9 td9Var, boolean z, String str, boolean z2);

    public void v(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, onClickListener) == null) {
        }
    }

    public abstract void w(boolean z);

    public void x(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, zVar) == null) {
        }
    }

    public void y(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, onLongClickListener) == null) {
        }
    }

    public void z(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, fVar) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wl9 a;

        public a(wl9 wl9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wl9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wl9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wl9 wl9Var = this.a;
                wl9Var.b.setData(wl9Var.f);
            }
        }
    }

    public wl9(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        if (detailInfoAndReplyFragment != null && detailInfoAndReplyFragment.O() != null && detailInfoAndReplyFragment.O().getArguments() != null) {
            this.j = detailInfoAndReplyFragment.O().getArguments().getInt(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE);
        }
        this.b = bdTypeRecyclerView;
        this.m = new kn(bdTypeRecyclerView);
    }

    public void s(td9 td9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, td9Var) == null) {
            t(td9Var, false);
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.e = z;
        }
    }

    public final void H() {
        td9 td9Var;
        qba qbaVar;
        qba qbaVar2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (td9Var = this.c) == null || td9Var.Z || td9Var.a0 == 2) {
            return;
        }
        ArrayList<rba> F = td9Var.F();
        ArrayList<qba> d = this.c.d();
        if (d != null && !d.isEmpty() && F != null && !F.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<qba> it = d.iterator();
            while (it.hasNext()) {
                qba next = it.next();
                if (next != null && next.A1() != null) {
                    sb.append(next.A1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<qba> it2 = d.iterator();
            while (it2.hasNext()) {
                qba next2 = it2.next();
                if (next2 != null) {
                    next2.n1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<qba> it3 = d.iterator();
            while (it3.hasNext()) {
                qba next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int h = next3.getAdvertAppInfo().h();
                    if (h != 0) {
                        bz9.j(next3, h);
                        if (h != 28 && h != 31) {
                            next3.getAdvertAppInfo().c = -1001;
                            Log.e("cq", "updateAppData，Data InValidate: " + h);
                        }
                    }
                    sparseArray.put(next3.getPosition(), next3);
                }
            }
            HashMap hashMap = new HashMap();
            for (int i = 0; i < sparseArray.size(); i++) {
                qba qbaVar3 = (qba) sparseArray.get(sparseArray.keyAt(i));
                if (qbaVar3 != null && (qbaVar2 = (qba) hashMap.put(qbaVar3.z1(), qbaVar3)) != null) {
                    bz9.j(qbaVar2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (qbaVar = (qba) entry.getValue()) != null) {
                    sparseArray.put(qbaVar.getPosition(), qbaVar);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                qba qbaVar4 = (qba) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                if (this.c.k() != null) {
                    qbaVar4.h1 = this.c.k().getId();
                }
                if (this.c.O() != null) {
                    qbaVar4.k1 = JavaTypesHelper.toLong(this.c.O().getId(), 0L);
                }
                td9 td9Var2 = this.c;
                if (td9Var2 != null && td9Var2.y() != null) {
                    qbaVar4.l1 = this.c.y().a();
                }
                c(qbaVar4);
                int position = qbaVar4.getPosition() + this.c.Y;
                if (position >= F.size()) {
                    qbaVar4.n1 = position;
                    bz9.k(qbaVar4, 2, position + i3, F.size());
                    return;
                }
                if (!this.e) {
                    position--;
                    qbaVar4.n1 = position;
                }
                if (position < 0) {
                    bz9.j(qbaVar4, 23);
                } else if (i(F, position)) {
                    bz9.j(qbaVar4, 1);
                } else {
                    F.add(position, qbaVar4);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", qbaVar4.getAdvertAppInfo().q);
                }
            }
        }
    }

    @Override // com.baidu.tieba.cm9
    public ArrayList<ym> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (12 == this.j) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.a.R() != null) {
                return this.a.R().V0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void c(qba qbaVar) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, qbaVar) == null) && qbaVar != null && this.c != null && qbaVar.getAdvertAppInfo() != null) {
            qbaVar.getAdvertAppInfo().i = new v05();
            if (this.c.y() != null) {
                qbaVar.getAdvertAppInfo().i.b = this.c.y().a();
            }
            qbaVar.getAdvertAppInfo().i.a = qbaVar.B1();
            if (this.c.k() != null && (k = this.c.k()) != null) {
                qbaVar.getAdvertAppInfo().i.c = k.getId();
                qbaVar.getAdvertAppInfo().i.d = k.getFirst_class();
                qbaVar.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                qbaVar.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            qbaVar.getAdvertAppInfo().i.g = qbaVar.getAdvertAppInfo().g;
            qbaVar.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean i(ArrayList<rba> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof qba) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            boolean z = false;
            for (int i = 0; i < this.f.size(); i++) {
                if (this.f.get(i) instanceof ie9) {
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

    public void t(td9 td9Var, boolean z) {
        qba qbaVar;
        rba rbaVar;
        boolean z2;
        td9 td9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048602, this, td9Var, z) != null) || td9Var == null) {
            return;
        }
        this.c = td9Var;
        if (td9Var != null && td9Var.O() != null && td9Var.O().getAuthor() != null) {
            this.g = td9Var.O().getAuthor().getUserId();
        }
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        this.f.clear();
        Iterator<rba> it = td9Var.F().iterator();
        while (true) {
            qbaVar = null;
            if (it.hasNext()) {
                rba next = it.next();
                if (next instanceof rba) {
                    rbaVar = next;
                    if (rbaVar.I() == 1) {
                        break;
                    }
                }
            } else {
                rbaVar = null;
                break;
            }
        }
        if (rbaVar == null && td9Var.i() != null) {
            rbaVar = td9Var.i();
        }
        if (rbaVar != null) {
            this.f.add(rbaVar);
        }
        F(td9Var);
        G(this.g);
        int i = 0;
        if (!ListUtils.isEmpty(td9Var.F()) && td9Var.F().get(0) != null && td9Var.O() != null) {
            td9Var.O().setItem(td9Var.F().get(0).W());
            td9Var.O().setItemStar(td9Var.F().get(0).X());
        }
        if (td9Var.O() != null && td9Var.O().getRawThreadInfo() != null) {
            w35 w35Var = new w35();
            w35Var.t = td9Var.O();
            w35Var.n = true;
            this.f.add(w35Var);
        }
        je9 je9Var = new je9(td9Var.O(), td9Var.c());
        je9Var.g(false);
        je9Var.b = false;
        this.f.add(je9Var);
        if (rbaVar != null && rbaVar.s0 != null && (td9Var.k() == null || !TextUtils.equals(td9Var.k().getName(), this.a.R().R0()) || !this.a.R().X0())) {
            wd9 wd9Var = new wd9(rbaVar.s0);
            wd9Var.b = this.a.R().M1();
            this.f.add(wd9Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && td9Var.k() != null && !StringUtils.isNull(td9Var.k().getName()) && (!TextUtils.equals(td9Var.k().getName(), this.a.R().R0()) || !this.a.R().X0())) {
            vd9 vd9Var = new vd9(td9Var.k());
            vd9Var.g = this.a.R().M1();
            vd9Var.e = false;
            this.f.add(vd9Var);
            je9Var.g(false);
            je9Var.b = false;
        }
        if (td9Var.O() != null && !StringUtils.isNull(td9Var.O().getForum_name())) {
            oe9 oe9Var = new oe9();
            oe9Var.a = td9Var.O();
            this.f.add(oe9Var);
        } else if (td9Var.O() != null && !StringUtils.isNull(td9Var.m())) {
            td9Var.O().setForum_name(td9Var.m());
            oe9 oe9Var2 = new oe9();
            oe9Var2.a = td9Var.O();
            this.f.add(oe9Var2);
        }
        if (k() && td9Var.y() != null && td9Var.y().c() == 1) {
            de9 de9Var = new de9(de9.c);
            de9Var.b(true);
            this.f.add(de9Var);
        }
        ie9 ie9Var = new ie9(ie9.g);
        ie9Var.c = l();
        ie9Var.b = td9Var.g;
        ie9Var.d = td9Var.j0();
        ie9Var.e = td9Var.f;
        D(td9Var);
        this.f.add(ie9Var);
        if (td9Var.J() == 4) {
            this.f.add(new he9());
        }
        H();
        q(j());
        Iterator<rba> it2 = td9Var.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            rba next2 = it2.next();
            if ((next2 instanceof rba) && next2.I() != 1) {
                this.f.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((td9Var2 = this.c) == null || !td9Var2.s()))) {
            fe9 fe9Var = new fe9();
            fe9Var.g1 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            fe9Var.f1 = R.drawable.new_pic_emotion_03;
            fe9Var.h1 = BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds74);
            this.f.add(fe9Var);
        }
        r(td9Var, this.i, this.g, this.h);
        if (td9Var.y().b() == 0) {
            td9 td9Var3 = this.c;
            if (td9Var3 != null && td9Var3.s()) {
                C(this.a.O().v3());
                this.f.add(new ce9());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.c.l());
                statisticItem.param("fname", this.c.m());
                statisticItem.param("tid", this.c.Q());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                B(this.a.O().v3());
                be9 be9Var = new be9();
                be9Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.f.add(be9Var);
            }
            List<qba> a0 = td9Var.a0();
            int i2 = -1;
            if (a0 != null && !a0.isEmpty()) {
                qbaVar = a0.get(0);
                i2 = qbaVar.getPosition();
            }
            if (!ListUtils.isEmpty(td9Var.e())) {
                int i3 = 1;
                for (h15 h15Var : td9Var.e()) {
                    if (a0 != null && i3 == i2) {
                        if (qbaVar != null) {
                            c(qbaVar);
                            this.f.add(qbaVar);
                            i++;
                            if (qbaVar.getType() != AdvertAppInfo.y) {
                                i3++;
                            }
                        }
                        if (i < a0.size()) {
                            qba qbaVar2 = a0.get(i);
                            qbaVar = qbaVar2;
                            i2 = qbaVar2.getPosition();
                        }
                    }
                    this.f.add(h15Var);
                    i3++;
                }
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.b;
        if (bdTypeRecyclerView != null) {
            if (this.m == null) {
                this.m = new kn(bdTypeRecyclerView);
            }
            this.m.e(new a(this));
        }
        p();
    }
}
