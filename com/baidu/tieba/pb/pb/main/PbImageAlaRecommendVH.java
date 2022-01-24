package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.s0.s.k0.t.c;
import c.a.s0.s.q.e2;
import c.a.s0.s.q.x0;
import c.a.t0.t2.g;
import c.a.t0.t2.i;
import c.a.t0.t2.l;
import c.a.t0.t2.r.f;
import c.a.t0.t2.u.f.y;
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
    public y f46580e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f46581f;

    /* renamed from: g  reason: collision with root package name */
    public View f46582g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f46583h;

    /* renamed from: i  reason: collision with root package name */
    public DynamicUserLikeButton f46584i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f46585j;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.t == null || this.a.t.l() == null || this.a.f46580e == null || this.a.f46580e.k == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13718").param("fid", this.a.t.l().getId()).param("fname", this.a.t.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.t.Q()).param(TiebaStatic.Params.FRIEND_UID, this.a.f46580e.k != null ? this.a.f46580e.k.getUserId() : "").param("obj_type", !this.a.f46580e.k.getIsLike()));
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
        this.f46581f = tbPageContext;
        this.s = bdUniqueId;
        if (view == null) {
            return;
        }
        this.n = view.findViewById(i.rootLayout);
        this.f46582g = view.findViewById(i.top_divider_line);
        this.f46583h = (TextView) view.findViewById(i.titleView);
        this.f46584i = (DynamicUserLikeButton) view.findViewById(i.followBtn);
        this.f46585j = (TextView) view.findViewById(i.alaStateView);
        this.k = (TbImageView) view.findViewById(i.coverView);
        this.l = (TextView) view.findViewById(i.descView);
        this.m = (TextView) view.findViewById(i.hotView);
        this.o = view.findViewById(i.hotPoint);
        this.p = view.findViewById(i.bottomSpaceView);
        this.f46584i.setTextSize(g.tbds28);
        this.k.setPlaceHolder(2);
        this.k.setRadius(n.f(view.getContext(), g.tbds10));
        this.k.setConrers(15);
    }

    public void bindDataToView(y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yVar) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (yVar == null) {
                return;
            }
            this.f46580e = yVar;
            this.n.setOnClickListener(this);
            this.k.startLoad(yVar.f23390h, 10, false);
            if (yVar.f23391i == 1 && yVar.f23392j > 0) {
                this.f46585j.setVisibility(0);
            } else {
                this.f46585j.setVisibility(8);
            }
            this.l.setText(yVar.f23389g);
            TextView textView = this.f46583h;
            textView.setText(String.format(textView.getContext().getResources().getString(l.pb_ala_name), StringHelper.getFixedText(yVar.f23387e, 7, true)));
            TextView textView2 = this.m;
            textView2.setText(String.format(textView2.getContext().getResources().getString(l.pb_ala_audience_count), StringHelper.numFormatOverWan(yVar.f23388f)));
            this.p.setVisibility(yVar.r ? 8 : 0);
            f(yVar.s);
            g();
        }
    }

    public final void c(y yVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yVar) == null) && yVar != null && yVar.f23391i == 1) {
            if (yVar.m) {
                d(yVar.o, yVar.n);
                return;
            }
            YyExtData yyExtData = yVar.t;
            if (yyExtData != null) {
                YYLiveUtil.jumpToYYLiveRoom(this.f46581f, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "", yyExtData.streamInfo, YYLiveUtil.SOURCE_PB_WORD_RECOMMEND_LIVE_CARD);
            }
        }
    }

    public final void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<?> tbPageContext = this.f46581f;
            urlManager.dealOneLink(tbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void e(y yVar) {
        f fVar;
        YyExtData yyExtData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, yVar) == null) || (fVar = this.t) == null || fVar.l() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c13709").param("fid", this.t.l().getId()).param("fname", this.t.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.t.Q());
        MetaData metaData = yVar.k;
        String str = "";
        StatisticItem param2 = param.param("obj_param1", metaData != null ? metaData.getUserId() : "");
        if (this.t.O() != null) {
            e2 O = this.t.O();
            int calculateLiveType = YYLiveUtil.calculateLiveType(O.p1());
            if (O.p1() != null && O.p1().isLegalYYLiveData()) {
                TiebaStaticHelper.addYYParam(param2, O.p1().mYyExtData);
            } else {
                if (yVar != null && (yyExtData = yVar.t) != null) {
                    TiebaStaticHelper.addYYParam(param2, yyExtData);
                    calculateLiveType = YYLiveUtil.calculateLiveType(yVar.t);
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
        if (!(interceptable == null || interceptable.invokeL(1048580, this, x0Var) == null) || (tbPageContext = this.f46581f) == null) {
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
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(n.f(this.f46581f.getPageActivity(), g.tbds130), n.f(this.f46581f.getPageActivity(), g.tbds86));
            layoutParams.addRule(11);
            layoutParams.addRule(8, i.coverView);
            NEGFeedBackView nEGFeedBackView2 = new NEGFeedBackView(this.f46581f);
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
            y yVar = this.f46580e;
            if (yVar != null && yVar.k != null) {
                this.f46584i.setVisibility(0);
                if (this.r == null) {
                    c cVar = new c(this.f46581f, this.f46584i);
                    this.r = cVar;
                    cVar.l(this.s);
                }
                this.r.n(this.f46580e.k);
                this.f46584i.setOnClickEvent(new b(this));
                return;
            }
            this.f46584i.setVisibility(8);
        }
    }

    public final void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (this.skinType != i2) {
                c.a.s0.s.u.c.d(this.n).i(c.a.t0.t2.f.CAM_X0205, c.a.t0.t2.f.CAM_X0204);
                SkinManager.setBackgroundColor(this.f46582g, c.a.t0.t2.f.CAM_X0204);
                SkinManager.setViewTextColor(this.l, c.a.t0.t2.f.CAM_X0105, 1, i2);
                SkinManager.setViewTextColor(this.f46583h, c.a.t0.t2.f.CAM_X0105, 1, i2);
                SkinManager.setViewTextColor(this.m, c.a.t0.t2.f.CAM_X0109, 1, i2);
                SkinManager.setViewTextColor(this.f46585j, c.a.t0.t2.f.CAM_X0101, 1, i2);
                NEGFeedBackView nEGFeedBackView = this.q;
                if (nEGFeedBackView != null) {
                    nEGFeedBackView.onChangeSkinType();
                }
                View view = this.o;
                view.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(view.getContext(), g.tbds32), SkinManager.getColor(c.a.t0.t2.f.CAM_X0309)));
                float f2 = n.f(this.f46585j.getContext(), g.tbds10);
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(DrawableSelector.TL_BR, c.a.t0.t2.f.CAM_X0308, c.a.t0.t2.f.CAM_X0301).tlRadius(f2).brRadius(f2).into(this.f46585j);
                this.f46584i.onChangeSkinType(i2);
            }
            this.skinType = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            int id = view.getId();
            y yVar = this.f46580e;
            if (yVar != null && id == i.rootLayout) {
                c(yVar);
                e(this.f46580e);
            }
        }
    }

    public void sendDisplayStatistic(f fVar) {
        y yVar;
        YyExtData yyExtData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) || fVar == null || fVar.l() == null || (yVar = this.f46580e) == null || yVar.q) {
            return;
        }
        this.t = fVar;
        StatisticItem param = new StatisticItem("c13708").param("fid", fVar.l().getId()).param("fname", fVar.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", fVar.Q());
        MetaData metaData = this.f46580e.k;
        String str = "";
        StatisticItem param2 = param.param("obj_param1", metaData != null ? metaData.getUserId() : "");
        if (fVar.O() != null) {
            e2 O = fVar.O();
            int calculateLiveType = YYLiveUtil.calculateLiveType(O.p1());
            if (O.p1() != null && O.p1().isLegalYYLiveData()) {
                TiebaStaticHelper.addYYParam(param2, O.p1().mYyExtData);
            } else {
                y yVar2 = this.f46580e;
                if (yVar2 != null && (yyExtData = yVar2.t) != null) {
                    TiebaStaticHelper.addYYParam(param2, yyExtData);
                    calculateLiveType = YYLiveUtil.calculateLiveType(this.f46580e.t);
                }
                param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
                param2.param(TiebaStatic.Params.OBJ_PARAM3, str);
            }
            str = TiebaStatic.YYValues.YY_LIVE;
            param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
            param2.param(TiebaStatic.Params.OBJ_PARAM3, str);
        }
        TiebaStatic.log(param2);
        this.f46580e.q = true;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tbPageContext) == null) {
            this.f46581f = tbPageContext;
        }
    }
}
