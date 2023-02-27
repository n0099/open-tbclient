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
public abstract class xk8 extends jl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public DetailInfoAndReplyFragment b;
    public BdTypeRecyclerView c;
    public hd8 d;
    public final List<qn> e;
    public boolean f;
    public ArrayList<Cdo> g;
    public String h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public int m;

    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
        }
    }

    public abstract void B(View.OnClickListener onClickListener);

    public abstract void C(View.OnClickListener onClickListener);

    public abstract void D(hd8 hd8Var);

    public void E(je8 je8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, je8Var) == null) {
        }
    }

    public abstract void F(hd8 hd8Var);

    public abstract void G(String str);

    public abstract bh8 e();

    public abstract wf8 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public abstract void m();

    public abstract void n();

    public abstract void p(boolean z);

    public abstract void q(hd8 hd8Var, boolean z, String str, boolean z2);

    public void v(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onClickListener) == null) {
        }
    }

    public abstract void w(boolean z);

    public void x(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, a0Var) == null) {
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

    public xk8(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        if (detailInfoAndReplyFragment != null && detailInfoAndReplyFragment.J() != null && detailInfoAndReplyFragment.J().getArguments() != null) {
            this.k = detailInfoAndReplyFragment.J().getArguments().getInt(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE);
        }
        this.c = bdTypeRecyclerView;
    }

    public final void H() {
        hd8 hd8Var;
        v59 v59Var;
        v59 v59Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (hd8Var = this.d) == null || hd8Var.c0 || hd8Var.d0 == 2) {
            return;
        }
        ArrayList<PostData> H = hd8Var.H();
        ArrayList<v59> e = this.d.e();
        if (e != null && !e.isEmpty() && H != null && !H.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<v59> it = e.iterator();
            while (it.hasNext()) {
                v59 next = it.next();
                if (next != null && next.q1() != null) {
                    sb.append(next.q1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<v59> it2 = e.iterator();
            while (it2.hasNext()) {
                v59 next2 = it2.next();
                if (next2 != null) {
                    next2.h1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<v59> it3 = e.iterator();
            while (it3.hasNext()) {
                v59 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int l = next3.getAdvertAppInfo().l();
                    if (l != 0) {
                        px8.j(next3, l);
                        if (l != 28 && l != 31) {
                            next3.getAdvertAppInfo().c = -1001;
                            Log.e("cq", "updateAppData，Data InValidate: " + l);
                        }
                    }
                    sparseArray.put(next3.getPosition(), next3);
                }
            }
            HashMap hashMap = new HashMap();
            for (int i = 0; i < sparseArray.size(); i++) {
                v59 v59Var3 = (v59) sparseArray.get(sparseArray.keyAt(i));
                if (v59Var3 != null && (v59Var2 = (v59) hashMap.put(v59Var3.p1(), v59Var3)) != null) {
                    px8.j(v59Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (v59Var = (v59) entry.getValue()) != null) {
                    sparseArray.put(v59Var.getPosition(), v59Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                v59 v59Var4 = (v59) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                if (this.d.l() != null) {
                    v59Var4.b1 = this.d.l().getId();
                }
                if (this.d.Q() != null) {
                    v59Var4.e1 = dh.g(this.d.Q().getId(), 0L);
                }
                hd8 hd8Var2 = this.d;
                if (hd8Var2 != null && hd8Var2.z() != null) {
                    v59Var4.f1 = this.d.z().a();
                }
                b(v59Var4);
                int position = v59Var4.getPosition() + this.d.b0;
                if (position >= H.size()) {
                    v59Var4.h1 = position;
                    px8.k(v59Var4, 2, position + i3, H.size());
                    return;
                }
                if (!this.f) {
                    position--;
                    v59Var4.h1 = position;
                }
                if (position < 0) {
                    px8.j(v59Var4, 23);
                } else if (h(H, position)) {
                    px8.j(v59Var4, 1);
                } else {
                    H.add(position, v59Var4);
                    TiebaStatic.eventStat(this.b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", v59Var4.getAdvertAppInfo().p);
                }
            }
        }
    }

    @Override // com.baidu.tieba.jl8
    public ArrayList<Cdo> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.g;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (12 == this.k) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.b.M() != null) {
                return this.b.M().V0();
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

    public final void b(v59 v59Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, v59Var) == null) && v59Var != null && this.d != null && v59Var.getAdvertAppInfo() != null) {
            v59Var.getAdvertAppInfo().i = new ey4();
            if (this.d.z() != null) {
                v59Var.getAdvertAppInfo().i.b = this.d.z().a();
            }
            v59Var.getAdvertAppInfo().i.a = v59Var.r1();
            if (this.d.l() != null && (l = this.d.l()) != null) {
                v59Var.getAdvertAppInfo().i.c = l.getId();
                v59Var.getAdvertAppInfo().i.d = l.getFirst_class();
                v59Var.getAdvertAppInfo().i.e = l.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                v59Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            v59Var.getAdvertAppInfo().i.g = v59Var.getAdvertAppInfo().g;
            v59Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean h(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof v59) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            boolean z = false;
            boolean z2 = false;
            for (int i = 0; i < this.g.size(); i++) {
                Cdo cdo = this.g.get(i);
                if (cdo instanceof ud8) {
                    this.l = i;
                    z = true;
                } else if ((cdo instanceof gd8) && ((gd8) cdo).a() == this.a) {
                    this.m = i;
                    z2 = true;
                }
            }
            if (!z) {
                this.l = -1;
            }
            if (!z2) {
                this.m = -1;
            }
        }
    }

    public void r(hd8 hd8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, hd8Var) == null) {
            s(hd8Var, false);
        }
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

    public void s(hd8 hd8Var, boolean z) {
        v59 v59Var;
        PostData postData;
        boolean z2;
        hd8 hd8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048602, this, hd8Var, z) != null) || hd8Var == null) {
            return;
        }
        this.d = hd8Var;
        if (hd8Var != null && hd8Var.Q() != null && hd8Var.Q().getAuthor() != null) {
            this.h = hd8Var.Q().getAuthor().getUserId();
        }
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        this.g.clear();
        Iterator<PostData> it = hd8Var.H().iterator();
        while (true) {
            v59Var = null;
            if (it.hasNext()) {
                PostData next = it.next();
                if (next instanceof PostData) {
                    postData = next;
                    if (postData.F() == 1) {
                        break;
                    }
                }
            } else {
                postData = null;
                break;
            }
        }
        if (postData == null && hd8Var.j() != null) {
            postData = hd8Var.j();
        }
        if (postData != null) {
            this.g.add(postData);
        }
        F(hd8Var);
        G(this.h);
        int i = 0;
        if (!ListUtils.isEmpty(hd8Var.H()) && hd8Var.H().get(0) != null && hd8Var.Q() != null) {
            hd8Var.Q().setItem(hd8Var.H().get(0).S());
            hd8Var.Q().setItemStar(hd8Var.H().get(0).T());
        }
        if (hd8Var.Q() != null && hd8Var.Q().getRawThreadInfo() != null) {
            d15 d15Var = new d15();
            d15Var.t = hd8Var.Q();
            d15Var.n = true;
            this.g.add(d15Var);
        }
        vd8 vd8Var = new vd8(hd8Var.Q(), hd8Var.d());
        vd8Var.i(false);
        vd8Var.b = false;
        this.g.add(vd8Var);
        if (postData != null && postData.r0 != null && (hd8Var.l() == null || !TextUtils.equals(hd8Var.l().getName(), this.b.M().R0()) || !this.b.M().X0())) {
            kd8 kd8Var = new kd8(postData.r0);
            kd8Var.b = this.b.M().M1();
            this.g.add(kd8Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && hd8Var.l() != null && !StringUtils.isNull(hd8Var.l().getName()) && (!TextUtils.equals(hd8Var.l().getName(), this.b.M().R0()) || !this.b.M().X0())) {
            jd8 jd8Var = new jd8(hd8Var.l());
            jd8Var.g = this.b.M().M1();
            jd8Var.e = false;
            this.g.add(jd8Var);
            vd8Var.i(false);
            vd8Var.b = false;
        }
        if (hd8Var.Q() != null && !StringUtils.isNull(hd8Var.Q().getForum_name())) {
            be8 be8Var = new be8();
            be8Var.a = hd8Var.Q();
            this.g.add(be8Var);
        } else if (hd8Var.Q() != null && !StringUtils.isNull(hd8Var.n())) {
            hd8Var.Q().setForum_name(hd8Var.n());
            be8 be8Var2 = new be8();
            be8Var2.a = hd8Var.Q();
            this.g.add(be8Var2);
        }
        if (j() && hd8Var.z() != null && hd8Var.z().c() == 1) {
            pd8 pd8Var = new pd8(pd8.c);
            pd8Var.b(true);
            this.g.add(pd8Var);
        }
        ud8 ud8Var = new ud8(ud8.i);
        ThreadData Q = hd8Var.Q();
        if (Q != null) {
            Q.getReply_num();
        }
        this.b.M().K1();
        ud8Var.d = k();
        ud8Var.c = hd8Var.g;
        hd8Var.c();
        ud8Var.e = hd8Var.l0();
        ud8Var.g = hd8Var.f;
        D(hd8Var);
        this.g.add(ud8Var);
        if (hd8Var.N() == 4) {
            this.g.add(new td8());
        }
        H();
        p(i());
        Iterator<PostData> it2 = hd8Var.H().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.F() != 1) {
                this.g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((hd8Var2 = this.d) == null || !hd8Var2.t()))) {
            rd8 rd8Var = new rd8();
            rd8Var.a1 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            rd8Var.Z0 = R.drawable.new_pic_emotion_03;
            rd8Var.b1 = -2;
            rd8Var.c1 = ej.g(this.b.getContext(), R.dimen.tbds74);
            this.g.add(rd8Var);
        }
        q(hd8Var, this.j, this.h, this.i);
        if (hd8Var.z().b() == 0) {
            hd8 hd8Var3 = this.d;
            if (hd8Var3 != null && hd8Var3.t()) {
                C(this.b.J().a4());
                this.g.add(new od8());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.d.m());
                statisticItem.param("fname", this.d.n());
                statisticItem.param("tid", this.d.S());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                B(this.b.J().a4());
                nd8 nd8Var = new nd8();
                nd8Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.g.add(nd8Var);
            }
            List<v59> c0 = hd8Var.c0();
            int i2 = -1;
            if (c0 != null && !c0.isEmpty()) {
                v59Var = c0.get(0);
                i2 = v59Var.getPosition();
            }
            if (!ListUtils.isEmpty(hd8Var.f())) {
                gd8 gd8Var = new gd8();
                gd8Var.f(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                gd8Var.c(this.a);
                this.g.add(gd8Var);
                int i3 = 1;
                for (qy4 qy4Var : hd8Var.f()) {
                    if (c0 != null && i3 == i2) {
                        if (v59Var != null) {
                            b(v59Var);
                            this.g.add(v59Var);
                            i++;
                            if (v59Var.getType() != AdvertAppInfo.x) {
                                i3++;
                            }
                        }
                        if (i < c0.size()) {
                            v59 v59Var2 = c0.get(i);
                            v59Var = v59Var2;
                            i2 = v59Var2.getPosition();
                        }
                    }
                    this.g.add(qy4Var);
                    i3++;
                    if (i3 == 4 && hd8Var.D() != null) {
                        this.g.add(hd8Var.D());
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
}
