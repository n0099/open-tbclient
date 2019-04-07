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
    public AppletsCellView aaI;
    public View bFs;
    public View hpF;
    public LinearLayout hpG;
    public TextView hpY;
    private ImageView hqA;
    private View hqB;
    public TbRichTextView hqC;
    public TbImageView hqD;
    public TbImageView hqE;
    public ThreadSkinView hqF;
    public q hqG;
    public ThreadForumEnterButtonContainer hqH;
    public View hqz;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.hqG = new q(view);
        this.hqA = (ImageView) view.findViewById(d.g.pb_thread_type_stamp_first_floor_bottom_part);
        this.hqA.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -TbadkApplication.getInst().getResources().getDimension(d.e.tbds194));
        this.hqA.setImageMatrix(matrix);
        this.hqB = view.findViewById(d.g.blank_view_above_rich_text);
        this.hqC = (TbRichTextView) view.findViewById(d.g.richText);
        this.hpF = view;
        this.hqz = view.findViewById(d.g.new_pb_list_item_blank_top);
        this.hqC.setLayoutStrategy(new c(this.hqC.getLayoutStrategy()));
        this.hqE = (TbImageView) view.findViewById(d.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.hqC.getPaddingLeft()) - this.hqC.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.hqC.getLayoutStrategy().ky(min);
        this.hqC.getLayoutStrategy().kz((int) (min * 1.618f));
        this.hqC.setTextSize(TbConfig.getContentSize());
        this.hqC.setDisplayImage(z, false);
        this.hqC.setVoiceViewRes(d.h.voice_play_btn_new);
        this.bFs = view.findViewById(d.g.divider_bottom_first_floor);
        this.hqD = (TbImageView) view.findViewById(d.g.user_head_mask);
        this.hqF = (ThreadSkinView) view.findViewById(d.g.pb_item_thread_skin);
        this.hpG = (LinearLayout) view.findViewById(d.g.pb_list_content);
        this.hpY = (TextView) view.findViewById(d.g.pb_item_tail_content);
        this.aaI = (AppletsCellView) view.findViewById(d.g.card_pb_page_first_floor_thread_share);
        this.hqH = (ThreadForumEnterButtonContainer) view.findViewById(d.g.pb_fourm_name_container);
        this.hqH.setFrom(1);
    }

    public void b(@NonNull com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (this.hqH != null && dVar != null && dVar.getForum() != null) {
            boolean z2 = false;
            if (!z && !com.baidu.tbadk.core.util.v.T(dVar.bIr())) {
                z2 = true;
            }
            bg bgVar = new bg();
            bgVar.setId(dVar.getThreadId());
            bgVar.setFid(com.baidu.adp.lib.g.b.d(dVar.getForum().getId(), 0L));
            bgVar.lk(dVar.getForum().getName());
            if (z2) {
                this.hqH.a(bgVar, dVar.bIr());
            } else {
                this.hqH.x(bgVar);
            }
        }
    }

    public void S(boolean z, boolean z2) {
        if (z && z2) {
            this.hqA.setImageResource(d.f.pic_pb_stick_refined_n);
            this.hqA.setVisibility(0);
        } else if (z) {
            this.hqA.setImageResource(d.f.pic_pb_refined_n);
            this.hqA.setVisibility(0);
        } else if (z2) {
            this.hqA.setImageResource(d.f.pic_pb_stick_n);
            this.hqA.setVisibility(0);
        } else {
            this.hqA.setVisibility(8);
        }
    }

    public void q(boolean z, int i) {
        if (this.hqB != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqB.getLayoutParams();
                layoutParams.height = i;
                this.hqB.setLayoutParams(layoutParams);
                this.hqB.setVisibility(0);
                return;
            }
            this.hqB.setVisibility(8);
        }
    }
}
