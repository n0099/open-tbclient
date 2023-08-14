package com.baidu.tieba.pb.pb.main;

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
import com.baidu.card.view.HeadWorldCupFlagLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.afx.TbAlphaVideo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
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
import com.baidu.tieba.aj9;
import com.baidu.tieba.hg9;
import com.baidu.tieba.lz5;
import com.baidu.tieba.view.VirtualImageStatusTip;
import com.baidu.tieba.w05;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes7.dex */
public class PbTopCommenFloorItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public ImageView B;
    public HeadPendantView C;
    public UserIconBox D;
    public UserIconBox E;
    public ImageView F;
    public TextView G;
    public SimpleDraweeView H;
    public LinearLayout I;
    public LinearLayout J;
    public TextView K;
    public View L;
    public TextView M;
    public ImageView N;
    public LinearLayout O;
    public LinearLayout P;
    public TextView Q;
    public PbFloorComplaint R;
    public Boolean S;

    /* renamed from: T  reason: collision with root package name */
    public ImageView f1147T;
    public TBLottieAnimationView U;
    public ViewGroup V;
    public AgreeView W;
    public ImageView X;
    public ViewGroup Y;
    public TextView Z;
    public int a;
    public TextView a0;
    public RelativeLayout b;
    public FrameLayout b0;
    public View c;
    public aj9 c0;
    public boolean d;
    public FrameLayout d0;
    public View e;
    public VirtualImageStatusTip e0;
    public View f;
    public HeadCustomImageView f0;
    public LinearLayout g;
    public FrameLayout g0;
    public TextView h;
    public LinearLayout h0;
    public TextView i;
    public RelativeLayout i0;
    public TextView j;
    public RelativeLayout j0;
    public TbImageView k;
    public RelativeLayout k0;
    public TextView l;
    public TextView l0;
    public TextView m;
    public TextView m0;
    public TextView n;
    public TextView n0;
    public TextView o;
    public TBLottieAnimationView o0;
    public TextView p;
    public TbImageView p0;
    public HeadImageView q;
    public HeadWorldCupFlagLayout q0;
    public TbRichTextView r;
    public RelativeLayout s;
    public TbAlphaVideo t;
    public ConstrainImageGroup u;
    public View v;
    public View w;
    public ImageView x;
    public ImageView y;
    public AgreeView z;

    /* loaded from: classes7.dex */
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
                this.a.U.playAnimation();
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
        this.S = Boolean.FALSE;
        if (tbPageContext != null && view2 != null) {
            this.c = view2;
            this.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091aaa);
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f0925f2);
            this.f = view2.findViewById(R.id.bottom_divider_line);
            this.g = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091ac9);
            this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092962);
            this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092963);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09292d);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09295a);
            this.B = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ff8);
            this.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09294e);
            this.p = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092768);
            this.v = view2.findViewById(R.id.obfuscated_res_0x7f091ab2);
            AgreeView agreeView = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f091aa4);
            this.z = agreeView;
            agreeView.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.z.setNormalColorResourceId(R.color.CAM_X0109);
            this.z.z(true);
            this.w = view2.findViewById(R.id.obfuscated_res_0x7f091b15);
            this.x = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091cf8);
            this.y = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091cf9);
            this.n0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092771);
            RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091f56);
            this.j0 = relativeLayout;
            EMManager.from(relativeLayout).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0204);
            RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091f3d);
            this.k0 = relativeLayout2;
            EMManager.from(relativeLayout2).setCorner(R.string.J_X07).setBackGroundColor(R.color.CAM_X0905);
            this.l0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0926f3);
            this.m0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09274c);
            this.v.setVisibility(8);
            this.w.setVisibility(8);
            this.x.setVisibility(0);
            this.y.setVisibility(0);
            this.F = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091aa9);
            w05 w05Var = new w05();
            w05Var.b = 5;
            w05Var.h = 8;
            w05Var.g = 2;
            w05Var.f = i;
            this.q = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f091982);
            HeadPendantView headPendantView = (HeadPendantView) view2.findViewById(R.id.obfuscated_res_0x7f091b60);
            this.C = headPendantView;
            headPendantView.setHasPendantStyle();
            if (this.C.getHeadView() != null) {
                this.C.getHeadView().setIsRound(true);
                this.C.getHeadView().setDrawBorder(true);
                this.C.getHeadView().setPlaceHolder(1);
            }
            this.D = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f0921df);
            this.E = (UserIconBox) view2.findViewById(R.id.obfuscated_res_0x7f0921e0);
            this.r = (TbRichTextView) view2.findViewById(R.id.obfuscated_res_0x7f091f04);
            this.s = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091d02);
            this.t = (TbAlphaVideo) view2.findViewById(R.id.obfuscated_res_0x7f09015c);
            this.u = (ConstrainImageGroup) view2.findViewById(R.id.obfuscated_res_0x7f090b6f);
            this.A = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b71);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091cb0);
            this.n = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091cb1);
            this.u.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be));
            this.u.setSingleImageRatio(0.75d);
            this.u.setImageProcessor(new lz5(3));
            hg9 hg9Var = new hg9(this.r.getLayoutStrategy());
            hg9Var.p(TbConfig.getPostLineSpace(), 1.0f);
            this.r.setLayoutStrategy(hg9Var);
            this.r.setIsNeedResizeEmotion(true);
            this.r.setTextSize(TbConfig.getContentSize());
            this.q.setIsRound(true);
            this.q.setGodIconWidth(R.dimen.tbds36);
            this.q.setPlaceHolder(1);
            this.r.setDisplayImage(this.d, false);
            this.r.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d0a0e);
            this.G = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091ad9);
            this.H = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f091a9f);
            this.I = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091a9e);
            this.J = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b11);
            this.K = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b12);
            this.L = view2.findViewById(R.id.obfuscated_res_0x7f091b10);
            this.M = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b13);
            this.N = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091b0f);
            this.O = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09027c);
            this.P = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090b8b);
            this.Q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b8c);
            this.f1147T = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091c73);
            this.R = (PbFloorComplaint) view2.findViewById(R.id.obfuscated_res_0x7f091aa8);
            if (this.S.booleanValue()) {
                this.R.setVisibility(0);
            } else {
                this.R.setVisibility(8);
            }
            this.U = (TBLottieAnimationView) view2.findViewById(R.id.user_living_lottie);
            this.V = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f091aae);
            this.W = (AgreeView) view2.findViewById(R.id.obfuscated_res_0x7f091aac);
            this.X = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091aad);
            this.W.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
            this.W.setNormalColorResourceId(R.color.CAM_X0109);
            this.W.z(false);
            this.W.setAgreeAlone(true);
            this.W.setStatisticData(w05Var);
            this.Y = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f091b17);
            this.Z = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09295b);
            this.a0 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0904e7);
            this.b0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f0927d0);
            aj9 aj9Var = new aj9(tbPageContext, this.b0);
            this.c0 = aj9Var;
            aj9Var.f = 3;
            this.d0 = (FrameLayout) view2.findViewById(R.id.user_container);
            this.e0 = (VirtualImageStatusTip) view2.findViewById(R.id.obfuscated_res_0x7f092997);
            this.f0 = (HeadCustomImageView) view2.findViewById(R.id.obfuscated_res_0x7f092980);
            this.g0 = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f092981);
            this.h0 = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f092130);
            this.i0 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091f58);
            this.k = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091a84);
            f(tbPageContext);
            this.p0 = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091aa1);
            this.q0 = (HeadWorldCupFlagLayout) view2.findViewById(R.id.world_cup_flag);
        }
    }

    public void d(int i) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (tBLottieAnimationView = this.U) != null) {
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c0.e();
            PbFloorComplaint pbFloorComplaint = this.R;
            if (pbFloorComplaint != null) {
                pbFloorComplaint.setBackgroundColor(R.color.CAM_X0206);
                EMManager.from(this.R).setCardType(0).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
                this.R.b();
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.o0 != null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                this.o0.setImageAssetsFolder("lottie_reactions_guide_left_img_dark");
            } else {
                this.o0.setImageAssetsFolder("lottie_reactions_guide_left_img");
            }
            SkinManager.setLottieAnimation(this.o0, R.raw.lottie_reactions_guide_left);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.U.setVisibility(0);
                if (!this.U.isAnimating()) {
                    this.U.setSpeed(0.8f);
                    this.U.setRepeatCount(-1);
                    this.U.post(new a(this));
                    return;
                }
                return;
            }
            this.U.setVisibility(8);
            if (this.U.isAnimating()) {
                this.U.cancelAnimation();
            }
        }
    }

    public final void f(@NonNull TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tbPageContext) == null) {
            this.o0 = new TBLottieAnimationView(tbPageContext.getPageActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds650), BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds100));
            layoutParams.setMargins(BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds90), 0, 0, BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds10));
            layoutParams.addRule(8, R.id.obfuscated_res_0x7f0911a3);
            this.b.addView(this.o0, layoutParams);
            g();
            this.o0.setVisibility(8);
        }
    }

    public void h(boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.c0.g(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.O.getLayoutParams();
            if (z) {
                this.b0.setVisibility(0);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f0927d0);
            } else {
                this.b0.setVisibility(8);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f0911a3);
            }
            this.O.setLayoutParams(layoutParams);
            c();
        }
    }
}
