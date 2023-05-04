package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.HeadWorldCupFlagLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.afx.TbAlphaVideo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.HeadCustomImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.ay8;
import com.baidu.tieba.g35;
import com.baidu.tieba.gx4;
import com.baidu.tieba.ii;
import com.baidu.tieba.p09;
import com.baidu.tieba.view.VirtualImageStatusTip;
import com.baidu.tieba.yu5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes5.dex */
public class PbTopCommenFloorItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public ImageView B;
    public HeadPendantView C;
    public UserIconBox D;
    public UserIconBox E;
    public ImageView F;
    public TextView G;
    public SimpleDraweeView H;
    public LinearLayout I;
    public LinearLayout J;
    public TextView K;
    public View L;
    public TextView M;
    public ImageView N;
    public LinearLayout O;
    public LinearLayout P;
    public TextView Q;
    public PbFloorComplaint R;
    public Boolean S;
    public ImageView T;
    public TBLottieAnimationView U;
    public ViewGroup V;
    public AgreeView W;
    public ImageView X;
    public ViewGroup Y;
    public TextView Z;
    public int a;
    public TextView a0;
    public RelativeLayout b;
    public FrameLayout b0;
    public View c;
    public p09 c0;
    public boolean d;
    public FrameLayout d0;
    public View e;
    public VirtualImageStatusTip e0;
    public View f;
    public HeadCustomImageView f0;
    public LinearLayout g;
    public FrameLayout g0;
    public TextView h;
    public LinearLayout h0;
    public TextView i;
    public RelativeLayout i0;
    public TextView j;
    public RelativeLayout j0;
    public TbImageView k;
    public RelativeLayout k0;
    public TextView l;
    public TextView l0;
    public TextView m;
    public TextView m0;
    public TextView n;
    public TextView n0;
    public TextView o;
    public TBLottieAnimationView o0;
    public TextView p;
    public TbImageView p0;
    public HeadImageView q;
    public HeadWorldCupFlagLayout q0;
    public TbRichTextView r;
    public RelativeLayout s;
    public TbAlphaVideo t;
    public ConstrainImageGroup u;
    public View v;
    public View w;
    public ImageView x;
    public ImageView y;
    public AgreeView z;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;

        public a(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbTopCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbTopCommenFloorItemViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.U.playAnimation();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbTopCommenFloorItemViewHolder(TbPageContext tbPageContext, View view2, int i) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, Integer.valueOf(i)};
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
        this.a = 3;
        this.d = true;
        this.S = Boolean.FALSE;
        if (tbPageContext != null && view2 != null) {
            this.c = view2;
            this.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0919a4);
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f092494);
            this.f = view2.findViewById(R.id.bottom_divider_line);
            this.g = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0919c0);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0927f4);
            this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0927f5);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0927c0);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0927ec);
            this.B = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f7e);
            this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0927e0);
            this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092602);
            this.v = view2.findViewById(R.id.obfuscated_res_0x7f0919ac);
            AgreeView agreeView = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f09199e);
            this.z = agreeView;
            agreeView.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.z.setNormalColorResourceId(R.color.CAM_X0109);
            this.z.y(true);
            this.w = view2.findViewById(R.id.obfuscated_res_0x7f091a06);
            this.x = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091bdd);
            this.y = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091bde);
            this.n0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09260b);
            RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091e15);
            this.j0 = relativeLayout;
            g35 d = g35.d(relativeLayout);
            d.o(R.string.J_X04);
            d.f(R.color.CAM_X0204);
            RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091dfd);
            this.k0 = relativeLayout2;
            g35 d2 = g35.d(relativeLayout2);
            d2.o(R.string.J_X07);
            d2.f(R.color.CAM_X0905);
            this.l0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09258f);
            this.m0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925e6);
            this.v.setVisibility(8);
            this.w.setVisibility(8);
            this.x.setVisibility(0);
            this.y.setVisibility(0);
            this.F = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0919a3);
            gx4 gx4Var = new gx4();
            gx4Var.b = 5;
            gx4Var.h = 8;
            gx4Var.g = 2;
            gx4Var.f = i;
            this.q = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f091894);
            HeadPendantView headPendantView = (HeadPendantView) view2.findViewById(R.id.obfuscated_res_0x7f091a50);
            this.C = headPendantView;
            headPendantView.setHasPendantStyle();
            if (this.C.getHeadView() != null) {
                this.C.getHeadView().setIsRound(true);
                this.C.getHeadView().setDrawBorder(true);
                this.C.getHeadView().setPlaceHolder(1);
            }
            this.D = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f092095);
            this.E = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f092096);
            this.r = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091dc6);
            this.s = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091be7);
            this.t = (TbAlphaVideo) view2.findViewById(R.id.obfuscated_res_0x7f09014e);
            this.u = (ConstrainImageGroup) view2.findViewById(R.id.obfuscated_res_0x7f090b0e);
            this.A = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b10);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b98);
            this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b99);
            this.u.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be));
            this.u.setSingleImageRatio(0.75d);
            this.u.setImageProcessor(new yu5(3));
            ay8 ay8Var = new ay8(this.r.getLayoutStrategy());
            ay8Var.p(TbConfig.getPostLineSpace(), 1.0f);
            this.r.setLayoutStrategy(ay8Var);
            this.r.setIsNeedResizeEmotion(true);
            this.r.setTextSize(TbConfig.getContentSize());
            this.q.setIsRound(true);
            this.q.setGodIconWidth(R.dimen.tbds36);
            this.q.setPlaceHolder(1);
            this.r.setDisplayImage(this.d, false);
            this.r.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d0985);
            this.G = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919cf);
            this.H = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f091999);
            this.I = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091998);
            this.J = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091a02);
            this.K = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091a03);
            this.L = view2.findViewById(R.id.obfuscated_res_0x7f091a01);
            this.M = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091a04);
            this.N = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a00);
            this.O = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09026f);
            this.P = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090b2a);
            this.Q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b2b);
            this.T = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091b60);
            this.R = (PbFloorComplaint) view2.findViewById(R.id.obfuscated_res_0x7f0919a2);
            if (this.S.booleanValue()) {
                this.R.setVisibility(0);
            } else {
                this.R.setVisibility(8);
            }
            this.U = (TBLottieAnimationView) view2.findViewById(R.id.user_living_lottie);
            this.V = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f0919a8);
            this.W = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f0919a6);
            this.X = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0919a7);
            this.W.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.W.setNormalColorResourceId(R.color.CAM_X0109);
            this.W.y(false);
            this.W.setAgreeAlone(true);
            this.W.setStatisticData(gx4Var);
            this.Y = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f091a08);
            this.Z = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0927ed);
            this.a0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0904bd);
            this.b0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092669);
            p09 p09Var = new p09(tbPageContext, this.b0);
            this.c0 = p09Var;
            p09Var.f = 3;
            this.d0 = (FrameLayout) view2.findViewById(R.id.user_container);
            this.e0 = (VirtualImageStatusTip) view2.findViewById(R.id.obfuscated_res_0x7f092829);
            this.f0 = (HeadCustomImageView) view2.findViewById(R.id.obfuscated_res_0x7f092812);
            this.g0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092813);
            this.h0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091feb);
            this.i0 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091e17);
            this.k = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09197f);
            e(tbPageContext);
            this.p0 = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09199b);
            this.q0 = (HeadWorldCupFlagLayout) view2.findViewById(R.id.world_cup_flag);
        }
    }

    public void c(int i) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (tBLottieAnimationView = this.U) != null) {
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c0.e();
            PbFloorComplaint pbFloorComplaint = this.R;
            if (pbFloorComplaint != null) {
                pbFloorComplaint.setBackgroundColor(R.color.CAM_X0206);
                g35 d = g35.d(this.R);
                d.n(0);
                d.o(R.string.J_X05);
                d.f(R.color.CAM_X0206);
                this.R.b();
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.o0 != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                this.o0.setImageAssetsFolder("lottie_reactions_guide_left_img_dark");
            } else {
                this.o0.setImageAssetsFolder("lottie_reactions_guide_left_img");
            }
            SkinManager.setLottieAnimation(this.o0, R.raw.lottie_reactions_guide_left);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.U.setVisibility(0);
                if (!this.U.isAnimating()) {
                    this.U.setSpeed(0.8f);
                    this.U.setRepeatCount(-1);
                    this.U.post(new a(this));
                    return;
                }
                return;
            }
            this.U.setVisibility(8);
            if (this.U.isAnimating()) {
                this.U.cancelAnimation();
            }
        }
    }

    public final void e(@NonNull TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tbPageContext) == null) {
            this.o0 = new TBLottieAnimationView(tbPageContext.getPageActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ii.g(tbPageContext.getPageActivity(), R.dimen.tbds650), ii.g(tbPageContext.getPageActivity(), R.dimen.tbds100));
            layoutParams.setMargins(ii.g(tbPageContext.getPageActivity(), R.dimen.tbds90), 0, 0, ii.g(tbPageContext.getPageActivity(), R.dimen.tbds10));
            layoutParams.addRule(8, R.id.obfuscated_res_0x7f091122);
            this.b.addView(this.o0, layoutParams);
            f();
            this.o0.setVisibility(8);
        }
    }

    public void g(boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.c0.g(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.O.getLayoutParams();
            if (z) {
                this.b0.setVisibility(0);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f092669);
            } else {
                this.b0.setVisibility(8);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f091122);
            }
            this.O.setLayoutParams(layoutParams);
            b();
        }
    }
}
