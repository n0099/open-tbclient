package com.baidu.tieba;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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
public class x58 extends v06<f58> {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x58(TbPageContext<?> tbPageContext) {
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
        View h = h();
        LinearLayout linearLayout = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f09190f);
        this.B = linearLayout;
        linearLayout.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f09190a);
        this.C = linearLayout2;
        linearLayout2.setOnClickListener(this);
        LinearLayout linearLayout3 = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f091910);
        this.D = linearLayout3;
        linearLayout3.setOnClickListener(this);
        FrameLayout frameLayout = (FrameLayout) h.findViewById(R.id.obfuscated_res_0x7f091039);
        this.F = frameLayout;
        frameLayout.setOnClickListener(this);
        this.G = (TextView) h.findViewById(R.id.obfuscated_res_0x7f09190e);
        this.I = (TextView) h.findViewById(R.id.obfuscated_res_0x7f091909);
        this.J = h.findViewById(R.id.obfuscated_res_0x7f0903ab);
        this.K = h.findViewById(R.id.obfuscated_res_0x7f0903ad);
        this.L = h.findViewById(R.id.obfuscated_res_0x7f0903ac);
        this.l = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f091937);
        this.m = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f091936);
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) h.findViewById(R.id.obfuscated_res_0x7f0906fb);
        this.n = tBSpecificationBtn;
        tBSpecificationBtn.setText("投稿");
        this.H = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090733);
        TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) h.findViewById(R.id.obfuscated_res_0x7f0912fa);
        this.o = tBSpecificationBtn2;
        tBSpecificationBtn2.setText("立即开通");
        PersonCreatorCenterFunView personCreatorCenterFunView = (PersonCreatorCenterFunView) h.findViewById(R.id.obfuscated_res_0x7f09192f);
        this.p = personCreatorCenterFunView;
        personCreatorCenterFunView.a(R.drawable.obfuscated_res_0x7f08084b, "创作首页");
        PersonCreatorCenterFunView personCreatorCenterFunView2 = (PersonCreatorCenterFunView) h.findViewById(R.id.obfuscated_res_0x7f091930);
        this.q = personCreatorCenterFunView2;
        personCreatorCenterFunView2.a(R.drawable.obfuscated_res_0x7f080844, "视频管理");
        PersonCreatorCenterFunView personCreatorCenterFunView3 = (PersonCreatorCenterFunView) h.findViewById(R.id.obfuscated_res_0x7f09192e);
        this.r = personCreatorCenterFunView3;
        personCreatorCenterFunView3.a(R.drawable.obfuscated_res_0x7f080847, "视频数据");
        this.s = (PersonCreatorCenterDataView) h.findViewById(R.id.obfuscated_res_0x7f0926dd);
        this.t = (PersonCreatorCenterDataView) h.findViewById(R.id.obfuscated_res_0x7f0926dc);
        this.u = (PersonCreatorCenterDataView) h.findViewById(R.id.obfuscated_res_0x7f0926da);
        this.k = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f091934);
        this.v = (ImageView) h.findViewById(R.id.obfuscated_res_0x7f091908);
        PersonCreatorCenterFunView personCreatorCenterFunView4 = (PersonCreatorCenterFunView) h.findViewById(R.id.obfuscated_res_0x7f09192d);
        this.w = personCreatorCenterFunView4;
        personCreatorCenterFunView4.a(R.drawable.obfuscated_res_0x7f080819, "大神认证");
        PersonCreatorCenterFunView personCreatorCenterFunView5 = (PersonCreatorCenterFunView) h.findViewById(R.id.obfuscated_res_0x7f091931);
        this.x = personCreatorCenterFunView5;
        personCreatorCenterFunView5.a(R.drawable.obfuscated_res_0x7f080847, "贴子数据");
        this.y = (PersonCreatorCenterDataView) h.findViewById(R.id.obfuscated_res_0x7f0926df);
        this.z = (PersonCreatorCenterDataView) h.findViewById(R.id.obfuscated_res_0x7f0926de);
        this.A = (PersonCreatorCenterDataView) h.findViewById(R.id.obfuscated_res_0x7f0926db);
        PersonCreatorCenterFunView personCreatorCenterFunView6 = (PersonCreatorCenterFunView) h.findViewById(R.id.obfuscated_res_0x7f091935);
        this.M = personCreatorCenterFunView6;
        personCreatorCenterFunView6.a(R.drawable.obfuscated_res_0x7f08087f, "全新发布体验");
        PersonCreatorCenterFunView personCreatorCenterFunView7 = (PersonCreatorCenterFunView) h.findViewById(R.id.obfuscated_res_0x7f091933);
        this.N = personCreatorCenterFunView7;
        personCreatorCenterFunView7.a(R.drawable.obfuscated_res_0x7f080b30, "个人主页升级");
        PersonCreatorCenterFunView personCreatorCenterFunView8 = (PersonCreatorCenterFunView) h.findViewById(R.id.obfuscated_res_0x7f09192c);
        this.O = personCreatorCenterFunView8;
        personCreatorCenterFunView8.a(R.drawable.obfuscated_res_0x7f08090f, "专属流量扶持");
        PersonCreatorCenterFunView personCreatorCenterFunView9 = (PersonCreatorCenterFunView) h.findViewById(R.id.obfuscated_res_0x7f091932);
        this.P = personCreatorCenterFunView9;
        personCreatorCenterFunView9.a(R.drawable.obfuscated_res_0x7f08078a, "百万现金激励");
        if (Build.VERSION.SDK_INT < 24) {
            LinearLayout linearLayout4 = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f09198e);
            this.E = linearLayout4;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout4.getLayoutParams();
            layoutParams.bottomMargin = ej.f(this.c, R.dimen.tbds37);
            this.E.setLayoutParams(layoutParams);
        }
        j(tbPageContext, this.a);
    }

    @Override // com.baidu.tieba.v06
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d070e : invokeV.intValue;
    }

    @Override // com.baidu.tieba.v06
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundColor(this.J, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.K, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.L, R.color.CAM_X0204);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.v, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            uu4 d = uu4.d(this.l);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            uu4 d2 = uu4.d(this.k);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
            uu4 d3 = uu4.d(this.m);
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
            if (R.id.obfuscated_res_0x7f09190f == view2.getId()) {
                f19 f19Var = new f19(g(), (ViewGroup) h(), "person", 3, null);
                f19Var.E("5");
                f19Var.v(WorkPublishOpenHelper.OPEN_WORK_PUBLISH_FROM_PERSON);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", "9"));
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("uid", String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
            } else if (R.id.obfuscated_res_0x7f09190a == view2.getId()) {
                s(TbConfig.URL_CREATE_CENTER);
                TiebaStatic.log(new StatisticItem("c14149").param("obj_locate", "2"));
                TiebaStatic.log(new StatisticItem("c14149").param("uid", String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
            } else if (R.id.obfuscated_res_0x7f091910 == view2.getId()) {
                this.i.A(true);
            } else if (R.id.obfuscated_res_0x7f091039 == view2.getId()) {
                WorkPublishGuideActivityConfig workPublishGuideActivityConfig = new WorkPublishGuideActivityConfig(getContext());
                workPublishGuideActivityConfig.setRequestCode(25064);
                workPublishGuideActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, workPublishGuideActivityConfig));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.v06
    /* renamed from: r */
    public void i(f58 f58Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, f58Var) == null) {
            if (f58Var == null) {
                q(8);
                return;
            }
            CreationData f = f58Var.f();
            if (f == null) {
                this.l.setVisibility(8);
                this.m.setVisibility(0);
            } else {
                this.l.setVisibility(0);
                this.m.setVisibility(8);
                this.s.a(f.view_count.intValue(), "昨日播放", f.view_count_trend.intValue());
                this.t.a(f.valid_play_count.intValue(), "昨日有效播放", f.valid_play_count_trend.intValue());
                this.u.a(f.agree_count.intValue(), "昨日视频点赞", f.agree_count_trend.intValue());
            }
            if (TbSingleton.getInstance().getNewGodData() != null) {
                NewGodData newGodData = TbSingleton.getInstance().getNewGodData();
                if (!StringUtils.isNull(newGodData.getFieldName()) && newGodData.getStatus() == 3) {
                    this.x.a(R.drawable.obfuscated_res_0x7f080847, "创作数据");
                    this.w.a(R.drawable.obfuscated_res_0x7f080819, "大神考核");
                }
            }
            CreationData c = f58Var.c();
            this.y.a(c.view_count.intValue(), "昨日新增浏览", c.view_count_trend.intValue());
            this.z.a(c.agree_count.intValue(), "昨日新增点赞", c.agree_count_trend.intValue());
            this.A.a(c.comment_count.intValue(), "昨日新增评论", c.comment_trend.intValue());
            j(this.j, this.a);
        }
    }

    public final void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }
}
