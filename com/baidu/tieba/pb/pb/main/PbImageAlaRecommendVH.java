package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.q0.s.g0.t.c;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.x0;
import c.a.r0.q2.g;
import c.a.r0.q2.i;
import c.a.r0.q2.r.f;
import c.a.r0.q2.u.f.x;
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
/* loaded from: classes11.dex */
public class PbImageAlaRecommendVH extends TypeAdapter.ViewHolder implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public x f47624e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f47625f;

    /* renamed from: g  reason: collision with root package name */
    public View f47626g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f47627h;

    /* renamed from: i  reason: collision with root package name */
    public DynamicUserLikeButton f47628i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f47629j;

    /* renamed from: k  reason: collision with root package name */
    public TbImageView f47630k;
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

    /* loaded from: classes11.dex */
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

    /* loaded from: classes11.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.t == null || this.a.t.l() == null || this.a.f47624e == null || this.a.f47624e.f22230k == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13718").param("fid", this.a.t.l().getId()).param("fname", this.a.t.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.t.Q()).param(TiebaStatic.Params.FRIEND_UID, this.a.f47624e.f22230k != null ? this.a.f47624e.f22230k.getUserId() : "").param("obj_type", !this.a.f47624e.f22230k.getIsLike()));
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
        this.f47625f = tbPageContext;
        this.s = bdUniqueId;
        if (view == null) {
            return;
        }
        this.n = view.findViewById(i.rootLayout);
        this.f47626g = view.findViewById(i.top_divider_line);
        this.f47627h = (TextView) view.findViewById(i.titleView);
        this.f47628i = (DynamicUserLikeButton) view.findViewById(i.followBtn);
        this.f47629j = (TextView) view.findViewById(i.alaStateView);
        this.f47630k = (TbImageView) view.findViewById(i.coverView);
        this.l = (TextView) view.findViewById(i.descView);
        this.m = (TextView) view.findViewById(i.hotView);
        this.o = view.findViewById(i.hotPoint);
        this.p = view.findViewById(i.bottomSpaceView);
        this.f47628i.setTextSize(g.tbds28);
        this.f47630k.setPlaceHolder(2);
        this.f47630k.setRadius(l.f(view.getContext(), g.tbds10));
        this.f47630k.setConrers(15);
    }

    public void bindDataToView(x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xVar) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (xVar == null) {
                return;
            }
            this.f47624e = xVar;
            this.n.setOnClickListener(this);
            this.f47630k.startLoad(xVar.f22227h, 10, false);
            if (xVar.f22228i == 1 && xVar.f22229j > 0) {
                this.f47629j.setVisibility(0);
            } else {
                this.f47629j.setVisibility(8);
            }
            this.l.setText(xVar.f22226g);
            TextView textView = this.f47627h;
            textView.setText(String.format(textView.getContext().getResources().getString(c.a.r0.q2.l.pb_ala_name), StringHelper.getFixedText(xVar.f22224e, 7, true)));
            TextView textView2 = this.m;
            textView2.setText(String.format(textView2.getContext().getResources().getString(c.a.r0.q2.l.pb_ala_audience_count), StringHelper.numFormatOverWan(xVar.f22225f)));
            this.p.setVisibility(xVar.r ? 8 : 0);
            f(xVar.s);
            g();
        }
    }

    public final void c(x xVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xVar) == null) && xVar != null && xVar.f22228i == 1) {
            if (xVar.m) {
                d(xVar.o, xVar.n);
                return;
            }
            YyExtData yyExtData = xVar.t;
            if (yyExtData != null) {
                YYLiveUtil.jumpToYYLiveRoom(this.f47625f, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "", yyExtData.streamInfo, YYLiveUtil.SOURCE_PB_WORD_RECOMMEND_LIVE_CARD);
            }
        }
    }

    public final void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<?> tbPageContext = this.f47625f;
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
        MetaData metaData = xVar.f22230k;
        String str = "";
        StatisticItem param2 = param.param("obj_param1", metaData != null ? metaData.getUserId() : "");
        if (this.t.O() != null) {
            d2 O = this.t.O();
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
        if (!(interceptable == null || interceptable.invokeL(1048580, this, x0Var) == null) || (tbPageContext = this.f47625f) == null) {
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
            int f2 = l.f(tbPageContext.getPageActivity(), g.tbds44);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.f(this.f47625f.getPageActivity(), g.tbds130), l.f(this.f47625f.getPageActivity(), g.tbds86));
            layoutParams.addRule(11);
            layoutParams.addRule(8, i.coverView);
            NEGFeedBackView nEGFeedBackView2 = new NEGFeedBackView(this.f47625f);
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
            x xVar = this.f47624e;
            if (xVar != null && xVar.f22230k != null) {
                this.f47628i.setVisibility(0);
                if (this.r == null) {
                    c cVar = new c(this.f47625f, this.f47628i);
                    this.r = cVar;
                    cVar.l(this.s);
                }
                this.r.n(this.f47624e.f22230k);
                this.f47628i.setOnClickEvent(new b(this));
                return;
            }
            this.f47628i.setVisibility(8);
        }
    }

    public final void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (this.skinType != i2) {
                c.a.q0.s.u.c.d(this.n).i(c.a.r0.q2.f.CAM_X0205, c.a.r0.q2.f.CAM_X0204);
                SkinManager.setBackgroundColor(this.f47626g, c.a.r0.q2.f.CAM_X0204);
                SkinManager.setViewTextColor(this.l, c.a.r0.q2.f.CAM_X0105, 1, i2);
                SkinManager.setViewTextColor(this.f47627h, c.a.r0.q2.f.CAM_X0105, 1, i2);
                SkinManager.setViewTextColor(this.m, c.a.r0.q2.f.CAM_X0109, 1, i2);
                SkinManager.setViewTextColor(this.f47629j, c.a.r0.q2.f.CAM_X0101, 1, i2);
                NEGFeedBackView nEGFeedBackView = this.q;
                if (nEGFeedBackView != null) {
                    nEGFeedBackView.onChangeSkinType();
                }
                View view = this.o;
                view.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(l.f(view.getContext(), g.tbds32), SkinManager.getColor(c.a.r0.q2.f.CAM_X0309)));
                float f2 = l.f(this.f47629j.getContext(), g.tbds10);
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(DrawableSelector.TL_BR, c.a.r0.q2.f.CAM_X0308, c.a.r0.q2.f.CAM_X0301).tlRadius(f2).brRadius(f2).into(this.f47629j);
                this.f47628i.onChangeSkinType(i2);
            }
            this.skinType = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            int id = view.getId();
            x xVar = this.f47624e;
            if (xVar != null && id == i.rootLayout) {
                c(xVar);
                e(this.f47624e);
            }
        }
    }

    public void sendDisplayStatistic(f fVar) {
        x xVar;
        YyExtData yyExtData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) || fVar == null || fVar.l() == null || (xVar = this.f47624e) == null || xVar.q) {
            return;
        }
        this.t = fVar;
        StatisticItem param = new StatisticItem("c13708").param("fid", fVar.l().getId()).param("fname", fVar.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", fVar.Q());
        MetaData metaData = this.f47624e.f22230k;
        String str = "";
        StatisticItem param2 = param.param("obj_param1", metaData != null ? metaData.getUserId() : "");
        if (fVar.O() != null) {
            d2 O = fVar.O();
            int calculateLiveType = YYLiveUtil.calculateLiveType(O.o1());
            if (O.o1() != null && O.o1().isLegalYYLiveData()) {
                TiebaStaticHelper.addYYParam(param2, O.o1().mYyExtData);
            } else {
                x xVar2 = this.f47624e;
                if (xVar2 != null && (yyExtData = xVar2.t) != null) {
                    TiebaStaticHelper.addYYParam(param2, yyExtData);
                    calculateLiveType = YYLiveUtil.calculateLiveType(this.f47624e.t);
                }
                param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
                param2.param(TiebaStatic.Params.OBJ_PARAM3, str);
            }
            str = TiebaStatic.YYValues.YY_LIVE;
            param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
            param2.param(TiebaStatic.Params.OBJ_PARAM3, str);
        }
        TiebaStatic.log(param2);
        this.f47624e.q = true;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tbPageContext) == null) {
            this.f47625f = tbPageContext;
        }
    }
}
