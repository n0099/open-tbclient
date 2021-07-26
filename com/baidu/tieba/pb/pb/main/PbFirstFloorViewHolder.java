package com.baidu.tieba.pb.pb.main;

import android.graphics.Matrix;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.m.b;
import d.a.d.e.p.l;
import d.a.p0.s.q.b2;
import d.a.q0.h2.h.e;
import d.a.q0.h2.k.e.e1.a;
import d.a.q0.h2.k.e.f;
import d.a.q0.h2.k.e.r0;
import d.a.q0.h2.k.e.t;
/* loaded from: classes4.dex */
public class PbFirstFloorViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f19300a;

    /* renamed from: b  reason: collision with root package name */
    public View f19301b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f19302c;

    /* renamed from: d  reason: collision with root package name */
    public View f19303d;

    /* renamed from: e  reason: collision with root package name */
    public TbRichTextView f19304e;

    /* renamed from: f  reason: collision with root package name */
    public View f19305f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f19306g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f19307h;

    /* renamed from: i  reason: collision with root package name */
    public ThreadSkinView f19308i;
    public TextView j;
    public LinearLayout k;
    public TextView l;
    public AppletsCellView m;
    public LinearLayout n;
    public t o;
    public FrameLayout p;
    public a q;
    public ThreadForumEnterButtonContainer r;
    public PbBusinessPromotionContainer s;
    public d.a.q0.h2.k.e.h1.a t;
    public VoteView u;
    public TextView v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFirstFloorViewHolder(TbPageContext tbPageContext, View view, boolean z, int i2) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, Boolean.valueOf(z), Integer.valueOf(i2)};
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
        this.f19300a = 3;
        this.o = new t(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.f19302c = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -r0.f());
        this.f19302c.setImageMatrix(matrix);
        this.f19303d = view.findViewById(R.id.blank_view_above_rich_text);
        this.f19304e = (TbRichTextView) view.findViewById(R.id.richText);
        this.f19301b = view;
        int k = (((l.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.f19304e.getPaddingLeft()) - this.f19304e.getPaddingRight();
        f fVar = new f(this.f19304e.getLayoutStrategy());
        fVar.D = k;
        this.f19304e.setLayoutStrategy(fVar);
        this.f19307h = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(k - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i2);
        this.f19304e.getLayoutStrategy().q(min);
        this.f19304e.getLayoutStrategy().p((int) (min * 1.618f));
        this.f19304e.setIsNeedResizeEmotion(true);
        this.f19304e.setTextSize(TbConfig.getContentSize());
        this.f19304e.setDisplayImage(z, false);
        this.f19304e.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.f19305f = view.findViewById(R.id.divider_bottom_first_floor);
        this.f19306g = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.f19308i = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.k = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.j = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.m = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.n = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        this.l = (TextView) view.findViewById(R.id.pb_tail_text);
        ThreadForumEnterButtonContainer threadForumEnterButtonContainer = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.r = threadForumEnterButtonContainer;
        threadForumEnterButtonContainer.setFrom(1);
        this.t = new d.a.q0.h2.k.e.h1.a(tbPageContext);
        this.s = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.p = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
        VoteView voteView = (VoteView) view.findViewById(R.id.vote_view);
        this.u = voteView;
        voteView.setPageContext(tbPageContext);
        this.v = (TextView) view.findViewById(R.id.tv_youngster_tip);
    }

    public void b(boolean z, int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (view = this.f19303d) == null) {
            return;
        }
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.height = i2;
            this.f19303d.setLayoutParams(layoutParams);
            this.f19303d.setVisibility(0);
            return;
        }
        view.setVisibility(8);
    }

    public void c(@NonNull e eVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{eVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.r == null || eVar == null || eVar.m() == null) {
            return;
        }
        if (eVar.e0() && eVar.l0()) {
            this.r.setVisibility(8);
            return;
        }
        this.r.setBottomPlaceHolderVisibility(z2);
        if (!z) {
            ListUtils.isEmpty(eVar.q());
        }
        b2 b2Var = new b2();
        b2Var.y3(eVar.P());
        b2Var.o3(b.f(eVar.m().getId(), 0L));
        b2Var.s3(eVar.m().getName());
        b2Var.p3(eVar.m().getFirst_class());
        b2Var.Y3(eVar.m().getSecond_class());
        if (eVar.N() != null) {
            b2Var.g4(eVar.N().Z);
        }
        if (eVar.f57445i) {
            this.r.setVisibility(8);
            this.s.f(b2Var, eVar.h(), eVar.l0());
            return;
        }
        this.s.setVisibility(8);
    }

    public void d(e eVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{eVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (eVar != null && eVar.j) {
                this.f19302c.setImageResource(R.drawable.pic_frs_headlines_n);
                this.f19302c.setVisibility(0);
            } else if (z && z2) {
                this.f19302c.setImageResource(R.drawable.pic_pb_stick_refined_n);
                this.f19302c.setVisibility(0);
            } else if (z) {
                this.f19302c.setImageResource(R.drawable.pic_pb_refined_n);
                this.f19302c.setVisibility(0);
            } else if (z2) {
                this.f19302c.setImageResource(R.drawable.pic_pb_stick_n);
                this.f19302c.setVisibility(0);
            } else {
                this.f19302c.setVisibility(8);
            }
        }
    }
}
