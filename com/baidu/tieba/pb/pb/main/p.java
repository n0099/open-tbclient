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
/* loaded from: classes2.dex */
public class p extends q.a {
    public AppletsCellView dBO;
    public View ebn;
    public View fFW;
    public LinearLayout fFX;
    public View fGQ;
    public TbRichTextView fGR;
    public TbImageView fGS;
    public TbImageView fGT;
    public ThreadSkinView fGU;
    public PbTopicContainer fGV;
    public q fGW;
    public TextView fGp;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.fGW = new q(view);
        this.fGR = (TbRichTextView) view.findViewById(e.g.richText);
        this.fFW = view;
        this.fGQ = view.findViewById(e.g.new_pb_list_item_blank_top);
        this.fGR.setLayoutStrategy(new c(this.fGR.getLayoutStrategy()));
        this.fGT = (TbImageView) view.findViewById(e.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.fGR.getPaddingLeft()) - this.fGR.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(e.C0141e.ds60)), i);
        this.fGR.getLayoutStrategy().ga(min);
        this.fGR.getLayoutStrategy().gb((int) (min * 1.618f));
        this.fGR.setTextSize(TbConfig.getContentSize());
        this.fGR.setDisplayImage(z, false);
        this.fGR.setVoiceViewRes(e.h.voice_play_btn_new);
        this.ebn = view.findViewById(e.g.divider_bottom_first_floor);
        this.fGS = (TbImageView) view.findViewById(e.g.user_head_mask);
        this.fGU = (ThreadSkinView) view.findViewById(e.g.pb_item_thread_skin);
        this.fFX = (LinearLayout) view.findViewById(e.g.pb_list_content);
        this.fGp = (TextView) view.findViewById(e.g.pb_item_tail_content);
        this.fGV = (PbTopicContainer) view.findViewById(e.g.pb_first_floor_topic_recommend);
        this.dBO = (AppletsCellView) view.findViewById(e.g.card_pb_page_first_floor_thread_share);
    }
}
