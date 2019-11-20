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
    public AppletsCellView Ir;
    public View ceJ;
    public View hOY;
    private ImageView hOZ;
    public View hOe;
    public LinearLayout hOf;
    public TextView hOx;
    private View hPa;
    public TbRichTextView hPb;
    public TbImageView hPc;
    public TbImageView hPd;
    public ThreadSkinView hPe;
    public TextView hPf;
    public q hPg;
    public ThreadForumEnterButtonContainer hPh;
    public PbBusinessPromotionContainer hPi;
    public com.baidu.tieba.pb.pb.main.view.a hPj;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.hPg = new q(view);
        this.hOZ = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.hOZ.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds194));
        this.hOZ.setImageMatrix(matrix);
        this.hPa = view.findViewById(R.id.blank_view_above_rich_text);
        this.hPb = (TbRichTextView) view.findViewById(R.id.richText);
        this.hOe = view;
        this.hOY = view.findViewById(R.id.new_pb_list_item_blank_top);
        this.hPb.setLayoutStrategy(new c(this.hPb.getLayoutStrategy()));
        this.hPd = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.hPb.getPaddingLeft()) - this.hPb.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.hPb.getLayoutStrategy().kC(min);
        this.hPb.getLayoutStrategy().kD((int) (min * 1.618f));
        this.hPb.setTextSize(TbConfig.getContentSize());
        this.hPb.setDisplayImage(z, false);
        this.hPb.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.ceJ = view.findViewById(R.id.divider_bottom_first_floor);
        this.hPc = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.hPe = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.hOf = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.hOx = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.Ir = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.hPf = (TextView) view.findViewById(R.id.pb_tail_text);
        this.hPh = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.hPh.setFrom(1);
        this.hPj = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.hPi = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
    }

    public void b(@NonNull com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (this.hPh != null && dVar != null && dVar.getForum() != null) {
            boolean z2 = false;
            if (!z && !com.baidu.tbadk.core.util.v.isEmpty(dVar.bQS())) {
                z2 = true;
            }
            bh bhVar = new bh();
            bhVar.setId(dVar.getThreadId());
            bhVar.setFid(com.baidu.adp.lib.g.b.toLong(dVar.getForum().getId(), 0L));
            bhVar.mZ(dVar.getForum().getName());
            if (z2) {
                this.hPh.a(bhVar, dVar.bQS());
            } else {
                this.hPh.z(bhVar);
            }
            if (dVar.hIC) {
                this.hPh.setVisibility(8);
                this.hPi.a(bhVar, dVar.bQw(), dVar.bQV());
                return;
            }
            this.hPi.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, boolean z, boolean z2) {
        if (dVar != null && dVar.hID) {
            this.hOZ.setImageResource(R.drawable.pic_frs_headlines_n);
            this.hOZ.setVisibility(0);
        } else if (z && z2) {
            this.hOZ.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.hOZ.setVisibility(0);
        } else if (z) {
            this.hOZ.setImageResource(R.drawable.pic_pb_refined_n);
            this.hOZ.setVisibility(0);
        } else if (z2) {
            this.hOZ.setImageResource(R.drawable.pic_pb_stick_n);
            this.hOZ.setVisibility(0);
        } else {
            this.hOZ.setVisibility(8);
        }
    }

    public void r(boolean z, int i) {
        if (this.hPa != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hPa.getLayoutParams();
                layoutParams.height = i;
                this.hPa.setLayoutParams(layoutParams);
                this.hPa.setVisibility(0);
                return;
            }
            this.hPa.setVisibility(8);
        }
    }
}
