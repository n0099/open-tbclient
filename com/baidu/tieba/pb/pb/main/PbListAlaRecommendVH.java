package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
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
import com.baidu.tieba.dx7;
import com.baidu.tieba.i08;
import com.baidu.tieba.kw4;
import com.baidu.tieba.ot4;
import com.baidu.tieba.wi;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class PbListAlaRecommendVH extends TypeAdapter.ViewHolder implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public AbsPbActivity b;
    public i08 c;
    public View d;
    public TbImageView e;
    public TBLottieAnimationView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public NEGFeedBackView j;
    public RelativeLayout k;
    public View l;
    public dx7 m;

    /* loaded from: classes5.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbListAlaRecommendVH a;

        public a(PbListAlaRecommendVH pbListAlaRecommendVH) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbListAlaRecommendVH};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbListAlaRecommendVH;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.f.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                this.a.f.cancelAnimation();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void a(ArrayList<Integer> arrayList, String str, ot4 ot4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, ot4Var) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(ot4 ot4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ot4Var, compoundButton, z) == null) {
            }
        }

        public b(PbListAlaRecommendVH pbListAlaRecommendVH) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbListAlaRecommendVH};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(ot4 ot4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ot4Var) == null) {
                TiebaStatic.log(new StatisticItem("c13858").param("obj_type", 2));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbListAlaRecommendVH(View view2, AbsPbActivity absPbActivity) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, absPbActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.b = absPbActivity;
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f091cb2);
        this.e = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09072c);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f0901b9);
        this.f = tBLottieAnimationView;
        tBLottieAnimationView.loop(true);
        SkinManager.setLottieAnimation(this.f, R.raw.ala_live2);
        this.f.addOnAttachStateChangeListener(new a(this));
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0907b1);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924c6);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0902f3);
        this.k = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0912c5);
        this.l = view2.findViewById(R.id.obfuscated_res_0x7f0901f0);
        this.e.setConrers(15);
        this.e.setRadius(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        this.e.setPlaceHolder(2);
        this.f.playAnimation();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            int id = view2.getId();
            i08 i08Var = this.c;
            if (i08Var != null && id == R.id.obfuscated_res_0x7f091cb2) {
                d(i08Var);
                f(this.c);
            }
        }
    }

    public void b(i08 i08Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, i08Var) == null) {
            c(TbadkCoreApplication.getInst().getSkinType());
            if (i08Var == null) {
                return;
            }
            this.c = i08Var;
            this.d.setOnClickListener(this);
            this.e.K(i08Var.e, 10, false);
            if (i08Var.b == 1) {
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
            this.g.setText(i08Var.d);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
            if (!wi.isEmpty(i08Var.a)) {
                this.h.setText(i08Var.a);
                this.h.setVisibility(0);
                layoutParams.leftMargin = xi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
            } else {
                this.h.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.i.setLayoutParams(layoutParams);
            this.i.setText(String.format(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0dfd), StringHelper.numFormatOverWan(i08Var.c)));
            h(i08Var.m);
        }
    }

    public final void f(i08 i08Var) {
        dx7 dx7Var;
        String str;
        YyExtData yyExtData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, i08Var) == null) && (dx7Var = this.m) != null && dx7Var.l() != null) {
            StatisticItem param = new StatisticItem("c13717").param("fid", this.m.l().getId()).param("fname", this.m.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.m.S());
            MetaData metaData = i08Var.f;
            String str2 = "";
            if (metaData == null) {
                str = "";
            } else {
                str = metaData.getUserId();
            }
            StatisticItem param2 = param.param("obj_param1", str);
            if (this.m.Q() != null) {
                ThreadData Q = this.m.Q();
                int calculateLiveType = YYLiveUtil.calculateLiveType(Q.getThreadAlaInfo());
                if (Q.getThreadAlaInfo() != null && Q.getThreadAlaInfo().isLegalYYLiveData()) {
                    TiebaStaticHelper.addYYParam(param2, Q.getThreadAlaInfo().mYyExtData);
                } else {
                    if (i08Var != null && (yyExtData = i08Var.n) != null) {
                        TiebaStaticHelper.addYYParam(param2, yyExtData);
                        calculateLiveType = YYLiveUtil.calculateLiveType(i08Var.n);
                    }
                    param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
                    param2.param(TiebaStatic.Params.OBJ_PARAM3, str2);
                }
                str2 = TiebaStatic.YYValues.YY_LIVE;
                param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
                param2.param(TiebaStatic.Params.OBJ_PARAM3, str2);
            }
            TiebaStatic.log(param2);
        }
    }

    public void g(dx7 dx7Var) {
        i08 i08Var;
        String str;
        YyExtData yyExtData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, dx7Var) == null) && dx7Var != null && dx7Var.l() != null && (i08Var = this.c) != null && !i08Var.l) {
            this.m = dx7Var;
            StatisticItem param = new StatisticItem("c13716").param("fid", dx7Var.l().getId()).param("fname", dx7Var.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", dx7Var.S());
            MetaData metaData = this.c.f;
            String str2 = "";
            if (metaData == null) {
                str = "";
            } else {
                str = metaData.getUserId();
            }
            StatisticItem param2 = param.param("obj_param1", str);
            if (dx7Var.Q() != null) {
                ThreadData Q = dx7Var.Q();
                int calculateLiveType = YYLiveUtil.calculateLiveType(Q.getThreadAlaInfo());
                if (Q.getThreadAlaInfo() != null && Q.getThreadAlaInfo().isLegalYYLiveData()) {
                    TiebaStaticHelper.addYYParam(param2, Q.getThreadAlaInfo().mYyExtData);
                } else {
                    i08 i08Var2 = this.c;
                    if (i08Var2 != null && (yyExtData = i08Var2.n) != null) {
                        TiebaStaticHelper.addYYParam(param2, yyExtData);
                        calculateLiveType = YYLiveUtil.calculateLiveType(this.c.n);
                    }
                    param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
                    param2.param(TiebaStatic.Params.OBJ_PARAM3, str2);
                }
                str2 = TiebaStatic.YYValues.YY_LIVE;
                param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
                param2.param(TiebaStatic.Params.OBJ_PARAM3, str2);
            }
            TiebaStatic.log(param2);
            this.c.l = true;
        }
    }

    public final void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (this.a != i) {
                kw4.d(this.d).i(R.color.CAM_X0205, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.g, R.color.CAM_X0105, 1, i);
                SkinManager.setViewTextColor(this.h, R.color.CAM_X0109, 1, i);
                SkinManager.setViewTextColor(this.i, R.color.CAM_X0109, 1, i);
                SkinManager.setViewTextColor(this.f, R.color.CAM_X0101, 1, i);
                NEGFeedBackView nEGFeedBackView = this.j;
                if (nEGFeedBackView != null) {
                    nEGFeedBackView.q();
                }
                kw4 d = kw4.d(this.f);
                d.n(R.string.J_X01);
                d.f(R.color.CAM_X0310);
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0203, i);
            }
            this.a = i;
        }
    }

    public final void d(i08 i08Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, i08Var) == null) && i08Var != null && i08Var.b == 1) {
            if (i08Var.h) {
                e(i08Var.j, i08Var.i);
            } else if (i08Var.n != null) {
                TbPageContext<BaseFragmentActivity> pageContext = this.b.getPageContext();
                YyExtData yyExtData = i08Var.n;
                YYLiveUtil.jumpToYYLiveRoom(pageContext, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "", YYLiveUtil.SOURCE_PB_VIDEO_RECOMMEND_LIVE_CARD);
            }
        }
    }

    public final void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<BaseFragmentActivity> pageContext = this.b.getPageContext();
            urlManager.dealOneLink(pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void h(ot4 ot4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, ot4Var) != null) || this.b == null) {
            return;
        }
        if (ot4Var == null) {
            NEGFeedBackView nEGFeedBackView = this.j;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.setVisibility(8);
                return;
            }
            return;
        }
        if (this.j == null) {
            this.j = new NEGFeedBackView(this.b.getPageContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(xi.g(this.b, R.dimen.tbds50), xi.g(this.b, R.dimen.tbds50));
            layoutParams.addRule(11);
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f0907b1);
            layoutParams.topMargin = xi.g(this.b, R.dimen.tbds12);
            this.k.addView(this.j, layoutParams);
            this.j.setEventCallback(new b(this));
        }
        this.j.setWebPResId(R.drawable.obfuscated_res_0x7f08076a, R.color.CAM_X0111);
        this.j.setVisibility(0);
        this.j.setData(ot4Var);
        this.j.q();
    }
}
