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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
/* loaded from: classes22.dex */
public class t extends af.a {
    public VoteView ajI;
    public AppletsCellView amE;
    public View eNL;
    public TextView lFW;
    public View lFs;
    private ImageView lGI;
    private View lGJ;
    public TbRichTextView lGK;
    public TbImageView lGL;
    public TbImageView lGM;
    public ThreadSkinView lGN;
    public LinearLayout lGO;
    public TextView lGP;
    public LinearLayout lGQ;
    public u lGR;
    public FrameLayout lGS;
    public com.baidu.tieba.pb.pb.main.c.a lGT;
    public ThreadForumEnterButtonContainer lGU;
    public PbBusinessPromotionContainer lGV;
    public com.baidu.tieba.pb.pb.main.view.a lGW;
    public int mSkinType;

    public t(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.lGR = new u(view);
        this.lGI = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.lGI.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -ay.drU());
        this.lGI.setImageMatrix(matrix);
        this.lGJ = view.findViewById(R.id.blank_view_above_rich_text);
        this.lGK = (TbRichTextView) view.findViewById(R.id.richText);
        this.lFs = view;
        int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.lGK.getPaddingLeft()) - this.lGK.getPaddingRight();
        int dimension = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60);
        d dVar = new d(this.lGK.getLayoutStrategy());
        dVar.fPo = equipmentWidth;
        this.lGK.setLayoutStrategy(dVar);
        this.lGM = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(equipmentWidth - dimension, i);
        this.lGK.getLayoutStrategy().to(min);
        this.lGK.getLayoutStrategy().tp((int) (min * 1.618f));
        this.lGK.setTextSize(TbConfig.getContentSize());
        this.lGK.setDisplayImage(z, false);
        this.lGK.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.eNL = view.findViewById(R.id.divider_bottom_first_floor);
        this.lGL = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.lGN = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.lGO = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.lFW = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.amE = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.lGQ = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        this.lGP = (TextView) view.findViewById(R.id.pb_tail_text);
        this.lGU = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.lGU.setFrom(1);
        this.lGW = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.lGV = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.lGS = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
        this.ajI = (VoteView) view.findViewById(R.id.vote_view);
        this.ajI.setPageContext(tbPageContext);
    }

    public void a(@NonNull com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (this.lGU != null && fVar != null && fVar.getForum() != null) {
            if (fVar.dnx() && fVar.dnu()) {
                this.lGU.setVisibility(8);
                return;
            }
            this.lGU.setBottomPlaceHolderVisibility(z2);
            if (z || !com.baidu.tbadk.core.util.y.isEmpty(fVar.dnq())) {
            }
            by byVar = new by();
            byVar.setId(fVar.getThreadId());
            byVar.setFid(com.baidu.adp.lib.f.b.toLong(fVar.getForum().getId(), 0L));
            byVar.Be(fVar.getForum().getName());
            byVar.Bj(fVar.getForum().getFirst_class());
            byVar.Bk(fVar.getForum().getSecond_class());
            if (fVar.dmT() != null) {
                byVar.setThreadType(fVar.dmT().threadType);
            }
            if (fVar.lAM) {
                this.lGU.setVisibility(8);
                this.lGV.a(byVar, fVar.dmS(), fVar.dnu());
                return;
            }
            this.lGV.setVisibility(8);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.lAN) {
            this.lGI.setImageResource(R.drawable.pic_frs_headlines_n);
            this.lGI.setVisibility(0);
        } else if (z && z2) {
            this.lGI.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.lGI.setVisibility(0);
        } else if (z) {
            this.lGI.setImageResource(R.drawable.pic_pb_refined_n);
            this.lGI.setVisibility(0);
        } else if (z2) {
            this.lGI.setImageResource(R.drawable.pic_pb_stick_n);
            this.lGI.setVisibility(0);
        } else {
            this.lGI.setVisibility(8);
        }
    }

    public void G(boolean z, int i) {
        if (this.lGJ != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lGJ.getLayoutParams();
                layoutParams.height = i;
                this.lGJ.setLayoutParams(layoutParams);
                this.lGJ.setVisibility(0);
                return;
            }
            this.lGJ.setVisibility(8);
        }
    }
}
