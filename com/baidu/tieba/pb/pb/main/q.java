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
    public View cVv;
    public View iFQ;
    private ImageView iGM;
    private View iGN;
    public TbRichTextView iGO;
    public TbImageView iGP;
    public TbImageView iGQ;
    public ThreadSkinView iGR;
    public LinearLayout iGS;
    public TextView iGT;
    public r iGU;
    public FrameLayout iGV;
    public com.baidu.tieba.pb.pb.main.c.a iGW;
    public ThreadForumEnterButtonContainer iGX;
    public PbBusinessPromotionContainer iGY;
    public com.baidu.tieba.pb.pb.main.view.a iGZ;
    public TextView iGi;
    public int mSkinType;

    public q(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.iGU = new r(view);
        this.iGM = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.iGM.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -am.cpd());
        this.iGM.setImageMatrix(matrix);
        this.iGN = view.findViewById(R.id.blank_view_above_rich_text);
        this.iGO = (TbRichTextView) view.findViewById(R.id.richText);
        this.iFQ = view;
        int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.iGO.getPaddingLeft()) - this.iGO.getPaddingRight();
        int dimension = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60);
        c cVar = new c(this.iGO.getLayoutStrategy());
        cVar.dOm = equipmentWidth;
        this.iGO.setLayoutStrategy(cVar);
        this.iGQ = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(equipmentWidth - dimension, i);
        this.iGO.getLayoutStrategy().ni(min);
        this.iGO.getLayoutStrategy().nj((int) (min * 1.618f));
        this.iGO.setTextSize(TbConfig.getContentSize());
        this.iGO.setDisplayImage(z, false);
        this.iGO.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.cVv = view.findViewById(R.id.divider_bottom_first_floor);
        this.iGP = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.iGR = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.iGS = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.iGi = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.OO = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.iGT = (TextView) view.findViewById(R.id.pb_tail_text);
        this.iGX = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.iGX.setFrom(1);
        this.iGZ = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.iGY = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.iGV = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
    }

    public void a(@NonNull com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (this.iGX != null && eVar != null && eVar.getForum() != null) {
            if (eVar.ckT() && eVar.aHL()) {
                this.iGX.setVisibility(8);
                return;
            }
            this.iGX.setBottomPlaceHolderVisibility(z2);
            boolean z3 = false;
            if (!z && !com.baidu.tbadk.core.util.v.isEmpty(eVar.ckO())) {
                z3 = true;
            }
            bj bjVar = new bj();
            bjVar.setId(eVar.getThreadId());
            bjVar.setFid(com.baidu.adp.lib.f.b.toLong(eVar.getForum().getId(), 0L));
            bjVar.sG(eVar.getForum().getName());
            bjVar.sL(eVar.getForum().getFirst_class());
            bjVar.sM(eVar.getForum().getSecond_class());
            if (eVar.ckv() != null) {
                bjVar.setThreadType(eVar.ckv().threadType);
            }
            if (z3) {
                this.iGX.a(bjVar, eVar.ckO());
            } else {
                this.iGX.E(bjVar);
            }
            if (eVar.iBS) {
                this.iGX.setVisibility(8);
                this.iGY.a(bjVar, eVar.cku(), eVar.aHL());
                return;
            }
            this.iGY.setVisibility(8);
        }
    }

    public void b(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.iBT) {
            this.iGM.setImageResource(R.drawable.pic_frs_headlines_n);
            this.iGM.setVisibility(0);
        } else if (z && z2) {
            this.iGM.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.iGM.setVisibility(0);
        } else if (z) {
            this.iGM.setImageResource(R.drawable.pic_pb_refined_n);
            this.iGM.setVisibility(0);
        } else if (z2) {
            this.iGM.setImageResource(R.drawable.pic_pb_stick_n);
            this.iGM.setVisibility(0);
        } else {
            this.iGM.setVisibility(8);
        }
    }

    public void w(boolean z, int i) {
        if (this.iGN != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iGN.getLayoutParams();
                layoutParams.height = i;
                this.iGN.setLayoutParams(layoutParams);
                this.iGN.setVisibility(0);
                return;
            }
            this.iGN.setVisibility(8);
        }
    }
}
