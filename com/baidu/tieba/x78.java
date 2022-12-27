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
public abstract class x78 extends j88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public DetailInfoAndReplyFragment b;
    public BdTypeRecyclerView c;
    public i08 d;
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

    public abstract void D(i08 i08Var);

    public void E(k18 k18Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, k18Var) == null) {
        }
    }

    public abstract void F(i08 i08Var);

    public abstract void G(String str);

    public abstract c48 e();

    public abstract x28 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public abstract void m();

    public abstract void n();

    public abstract void p(boolean z);

    public abstract void q(i08 i08Var, boolean z, String str, boolean z2);

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

    public x78(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        i08 i08Var;
        ls8 ls8Var;
        ls8 ls8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (i08Var = this.d) == null || i08Var.c0 || i08Var.d0 == 2) {
            return;
        }
        ArrayList<PostData> H = i08Var.H();
        ArrayList<ls8> e = this.d.e();
        if (e != null && !e.isEmpty() && H != null && !H.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<ls8> it = e.iterator();
            while (it.hasNext()) {
                ls8 next = it.next();
                if (next != null && next.n1() != null) {
                    sb.append(next.n1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<ls8> it2 = e.iterator();
            while (it2.hasNext()) {
                ls8 next2 = it2.next();
                if (next2 != null) {
                    next2.e1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<ls8> it3 = e.iterator();
            while (it3.hasNext()) {
                ls8 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int m = next3.getAdvertAppInfo().m();
                    if (m != 0) {
                        nk8.j(next3, m);
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
                ls8 ls8Var3 = (ls8) sparseArray.get(sparseArray.keyAt(i));
                if (ls8Var3 != null && (ls8Var2 = (ls8) hashMap.put(ls8Var3.m1(), ls8Var3)) != null) {
                    nk8.j(ls8Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (ls8Var = (ls8) entry.getValue()) != null) {
                    sparseArray.put(ls8Var.getPosition(), ls8Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                ls8 ls8Var4 = (ls8) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                if (this.d.l() != null) {
                    ls8Var4.Y0 = this.d.l().getId();
                }
                if (this.d.Q() != null) {
                    ls8Var4.b1 = xg.g(this.d.Q().getId(), 0L);
                }
                i08 i08Var2 = this.d;
                if (i08Var2 != null && i08Var2.z() != null) {
                    ls8Var4.c1 = this.d.z().a();
                }
                b(ls8Var4);
                int position = ls8Var4.getPosition() + this.d.b0;
                if (position >= H.size()) {
                    ls8Var4.e1 = position;
                    nk8.k(ls8Var4, 2, position + i3, H.size());
                    return;
                }
                if (!this.f) {
                    position--;
                    ls8Var4.e1 = position;
                }
                if (position < 0) {
                    nk8.j(ls8Var4, 23);
                } else if (h(H, position)) {
                    nk8.j(ls8Var4, 1);
                } else {
                    H.add(position, ls8Var4);
                    TiebaStatic.eventStat(this.b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", ls8Var4.getAdvertAppInfo().p);
                }
            }
        }
    }

    @Override // com.baidu.tieba.j88
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

    public final void b(ls8 ls8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, ls8Var) == null) && ls8Var != null && this.d != null && ls8Var.getAdvertAppInfo() != null) {
            ls8Var.getAdvertAppInfo().i = new as4();
            if (this.d.z() != null) {
                ls8Var.getAdvertAppInfo().i.b = this.d.z().a();
            }
            ls8Var.getAdvertAppInfo().i.a = ls8Var.o1();
            if (this.d.l() != null && (l = this.d.l()) != null) {
                ls8Var.getAdvertAppInfo().i.c = l.getId();
                ls8Var.getAdvertAppInfo().i.d = l.getFirst_class();
                ls8Var.getAdvertAppInfo().i.e = l.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                ls8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            ls8Var.getAdvertAppInfo().i.g = ls8Var.getAdvertAppInfo().g;
            ls8Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean h(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof ls8) {
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
                if (xnVar instanceof v08) {
                    this.l = i;
                    z = true;
                } else if ((xnVar instanceof h08) && ((h08) xnVar).a() == this.a) {
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

    public void r(i08 i08Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, i08Var) == null) {
            s(i08Var, false);
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

    public void s(i08 i08Var, boolean z) {
        ls8 ls8Var;
        PostData postData;
        boolean z2;
        i08 i08Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048602, this, i08Var, z) != null) || i08Var == null) {
            return;
        }
        this.d = i08Var;
        if (i08Var != null && i08Var.Q() != null && i08Var.Q().getAuthor() != null) {
            this.h = i08Var.Q().getAuthor().getUserId();
        }
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        this.g.clear();
        Iterator<PostData> it = i08Var.H().iterator();
        while (true) {
            ls8Var = null;
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
        if (postData == null && i08Var.j() != null) {
            postData = i08Var.j();
        }
        if (postData != null) {
            this.g.add(postData);
        }
        F(i08Var);
        G(this.h);
        int i = 0;
        if (!ListUtils.isEmpty(i08Var.H()) && i08Var.H().get(0) != null && i08Var.Q() != null) {
            i08Var.Q().setItem(i08Var.H().get(0).Q());
            i08Var.Q().setItemStar(i08Var.H().get(0).R());
        }
        if (i08Var.Q() != null && i08Var.Q().getRawThreadInfo() != null) {
            yu4 yu4Var = new yu4();
            yu4Var.t = i08Var.Q();
            yu4Var.n = true;
            this.g.add(yu4Var);
        }
        w08 w08Var = new w08(i08Var.Q(), i08Var.d());
        w08Var.i(false);
        w08Var.b = false;
        this.g.add(w08Var);
        if (postData != null && postData.q0 != null && (i08Var.l() == null || !TextUtils.equals(i08Var.l().getName(), this.b.M().K0()) || !this.b.M().Q0())) {
            l08 l08Var = new l08(postData.q0);
            l08Var.b = this.b.M().F1();
            this.g.add(l08Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && i08Var.l() != null && !StringUtils.isNull(i08Var.l().getName()) && (!TextUtils.equals(i08Var.l().getName(), this.b.M().K0()) || !this.b.M().Q0())) {
            k08 k08Var = new k08(i08Var.l());
            k08Var.g = this.b.M().F1();
            k08Var.e = false;
            this.g.add(k08Var);
            w08Var.i(false);
            w08Var.b = false;
        }
        if (i08Var.Q() != null && !StringUtils.isNull(i08Var.Q().getForum_name())) {
            c18 c18Var = new c18();
            c18Var.a = i08Var.Q();
            this.g.add(c18Var);
        } else if (i08Var.Q() != null && !StringUtils.isNull(i08Var.n())) {
            i08Var.Q().setForum_name(i08Var.n());
            c18 c18Var2 = new c18();
            c18Var2.a = i08Var.Q();
            this.g.add(c18Var2);
        }
        if (j() && i08Var.z() != null && i08Var.z().c() == 1) {
            q08 q08Var = new q08(q08.c);
            q08Var.b(true);
            this.g.add(q08Var);
        }
        v08 v08Var = new v08(v08.i);
        ThreadData Q = i08Var.Q();
        if (Q != null) {
            Q.getReply_num();
        }
        this.b.M().D1();
        v08Var.d = k();
        v08Var.c = i08Var.g;
        i08Var.c();
        v08Var.e = i08Var.l0();
        v08Var.g = i08Var.f;
        D(i08Var);
        this.g.add(v08Var);
        if (i08Var.N() == 4) {
            this.g.add(new u08());
        }
        H();
        p(i());
        Iterator<PostData> it2 = i08Var.H().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.D() != 1) {
                this.g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((i08Var2 = this.d) == null || !i08Var2.t()))) {
            s08 s08Var = new s08();
            s08Var.X0 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            s08Var.W0 = R.drawable.new_pic_emotion_03;
            s08Var.Y0 = -2;
            s08Var.Z0 = yi.g(this.b.getContext(), R.dimen.tbds74);
            this.g.add(s08Var);
        }
        q(i08Var, this.j, this.h, this.i);
        if (i08Var.z().b() == 0) {
            i08 i08Var3 = this.d;
            if (i08Var3 != null && i08Var3.t()) {
                C(this.b.J().U3());
                this.g.add(new p08());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.d.m());
                statisticItem.param("fname", this.d.n());
                statisticItem.param("tid", this.d.S());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                B(this.b.J().U3());
                o08 o08Var = new o08();
                o08Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.g.add(o08Var);
            }
            List<ls8> c0 = i08Var.c0();
            int i2 = -1;
            if (c0 != null && !c0.isEmpty()) {
                ls8Var = c0.get(0);
                i2 = ls8Var.getPosition();
            }
            if (!ListUtils.isEmpty(i08Var.f())) {
                h08 h08Var = new h08();
                h08Var.f(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                h08Var.c(this.a);
                this.g.add(h08Var);
                int i3 = 1;
                for (ms4 ms4Var : i08Var.f()) {
                    if (c0 != null && i3 == i2) {
                        if (ls8Var != null) {
                            b(ls8Var);
                            this.g.add(ls8Var);
                            i++;
                            if (ls8Var.getType() != AdvertAppInfo.x) {
                                i3++;
                            }
                        }
                        if (i < c0.size()) {
                            ls8 ls8Var2 = c0.get(i);
                            ls8Var = ls8Var2;
                            i2 = ls8Var2.getPosition();
                        }
                    }
                    this.g.add(ms4Var);
                    i3++;
                    if (i3 == 4 && i08Var.D() != null) {
                        this.g.add(i08Var.D());
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
