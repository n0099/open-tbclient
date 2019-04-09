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
    public AppletsCellView aaJ;
    public View bFt;
    public View hpG;
    public LinearLayout hpH;
    public TextView hpZ;
    public View hqA;
    private ImageView hqB;
    private View hqC;
    public TbRichTextView hqD;
    public TbImageView hqE;
    public TbImageView hqF;
    public ThreadSkinView hqG;
    public q hqH;
    public ThreadForumEnterButtonContainer hqI;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.hqH = new q(view);
        this.hqB = (ImageView) view.findViewById(d.g.pb_thread_type_stamp_first_floor_bottom_part);
        this.hqB.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -TbadkApplication.getInst().getResources().getDimension(d.e.tbds194));
        this.hqB.setImageMatrix(matrix);
        this.hqC = view.findViewById(d.g.blank_view_above_rich_text);
        this.hqD = (TbRichTextView) view.findViewById(d.g.richText);
        this.hpG = view;
        this.hqA = view.findViewById(d.g.new_pb_list_item_blank_top);
        this.hqD.setLayoutStrategy(new c(this.hqD.getLayoutStrategy()));
        this.hqF = (TbImageView) view.findViewById(d.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.hqD.getPaddingLeft()) - this.hqD.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.hqD.getLayoutStrategy().ky(min);
        this.hqD.getLayoutStrategy().kz((int) (min * 1.618f));
        this.hqD.setTextSize(TbConfig.getContentSize());
        this.hqD.setDisplayImage(z, false);
        this.hqD.setVoiceViewRes(d.h.voice_play_btn_new);
        this.bFt = view.findViewById(d.g.divider_bottom_first_floor);
        this.hqE = (TbImageView) view.findViewById(d.g.user_head_mask);
        this.hqG = (ThreadSkinView) view.findViewById(d.g.pb_item_thread_skin);
        this.hpH = (LinearLayout) view.findViewById(d.g.pb_list_content);
        this.hpZ = (TextView) view.findViewById(d.g.pb_item_tail_content);
        this.aaJ = (AppletsCellView) view.findViewById(d.g.card_pb_page_first_floor_thread_share);
        this.hqI = (ThreadForumEnterButtonContainer) view.findViewById(d.g.pb_fourm_name_container);
        this.hqI.setFrom(1);
    }

    public void b(@NonNull com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (this.hqI != null && dVar != null && dVar.getForum() != null) {
            boolean z2 = false;
            if (!z && !com.baidu.tbadk.core.util.v.T(dVar.bIr())) {
                z2 = true;
            }
            bg bgVar = new bg();
            bgVar.setId(dVar.getThreadId());
            bgVar.setFid(com.baidu.adp.lib.g.b.d(dVar.getForum().getId(), 0L));
            bgVar.lk(dVar.getForum().getName());
            if (z2) {
                this.hqI.a(bgVar, dVar.bIr());
            } else {
                this.hqI.x(bgVar);
            }
        }
    }

    public void S(boolean z, boolean z2) {
        if (z && z2) {
            this.hqB.setImageResource(d.f.pic_pb_stick_refined_n);
            this.hqB.setVisibility(0);
        } else if (z) {
            this.hqB.setImageResource(d.f.pic_pb_refined_n);
            this.hqB.setVisibility(0);
        } else if (z2) {
            this.hqB.setImageResource(d.f.pic_pb_stick_n);
            this.hqB.setVisibility(0);
        } else {
            this.hqB.setVisibility(8);
        }
    }

    public void q(boolean z, int i) {
        if (this.hqC != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqC.getLayoutParams();
                layoutParams.height = i;
                this.hqC.setLayoutParams(layoutParams);
                this.hqC.setVisibility(0);
                return;
            }
            this.hqC.setVisibility(8);
        }
    }
}
