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
/* loaded from: classes6.dex */
public class r extends v.a {
    public AppletsCellView Oi;
    public View cRh;
    public TextView iAM;
    public View iAu;
    public com.baidu.tieba.pb.pb.main.c.a iBA;
    public ThreadForumEnterButtonContainer iBB;
    public PbBusinessPromotionContainer iBC;
    public com.baidu.tieba.pb.pb.main.view.a iBD;
    private ImageView iBq;
    private View iBr;
    public TbRichTextView iBs;
    public TbImageView iBt;
    public TbImageView iBu;
    public ThreadSkinView iBv;
    public LinearLayout iBw;
    public TextView iBx;
    public s iBy;
    public FrameLayout iBz;
    public int mSkinType;

    public r(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.iBy = new s(view);
        this.iBq = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.iBq.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -ap.cmC());
        this.iBq.setImageMatrix(matrix);
        this.iBr = view.findViewById(R.id.blank_view_above_rich_text);
        this.iBs = (TbRichTextView) view.findViewById(R.id.richText);
        this.iAu = view;
        this.iBs.setLayoutStrategy(new c(this.iBs.getLayoutStrategy()));
        this.iBu = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.iBs.getPaddingLeft()) - this.iBs.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.iBs.getLayoutStrategy().mR(min);
        this.iBs.getLayoutStrategy().mS((int) (min * 1.618f));
        this.iBs.setTextSize(TbConfig.getContentSize());
        this.iBs.setDisplayImage(z, false);
        this.iBs.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.cRh = view.findViewById(R.id.divider_bottom_first_floor);
        this.iBt = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.iBv = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.iBw = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.iAM = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.Oi = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.iBx = (TextView) view.findViewById(R.id.pb_tail_text);
        this.iBB = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.iBB.setFrom(1);
        this.iBD = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.iBC = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.iBz = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
    }

    public void a(@NonNull com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (this.iBB != null && fVar != null && fVar.getForum() != null) {
            if (fVar.cik() && fVar.cih()) {
                this.iBB.setVisibility(8);
                return;
            }
            this.iBB.setBottomPlaceHolderVisibility(z2);
            boolean z3 = false;
            if (!z && !com.baidu.tbadk.core.util.v.isEmpty(fVar.cie())) {
                z3 = true;
            }
            bj bjVar = new bj();
            bjVar.setId(fVar.getThreadId());
            bjVar.setFid(com.baidu.adp.lib.f.b.toLong(fVar.getForum().getId(), 0L));
            bjVar.sm(fVar.getForum().getName());
            bjVar.ss(fVar.getForum().getFirst_class());
            bjVar.st(fVar.getForum().getSecond_class());
            if (fVar.chK() != null) {
                bjVar.setThreadType(fVar.chK().threadType);
            }
            if (z3) {
                this.iBB.a(bjVar, fVar.cie());
            } else {
                this.iBB.D(bjVar);
            }
            if (fVar.iwi) {
                this.iBB.setVisibility(8);
                this.iBC.a(bjVar, fVar.chJ(), fVar.cih());
                return;
            }
            this.iBC.setVisibility(8);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.iwj) {
            this.iBq.setImageResource(R.drawable.pic_frs_headlines_n);
            this.iBq.setVisibility(0);
        } else if (z && z2) {
            this.iBq.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.iBq.setVisibility(0);
        } else if (z) {
            this.iBq.setImageResource(R.drawable.pic_pb_refined_n);
            this.iBq.setVisibility(0);
        } else if (z2) {
            this.iBq.setImageResource(R.drawable.pic_pb_stick_n);
            this.iBq.setVisibility(0);
        } else {
            this.iBq.setVisibility(8);
        }
    }

    public void u(boolean z, int i) {
        if (this.iBr != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iBr.getLayoutParams();
                layoutParams.height = i;
                this.iBr.setLayoutParams(layoutParams);
                this.iBr.setVisibility(0);
                return;
            }
            this.iBr.setVisibility(8);
        }
    }
}
