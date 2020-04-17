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
    public AppletsCellView ahs;
    public View duT;
    public TextView jrQ;
    public View jry;
    public LinearLayout jsA;
    public TextView jsB;
    public r jsC;
    public FrameLayout jsD;
    public com.baidu.tieba.pb.pb.main.c.a jsE;
    public ThreadForumEnterButtonContainer jsF;
    public PbBusinessPromotionContainer jsG;
    public com.baidu.tieba.pb.pb.main.view.a jsH;
    private ImageView jsu;
    private View jsv;
    public TbRichTextView jsw;
    public TbImageView jsx;
    public TbImageView jsy;
    public ThreadSkinView jsz;
    public int mSkinType;

    public q(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.jsC = new r(view);
        this.jsu = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.jsu.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -am.cAe());
        this.jsu.setImageMatrix(matrix);
        this.jsv = view.findViewById(R.id.blank_view_above_rich_text);
        this.jsw = (TbRichTextView) view.findViewById(R.id.richText);
        this.jry = view;
        int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.jsw.getPaddingLeft()) - this.jsw.getPaddingRight();
        int dimension = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60);
        c cVar = new c(this.jsw.getLayoutStrategy());
        cVar.eox = equipmentWidth;
        this.jsw.setLayoutStrategy(cVar);
        this.jsy = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(equipmentWidth - dimension, i);
        this.jsw.getLayoutStrategy().nw(min);
        this.jsw.getLayoutStrategy().nx((int) (min * 1.618f));
        this.jsw.setTextSize(TbConfig.getContentSize());
        this.jsw.setDisplayImage(z, false);
        this.jsw.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.duT = view.findViewById(R.id.divider_bottom_first_floor);
        this.jsx = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.jsz = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.jsA = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.jrQ = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.ahs = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.jsB = (TextView) view.findViewById(R.id.pb_tail_text);
        this.jsF = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.jsF.setFrom(1);
        this.jsH = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.jsG = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.jsD = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
    }

    public void a(@NonNull com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (this.jsF != null && eVar != null && eVar.getForum() != null) {
            if (eVar.cvS() && eVar.aQh()) {
                this.jsF.setVisibility(8);
                return;
            }
            this.jsF.setBottomPlaceHolderVisibility(z2);
            boolean z3 = false;
            if (!z && !com.baidu.tbadk.core.util.v.isEmpty(eVar.cvN())) {
                z3 = true;
            }
            bj bjVar = new bj();
            bjVar.setId(eVar.getThreadId());
            bjVar.setFid(com.baidu.adp.lib.f.b.toLong(eVar.getForum().getId(), 0L));
            bjVar.tT(eVar.getForum().getName());
            bjVar.tY(eVar.getForum().getFirst_class());
            bjVar.tZ(eVar.getForum().getSecond_class());
            if (eVar.cvu() != null) {
                bjVar.setThreadType(eVar.cvu().threadType);
            }
            if (z3) {
                this.jsF.a(bjVar, eVar.cvN());
            } else {
                this.jsF.F(bjVar);
            }
            if (eVar.jny) {
                this.jsF.setVisibility(8);
                this.jsG.a(bjVar, eVar.cvt(), eVar.aQh());
                return;
            }
            this.jsG.setVisibility(8);
        }
    }

    public void b(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.jnz) {
            this.jsu.setImageResource(R.drawable.pic_frs_headlines_n);
            this.jsu.setVisibility(0);
        } else if (z && z2) {
            this.jsu.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.jsu.setVisibility(0);
        } else if (z) {
            this.jsu.setImageResource(R.drawable.pic_pb_refined_n);
            this.jsu.setVisibility(0);
        } else if (z2) {
            this.jsu.setImageResource(R.drawable.pic_pb_stick_n);
            this.jsu.setVisibility(0);
        } else {
            this.jsu.setVisibility(8);
        }
    }

    public void x(boolean z, int i) {
        if (this.jsv != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jsv.getLayoutParams();
                layoutParams.height = i;
                this.jsv.setLayoutParams(layoutParams);
                this.jsv.setVisibility(0);
                return;
            }
            this.jsv.setVisibility(8);
        }
    }
}
