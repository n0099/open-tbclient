package com.baidu.tieba.pb.pb.main;

import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbBusinessPromotionContainer;
/* loaded from: classes4.dex */
public class p extends v.a {
    public AppletsCellView IU;
    public View cfA;
    public View hOV;
    public LinearLayout hOW;
    public View hPP;
    private ImageView hPQ;
    private View hPR;
    public TbRichTextView hPS;
    public TbImageView hPT;
    public TbImageView hPU;
    public ThreadSkinView hPV;
    public TextView hPW;
    public q hPX;
    public ThreadForumEnterButtonContainer hPY;
    public PbBusinessPromotionContainer hPZ;
    public TextView hPo;
    public com.baidu.tieba.pb.pb.main.view.a hQa;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.hPX = new q(view);
        this.hPQ = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.hPQ.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds194));
        this.hPQ.setImageMatrix(matrix);
        this.hPR = view.findViewById(R.id.blank_view_above_rich_text);
        this.hPS = (TbRichTextView) view.findViewById(R.id.richText);
        this.hOV = view;
        this.hPP = view.findViewById(R.id.new_pb_list_item_blank_top);
        this.hPS.setLayoutStrategy(new c(this.hPS.getLayoutStrategy()));
        this.hPU = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.hPS.getPaddingLeft()) - this.hPS.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.hPS.getLayoutStrategy().kD(min);
        this.hPS.getLayoutStrategy().kE((int) (min * 1.618f));
        this.hPS.setTextSize(TbConfig.getContentSize());
        this.hPS.setDisplayImage(z, false);
        this.hPS.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.cfA = view.findViewById(R.id.divider_bottom_first_floor);
        this.hPT = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.hPV = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.hOW = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.hPo = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.IU = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.hPW = (TextView) view.findViewById(R.id.pb_tail_text);
        this.hPY = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.hPY.setFrom(1);
        this.hQa = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.hPZ = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
    }

    public void b(@NonNull com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (this.hPY != null && dVar != null && dVar.getForum() != null) {
            boolean z2 = false;
            if (!z && !com.baidu.tbadk.core.util.v.isEmpty(dVar.bQU())) {
                z2 = true;
            }
            bh bhVar = new bh();
            bhVar.setId(dVar.getThreadId());
            bhVar.setFid(com.baidu.adp.lib.g.b.toLong(dVar.getForum().getId(), 0L));
            bhVar.mZ(dVar.getForum().getName());
            if (z2) {
                this.hPY.a(bhVar, dVar.bQU());
            } else {
                this.hPY.z(bhVar);
            }
            if (dVar.hJt) {
                this.hPY.setVisibility(8);
                this.hPZ.a(bhVar, dVar.bQy(), dVar.bQX());
                return;
            }
            this.hPZ.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, boolean z, boolean z2) {
        if (dVar != null && dVar.hJu) {
            this.hPQ.setImageResource(R.drawable.pic_frs_headlines_n);
            this.hPQ.setVisibility(0);
        } else if (z && z2) {
            this.hPQ.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.hPQ.setVisibility(0);
        } else if (z) {
            this.hPQ.setImageResource(R.drawable.pic_pb_refined_n);
            this.hPQ.setVisibility(0);
        } else if (z2) {
            this.hPQ.setImageResource(R.drawable.pic_pb_stick_n);
            this.hPQ.setVisibility(0);
        } else {
            this.hPQ.setVisibility(8);
        }
    }

    public void r(boolean z, int i) {
        if (this.hPR != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hPR.getLayoutParams();
                layoutParams.height = i;
                this.hPR.setLayoutParams(layoutParams);
                this.hPR.setVisibility(0);
                return;
            }
            this.hPR.setVisibility(8);
        }
    }
}
