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
import d.b.b.e.m.b;
import d.b.b.e.p.l;
import d.b.h0.r.q.a2;
import d.b.i0.c2.h.e;
import d.b.i0.c2.k.e.a1.a;
import d.b.i0.c2.k.e.d;
import d.b.i0.c2.k.e.p0;
import d.b.i0.c2.k.e.r;
/* loaded from: classes4.dex */
public class PbFirstFloorViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public int f19538a;

    /* renamed from: b  reason: collision with root package name */
    public View f19539b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f19540c;

    /* renamed from: d  reason: collision with root package name */
    public View f19541d;

    /* renamed from: e  reason: collision with root package name */
    public TbRichTextView f19542e;

    /* renamed from: f  reason: collision with root package name */
    public View f19543f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f19544g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f19545h;
    public ThreadSkinView i;
    public TextView j;
    public LinearLayout k;
    public TextView l;
    public AppletsCellView m;
    public LinearLayout n;
    public r o;
    public FrameLayout p;
    public a q;
    public ThreadForumEnterButtonContainer r;
    public PbBusinessPromotionContainer s;
    public d.b.i0.c2.k.e.c1.a t;
    public VoteView u;

    public PbFirstFloorViewHolder(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.f19538a = 3;
        this.o = new r(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.f19540c = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -p0.e());
        this.f19540c.setImageMatrix(matrix);
        this.f19541d = view.findViewById(R.id.blank_view_above_rich_text);
        this.f19542e = (TbRichTextView) view.findViewById(R.id.richText);
        this.f19539b = view;
        int k = (((l.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.f19542e.getPaddingLeft()) - this.f19542e.getPaddingRight();
        d dVar = new d(this.f19542e.getLayoutStrategy());
        dVar.D = k;
        this.f19542e.setLayoutStrategy(dVar);
        this.f19545h = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(k - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.f19542e.getLayoutStrategy().q(min);
        this.f19542e.getLayoutStrategy().p((int) (min * 1.618f));
        this.f19542e.setTextSize(TbConfig.getContentSize());
        this.f19542e.setDisplayImage(z, false);
        this.f19542e.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.f19543f = view.findViewById(R.id.divider_bottom_first_floor);
        this.f19544g = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.i = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.k = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.j = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.m = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.n = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        this.l = (TextView) view.findViewById(R.id.pb_tail_text);
        ThreadForumEnterButtonContainer threadForumEnterButtonContainer = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.r = threadForumEnterButtonContainer;
        threadForumEnterButtonContainer.setFrom(1);
        this.t = new d.b.i0.c2.k.e.c1.a(tbPageContext);
        this.s = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.p = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
        VoteView voteView = (VoteView) view.findViewById(R.id.vote_view);
        this.u = voteView;
        voteView.setPageContext(tbPageContext);
    }

    public void b(boolean z, int i) {
        View view = this.f19541d;
        if (view == null) {
            return;
        }
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.height = i;
            this.f19541d.setLayoutParams(layoutParams);
            this.f19541d.setVisibility(0);
            return;
        }
        view.setVisibility(8);
    }

    public void c(@NonNull e eVar, boolean z, boolean z2) {
        if (this.r == null || eVar == null || eVar.l() == null) {
            return;
        }
        if (eVar.Z() && eVar.e0()) {
            this.r.setVisibility(8);
            return;
        }
        this.r.setBottomPlaceHolderVisibility(z2);
        if (!z) {
            ListUtils.isEmpty(eVar.p());
        }
        a2 a2Var = new a2();
        a2Var.D3(eVar.N());
        a2Var.t3(b.f(eVar.l().getId(), 0L));
        a2Var.x3(eVar.l().getName());
        a2Var.u3(eVar.l().getFirst_class());
        a2Var.c4(eVar.l().getSecond_class());
        if (eVar.L() != null) {
            a2Var.k4(eVar.L().Z);
        }
        if (eVar.i) {
            this.r.setVisibility(8);
            this.s.f(a2Var, eVar.h(), eVar.e0());
            return;
        }
        this.s.setVisibility(8);
    }

    public void d(e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.j) {
            this.f19540c.setImageResource(R.drawable.pic_frs_headlines_n);
            this.f19540c.setVisibility(0);
        } else if (z && z2) {
            this.f19540c.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.f19540c.setVisibility(0);
        } else if (z) {
            this.f19540c.setImageResource(R.drawable.pic_pb_refined_n);
            this.f19540c.setVisibility(0);
        } else if (z2) {
            this.f19540c.setImageResource(R.drawable.pic_pb_stick_n);
            this.f19540c.setVisibility(0);
        } else {
            this.f19540c.setVisibility(8);
        }
    }
}
