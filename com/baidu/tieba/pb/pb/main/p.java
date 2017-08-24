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
    public TbImageView aoV;
    public View cNX;
    public TbImageView clX;
    public View eHF;
    public View eHG;
    public TbRichTextView eHP;
    public PbGiftListView eHS;
    public TextView eIl;
    public TextView eIn;
    public TextView eIo;
    public TextView eIp;
    public TextView eIq;
    public LinearLayout eIr;
    public LinearLayout eLR;
    public TbImageView eMt;
    public ThreadSkinView eMu;
    public TextView eMv;
    public View eMw;
    public BaseWebView eMx;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.eIr = (LinearLayout) view.findViewById(d.h.belong_ba);
        this.eMv = (TextView) view.findViewById(d.h.belong_bar_direction);
        this.eIn = (TextView) view.findViewById(d.h.belong_ba_btn1);
        this.eIo = (TextView) view.findViewById(d.h.belong_ba_btn2);
        this.eIp = (TextView) view.findViewById(d.h.belong_ba_btn3);
        this.eIq = (TextView) view.findViewById(d.h.belong_ba_btn4);
        this.eHP = (TbRichTextView) view.findViewById(d.h.richText);
        this.eHS = (PbGiftListView) view.findViewById(d.h.gift_list_view);
        this.eHF = view;
        this.eHG = view.findViewById(d.h.new_pb_list_item_blank_top);
        this.eHP.Jc();
        this.eHP.setImageViewStretch(true);
        this.clX = (TbImageView) view.findViewById(d.h.game_activity_banner);
        this.eMt = (TbImageView) view.findViewById(d.h.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.eHP.getPaddingLeft()) - this.eHP.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.f.ds60)), i);
        this.eHP.setMaxImageWidth(min);
        this.eHP.setMaxImageHeight((int) (min * 1.618f));
        this.eHP.setTextSize(TbConfig.getContentSize());
        this.eHP.k(z, false);
        this.eHP.setVoiceViewRes(d.j.voice_play_btn_new);
        this.cNX = view.findViewById(d.h.divider_bottom_first_floor);
        this.aoV = (TbImageView) view.findViewById(d.h.user_head_mask);
        this.eMu = (ThreadSkinView) view.findViewById(d.h.pb_item_thread_skin);
        this.eLR = (LinearLayout) view.findViewById(d.h.pb_list_content);
        this.eIl = (TextView) view.findViewById(d.h.pb_item_tail_content);
        this.eMw = view.findViewById(d.h.link_thread_divider);
        this.eMx = (BaseWebView) view.findViewById(d.h.link_thread_webview);
    }
}
