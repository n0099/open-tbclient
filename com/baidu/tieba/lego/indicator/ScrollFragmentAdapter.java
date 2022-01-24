package com.baidu.tieba.lego.indicator;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import c.a.t0.x3.r0.b;
import c.a.t0.y1.d;
import c.a.t0.y1.g;
import c.a.t0.y1.p.c;
import c.a.t0.y1.p.e;
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
/* loaded from: classes12.dex */
public class ScrollFragmentAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f45669b;

    /* renamed from: c  reason: collision with root package name */
    public int f45670c;

    /* renamed from: d  reason: collision with root package name */
    public int f45671d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c> f45672e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<LegoListView> f45673f;

    /* renamed from: g  reason: collision with root package name */
    public LegoHotPageView f45674g;

    /* renamed from: h  reason: collision with root package name */
    public g f45675h;

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = scrollFragmentAdapter;
        }

        @Override // c.a.t0.y1.g
        public void a(e eVar, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, eVar, i2) == null) || i2 < 0 || this.a.f45672e == null || this.a.f45672e.size() <= 0) {
                return;
            }
            Iterator it = this.a.f45672e.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar != null && cVar.h() != null && eVar == cVar.h()) {
                    cVar.p(i2);
                    return;
                }
            }
        }
    }

    public ScrollFragmentAdapter(Context context, d dVar, c.a.t0.y1.c cVar, BdUniqueId bdUniqueId) {
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
        this.f45670c = -1;
        this.f45671d = -1;
        this.f45675h = new a(this);
        this.a = context;
        this.f45669b = bdUniqueId;
        this.f45672e = new ArrayList<>();
        ArrayList<LegoListView> arrayList = new ArrayList<>();
        this.f45673f = arrayList;
        arrayList.add(c(dVar));
        this.f45673f.add(c(dVar));
        this.f45673f.add(c(dVar));
        LegoHotPageView legoHotPageView = new LegoHotPageView(context);
        this.f45674g = legoHotPageView;
        legoHotPageView.setPageUniqueId(bdUniqueId);
        this.f45674g.setCallback(cVar);
    }

    public final View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f45670c;
            if (i2 == this.f45671d) {
                return this.f45674g;
            }
            return (View) ListUtils.getItem(this.f45673f, i2 % 3);
        }
        return (View) invokeV.objValue;
    }

    public final LegoListView c(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar)) == null) {
            LegoListView legoListView = new LegoListView(this.a);
            legoListView.registerListener(this.f45669b);
            legoListView.setCallback(dVar);
            legoListView.setScrollCallback(this.f45675h);
            return legoListView;
        }
        return (LegoListView) invokeL.objValue;
    }

    public final void d(long j2, String str, c cVar) {
        ArrayList<LegoListView> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), str, cVar}) == null) || (arrayList = this.f45673f) == null) {
            return;
        }
        Iterator<LegoListView> it = arrayList.iterator();
        while (it.hasNext()) {
            LegoListView next = it.next();
            if (next != null && next.isSelf(j2, str)) {
                next.refreshView(cVar, false);
                return;
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i2, obj) == null) {
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList<c> arrayList = this.f45672e;
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            int count = getCount();
            if (i2 < 0 || i2 >= count || (arrayList = this.f45672e) == null || arrayList.get(i2) == null || this.f45672e.get(i2).h() == null) {
                return null;
            }
            return this.f45672e.get(i2).h().f25535c;
        }
        return (CharSequence) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i2)) == null) {
            if (i2 == this.f45671d) {
                if (this.f45674g.getParent() != null) {
                    viewGroup.removeView(this.f45674g);
                }
                c cVar = (c) ListUtils.getItem(this.f45672e, i2);
                if (cVar != null) {
                    this.f45674g.setTagInfo(cVar.h());
                }
                viewGroup.addView(this.f45674g);
                return this.f45674g;
            }
            LegoListView legoListView = this.f45673f.get(i2 % 3);
            if (legoListView.getParent() != null) {
                viewGroup.removeView(legoListView);
            }
            legoListView.refreshView(this.f45672e.get(i2), true);
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

    public void onChangeSkin(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || this.f45673f == null) {
            return;
        }
        LegoHotPageView legoHotPageView = this.f45674g;
        if (legoHotPageView != null) {
            legoHotPageView.onChangeSkinType(i2);
        }
        Iterator<LegoListView> it = this.f45673f.iterator();
        while (it.hasNext()) {
            LegoListView next = it.next();
            if (next != null) {
                next.onChangeSkinType(i2);
            }
        }
    }

    public void onPageOut() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            View b2 = b();
            if (b2 instanceof LegoHotPageView) {
                ((LegoHotPageView) b2).setViewBackGround();
            } else if (b2 instanceof LegoListView) {
                ((LegoListView) b2).setViewBackGround();
            }
        }
    }

    public void setFirstPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f45671d = i2;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048587, this, viewGroup, i2, obj) == null) {
            super.setPrimaryItem(viewGroup, i2, obj);
            if (this.f45670c != i2) {
                onPageOut();
                this.f45670c = i2;
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

    public void startFirstLoad(long j2, String str) {
        LegoHotPageView legoHotPageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(1048588, this, j2, str) == null) || (legoHotPageView = this.f45674g) == null) {
            return;
        }
        legoHotPageView.startFirstLoad(j2, str);
    }

    public void updateError(long j2, String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j2), str, str2, Integer.valueOf(i2)}) == null) {
            if (j2 == this.f45674g.getTagCode()) {
                this.f45674g.updateError(str2, i2);
                return;
            }
            ArrayList<LegoListView> arrayList = this.f45673f;
            if (arrayList == null) {
                return;
            }
            Iterator<LegoListView> it = arrayList.iterator();
            while (it.hasNext()) {
                LegoListView next = it.next();
                if (next != null && next.isSelf(j2, str)) {
                    next.updateError(str2);
                    return;
                }
            }
        }
    }

    public void updateHotData(long j2, String str, DataRes dataRes, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j2), str, dataRes, Boolean.valueOf(z)}) == null) {
            if (ListUtils.getCount(this.f45672e) <= 0) {
                LegoHotPageView legoHotPageView = this.f45674g;
                if (legoHotPageView != null) {
                    legoHotPageView.updateData(dataRes, z);
                }
            } else if (j2 == 0 && ((c) ListUtils.getItem(this.f45672e, this.f45671d)) != null) {
                this.f45674g.updateData(dataRes, z);
            } else {
                Iterator<c> it = this.f45672e.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && next.h() != null && j2 == next.h().a && TextUtils.equals(str, next.h().f25534b)) {
                        this.f45674g.updateData(dataRes, z);
                        return;
                    }
                }
            }
        }
    }

    public void updateItem(boolean z, long j2, String str, DataRes dataRes, boolean z2, int i2) {
        ArrayList<c> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2), str, dataRes, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || (arrayList = this.f45672e) == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<c> it = this.f45672e.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && next.h() != null && j2 == next.h().a && TextUtils.equals(str, next.h().f25534b)) {
                next.c(z, dataRes, z2, i2);
                notifyDataSetChanged();
                d(j2, str, next);
                return;
            }
        }
    }

    public void updateList(List<c> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
            if (this.f45672e == null) {
                this.f45672e = new ArrayList<>();
            }
            this.f45672e.clear();
            if (list != null && list.size() > 0) {
                this.f45672e.addAll(list);
            }
            notifyDataSetChanged();
        }
    }
}
