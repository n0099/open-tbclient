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
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.level.TbLevelView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.a16;
import com.baidu.tieba.h15;
import com.baidu.tieba.pb.feedback.AigcFeedbackView;
import com.baidu.tieba.pb.feedback.fold.AigcFeedbackFoldView;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.sq9;
import com.baidu.tieba.un9;
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
    public TBLottieAnimationView B0;
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
    public LinearLayout f1135T;
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
    public sq9 r0;
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
            this.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b48);
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f09262f);
            this.f = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091af1);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092994);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092995);
            this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09295c);
            this.j = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09295b);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09298c);
            this.E = (TbLevelView) view2.findViewById(R.id.forum_level_view);
            this.C0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b34);
            this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092981);
            this.v = view2.findViewById(R.id.obfuscated_res_0x7f091b3d);
            this.z = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091d09);
            this.A = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091d0a);
            AgreeView agreeView = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f09193f);
            this.p = agreeView;
            agreeView.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.p.setNormalColorResourceId(R.color.CAM_X0109);
            this.p.z(false);
            this.B = view2.findViewById(R.id.obfuscated_res_0x7f091ada);
            AgreeView agreeView2 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f091acc);
            this.C = agreeView2;
            agreeView2.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.C.setNormalColorResourceId(R.color.CAM_X0109);
            this.C.z(true);
            this.x0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0927a0);
            RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091f82);
            this.y0 = relativeLayout;
            EMManager.from(relativeLayout).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0204);
            RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091f68);
            this.z0 = relativeLayout2;
            EMManager.from(relativeLayout2).setCorner(R.string.J_X07).setBackGroundColor(R.color.CAM_X0905);
            this.A0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092720);
            this.B.setVisibility(8);
            this.v.setVisibility(0);
            this.z.setVisibility(0);
            this.A.setVisibility(0);
            this.p.setVisibility(0);
            this.I = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091ad1);
            this.a0 = i;
            h15 h15Var = new h15();
            h15Var.b = 5;
            h15Var.h = 8;
            h15Var.g = 2;
            h15Var.f = i;
            this.p.setStatisticData(h15Var);
            this.q = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0919ab);
            HeadPendantView headPendantView = (HeadPendantView) view2.findViewById(R.id.obfuscated_res_0x7f091b88);
            this.F = headPendantView;
            headPendantView.setHasPendantStyle();
            if (this.F.getHeadView() != null) {
                this.F.getHeadView().setIsRound(true);
                this.F.getHeadView().setDrawBorder(true);
                this.F.getHeadView().setPlaceHolder(1);
            }
            this.G = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f09220f);
            this.H = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f092210);
            this.r = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091f19);
            this.s = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091d13);
            this.t = (TbAlphaVideo) view2.findViewById(R.id.obfuscated_res_0x7f09015a);
            this.w = (SubPbLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b33);
            this.x = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b3e);
            this.x.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0107), null), (Drawable) null);
            this.x.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
            this.x.setTextSize(0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X07));
            this.y = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b3c);
            this.u = (ConstrainImageGroup) view2.findViewById(R.id.obfuscated_res_0x7f090b69);
            this.J = view2.findViewById(R.id.obfuscated_res_0x7f091aa1);
            this.D = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b6b);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091cc1);
            this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091cc2);
            this.u.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be));
            this.u.setSingleImageRatio(0.75d);
            this.u.setImageProcessor(new a16(3));
            un9 un9Var = new un9(this.r.getLayoutStrategy());
            un9Var.p(TbConfig.getPostLineSpace(), 1.0f);
            this.r.setLayoutStrategy(un9Var);
            this.r.setIsNeedResizeEmotion(true);
            this.r.setTextSize(TbConfig.getContentSize());
            this.q.setIsRound(true);
            this.q.setGodIconWidth(R.dimen.tbds36);
            this.q.setPlaceHolder(1);
            this.r.setDisplayImage(this.d, false);
            this.r.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d0a26);
            this.K = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b01);
            this.L = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f091ac8);
            this.M = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091ac7);
            this.N = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b39);
            this.O = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b3a);
            this.P = view2.findViewById(R.id.obfuscated_res_0x7f091b38);
            this.Q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b3b);
            this.R = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091b37);
            this.S = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09027e);
            this.f1135T = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090b87);
            this.U = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b88);
            this.X = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091c7d);
            this.Y = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091c7e);
            this.V = (PbFloorComplaint) view2.findViewById(R.id.obfuscated_res_0x7f091ad0);
            if (this.W.booleanValue()) {
                this.V.setVisibility(0);
            } else {
                this.V.setVisibility(8);
            }
            this.b0 = (TBLottieAnimationView) view2.findViewById(R.id.user_living_lottie);
            this.c0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f091ad6);
            this.n0 = view2.findViewById(R.id.obfuscated_res_0x7f092647);
            this.d0 = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f091ad4);
            this.e0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091ad5);
            this.i0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090863);
            this.j0 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090861);
            this.k0 = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090865);
            this.l0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090864);
            this.m0 = view2.findViewById(R.id.obfuscated_res_0x7f090b6a);
            this.d0.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.d0.setNormalColorResourceId(R.color.CAM_X0109);
            this.d0.z(false);
            this.d0.setAgreeAlone(true);
            this.d0.setStatisticData(h15Var);
            this.f0 = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f091b3f);
            this.g0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09298d);
            this.h0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0904ec);
            this.o0 = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091b36);
            this.p0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0927ff);
            sq9 sq9Var = new sq9(tbPageContext, this.p0);
            this.r0 = sq9Var;
            sq9Var.f = 3;
            this.q0 = (MaskView) view2.findViewById(R.id.obfuscated_res_0x7f0916f5);
            this.s0 = (FrameLayout) view2.findViewById(R.id.user_container);
            this.t0 = (VirtualImageStatusTip) view2.findViewById(R.id.obfuscated_res_0x7f0929c9);
            this.u0 = (HeadCustomImageView) view2.findViewById(R.id.obfuscated_res_0x7f0929b2);
            this.v0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0929b3);
            this.w0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09215f);
            this.k = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091aad);
            e(tbPageContext);
            this.D0 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090b68);
            this.E0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090b71);
            this.F0 = (AigcFeedbackView) view2.findViewById(R.id.obfuscated_res_0x7f090434);
            this.G0 = (AigcFeedbackFoldView) view2.findViewById(R.id.obfuscated_res_0x7f0901be);
            this.H0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09027f);
        }
    }

    public void c(int i) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (tBLottieAnimationView = this.b0) != null) {
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && z) {
            h15 h15Var = new h15();
            h15Var.b = 12;
            h15Var.h = 9;
            h15Var.g = 3;
            h15Var.f = this.a0;
            this.p.setStatisticData(h15Var);
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
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.B0 != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                this.B0.setImageAssetsFolder("lottie_reactions_guide_left_img_dark");
            } else {
                this.B0.setImageAssetsFolder("lottie_reactions_guide_left_img");
            }
            SkinManager.setLottieAnimation(this.B0, R.raw.lottie_reactions_guide_left);
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
            this.B0 = new TBLottieAnimationView(tbPageContext.getPageActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds650), BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds100));
            layoutParams.setMargins(BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds90), 0, 0, BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds10));
            layoutParams.addRule(8, R.id.obfuscated_res_0x7f0911ae);
            this.b.addView(this.B0, layoutParams);
            f();
            this.B0.setVisibility(8);
        }
    }

    public void h(boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.r0.g(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.S.getLayoutParams();
            if (z) {
                this.p0.setVisibility(0);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f0927ff);
            } else {
                this.p0.setVisibility(8);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f0911ae);
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
