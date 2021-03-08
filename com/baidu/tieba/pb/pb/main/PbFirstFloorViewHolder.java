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
    public VoteView akA;
    public AppletsCellView anz;
    public View eWL;
    public TextView lRQ;
    public View lRn;
    private ImageView lSF;
    private View lSG;
    public TbRichTextView lSH;
    public TbImageView lSI;
    public TbImageView lSJ;
    public ThreadSkinView lSK;
    public LinearLayout lSL;
    public TextView lSM;
    public LinearLayout lSN;
    public q lSO;
    public FrameLayout lSP;
    public com.baidu.tieba.pb.pb.main.c.a lSQ;
    public ThreadForumEnterButtonContainer lSR;
    public PbBusinessPromotionContainer lSS;
    public com.baidu.tieba.pb.pb.main.view.a lST;
    public int mSkinType;

    public PbFirstFloorViewHolder(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.lSO = new q(view);
        this.lSF = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.lSF.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -ao.dqu());
        this.lSF.setImageMatrix(matrix);
        this.lSG = view.findViewById(R.id.blank_view_above_rich_text);
        this.lSH = (TbRichTextView) view.findViewById(R.id.richText);
        this.lRn = view;
        int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.lSH.getPaddingLeft()) - this.lSH.getPaddingRight();
        int dimension = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60);
        d dVar = new d(this.lSH.getLayoutStrategy());
        dVar.fXZ = equipmentWidth;
        this.lSH.setLayoutStrategy(dVar);
        this.lSJ = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(equipmentWidth - dimension, i);
        this.lSH.getLayoutStrategy().sa(min);
        this.lSH.getLayoutStrategy().sb((int) (min * 1.618f));
        this.lSH.setTextSize(TbConfig.getContentSize());
        this.lSH.setDisplayImage(z, false);
        this.lSH.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.eWL = view.findViewById(R.id.divider_bottom_first_floor);
        this.lSI = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.lSK = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.lSL = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.lRQ = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.anz = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.lSN = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        this.lSM = (TextView) view.findViewById(R.id.pb_tail_text);
        this.lSR = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.lSR.setFrom(1);
        this.lST = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.lSS = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.lSP = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
        this.akA = (VoteView) view.findViewById(R.id.vote_view);
        this.akA.setPageContext(tbPageContext);
    }

    public void a(@NonNull com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (this.lSR != null && fVar != null && fVar.getForum() != null) {
            if (fVar.dlS() && fVar.dlP()) {
                this.lSR.setVisibility(8);
                return;
            }
            this.lSR.setBottomPlaceHolderVisibility(z2);
            if (z || !com.baidu.tbadk.core.util.y.isEmpty(fVar.dlM())) {
            }
            cb cbVar = new cb();
            cbVar.setId(fVar.getThreadId());
            cbVar.setFid(com.baidu.adp.lib.f.b.toLong(fVar.getForum().getId(), 0L));
            cbVar.Ap(fVar.getForum().getName());
            cbVar.Au(fVar.getForum().getFirst_class());
            cbVar.Av(fVar.getForum().getSecond_class());
            if (fVar.dlp() != null) {
                cbVar.setThreadType(fVar.dlp().threadType);
            }
            if (fVar.lMr) {
                this.lSR.setVisibility(8);
                this.lSS.a(cbVar, fVar.dlo(), fVar.dlP());
                return;
            }
            this.lSS.setVisibility(8);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.lMs) {
            this.lSF.setImageResource(R.drawable.pic_frs_headlines_n);
            this.lSF.setVisibility(0);
        } else if (z && z2) {
            this.lSF.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.lSF.setVisibility(0);
        } else if (z) {
            this.lSF.setImageResource(R.drawable.pic_pb_refined_n);
            this.lSF.setVisibility(0);
        } else if (z2) {
            this.lSF.setImageResource(R.drawable.pic_pb_stick_n);
            this.lSF.setVisibility(0);
        } else {
            this.lSF.setVisibility(8);
        }
    }

    public void F(boolean z, int i) {
        if (this.lSG != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lSG.getLayoutParams();
                layoutParams.height = i;
                this.lSG.setLayoutParams(layoutParams);
                this.lSG.setVisibility(0);
                return;
            }
            this.lSG.setVisibility(8);
        }
    }
}
