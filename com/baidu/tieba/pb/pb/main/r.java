package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
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
/* loaded from: classes.dex */
public class r extends j.a {
    public TbImageView aoe;
    public TbImageView cJD;
    public OriginalThreadCardView ccq;
    public TextView cvf;
    public View dpa;
    public TextView eRO;
    public View eRj;
    public View eRk;
    public TbRichTextView eRt;
    public PbGiftListView eRw;
    public TbImageView eWX;
    public ThreadSkinView eWY;
    public LinearLayout eWZ;
    public LinearLayout eWj;
    public TextView eXa;
    public TextView eXb;
    public TextView eXc;
    public TextView eXd;
    public View eXe;
    public View eXf;
    public View eXg;
    public BaseWebView eXh;
    public int mSkinType;

    public r(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.cvf = (TextView) view.findViewById(d.g.view_forum_name_first_floor);
        this.ccq = (OriginalThreadCardView) view.findViewById(d.g.view_original_thread_info);
        this.eWZ = (LinearLayout) view.findViewById(d.g.view_multi_from_list);
        this.eXa = (TextView) view.findViewById(d.g.tip_source);
        this.eXb = (TextView) view.findViewById(d.g.view_forum1);
        this.eXc = (TextView) view.findViewById(d.g.view_forum2);
        this.eXd = (TextView) view.findViewById(d.g.view_forum3);
        this.eXe = view.findViewById(d.g.line_divide1);
        this.eXf = view.findViewById(d.g.line_divide2);
        this.eRt = (TbRichTextView) view.findViewById(d.g.richText);
        this.eRw = (PbGiftListView) view.findViewById(d.g.gift_list_view);
        this.eRj = view;
        this.eRk = view.findViewById(d.g.new_pb_list_item_blank_top);
        this.eRt.setLayoutStrategy(new c(this.eRt.getLayoutStrategy()));
        this.cJD = (TbImageView) view.findViewById(d.g.game_activity_banner);
        this.eWX = (TbImageView) view.findViewById(d.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.eRt.getPaddingLeft()) - this.eRt.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.eRt.getLayoutStrategy().fT(min);
        this.eRt.getLayoutStrategy().fU((int) (min * 1.618f));
        this.eRt.setTextSize(TbConfig.getContentSize());
        this.eRt.m(z, false);
        this.eRt.setVoiceViewRes(d.h.voice_play_btn_new);
        this.dpa = view.findViewById(d.g.divider_bottom_first_floor);
        this.aoe = (TbImageView) view.findViewById(d.g.user_head_mask);
        this.eWY = (ThreadSkinView) view.findViewById(d.g.pb_item_thread_skin);
        this.eWj = (LinearLayout) view.findViewById(d.g.pb_list_content);
        this.eRO = (TextView) view.findViewById(d.g.pb_item_tail_content);
        this.eXg = view.findViewById(d.g.link_thread_divider);
        this.eXh = (BaseWebView) view.findViewById(d.g.link_thread_webview);
    }
}
