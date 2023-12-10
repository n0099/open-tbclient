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
/* loaded from: classes6.dex */
public abstract class j6a extends p6a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DetailInfoAndReplyFragment a;
    public BdTypeRecyclerView b;
    public aw9 c;
    public final List<ci> d;
    public boolean e;
    public ArrayList<pi> f;
    public String g;
    public boolean h;
    public boolean i;
    public int j;
    public boolean k;
    public int l;
    public int m;
    public bj n;

    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
        }
    }

    public abstract void B(View.OnClickListener onClickListener);

    public abstract void C(View.OnClickListener onClickListener);

    public abstract void D(aw9 aw9Var);

    public void E(ux9 ux9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ux9Var) == null) {
        }
    }

    public abstract void F(aw9 aw9Var);

    public abstract void G(String str);

    public abstract g1a f();

    public abstract yz9 g();

    public abstract PbFirstFloorCommentAndPraiseAdapter h();

    public abstract void m();

    public abstract void n();

    public abstract void o();

    public abstract void q(boolean z);

    public abstract void r(aw9 aw9Var, boolean z, String str, boolean z2);

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

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j6a a;

        public a(j6a j6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j6aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j6aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                j6a j6aVar = this.a;
                j6aVar.b.setData(j6aVar.f);
            }
        }
    }

    public j6a(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.k = false;
        this.l = -1;
        this.m = -1;
        this.a = detailInfoAndReplyFragment;
        if (detailInfoAndReplyFragment != null && detailInfoAndReplyFragment.h0() != null && detailInfoAndReplyFragment.h0().getArguments() != null) {
            this.j = detailInfoAndReplyFragment.h0().getArguments().getInt(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE);
            this.k = detailInfoAndReplyFragment.h0().getArguments().getBoolean("is_check_pre_floor");
        }
        this.b = bdTypeRecyclerView;
        this.n = new bj(bdTypeRecyclerView);
    }

    public void s(aw9 aw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, aw9Var) == null) {
            t(aw9Var, false);
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.e = z;
        }
    }

    public final void H() {
        aw9 aw9Var;
        mwa mwaVar;
        mwa mwaVar2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (aw9Var = this.c) == null || aw9Var.Z || aw9Var.a0 == 2) {
            return;
        }
        ArrayList<nwa> I = aw9Var.I();
        ArrayList<mwa> g = this.c.g();
        if (g != null && !g.isEmpty() && I != null && !I.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<mwa> it = g.iterator();
            while (it.hasNext()) {
                mwa next = it.next();
                if (next != null && next.I1() != null) {
                    sb.append(next.I1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<mwa> it2 = g.iterator();
            while (it2.hasNext()) {
                mwa next2 = it2.next();
                if (next2 != null) {
                    next2.q1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<mwa> it3 = g.iterator();
            while (it3.hasNext()) {
                mwa next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int h = next3.getAdvertAppInfo().h();
                    if (h != 0) {
                        lja.j(next3, h);
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
                mwa mwaVar3 = (mwa) sparseArray.get(sparseArray.keyAt(i));
                if (mwaVar3 != null && (mwaVar2 = (mwa) hashMap.put(mwaVar3.H1(), mwaVar3)) != null) {
                    lja.j(mwaVar2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (mwaVar = (mwa) entry.getValue()) != null) {
                    sparseArray.put(mwaVar.getPosition(), mwaVar);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                mwa mwaVar4 = (mwa) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                if (this.c.n() != null) {
                    mwaVar4.k1 = this.c.n().getId();
                }
                if (this.c.R() != null) {
                    mwaVar4.n1 = JavaTypesHelper.toLong(this.c.R().getId(), 0L);
                }
                aw9 aw9Var2 = this.c;
                if (aw9Var2 != null && aw9Var2.B() != null) {
                    mwaVar4.o1 = this.c.B().a();
                }
                c(mwaVar4);
                int position = mwaVar4.getPosition() + this.c.Y;
                if (position >= I.size()) {
                    mwaVar4.q1 = position;
                    lja.k(mwaVar4, 2, position + i3, I.size());
                    return;
                }
                if (!this.e) {
                    position--;
                    mwaVar4.q1 = position;
                }
                if (position < 0) {
                    lja.j(mwaVar4, 23);
                } else if (i(I, position)) {
                    lja.j(mwaVar4, 1);
                } else {
                    I.add(position, mwaVar4);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", mwaVar4.getAdvertAppInfo().q);
                }
            }
        }
    }

    @Override // com.baidu.tieba.p6a
    public ArrayList<pi> a() {
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
            return this.m;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (!this.k && 12 != this.j) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.a.l0() != null) {
                return this.a.l0().V0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void c(mwa mwaVar) {
        ForumData n;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, mwaVar) == null) && mwaVar != null && this.c != null && mwaVar.getAdvertAppInfo() != null) {
            mwaVar.getAdvertAppInfo().i = new kw4();
            if (this.c.B() != null) {
                mwaVar.getAdvertAppInfo().i.b = this.c.B().a();
            }
            mwaVar.getAdvertAppInfo().i.a = mwaVar.J1();
            if (this.c.n() != null && (n = this.c.n()) != null) {
                mwaVar.getAdvertAppInfo().i.c = n.getId();
                mwaVar.getAdvertAppInfo().i.d = n.getFirst_class();
                mwaVar.getAdvertAppInfo().i.e = n.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                mwaVar.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            mwaVar.getAdvertAppInfo().i.g = mwaVar.getAdvertAppInfo().g;
            mwaVar.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean i(ArrayList<nwa> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof mwa) {
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
                if (this.f.get(i) instanceof ow9) {
                    this.l = i;
                    z = true;
                }
            }
            if (!z) {
                this.l = -1;
            }
            this.m = -1;
        }
    }

    public void t(aw9 aw9Var, boolean z) {
        mwa mwaVar;
        nwa nwaVar;
        boolean z2;
        aw9 aw9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048602, this, aw9Var, z) != null) || aw9Var == null) {
            return;
        }
        this.c = aw9Var;
        if (aw9Var != null && aw9Var.R() != null && aw9Var.R().getAuthor() != null) {
            this.g = aw9Var.R().getAuthor().getUserId();
        }
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        this.f.clear();
        Iterator<nwa> it = aw9Var.I().iterator();
        while (true) {
            mwaVar = null;
            if (it.hasNext()) {
                nwa next = it.next();
                if (next instanceof nwa) {
                    nwaVar = next;
                    if (nwaVar.L() == 1) {
                        break;
                    }
                }
            } else {
                nwaVar = null;
                break;
            }
        }
        if (nwaVar == null && aw9Var.l() != null) {
            nwaVar = aw9Var.l();
        }
        if (nwaVar != null) {
            this.f.add(nwaVar);
        }
        F(aw9Var);
        G(this.g);
        int i = 0;
        if (!ListUtils.isEmpty(aw9Var.I()) && aw9Var.I().get(0) != null && aw9Var.R() != null) {
            aw9Var.R().setItem(aw9Var.I().get(0).X());
            aw9Var.R().setItemStar(aw9Var.I().get(0).Y());
        }
        if (aw9Var.R() != null && aw9Var.R().getRawThreadInfo() != null) {
            mz4 mz4Var = new mz4();
            mz4Var.t = aw9Var.R();
            mz4Var.n = true;
            this.f.add(mz4Var);
        }
        pw9 pw9Var = new pw9(aw9Var.R(), aw9Var.f());
        pw9Var.h(false);
        pw9Var.b = false;
        this.f.add(pw9Var);
        if (nwaVar != null && nwaVar.v0 != null && (aw9Var.n() == null || !TextUtils.equals(aw9Var.n().getName(), this.a.l0().R0()) || !this.a.l0().X0())) {
            dw9 dw9Var = new dw9(nwaVar.v0);
            dw9Var.b = this.a.l0().M1();
            this.f.add(dw9Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && aw9Var.n() != null && !StringUtils.isNull(aw9Var.n().getName()) && (!TextUtils.equals(aw9Var.n().getName(), this.a.l0().R0()) || !this.a.l0().X0())) {
            cw9 cw9Var = new cw9(aw9Var.n());
            cw9Var.g = this.a.l0().M1();
            cw9Var.e = false;
            this.f.add(cw9Var);
            pw9Var.h(false);
            pw9Var.b = false;
        }
        if (aw9Var.R() != null && !StringUtils.isNull(aw9Var.R().getForum_name())) {
            uw9 uw9Var = new uw9();
            uw9Var.a = aw9Var.R();
            this.f.add(uw9Var);
        } else if (aw9Var.R() != null && !StringUtils.isNull(aw9Var.p())) {
            aw9Var.R().setForum_name(aw9Var.p());
            uw9 uw9Var2 = new uw9();
            uw9Var2.a = aw9Var.R();
            this.f.add(uw9Var2);
        }
        if (j() && aw9Var.B() != null && aw9Var.B().c() == 1) {
            kw9 kw9Var = new kw9(kw9.c);
            kw9Var.b(true);
            this.f.add(kw9Var);
        }
        ow9 ow9Var = new ow9(ow9.g);
        ow9Var.c = l();
        ow9Var.b = aw9Var.g;
        ow9Var.d = aw9Var.a();
        ow9Var.e = aw9Var.f;
        D(aw9Var);
        this.f.add(ow9Var);
        if (aw9Var.M() == 4) {
            this.f.add(new nw9());
        }
        H();
        q(k());
        Iterator<nwa> it2 = aw9Var.I().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            nwa next2 = it2.next();
            if ((next2 instanceof nwa) && next2.L() != 1) {
                this.f.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((aw9Var2 = this.c) == null || !aw9Var2.v()))) {
            mw9 mw9Var = new mw9();
            mw9Var.j1 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            mw9Var.i1 = R.drawable.new_pic_emotion_03;
            mw9Var.k1 = BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds74);
            this.f.add(mw9Var);
        }
        r(aw9Var, this.i, this.g, this.h);
        if (aw9Var.B().b() == 0) {
            aw9 aw9Var3 = this.c;
            if (aw9Var3 != null && aw9Var3.v()) {
                C(this.a.h0().s4());
                this.f.add(new jw9());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.c.o());
                statisticItem.param("fname", this.c.p());
                statisticItem.param("tid", this.c.T());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                B(this.a.h0().s4());
                iw9 iw9Var = new iw9();
                iw9Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.f.add(iw9Var);
            }
            List<mwa> d0 = aw9Var.d0();
            int i2 = -1;
            if (d0 != null && !d0.isEmpty()) {
                mwaVar = d0.get(0);
                i2 = mwaVar.getPosition();
            }
            if (!ListUtils.isEmpty(aw9Var.h())) {
                int i3 = 1;
                for (xw4 xw4Var : aw9Var.h()) {
                    if (d0 != null && i3 == i2) {
                        if (mwaVar != null) {
                            c(mwaVar);
                            this.f.add(mwaVar);
                            i++;
                            if (mwaVar.getType() != AdvertAppInfo.z) {
                                i3++;
                            }
                        }
                        if (i < d0.size()) {
                            mwa mwaVar2 = d0.get(i);
                            mwaVar = mwaVar2;
                            i2 = mwaVar2.getPosition();
                        }
                    }
                    this.f.add(xw4Var);
                    i3++;
                }
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.b;
        if (bdTypeRecyclerView != null) {
            if (this.n == null) {
                this.n = new bj(bdTypeRecyclerView);
            }
            this.n.e(new a(this));
        }
        p();
    }
}
