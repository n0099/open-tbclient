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
import com.baidu.tieba.f;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbTopicContainer;
/* loaded from: classes2.dex */
public class p extends q.a {
    public View dTU;
    public TextView fyD;
    public View fyl;
    public LinearLayout fym;
    public View fze;
    public TbRichTextView fzf;
    public TbImageView fzg;
    public TbImageView fzh;
    public ThreadSkinView fzi;
    public PbTopicContainer fzj;
    public q fzk;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.fzk = new q(view);
        this.fzf = (TbRichTextView) view.findViewById(f.g.richText);
        this.fyl = view;
        this.fze = view.findViewById(f.g.new_pb_list_item_blank_top);
        this.fzf.setLayoutStrategy(new c(this.fzf.getLayoutStrategy()));
        this.fzh = (TbImageView) view.findViewById(f.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.fzf.getPaddingLeft()) - this.fzf.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(f.e.ds60)), i);
        this.fzf.getLayoutStrategy().fO(min);
        this.fzf.getLayoutStrategy().fP((int) (min * 1.618f));
        this.fzf.setTextSize(TbConfig.getContentSize());
        this.fzf.setDisplayImage(z, false);
        this.fzf.setVoiceViewRes(f.h.voice_play_btn_new);
        this.dTU = view.findViewById(f.g.divider_bottom_first_floor);
        this.fzg = (TbImageView) view.findViewById(f.g.user_head_mask);
        this.fzi = (ThreadSkinView) view.findViewById(f.g.pb_item_thread_skin);
        this.fym = (LinearLayout) view.findViewById(f.g.pb_list_content);
        this.fyD = (TextView) view.findViewById(f.g.pb_item_tail_content);
        this.fzj = (PbTopicContainer) view.findViewById(f.g.pb_first_floor_topic_recommend);
    }
}
