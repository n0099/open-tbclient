package com.baidu.tieba.pb.pb.main;

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
import com.baidu.tieba.view.VirtualImageStatusTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dh5;
import com.repackage.ey7;
import com.repackage.lo4;
import com.repackage.ms4;
import com.repackage.qi;
import com.repackage.rv7;
/* loaded from: classes3.dex */
public class PbTopCommenFloorItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public ImageView B;
    public TextView C;
    public AgreeView D;
    public TextView E;
    public ImageView F;
    public HeadPendantView G;
    public UserIconBox H;
    public UserIconBox I;
    public ImageView J;
    public TextView K;
    public LinearLayout L;
    public TextView M;
    public View N;
    public TextView O;
    public ImageView P;
    public LinearLayout Q;
    public LinearLayout R;
    public TextView S;
    public PbFloorComplaint T;
    public Boolean U;
    public ImageView V;
    public TBLottieAnimationView W;
    public ViewGroup X;
    public AgreeView Y;
    public ImageView Z;
    public int a;
    public ViewGroup a0;
    public View b;
    public TextView b0;
    public boolean c;
    public TextView c0;
    public View d;
    public FrameLayout d0;
    public View e;
    public ey7 e0;
    public LinearLayout f;
    public FrameLayout f0;
    public TextView g;
    public VirtualImageStatusTip g0;
    public TextView h;
    public HeadCustomImageView h0;
    public TextView i;
    public FrameLayout i0;
    public TbImageView j;
    public LinearLayout j0;
    public TextView k;
    public RelativeLayout k0;
    public TextView l;
    public RelativeLayout l0;
    public TextView m;
    public TextView m0;
    public TextView n;
    public TextView n0;
    public TextView o;
    public TextView o0;
    public HeadImageView p;
    public TbRichTextView q;
    public ConstrainImageGroup r;
    public View s;
    public View t;
    public View u;
    public View v;
    public ImageView w;
    public View x;
    public ImageView y;
    public ImageView z;

    /* loaded from: classes3.dex */
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
                this.a.W.playAnimation();
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
        this.c = true;
        this.U = Boolean.FALSE;
        if (tbPageContext == null || view2 == null) {
            return;
        }
        this.b = view2;
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f09223e);
        this.e = view2.findViewById(R.id.obfuscated_res_0x7f0903dc);
        this.f = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917ee);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09256c);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09256d);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09253a);
        this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092564);
        this.F = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e0c);
        this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092558);
        this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092397);
        this.s = view2.findViewById(R.id.obfuscated_res_0x7f0917da);
        this.t = view2.findViewById(R.id.obfuscated_res_0x7f0917d7);
        this.u = view2.findViewById(R.id.obfuscated_res_0x7f0917cd);
        this.v = view2.findViewById(R.id.obfuscated_res_0x7f0917cb);
        this.w = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917d8);
        this.A = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917d9);
        this.B = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917ce);
        this.C = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917cf);
        AgreeView agreeView = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f0917cc);
        this.D = agreeView;
        agreeView.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
        this.D.setNormalColorResourceId(R.color.CAM_X0109);
        this.D.u(true);
        this.x = view2.findViewById(R.id.obfuscated_res_0x7f091834);
        this.y = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a01);
        this.z = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a02);
        this.o0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09239d);
        RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c18);
        this.k0 = relativeLayout;
        ms4 d = ms4.d(relativeLayout);
        d.n(R.string.J_X04);
        d.f(R.color.CAM_X0204);
        RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c06);
        this.l0 = relativeLayout2;
        ms4 d2 = ms4.d(relativeLayout2);
        d2.n(R.string.J_X07);
        d2.f(R.color.CAM_X0905);
        this.m0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09232a);
        this.n0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09237b);
        this.s.setVisibility(8);
        this.x.setVisibility(8);
        this.y.setVisibility(0);
        this.z.setVisibility(0);
        this.J = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917d1);
        lo4 lo4Var = new lo4();
        lo4Var.b = 5;
        lo4Var.h = 8;
        lo4Var.g = 2;
        lo4Var.f = i;
        this.p = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0916c3);
        HeadPendantView headPendantView = (HeadPendantView) view2.findViewById(R.id.obfuscated_res_0x7f09188b);
        this.G = headPendantView;
        headPendantView.setHasPendantStyle();
        if (this.G.getHeadView() != null) {
            this.G.getHeadView().setIsRound(true);
            this.G.getHeadView().setDrawBorder(true);
            this.G.getHeadView().setPlaceHolder(1);
        }
        this.H = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f091e72);
        this.I = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f091e73);
        this.q = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091bd2);
        this.r = (ConstrainImageGroup) view2.findViewById(R.id.obfuscated_res_0x7f0909f0);
        this.E = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0909f2);
        this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919be);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919bf);
        this.r.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be));
        this.r.setSingleImageRatio(0.75d);
        this.r.setImageProcessor(new dh5(3));
        rv7 rv7Var = new rv7(this.q.getLayoutStrategy());
        rv7Var.j(qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
        rv7Var.o(TbConfig.getPostLineSpace(), 1.0f);
        this.q.setLayoutStrategy(rv7Var);
        this.q.setIsNeedResizeEmotion(true);
        this.q.setTextSize(TbConfig.getContentSize());
        this.p.setIsRound(true);
        this.p.setGodIconWidth(R.dimen.tbds36);
        this.p.setPlaceHolder(1);
        this.q.setDisplayImage(this.c, false);
        this.q.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d08e5);
        this.K = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917fd);
        this.L = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091830);
        this.M = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091831);
        this.N = view2.findViewById(R.id.obfuscated_res_0x7f09182f);
        this.O = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091832);
        this.P = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09182e);
        this.Q = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090265);
        this.R = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090a0a);
        this.S = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a0b);
        this.V = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091989);
        this.T = (PbFloorComplaint) view2.findViewById(R.id.obfuscated_res_0x7f0917d0);
        if (this.U.booleanValue()) {
            this.T.setVisibility(0);
        } else {
            this.T.setVisibility(8);
        }
        this.W = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f09244e);
        this.X = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f0917d6);
        this.Y = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f0917d4);
        this.Z = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917d5);
        this.Y.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
        this.Y.setNormalColorResourceId(R.color.CAM_X0109);
        this.Y.u(false);
        this.Y.setAgreeAlone(true);
        this.Y.setStatisticData(lo4Var);
        this.a0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f091836);
        this.b0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092565);
        this.c0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090449);
        FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0923f8);
        this.d0 = frameLayout;
        ey7 ey7Var = new ey7(tbPageContext, frameLayout);
        this.e0 = ey7Var;
        ey7Var.f = 3;
        this.f0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092428);
        this.g0 = (VirtualImageStatusTip) view2.findViewById(R.id.obfuscated_res_0x7f0925a2);
        this.h0 = (HeadCustomImageView) view2.findViewById(R.id.obfuscated_res_0x7f09258b);
        this.i0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f09258c);
        this.j0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091dd2);
        this.j = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917b1);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e0.d();
            PbFloorComplaint pbFloorComplaint = this.T;
            if (pbFloorComplaint != null) {
                pbFloorComplaint.setBackgroundColor(R.color.CAM_X0206);
                ms4 d = ms4.d(this.T);
                d.m(0);
                d.n(R.string.J_X05);
                d.f(R.color.CAM_X0206);
                this.T.b();
            }
        }
    }

    public void c(int i) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (tBLottieAnimationView = this.W) == null) {
            return;
        }
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.W.setVisibility(0);
                if (this.W.isAnimating()) {
                    return;
                }
                this.W.setSpeed(0.8f);
                this.W.setRepeatCount(-1);
                this.W.post(new a(this));
                return;
            }
            this.W.setVisibility(8);
            if (this.W.isAnimating()) {
                this.W.cancelAnimation();
            }
        }
    }

    public void e(boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.e0.f(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Q.getLayoutParams();
            if (z) {
                this.d0.setVisibility(0);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f0923f8);
            } else {
                this.d0.setVisibility(8);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f090f8d);
            }
            this.Q.setLayoutParams(layoutParams);
            b();
        }
    }
}
