package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.x0;
import c.a.q0.s.u.c;
import c.a.r0.k2.h.e;
import c.a.r0.k2.k.e.z;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class PbListAlaRecommendVH extends TypeAdapter.ViewHolder implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f55209e;

    /* renamed from: f  reason: collision with root package name */
    public AbsPbActivity f55210f;

    /* renamed from: g  reason: collision with root package name */
    public z f55211g;

    /* renamed from: h  reason: collision with root package name */
    public View f55212h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f55213i;

    /* renamed from: j  reason: collision with root package name */
    public TBLottieAnimationView f55214j;
    public TextView k;
    public TextView l;
    public TextView m;
    public NEGFeedBackView n;
    public RelativeLayout o;
    public View p;
    public e q;

    /* loaded from: classes7.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbListAlaRecommendVH f55215e;

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
            this.f55215e = pbListAlaRecommendVH;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f55215e.f55214j.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f55215e.f55214j.cancelAnimation();
            }
        }
    }

    /* loaded from: classes7.dex */
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
        this.f55209e = 3;
        this.f55210f = absPbActivity;
        this.f55212h = view.findViewById(R.id.rootLayout);
        this.f55213i = (TbImageView) view.findViewById(R.id.coverView);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view.findViewById(R.id.alaStateView);
        this.f55214j = tBLottieAnimationView;
        tBLottieAnimationView.loop(true);
        SkinManager.setLottieAnimation(this.f55214j, R.raw.ala_live2);
        this.f55214j.addOnAttachStateChangeListener(new a(this));
        this.k = (TextView) view.findViewById(R.id.descView);
        this.l = (TextView) view.findViewById(R.id.userInfoView);
        this.m = (TextView) view.findViewById(R.id.audienceCountInfoView);
        this.o = (RelativeLayout) view.findViewById(R.id.layout_left);
        this.p = view.findViewById(R.id.ala_item_cross_line);
        this.f55213i.setConrers(15);
        this.f55213i.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        this.f55213i.setPlaceHolder(2);
        this.f55214j.playAnimation();
    }

    public final void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (this.f55209e != i2) {
                c.d(this.f55212h).i(R.color.CAM_X0205, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1, i2);
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0109, 1, i2);
                SkinManager.setViewTextColor(this.m, R.color.CAM_X0109, 1, i2);
                SkinManager.setViewTextColor(this.f55214j, R.color.CAM_X0101, 1, i2);
                NEGFeedBackView nEGFeedBackView = this.n;
                if (nEGFeedBackView != null) {
                    nEGFeedBackView.onChangeSkinType();
                }
                c d2 = c.d(this.f55214j);
                d2.n(R.string.J_X01);
                d2.f(R.color.CAM_X0310);
                SkinManager.setBackgroundColor(this.p, R.color.CAM_X0203, i2);
            }
            this.f55209e = i2;
        }
    }

    public void bindData(z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zVar) == null) {
            b(TbadkCoreApplication.getInst().getSkinType());
            if (zVar == null) {
                return;
            }
            this.f55211g = zVar;
            this.f55212h.setOnClickListener(this);
            this.f55213i.startLoad(zVar.f20549i, 10, false);
            if (zVar.f20546f == 1) {
                this.f55214j.setVisibility(0);
            } else {
                this.f55214j.setVisibility(8);
            }
            this.k.setText(zVar.f20548h);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
            if (!k.isEmpty(zVar.f20545e)) {
                this.l.setText(zVar.f20545e);
                this.l.setVisibility(0);
                layoutParams.leftMargin = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
            } else {
                this.l.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.m.setLayoutParams(layoutParams);
            this.m.setText(String.format(this.f55210f.getResources().getString(R.string.pb_ala_audience_count), StringHelper.numFormatOverWan(zVar.f20547g)));
            f(zVar.q);
        }
    }

    public final void c(z zVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zVar) == null) && zVar != null && zVar.f20546f == 1) {
            if (zVar.l) {
                d(zVar.n, zVar.m);
            } else if (zVar.r != null) {
                TbPageContext<BaseFragmentActivity> pageContext = this.f55210f.getPageContext();
                YyExtData yyExtData = zVar.r;
                YYLiveUtil.jumpToYYLiveRoom(pageContext, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "", YYLiveUtil.SOURCE_PB_VIDEO_RECOMMEND_LIVE_CARD);
            }
        }
    }

    public final void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<BaseFragmentActivity> pageContext = this.f55210f.getPageContext();
            urlManager.dealOneLink(pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void e(z zVar) {
        e eVar;
        YyExtData yyExtData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, zVar) == null) || (eVar = this.q) == null || eVar.m() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c13717").param("fid", this.q.m().getId()).param("fname", this.q.m().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.q.Q());
        MetaData metaData = zVar.f20550j;
        String str = "";
        StatisticItem param2 = param.param("obj_param1", metaData != null ? metaData.getUserId() : "");
        if (this.q.O() != null) {
            d2 O = this.q.O();
            int calculateLiveType = YYLiveUtil.calculateLiveType(O.l1());
            if (O.l1() != null && O.l1().isLegalYYLiveData()) {
                TiebaStaticHelper.addYYParam(param2, O.l1().mYyExtData);
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
        if (!(interceptable == null || interceptable.invokeL(1048581, this, x0Var) == null) || this.f55210f == null) {
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
            this.n = new NEGFeedBackView(this.f55210f.getPageContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.g(this.f55210f, R.dimen.tbds50), l.g(this.f55210f, R.dimen.tbds50));
            layoutParams.addRule(11);
            layoutParams.addRule(3, R.id.descView);
            layoutParams.topMargin = l.g(this.f55210f, R.dimen.tbds12);
            this.o.addView(this.n, layoutParams);
            this.n.setEventCallback(new b(this));
        }
        this.n.setWebPResId(R.drawable.icon_home_delete_n, R.color.CAM_X0111);
        this.n.setVisibility(0);
        this.n.setData(x0Var);
        this.n.onChangeSkinType();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            int id = view.getId();
            z zVar = this.f55211g;
            if (zVar != null && id == R.id.rootLayout) {
                c(zVar);
                e(this.f55211g);
            }
        }
    }

    public void sendDisplayStatistic(e eVar) {
        z zVar;
        YyExtData yyExtData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) || eVar == null || eVar.m() == null || (zVar = this.f55211g) == null || zVar.p) {
            return;
        }
        this.q = eVar;
        StatisticItem param = new StatisticItem("c13716").param("fid", eVar.m().getId()).param("fname", eVar.m().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", eVar.Q());
        MetaData metaData = this.f55211g.f20550j;
        String str = "";
        StatisticItem param2 = param.param("obj_param1", metaData != null ? metaData.getUserId() : "");
        if (eVar.O() != null) {
            d2 O = eVar.O();
            int calculateLiveType = YYLiveUtil.calculateLiveType(O.l1());
            if (O.l1() != null && O.l1().isLegalYYLiveData()) {
                TiebaStaticHelper.addYYParam(param2, O.l1().mYyExtData);
            } else {
                z zVar2 = this.f55211g;
                if (zVar2 != null && (yyExtData = zVar2.r) != null) {
                    TiebaStaticHelper.addYYParam(param2, yyExtData);
                    calculateLiveType = YYLiveUtil.calculateLiveType(this.f55211g.r);
                }
                param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
                param2.param(TiebaStatic.Params.OBJ_PARAM3, str);
            }
            str = TiebaStatic.YYValues.YY_LIVE;
            param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
            param2.param(TiebaStatic.Params.OBJ_PARAM3, str);
        }
        TiebaStatic.log(param2);
        this.f55211g.p = true;
    }
}
