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
public abstract class s48 extends e58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public DetailInfoAndReplyFragment b;
    public BdTypeRecyclerView c;
    public dx7 d;
    public final List<jn> e;
    public boolean f;
    public ArrayList<wn> g;
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

    public abstract void D(dx7 dx7Var);

    public void E(fy7 fy7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fy7Var) == null) {
        }
    }

    public abstract void F(dx7 dx7Var);

    public abstract void G(String str);

    public abstract x08 e();

    public abstract sz7 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public abstract void m();

    public abstract void n();

    public abstract void p(boolean z);

    public abstract void q(dx7 dx7Var, boolean z, String str, boolean z2);

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

    public s48(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public final void H() {
        dx7 dx7Var;
        zo8 zo8Var;
        zo8 zo8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (dx7Var = this.d) == null || dx7Var.c0 || dx7Var.d0 == 2) {
            return;
        }
        ArrayList<PostData> H = dx7Var.H();
        ArrayList<zo8> e = this.d.e();
        if (e != null && !e.isEmpty() && H != null && !H.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<zo8> it = e.iterator();
            while (it.hasNext()) {
                zo8 next = it.next();
                if (next != null && next.m1() != null) {
                    sb.append(next.m1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<zo8> it2 = e.iterator();
            while (it2.hasNext()) {
                zo8 next2 = it2.next();
                if (next2 != null) {
                    next2.d1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<zo8> it3 = e.iterator();
            while (it3.hasNext()) {
                zo8 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int n = next3.getAdvertAppInfo().n();
                    if (n != 0) {
                        ih8.j(next3, n);
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
                zo8 zo8Var3 = (zo8) sparseArray.get(sparseArray.keyAt(i));
                if (zo8Var3 != null && (zo8Var2 = (zo8) hashMap.put(zo8Var3.l1(), zo8Var3)) != null) {
                    ih8.j(zo8Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (zo8Var = (zo8) entry.getValue()) != null) {
                    sparseArray.put(zo8Var.getPosition(), zo8Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                zo8 zo8Var4 = (zo8) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                if (this.d.l() != null) {
                    zo8Var4.X0 = this.d.l().getId();
                }
                if (this.d.Q() != null) {
                    zo8Var4.a1 = wg.g(this.d.Q().getId(), 0L);
                }
                dx7 dx7Var2 = this.d;
                if (dx7Var2 != null && dx7Var2.z() != null) {
                    zo8Var4.b1 = this.d.z().a();
                }
                b(zo8Var4);
                int position = zo8Var4.getPosition() + this.d.b0;
                if (position >= H.size()) {
                    zo8Var4.d1 = position;
                    ih8.k(zo8Var4, 2, position + i3, H.size());
                    return;
                }
                if (!this.f) {
                    position--;
                    zo8Var4.d1 = position;
                }
                if (position < 0) {
                    ih8.j(zo8Var4, 23);
                } else if (h(H, position)) {
                    ih8.j(zo8Var4, 1);
                } else {
                    H.add(position, zo8Var4);
                    TiebaStatic.eventStat(this.b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", zo8Var4.getAdvertAppInfo().p);
                }
            }
        }
    }

    @Override // com.baidu.tieba.e58
    public ArrayList<wn> a() {
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

    public final void b(zo8 zo8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, zo8Var) == null) && zo8Var != null && this.d != null && zo8Var.getAdvertAppInfo() != null) {
            zo8Var.getAdvertAppInfo().i = new wr4();
            if (this.d.z() != null) {
                zo8Var.getAdvertAppInfo().i.b = this.d.z().a();
            }
            zo8Var.getAdvertAppInfo().i.a = zo8Var.n1();
            if (this.d.l() != null && (l = this.d.l()) != null) {
                zo8Var.getAdvertAppInfo().i.c = l.getId();
                zo8Var.getAdvertAppInfo().i.d = l.getFirst_class();
                zo8Var.getAdvertAppInfo().i.e = l.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                zo8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            zo8Var.getAdvertAppInfo().i.g = zo8Var.getAdvertAppInfo().g;
            zo8Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean h(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof zo8) {
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
                wn wnVar = this.g.get(i);
                if (wnVar instanceof qx7) {
                    this.l = i;
                    z = true;
                } else if ((wnVar instanceof cx7) && ((cx7) wnVar).a() == this.a) {
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

    public void r(dx7 dx7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, dx7Var) == null) {
            s(dx7Var, false);
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

    public void s(dx7 dx7Var, boolean z) {
        zo8 zo8Var;
        PostData postData;
        boolean z2;
        dx7 dx7Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048602, this, dx7Var, z) != null) || dx7Var == null) {
            return;
        }
        this.d = dx7Var;
        if (dx7Var != null && dx7Var.Q() != null && dx7Var.Q().getAuthor() != null) {
            this.h = dx7Var.Q().getAuthor().getUserId();
        }
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        this.g.clear();
        Iterator<PostData> it = dx7Var.H().iterator();
        while (true) {
            zo8Var = null;
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
        if (postData == null && dx7Var.j() != null) {
            postData = dx7Var.j();
        }
        if (postData != null) {
            this.g.add(postData);
        }
        F(dx7Var);
        G(this.h);
        int i = 0;
        if (!ListUtils.isEmpty(dx7Var.H()) && dx7Var.H().get(0) != null && dx7Var.Q() != null) {
            dx7Var.Q().setItem(dx7Var.H().get(0).Q());
            dx7Var.Q().setItemStar(dx7Var.H().get(0).R());
        }
        if (dx7Var.Q() != null && dx7Var.Q().getRawThreadInfo() != null) {
            vu4 vu4Var = new vu4();
            vu4Var.t = dx7Var.Q();
            vu4Var.n = true;
            this.g.add(vu4Var);
        }
        rx7 rx7Var = new rx7(dx7Var.Q(), dx7Var.d());
        rx7Var.j(false);
        rx7Var.b = false;
        this.g.add(rx7Var);
        if (postData != null && postData.j0 != null && (dx7Var.l() == null || !TextUtils.equals(dx7Var.l().getName(), this.b.K().r1()) || !this.b.K().x1())) {
            gx7 gx7Var = new gx7(postData.j0);
            gx7Var.b = this.b.K().m2();
            this.g.add(gx7Var);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && dx7Var.l() != null && !StringUtils.isNull(dx7Var.l().getName()) && (!TextUtils.equals(dx7Var.l().getName(), this.b.K().r1()) || !this.b.K().x1())) {
            fx7 fx7Var = new fx7(dx7Var.l());
            fx7Var.g = this.b.K().m2();
            fx7Var.e = false;
            this.g.add(fx7Var);
            rx7Var.j(false);
            rx7Var.b = false;
        }
        if (dx7Var.Q() != null && !StringUtils.isNull(dx7Var.Q().getForum_name())) {
            xx7 xx7Var = new xx7();
            xx7Var.a = dx7Var.Q();
            this.g.add(xx7Var);
        } else if (dx7Var.Q() != null && !StringUtils.isNull(dx7Var.n())) {
            dx7Var.Q().setForum_name(dx7Var.n());
            xx7 xx7Var2 = new xx7();
            xx7Var2.a = dx7Var.Q();
            this.g.add(xx7Var2);
        }
        if (j() && dx7Var.z() != null && dx7Var.z().c() == 1) {
            lx7 lx7Var = new lx7(lx7.c);
            lx7Var.b(true);
            this.g.add(lx7Var);
        }
        qx7 qx7Var = new qx7(qx7.i);
        ThreadData Q = dx7Var.Q();
        if (Q != null) {
            Q.getReply_num();
        }
        this.b.K().k2();
        qx7Var.d = k();
        qx7Var.c = dx7Var.g;
        dx7Var.c();
        qx7Var.e = dx7Var.l0();
        qx7Var.g = dx7Var.f;
        D(dx7Var);
        this.g.add(qx7Var);
        if (dx7Var.N() == 4) {
            this.g.add(new px7());
        }
        H();
        p(i());
        Iterator<PostData> it2 = dx7Var.H().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.D() != 1) {
                this.g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !BdNetTypeUtil.isNetWorkAvailable()) && ((dx7Var2 = this.d) == null || !dx7Var2.t()))) {
            nx7 nx7Var = new nx7();
            nx7Var.W0 = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0afb);
            nx7Var.V0 = R.drawable.new_pic_emotion_03;
            nx7Var.X0 = -2;
            nx7Var.Y0 = xi.g(this.b.getContext(), R.dimen.tbds74);
            this.g.add(nx7Var);
        }
        q(dx7Var, this.j, this.h, this.i);
        if (dx7Var.z().b() == 0) {
            dx7 dx7Var3 = this.d;
            if (dx7Var3 != null && dx7Var3.t()) {
                C(this.b.B().O3());
                this.g.add(new kx7());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.d.m());
                statisticItem.param("fname", this.d.n());
                statisticItem.param("tid", this.d.S());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                B(this.b.B().O3());
                jx7 jx7Var = new jx7();
                jx7Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a18);
                this.g.add(jx7Var);
            }
            List<zo8> c0 = dx7Var.c0();
            int i2 = -1;
            if (c0 != null && !c0.isEmpty()) {
                zo8Var = c0.get(0);
                i2 = zo8Var.getPosition();
            }
            if (!ListUtils.isEmpty(dx7Var.f())) {
                cx7 cx7Var = new cx7();
                cx7Var.f(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f100b));
                cx7Var.c(this.a);
                this.g.add(cx7Var);
                int i3 = 1;
                for (is4 is4Var : dx7Var.f()) {
                    if (c0 != null && i3 == i2) {
                        if (zo8Var != null) {
                            b(zo8Var);
                            this.g.add(zo8Var);
                            i++;
                            if (zo8Var.getType() != AdvertAppInfo.x) {
                                i3++;
                            }
                        }
                        if (i < c0.size()) {
                            zo8 zo8Var2 = c0.get(i);
                            zo8Var = zo8Var2;
                            i2 = zo8Var2.getPosition();
                        }
                    }
                    this.g.add(is4Var);
                    i3++;
                    if (i3 == 4 && dx7Var.D() != null) {
                        this.g.add(dx7Var.D());
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
