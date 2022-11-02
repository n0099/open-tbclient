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
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.kl5;
import com.baidu.tieba.kw4;
import com.baidu.tieba.kz7;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.view.VirtualImageStatusTip;
import com.baidu.tieba.xi;
import com.baidu.tieba.xr4;
import com.baidu.tieba.z18;
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
    public LinearLayout A0;
    public View B;
    public TextView B0;
    public View C;
    public RelativeLayout C0;
    public View D;
    public RelativeLayout D0;
    public ImageView E;
    public TextView E0;
    public TextView F;
    public TBLottieAnimationView F0;
    public ImageView G;
    public TextView H;
    public AgreeView I;
    public TextView J;
    public ImageView K;
    public HeadPendantView L;
    public UserIconBox M;
    public UserIconBox N;
    public ImageView O;
    public View P;
    public TextView Q;
    public SimpleDraweeView R;
    public LinearLayout S;
    public LinearLayout T;
    public TextView U;
    public View V;
    public TextView W;
    public ImageView X;
    public LinearLayout Y;
    public LinearLayout Z;
    public int a;
    public TextView a0;
    public RelativeLayout b;
    public PbFloorComplaint b0;
    public View c;
    public Boolean c0;
    public boolean d;
    public ImageView d0;
    public View e;
    public int e0;
    public LinearLayout f;
    public int f0;
    public TextView g;
    public TBLottieAnimationView g0;
    public TextView h;
    public ViewGroup h0;
    public TextView i;
    public AgreeView i0;
    public TbImageView j;
    public ImageView j0;
    public TextView k;
    public ViewGroup k0;
    public TextView l;
    public TextView l0;
    public TextView m;
    public TextView m0;
    public TextView n;
    public LinearLayout n0;
    public AgreeView o;
    public RelativeLayout o0;
    public HeadImageView p;
    public EMTextView p0;
    public TbRichTextView q;
    public ImageView q0;
    public RelativeLayout r;
    public View r0;
    public TbAlphaVideo s;
    public ImageView s0;
    public ConstrainImageGroup t;
    public FrameLayout t0;
    public View u;
    public MaskView u0;
    public SubPbLayout v;
    public z18 v0;
    public TextView w;
    public FrameLayout w0;
    public TextView x;
    public VirtualImageStatusTip x0;
    public ImageView y;
    public HeadCustomImageView y0;
    public ImageView z;
    public FrameLayout z0;

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
                this.a.g0.playAnimation();
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
        this.c0 = Boolean.FALSE;
        this.e0 = -1;
        if (tbPageContext != null && view2 != null) {
            this.c = view2;
            this.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0918ae);
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f0922db);
            this.f = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09185b);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092614);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092615);
            this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925e2);
            this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09260c);
            this.K = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e4a);
            this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092600);
            this.u = view2.findViewById(R.id.obfuscated_res_0x7f0918a3);
            this.y = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a83);
            this.z = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a84);
            AgreeView agreeView = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f0916c0);
            this.o = agreeView;
            agreeView.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.o.setNormalColorResourceId(R.color.CAM_X0109);
            this.o.v(false);
            this.A = view2.findViewById(R.id.obfuscated_res_0x7f091847);
            this.B = view2.findViewById(R.id.obfuscated_res_0x7f091844);
            this.C = view2.findViewById(R.id.obfuscated_res_0x7f09183a);
            this.D = view2.findViewById(R.id.obfuscated_res_0x7f091838);
            this.E = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091845);
            this.F = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091846);
            this.G = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09183b);
            this.H = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09183c);
            AgreeView agreeView2 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f091839);
            this.I = agreeView2;
            agreeView2.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.I.setNormalColorResourceId(R.color.CAM_X0109);
            this.I.v(true);
            this.B0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092442);
            RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091cad);
            this.C0 = relativeLayout;
            kw4 d = kw4.d(relativeLayout);
            d.n(R.string.J_X04);
            d.f(R.color.CAM_X0204);
            RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c96);
            this.D0 = relativeLayout2;
            kw4 d2 = kw4.d(relativeLayout2);
            d2.n(R.string.J_X07);
            d2.f(R.color.CAM_X0905);
            this.E0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923ce);
            this.A.setVisibility(8);
            this.u.setVisibility(0);
            this.y.setVisibility(0);
            this.z.setVisibility(0);
            this.o.setVisibility(0);
            this.O = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09183e);
            this.f0 = i;
            xr4 xr4Var = new xr4();
            xr4Var.b = 5;
            xr4Var.h = 8;
            xr4Var.g = 2;
            xr4Var.f = i;
            this.o.setStatisticData(xr4Var);
            this.p = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f09172d);
            HeadPendantView headPendantView = (HeadPendantView) view2.findViewById(R.id.obfuscated_res_0x7f0918fb);
            this.L = headPendantView;
            headPendantView.setHasPendantStyle();
            if (this.L.getHeadView() != null) {
                this.L.getHeadView().setIsRound(true);
                this.L.getHeadView().setDrawBorder(true);
                this.L.getHeadView().setPlaceHolder(1);
            }
            this.M = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f091f11);
            this.N = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f091f12);
            this.q = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091c61);
            this.r = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091a8d);
            this.s = (TbAlphaVideo) view2.findViewById(R.id.obfuscated_res_0x7f090156);
            this.v = (SubPbLayout) view2.findViewById(R.id.obfuscated_res_0x7f09189a);
            this.w = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0918a4);
            this.w.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0107), null), (Drawable) null);
            this.w.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.w.setTextSize(0, xi.g(TbadkCoreApplication.getInst(), R.dimen.T_X07));
            this.x = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0918a2);
            this.t = (ConstrainImageGroup) view2.findViewById(R.id.obfuscated_res_0x7f090a28);
            this.P = view2.findViewById(R.id.obfuscated_res_0x7f091810);
            this.J = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a2a);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091a40);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091a41);
            this.t.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be));
            this.t.setSingleImageRatio(0.75d);
            this.t.setImageProcessor(new kl5(3));
            kz7 kz7Var = new kz7(this.q.getLayoutStrategy());
            kz7Var.o(TbConfig.getPostLineSpace(), 1.0f);
            this.q.setLayoutStrategy(kz7Var);
            this.q.setIsNeedResizeEmotion(true);
            this.q.setTextSize(TbConfig.getContentSize());
            this.p.setIsRound(true);
            this.p.setGodIconWidth(R.dimen.tbds36);
            this.p.setPlaceHolder(1);
            this.q.setDisplayImage(this.d, false);
            this.q.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d091b);
            this.Q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09186c);
            this.R = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f091835);
            this.S = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091834);
            this.T = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09189f);
            this.U = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0918a0);
            this.V = view2.findViewById(R.id.obfuscated_res_0x7f09189e);
            this.W = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0918a1);
            this.X = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09189d);
            this.Y = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09027d);
            this.Z = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090a42);
            this.a0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a43);
            this.d0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a0a);
            this.b0 = (PbFloorComplaint) view2.findViewById(R.id.obfuscated_res_0x7f09183d);
            if (this.c0.booleanValue()) {
                this.b0.setVisibility(0);
            } else {
                this.b0.setVisibility(8);
            }
            this.g0 = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f0924f4);
            this.h0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f091843);
            this.i0 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f091841);
            this.j0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091842);
            this.n0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09079d);
            this.o0 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09079a);
            this.p0 = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f09079f);
            this.q0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09079e);
            this.r0 = view2.findViewById(R.id.obfuscated_res_0x7f090a29);
            this.i0.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.i0.setNormalColorResourceId(R.color.CAM_X0109);
            this.i0.v(false);
            this.i0.setAgreeAlone(true);
            this.i0.setStatisticData(xr4Var);
            this.k0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f0918a5);
            this.l0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09260d);
            this.m0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09046d);
            this.s0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09189c);
            this.t0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09249d);
            z18 z18Var = new z18(tbPageContext, this.t0);
            this.v0 = z18Var;
            z18Var.f = 3;
            this.u0 = (MaskView) view2.findViewById(R.id.obfuscated_res_0x7f0914f9);
            this.w0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0924ce);
            this.x0 = (VirtualImageStatusTip) view2.findViewById(R.id.obfuscated_res_0x7f09264a);
            this.y0 = (HeadCustomImageView) view2.findViewById(R.id.obfuscated_res_0x7f092633);
            this.z0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092634);
            this.A0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091e6c);
            this.j = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09181b);
            e(tbPageContext);
        }
    }

    public void c(int i) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (tBLottieAnimationView = this.g0) != null) {
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && z) {
            xr4 xr4Var = new xr4();
            xr4Var.b = 12;
            xr4Var.h = 9;
            xr4Var.g = 3;
            xr4Var.f = this.f0;
            this.o.setStatisticData(xr4Var);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.v0.e();
            MaskView maskView = this.u0;
            if (maskView != null) {
                maskView.f();
            }
            PbFloorComplaint pbFloorComplaint = this.b0;
            if (pbFloorComplaint != null) {
                pbFloorComplaint.setBackgroundColor(R.color.CAM_X0206);
                kw4 d = kw4.d(this.b0);
                d.m(0);
                d.n(R.string.J_X05);
                d.f(R.color.CAM_X0206);
                this.b0.b();
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.F0 != null) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                this.F0.setImageAssetsFolder("lottie_reactions_guide_left_img");
            } else {
                this.F0.setImageAssetsFolder("lottie_reactions_guide_left_img_dark");
            }
            SkinManager.setLottieAnimation(this.F0, R.raw.obfuscated_res_0x7f11004e);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.g0.setVisibility(0);
                if (!this.g0.isAnimating()) {
                    this.g0.setSpeed(0.8f);
                    this.g0.setRepeatCount(-1);
                    this.g0.post(new a(this));
                    return;
                }
                return;
            }
            this.g0.setVisibility(8);
            if (this.g0.isAnimating()) {
                this.g0.cancelAnimation();
            }
        }
    }

    public final void e(@NonNull TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tbPageContext) == null) {
            this.F0 = new TBLottieAnimationView(tbPageContext.getPageActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(xi.g(tbPageContext.getPageActivity(), R.dimen.tbds650), xi.g(tbPageContext.getPageActivity(), R.dimen.tbds100));
            layoutParams.setMargins(xi.g(tbPageContext.getPageActivity(), R.dimen.tbds90), 0, 0, xi.g(tbPageContext.getPageActivity(), R.dimen.tbds10));
            layoutParams.addRule(8, R.id.obfuscated_res_0x7f090fd6);
            this.b.addView(this.F0, layoutParams);
            f();
            this.F0.setVisibility(8);
        }
    }

    public void h(boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.v0.g(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Y.getLayoutParams();
            if (z) {
                this.t0.setVisibility(0);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f09249d);
            } else {
                this.t0.setVisibility(8);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f090fd6);
            }
            this.Y.setLayoutParams(layoutParams);
            MaskView maskView = this.u0;
            if (maskView != null) {
                maskView.setVisibility(8);
            }
            b();
        }
    }
}
