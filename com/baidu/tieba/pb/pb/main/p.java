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
    public AppletsCellView aaG;
    public View bFo;
    public View hpY;
    public LinearLayout hpZ;
    public View hqS;
    private ImageView hqT;
    private View hqU;
    public TbRichTextView hqV;
    public TbImageView hqW;
    public TbImageView hqX;
    public ThreadSkinView hqY;
    public q hqZ;
    public TextView hqr;
    public ThreadForumEnterButtonContainer hra;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.hqZ = new q(view);
        this.hqT = (ImageView) view.findViewById(d.g.pb_thread_type_stamp_first_floor_bottom_part);
        this.hqT.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -TbadkApplication.getInst().getResources().getDimension(d.e.tbds194));
        this.hqT.setImageMatrix(matrix);
        this.hqU = view.findViewById(d.g.blank_view_above_rich_text);
        this.hqV = (TbRichTextView) view.findViewById(d.g.richText);
        this.hpY = view;
        this.hqS = view.findViewById(d.g.new_pb_list_item_blank_top);
        this.hqV.setLayoutStrategy(new c(this.hqV.getLayoutStrategy()));
        this.hqX = (TbImageView) view.findViewById(d.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.hqV.getPaddingLeft()) - this.hqV.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.hqV.getLayoutStrategy().kz(min);
        this.hqV.getLayoutStrategy().kA((int) (min * 1.618f));
        this.hqV.setTextSize(TbConfig.getContentSize());
        this.hqV.setDisplayImage(z, false);
        this.hqV.setVoiceViewRes(d.h.voice_play_btn_new);
        this.bFo = view.findViewById(d.g.divider_bottom_first_floor);
        this.hqW = (TbImageView) view.findViewById(d.g.user_head_mask);
        this.hqY = (ThreadSkinView) view.findViewById(d.g.pb_item_thread_skin);
        this.hpZ = (LinearLayout) view.findViewById(d.g.pb_list_content);
        this.hqr = (TextView) view.findViewById(d.g.pb_item_tail_content);
        this.aaG = (AppletsCellView) view.findViewById(d.g.card_pb_page_first_floor_thread_share);
        this.hra = (ThreadForumEnterButtonContainer) view.findViewById(d.g.pb_fourm_name_container);
        this.hra.setFrom(1);
    }

    public void b(@NonNull com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (this.hra != null && dVar != null && dVar.getForum() != null) {
            boolean z2 = false;
            if (!z && !com.baidu.tbadk.core.util.v.T(dVar.bIu())) {
                z2 = true;
            }
            bg bgVar = new bg();
            bgVar.setId(dVar.getThreadId());
            bgVar.setFid(com.baidu.adp.lib.g.b.d(dVar.getForum().getId(), 0L));
            bgVar.lj(dVar.getForum().getName());
            if (z2) {
                this.hra.a(bgVar, dVar.bIu());
            } else {
                this.hra.x(bgVar);
            }
        }
    }

    public void U(boolean z, boolean z2) {
        if (z && z2) {
            this.hqT.setImageResource(d.f.pic_pb_stick_refined_n);
            this.hqT.setVisibility(0);
        } else if (z) {
            this.hqT.setImageResource(d.f.pic_pb_refined_n);
            this.hqT.setVisibility(0);
        } else if (z2) {
            this.hqT.setImageResource(d.f.pic_pb_stick_n);
            this.hqT.setVisibility(0);
        } else {
            this.hqT.setVisibility(8);
        }
    }

    public void q(boolean z, int i) {
        if (this.hqU != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqU.getLayoutParams();
                layoutParams.height = i;
                this.hqU.setLayoutParams(layoutParams);
                this.hqU.setVisibility(0);
                return;
            }
            this.hqU.setVisibility(8);
        }
    }
}
