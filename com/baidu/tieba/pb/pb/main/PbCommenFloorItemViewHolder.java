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
import com.baidu.tieba.ih5;
import com.baidu.tieba.jy7;
import com.baidu.tieba.mo4;
import com.baidu.tieba.ns4;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.ri;
import com.baidu.tieba.view.VirtualImageStatusTip;
import com.baidu.tieba.wv7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PbCommenFloorItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public ImageView B;
    public TextView C;
    public ImageView D;
    public TextView E;
    public AgreeView F;
    public TextView G;
    public ImageView H;
    public HeadPendantView I;
    public UserIconBox J;
    public UserIconBox K;
    public ImageView L;
    public View M;
    public TextView N;
    public LinearLayout O;
    public TextView P;
    public View Q;
    public TextView R;
    public ImageView S;
    public LinearLayout T;
    public LinearLayout U;
    public TextView V;
    public PbFloorComplaint W;
    public Boolean X;
    public ImageView Y;
    public int Z;
    public int a;
    public int a0;
    public View b;
    public TBLottieAnimationView b0;
    public boolean c;
    public ViewGroup c0;
    public View d;
    public AgreeView d0;
    public LinearLayout e;
    public ImageView e0;
    public TextView f;
    public ViewGroup f0;
    public TextView g;
    public TextView g0;
    public TextView h;
    public TextView h0;
    public TbImageView i;
    public LinearLayout i0;
    public TextView j;
    public RelativeLayout j0;
    public TextView k;
    public EMTextView k0;
    public TextView l;
    public ImageView l0;
    public TextView m;
    public View m0;
    public AgreeView n;
    public ImageView n0;
    public HeadImageView o;
    public FrameLayout o0;
    public TbRichTextView p;
    public MaskView p0;
    public ConstrainImageGroup q;
    public jy7 q0;
    public View r;
    public FrameLayout r0;
    public SubPbLayout s;
    public VirtualImageStatusTip s0;
    public TextView t;
    public HeadCustomImageView t0;
    public TextView u;
    public FrameLayout u0;
    public ImageView v;
    public LinearLayout v0;
    public ImageView w;
    public TextView w0;
    public View x;
    public RelativeLayout x0;
    public View y;
    public RelativeLayout y0;
    public View z;
    public TextView z0;

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
                this.a.b0.playAnimation();
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
        this.X = Boolean.FALSE;
        this.Z = -1;
        if (tbPageContext == null || view2 == null) {
            return;
        }
        this.b = view2;
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f092247);
        this.e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917f0);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092576);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092577);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092544);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09256e);
        this.H = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e0d);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092562);
        this.r = view2.findViewById(R.id.obfuscated_res_0x7f091836);
        this.v = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a03);
        this.w = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a04);
        AgreeView agreeView = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f09165b);
        this.n = agreeView;
        agreeView.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
        this.n.setNormalColorResourceId(R.color.CAM_X0109);
        this.n.u(false);
        this.x = view2.findViewById(R.id.obfuscated_res_0x7f0917dc);
        this.y = view2.findViewById(R.id.obfuscated_res_0x7f0917d9);
        this.z = view2.findViewById(R.id.obfuscated_res_0x7f0917cf);
        this.A = view2.findViewById(R.id.obfuscated_res_0x7f0917cd);
        this.B = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917da);
        this.C = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917db);
        this.D = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917d0);
        this.E = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917d1);
        AgreeView agreeView2 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f0917ce);
        this.F = agreeView2;
        agreeView2.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
        this.F.setNormalColorResourceId(R.color.CAM_X0109);
        this.F.u(true);
        this.w0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923a6);
        RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c1a);
        this.x0 = relativeLayout;
        ns4 d = ns4.d(relativeLayout);
        d.n(R.string.J_X04);
        d.f(R.color.CAM_X0204);
        RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c08);
        this.y0 = relativeLayout2;
        ns4 d2 = ns4.d(relativeLayout2);
        d2.n(R.string.J_X07);
        d2.f(R.color.CAM_X0905);
        this.z0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092333);
        this.x.setVisibility(8);
        this.r.setVisibility(0);
        this.v.setVisibility(0);
        this.w.setVisibility(0);
        this.n.setVisibility(0);
        this.L = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917d3);
        this.a0 = i;
        mo4 mo4Var = new mo4();
        mo4Var.b = 5;
        mo4Var.h = 8;
        mo4Var.g = 2;
        mo4Var.f = i;
        this.n.setStatisticData(mo4Var);
        this.o = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0916c5);
        HeadPendantView headPendantView = (HeadPendantView) view2.findViewById(R.id.obfuscated_res_0x7f09188d);
        this.I = headPendantView;
        headPendantView.setHasPendantStyle();
        if (this.I.getHeadView() != null) {
            this.I.getHeadView().setIsRound(true);
            this.I.getHeadView().setDrawBorder(true);
            this.I.getHeadView().setPlaceHolder(1);
        }
        this.J = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f091e74);
        this.K = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f091e75);
        this.p = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091bd4);
        this.s = (SubPbLayout) view2.findViewById(R.id.obfuscated_res_0x7f09182d);
        this.t = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091837);
        this.t.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0107), null), (Drawable) null);
        this.t.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        this.t.setTextSize(0, ri.f(TbadkCoreApplication.getInst(), R.dimen.T_X07));
        this.u = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091835);
        this.q = (ConstrainImageGroup) view2.findViewById(R.id.obfuscated_res_0x7f0909f1);
        this.M = view2.findViewById(R.id.obfuscated_res_0x7f0917a8);
        this.G = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0909f3);
        this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919c0);
        this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919c1);
        this.q.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be));
        this.q.setSingleImageRatio(0.75d);
        this.q.setImageProcessor(new ih5(3));
        wv7 wv7Var = new wv7(this.p.getLayoutStrategy());
        wv7Var.o(TbConfig.getPostLineSpace(), 1.0f);
        this.p.setLayoutStrategy(wv7Var);
        this.p.setIsNeedResizeEmotion(true);
        this.p.setTextSize(TbConfig.getContentSize());
        this.o.setIsRound(true);
        this.o.setGodIconWidth(R.dimen.tbds36);
        this.o.setPlaceHolder(1);
        this.p.setDisplayImage(this.c, false);
        this.p.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d08e7);
        this.N = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917ff);
        this.O = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091832);
        this.P = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091833);
        this.Q = view2.findViewById(R.id.obfuscated_res_0x7f091831);
        this.R = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091834);
        this.S = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091830);
        this.T = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090265);
        this.U = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090a0b);
        this.V = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a0c);
        this.Y = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09198b);
        this.W = (PbFloorComplaint) view2.findViewById(R.id.obfuscated_res_0x7f0917d2);
        if (this.X.booleanValue()) {
            this.W.setVisibility(0);
        } else {
            this.W.setVisibility(8);
        }
        this.b0 = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f092457);
        this.c0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f0917d8);
        this.d0 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f0917d6);
        this.e0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917d7);
        this.i0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09076f);
        this.j0 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09076c);
        this.k0 = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090771);
        this.l0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090770);
        this.m0 = view2.findViewById(R.id.obfuscated_res_0x7f0909f2);
        this.d0.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
        this.d0.setNormalColorResourceId(R.color.CAM_X0109);
        this.d0.u(false);
        this.d0.setAgreeAlone(true);
        this.d0.setStatisticData(mo4Var);
        this.f0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f091838);
        this.g0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09256f);
        this.h0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090449);
        this.n0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09182f);
        FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092401);
        this.o0 = frameLayout;
        jy7 jy7Var = new jy7(tbPageContext, frameLayout);
        this.q0 = jy7Var;
        jy7Var.f = 3;
        this.p0 = (MaskView) view2.findViewById(R.id.obfuscated_res_0x7f0914a3);
        this.r0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092431);
        this.s0 = (VirtualImageStatusTip) view2.findViewById(R.id.obfuscated_res_0x7f0925ac);
        this.t0 = (HeadCustomImageView) view2.findViewById(R.id.obfuscated_res_0x7f092595);
        this.u0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092596);
        this.v0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091dd4);
        this.i = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917b3);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.q0.d();
            MaskView maskView = this.p0;
            if (maskView != null) {
                maskView.f();
            }
            PbFloorComplaint pbFloorComplaint = this.W;
            if (pbFloorComplaint != null) {
                pbFloorComplaint.setBackgroundColor(R.color.CAM_X0206);
                ns4 d = ns4.d(this.W);
                d.m(0);
                d.n(R.string.J_X05);
                d.f(R.color.CAM_X0206);
                this.W.b();
            }
        }
    }

    public void c(int i) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (tBLottieAnimationView = this.b0) == null) {
            return;
        }
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.b0.setVisibility(0);
                if (this.b0.isAnimating()) {
                    return;
                }
                this.b0.setSpeed(0.8f);
                this.b0.setRepeatCount(-1);
                this.b0.post(new a(this));
                return;
            }
            this.b0.setVisibility(8);
            if (this.b0.isAnimating()) {
                this.b0.cancelAnimation();
            }
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && z) {
            mo4 mo4Var = new mo4();
            mo4Var.b = 12;
            mo4Var.h = 9;
            mo4Var.g = 3;
            mo4Var.f = this.a0;
            this.n.setStatisticData(mo4Var);
        }
    }

    public void f(boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.q0.f(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.T.getLayoutParams();
            if (z) {
                this.o0.setVisibility(0);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f092401);
            } else {
                this.o0.setVisibility(8);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f090f8e);
            }
            this.T.setLayoutParams(layoutParams);
            MaskView maskView = this.p0;
            if (maskView != null) {
                maskView.setVisibility(8);
            }
            b();
        }
    }
}
