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
/* loaded from: classes21.dex */
public class t extends af.a {
    public VoteView ail;
    public AppletsCellView alg;
    public View ehT;
    public View kJM;
    private ImageView kKV;
    private View kKW;
    public TbRichTextView kKX;
    public TbImageView kKY;
    public TbImageView kKZ;
    public TextView kKq;
    public ThreadSkinView kLa;
    public LinearLayout kLb;
    public TextView kLc;
    public LinearLayout kLd;
    public u kLe;
    public FrameLayout kLf;
    public com.baidu.tieba.pb.pb.main.c.a kLg;
    public ThreadForumEnterButtonContainer kLh;
    public PbBusinessPromotionContainer kLi;
    public com.baidu.tieba.pb.pb.main.view.a kLj;
    public int mSkinType;

    public t(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.kLe = new u(view);
        this.kKV = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.kKV.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -ay.ddM());
        this.kKV.setImageMatrix(matrix);
        this.kKW = view.findViewById(R.id.blank_view_above_rich_text);
        this.kKX = (TbRichTextView) view.findViewById(R.id.richText);
        this.kJM = view;
        int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.kKX.getPaddingLeft()) - this.kKX.getPaddingRight();
        int dimension = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60);
        d dVar = new d(this.kKX.getLayoutStrategy());
        dVar.fhx = equipmentWidth;
        this.kKX.setLayoutStrategy(dVar);
        this.kKZ = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(equipmentWidth - dimension, i);
        this.kKX.getLayoutStrategy().ru(min);
        this.kKX.getLayoutStrategy().rv((int) (min * 1.618f));
        this.kKX.setTextSize(TbConfig.getContentSize());
        this.kKX.setDisplayImage(z, false);
        this.kKX.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.ehT = view.findViewById(R.id.divider_bottom_first_floor);
        this.kKY = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.kLa = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.kLb = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.kKq = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.alg = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.kLd = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        this.kLc = (TextView) view.findViewById(R.id.pb_tail_text);
        this.kLh = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.kLh.setFrom(1);
        this.kLj = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.kLi = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.kLf = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
        this.ail = (VoteView) view.findViewById(R.id.vote_view);
        this.ail.setPageContext(tbPageContext);
    }

    public void a(@NonNull com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (this.kLh != null && fVar != null && fVar.getForum() != null) {
            if (fVar.cZu() && fVar.cZr()) {
                this.kLh.setVisibility(8);
                return;
            }
            this.kLh.setBottomPlaceHolderVisibility(z2);
            if (z || !com.baidu.tbadk.core.util.y.isEmpty(fVar.cZo())) {
            }
            bw bwVar = new bw();
            bwVar.setId(fVar.getThreadId());
            bwVar.setFid(com.baidu.adp.lib.f.b.toLong(fVar.getForum().getId(), 0L));
            bwVar.zJ(fVar.getForum().getName());
            bwVar.zO(fVar.getForum().getFirst_class());
            bwVar.zP(fVar.getForum().getSecond_class());
            if (fVar.cYR() != null) {
                bwVar.setThreadType(fVar.cYR().threadType);
            }
            if (fVar.kFq) {
                this.kLh.setVisibility(8);
                this.kLi.a(bwVar, fVar.cYQ(), fVar.cZr());
                return;
            }
            this.kLi.setVisibility(8);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.kFr) {
            this.kKV.setImageResource(R.drawable.pic_frs_headlines_n);
            this.kKV.setVisibility(0);
        } else if (z && z2) {
            this.kKV.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.kKV.setVisibility(0);
        } else if (z) {
            this.kKV.setImageResource(R.drawable.pic_pb_refined_n);
            this.kKV.setVisibility(0);
        } else if (z2) {
            this.kKV.setImageResource(R.drawable.pic_pb_stick_n);
            this.kKV.setVisibility(0);
        } else {
            this.kKV.setVisibility(8);
        }
    }

    public void D(boolean z, int i) {
        if (this.kKW != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kKW.getLayoutParams();
                layoutParams.height = i;
                this.kKW.setLayoutParams(layoutParams);
                this.kKW.setVisibility(0);
                return;
            }
            this.kKW.setVisibility(8);
        }
    }
}
