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
    public TextView hHE;
    public View hHl;
    public LinearLayout hHm;
    public View hIf;
    private ImageView hIg;
    private View hIh;
    public TbRichTextView hIi;
    public TbImageView hIj;
    public TbImageView hIk;
    public ThreadSkinView hIl;
    public TextView hIm;
    public q hIn;
    public ThreadForumEnterButtonContainer hIo;
    public com.baidu.tieba.pb.pb.main.view.a hIp;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.hIn = new q(view);
        this.hIg = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.hIg.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds194));
        this.hIg.setImageMatrix(matrix);
        this.hIh = view.findViewById(R.id.blank_view_above_rich_text);
        this.hIi = (TbRichTextView) view.findViewById(R.id.richText);
        this.hHl = view;
        this.hIf = view.findViewById(R.id.new_pb_list_item_blank_top);
        this.hIi.setLayoutStrategy(new c(this.hIi.getLayoutStrategy()));
        this.hIk = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.hIi.getPaddingLeft()) - this.hIi.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.hIi.getLayoutStrategy().ln(min);
        this.hIi.getLayoutStrategy().lo((int) (min * 1.618f));
        this.hIi.setTextSize(TbConfig.getContentSize());
        this.hIi.setDisplayImage(z, false);
        this.hIi.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.bMQ = view.findViewById(R.id.divider_bottom_first_floor);
        this.hIj = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.hIl = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.hHm = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.hHE = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.YB = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.hIm = (TextView) view.findViewById(R.id.pb_tail_text);
        this.hIo = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.hIo.setFrom(1);
        this.hIp = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
    }

    public void b(@NonNull com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (this.hIo != null && dVar != null && dVar.getForum() != null) {
            boolean z2 = false;
            if (!z && !com.baidu.tbadk.core.util.v.aa(dVar.bQg())) {
                z2 = true;
            }
            bg bgVar = new bg();
            bgVar.setId(dVar.getThreadId());
            bgVar.setFid(com.baidu.adp.lib.g.b.c(dVar.getForum().getId(), 0L));
            bgVar.mp(dVar.getForum().getName());
            if (z2) {
                this.hIo.a(bgVar, dVar.bQg());
            } else {
                this.hIo.x(bgVar);
            }
        }
    }

    public void T(boolean z, boolean z2) {
        if (z && z2) {
            this.hIg.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.hIg.setVisibility(0);
        } else if (z) {
            this.hIg.setImageResource(R.drawable.pic_pb_refined_n);
            this.hIg.setVisibility(0);
        } else if (z2) {
            this.hIg.setImageResource(R.drawable.pic_pb_stick_n);
            this.hIg.setVisibility(0);
        } else {
            this.hIg.setVisibility(8);
        }
    }

    public void q(boolean z, int i) {
        if (this.hIh != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hIh.getLayoutParams();
                layoutParams.height = i;
                this.hIh.setLayoutParams(layoutParams);
                this.hIh.setVisibility(0);
                return;
            }
            this.hIh.setVisibility(8);
        }
    }
}
