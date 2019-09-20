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
    public AppletsCellView YV;
    public View bOw;
    public TextView hQJ;
    public View hQq;
    public LinearLayout hQr;
    public View hRk;
    private ImageView hRl;
    private View hRm;
    public TbRichTextView hRn;
    public TbImageView hRo;
    public TbImageView hRp;
    public ThreadSkinView hRq;
    public TextView hRr;
    public q hRs;
    public ThreadForumEnterButtonContainer hRt;
    public PbBusinessPromotionContainer hRu;
    public com.baidu.tieba.pb.pb.main.view.a hRv;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.hRs = new q(view);
        this.hRl = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.hRl.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds194));
        this.hRl.setImageMatrix(matrix);
        this.hRm = view.findViewById(R.id.blank_view_above_rich_text);
        this.hRn = (TbRichTextView) view.findViewById(R.id.richText);
        this.hQq = view;
        this.hRk = view.findViewById(R.id.new_pb_list_item_blank_top);
        this.hRn.setLayoutStrategy(new c(this.hRn.getLayoutStrategy()));
        this.hRp = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.hRn.getPaddingLeft()) - this.hRn.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.hRn.getLayoutStrategy().ly(min);
        this.hRn.getLayoutStrategy().lz((int) (min * 1.618f));
        this.hRn.setTextSize(TbConfig.getContentSize());
        this.hRn.setDisplayImage(z, false);
        this.hRn.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.bOw = view.findViewById(R.id.divider_bottom_first_floor);
        this.hRo = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.hRq = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.hQr = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.hQJ = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.YV = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.hRr = (TextView) view.findViewById(R.id.pb_tail_text);
        this.hRt = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.hRt.setFrom(1);
        this.hRv = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.hRu = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
    }

    public void b(@NonNull com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (this.hRt != null && dVar != null && dVar.getForum() != null) {
            boolean z2 = false;
            if (!z && !com.baidu.tbadk.core.util.v.aa(dVar.bTT())) {
                z2 = true;
            }
            bh bhVar = new bh();
            bhVar.setId(dVar.getThreadId());
            bhVar.setFid(com.baidu.adp.lib.g.b.e(dVar.getForum().getId(), 0L));
            bhVar.mB(dVar.getForum().getName());
            if (z2) {
                this.hRt.a(bhVar, dVar.bTT());
            } else {
                this.hRt.z(bhVar);
            }
            if (dVar.hKO) {
                this.hRt.setVisibility(8);
                this.hRu.a(bhVar, dVar.bTx(), dVar.bTW());
                return;
            }
            this.hRu.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.pb.data.d dVar, boolean z, boolean z2) {
        if (dVar != null && dVar.hKP) {
            this.hRl.setImageResource(R.drawable.pic_frs_headlines_n);
            this.hRl.setVisibility(0);
        } else if (z && z2) {
            this.hRl.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.hRl.setVisibility(0);
        } else if (z) {
            this.hRl.setImageResource(R.drawable.pic_pb_refined_n);
            this.hRl.setVisibility(0);
        } else if (z2) {
            this.hRl.setImageResource(R.drawable.pic_pb_stick_n);
            this.hRl.setVisibility(0);
        } else {
            this.hRl.setVisibility(8);
        }
    }

    public void q(boolean z, int i) {
        if (this.hRm != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hRm.getLayoutParams();
                layoutParams.height = i;
                this.hRm.setLayoutParams(layoutParams);
                this.hRm.setVisibility(0);
                return;
            }
            this.hRm.setVisibility(8);
        }
    }
}
