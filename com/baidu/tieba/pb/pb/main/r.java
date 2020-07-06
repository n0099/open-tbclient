package com.baidu.tieba.pb.pb.main;

import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
/* loaded from: classes9.dex */
public class r extends ad.a {
    public VoteView agO;
    public AppletsCellView ajv;
    public View dPI;
    public TextView kdD;
    public View kdj;
    private ImageView kej;
    private View kek;
    public TbRichTextView kel;
    public TbImageView kem;
    public TbImageView ken;
    public ThreadSkinView keo;
    public LinearLayout kep;
    public TextView keq;
    public LinearLayout ker;
    public s kes;
    public FrameLayout ket;
    public com.baidu.tieba.pb.pb.main.c.a keu;
    public ThreadForumEnterButtonContainer kev;
    public PbBusinessPromotionContainer kew;
    public com.baidu.tieba.pb.pb.main.view.a kex;
    public int mSkinType;

    public r(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.kes = new s(view);
        this.kej = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.kej.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -au.cLG());
        this.kej.setImageMatrix(matrix);
        this.kek = view.findViewById(R.id.blank_view_above_rich_text);
        this.kel = (TbRichTextView) view.findViewById(R.id.richText);
        this.kdj = view;
        int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.kel.getPaddingLeft()) - this.kel.getPaddingRight();
        int dimension = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60);
        d dVar = new d(this.kel.getLayoutStrategy());
        dVar.eNz = equipmentWidth;
        this.kel.setLayoutStrategy(dVar);
        this.ken = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(equipmentWidth - dimension, i);
        this.kel.getLayoutStrategy().oy(min);
        this.kel.getLayoutStrategy().oz((int) (min * 1.618f));
        this.kel.setTextSize(TbConfig.getContentSize());
        this.kel.setDisplayImage(z, false);
        this.kel.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.dPI = view.findViewById(R.id.divider_bottom_first_floor);
        this.kem = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.keo = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.kep = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.kdD = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.ajv = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.ker = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        this.keq = (TextView) view.findViewById(R.id.pb_tail_text);
        this.kev = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.kev.setFrom(1);
        this.kex = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.kew = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.ket = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
        this.agO = (VoteView) view.findViewById(R.id.vote_view);
        this.agO.setPageContext(tbPageContext);
    }

    public void a(@NonNull com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (this.kev != null && eVar != null && eVar.getForum() != null) {
            if (eVar.cHq() && eVar.cHn()) {
                this.kev.setVisibility(8);
                return;
            }
            this.kev.setBottomPlaceHolderVisibility(z2);
            boolean z3 = false;
            if (!z && !com.baidu.tbadk.core.util.w.isEmpty(eVar.cHk())) {
                z3 = true;
            }
            bu buVar = new bu();
            buVar.setId(eVar.getThreadId());
            buVar.setFid(com.baidu.adp.lib.f.b.toLong(eVar.getForum().getId(), 0L));
            buVar.vS(eVar.getForum().getName());
            buVar.vX(eVar.getForum().getFirst_class());
            buVar.vY(eVar.getForum().getSecond_class());
            if (eVar.cGO() != null) {
                buVar.setThreadType(eVar.cGO().threadType);
            }
            if (eVar.jYO) {
                this.kev.setVisibility(8);
                this.kew.a(buVar, eVar.cGN(), eVar.cHn());
                return;
            }
            this.kew.setVisibility(8);
            if (!com.baidu.tbadk.a.d.aNU()) {
                if (z3) {
                    this.kev.a(buVar, eVar.cHk());
                } else {
                    this.kev.G(buVar);
                }
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.e eVar, boolean z, boolean z2) {
        if (eVar != null && eVar.jYP) {
            this.kej.setImageResource(R.drawable.pic_frs_headlines_n);
            this.kej.setVisibility(0);
        } else if (z && z2) {
            this.kej.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.kej.setVisibility(0);
        } else if (z) {
            this.kej.setImageResource(R.drawable.pic_pb_refined_n);
            this.kej.setVisibility(0);
        } else if (z2) {
            this.kej.setImageResource(R.drawable.pic_pb_stick_n);
            this.kej.setVisibility(0);
        } else {
            this.kej.setVisibility(8);
        }
    }

    public void D(boolean z, int i) {
        if (this.kek != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kek.getLayoutParams();
                layoutParams.height = i;
                this.kek.setLayoutParams(layoutParams);
                this.kek.setVisibility(0);
                return;
            }
            this.kek.setVisibility(8);
        }
    }
}
