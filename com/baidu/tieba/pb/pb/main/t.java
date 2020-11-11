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
import com.baidu.tbadk.core.data.bw;
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
    public VoteView aiE;
    public AppletsCellView alA;
    public View eIp;
    public View lrx;
    private ImageView lsG;
    private View lsH;
    public TbRichTextView lsI;
    public TbImageView lsJ;
    public TbImageView lsK;
    public ThreadSkinView lsL;
    public LinearLayout lsM;
    public TextView lsN;
    public LinearLayout lsO;
    public u lsP;
    public FrameLayout lsQ;
    public com.baidu.tieba.pb.pb.main.c.a lsR;
    public ThreadForumEnterButtonContainer lsS;
    public PbBusinessPromotionContainer lsT;
    public com.baidu.tieba.pb.pb.main.view.a lsU;
    public TextView lsb;
    public int mSkinType;

    public t(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.lsP = new u(view);
        this.lsG = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.lsG.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -ay.dne());
        this.lsG.setImageMatrix(matrix);
        this.lsH = view.findViewById(R.id.blank_view_above_rich_text);
        this.lsI = (TbRichTextView) view.findViewById(R.id.richText);
        this.lrx = view;
        int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.lsI.getPaddingLeft()) - this.lsI.getPaddingRight();
        int dimension = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60);
        d dVar = new d(this.lsI.getLayoutStrategy());
        dVar.fHZ = equipmentWidth;
        this.lsI.setLayoutStrategy(dVar);
        this.lsK = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(equipmentWidth - dimension, i);
        this.lsI.getLayoutStrategy().sn(min);
        this.lsI.getLayoutStrategy().so((int) (min * 1.618f));
        this.lsI.setTextSize(TbConfig.getContentSize());
        this.lsI.setDisplayImage(z, false);
        this.lsI.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.eIp = view.findViewById(R.id.divider_bottom_first_floor);
        this.lsJ = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.lsL = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.lsM = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.lsb = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.alA = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.lsO = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        this.lsN = (TextView) view.findViewById(R.id.pb_tail_text);
        this.lsS = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.lsS.setFrom(1);
        this.lsU = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.lsT = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.lsQ = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
        this.aiE = (VoteView) view.findViewById(R.id.vote_view);
        this.aiE.setPageContext(tbPageContext);
    }

    public void a(@NonNull com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (this.lsS != null && fVar != null && fVar.getForum() != null) {
            if (fVar.diN() && fVar.diK()) {
                this.lsS.setVisibility(8);
                return;
            }
            this.lsS.setBottomPlaceHolderVisibility(z2);
            if (z || !com.baidu.tbadk.core.util.y.isEmpty(fVar.diH())) {
            }
            bw bwVar = new bw();
            bwVar.setId(fVar.getThreadId());
            bwVar.setFid(com.baidu.adp.lib.f.b.toLong(fVar.getForum().getId(), 0L));
            bwVar.Bc(fVar.getForum().getName());
            bwVar.Bh(fVar.getForum().getFirst_class());
            bwVar.Bi(fVar.getForum().getSecond_class());
            if (fVar.dik() != null) {
                bwVar.setThreadType(fVar.dik().threadType);
            }
            if (fVar.lmW) {
                this.lsS.setVisibility(8);
                this.lsT.a(bwVar, fVar.dij(), fVar.diK());
                return;
            }
            this.lsT.setVisibility(8);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.lmX) {
            this.lsG.setImageResource(R.drawable.pic_frs_headlines_n);
            this.lsG.setVisibility(0);
        } else if (z && z2) {
            this.lsG.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.lsG.setVisibility(0);
        } else if (z) {
            this.lsG.setImageResource(R.drawable.pic_pb_refined_n);
            this.lsG.setVisibility(0);
        } else if (z2) {
            this.lsG.setImageResource(R.drawable.pic_pb_stick_n);
            this.lsG.setVisibility(0);
        } else {
            this.lsG.setVisibility(8);
        }
    }

    public void G(boolean z, int i) {
        if (this.lsH != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lsH.getLayoutParams();
                layoutParams.height = i;
                this.lsH.setLayoutParams(layoutParams);
                this.lsH.setVisibility(0);
                return;
            }
            this.lsH.setVisibility(8);
        }
    }
}
