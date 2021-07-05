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
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.r.q.f;
import d.a.s0.h2.k.e.a1.d;
import d.a.s0.h2.k.e.e;
/* loaded from: classes5.dex */
public class PbCommenFloorItemViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public TextView B;
    public AgreeView C;
    public TextView D;
    public ImageView E;
    public HeadPendantView F;
    public UserIconBox G;
    public UserIconBox H;
    public ImageView I;
    public View J;
    public TextView K;
    public LinearLayout L;
    public TextView M;
    public View N;
    public TextView O;
    public ImageView P;
    public LinearLayout Q;
    public LinearLayout R;
    public TextView S;
    public ImageView T;
    public int U;
    public int V;
    public TBLottieAnimationView W;
    public ViewGroup X;
    public AgreeView Y;
    public ImageView Z;

    /* renamed from: a  reason: collision with root package name */
    public int f19161a;
    public ViewGroup a0;

    /* renamed from: b  reason: collision with root package name */
    public View f19162b;
    public TextView b0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f19163c;
    public TextView c0;

    /* renamed from: d  reason: collision with root package name */
    public View f19164d;
    public ImageView d0;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19165e;
    public FrameLayout e0;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19166f;
    public MaskView f0;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19167g;
    public d g0;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19168h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f19169i;
    public TextView j;
    public AgreeView k;
    public HeadImageView l;
    public TbRichTextView m;
    public ConstrainImageGroup n;
    public View o;
    public SubPbLayout p;
    public TextView q;
    public TextView r;
    public ImageView s;
    public ImageView t;
    public View u;
    public View v;
    public View w;
    public View x;
    public ImageView y;
    public TextView z;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f19170e;

        public a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19170e = pbCommenFloorItemViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19170e.W.playAnimation();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbCommenFloorItemViewHolder(TbPageContext tbPageContext, View view, int i2) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19161a = 3;
        this.f19163c = true;
        this.U = -1;
        if (tbPageContext == null || view == null) {
            return;
        }
        this.f19162b = view;
        this.f19164d = view.findViewById(R.id.top_divider_line);
        this.f19165e = (TextView) view.findViewById(R.id.view_user_name);
        this.f19166f = (TextView) view.findViewById(R.id.view_author_tip);
        this.f19167g = (TextView) view.findViewById(R.id.view_post_time);
        this.E = (ImageView) view.findViewById(R.id.icon_forum_level);
        this.j = (TextView) view.findViewById(R.id.view_location);
        this.o = view.findViewById(R.id.pb_post_reply_container);
        this.s = (ImageView) view.findViewById(R.id.post_info_commont_img);
        this.t = (ImageView) view.findViewById(R.id.post_info_share_img);
        AgreeView agreeView = (AgreeView) view.findViewById(R.id.new_pb_floor_praise_view);
        this.k = agreeView;
        agreeView.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
        this.k.setNormalColorResourceId(R.color.CAM_X0109);
        this.k.h(false);
        this.u = view.findViewById(R.id.pb_floor_trisection_area);
        this.v = view.findViewById(R.id.pb_floor_share_container);
        this.w = view.findViewById(R.id.pb_floor_comment_container);
        this.x = view.findViewById(R.id.pb_floor_agree_container);
        this.y = (ImageView) view.findViewById(R.id.pb_floor_share_img);
        this.z = (TextView) view.findViewById(R.id.pb_floor_share_text);
        this.A = (ImageView) view.findViewById(R.id.pb_floor_comment_img);
        this.B = (TextView) view.findViewById(R.id.pb_floor_comment_text);
        AgreeView agreeView2 = (AgreeView) view.findViewById(R.id.pb_floor_agree_view);
        this.C = agreeView2;
        agreeView2.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
        this.C.setNormalColorResourceId(R.color.CAM_X0109);
        this.C.h(true);
        this.u.setVisibility(8);
        this.o.setVisibility(0);
        this.s.setVisibility(0);
        this.t.setVisibility(0);
        this.k.setVisibility(0);
        this.I = (ImageView) view.findViewById(R.id.pb_floor_feedback);
        this.V = i2;
        f fVar = new f();
        fVar.f55932b = 5;
        fVar.f55938h = 8;
        fVar.f55937g = 2;
        fVar.f55936f = i2;
        this.k.setStatisticData(fVar);
        this.l = (HeadImageView) view.findViewById(R.id.normal_user_photo);
        HeadPendantView headPendantView = (HeadPendantView) view.findViewById(R.id.pendant_user_photo);
        this.F = headPendantView;
        headPendantView.setHasPendantStyle();
        if (this.F.getHeadView() != null) {
            this.F.getHeadView().setIsRound(true);
            this.F.getHeadView().setDrawBorder(true);
            this.F.getHeadView().setPlaceHolder(1);
        }
        this.G = (UserIconBox) view.findViewById(R.id.show_icon_vip);
        this.H = (UserIconBox) view.findViewById(R.id.show_icon_yinji);
        this.m = (TbRichTextView) view.findViewById(R.id.richText);
        this.p = (SubPbLayout) view.findViewById(R.id.pb_post_footer_layout);
        this.q = (TextView) view.findViewById(R.id.pb_post_reply_count);
        this.q.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0107), null), (Drawable) null);
        this.q.setCompoundDrawablePadding((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds4));
        this.q.setTextSize(0, l.g(TbadkCoreApplication.getInst(), R.dimen.T_X07));
        this.r = (TextView) view.findViewById(R.id.pb_post_reply);
        this.n = (ConstrainImageGroup) view.findViewById(R.id.floor_images_content);
        this.J = view.findViewById(R.id.pb_bottom_line);
        this.D = (TextView) view.findViewById(R.id.floor_num);
        this.f19168h = (TextView) view.findViewById(R.id.point_between_floor_and_time);
        this.f19169i = (TextView) view.findViewById(R.id.point_between_time_and_locate);
        this.n.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds16));
        this.n.setSingleImageRatio(0.75d);
        this.n.setImageProcessor(new d.a.r0.b1.j.f(3));
        e eVar = new e(this.m.getLayoutStrategy());
        eVar.j(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
        eVar.o(TbConfig.getPostLineSpace(), 1.0f);
        this.m.setLayoutStrategy(eVar);
        this.m.setIsNeedResizeEmotion(true);
        this.m.setTextSize(TbConfig.getContentSize());
        this.l.setIsRound(true);
        this.l.setGodIconWidth(R.dimen.tbds31);
        this.l.setPlaceHolder(1);
        this.m.setDisplayImage(this.f19163c, false);
        this.m.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.K = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.L = (LinearLayout) view.findViewById(R.id.pb_post_recommend_live_layout);
        this.M = (TextView) view.findViewById(R.id.pb_post_recommend_live_prefix_tv);
        this.N = view.findViewById(R.id.pb_post_recommend_live_divider);
        this.O = (TextView) view.findViewById(R.id.pb_post_recommend_live_title);
        this.P = (ImageView) view.findViewById(R.id.pb_post_recommend_live_arrow);
        this.Q = (LinearLayout) view.findViewById(R.id.all_content);
        this.R = (LinearLayout) view.findViewById(R.id.fold_op_area);
        this.S = (TextView) view.findViewById(R.id.fold_title);
        this.T = (ImageView) view.findViewById(R.id.pic_comment_god);
        this.W = (TBLottieAnimationView) view.findViewById(R.id.user_living_lottie);
        this.X = (ViewGroup) view.findViewById(R.id.pb_floor_right_top_layout);
        this.Y = (AgreeView) view.findViewById(R.id.pb_floor_right_top_agree_view);
        this.Z = (ImageView) view.findViewById(R.id.pb_floor_right_top_feedback);
        this.Y.setResourceId(R.raw.pb_lottie_agree, R.raw.pb_lottie_disagree);
        this.Y.setNormalColorResourceId(R.color.CAM_X0109);
        this.Y.h(false);
        this.Y.setAgreeAlone(true);
        this.a0 = (ViewGroup) view.findViewById(R.id.pb_post_reply_layout_above);
        this.b0 = (TextView) view.findViewById(R.id.view_post_time_above);
        this.c0 = (TextView) view.findViewById(R.id.btn_post_above);
        this.d0 = (ImageView) view.findViewById(R.id.pb_post_op_more);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.ueg_root);
        this.e0 = frameLayout;
        d dVar = new d(tbPageContext, frameLayout);
        this.g0 = dVar;
        dVar.f60326f = 3;
        this.f0 = (MaskView) view.findViewById(R.id.mask_view_op);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g0.d();
            MaskView maskView = this.f0;
            if (maskView != null) {
                maskView.c();
            }
        }
    }

    public void d(int i2) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (tBLottieAnimationView = this.W) == null) {
            return;
        }
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
    }

    public void e(boolean z) {
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

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && z) {
            f fVar = new f();
            fVar.f55932b = 12;
            fVar.f55938h = 9;
            fVar.f55937g = 3;
            fVar.f55936f = this.V;
            this.k.setStatisticData(fVar);
        }
    }

    public void g(boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.g0.f(str);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Q.getLayoutParams();
            if (z) {
                this.e0.setVisibility(0);
                layoutParams.addRule(3, R.id.ueg_root);
            } else {
                this.e0.setVisibility(8);
                layoutParams.addRule(3, R.id.item_head_owner_root);
            }
            this.Q.setLayoutParams(layoutParams);
            MaskView maskView = this.f0;
            if (maskView != null) {
                maskView.setVisibility(8);
            }
            c();
        }
    }
}
