package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import com.baidu.tieba.e08;
import com.baidu.tieba.ej;
import com.baidu.tieba.er4;
import com.baidu.tieba.fk5;
import com.baidu.tieba.hv4;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.qx7;
import com.baidu.tieba.view.VirtualImageStatusTip;
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
    public TextView A0;
    public View B;
    public RelativeLayout B0;
    public View C;
    public RelativeLayout C0;
    public ImageView D;
    public TextView D0;
    public TextView E;
    public ImageView F;
    public TextView G;
    public AgreeView H;
    public TextView I;
    public ImageView J;
    public HeadPendantView K;
    public UserIconBox L;
    public UserIconBox M;
    public ImageView N;
    public View O;
    public TextView P;
    public SimpleDraweeView Q;
    public LinearLayout R;
    public LinearLayout S;
    public TextView T;
    public View U;
    public TextView V;
    public ImageView W;
    public LinearLayout X;
    public LinearLayout Y;
    public TextView Z;
    public int a;
    public PbFloorComplaint a0;
    public View b;
    public Boolean b0;
    public boolean c;
    public ImageView c0;
    public View d;
    public int d0;
    public LinearLayout e;
    public int e0;
    public TextView f;
    public TBLottieAnimationView f0;
    public TextView g;
    public ViewGroup g0;
    public TextView h;
    public AgreeView h0;
    public TbImageView i;
    public ImageView i0;
    public TextView j;
    public ViewGroup j0;
    public TextView k;
    public TextView k0;
    public TextView l;
    public TextView l0;
    public TextView m;
    public LinearLayout m0;
    public AgreeView n;
    public RelativeLayout n0;
    public HeadImageView o;
    public EMTextView o0;
    public TbRichTextView p;
    public ImageView p0;
    public RelativeLayout q;
    public View q0;
    public TbAlphaVideo r;
    public ImageView r0;
    public ConstrainImageGroup s;
    public FrameLayout s0;
    public View t;
    public MaskView t0;
    public SubPbLayout u;
    public e08 u0;
    public TextView v;
    public FrameLayout v0;
    public TextView w;
    public VirtualImageStatusTip w0;
    public ImageView x;
    public HeadCustomImageView x0;
    public ImageView y;
    public FrameLayout y0;
    public View z;
    public LinearLayout z0;

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
                this.a.f0.playAnimation();
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
        this.c = true;
        this.b0 = Boolean.FALSE;
        this.d0 = -1;
        if (tbPageContext == null || view2 == null) {
            return;
        }
        this.b = view2;
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f09229d);
        this.e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091828);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925d4);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925d5);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925a2);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925cc);
        this.J = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e27);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925c0);
        this.t = view2.findViewById(R.id.obfuscated_res_0x7f09186e);
        this.x = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a43);
        this.y = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a44);
        AgreeView agreeView = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f09168f);
        this.n = agreeView;
        agreeView.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
        this.n.setNormalColorResourceId(R.color.CAM_X0109);
        this.n.u(false);
        this.z = view2.findViewById(R.id.obfuscated_res_0x7f091814);
        this.A = view2.findViewById(R.id.obfuscated_res_0x7f091811);
        this.B = view2.findViewById(R.id.obfuscated_res_0x7f091807);
        this.C = view2.findViewById(R.id.obfuscated_res_0x7f091805);
        this.D = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091812);
        this.E = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091813);
        this.F = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091808);
        this.G = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091809);
        AgreeView agreeView2 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f091806);
        this.H = agreeView2;
        agreeView2.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
        this.H.setNormalColorResourceId(R.color.CAM_X0109);
        this.H.u(true);
        this.A0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092401);
        RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c68);
        this.B0 = relativeLayout;
        hv4 d = hv4.d(relativeLayout);
        d.n(R.string.J_X04);
        d.f(R.color.CAM_X0204);
        RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c51);
        this.C0 = relativeLayout2;
        hv4 d2 = hv4.d(relativeLayout2);
        d2.n(R.string.J_X07);
        d2.f(R.color.CAM_X0905);
        this.D0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09238d);
        this.z.setVisibility(8);
        this.t.setVisibility(0);
        this.x.setVisibility(0);
        this.y.setVisibility(0);
        this.n.setVisibility(0);
        this.N = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09180b);
        this.e0 = i;
        er4 er4Var = new er4();
        er4Var.b = 5;
        er4Var.h = 8;
        er4Var.g = 2;
        er4Var.f = i;
        this.n.setStatisticData(er4Var);
        this.o = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0916fa);
        HeadPendantView headPendantView = (HeadPendantView) view2.findViewById(R.id.obfuscated_res_0x7f0918c5);
        this.K = headPendantView;
        headPendantView.setHasPendantStyle();
        if (this.K.getHeadView() != null) {
            this.K.getHeadView().setIsRound(true);
            this.K.getHeadView().setDrawBorder(true);
            this.K.getHeadView().setPlaceHolder(1);
        }
        this.L = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f091ec6);
        this.M = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f091ec7);
        this.p = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091c1d);
        this.q = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091a4d);
        this.r = (TbAlphaVideo) view2.findViewById(R.id.obfuscated_res_0x7f09014e);
        this.u = (SubPbLayout) view2.findViewById(R.id.obfuscated_res_0x7f091865);
        this.v = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09186f);
        this.v.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0107), null), (Drawable) null);
        this.v.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        this.v.setTextSize(0, ej.f(TbadkCoreApplication.getInst(), R.dimen.T_X07));
        this.w = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09186d);
        this.s = (ConstrainImageGroup) view2.findViewById(R.id.obfuscated_res_0x7f090a0b);
        this.O = view2.findViewById(R.id.obfuscated_res_0x7f0917dd);
        this.I = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a0d);
        this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091a00);
        this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091a01);
        this.s.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be));
        this.s.setSingleImageRatio(0.75d);
        this.s.setImageProcessor(new fk5(3));
        qx7 qx7Var = new qx7(this.p.getLayoutStrategy());
        qx7Var.o(TbConfig.getPostLineSpace(), 1.0f);
        this.p.setLayoutStrategy(qx7Var);
        this.p.setIsNeedResizeEmotion(true);
        this.p.setTextSize(TbConfig.getContentSize());
        this.o.setIsRound(true);
        this.o.setGodIconWidth(R.dimen.tbds36);
        this.o.setPlaceHolder(1);
        this.p.setDisplayImage(this.c, false);
        this.p.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d0906);
        this.P = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091837);
        this.Q = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f091802);
        this.R = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091801);
        this.S = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09186a);
        this.T = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09186b);
        this.U = view2.findViewById(R.id.obfuscated_res_0x7f091869);
        this.V = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09186c);
        this.W = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091868);
        this.X = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09026c);
        this.Y = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090a25);
        this.Z = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a26);
        this.c0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0919ca);
        this.a0 = (PbFloorComplaint) view2.findViewById(R.id.obfuscated_res_0x7f09180a);
        if (this.b0.booleanValue()) {
            this.a0.setVisibility(0);
        } else {
            this.a0.setVisibility(8);
        }
        this.f0 = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f0924b4);
        this.g0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f091810);
        this.h0 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f09180e);
        this.i0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09180f);
        this.m0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090786);
        this.n0 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090783);
        this.o0 = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090788);
        this.p0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090787);
        this.q0 = view2.findViewById(R.id.obfuscated_res_0x7f090a0c);
        this.h0.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
        this.h0.setNormalColorResourceId(R.color.CAM_X0109);
        this.h0.u(false);
        this.h0.setAgreeAlone(true);
        this.h0.setStatisticData(er4Var);
        this.j0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f091870);
        this.k0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925cd);
        this.l0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090457);
        this.r0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091867);
        this.s0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09245d);
        e08 e08Var = new e08(tbPageContext, this.s0);
        this.u0 = e08Var;
        e08Var.f = 3;
        this.t0 = (MaskView) view2.findViewById(R.id.obfuscated_res_0x7f0914c8);
        this.v0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09248e);
        this.w0 = (VirtualImageStatusTip) view2.findViewById(R.id.obfuscated_res_0x7f09260a);
        this.x0 = (HeadCustomImageView) view2.findViewById(R.id.obfuscated_res_0x7f0925f3);
        this.y0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0925f4);
        this.z0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091e25);
        this.i = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917e8);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.u0.e();
            MaskView maskView = this.t0;
            if (maskView != null) {
                maskView.f();
            }
            PbFloorComplaint pbFloorComplaint = this.a0;
            if (pbFloorComplaint != null) {
                pbFloorComplaint.setBackgroundColor(R.color.CAM_X0206);
                hv4 d = hv4.d(this.a0);
                d.m(0);
                d.n(R.string.J_X05);
                d.f(R.color.CAM_X0206);
                this.a0.b();
            }
        }
    }

    public void c(int i) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (tBLottieAnimationView = this.f0) == null) {
            return;
        }
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.f0.setVisibility(0);
                if (this.f0.isAnimating()) {
                    return;
                }
                this.f0.setSpeed(0.8f);
                this.f0.setRepeatCount(-1);
                this.f0.post(new a(this));
                return;
            }
            this.f0.setVisibility(8);
            if (this.f0.isAnimating()) {
                this.f0.cancelAnimation();
            }
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && z) {
            er4 er4Var = new er4();
            er4Var.b = 12;
            er4Var.h = 9;
            er4Var.g = 3;
            er4Var.f = this.e0;
            this.n.setStatisticData(er4Var);
        }
    }

    public void f(boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.u0.g(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.X.getLayoutParams();
            if (z) {
                this.s0.setVisibility(0);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f09245d);
            } else {
                this.s0.setVisibility(8);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f090fa9);
            }
            this.X.setLayoutParams(layoutParams);
            MaskView maskView = this.t0;
            if (maskView != null) {
                maskView.setVisibility(8);
            }
            b();
        }
    }
}
