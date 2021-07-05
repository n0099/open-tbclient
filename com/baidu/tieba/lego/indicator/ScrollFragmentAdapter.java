package com.baidu.tieba.lego.indicator;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.lego.LegoHotPageView;
import com.baidu.tieba.lego.LegoListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.h3.p0.b;
import d.a.s0.n1.d;
import d.a.s0.n1.g;
import d.a.s0.n1.p.c;
import d.a.s0.n1.p.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes5.dex */
public class ScrollFragmentAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f18251a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f18252b;

    /* renamed from: c  reason: collision with root package name */
    public int f18253c;

    /* renamed from: d  reason: collision with root package name */
    public int f18254d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c> f18255e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<LegoListView> f18256f;

    /* renamed from: g  reason: collision with root package name */
    public LegoHotPageView f18257g;

    /* renamed from: h  reason: collision with root package name */
    public g f18258h;

    /* loaded from: classes5.dex */
    public class a implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentAdapter f18259a;

        public a(ScrollFragmentAdapter scrollFragmentAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18259a = scrollFragmentAdapter;
        }

        @Override // d.a.s0.n1.g
        public void a(e eVar, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, eVar, i2) == null) || i2 < 0 || this.f18259a.f18255e == null || this.f18259a.f18255e.size() <= 0) {
                return;
            }
            Iterator it = this.f18259a.f18255e.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar != null && cVar.i() != null && eVar == cVar.i()) {
                    cVar.q(i2);
                    return;
                }
            }
        }
    }

    public ScrollFragmentAdapter(Context context, d dVar, d.a.s0.n1.c cVar, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, dVar, cVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18253c = -1;
        this.f18254d = -1;
        this.f18258h = new a(this);
        this.f18251a = context;
        this.f18252b = bdUniqueId;
        this.f18255e = new ArrayList<>();
        ArrayList<LegoListView> arrayList = new ArrayList<>();
        this.f18256f = arrayList;
        arrayList.add(f(dVar));
        this.f18256f.add(f(dVar));
        this.f18256f.add(f(dVar));
        LegoHotPageView legoHotPageView = new LegoHotPageView(context);
        this.f18257g = legoHotPageView;
        legoHotPageView.setPageUniqueId(bdUniqueId);
        this.f18257g.setCallback(cVar);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i2, obj) == null) {
        }
    }

    public final View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.f18253c;
            if (i2 == this.f18254d) {
                return this.f18257g;
            }
            return (View) ListUtils.getItem(this.f18256f, i2 % 3);
        }
        return (View) invokeV.objValue;
    }

    public final LegoListView f(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) {
            LegoListView legoListView = new LegoListView(this.f18251a);
            legoListView.v(this.f18252b);
            legoListView.setCallback(dVar);
            legoListView.setScrollCallback(this.f18258h);
            return legoListView;
        }
        return (LegoListView) invokeL.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList<c> arrayList = this.f18255e;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i2) {
        InterceptResult invokeI;
        ArrayList<c> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            int count = getCount();
            if (i2 < 0 || i2 >= count || (arrayList = this.f18255e) == null || arrayList.get(i2) == null || this.f18255e.get(i2).i() == null) {
                return null;
            }
            return this.f18255e.get(i2).i().f63905c;
        }
        return (CharSequence) invokeI.objValue;
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || this.f18256f == null) {
            return;
        }
        LegoHotPageView legoHotPageView = this.f18257g;
        if (legoHotPageView != null) {
            legoHotPageView.w(i2);
        }
        Iterator<LegoListView> it = this.f18256f.iterator();
        while (it.hasNext()) {
            LegoListView next = it.next();
            if (next != null) {
                next.s(i2);
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i2)) == null) {
            if (i2 == this.f18254d) {
                if (this.f18257g.getParent() != null) {
                    viewGroup.removeView(this.f18257g);
                }
                c cVar = (c) ListUtils.getItem(this.f18255e, i2);
                if (cVar != null) {
                    this.f18257g.setTagInfo(cVar.i());
                }
                viewGroup.addView(this.f18257g);
                return this.f18257g;
            }
            LegoListView legoListView = this.f18256f.get(i2 % 3);
            if (legoListView.getParent() != null) {
                viewGroup.removeView(legoListView);
            }
            legoListView.u(this.f18255e.get(i2), true);
            viewGroup.addView(legoListView);
            return legoListView;
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            View e2 = e();
            if (e2 instanceof LegoHotPageView) {
                ((LegoHotPageView) e2).setViewBackGround();
            } else if (e2 instanceof LegoListView) {
                ((LegoListView) e2).setViewBackGround();
            }
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f18254d = i2;
        }
    }

    public void l(long j, String str) {
        LegoHotPageView legoHotPageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(1048586, this, j, str) == null) || (legoHotPageView = this.f18257g) == null) {
            return;
        }
        legoHotPageView.z(j, str);
    }

    public void m(long j, String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i2)}) == null) {
            if (j == this.f18257g.getTagCode()) {
                this.f18257g.B(str2, i2);
                return;
            }
            ArrayList<LegoListView> arrayList = this.f18256f;
            if (arrayList == null) {
                return;
            }
            Iterator<LegoListView> it = arrayList.iterator();
            while (it.hasNext()) {
                LegoListView next = it.next();
                if (next != null && next.p(j, str)) {
                    next.z(str2);
                    return;
                }
            }
        }
    }

    public void n(long j, String str, DataRes dataRes, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), str, dataRes, Boolean.valueOf(z)}) == null) {
            if (ListUtils.getCount(this.f18255e) <= 0) {
                LegoHotPageView legoHotPageView = this.f18257g;
                if (legoHotPageView != null) {
                    legoHotPageView.A(dataRes, z);
                }
            } else if (j == 0 && ((c) ListUtils.getItem(this.f18255e, this.f18254d)) != null) {
                this.f18257g.A(dataRes, z);
            } else {
                Iterator<c> it = this.f18255e.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && next.i() != null && j == next.i().f63903a && TextUtils.equals(str, next.i().f63904b)) {
                        this.f18257g.A(dataRes, z);
                        return;
                    }
                }
            }
        }
    }

    public void o(boolean z, long j, String str, DataRes dataRes, boolean z2, int i2) {
        ArrayList<c> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), str, dataRes, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || (arrayList = this.f18255e) == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<c> it = this.f18255e.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && next.i() != null && j == next.i().f63903a && TextUtils.equals(str, next.i().f63904b)) {
                next.c(z, dataRes, z2, i2);
                notifyDataSetChanged();
                q(j, str, next);
                return;
            }
        }
    }

    public void p(List<c> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            if (this.f18255e == null) {
                this.f18255e = new ArrayList<>();
            }
            this.f18255e.clear();
            if (list != null && list.size() > 0) {
                this.f18255e.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    public final void q(long j, String str, c cVar) {
        ArrayList<LegoListView> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j), str, cVar}) == null) || (arrayList = this.f18256f) == null) {
            return;
        }
        Iterator<LegoListView> it = arrayList.iterator();
        while (it.hasNext()) {
            LegoListView next = it.next();
            if (next != null && next.p(j, str)) {
                next.u(cVar, false);
                return;
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048592, this, viewGroup, i2, obj) == null) {
            super.setPrimaryItem(viewGroup, i2, obj);
            if (this.f18253c != i2) {
                j();
                this.f18253c = i2;
                VoiceManager a2 = b.a(this.f18251a);
                if (a2 != null) {
                    a2.stopPlay();
                }
                if (obj instanceof LegoListView) {
                    ((LegoListView) obj).setViewForeground();
                } else if (obj instanceof LegoHotPageView) {
                    ((LegoHotPageView) obj).setViewForeground();
                }
            }
        }
    }
}
