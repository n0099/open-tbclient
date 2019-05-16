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
    public AppletsCellView YB;
    public View bMQ;
    public TextView hHB;
    public View hHi;
    public LinearLayout hHj;
    public View hIc;
    private ImageView hId;
    private View hIe;
    public TbRichTextView hIf;
    public TbImageView hIg;
    public TbImageView hIh;
    public ThreadSkinView hIi;
    public TextView hIj;
    public q hIk;
    public ThreadForumEnterButtonContainer hIl;
    public com.baidu.tieba.pb.pb.main.view.a hIm;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.hIk = new q(view);
        this.hId = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.hId.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds194));
        this.hId.setImageMatrix(matrix);
        this.hIe = view.findViewById(R.id.blank_view_above_rich_text);
        this.hIf = (TbRichTextView) view.findViewById(R.id.richText);
        this.hHi = view;
        this.hIc = view.findViewById(R.id.new_pb_list_item_blank_top);
        this.hIf.setLayoutStrategy(new c(this.hIf.getLayoutStrategy()));
        this.hIh = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.hIf.getPaddingLeft()) - this.hIf.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.hIf.getLayoutStrategy().ln(min);
        this.hIf.getLayoutStrategy().lo((int) (min * 1.618f));
        this.hIf.setTextSize(TbConfig.getContentSize());
        this.hIf.setDisplayImage(z, false);
        this.hIf.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.bMQ = view.findViewById(R.id.divider_bottom_first_floor);
        this.hIg = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.hIi = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.hHj = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.hHB = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.YB = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.hIj = (TextView) view.findViewById(R.id.pb_tail_text);
        this.hIl = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.hIl.setFrom(1);
        this.hIm = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
    }

    public void b(@NonNull com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (this.hIl != null && dVar != null && dVar.getForum() != null) {
            boolean z2 = false;
            if (!z && !com.baidu.tbadk.core.util.v.aa(dVar.bQd())) {
                z2 = true;
            }
            bg bgVar = new bg();
            bgVar.setId(dVar.getThreadId());
            bgVar.setFid(com.baidu.adp.lib.g.b.c(dVar.getForum().getId(), 0L));
            bgVar.mp(dVar.getForum().getName());
            if (z2) {
                this.hIl.a(bgVar, dVar.bQd());
            } else {
                this.hIl.x(bgVar);
            }
        }
    }

    public void T(boolean z, boolean z2) {
        if (z && z2) {
            this.hId.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.hId.setVisibility(0);
        } else if (z) {
            this.hId.setImageResource(R.drawable.pic_pb_refined_n);
            this.hId.setVisibility(0);
        } else if (z2) {
            this.hId.setImageResource(R.drawable.pic_pb_stick_n);
            this.hId.setVisibility(0);
        } else {
            this.hId.setVisibility(8);
        }
    }

    public void q(boolean z, int i) {
        if (this.hIe != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hIe.getLayoutParams();
                layoutParams.height = i;
                this.hIe.setLayoutParams(layoutParams);
                this.hIe.setVisibility(0);
                return;
            }
            this.hIe.setVisibility(8);
        }
    }
}
