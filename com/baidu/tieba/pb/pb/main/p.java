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
    public AppletsCellView dKS;
    public View ekB;
    public View fOX;
    public LinearLayout fOY;
    public View fPR;
    public TbRichTextView fPS;
    public TbImageView fPT;
    public TbImageView fPU;
    public ThreadSkinView fPV;
    public PbTopicContainer fPW;
    public q fPX;
    public TextView fPq;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.fPX = new q(view);
        this.fPS = (TbRichTextView) view.findViewById(e.g.richText);
        this.fOX = view;
        this.fPR = view.findViewById(e.g.new_pb_list_item_blank_top);
        this.fPS.setLayoutStrategy(new c(this.fPS.getLayoutStrategy()));
        this.fPU = (TbImageView) view.findViewById(e.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.fPS.getPaddingLeft()) - this.fPS.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(e.C0200e.ds60)), i);
        this.fPS.getLayoutStrategy().gw(min);
        this.fPS.getLayoutStrategy().gx((int) (min * 1.618f));
        this.fPS.setTextSize(TbConfig.getContentSize());
        this.fPS.setDisplayImage(z, false);
        this.fPS.setVoiceViewRes(e.h.voice_play_btn_new);
        this.ekB = view.findViewById(e.g.divider_bottom_first_floor);
        this.fPT = (TbImageView) view.findViewById(e.g.user_head_mask);
        this.fPV = (ThreadSkinView) view.findViewById(e.g.pb_item_thread_skin);
        this.fOY = (LinearLayout) view.findViewById(e.g.pb_list_content);
        this.fPq = (TextView) view.findViewById(e.g.pb_item_tail_content);
        this.fPW = (PbTopicContainer) view.findViewById(e.g.pb_first_floor_topic_recommend);
        this.dKS = (AppletsCellView) view.findViewById(e.g.card_pb_page_first_floor_thread_share);
    }
}
