package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.r.l0.t.c;
import c.a.o0.r.r.v0;
import c.a.p0.w2.i.f;
import c.a.p0.w2.m.f.d0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
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
/* loaded from: classes5.dex */
public class PbImageAlaRecommendVH extends TypeAdapter.ViewHolder implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public d0 f34932b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f34933c;

    /* renamed from: d  reason: collision with root package name */
    public View f34934d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f34935e;

    /* renamed from: f  reason: collision with root package name */
    public DynamicUserLikeButton f34936f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f34937g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f34938h;
    public TextView i;
    public TextView j;
    public View k;
    public View l;
    public View m;
    public NEGFeedBackView n;
    public c o;
    public BdUniqueId p;
    public f q;

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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void a(ArrayList<Integer> arrayList, String str, v0 v0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, v0Var) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(v0 v0Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v0Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(v0 v0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, v0Var) == null) {
                TiebaStatic.log(new StatisticItem("c13858").param("obj_type", 1));
            }
        }
    }

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.q == null || this.a.q.l() == null || this.a.f34932b == null || this.a.f34932b.f20039g == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13718").param("fid", this.a.q.l().getId()).param("fname", this.a.q.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.q.Q()).param(TiebaStatic.Params.FRIEND_UID, this.a.f34932b.f20039g != null ? this.a.f34932b.f20039g.getUserId() : "").param("obj_type", !this.a.f34932b.f20039g.getIsLike()));
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
        this.f34933c = tbPageContext;
        this.p = bdUniqueId;
        if (view == null) {
            return;
        }
        this.k = view.findViewById(R.id.obfuscated_res_0x7f091ad8);
        this.f34934d = view.findViewById(R.id.obfuscated_res_0x7f0920b2);
        this.f34935e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f092032);
        this.f34936f = (DynamicUserLikeButton) view.findViewById(R.id.obfuscated_res_0x7f0909fa);
        this.f34937g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0901ae);
        this.f34938h = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090707);
        this.i = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09077a);
        this.j = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090db8);
        this.l = view.findViewById(R.id.obfuscated_res_0x7f090db0);
        this.m = view.findViewById(R.id.obfuscated_res_0x7f0903b2);
        this.f34936f.setTextSize(R.dimen.tbds28);
        this.f34938h.setPlaceHolder(2);
        this.f34938h.setRadius(n.f(view.getContext(), R.dimen.tbds10));
        this.f34938h.setConrers(15);
    }

    public void e(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, d0Var) == null) {
            h(TbadkCoreApplication.getInst().getSkinType());
            if (d0Var == null) {
                return;
            }
            this.f34932b = d0Var;
            this.k.setOnClickListener(this);
            this.f34938h.J(d0Var.f20036d, 10, false);
            if (d0Var.f20037e == 1 && d0Var.f20038f > 0) {
                this.f34937g.setVisibility(0);
            } else {
                this.f34937g.setVisibility(8);
            }
            this.i.setText(d0Var.f20035c);
            TextView textView = this.f34935e;
            textView.setText(String.format(textView.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0d90), StringHelper.getFixedText(d0Var.a, 7, true)));
            TextView textView2 = this.j;
            textView2.setText(String.format(textView2.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0d8e), StringHelper.numFormatOverWan(d0Var.f20034b)));
            this.m.setVisibility(d0Var.n ? 8 : 0);
            k(d0Var.o);
            l();
        }
    }

    public final void f(d0 d0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d0Var) == null) && d0Var != null && d0Var.f20037e == 1) {
            if (d0Var.i) {
                g(d0Var.k, d0Var.j);
                return;
            }
            YyExtData yyExtData = d0Var.p;
            if (yyExtData != null) {
                YYLiveUtil.jumpToYYLiveRoom(this.f34933c, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "", yyExtData.streamInfo, YYLiveUtil.SOURCE_PB_WORD_RECOMMEND_LIVE_CARD);
            }
        }
    }

    public final void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<?> tbPageContext = this.f34933c;
            urlManager.dealOneLink(tbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (this.a != i) {
                c.a.o0.r.v.c.d(this.k).i(R.color.CAM_X0205, R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.f34934d, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.i, R.color.CAM_X0105, 1, i);
                SkinManager.setViewTextColor(this.f34935e, R.color.CAM_X0105, 1, i);
                SkinManager.setViewTextColor(this.j, R.color.CAM_X0109, 1, i);
                SkinManager.setViewTextColor(this.f34937g, R.color.CAM_X0101, 1, i);
                NEGFeedBackView nEGFeedBackView = this.n;
                if (nEGFeedBackView != null) {
                    nEGFeedBackView.q();
                }
                View view = this.l;
                view.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(view.getContext(), R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0309)));
                float f2 = n.f(this.f34937g.getContext(), R.dimen.tbds10);
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(DrawableSelector.TL_BR, R.color.CAM_X0308, R.color.CAM_X0301).tlRadius(f2).brRadius(f2).into(this.f34937g);
                this.f34936f.r(i);
            }
            this.a = i;
        }
    }

    public final void i(d0 d0Var) {
        f fVar;
        YyExtData yyExtData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, d0Var) == null) || (fVar = this.q) == null || fVar.l() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c13709").param("fid", this.q.l().getId()).param("fname", this.q.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.q.Q());
        MetaData metaData = d0Var.f20039g;
        String str = "";
        StatisticItem param2 = param.param("obj_param1", metaData != null ? metaData.getUserId() : "");
        if (this.q.O() != null) {
            ThreadData O = this.q.O();
            int calculateLiveType = YYLiveUtil.calculateLiveType(O.getThreadAlaInfo());
            if (O.getThreadAlaInfo() != null && O.getThreadAlaInfo().isLegalYYLiveData()) {
                TiebaStaticHelper.addYYParam(param2, O.getThreadAlaInfo().mYyExtData);
            } else {
                if (d0Var != null && (yyExtData = d0Var.p) != null) {
                    TiebaStaticHelper.addYYParam(param2, yyExtData);
                    calculateLiveType = YYLiveUtil.calculateLiveType(d0Var.p);
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

    public void j(f fVar) {
        d0 d0Var;
        YyExtData yyExtData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) || fVar == null || fVar.l() == null || (d0Var = this.f34932b) == null || d0Var.m) {
            return;
        }
        this.q = fVar;
        StatisticItem param = new StatisticItem("c13708").param("fid", fVar.l().getId()).param("fname", fVar.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", fVar.Q());
        MetaData metaData = this.f34932b.f20039g;
        String str = "";
        StatisticItem param2 = param.param("obj_param1", metaData != null ? metaData.getUserId() : "");
        if (fVar.O() != null) {
            ThreadData O = fVar.O();
            int calculateLiveType = YYLiveUtil.calculateLiveType(O.getThreadAlaInfo());
            if (O.getThreadAlaInfo() != null && O.getThreadAlaInfo().isLegalYYLiveData()) {
                TiebaStaticHelper.addYYParam(param2, O.getThreadAlaInfo().mYyExtData);
            } else {
                d0 d0Var2 = this.f34932b;
                if (d0Var2 != null && (yyExtData = d0Var2.p) != null) {
                    TiebaStaticHelper.addYYParam(param2, yyExtData);
                    calculateLiveType = YYLiveUtil.calculateLiveType(this.f34932b.p);
                }
                param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
                param2.param(TiebaStatic.Params.OBJ_PARAM3, str);
            }
            str = TiebaStatic.YYValues.YY_LIVE;
            param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
            param2.param(TiebaStatic.Params.OBJ_PARAM3, str);
        }
        TiebaStatic.log(param2);
        this.f34932b.m = true;
    }

    public final void k(v0 v0Var) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, v0Var) == null) || (tbPageContext = this.f34933c) == null) {
            return;
        }
        if (v0Var == null) {
            NEGFeedBackView nEGFeedBackView = this.n;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.setVisibility(8);
                return;
            }
            return;
        }
        if (this.n == null) {
            int f2 = n.f(tbPageContext.getPageActivity(), R.dimen.tbds44);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(n.f(this.f34933c.getPageActivity(), R.dimen.tbds130), n.f(this.f34933c.getPageActivity(), R.dimen.tbds86));
            layoutParams.addRule(11);
            layoutParams.addRule(8, R.id.obfuscated_res_0x7f090707);
            NEGFeedBackView nEGFeedBackView2 = new NEGFeedBackView(this.f34933c);
            this.n = nEGFeedBackView2;
            nEGFeedBackView2.setPadding(f2, f2, f2, 0);
            ((RelativeLayout) this.k.findViewById(R.id.obfuscated_res_0x7f0906d9)).addView(this.n, layoutParams);
            this.n.setEventCallback(new a(this));
        }
        this.n.setVisibility(0);
        this.n.setData(v0Var);
        this.n.q();
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d0 d0Var = this.f34932b;
            if (d0Var != null && d0Var.f20039g != null) {
                this.f34936f.setVisibility(0);
                if (this.o == null) {
                    c cVar = new c(this.f34933c, this.f34936f);
                    this.o = cVar;
                    cVar.l(this.p);
                }
                this.o.n(this.f34932b.f20039g);
                this.f34936f.setOnClickEvent(new b(this));
                return;
            }
            this.f34936f.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            int id = view.getId();
            d0 d0Var = this.f34932b;
            if (d0Var != null && id == R.id.obfuscated_res_0x7f091ad8) {
                f(d0Var);
                i(this.f34932b);
            }
        }
    }
}
