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
import com.baidu.tieba.iq8;
import com.baidu.tieba.kq8;
import com.baidu.tieba.lego.LegoHotPageView;
import com.baidu.tieba.lego.LegoListView;
import com.baidu.tieba.po8;
import com.baidu.tieba.qo8;
import com.baidu.tieba.to8;
import com.baidu.tieba.u1a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.Lego.DataRes;
/* loaded from: classes6.dex */
public class ScrollFragmentAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public BdUniqueId b;
    public int c;
    public int d;
    public ArrayList<iq8> e;
    public ArrayList<LegoListView> f;
    public LegoHotPageView g;
    public to8 h;

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i, obj) == null) {
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view2, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, view2, obj)) == null) ? view2 == obj : invokeLL.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class a implements to8 {
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

        @Override // com.baidu.tieba.to8
        public void a(kq8 kq8Var, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, kq8Var, i) == null) && i >= 0 && this.a.e != null && this.a.e.size() > 0) {
                Iterator it = this.a.e.iterator();
                while (it.hasNext()) {
                    iq8 iq8Var = (iq8) it.next();
                    if (iq8Var != null && iq8Var.h() != null && kq8Var == iq8Var.h()) {
                        iq8Var.p(i);
                        return;
                    }
                }
            }
        }
    }

    public ScrollFragmentAdapter(Context context, qo8 qo8Var, po8 po8Var, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, qo8Var, po8Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = -1;
        this.d = -1;
        this.h = new a(this);
        this.a = context;
        this.b = bdUniqueId;
        this.e = new ArrayList<>();
        ArrayList<LegoListView> arrayList = new ArrayList<>();
        this.f = arrayList;
        arrayList.add(d(qo8Var));
        this.f.add(d(qo8Var));
        this.f.add(d(qo8Var));
        LegoHotPageView legoHotPageView = new LegoHotPageView(context);
        this.g = legoHotPageView;
        legoHotPageView.setPageUniqueId(bdUniqueId);
        this.g.setCallback(po8Var);
    }

    public void j(long j, String str, DataRes dataRes, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), str, dataRes, Boolean.valueOf(z)}) == null) {
            if (ListUtils.getCount(this.e) <= 0) {
                LegoHotPageView legoHotPageView = this.g;
                if (legoHotPageView != null) {
                    legoHotPageView.A(dataRes, z);
                }
            } else if (j == 0 && ((iq8) ListUtils.getItem(this.e, this.d)) != null) {
                this.g.A(dataRes, z);
            } else {
                Iterator<iq8> it = this.e.iterator();
                while (it.hasNext()) {
                    iq8 next = it.next();
                    if (next != null && next.h() != null && j == next.h().a && TextUtils.equals(str, next.h().b)) {
                        this.g.A(dataRes, z);
                        return;
                    }
                }
            }
        }
    }

    public final LegoListView d(qo8 qo8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qo8Var)) == null) {
            LegoListView legoListView = new LegoListView(this.a);
            legoListView.v(this.b);
            legoListView.setCallback(qo8Var);
            legoListView.setScrollCallback(this.h);
            return legoListView;
        }
        return (LegoListView) invokeL.objValue;
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.d = i;
        }
    }

    public void l(List<iq8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            if (this.e == null) {
                this.e = new ArrayList<>();
            }
            this.e.clear();
            if (list != null && list.size() > 0) {
                this.e.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    public final View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = this.c;
            if (i == this.d) {
                return this.g;
            }
            return (View) ListUtils.getItem(this.f, i % 3);
        }
        return (View) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View c = c();
            if (c instanceof LegoHotPageView) {
                ((LegoHotPageView) c).setViewBackGround();
            } else if (c instanceof LegoListView) {
                ((LegoListView) c).setViewBackGround();
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList<iq8> arrayList = this.e;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || this.f == null) {
            return;
        }
        LegoHotPageView legoHotPageView = this.g;
        if (legoHotPageView != null) {
            legoHotPageView.w(i);
        }
        Iterator<LegoListView> it = this.f.iterator();
        while (it.hasNext()) {
            LegoListView next = it.next();
            if (next != null) {
                next.s(i);
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        InterceptResult invokeI;
        ArrayList<iq8> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            int count = getCount();
            if (i < 0 || i >= count || (arrayList = this.e) == null || arrayList.get(i) == null || this.e.get(i).h() == null) {
                return null;
            }
            return this.e.get(i).h().c;
        }
        return (CharSequence) invokeI.objValue;
    }

    public void h(long j, String str) {
        LegoHotPageView legoHotPageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJL(InputDeviceCompat.SOURCE_TOUCHPAD, this, j, str) == null) && (legoHotPageView = this.g) != null) {
            legoHotPageView.z(j, str);
        }
    }

    public void i(long j, String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i)}) == null) {
            if (j == this.g.getTagCode()) {
                this.g.B(str2, i);
                return;
            }
            ArrayList<LegoListView> arrayList = this.f;
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
            if (i == this.d) {
                if (this.g.getParent() != null) {
                    viewGroup.removeView(this.g);
                }
                iq8 iq8Var = (iq8) ListUtils.getItem(this.e, i);
                if (iq8Var != null) {
                    this.g.setTagInfo(iq8Var.h());
                }
                viewGroup.addView(this.g);
                return this.g;
            }
            LegoListView legoListView = this.f.get(i % 3);
            if (legoListView.getParent() != null) {
                viewGroup.removeView(legoListView);
            }
            legoListView.u(this.e.get(i), true);
            viewGroup.addView(legoListView);
            return legoListView;
        }
        return invokeLI.objValue;
    }

    public void k(boolean z, long j, String str, DataRes dataRes, boolean z2, int i) {
        ArrayList<iq8> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), str, dataRes, Boolean.valueOf(z2), Integer.valueOf(i)}) == null) && (arrayList = this.e) != null && !arrayList.isEmpty()) {
            Iterator<iq8> it = this.e.iterator();
            while (it.hasNext()) {
                iq8 next = it.next();
                if (next != null && next.h() != null && j == next.h().a && TextUtils.equals(str, next.h().b)) {
                    next.b(z, dataRes, z2, i);
                    notifyDataSetChanged();
                    m(j, str, next);
                    return;
                }
            }
        }
    }

    public final void m(long j, String str, iq8 iq8Var) {
        ArrayList<LegoListView> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j), str, iq8Var}) != null) || (arrayList = this.f) == null) {
            return;
        }
        Iterator<LegoListView> it = arrayList.iterator();
        while (it.hasNext()) {
            LegoListView next = it.next();
            if (next != null && next.p(j, str)) {
                next.u(iq8Var, false);
                return;
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048592, this, viewGroup, i, obj) == null) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (this.c != i) {
                f();
                this.c = i;
                VoiceManager a2 = u1a.a(this.a);
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
