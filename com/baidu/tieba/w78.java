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
public abstract class w78 extends i88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public DetailInfoAndReplyFragment b;
    public BdTypeRecyclerView c;
    public h08 d;
    public final List<kn> e;
    public boolean f;
    public ArrayList<xn> g;
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

    public abstract void D(h08 h08Var);

    public void E(j18 j18Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, j18Var) == null) {
        }
    }

    public abstract void F(h08 h08Var);

    public abstract void G(String str);

    public abstract b48 e();

    public abstract w28 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public abstract void m();

    public abstract void n();

    public abstract void p(boolean z);

    public abstract void q(h08 h08Var, boolean z, String str, boolean z2);

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

    public w78(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        h08 h08Var;
        ks8 ks8Var;
        ks8 ks8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (h08Var = this.d) == null || h08Var.c0 || h08Var.d0 == 2) {
            return;
        }
        ArrayList<PostData> H = h08Var.H();
        ArrayList<ks8> e = this.d.e();
        if (e != null && !e.isEmpty() && H != null && !H.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<ks8> it = e.iterator();
            while (it.hasNext()) {
                ks8 next = it.next();
                if (next != null && next.n1() != null) {
                    sb.append(next.n1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<ks8> it2 = e.iterator();
            while (it2.hasNext()) {
                ks8 next2 = it2.next();
                if (next2 != null) {
                    next2.e1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<ks8> it3 = e.iterator();
            while (it3.hasNext()) {
                ks8 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int m = next3.getAdvertAppInfo().m();
                    if (m != 0) {
                        mk8.j(next3, m);
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
                ks8 ks8Var3 = (ks8) sparseArray.get(sparseArray.keyAt(i));
                if (ks8Var3 != null && (ks8Var2 = (ks8) hashMap.put(ks8Var3.m1(), ks8Var3)) != null) {
                    mk8.j(ks8Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (ks8Var = (ks8) entry.getValue()) != null) {
                    sparseArray.put(ks8Var.getPosition(), ks8Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                ks8 ks8Var4 = (ks8) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                if (this.d.l() != null) {
                    ks8Var4.Y0 = this.d.l().getId();
                }
                if (this.d.Q() != null) {
                    ks8Var4.b1 = xg.g(this.d.Q().getId(), 0L);
                }
                h08 h08Var2 = this.d;
                if (h08Var2 != null && h08Var2.z() != null) {
                    ks8Var4.c1 = this.d.z().a();
                }
                b(ks8Var4);
                int position = ks8Var4.getPosition() + this.d.b0;
                if (position >= H.size()) {
                    ks8Var4.e1 = position;
                    mk8.k(ks8Var4, 2, position + i3, H.size());
                    return;
                }
                if (!this.f) {
                    position--;
                    ks8Var4.e1 = position;
                }
                if (position < 0) {
                    mk8.j(ks8Var4, 23);
                } else if (h(H, position)) {
                    mk8.j(ks8Var4, 1);
                } else {
                    H.add(position, ks8Var4);
                    TiebaStatic.eventStat(this.b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", ks8Var4.getAdvertAppInfo().p);
                }
            }
        }
    }

    @Override // com.baidu.tieba.i88
    public ArrayList<xn> a() {
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

    public final void b(ks8 ks8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, ks8Var) == null) && ks8Var != null && this.d != null && ks8Var.getAdvertAppInfo() != null) {
            ks8Var.getAdvertAppInfo().i = new as4();
            if (this.d.z() != null) {
                ks8Var.getAdvertAppInfo().i.b = this.d.z().a();
            }
            ks8Var.getAdvertAppInfo().i.a = ks8Var.o1();
            if (this.d.l() != null && (l = this.d.l()) != null) {
                ks8Var.getAdvertAppInfo().i.c = l.getId();
                ks8Var.getAdvertAppInfo().i.d = l.getFirst_class();
                ks8Var.getAdvertAppInfo().i.e = l.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                ks8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            ks8Var.getAdvertAppInfo().i.g = ks8Var.getAdvertAppInfo().g;
            ks8Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean h(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof ks8) {
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
                xn xnVar = this.g.get(i);
                if (xnVar instanceof u08) {
                    this.l = i;
                    z = true;
                } else if ((xnVar instanceof g08) && ((g08) xnVar).a() == this.a) {
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

    public void r(h08 h08Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, h08Var) == null) {
            s(h08Var, false);
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

    public void s(h08 h08Var, boolean z) {
        ks8 ks8Var;
        PostData postData;
        boolean z2;
        h08 h08Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048602, this, h08Var, z) != null) || h08Var == null) {
            return;
        }
        this.d = h08Var;
        if (h08Var != null && h08Var.Q() != null && h08Var.Q().getAuthor() != null) {
            this.h = h08Var.Q().getAuthor().getUserId();
        }
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        this.g.clear();
        Iterator<PostData> it = h08Var.H().iterator();
        while (true) {
            ks8Var = null;
            if (it.hasNext()) {
                PostData next = it.next();
                if (next instanceof PostData) {
                    postData = next;
                    if (postData.D() == 1) {
                        break;
                    }
                }
            } else {
                postData = null;
                break;
            }
        }
        if (postData == null && h08Var.j() != null) {
            postData = h08Var.j();
        }
        if (postData != null) {
            this.g.add(postData);
        }
        F(h08Var);
        G(this.h);
        int i = 0;
        if (!ListUtils.isEmpty(h08Var.H()) && h08Var.H().get(0) != null && h08Var.Q() != null) {
            h08Var.Q().setItem(h08Var.H().get(0).Q());
            h08Var.Q().setItemStar(h08Var.H().get(0).R());
        }
        if (h08Var.Q() != null && h08Var.Q().getRawThreadInfo() != null) {
            yu4 yu4Var = new yu4();
            yu4Var.t = h08Var.Q();
            yu4Var.n = true;
            this.g.add(yu4Var);
        }
        v08 v08Var = new v08(h08Var.Q(), h08Var.d());
        v08Var.i(false);
        v08Var.b = false;
        this.g.add(v08Var);
        if (postData != null && postData.q0 != null && (h08Var.l() == null || !TextUtils.equals(h08Var.l().getName(), this.b.M().K0()) || !this.b.M().Q0())) {
            k08 k08Var = new k08(postData.q0);
            k08Var.b = this.b.M().F1();
            this.g.add(k08Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && h08Var.l() != null && !StringUtils.isNull(h08Var.l().getName()) && (!TextUtils.equals(h08Var.l().getName(), this.b.M().K0()) || !this.b.M().Q0())) {
            j08 j08Var = new j08(h08Var.l());
            j08Var.g = this.b.M().F1();
            j08Var.e = false;
            this.g.add(j08Var);
            v08Var.i(false);
            v08Var.b = false;
        }
        if (h08Var.Q() != null && !StringUtils.isNull(h08Var.Q().getForum_name())) {
            b18 b18Var = new b18();
            b18Var.a = h08Var.Q();
            this.g.add(b18Var);
        } else if (h08Var.Q() != null && !StringUtils.isNull(h08Var.n())) {
            h08Var.Q().setForum_name(h08Var.n());
            b18 b18Var2 = new b18();
            b18Var2.a = h08Var.Q();
            this.g.add(b18Var2);
        }
        if (j() && h08Var.z() != null && h08Var.z().c() == 1) {
            p08 p08Var = new p08(p08.c);
            p08Var.b(true);
            this.g.add(p08Var);
        }
        u08 u08Var = new u08(u08.i);
        ThreadData Q = h08Var.Q();
        if (Q != null) {
            Q.getReply_num();
        }
        this.b.M().D1();
        u08Var.d = k();
        u08Var.c = h08Var.g;
        h08Var.c();
        u08Var.e = h08Var.l0();
        u08Var.g = h08Var.f;
        D(h08Var);
        this.g.add(u08Var);
        if (h08Var.N() == 4) {
            this.g.add(new t08());
        }
        H();
        p(i());
        Iterator<PostData> it2 = h08Var.H().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.D() != 1) {
                this.g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((h08Var2 = this.d) == null || !h08Var2.t()))) {
            r08 r08Var = new r08();
            r08Var.X0 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            r08Var.W0 = R.drawable.new_pic_emotion_03;
            r08Var.Y0 = -2;
            r08Var.Z0 = yi.g(this.b.getContext(), R.dimen.tbds74);
            this.g.add(r08Var);
        }
        q(h08Var, this.j, this.h, this.i);
        if (h08Var.z().b() == 0) {
            h08 h08Var3 = this.d;
            if (h08Var3 != null && h08Var3.t()) {
                C(this.b.J().U3());
                this.g.add(new o08());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.d.m());
                statisticItem.param("fname", this.d.n());
                statisticItem.param("tid", this.d.S());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                B(this.b.J().U3());
                n08 n08Var = new n08();
                n08Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.g.add(n08Var);
            }
            List<ks8> c0 = h08Var.c0();
            int i2 = -1;
            if (c0 != null && !c0.isEmpty()) {
                ks8Var = c0.get(0);
                i2 = ks8Var.getPosition();
            }
            if (!ListUtils.isEmpty(h08Var.f())) {
                g08 g08Var = new g08();
                g08Var.f(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                g08Var.c(this.a);
                this.g.add(g08Var);
                int i3 = 1;
                for (ms4 ms4Var : h08Var.f()) {
                    if (c0 != null && i3 == i2) {
                        if (ks8Var != null) {
                            b(ks8Var);
                            this.g.add(ks8Var);
                            i++;
                            if (ks8Var.getType() != AdvertAppInfo.x) {
                                i3++;
                            }
                        }
                        if (i < c0.size()) {
                            ks8 ks8Var2 = c0.get(i);
                            ks8Var = ks8Var2;
                            i2 = ks8Var2.getPosition();
                        }
                    }
                    this.g.add(ms4Var);
                    i3++;
                    if (i3 == 4 && h08Var.D() != null) {
                        this.g.add(h08Var.D());
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
