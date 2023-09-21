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
/* loaded from: classes7.dex */
public abstract class pt9 extends vt9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DetailInfoAndReplyFragment a;
    public BdTypeRecyclerView b;
    public lk9 c;
    public final List<om> d;
    public boolean e;
    public ArrayList<bn> f;
    public String g;
    public boolean h;
    public boolean i;
    public int j;
    public int k;
    public int l;
    public nn m;

    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
        }
    }

    public abstract void B(View.OnClickListener onClickListener);

    public abstract void C(View.OnClickListener onClickListener);

    public abstract void D(lk9 lk9Var);

    public void E(gm9 gm9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gm9Var) == null) {
        }
    }

    public abstract void F(lk9 lk9Var);

    public abstract void G(String str);

    public abstract ip9 f();

    public abstract bo9 g();

    public abstract PbFirstFloorCommentAndPraiseAdapter h();

    public abstract void m();

    public abstract void n();

    public abstract void o();

    public abstract void q(boolean z);

    public abstract void r(lk9 lk9Var, boolean z, String str, boolean z2);

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

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pt9 a;

        public a(pt9 pt9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pt9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pt9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                pt9 pt9Var = this.a;
                pt9Var.b.setData(pt9Var.f);
            }
        }
    }

    public pt9(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        if (detailInfoAndReplyFragment != null && detailInfoAndReplyFragment.b0() != null && detailInfoAndReplyFragment.b0().getArguments() != null) {
            this.j = detailInfoAndReplyFragment.b0().getArguments().getInt(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE);
        }
        this.b = bdTypeRecyclerView;
        this.m = new nn(bdTypeRecyclerView);
    }

    public void s(lk9 lk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, lk9Var) == null) {
            t(lk9Var, false);
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.e = z;
        }
    }

    public final void H() {
        lk9 lk9Var;
        yja yjaVar;
        yja yjaVar2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (lk9Var = this.c) == null || lk9Var.Z || lk9Var.a0 == 2) {
            return;
        }
        ArrayList<zja> F = lk9Var.F();
        ArrayList<yja> d = this.c.d();
        if (d != null && !d.isEmpty() && F != null && !F.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<yja> it = d.iterator();
            while (it.hasNext()) {
                yja next = it.next();
                if (next != null && next.E1() != null) {
                    sb.append(next.E1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<yja> it2 = d.iterator();
            while (it2.hasNext()) {
                yja next2 = it2.next();
                if (next2 != null) {
                    next2.o1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<yja> it3 = d.iterator();
            while (it3.hasNext()) {
                yja next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int h = next3.getAdvertAppInfo().h();
                    if (h != 0) {
                        v6a.j(next3, h);
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
                yja yjaVar3 = (yja) sparseArray.get(sparseArray.keyAt(i));
                if (yjaVar3 != null && (yjaVar2 = (yja) hashMap.put(yjaVar3.D1(), yjaVar3)) != null) {
                    v6a.j(yjaVar2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (yjaVar = (yja) entry.getValue()) != null) {
                    sparseArray.put(yjaVar.getPosition(), yjaVar);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                yja yjaVar4 = (yja) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                if (this.c.k() != null) {
                    yjaVar4.i1 = this.c.k().getId();
                }
                if (this.c.O() != null) {
                    yjaVar4.l1 = JavaTypesHelper.toLong(this.c.O().getId(), 0L);
                }
                lk9 lk9Var2 = this.c;
                if (lk9Var2 != null && lk9Var2.y() != null) {
                    yjaVar4.m1 = this.c.y().a();
                }
                c(yjaVar4);
                int position = yjaVar4.getPosition() + this.c.Y;
                if (position >= F.size()) {
                    yjaVar4.o1 = position;
                    v6a.k(yjaVar4, 2, position + i3, F.size());
                    return;
                }
                if (!this.e) {
                    position--;
                    yjaVar4.o1 = position;
                }
                if (position < 0) {
                    v6a.j(yjaVar4, 23);
                } else if (i(F, position)) {
                    v6a.j(yjaVar4, 1);
                } else {
                    F.add(position, yjaVar4);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", yjaVar4.getAdvertAppInfo().q);
                }
            }
        }
    }

    @Override // com.baidu.tieba.vt9
    public ArrayList<bn> a() {
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
            if (this.a.f0() != null) {
                return this.a.f0().U0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void c(yja yjaVar) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, yjaVar) == null) && yjaVar != null && this.c != null && yjaVar.getAdvertAppInfo() != null) {
            yjaVar.getAdvertAppInfo().i = new g15();
            if (this.c.y() != null) {
                yjaVar.getAdvertAppInfo().i.b = this.c.y().a();
            }
            yjaVar.getAdvertAppInfo().i.a = yjaVar.F1();
            if (this.c.k() != null && (k = this.c.k()) != null) {
                yjaVar.getAdvertAppInfo().i.c = k.getId();
                yjaVar.getAdvertAppInfo().i.d = k.getFirst_class();
                yjaVar.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                yjaVar.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            yjaVar.getAdvertAppInfo().i.g = yjaVar.getAdvertAppInfo().g;
            yjaVar.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean i(ArrayList<zja> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof yja) {
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
                if (this.f.get(i) instanceof al9) {
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

    public void t(lk9 lk9Var, boolean z) {
        yja yjaVar;
        zja zjaVar;
        boolean z2;
        lk9 lk9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048602, this, lk9Var, z) != null) || lk9Var == null) {
            return;
        }
        this.c = lk9Var;
        if (lk9Var != null && lk9Var.O() != null && lk9Var.O().getAuthor() != null) {
            this.g = lk9Var.O().getAuthor().getUserId();
        }
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        this.f.clear();
        Iterator<zja> it = lk9Var.F().iterator();
        while (true) {
            yjaVar = null;
            if (it.hasNext()) {
                zja next = it.next();
                if (next instanceof zja) {
                    zjaVar = next;
                    if (zjaVar.L() == 1) {
                        break;
                    }
                }
            } else {
                zjaVar = null;
                break;
            }
        }
        if (zjaVar == null && lk9Var.i() != null) {
            zjaVar = lk9Var.i();
        }
        if (zjaVar != null) {
            this.f.add(zjaVar);
        }
        F(lk9Var);
        G(this.g);
        int i = 0;
        if (!ListUtils.isEmpty(lk9Var.F()) && lk9Var.F().get(0) != null && lk9Var.O() != null) {
            lk9Var.O().setItem(lk9Var.F().get(0).X());
            lk9Var.O().setItemStar(lk9Var.F().get(0).Y());
        }
        if (lk9Var.O() != null && lk9Var.O().getRawThreadInfo() != null) {
            h45 h45Var = new h45();
            h45Var.t = lk9Var.O();
            h45Var.n = true;
            this.f.add(h45Var);
        }
        bl9 bl9Var = new bl9(lk9Var.O(), lk9Var.c());
        bl9Var.g(false);
        bl9Var.b = false;
        this.f.add(bl9Var);
        if (zjaVar != null && zjaVar.t0 != null && (lk9Var.k() == null || !TextUtils.equals(lk9Var.k().getName(), this.a.f0().Q0()) || !this.a.f0().W0())) {
            ok9 ok9Var = new ok9(zjaVar.t0);
            ok9Var.b = this.a.f0().L1();
            this.f.add(ok9Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && lk9Var.k() != null && !StringUtils.isNull(lk9Var.k().getName()) && (!TextUtils.equals(lk9Var.k().getName(), this.a.f0().Q0()) || !this.a.f0().W0())) {
            nk9 nk9Var = new nk9(lk9Var.k());
            nk9Var.g = this.a.f0().L1();
            nk9Var.e = false;
            this.f.add(nk9Var);
            bl9Var.g(false);
            bl9Var.b = false;
        }
        if (lk9Var.O() != null && !StringUtils.isNull(lk9Var.O().getForum_name())) {
            gl9 gl9Var = new gl9();
            gl9Var.a = lk9Var.O();
            this.f.add(gl9Var);
        } else if (lk9Var.O() != null && !StringUtils.isNull(lk9Var.m())) {
            lk9Var.O().setForum_name(lk9Var.m());
            gl9 gl9Var2 = new gl9();
            gl9Var2.a = lk9Var.O();
            this.f.add(gl9Var2);
        }
        if (k() && lk9Var.y() != null && lk9Var.y().c() == 1) {
            vk9 vk9Var = new vk9(vk9.c);
            vk9Var.b(true);
            this.f.add(vk9Var);
        }
        al9 al9Var = new al9(al9.g);
        al9Var.c = l();
        al9Var.b = lk9Var.g;
        al9Var.d = lk9Var.j0();
        al9Var.e = lk9Var.f;
        D(lk9Var);
        this.f.add(al9Var);
        if (lk9Var.J() == 4) {
            this.f.add(new zk9());
        }
        H();
        q(j());
        Iterator<zja> it2 = lk9Var.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            zja next2 = it2.next();
            if ((next2 instanceof zja) && next2.L() != 1) {
                this.f.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((lk9Var2 = this.c) == null || !lk9Var2.s()))) {
            xk9 xk9Var = new xk9();
            xk9Var.h1 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            xk9Var.g1 = R.drawable.new_pic_emotion_03;
            xk9Var.i1 = BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds74);
            this.f.add(xk9Var);
        }
        r(lk9Var, this.i, this.g, this.h);
        if (lk9Var.y().b() == 0) {
            lk9 lk9Var3 = this.c;
            if (lk9Var3 != null && lk9Var3.s()) {
                C(this.a.b0().P3());
                this.f.add(new uk9());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.c.l());
                statisticItem.param("fname", this.c.m());
                statisticItem.param("tid", this.c.Q());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                B(this.a.b0().P3());
                tk9 tk9Var = new tk9();
                tk9Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.f.add(tk9Var);
            }
            List<yja> a0 = lk9Var.a0();
            int i2 = -1;
            if (a0 != null && !a0.isEmpty()) {
                yjaVar = a0.get(0);
                i2 = yjaVar.getPosition();
            }
            if (!ListUtils.isEmpty(lk9Var.e())) {
                int i3 = 1;
                for (s15 s15Var : lk9Var.e()) {
                    if (a0 != null && i3 == i2) {
                        if (yjaVar != null) {
                            c(yjaVar);
                            this.f.add(yjaVar);
                            i++;
                            if (yjaVar.getType() != AdvertAppInfo.y) {
                                i3++;
                            }
                        }
                        if (i < a0.size()) {
                            yja yjaVar2 = a0.get(i);
                            yjaVar = yjaVar2;
                            i2 = yjaVar2.getPosition();
                        }
                    }
                    this.f.add(s15Var);
                    i3++;
                }
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.b;
        if (bdTypeRecyclerView != null) {
            if (this.m == null) {
                this.m = new nn(bdTypeRecyclerView);
            }
            this.m.e(new a(this));
        }
        p();
    }
}
