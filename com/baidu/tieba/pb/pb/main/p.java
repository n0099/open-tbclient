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
    public AppletsCellView YA;
    public View bMR;
    public TextView hHF;
    public View hHm;
    public LinearLayout hHn;
    public View hIg;
    private ImageView hIh;
    private View hIi;
    public TbRichTextView hIj;
    public TbImageView hIk;
    public TbImageView hIl;
    public ThreadSkinView hIm;
    public TextView hIn;
    public q hIo;
    public ThreadForumEnterButtonContainer hIp;
    public com.baidu.tieba.pb.pb.main.view.a hIq;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.hIo = new q(view);
        this.hIh = (ImageView) view.findViewById(R.id.pb_thread_type_stamp_first_floor_bottom_part);
        this.hIh.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds194));
        this.hIh.setImageMatrix(matrix);
        this.hIi = view.findViewById(R.id.blank_view_above_rich_text);
        this.hIj = (TbRichTextView) view.findViewById(R.id.richText);
        this.hHm = view;
        this.hIg = view.findViewById(R.id.new_pb_list_item_blank_top);
        this.hIj.setLayoutStrategy(new c(this.hIj.getLayoutStrategy()));
        this.hIl = (TbImageView) view.findViewById(R.id.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.hIj.getPaddingLeft()) - this.hIj.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds60)), i);
        this.hIj.getLayoutStrategy().ln(min);
        this.hIj.getLayoutStrategy().lo((int) (min * 1.618f));
        this.hIj.setTextSize(TbConfig.getContentSize());
        this.hIj.setDisplayImage(z, false);
        this.hIj.setVoiceViewRes(R.layout.voice_play_btn_new);
        this.bMR = view.findViewById(R.id.divider_bottom_first_floor);
        this.hIk = (TbImageView) view.findViewById(R.id.user_head_mask);
        this.hIm = (ThreadSkinView) view.findViewById(R.id.pb_item_thread_skin);
        this.hHn = (LinearLayout) view.findViewById(R.id.pb_list_content);
        this.hHF = (TextView) view.findViewById(R.id.pb_item_tail_content);
        this.YA = (AppletsCellView) view.findViewById(R.id.card_pb_page_first_floor_thread_share);
        this.hIn = (TextView) view.findViewById(R.id.pb_tail_text);
        this.hIp = (ThreadForumEnterButtonContainer) view.findViewById(R.id.pb_fourm_name_container);
        this.hIp.setFrom(1);
        this.hIq = new com.baidu.tieba.pb.pb.main.view.a(tbPageContext);
    }

    public void b(@NonNull com.baidu.tieba.pb.data.d dVar, boolean z) {
        if (this.hIp != null && dVar != null && dVar.getForum() != null) {
            boolean z2 = false;
            if (!z && !com.baidu.tbadk.core.util.v.aa(dVar.bQh())) {
                z2 = true;
            }
            bg bgVar = new bg();
            bgVar.setId(dVar.getThreadId());
            bgVar.setFid(com.baidu.adp.lib.g.b.c(dVar.getForum().getId(), 0L));
            bgVar.mo(dVar.getForum().getName());
            if (z2) {
                this.hIp.a(bgVar, dVar.bQh());
            } else {
                this.hIp.x(bgVar);
            }
        }
    }

    public void T(boolean z, boolean z2) {
        if (z && z2) {
            this.hIh.setImageResource(R.drawable.pic_pb_stick_refined_n);
            this.hIh.setVisibility(0);
        } else if (z) {
            this.hIh.setImageResource(R.drawable.pic_pb_refined_n);
            this.hIh.setVisibility(0);
        } else if (z2) {
            this.hIh.setImageResource(R.drawable.pic_pb_stick_n);
            this.hIh.setVisibility(0);
        } else {
            this.hIh.setVisibility(8);
        }
    }

    public void q(boolean z, int i) {
        if (this.hIi != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hIi.getLayoutParams();
                layoutParams.height = i;
                this.hIi.setLayoutParams(layoutParams);
                this.hIi.setVisibility(0);
                return;
            }
            this.hIi.setVisibility(8);
        }
    }
}
