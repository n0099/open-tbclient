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
    public AppletsCellView dUT;
    public View euU;
    public View fZD;
    public LinearLayout fZE;
    public TextView fZW;
    public TbImageView gaA;
    public ThreadSkinView gaB;
    public PbTopicContainer gaC;
    public q gaD;
    public View gax;
    public TbRichTextView gay;
    public TbImageView gaz;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.gaD = new q(view);
        this.gay = (TbRichTextView) view.findViewById(e.g.richText);
        this.fZD = view;
        this.gax = view.findViewById(e.g.new_pb_list_item_blank_top);
        this.gay.setLayoutStrategy(new c(this.gay.getLayoutStrategy()));
        this.gaA = (TbImageView) view.findViewById(e.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.gay.getPaddingLeft()) - this.gay.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(e.C0210e.ds60)), i);
        this.gay.getLayoutStrategy().gL(min);
        this.gay.getLayoutStrategy().gM((int) (min * 1.618f));
        this.gay.setTextSize(TbConfig.getContentSize());
        this.gay.setDisplayImage(z, false);
        this.gay.setVoiceViewRes(e.h.voice_play_btn_new);
        this.euU = view.findViewById(e.g.divider_bottom_first_floor);
        this.gaz = (TbImageView) view.findViewById(e.g.user_head_mask);
        this.gaB = (ThreadSkinView) view.findViewById(e.g.pb_item_thread_skin);
        this.fZE = (LinearLayout) view.findViewById(e.g.pb_list_content);
        this.fZW = (TextView) view.findViewById(e.g.pb_item_tail_content);
        this.gaC = (PbTopicContainer) view.findViewById(e.g.pb_first_floor_topic_recommend);
        this.dUT = (AppletsCellView) view.findViewById(e.g.card_pb_page_first_floor_thread_share);
    }
}
