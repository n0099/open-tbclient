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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.HeadCustomImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.view.VirtualImageStatusTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.eg5;
import com.repackage.ew7;
import com.repackage.pi;
import com.repackage.tt7;
import com.repackage.un4;
import com.repackage.vr4;
/* loaded from: classes3.dex */
public class PbCommenFloorItemViewHolder extends TypeAdapter.ViewHolder {
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
    public View K;
    public TextView L;
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
    public int X;
    public int Y;
    public TBLottieAnimationView Z;
    public int a;
    public ViewGroup a0;
    public View b;
    public AgreeView b0;
    public boolean c;
    public ImageView c0;
    public View d;
    public ViewGroup d0;
    public LinearLayout e;
    public TextView e0;
    public TextView f;
    public TextView f0;
    public TextView g;
    public ImageView g0;
    public TextView h;
    public FrameLayout h0;
    public TextView i;
    public MaskView i0;
    public TextView j;
    public ew7 j0;
    public TextView k;
    public FrameLayout k0;
    public AgreeView l;
    public VirtualImageStatusTip l0;
    public HeadImageView m;
    public HeadCustomImageView m0;
    public TbRichTextView n;
    public FrameLayout n0;
    public ConstrainImageGroup o;
    public LinearLayout o0;
    public View p;
    public SubPbLayout q;
    public TextView r;
    public TextView s;
    public ImageView t;
    public ImageView u;
    public View v;
    public View w;
    public View x;
    public View y;
    public ImageView z;

    /* loaded from: classes3.dex */
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
                this.a.Z.playAnimation();
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
        this.V = Boolean.FALSE;
        this.X = -1;
        if (tbPageContext == null || view2 == null) {
            return;
        }
        this.b = view2;
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f09213f);
        this.e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091721);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092449);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092417);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092441);
        this.F = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090dc2);
        this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092435);
        this.p = view2.findViewById(R.id.obfuscated_res_0x7f091767);
        this.t = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09192e);
        this.u = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09192f);
        AgreeView agreeView = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f09159b);
        this.l = agreeView;
        agreeView.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
        this.l.setNormalColorResourceId(R.color.CAM_X0109);
        this.l.u(false);
        this.v = view2.findViewById(R.id.obfuscated_res_0x7f09170e);
        this.w = view2.findViewById(R.id.obfuscated_res_0x7f09170b);
        this.x = view2.findViewById(R.id.obfuscated_res_0x7f091701);
        this.y = view2.findViewById(R.id.obfuscated_res_0x7f0916ff);
        this.z = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09170c);
        this.A = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09170d);
        this.B = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091702);
        this.C = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091703);
        AgreeView agreeView2 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f091700);
        this.D = agreeView2;
        agreeView2.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
        this.D.setNormalColorResourceId(R.color.CAM_X0109);
        this.D.u(true);
        this.v.setVisibility(8);
        this.p.setVisibility(0);
        this.t.setVisibility(0);
        this.u.setVisibility(0);
        this.l.setVisibility(0);
        this.J = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091705);
        this.Y = i;
        un4 un4Var = new un4();
        un4Var.b = 5;
        un4Var.h = 8;
        un4Var.g = 2;
        un4Var.f = i;
        this.l.setStatisticData(un4Var);
        this.m = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0915fd);
        HeadPendantView headPendantView = (HeadPendantView) view2.findViewById(R.id.obfuscated_res_0x7f0917bd);
        this.G = headPendantView;
        headPendantView.setHasPendantStyle();
        if (this.G.getHeadView() != null) {
            this.G.getHeadView().setIsRound(true);
            this.G.getHeadView().setDrawBorder(true);
            this.G.getHeadView().setPlaceHolder(1);
        }
        this.H = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f091d85);
        this.I = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f091d86);
        this.n = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091af1);
        this.q = (SubPbLayout) view2.findViewById(R.id.obfuscated_res_0x7f09175e);
        this.r = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091768);
        this.r.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0107), null), (Drawable) null);
        this.r.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        this.r.setTextSize(0, pi.f(TbadkCoreApplication.getInst(), R.dimen.T_X07));
        this.s = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091766);
        this.o = (ConstrainImageGroup) view2.findViewById(R.id.obfuscated_res_0x7f0909b6);
        this.K = view2.findViewById(R.id.obfuscated_res_0x7f0916dc);
        this.E = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0909b7);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0918ec);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0918ed);
        this.o.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be));
        this.o.setSingleImageRatio(0.75d);
        this.o.setImageProcessor(new eg5(3));
        tt7 tt7Var = new tt7(this.n.getLayoutStrategy());
        tt7Var.j(pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
        tt7Var.o(TbConfig.getPostLineSpace(), 1.0f);
        this.n.setLayoutStrategy(tt7Var);
        this.n.setIsNeedResizeEmotion(true);
        this.n.setTextSize(TbConfig.getContentSize());
        this.m.setIsRound(true);
        this.m.setGodIconWidth(R.dimen.tbds36);
        this.m.setPlaceHolder(1);
        this.n.setDisplayImage(this.c, false);
        this.n.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d08b9);
        this.L = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091730);
        this.M = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091763);
        this.N = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091764);
        this.O = view2.findViewById(R.id.obfuscated_res_0x7f091762);
        this.P = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091765);
        this.Q = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091761);
        this.R = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090258);
        this.S = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0909cf);
        this.T = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0909d0);
        this.W = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0918b6);
        this.U = (PbFloorComplaint) view2.findViewById(R.id.obfuscated_res_0x7f091704);
        if (this.V.booleanValue()) {
            this.U.setVisibility(0);
        } else {
            this.U.setVisibility(8);
        }
        this.Z = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f09232d);
        this.a0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f09170a);
        this.b0 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f091708);
        this.c0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091709);
        this.b0.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
        this.b0.setNormalColorResourceId(R.color.CAM_X0109);
        this.b0.u(false);
        this.b0.setAgreeAlone(true);
        this.b0.setStatisticData(un4Var);
        this.d0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f091769);
        this.e0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092442);
        this.f0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09042f);
        this.g0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091760);
        FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0922e4);
        this.h0 = frameLayout;
        ew7 ew7Var = new ew7(tbPageContext, frameLayout);
        this.j0 = ew7Var;
        ew7Var.f = 3;
        this.i0 = (MaskView) view2.findViewById(R.id.obfuscated_res_0x7f0913fa);
        this.k0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092314);
        this.l0 = (VirtualImageStatusTip) view2.findViewById(R.id.obfuscated_res_0x7f09247c);
        this.m0 = (HeadCustomImageView) view2.findViewById(R.id.obfuscated_res_0x7f092465);
        this.n0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092466);
        this.o0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091ce5);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.j0.d();
            MaskView maskView = this.i0;
            if (maskView != null) {
                maskView.f();
            }
            PbFloorComplaint pbFloorComplaint = this.U;
            if (pbFloorComplaint != null) {
                pbFloorComplaint.setBackgroundColor(R.color.CAM_X0206);
                vr4 d = vr4.d(this.U);
                d.m(0);
                d.n(R.string.J_X05);
                d.f(R.color.CAM_X0206);
                this.U.b();
            }
        }
    }

    public void d(int i) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (tBLottieAnimationView = this.Z) == null) {
            return;
        }
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.Z.setVisibility(0);
                if (this.Z.isAnimating()) {
                    return;
                }
                this.Z.setSpeed(0.8f);
                this.Z.setRepeatCount(-1);
                this.Z.post(new a(this));
                return;
            }
            this.Z.setVisibility(8);
            if (this.Z.isAnimating()) {
                this.Z.cancelAnimation();
            }
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && z) {
            un4 un4Var = new un4();
            un4Var.b = 12;
            un4Var.h = 9;
            un4Var.g = 3;
            un4Var.f = this.Y;
            this.l.setStatisticData(un4Var);
        }
    }

    public void g(boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.j0.f(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.R.getLayoutParams();
            if (z) {
                this.h0.setVisibility(0);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f0922e4);
            } else {
                this.h0.setVisibility(8);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f090f3b);
            }
            this.R.setLayoutParams(layoutParams);
            MaskView maskView = this.i0;
            if (maskView != null) {
                maskView.setVisibility(8);
            }
            c();
        }
    }
}
