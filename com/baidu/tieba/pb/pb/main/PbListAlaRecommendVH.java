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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bs7;
import com.repackage.kv7;
import com.repackage.lp4;
import com.repackage.ni;
import com.repackage.oi;
import com.repackage.vr4;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PbListAlaRecommendVH extends TypeAdapter.ViewHolder implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public AbsPbActivity b;
    public kv7 c;
    public View d;
    public TbImageView e;
    public TBLottieAnimationView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public NEGFeedBackView j;
    public RelativeLayout k;
    public View l;
    public bs7 m;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
        public void a(ArrayList<Integer> arrayList, String str, lp4 lp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, lp4Var) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(lp4 lp4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lp4Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(lp4 lp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lp4Var) == null) {
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
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f091ac9);
        this.e = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090710);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f0901b6);
        this.f = tBLottieAnimationView;
        tBLottieAnimationView.loop(true);
        SkinManager.setLottieAnimation(this.f, R.raw.ala_live2);
        this.f.addOnAttachStateChangeListener(new a(this));
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090783);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092279);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0902d3);
        this.k = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0911da);
        this.l = view2.findViewById(R.id.obfuscated_res_0x7f0901ec);
        this.e.setConrers(15);
        this.e.setRadius(oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        this.e.setPlaceHolder(2);
        this.f.playAnimation();
    }

    public void d(kv7 kv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kv7Var) == null) {
            e(TbadkCoreApplication.getInst().getSkinType());
            if (kv7Var == null) {
                return;
            }
            this.c = kv7Var;
            this.d.setOnClickListener(this);
            this.e.K(kv7Var.e, 10, false);
            if (kv7Var.b == 1) {
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
            this.g.setText(kv7Var.d);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
            if (!ni.isEmpty(kv7Var.a)) {
                this.h.setText(kv7Var.a);
                this.h.setVisibility(0);
                layoutParams.leftMargin = oi.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
            } else {
                this.h.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.i.setLayoutParams(layoutParams);
            this.i.setText(String.format(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0d90), StringHelper.numFormatOverWan(kv7Var.c)));
            j(kv7Var.m);
        }
    }

    public final void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (this.a != i) {
                vr4.d(this.d).i(R.color.CAM_X0205, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.g, R.color.CAM_X0105, 1, i);
                SkinManager.setViewTextColor(this.h, R.color.CAM_X0109, 1, i);
                SkinManager.setViewTextColor(this.i, R.color.CAM_X0109, 1, i);
                SkinManager.setViewTextColor(this.f, R.color.CAM_X0101, 1, i);
                NEGFeedBackView nEGFeedBackView = this.j;
                if (nEGFeedBackView != null) {
                    nEGFeedBackView.r();
                }
                vr4 d = vr4.d(this.f);
                d.n(R.string.J_X01);
                d.f(R.color.CAM_X0310);
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0203, i);
            }
            this.a = i;
        }
    }

    public final void f(kv7 kv7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kv7Var) == null) && kv7Var != null && kv7Var.b == 1) {
            if (kv7Var.h) {
                g(kv7Var.j, kv7Var.i);
            } else if (kv7Var.n != null) {
                TbPageContext<BaseFragmentActivity> pageContext = this.b.getPageContext();
                YyExtData yyExtData = kv7Var.n;
                YYLiveUtil.jumpToYYLiveRoom(pageContext, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "", YYLiveUtil.SOURCE_PB_VIDEO_RECOMMEND_LIVE_CARD);
            }
        }
    }

    public final void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<BaseFragmentActivity> pageContext = this.b.getPageContext();
            urlManager.dealOneLink(pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void h(kv7 kv7Var) {
        bs7 bs7Var;
        YyExtData yyExtData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, kv7Var) == null) || (bs7Var = this.m) == null || bs7Var.l() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c13717").param("fid", this.m.l().getId()).param("fname", this.m.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.m.Q());
        MetaData metaData = kv7Var.f;
        String str = "";
        StatisticItem param2 = param.param("obj_param1", metaData != null ? metaData.getUserId() : "");
        if (this.m.O() != null) {
            ThreadData O = this.m.O();
            int calculateLiveType = YYLiveUtil.calculateLiveType(O.getThreadAlaInfo());
            if (O.getThreadAlaInfo() != null && O.getThreadAlaInfo().isLegalYYLiveData()) {
                TiebaStaticHelper.addYYParam(param2, O.getThreadAlaInfo().mYyExtData);
            } else {
                if (kv7Var != null && (yyExtData = kv7Var.n) != null) {
                    TiebaStaticHelper.addYYParam(param2, yyExtData);
                    calculateLiveType = YYLiveUtil.calculateLiveType(kv7Var.n);
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

    public void i(bs7 bs7Var) {
        kv7 kv7Var;
        YyExtData yyExtData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bs7Var) == null) || bs7Var == null || bs7Var.l() == null || (kv7Var = this.c) == null || kv7Var.l) {
            return;
        }
        this.m = bs7Var;
        StatisticItem param = new StatisticItem("c13716").param("fid", bs7Var.l().getId()).param("fname", bs7Var.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", bs7Var.Q());
        MetaData metaData = this.c.f;
        String str = "";
        StatisticItem param2 = param.param("obj_param1", metaData != null ? metaData.getUserId() : "");
        if (bs7Var.O() != null) {
            ThreadData O = bs7Var.O();
            int calculateLiveType = YYLiveUtil.calculateLiveType(O.getThreadAlaInfo());
            if (O.getThreadAlaInfo() != null && O.getThreadAlaInfo().isLegalYYLiveData()) {
                TiebaStaticHelper.addYYParam(param2, O.getThreadAlaInfo().mYyExtData);
            } else {
                kv7 kv7Var2 = this.c;
                if (kv7Var2 != null && (yyExtData = kv7Var2.n) != null) {
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

    public final void j(lp4 lp4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, lp4Var) == null) || this.b == null) {
            return;
        }
        if (lp4Var == null) {
            NEGFeedBackView nEGFeedBackView = this.j;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.setVisibility(8);
                return;
            }
            return;
        }
        if (this.j == null) {
            this.j = new NEGFeedBackView(this.b.getPageContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(oi.f(this.b, R.dimen.tbds50), oi.f(this.b, R.dimen.tbds50));
            layoutParams.addRule(11);
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f090783);
            layoutParams.topMargin = oi.f(this.b, R.dimen.tbds12);
            this.k.addView(this.j, layoutParams);
            this.j.setEventCallback(new b(this));
        }
        this.j.setWebPResId(R.drawable.obfuscated_res_0x7f080758, R.color.CAM_X0111);
        this.j.setVisibility(0);
        this.j.setData(lp4Var);
        this.j.r();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            int id = view2.getId();
            kv7 kv7Var = this.c;
            if (kv7Var != null && id == R.id.obfuscated_res_0x7f091ac9) {
                f(kv7Var);
                h(this.c);
            }
        }
    }
}
