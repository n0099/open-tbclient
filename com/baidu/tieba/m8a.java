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
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.l45;
import com.baidu.tieba.signall.SignAllForumActivity;
import com.baidu.tieba.signall.SignAllForumProgressView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class m8a extends BdBaseView<SignAllForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public static int o;
    public transient /* synthetic */ FieldHolder $fh;
    public SignAllForumActivity a;
    public NavigationBar b;
    public RelativeLayout c;
    public SignAllForumProgressView d;
    public ProgressBar e;
    public BdListView f;
    public m45 g;
    public j8a h;
    public f8a i;
    public RelativeLayout j;
    public TextView k;
    public TextView l;
    public LinearLayout m;
    public TextView n;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m8a a;

        public a(m8a m8aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m8aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m8aVar;
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
    public m8a(SignAllForumActivity signAllForumActivity) {
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
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = null;
        this.a = signAllForumActivity;
        signAllForumActivity.setContentView(R.layout.obfuscated_res_0x7f0d08c0);
        this.c = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f092223);
        NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
        this.b = navigationBar;
        navigationBar.setCenterTextTitle(this.a.getPageContext().getString(R.string.signallforum));
        this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        this.b.showBottomLine();
        BdListView bdListView = (BdListView) this.a.findViewById(R.id.obfuscated_res_0x7f092244);
        this.f = bdListView;
        bdListView.setOnItemClickListener(signAllForumActivity);
        m45 m45Var = new m45(signAllForumActivity.getPageContext());
        this.g = m45Var;
        this.f.setPullRefresh(m45Var);
        TextView textView = (TextView) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d08be, (ViewGroup) null);
        this.n = textView;
        this.f.addFooterView(textView);
        SignAllForumProgressView signAllForumProgressView = new SignAllForumProgressView(this.a.getPageContext().getPageActivity());
        this.d = signAllForumProgressView;
        ProgressBar progressBar = signAllForumProgressView.getProgressBar();
        this.e = progressBar;
        progressBar.setOnClickListener(this.a);
        this.f.addHeaderView(this.d);
        this.d.setVisibility(8);
        this.j = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090eee);
        this.m = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090ef0);
        this.k = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090ef1);
        this.l = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090eef);
        this.m.setOnClickListener(this.a);
        j8a j8aVar = new j8a(this.a, null);
        this.h = j8aVar;
        this.f.setAdapter((ListAdapter) j8aVar);
        this.f.setOnScrollListener(this.h);
    }

    public void E(l45.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
            this.g.a(gVar);
        }
    }

    public void F(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f.setSelection(i);
        }
    }

    public void G(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onItemClickListener) == null) {
            this.f.setOnItemClickListener(onItemClickListener);
        }
    }

    public ProgressBar A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return (ProgressBar) invokeV.objValue;
    }

    public SignAllForumProgressView B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (SignAllForumProgressView) invokeV.objValue;
    }

    public RelativeLayout C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f.E();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f.z(0L);
        }
    }

    public j8a u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.h;
        }
        return (j8a) invokeV.objValue;
    }

    public f8a x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.i;
        }
        return (f8a) invokeV.objValue;
    }

    public LinearLayout y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.m;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public BdListView z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.f;
        }
        return (BdListView) invokeV.objValue;
    }

    public void D(f8a f8aVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048579, this, f8aVar, z) != null) || f8aVar == null) {
            return;
        }
        this.i = f8aVar;
        t();
        ArrayList<g8a> k = f8aVar.k();
        this.h.h(this.i);
        if (k.size() == o) {
            this.n.setVisibility(0);
            this.n.setText(f8aVar.m());
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
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            BDLayoutMode layoutMode = this.a.getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.a.getLayoutMode().onModeChanged(this.c);
            this.a.getLayoutMode().onModeChanged(this.n);
            this.a.getLayoutMode().onModeChanged(this.d);
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
            this.b.onChangeSkinType(getPageContext(), i);
            SignAllForumProgressView signAllForumProgressView = this.d;
            if (signAllForumProgressView != null) {
                signAllForumProgressView.k();
            }
            this.g.D(i);
            this.h.notifyDataSetChanged();
        }
    }

    public final void t() {
        f8a f8aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || (f8aVar = this.i) == null) {
            return;
        }
        this.d.setHasPrivilege(f8aVar.B());
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
