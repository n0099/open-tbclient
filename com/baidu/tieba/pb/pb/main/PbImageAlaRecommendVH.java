package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.s0.s.j0.t.c;
import c.a.s0.s.q.e2;
import c.a.s0.s.q.x0;
import c.a.t0.s2.g;
import c.a.t0.s2.i;
import c.a.t0.s2.l;
import c.a.t0.s2.r.f;
import c.a.t0.s2.u.f.x;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
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
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.view.DynamicUserLikeButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes12.dex */
public class PbImageAlaRecommendVH extends TypeAdapter.ViewHolder implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public x f46552e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f46553f;

    /* renamed from: g  reason: collision with root package name */
    public View f46554g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f46555h;

    /* renamed from: i  reason: collision with root package name */
    public DynamicUserLikeButton f46556i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f46557j;
    public TbImageView k;
    public TextView l;
    public TextView m;
    public View n;
    public View o;
    public View p;
    public NEGFeedBackView q;
    public c r;
    public BdUniqueId s;
    public int skinType;
    public f t;

    /* loaded from: classes12.dex */
    public class a implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(PbImageAlaRecommendVH pbImageAlaRecommendVH) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbImageAlaRecommendVH};
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
                TiebaStatic.log(new StatisticItem("c13858").param("obj_type", 1));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements DynamicUserLikeButton.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbImageAlaRecommendVH a;

        public b(PbImageAlaRecommendVH pbImageAlaRecommendVH) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbImageAlaRecommendVH};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbImageAlaRecommendVH;
        }

        @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.t == null || this.a.t.l() == null || this.a.f46552e == null || this.a.f46552e.k == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13718").param("fid", this.a.t.l().getId()).param("fname", this.a.t.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.t.Q()).param(TiebaStatic.Params.FRIEND_UID, this.a.f46552e.k != null ? this.a.f46552e.k.getUserId() : "").param("obj_type", !this.a.f46552e.k.getIsLike()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbImageAlaRecommendVH(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, tbPageContext, bdUniqueId};
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
        this.skinType = 3;
        this.f46553f = tbPageContext;
        this.s = bdUniqueId;
        if (view == null) {
            return;
        }
        this.n = view.findViewById(i.rootLayout);
        this.f46554g = view.findViewById(i.top_divider_line);
        this.f46555h = (TextView) view.findViewById(i.titleView);
        this.f46556i = (DynamicUserLikeButton) view.findViewById(i.followBtn);
        this.f46557j = (TextView) view.findViewById(i.alaStateView);
        this.k = (TbImageView) view.findViewById(i.coverView);
        this.l = (TextView) view.findViewById(i.descView);
        this.m = (TextView) view.findViewById(i.hotView);
        this.o = view.findViewById(i.hotPoint);
        this.p = view.findViewById(i.bottomSpaceView);
        this.f46556i.setTextSize(g.tbds28);
        this.k.setPlaceHolder(2);
        this.k.setRadius(n.f(view.getContext(), g.tbds10));
        this.k.setConrers(15);
    }

    public void bindDataToView(x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xVar) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (xVar == null) {
                return;
            }
            this.f46552e = xVar;
            this.n.setOnClickListener(this);
            this.k.startLoad(xVar.f23090h, 10, false);
            if (xVar.f23091i == 1 && xVar.f23092j > 0) {
                this.f46557j.setVisibility(0);
            } else {
                this.f46557j.setVisibility(8);
            }
            this.l.setText(xVar.f23089g);
            TextView textView = this.f46555h;
            textView.setText(String.format(textView.getContext().getResources().getString(l.pb_ala_name), StringHelper.getFixedText(xVar.f23087e, 7, true)));
            TextView textView2 = this.m;
            textView2.setText(String.format(textView2.getContext().getResources().getString(l.pb_ala_audience_count), StringHelper.numFormatOverWan(xVar.f23088f)));
            this.p.setVisibility(xVar.r ? 8 : 0);
            f(xVar.s);
            g();
        }
    }

    public final void c(x xVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xVar) == null) && xVar != null && xVar.f23091i == 1) {
            if (xVar.m) {
                d(xVar.o, xVar.n);
                return;
            }
            YyExtData yyExtData = xVar.t;
            if (yyExtData != null) {
                YYLiveUtil.jumpToYYLiveRoom(this.f46553f, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "", yyExtData.streamInfo, YYLiveUtil.SOURCE_PB_WORD_RECOMMEND_LIVE_CARD);
            }
        }
    }

    public final void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<?> tbPageContext = this.f46553f;
            urlManager.dealOneLink(tbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void e(x xVar) {
        f fVar;
        YyExtData yyExtData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, xVar) == null) || (fVar = this.t) == null || fVar.l() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c13709").param("fid", this.t.l().getId()).param("fname", this.t.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.t.Q());
        MetaData metaData = xVar.k;
        String str = "";
        StatisticItem param2 = param.param("obj_param1", metaData != null ? metaData.getUserId() : "");
        if (this.t.O() != null) {
            e2 O = this.t.O();
            int calculateLiveType = YYLiveUtil.calculateLiveType(O.o1());
            if (O.o1() != null && O.o1().isLegalYYLiveData()) {
                TiebaStaticHelper.addYYParam(param2, O.o1().mYyExtData);
            } else {
                if (xVar != null && (yyExtData = xVar.t) != null) {
                    TiebaStaticHelper.addYYParam(param2, yyExtData);
                    calculateLiveType = YYLiveUtil.calculateLiveType(xVar.t);
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
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, x0Var) == null) || (tbPageContext = this.f46553f) == null) {
            return;
        }
        if (x0Var == null) {
            NEGFeedBackView nEGFeedBackView = this.q;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.setVisibility(8);
                return;
            }
            return;
        }
        if (this.q == null) {
            int f2 = n.f(tbPageContext.getPageActivity(), g.tbds44);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(n.f(this.f46553f.getPageActivity(), g.tbds130), n.f(this.f46553f.getPageActivity(), g.tbds86));
            layoutParams.addRule(11);
            layoutParams.addRule(8, i.coverView);
            NEGFeedBackView nEGFeedBackView2 = new NEGFeedBackView(this.f46553f);
            this.q = nEGFeedBackView2;
            nEGFeedBackView2.setPadding(f2, f2, f2, 0);
            ((RelativeLayout) this.n.findViewById(i.contentLayout)).addView(this.q, layoutParams);
            this.q.setEventCallback(new a(this));
        }
        this.q.setVisibility(0);
        this.q.setData(x0Var);
        this.q.onChangeSkinType();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            x xVar = this.f46552e;
            if (xVar != null && xVar.k != null) {
                this.f46556i.setVisibility(0);
                if (this.r == null) {
                    c cVar = new c(this.f46553f, this.f46556i);
                    this.r = cVar;
                    cVar.l(this.s);
                }
                this.r.n(this.f46552e.k);
                this.f46556i.setOnClickEvent(new b(this));
                return;
            }
            this.f46556i.setVisibility(8);
        }
    }

    public final void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (this.skinType != i2) {
                c.a.s0.s.u.c.d(this.n).i(c.a.t0.s2.f.CAM_X0205, c.a.t0.s2.f.CAM_X0204);
                SkinManager.setBackgroundColor(this.f46554g, c.a.t0.s2.f.CAM_X0204);
                SkinManager.setViewTextColor(this.l, c.a.t0.s2.f.CAM_X0105, 1, i2);
                SkinManager.setViewTextColor(this.f46555h, c.a.t0.s2.f.CAM_X0105, 1, i2);
                SkinManager.setViewTextColor(this.m, c.a.t0.s2.f.CAM_X0109, 1, i2);
                SkinManager.setViewTextColor(this.f46557j, c.a.t0.s2.f.CAM_X0101, 1, i2);
                NEGFeedBackView nEGFeedBackView = this.q;
                if (nEGFeedBackView != null) {
                    nEGFeedBackView.onChangeSkinType();
                }
                View view = this.o;
                view.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(view.getContext(), g.tbds32), SkinManager.getColor(c.a.t0.s2.f.CAM_X0309)));
                float f2 = n.f(this.f46557j.getContext(), g.tbds10);
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(DrawableSelector.TL_BR, c.a.t0.s2.f.CAM_X0308, c.a.t0.s2.f.CAM_X0301).tlRadius(f2).brRadius(f2).into(this.f46557j);
                this.f46556i.onChangeSkinType(i2);
            }
            this.skinType = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            int id = view.getId();
            x xVar = this.f46552e;
            if (xVar != null && id == i.rootLayout) {
                c(xVar);
                e(this.f46552e);
            }
        }
    }

    public void sendDisplayStatistic(f fVar) {
        x xVar;
        YyExtData yyExtData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) || fVar == null || fVar.l() == null || (xVar = this.f46552e) == null || xVar.q) {
            return;
        }
        this.t = fVar;
        StatisticItem param = new StatisticItem("c13708").param("fid", fVar.l().getId()).param("fname", fVar.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", fVar.Q());
        MetaData metaData = this.f46552e.k;
        String str = "";
        StatisticItem param2 = param.param("obj_param1", metaData != null ? metaData.getUserId() : "");
        if (fVar.O() != null) {
            e2 O = fVar.O();
            int calculateLiveType = YYLiveUtil.calculateLiveType(O.o1());
            if (O.o1() != null && O.o1().isLegalYYLiveData()) {
                TiebaStaticHelper.addYYParam(param2, O.o1().mYyExtData);
            } else {
                x xVar2 = this.f46552e;
                if (xVar2 != null && (yyExtData = xVar2.t) != null) {
                    TiebaStaticHelper.addYYParam(param2, yyExtData);
                    calculateLiveType = YYLiveUtil.calculateLiveType(this.f46552e.t);
                }
                param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
                param2.param(TiebaStatic.Params.OBJ_PARAM3, str);
            }
            str = TiebaStatic.YYValues.YY_LIVE;
            param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
            param2.param(TiebaStatic.Params.OBJ_PARAM3, str);
        }
        TiebaStatic.log(param2);
        this.f46552e.q = true;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tbPageContext) == null) {
            this.f46553f = tbPageContext;
        }
    }
}
