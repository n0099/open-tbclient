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
/* loaded from: classes7.dex */
public class r extends v.a {
    public AppletsCellView Om;
    public View cRr;
    public View iDY;
    private ImageView iEU;
    private View iEV;
    public TbRichTextView iEW;
    public TbImageView iEX;
    public TbImageView iEY;
    public ThreadSkinView iEZ;
    public TextView iEq;
    public LinearLayout iFa;
    public TextView iFb;
    public s iFc;
    public FrameLayout iFd;
    public com.baidu.tieba.pb.pb.main.c.a iFe;
    public ThreadForumEnterButtonContainer iFf;
    public PbBusinessPromotionContainer iFg;
    public com.baidu.tieba.pb.pb.main.view.a iFh;
    public int mSkinType;

    public r(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.iFc = new s(view);
        this.iEU = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.iEU.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -ap.cnJ());
        this.iEU.setImageMatrix(matrix);
        this.iEV = view.findViewById(R.id.blank_view_above_rich_text);
        this.iEW = (TbRichTextView) view.findViewById(R.id.richText);
        this.iDY = view;
        this.iEW.setLayoutStrategy(new c(this.iEW.getLayoutStrategy()));
        this.iEY = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.iEW.getPaddingLeft()) - this.iEW.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.iEW.getLayoutStrategy().mR(min);
        this.iEW.getLayoutStrategy().mS((int) (min * 1.618f));
        this.iEW.setTextSize(TbConfig.getContentSize());
        this.iEW.setDisplayImage(z, false);
        this.iEW.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.cRr = view.findViewById(R.id.divider_bottom_first_floor);
        this.iEX = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.iEZ = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.iFa = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.iEq = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.Om = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.iFb = (TextView) view.findViewById(R.id.pb_tail_text);
        this.iFf = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.iFf.setFrom(1);
        this.iFh = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.iFg = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.iFd = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
    }

    public void a(@NonNull com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (this.iFf != null && fVar != null && fVar.getForum() != null) {
            if (fVar.cjs() && fVar.cjp()) {
                this.iFf.setVisibility(8);
                return;
            }
            this.iFf.setBottomPlaceHolderVisibility(z2);
            boolean z3 = false;
            if (!z && !com.baidu.tbadk.core.util.v.isEmpty(fVar.cjm())) {
                z3 = true;
            }
            bj bjVar = new bj();
            bjVar.setId(fVar.getThreadId());
            bjVar.setFid(com.baidu.adp.lib.f.b.toLong(fVar.getForum().getId(), 0L));
            bjVar.sp(fVar.getForum().getName());
            bjVar.sv(fVar.getForum().getFirst_class());
            bjVar.sw(fVar.getForum().getSecond_class());
            if (fVar.ciS() != null) {
                bjVar.setThreadType(fVar.ciS().threadType);
            }
            if (z3) {
                this.iFf.a(bjVar, fVar.cjm());
            } else {
                this.iFf.D(bjVar);
            }
            if (fVar.izM) {
                this.iFf.setVisibility(8);
                this.iFg.a(bjVar, fVar.ciR(), fVar.cjp());
                return;
            }
            this.iFg.setVisibility(8);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.izN) {
            this.iEU.setImageResource(R.drawable.pic_frs_headlines_n);
            this.iEU.setVisibility(0);
        } else if (z && z2) {
            this.iEU.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.iEU.setVisibility(0);
        } else if (z) {
            this.iEU.setImageResource(R.drawable.pic_pb_refined_n);
            this.iEU.setVisibility(0);
        } else if (z2) {
            this.iEU.setImageResource(R.drawable.pic_pb_stick_n);
            this.iEU.setVisibility(0);
        } else {
            this.iEU.setVisibility(8);
        }
    }

    public void v(boolean z, int i) {
        if (this.iEV != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iEV.getLayoutParams();
                layoutParams.height = i;
                this.iEV.setLayoutParams(layoutParams);
                this.iEV.setVisibility(0);
                return;
            }
            this.iEV.setVisibility(8);
        }
    }
}
