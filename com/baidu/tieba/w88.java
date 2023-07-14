package com.baidu.tieba;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.LocalChannelTopicListActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tieba.homepage.topic.local.LocalChannelTopicDecoration;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class w88 implements vu5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public LinearLayout b;
    public NavigationBar c;
    public View d;
    public EMTextView e;
    public EMTextView f;
    public RelativeLayout g;
    public BdTypeRecyclerView h;
    public co5 i;
    public do5 j;
    public View.OnClickListener k;
    public LocalChannelTopicDecoration l;
    public boolean m;

    @Override // com.baidu.tieba.wu5
    public boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.wu5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w88 a;

        public a(w88 w88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w88Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.a.a != null && this.a.a.getPageActivity() != null && (ynVar instanceof y88)) {
                this.a.s();
                String str = ((y88) ynVar).a;
                if (this.a.m) {
                    Intent intent = new Intent();
                    intent.putExtra(LocalChannelTopicListActivityConfig.KEY_RESPONSE_TOPIC, str);
                    this.a.a.getPageActivity().setResult(-1, intent);
                    this.a.a.getPageActivity().finish();
                    return;
                }
                if (this.a.a.getPageActivity() instanceof SuspendedActivity) {
                    ((SuspendedActivity) this.a.a.getPageActivity()).F1(true);
                }
                this.a.a.getPageActivity().finish();
                if (this.a.a != null && this.a.a.getPageActivity() != null) {
                    WriteActivityConfig.newInstance(this.a.a.getPageActivity()).setType(9).setFrom("main_tab").setCallFrom("2").setIsPostLocalChannelDynamic(true).setLocalChannelTopic(str).send();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z88 a;
        public final /* synthetic */ w88 b;

        public b(w88 w88Var, z88 z88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w88Var, z88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = w88Var;
            this.a = z88Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.a != null) {
                this.b.r();
                this.b.j(this.a);
            }
        }
    }

    public w88(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, linearLayout, navigationBar, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.b = linearLayout;
        this.c = navigationBar;
        this.k = onClickListener;
        i();
        h();
    }

    @Override // com.baidu.tieba.vu5
    public void P(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
            this.h.setPressed(false);
        }
    }

    public final void j(z88 z88Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z88Var) == null) {
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.a.getPageActivity());
            pbActivityConfig.setThreadId(z88Var.a.b);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        }
    }

    public void k(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, intent) != null) || intent == null) {
            return;
        }
        this.m = intent.getBooleanExtra(LocalChannelTopicListActivityConfig.KEY_IS_RESPONSE_FOR_TOPIC, false);
        t();
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.h;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setVisibility(8);
            }
            f();
            o(str, false);
        }
    }

    @Override // com.baidu.tieba.wu5
    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.h;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getVisibility() != 0) {
                return true;
            }
            if (this.h.getFirstVisiblePosition() == 0 && this.h.getChildAt(0) != null && this.h.getChildAt(0).getTop() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.a != null && this.g != null) {
            co5 co5Var = this.i;
            if (co5Var != null && co5Var.isViewAttached()) {
                return;
            }
            if (this.i == null) {
                this.i = new co5(this.a.getPageActivity());
            }
            this.i.attachView(this.g);
        }
    }

    public final void f() {
        co5 co5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.g != null && (co5Var = this.i) != null && co5Var.isViewAttached()) {
            this.i.dettachView(this.g);
        }
    }

    public final void g() {
        do5 do5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.g != null && (do5Var = this.j) != null && do5Var.isViewAttached()) {
            this.j.dettachView(this.g);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            o(this.a.getString(R.string.list_has_no_more), true);
            f();
            this.h.setVisibility(8);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            TiebaStatic.log(new StatisticItem("c14524"));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            TiebaStatic.log(new StatisticItem("c14523"));
        }
    }

    public final void t() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14522");
            if (this.m) {
                i = 2;
            } else {
                i = 1;
            }
            TiebaStatic.log(statisticItem.param("obj_source", i));
        }
    }

    public final void h() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (tbPageContext = this.a) == null || this.b == null) {
            return;
        }
        LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0527, (ViewGroup) this.b, true);
        this.g = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f09162f);
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.b.findViewById(R.id.recycler_view);
        this.h = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getPageActivity()));
        this.h.setFadingEdgeLength(0);
        this.h.setOverScrollMode(2);
        LocalChannelTopicDecoration localChannelTopicDecoration = new LocalChannelTopicDecoration();
        this.l = localChannelTopicDecoration;
        this.h.addItemDecoration(localChannelTopicDecoration);
        ArrayList arrayList = new ArrayList();
        v88 v88Var = new v88(this.a, y88.e);
        v88Var.setOnAdapterItemClickListener(new a(this));
        arrayList.add(v88Var);
        this.h.addAdapters(arrayList);
        this.h.setVisibility(8);
        g();
        n();
    }

    public final void i() {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || this.a == null || (navigationBar = this.c) == null) {
            return;
        }
        navigationBar.setFixedHeight(false);
        if (this.c.getContentLayout() != null && this.c.getContentLayout().getLayoutParams() != null) {
            this.c.getContentLayout().getLayoutParams().height = yi.g(this.a.getPageActivity(), R.dimen.tbds161);
            this.c.getContentLayout().requestLayout();
        }
        this.d = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0528, this.c.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER), true);
        this.e = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f09162e);
        this.f = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f09162d);
    }

    public final void o(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048589, this, str, z) == null) && this.a != null && this.g != null) {
            do5 do5Var = this.j;
            if (do5Var != null && do5Var.isViewAttached()) {
                return;
            }
            if (this.j == null) {
                this.j = new do5(this.a.getPageActivity(), this.k);
            }
            if (z) {
                this.j.i(R.drawable.new_pic_emotion_07);
                this.j.e();
            } else {
                this.j.i(R.drawable.new_pic_emotion_08);
                this.j.p();
            }
            this.j.o(str);
            this.j.attachView(this.g);
        }
    }

    public void p(z88 z88Var) {
        EMTextView eMTextView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, z88Var) == null) {
            if (z88Var == null) {
                l();
            } else if (this.d != null && (eMTextView = this.f) != null && this.h != null) {
                x88 x88Var = z88Var.a;
                if (x88Var != null) {
                    eMTextView.setText(x88Var.a);
                    this.f.setVisibility(0);
                    this.d.setOnClickListener(new b(this, z88Var));
                }
                if (ListUtils.isEmpty(z88Var.b)) {
                    l();
                    return;
                }
                f();
                g();
                this.h.setVisibility(0);
                this.h.setData(z88Var.b);
            }
        }
    }

    @Override // com.baidu.tieba.wu5
    public void q(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048592, this, i) != null) || this.a == null) {
            return;
        }
        SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0108);
        Drawable pureDrawable = WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right_n, SkinManager.getColor(R.color.CAM_X0108), null);
        if (this.f != null && pureDrawable != null) {
            int g = yi.g(this.a.getPageActivity(), R.dimen.tbds31);
            pureDrawable.setBounds(0, 0, g, g);
            this.f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, pureDrawable, (Drawable) null);
        }
        co5 co5Var = this.i;
        if (co5Var != null) {
            co5Var.m(i);
        }
        do5 do5Var = this.j;
        if (do5Var != null) {
            do5Var.onChangeSkinType();
        }
        LocalChannelTopicDecoration localChannelTopicDecoration = this.l;
        if (localChannelTopicDecoration != null) {
            localChannelTopicDecoration.a();
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.h;
        if (bdTypeRecyclerView != null && bdTypeRecyclerView.getAdapter() != null) {
            this.h.getAdapter().notifyDataSetChanged();
        }
    }
}
