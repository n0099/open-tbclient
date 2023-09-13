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
public abstract class sr9 extends yr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DetailInfoAndReplyFragment a;
    public BdTypeRecyclerView b;
    public aj9 c;
    public final List<pm> d;
    public boolean e;
    public ArrayList<cn> f;
    public String g;
    public boolean h;
    public boolean i;
    public int j;
    public int k;
    public int l;
    public on m;

    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
        }
    }

    public abstract void B(View.OnClickListener onClickListener);

    public abstract void C(View.OnClickListener onClickListener);

    public abstract void D(aj9 aj9Var);

    public void E(vk9 vk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, vk9Var) == null) {
        }
    }

    public abstract void F(aj9 aj9Var);

    public abstract void G(String str);

    public abstract pn9 f();

    public abstract jm9 g();

    public abstract PbFirstFloorCommentAndPraiseAdapter h();

    public abstract void m();

    public abstract void n();

    public abstract void o();

    public abstract void q(boolean z);

    public abstract void r(aj9 aj9Var, boolean z, String str, boolean z2);

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
        public final /* synthetic */ sr9 a;

        public a(sr9 sr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sr9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                sr9 sr9Var = this.a;
                sr9Var.b.setData(sr9Var.f);
            }
        }
    }

    public sr9(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        if (detailInfoAndReplyFragment != null && detailInfoAndReplyFragment.S() != null && detailInfoAndReplyFragment.S().getArguments() != null) {
            this.j = detailInfoAndReplyFragment.S().getArguments().getInt(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE);
        }
        this.b = bdTypeRecyclerView;
        this.m = new on(bdTypeRecyclerView);
    }

    public void s(aj9 aj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, aj9Var) == null) {
            t(aj9Var, false);
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.e = z;
        }
    }

    public final void H() {
        aj9 aj9Var;
        sha shaVar;
        sha shaVar2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (aj9Var = this.c) == null || aj9Var.Z || aj9Var.a0 == 2) {
            return;
        }
        ArrayList<tha> F = aj9Var.F();
        ArrayList<sha> d = this.c.d();
        if (d != null && !d.isEmpty() && F != null && !F.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<sha> it = d.iterator();
            while (it.hasNext()) {
                sha next = it.next();
                if (next != null && next.E1() != null) {
                    sb.append(next.E1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<sha> it2 = d.iterator();
            while (it2.hasNext()) {
                sha next2 = it2.next();
                if (next2 != null) {
                    next2.o1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<sha> it3 = d.iterator();
            while (it3.hasNext()) {
                sha next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int h = next3.getAdvertAppInfo().h();
                    if (h != 0) {
                        x4a.j(next3, h);
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
                sha shaVar3 = (sha) sparseArray.get(sparseArray.keyAt(i));
                if (shaVar3 != null && (shaVar2 = (sha) hashMap.put(shaVar3.D1(), shaVar3)) != null) {
                    x4a.j(shaVar2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (shaVar = (sha) entry.getValue()) != null) {
                    sparseArray.put(shaVar.getPosition(), shaVar);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                sha shaVar4 = (sha) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                if (this.c.k() != null) {
                    shaVar4.i1 = this.c.k().getId();
                }
                if (this.c.O() != null) {
                    shaVar4.l1 = JavaTypesHelper.toLong(this.c.O().getId(), 0L);
                }
                aj9 aj9Var2 = this.c;
                if (aj9Var2 != null && aj9Var2.y() != null) {
                    shaVar4.m1 = this.c.y().a();
                }
                c(shaVar4);
                int position = shaVar4.getPosition() + this.c.Y;
                if (position >= F.size()) {
                    shaVar4.o1 = position;
                    x4a.k(shaVar4, 2, position + i3, F.size());
                    return;
                }
                if (!this.e) {
                    position--;
                    shaVar4.o1 = position;
                }
                if (position < 0) {
                    x4a.j(shaVar4, 23);
                } else if (i(F, position)) {
                    x4a.j(shaVar4, 1);
                } else {
                    F.add(position, shaVar4);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", shaVar4.getAdvertAppInfo().q);
                }
            }
        }
    }

    @Override // com.baidu.tieba.yr9
    public ArrayList<cn> a() {
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
            if (this.a.X() != null) {
                return this.a.X().U0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void c(sha shaVar) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, shaVar) == null) && shaVar != null && this.c != null && shaVar.getAdvertAppInfo() != null) {
            shaVar.getAdvertAppInfo().i = new g15();
            if (this.c.y() != null) {
                shaVar.getAdvertAppInfo().i.b = this.c.y().a();
            }
            shaVar.getAdvertAppInfo().i.a = shaVar.F1();
            if (this.c.k() != null && (k = this.c.k()) != null) {
                shaVar.getAdvertAppInfo().i.c = k.getId();
                shaVar.getAdvertAppInfo().i.d = k.getFirst_class();
                shaVar.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                shaVar.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            shaVar.getAdvertAppInfo().i.g = shaVar.getAdvertAppInfo().g;
            shaVar.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean i(ArrayList<tha> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof sha) {
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
                if (this.f.get(i) instanceof pj9) {
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

    public void t(aj9 aj9Var, boolean z) {
        sha shaVar;
        tha thaVar;
        boolean z2;
        aj9 aj9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048602, this, aj9Var, z) != null) || aj9Var == null) {
            return;
        }
        this.c = aj9Var;
        if (aj9Var != null && aj9Var.O() != null && aj9Var.O().getAuthor() != null) {
            this.g = aj9Var.O().getAuthor().getUserId();
        }
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        this.f.clear();
        Iterator<tha> it = aj9Var.F().iterator();
        while (true) {
            shaVar = null;
            if (it.hasNext()) {
                tha next = it.next();
                if (next instanceof tha) {
                    thaVar = next;
                    if (thaVar.L() == 1) {
                        break;
                    }
                }
            } else {
                thaVar = null;
                break;
            }
        }
        if (thaVar == null && aj9Var.i() != null) {
            thaVar = aj9Var.i();
        }
        if (thaVar != null) {
            this.f.add(thaVar);
        }
        F(aj9Var);
        G(this.g);
        int i = 0;
        if (!ListUtils.isEmpty(aj9Var.F()) && aj9Var.F().get(0) != null && aj9Var.O() != null) {
            aj9Var.O().setItem(aj9Var.F().get(0).X());
            aj9Var.O().setItemStar(aj9Var.F().get(0).Y());
        }
        if (aj9Var.O() != null && aj9Var.O().getRawThreadInfo() != null) {
            h45 h45Var = new h45();
            h45Var.t = aj9Var.O();
            h45Var.n = true;
            this.f.add(h45Var);
        }
        qj9 qj9Var = new qj9(aj9Var.O(), aj9Var.c());
        qj9Var.g(false);
        qj9Var.b = false;
        this.f.add(qj9Var);
        if (thaVar != null && thaVar.t0 != null && (aj9Var.k() == null || !TextUtils.equals(aj9Var.k().getName(), this.a.X().Q0()) || !this.a.X().W0())) {
            dj9 dj9Var = new dj9(thaVar.t0);
            dj9Var.b = this.a.X().L1();
            this.f.add(dj9Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && aj9Var.k() != null && !StringUtils.isNull(aj9Var.k().getName()) && (!TextUtils.equals(aj9Var.k().getName(), this.a.X().Q0()) || !this.a.X().W0())) {
            cj9 cj9Var = new cj9(aj9Var.k());
            cj9Var.g = this.a.X().L1();
            cj9Var.e = false;
            this.f.add(cj9Var);
            qj9Var.g(false);
            qj9Var.b = false;
        }
        if (aj9Var.O() != null && !StringUtils.isNull(aj9Var.O().getForum_name())) {
            vj9 vj9Var = new vj9();
            vj9Var.a = aj9Var.O();
            this.f.add(vj9Var);
        } else if (aj9Var.O() != null && !StringUtils.isNull(aj9Var.m())) {
            aj9Var.O().setForum_name(aj9Var.m());
            vj9 vj9Var2 = new vj9();
            vj9Var2.a = aj9Var.O();
            this.f.add(vj9Var2);
        }
        if (k() && aj9Var.y() != null && aj9Var.y().c() == 1) {
            kj9 kj9Var = new kj9(kj9.c);
            kj9Var.b(true);
            this.f.add(kj9Var);
        }
        pj9 pj9Var = new pj9(pj9.g);
        pj9Var.c = l();
        pj9Var.b = aj9Var.g;
        pj9Var.d = aj9Var.j0();
        pj9Var.e = aj9Var.f;
        D(aj9Var);
        this.f.add(pj9Var);
        if (aj9Var.J() == 4) {
            this.f.add(new oj9());
        }
        H();
        q(j());
        Iterator<tha> it2 = aj9Var.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            tha next2 = it2.next();
            if ((next2 instanceof tha) && next2.L() != 1) {
                this.f.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((aj9Var2 = this.c) == null || !aj9Var2.s()))) {
            mj9 mj9Var = new mj9();
            mj9Var.h1 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            mj9Var.g1 = R.drawable.new_pic_emotion_03;
            mj9Var.i1 = BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds74);
            this.f.add(mj9Var);
        }
        r(aj9Var, this.i, this.g, this.h);
        if (aj9Var.y().b() == 0) {
            aj9 aj9Var3 = this.c;
            if (aj9Var3 != null && aj9Var3.s()) {
                C(this.a.S().J3());
                this.f.add(new jj9());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.c.l());
                statisticItem.param("fname", this.c.m());
                statisticItem.param("tid", this.c.Q());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                B(this.a.S().J3());
                ij9 ij9Var = new ij9();
                ij9Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.f.add(ij9Var);
            }
            List<sha> a0 = aj9Var.a0();
            int i2 = -1;
            if (a0 != null && !a0.isEmpty()) {
                shaVar = a0.get(0);
                i2 = shaVar.getPosition();
            }
            if (!ListUtils.isEmpty(aj9Var.e())) {
                int i3 = 1;
                for (s15 s15Var : aj9Var.e()) {
                    if (a0 != null && i3 == i2) {
                        if (shaVar != null) {
                            c(shaVar);
                            this.f.add(shaVar);
                            i++;
                            if (shaVar.getType() != AdvertAppInfo.y) {
                                i3++;
                            }
                        }
                        if (i < a0.size()) {
                            sha shaVar2 = a0.get(i);
                            shaVar = shaVar2;
                            i2 = shaVar2.getPosition();
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
                this.m = new on(bdTypeRecyclerView);
            }
            this.m.e(new a(this));
        }
        p();
    }
}
