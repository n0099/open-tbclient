package com.baidu.tieba.pb.pb.main;

import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
/* loaded from: classes21.dex */
public class t extends af.a {
    public VoteView aiJ;
    public AppletsCellView alE;
    public View eGI;
    public View lrN;
    private ImageView lsW;
    private View lsX;
    public TbRichTextView lsY;
    public TbImageView lsZ;
    public TextView lsr;
    public TbImageView lta;
    public ThreadSkinView ltb;
    public LinearLayout ltc;
    public TextView ltd;
    public LinearLayout lte;
    public u ltf;
    public FrameLayout ltg;
    public com.baidu.tieba.pb.pb.main.c.a lth;
    public ThreadForumEnterButtonContainer lti;
    public PbBusinessPromotionContainer ltj;
    public com.baidu.tieba.pb.pb.main.view.a ltk;
    public int mSkinType;

    public t(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.ltf = new u(view);
        this.lsW = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.lsW.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -ay.dmD());
        this.lsW.setImageMatrix(matrix);
        this.lsX = view.findViewById(R.id.blank_view_above_rich_text);
        this.lsY = (TbRichTextView) view.findViewById(R.id.richText);
        this.lrN = view;
        int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.lsY.getPaddingLeft()) - this.lsY.getPaddingRight();
        int dimension = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60);
        d dVar = new d(this.lsY.getLayoutStrategy());
        dVar.fHC = equipmentWidth;
        this.lsY.setLayoutStrategy(dVar);
        this.lta = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(equipmentWidth - dimension, i);
        this.lsY.getLayoutStrategy().sL(min);
        this.lsY.getLayoutStrategy().sM((int) (min * 1.618f));
        this.lsY.setTextSize(TbConfig.getContentSize());
        this.lsY.setDisplayImage(z, false);
        this.lsY.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.eGI = view.findViewById(R.id.divider_bottom_first_floor);
        this.lsZ = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.ltb = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.ltc = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.lsr = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.alE = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.lte = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        this.ltd = (TextView) view.findViewById(R.id.pb_tail_text);
        this.lti = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.lti.setFrom(1);
        this.ltk = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.ltj = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.ltg = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
        this.aiJ = (VoteView) view.findViewById(R.id.vote_view);
        this.aiJ.setPageContext(tbPageContext);
    }

    public void a(@NonNull com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (this.lti != null && fVar != null && fVar.getForum() != null) {
            if (fVar.dik() && fVar.dih()) {
                this.lti.setVisibility(8);
                return;
            }
            this.lti.setBottomPlaceHolderVisibility(z2);
            if (z || !com.baidu.tbadk.core.util.y.isEmpty(fVar.die())) {
            }
            bx bxVar = new bx();
            bxVar.setId(fVar.getThreadId());
            bxVar.setFid(com.baidu.adp.lib.f.b.toLong(fVar.getForum().getId(), 0L));
            bxVar.Ax(fVar.getForum().getName());
            bxVar.AC(fVar.getForum().getFirst_class());
            bxVar.AD(fVar.getForum().getSecond_class());
            if (fVar.dhH() != null) {
                bxVar.setThreadType(fVar.dhH().threadType);
            }
            if (fVar.lnn) {
                this.lti.setVisibility(8);
                this.ltj.a(bxVar, fVar.dhG(), fVar.dih());
                return;
            }
            this.ltj.setVisibility(8);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.lno) {
            this.lsW.setImageResource(R.drawable.pic_frs_headlines_n);
            this.lsW.setVisibility(0);
        } else if (z && z2) {
            this.lsW.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.lsW.setVisibility(0);
        } else if (z) {
            this.lsW.setImageResource(R.drawable.pic_pb_refined_n);
            this.lsW.setVisibility(0);
        } else if (z2) {
            this.lsW.setImageResource(R.drawable.pic_pb_stick_n);
            this.lsW.setVisibility(0);
        } else {
            this.lsW.setVisibility(8);
        }
    }

    public void G(boolean z, int i) {
        if (this.lsX != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lsX.getLayoutParams();
                layoutParams.height = i;
                this.lsX.setLayoutParams(layoutParams);
                this.lsX.setVisibility(0);
                return;
            }
            this.lsX.setVisibility(8);
        }
    }
}
