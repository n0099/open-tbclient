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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
/* loaded from: classes16.dex */
public class t extends ad.a {
    public VoteView agF;
    public AppletsCellView ajq;
    public View dWa;
    public View klN;
    private ImageView kmX;
    private View kmY;
    public TbRichTextView kmZ;
    public TextView kmr;
    public TbImageView kna;
    public TbImageView knb;
    public ThreadSkinView knc;
    public LinearLayout knd;
    public TextView kne;
    public LinearLayout knf;
    public u kng;
    public FrameLayout knh;
    public com.baidu.tieba.pb.pb.main.c.a kni;
    public ThreadForumEnterButtonContainer knj;
    public PbBusinessPromotionContainer knk;
    public com.baidu.tieba.pb.pb.main.view.a knl;
    public int mSkinType;

    public t(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.kng = new u(view);
        this.kmX = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.kmX.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -ay.cPs());
        this.kmX.setImageMatrix(matrix);
        this.kmY = view.findViewById(R.id.blank_view_above_rich_text);
        this.kmZ = (TbRichTextView) view.findViewById(R.id.richText);
        this.klN = view;
        int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.kmZ.getPaddingLeft()) - this.kmZ.getPaddingRight();
        int dimension = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60);
        d dVar = new d(this.kmZ.getLayoutStrategy());
        dVar.eTU = equipmentWidth;
        this.kmZ.setLayoutStrategy(dVar);
        this.knb = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(equipmentWidth - dimension, i);
        this.kmZ.getLayoutStrategy().oR(min);
        this.kmZ.getLayoutStrategy().oS((int) (min * 1.618f));
        this.kmZ.setTextSize(TbConfig.getContentSize());
        this.kmZ.setDisplayImage(z, false);
        this.kmZ.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.dWa = view.findViewById(R.id.divider_bottom_first_floor);
        this.kna = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.knc = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.knd = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.kmr = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.ajq = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.knf = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        this.kne = (TextView) view.findViewById(R.id.pb_tail_text);
        this.knj = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.knj.setFrom(1);
        this.knl = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.knk = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.knh = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
        this.agF = (VoteView) view.findViewById(R.id.vote_view);
        this.agF.setPageContext(tbPageContext);
    }

    public void a(@NonNull com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (this.knj != null && fVar != null && fVar.getForum() != null) {
            if (fVar.cLa() && fVar.cKX()) {
                this.knj.setVisibility(8);
                return;
            }
            this.knj.setBottomPlaceHolderVisibility(z2);
            if (z || !com.baidu.tbadk.core.util.x.isEmpty(fVar.cKU())) {
            }
            bv bvVar = new bv();
            bvVar.setId(fVar.getThreadId());
            bvVar.setFid(com.baidu.adp.lib.f.b.toLong(fVar.getForum().getId(), 0L));
            bvVar.wZ(fVar.getForum().getName());
            bvVar.xe(fVar.getForum().getFirst_class());
            bvVar.xf(fVar.getForum().getSecond_class());
            if (fVar.cKx() != null) {
                bvVar.setThreadType(fVar.cKx().threadType);
            }
            if (fVar.khp) {
                this.knj.setVisibility(8);
                this.knk.a(bvVar, fVar.cKw(), fVar.cKX());
                return;
            }
            this.knk.setVisibility(8);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.khq) {
            this.kmX.setImageResource(R.drawable.pic_frs_headlines_n);
            this.kmX.setVisibility(0);
        } else if (z && z2) {
            this.kmX.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.kmX.setVisibility(0);
        } else if (z) {
            this.kmX.setImageResource(R.drawable.pic_pb_refined_n);
            this.kmX.setVisibility(0);
        } else if (z2) {
            this.kmX.setImageResource(R.drawable.pic_pb_stick_n);
            this.kmX.setVisibility(0);
        } else {
            this.kmX.setVisibility(8);
        }
    }

    public void D(boolean z, int i) {
        if (this.kmY != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kmY.getLayoutParams();
                layoutParams.height = i;
                this.kmY.setLayoutParams(layoutParams);
                this.kmY.setVisibility(0);
                return;
            }
            this.kmY.setVisibility(8);
        }
    }
}
