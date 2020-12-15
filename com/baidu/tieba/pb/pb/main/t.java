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
    public TextView lFY;
    public View lFu;
    private ImageView lGK;
    private View lGL;
    public TbRichTextView lGM;
    public TbImageView lGN;
    public TbImageView lGO;
    public ThreadSkinView lGP;
    public LinearLayout lGQ;
    public TextView lGR;
    public LinearLayout lGS;
    public u lGT;
    public FrameLayout lGU;
    public com.baidu.tieba.pb.pb.main.c.a lGV;
    public ThreadForumEnterButtonContainer lGW;
    public PbBusinessPromotionContainer lGX;
    public com.baidu.tieba.pb.pb.main.view.a lGY;
    public int mSkinType;

    public t(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.lGT = new u(view);
        this.lGK = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.lGK.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -ay.drV());
        this.lGK.setImageMatrix(matrix);
        this.lGL = view.findViewById(R.id.blank_view_above_rich_text);
        this.lGM = (TbRichTextView) view.findViewById(R.id.richText);
        this.lFu = view;
        int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.lGM.getPaddingLeft()) - this.lGM.getPaddingRight();
        int dimension = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60);
        d dVar = new d(this.lGM.getLayoutStrategy());
        dVar.fPo = equipmentWidth;
        this.lGM.setLayoutStrategy(dVar);
        this.lGO = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(equipmentWidth - dimension, i);
        this.lGM.getLayoutStrategy().to(min);
        this.lGM.getLayoutStrategy().tp((int) (min * 1.618f));
        this.lGM.setTextSize(TbConfig.getContentSize());
        this.lGM.setDisplayImage(z, false);
        this.lGM.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.eNL = view.findViewById(R.id.divider_bottom_first_floor);
        this.lGN = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.lGP = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.lGQ = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.lFY = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.amE = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.lGS = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        this.lGR = (TextView) view.findViewById(R.id.pb_tail_text);
        this.lGW = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.lGW.setFrom(1);
        this.lGY = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.lGX = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.lGU = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
        this.ajI = (VoteView) view.findViewById(R.id.vote_view);
        this.ajI.setPageContext(tbPageContext);
    }

    public void a(@NonNull com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (this.lGW != null && fVar != null && fVar.getForum() != null) {
            if (fVar.dny() && fVar.dnv()) {
                this.lGW.setVisibility(8);
                return;
            }
            this.lGW.setBottomPlaceHolderVisibility(z2);
            if (z || !com.baidu.tbadk.core.util.y.isEmpty(fVar.dnr())) {
            }
            by byVar = new by();
            byVar.setId(fVar.getThreadId());
            byVar.setFid(com.baidu.adp.lib.f.b.toLong(fVar.getForum().getId(), 0L));
            byVar.Be(fVar.getForum().getName());
            byVar.Bj(fVar.getForum().getFirst_class());
            byVar.Bk(fVar.getForum().getSecond_class());
            if (fVar.dmU() != null) {
                byVar.setThreadType(fVar.dmU().threadType);
            }
            if (fVar.lAO) {
                this.lGW.setVisibility(8);
                this.lGX.a(byVar, fVar.dmT(), fVar.dnv());
                return;
            }
            this.lGX.setVisibility(8);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.lAP) {
            this.lGK.setImageResource(R.drawable.pic_frs_headlines_n);
            this.lGK.setVisibility(0);
        } else if (z && z2) {
            this.lGK.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.lGK.setVisibility(0);
        } else if (z) {
            this.lGK.setImageResource(R.drawable.pic_pb_refined_n);
            this.lGK.setVisibility(0);
        } else if (z2) {
            this.lGK.setImageResource(R.drawable.pic_pb_stick_n);
            this.lGK.setVisibility(0);
        } else {
            this.lGK.setVisibility(8);
        }
    }

    public void G(boolean z, int i) {
        if (this.lGL != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lGL.getLayoutParams();
                layoutParams.height = i;
                this.lGL.setLayoutParams(layoutParams);
                this.lGL.setVisibility(0);
                return;
            }
            this.lGL.setVisibility(8);
        }
    }
}
