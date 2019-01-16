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
    public AppletsCellView dUS;
    public View euT;
    public View fZC;
    public LinearLayout fZD;
    public TextView fZV;
    public ThreadSkinView gaA;
    public PbTopicContainer gaB;
    public q gaC;
    public View gaw;
    public TbRichTextView gax;
    public TbImageView gay;
    public TbImageView gaz;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.gaC = new q(view);
        this.gax = (TbRichTextView) view.findViewById(e.g.richText);
        this.fZC = view;
        this.gaw = view.findViewById(e.g.new_pb_list_item_blank_top);
        this.gax.setLayoutStrategy(new c(this.gax.getLayoutStrategy()));
        this.gaz = (TbImageView) view.findViewById(e.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.gax.getPaddingLeft()) - this.gax.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(e.C0210e.ds60)), i);
        this.gax.getLayoutStrategy().gL(min);
        this.gax.getLayoutStrategy().gM((int) (min * 1.618f));
        this.gax.setTextSize(TbConfig.getContentSize());
        this.gax.setDisplayImage(z, false);
        this.gax.setVoiceViewRes(e.h.voice_play_btn_new);
        this.euT = view.findViewById(e.g.divider_bottom_first_floor);
        this.gay = (TbImageView) view.findViewById(e.g.user_head_mask);
        this.gaA = (ThreadSkinView) view.findViewById(e.g.pb_item_thread_skin);
        this.fZD = (LinearLayout) view.findViewById(e.g.pb_list_content);
        this.fZV = (TextView) view.findViewById(e.g.pb_item_tail_content);
        this.gaB = (PbTopicContainer) view.findViewById(e.g.pb_first_floor_topic_recommend);
        this.dUS = (AppletsCellView) view.findViewById(e.g.card_pb_page_first_floor_thread_share);
    }
}
