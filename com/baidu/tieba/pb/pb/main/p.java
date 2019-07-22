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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.ThreadSkinView;
/* loaded from: classes4.dex */
public class p extends v.a {
    public AppletsCellView YV;
    public View bNS;
    public LinearLayout hNA;
    public TextView hNS;
    public View hNz;
    public TextView hOA;
    public q hOB;
    public ThreadForumEnterButtonContainer hOC;
    public com.baidu.tieba.pb.pb.main.view.a hOD;
    public View hOt;
    private ImageView hOu;
    private View hOv;
    public TbRichTextView hOw;
    public TbImageView hOx;
    public TbImageView hOy;
    public ThreadSkinView hOz;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.hOB = new q(view);
        this.hOu = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.hOu.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds194));
        this.hOu.setImageMatrix(matrix);
        this.hOv = view.findViewById(R.id.blank_view_above_rich_text);
        this.hOw = (TbRichTextView) view.findViewById(R.id.richText);
        this.hNz = view;
        this.hOt = view.findViewById(R.id.new_pb_list_item_blank_top);
        this.hOw.setLayoutStrategy(new c(this.hOw.getLayoutStrategy()));
        this.hOy = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.hOw.getPaddingLeft()) - this.hOw.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.hOw.getLayoutStrategy().lt(min);
        this.hOw.getLayoutStrategy().lu((int) (min * 1.618f));
        this.hOw.setTextSize(TbConfig.getContentSize());
        this.hOw.setDisplayImage(z, false);
        this.hOw.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.bNS = view.findViewById(R.id.divider_bottom_first_floor);
        this.hOx = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.hOz = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.hNA = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.hNS = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.YV = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.hOA = (TextView) view.findViewById(R.id.pb_tail_text);
        this.hOC = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.hOC.setFrom(1);
        this.hOD = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
    }

    public void b(@NonNull com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (this.hOC != null && dVar != null && dVar.getForum() != null) {
            boolean z2 = false;
            if (!z && !com.baidu.tbadk.core.util.v.aa(dVar.bSS())) {
                z2 = true;
            }
            bg bgVar = new bg();
            bgVar.setId(dVar.getThreadId());
            bgVar.setFid(com.baidu.adp.lib.g.b.c(dVar.getForum().getId(), 0L));
            bgVar.mz(dVar.getForum().getName());
            if (z2) {
                this.hOC.a(bgVar, dVar.bSS());
            } else {
                this.hOC.x(bgVar);
            }
        }
    }

    public void W(boolean z, boolean z2) {
        if (z && z2) {
            this.hOu.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.hOu.setVisibility(0);
        } else if (z) {
            this.hOu.setImageResource(R.drawable.pic_pb_refined_n);
            this.hOu.setVisibility(0);
        } else if (z2) {
            this.hOu.setImageResource(R.drawable.pic_pb_stick_n);
            this.hOu.setVisibility(0);
        } else {
            this.hOu.setVisibility(8);
        }
    }

    public void q(boolean z, int i) {
        if (this.hOv != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hOv.getLayoutParams();
                layoutParams.height = i;
                this.hOv.setLayoutParams(layoutParams);
                this.hOv.setVisibility(0);
                return;
            }
            this.hOv.setVisibility(8);
        }
    }
}
