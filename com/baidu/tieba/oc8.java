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
/* loaded from: classes5.dex */
public abstract class oc8 extends ad8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public DetailInfoAndReplyFragment b;
    public BdTypeRecyclerView c;
    public y48 d;
    public final List<ln> e;
    public boolean f;
    public ArrayList<yn> g;
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

    public abstract void D(y48 y48Var);

    public void E(a68 a68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, a68Var) == null) {
        }
    }

    public abstract void F(y48 y48Var);

    public abstract void G(String str);

    public abstract s88 e();

    public abstract n78 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public abstract void m();

    public abstract void n();

    public abstract void p(boolean z);

    public abstract void q(y48 y48Var, boolean z, String str, boolean z2);

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

    public oc8(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        y48 y48Var;
        hx8 hx8Var;
        hx8 hx8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (y48Var = this.d) == null || y48Var.c0 || y48Var.d0 == 2) {
            return;
        }
        ArrayList<PostData> H = y48Var.H();
        ArrayList<hx8> e = this.d.e();
        if (e != null && !e.isEmpty() && H != null && !H.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<hx8> it = e.iterator();
            while (it.hasNext()) {
                hx8 next = it.next();
                if (next != null && next.q1() != null) {
                    sb.append(next.q1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<hx8> it2 = e.iterator();
            while (it2.hasNext()) {
                hx8 next2 = it2.next();
                if (next2 != null) {
                    next2.g1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<hx8> it3 = e.iterator();
            while (it3.hasNext()) {
                hx8 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int m = next3.getAdvertAppInfo().m();
                    if (m != 0) {
                        ep8.j(next3, m);
                        if (m != 28 && m != 31) {
                            next3.getAdvertAppInfo().c = -1001;
                            Log.e("cq", "updateAppData，Data InValidate: " + m);
                        }
                    }
                    sparseArray.put(next3.getPosition(), next3);
                }
            }
            HashMap hashMap = new HashMap();
            for (int i = 0; i < sparseArray.size(); i++) {
                hx8 hx8Var3 = (hx8) sparseArray.get(sparseArray.keyAt(i));
                if (hx8Var3 != null && (hx8Var2 = (hx8) hashMap.put(hx8Var3.p1(), hx8Var3)) != null) {
                    ep8.j(hx8Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (hx8Var = (hx8) entry.getValue()) != null) {
                    sparseArray.put(hx8Var.getPosition(), hx8Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                hx8 hx8Var4 = (hx8) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                if (this.d.l() != null) {
                    hx8Var4.a1 = this.d.l().getId();
                }
                if (this.d.Q() != null) {
                    hx8Var4.d1 = yg.g(this.d.Q().getId(), 0L);
                }
                y48 y48Var2 = this.d;
                if (y48Var2 != null && y48Var2.z() != null) {
                    hx8Var4.e1 = this.d.z().a();
                }
                b(hx8Var4);
                int position = hx8Var4.getPosition() + this.d.b0;
                if (position >= H.size()) {
                    hx8Var4.g1 = position;
                    ep8.k(hx8Var4, 2, position + i3, H.size());
                    return;
                }
                if (!this.f) {
                    position--;
                    hx8Var4.g1 = position;
                }
                if (position < 0) {
                    ep8.j(hx8Var4, 23);
                } else if (h(H, position)) {
                    ep8.j(hx8Var4, 1);
                } else {
                    H.add(position, hx8Var4);
                    TiebaStatic.eventStat(this.b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", hx8Var4.getAdvertAppInfo().p);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad8
    public ArrayList<yn> a() {
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
                return this.b.M().O0();
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

    public final void b(hx8 hx8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, hx8Var) == null) && hx8Var != null && this.d != null && hx8Var.getAdvertAppInfo() != null) {
            hx8Var.getAdvertAppInfo().i = new ks4();
            if (this.d.z() != null) {
                hx8Var.getAdvertAppInfo().i.b = this.d.z().a();
            }
            hx8Var.getAdvertAppInfo().i.a = hx8Var.r1();
            if (this.d.l() != null && (l = this.d.l()) != null) {
                hx8Var.getAdvertAppInfo().i.c = l.getId();
                hx8Var.getAdvertAppInfo().i.d = l.getFirst_class();
                hx8Var.getAdvertAppInfo().i.e = l.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                hx8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            hx8Var.getAdvertAppInfo().i.g = hx8Var.getAdvertAppInfo().g;
            hx8Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean h(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof hx8) {
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
                yn ynVar = this.g.get(i);
                if (ynVar instanceof l58) {
                    this.l = i;
                    z = true;
                } else if ((ynVar instanceof x48) && ((x48) ynVar).a() == this.a) {
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

    public void r(y48 y48Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, y48Var) == null) {
            s(y48Var, false);
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

    public void s(y48 y48Var, boolean z) {
        hx8 hx8Var;
        PostData postData;
        boolean z2;
        y48 y48Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048602, this, y48Var, z) != null) || y48Var == null) {
            return;
        }
        this.d = y48Var;
        if (y48Var != null && y48Var.Q() != null && y48Var.Q().getAuthor() != null) {
            this.h = y48Var.Q().getAuthor().getUserId();
        }
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        this.g.clear();
        Iterator<PostData> it = y48Var.H().iterator();
        while (true) {
            hx8Var = null;
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
        if (postData == null && y48Var.j() != null) {
            postData = y48Var.j();
        }
        if (postData != null) {
            this.g.add(postData);
        }
        F(y48Var);
        G(this.h);
        int i = 0;
        if (!ListUtils.isEmpty(y48Var.H()) && y48Var.H().get(0) != null && y48Var.Q() != null) {
            y48Var.Q().setItem(y48Var.H().get(0).S());
            y48Var.Q().setItemStar(y48Var.H().get(0).T());
        }
        if (y48Var.Q() != null && y48Var.Q().getRawThreadInfo() != null) {
            jv4 jv4Var = new jv4();
            jv4Var.t = y48Var.Q();
            jv4Var.n = true;
            this.g.add(jv4Var);
        }
        m58 m58Var = new m58(y48Var.Q(), y48Var.d());
        m58Var.i(false);
        m58Var.b = false;
        this.g.add(m58Var);
        if (postData != null && postData.q0 != null && (y48Var.l() == null || !TextUtils.equals(y48Var.l().getName(), this.b.M().K0()) || !this.b.M().Q0())) {
            b58 b58Var = new b58(postData.q0);
            b58Var.b = this.b.M().F1();
            this.g.add(b58Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && y48Var.l() != null && !StringUtils.isNull(y48Var.l().getName()) && (!TextUtils.equals(y48Var.l().getName(), this.b.M().K0()) || !this.b.M().Q0())) {
            a58 a58Var = new a58(y48Var.l());
            a58Var.g = this.b.M().F1();
            a58Var.e = false;
            this.g.add(a58Var);
            m58Var.i(false);
            m58Var.b = false;
        }
        if (y48Var.Q() != null && !StringUtils.isNull(y48Var.Q().getForum_name())) {
            s58 s58Var = new s58();
            s58Var.a = y48Var.Q();
            this.g.add(s58Var);
        } else if (y48Var.Q() != null && !StringUtils.isNull(y48Var.n())) {
            y48Var.Q().setForum_name(y48Var.n());
            s58 s58Var2 = new s58();
            s58Var2.a = y48Var.Q();
            this.g.add(s58Var2);
        }
        if (j() && y48Var.z() != null && y48Var.z().c() == 1) {
            g58 g58Var = new g58(g58.c);
            g58Var.b(true);
            this.g.add(g58Var);
        }
        l58 l58Var = new l58(l58.i);
        ThreadData Q = y48Var.Q();
        if (Q != null) {
            Q.getReply_num();
        }
        this.b.M().D1();
        l58Var.d = k();
        l58Var.c = y48Var.g;
        y48Var.c();
        l58Var.e = y48Var.l0();
        l58Var.g = y48Var.f;
        D(y48Var);
        this.g.add(l58Var);
        if (y48Var.N() == 4) {
            this.g.add(new k58());
        }
        H();
        p(i());
        Iterator<PostData> it2 = y48Var.H().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.F() != 1) {
                this.g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((y48Var2 = this.d) == null || !y48Var2.t()))) {
            i58 i58Var = new i58();
            i58Var.Z0 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            i58Var.Y0 = R.drawable.new_pic_emotion_03;
            i58Var.a1 = -2;
            i58Var.b1 = zi.g(this.b.getContext(), R.dimen.tbds74);
            this.g.add(i58Var);
        }
        q(y48Var, this.j, this.h, this.i);
        if (y48Var.z().b() == 0) {
            y48 y48Var3 = this.d;
            if (y48Var3 != null && y48Var3.t()) {
                C(this.b.J().a4());
                this.g.add(new f58());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.d.m());
                statisticItem.param("fname", this.d.n());
                statisticItem.param("tid", this.d.S());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                B(this.b.J().a4());
                e58 e58Var = new e58();
                e58Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.g.add(e58Var);
            }
            List<hx8> c0 = y48Var.c0();
            int i2 = -1;
            if (c0 != null && !c0.isEmpty()) {
                hx8Var = c0.get(0);
                i2 = hx8Var.getPosition();
            }
            if (!ListUtils.isEmpty(y48Var.f())) {
                x48 x48Var = new x48();
                x48Var.f(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                x48Var.c(this.a);
                this.g.add(x48Var);
                int i3 = 1;
                for (ws4 ws4Var : y48Var.f()) {
                    if (c0 != null && i3 == i2) {
                        if (hx8Var != null) {
                            b(hx8Var);
                            this.g.add(hx8Var);
                            i++;
                            if (hx8Var.getType() != AdvertAppInfo.x) {
                                i3++;
                            }
                        }
                        if (i < c0.size()) {
                            hx8 hx8Var2 = c0.get(i);
                            hx8Var = hx8Var2;
                            i2 = hx8Var2.getPosition();
                        }
                    }
                    this.g.add(ws4Var);
                    i3++;
                    if (i3 == 4 && y48Var.D() != null) {
                        this.g.add(y48Var.D());
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
