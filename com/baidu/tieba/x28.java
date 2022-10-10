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
/* loaded from: classes6.dex */
public abstract class x28 extends j38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public DetailInfoAndReplyFragment b;
    public BdTypeRecyclerView c;
    public jv7 d;
    public final List<qn> e;
    public boolean f;
    public ArrayList<Cdo> g;
    public String h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public int m;

    public x28(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public abstract void D(jv7 jv7Var);

    public void E(lw7 lw7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, lw7Var) == null) {
        }
    }

    public abstract void F(jv7 jv7Var);

    public abstract void G(String str);

    public final void H() {
        jv7 jv7Var;
        jn8 jn8Var;
        jn8 jn8Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (jv7Var = this.d) == null || jv7Var.b0 || jv7Var.c0 == 2) {
            return;
        }
        ArrayList<PostData> F = jv7Var.F();
        ArrayList<jn8> e = this.d.e();
        if (e == null || e.isEmpty() || F == null || F.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<jn8> it = e.iterator();
        while (it.hasNext()) {
            jn8 next = it.next();
            if (next != null && next.k1() != null) {
                sb.append(next.k1());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<jn8> it2 = e.iterator();
        while (it2.hasNext()) {
            jn8 next2 = it2.next();
            if (next2 != null) {
                next2.c1 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<jn8> it3 = e.iterator();
        while (it3.hasNext()) {
            jn8 next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int n = next3.getAdvertAppInfo().n();
                if (n != 0) {
                    of8.j(next3, n);
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
            jn8 jn8Var3 = (jn8) sparseArray.get(sparseArray.keyAt(i));
            if (jn8Var3 != null && (jn8Var2 = (jn8) hashMap.put(jn8Var3.j1(), jn8Var3)) != null) {
                of8.j(jn8Var2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (jn8Var = (jn8) entry.getValue()) != null) {
                sparseArray.put(jn8Var.getPosition(), jn8Var);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
        }
        Collections.sort(arrayList);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            jn8 jn8Var4 = (jn8) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
            if (this.d.l() != null) {
                jn8Var4.W0 = this.d.l().getId();
            }
            if (this.d.O() != null) {
                jn8Var4.Z0 = dh.g(this.d.O().getId(), 0L);
            }
            jv7 jv7Var2 = this.d;
            if (jv7Var2 != null && jv7Var2.y() != null) {
                jn8Var4.a1 = this.d.y().a();
            }
            b(jn8Var4);
            int position = jn8Var4.getPosition() + this.d.a0;
            if (position >= F.size()) {
                jn8Var4.c1 = position;
                of8.k(jn8Var4, 2, position + i3, F.size());
                return;
            }
            if (!this.f) {
                position--;
                jn8Var4.c1 = position;
            }
            if (position < 0) {
                of8.j(jn8Var4, 23);
            } else if (h(F, position)) {
                of8.j(jn8Var4, 1);
            } else {
                F.add(position, jn8Var4);
                TiebaStatic.eventStat(this.b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", jn8Var4.getAdvertAppInfo().p);
            }
        }
    }

    @Override // com.baidu.tieba.j38
    public ArrayList<Cdo> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.g : (ArrayList) invokeV.objValue;
    }

    public final void b(jn8 jn8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, jn8Var) == null) || jn8Var == null || this.d == null || jn8Var.getAdvertAppInfo() == null) {
            return;
        }
        jn8Var.getAdvertAppInfo().i = new dr4();
        if (this.d.y() != null) {
            jn8Var.getAdvertAppInfo().i.b = this.d.y().a();
        }
        jn8Var.getAdvertAppInfo().i.a = jn8Var.l1();
        if (this.d.l() != null && (l = this.d.l()) != null) {
            jn8Var.getAdvertAppInfo().i.c = l.getId();
            jn8Var.getAdvertAppInfo().i.d = l.getFirst_class();
            jn8Var.getAdvertAppInfo().i.e = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            jn8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        jn8Var.getAdvertAppInfo().i.g = jn8Var.getAdvertAppInfo().g;
        jn8Var.getAdvertAppInfo().i.h = false;
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

    public abstract dz7 e();

    public abstract yx7 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public final boolean h(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof jn8) {
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
                if (cdo instanceof wv7) {
                    this.l = i;
                    z = true;
                } else if ((cdo instanceof iv7) && ((iv7) cdo).a() == this.a) {
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

    public abstract void q(jv7 jv7Var, boolean z, String str, boolean z2);

    public void r(jv7 jv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, jv7Var) == null) {
            s(jv7Var, false);
        }
    }

    public void s(jv7 jv7Var, boolean z) {
        jn8 jn8Var;
        PostData postData;
        boolean z2;
        jv7 jv7Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048602, this, jv7Var, z) == null) || jv7Var == null) {
            return;
        }
        this.d = jv7Var;
        if (jv7Var != null && jv7Var.O() != null && jv7Var.O().getAuthor() != null) {
            this.h = jv7Var.O().getAuthor().getUserId();
        }
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        this.g.clear();
        Iterator<PostData> it = jv7Var.F().iterator();
        while (true) {
            jn8Var = null;
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
        if (postData == null && jv7Var.j() != null) {
            postData = jv7Var.j();
        }
        if (postData != null) {
            this.g.add(postData);
        }
        F(jv7Var);
        G(this.h);
        int i = 0;
        if (!ListUtils.isEmpty(jv7Var.F()) && jv7Var.F().get(0) != null && jv7Var.O() != null) {
            jv7Var.O().setItem(jv7Var.F().get(0).P());
            jv7Var.O().setItemStar(jv7Var.F().get(0).Q());
        }
        if (jv7Var.O() != null && jv7Var.O().getRawThreadInfo() != null) {
            bu4 bu4Var = new bu4();
            bu4Var.t = jv7Var.O();
            bu4Var.n = true;
            this.g.add(bu4Var);
        }
        xv7 xv7Var = new xv7(jv7Var.O(), jv7Var.d());
        xv7Var.j(false);
        xv7Var.b = false;
        this.g.add(xv7Var);
        if (postData == null || postData.j0 == null || (jv7Var.l() != null && TextUtils.equals(jv7Var.l().getName(), this.b.K().r1()) && this.b.K().x1())) {
            z2 = false;
        } else {
            mv7 mv7Var = new mv7(postData.j0);
            mv7Var.b = this.b.K().m2();
            this.g.add(mv7Var);
            z2 = true;
        }
        if (!z2 && jv7Var.l() != null && !StringUtils.isNull(jv7Var.l().getName()) && (!TextUtils.equals(jv7Var.l().getName(), this.b.K().r1()) || !this.b.K().x1())) {
            lv7 lv7Var = new lv7(jv7Var.l());
            lv7Var.g = this.b.K().m2();
            lv7Var.e = false;
            this.g.add(lv7Var);
            xv7Var.j(false);
            xv7Var.b = false;
        }
        if (jv7Var.O() != null && !StringUtils.isNull(jv7Var.O().getForum_name())) {
            dw7 dw7Var = new dw7();
            dw7Var.a = jv7Var.O();
            this.g.add(dw7Var);
        } else if (jv7Var.O() != null && !StringUtils.isNull(jv7Var.n())) {
            jv7Var.O().setForum_name(jv7Var.n());
            dw7 dw7Var2 = new dw7();
            dw7Var2.a = jv7Var.O();
            this.g.add(dw7Var2);
        }
        if (j() && jv7Var.y() != null && jv7Var.y().c() == 1) {
            rv7 rv7Var = new rv7(rv7.c);
            rv7Var.b(true);
            this.g.add(rv7Var);
        }
        wv7 wv7Var = new wv7(wv7.i);
        ThreadData O = jv7Var.O();
        if (O != null) {
            O.getReply_num();
        }
        this.b.K().k2();
        wv7Var.d = k();
        wv7Var.c = jv7Var.g;
        jv7Var.c();
        wv7Var.e = jv7Var.i0();
        wv7Var.g = jv7Var.f;
        D(jv7Var);
        this.g.add(wv7Var);
        if (jv7Var.L() == 4) {
            this.g.add(new vv7());
        }
        H();
        p(i());
        Iterator<PostData> it2 = jv7Var.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.C() != 1) {
                this.g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((jv7Var2 = this.d) == null || !jv7Var2.t()))) {
            tv7 tv7Var = new tv7();
            tv7Var.V0 = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0ae1);
            tv7Var.U0 = R.drawable.new_pic_emotion_03;
            tv7Var.W0 = -2;
            tv7Var.X0 = ej.f(this.b.getContext(), R.dimen.tbds74);
            this.g.add(tv7Var);
        }
        q(jv7Var, this.j, this.h, this.i);
        if (jv7Var.y().b() == 0) {
            jv7 jv7Var3 = this.d;
            if (jv7Var3 != null && jv7Var3.t()) {
                C(this.b.B().P3());
                this.g.add(new qv7());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.d.m());
                statisticItem.param("fname", this.d.n());
                statisticItem.param("tid", this.d.Q());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                B(this.b.B().P3());
                pv7 pv7Var = new pv7();
                pv7Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09ff);
                this.g.add(pv7Var);
            }
            List<jn8> Z = jv7Var.Z();
            int i2 = -1;
            if (Z != null && !Z.isEmpty()) {
                jn8Var = Z.get(0);
                i2 = jn8Var.getPosition();
            }
            if (!ListUtils.isEmpty(jv7Var.f())) {
                iv7 iv7Var = new iv7();
                iv7Var.f(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fde));
                iv7Var.c(this.a);
                this.g.add(iv7Var);
                int i3 = 1;
                for (pr4 pr4Var : jv7Var.f()) {
                    if (Z != null && i3 == i2) {
                        if (jn8Var != null) {
                            b(jn8Var);
                            this.g.add(jn8Var);
                            i++;
                            if (jn8Var.getType() != AdvertAppInfo.x) {
                                i3++;
                            }
                        }
                        if (i < Z.size()) {
                            jn8 jn8Var2 = Z.get(i);
                            jn8Var = jn8Var2;
                            i2 = jn8Var2.getPosition();
                        }
                    }
                    this.g.add(pr4Var);
                    i3++;
                    if (i3 == 4 && jv7Var.C() != null) {
                        this.g.add(jv7Var.C());
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
