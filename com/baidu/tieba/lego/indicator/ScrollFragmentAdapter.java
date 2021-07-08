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
import d.a.p0.h3.p0.b;
import d.a.p0.n1.d;
import d.a.p0.n1.g;
import d.a.p0.n1.p.c;
import d.a.p0.n1.p.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes4.dex */
public class ScrollFragmentAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f18291a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f18292b;

    /* renamed from: c  reason: collision with root package name */
    public int f18293c;

    /* renamed from: d  reason: collision with root package name */
    public int f18294d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c> f18295e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<LegoListView> f18296f;

    /* renamed from: g  reason: collision with root package name */
    public LegoHotPageView f18297g;

    /* renamed from: h  reason: collision with root package name */
    public g f18298h;

    /* loaded from: classes4.dex */
    public class a implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentAdapter f18299a;

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
            this.f18299a = scrollFragmentAdapter;
        }

        @Override // d.a.p0.n1.g
        public void a(e eVar, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, eVar, i2) == null) || i2 < 0 || this.f18299a.f18295e == null || this.f18299a.f18295e.size() <= 0) {
                return;
            }
            Iterator it = this.f18299a.f18295e.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar != null && cVar.i() != null && eVar == cVar.i()) {
                    cVar.q(i2);
                    return;
                }
            }
        }
    }

    public ScrollFragmentAdapter(Context context, d dVar, d.a.p0.n1.c cVar, BdUniqueId bdUniqueId) {
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
        this.f18293c = -1;
        this.f18294d = -1;
        this.f18298h = new a(this);
        this.f18291a = context;
        this.f18292b = bdUniqueId;
        this.f18295e = new ArrayList<>();
        ArrayList<LegoListView> arrayList = new ArrayList<>();
        this.f18296f = arrayList;
        arrayList.add(d(dVar));
        this.f18296f.add(d(dVar));
        this.f18296f.add(d(dVar));
        LegoHotPageView legoHotPageView = new LegoHotPageView(context);
        this.f18297g = legoHotPageView;
        legoHotPageView.setPageUniqueId(bdUniqueId);
        this.f18297g.setCallback(cVar);
    }

    public final View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f18293c;
            if (i2 == this.f18294d) {
                return this.f18297g;
            }
            return (View) ListUtils.getItem(this.f18296f, i2 % 3);
        }
        return (View) invokeV.objValue;
    }

    public final LegoListView d(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar)) == null) {
            LegoListView legoListView = new LegoListView(this.f18291a);
            legoListView.v(this.f18292b);
            legoListView.setCallback(dVar);
            legoListView.setScrollCallback(this.f18298h);
            return legoListView;
        }
        return (LegoListView) invokeL.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2, obj) == null) {
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f18296f == null) {
            return;
        }
        LegoHotPageView legoHotPageView = this.f18297g;
        if (legoHotPageView != null) {
            legoHotPageView.w(i2);
        }
        Iterator<LegoListView> it = this.f18296f.iterator();
        while (it.hasNext()) {
            LegoListView next = it.next();
            if (next != null) {
                next.s(i2);
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

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f18294d = i2;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList<c> arrayList = this.f18295e;
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            int count = getCount();
            if (i2 < 0 || i2 >= count || (arrayList = this.f18295e) == null || arrayList.get(i2) == null || this.f18295e.get(i2).i() == null) {
                return null;
            }
            return this.f18295e.get(i2).i().f60671c;
        }
        return (CharSequence) invokeI.objValue;
    }

    public void h(long j, String str) {
        LegoHotPageView legoHotPageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(InputDeviceCompat.SOURCE_TOUCHPAD, this, j, str) == null) || (legoHotPageView = this.f18297g) == null) {
            return;
        }
        legoHotPageView.z(j, str);
    }

    public void i(long j, String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i2)}) == null) {
            if (j == this.f18297g.getTagCode()) {
                this.f18297g.B(str2, i2);
                return;
            }
            ArrayList<LegoListView> arrayList = this.f18296f;
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
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, viewGroup, i2)) == null) {
            if (i2 == this.f18294d) {
                if (this.f18297g.getParent() != null) {
                    viewGroup.removeView(this.f18297g);
                }
                c cVar = (c) ListUtils.getItem(this.f18295e, i2);
                if (cVar != null) {
                    this.f18297g.setTagInfo(cVar.i());
                }
                viewGroup.addView(this.f18297g);
                return this.f18297g;
            }
            LegoListView legoListView = this.f18296f.get(i2 % 3);
            if (legoListView.getParent() != null) {
                viewGroup.removeView(legoListView);
            }
            legoListView.u(this.f18295e.get(i2), true);
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
            if (ListUtils.getCount(this.f18295e) <= 0) {
                LegoHotPageView legoHotPageView = this.f18297g;
                if (legoHotPageView != null) {
                    legoHotPageView.A(dataRes, z);
                }
            } else if (j == 0 && ((c) ListUtils.getItem(this.f18295e, this.f18294d)) != null) {
                this.f18297g.A(dataRes, z);
            } else {
                Iterator<c> it = this.f18295e.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && next.i() != null && j == next.i().f60669a && TextUtils.equals(str, next.i().f60670b)) {
                        this.f18297g.A(dataRes, z);
                        return;
                    }
                }
            }
        }
    }

    public void k(boolean z, long j, String str, DataRes dataRes, boolean z2, int i2) {
        ArrayList<c> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), str, dataRes, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || (arrayList = this.f18295e) == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<c> it = this.f18295e.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && next.i() != null && j == next.i().f60669a && TextUtils.equals(str, next.i().f60670b)) {
                next.c(z, dataRes, z2, i2);
                notifyDataSetChanged();
                m(j, str, next);
                return;
            }
        }
    }

    public void l(List<c> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            if (this.f18295e == null) {
                this.f18295e = new ArrayList<>();
            }
            this.f18295e.clear();
            if (list != null && list.size() > 0) {
                this.f18295e.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    public final void m(long j, String str, c cVar) {
        ArrayList<LegoListView> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j), str, cVar}) == null) || (arrayList = this.f18296f) == null) {
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
            if (this.f18293c != i2) {
                f();
                this.f18293c = i2;
                VoiceManager a2 = b.a(this.f18291a);
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
