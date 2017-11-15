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
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbGiftListView;
/* loaded from: classes.dex */
public class r extends j.a {
    public TbImageView anP;
    public TbImageView cAl;
    public TextView cmn;
    public View dfj;
    public TbRichTextView eII;
    public PbGiftListView eIL;
    public View eIy;
    public View eIz;
    public TextView eJd;
    public TextView eJf;
    public TextView eJg;
    public TextView eJh;
    public TextView eJi;
    public LinearLayout eJj;
    public TbImageView eNT;
    public ThreadSkinView eNU;
    public TextView eNV;
    public View eNW;
    public BaseWebView eNX;
    public LinearLayout eNr;
    public int mSkinType;

    public r(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.eJj = (LinearLayout) view.findViewById(d.g.belong_ba);
        this.eNV = (TextView) view.findViewById(d.g.belong_bar_direction);
        this.eJf = (TextView) view.findViewById(d.g.belong_ba_btn1);
        this.eJg = (TextView) view.findViewById(d.g.belong_ba_btn2);
        this.eJh = (TextView) view.findViewById(d.g.belong_ba_btn3);
        this.eJi = (TextView) view.findViewById(d.g.belong_ba_btn4);
        this.cmn = (TextView) view.findViewById(d.g.view_forum_name_first_floor);
        this.eII = (TbRichTextView) view.findViewById(d.g.richText);
        this.eIL = (PbGiftListView) view.findViewById(d.g.gift_list_view);
        this.eIy = view;
        this.eIz = view.findViewById(d.g.new_pb_list_item_blank_top);
        this.eII.setLayoutStrategy(new c(this.eII.getLayoutStrategy()));
        this.cAl = (TbImageView) view.findViewById(d.g.game_activity_banner);
        this.eNT = (TbImageView) view.findViewById(d.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.eII.getPaddingLeft()) - this.eII.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.eII.getLayoutStrategy().fM(min);
        this.eII.getLayoutStrategy().fN((int) (min * 1.618f));
        this.eII.setTextSize(TbConfig.getContentSize());
        this.eII.m(z, false);
        this.eII.setVoiceViewRes(d.h.voice_play_btn_new);
        this.dfj = view.findViewById(d.g.divider_bottom_first_floor);
        this.anP = (TbImageView) view.findViewById(d.g.user_head_mask);
        this.eNU = (ThreadSkinView) view.findViewById(d.g.pb_item_thread_skin);
        this.eNr = (LinearLayout) view.findViewById(d.g.pb_list_content);
        this.eJd = (TextView) view.findViewById(d.g.pb_item_tail_content);
        this.eNW = view.findViewById(d.g.link_thread_divider);
        this.eNX = (BaseWebView) view.findViewById(d.g.link_thread_webview);
    }
}
