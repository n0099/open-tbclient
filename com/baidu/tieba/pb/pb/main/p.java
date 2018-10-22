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
    public View ejh;
    public TextView fNR;
    public View fNy;
    public LinearLayout fNz;
    public View fOs;
    public TbRichTextView fOt;
    public TbImageView fOu;
    public TbImageView fOv;
    public ThreadSkinView fOw;
    public PbTopicContainer fOx;
    public q fOy;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.fOy = new q(view);
        this.fOt = (TbRichTextView) view.findViewById(e.g.richText);
        this.fNy = view;
        this.fOs = view.findViewById(e.g.new_pb_list_item_blank_top);
        this.fOt.setLayoutStrategy(new c(this.fOt.getLayoutStrategy()));
        this.fOv = (TbImageView) view.findViewById(e.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.fOt.getPaddingLeft()) - this.fOt.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(e.C0175e.ds60)), i);
        this.fOt.getLayoutStrategy().gi(min);
        this.fOt.getLayoutStrategy().gj((int) (min * 1.618f));
        this.fOt.setTextSize(TbConfig.getContentSize());
        this.fOt.setDisplayImage(z, false);
        this.fOt.setVoiceViewRes(e.h.voice_play_btn_new);
        this.ejh = view.findViewById(e.g.divider_bottom_first_floor);
        this.fOu = (TbImageView) view.findViewById(e.g.user_head_mask);
        this.fOw = (ThreadSkinView) view.findViewById(e.g.pb_item_thread_skin);
        this.fNz = (LinearLayout) view.findViewById(e.g.pb_list_content);
        this.fNR = (TextView) view.findViewById(e.g.pb_item_tail_content);
        this.fOx = (PbTopicContainer) view.findViewById(e.g.pb_first_floor_topic_recommend);
        this.dJO = (AppletsCellView) view.findViewById(e.g.card_pb_page_first_floor_thread_share);
    }
}
