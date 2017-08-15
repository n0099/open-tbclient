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
    public TbImageView clW;
    public View eHD;
    public View eHE;
    public TbRichTextView eHN;
    public PbGiftListView eHQ;
    public TextView eIj;
    public TextView eIl;
    public TextView eIm;
    public TextView eIn;
    public TextView eIo;
    public LinearLayout eIp;
    public LinearLayout eLP;
    public TbImageView eMr;
    public ThreadSkinView eMs;
    public TextView eMt;
    public View eMu;
    public BaseWebView eMv;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.eIp = (LinearLayout) view.findViewById(d.h.belong_ba);
        this.eMt = (TextView) view.findViewById(d.h.belong_bar_direction);
        this.eIl = (TextView) view.findViewById(d.h.belong_ba_btn1);
        this.eIm = (TextView) view.findViewById(d.h.belong_ba_btn2);
        this.eIn = (TextView) view.findViewById(d.h.belong_ba_btn3);
        this.eIo = (TextView) view.findViewById(d.h.belong_ba_btn4);
        this.eHN = (TbRichTextView) view.findViewById(d.h.richText);
        this.eHQ = (PbGiftListView) view.findViewById(d.h.gift_list_view);
        this.eHD = view;
        this.eHE = view.findViewById(d.h.new_pb_list_item_blank_top);
        this.eHN.Jc();
        this.eHN.setImageViewStretch(true);
        this.clW = (TbImageView) view.findViewById(d.h.game_activity_banner);
        this.eMr = (TbImageView) view.findViewById(d.h.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.eHN.getPaddingLeft()) - this.eHN.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.f.ds60)), i);
        this.eHN.setMaxImageWidth(min);
        this.eHN.setMaxImageHeight((int) (min * 1.618f));
        this.eHN.setTextSize(TbConfig.getContentSize());
        this.eHN.k(z, false);
        this.eHN.setVoiceViewRes(d.j.voice_play_btn_new);
        this.cNX = view.findViewById(d.h.divider_bottom_first_floor);
        this.aoV = (TbImageView) view.findViewById(d.h.user_head_mask);
        this.eMs = (ThreadSkinView) view.findViewById(d.h.pb_item_thread_skin);
        this.eLP = (LinearLayout) view.findViewById(d.h.pb_list_content);
        this.eIj = (TextView) view.findViewById(d.h.pb_item_tail_content);
        this.eMu = view.findViewById(d.h.link_thread_divider);
        this.eMv = (BaseWebView) view.findViewById(d.h.link_thread_webview);
    }
}
