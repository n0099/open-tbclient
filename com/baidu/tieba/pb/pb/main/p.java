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
    public TbImageView anH;
    public View cUW;
    public TextView ceM;
    public TbImageView csH;
    public TbRichTextView eAA;
    public PbGiftListView eAD;
    public TextView eAW;
    public TextView eAY;
    public TextView eAZ;
    public View eAq;
    public View eAr;
    public TextView eBa;
    public TextView eBb;
    public LinearLayout eBc;
    public LinearLayout eEA;
    public TbImageView eFe;
    public ThreadSkinView eFf;
    public TextView eFg;
    public View eFh;
    public BaseWebView eFi;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.eBc = (LinearLayout) view.findViewById(d.h.belong_ba);
        this.eFg = (TextView) view.findViewById(d.h.belong_bar_direction);
        this.eAY = (TextView) view.findViewById(d.h.belong_ba_btn1);
        this.eAZ = (TextView) view.findViewById(d.h.belong_ba_btn2);
        this.eBa = (TextView) view.findViewById(d.h.belong_ba_btn3);
        this.eBb = (TextView) view.findViewById(d.h.belong_ba_btn4);
        this.ceM = (TextView) view.findViewById(d.h.view_forum_name_first_floor);
        this.eAA = (TbRichTextView) view.findViewById(d.h.richText);
        this.eAD = (PbGiftListView) view.findViewById(d.h.gift_list_view);
        this.eAq = view;
        this.eAr = view.findViewById(d.h.new_pb_list_item_blank_top);
        this.eAA.Jt();
        this.eAA.setImageViewStretch(true);
        this.csH = (TbImageView) view.findViewById(d.h.game_activity_banner);
        this.eFe = (TbImageView) view.findViewById(d.h.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.l.ad(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.eAA.getPaddingLeft()) - this.eAA.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.f.ds60)), i);
        this.eAA.setMaxImageWidth(min);
        this.eAA.setMaxImageHeight((int) (min * 1.618f));
        this.eAA.setTextSize(TbConfig.getContentSize());
        this.eAA.m(z, false);
        this.eAA.setVoiceViewRes(d.j.voice_play_btn_new);
        this.cUW = view.findViewById(d.h.divider_bottom_first_floor);
        this.anH = (TbImageView) view.findViewById(d.h.user_head_mask);
        this.eFf = (ThreadSkinView) view.findViewById(d.h.pb_item_thread_skin);
        this.eEA = (LinearLayout) view.findViewById(d.h.pb_list_content);
        this.eAW = (TextView) view.findViewById(d.h.pb_item_tail_content);
        this.eFh = view.findViewById(d.h.link_thread_divider);
        this.eFi = (BaseWebView) view.findViewById(d.h.link_thread_webview);
    }
}
