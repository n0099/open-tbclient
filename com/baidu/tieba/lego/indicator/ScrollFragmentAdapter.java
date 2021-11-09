package com.baidu.tieba.lego.indicator;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import b.a.r0.l3.r0.b;
import b.a.r0.q1.d;
import b.a.r0.q1.g;
import b.a.r0.q1.p.c;
import b.a.r0.q1.p.e;
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
/* loaded from: classes9.dex */
public class ScrollFragmentAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f51218a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f51219b;

    /* renamed from: c  reason: collision with root package name */
    public int f51220c;

    /* renamed from: d  reason: collision with root package name */
    public int f51221d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c> f51222e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<LegoListView> f51223f;

    /* renamed from: g  reason: collision with root package name */
    public LegoHotPageView f51224g;

    /* renamed from: h  reason: collision with root package name */
    public g f51225h;

    /* loaded from: classes9.dex */
    public class a implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScrollFragmentAdapter f51226a;

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
            this.f51226a = scrollFragmentAdapter;
        }

        @Override // b.a.r0.q1.g
        public void a(e eVar, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, eVar, i2) == null) || i2 < 0 || this.f51226a.f51222e == null || this.f51226a.f51222e.size() <= 0) {
                return;
            }
            Iterator it = this.f51226a.f51222e.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar != null && cVar.i() != null && eVar == cVar.i()) {
                    cVar.q(i2);
                    return;
                }
            }
        }
    }

    public ScrollFragmentAdapter(Context context, d dVar, b.a.r0.q1.c cVar, BdUniqueId bdUniqueId) {
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
        this.f51220c = -1;
        this.f51221d = -1;
        this.f51225h = new a(this);
        this.f51218a = context;
        this.f51219b = bdUniqueId;
        this.f51222e = new ArrayList<>();
        ArrayList<LegoListView> arrayList = new ArrayList<>();
        this.f51223f = arrayList;
        arrayList.add(c(dVar));
        this.f51223f.add(c(dVar));
        this.f51223f.add(c(dVar));
        LegoHotPageView legoHotPageView = new LegoHotPageView(context);
        this.f51224g = legoHotPageView;
        legoHotPageView.setPageUniqueId(bdUniqueId);
        this.f51224g.setCallback(cVar);
    }

    public final View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f51220c;
            if (i2 == this.f51221d) {
                return this.f51224g;
            }
            return (View) ListUtils.getItem(this.f51223f, i2 % 3);
        }
        return (View) invokeV.objValue;
    }

    public final LegoListView c(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar)) == null) {
            LegoListView legoListView = new LegoListView(this.f51218a);
            legoListView.registerListener(this.f51219b);
            legoListView.setCallback(dVar);
            legoListView.setScrollCallback(this.f51225h);
            return legoListView;
        }
        return (LegoListView) invokeL.objValue;
    }

    public final void d(long j, String str, c cVar) {
        ArrayList<LegoListView> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), str, cVar}) == null) || (arrayList = this.f51223f) == null) {
            return;
        }
        Iterator<LegoListView> it = arrayList.iterator();
        while (it.hasNext()) {
            LegoListView next = it.next();
            if (next != null && next.isSelf(j, str)) {
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
            ArrayList<c> arrayList = this.f51222e;
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
            if (i2 < 0 || i2 >= count || (arrayList = this.f51222e) == null || arrayList.get(i2) == null || this.f51222e.get(i2).i() == null) {
                return null;
            }
            return this.f51222e.get(i2).i().f22740c;
        }
        return (CharSequence) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i2)) == null) {
            if (i2 == this.f51221d) {
                if (this.f51224g.getParent() != null) {
                    viewGroup.removeView(this.f51224g);
                }
                c cVar = (c) ListUtils.getItem(this.f51222e, i2);
                if (cVar != null) {
                    this.f51224g.setTagInfo(cVar.i());
                }
                viewGroup.addView(this.f51224g);
                return this.f51224g;
            }
            LegoListView legoListView = this.f51223f.get(i2 % 3);
            if (legoListView.getParent() != null) {
                viewGroup.removeView(legoListView);
            }
            legoListView.refreshView(this.f51222e.get(i2), true);
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
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || this.f51223f == null) {
            return;
        }
        LegoHotPageView legoHotPageView = this.f51224g;
        if (legoHotPageView != null) {
            legoHotPageView.onChangeSkinType(i2);
        }
        Iterator<LegoListView> it = this.f51223f.iterator();
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
            this.f51221d = i2;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048587, this, viewGroup, i2, obj) == null) {
            super.setPrimaryItem(viewGroup, i2, obj);
            if (this.f51220c != i2) {
                onPageOut();
                this.f51220c = i2;
                VoiceManager a2 = b.a(this.f51218a);
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

    public void startFirstLoad(long j, String str) {
        LegoHotPageView legoHotPageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(1048588, this, j, str) == null) || (legoHotPageView = this.f51224g) == null) {
            return;
        }
        legoHotPageView.startFirstLoad(j, str);
    }

    public void updateError(long j, String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i2)}) == null) {
            if (j == this.f51224g.getTagCode()) {
                this.f51224g.updateError(str2, i2);
                return;
            }
            ArrayList<LegoListView> arrayList = this.f51223f;
            if (arrayList == null) {
                return;
            }
            Iterator<LegoListView> it = arrayList.iterator();
            while (it.hasNext()) {
                LegoListView next = it.next();
                if (next != null && next.isSelf(j, str)) {
                    next.updateError(str2);
                    return;
                }
            }
        }
    }

    public void updateHotData(long j, String str, DataRes dataRes, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), str, dataRes, Boolean.valueOf(z)}) == null) {
            if (ListUtils.getCount(this.f51222e) <= 0) {
                LegoHotPageView legoHotPageView = this.f51224g;
                if (legoHotPageView != null) {
                    legoHotPageView.updateData(dataRes, z);
                }
            } else if (j == 0 && ((c) ListUtils.getItem(this.f51222e, this.f51221d)) != null) {
                this.f51224g.updateData(dataRes, z);
            } else {
                Iterator<c> it = this.f51222e.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null && next.i() != null && j == next.i().f22738a && TextUtils.equals(str, next.i().f22739b)) {
                        this.f51224g.updateData(dataRes, z);
                        return;
                    }
                }
            }
        }
    }

    public void updateItem(boolean z, long j, String str, DataRes dataRes, boolean z2, int i2) {
        ArrayList<c> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), str, dataRes, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || (arrayList = this.f51222e) == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<c> it = this.f51222e.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && next.i() != null && j == next.i().f22738a && TextUtils.equals(str, next.i().f22739b)) {
                next.d(z, dataRes, z2, i2);
                notifyDataSetChanged();
                d(j, str, next);
                return;
            }
        }
    }

    public void updateList(List<c> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
            if (this.f51222e == null) {
                this.f51222e = new ArrayList<>();
            }
            this.f51222e.clear();
            if (list != null && list.size() > 0) {
                this.f51222e.addAll(list);
            }
            notifyDataSetChanged();
        }
    }
}
