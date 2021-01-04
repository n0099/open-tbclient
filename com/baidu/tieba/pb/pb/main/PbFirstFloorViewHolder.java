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
    public VoteView akk;
    public AppletsCellView ani;
    public View eXI;
    public View lKK;
    private ImageView lLZ;
    public TextView lLn;
    private View lMa;
    public TbRichTextView lMb;
    public TbImageView lMc;
    public TbImageView lMd;
    public ThreadSkinView lMe;
    public LinearLayout lMf;
    public TextView lMg;
    public LinearLayout lMh;
    public q lMi;
    public FrameLayout lMj;
    public com.baidu.tieba.pb.pb.main.c.a lMk;
    public ThreadForumEnterButtonContainer lMl;
    public PbBusinessPromotionContainer lMm;
    public com.baidu.tieba.pb.pb.main.view.a lMn;
    public int mSkinType;

    public PbFirstFloorViewHolder(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.lMi = new q(view);
        this.lLZ = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.lLZ.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -ao.drH());
        this.lLZ.setImageMatrix(matrix);
        this.lMa = view.findViewById(R.id.blank_view_above_rich_text);
        this.lMb = (TbRichTextView) view.findViewById(R.id.richText);
        this.lKK = view;
        int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.lMb.getPaddingLeft()) - this.lMb.getPaddingRight();
        int dimension = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60);
        d dVar = new d(this.lMb.getLayoutStrategy());
        dVar.fYR = equipmentWidth;
        this.lMb.setLayoutStrategy(dVar);
        this.lMd = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(equipmentWidth - dimension, i);
        this.lMb.getLayoutStrategy().tz(min);
        this.lMb.getLayoutStrategy().tA((int) (min * 1.618f));
        this.lMb.setTextSize(TbConfig.getContentSize());
        this.lMb.setDisplayImage(z, false);
        this.lMb.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.eXI = view.findViewById(R.id.divider_bottom_first_floor);
        this.lMc = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.lMe = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.lMf = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.lLn = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.ani = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.lMh = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        this.lMg = (TextView) view.findViewById(R.id.pb_tail_text);
        this.lMl = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.lMl.setFrom(1);
        this.lMn = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.lMm = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.lMj = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
        this.akk = (VoteView) view.findViewById(R.id.vote_view);
        this.akk.setPageContext(tbPageContext);
    }

    public void a(@NonNull com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (this.lMl != null && fVar != null && fVar.getForum() != null) {
            if (fVar.dnh() && fVar.dne()) {
                this.lMl.setVisibility(8);
                return;
            }
            this.lMl.setBottomPlaceHolderVisibility(z2);
            if (z || !com.baidu.tbadk.core.util.x.isEmpty(fVar.dnb())) {
            }
            bz bzVar = new bz();
            bzVar.setId(fVar.getThreadId());
            bzVar.setFid(com.baidu.adp.lib.f.b.toLong(fVar.getForum().getId(), 0L));
            bzVar.Bd(fVar.getForum().getName());
            bzVar.Bi(fVar.getForum().getFirst_class());
            bzVar.Bj(fVar.getForum().getSecond_class());
            if (fVar.dmE() != null) {
                bzVar.setThreadType(fVar.dmE().threadType);
            }
            if (fVar.lFU) {
                this.lMl.setVisibility(8);
                this.lMm.a(bzVar, fVar.dmD(), fVar.dne());
                return;
            }
            this.lMm.setVisibility(8);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.lFV) {
            this.lLZ.setImageResource(R.drawable.pic_frs_headlines_n);
            this.lLZ.setVisibility(0);
        } else if (z && z2) {
            this.lLZ.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.lLZ.setVisibility(0);
        } else if (z) {
            this.lLZ.setImageResource(R.drawable.pic_pb_refined_n);
            this.lLZ.setVisibility(0);
        } else if (z2) {
            this.lLZ.setImageResource(R.drawable.pic_pb_stick_n);
            this.lLZ.setVisibility(0);
        } else {
            this.lLZ.setVisibility(8);
        }
    }

    public void F(boolean z, int i) {
        if (this.lMa != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lMa.getLayoutParams();
                layoutParams.height = i;
                this.lMa.setLayoutParams(layoutParams);
                this.lMa.setVisibility(0);
                return;
            }
            this.lMa.setVisibility(8);
        }
    }
}
