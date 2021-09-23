package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.s.f0.t.c;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.x0;
import c.a.r0.j2.h.e;
import c.a.r0.j2.k.e.x;
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
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class PbImageAlaRecommendVH extends TypeAdapter.ViewHolder implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public x f55247e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f55248f;

    /* renamed from: g  reason: collision with root package name */
    public View f55249g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f55250h;

    /* renamed from: i  reason: collision with root package name */
    public DynamicUserLikeButton f55251i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f55252j;
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
    public e t;

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public class b implements DynamicUserLikeButton.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbImageAlaRecommendVH f55253a;

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
            this.f55253a = pbImageAlaRecommendVH;
        }

        @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f55253a.t == null || this.f55253a.t.m() == null || this.f55253a.f55247e == null || this.f55253a.f55247e.k == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13718").param("fid", this.f55253a.t.m().getId()).param("fname", this.f55253a.t.m().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f55253a.t.Q()).param(TiebaStatic.Params.FRIEND_UID, this.f55253a.f55247e.k != null ? this.f55253a.f55247e.k.getUserId() : "").param("obj_type", !this.f55253a.f55247e.k.getIsLike()));
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
        this.f55248f = tbPageContext;
        this.s = bdUniqueId;
        if (view == null) {
            return;
        }
        this.n = view.findViewById(R.id.rootLayout);
        this.f55249g = view.findViewById(R.id.top_divider_line);
        this.f55250h = (TextView) view.findViewById(R.id.titleView);
        this.f55251i = (DynamicUserLikeButton) view.findViewById(R.id.followBtn);
        this.f55252j = (TextView) view.findViewById(R.id.alaStateView);
        this.k = (TbImageView) view.findViewById(R.id.coverView);
        this.l = (TextView) view.findViewById(R.id.descView);
        this.m = (TextView) view.findViewById(R.id.hotView);
        this.o = view.findViewById(R.id.hotPoint);
        this.p = view.findViewById(R.id.bottomSpaceView);
        this.f55251i.setTextSize(R.dimen.tbds28);
        this.k.setPlaceHolder(2);
        this.k.setRadius(l.g(view.getContext(), R.dimen.tbds10));
        this.k.setConrers(15);
    }

    public void bindDataToView(x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xVar) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (xVar == null) {
                return;
            }
            this.f55247e = xVar;
            this.n.setOnClickListener(this);
            this.k.startLoad(xVar.f20348h, 10, false);
            if (xVar.f20349i == 1 && xVar.f20350j > 0) {
                this.f55252j.setVisibility(0);
            } else {
                this.f55252j.setVisibility(8);
            }
            this.l.setText(xVar.f20347g);
            TextView textView = this.f55250h;
            textView.setText(String.format(textView.getContext().getResources().getString(R.string.pb_ala_name), StringHelper.getFixedText(xVar.f20345e, 7, true)));
            TextView textView2 = this.m;
            textView2.setText(String.format(textView2.getContext().getResources().getString(R.string.pb_ala_audience_count), StringHelper.numFormatOverWan(xVar.f20346f)));
            this.p.setVisibility(xVar.r ? 8 : 0);
            f(xVar.s);
            g();
        }
    }

    public final void c(x xVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xVar) == null) && xVar != null && xVar.f20349i == 1) {
            if (xVar.m) {
                d(xVar.o, xVar.n);
                return;
            }
            YyExtData yyExtData = xVar.t;
            if (yyExtData != null) {
                YYLiveUtil.jumpToYYLiveRoom(this.f55248f, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "", YYLiveUtil.SOURCE_PB_WORD_RECOMMEND_LIVE_CARD);
            }
        }
    }

    public final void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<?> tbPageContext = this.f55248f;
            urlManager.dealOneLink(tbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void e(x xVar) {
        e eVar;
        YyExtData yyExtData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, xVar) == null) || (eVar = this.t) == null || eVar.m() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c13709").param("fid", this.t.m().getId()).param("fname", this.t.m().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.t.Q());
        MetaData metaData = xVar.k;
        String str = "";
        StatisticItem param2 = param.param("obj_param1", metaData != null ? metaData.getUserId() : "");
        if (this.t.O() != null) {
            d2 O = this.t.O();
            int calculateLiveType = YYLiveUtil.calculateLiveType(O.l1());
            if (O.l1() != null && O.l1().isLegalYYLiveData()) {
                TiebaStaticHelper.addYYParam(param2, O.l1().mYyExtData);
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
        if (!(interceptable == null || interceptable.invokeL(1048580, this, x0Var) == null) || (tbPageContext = this.f55248f) == null) {
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
            int g2 = l.g(tbPageContext.getPageActivity(), R.dimen.tbds44);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.g(this.f55248f.getPageActivity(), R.dimen.tbds130), l.g(this.f55248f.getPageActivity(), R.dimen.tbds86));
            layoutParams.addRule(11);
            layoutParams.addRule(8, R.id.coverView);
            NEGFeedBackView nEGFeedBackView2 = new NEGFeedBackView(this.f55248f);
            this.q = nEGFeedBackView2;
            nEGFeedBackView2.setPadding(g2, g2, g2, 0);
            ((RelativeLayout) this.n.findViewById(R.id.contentLayout)).addView(this.q, layoutParams);
            this.q.setEventCallback(new a(this));
        }
        this.q.setVisibility(0);
        this.q.setData(x0Var);
        this.q.onChangeSkinType();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            x xVar = this.f55247e;
            if (xVar != null && xVar.k != null) {
                this.f55251i.setVisibility(0);
                if (this.r == null) {
                    c cVar = new c(this.f55248f, this.f55251i);
                    this.r = cVar;
                    cVar.l(this.s);
                }
                this.r.n(this.f55247e.k);
                this.f55251i.setOnClickEvent(new b(this));
                return;
            }
            this.f55251i.setVisibility(8);
        }
    }

    public final void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (this.skinType != i2) {
                c.a.q0.s.u.c.d(this.n).j(R.color.CAM_X0205, R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.f55249g, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0105, 1, i2);
                SkinManager.setViewTextColor(this.f55250h, R.color.CAM_X0105, 1, i2);
                SkinManager.setViewTextColor(this.m, R.color.CAM_X0109, 1, i2);
                SkinManager.setViewTextColor(this.f55252j, R.color.CAM_X0101, 1, i2);
                NEGFeedBackView nEGFeedBackView = this.q;
                if (nEGFeedBackView != null) {
                    nEGFeedBackView.onChangeSkinType();
                }
                View view = this.o;
                view.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(l.g(view.getContext(), R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0309)));
                float g2 = l.g(this.f55252j.getContext(), R.dimen.tbds10);
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(DrawableSelector.TL_BR, R.color.CAM_X0308, R.color.CAM_X0301).tlRadius(g2).brRadius(g2).into(this.f55252j);
                this.f55251i.onChangeSkinType(i2);
            }
            this.skinType = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            int id = view.getId();
            x xVar = this.f55247e;
            if (xVar != null && id == R.id.rootLayout) {
                c(xVar);
                e(this.f55247e);
            }
        }
    }

    public void sendDisplayStatistic(e eVar) {
        x xVar;
        YyExtData yyExtData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar) == null) || eVar == null || eVar.m() == null || (xVar = this.f55247e) == null || xVar.q) {
            return;
        }
        this.t = eVar;
        StatisticItem param = new StatisticItem("c13708").param("fid", eVar.m().getId()).param("fname", eVar.m().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", eVar.Q());
        MetaData metaData = this.f55247e.k;
        String str = "";
        StatisticItem param2 = param.param("obj_param1", metaData != null ? metaData.getUserId() : "");
        if (eVar.O() != null) {
            d2 O = eVar.O();
            int calculateLiveType = YYLiveUtil.calculateLiveType(O.l1());
            if (O.l1() != null && O.l1().isLegalYYLiveData()) {
                TiebaStaticHelper.addYYParam(param2, O.l1().mYyExtData);
            } else {
                x xVar2 = this.f55247e;
                if (xVar2 != null && (yyExtData = xVar2.t) != null) {
                    TiebaStaticHelper.addYYParam(param2, yyExtData);
                    calculateLiveType = YYLiveUtil.calculateLiveType(this.f55247e.t);
                }
                param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
                param2.param(TiebaStatic.Params.OBJ_PARAM3, str);
            }
            str = TiebaStatic.YYValues.YY_LIVE;
            param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
            param2.param(TiebaStatic.Params.OBJ_PARAM3, str);
        }
        TiebaStatic.log(param2);
        this.f55247e.q = true;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tbPageContext) == null) {
            this.f55248f = tbPageContext;
        }
    }
}
