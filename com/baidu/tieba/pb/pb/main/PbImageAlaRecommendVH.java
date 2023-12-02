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
import com.baidu.tieba.g75;
import com.baidu.tieba.p0a;
import com.baidu.tieba.view.DynamicUserLikeButton;
import com.baidu.tieba.zv9;
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
    public p0a b;
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
    public g75 o;
    public BdUniqueId p;
    public zv9 q;

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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.q != null && this.a.q.n() != null && this.a.b != null && this.a.b.g != null) {
                StatisticItem param = new StatisticItem("c13718").param("fid", this.a.q.n().getId()).param("fname", this.a.q.n().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.q.T());
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
        this.k = view2.findViewById(R.id.obfuscated_res_0x7f09206c);
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f092717);
        this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09268b);
        this.f = (DynamicUserLikeButton) view2.findViewById(R.id.obfuscated_res_0x7f090bea);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901ed);
        this.h = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090845);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0908d0);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091014);
        this.l = view2.findViewById(R.id.obfuscated_res_0x7f09100c);
        this.m = view2.findViewById(R.id.obfuscated_res_0x7f090480);
        this.f.setTextSize(R.dimen.tbds28);
        this.h.setPlaceHolder(2);
        this.h.setRadius(BdUtilHelper.getDimens(view2.getContext(), R.dimen.tbds10));
        this.h.setConrers(15);
    }

    public final void g(p0a p0aVar) {
        zv9 zv9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, p0aVar) == null) && (zv9Var = this.q) != null && zv9Var.n() != null) {
            k("c13709", this.q, p0aVar);
        }
    }

    public void h(zv9 zv9Var) {
        p0a p0aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, zv9Var) == null) && zv9Var != null && zv9Var.n() != null && (p0aVar = this.b) != null && !p0aVar.m) {
            this.q = zv9Var;
            k("c13708", zv9Var, p0aVar);
            this.b.m = true;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            int id = view2.getId();
            p0a p0aVar = this.b;
            if (p0aVar != null && id == R.id.obfuscated_res_0x7f09206c) {
                d(p0aVar);
                g(this.b);
            }
        }
    }

    public void c(p0a p0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, p0aVar) == null) {
            f(TbadkCoreApplication.getInst().getSkinType());
            if (p0aVar == null) {
                return;
            }
            this.b = p0aVar;
            this.k.setOnClickListener(this);
            int i = 0;
            this.h.startLoad(p0aVar.d, 10, false);
            if (p0aVar.e == 1 && p0aVar.f > 0) {
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(8);
            }
            this.i.setText(p0aVar.c);
            TextView textView = this.e;
            textView.setText(String.format(textView.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f100d), StringHelper.getFixedText(p0aVar.a, 7, true)));
            TextView textView2 = this.j;
            textView2.setText(String.format(textView2.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f100c), StringHelper.numFormatOverWan(p0aVar.b)));
            View view2 = this.m;
            if (p0aVar.n) {
                i = 8;
            }
            view2.setVisibility(i);
            i(p0aVar.o);
            l();
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

    public final void d(p0a p0aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p0aVar) == null) && p0aVar != null && p0aVar.e == 1) {
            if (p0aVar.i) {
                e(p0aVar.k, p0aVar.j);
                return;
            }
            YyExtData yyExtData = p0aVar.p;
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
            layoutParams.addRule(8, R.id.obfuscated_res_0x7f090845);
            NEGFeedBackView nEGFeedBackView2 = new NEGFeedBackView(this.c);
            this.n = nEGFeedBackView2;
            nEGFeedBackView2.setPadding(dimens, dimens, dimens, 0);
            ((RelativeLayout) this.k.findViewById(R.id.obfuscated_res_0x7f090810)).addView(this.n, layoutParams);
            this.n.setEventCallback(new a(this));
        }
        this.n.setVisibility(0);
        this.n.setData(negativeFeedBackData);
        this.n.onChangeSkinType();
    }

    public final void k(String str, zv9 zv9Var, p0a p0aVar) {
        String str2;
        YyExtData yyExtData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, zv9Var, p0aVar) == null) {
            StatisticItem param = new StatisticItem(str).param("fid", zv9Var.n().getId()).param("fname", zv9Var.n().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", zv9Var.T()).param("cuid", TbadkCoreApplication.getInst().getCuid()).param("nid", zv9Var.E().p.feedId);
            MetaData metaData = p0aVar.g;
            String str3 = "";
            if (metaData == null) {
                str2 = "";
            } else {
                str2 = metaData.getUserId();
            }
            StatisticItem param2 = param.param("obj_param1", str2);
            if (zv9Var.R() != null) {
                ThreadData R = zv9Var.R();
                int calculateLiveType = YYLiveUtil.calculateLiveType(R.getThreadAlaInfo());
                if (R.getThreadAlaInfo() != null && R.getThreadAlaInfo().isLegalYYLiveData()) {
                    TiebaStaticHelper.addYYParam(param2, R.getThreadAlaInfo().mYyExtData);
                } else {
                    if (p0aVar != null && (yyExtData = p0aVar.p) != null) {
                        TiebaStaticHelper.addYYParam(param2, yyExtData);
                        calculateLiveType = YYLiveUtil.calculateLiveType(p0aVar.p);
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

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            p0a p0aVar = this.b;
            if (p0aVar != null && p0aVar.g != null) {
                this.f.setVisibility(0);
                if (this.o == null) {
                    g75 g75Var = new g75(this.c, this.f);
                    this.o = g75Var;
                    g75Var.j(this.p);
                }
                this.o.l(this.b.g);
                this.f.setOnClickEvent(new b(this));
                return;
            }
            this.f.setVisibility(8);
        }
    }
}
