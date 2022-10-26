package com.baidu.tieba;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishGuideActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishOpenHelper;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tieba.personCenter.model.PersonCreatorModel;
import com.baidu.tieba.personCenter.view.PersonCreatorCenterDataView;
import com.baidu.tieba.personCenter.view.PersonCreatorCenterFunView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.CreationData;
/* loaded from: classes6.dex */
public class v68 extends p16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonCreatorCenterDataView A;
    public LinearLayout B;
    public LinearLayout C;
    public LinearLayout D;
    public LinearLayout E;
    public FrameLayout F;
    public TextView G;
    public TextView H;
    public TextView I;
    public View J;
    public View K;
    public View L;
    public PersonCreatorCenterFunView M;
    public PersonCreatorCenterFunView N;
    public PersonCreatorCenterFunView O;
    public PersonCreatorCenterFunView P;
    public boolean Q;
    public boolean R;
    public PersonCreatorModel i;
    public TbPageContext j;
    public LinearLayout k;
    public LinearLayout l;
    public LinearLayout m;
    public TBSpecificationBtn n;
    public TBSpecificationBtn o;
    public PersonCreatorCenterFunView p;
    public PersonCreatorCenterFunView q;
    public PersonCreatorCenterFunView r;
    public PersonCreatorCenterDataView s;
    public PersonCreatorCenterDataView t;
    public PersonCreatorCenterDataView u;
    public ImageView v;
    public PersonCreatorCenterFunView w;
    public PersonCreatorCenterFunView x;
    public PersonCreatorCenterDataView y;
    public PersonCreatorCenterDataView z;

    @Override // com.baidu.tieba.p16
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d070e : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v68(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = tbPageContext;
        this.i = new PersonCreatorModel(tbPageContext);
        View k = k();
        int f = fj.f(this.c, R.dimen.M_W_X003);
        k.setPadding(f, 0, f, 0);
        LinearLayout linearLayout = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f091905);
        this.B = linearLayout;
        linearLayout.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f091900);
        this.C = linearLayout2;
        linearLayout2.setOnClickListener(this);
        LinearLayout linearLayout3 = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f091906);
        this.D = linearLayout3;
        linearLayout3.setOnClickListener(this);
        FrameLayout frameLayout = (FrameLayout) k.findViewById(R.id.obfuscated_res_0x7f09102d);
        this.F = frameLayout;
        frameLayout.setOnClickListener(this);
        this.G = (TextView) k.findViewById(R.id.obfuscated_res_0x7f091904);
        this.I = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0918ff);
        this.J = k.findViewById(R.id.obfuscated_res_0x7f0903b4);
        this.K = k.findViewById(R.id.obfuscated_res_0x7f0903b6);
        this.L = k.findViewById(R.id.obfuscated_res_0x7f0903b5);
        this.l = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f09192d);
        this.m = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f09192c);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) k.findViewById(R.id.obfuscated_res_0x7f090704);
        this.n = tBSpecificationBtn;
        tBSpecificationBtn.setText("投稿");
        this.H = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09073c);
        TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) k.findViewById(R.id.obfuscated_res_0x7f0912ee);
        this.o = tBSpecificationBtn2;
        tBSpecificationBtn2.setText("立即开通");
        PersonCreatorCenterFunView personCreatorCenterFunView = (PersonCreatorCenterFunView) k.findViewById(R.id.obfuscated_res_0x7f091925);
        this.p = personCreatorCenterFunView;
        personCreatorCenterFunView.a(R.drawable.obfuscated_res_0x7f080849, this.j.getString(R.string.obfuscated_res_0x7f0f0482));
        PersonCreatorCenterFunView personCreatorCenterFunView2 = (PersonCreatorCenterFunView) k.findViewById(R.id.obfuscated_res_0x7f091926);
        this.q = personCreatorCenterFunView2;
        personCreatorCenterFunView2.a(R.drawable.obfuscated_res_0x7f080842, this.j.getString(R.string.obfuscated_res_0x7f0f1554));
        PersonCreatorCenterFunView personCreatorCenterFunView3 = (PersonCreatorCenterFunView) k.findViewById(R.id.obfuscated_res_0x7f091924);
        this.r = personCreatorCenterFunView3;
        personCreatorCenterFunView3.a(R.drawable.obfuscated_res_0x7f080845, this.j.getString(R.string.obfuscated_res_0x7f0f154b));
        this.s = (PersonCreatorCenterDataView) k.findViewById(R.id.obfuscated_res_0x7f0926c4);
        this.t = (PersonCreatorCenterDataView) k.findViewById(R.id.obfuscated_res_0x7f0926c3);
        this.u = (PersonCreatorCenterDataView) k.findViewById(R.id.obfuscated_res_0x7f0926c1);
        this.k = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f09192a);
        this.v = (ImageView) k.findViewById(R.id.obfuscated_res_0x7f0918fe);
        PersonCreatorCenterFunView personCreatorCenterFunView4 = (PersonCreatorCenterFunView) k.findViewById(R.id.obfuscated_res_0x7f091923);
        this.w = personCreatorCenterFunView4;
        personCreatorCenterFunView4.a(R.drawable.obfuscated_res_0x7f080820, this.j.getString(R.string.obfuscated_res_0x7f0f1427));
        PersonCreatorCenterFunView personCreatorCenterFunView5 = (PersonCreatorCenterFunView) k.findViewById(R.id.obfuscated_res_0x7f091927);
        this.x = personCreatorCenterFunView5;
        personCreatorCenterFunView5.a(R.drawable.obfuscated_res_0x7f080845, this.j.getString(R.string.obfuscated_res_0x7f0f1428));
        this.y = (PersonCreatorCenterDataView) k.findViewById(R.id.obfuscated_res_0x7f0926c6);
        this.z = (PersonCreatorCenterDataView) k.findViewById(R.id.obfuscated_res_0x7f0926c5);
        this.A = (PersonCreatorCenterDataView) k.findViewById(R.id.obfuscated_res_0x7f0926c2);
        PersonCreatorCenterFunView personCreatorCenterFunView6 = (PersonCreatorCenterFunView) k.findViewById(R.id.obfuscated_res_0x7f09192b);
        this.M = personCreatorCenterFunView6;
        personCreatorCenterFunView6.a(R.drawable.obfuscated_res_0x7f08087e, this.j.getString(R.string.obfuscated_res_0x7f0f0c6f));
        PersonCreatorCenterFunView personCreatorCenterFunView7 = (PersonCreatorCenterFunView) k.findViewById(R.id.obfuscated_res_0x7f091929);
        this.N = personCreatorCenterFunView7;
        personCreatorCenterFunView7.a(R.drawable.obfuscated_res_0x7f080b42, this.j.getString(R.string.obfuscated_res_0x7f0f0ea3));
        PersonCreatorCenterFunView personCreatorCenterFunView8 = (PersonCreatorCenterFunView) k.findViewById(R.id.obfuscated_res_0x7f091922);
        this.O = personCreatorCenterFunView8;
        personCreatorCenterFunView8.a(R.drawable.obfuscated_res_0x7f080910, this.j.getString(R.string.obfuscated_res_0x7f0f05e0));
        PersonCreatorCenterFunView personCreatorCenterFunView9 = (PersonCreatorCenterFunView) k.findViewById(R.id.obfuscated_res_0x7f091928);
        this.P = personCreatorCenterFunView9;
        personCreatorCenterFunView9.a(R.drawable.obfuscated_res_0x7f08078d, this.j.getString(R.string.obfuscated_res_0x7f0f0afb));
        if (Build.VERSION.SDK_INT < 24) {
            LinearLayout linearLayout4 = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f091988);
            this.E = linearLayout4;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout4.getLayoutParams();
            layoutParams.bottomMargin = fj.f(this.c, R.dimen.tbds37);
            this.E.setLayoutParams(layoutParams);
        }
        m(tbPageContext, this.a);
    }

    public final void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.Q = z;
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.R = z;
            r();
        }
    }

    @Override // com.baidu.tieba.p16
    public void m(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.J, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.K, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.L, R.color.CAM_X0204);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.v, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            nv4 d = nv4.d(this.l);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            nv4 d2 = nv4.d(this.k);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
            nv4 d3 = nv4.d(this.m);
            d3.n(R.string.J_X06);
            d3.f(R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.G, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.I, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.p.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.q.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.r.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.w.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.x.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.s.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.s.h, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.t.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.t.h, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.u.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.u.h, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.y.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.y.h, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.z.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.z.h, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.A.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.A.h, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.H, (int) R.color.CAM_X0105);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            if (R.id.obfuscated_res_0x7f091905 == view2.getId()) {
                b29 b29Var = new b29(g(), (ViewGroup) k(), "person", 3, null);
                b29Var.h("5");
                b29Var.f(WorkPublishOpenHelper.OPEN_WORK_PUBLISH_FROM_PERSON);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", "9"));
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("uid", String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
            } else if (R.id.obfuscated_res_0x7f091900 == view2.getId()) {
                t(TbConfig.URL_CREATE_CENTER);
                TiebaStatic.log(new StatisticItem("c14149").param("obj_locate", "2"));
                TiebaStatic.log(new StatisticItem("c14149").param("uid", String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
            } else if (R.id.obfuscated_res_0x7f091906 == view2.getId()) {
                this.i.A(true);
            } else if (R.id.obfuscated_res_0x7f09102d == view2.getId()) {
                WorkPublishGuideActivityConfig workPublishGuideActivityConfig = new WorkPublishGuideActivityConfig(getContext());
                workPublishGuideActivityConfig.setRequestCode(25064);
                workPublishGuideActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, workPublishGuideActivityConfig));
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && UtilHelper.isViewPrimary(this.w, true) && this.R) {
            new StatisticItem("c15051").param("uid", TbadkCoreApplication.getCurrentAccountId()).eventStat();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p16
    /* renamed from: s */
    public void l(d68 d68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, d68Var) == null) {
            if (d68Var == null) {
                q(8);
                return;
            }
            CreationData f = d68Var.f();
            if (f == null) {
                this.l.setVisibility(8);
                this.m.setVisibility(0);
            } else {
                this.l.setVisibility(0);
                this.m.setVisibility(8);
                this.s.a(f.view_count.intValue(), this.j.getString(R.string.obfuscated_res_0x7f0f1646), f.view_count_trend.intValue());
                this.t.a(f.valid_play_count.intValue(), this.j.getString(R.string.obfuscated_res_0x7f0f1647), f.valid_play_count_trend.intValue());
                this.u.a(f.agree_count.intValue(), this.j.getString(R.string.obfuscated_res_0x7f0f1648), f.agree_count_trend.intValue());
            }
            if (TbSingleton.getInstance().getNewGodData() != null) {
                NewGodData newGodData = TbSingleton.getInstance().getNewGodData();
                if (!StringUtils.isNull(newGodData.getFieldName()) && newGodData.getStatus() == 3) {
                    this.x.a(R.drawable.obfuscated_res_0x7f080845, this.j.getString(R.string.obfuscated_res_0x7f0f1425));
                    this.w.a(R.drawable.obfuscated_res_0x7f080820, this.j.getString(R.string.obfuscated_res_0x7f0f1426));
                } else {
                    this.x.a(R.drawable.obfuscated_res_0x7f080845, this.j.getString(R.string.obfuscated_res_0x7f0f1428));
                    this.w.a(R.drawable.obfuscated_res_0x7f080820, this.j.getString(R.string.obfuscated_res_0x7f0f1427));
                }
            }
            if (this.Q) {
                w(this.w, this.j.getString(R.string.obfuscated_res_0x7f0f141c));
            }
            CreationData c = d68Var.c();
            if (c != null) {
                this.y.a(c.view_count.intValue(), this.j.getString(R.string.obfuscated_res_0x7f0f1643), c.view_count_trend.intValue());
                this.z.a(c.agree_count.intValue(), this.j.getString(R.string.obfuscated_res_0x7f0f1645), c.agree_count_trend.intValue());
                this.A.a(c.comment_count.intValue(), this.j.getString(R.string.obfuscated_res_0x7f0f1644), c.comment_trend.intValue());
            }
            m(this.j, this.a);
        }
    }

    public final void w(View view2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, view2, str) == null) && view2 != null && !StringUtils.isNull(str) && view2.getVisibility() == 0) {
            e46 e46Var = new e46(this.j, view2);
            e46Var.L(R.drawable.obfuscated_res_0x7f0802f5);
            e46Var.o(16);
            e46Var.x(true);
            e46Var.P(42);
            e46Var.Q(0);
            e46Var.n(3000);
            e46Var.R(str);
            this.Q = false;
        }
    }
}
