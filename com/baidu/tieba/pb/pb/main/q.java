package com.baidu.tieba.pb.pb.main;

import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
/* loaded from: classes9.dex */
public class q extends v.a {
    public AppletsCellView OO;
    public View cVt;
    public View iFC;
    public TextView iFU;
    public TbRichTextView iGA;
    public TbImageView iGB;
    public TbImageView iGC;
    public ThreadSkinView iGD;
    public LinearLayout iGE;
    public TextView iGF;
    public r iGG;
    public FrameLayout iGH;
    public com.baidu.tieba.pb.pb.main.c.a iGI;
    public ThreadForumEnterButtonContainer iGJ;
    public PbBusinessPromotionContainer iGK;
    public com.baidu.tieba.pb.pb.main.view.a iGL;
    private ImageView iGy;
    private View iGz;
    public int mSkinType;

    public q(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.iGG = new r(view);
        this.iGy = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.iGy.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -am.cpa());
        this.iGy.setImageMatrix(matrix);
        this.iGz = view.findViewById(R.id.blank_view_above_rich_text);
        this.iGA = (TbRichTextView) view.findViewById(R.id.richText);
        this.iFC = view;
        int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.iGA.getPaddingLeft()) - this.iGA.getPaddingRight();
        int dimension = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60);
        c cVar = new c(this.iGA.getLayoutStrategy());
        cVar.dNY = equipmentWidth;
        this.iGA.setLayoutStrategy(cVar);
        this.iGC = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(equipmentWidth - dimension, i);
        this.iGA.getLayoutStrategy().ni(min);
        this.iGA.getLayoutStrategy().nj((int) (min * 1.618f));
        this.iGA.setTextSize(TbConfig.getContentSize());
        this.iGA.setDisplayImage(z, false);
        this.iGA.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.cVt = view.findViewById(R.id.divider_bottom_first_floor);
        this.iGB = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.iGD = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.iGE = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.iFU = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.OO = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.iGF = (TextView) view.findViewById(R.id.pb_tail_text);
        this.iGJ = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.iGJ.setFrom(1);
        this.iGL = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.iGK = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.iGH = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
    }

    public void a(@NonNull com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (this.iGJ != null && eVar != null && eVar.getForum() != null) {
            if (eVar.ckQ() && eVar.aHI()) {
                this.iGJ.setVisibility(8);
                return;
            }
            this.iGJ.setBottomPlaceHolderVisibility(z2);
            boolean z3 = false;
            if (!z && !com.baidu.tbadk.core.util.v.isEmpty(eVar.ckL())) {
                z3 = true;
            }
            bj bjVar = new bj();
            bjVar.setId(eVar.getThreadId());
            bjVar.setFid(com.baidu.adp.lib.f.b.toLong(eVar.getForum().getId(), 0L));
            bjVar.sG(eVar.getForum().getName());
            bjVar.sL(eVar.getForum().getFirst_class());
            bjVar.sM(eVar.getForum().getSecond_class());
            if (eVar.cks() != null) {
                bjVar.setThreadType(eVar.cks().threadType);
            }
            if (z3) {
                this.iGJ.a(bjVar, eVar.ckL());
            } else {
                this.iGJ.E(bjVar);
            }
            if (eVar.iBE) {
                this.iGJ.setVisibility(8);
                this.iGK.a(bjVar, eVar.ckr(), eVar.aHI());
                return;
            }
            this.iGK.setVisibility(8);
        }
    }

    public void b(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.iBF) {
            this.iGy.setImageResource(R.drawable.pic_frs_headlines_n);
            this.iGy.setVisibility(0);
        } else if (z && z2) {
            this.iGy.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.iGy.setVisibility(0);
        } else if (z) {
            this.iGy.setImageResource(R.drawable.pic_pb_refined_n);
            this.iGy.setVisibility(0);
        } else if (z2) {
            this.iGy.setImageResource(R.drawable.pic_pb_stick_n);
            this.iGy.setVisibility(0);
        } else {
            this.iGy.setVisibility(8);
        }
    }

    public void w(boolean z, int i) {
        if (this.iGz != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iGz.getLayoutParams();
                layoutParams.height = i;
                this.iGz.setLayoutParams(layoutParams);
                this.iGz.setVisibility(0);
                return;
            }
            this.iGz.setVisibility(8);
        }
    }
}
