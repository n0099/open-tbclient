package com.baidu.tieba;

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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
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
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class kv8 extends jv8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext b;
    public NoDataView c;
    public View d;
    public lf5 e;
    public e f;
    public PbListView g;
    public NoNetworkView h;
    public ImageView i;
    public kf5 j;
    public int k;
    public LinearLayout l;
    public FrameLayout m;
    public NoNetworkView n;
    public RelativeLayout o;
    public ex8 p;

    /* loaded from: classes5.dex */
    public interface e {
        void a(View view2);
    }

    public void A(boolean z, List<gn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
        }
    }

    public void j(qv8 qv8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, qv8Var) == null) {
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kv8 a;

        public a(kv8 kv8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kv8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kv8Var;
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

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kv8 a;

        public b(kv8 kv8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kv8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kv8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                this.a.n();
                this.a.C(true);
                if (this.a.f != null) {
                    this.a.f.a(view2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kv8 a;

        public c(kv8 kv8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kv8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kv8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                gt4.v(this.a.b.getPageActivity(), null, kh8.a(), true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public iw8 a;
        public UserData b;
        public qo9 c;

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
            this.a = new iw8();
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
                iw8 iw8Var = this.a;
                iw8Var.a = 10;
                iw8Var.b = new Bundle();
                this.a.b.putSerializable(UserData.TYPE_USER, this.b);
                qo9 qo9Var = this.c;
                if (qo9Var != null) {
                    qo9Var.a(view2, this.a);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kv8(TbPageContext tbPageContext, View view2, boolean z) {
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
            this.h = (NoNetworkView) view2.findViewById(R.id.obfuscated_res_0x7f091a8e);
            this.l = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091a69);
            ex8 ex8Var = new ex8(this.b, this.d.findViewById(R.id.obfuscated_res_0x7f091a6b), this.d.findViewById(R.id.obfuscated_res_0x7f091a6d), z);
            this.p = ex8Var;
            ex8Var.k(PersonStatus.GUEST_DEFAULT);
            this.m = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091a6a);
            this.n = (NoNetworkView) this.d.findViewById(R.id.obfuscated_res_0x7f091a6c);
            this.o = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091a8f);
            PbListView pbListView = new PbListView(this.b.getPageActivity());
            this.g = pbListView;
            pbListView.c();
            this.g.H(SkinManager.getColor(R.color.CAM_X0109));
            this.g.D(R.color.CAM_X0110);
            this.g.r(R.color.CAM_X0201);
            this.g.v(hi.g(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f070248));
            this.g.t(hi.g(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f07023c));
            this.g.C();
            this.g.z(R.color.CAM_X0205);
            q(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && z) {
            z();
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.o.setVisibility(i);
        }
    }

    public void s(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, eVar) == null) {
            this.f = eVar;
        }
    }

    public void u(List<gn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, list) == null) && ListUtils.isEmpty(list)) {
            new ArrayList();
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.m == null) {
            return;
        }
        ImageView imageView = this.i;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.l.setVisibility(0);
        int dimensionPixelSize = this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07027b);
        int dimensionPixelSize2 = this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702cd);
        int dimensionPixelSize3 = this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702ab);
        int dimensionPixelSize4 = this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070253);
        int dimensionPixelSize5 = this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5);
        NoDataView a2 = NoDataViewFactory.a(this.b.getPageActivity(), this.m, NoDataViewFactory.d.c(NoDataViewFactory.ImgType.LOCAL, R.drawable.new_pic_emotion_01, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.e.e(R.string.obfuscated_res_0x7f0f1601, dimensionPixelSize4), NoDataViewFactory.c.b(new NoDataViewFactory.b(this.b.getString(R.string.obfuscated_res_0x7f0f1600), new a(this)), dimensionPixelSize5));
        this.c = a2;
        a2.setVisibility(0);
        this.c.f(this.b, TbadkCoreApplication.getInst().getSkinType());
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (NickNameActivitySwitch.isOn()) {
                if (this.i == null) {
                    ImageView imageView = new ImageView(this.b.getPageActivity());
                    this.i = imageView;
                    imageView.setImageResource(R.drawable.obfuscated_res_0x7f080909);
                    this.i.setOnClickListener(new c(this));
                }
                if (this.i.getParent() != null) {
                    ((ViewGroup) this.i.getParent()).removeView(this.i);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.topMargin = hi.g(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f0702d5);
                layoutParams.rightMargin = hi.g(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f0701f0);
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

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            kf5 kf5Var = this.j;
            if (kf5Var != null) {
                kf5Var.dettachView(this.d);
                this.j = null;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.TRUE));
        }
    }

    public void n() {
        lf5 lf5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (lf5Var = this.e) != null) {
            lf5Var.dettachView(this.m);
            this.e = null;
        }
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            lf5 lf5Var = this.e;
            if (lf5Var != null) {
                return lf5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048586, this, i) != null) || this.k == i) {
            return;
        }
        NoDataView noDataView = this.c;
        if (noDataView != null) {
            noDataView.f(this.b, i);
        }
        NoNetworkView noNetworkView = this.n;
        if (noNetworkView != null) {
            noNetworkView.d(this.b, i);
        }
        ex8 ex8Var = this.p;
        if (ex8Var != null) {
            ex8Var.g(i);
        }
        SkinManager.setBackgroundResource(this.d, R.color.CAM_X0201);
        lf5 lf5Var = this.e;
        if (lf5Var != null) {
            lf5Var.onChangeSkinType();
        }
        this.k = i;
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.o.setVisibility(8);
            int dimensionPixelSize = this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070284);
            if (this.c == null) {
                this.c = NoDataViewFactory.a(this.b.getPageActivity(), this.d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.ANTI, dimensionPixelSize), NoDataViewFactory.e.d(null, this.b.getString(R.string.user_to_anti)), null);
            }
            SkinManager.setViewTextColor(this.c.getSuTextView(), (int) R.color.CAM_X0106);
            this.c.f(this.b, TbadkCoreApplication.getInst().getSkinType());
            this.c.setVisibility(0);
        }
    }

    public void x(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            if (this.j == null) {
                if (i < 0) {
                    this.j = new kf5(this.b.getContext());
                } else {
                    this.j = new kf5(this.b.getContext(), i);
                }
                this.j.onChangeSkinType();
            }
            this.j.attachView(this.d, z);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921440, Boolean.FALSE));
        }
    }

    public void y(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048592, this, str, z) != null) || p()) {
            return;
        }
        this.l.setVisibility(0);
        if (this.e == null) {
            this.e = new lf5(this.b.getPageActivity(), new b(this));
        }
        this.e.h(R.drawable.new_pic_emotion_08);
        this.e.attachView(this.m, z);
        this.e.p();
        this.e.onChangeSkinType();
        ImageView imageView = this.i;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }
}
