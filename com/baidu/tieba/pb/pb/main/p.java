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
public class p extends j.a {
    public TbImageView anv;
    public View cUK;
    public TextView ceA;
    public TbImageView csv;
    public TextView eAI;
    public TextView eAK;
    public TextView eAL;
    public TextView eAM;
    public TextView eAN;
    public LinearLayout eAO;
    public View eAc;
    public View eAd;
    public TbRichTextView eAm;
    public PbGiftListView eAp;
    public TbImageView eEQ;
    public ThreadSkinView eER;
    public TextView eES;
    public View eET;
    public BaseWebView eEU;
    public LinearLayout eEm;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.eAO = (LinearLayout) view.findViewById(d.h.belong_ba);
        this.eES = (TextView) view.findViewById(d.h.belong_bar_direction);
        this.eAK = (TextView) view.findViewById(d.h.belong_ba_btn1);
        this.eAL = (TextView) view.findViewById(d.h.belong_ba_btn2);
        this.eAM = (TextView) view.findViewById(d.h.belong_ba_btn3);
        this.eAN = (TextView) view.findViewById(d.h.belong_ba_btn4);
        this.ceA = (TextView) view.findViewById(d.h.view_forum_name_first_floor);
        this.eAm = (TbRichTextView) view.findViewById(d.h.richText);
        this.eAp = (PbGiftListView) view.findViewById(d.h.gift_list_view);
        this.eAc = view;
        this.eAd = view.findViewById(d.h.new_pb_list_item_blank_top);
        this.eAm.Jn();
        this.eAm.setImageViewStretch(true);
        this.csv = (TbImageView) view.findViewById(d.h.game_activity_banner);
        this.eEQ = (TbImageView) view.findViewById(d.h.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.ad(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.eAm.getPaddingLeft()) - this.eAm.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.f.ds60)), i);
        this.eAm.setMaxImageWidth(min);
        this.eAm.setMaxImageHeight((int) (min * 1.618f));
        this.eAm.setTextSize(TbConfig.getContentSize());
        this.eAm.m(z, false);
        this.eAm.setVoiceViewRes(d.j.voice_play_btn_new);
        this.cUK = view.findViewById(d.h.divider_bottom_first_floor);
        this.anv = (TbImageView) view.findViewById(d.h.user_head_mask);
        this.eER = (ThreadSkinView) view.findViewById(d.h.pb_item_thread_skin);
        this.eEm = (LinearLayout) view.findViewById(d.h.pb_list_content);
        this.eAI = (TextView) view.findViewById(d.h.pb_item_tail_content);
        this.eET = view.findViewById(d.h.link_thread_divider);
        this.eEU = (BaseWebView) view.findViewById(d.h.link_thread_webview);
    }
}
