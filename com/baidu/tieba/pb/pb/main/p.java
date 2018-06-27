package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbTopicContainer;
/* loaded from: classes2.dex */
public class p extends q.a {
    public View dRm;
    public View fyZ;
    public View fyg;
    public LinearLayout fyh;
    public TextView fyy;
    public TbRichTextView fza;
    public TbImageView fzb;
    public TbImageView fzc;
    public ThreadSkinView fzd;
    public PbTopicContainer fze;
    public q fzf;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.fzf = new q(view);
        this.fza = (TbRichTextView) view.findViewById(d.g.richText);
        this.fyg = view;
        this.fyZ = view.findViewById(d.g.new_pb_list_item_blank_top);
        this.fza.setLayoutStrategy(new c(this.fza.getLayoutStrategy()));
        this.fzc = (TbImageView) view.findViewById(d.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.fza.getPaddingLeft()) - this.fza.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.fza.getLayoutStrategy().fO(min);
        this.fza.getLayoutStrategy().fP((int) (min * 1.618f));
        this.fza.setTextSize(TbConfig.getContentSize());
        this.fza.setDisplayImage(z, false);
        this.fza.setVoiceViewRes(d.i.voice_play_btn_new);
        this.dRm = view.findViewById(d.g.divider_bottom_first_floor);
        this.fzb = (TbImageView) view.findViewById(d.g.user_head_mask);
        this.fzd = (ThreadSkinView) view.findViewById(d.g.pb_item_thread_skin);
        this.fyh = (LinearLayout) view.findViewById(d.g.pb_list_content);
        this.fyy = (TextView) view.findViewById(d.g.pb_item_tail_content);
        this.fze = (PbTopicContainer) view.findViewById(d.g.pb_first_floor_topic_recommend);
    }
}
