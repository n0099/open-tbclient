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
    public AppletsCellView dJO;
    public View ejg;
    public TextView fNQ;
    public View fNx;
    public LinearLayout fNy;
    public View fOr;
    public TbRichTextView fOs;
    public TbImageView fOt;
    public TbImageView fOu;
    public ThreadSkinView fOv;
    public PbTopicContainer fOw;
    public q fOx;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.fOx = new q(view);
        this.fOs = (TbRichTextView) view.findViewById(e.g.richText);
        this.fNx = view;
        this.fOr = view.findViewById(e.g.new_pb_list_item_blank_top);
        this.fOs.setLayoutStrategy(new c(this.fOs.getLayoutStrategy()));
        this.fOu = (TbImageView) view.findViewById(e.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.fOs.getPaddingLeft()) - this.fOs.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(e.C0175e.ds60)), i);
        this.fOs.getLayoutStrategy().gi(min);
        this.fOs.getLayoutStrategy().gj((int) (min * 1.618f));
        this.fOs.setTextSize(TbConfig.getContentSize());
        this.fOs.setDisplayImage(z, false);
        this.fOs.setVoiceViewRes(e.h.voice_play_btn_new);
        this.ejg = view.findViewById(e.g.divider_bottom_first_floor);
        this.fOt = (TbImageView) view.findViewById(e.g.user_head_mask);
        this.fOv = (ThreadSkinView) view.findViewById(e.g.pb_item_thread_skin);
        this.fNy = (LinearLayout) view.findViewById(e.g.pb_list_content);
        this.fNQ = (TextView) view.findViewById(e.g.pb_item_tail_content);
        this.fOw = (PbTopicContainer) view.findViewById(e.g.pb_first_floor_topic_recommend);
        this.dJO = (AppletsCellView) view.findViewById(e.g.card_pb_page_first_floor_thread_share);
    }
}
