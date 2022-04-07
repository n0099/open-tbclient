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
import com.repackage.bv7;
import com.repackage.mp4;
import com.repackage.oi;
import com.repackage.ov4;
import com.repackage.wr4;
import com.repackage.yr7;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PbImageAlaRecommendVH extends TypeAdapter.ViewHolder implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public bv7 b;
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
    public ov4 o;
    public BdUniqueId p;
    public yr7 q;

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
        public void a(ArrayList<Integer> arrayList, String str, mp4 mp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, mp4Var) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(mp4 mp4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mp4Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(mp4 mp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mp4Var) == null) {
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
        this.k = view2.findViewById(R.id.obfuscated_res_0x7f091ac8);
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f092097);
        this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092019);
        this.f = (DynamicUserLikeButton) view2.findViewById(R.id.obfuscated_res_0x7f090a01);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901b6);
        this.h = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090710);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090783);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090dc0);
        this.l = view2.findViewById(R.id.obfuscated_res_0x7f090db8);
        this.m = view2.findViewById(R.id.obfuscated_res_0x7f0903bc);
        this.f.setTextSize(R.dimen.tbds28);
        this.h.setPlaceHolder(2);
        this.h.setRadius(oi.f(view2.getContext(), R.dimen.tbds10));
        this.h.setConrers(15);
    }

    public void e(bv7 bv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bv7Var) == null) {
            h(TbadkCoreApplication.getInst().getSkinType());
            if (bv7Var == null) {
                return;
            }
            this.b = bv7Var;
            this.k.setOnClickListener(this);
            this.h.K(bv7Var.d, 10, false);
            if (bv7Var.e == 1 && bv7Var.f > 0) {
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(8);
            }
            this.i.setText(bv7Var.c);
            TextView textView = this.e;
            textView.setText(String.format(textView.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0d93), StringHelper.getFixedText(bv7Var.a, 7, true)));
            TextView textView2 = this.j;
            textView2.setText(String.format(textView2.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0d91), StringHelper.numFormatOverWan(bv7Var.b)));
            this.m.setVisibility(bv7Var.n ? 8 : 0);
            k(bv7Var.o);
            l();
        }
    }

    public final void f(bv7 bv7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bv7Var) == null) && bv7Var != null && bv7Var.e == 1) {
            if (bv7Var.i) {
                g(bv7Var.k, bv7Var.j);
                return;
            }
            YyExtData yyExtData = bv7Var.p;
            if (yyExtData != null) {
                YYLiveUtil.jumpToYYLiveRoom(this.c, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "", yyExtData.streamInfo, YYLiveUtil.SOURCE_PB_WORD_RECOMMEND_LIVE_CARD);
            }
        }
    }

    public final void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<?> tbPageContext = this.c;
            urlManager.dealOneLink(tbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (this.a != i) {
                wr4.d(this.k).i(R.color.CAM_X0205, R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.d, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.i, R.color.CAM_X0105, 1, i);
                SkinManager.setViewTextColor(this.e, R.color.CAM_X0105, 1, i);
                SkinManager.setViewTextColor(this.j, R.color.CAM_X0109, 1, i);
                SkinManager.setViewTextColor(this.g, R.color.CAM_X0101, 1, i);
                NEGFeedBackView nEGFeedBackView = this.n;
                if (nEGFeedBackView != null) {
                    nEGFeedBackView.r();
                }
                View view2 = this.l;
                view2.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(oi.f(view2.getContext(), R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0309)));
                float f = oi.f(this.g.getContext(), R.dimen.tbds10);
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(DrawableSelector.TL_BR, R.color.CAM_X0308, R.color.CAM_X0301).tlRadius(f).brRadius(f).into(this.g);
                this.f.s(i);
            }
            this.a = i;
        }
    }

    public final void i(bv7 bv7Var) {
        yr7 yr7Var;
        YyExtData yyExtData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bv7Var) == null) || (yr7Var = this.q) == null || yr7Var.l() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c13709").param("fid", this.q.l().getId()).param("fname", this.q.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.q.Q());
        MetaData metaData = bv7Var.g;
        String str = "";
        StatisticItem param2 = param.param("obj_param1", metaData != null ? metaData.getUserId() : "");
        if (this.q.O() != null) {
            ThreadData O = this.q.O();
            int calculateLiveType = YYLiveUtil.calculateLiveType(O.getThreadAlaInfo());
            if (O.getThreadAlaInfo() != null && O.getThreadAlaInfo().isLegalYYLiveData()) {
                TiebaStaticHelper.addYYParam(param2, O.getThreadAlaInfo().mYyExtData);
            } else {
                if (bv7Var != null && (yyExtData = bv7Var.p) != null) {
                    TiebaStaticHelper.addYYParam(param2, yyExtData);
                    calculateLiveType = YYLiveUtil.calculateLiveType(bv7Var.p);
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

    public void j(yr7 yr7Var) {
        bv7 bv7Var;
        YyExtData yyExtData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, yr7Var) == null) || yr7Var == null || yr7Var.l() == null || (bv7Var = this.b) == null || bv7Var.m) {
            return;
        }
        this.q = yr7Var;
        StatisticItem param = new StatisticItem("c13708").param("fid", yr7Var.l().getId()).param("fname", yr7Var.l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", yr7Var.Q());
        MetaData metaData = this.b.g;
        String str = "";
        StatisticItem param2 = param.param("obj_param1", metaData != null ? metaData.getUserId() : "");
        if (yr7Var.O() != null) {
            ThreadData O = yr7Var.O();
            int calculateLiveType = YYLiveUtil.calculateLiveType(O.getThreadAlaInfo());
            if (O.getThreadAlaInfo() != null && O.getThreadAlaInfo().isLegalYYLiveData()) {
                TiebaStaticHelper.addYYParam(param2, O.getThreadAlaInfo().mYyExtData);
            } else {
                bv7 bv7Var2 = this.b;
                if (bv7Var2 != null && (yyExtData = bv7Var2.p) != null) {
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

    public final void k(mp4 mp4Var) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, mp4Var) == null) || (tbPageContext = this.c) == null) {
            return;
        }
        if (mp4Var == null) {
            NEGFeedBackView nEGFeedBackView = this.n;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.setVisibility(8);
                return;
            }
            return;
        }
        if (this.n == null) {
            int f = oi.f(tbPageContext.getPageActivity(), R.dimen.tbds44);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(oi.f(this.c.getPageActivity(), R.dimen.tbds130), oi.f(this.c.getPageActivity(), R.dimen.tbds86));
            layoutParams.addRule(11);
            layoutParams.addRule(8, R.id.obfuscated_res_0x7f090710);
            NEGFeedBackView nEGFeedBackView2 = new NEGFeedBackView(this.c);
            this.n = nEGFeedBackView2;
            nEGFeedBackView2.setPadding(f, f, f, 0);
            ((RelativeLayout) this.k.findViewById(R.id.obfuscated_res_0x7f0906e2)).addView(this.n, layoutParams);
            this.n.setEventCallback(new a(this));
        }
        this.n.setVisibility(0);
        this.n.setData(mp4Var);
        this.n.r();
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            bv7 bv7Var = this.b;
            if (bv7Var != null && bv7Var.g != null) {
                this.f.setVisibility(0);
                if (this.o == null) {
                    ov4 ov4Var = new ov4(this.c, this.f);
                    this.o = ov4Var;
                    ov4Var.l(this.p);
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
            bv7 bv7Var = this.b;
            if (bv7Var != null && id == R.id.obfuscated_res_0x7f091ac8) {
                f(bv7Var);
                i(this.b);
            }
        }
    }
}
