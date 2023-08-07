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
public abstract class vl9 extends bm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DetailInfoAndReplyFragment a;
    public BdTypeRecyclerView b;
    public sd9 c;
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

    public abstract void D(sd9 sd9Var);

    public void E(ze9 ze9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ze9Var) == null) {
        }
    }

    public abstract void F(sd9 sd9Var);

    public abstract void G(String str);

    public abstract th9 f();

    public abstract ng9 g();

    public abstract PbFirstFloorCommentAndPraiseAdapter h();

    public abstract void m();

    public abstract void n();

    public abstract void o();

    public abstract void q(boolean z);

    public abstract void r(sd9 sd9Var, boolean z, String str, boolean z2);

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
        public final /* synthetic */ vl9 a;

        public a(vl9 vl9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vl9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                vl9 vl9Var = this.a;
                vl9Var.b.setData(vl9Var.f);
            }
        }
    }

    public vl9(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void s(sd9 sd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, sd9Var) == null) {
            t(sd9Var, false);
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.e = z;
        }
    }

    public final void H() {
        sd9 sd9Var;
        pba pbaVar;
        pba pbaVar2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (sd9Var = this.c) == null || sd9Var.Z || sd9Var.a0 == 2) {
            return;
        }
        ArrayList<qba> F = sd9Var.F();
        ArrayList<pba> d = this.c.d();
        if (d != null && !d.isEmpty() && F != null && !F.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<pba> it = d.iterator();
            while (it.hasNext()) {
                pba next = it.next();
                if (next != null && next.A1() != null) {
                    sb.append(next.A1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<pba> it2 = d.iterator();
            while (it2.hasNext()) {
                pba next2 = it2.next();
                if (next2 != null) {
                    next2.n1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<pba> it3 = d.iterator();
            while (it3.hasNext()) {
                pba next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int h = next3.getAdvertAppInfo().h();
                    if (h != 0) {
                        az9.j(next3, h);
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
                pba pbaVar3 = (pba) sparseArray.get(sparseArray.keyAt(i));
                if (pbaVar3 != null && (pbaVar2 = (pba) hashMap.put(pbaVar3.z1(), pbaVar3)) != null) {
                    az9.j(pbaVar2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (pbaVar = (pba) entry.getValue()) != null) {
                    sparseArray.put(pbaVar.getPosition(), pbaVar);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                pba pbaVar4 = (pba) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                if (this.c.k() != null) {
                    pbaVar4.h1 = this.c.k().getId();
                }
                if (this.c.O() != null) {
                    pbaVar4.k1 = JavaTypesHelper.toLong(this.c.O().getId(), 0L);
                }
                sd9 sd9Var2 = this.c;
                if (sd9Var2 != null && sd9Var2.y() != null) {
                    pbaVar4.l1 = this.c.y().a();
                }
                c(pbaVar4);
                int position = pbaVar4.getPosition() + this.c.Y;
                if (position >= F.size()) {
                    pbaVar4.n1 = position;
                    az9.k(pbaVar4, 2, position + i3, F.size());
                    return;
                }
                if (!this.e) {
                    position--;
                    pbaVar4.n1 = position;
                }
                if (position < 0) {
                    az9.j(pbaVar4, 23);
                } else if (i(F, position)) {
                    az9.j(pbaVar4, 1);
                } else {
                    F.add(position, pbaVar4);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", pbaVar4.getAdvertAppInfo().q);
                }
            }
        }
    }

    @Override // com.baidu.tieba.bm9
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
                return this.a.R().U0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void c(pba pbaVar) {
        ForumData k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, pbaVar) == null) && pbaVar != null && this.c != null && pbaVar.getAdvertAppInfo() != null) {
            pbaVar.getAdvertAppInfo().i = new v05();
            if (this.c.y() != null) {
                pbaVar.getAdvertAppInfo().i.b = this.c.y().a();
            }
            pbaVar.getAdvertAppInfo().i.a = pbaVar.B1();
            if (this.c.k() != null && (k = this.c.k()) != null) {
                pbaVar.getAdvertAppInfo().i.c = k.getId();
                pbaVar.getAdvertAppInfo().i.d = k.getFirst_class();
                pbaVar.getAdvertAppInfo().i.e = k.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                pbaVar.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            pbaVar.getAdvertAppInfo().i.g = pbaVar.getAdvertAppInfo().g;
            pbaVar.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean i(ArrayList<qba> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof pba) {
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
                if (this.f.get(i) instanceof he9) {
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

    public void t(sd9 sd9Var, boolean z) {
        pba pbaVar;
        qba qbaVar;
        boolean z2;
        sd9 sd9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048602, this, sd9Var, z) != null) || sd9Var == null) {
            return;
        }
        this.c = sd9Var;
        if (sd9Var != null && sd9Var.O() != null && sd9Var.O().getAuthor() != null) {
            this.g = sd9Var.O().getAuthor().getUserId();
        }
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        this.f.clear();
        Iterator<qba> it = sd9Var.F().iterator();
        while (true) {
            pbaVar = null;
            if (it.hasNext()) {
                qba next = it.next();
                if (next instanceof qba) {
                    qbaVar = next;
                    if (qbaVar.I() == 1) {
                        break;
                    }
                }
            } else {
                qbaVar = null;
                break;
            }
        }
        if (qbaVar == null && sd9Var.i() != null) {
            qbaVar = sd9Var.i();
        }
        if (qbaVar != null) {
            this.f.add(qbaVar);
        }
        F(sd9Var);
        G(this.g);
        int i = 0;
        if (!ListUtils.isEmpty(sd9Var.F()) && sd9Var.F().get(0) != null && sd9Var.O() != null) {
            sd9Var.O().setItem(sd9Var.F().get(0).W());
            sd9Var.O().setItemStar(sd9Var.F().get(0).X());
        }
        if (sd9Var.O() != null && sd9Var.O().getRawThreadInfo() != null) {
            w35 w35Var = new w35();
            w35Var.t = sd9Var.O();
            w35Var.n = true;
            this.f.add(w35Var);
        }
        ie9 ie9Var = new ie9(sd9Var.O(), sd9Var.c());
        ie9Var.g(false);
        ie9Var.b = false;
        this.f.add(ie9Var);
        if (qbaVar != null && qbaVar.s0 != null && (sd9Var.k() == null || !TextUtils.equals(sd9Var.k().getName(), this.a.R().Q0()) || !this.a.R().W0())) {
            vd9 vd9Var = new vd9(qbaVar.s0);
            vd9Var.b = this.a.R().K1();
            this.f.add(vd9Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && sd9Var.k() != null && !StringUtils.isNull(sd9Var.k().getName()) && (!TextUtils.equals(sd9Var.k().getName(), this.a.R().Q0()) || !this.a.R().W0())) {
            ud9 ud9Var = new ud9(sd9Var.k());
            ud9Var.g = this.a.R().K1();
            ud9Var.e = false;
            this.f.add(ud9Var);
            ie9Var.g(false);
            ie9Var.b = false;
        }
        if (sd9Var.O() != null && !StringUtils.isNull(sd9Var.O().getForum_name())) {
            ne9 ne9Var = new ne9();
            ne9Var.a = sd9Var.O();
            this.f.add(ne9Var);
        } else if (sd9Var.O() != null && !StringUtils.isNull(sd9Var.m())) {
            sd9Var.O().setForum_name(sd9Var.m());
            ne9 ne9Var2 = new ne9();
            ne9Var2.a = sd9Var.O();
            this.f.add(ne9Var2);
        }
        if (k() && sd9Var.y() != null && sd9Var.y().c() == 1) {
            ce9 ce9Var = new ce9(ce9.c);
            ce9Var.b(true);
            this.f.add(ce9Var);
        }
        he9 he9Var = new he9(he9.g);
        he9Var.c = l();
        he9Var.b = sd9Var.g;
        he9Var.d = sd9Var.j0();
        he9Var.e = sd9Var.f;
        D(sd9Var);
        this.f.add(he9Var);
        if (sd9Var.J() == 4) {
            this.f.add(new ge9());
        }
        H();
        q(j());
        Iterator<qba> it2 = sd9Var.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            qba next2 = it2.next();
            if ((next2 instanceof qba) && next2.I() != 1) {
                this.f.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((sd9Var2 = this.c) == null || !sd9Var2.s()))) {
            ee9 ee9Var = new ee9();
            ee9Var.g1 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            ee9Var.f1 = R.drawable.new_pic_emotion_03;
            ee9Var.h1 = BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds74);
            this.f.add(ee9Var);
        }
        r(sd9Var, this.i, this.g, this.h);
        if (sd9Var.y().b() == 0) {
            sd9 sd9Var3 = this.c;
            if (sd9Var3 != null && sd9Var3.s()) {
                C(this.a.O().v3());
                this.f.add(new be9());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.c.l());
                statisticItem.param("fname", this.c.m());
                statisticItem.param("tid", this.c.Q());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                B(this.a.O().v3());
                ae9 ae9Var = new ae9();
                ae9Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.f.add(ae9Var);
            }
            List<pba> a0 = sd9Var.a0();
            int i2 = -1;
            if (a0 != null && !a0.isEmpty()) {
                pbaVar = a0.get(0);
                i2 = pbaVar.getPosition();
            }
            if (!ListUtils.isEmpty(sd9Var.e())) {
                int i3 = 1;
                for (h15 h15Var : sd9Var.e()) {
                    if (a0 != null && i3 == i2) {
                        if (pbaVar != null) {
                            c(pbaVar);
                            this.f.add(pbaVar);
                            i++;
                            if (pbaVar.getType() != AdvertAppInfo.y) {
                                i3++;
                            }
                        }
                        if (i < a0.size()) {
                            pba pbaVar2 = a0.get(i);
                            pbaVar = pbaVar2;
                            i2 = pbaVar2.getPosition();
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
