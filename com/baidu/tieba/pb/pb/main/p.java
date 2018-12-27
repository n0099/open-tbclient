package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.AppletsCellView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbTopicContainer;
/* loaded from: classes6.dex */
public class p extends q.a {
    public AppletsCellView dUm;
    public View eun;
    public View fYF;
    public LinearLayout fYG;
    public TextView fYY;
    public TbRichTextView fZA;
    public TbImageView fZB;
    public TbImageView fZC;
    public ThreadSkinView fZD;
    public PbTopicContainer fZE;
    public q fZF;
    public View fZz;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.fZF = new q(view);
        this.fZA = (TbRichTextView) view.findViewById(e.g.richText);
        this.fYF = view;
        this.fZz = view.findViewById(e.g.new_pb_list_item_blank_top);
        this.fZA.setLayoutStrategy(new c(this.fZA.getLayoutStrategy()));
        this.fZC = (TbImageView) view.findViewById(e.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.fZA.getPaddingLeft()) - this.fZA.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(e.C0210e.ds60)), i);
        this.fZA.getLayoutStrategy().gL(min);
        this.fZA.getLayoutStrategy().gM((int) (min * 1.618f));
        this.fZA.setTextSize(TbConfig.getContentSize());
        this.fZA.setDisplayImage(z, false);
        this.fZA.setVoiceViewRes(e.h.voice_play_btn_new);
        this.eun = view.findViewById(e.g.divider_bottom_first_floor);
        this.fZB = (TbImageView) view.findViewById(e.g.user_head_mask);
        this.fZD = (ThreadSkinView) view.findViewById(e.g.pb_item_thread_skin);
        this.fYG = (LinearLayout) view.findViewById(e.g.pb_list_content);
        this.fYY = (TextView) view.findViewById(e.g.pb_item_tail_content);
        this.fZE = (PbTopicContainer) view.findViewById(e.g.pb_first_floor_topic_recommend);
        this.dUm = (AppletsCellView) view.findViewById(e.g.card_pb_page_first_floor_thread_share);
    }
}
