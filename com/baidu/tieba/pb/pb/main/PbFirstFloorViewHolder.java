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
    public TextView lPO;
    public View lPl;
    private ImageView lQD;
    private View lQE;
    public TbRichTextView lQF;
    public TbImageView lQG;
    public TbImageView lQH;
    public ThreadSkinView lQI;
    public LinearLayout lQJ;
    public TextView lQK;
    public LinearLayout lQL;
    public q lQM;
    public FrameLayout lQN;
    public com.baidu.tieba.pb.pb.main.c.a lQO;
    public ThreadForumEnterButtonContainer lQP;
    public PbBusinessPromotionContainer lQQ;
    public com.baidu.tieba.pb.pb.main.view.a lQR;
    public int mSkinType;

    public PbFirstFloorViewHolder(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.lQM = new q(view);
        this.lQD = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.lQD.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -ao.dql());
        this.lQD.setImageMatrix(matrix);
        this.lQE = view.findViewById(R.id.blank_view_above_rich_text);
        this.lQF = (TbRichTextView) view.findViewById(R.id.richText);
        this.lPl = view;
        int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.lQF.getPaddingLeft()) - this.lQF.getPaddingRight();
        int dimension = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60);
        d dVar = new d(this.lQF.getLayoutStrategy());
        dVar.fWz = equipmentWidth;
        this.lQF.setLayoutStrategy(dVar);
        this.lQH = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(equipmentWidth - dimension, i);
        this.lQF.getLayoutStrategy().rY(min);
        this.lQF.getLayoutStrategy().rZ((int) (min * 1.618f));
        this.lQF.setTextSize(TbConfig.getContentSize());
        this.lQF.setDisplayImage(z, false);
        this.lQF.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.eVm = view.findViewById(R.id.divider_bottom_first_floor);
        this.lQG = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.lQI = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.lQJ = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.lPO = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.amh = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.lQL = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        this.lQK = (TextView) view.findViewById(R.id.pb_tail_text);
        this.lQP = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.lQP.setFrom(1);
        this.lQR = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.lQQ = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.lQN = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
        this.aji = (VoteView) view.findViewById(R.id.vote_view);
        this.aji.setPageContext(tbPageContext);
    }

    public void a(@NonNull com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (this.lQP != null && fVar != null && fVar.getForum() != null) {
            if (fVar.dlJ() && fVar.dlG()) {
                this.lQP.setVisibility(8);
                return;
            }
            this.lQP.setBottomPlaceHolderVisibility(z2);
            if (z || !com.baidu.tbadk.core.util.y.isEmpty(fVar.dlD())) {
            }
            cb cbVar = new cb();
            cbVar.setId(fVar.getThreadId());
            cbVar.setFid(com.baidu.adp.lib.f.b.toLong(fVar.getForum().getId(), 0L));
            cbVar.Ai(fVar.getForum().getName());
            cbVar.An(fVar.getForum().getFirst_class());
            cbVar.Ao(fVar.getForum().getSecond_class());
            if (fVar.dlg() != null) {
                cbVar.setThreadType(fVar.dlg().threadType);
            }
            if (fVar.lKp) {
                this.lQP.setVisibility(8);
                this.lQQ.a(cbVar, fVar.dlf(), fVar.dlG());
                return;
            }
            this.lQQ.setVisibility(8);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.lKq) {
            this.lQD.setImageResource(R.drawable.pic_frs_headlines_n);
            this.lQD.setVisibility(0);
        } else if (z && z2) {
            this.lQD.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.lQD.setVisibility(0);
        } else if (z) {
            this.lQD.setImageResource(R.drawable.pic_pb_refined_n);
            this.lQD.setVisibility(0);
        } else if (z2) {
            this.lQD.setImageResource(R.drawable.pic_pb_stick_n);
            this.lQD.setVisibility(0);
        } else {
            this.lQD.setVisibility(8);
        }
    }

    public void F(boolean z, int i) {
        if (this.lQE != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lQE.getLayoutParams();
                layoutParams.height = i;
                this.lQE.setLayoutParams(layoutParams);
                this.lQE.setVisibility(0);
                return;
            }
            this.lQE.setVisibility(8);
        }
    }
}
