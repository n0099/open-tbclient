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
    public AppletsCellView dRv;
    public View erw;
    public View fVN;
    public LinearLayout fVO;
    public View fWH;
    public TbRichTextView fWI;
    public TbImageView fWJ;
    public TbImageView fWK;
    public ThreadSkinView fWL;
    public PbTopicContainer fWM;
    public q fWN;
    public TextView fWg;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.fWN = new q(view);
        this.fWI = (TbRichTextView) view.findViewById(e.g.richText);
        this.fVN = view;
        this.fWH = view.findViewById(e.g.new_pb_list_item_blank_top);
        this.fWI.setLayoutStrategy(new c(this.fWI.getLayoutStrategy()));
        this.fWK = (TbImageView) view.findViewById(e.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.fWI.getPaddingLeft()) - this.fWI.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(e.C0210e.ds60)), i);
        this.fWI.getLayoutStrategy().gK(min);
        this.fWI.getLayoutStrategy().gL((int) (min * 1.618f));
        this.fWI.setTextSize(TbConfig.getContentSize());
        this.fWI.setDisplayImage(z, false);
        this.fWI.setVoiceViewRes(e.h.voice_play_btn_new);
        this.erw = view.findViewById(e.g.divider_bottom_first_floor);
        this.fWJ = (TbImageView) view.findViewById(e.g.user_head_mask);
        this.fWL = (ThreadSkinView) view.findViewById(e.g.pb_item_thread_skin);
        this.fVO = (LinearLayout) view.findViewById(e.g.pb_list_content);
        this.fWg = (TextView) view.findViewById(e.g.pb_item_tail_content);
        this.fWM = (PbTopicContainer) view.findViewById(e.g.pb_first_floor_topic_recommend);
        this.dRv = (AppletsCellView) view.findViewById(e.g.card_pb_page_first_floor_thread_share);
    }
}
