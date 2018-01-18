package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbGiftListView;
/* loaded from: classes2.dex */
public class r extends r.a {
    public TbImageView bcc;
    public TextView bcz;
    public OriginalThreadCardView cVw;
    public View ecs;
    public TextView fFP;
    public View fFk;
    public View fFl;
    public TbRichTextView fFu;
    public PbGiftListView fFx;
    public LinearLayout fKo;
    public TbImageView fLj;
    public TbImageView fLk;
    public ThreadSkinView fLl;
    public LinearLayout fLm;
    public TextView fLn;
    public TextView fLo;
    public TextView fLp;
    public TextView fLq;
    public View fLr;
    public View fLs;
    public View fLt;
    public BaseWebView fLu;
    public TextView fLv;
    public int mSkinType;

    public r(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.bcz = (TextView) view.findViewById(d.g.view_forum_name_first_floor);
        this.cVw = (OriginalThreadCardView) view.findViewById(d.g.view_original_thread_info);
        this.fLm = (LinearLayout) view.findViewById(d.g.view_multi_from_list);
        this.fLn = (TextView) view.findViewById(d.g.tip_source);
        this.fLo = (TextView) view.findViewById(d.g.view_forum1);
        this.fLp = (TextView) view.findViewById(d.g.view_forum2);
        this.fLq = (TextView) view.findViewById(d.g.view_forum3);
        this.fLr = view.findViewById(d.g.line_divide1);
        this.fLs = view.findViewById(d.g.line_divide2);
        this.fFu = (TbRichTextView) view.findViewById(d.g.richText);
        this.fFx = (PbGiftListView) view.findViewById(d.g.gift_list_view);
        this.fFk = view;
        this.fFl = view.findViewById(d.g.new_pb_list_item_blank_top);
        this.fFu.setLayoutStrategy(new c(this.fFu.getLayoutStrategy()));
        this.fLj = (TbImageView) view.findViewById(d.g.game_activity_banner);
        this.fLk = (TbImageView) view.findViewById(d.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.ao(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.fFu.getPaddingLeft()) - this.fFu.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.fFu.getLayoutStrategy().iO(min);
        this.fFu.getLayoutStrategy().iP((int) (min * 1.618f));
        this.fFu.setTextSize(TbConfig.getContentSize());
        this.fFu.o(z, false);
        this.fFu.setVoiceViewRes(d.h.voice_play_btn_new);
        this.ecs = view.findViewById(d.g.divider_bottom_first_floor);
        this.bcc = (TbImageView) view.findViewById(d.g.user_head_mask);
        this.fLl = (ThreadSkinView) view.findViewById(d.g.pb_item_thread_skin);
        this.fKo = (LinearLayout) view.findViewById(d.g.pb_list_content);
        this.fFP = (TextView) view.findViewById(d.g.pb_item_tail_content);
        this.fLt = view.findViewById(d.g.link_thread_divider);
        this.fLu = (BaseWebView) view.findViewById(d.g.link_thread_webview);
        this.fLv = (TextView) view.findViewById(d.g.pb_first_floor_multi_forum_del_txt);
    }
}
