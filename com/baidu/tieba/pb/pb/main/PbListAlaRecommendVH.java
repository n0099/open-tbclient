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
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
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
import d.a.d.e.p.k;
import d.a.d.e.p.l;
import d.a.p0.s.q.w0;
import d.a.p0.s.u.c;
import d.a.q0.h2.h.e;
import d.a.q0.h2.k.e.a0;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class PbListAlaRecommendVH extends TypeAdapter.ViewHolder implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f19495e;

    /* renamed from: f  reason: collision with root package name */
    public AbsPbActivity f19496f;

    /* renamed from: g  reason: collision with root package name */
    public a0 f19497g;

    /* renamed from: h  reason: collision with root package name */
    public View f19498h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f19499i;
    public TBLottieAnimationView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public NEGFeedBackView n;
    public RelativeLayout o;
    public View p;
    public e q;

    /* loaded from: classes4.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbListAlaRecommendVH f19500e;

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
            this.f19500e = pbListAlaRecommendVH;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19500e.j.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f19500e.j.cancelAnimation();
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public void onCheckedChanged(w0 w0Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, w0Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, w0 w0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, w0Var) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(w0 w0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, w0Var) == null) {
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
        this.f19495e = 3;
        this.f19496f = absPbActivity;
        this.f19498h = view.findViewById(R.id.rootLayout);
        this.f19499i = (TbImageView) view.findViewById(R.id.coverView);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view.findViewById(R.id.alaStateView);
        this.j = tBLottieAnimationView;
        tBLottieAnimationView.loop(true);
        SkinManager.setLottieAnimation(this.j, R.raw.ala_live2);
        this.j.addOnAttachStateChangeListener(new a(this));
        this.k = (TextView) view.findViewById(R.id.descView);
        this.l = (TextView) view.findViewById(R.id.userInfoView);
        this.m = (TextView) view.findViewById(R.id.audienceCountInfoView);
        this.o = (RelativeLayout) view.findViewById(R.id.layout_left);
        this.p = view.findViewById(R.id.ala_item_cross_line);
        this.f19499i.setConrers(15);
        this.f19499i.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        this.f19499i.setPlaceHolder(2);
        this.j.playAnimation();
    }

    public void c(a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, a0Var) == null) {
            d(TbadkCoreApplication.getInst().getSkinType());
            if (a0Var == null) {
                return;
            }
            this.f19497g = a0Var;
            this.f19498h.setOnClickListener(this);
            this.f19499i.M(a0Var.f57604i, 10, false);
            if (a0Var.f57601f == 1) {
                this.j.setVisibility(0);
            } else {
                this.j.setVisibility(8);
            }
            this.k.setText(a0Var.f57603h);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
            if (!k.isEmpty(a0Var.f57600e)) {
                this.l.setText(a0Var.f57600e);
                this.l.setVisibility(0);
                layoutParams.leftMargin = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
            } else {
                this.l.setVisibility(8);
                layoutParams.leftMargin = 0;
            }
            this.m.setLayoutParams(layoutParams);
            this.m.setText(String.format(this.f19496f.getResources().getString(R.string.pb_ala_audience_count), StringHelper.numFormatOverWan(a0Var.f57602g)));
            i(a0Var.q);
        }
    }

    public final void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (this.f19495e != i2) {
                SkinManager.setBackgroundSelector(this.f19498h, R.color.CAM_X0205, R.color.CAM_X0204, i2);
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1, i2);
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0109, 1, i2);
                SkinManager.setViewTextColor(this.m, R.color.CAM_X0109, 1, i2);
                SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1, i2);
                NEGFeedBackView nEGFeedBackView = this.n;
                if (nEGFeedBackView != null) {
                    nEGFeedBackView.q();
                }
                c d2 = c.d(this.j);
                d2.n(R.string.J_X01);
                d2.f(R.color.CAM_X0310);
                SkinManager.setBackgroundColor(this.p, R.color.CAM_X0203, i2);
            }
            this.f19495e = i2;
        }
    }

    public final void e(a0 a0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, a0Var) == null) && a0Var != null && a0Var.f57601f == 1) {
            if (a0Var.l) {
                f(a0Var.n, a0Var.m);
            } else if (a0Var.r != null) {
                TbPageContext<BaseFragmentActivity> pageContext = this.f19496f.getPageContext();
                YyExtData yyExtData = a0Var.r;
                YYLiveUtil.jumpToYYLiveRoom(pageContext, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "", YYLiveUtil.SOURCE_PB_VIDEO_RECOMMEND_LIVE_CARD);
            }
        }
    }

    public final void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<BaseFragmentActivity> pageContext = this.f19496f.getPageContext();
            urlManager.dealOneLink(pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void g(a0 a0Var) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, a0Var) == null) || (eVar = this.q) == null || eVar.m() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c13717").param("fid", this.q.m().getId()).param("fname", this.q.m().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.q.P());
        MetaData metaData = a0Var.j;
        TiebaStatic.log(param.param("obj_param1", metaData != null ? metaData.getUserId() : ""));
    }

    public void h(e eVar) {
        a0 a0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) || eVar == null || eVar.m() == null || (a0Var = this.f19497g) == null || a0Var.p) {
            return;
        }
        this.q = eVar;
        StatisticItem param = new StatisticItem("c13716").param("fid", eVar.m().getId()).param("fname", eVar.m().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", eVar.P());
        MetaData metaData = this.f19497g.j;
        TiebaStatic.log(param.param("obj_param1", metaData != null ? metaData.getUserId() : ""));
        this.f19497g.p = true;
    }

    public final void i(w0 w0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, w0Var) == null) || this.f19496f == null) {
            return;
        }
        if (w0Var == null) {
            NEGFeedBackView nEGFeedBackView = this.n;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.setVisibility(8);
                return;
            }
            return;
        }
        if (this.n == null) {
            this.n = new NEGFeedBackView(this.f19496f.getPageContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.g(this.f19496f, R.dimen.tbds50), l.g(this.f19496f, R.dimen.tbds50));
            layoutParams.addRule(11);
            layoutParams.addRule(3, R.id.descView);
            layoutParams.topMargin = l.g(this.f19496f, R.dimen.tbds12);
            this.o.addView(this.n, layoutParams);
            this.n.setEventCallback(new b(this));
        }
        this.n.setWebPResId(R.drawable.icon_home_delete_n, R.color.CAM_X0111);
        this.n.setVisibility(0);
        this.n.setData(w0Var);
        this.n.q();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            int id = view.getId();
            a0 a0Var = this.f19497g;
            if (a0Var != null && id == R.id.rootLayout) {
                e(a0Var);
                g(this.f19497g);
            }
        }
    }
}
