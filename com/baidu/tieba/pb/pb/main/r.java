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
    public TbImageView anQ;
    public TextView clT;
    public TbImageView czS;
    public View deP;
    public TextView eIJ;
    public TextView eIL;
    public TextView eIM;
    public TextView eIN;
    public TextView eIO;
    public LinearLayout eIP;
    public View eIe;
    public View eIf;
    public TbRichTextView eIo;
    public PbGiftListView eIr;
    public LinearLayout eMX;
    public ThreadSkinView eNA;
    public TextView eNB;
    public View eNC;
    public BaseWebView eND;
    public TbImageView eNz;
    public int mSkinType;

    public r(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.eIP = (LinearLayout) view.findViewById(d.g.belong_ba);
        this.eNB = (TextView) view.findViewById(d.g.belong_bar_direction);
        this.eIL = (TextView) view.findViewById(d.g.belong_ba_btn1);
        this.eIM = (TextView) view.findViewById(d.g.belong_ba_btn2);
        this.eIN = (TextView) view.findViewById(d.g.belong_ba_btn3);
        this.eIO = (TextView) view.findViewById(d.g.belong_ba_btn4);
        this.clT = (TextView) view.findViewById(d.g.view_forum_name_first_floor);
        this.eIo = (TbRichTextView) view.findViewById(d.g.richText);
        this.eIr = (PbGiftListView) view.findViewById(d.g.gift_list_view);
        this.eIe = view;
        this.eIf = view.findViewById(d.g.new_pb_list_item_blank_top);
        this.eIo.setLayoutStrategy(new c(this.eIo.getLayoutStrategy()));
        this.czS = (TbImageView) view.findViewById(d.g.game_activity_banner);
        this.eNz = (TbImageView) view.findViewById(d.g.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.ac(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.eIo.getPaddingLeft()) - this.eIo.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds60)), i);
        this.eIo.getLayoutStrategy().fN(min);
        this.eIo.getLayoutStrategy().fO((int) (min * 1.618f));
        this.eIo.setTextSize(TbConfig.getContentSize());
        this.eIo.m(z, false);
        this.eIo.setVoiceViewRes(d.h.voice_play_btn_new);
        this.deP = view.findViewById(d.g.divider_bottom_first_floor);
        this.anQ = (TbImageView) view.findViewById(d.g.user_head_mask);
        this.eNA = (ThreadSkinView) view.findViewById(d.g.pb_item_thread_skin);
        this.eMX = (LinearLayout) view.findViewById(d.g.pb_list_content);
        this.eIJ = (TextView) view.findViewById(d.g.pb_item_tail_content);
        this.eNC = view.findViewById(d.g.link_thread_divider);
        this.eND = (BaseWebView) view.findViewById(d.g.link_thread_webview);
    }
}
