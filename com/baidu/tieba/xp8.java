package com.baidu.tieba;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdRecyclerAdapter;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
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
/* loaded from: classes7.dex */
public class xp8 extends mq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyFragment a;
    public BdTypeRecyclerView b;
    public ki8 c;
    public final List<tm> d;
    public zk8 e;
    public PbReplyLoadMoreAdapter f;
    public tm g;
    public tm h;
    public boolean i;
    public ArrayList<bc9> j;
    public ArrayList<gn> k;
    public String l;
    public boolean m;
    public boolean n;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public TbRichTextView.a0 q;
    public mj8 r;
    public View.OnLongClickListener s;

    public xp8(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {replyFragment, bdTypeRecyclerView};
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
        this.i = true;
        this.l = null;
        this.m = true;
        this.n = false;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.a = replyFragment;
        this.b = bdTypeRecyclerView;
        d();
    }

    @Override // com.baidu.tieba.mq8
    public ArrayList<gn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.k;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (this.b.getAdapter() instanceof BdRecyclerAdapter)) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public final void b(ac9 ac9Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ac9Var) == null) && ac9Var != null && this.c != null && ac9Var.getAdvertAppInfo() != null) {
            ac9Var.getAdvertAppInfo().i = new mw4();
            if (this.c.z() != null) {
                ac9Var.getAdvertAppInfo().i.b = this.c.z().a();
            }
            ac9Var.getAdvertAppInfo().i.a = ac9Var.r1();
            if (this.c.l() != null && (l = this.c.l()) != null) {
                ac9Var.getAdvertAppInfo().i.c = l.getId();
                ac9Var.getAdvertAppInfo().i.d = l.getFirst_class();
                ac9Var.getAdvertAppInfo().i.e = l.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                ac9Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            ac9Var.getAdvertAppInfo().i.g = ac9Var.getAdvertAppInfo().g;
            ac9Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean c(ArrayList<bc9> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof ac9) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            zk8 zk8Var = new zk8(this.a.D(), bc9.Q0);
            this.e = zk8Var;
            zk8Var.z0(this.a.D());
            this.f = new PbReplyLoadMoreAdapter(this.a.D(), bc9.X0);
            this.g = f19.l().a(this.a.D().getBaseFragmentActivity(), AdvertAppInfo.x);
            this.h = f19.l().a(this.a.D().getBaseFragmentActivity(), AdvertAppInfo.z);
            this.d.add(this.g);
            this.d.add(this.h);
            this.d.add(this.e);
            this.d.add(this.f);
            this.b.addAdapters(this.d);
        }
    }

    public void f(ki8 ki8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, ki8Var) != null) || ki8Var == null) {
            return;
        }
        this.c = ki8Var;
        if (ki8Var != null && ki8Var.Q() != null && ki8Var.Q().getAuthor() != null) {
            this.l = ki8Var.Q().getAuthor().getUserId();
        }
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.clear();
        ki8 ki8Var2 = this.c;
        if (ki8Var2 != null && ki8Var2.H() != null && this.c.H().size() > 0) {
            this.j.addAll(this.c.H());
        }
        this.e.r(ki8Var);
        this.e.setFromCDN(this.n);
        this.e.o(this.l);
        this.e.c(this.m);
        this.e.e(this.p);
        this.e.k(this.o);
        this.e.n(this.q);
        this.e.d(this.s);
        this.e.y0(this.r);
        this.f.y(this.p);
        n();
        tm tmVar = this.h;
        if (tmVar != null && (tmVar instanceof b19)) {
            ((b19) tmVar).setIsFromCDN(this.n);
        }
        ArrayList<gn> arrayList = new ArrayList<>(ki8Var.H());
        boolean z = false;
        bc9 bc9Var = null;
        Iterator<gn> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            gn next = it.next();
            if (next instanceof bc9) {
                bc9 bc9Var2 = (bc9) next;
                if (bc9Var2.E() == 1) {
                    bc9Var = bc9Var2;
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            arrayList.remove(bc9Var);
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.b;
        if (bdTypeRecyclerView != null) {
            this.k = arrayList;
            bdTypeRecyclerView.setData(arrayList);
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.n = z;
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.i = z;
        }
    }

    public void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void j(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, a0Var) == null) {
            this.q = a0Var;
        }
    }

    public void k(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onLongClickListener) == null) {
            this.s = onLongClickListener;
        }
    }

    public void l(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.p = onClickListener;
        }
    }

    public void m(mj8 mj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, mj8Var) == null) {
            this.r = mj8Var;
        }
    }

    public final void n() {
        ki8 ki8Var;
        ac9 ac9Var;
        ac9 ac9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || (ki8Var = this.c) == null || ki8Var.c0 || ki8Var.d0 == 2) {
            return;
        }
        ArrayList<bc9> H = ki8Var.H();
        ArrayList<ac9> e = this.c.e();
        if (e != null && !e.isEmpty() && H != null && !H.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<ac9> it = e.iterator();
            while (it.hasNext()) {
                ac9 next = it.next();
                if (next != null && next.q1() != null) {
                    sb.append(next.q1());
                    sb.append(",");
                }
            }
            if (sb.length() > 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            Iterator<ac9> it2 = e.iterator();
            while (it2.hasNext()) {
                ac9 next2 = it2.next();
                if (next2 != null) {
                    next2.h1 = next2.getPosition() - 1;
                }
            }
            SparseArray sparseArray = new SparseArray();
            Iterator<ac9> it3 = e.iterator();
            while (it3.hasNext()) {
                ac9 next3 = it3.next();
                if (next3.getAdvertAppInfo() != null) {
                    int k = next3.getAdvertAppInfo().k();
                    if (k != 0) {
                        s29.j(next3, k);
                        if (k != 28 && k != 31) {
                            next3.getAdvertAppInfo().c = -1001;
                            Log.e("cq", "updateAppData，Data InValidate: " + k);
                        }
                    }
                    sparseArray.put(next3.getPosition(), next3);
                }
            }
            HashMap hashMap = new HashMap();
            for (int i = 0; i < sparseArray.size(); i++) {
                ac9 ac9Var3 = (ac9) sparseArray.get(sparseArray.keyAt(i));
                if (ac9Var3 != null && (ac9Var2 = (ac9) hashMap.put(ac9Var3.p1(), ac9Var3)) != null) {
                    s29.j(ac9Var2, 30);
                }
            }
            sparseArray.clear();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && (ac9Var = (ac9) entry.getValue()) != null) {
                    sparseArray.put(ac9Var.getPosition(), ac9Var);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
            }
            Collections.sort(arrayList);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                ac9 ac9Var4 = (ac9) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
                if (this.c.l() != null) {
                    ac9Var4.b1 = this.c.l().getId();
                }
                if (this.c.Q() != null) {
                    ac9Var4.e1 = gg.g(this.c.Q().getId(), 0L);
                }
                ki8 ki8Var2 = this.c;
                if (ki8Var2 != null && ki8Var2.z() != null) {
                    ac9Var4.f1 = this.c.z().a();
                }
                b(ac9Var4);
                int position = ac9Var4.getPosition() + this.c.b0;
                if (position >= H.size()) {
                    ac9Var4.h1 = position;
                    s29.k(ac9Var4, 2, position + i3, v38.i(arrayList));
                    return;
                }
                if (!this.i) {
                    position--;
                    ac9Var4.h1 = position;
                }
                if (position < 0) {
                    s29.j(ac9Var4, 23);
                } else if (c(H, position)) {
                    s29.j(ac9Var4, 1);
                } else {
                    H.add(position, ac9Var4);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", ac9Var4.getAdvertAppInfo().p);
                }
            }
        }
    }
}
