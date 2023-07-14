package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class sz8 extends pn {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public List<ICardInfo> j;
    public int k;
    public boolean l;
    public NoDataView m;
    public FrameLayout n;
    public NoDataViewFactory.e o;
    public NoDataViewFactory.d p;
    public NoDataViewFactory.c q;
    public FrameLayout.LayoutParams r;
    public String s;
    public boolean t;

    @Override // com.baidu.tieba.pn, android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) ? i : invokeI.longValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sz8(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = 0;
        this.l = true;
        this.i = tbPageContext;
    }

    public final void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (this.t) {
                int u = u(i - 1);
                int u2 = u(i - 2);
                B(u);
                B(u2);
                return;
            }
            int u3 = u(i + 1);
            int u4 = u(i + 2);
            B(u3);
            B(u4);
        }
    }

    public final ICardInfo x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            for (ICardInfo iCardInfo : this.j) {
                int adapterCount = iCardInfo.getAdapterCount();
                if (i < adapterCount) {
                    return iCardInfo.getAdapterItem(i);
                }
                i -= adapterCount;
            }
            return null;
        }
        return (ICardInfo) invokeI.objValue;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<ICardInfo> list = this.j;
            if (list != null && list.size() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.pn, android.widget.Adapter, com.baidu.tieba.zn
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.k == 0 && this.l) {
                return 1;
            }
            return this.k;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.pn, android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return wz8.a.size() + 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.pn, android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.k == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void v() {
        FrameLayout frameLayout;
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (frameLayout = this.n) != null && (noDataView = this.m) != null) {
            frameLayout.removeView(noDataView);
            this.m = null;
        }
    }

    public final int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            List<ICardInfo> list = this.j;
            int i = 0;
            if (list == null) {
                return 0;
            }
            for (ICardInfo iCardInfo : list) {
                i += iCardInfo.getAdapterCount();
            }
            return i;
        }
        return invokeV.intValue;
    }

    public final void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            ICardInfo iCardInfo = this.j.get(i);
            if (iCardInfo instanceof c09) {
                ((c09) iCardInfo).doLoad(iCardInfo, this.i);
            }
        }
    }

    public void C(List<ICardInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            List<ICardInfo> list2 = this.j;
            if (list2 == null) {
                this.j = new ArrayList();
            } else {
                list2.clear();
            }
            if (list != null) {
                this.j.addAll(list);
            }
            this.k = w();
            notifyDataSetChanged();
        }
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.s = str;
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.l = z;
        }
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.t = z;
        }
    }

    @Override // com.baidu.tieba.pn, android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            ICardInfo x = x(i);
            if (x != null) {
                return wz8.a.get(x.getAdapterType());
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public final int u(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            if (i < 0) {
                i = 0;
            }
            if (i >= this.j.size()) {
                return this.j.size() - 1;
            }
            return i;
        }
        return invokeI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pn, android.widget.Adapter, com.baidu.tieba.zn
    /* renamed from: z */
    public ICardInfo getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            return x(i);
        }
        return (ICardInfo) invokeI.objValue;
    }

    public void F(NoDataViewFactory.d dVar, NoDataViewFactory.e eVar, NoDataViewFactory.c cVar, FrameLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, dVar, eVar, cVar, layoutParams) == null) {
            this.p = dVar;
            this.o = eVar;
            this.q = cVar;
            this.r = layoutParams;
            NoDataView noDataView = this.m;
            if (noDataView != null) {
                noDataView.setTextOption(eVar);
                this.m.setImgOption(dVar);
                this.m.setButtonOption(cVar);
                if (layoutParams != null) {
                    this.m.setLayoutParams(layoutParams);
                }
            }
        }
    }

    @Override // com.baidu.tieba.pn, android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048588, this, i, view2, viewGroup)) == null) {
            if (this.l && A()) {
                return t();
            }
            v();
            D(i);
            ICardInfo x = x(i);
            BaseLegoCardView y = y(view2, x);
            if (y != null) {
                y.a = this.s;
                y.update(x);
            }
            return y;
        }
        return (View) invokeILL.objValue;
    }

    public View t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.n == null) {
                this.n = new FrameLayout(this.i.getPageActivity());
            }
            if (this.m == null) {
                this.m = NoDataViewFactory.a(this.i.getPageActivity(), this.n, this.p, this.o, this.q);
            }
            this.m.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = this.r;
            if (layoutParams != null) {
                this.m.setLayoutParams(layoutParams);
            }
            this.n.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            this.m.f(this.i, TbadkCoreApplication.getInst().getSkinType());
            return this.n;
        }
        return (View) invokeV.objValue;
    }

    public BaseLegoCardView y(View view2, ICardInfo iCardInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, view2, iCardInfo)) == null) {
            if (iCardInfo == null) {
                return null;
            }
            if (view2 instanceof BaseLegoCardView) {
                return (BaseLegoCardView) view2;
            }
            return (BaseLegoCardView) uz8.h().a(this.i, iCardInfo, 0);
        }
        return (BaseLegoCardView) invokeLL.objValue;
    }
}
