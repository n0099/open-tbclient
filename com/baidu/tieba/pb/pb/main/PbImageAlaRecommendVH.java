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
import com.baidu.tieba.view.DynamicUserLikeButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cq4;
import com.repackage.et7;
import com.repackage.ms4;
import com.repackage.mw7;
import com.repackage.qi;
import com.repackage.tw4;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PbImageAlaRecommendVH extends TypeAdapter.ViewHolder implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public mw7 b;
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
    public tw4 o;
    public BdUniqueId p;
    public et7 q;

    /* loaded from: classes3.dex */
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
        public void a(ArrayList<Integer> arrayList, String str, cq4 cq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, cq4Var) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(cq4 cq4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cq4Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(cq4 cq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cq4Var) == null) {
                TiebaStatic.log(new StatisticItem("c13858").param("obj_type", 1));
            }
        }
    }

    /* loaded from: classes3.dex */
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
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.q == null || this.a.q.l() == null || this.a.b == null || this.a.b.g == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13718").param("fid", this.a.q.l().getId()).param("fname", this.a.q.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.q.Q()).param(TiebaStatic.Params.FRIEND_UID, this.a.b.g != null ? this.a.b.g.getUserId() : "").param("obj_type", !this.a.b.g.getIsLike()));
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
        this.k = view2.findViewById(R.id.obfuscated_res_0x7f091c1b);
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f09223e);
        this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921c0);
        this.f = (DynamicUserLikeButton) view2.findViewById(R.id.obfuscated_res_0x7f090a0f);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901b0);
        this.h = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0906ff);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090782);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090db5);
        this.l = view2.findViewById(R.id.obfuscated_res_0x7f090dad);
        this.m = view2.findViewById(R.id.obfuscated_res_0x7f0903cc);
        this.f.setTextSize(R.dimen.tbds28);
        this.h.setPlaceHolder(2);
        this.h.setRadius(qi.f(view2.getContext(), R.dimen.tbds10));
        this.h.setConrers(15);
    }

    public void c(mw7 mw7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mw7Var) == null) {
            f(TbadkCoreApplication.getInst().getSkinType());
            if (mw7Var == null) {
                return;
            }
            this.b = mw7Var;
            this.k.setOnClickListener(this);
            this.h.K(mw7Var.d, 10, false);
            if (mw7Var.e == 1 && mw7Var.f > 0) {
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(8);
            }
            this.i.setText(mw7Var.c);
            TextView textView = this.e;
            textView.setText(String.format(textView.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0dba), StringHelper.getFixedText(mw7Var.a, 7, true)));
            TextView textView2 = this.j;
            textView2.setText(String.format(textView2.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0db8), StringHelper.numFormatOverWan(mw7Var.b)));
            this.m.setVisibility(mw7Var.n ? 8 : 0);
            i(mw7Var.o);
            j();
        }
    }

    public final void d(mw7 mw7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mw7Var) == null) && mw7Var != null && mw7Var.e == 1) {
            if (mw7Var.i) {
                e(mw7Var.k, mw7Var.j);
                return;
            }
            YyExtData yyExtData = mw7Var.p;
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

    public final void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (this.a != i) {
                ms4.d(this.k).i(R.color.CAM_X0205, R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.d, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.i, R.color.CAM_X0105, 1, i);
                SkinManager.setViewTextColor(this.e, R.color.CAM_X0105, 1, i);
                SkinManager.setViewTextColor(this.j, R.color.CAM_X0109, 1, i);
                SkinManager.setViewTextColor(this.g, R.color.CAM_X0101, 1, i);
                NEGFeedBackView nEGFeedBackView = this.n;
                if (nEGFeedBackView != null) {
                    nEGFeedBackView.q();
                }
                View view2 = this.l;
                view2.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(qi.f(view2.getContext(), R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0309)));
                float f = qi.f(this.g.getContext(), R.dimen.tbds10);
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(DrawableSelector.TL_BR, R.color.CAM_X0308, R.color.CAM_X0301).tlRadius(f).brRadius(f).into(this.g);
                this.f.r(i);
            }
            this.a = i;
        }
    }

    public final void g(mw7 mw7Var) {
        et7 et7Var;
        YyExtData yyExtData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, mw7Var) == null) || (et7Var = this.q) == null || et7Var.l() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c13709").param("fid", this.q.l().getId()).param("fname", this.q.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.q.Q());
        MetaData metaData = mw7Var.g;
        String str = "";
        StatisticItem param2 = param.param("obj_param1", metaData != null ? metaData.getUserId() : "");
        if (this.q.O() != null) {
            ThreadData O = this.q.O();
            int calculateLiveType = YYLiveUtil.calculateLiveType(O.getThreadAlaInfo());
            if (O.getThreadAlaInfo() != null && O.getThreadAlaInfo().isLegalYYLiveData()) {
                TiebaStaticHelper.addYYParam(param2, O.getThreadAlaInfo().mYyExtData);
            } else {
                if (mw7Var != null && (yyExtData = mw7Var.p) != null) {
                    TiebaStaticHelper.addYYParam(param2, yyExtData);
                    calculateLiveType = YYLiveUtil.calculateLiveType(mw7Var.p);
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

    public void h(et7 et7Var) {
        mw7 mw7Var;
        YyExtData yyExtData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, et7Var) == null) || et7Var == null || et7Var.l() == null || (mw7Var = this.b) == null || mw7Var.m) {
            return;
        }
        this.q = et7Var;
        StatisticItem param = new StatisticItem("c13708").param("fid", et7Var.l().getId()).param("fname", et7Var.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", et7Var.Q());
        MetaData metaData = this.b.g;
        String str = "";
        StatisticItem param2 = param.param("obj_param1", metaData != null ? metaData.getUserId() : "");
        if (et7Var.O() != null) {
            ThreadData O = et7Var.O();
            int calculateLiveType = YYLiveUtil.calculateLiveType(O.getThreadAlaInfo());
            if (O.getThreadAlaInfo() != null && O.getThreadAlaInfo().isLegalYYLiveData()) {
                TiebaStaticHelper.addYYParam(param2, O.getThreadAlaInfo().mYyExtData);
            } else {
                mw7 mw7Var2 = this.b;
                if (mw7Var2 != null && (yyExtData = mw7Var2.p) != null) {
                    TiebaStaticHelper.addYYParam(param2, yyExtData);
                    calculateLiveType = YYLiveUtil.calculateLiveType(this.b.p);
                }
                param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
                param2.param(TiebaStatic.Params.OBJ_PARAM3, str);
            }
            str = TiebaStatic.YYValues.YY_LIVE;
            param2.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
            param2.param(TiebaStatic.Params.OBJ_PARAM3, str);
        }
        TiebaStatic.log(param2);
        this.b.m = true;
    }

    public final void i(cq4 cq4Var) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, cq4Var) == null) || (tbPageContext = this.c) == null) {
            return;
        }
        if (cq4Var == null) {
            NEGFeedBackView nEGFeedBackView = this.n;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.setVisibility(8);
                return;
            }
            return;
        }
        if (this.n == null) {
            int f = qi.f(tbPageContext.getPageActivity(), R.dimen.tbds44);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(qi.f(this.c.getPageActivity(), R.dimen.tbds151), qi.f(this.c.getPageActivity(), R.dimen.tbds151));
            layoutParams.addRule(11);
            layoutParams.addRule(8, R.id.obfuscated_res_0x7f0906ff);
            NEGFeedBackView nEGFeedBackView2 = new NEGFeedBackView(this.c);
            this.n = nEGFeedBackView2;
            nEGFeedBackView2.setPadding(f, f, f, 0);
            ((RelativeLayout) this.k.findViewById(R.id.obfuscated_res_0x7f0906cf)).addView(this.n, layoutParams);
            this.n.setEventCallback(new a(this));
        }
        this.n.setVisibility(0);
        this.n.setData(cq4Var);
        this.n.q();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            mw7 mw7Var = this.b;
            if (mw7Var != null && mw7Var.g != null) {
                this.f.setVisibility(0);
                if (this.o == null) {
                    tw4 tw4Var = new tw4(this.c, this.f);
                    this.o = tw4Var;
                    tw4Var.l(this.p);
                }
                this.o.n(this.b.g);
                this.f.setOnClickEvent(new b(this));
                return;
            }
            this.f.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            int id = view2.getId();
            mw7 mw7Var = this.b;
            if (mw7Var != null && id == R.id.obfuscated_res_0x7f091c1b) {
                d(mw7Var);
                g(this.b);
            }
        }
    }
}
