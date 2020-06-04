package com.baidu.tieba.pb.pb.main;

import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
/* loaded from: classes9.dex */
public class r extends aa.a {
    public AppletsCellView ahY;
    public View dIS;
    public View jJB;
    public TextView jJV;
    private ImageView jKA;
    private View jKB;
    public TbRichTextView jKC;
    public TbImageView jKD;
    public TbImageView jKE;
    public ThreadSkinView jKF;
    public LinearLayout jKG;
    public TextView jKH;
    public s jKI;
    public FrameLayout jKJ;
    public com.baidu.tieba.pb.pb.main.c.a jKK;
    public ThreadForumEnterButtonContainer jKL;
    public PbBusinessPromotionContainer jKM;
    public com.baidu.tieba.pb.pb.main.view.a jKN;
    public int mSkinType;

    public r(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.jKI = new s(view);
        this.jKA = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.jKA.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -au.cHo());
        this.jKA.setImageMatrix(matrix);
        this.jKB = view.findViewById(R.id.blank_view_above_rich_text);
        this.jKC = (TbRichTextView) view.findViewById(R.id.richText);
        this.jJB = view;
        int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.jKC.getPaddingLeft()) - this.jKC.getPaddingRight();
        int dimension = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60);
        d dVar = new d(this.jKC.getLayoutStrategy());
        dVar.eDp = equipmentWidth;
        this.jKC.setLayoutStrategy(dVar);
        this.jKE = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(equipmentWidth - dimension, i);
        this.jKC.getLayoutStrategy().ob(min);
        this.jKC.getLayoutStrategy().oc((int) (min * 1.618f));
        this.jKC.setTextSize(TbConfig.getContentSize());
        this.jKC.setDisplayImage(z, false);
        this.jKC.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.dIS = view.findViewById(R.id.divider_bottom_first_floor);
        this.jKD = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.jKF = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.jKG = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.jJV = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.ahY = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.jKH = (TextView) view.findViewById(R.id.pb_tail_text);
        this.jKL = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.jKL.setFrom(1);
        this.jKN = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.jKM = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.jKJ = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
    }

    public void a(@NonNull com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (this.jKL != null && eVar != null && eVar.getForum() != null) {
            if (eVar.cCZ() && eVar.aWj()) {
                this.jKL.setVisibility(8);
                return;
            }
            this.jKL.setBottomPlaceHolderVisibility(z2);
            boolean z3 = false;
            if (!z && !com.baidu.tbadk.core.util.v.isEmpty(eVar.cCU())) {
                z3 = true;
            }
            bk bkVar = new bk();
            bkVar.setId(eVar.getThreadId());
            bkVar.setFid(com.baidu.adp.lib.f.b.toLong(eVar.getForum().getId(), 0L));
            bkVar.vC(eVar.getForum().getName());
            bkVar.vH(eVar.getForum().getFirst_class());
            bkVar.vI(eVar.getForum().getSecond_class());
            if (eVar.cCy() != null) {
                bkVar.setThreadType(eVar.cCy().threadType);
            }
            if (eVar.jFe) {
                this.jKL.setVisibility(8);
                this.jKM.a(bkVar, eVar.cCx(), eVar.aWj());
                return;
            }
            this.jKM.setVisibility(8);
            if (!com.baidu.tbadk.a.d.aMr()) {
                if (z3) {
                    this.jKL.a(bkVar, eVar.cCU());
                } else {
                    this.jKL.G(bkVar);
                }
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.jFf) {
            this.jKA.setImageResource(R.drawable.pic_frs_headlines_n);
            this.jKA.setVisibility(0);
        } else if (z && z2) {
            this.jKA.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.jKA.setVisibility(0);
        } else if (z) {
            this.jKA.setImageResource(R.drawable.pic_pb_refined_n);
            this.jKA.setVisibility(0);
        } else if (z2) {
            this.jKA.setImageResource(R.drawable.pic_pb_stick_n);
            this.jKA.setVisibility(0);
        } else {
            this.jKA.setVisibility(8);
        }
    }

    public void A(boolean z, int i) {
        if (this.jKB != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jKB.getLayoutParams();
                layoutParams.height = i;
                this.jKB.setLayoutParams(layoutParams);
                this.jKB.setVisibility(0);
                return;
            }
            this.jKB.setVisibility(8);
        }
    }
}
