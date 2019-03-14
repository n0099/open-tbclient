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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.core.view.ThreadForumEnterButtonContainer;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
/* loaded from: classes4.dex */
public class p extends v.a {
    public AppletsCellView aaH;
    public View bFq;
    public View hpS;
    public LinearLayout hpT;
    public View hqM;
    private ImageView hqN;
    private View hqO;
    public TbRichTextView hqP;
    public TbImageView hqQ;
    public TbImageView hqR;
    public ThreadSkinView hqS;
    public q hqT;
    public ThreadForumEnterButtonContainer hqU;
    public TextView hql;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.hqT = new q(view);
        this.hqN = (ImageView) view.findViewById(d.g.pb_thread_type_stamp_first_floor_bottom_part);
        this.hqN.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -TbadkApplication.getInst().getResources().getDimension(d.e.tbds194));
        this.hqN.setImageMatrix(matrix);
        this.hqO = view.findViewById(d.g.blank_view_above_rich_text);
        this.hqP = (TbRichTextView) view.findViewById(d.g.richText);
        this.hpS = view;
        this.hqM = view.findViewById(d.g.new_pb_list_item_blank_top);
        this.hqP.setLayoutStrategy(new c(this.hqP.getLayoutStrategy()));
        this.hqR = (TbImageView) view.findViewById(d.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.hqP.getPaddingLeft()) - this.hqP.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.hqP.getLayoutStrategy().kz(min);
        this.hqP.getLayoutStrategy().kA((int) (min * 1.618f));
        this.hqP.setTextSize(TbConfig.getContentSize());
        this.hqP.setDisplayImage(z, false);
        this.hqP.setVoiceViewRes(d.h.voice_play_btn_new);
        this.bFq = view.findViewById(d.g.divider_bottom_first_floor);
        this.hqQ = (TbImageView) view.findViewById(d.g.user_head_mask);
        this.hqS = (ThreadSkinView) view.findViewById(d.g.pb_item_thread_skin);
        this.hpT = (LinearLayout) view.findViewById(d.g.pb_list_content);
        this.hql = (TextView) view.findViewById(d.g.pb_item_tail_content);
        this.aaH = (AppletsCellView) view.findViewById(d.g.card_pb_page_first_floor_thread_share);
        this.hqU = (ThreadForumEnterButtonContainer) view.findViewById(d.g.pb_fourm_name_container);
        this.hqU.setFrom(1);
    }

    public void b(@NonNull com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (this.hqU != null && dVar != null && dVar.getForum() != null) {
            boolean z2 = false;
            if (!z && !com.baidu.tbadk.core.util.v.T(dVar.bIu())) {
                z2 = true;
            }
            bg bgVar = new bg();
            bgVar.setId(dVar.getThreadId());
            bgVar.setFid(com.baidu.adp.lib.g.b.d(dVar.getForum().getId(), 0L));
            bgVar.lj(dVar.getForum().getName());
            if (z2) {
                this.hqU.a(bgVar, dVar.bIu());
            } else {
                this.hqU.x(bgVar);
            }
        }
    }

    public void U(boolean z, boolean z2) {
        if (z && z2) {
            this.hqN.setImageResource(d.f.pic_pb_stick_refined_n);
            this.hqN.setVisibility(0);
        } else if (z) {
            this.hqN.setImageResource(d.f.pic_pb_refined_n);
            this.hqN.setVisibility(0);
        } else if (z2) {
            this.hqN.setImageResource(d.f.pic_pb_stick_n);
            this.hqN.setVisibility(0);
        } else {
            this.hqN.setVisibility(8);
        }
    }

    public void q(boolean z, int i) {
        if (this.hqO != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqO.getLayoutParams();
                layoutParams.height = i;
                this.hqO.setLayoutParams(layoutParams);
                this.hqO.setVisibility(0);
                return;
            }
            this.hqO.setVisibility(8);
        }
    }
}
