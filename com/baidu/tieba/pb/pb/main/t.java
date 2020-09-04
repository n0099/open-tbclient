package com.baidu.tieba.pb.pb.main;

import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
/* loaded from: classes16.dex */
public class t extends af.a {
    public VoteView ahQ;
    public AppletsCellView akH;
    public View efE;
    public TextView kBS;
    public View kBo;
    public TbImageView kCA;
    public TbImageView kCB;
    public ThreadSkinView kCC;
    public LinearLayout kCD;
    public TextView kCE;
    public LinearLayout kCF;
    public u kCG;
    public FrameLayout kCH;
    public com.baidu.tieba.pb.pb.main.c.a kCI;
    public ThreadForumEnterButtonContainer kCJ;
    public PbBusinessPromotionContainer kCK;
    public com.baidu.tieba.pb.pb.main.view.a kCL;
    private ImageView kCx;
    private View kCy;
    public TbRichTextView kCz;
    public int mSkinType;

    public t(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.kCG = new u(view);
        this.kCx = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.kCx.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -ay.daj());
        this.kCx.setImageMatrix(matrix);
        this.kCy = view.findViewById(R.id.blank_view_above_rich_text);
        this.kCz = (TbRichTextView) view.findViewById(R.id.richText);
        this.kBo = view;
        int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.kCz.getPaddingLeft()) - this.kCz.getPaddingRight();
        int dimension = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60);
        d dVar = new d(this.kCz.getLayoutStrategy());
        dVar.feF = equipmentWidth;
        this.kCz.setLayoutStrategy(dVar);
        this.kCB = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(equipmentWidth - dimension, i);
        this.kCz.getLayoutStrategy().rd(min);
        this.kCz.getLayoutStrategy().re((int) (min * 1.618f));
        this.kCz.setTextSize(TbConfig.getContentSize());
        this.kCz.setDisplayImage(z, false);
        this.kCz.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.efE = view.findViewById(R.id.divider_bottom_first_floor);
        this.kCA = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.kCC = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.kCD = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.kBS = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.akH = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.kCF = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        this.kCE = (TextView) view.findViewById(R.id.pb_tail_text);
        this.kCJ = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.kCJ.setFrom(1);
        this.kCL = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.kCK = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.kCH = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
        this.ahQ = (VoteView) view.findViewById(R.id.vote_view);
        this.ahQ.setPageContext(tbPageContext);
    }

    public void a(@NonNull com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (this.kCJ != null && fVar != null && fVar.getForum() != null) {
            if (fVar.cVP() && fVar.cVM()) {
                this.kCJ.setVisibility(8);
                return;
            }
            this.kCJ.setBottomPlaceHolderVisibility(z2);
            if (z || !com.baidu.tbadk.core.util.y.isEmpty(fVar.cVJ())) {
            }
            bw bwVar = new bw();
            bwVar.setId(fVar.getThreadId());
            bwVar.setFid(com.baidu.adp.lib.f.b.toLong(fVar.getForum().getId(), 0L));
            bwVar.zo(fVar.getForum().getName());
            bwVar.zt(fVar.getForum().getFirst_class());
            bwVar.zu(fVar.getForum().getSecond_class());
            if (fVar.cVm() != null) {
                bwVar.setThreadType(fVar.cVm().threadType);
            }
            if (fVar.kwR) {
                this.kCJ.setVisibility(8);
                this.kCK.a(bwVar, fVar.cVl(), fVar.cVM());
                return;
            }
            this.kCK.setVisibility(8);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.kwS) {
            this.kCx.setImageResource(R.drawable.pic_frs_headlines_n);
            this.kCx.setVisibility(0);
        } else if (z && z2) {
            this.kCx.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.kCx.setVisibility(0);
        } else if (z) {
            this.kCx.setImageResource(R.drawable.pic_pb_refined_n);
            this.kCx.setVisibility(0);
        } else if (z2) {
            this.kCx.setImageResource(R.drawable.pic_pb_stick_n);
            this.kCx.setVisibility(0);
        } else {
            this.kCx.setVisibility(8);
        }
    }

    public void D(boolean z, int i) {
        if (this.kCy != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kCy.getLayoutParams();
                layoutParams.height = i;
                this.kCy.setLayoutParams(layoutParams);
                this.kCy.setVisibility(0);
                return;
            }
            this.kCy.setVisibility(8);
        }
    }
}
