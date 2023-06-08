package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.signall.SignAllForumActivity;
import com.baidu.tieba.signall.SignAllForumProgressView;
import com.baidu.tieba.w95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class rs9 extends i9<SignAllForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public static int o;
    public transient /* synthetic */ FieldHolder $fh;
    public SignAllForumActivity a;
    public NavigationBar b;
    public RelativeLayout c;
    public SignAllForumProgressView d;
    public ProgressBar e;
    public BdListView f;
    public x95 g;
    public os9 h;
    public ks9 i;
    public RelativeLayout j;
    public TextView k;
    public TextView l;
    public LinearLayout m;
    public TextView n;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rs9 a;

        public a(rs9 rs9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rs9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rs9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.finish();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rs9(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {signAllForumActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((k9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = null;
        this.a = signAllForumActivity;
        signAllForumActivity.setContentView(R.layout.obfuscated_res_0x7f0d087f);
        this.c = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f092130);
        NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.b = navigationBar;
        navigationBar.setCenterTextTitle(this.a.getPageContext().getString(R.string.signallforum));
        this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        this.b.showBottomLine();
        BdListView bdListView = (BdListView) this.a.findViewById(R.id.obfuscated_res_0x7f092150);
        this.f = bdListView;
        bdListView.setOnItemClickListener(signAllForumActivity);
        x95 x95Var = new x95(signAllForumActivity.getPageContext());
        this.g = x95Var;
        this.f.setPullRefresh(x95Var);
        TextView textView = (TextView) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d087d, (ViewGroup) null);
        this.n = textView;
        this.f.addFooterView(textView);
        SignAllForumProgressView signAllForumProgressView = new SignAllForumProgressView(this.a.getPageContext().getPageActivity());
        this.d = signAllForumProgressView;
        ProgressBar progressBar = signAllForumProgressView.getProgressBar();
        this.e = progressBar;
        progressBar.setOnClickListener(this.a);
        this.f.addHeaderView(this.d);
        this.d.setVisibility(8);
        this.j = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090eaa);
        this.m = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090eac);
        this.k = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090ead);
        this.l = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090eab);
        this.m.setOnClickListener(this.a);
        os9 os9Var = new os9(this.a, null);
        this.h = os9Var;
        this.f.setAdapter((ListAdapter) os9Var);
        this.f.setOnScrollListener(this.h);
    }

    public void H(w95.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) {
            this.g.f(gVar);
        }
    }

    public void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.f.setSelection(i);
        }
    }

    public void J(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onItemClickListener) == null) {
            this.f.setOnItemClickListener(onItemClickListener);
        }
    }

    public ks9 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.i;
        }
        return (ks9) invokeV.objValue;
    }

    public LinearLayout B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.m;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public BdListView C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (BdListView) invokeV.objValue;
    }

    public ProgressBar D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (ProgressBar) invokeV.objValue;
    }

    public SignAllForumProgressView E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (SignAllForumProgressView) invokeV.objValue;
    }

    public RelativeLayout F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f.E();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f.z(0L);
        }
    }

    public os9 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.h;
        }
        return (os9) invokeV.objValue;
    }

    public void G(ks9 ks9Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048582, this, ks9Var, z) != null) || ks9Var == null) {
            return;
        }
        this.i = ks9Var;
        y();
        ArrayList<ls9> k = ks9Var.k();
        this.h.h(this.i);
        if (k.size() == o) {
            this.n.setVisibility(0);
            this.n.setText(ks9Var.m());
        } else {
            this.n.setVisibility(8);
        }
        String y = this.i.y();
        if (!StringUtils.isNull(y)) {
            this.d.l(this.a, y, this.i.z());
            return;
        }
        this.d.i();
    }

    public void onChangeSkinType(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            d05 layoutMode = this.a.getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            this.a.getLayoutMode().k(this.c);
            this.a.getLayoutMode().k(this.n);
            this.a.getLayoutMode().k(this.d);
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
            this.b.onChangeSkinType(getPageContext(), i);
            SignAllForumProgressView signAllForumProgressView = this.d;
            if (signAllForumProgressView != null) {
                signAllForumProgressView.k();
            }
            this.g.H(i);
            this.h.notifyDataSetChanged();
        }
    }

    public final void y() {
        ks9 ks9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || (ks9Var = this.i) == null) {
            return;
        }
        this.d.setHasPrivilege(ks9Var.B());
        this.d.setmCurrentStatus(this.i.q());
        TextView message1 = this.d.getMessage1();
        SpannableString spannableString = new SpannableString(this.i.v() + this.i.t() + this.i.u());
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
        int length = this.i.v().length();
        spannableString.setSpan(foregroundColorSpan, length, this.i.t().length() + length, 33);
        message1.setText(spannableString);
        this.d.getMessage2().setText(this.i.w());
        this.k.setText(this.i.h());
        if (TextUtils.isEmpty(this.i.g())) {
            this.l.setText(R.string.member_buy_open);
        } else {
            this.l.setText(this.i.g());
        }
        this.d.setVisibility(0);
        if (!this.i.B() && TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) != null) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }
}
