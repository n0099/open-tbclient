package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
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
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.HeadCustomImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.level.TbLevelView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.ay8;
import com.baidu.tieba.g35;
import com.baidu.tieba.gx4;
import com.baidu.tieba.ii;
import com.baidu.tieba.p09;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.view.VirtualImageStatusTip;
import com.baidu.tieba.yu5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes5.dex */
public class PbCommenFloorItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public TbImageView A0;
    public AgreeView B;
    public HeadWorldCupFlagLayout B0;
    public TextView C;
    public TbLevelView D;
    public HeadPendantView E;
    public UserIconBox F;
    public UserIconBox G;
    public ImageView H;
    public View I;
    public TextView J;
    public SimpleDraweeView K;
    public LinearLayout L;
    public LinearLayout M;
    public TextView N;
    public View O;
    public TextView P;
    public ImageView Q;
    public LinearLayout R;
    public LinearLayout S;
    public TextView T;
    public PbFloorComplaint U;
    public Boolean V;
    public ImageView W;
    public TbImageView X;
    public int Y;
    public int Z;
    public int a;
    public TBLottieAnimationView a0;
    public RelativeLayout b;
    public ViewGroup b0;
    public View c;
    public AgreeView c0;
    public boolean d;
    public ImageView d0;
    public View e;
    public ViewGroup e0;
    public LinearLayout f;
    public TextView f0;
    public TextView g;
    public TextView g0;
    public TextView h;
    public LinearLayout h0;
    public TextView i;
    public RelativeLayout i0;
    public TbImageView j;
    public EMTextView j0;
    public TextView k;
    public ImageView k0;
    public TextView l;
    public View l0;
    public TextView m;
    public ImageView m0;
    public TextView n;
    public FrameLayout n0;
    public AgreeView o;
    public MaskView o0;
    public HeadImageView p;
    public p09 p0;
    public TbRichTextView q;
    public FrameLayout q0;
    public RelativeLayout r;
    public VirtualImageStatusTip r0;
    public TbAlphaVideo s;
    public HeadCustomImageView s0;
    public ConstrainImageGroup t;
    public FrameLayout t0;
    public View u;
    public LinearLayout u0;
    public SubPbLayout v;
    public TextView v0;
    public TextView w;
    public RelativeLayout w0;
    public TextView x;
    public RelativeLayout x0;
    public ImageView y;
    public TextView y0;
    public ImageView z;
    public TBLottieAnimationView z0;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a0.playAnimation();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbCommenFloorItemViewHolder(TbPageContext tbPageContext, View view2, int i) {
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
        this.V = Boolean.FALSE;
        this.Y = -1;
        if (tbPageContext != null && view2 != null) {
            this.c = view2;
            this.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091a11);
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f092494);
            this.f = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0919c0);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0927f4);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0927f5);
            this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0927c0);
            this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0927ec);
            this.D = (TbLevelView) view2.findViewById(R.id.forum_level_view);
            this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0927e0);
            this.u = view2.findViewById(R.id.obfuscated_res_0x7f091a06);
            this.y = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091bdd);
            this.z = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091bde);
            AgreeView agreeView = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f091828);
            this.o = agreeView;
            agreeView.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.o.setNormalColorResourceId(R.color.CAM_X0109);
            this.o.y(false);
            this.A = view2.findViewById(R.id.obfuscated_res_0x7f0919ac);
            AgreeView agreeView2 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f09199e);
            this.B = agreeView2;
            agreeView2.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.B.setNormalColorResourceId(R.color.CAM_X0109);
            this.B.y(true);
            this.v0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09260b);
            RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091e15);
            this.w0 = relativeLayout;
            g35 d = g35.d(relativeLayout);
            d.o(R.string.J_X04);
            d.f(R.color.CAM_X0204);
            RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091dfd);
            this.x0 = relativeLayout2;
            g35 d2 = g35.d(relativeLayout2);
            d2.o(R.string.J_X07);
            d2.f(R.color.CAM_X0905);
            this.y0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09258f);
            this.A.setVisibility(8);
            this.u.setVisibility(0);
            this.y.setVisibility(0);
            this.z.setVisibility(0);
            this.o.setVisibility(0);
            this.H = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0919a3);
            this.Z = i;
            gx4 gx4Var = new gx4();
            gx4Var.b = 5;
            gx4Var.h = 8;
            gx4Var.g = 2;
            gx4Var.f = i;
            this.o.setStatisticData(gx4Var);
            this.p = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f091894);
            HeadPendantView headPendantView = (HeadPendantView) view2.findViewById(R.id.obfuscated_res_0x7f091a50);
            this.E = headPendantView;
            headPendantView.setHasPendantStyle();
            if (this.E.getHeadView() != null) {
                this.E.getHeadView().setIsRound(true);
                this.E.getHeadView().setDrawBorder(true);
                this.E.getHeadView().setPlaceHolder(1);
            }
            this.F = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f092095);
            this.G = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f092096);
            this.q = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091dc6);
            this.r = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091be7);
            this.s = (TbAlphaVideo) view2.findViewById(R.id.obfuscated_res_0x7f09014e);
            this.v = (SubPbLayout) view2.findViewById(R.id.obfuscated_res_0x7f0919fd);
            this.w = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091a07);
            this.w.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0107), null), (Drawable) null);
            this.w.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.w.setTextSize(0, ii.g(TbadkCoreApplication.getInst(), R.dimen.T_X07));
            this.x = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091a05);
            this.t = (ConstrainImageGroup) view2.findViewById(R.id.obfuscated_res_0x7f090b0e);
            this.I = view2.findViewById(R.id.obfuscated_res_0x7f091974);
            this.C = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b10);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b98);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b99);
            this.t.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be));
            this.t.setSingleImageRatio(0.75d);
            this.t.setImageProcessor(new yu5(3));
            ay8 ay8Var = new ay8(this.q.getLayoutStrategy());
            ay8Var.p(TbConfig.getPostLineSpace(), 1.0f);
            this.q.setLayoutStrategy(ay8Var);
            this.q.setIsNeedResizeEmotion(true);
            this.q.setTextSize(TbConfig.getContentSize());
            this.p.setIsRound(true);
            this.p.setGodIconWidth(R.dimen.tbds36);
            this.p.setPlaceHolder(1);
            this.q.setDisplayImage(this.d, false);
            this.q.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d0985);
            this.J = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919cf);
            this.K = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f091999);
            this.L = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091998);
            this.M = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091a02);
            this.N = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091a03);
            this.O = view2.findViewById(R.id.obfuscated_res_0x7f091a01);
            this.P = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091a04);
            this.Q = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a00);
            this.R = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09026f);
            this.S = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090b2a);
            this.T = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b2b);
            this.W = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091b60);
            this.X = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091b61);
            this.U = (PbFloorComplaint) view2.findViewById(R.id.obfuscated_res_0x7f0919a2);
            if (this.V.booleanValue()) {
                this.U.setVisibility(0);
            } else {
                this.U.setVisibility(8);
            }
            this.a0 = (TBLottieAnimationView) view2.findViewById(R.id.user_living_lottie);
            this.b0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f0919a8);
            this.c0 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f0919a6);
            this.d0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0919a7);
            this.h0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090834);
            this.i0 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090832);
            this.j0 = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090836);
            this.k0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090835);
            this.l0 = view2.findViewById(R.id.obfuscated_res_0x7f090b0f);
            this.c0.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.c0.setNormalColorResourceId(R.color.CAM_X0109);
            this.c0.y(false);
            this.c0.setAgreeAlone(true);
            this.c0.setStatisticData(gx4Var);
            this.e0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f091a08);
            this.f0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0927ed);
            this.g0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0904bd);
            this.m0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0919ff);
            this.n0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092669);
            p09 p09Var = new p09(tbPageContext, this.n0);
            this.p0 = p09Var;
            p09Var.f = 3;
            this.o0 = (MaskView) view2.findViewById(R.id.obfuscated_res_0x7f09164a);
            this.q0 = (FrameLayout) view2.findViewById(R.id.user_container);
            this.r0 = (VirtualImageStatusTip) view2.findViewById(R.id.obfuscated_res_0x7f092829);
            this.s0 = (HeadCustomImageView) view2.findViewById(R.id.obfuscated_res_0x7f092812);
            this.t0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092813);
            this.u0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091feb);
            this.j = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09197f);
            e(tbPageContext);
            this.A0 = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09199b);
            this.B0 = (HeadWorldCupFlagLayout) view2.findViewById(R.id.world_cup_flag);
        }
    }

    public void c(int i) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (tBLottieAnimationView = this.a0) != null) {
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && z) {
            gx4 gx4Var = new gx4();
            gx4Var.b = 12;
            gx4Var.h = 9;
            gx4Var.g = 3;
            gx4Var.f = this.Z;
            this.o.setStatisticData(gx4Var);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.p0.e();
            MaskView maskView = this.o0;
            if (maskView != null) {
                maskView.f();
            }
            PbFloorComplaint pbFloorComplaint = this.U;
            if (pbFloorComplaint != null) {
                pbFloorComplaint.setBackgroundColor(R.color.CAM_X0206);
                g35 d = g35.d(this.U);
                d.n(0);
                d.o(R.string.J_X05);
                d.f(R.color.CAM_X0206);
                this.U.b();
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.z0 != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                this.z0.setImageAssetsFolder("lottie_reactions_guide_left_img_dark");
            } else {
                this.z0.setImageAssetsFolder("lottie_reactions_guide_left_img");
            }
            SkinManager.setLottieAnimation(this.z0, R.raw.lottie_reactions_guide_left);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.a0.setVisibility(0);
                if (!this.a0.isAnimating()) {
                    this.a0.setSpeed(0.8f);
                    this.a0.setRepeatCount(-1);
                    this.a0.post(new a(this));
                    return;
                }
                return;
            }
            this.a0.setVisibility(8);
            if (this.a0.isAnimating()) {
                this.a0.cancelAnimation();
            }
        }
    }

    public final void e(@NonNull TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tbPageContext) == null) {
            this.z0 = new TBLottieAnimationView(tbPageContext.getPageActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ii.g(tbPageContext.getPageActivity(), R.dimen.tbds650), ii.g(tbPageContext.getPageActivity(), R.dimen.tbds100));
            layoutParams.setMargins(ii.g(tbPageContext.getPageActivity(), R.dimen.tbds90), 0, 0, ii.g(tbPageContext.getPageActivity(), R.dimen.tbds10));
            layoutParams.addRule(8, R.id.obfuscated_res_0x7f091122);
            this.b.addView(this.z0, layoutParams);
            f();
            this.z0.setVisibility(8);
        }
    }

    public void h(boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.p0.g(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.R.getLayoutParams();
            if (z) {
                this.n0.setVisibility(0);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f092669);
            } else {
                this.n0.setVisibility(8);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f091122);
            }
            this.R.setLayoutParams(layoutParams);
            MaskView maskView = this.o0;
            if (maskView != null) {
                maskView.setVisibility(8);
            }
            b();
        }
    }
}
