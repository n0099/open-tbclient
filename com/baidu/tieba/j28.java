package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerAdapter;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbCommentFloatActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
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
/* loaded from: classes4.dex */
public abstract class j28 extends v28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public DetailInfoAndReplyFragment b;
    public BdTypeRecyclerView c;
    public vu7 d;
    public final List<qn> e;
    public boolean f;
    public ArrayList<Cdo> g;
    public String h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public int m;

    public j28(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.a = BdUniqueId.gen();
        this.e = new ArrayList();
        this.f = true;
        this.h = null;
        this.i = true;
        this.j = false;
        this.l = -1;
        this.m = -1;
        this.b = detailInfoAndReplyFragment;
        if (detailInfoAndReplyFragment != null && detailInfoAndReplyFragment.B() != null && detailInfoAndReplyFragment.B().getArguments() != null) {
            this.k = detailInfoAndReplyFragment.B().getArguments().getInt(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE);
        }
        this.c = bdTypeRecyclerView;
    }

    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
        }
    }

    public abstract void B(View.OnClickListener onClickListener);

    public abstract void C(View.OnClickListener onClickListener);

    public abstract void D(vu7 vu7Var);

    public void E(xv7 xv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, xv7Var) == null) {
        }
    }

    public abstract void F(vu7 vu7Var);

    public abstract void G(String str);

    public final void H() {
        vu7 vu7Var;
        um8 um8Var;
        um8 um8Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (vu7Var = this.d) == null || vu7Var.b0 || vu7Var.c0 == 2) {
            return;
        }
        ArrayList<PostData> F = vu7Var.F();
        ArrayList<um8> e = this.d.e();
        if (e == null || e.isEmpty() || F == null || F.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<um8> it = e.iterator();
        while (it.hasNext()) {
            um8 next = it.next();
            if (next != null && next.k1() != null) {
                sb.append(next.k1());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<um8> it2 = e.iterator();
        while (it2.hasNext()) {
            um8 next2 = it2.next();
            if (next2 != null) {
                next2.b1 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<um8> it3 = e.iterator();
        while (it3.hasNext()) {
            um8 next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int n = next3.getAdvertAppInfo().n();
                if (n != 0) {
                    ze8.j(next3, n);
                    if (n != 28 && n != 31) {
                        next3.getAdvertAppInfo().c = -1001;
                        Log.e("cq", "updateAppData，Data InValidate: " + n);
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < sparseArray.size(); i++) {
            um8 um8Var3 = (um8) sparseArray.get(sparseArray.keyAt(i));
            if (um8Var3 != null && (um8Var2 = (um8) hashMap.put(um8Var3.j1(), um8Var3)) != null) {
                ze8.j(um8Var2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (um8Var = (um8) entry.getValue()) != null) {
                sparseArray.put(um8Var.getPosition(), um8Var);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
        }
        Collections.sort(arrayList);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            um8 um8Var4 = (um8) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
            if (this.d.l() != null) {
                um8Var4.V0 = this.d.l().getId();
            }
            if (this.d.O() != null) {
                um8Var4.Y0 = dh.g(this.d.O().getId(), 0L);
            }
            vu7 vu7Var2 = this.d;
            if (vu7Var2 != null && vu7Var2.y() != null) {
                um8Var4.Z0 = this.d.y().a();
            }
            b(um8Var4);
            int position = um8Var4.getPosition() + this.d.a0;
            if (position >= F.size()) {
                um8Var4.b1 = position;
                ze8.k(um8Var4, 2, position + i3, F.size());
                return;
            }
            if (!this.f) {
                position--;
                um8Var4.b1 = position;
            }
            if (position < 0) {
                ze8.j(um8Var4, 23);
            } else if (h(F, position)) {
                ze8.j(um8Var4, 1);
            } else {
                F.add(position, um8Var4);
                TiebaStatic.eventStat(this.b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", um8Var4.getAdvertAppInfo().p);
            }
        }
    }

    @Override // com.baidu.tieba.v28
    public ArrayList<Cdo> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.g : (ArrayList) invokeV.objValue;
    }

    public final void b(um8 um8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, um8Var) == null) || um8Var == null || this.d == null || um8Var.getAdvertAppInfo() == null) {
            return;
        }
        um8Var.getAdvertAppInfo().i = new qq4();
        if (this.d.y() != null) {
            um8Var.getAdvertAppInfo().i.b = this.d.y().a();
        }
        um8Var.getAdvertAppInfo().i.a = um8Var.l1();
        if (this.d.l() != null && (l = this.d.l()) != null) {
            um8Var.getAdvertAppInfo().i.c = l.getId();
            um8Var.getAdvertAppInfo().i.d = l.getFirst_class();
            um8Var.getAdvertAppInfo().i.e = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            um8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        um8Var.getAdvertAppInfo().i.g = um8Var.getAdvertAppInfo().g;
        um8Var.getAdvertAppInfo().i.h = false;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.m : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : invokeV.intValue;
    }

    public abstract py7 e();

    public abstract kx7 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public final boolean h(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof um8) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? 12 == this.k : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.b.K() != null) {
                return this.b.K().v1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (this.c.getAdapter() instanceof BdRecyclerAdapter)) {
            this.c.getAdapter().notifyDataSetChanged();
        }
    }

    public abstract void m();

    public abstract void n();

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            boolean z = false;
            boolean z2 = false;
            for (int i = 0; i < this.g.size(); i++) {
                Cdo cdo = this.g.get(i);
                if (cdo instanceof iv7) {
                    this.l = i;
                    z = true;
                } else if ((cdo instanceof uu7) && ((uu7) cdo).a() == this.a) {
                    this.m = i;
                    z2 = true;
                }
            }
            if (!z) {
                this.l = -1;
            }
            if (z2) {
                return;
            }
            this.m = -1;
        }
    }

    public abstract void p(boolean z);

    public abstract void q(vu7 vu7Var, boolean z, String str, boolean z2);

    public void r(vu7 vu7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, vu7Var) == null) {
            s(vu7Var, false);
        }
    }

    public void s(vu7 vu7Var, boolean z) {
        um8 um8Var;
        PostData postData;
        boolean z2;
        vu7 vu7Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048602, this, vu7Var, z) == null) || vu7Var == null) {
            return;
        }
        this.d = vu7Var;
        if (vu7Var != null && vu7Var.O() != null && vu7Var.O().getAuthor() != null) {
            this.h = vu7Var.O().getAuthor().getUserId();
        }
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        this.g.clear();
        Iterator<PostData> it = vu7Var.F().iterator();
        while (true) {
            um8Var = null;
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if (next instanceof PostData) {
                postData = next;
                if (postData.C() == 1) {
                    break;
                }
            }
        }
        if (postData == null && vu7Var.j() != null) {
            postData = vu7Var.j();
        }
        if (postData != null) {
            this.g.add(postData);
        }
        F(vu7Var);
        G(this.h);
        int i = 0;
        if (!ListUtils.isEmpty(vu7Var.F()) && vu7Var.F().get(0) != null && vu7Var.O() != null) {
            vu7Var.O().setItem(vu7Var.F().get(0).P());
            vu7Var.O().setItemStar(vu7Var.F().get(0).Q());
        }
        if (vu7Var.O() != null && vu7Var.O().getRawThreadInfo() != null) {
            ot4 ot4Var = new ot4();
            ot4Var.t = vu7Var.O();
            ot4Var.n = true;
            this.g.add(ot4Var);
        }
        jv7 jv7Var = new jv7(vu7Var.O(), vu7Var.d());
        jv7Var.j(false);
        jv7Var.b = false;
        this.g.add(jv7Var);
        if (postData == null || postData.i0 == null || (vu7Var.l() != null && TextUtils.equals(vu7Var.l().getName(), this.b.K().r1()) && this.b.K().x1())) {
            z2 = false;
        } else {
            yu7 yu7Var = new yu7(postData.i0);
            yu7Var.b = this.b.K().m2();
            this.g.add(yu7Var);
            z2 = true;
        }
        if (!z2 && vu7Var.l() != null && !StringUtils.isNull(vu7Var.l().getName()) && (!TextUtils.equals(vu7Var.l().getName(), this.b.K().r1()) || !this.b.K().x1())) {
            xu7 xu7Var = new xu7(vu7Var.l());
            xu7Var.g = this.b.K().m2();
            xu7Var.e = false;
            this.g.add(xu7Var);
            jv7Var.j(false);
            jv7Var.b = false;
        }
        if (vu7Var.O() != null && !StringUtils.isNull(vu7Var.O().getForum_name())) {
            pv7 pv7Var = new pv7();
            pv7Var.a = vu7Var.O();
            this.g.add(pv7Var);
        } else if (vu7Var.O() != null && !StringUtils.isNull(vu7Var.n())) {
            vu7Var.O().setForum_name(vu7Var.n());
            pv7 pv7Var2 = new pv7();
            pv7Var2.a = vu7Var.O();
            this.g.add(pv7Var2);
        }
        if (j() && vu7Var.y() != null && vu7Var.y().c() == 1) {
            dv7 dv7Var = new dv7(dv7.c);
            dv7Var.b(true);
            this.g.add(dv7Var);
        }
        iv7 iv7Var = new iv7(iv7.i);
        ThreadData O = vu7Var.O();
        if (O != null) {
            O.getReply_num();
        }
        this.b.K().k2();
        iv7Var.d = k();
        iv7Var.c = vu7Var.g;
        vu7Var.c();
        iv7Var.e = vu7Var.i0();
        iv7Var.g = vu7Var.f;
        D(vu7Var);
        this.g.add(iv7Var);
        if (vu7Var.L() == 4) {
            this.g.add(new hv7());
        }
        H();
        p(i());
        Iterator<PostData> it2 = vu7Var.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.C() != 1) {
                this.g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((vu7Var2 = this.d) == null || !vu7Var2.t()))) {
            fv7 fv7Var = new fv7();
            fv7Var.U0 = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0ae1);
            fv7Var.T0 = R.drawable.new_pic_emotion_03;
            fv7Var.V0 = -2;
            fv7Var.W0 = ej.f(this.b.getContext(), R.dimen.tbds74);
            this.g.add(fv7Var);
        }
        q(vu7Var, this.j, this.h, this.i);
        if (vu7Var.y().b() == 0) {
            vu7 vu7Var3 = this.d;
            if (vu7Var3 != null && vu7Var3.t()) {
                C(this.b.B().P3());
                this.g.add(new cv7());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.d.m());
                statisticItem.param("fname", this.d.n());
                statisticItem.param("tid", this.d.Q());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                B(this.b.B().P3());
                bv7 bv7Var = new bv7();
                bv7Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09ff);
                this.g.add(bv7Var);
            }
            List<um8> Z = vu7Var.Z();
            int i2 = -1;
            if (Z != null && !Z.isEmpty()) {
                um8Var = Z.get(0);
                i2 = um8Var.getPosition();
            }
            if (!ListUtils.isEmpty(vu7Var.f())) {
                uu7 uu7Var = new uu7();
                uu7Var.f(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fdd));
                uu7Var.c(this.a);
                this.g.add(uu7Var);
                int i3 = 1;
                for (cr4 cr4Var : vu7Var.f()) {
                    if (Z != null && i3 == i2) {
                        if (um8Var != null) {
                            b(um8Var);
                            this.g.add(um8Var);
                            i++;
                            if (um8Var.getType() != AdvertAppInfo.x) {
                                i3++;
                            }
                        }
                        if (i < Z.size()) {
                            um8 um8Var2 = Z.get(i);
                            um8Var = um8Var2;
                            i2 = um8Var2.getPosition();
                        }
                    }
                    this.g.add(cr4Var);
                    i3++;
                    if (i3 == 4 && vu7Var.C() != null) {
                        this.g.add(vu7Var.C());
                        i3++;
                    }
                }
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setData(this.g);
        }
        o();
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.j = z;
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.f = z;
        }
    }

    public void v(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onClickListener) == null) {
        }
    }

    public abstract void w(boolean z);

    public void x(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, yVar) == null) {
        }
    }

    public void y(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onLongClickListener) == null) {
        }
    }

    public void z(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, fVar) == null) {
        }
    }
}
