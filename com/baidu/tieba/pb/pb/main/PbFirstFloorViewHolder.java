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
    public View lKJ;
    private ImageView lLY;
    private View lLZ;
    public TextView lLm;
    public TbRichTextView lMa;
    public TbImageView lMb;
    public TbImageView lMc;
    public ThreadSkinView lMd;
    public LinearLayout lMe;
    public TextView lMf;
    public LinearLayout lMg;
    public q lMh;
    public FrameLayout lMi;
    public com.baidu.tieba.pb.pb.main.c.a lMj;
    public ThreadForumEnterButtonContainer lMk;
    public PbBusinessPromotionContainer lMl;
    public com.baidu.tieba.pb.pb.main.view.a lMm;
    public int mSkinType;

    public PbFirstFloorViewHolder(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.lMh = new q(view);
        this.lLY = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.lLY.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -ao.drI());
        this.lLY.setImageMatrix(matrix);
        this.lLZ = view.findViewById(R.id.blank_view_above_rich_text);
        this.lMa = (TbRichTextView) view.findViewById(R.id.richText);
        this.lKJ = view;
        int equipmentWidth = (((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.lMa.getPaddingLeft()) - this.lMa.getPaddingRight();
        int dimension = (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60);
        d dVar = new d(this.lMa.getLayoutStrategy());
        dVar.fYR = equipmentWidth;
        this.lMa.setLayoutStrategy(dVar);
        this.lMc = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(equipmentWidth - dimension, i);
        this.lMa.getLayoutStrategy().tz(min);
        this.lMa.getLayoutStrategy().tA((int) (min * 1.618f));
        this.lMa.setTextSize(TbConfig.getContentSize());
        this.lMa.setDisplayImage(z, false);
        this.lMa.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.eXI = view.findViewById(R.id.divider_bottom_first_floor);
        this.lMb = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.lMd = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.lMe = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.lLm = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.ani = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.lMg = (LinearLayout) view.findViewById(R.id.pb_link_container_layout);
        this.lMf = (TextView) view.findViewById(R.id.pb_tail_text);
        this.lMk = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.lMk.setFrom(1);
        this.lMm = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.lMl = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
        this.lMi = (FrameLayout) view.findViewById(R.id.original_thread_root_view);
        this.akk = (VoteView) view.findViewById(R.id.vote_view);
        this.akk.setPageContext(tbPageContext);
    }

    public void a(@NonNull com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (this.lMk != null && fVar != null && fVar.getForum() != null) {
            if (fVar.dni() && fVar.dnf()) {
                this.lMk.setVisibility(8);
                return;
            }
            this.lMk.setBottomPlaceHolderVisibility(z2);
            if (z || !com.baidu.tbadk.core.util.x.isEmpty(fVar.dnc())) {
            }
            bz bzVar = new bz();
            bzVar.setId(fVar.getThreadId());
            bzVar.setFid(com.baidu.adp.lib.f.b.toLong(fVar.getForum().getId(), 0L));
            bzVar.Bc(fVar.getForum().getName());
            bzVar.Bh(fVar.getForum().getFirst_class());
            bzVar.Bi(fVar.getForum().getSecond_class());
            if (fVar.dmF() != null) {
                bzVar.setThreadType(fVar.dmF().threadType);
            }
            if (fVar.lFT) {
                this.lMk.setVisibility(8);
                this.lMl.a(bzVar, fVar.dmE(), fVar.dnf());
                return;
            }
            this.lMl.setVisibility(8);
        }
    }

    public void b(com.baidu.tieba.pb.data.f fVar, boolean z, boolean z2) {
        if (fVar != null && fVar.lFU) {
            this.lLY.setImageResource(R.drawable.pic_frs_headlines_n);
            this.lLY.setVisibility(0);
        } else if (z && z2) {
            this.lLY.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.lLY.setVisibility(0);
        } else if (z) {
            this.lLY.setImageResource(R.drawable.pic_pb_refined_n);
            this.lLY.setVisibility(0);
        } else if (z2) {
            this.lLY.setImageResource(R.drawable.pic_pb_stick_n);
            this.lLY.setVisibility(0);
        } else {
            this.lLY.setVisibility(8);
        }
    }

    public void F(boolean z, int i) {
        if (this.lLZ != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lLZ.getLayoutParams();
                layoutParams.height = i;
                this.lLZ.setLayoutParams(layoutParams);
                this.lLZ.setVisibility(0);
                return;
            }
            this.lLZ.setVisibility(8);
        }
    }
}
