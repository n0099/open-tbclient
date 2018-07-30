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
    public View dTZ;
    public TextView fyK;
    public View fys;
    public LinearLayout fyt;
    public View fzl;
    public TbRichTextView fzm;
    public TbImageView fzn;
    public TbImageView fzo;
    public ThreadSkinView fzp;
    public PbTopicContainer fzq;
    public q fzr;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.fzr = new q(view);
        this.fzm = (TbRichTextView) view.findViewById(d.g.richText);
        this.fys = view;
        this.fzl = view.findViewById(d.g.new_pb_list_item_blank_top);
        this.fzm.setLayoutStrategy(new c(this.fzm.getLayoutStrategy()));
        this.fzo = (TbImageView) view.findViewById(d.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.fzm.getPaddingLeft()) - this.fzm.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.fzm.getLayoutStrategy().fP(min);
        this.fzm.getLayoutStrategy().fQ((int) (min * 1.618f));
        this.fzm.setTextSize(TbConfig.getContentSize());
        this.fzm.setDisplayImage(z, false);
        this.fzm.setVoiceViewRes(d.h.voice_play_btn_new);
        this.dTZ = view.findViewById(d.g.divider_bottom_first_floor);
        this.fzn = (TbImageView) view.findViewById(d.g.user_head_mask);
        this.fzp = (ThreadSkinView) view.findViewById(d.g.pb_item_thread_skin);
        this.fyt = (LinearLayout) view.findViewById(d.g.pb_list_content);
        this.fyK = (TextView) view.findViewById(d.g.pb_item_tail_content);
        this.fzq = (PbTopicContainer) view.findViewById(d.g.pb_first_floor_topic_recommend);
    }
}
