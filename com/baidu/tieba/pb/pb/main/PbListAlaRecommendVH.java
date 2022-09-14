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
import com.baidu.tieba.ay7;
import com.baidu.tieba.dj;
import com.baidu.tieba.ej;
import com.baidu.tieba.is4;
import com.baidu.tieba.uu4;
import com.baidu.tieba.vu7;
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
    public ay7 c;
    public View d;
    public TbImageView e;
    public TBLottieAnimationView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public NEGFeedBackView j;
    public RelativeLayout k;
    public View l;
    public vu7 m;

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
        public void a(ArrayList<Integer> arrayList, String str, is4 is4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, is4Var) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(is4 is4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, is4Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(is4 is4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, is4Var) == null) {
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
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f091c6b);
        this.e = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090715);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f0901b1);
        this.f = tBLottieAnimationView;
        tBLottieAnimationView.loop(true);
        SkinManager.setLottieAnimation(this.f, R.raw.ala_live2);
        this.f.addOnAttachStateChangeListener(new a(this));
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09079a);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092484);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0902e4);
        this.k = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091296);
        this.l = view2.findViewById(R.id.obfuscated_res_0x7f0901e8);
        this.e.setConrers(15);
        this.e.setRadius(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        this.e.setPlaceHolder(2);
        this.f.playAnimation();
    }

    public void b(ay7 ay7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ay7Var) == null) {
            c(TbadkCoreApplication.getInst().getSkinType());
            if (ay7Var == null) {
                return;
            }
            this.c = ay7Var;
            this.d.setOnClickListener(this);
            this.e.K(ay7Var.e, 10, false);
            if (ay7Var.b == 1) {
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
            this.g.setText(ay7Var.d);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
            if (!dj.isEmpty(ay7Var.a)) {
                this.h.setText(ay7Var.a);
                this.h.setVisibility(0);
                layoutParams.leftMargin = ej.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
            } else {
                this.h.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.i.setLayoutParams(layoutParams);
            this.i.setText(String.format(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0dd5), StringHelper.numFormatOverWan(ay7Var.c)));
            h(ay7Var.m);
        }
    }

    public final void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (this.a != i) {
                uu4.d(this.d).i(R.color.CAM_X0205, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.g, R.color.CAM_X0105, 1, i);
                SkinManager.setViewTextColor(this.h, R.color.CAM_X0109, 1, i);
                SkinManager.setViewTextColor(this.i, R.color.CAM_X0109, 1, i);
                SkinManager.setViewTextColor(this.f, R.color.CAM_X0101, 1, i);
                NEGFeedBackView nEGFeedBackView = this.j;
                if (nEGFeedBackView != null) {
                    nEGFeedBackView.q();
                }
                uu4 d = uu4.d(this.f);
                d.n(R.string.J_X01);
                d.f(R.color.CAM_X0310);
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0203, i);
            }
            this.a = i;
        }
    }

    public final void d(ay7 ay7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ay7Var) == null) && ay7Var != null && ay7Var.b == 1) {
            if (ay7Var.h) {
                e(ay7Var.j, ay7Var.i);
            } else if (ay7Var.n != null) {
                TbPageContext<BaseFragmentActivity> pageContext = this.b.getPageContext();
                YyExtData yyExtData = ay7Var.n;
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

    public final void f(ay7 ay7Var) {
        vu7 vu7Var;
        YyExtData yyExtData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, ay7Var) == null) || (vu7Var = this.m) == null || vu7Var.l() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c13717").param("fid", this.m.l().getId()).param("fname", this.m.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.m.Q());
        MetaData metaData = ay7Var.f;
        String str = "";
        StatisticItem param2 = param.param("obj_param1", metaData != null ? metaData.getUserId() : "");
        if (this.m.O() != null) {
            ThreadData O = this.m.O();
            int calculateLiveType = YYLiveUtil.calculateLiveType(O.getThreadAlaInfo());
            if (O.getThreadAlaInfo() != null && O.getThreadAlaInfo().isLegalYYLiveData()) {
                TiebaStaticHelper.addYYParam(param2, O.getThreadAlaInfo().mYyExtData);
            } else {
                if (ay7Var != null && (yyExtData = ay7Var.n) != null) {
                    TiebaStaticHelper.addYYParam(param2, yyExtData);
                    calculateLiveType = YYLiveUtil.calculateLiveType(ay7Var.n);
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

    public void g(vu7 vu7Var) {
        ay7 ay7Var;
        YyExtData yyExtData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, vu7Var) == null) || vu7Var == null || vu7Var.l() == null || (ay7Var = this.c) == null || ay7Var.l) {
            return;
        }
        this.m = vu7Var;
        StatisticItem param = new StatisticItem("c13716").param("fid", vu7Var.l().getId()).param("fname", vu7Var.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", vu7Var.Q());
        MetaData metaData = this.c.f;
        String str = "";
        StatisticItem param2 = param.param("obj_param1", metaData != null ? metaData.getUserId() : "");
        if (vu7Var.O() != null) {
            ThreadData O = vu7Var.O();
            int calculateLiveType = YYLiveUtil.calculateLiveType(O.getThreadAlaInfo());
            if (O.getThreadAlaInfo() != null && O.getThreadAlaInfo().isLegalYYLiveData()) {
                TiebaStaticHelper.addYYParam(param2, O.getThreadAlaInfo().mYyExtData);
            } else {
                ay7 ay7Var2 = this.c;
                if (ay7Var2 != null && (yyExtData = ay7Var2.n) != null) {
                    TiebaStaticHelper.addYYParam(param2, yyExtData);
                    calculateLiveType = YYLiveUtil.calculateLiveType(this.c.n);
                }
                param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
                param2.param(TiebaStatic.Params.OBJ_PARAM3, str);
            }
            str = TiebaStatic.YYValues.YY_LIVE;
            param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
            param2.param(TiebaStatic.Params.OBJ_PARAM3, str);
        }
        TiebaStatic.log(param2);
        this.c.l = true;
    }

    public final void h(is4 is4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, is4Var) == null) || this.b == null) {
            return;
        }
        if (is4Var == null) {
            NEGFeedBackView nEGFeedBackView = this.j;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.setVisibility(8);
                return;
            }
            return;
        }
        if (this.j == null) {
            this.j = new NEGFeedBackView(this.b.getPageContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ej.f(this.b, R.dimen.tbds50), ej.f(this.b, R.dimen.tbds50));
            layoutParams.addRule(11);
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f09079a);
            layoutParams.topMargin = ej.f(this.b, R.dimen.tbds12);
            this.k.addView(this.j, layoutParams);
            this.j.setEventCallback(new b(this));
        }
        this.j.setWebPResId(R.drawable.obfuscated_res_0x7f080760, R.color.CAM_X0111);
        this.j.setVisibility(0);
        this.j.setData(is4Var);
        this.j.q();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            int id = view2.getId();
            ay7 ay7Var = this.c;
            if (ay7Var != null && id == R.id.obfuscated_res_0x7f091c6b) {
                d(ay7Var);
                f(this.c);
            }
        }
    }
}
