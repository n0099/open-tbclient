package com.baidu.tieba.pb.pb.main;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.afx.TbAlphaVideo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.HeadCustomImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.editortools.meme.view.SpriteMemeReplyView;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.level.TbLevelView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.iw4;
import com.baidu.tieba.kx5;
import com.baidu.tieba.m2a;
import com.baidu.tieba.mz9;
import com.baidu.tieba.pb.feedback.AigcFeedbackView;
import com.baidu.tieba.pb.feedback.fold.AigcFeedbackFoldView;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.view.VirtualImageStatusTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes7.dex */
public class PbCommenFloorItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public TextView A0;
    public View B;
    public TextView B0;
    public AgreeView C;
    public LinearLayout C0;
    public TextView D;
    public RelativeLayout D0;
    public TbLevelView E;
    public LinearLayout E0;
    public HeadPendantView F;
    public AigcFeedbackView F0;
    public UserIconBox G;
    public AigcFeedbackFoldView G0;
    public UserIconBox H;
    public LinearLayout H0;
    public ImageView I;
    public SpriteMemeReplyView I0;
    public View J;
    public TextView K;
    public SimpleDraweeView L;
    public LinearLayout M;
    public LinearLayout N;
    public TextView O;
    public View P;
    public TextView Q;
    public ImageView R;
    public LinearLayout S;

    /* renamed from: T  reason: collision with root package name */
    public LinearLayout f1137T;
    public TextView U;
    public PbFloorComplaint V;
    public Boolean W;
    public ImageView X;
    public TbImageView Y;
    public int Z;
    public int a;
    public int a0;
    public RelativeLayout b;
    public TBLottieAnimationView b0;
    public View c;
    public ViewGroup c0;
    public boolean d;
    public AgreeView d0;
    public View e;
    public ImageView e0;
    public LinearLayout f;
    public ViewGroup f0;
    public TextView g;
    public TextView g0;
    public TextView h;
    public TextView h0;
    public TextView i;
    public LinearLayout i0;
    public TbImageView j;
    public RelativeLayout j0;
    public TbImageView k;
    public EMTextView k0;
    public TextView l;
    public ImageView l0;
    public TextView m;
    public View m0;
    public TextView n;
    public View n0;
    public TextView o;
    public ImageView o0;
    public AgreeView p;
    public FrameLayout p0;
    public HeadImageView q;
    public MaskView q0;
    public TbRichTextView r;
    public m2a r0;
    public RelativeLayout s;
    public FrameLayout s0;
    public TbAlphaVideo t;
    public VirtualImageStatusTip t0;
    public ConstrainImageGroup u;
    public HeadCustomImageView u0;
    public View v;
    public FrameLayout v0;
    public SubPbLayout w;
    public LinearLayout w0;
    public TextView x;
    public TextView x0;
    public TextView y;
    public RelativeLayout y0;
    public ImageView z;
    public RelativeLayout z0;

    /* loaded from: classes7.dex */
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
        this.d = true;
        this.W = Boolean.FALSE;
        this.Z = -1;
        if (tbPageContext != null && view2 != null) {
            this.c = view2;
            this.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c2d);
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f092715);
            this.f = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091bd6);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092a6d);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092a6e);
            this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092a36);
            this.j = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f092a35);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092a63);
            this.E = (TbLevelView) view2.findViewById(R.id.forum_level_view);
            this.C0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c19);
            this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092a58);
            this.v = view2.findViewById(R.id.obfuscated_res_0x7f091c22);
            this.z = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091dee);
            this.A = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091def);
            AgreeView agreeView = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f091a22);
            this.p = agreeView;
            agreeView.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.p.setNormalColorResourceId(R.color.CAM_X0109);
            this.p.z(false);
            this.B = view2.findViewById(R.id.obfuscated_res_0x7f091bbf);
            AgreeView agreeView2 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f091bb1);
            this.C = agreeView2;
            agreeView2.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.C.setNormalColorResourceId(R.color.CAM_X0109);
            this.C.z(true);
            this.x0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092877);
            RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09204c);
            this.y0 = relativeLayout;
            EMManager.from(relativeLayout).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0204);
            RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f092032);
            this.z0 = relativeLayout2;
            EMManager.from(relativeLayout2).setCorner(R.string.J_X07).setBackGroundColor(R.color.CAM_X0905);
            this.A0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0901b2);
            this.B0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0927fa);
            this.B.setVisibility(8);
            this.v.setVisibility(0);
            this.z.setVisibility(0);
            this.A.setVisibility(0);
            this.p.setVisibility(0);
            this.I = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091bb6);
            this.a0 = i;
            iw4 iw4Var = new iw4();
            iw4Var.b = 5;
            iw4Var.h = 8;
            iw4Var.g = 2;
            iw4Var.f = i;
            this.p.setStatisticData(iw4Var);
            this.q = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a90);
            HeadPendantView headPendantView = (HeadPendantView) view2.findViewById(R.id.obfuscated_res_0x7f091c6d);
            this.F = headPendantView;
            headPendantView.setHasPendantStyle();
            if (this.F.getHeadView() != null) {
                this.F.getHeadView().setIsRound(true);
                this.F.getHeadView().setDrawBorder(true);
                this.F.getHeadView().setPlaceHolder(1);
            }
            this.G = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f0922dc);
            this.H = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f0922dd);
            this.r = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091ff8);
            this.s = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091df8);
            this.t = (TbAlphaVideo) view2.findViewById(R.id.obfuscated_res_0x7f090170);
            this.w = (SubPbLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c18);
            this.x = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091c23);
            this.x.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0107), null), (Drawable) null);
            this.x.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.x.setTextSize(0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X07));
            this.y = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091c21);
            this.u = (ConstrainImageGroup) view2.findViewById(R.id.obfuscated_res_0x7f090bc5);
            this.J = view2.findViewById(R.id.obfuscated_res_0x7f091b86);
            this.D = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090bc7);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091da6);
            this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091da7);
            this.u.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be));
            this.u.setSingleImageRatio(0.75d);
            this.u.setImageProcessor(new kx5(3));
            mz9 mz9Var = new mz9(this.r.getLayoutStrategy());
            mz9Var.p(TbConfig.getPostLineSpace(), 1.0f);
            this.r.setLayoutStrategy(mz9Var);
            this.r.setIsNeedResizeEmotion(true);
            this.r.setTextSize(TbConfig.getContentSize());
            this.q.setIsRound(true);
            this.q.setGodIconWidth(R.dimen.tbds36);
            this.q.setPlaceHolder(1);
            this.r.setDisplayImage(this.d, false);
            this.r.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d0a43);
            this.K = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091be6);
            this.L = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f091bad);
            this.M = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091bac);
            this.N = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c1e);
            this.O = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091c1f);
            this.P = view2.findViewById(R.id.obfuscated_res_0x7f091c1d);
            this.Q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091c20);
            this.R = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091c1c);
            this.S = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0902a8);
            this.f1137T = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090be4);
            this.U = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090be5);
            this.X = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091d62);
            this.Y = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091d63);
            this.V = (PbFloorComplaint) view2.findViewById(R.id.obfuscated_res_0x7f091bb5);
            if (this.W.booleanValue()) {
                this.V.setVisibility(0);
            } else {
                this.V.setVisibility(8);
            }
            this.b0 = (TBLottieAnimationView) view2.findViewById(R.id.user_living_lottie);
            this.c0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f091bbb);
            this.n0 = view2.findViewById(R.id.obfuscated_res_0x7f09272d);
            this.d0 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f091bb9);
            this.e0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091bba);
            this.i0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0908bb);
            this.j0 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0908b9);
            this.k0 = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f0908bd);
            this.l0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0908bc);
            this.m0 = view2.findViewById(R.id.obfuscated_res_0x7f090bc6);
            this.d0.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.d0.setNormalColorResourceId(R.color.CAM_X0109);
            this.d0.z(false);
            this.d0.setAgreeAlone(true);
            this.d0.setStatisticData(iw4Var);
            this.f0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f091c24);
            this.g0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092a64);
            this.h0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090524);
            this.o0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091c1b);
            this.p0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0928d6);
            m2a m2aVar = new m2a(tbPageContext, this.p0);
            this.r0 = m2aVar;
            m2aVar.f = 3;
            this.q0 = (MaskView) view2.findViewById(R.id.obfuscated_res_0x7f0917c2);
            this.s0 = (FrameLayout) view2.findViewById(R.id.user_container);
            this.t0 = (VirtualImageStatusTip) view2.findViewById(R.id.obfuscated_res_0x7f092aa2);
            this.u0 = (HeadCustomImageView) view2.findViewById(R.id.obfuscated_res_0x7f092a8b);
            this.v0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092a8c);
            this.w0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09222d);
            this.k = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091b92);
            this.D0 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090bc4);
            this.E0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090bcd);
            this.F0 = (AigcFeedbackView) view2.findViewById(R.id.obfuscated_res_0x7f090465);
            this.G0 = (AigcFeedbackFoldView) view2.findViewById(R.id.obfuscated_res_0x7f0901e8);
            this.H0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0902a9);
            this.I0 = (SpriteMemeReplyView) view2.findViewById(R.id.obfuscated_res_0x7f09237c);
        }
    }

    public void c(int i) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (tBLottieAnimationView = this.b0) != null) {
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && z) {
            iw4 iw4Var = new iw4();
            iw4Var.b = 12;
            iw4Var.h = 9;
            iw4Var.g = 3;
            iw4Var.f = this.a0;
            this.p.setStatisticData(iw4Var);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.r0.e();
            MaskView maskView = this.q0;
            if (maskView != null) {
                maskView.g();
            }
            PbFloorComplaint pbFloorComplaint = this.V;
            if (pbFloorComplaint != null) {
                pbFloorComplaint.setBackgroundColor(R.color.CAM_X0206);
                EMManager.from(this.V).setCardType(0).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
                this.V.b();
            }
            SpriteMemeReplyView spriteMemeReplyView = this.I0;
            if (spriteMemeReplyView != null) {
                spriteMemeReplyView.e();
            }
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

    public void f(boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.r0.g(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.S.getLayoutParams();
            if (z) {
                this.p0.setVisibility(0);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f0928d6);
            } else {
                this.p0.setVisibility(8);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f09122f);
            }
            this.S.setLayoutParams(layoutParams);
            MaskView maskView = this.q0;
            if (maskView != null) {
                maskView.setVisibility(8);
            }
            b();
        }
    }
}
