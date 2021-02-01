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
import com.baidu.tbadk.core.data.cb;
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
    public VoteView aji;
    public AppletsCellView amh;
    public View eVm;
    public View lOW;
    public TextView lPz;
    public ThreadForumEnterButtonContainer lQA;
    public PbBusinessPromotionContainer lQB;
    public com.baidu.tieba.pb.pb.main.view.a lQC;
    private ImageView lQo;
    private View lQp;
    public TbRichTextView lQq;
    public TbImageView lQr;
    public TbImageView lQs;
    public ThreadSkinView lQt;
    public LinearLayout lQu;
    public TextView lQv;
    public LinearLayout lQw;
    public q lQx;
    public FrameLayout lQy;
    public com.baidu.tieba.pb.pb.main.c.a lQz;
    public int mSkinType;

    public PbFirstFloorViewHolder(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.lQx = new q(view);
        this.lQo = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.lQo.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -ao.dqe());
        this.lQo.setImageMatrix(matrix);
        this.lQp = view.findViewById(R.id.blank_view_above_rich_text);
        this.lQq = (TbRichTextView) view.findViewById(R.id.richText);
        this.lOW = view;
        int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.lQq.getPaddingLeft()) - this.lQq.getPaddingRight();
        int dimension = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60);
        d dVar = new d(this.lQq.getLayoutStrategy());
        dVar.fWz = equipmentWidth;
        this.lQq.setLayoutStrategy(dVar);
        this.lQs = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(equipmentWidth - dimension, i);
        this.lQq.getLayoutStrategy().rY(min);
        this.lQq.getLayoutStrategy().rZ((int) (min * 1.618f));
        this.lQq.setTextSize(TbConfig.getContentSize());
        this.lQq.setDisplayImage(z, false);
        this.lQq.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.eVm = view.findViewById(R.id.divider_bottom_first_floor);
        this.lQr = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.lQt = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.lQu = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.lPz = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.amh = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.lQw = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        this.lQv = (TextView) view.findViewById(R.id.pb_tail_text);
        this.lQA = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.lQA.setFrom(1);
        this.lQC = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.lQB = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.lQy = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
        this.aji = (VoteView) view.findViewById(R.id.vote_view);
        this.aji.setPageContext(tbPageContext);
    }

    public void a(@NonNull com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (this.lQA != null && fVar != null && fVar.getForum() != null) {
            if (fVar.dlC() && fVar.dlz()) {
                this.lQA.setVisibility(8);
                return;
            }
            this.lQA.setBottomPlaceHolderVisibility(z2);
            if (z || !com.baidu.tbadk.core.util.y.isEmpty(fVar.dlw())) {
            }
            cb cbVar = new cb();
            cbVar.setId(fVar.getThreadId());
            cbVar.setFid(com.baidu.adp.lib.f.b.toLong(fVar.getForum().getId(), 0L));
            cbVar.Ai(fVar.getForum().getName());
            cbVar.An(fVar.getForum().getFirst_class());
            cbVar.Ao(fVar.getForum().getSecond_class());
            if (fVar.dkZ() != null) {
                cbVar.setThreadType(fVar.dkZ().threadType);
            }
            if (fVar.lKb) {
                this.lQA.setVisibility(8);
                this.lQB.a(cbVar, fVar.dkY(), fVar.dlz());
                return;
            }
            this.lQB.setVisibility(8);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.lKc) {
            this.lQo.setImageResource(R.drawable.pic_frs_headlines_n);
            this.lQo.setVisibility(0);
        } else if (z && z2) {
            this.lQo.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.lQo.setVisibility(0);
        } else if (z) {
            this.lQo.setImageResource(R.drawable.pic_pb_refined_n);
            this.lQo.setVisibility(0);
        } else if (z2) {
            this.lQo.setImageResource(R.drawable.pic_pb_stick_n);
            this.lQo.setVisibility(0);
        } else {
            this.lQo.setVisibility(8);
        }
    }

    public void F(boolean z, int i) {
        if (this.lQp != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lQp.getLayoutParams();
                layoutParams.height = i;
                this.lQp.setLayoutParams(layoutParams);
                this.lQp.setVisibility(0);
                return;
            }
            this.lQp.setVisibility(8);
        }
    }
}
