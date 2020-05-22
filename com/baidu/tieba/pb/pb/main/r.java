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
    public TextView jIP;
    public View jIv;
    public LinearLayout jJA;
    public TextView jJB;
    public s jJC;
    public FrameLayout jJD;
    public com.baidu.tieba.pb.pb.main.c.a jJE;
    public ThreadForumEnterButtonContainer jJF;
    public PbBusinessPromotionContainer jJG;
    public com.baidu.tieba.pb.pb.main.view.a jJH;
    private ImageView jJu;
    private View jJv;
    public TbRichTextView jJw;
    public TbImageView jJx;
    public TbImageView jJy;
    public ThreadSkinView jJz;
    public int mSkinType;

    public r(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.jJC = new s(view);
        this.jJu = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.jJu.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -au.cGY());
        this.jJu.setImageMatrix(matrix);
        this.jJv = view.findViewById(R.id.blank_view_above_rich_text);
        this.jJw = (TbRichTextView) view.findViewById(R.id.richText);
        this.jIv = view;
        int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.jJw.getPaddingLeft()) - this.jJw.getPaddingRight();
        int dimension = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60);
        d dVar = new d(this.jJw.getLayoutStrategy());
        dVar.eDe = equipmentWidth;
        this.jJw.setLayoutStrategy(dVar);
        this.jJy = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(equipmentWidth - dimension, i);
        this.jJw.getLayoutStrategy().nZ(min);
        this.jJw.getLayoutStrategy().oa((int) (min * 1.618f));
        this.jJw.setTextSize(TbConfig.getContentSize());
        this.jJw.setDisplayImage(z, false);
        this.jJw.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.dIS = view.findViewById(R.id.divider_bottom_first_floor);
        this.jJx = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.jJz = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.jJA = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.jIP = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.ahY = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.jJB = (TextView) view.findViewById(R.id.pb_tail_text);
        this.jJF = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.jJF.setFrom(1);
        this.jJH = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.jJG = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.jJD = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
    }

    public void a(@NonNull com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (this.jJF != null && eVar != null && eVar.getForum() != null) {
            if (eVar.cCJ() && eVar.aWi()) {
                this.jJF.setVisibility(8);
                return;
            }
            this.jJF.setBottomPlaceHolderVisibility(z2);
            boolean z3 = false;
            if (!z && !com.baidu.tbadk.core.util.v.isEmpty(eVar.cCE())) {
                z3 = true;
            }
            bk bkVar = new bk();
            bkVar.setId(eVar.getThreadId());
            bkVar.setFid(com.baidu.adp.lib.f.b.toLong(eVar.getForum().getId(), 0L));
            bkVar.vC(eVar.getForum().getName());
            bkVar.vH(eVar.getForum().getFirst_class());
            bkVar.vI(eVar.getForum().getSecond_class());
            if (eVar.cCi() != null) {
                bkVar.setThreadType(eVar.cCi().threadType);
            }
            if (eVar.jDY) {
                this.jJF.setVisibility(8);
                this.jJG.a(bkVar, eVar.cCh(), eVar.aWi());
                return;
            }
            this.jJG.setVisibility(8);
            if (!com.baidu.tbadk.a.d.aMr()) {
                if (z3) {
                    this.jJF.a(bkVar, eVar.cCE());
                } else {
                    this.jJF.G(bkVar);
                }
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.jDZ) {
            this.jJu.setImageResource(R.drawable.pic_frs_headlines_n);
            this.jJu.setVisibility(0);
        } else if (z && z2) {
            this.jJu.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.jJu.setVisibility(0);
        } else if (z) {
            this.jJu.setImageResource(R.drawable.pic_pb_refined_n);
            this.jJu.setVisibility(0);
        } else if (z2) {
            this.jJu.setImageResource(R.drawable.pic_pb_stick_n);
            this.jJu.setVisibility(0);
        } else {
            this.jJu.setVisibility(8);
        }
    }

    public void A(boolean z, int i) {
        if (this.jJv != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jJv.getLayoutParams();
                layoutParams.height = i;
                this.jJv.setLayoutParams(layoutParams);
                this.jJv.setVisibility(0);
                return;
            }
            this.jJv.setVisibility(8);
        }
    }
}
