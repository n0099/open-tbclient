package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
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
import d.a.c.e.p.l;
import d.a.r0.r.f0.s.c;
import d.a.r0.r.q.w0;
import d.a.s0.h2.h.e;
import d.a.s0.h2.k.e.y;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class PbImageAlaRecommendVH extends TypeAdapter.ViewHolder implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f19337e;

    /* renamed from: f  reason: collision with root package name */
    public y f19338f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f19339g;

    /* renamed from: h  reason: collision with root package name */
    public View f19340h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f19341i;
    public DynamicUserLikeButton j;
    public TextView k;
    public TbImageView l;
    public TextView m;
    public TextView n;
    public View o;
    public View p;
    public View q;
    public NEGFeedBackView r;
    public c s;
    public BdUniqueId t;
    public e u;

    /* loaded from: classes5.dex */
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
                TiebaStatic.log(new StatisticItem("c13858").param("obj_type", 1));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements DynamicUserLikeButton.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbImageAlaRecommendVH f19342a;

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
            this.f19342a = pbImageAlaRecommendVH;
        }

        @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19342a.u == null || this.f19342a.u.m() == null || this.f19342a.f19338f == null || this.f19342a.f19338f.k == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13718").param("fid", this.f19342a.u.m().getId()).param("fname", this.f19342a.u.m().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.f19342a.u.P()).param(TiebaStatic.Params.FRIEND_UID, this.f19342a.f19338f.k != null ? this.f19342a.f19338f.k.getUserId() : "").param("obj_type", !this.f19342a.f19338f.k.getIsLike()));
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
        this.f19337e = 3;
        this.f19339g = tbPageContext;
        this.t = bdUniqueId;
        if (view == null) {
            return;
        }
        this.o = view.findViewById(R.id.rootLayout);
        this.f19340h = view.findViewById(R.id.top_divider_line);
        this.f19341i = (TextView) view.findViewById(R.id.titleView);
        this.j = (DynamicUserLikeButton) view.findViewById(R.id.followBtn);
        this.k = (TextView) view.findViewById(R.id.alaStateView);
        this.l = (TbImageView) view.findViewById(R.id.coverView);
        this.m = (TextView) view.findViewById(R.id.descView);
        this.n = (TextView) view.findViewById(R.id.hotView);
        this.p = view.findViewById(R.id.hotPoint);
        this.q = view.findViewById(R.id.bottomSpaceView);
        this.j.setTextSize(R.dimen.tbds28);
        this.l.setPlaceHolder(2);
        this.l.setRadius(l.g(view.getContext(), R.dimen.tbds10));
        this.l.setConrers(15);
    }

    public void d(y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yVar) == null) {
            g(TbadkCoreApplication.getInst().getSkinType());
            if (yVar == null) {
                return;
            }
            this.f19338f = yVar;
            this.o.setOnClickListener(this);
            this.l.M(yVar.f60776h, 10, false);
            if (yVar.f60777i == 1 && yVar.j > 0) {
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(8);
            }
            this.m.setText(yVar.f60775g);
            TextView textView = this.f19341i;
            textView.setText(String.format(textView.getContext().getResources().getString(R.string.pb_ala_name), StringHelper.getFixedText(yVar.f60773e, 7, true)));
            TextView textView2 = this.n;
            textView2.setText(String.format(textView2.getContext().getResources().getString(R.string.pb_ala_audience_count), StringHelper.numFormatOverWan(yVar.f60774f)));
            this.q.setVisibility(yVar.r ? 8 : 0);
            j(yVar.s);
            k();
        }
    }

    public final void e(y yVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yVar) == null) && yVar != null && yVar.f60777i == 1) {
            if (yVar.m) {
                f(yVar.o, yVar.n);
                return;
            }
            YyExtData yyExtData = yVar.t;
            if (yyExtData != null) {
                YYLiveUtil.jumpToYYLiveRoom(this.f19339g, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "", YYLiveUtil.SOURCE_PB_WORD_RECOMMEND_LIVE_CARD);
            }
        }
    }

    public final void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<?> tbPageContext = this.f19339g;
            urlManager.dealOneLink(tbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (this.f19337e != i2) {
                SkinManager.setBackgroundSelector(this.o, R.color.CAM_X0205, R.color.CAM_X0204, i2);
                SkinManager.setBackgroundColor(this.f19340h, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.m, R.color.CAM_X0105, 1, i2);
                SkinManager.setViewTextColor(this.f19341i, R.color.CAM_X0105, 1, i2);
                SkinManager.setViewTextColor(this.n, R.color.CAM_X0109, 1, i2);
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0101, 1, i2);
                NEGFeedBackView nEGFeedBackView = this.r;
                if (nEGFeedBackView != null) {
                    nEGFeedBackView.q();
                }
                View view = this.p;
                view.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(l.g(view.getContext(), R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0309)));
                float g2 = l.g(this.k.getContext(), R.dimen.tbds10);
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(DrawableSelector.TL_BR, R.color.CAM_X0308, R.color.CAM_X0301).tlRadius(g2).brRadius(g2).into(this.k);
                this.j.r(i2);
            }
            this.f19337e = i2;
        }
    }

    public final void h(y yVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, yVar) == null) || (eVar = this.u) == null || eVar.m() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c13709").param("fid", this.u.m().getId()).param("fname", this.u.m().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.u.P());
        MetaData metaData = yVar.k;
        TiebaStatic.log(param.param("obj_param1", metaData != null ? metaData.getUserId() : ""));
    }

    public void i(e eVar) {
        y yVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) || eVar == null || eVar.m() == null || (yVar = this.f19338f) == null || yVar.q) {
            return;
        }
        this.u = eVar;
        StatisticItem param = new StatisticItem("c13708").param("fid", eVar.m().getId()).param("fname", eVar.m().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", eVar.P());
        MetaData metaData = this.f19338f.k;
        TiebaStatic.log(param.param("obj_param1", metaData != null ? metaData.getUserId() : ""));
        this.f19338f.q = true;
    }

    public final void j(w0 w0Var) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, w0Var) == null) || (tbPageContext = this.f19339g) == null) {
            return;
        }
        if (w0Var == null) {
            NEGFeedBackView nEGFeedBackView = this.r;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.setVisibility(8);
                return;
            }
            return;
        }
        if (this.r == null) {
            int g2 = l.g(tbPageContext.getPageActivity(), R.dimen.tbds44);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.g(this.f19339g.getPageActivity(), R.dimen.tbds130), l.g(this.f19339g.getPageActivity(), R.dimen.tbds86));
            layoutParams.addRule(11);
            layoutParams.addRule(8, R.id.coverView);
            NEGFeedBackView nEGFeedBackView2 = new NEGFeedBackView(this.f19339g);
            this.r = nEGFeedBackView2;
            nEGFeedBackView2.setPadding(g2, g2, g2, 0);
            ((RelativeLayout) this.o.findViewById(R.id.contentLayout)).addView(this.r, layoutParams);
            this.r.setEventCallback(new a(this));
        }
        this.r.setVisibility(0);
        this.r.setData(w0Var);
        this.r.q();
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            y yVar = this.f19338f;
            if (yVar != null && yVar.k != null) {
                this.j.setVisibility(0);
                if (this.s == null) {
                    c cVar = new c(this.f19339g, this.j);
                    this.s = cVar;
                    cVar.l(this.t);
                }
                this.s.n(this.f19338f.k);
                this.j.setOnClickEvent(new b(this));
                return;
            }
            this.j.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            int id = view.getId();
            y yVar = this.f19338f;
            if (yVar != null && id == R.id.rootLayout) {
                e(yVar);
                h(this.f19338f);
            }
        }
    }
}
