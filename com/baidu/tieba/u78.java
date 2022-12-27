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
public class u78 extends j88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyFragment a;
    public BdTypeRecyclerView b;
    public i08 c;
    public final List<kn> d;
    public x28 e;
    public PbReplyLoadMoreAdapter f;
    public kn g;
    public kn h;
    public boolean i;
    public ArrayList<PostData> j;
    public ArrayList<xn> k;
    public String l;
    public boolean m;
    public boolean n;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public TbRichTextView.y q;
    public k18 r;
    public View.OnLongClickListener s;

    public u78(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    @Override // com.baidu.tieba.j88
    public ArrayList<xn> a() {
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

    public final void b(ls8 ls8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ls8Var) == null) && ls8Var != null && this.c != null && ls8Var.getAdvertAppInfo() != null) {
            ls8Var.getAdvertAppInfo().i = new as4();
            if (this.c.z() != null) {
                ls8Var.getAdvertAppInfo().i.b = this.c.z().a();
            }
            ls8Var.getAdvertAppInfo().i.a = ls8Var.o1();
            if (this.c.l() != null && (l = this.c.l()) != null) {
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

    public final boolean c(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof ls8) {
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
            x28 x28Var = new x28(this.a.J(), PostData.N0);
            this.e = x28Var;
            x28Var.x0(this.a.J());
            this.f = new PbReplyLoadMoreAdapter(this.a.J(), PostData.U0);
            this.g = aj8.l().a(this.a.J().getBaseFragmentActivity(), AdvertAppInfo.x);
            this.h = aj8.l().a(this.a.J().getBaseFragmentActivity(), AdvertAppInfo.z);
            this.d.add(this.g);
            this.d.add(this.h);
            this.d.add(this.e);
            this.d.add(this.f);
            this.b.a(this.d);
        }
    }

    public void f(i08 i08Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, i08Var) != null) || i08Var == null) {
            return;
        }
        this.c = i08Var;
        if (i08Var != null && i08Var.Q() != null && i08Var.Q().getAuthor() != null) {
            this.l = i08Var.Q().getAuthor().getUserId();
        }
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.clear();
        i08 i08Var2 = this.c;
        if (i08Var2 != null && i08Var2.H() != null && this.c.H().size() > 0) {
            this.j.addAll(this.c.H());
        }
        this.e.r(i08Var);
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
        kn knVar = this.h;
        if (knVar != null && (knVar instanceof wi8)) {
            ((wi8) knVar).setIsFromCDN(this.n);
        }
        ArrayList<xn> arrayList = new ArrayList<>(i08Var.H());
        boolean z = false;
        PostData postData = null;
        Iterator<xn> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            xn next = it.next();
            if (next instanceof PostData) {
                PostData postData2 = (PostData) next;
                if (postData2.D() == 1) {
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

    public void j(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, yVar) == null) {
            this.q = yVar;
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

    public void m(k18 k18Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, k18Var) == null) {
            this.r = k18Var;
        }
    }

    public final void n() {
        i08 i08Var;
        ls8 ls8Var;
        ls8 ls8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || (i08Var = this.c) == null || i08Var.c0 || i08Var.d0 == 2) {
            return;
        }
        ArrayList<PostData> H = i08Var.H();
        ArrayList<ls8> e = this.c.e();
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
                if (this.c.l() != null) {
                    ls8Var4.Y0 = this.c.l().getId();
                }
                if (this.c.Q() != null) {
                    ls8Var4.b1 = xg.g(this.c.Q().getId(), 0L);
                }
                i08 i08Var2 = this.c;
                if (i08Var2 != null && i08Var2.z() != null) {
                    ls8Var4.c1 = this.c.z().a();
                }
                b(ls8Var4);
                int position = ls8Var4.getPosition() + this.c.b0;
                if (position >= H.size()) {
                    ls8Var4.e1 = position;
                    nk8.k(ls8Var4, 2, position + i3, fm7.i(arrayList));
                    return;
                }
                if (!this.i) {
                    position--;
                    ls8Var4.e1 = position;
                }
                if (position < 0) {
                    nk8.j(ls8Var4, 23);
                } else if (c(H, position)) {
                    nk8.j(ls8Var4, 1);
                } else {
                    H.add(position, ls8Var4);
                    TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", ls8Var4.getAdvertAppInfo().p);
                }
            }
        }
    }
}
