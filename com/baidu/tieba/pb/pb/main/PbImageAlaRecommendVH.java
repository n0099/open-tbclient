package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
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
import com.baidu.tieba.aj9;
import com.baidu.tieba.an9;
import com.baidu.tieba.qb5;
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
    public int a;
    public an9 b;
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
    public qb5 o;
    public BdUniqueId p;
    public aj9 q;

    /* loaded from: classes7.dex */
    public class a implements NEGFeedBackView.NEGFeedbackEventCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.NEGFeedbackEventCallback
        public void onCheckedChanged(NegativeFeedBackData negativeFeedBackData, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, negativeFeedBackData, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.NEGFeedbackEventCallback
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, NegativeFeedBackData negativeFeedBackData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, negativeFeedBackData) == null) {
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

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.NEGFeedbackEventCallback
        public void onNEGFeedbackWindowShow(NegativeFeedBackData negativeFeedBackData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, negativeFeedBackData) == null) {
                TiebaStatic.log(new StatisticItem("c13858").param("obj_type", 1));
            }
        }
    }

    /* loaded from: classes7.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.q != null && this.a.q.k() != null && this.a.b != null && this.a.b.g != null) {
                StatisticItem param = new StatisticItem("c13718").param("fid", this.a.q.k().getId()).param("fname", this.a.q.k().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.q.Q());
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
        this.k = view2.findViewById(R.id.obfuscated_res_0x7f091fd7);
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f092664);
        this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925d7);
        this.f = (DynamicUserLikeButton) view2.findViewById(R.id.obfuscated_res_0x7f090b99);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901c5);
        this.h = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0907f6);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090880);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090fa5);
        this.l = view2.findViewById(R.id.obfuscated_res_0x7f090f9d);
        this.m = view2.findViewById(R.id.obfuscated_res_0x7f090455);
        this.f.setTextSize(R.dimen.tbds28);
        this.h.setPlaceHolder(2);
        this.h.setRadius(BdUtilHelper.getDimens(view2.getContext(), R.dimen.tbds10));
        this.h.setConrers(15);
    }

    public final void g(an9 an9Var) {
        aj9 aj9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, an9Var) == null) && (aj9Var = this.q) != null && aj9Var.k() != null) {
            j("c13709", this.q, an9Var);
        }
    }

    public void h(aj9 aj9Var) {
        an9 an9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, aj9Var) == null) && aj9Var != null && aj9Var.k() != null && (an9Var = this.b) != null && !an9Var.m) {
            this.q = aj9Var;
            j("c13708", aj9Var, an9Var);
            this.b.m = true;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            int id = view2.getId();
            an9 an9Var = this.b;
            if (an9Var != null && id == R.id.obfuscated_res_0x7f091fd7) {
                d(an9Var);
                g(this.b);
            }
        }
    }

    public void c(an9 an9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, an9Var) == null) {
            f(TbadkCoreApplication.getInst().getSkinType());
            if (an9Var == null) {
                return;
            }
            this.b = an9Var;
            this.k.setOnClickListener(this);
            int i = 0;
            this.h.startLoad(an9Var.d, 10, false);
            if (an9Var.e == 1 && an9Var.f > 0) {
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(8);
            }
            this.i.setText(an9Var.c);
            TextView textView = this.e;
            textView.setText(String.format(textView.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0fdb), StringHelper.getFixedText(an9Var.a, 7, true)));
            TextView textView2 = this.j;
            textView2.setText(String.format(textView2.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0fda), StringHelper.numFormatOverWan(an9Var.b)));
            View view2 = this.m;
            if (an9Var.n) {
                i = 8;
            }
            view2.setVisibility(i);
            i(an9Var.o);
            k();
        }
    }

    public final void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (this.a != i) {
                EMManager.from(this.k).setBackGroundSelectorColor(R.color.CAM_X0205, R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.d, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.i, R.color.CAM_X0105, 1, i);
                SkinManager.setViewTextColor(this.e, R.color.CAM_X0105, 1, i);
                SkinManager.setViewTextColor(this.j, R.color.CAM_X0109, 1, i);
                SkinManager.setViewTextColor(this.g, R.color.CAM_X0101, 1, i);
                NEGFeedBackView nEGFeedBackView = this.n;
                if (nEGFeedBackView != null) {
                    nEGFeedBackView.onChangeSkinType();
                }
                View view2 = this.l;
                view2.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(BdUtilHelper.getDimens(view2.getContext(), R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0309)));
                float dimens = BdUtilHelper.getDimens(this.g.getContext(), R.dimen.tbds10);
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(DrawableSelector.TL_BR, R.color.CAM_X0308, R.color.CAM_X0301).tlRadius(dimens).brRadius(dimens).into(this.g);
                this.f.onChangeSkinType(i);
            }
            this.a = i;
        }
    }

    public final void d(an9 an9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, an9Var) == null) && an9Var != null && an9Var.e == 1) {
            if (an9Var.i) {
                e(an9Var.k, an9Var.j);
                return;
            }
            YyExtData yyExtData = an9Var.p;
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

    public final void i(NegativeFeedBackData negativeFeedBackData) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, negativeFeedBackData) != null) || (tbPageContext = this.c) == null) {
            return;
        }
        if (negativeFeedBackData == null) {
            NEGFeedBackView nEGFeedBackView = this.n;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.setVisibility(8);
                return;
            }
            return;
        }
        if (this.n == null) {
            int dimens = BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds44);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BdUtilHelper.getDimens(this.c.getPageActivity(), R.dimen.tbds151), BdUtilHelper.getDimens(this.c.getPageActivity(), R.dimen.tbds151));
            layoutParams.addRule(11);
            layoutParams.addRule(8, R.id.obfuscated_res_0x7f0907f6);
            NEGFeedBackView nEGFeedBackView2 = new NEGFeedBackView(this.c);
            this.n = nEGFeedBackView2;
            nEGFeedBackView2.setPadding(dimens, dimens, dimens, 0);
            ((RelativeLayout) this.k.findViewById(R.id.obfuscated_res_0x7f0907c2)).addView(this.n, layoutParams);
            this.n.setEventCallback(new a(this));
        }
        this.n.setVisibility(0);
        this.n.setData(negativeFeedBackData);
        this.n.onChangeSkinType();
    }

    public final void j(String str, aj9 aj9Var, an9 an9Var) {
        String str2;
        YyExtData yyExtData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, aj9Var, an9Var) == null) {
            StatisticItem param = new StatisticItem(str).param("fid", aj9Var.k().getId()).param("fname", aj9Var.k().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", aj9Var.Q()).param("cuid", TbadkCoreApplication.getInst().getCuid()).param("nid", aj9Var.B().p.feedId);
            MetaData metaData = an9Var.g;
            String str3 = "";
            if (metaData == null) {
                str2 = "";
            } else {
                str2 = metaData.getUserId();
            }
            StatisticItem param2 = param.param("obj_param1", str2);
            if (aj9Var.O() != null) {
                ThreadData O = aj9Var.O();
                int calculateLiveType = YYLiveUtil.calculateLiveType(O.getThreadAlaInfo());
                if (O.getThreadAlaInfo() != null && O.getThreadAlaInfo().isLegalYYLiveData()) {
                    TiebaStaticHelper.addYYParam(param2, O.getThreadAlaInfo().mYyExtData);
                } else {
                    if (an9Var != null && (yyExtData = an9Var.p) != null) {
                        TiebaStaticHelper.addYYParam(param2, yyExtData);
                        calculateLiveType = YYLiveUtil.calculateLiveType(an9Var.p);
                    }
                    param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
                    param2.param(TiebaStatic.Params.OBJ_PARAM3, str3);
                }
                str3 = TiebaStatic.YYValues.YY_LIVE;
                param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
                param2.param(TiebaStatic.Params.OBJ_PARAM3, str3);
            }
            TiebaStatic.log(param2);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            an9 an9Var = this.b;
            if (an9Var != null && an9Var.g != null) {
                this.f.setVisibility(0);
                if (this.o == null) {
                    qb5 qb5Var = new qb5(this.c, this.f);
                    this.o = qb5Var;
                    qb5Var.j(this.p);
                }
                this.o.l(this.b.g);
                this.f.setOnClickEvent(new b(this));
                return;
            }
            this.f.setVisibility(8);
        }
    }
}
