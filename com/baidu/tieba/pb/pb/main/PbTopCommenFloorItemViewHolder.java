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
import com.baidu.tieba.l28;
import com.baidu.tieba.qw4;
import com.baidu.tieba.view.VirtualImageStatusTip;
import com.baidu.tieba.vl5;
import com.baidu.tieba.wz7;
import com.baidu.tieba.yi;
import com.baidu.tieba.zr4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes5.dex */
public class PbTopCommenFloorItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public ImageView B;
    public ImageView C;
    public TextView D;
    public ImageView E;
    public TextView F;
    public AgreeView G;
    public TextView H;
    public ImageView I;
    public HeadPendantView J;
    public UserIconBox K;
    public UserIconBox L;
    public ImageView M;
    public TextView N;
    public SimpleDraweeView O;
    public LinearLayout P;
    public LinearLayout Q;
    public TextView R;
    public View S;
    public TextView T;
    public ImageView U;
    public LinearLayout V;
    public LinearLayout W;
    public TextView X;
    public PbFloorComplaint Y;
    public Boolean Z;
    public int a;
    public ImageView a0;
    public RelativeLayout b;
    public TBLottieAnimationView b0;
    public View c;
    public ViewGroup c0;
    public boolean d;
    public AgreeView d0;
    public View e;
    public ImageView e0;
    public View f;
    public ViewGroup f0;
    public LinearLayout g;
    public TextView g0;
    public TextView h;
    public TextView h0;
    public TextView i;
    public FrameLayout i0;
    public TextView j;
    public l28 j0;
    public TbImageView k;
    public FrameLayout k0;
    public TextView l;
    public VirtualImageStatusTip l0;
    public TextView m;
    public HeadCustomImageView m0;
    public TextView n;
    public FrameLayout n0;
    public TextView o;
    public LinearLayout o0;
    public TextView p;
    public RelativeLayout p0;
    public HeadImageView q;
    public RelativeLayout q0;
    public TbRichTextView r;
    public RelativeLayout r0;
    public RelativeLayout s;
    public TextView s0;
    public TbAlphaVideo t;
    public TextView t0;
    public ConstrainImageGroup u;
    public TextView u0;
    public View v;
    public TBLottieAnimationView v0;
    public View w;
    public TbImageView w0;
    public View x;
    public HeadWorldCupFlagLayout x0;
    public View y;
    public ImageView z;

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
                this.a.b0.playAnimation();
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
        this.Z = Boolean.FALSE;
        if (tbPageContext != null && view2 != null) {
            this.c = view2;
            this.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091847);
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f0922e8);
            this.f = view2.findViewById(R.id.obfuscated_res_0x7f0903fd);
            this.g = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091863);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092623);
            this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092624);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925f1);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09261b);
            this.I = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e4d);
            this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09260f);
            this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09244b);
            this.v = view2.findViewById(R.id.obfuscated_res_0x7f09184f);
            this.w = view2.findViewById(R.id.obfuscated_res_0x7f09184c);
            this.x = view2.findViewById(R.id.obfuscated_res_0x7f091842);
            this.y = view2.findViewById(R.id.obfuscated_res_0x7f091840);
            this.z = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09184d);
            this.D = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09184e);
            this.E = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091843);
            this.F = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091844);
            AgreeView agreeView = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f091841);
            this.G = agreeView;
            agreeView.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.G.setNormalColorResourceId(R.color.CAM_X0109);
            this.G.v(true);
            this.A = view2.findViewById(R.id.obfuscated_res_0x7f0918ab);
            this.B = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a8d);
            this.C = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a8e);
            this.u0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092451);
            RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091cb9);
            this.q0 = relativeLayout;
            qw4 d = qw4.d(relativeLayout);
            d.n(R.string.J_X04);
            d.f(R.color.CAM_X0204);
            RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091ca1);
            this.r0 = relativeLayout2;
            qw4 d2 = qw4.d(relativeLayout2);
            d2.n(R.string.J_X07);
            d2.f(R.color.CAM_X0905);
            this.s0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923dd);
            this.t0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09242f);
            this.v.setVisibility(8);
            this.A.setVisibility(8);
            this.B.setVisibility(0);
            this.C.setVisibility(0);
            this.M = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091846);
            zr4 zr4Var = new zr4();
            zr4Var.b = 5;
            zr4Var.h = 8;
            zr4Var.g = 2;
            zr4Var.f = i;
            this.q = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f091734);
            HeadPendantView headPendantView = (HeadPendantView) view2.findViewById(R.id.obfuscated_res_0x7f091904);
            this.J = headPendantView;
            headPendantView.setHasPendantStyle();
            if (this.J.getHeadView() != null) {
                this.J.getHeadView().setIsRound(true);
                this.J.getHeadView().setDrawBorder(true);
                this.J.getHeadView().setPlaceHolder(1);
            }
            this.K = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f091f1d);
            this.L = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f091f1e);
            this.r = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091c6b);
            this.s = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091a97);
            this.t = (TbAlphaVideo) view2.findViewById(R.id.obfuscated_res_0x7f090156);
            this.u = (ConstrainImageGroup) view2.findViewById(R.id.obfuscated_res_0x7f090a29);
            this.H = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a2b);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091a4a);
            this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091a4b);
            this.u.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be));
            this.u.setSingleImageRatio(0.75d);
            this.u.setImageProcessor(new vl5(3));
            wz7 wz7Var = new wz7(this.r.getLayoutStrategy());
            wz7Var.o(TbConfig.getPostLineSpace(), 1.0f);
            this.r.setLayoutStrategy(wz7Var);
            this.r.setIsNeedResizeEmotion(true);
            this.r.setTextSize(TbConfig.getContentSize());
            this.q.setIsRound(true);
            this.q.setGodIconWidth(R.dimen.tbds36);
            this.q.setPlaceHolder(1);
            this.r.setDisplayImage(this.d, false);
            this.r.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d091f);
            this.N = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091874);
            this.O = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f09183c);
            this.P = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09183b);
            this.Q = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0918a7);
            this.R = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0918a8);
            this.S = view2.findViewById(R.id.obfuscated_res_0x7f0918a6);
            this.T = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0918a9);
            this.U = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0918a5);
            this.V = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09027d);
            this.W = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090a43);
            this.X = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a44);
            this.a0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a13);
            this.Y = (PbFloorComplaint) view2.findViewById(R.id.obfuscated_res_0x7f091845);
            if (this.Z.booleanValue()) {
                this.Y.setVisibility(0);
            } else {
                this.Y.setVisibility(8);
            }
            this.b0 = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f092503);
            this.c0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f09184b);
            this.d0 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f091849);
            this.e0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09184a);
            this.d0.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.d0.setNormalColorResourceId(R.color.CAM_X0109);
            this.d0.v(false);
            this.d0.setAgreeAlone(true);
            this.d0.setStatisticData(zr4Var);
            this.f0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f0918ad);
            this.g0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09261c);
            this.h0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09046e);
            this.i0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0924ac);
            l28 l28Var = new l28(tbPageContext, this.i0);
            this.j0 = l28Var;
            l28Var.f = 3;
            this.k0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0924dd);
            this.l0 = (VirtualImageStatusTip) view2.findViewById(R.id.obfuscated_res_0x7f092659);
            this.m0 = (HeadCustomImageView) view2.findViewById(R.id.obfuscated_res_0x7f092642);
            this.n0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092643);
            this.o0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091e78);
            this.p0 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091cbb);
            this.k = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091822);
            e(tbPageContext);
            this.w0 = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09183e);
            this.x0 = (HeadWorldCupFlagLayout) view2.findViewById(R.id.obfuscated_res_0x7f0926f9);
        }
    }

    public void c(int i) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (tBLottieAnimationView = this.b0) != null) {
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.j0.e();
            PbFloorComplaint pbFloorComplaint = this.Y;
            if (pbFloorComplaint != null) {
                pbFloorComplaint.setBackgroundColor(R.color.CAM_X0206);
                qw4 d = qw4.d(this.Y);
                d.m(0);
                d.n(R.string.J_X05);
                d.f(R.color.CAM_X0206);
                this.Y.b();
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.v0 != null) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                this.v0.setImageAssetsFolder("lottie_reactions_guide_left_img");
            } else {
                this.v0.setImageAssetsFolder("lottie_reactions_guide_left_img_dark");
            }
            SkinManager.setLottieAnimation(this.v0, R.raw.obfuscated_res_0x7f11004e);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.b0.setVisibility(0);
                if (!this.b0.isAnimating()) {
                    this.b0.setSpeed(0.8f);
                    this.b0.setRepeatCount(-1);
                    this.b0.post(new a(this));
                    return;
                }
                return;
            }
            this.b0.setVisibility(8);
            if (this.b0.isAnimating()) {
                this.b0.cancelAnimation();
            }
        }
    }

    public final void e(@NonNull TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tbPageContext) == null) {
            this.v0 = new TBLottieAnimationView(tbPageContext.getPageActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(yi.g(tbPageContext.getPageActivity(), R.dimen.tbds650), yi.g(tbPageContext.getPageActivity(), R.dimen.tbds100));
            layoutParams.setMargins(yi.g(tbPageContext.getPageActivity(), R.dimen.tbds90), 0, 0, yi.g(tbPageContext.getPageActivity(), R.dimen.tbds10));
            layoutParams.addRule(8, R.id.obfuscated_res_0x7f090fda);
            this.b.addView(this.v0, layoutParams);
            f();
            this.v0.setVisibility(8);
        }
    }

    public void g(boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.j0.g(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.V.getLayoutParams();
            if (z) {
                this.i0.setVisibility(0);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f0924ac);
            } else {
                this.i0.setVisibility(8);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f090fda);
            }
            this.V.setLayoutParams(layoutParams);
            b();
        }
    }
}
