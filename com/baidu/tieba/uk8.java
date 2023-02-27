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
import com.baidu.tieba.tbadkCore.data.PostData;
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
public class uk8 extends jl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyFragment a;
    public BdTypeRecyclerView b;
    public hd8 c;
    public final List<qn> d;
    public wf8 e;
    public PbReplyLoadMoreAdapter f;
    public qn g;
    public qn h;
    public boolean i;
    public ArrayList<PostData> j;
    public ArrayList<Cdo> k;
    public String l;
    public boolean m;
    public boolean n;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public TbRichTextView.a0 q;
    public je8 r;
    public View.OnLongClickListener s;

    public uk8(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    @Override // com.baidu.tieba.jl8
    public ArrayList<Cdo> a() {
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

    public final void b(v59 v59Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v59Var) == null) && v59Var != null && this.c != null && v59Var.getAdvertAppInfo() != null) {
            v59Var.getAdvertAppInfo().i = new ey4();
            if (this.c.z() != null) {
                v59Var.getAdvertAppInfo().i.b = this.c.z().a();
            }
            v59Var.getAdvertAppInfo().i.a = v59Var.r1();
            if (this.c.l() != null && (l = this.c.l()) != null) {
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

    public final boolean c(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof v59) {
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
            wf8 wf8Var = new wf8(this.a.J(), PostData.Q0);
            this.e = wf8Var;
            wf8Var.x0(this.a.J());
            this.f = new PbReplyLoadMoreAdapter(this.a.J(), PostData.X0);
            this.g = cw8.l().a(this.a.J().getBaseFragmentActivity(), AdvertAppInfo.x);
            this.h = cw8.l().a(this.a.J().getBaseFragmentActivity(), AdvertAppInfo.z);
            this.d.add(this.g);
            this.d.add(this.h);
            this.d.add(this.e);
            this.d.add(this.f);
            this.b.a(this.d);
        }
    }

    public void f(hd8 hd8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, hd8Var) != null) || hd8Var == null) {
            return;
        }
        this.c = hd8Var;
        if (hd8Var != null && hd8Var.Q() != null && hd8Var.Q().getAuthor() != null) {
            this.l = hd8Var.Q().getAuthor().getUserId();
        }
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.clear();
        hd8 hd8Var2 = this.c;
        if (hd8Var2 != null && hd8Var2.H() != null && this.c.H().size() > 0) {
            this.j.addAll(this.c.H());
        }
        this.e.r(hd8Var);
        this.e.setFromCDN(this.n);
        this.e.o(this.l);
        this.e.c(this.m);
        this.e.e(this.p);
        this.e.k(this.o);
        this.e.n(this.q);
        this.e.d(this.s);
        this.e.w0(this.r);
        this.f.w(this.p);
        n();
        qn qnVar = this.h;
        if (qnVar != null && (qnVar instanceof yv8)) {
            ((yv8) qnVar).setIsFromCDN(this.n);
        }
        ArrayList<Cdo> arrayList = new ArrayList<>(hd8Var.H());
        boolean z = false;
        PostData postData = null;
        Iterator<Cdo> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Cdo next = it.next();
            if (next instanceof PostData) {
                PostData postData2 = (PostData) next;
                if (postData2.F() == 1) {
                    postData = postData2;
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            arrayList.remove(postData);
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

    public void m(je8 je8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, je8Var) == null) {
            this.r = je8Var;
        }
    }

    public final void n() {
        hd8 hd8Var;
        v59 v59Var;
        v59 v59Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || (hd8Var = this.c) == null || hd8Var.c0 || hd8Var.d0 == 2) {
            return;
        }
        ArrayList<PostData> H = hd8Var.H();
        ArrayList<v59> e = this.c.e();
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
                if (this.c.l() != null) {
                    v59Var4.b1 = this.c.l().getId();
                }
                if (this.c.Q() != null) {
                    v59Var4.e1 = dh.g(this.c.Q().getId(), 0L);
                }
                hd8 hd8Var2 = this.c;
                if (hd8Var2 != null && hd8Var2.z() != null) {
                    v59Var4.f1 = this.c.z().a();
                }
                b(v59Var4);
                int position = v59Var4.getPosition() + this.c.b0;
                if (position >= H.size()) {
                    v59Var4.h1 = position;
                    px8.k(v59Var4, 2, position + i3, ry7.i(arrayList));
                    return;
                }
                if (!this.i) {
                    position--;
                    v59Var4.h1 = position;
                }
                if (position < 0) {
                    px8.j(v59Var4, 23);
                } else if (c(H, position)) {
                    px8.j(v59Var4, 1);
                } else {
                    H.add(position, v59Var4);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", v59Var4.getAdvertAppInfo().p);
                }
            }
        }
    }
}
