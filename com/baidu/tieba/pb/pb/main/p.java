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
    public View bNX;
    public TextView hOM;
    public View hOt;
    public LinearLayout hOu;
    public View hPn;
    private ImageView hPo;
    private View hPp;
    public TbRichTextView hPq;
    public TbImageView hPr;
    public TbImageView hPs;
    public ThreadSkinView hPt;
    public TextView hPu;
    public q hPv;
    public ThreadForumEnterButtonContainer hPw;
    public PbBusinessPromotionContainer hPx;
    public com.baidu.tieba.pb.pb.main.view.a hPy;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.hPv = new q(view);
        this.hPo = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.hPo.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds194));
        this.hPo.setImageMatrix(matrix);
        this.hPp = view.findViewById(R.id.blank_view_above_rich_text);
        this.hPq = (TbRichTextView) view.findViewById(R.id.richText);
        this.hOt = view;
        this.hPn = view.findViewById(R.id.new_pb_list_item_blank_top);
        this.hPq.setLayoutStrategy(new c(this.hPq.getLayoutStrategy()));
        this.hPs = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.hPq.getPaddingLeft()) - this.hPq.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.hPq.getLayoutStrategy().lu(min);
        this.hPq.getLayoutStrategy().lv((int) (min * 1.618f));
        this.hPq.setTextSize(TbConfig.getContentSize());
        this.hPq.setDisplayImage(z, false);
        this.hPq.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.bNX = view.findViewById(R.id.divider_bottom_first_floor);
        this.hPr = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.hPt = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.hOu = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.hOM = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.YV = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.hPu = (TextView) view.findViewById(R.id.pb_tail_text);
        this.hPw = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.hPw.setFrom(1);
        this.hPy = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
        this.hPx = (PbBusinessPromotionContainer) view.findViewById(R.id.pb_business_promotion_container);
    }

    public void b(@NonNull com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (this.hPw != null && dVar != null && dVar.getForum() != null) {
            boolean z2 = false;
            if (!z && !com.baidu.tbadk.core.util.v.aa(dVar.bTg())) {
                z2 = true;
            }
            bh bhVar = new bh();
            bhVar.setId(dVar.getThreadId());
            bhVar.setFid(com.baidu.adp.lib.g.b.c(dVar.getForum().getId(), 0L));
            bhVar.mz(dVar.getForum().getName());
            if (z2) {
                this.hPw.a(bhVar, dVar.bTg());
            } else {
                this.hPw.y(bhVar);
            }
            if (dVar.hIS) {
                this.hPw.setVisibility(8);
                this.hPx.a(bhVar, dVar.bSK(), dVar.bTj());
                return;
            }
            this.hPx.setVisibility(8);
        }
    }

    public void W(boolean z, boolean z2) {
        if (z && z2) {
            this.hPo.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.hPo.setVisibility(0);
        } else if (z) {
            this.hPo.setImageResource(R.drawable.pic_pb_refined_n);
            this.hPo.setVisibility(0);
        } else if (z2) {
            this.hPo.setImageResource(R.drawable.pic_pb_stick_n);
            this.hPo.setVisibility(0);
        } else {
            this.hPo.setVisibility(8);
        }
    }

    public void q(boolean z, int i) {
        if (this.hPp != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hPp.getLayoutParams();
                layoutParams.height = i;
                this.hPp.setLayoutParams(layoutParams);
                this.hPp.setVisibility(0);
                return;
            }
            this.hPp.setVisibility(8);
        }
    }
}
