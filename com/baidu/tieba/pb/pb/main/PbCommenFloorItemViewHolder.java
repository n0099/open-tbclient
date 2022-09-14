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
import com.baidu.tieba.cx7;
import com.baidu.tieba.ej;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.qz7;
import com.baidu.tieba.rq4;
import com.baidu.tieba.sj5;
import com.baidu.tieba.uu4;
import com.baidu.tieba.view.VirtualImageStatusTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PbCommenFloorItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public RelativeLayout A0;
    public View B;
    public TextView B0;
    public View C;
    public ImageView D;
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
    public View b;
    public int b0;
    public boolean c;
    public int c0;
    public View d;
    public TBLottieAnimationView d0;
    public LinearLayout e;
    public ViewGroup e0;
    public TextView f;
    public AgreeView f0;
    public TextView g;
    public ImageView g0;
    public TextView h;
    public ViewGroup h0;
    public TbImageView i;
    public TextView i0;
    public TextView j;
    public TextView j0;
    public TextView k;
    public LinearLayout k0;
    public TextView l;
    public RelativeLayout l0;
    public TextView m;
    public EMTextView m0;
    public AgreeView n;
    public ImageView n0;
    public HeadImageView o;
    public View o0;
    public TbRichTextView p;
    public ImageView p0;
    public RelativeLayout q;
    public FrameLayout q0;
    public TbAlphaVideo r;
    public MaskView r0;
    public ConstrainImageGroup s;
    public qz7 s0;
    public View t;
    public FrameLayout t0;
    public SubPbLayout u;
    public VirtualImageStatusTip u0;
    public TextView v;
    public HeadCustomImageView v0;
    public TextView w;
    public FrameLayout w0;
    public ImageView x;
    public LinearLayout x0;
    public ImageView y;
    public TextView y0;
    public View z;
    public RelativeLayout z0;

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
                this.a.d0.playAnimation();
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
        this.Z = Boolean.FALSE;
        this.b0 = -1;
        if (tbPageContext == null || view2 == null) {
            return;
        }
        this.b = view2;
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f09229b);
        this.e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091826);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925d2);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925d3);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925a0);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925ca);
        this.J = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e28);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925be);
        this.t = view2.findViewById(R.id.obfuscated_res_0x7f09186c);
        this.x = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a41);
        this.y = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a42);
        AgreeView agreeView = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f09168f);
        this.n = agreeView;
        agreeView.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
        this.n.setNormalColorResourceId(R.color.CAM_X0109);
        this.n.u(false);
        this.z = view2.findViewById(R.id.obfuscated_res_0x7f091812);
        this.A = view2.findViewById(R.id.obfuscated_res_0x7f09180f);
        this.B = view2.findViewById(R.id.obfuscated_res_0x7f091805);
        this.C = view2.findViewById(R.id.obfuscated_res_0x7f091803);
        this.D = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091810);
        this.E = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091811);
        this.F = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091806);
        this.G = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091807);
        AgreeView agreeView2 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f091804);
        this.H = agreeView2;
        agreeView2.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
        this.H.setNormalColorResourceId(R.color.CAM_X0109);
        this.H.u(true);
        this.y0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923ff);
        RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c66);
        this.z0 = relativeLayout;
        uu4 d = uu4.d(relativeLayout);
        d.n(R.string.J_X04);
        d.f(R.color.CAM_X0204);
        RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c4f);
        this.A0 = relativeLayout2;
        uu4 d2 = uu4.d(relativeLayout2);
        d2.n(R.string.J_X07);
        d2.f(R.color.CAM_X0905);
        this.B0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09238b);
        this.z.setVisibility(8);
        this.t.setVisibility(0);
        this.x.setVisibility(0);
        this.y.setVisibility(0);
        this.n.setVisibility(0);
        this.N = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091809);
        this.c0 = i;
        rq4 rq4Var = new rq4();
        rq4Var.b = 5;
        rq4Var.h = 8;
        rq4Var.g = 2;
        rq4Var.f = i;
        this.n.setStatisticData(rq4Var);
        this.o = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0916fa);
        HeadPendantView headPendantView = (HeadPendantView) view2.findViewById(R.id.obfuscated_res_0x7f0918c3);
        this.K = headPendantView;
        headPendantView.setHasPendantStyle();
        if (this.K.getHeadView() != null) {
            this.K.getHeadView().setIsRound(true);
            this.K.getHeadView().setDrawBorder(true);
            this.K.getHeadView().setPlaceHolder(1);
        }
        this.L = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f091ec4);
        this.M = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f091ec5);
        this.p = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091c1b);
        this.q = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091a4b);
        this.r = (TbAlphaVideo) view2.findViewById(R.id.obfuscated_res_0x7f09014e);
        this.u = (SubPbLayout) view2.findViewById(R.id.obfuscated_res_0x7f091863);
        this.v = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09186d);
        this.v.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0107), null), (Drawable) null);
        this.v.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        this.v.setTextSize(0, ej.f(TbadkCoreApplication.getInst(), R.dimen.T_X07));
        this.w = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09186b);
        this.s = (ConstrainImageGroup) view2.findViewById(R.id.obfuscated_res_0x7f090a0b);
        this.O = view2.findViewById(R.id.obfuscated_res_0x7f0917dd);
        this.I = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a0d);
        this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919fe);
        this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919ff);
        this.s.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be));
        this.s.setSingleImageRatio(0.75d);
        this.s.setImageProcessor(new sj5(3));
        cx7 cx7Var = new cx7(this.p.getLayoutStrategy());
        cx7Var.o(TbConfig.getPostLineSpace(), 1.0f);
        this.p.setLayoutStrategy(cx7Var);
        this.p.setIsNeedResizeEmotion(true);
        this.p.setTextSize(TbConfig.getContentSize());
        this.o.setIsRound(true);
        this.o.setGodIconWidth(R.dimen.tbds36);
        this.o.setPlaceHolder(1);
        this.p.setDisplayImage(this.c, false);
        this.p.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d0906);
        this.P = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091835);
        this.Q = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091868);
        this.R = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091869);
        this.S = view2.findViewById(R.id.obfuscated_res_0x7f091867);
        this.T = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09186a);
        this.U = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091866);
        this.V = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09026c);
        this.W = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090a25);
        this.X = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a26);
        this.a0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0919c8);
        this.Y = (PbFloorComplaint) view2.findViewById(R.id.obfuscated_res_0x7f091808);
        if (this.Z.booleanValue()) {
            this.Y.setVisibility(0);
        } else {
            this.Y.setVisibility(8);
        }
        this.d0 = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f0924b2);
        this.e0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f09180e);
        this.f0 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f09180c);
        this.g0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09180d);
        this.k0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090786);
        this.l0 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090783);
        this.m0 = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090788);
        this.n0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090787);
        this.o0 = view2.findViewById(R.id.obfuscated_res_0x7f090a0c);
        this.f0.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
        this.f0.setNormalColorResourceId(R.color.CAM_X0109);
        this.f0.u(false);
        this.f0.setAgreeAlone(true);
        this.f0.setStatisticData(rq4Var);
        this.h0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f09186e);
        this.i0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925cb);
        this.j0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090457);
        this.p0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091865);
        this.q0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09245b);
        qz7 qz7Var = new qz7(tbPageContext, this.q0);
        this.s0 = qz7Var;
        qz7Var.f = 3;
        this.r0 = (MaskView) view2.findViewById(R.id.obfuscated_res_0x7f0914c8);
        this.t0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09248c);
        this.u0 = (VirtualImageStatusTip) view2.findViewById(R.id.obfuscated_res_0x7f092608);
        this.v0 = (HeadCustomImageView) view2.findViewById(R.id.obfuscated_res_0x7f0925f1);
        this.w0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0925f2);
        this.x0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091e23);
        this.i = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917e8);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.s0.e();
            MaskView maskView = this.r0;
            if (maskView != null) {
                maskView.f();
            }
            PbFloorComplaint pbFloorComplaint = this.Y;
            if (pbFloorComplaint != null) {
                pbFloorComplaint.setBackgroundColor(R.color.CAM_X0206);
                uu4 d = uu4.d(this.Y);
                d.m(0);
                d.n(R.string.J_X05);
                d.f(R.color.CAM_X0206);
                this.Y.b();
            }
        }
    }

    public void c(int i) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (tBLottieAnimationView = this.d0) == null) {
            return;
        }
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.d0.setVisibility(0);
                if (this.d0.isAnimating()) {
                    return;
                }
                this.d0.setSpeed(0.8f);
                this.d0.setRepeatCount(-1);
                this.d0.post(new a(this));
                return;
            }
            this.d0.setVisibility(8);
            if (this.d0.isAnimating()) {
                this.d0.cancelAnimation();
            }
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && z) {
            rq4 rq4Var = new rq4();
            rq4Var.b = 12;
            rq4Var.h = 9;
            rq4Var.g = 3;
            rq4Var.f = this.c0;
            this.n.setStatisticData(rq4Var);
        }
    }

    public void f(boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.s0.g(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.V.getLayoutParams();
            if (z) {
                this.q0.setVisibility(0);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f09245b);
            } else {
                this.q0.setVisibility(8);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f090fa9);
            }
            this.V.setLayoutParams(layoutParams);
            MaskView maskView = this.r0;
            if (maskView != null) {
                maskView.setVisibility(8);
            }
            b();
        }
    }
}
