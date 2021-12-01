package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.x0;
import c.a.q0.s.u.c;
import c.a.r0.q2.g;
import c.a.r0.q2.h;
import c.a.r0.q2.i;
import c.a.r0.q2.k;
import c.a.r0.q2.r.f;
import c.a.r0.q2.u.f.z;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class PbListAlaRecommendVH extends TypeAdapter.ViewHolder implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f47651e;

    /* renamed from: f  reason: collision with root package name */
    public AbsPbActivity f47652f;

    /* renamed from: g  reason: collision with root package name */
    public z f47653g;

    /* renamed from: h  reason: collision with root package name */
    public View f47654h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f47655i;

    /* renamed from: j  reason: collision with root package name */
    public TBLottieAnimationView f47656j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f47657k;
    public TextView l;
    public TextView m;
    public NEGFeedBackView n;
    public RelativeLayout o;
    public View p;
    public f q;

    /* loaded from: classes11.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbListAlaRecommendVH f47658e;

        public a(PbListAlaRecommendVH pbListAlaRecommendVH) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbListAlaRecommendVH};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47658e = pbListAlaRecommendVH;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47658e.f47656j.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f47658e.f47656j.cancelAnimation();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(PbListAlaRecommendVH pbListAlaRecommendVH) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbListAlaRecommendVH};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onCheckedChanged(x0 x0Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, x0Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, x0 x0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, x0Var) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(x0 x0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, x0Var) == null) {
                TiebaStatic.log(new StatisticItem("c13858").param("obj_type", 2));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbListAlaRecommendVH(View view, AbsPbActivity absPbActivity) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, absPbActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47651e = 3;
        this.f47652f = absPbActivity;
        this.f47654h = view.findViewById(i.rootLayout);
        this.f47655i = (TbImageView) view.findViewById(i.coverView);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view.findViewById(i.alaStateView);
        this.f47656j = tBLottieAnimationView;
        tBLottieAnimationView.loop(true);
        SkinManager.setLottieAnimation(this.f47656j, k.ala_live2);
        this.f47656j.addOnAttachStateChangeListener(new a(this));
        this.f47657k = (TextView) view.findViewById(i.descView);
        this.l = (TextView) view.findViewById(i.userInfoView);
        this.m = (TextView) view.findViewById(i.audienceCountInfoView);
        this.o = (RelativeLayout) view.findViewById(i.layout_left);
        this.p = view.findViewById(i.ala_item_cross_line);
        this.f47655i.setConrers(15);
        this.f47655i.setRadius(l.f(TbadkCoreApplication.getInst(), g.tbds21));
        this.f47655i.setPlaceHolder(2);
        this.f47656j.playAnimation();
    }

    public final void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (this.f47651e != i2) {
                c.d(this.f47654h).i(c.a.r0.q2.f.CAM_X0205, c.a.r0.q2.f.CAM_X0204);
                SkinManager.setViewTextColor(this.f47657k, c.a.r0.q2.f.CAM_X0105, 1, i2);
                SkinManager.setViewTextColor(this.l, c.a.r0.q2.f.CAM_X0109, 1, i2);
                SkinManager.setViewTextColor(this.m, c.a.r0.q2.f.CAM_X0109, 1, i2);
                SkinManager.setViewTextColor(this.f47656j, c.a.r0.q2.f.CAM_X0101, 1, i2);
                NEGFeedBackView nEGFeedBackView = this.n;
                if (nEGFeedBackView != null) {
                    nEGFeedBackView.onChangeSkinType();
                }
                c d2 = c.d(this.f47656j);
                d2.n(c.a.r0.q2.l.J_X01);
                d2.f(c.a.r0.q2.f.CAM_X0310);
                SkinManager.setBackgroundColor(this.p, c.a.r0.q2.f.CAM_X0203, i2);
            }
            this.f47651e = i2;
        }
    }

    public void bindData(z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zVar) == null) {
            b(TbadkCoreApplication.getInst().getSkinType());
            if (zVar == null) {
                return;
            }
            this.f47653g = zVar;
            this.f47654h.setOnClickListener(this);
            this.f47655i.startLoad(zVar.f22237i, 10, false);
            if (zVar.f22234f == 1) {
                this.f47656j.setVisibility(0);
            } else {
                this.f47656j.setVisibility(8);
            }
            this.f47657k.setText(zVar.f22236h);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
            if (!c.a.d.f.p.k.isEmpty(zVar.f22233e)) {
                this.l.setText(zVar.f22233e);
                this.l.setVisibility(0);
                layoutParams.leftMargin = l.f(TbadkCoreApplication.getInst(), g.M_W_X004);
            } else {
                this.l.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.m.setLayoutParams(layoutParams);
            this.m.setText(String.format(this.f47652f.getResources().getString(c.a.r0.q2.l.pb_ala_audience_count), StringHelper.numFormatOverWan(zVar.f22235g)));
            f(zVar.q);
        }
    }

    public final void c(z zVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zVar) == null) && zVar != null && zVar.f22234f == 1) {
            if (zVar.l) {
                d(zVar.n, zVar.m);
            } else if (zVar.r != null) {
                TbPageContext<BaseFragmentActivity> pageContext = this.f47652f.getPageContext();
                YyExtData yyExtData = zVar.r;
                YYLiveUtil.jumpToYYLiveRoom(pageContext, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "", YYLiveUtil.SOURCE_PB_VIDEO_RECOMMEND_LIVE_CARD);
            }
        }
    }

    public final void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<BaseFragmentActivity> pageContext = this.f47652f.getPageContext();
            urlManager.dealOneLink(pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void e(z zVar) {
        f fVar;
        YyExtData yyExtData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, zVar) == null) || (fVar = this.q) == null || fVar.l() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c13717").param("fid", this.q.l().getId()).param("fname", this.q.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.q.Q());
        MetaData metaData = zVar.f22238j;
        String str = "";
        StatisticItem param2 = param.param("obj_param1", metaData != null ? metaData.getUserId() : "");
        if (this.q.O() != null) {
            d2 O = this.q.O();
            int calculateLiveType = YYLiveUtil.calculateLiveType(O.o1());
            if (O.o1() != null && O.o1().isLegalYYLiveData()) {
                TiebaStaticHelper.addYYParam(param2, O.o1().mYyExtData);
            } else {
                if (zVar != null && (yyExtData = zVar.r) != null) {
                    TiebaStaticHelper.addYYParam(param2, yyExtData);
                    calculateLiveType = YYLiveUtil.calculateLiveType(zVar.r);
                }
                param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
                param2.param(TiebaStatic.Params.OBJ_PARAM3, str);
            }
            str = TiebaStatic.YYValues.YY_LIVE;
            param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
            param2.param(TiebaStatic.Params.OBJ_PARAM3, str);
        }
        TiebaStatic.log(param2);
    }

    public final void f(x0 x0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, x0Var) == null) || this.f47652f == null) {
            return;
        }
        if (x0Var == null) {
            NEGFeedBackView nEGFeedBackView = this.n;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.setVisibility(8);
                return;
            }
            return;
        }
        if (this.n == null) {
            this.n = new NEGFeedBackView(this.f47652f.getPageContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.f(this.f47652f, g.tbds50), l.f(this.f47652f, g.tbds50));
            layoutParams.addRule(11);
            layoutParams.addRule(3, i.descView);
            layoutParams.topMargin = l.f(this.f47652f, g.tbds12);
            this.o.addView(this.n, layoutParams);
            this.n.setEventCallback(new b(this));
        }
        this.n.setWebPResId(h.icon_home_delete_n, c.a.r0.q2.f.CAM_X0111);
        this.n.setVisibility(0);
        this.n.setData(x0Var);
        this.n.onChangeSkinType();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            int id = view.getId();
            z zVar = this.f47653g;
            if (zVar != null && id == i.rootLayout) {
                c(zVar);
                e(this.f47653g);
            }
        }
    }

    public void sendDisplayStatistic(f fVar) {
        z zVar;
        YyExtData yyExtData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) || fVar == null || fVar.l() == null || (zVar = this.f47653g) == null || zVar.p) {
            return;
        }
        this.q = fVar;
        StatisticItem param = new StatisticItem("c13716").param("fid", fVar.l().getId()).param("fname", fVar.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", fVar.Q());
        MetaData metaData = this.f47653g.f22238j;
        String str = "";
        StatisticItem param2 = param.param("obj_param1", metaData != null ? metaData.getUserId() : "");
        if (fVar.O() != null) {
            d2 O = fVar.O();
            int calculateLiveType = YYLiveUtil.calculateLiveType(O.o1());
            if (O.o1() != null && O.o1().isLegalYYLiveData()) {
                TiebaStaticHelper.addYYParam(param2, O.o1().mYyExtData);
            } else {
                z zVar2 = this.f47653g;
                if (zVar2 != null && (yyExtData = zVar2.r) != null) {
                    TiebaStaticHelper.addYYParam(param2, yyExtData);
                    calculateLiveType = YYLiveUtil.calculateLiveType(this.f47653g.r);
                }
                param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
                param2.param(TiebaStatic.Params.OBJ_PARAM3, str);
            }
            str = TiebaStatic.YYValues.YY_LIVE;
            param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
            param2.param(TiebaStatic.Params.OBJ_PARAM3, str);
        }
        TiebaStatic.log(param2);
        this.f47653g.p = true;
    }
}
