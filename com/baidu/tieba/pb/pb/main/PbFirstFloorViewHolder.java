package com.baidu.tieba.pb.pb.main;

import android.graphics.Matrix;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
/* loaded from: classes2.dex */
public class PbFirstFloorViewHolder extends TypeAdapter.ViewHolder {
    public VoteView ajt;
    public AppletsCellView amr;
    public View eSX;
    public TextView lGI;
    public View lGf;
    public LinearLayout lHA;
    public TextView lHB;
    public LinearLayout lHC;
    public q lHD;
    public FrameLayout lHE;
    public com.baidu.tieba.pb.pb.main.c.a lHF;
    public ThreadForumEnterButtonContainer lHG;
    public PbBusinessPromotionContainer lHH;
    public com.baidu.tieba.pb.pb.main.view.a lHI;
    private ImageView lHu;
    private View lHv;
    public TbRichTextView lHw;
    public TbImageView lHx;
    public TbImageView lHy;
    public ThreadSkinView lHz;
    public int mSkinType;

    public PbFirstFloorViewHolder(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.lHD = new q(view);
        this.lHu = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.lHu.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -ao.dnQ());
        this.lHu.setImageMatrix(matrix);
        this.lHv = view.findViewById(R.id.blank_view_above_rich_text);
        this.lHw = (TbRichTextView) view.findViewById(R.id.richText);
        this.lGf = view;
        int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.lHw.getPaddingLeft()) - this.lHw.getPaddingRight();
        int dimension = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60);
        d dVar = new d(this.lHw.getLayoutStrategy());
        dVar.fUk = equipmentWidth;
        this.lHw.setLayoutStrategy(dVar);
        this.lHy = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(equipmentWidth - dimension, i);
        this.lHw.getLayoutStrategy().rT(min);
        this.lHw.getLayoutStrategy().rU((int) (min * 1.618f));
        this.lHw.setTextSize(TbConfig.getContentSize());
        this.lHw.setDisplayImage(z, false);
        this.lHw.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.eSX = view.findViewById(R.id.divider_bottom_first_floor);
        this.lHx = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.lHz = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.lHA = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.lGI = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.amr = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.lHC = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        this.lHB = (TextView) view.findViewById(R.id.pb_tail_text);
        this.lHG = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.lHG.setFrom(1);
        this.lHI = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.lHH = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.lHE = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
        this.ajt = (VoteView) view.findViewById(R.id.vote_view);
        this.ajt.setPageContext(tbPageContext);
    }

    public void a(@NonNull com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (this.lHG != null && fVar != null && fVar.getForum() != null) {
            if (fVar.djq() && fVar.djn()) {
                this.lHG.setVisibility(8);
                return;
            }
            this.lHG.setBottomPlaceHolderVisibility(z2);
            if (z || !com.baidu.tbadk.core.util.x.isEmpty(fVar.djk())) {
            }
            bz bzVar = new bz();
            bzVar.setId(fVar.getThreadId());
            bzVar.setFid(com.baidu.adp.lib.f.b.toLong(fVar.getForum().getId(), 0L));
            bzVar.zR(fVar.getForum().getName());
            bzVar.zW(fVar.getForum().getFirst_class());
            bzVar.zX(fVar.getForum().getSecond_class());
            if (fVar.diN() != null) {
                bzVar.setThreadType(fVar.diN().threadType);
            }
            if (fVar.lBo) {
                this.lHG.setVisibility(8);
                this.lHH.a(bzVar, fVar.diM(), fVar.djn());
                return;
            }
            this.lHH.setVisibility(8);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.lBp) {
            this.lHu.setImageResource(R.drawable.pic_frs_headlines_n);
            this.lHu.setVisibility(0);
        } else if (z && z2) {
            this.lHu.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.lHu.setVisibility(0);
        } else if (z) {
            this.lHu.setImageResource(R.drawable.pic_pb_refined_n);
            this.lHu.setVisibility(0);
        } else if (z2) {
            this.lHu.setImageResource(R.drawable.pic_pb_stick_n);
            this.lHu.setVisibility(0);
        } else {
            this.lHu.setVisibility(8);
        }
    }

    public void F(boolean z, int i) {
        if (this.lHv != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lHv.getLayoutParams();
                layoutParams.height = i;
                this.lHv.setLayoutParams(layoutParams);
                this.lHv.setVisibility(0);
                return;
            }
            this.lHv.setVisibility(8);
        }
    }
}
