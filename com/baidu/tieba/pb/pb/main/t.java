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
    public VoteView ahO;
    public AppletsCellView akF;
    public View efA;
    public TextView kBL;
    public View kBh;
    public FrameLayout kCA;
    public com.baidu.tieba.pb.pb.main.c.a kCB;
    public ThreadForumEnterButtonContainer kCC;
    public PbBusinessPromotionContainer kCD;
    public com.baidu.tieba.pb.pb.main.view.a kCE;
    private ImageView kCq;
    private View kCr;
    public TbRichTextView kCs;
    public TbImageView kCt;
    public TbImageView kCu;
    public ThreadSkinView kCv;
    public LinearLayout kCw;
    public TextView kCx;
    public LinearLayout kCy;
    public u kCz;
    public int mSkinType;

    public t(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.kCz = new u(view);
        this.kCq = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.kCq.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -ay.dai());
        this.kCq.setImageMatrix(matrix);
        this.kCr = view.findViewById(R.id.blank_view_above_rich_text);
        this.kCs = (TbRichTextView) view.findViewById(R.id.richText);
        this.kBh = view;
        int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.kCs.getPaddingLeft()) - this.kCs.getPaddingRight();
        int dimension = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60);
        d dVar = new d(this.kCs.getLayoutStrategy());
        dVar.feB = equipmentWidth;
        this.kCs.setLayoutStrategy(dVar);
        this.kCu = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(equipmentWidth - dimension, i);
        this.kCs.getLayoutStrategy().rd(min);
        this.kCs.getLayoutStrategy().re((int) (min * 1.618f));
        this.kCs.setTextSize(TbConfig.getContentSize());
        this.kCs.setDisplayImage(z, false);
        this.kCs.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.efA = view.findViewById(R.id.divider_bottom_first_floor);
        this.kCt = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.kCv = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.kCw = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.kBL = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.akF = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.kCy = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        this.kCx = (TextView) view.findViewById(R.id.pb_tail_text);
        this.kCC = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.kCC.setFrom(1);
        this.kCE = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.kCD = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.kCA = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
        this.ahO = (VoteView) view.findViewById(R.id.vote_view);
        this.ahO.setPageContext(tbPageContext);
    }

    public void a(@NonNull com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (this.kCC != null && fVar != null && fVar.getForum() != null) {
            if (fVar.cVO() && fVar.cVL()) {
                this.kCC.setVisibility(8);
                return;
            }
            this.kCC.setBottomPlaceHolderVisibility(z2);
            if (z || !com.baidu.tbadk.core.util.y.isEmpty(fVar.cVI())) {
            }
            bw bwVar = new bw();
            bwVar.setId(fVar.getThreadId());
            bwVar.setFid(com.baidu.adp.lib.f.b.toLong(fVar.getForum().getId(), 0L));
            bwVar.zn(fVar.getForum().getName());
            bwVar.zs(fVar.getForum().getFirst_class());
            bwVar.zt(fVar.getForum().getSecond_class());
            if (fVar.cVl() != null) {
                bwVar.setThreadType(fVar.cVl().threadType);
            }
            if (fVar.kwK) {
                this.kCC.setVisibility(8);
                this.kCD.a(bwVar, fVar.cVk(), fVar.cVL());
                return;
            }
            this.kCD.setVisibility(8);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.kwL) {
            this.kCq.setImageResource(R.drawable.pic_frs_headlines_n);
            this.kCq.setVisibility(0);
        } else if (z && z2) {
            this.kCq.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.kCq.setVisibility(0);
        } else if (z) {
            this.kCq.setImageResource(R.drawable.pic_pb_refined_n);
            this.kCq.setVisibility(0);
        } else if (z2) {
            this.kCq.setImageResource(R.drawable.pic_pb_stick_n);
            this.kCq.setVisibility(0);
        } else {
            this.kCq.setVisibility(8);
        }
    }

    public void D(boolean z, int i) {
        if (this.kCr != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kCr.getLayoutParams();
                layoutParams.height = i;
                this.kCr.setLayoutParams(layoutParams);
                this.kCr.setVisibility(0);
                return;
            }
            this.kCr.setVisibility(8);
        }
    }
}
