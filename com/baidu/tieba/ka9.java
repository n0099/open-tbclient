package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdPageContext;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tieba.memberCenter.tail.data.TailData;
import com.baidu.tieba.pay.panel.PayPanelUtils;
import com.baidu.tieba.s45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ka9 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public oa9 b;
    public View.OnClickListener c;
    public View.OnClickListener d;
    public View.OnClickListener e;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ka9 a;

        public a(ka9 ka9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ka9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ka9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                PayPanelUtils.launchPayPanel(TbadkCoreApplication.getInst().getCurrentPageContext(this.a.a), IMConstants.IM_MSG_TYPE_ADVISORY_EVALUATION, MemberPayStatistic.REFER_PAGE_POSTING, MemberPayStatistic.CLICK_ZONE_TAILS_POP_UPS_OPENDE_RENEWALFEE_BUTTON);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ka9 a;

        public b(ka9 ka9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ka9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ka9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2.getTag() == null) {
                return;
            }
            if (!this.a.b.g()) {
                ka9 ka9Var = this.a;
                ka9Var.h(ka9Var.a.getString(R.string.obfuscated_res_0x7f0f034e));
                return;
            }
            TailData b = ((ma9) view2.getTag()).b();
            this.a.b.o(b.getId(), !b.isSelected());
        }
    }

    /* loaded from: classes6.dex */
    public class c implements s45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ka9 a;

        public c(ka9 ka9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ka9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ka9Var;
        }

        @Override // com.baidu.tieba.s45.e
        public void onClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                s45Var.dismiss();
                PayPanelUtils.launchPayPanel(TbadkCoreApplication.getInst().getCurrentPageContext(this.a.a), IMConstants.IM_MSG_TYPE_ADVISORY_EVALUATION, MemberPayStatistic.REFER_PAGE_POSTING, MemberPayStatistic.CLICK_ZONE_TAILS_POP_UPS_OPENDE_RENEWALFEE_BUTTON);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements s45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(ka9 ka9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ka9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.s45.e
        public void onClick(s45 s45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                s45Var.dismiss();
            }
        }
    }

    public ka9(Context context, oa9 oa9Var, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, oa9Var, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new a(this);
        this.e = new b(this);
        this.a = context;
        this.c = onClickListener;
        this.b = oa9Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: e */
    public TailData getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i >= this.b.i().size()) {
                return null;
            }
            return this.b.i().get(i);
        }
        return (TailData) invokeI.objValue;
    }

    public final View g(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof na9)) {
                na9 na9Var = new na9();
                View a2 = na9Var.a(this.a);
                na9Var.c(this.d);
                na9Var.b();
                return a2;
            }
            return view2;
        }
        return (View) invokeL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            if (this.b.i().size() == 0) {
                return 2;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public final View d(View view2) {
        InterceptResult invokeL;
        la9 la9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
            if (view2 != null && (view2.getTag() instanceof la9)) {
                la9Var = (la9) view2.getTag();
            } else {
                la9Var = new la9();
                view2 = la9Var.a(this.a);
                la9Var.c(this.c);
                la9Var.b();
            }
            la9Var.d(3);
            return view2;
        }
        return (View) invokeL.objValue;
    }

    public final View f(TailData tailData, View view2) {
        InterceptResult invokeLL;
        ma9 ma9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tailData, view2)) == null) {
            if (tailData == null) {
                return null;
            }
            if (view2 != null && (view2.getTag() instanceof ma9)) {
                ma9Var = (ma9) view2.getTag();
            } else {
                ma9Var = new ma9();
                view2 = ma9Var.a(this.a);
                ma9Var.e(this.e);
                ma9Var.c();
            }
            ma9Var.f(tailData);
            ma9Var.h(tailData);
            return view2;
        }
        return (View) invokeLL.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b.i().size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view2, viewGroup)) == null) {
            if (getItemViewType(i) == 0) {
                return f(getItem(i), view2);
            }
            if (getItemViewType(i) == 2) {
                return d(view2);
            }
            if (getItemViewType(i) == 3) {
                return g(view2);
            }
            return null;
        }
        return (View) invokeILL.objValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public final void h(String str) {
        BdPageContext<?> a2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, str) != null) || (a2 = l9.a(this.a)) == null) {
            return;
        }
        s45 s45Var = new s45(a2.getPageActivity());
        s45Var.setButtonTextColor(R.color.CAM_X0305);
        s45Var.setMessage(str).setNegativeButton(this.a.getString(R.string.obfuscated_res_0x7f0f03cf), new d(this)).setPositiveButton(this.a.getString(R.string.open_now), new c(this)).create(a2).show();
    }
}
