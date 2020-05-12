package com.baidu.tieba.pb.pb.main;

import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
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
public class q extends y.a {
    public AppletsCellView ahv;
    public View duX;
    public View jrC;
    public TextView jrU;
    public TbRichTextView jsA;
    public TbImageView jsB;
    public TbImageView jsC;
    public ThreadSkinView jsD;
    public LinearLayout jsE;
    public TextView jsF;
    public r jsG;
    public FrameLayout jsH;
    public com.baidu.tieba.pb.pb.main.c.a jsI;
    public ThreadForumEnterButtonContainer jsJ;
    public PbBusinessPromotionContainer jsK;
    public com.baidu.tieba.pb.pb.main.view.a jsL;
    private ImageView jsy;
    private View jsz;
    public int mSkinType;

    public q(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.jsG = new r(view);
        this.jsy = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.jsy.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -am.cAc());
        this.jsy.setImageMatrix(matrix);
        this.jsz = view.findViewById(R.id.blank_view_above_rich_text);
        this.jsA = (TbRichTextView) view.findViewById(R.id.richText);
        this.jrC = view;
        int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.jsA.getPaddingLeft()) - this.jsA.getPaddingRight();
        int dimension = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60);
        c cVar = new c(this.jsA.getLayoutStrategy());
        cVar.eoC = equipmentWidth;
        this.jsA.setLayoutStrategy(cVar);
        this.jsC = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(equipmentWidth - dimension, i);
        this.jsA.getLayoutStrategy().nw(min);
        this.jsA.getLayoutStrategy().nx((int) (min * 1.618f));
        this.jsA.setTextSize(TbConfig.getContentSize());
        this.jsA.setDisplayImage(z, false);
        this.jsA.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.duX = view.findViewById(R.id.divider_bottom_first_floor);
        this.jsB = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.jsD = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.jsE = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.jrU = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.ahv = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.jsF = (TextView) view.findViewById(R.id.pb_tail_text);
        this.jsJ = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.jsJ.setFrom(1);
        this.jsL = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.jsK = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.jsH = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
    }

    public void a(@NonNull com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (this.jsJ != null && eVar != null && eVar.getForum() != null) {
            if (eVar.cvQ() && eVar.aQe()) {
                this.jsJ.setVisibility(8);
                return;
            }
            this.jsJ.setBottomPlaceHolderVisibility(z2);
            boolean z3 = false;
            if (!z && !com.baidu.tbadk.core.util.v.isEmpty(eVar.cvL())) {
                z3 = true;
            }
            bj bjVar = new bj();
            bjVar.setId(eVar.getThreadId());
            bjVar.setFid(com.baidu.adp.lib.f.b.toLong(eVar.getForum().getId(), 0L));
            bjVar.tW(eVar.getForum().getName());
            bjVar.ub(eVar.getForum().getFirst_class());
            bjVar.uc(eVar.getForum().getSecond_class());
            if (eVar.cvs() != null) {
                bjVar.setThreadType(eVar.cvs().threadType);
            }
            if (z3) {
                this.jsJ.a(bjVar, eVar.cvL());
            } else {
                this.jsJ.F(bjVar);
            }
            if (eVar.jnC) {
                this.jsJ.setVisibility(8);
                this.jsK.a(bjVar, eVar.cvr(), eVar.aQe());
                return;
            }
            this.jsK.setVisibility(8);
        }
    }

    public void b(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.jnD) {
            this.jsy.setImageResource(R.drawable.pic_frs_headlines_n);
            this.jsy.setVisibility(0);
        } else if (z && z2) {
            this.jsy.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.jsy.setVisibility(0);
        } else if (z) {
            this.jsy.setImageResource(R.drawable.pic_pb_refined_n);
            this.jsy.setVisibility(0);
        } else if (z2) {
            this.jsy.setImageResource(R.drawable.pic_pb_stick_n);
            this.jsy.setVisibility(0);
        } else {
            this.jsy.setVisibility(8);
        }
    }

    public void x(boolean z, int i) {
        if (this.jsz != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jsz.getLayoutParams();
                layoutParams.height = i;
                this.jsz.setLayoutParams(layoutParams);
                this.jsz.setVisibility(0);
                return;
            }
            this.jsz.setVisibility(8);
        }
    }
}
