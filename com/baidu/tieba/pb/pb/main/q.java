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
    public View cVu;
    public View iFE;
    public TextView iFW;
    private ImageView iGA;
    private View iGB;
    public TbRichTextView iGC;
    public TbImageView iGD;
    public TbImageView iGE;
    public ThreadSkinView iGF;
    public LinearLayout iGG;
    public TextView iGH;
    public r iGI;
    public FrameLayout iGJ;
    public com.baidu.tieba.pb.pb.main.c.a iGK;
    public ThreadForumEnterButtonContainer iGL;
    public PbBusinessPromotionContainer iGM;
    public com.baidu.tieba.pb.pb.main.view.a iGN;
    public int mSkinType;

    public q(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.iGI = new r(view);
        this.iGA = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.iGA.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -am.cpc());
        this.iGA.setImageMatrix(matrix);
        this.iGB = view.findViewById(R.id.blank_view_above_rich_text);
        this.iGC = (TbRichTextView) view.findViewById(R.id.richText);
        this.iFE = view;
        int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.iGC.getPaddingLeft()) - this.iGC.getPaddingRight();
        int dimension = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60);
        c cVar = new c(this.iGC.getLayoutStrategy());
        cVar.dNZ = equipmentWidth;
        this.iGC.setLayoutStrategy(cVar);
        this.iGE = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(equipmentWidth - dimension, i);
        this.iGC.getLayoutStrategy().ni(min);
        this.iGC.getLayoutStrategy().nj((int) (min * 1.618f));
        this.iGC.setTextSize(TbConfig.getContentSize());
        this.iGC.setDisplayImage(z, false);
        this.iGC.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.cVu = view.findViewById(R.id.divider_bottom_first_floor);
        this.iGD = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.iGF = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.iGG = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.iFW = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.OO = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.iGH = (TextView) view.findViewById(R.id.pb_tail_text);
        this.iGL = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.iGL.setFrom(1);
        this.iGN = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.iGM = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.iGJ = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
    }

    public void a(@NonNull com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (this.iGL != null && eVar != null && eVar.getForum() != null) {
            if (eVar.ckS() && eVar.aHK()) {
                this.iGL.setVisibility(8);
                return;
            }
            this.iGL.setBottomPlaceHolderVisibility(z2);
            boolean z3 = false;
            if (!z && !com.baidu.tbadk.core.util.v.isEmpty(eVar.ckN())) {
                z3 = true;
            }
            bj bjVar = new bj();
            bjVar.setId(eVar.getThreadId());
            bjVar.setFid(com.baidu.adp.lib.f.b.toLong(eVar.getForum().getId(), 0L));
            bjVar.sG(eVar.getForum().getName());
            bjVar.sL(eVar.getForum().getFirst_class());
            bjVar.sM(eVar.getForum().getSecond_class());
            if (eVar.cku() != null) {
                bjVar.setThreadType(eVar.cku().threadType);
            }
            if (z3) {
                this.iGL.a(bjVar, eVar.ckN());
            } else {
                this.iGL.E(bjVar);
            }
            if (eVar.iBG) {
                this.iGL.setVisibility(8);
                this.iGM.a(bjVar, eVar.ckt(), eVar.aHK());
                return;
            }
            this.iGM.setVisibility(8);
        }
    }

    public void b(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.iBH) {
            this.iGA.setImageResource(R.drawable.pic_frs_headlines_n);
            this.iGA.setVisibility(0);
        } else if (z && z2) {
            this.iGA.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.iGA.setVisibility(0);
        } else if (z) {
            this.iGA.setImageResource(R.drawable.pic_pb_refined_n);
            this.iGA.setVisibility(0);
        } else if (z2) {
            this.iGA.setImageResource(R.drawable.pic_pb_stick_n);
            this.iGA.setVisibility(0);
        } else {
            this.iGA.setVisibility(8);
        }
    }

    public void w(boolean z, int i) {
        if (this.iGB != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iGB.getLayoutParams();
                layoutParams.height = i;
                this.iGB.setLayoutParams(layoutParams);
                this.iGB.setVisibility(0);
                return;
            }
            this.iGB.setVisibility(8);
        }
    }
}
