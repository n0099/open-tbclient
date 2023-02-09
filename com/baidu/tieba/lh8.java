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
public abstract class lh8 extends xh8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public DetailInfoAndReplyFragment b;
    public BdTypeRecyclerView c;
    public v98 d;
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

    public abstract void D(v98 v98Var);

    public void E(xa8 xa8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, xa8Var) == null) {
        }
    }

    public abstract void F(v98 v98Var);

    public abstract void G(String str);

    public abstract pd8 e();

    public abstract kc8 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public abstract void m();

    public abstract void n();

    public abstract void p(boolean z);

    public abstract void q(v98 v98Var, boolean z, String str, boolean z2);

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

    public lh8(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        v98 v98Var;
        j29 j29Var;
        j29 j29Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (v98Var = this.d) == null || v98Var.c0 || v98Var.d0 == 2) {
            return;
        }
        ArrayList<PostData> H = v98Var.H();
        ArrayList<j29> e = this.d.e();
        if (e != null && !e.isEmpty() && H != null && !H.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<j29> it = e.iterator();
            while (it.hasNext()) {
                j29 next = it.next();
                if (next != null && next.q1() != null) {
                    sb.append(next.q1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<j29> it2 = e.iterator();
            while (it2.hasNext()) {
                j29 next2 = it2.next();
                if (next2 != null) {
                    next2.h1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<j29> it3 = e.iterator();
            while (it3.hasNext()) {
                j29 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int m = next3.getAdvertAppInfo().m();
                    if (m != 0) {
                        du8.j(next3, m);
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
                j29 j29Var3 = (j29) sparseArray.get(sparseArray.keyAt(i));
                if (j29Var3 != null && (j29Var2 = (j29) hashMap.put(j29Var3.p1(), j29Var3)) != null) {
                    du8.j(j29Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (j29Var = (j29) entry.getValue()) != null) {
                    sparseArray.put(j29Var.getPosition(), j29Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                j29 j29Var4 = (j29) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                if (this.d.l() != null) {
                    j29Var4.b1 = this.d.l().getId();
                }
                if (this.d.Q() != null) {
                    j29Var4.e1 = dh.g(this.d.Q().getId(), 0L);
                }
                v98 v98Var2 = this.d;
                if (v98Var2 != null && v98Var2.z() != null) {
                    j29Var4.f1 = this.d.z().a();
                }
                b(j29Var4);
                int position = j29Var4.getPosition() + this.d.b0;
                if (position >= H.size()) {
                    j29Var4.h1 = position;
                    du8.k(j29Var4, 2, position + i3, H.size());
                    return;
                }
                if (!this.f) {
                    position--;
                    j29Var4.h1 = position;
                }
                if (position < 0) {
                    du8.j(j29Var4, 23);
                } else if (h(H, position)) {
                    du8.j(j29Var4, 1);
                } else {
                    H.add(position, j29Var4);
                    TiebaStatic.eventStat(this.b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", j29Var4.getAdvertAppInfo().p);
                }
            }
        }
    }

    @Override // com.baidu.tieba.xh8
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

    public final void b(j29 j29Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, j29Var) == null) && j29Var != null && this.d != null && j29Var.getAdvertAppInfo() != null) {
            j29Var.getAdvertAppInfo().i = new xw4();
            if (this.d.z() != null) {
                j29Var.getAdvertAppInfo().i.b = this.d.z().a();
            }
            j29Var.getAdvertAppInfo().i.a = j29Var.r1();
            if (this.d.l() != null && (l = this.d.l()) != null) {
                j29Var.getAdvertAppInfo().i.c = l.getId();
                j29Var.getAdvertAppInfo().i.d = l.getFirst_class();
                j29Var.getAdvertAppInfo().i.e = l.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                j29Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            j29Var.getAdvertAppInfo().i.g = j29Var.getAdvertAppInfo().g;
            j29Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean h(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof j29) {
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
                if (cdo instanceof ia8) {
                    this.l = i;
                    z = true;
                } else if ((cdo instanceof u98) && ((u98) cdo).a() == this.a) {
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

    public void r(v98 v98Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, v98Var) == null) {
            s(v98Var, false);
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

    public void s(v98 v98Var, boolean z) {
        j29 j29Var;
        PostData postData;
        boolean z2;
        v98 v98Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048602, this, v98Var, z) != null) || v98Var == null) {
            return;
        }
        this.d = v98Var;
        if (v98Var != null && v98Var.Q() != null && v98Var.Q().getAuthor() != null) {
            this.h = v98Var.Q().getAuthor().getUserId();
        }
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        this.g.clear();
        Iterator<PostData> it = v98Var.H().iterator();
        while (true) {
            j29Var = null;
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
        if (postData == null && v98Var.j() != null) {
            postData = v98Var.j();
        }
        if (postData != null) {
            this.g.add(postData);
        }
        F(v98Var);
        G(this.h);
        int i = 0;
        if (!ListUtils.isEmpty(v98Var.H()) && v98Var.H().get(0) != null && v98Var.Q() != null) {
            v98Var.Q().setItem(v98Var.H().get(0).S());
            v98Var.Q().setItemStar(v98Var.H().get(0).T());
        }
        if (v98Var.Q() != null && v98Var.Q().getRawThreadInfo() != null) {
            wz4 wz4Var = new wz4();
            wz4Var.t = v98Var.Q();
            wz4Var.n = true;
            this.g.add(wz4Var);
        }
        ja8 ja8Var = new ja8(v98Var.Q(), v98Var.d());
        ja8Var.i(false);
        ja8Var.b = false;
        this.g.add(ja8Var);
        if (postData != null && postData.r0 != null && (v98Var.l() == null || !TextUtils.equals(v98Var.l().getName(), this.b.M().K0()) || !this.b.M().Q0())) {
            y98 y98Var = new y98(postData.r0);
            y98Var.b = this.b.M().F1();
            this.g.add(y98Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && v98Var.l() != null && !StringUtils.isNull(v98Var.l().getName()) && (!TextUtils.equals(v98Var.l().getName(), this.b.M().K0()) || !this.b.M().Q0())) {
            x98 x98Var = new x98(v98Var.l());
            x98Var.g = this.b.M().F1();
            x98Var.e = false;
            this.g.add(x98Var);
            ja8Var.i(false);
            ja8Var.b = false;
        }
        if (v98Var.Q() != null && !StringUtils.isNull(v98Var.Q().getForum_name())) {
            pa8 pa8Var = new pa8();
            pa8Var.a = v98Var.Q();
            this.g.add(pa8Var);
        } else if (v98Var.Q() != null && !StringUtils.isNull(v98Var.n())) {
            v98Var.Q().setForum_name(v98Var.n());
            pa8 pa8Var2 = new pa8();
            pa8Var2.a = v98Var.Q();
            this.g.add(pa8Var2);
        }
        if (j() && v98Var.z() != null && v98Var.z().c() == 1) {
            da8 da8Var = new da8(da8.c);
            da8Var.b(true);
            this.g.add(da8Var);
        }
        ia8 ia8Var = new ia8(ia8.i);
        ThreadData Q = v98Var.Q();
        if (Q != null) {
            Q.getReply_num();
        }
        this.b.M().D1();
        ia8Var.d = k();
        ia8Var.c = v98Var.g;
        v98Var.c();
        ia8Var.e = v98Var.l0();
        ia8Var.g = v98Var.f;
        D(v98Var);
        this.g.add(ia8Var);
        if (v98Var.N() == 4) {
            this.g.add(new ha8());
        }
        H();
        p(i());
        Iterator<PostData> it2 = v98Var.H().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.F() != 1) {
                this.g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((v98Var2 = this.d) == null || !v98Var2.t()))) {
            fa8 fa8Var = new fa8();
            fa8Var.a1 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            fa8Var.Z0 = R.drawable.new_pic_emotion_03;
            fa8Var.b1 = -2;
            fa8Var.c1 = ej.g(this.b.getContext(), R.dimen.tbds74);
            this.g.add(fa8Var);
        }
        q(v98Var, this.j, this.h, this.i);
        if (v98Var.z().b() == 0) {
            v98 v98Var3 = this.d;
            if (v98Var3 != null && v98Var3.t()) {
                C(this.b.J().a4());
                this.g.add(new ca8());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.d.m());
                statisticItem.param("fname", this.d.n());
                statisticItem.param("tid", this.d.S());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                B(this.b.J().a4());
                ba8 ba8Var = new ba8();
                ba8Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.g.add(ba8Var);
            }
            List<j29> c0 = v98Var.c0();
            int i2 = -1;
            if (c0 != null && !c0.isEmpty()) {
                j29Var = c0.get(0);
                i2 = j29Var.getPosition();
            }
            if (!ListUtils.isEmpty(v98Var.f())) {
                u98 u98Var = new u98();
                u98Var.f(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                u98Var.c(this.a);
                this.g.add(u98Var);
                int i3 = 1;
                for (jx4 jx4Var : v98Var.f()) {
                    if (c0 != null && i3 == i2) {
                        if (j29Var != null) {
                            b(j29Var);
                            this.g.add(j29Var);
                            i++;
                            if (j29Var.getType() != AdvertAppInfo.x) {
                                i3++;
                            }
                        }
                        if (i < c0.size()) {
                            j29 j29Var2 = c0.get(i);
                            j29Var = j29Var2;
                            i2 = j29Var2.getPosition();
                        }
                    }
                    this.g.add(jx4Var);
                    i3++;
                    if (i3 == 4 && v98Var.D() != null) {
                        this.g.add(v98Var.D());
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
