package com.baidu.tieba.pb.pb.main;

import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
/* loaded from: classes16.dex */
public class t extends ad.a {
    public VoteView agF;
    public AppletsCellView ajq;
    public View dWa;
    public View klP;
    private ImageView kmZ;
    public TextView kmt;
    private View kna;
    public TbRichTextView knb;
    public TbImageView knc;
    public TbImageView knd;
    public ThreadSkinView kne;
    public LinearLayout knf;
    public TextView kng;
    public LinearLayout knh;
    public u kni;
    public FrameLayout knj;
    public com.baidu.tieba.pb.pb.main.c.a knk;
    public ThreadForumEnterButtonContainer knl;
    public PbBusinessPromotionContainer knm;
    public com.baidu.tieba.pb.pb.main.view.a knn;
    public int mSkinType;

    public t(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.kni = new u(view);
        this.kmZ = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.kmZ.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -ay.cPs());
        this.kmZ.setImageMatrix(matrix);
        this.kna = view.findViewById(R.id.blank_view_above_rich_text);
        this.knb = (TbRichTextView) view.findViewById(R.id.richText);
        this.klP = view;
        int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.knb.getPaddingLeft()) - this.knb.getPaddingRight();
        int dimension = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60);
        d dVar = new d(this.knb.getLayoutStrategy());
        dVar.eTU = equipmentWidth;
        this.knb.setLayoutStrategy(dVar);
        this.knd = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(equipmentWidth - dimension, i);
        this.knb.getLayoutStrategy().oR(min);
        this.knb.getLayoutStrategy().oS((int) (min * 1.618f));
        this.knb.setTextSize(TbConfig.getContentSize());
        this.knb.setDisplayImage(z, false);
        this.knb.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.dWa = view.findViewById(R.id.divider_bottom_first_floor);
        this.knc = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.kne = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.knf = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.kmt = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.ajq = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.knh = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        this.kng = (TextView) view.findViewById(R.id.pb_tail_text);
        this.knl = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.knl.setFrom(1);
        this.knn = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.knm = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.knj = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
        this.agF = (VoteView) view.findViewById(R.id.vote_view);
        this.agF.setPageContext(tbPageContext);
    }

    public void a(@NonNull com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (this.knl != null && fVar != null && fVar.getForum() != null) {
            if (fVar.cLa() && fVar.cKX()) {
                this.knl.setVisibility(8);
                return;
            }
            this.knl.setBottomPlaceHolderVisibility(z2);
            if (z || !com.baidu.tbadk.core.util.x.isEmpty(fVar.cKU())) {
            }
            bv bvVar = new bv();
            bvVar.setId(fVar.getThreadId());
            bvVar.setFid(com.baidu.adp.lib.f.b.toLong(fVar.getForum().getId(), 0L));
            bvVar.wZ(fVar.getForum().getName());
            bvVar.xe(fVar.getForum().getFirst_class());
            bvVar.xf(fVar.getForum().getSecond_class());
            if (fVar.cKx() != null) {
                bvVar.setThreadType(fVar.cKx().threadType);
            }
            if (fVar.khr) {
                this.knl.setVisibility(8);
                this.knm.a(bvVar, fVar.cKw(), fVar.cKX());
                return;
            }
            this.knm.setVisibility(8);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.khs) {
            this.kmZ.setImageResource(R.drawable.pic_frs_headlines_n);
            this.kmZ.setVisibility(0);
        } else if (z && z2) {
            this.kmZ.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.kmZ.setVisibility(0);
        } else if (z) {
            this.kmZ.setImageResource(R.drawable.pic_pb_refined_n);
            this.kmZ.setVisibility(0);
        } else if (z2) {
            this.kmZ.setImageResource(R.drawable.pic_pb_stick_n);
            this.kmZ.setVisibility(0);
        } else {
            this.kmZ.setVisibility(8);
        }
    }

    public void D(boolean z, int i) {
        if (this.kna != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kna.getLayoutParams();
                layoutParams.height = i;
                this.kna.setLayoutParams(layoutParams);
                this.kna.setVisibility(0);
                return;
            }
            this.kna.setVisibility(8);
        }
    }
}
