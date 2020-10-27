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
    public View eCA;
    public View llw;
    private ImageView lmF;
    private View lmG;
    public TbRichTextView lmH;
    public TbImageView lmI;
    public TbImageView lmJ;
    public ThreadSkinView lmK;
    public LinearLayout lmL;
    public TextView lmM;
    public LinearLayout lmN;
    public u lmO;
    public FrameLayout lmP;
    public com.baidu.tieba.pb.pb.main.c.a lmQ;
    public ThreadForumEnterButtonContainer lmR;
    public PbBusinessPromotionContainer lmS;
    public com.baidu.tieba.pb.pb.main.view.a lmT;
    public TextView lma;
    public int mSkinType;

    public t(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.lmO = new u(view);
        this.lmF = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.lmF.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -ay.dkC());
        this.lmF.setImageMatrix(matrix);
        this.lmG = view.findViewById(R.id.blank_view_above_rich_text);
        this.lmH = (TbRichTextView) view.findViewById(R.id.richText);
        this.llw = view;
        int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.lmH.getPaddingLeft()) - this.lmH.getPaddingRight();
        int dimension = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60);
        d dVar = new d(this.lmH.getLayoutStrategy());
        dVar.fCj = equipmentWidth;
        this.lmH.setLayoutStrategy(dVar);
        this.lmJ = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(equipmentWidth - dimension, i);
        this.lmH.getLayoutStrategy().sd(min);
        this.lmH.getLayoutStrategy().se((int) (min * 1.618f));
        this.lmH.setTextSize(TbConfig.getContentSize());
        this.lmH.setDisplayImage(z, false);
        this.lmH.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.eCA = view.findViewById(R.id.divider_bottom_first_floor);
        this.lmI = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.lmK = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.lmL = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.lma = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.alA = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.lmN = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        this.lmM = (TextView) view.findViewById(R.id.pb_tail_text);
        this.lmR = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.lmR.setFrom(1);
        this.lmT = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.lmS = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.lmP = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
        this.aiE = (VoteView) view.findViewById(R.id.vote_view);
        this.aiE.setPageContext(tbPageContext);
    }

    public void a(@NonNull com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (this.lmR != null && fVar != null && fVar.getForum() != null) {
            if (fVar.dgl() && fVar.dgi()) {
                this.lmR.setVisibility(8);
                return;
            }
            this.lmR.setBottomPlaceHolderVisibility(z2);
            if (z || !com.baidu.tbadk.core.util.y.isEmpty(fVar.dgf())) {
            }
            bw bwVar = new bw();
            bwVar.setId(fVar.getThreadId());
            bwVar.setFid(com.baidu.adp.lib.f.b.toLong(fVar.getForum().getId(), 0L));
            bwVar.AO(fVar.getForum().getName());
            bwVar.AT(fVar.getForum().getFirst_class());
            bwVar.AU(fVar.getForum().getSecond_class());
            if (fVar.dfI() != null) {
                bwVar.setThreadType(fVar.dfI().threadType);
            }
            if (fVar.lha) {
                this.lmR.setVisibility(8);
                this.lmS.a(bwVar, fVar.dfH(), fVar.dgi());
                return;
            }
            this.lmS.setVisibility(8);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.lhb) {
            this.lmF.setImageResource(R.drawable.pic_frs_headlines_n);
            this.lmF.setVisibility(0);
        } else if (z && z2) {
            this.lmF.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.lmF.setVisibility(0);
        } else if (z) {
            this.lmF.setImageResource(R.drawable.pic_pb_refined_n);
            this.lmF.setVisibility(0);
        } else if (z2) {
            this.lmF.setImageResource(R.drawable.pic_pb_stick_n);
            this.lmF.setVisibility(0);
        } else {
            this.lmF.setVisibility(8);
        }
    }

    public void G(boolean z, int i) {
        if (this.lmG != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lmG.getLayoutParams();
                layoutParams.height = i;
                this.lmG.setLayoutParams(layoutParams);
                this.lmG.setVisibility(0);
                return;
            }
            this.lmG.setVisibility(8);
        }
    }
}
