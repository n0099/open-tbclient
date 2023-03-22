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
import com.baidu.tieba.fy4;
import com.baidu.tieba.hi;
import com.baidu.tieba.ki8;
import com.baidu.tieba.n15;
import com.baidu.tieba.n55;
import com.baidu.tieba.nl8;
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
    public nl8 b;
    public TbPageContext c;
    public View d;
    public TextView e;
    public DynamicUserLikeButton f;
    public TextView g;
    public TbImageView h;
    public TextView i;
    public TextView j;
    public View k;
    public View l;
    public View m;
    public NEGFeedBackView n;
    public n55 o;
    public BdUniqueId p;
    public ki8 q;

    /* loaded from: classes5.dex */
    public class a implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void a(ArrayList<Integer> arrayList, String str, fy4 fy4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, fy4Var) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(fy4 fy4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fy4Var, compoundButton, z) == null) {
            }
        }

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
        public void c(fy4 fy4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fy4Var) == null) {
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
        public void a(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.q != null && this.a.q.l() != null && this.a.b != null && this.a.b.g != null) {
                StatisticItem param = new StatisticItem("c13718").param("fid", this.a.q.l().getId()).param("fname", this.a.q.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.q.S());
                if (this.a.b.g != null) {
                    str = this.a.b.g.getUserId();
                } else {
                    str = "";
                }
                TiebaStatic.log(param.param(TiebaStatic.Params.FRIEND_UID, str).param("obj_type", !this.a.b.g.getIsLike()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbImageAlaRecommendVH(View view2, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, tbPageContext, bdUniqueId};
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
        this.c = tbPageContext;
        this.p = bdUniqueId;
        if (view2 == null) {
            return;
        }
        this.k = view2.findViewById(R.id.obfuscated_res_0x7f091e2f);
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f092486);
        this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092404);
        this.f = (DynamicUserLikeButton) view2.findViewById(R.id.obfuscated_res_0x7f090b26);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901b5);
        this.h = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0907b9);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090842);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f17);
        this.l = view2.findViewById(R.id.obfuscated_res_0x7f090f0f);
        this.m = view2.findViewById(R.id.obfuscated_res_0x7f09042f);
        this.f.setTextSize(R.dimen.tbds28);
        this.h.setPlaceHolder(2);
        this.h.setRadius(hi.g(view2.getContext(), R.dimen.tbds10));
        this.h.setConrers(15);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            int id = view2.getId();
            nl8 nl8Var = this.b;
            if (nl8Var != null && id == R.id.obfuscated_res_0x7f091e2f) {
                d(nl8Var);
                g(this.b);
            }
        }
    }

    public void c(nl8 nl8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, nl8Var) == null) {
            f(TbadkCoreApplication.getInst().getSkinType());
            if (nl8Var == null) {
                return;
            }
            this.b = nl8Var;
            this.k.setOnClickListener(this);
            int i = 0;
            this.h.M(nl8Var.d, 10, false);
            if (nl8Var.e == 1 && nl8Var.f > 0) {
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(8);
            }
            this.i.setText(nl8Var.c);
            TextView textView = this.e;
            textView.setText(String.format(textView.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0ea5), StringHelper.getFixedText(nl8Var.a, 7, true)));
            TextView textView2 = this.j;
            textView2.setText(String.format(textView2.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0ea3), StringHelper.numFormatOverWan(nl8Var.b)));
            View view2 = this.m;
            if (nl8Var.n) {
                i = 8;
            }
            view2.setVisibility(i);
            i(nl8Var.o);
            j();
        }
    }

    public final void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (this.a != i) {
                n15.d(this.k).j(R.color.CAM_X0205, R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.d, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.i, R.color.CAM_X0105, 1, i);
                SkinManager.setViewTextColor(this.e, R.color.CAM_X0105, 1, i);
                SkinManager.setViewTextColor(this.j, R.color.CAM_X0109, 1, i);
                SkinManager.setViewTextColor(this.g, R.color.CAM_X0101, 1, i);
                NEGFeedBackView nEGFeedBackView = this.n;
                if (nEGFeedBackView != null) {
                    nEGFeedBackView.u();
                }
                View view2 = this.l;
                view2.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(hi.g(view2.getContext(), R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0309)));
                float g = hi.g(this.g.getContext(), R.dimen.tbds10);
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(DrawableSelector.TL_BR, R.color.CAM_X0308, R.color.CAM_X0301).tlRadius(g).brRadius(g).into(this.g);
                this.f.onChangeSkinType(i);
            }
            this.a = i;
        }
    }

    public final void d(nl8 nl8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nl8Var) == null) && nl8Var != null && nl8Var.e == 1) {
            if (nl8Var.i) {
                e(nl8Var.k, nl8Var.j);
                return;
            }
            YyExtData yyExtData = nl8Var.p;
            if (yyExtData != null) {
                YYLiveUtil.jumpToYYLiveRoom(this.c, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "", yyExtData.streamInfo, YYLiveUtil.SOURCE_PB_WORD_RECOMMEND_LIVE_CARD);
            }
        }
    }

    public final void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<?> tbPageContext = this.c;
            urlManager.dealOneLink(tbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void g(nl8 nl8Var) {
        ki8 ki8Var;
        String str;
        YyExtData yyExtData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, nl8Var) == null) && (ki8Var = this.q) != null && ki8Var.l() != null) {
            StatisticItem param = new StatisticItem("c13709").param("fid", this.q.l().getId()).param("fname", this.q.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.q.S()).param("cuid", TbadkCoreApplication.getInst().getCuid()).param("nid", this.q.C().p.feedId);
            MetaData metaData = nl8Var.g;
            String str2 = "";
            if (metaData == null) {
                str = "";
            } else {
                str = metaData.getUserId();
            }
            StatisticItem param2 = param.param("obj_param1", str);
            if (this.q.Q() != null) {
                ThreadData Q = this.q.Q();
                int calculateLiveType = YYLiveUtil.calculateLiveType(Q.getThreadAlaInfo());
                if (Q.getThreadAlaInfo() != null && Q.getThreadAlaInfo().isLegalYYLiveData()) {
                    TiebaStaticHelper.addYYParam(param2, Q.getThreadAlaInfo().mYyExtData);
                } else {
                    if (nl8Var != null && (yyExtData = nl8Var.p) != null) {
                        TiebaStaticHelper.addYYParam(param2, yyExtData);
                        calculateLiveType = YYLiveUtil.calculateLiveType(nl8Var.p);
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

    public void h(ki8 ki8Var) {
        nl8 nl8Var;
        String str;
        YyExtData yyExtData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, ki8Var) == null) && ki8Var != null && ki8Var.l() != null && (nl8Var = this.b) != null && !nl8Var.m) {
            this.q = ki8Var;
            StatisticItem param = new StatisticItem("c13708").param("fid", ki8Var.l().getId()).param("fname", ki8Var.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", ki8Var.S()).param("cuid", TbadkCoreApplication.getInst().getCuid()).param("nid", ki8Var.C().p.feedId);
            MetaData metaData = this.b.g;
            String str2 = "";
            if (metaData == null) {
                str = "";
            } else {
                str = metaData.getUserId();
            }
            StatisticItem param2 = param.param("obj_param1", str);
            if (ki8Var.Q() != null) {
                ThreadData Q = ki8Var.Q();
                int calculateLiveType = YYLiveUtil.calculateLiveType(Q.getThreadAlaInfo());
                if (Q.getThreadAlaInfo() != null && Q.getThreadAlaInfo().isLegalYYLiveData()) {
                    TiebaStaticHelper.addYYParam(param2, Q.getThreadAlaInfo().mYyExtData);
                } else {
                    nl8 nl8Var2 = this.b;
                    if (nl8Var2 != null && (yyExtData = nl8Var2.p) != null) {
                        TiebaStaticHelper.addYYParam(param2, yyExtData);
                        calculateLiveType = YYLiveUtil.calculateLiveType(this.b.p);
                    }
                    param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
                    param2.param(TiebaStatic.Params.OBJ_PARAM3, str2);
                }
                str2 = TiebaStatic.YYValues.YY_LIVE;
                param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
                param2.param(TiebaStatic.Params.OBJ_PARAM3, str2);
            }
            TiebaStatic.log(param2);
            this.b.m = true;
        }
    }

    public final void i(fy4 fy4Var) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, fy4Var) != null) || (tbPageContext = this.c) == null) {
            return;
        }
        if (fy4Var == null) {
            NEGFeedBackView nEGFeedBackView = this.n;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.setVisibility(8);
                return;
            }
            return;
        }
        if (this.n == null) {
            int g = hi.g(tbPageContext.getPageActivity(), R.dimen.tbds44);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(hi.g(this.c.getPageActivity(), R.dimen.tbds151), hi.g(this.c.getPageActivity(), R.dimen.tbds151));
            layoutParams.addRule(11);
            layoutParams.addRule(8, R.id.obfuscated_res_0x7f0907b9);
            NEGFeedBackView nEGFeedBackView2 = new NEGFeedBackView(this.c);
            this.n = nEGFeedBackView2;
            nEGFeedBackView2.setPadding(g, g, g, 0);
            ((RelativeLayout) this.k.findViewById(R.id.obfuscated_res_0x7f090786)).addView(this.n, layoutParams);
            this.n.setEventCallback(new a(this));
        }
        this.n.setVisibility(0);
        this.n.setData(fy4Var);
        this.n.u();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            nl8 nl8Var = this.b;
            if (nl8Var != null && nl8Var.g != null) {
                this.f.setVisibility(0);
                if (this.o == null) {
                    n55 n55Var = new n55(this.c, this.f);
                    this.o = n55Var;
                    n55Var.l(this.p);
                }
                this.o.n(this.b.g);
                this.f.setOnClickEvent(new b(this));
                return;
            }
            this.f.setVisibility(8);
        }
    }
}
