package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class j6a extends i6a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext b;
    public NoDataView c;
    public View d;
    public vj5 e;
    public e f;
    public PbListView g;
    public NoNetworkView h;
    public ImageView i;
    public LoadingView j;
    public int k;
    public LinearLayout l;
    public FrameLayout m;
    public NoNetworkView n;
    public RelativeLayout o;
    public d8a p;

    /* loaded from: classes6.dex */
    public interface e {
        void a(View view2);
    }

    public void B(boolean z, List<oi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, list) == null) {
        }
    }

    public void k(p6a p6aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, p6aVar) == null) {
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j6a a;

        public a(j6a j6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j6aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j6aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.eventStat(this.a.b.getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
                ViewHelper.skipToLoginActivity(this.a.b.getPageActivity());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j6a a;

        public b(j6a j6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j6aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j6aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                this.a.o();
                this.a.D(true);
                if (this.a.f != null) {
                    this.a.f.a(view2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j6a a;

        public c(j6a j6aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j6aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j6aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                BrowserHelper.startWebActivity((Context) this.a.b.getPageActivity(), (String) null, hq9.a(), true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public h7a a;
        public UserData b;
        public d5b c;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new h7a();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                UserData userData = this.b;
                if (userData != null && userData.isBaijiahaoUser()) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "3"));
                h7a h7aVar = this.a;
                h7aVar.a = 10;
                h7aVar.b = new Bundle();
                this.a.b.putSerializable(UserData.TYPE_USER, this.b);
                d5b d5bVar = this.c;
                if (d5bVar != null) {
                    d5bVar.a(view2, this.a);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j6a(TbPageContext tbPageContext, View view2, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        new d();
        this.k = 3;
        if (tbPageContext != null && view2 != null) {
            this.b = tbPageContext;
            this.d = view2;
            this.h = (NoNetworkView) view2.findViewById(R.id.obfuscated_res_0x7f091c34);
            this.l = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091c0f);
            d8a d8aVar = new d8a(this.b, this.d.findViewById(R.id.obfuscated_res_0x7f091c11), this.d.findViewById(R.id.obfuscated_res_0x7f091c13), z);
            this.p = d8aVar;
            d8aVar.k(PersonStatus.GUEST_DEFAULT);
            this.m = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091c10);
            this.n = (NoNetworkView) this.d.findViewById(R.id.obfuscated_res_0x7f091c12);
            this.o = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091c35);
            PbListView pbListView = new PbListView(this.b.getPageActivity());
            this.g = pbListView;
            pbListView.c();
            this.g.J(SkinManager.getColor(R.color.CAM_X0109));
            this.g.F(R.color.CAM_X0110);
            this.g.s(R.color.CAM_X0201);
            this.g.w(BdUtilHelper.getDimens(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f07036f));
            this.g.u(BdUtilHelper.getDimens(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f070363));
            this.g.D();
            this.g.A(R.color.CAM_X0205);
            r(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && z) {
            A();
        }
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.o.setVisibility(i);
        }
    }

    public void t(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, eVar) == null) {
            this.f = eVar;
        }
    }

    public void x(List<oi> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, list) == null) && ListUtils.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (NickNameActivitySwitch.isOn()) {
                if (this.i == null) {
                    ImageView imageView = new ImageView(this.b.getPageActivity());
                    this.i = imageView;
                    imageView.setImageResource(R.drawable.obfuscated_res_0x7f080ab1);
                    this.i.setOnClickListener(new c(this));
                }
                if (this.i.getParent() != null) {
                    ((ViewGroup) this.i.getParent()).removeView(this.i);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.topMargin = BdUtilHelper.getDimens(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f0703ee);
                layoutParams.rightMargin = BdUtilHelper.getDimens(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f0701f0);
                View view2 = this.d;
                if (view2 instanceof RelativeLayout) {
                    ((RelativeLayout) view2).addView(this.i, layoutParams);
                    return;
                }
                return;
            }
            ImageView imageView2 = this.i;
            if (imageView2 != null && imageView2.getParent() != null) {
                ViewParent parent = this.i.getParent();
                View view3 = this.d;
                if (parent == view3) {
                    ((RelativeLayout) view3).removeView(this.i);
                }
            }
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.m == null) {
            return;
        }
        ImageView imageView = this.i;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.l.setVisibility(0);
        int dimensionPixelSize = this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07039a);
        int dimensionPixelSize2 = this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703e6);
        int dimensionPixelSize3 = this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703c8);
        int dimensionPixelSize4 = this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070253);
        int dimensionPixelSize5 = this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5);
        NoDataView a2 = NoDataViewFactory.a(this.b.getPageActivity(), this.m, NoDataViewFactory.d.c(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.e.e(R.string.obfuscated_res_0x7f0f17b3, dimensionPixelSize4), NoDataViewFactory.c.b(new NoDataViewFactory.b(this.b.getString(R.string.obfuscated_res_0x7f0f17b2), new a(this)), dimensionPixelSize5));
        this.c = a2;
        a2.setVisibility(0);
        this.c.f(this.b, TbadkCoreApplication.getInst().getSkinType());
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            LoadingView loadingView = this.j;
            if (loadingView != null) {
                loadingView.dettachView(this.d);
                this.j = null;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.TRUE));
        }
    }

    public void o() {
        vj5 vj5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (vj5Var = this.e) != null) {
            vj5Var.dettachView(this.m);
            this.e = null;
        }
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            vj5 vj5Var = this.e;
            if (vj5Var != null) {
                return vj5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048587, this, i) != null) || this.k == i) {
            return;
        }
        NoDataView noDataView = this.c;
        if (noDataView != null) {
            noDataView.f(this.b, i);
        }
        NoNetworkView noNetworkView = this.n;
        if (noNetworkView != null) {
            noNetworkView.onChangeSkinType(this.b, i);
        }
        d8a d8aVar = this.p;
        if (d8aVar != null) {
            d8aVar.g(i);
        }
        SkinManager.setBackgroundResource(this.d, R.color.CAM_X0201);
        vj5 vj5Var = this.e;
        if (vj5Var != null) {
            vj5Var.onChangeSkinType();
        }
        this.k = i;
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.o.setVisibility(8);
            int dimensionPixelSize = this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703a1);
            if (this.c == null) {
                this.c = NoDataViewFactory.a(this.b.getPageActivity(), this.d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.e.d(null, this.b.getString(R.string.user_to_anti)), null);
            }
            SkinManager.setViewTextColor(this.c.getSuTextView(), (int) R.color.CAM_X0106);
            this.c.f(this.b, TbadkCoreApplication.getInst().getSkinType());
            this.c.setVisibility(0);
        }
    }

    public void y(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if (this.j == null) {
                if (i < 0) {
                    this.j = new LoadingView(this.b.getContext());
                } else {
                    this.j = new LoadingView(this.b.getContext(), i);
                }
                this.j.onChangeSkinType();
            }
            this.j.attachView(this.d, z);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.FALSE));
        }
    }

    public void z(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048593, this, str, z) != null) || q()) {
            return;
        }
        this.l.setVisibility(0);
        if (this.e == null) {
            this.e = new vj5(this.b.getPageActivity(), new b(this));
        }
        this.e.g(R.drawable.new_pic_emotion_08);
        this.e.attachView(this.m, z);
        this.e.o();
        this.e.onChangeSkinType();
        ImageView imageView = this.i;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }
}
