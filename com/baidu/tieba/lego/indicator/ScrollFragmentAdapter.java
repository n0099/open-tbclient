package com.baidu.tieba.lego.indicator;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import c.a.p0.a4.s0.b;
import c.a.p0.b2.d;
import c.a.p0.b2.g;
import c.a.p0.b2.p.c;
import c.a.p0.b2.p.e;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes5.dex */
public class ScrollFragmentAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f34275b;

    /* renamed from: c  reason: collision with root package name */
    public int f34276c;

    /* renamed from: d  reason: collision with root package name */
    public int f34277d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c> f34278e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<LegoListView> f34279f;

    /* renamed from: g  reason: collision with root package name */
    public LegoHotPageView f34280g;

    /* renamed from: h  reason: collision with root package name */
    public g f34281h;

    /* loaded from: classes5.dex */
    public class a implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollFragmentAdapter a;

        public a(ScrollFragmentAdapter scrollFragmentAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollFragmentAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollFragmentAdapter;
        }

        @Override // c.a.p0.b2.g
        public void a(e eVar, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, eVar, i) == null) || i < 0 || this.a.f34278e == null || this.a.f34278e.size() <= 0) {
                return;
            }
            Iterator it = this.a.f34278e.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar != null && cVar.h() != null && eVar == cVar.h()) {
                    cVar.p(i);
                    return;
                }
            }
        }
    }

    public ScrollFragmentAdapter(Context context, d dVar, c.a.p0.b2.c cVar, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, dVar, cVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34276c = -1;
        this.f34277d = -1;
        this.f34281h = new a(this);
        this.a = context;
        this.f34275b = bdUniqueId;
        this.f34278e = new ArrayList<>();
        ArrayList<LegoListView> arrayList = new ArrayList<>();
        this.f34279f = arrayList;
        arrayList.add(d(dVar));
        this.f34279f.add(d(dVar));
        this.f34279f.add(d(dVar));
        LegoHotPageView legoHotPageView = new LegoHotPageView(context);
        this.f34280g = legoHotPageView;
        legoHotPageView.setPageUniqueId(bdUniqueId);
        this.f34280g.setCallback(cVar);
    }

    public final View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = this.f34276c;
            if (i == this.f34277d) {
                return this.f34280g;
            }
            return (View) ListUtils.getItem(this.f34279f, i % 3);
        }
        return (View) invokeV.objValue;
    }

    public final LegoListView d(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar)) == null) {
            LegoListView legoListView = new LegoListView(this.a);
            legoListView.v(this.f34275b);
            legoListView.setCallback(dVar);
            legoListView.setScrollCallback(this.f34281h);
            return legoListView;
        }
        return (LegoListView) invokeL.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i, obj) == null) {
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || this.f34279f == null) {
            return;
        }
        LegoHotPageView legoHotPageView = this.f34280g;
        if (legoHotPageView != null) {
            legoHotPageView.w(i);
        }
        Iterator<LegoListView> it = this.f34279f.iterator();
        while (it.hasNext()) {
            LegoListView next = it.next();
            if (next != null) {
                next.s(i);
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View c2 = c();
            if (c2 instanceof LegoHotPageView) {
                ((LegoHotPageView) c2).setViewBackGround();
            } else if (c2 instanceof LegoListView) {
                ((LegoListView) c2).setViewBackGround();
            }
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f34277d = i;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList<c> arrayList = this.f34278e;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        InterceptResult invokeI;
        ArrayList<c> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            int count = getCount();
            if (i < 0 || i >= count || (arrayList = this.f34278e) == null || arrayList.get(i) == null || this.f34278e.get(i).h() == null) {
                return null;
            }
            return this.f34278e.get(i).h().f12572c;
        }
        return (CharSequence) invokeI.objValue;
    }

    public void h(long j, String str) {
        LegoHotPageView legoHotPageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(InputDeviceCompat.SOURCE_TOUCHPAD, this, j, str) == null) || (legoHotPageView = this.f34280g) == null) {
            return;
        }
        legoHotPageView.z(j, str);
    }

    public void i(long j, String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i)}) == null) {
            if (j == this.f34280g.getTagCode()) {
                this.f34280g.B(str2, i);
                return;
            }
            ArrayList<LegoListView> arrayList = this.f34279f;
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

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, viewGroup, i)) == null) {
            if (i == this.f34277d) {
                if (this.f34280g.getParent() != null) {
                    viewGroup.removeView(this.f34280g);
                }
                c cVar = (c) ListUtils.getItem(this.f34278e, i);
                if (cVar != null) {
                    this.f34280g.setTagInfo(cVar.h());
                }
                viewGroup.addView(this.f34280g);
                return this.f34280g;
            }
            LegoListView legoListView = this.f34279f.get(i % 3);
            if (legoListView.getParent() != null) {
                viewGroup.removeView(legoListView);
            }
            legoListView.u(this.f34278e.get(i), true);
            viewGroup.addView(legoListView);
            return legoListView;
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
    }

    public void j(long j, String str, DataRes dataRes, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), str, dataRes, Boolean.valueOf(z)}) == null) {
            if (ListUtils.getCount(this.f34278e) <= 0) {
                LegoHotPageView legoHotPageView = this.f34280g;
                if (legoHotPageView != null) {
                    legoHotPageView.A(dataRes, z);
                }
            } else if (j == 0 && ((c) ListUtils.getItem(this.f34278e, this.f34277d)) != null) {
                this.f34280g.A(dataRes, z);
            } else {
                Iterator<c> it = this.f34278e.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && next.h() != null && j == next.h().a && TextUtils.equals(str, next.h().f12571b)) {
                        this.f34280g.A(dataRes, z);
                        return;
                    }
                }
            }
        }
    }

    public void k(boolean z, long j, String str, DataRes dataRes, boolean z2, int i) {
        ArrayList<c> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), str, dataRes, Boolean.valueOf(z2), Integer.valueOf(i)}) == null) || (arrayList = this.f34278e) == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<c> it = this.f34278e.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && next.h() != null && j == next.h().a && TextUtils.equals(str, next.h().f12571b)) {
                next.c(z, dataRes, z2, i);
                notifyDataSetChanged();
                m(j, str, next);
                return;
            }
        }
    }

    public void l(List<c> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            if (this.f34278e == null) {
                this.f34278e = new ArrayList<>();
            }
            this.f34278e.clear();
            if (list != null && list.size() > 0) {
                this.f34278e.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    public final void m(long j, String str, c cVar) {
        ArrayList<LegoListView> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j), str, cVar}) == null) || (arrayList = this.f34279f) == null) {
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
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048592, this, viewGroup, i, obj) == null) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (this.f34276c != i) {
                f();
                this.f34276c = i;
                VoiceManager a2 = b.a(this.a);
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
