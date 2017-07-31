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
    public TbImageView aoU;
    public View cMa;
    public TbImageView cll;
    public View eFJ;
    public View eFK;
    public TbRichTextView eFT;
    public PbGiftListView eFW;
    public TextView eGp;
    public TextView eGr;
    public TextView eGs;
    public TextView eGt;
    public TextView eGu;
    public LinearLayout eGv;
    public LinearLayout eJV;
    public View eKA;
    public BaseWebView eKB;
    public TbImageView eKx;
    public ThreadSkinView eKy;
    public TextView eKz;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.eGv = (LinearLayout) view.findViewById(d.h.belong_ba);
        this.eKz = (TextView) view.findViewById(d.h.belong_bar_direction);
        this.eGr = (TextView) view.findViewById(d.h.belong_ba_btn1);
        this.eGs = (TextView) view.findViewById(d.h.belong_ba_btn2);
        this.eGt = (TextView) view.findViewById(d.h.belong_ba_btn3);
        this.eGu = (TextView) view.findViewById(d.h.belong_ba_btn4);
        this.eFT = (TbRichTextView) view.findViewById(d.h.richText);
        this.eFW = (PbGiftListView) view.findViewById(d.h.gift_list_view);
        this.eFJ = view;
        this.eFK = view.findViewById(d.h.new_pb_list_item_blank_top);
        this.eFT.Jc();
        this.eFT.setImageViewStretch(true);
        this.cll = (TbImageView) view.findViewById(d.h.game_activity_banner);
        this.eKx = (TbImageView) view.findViewById(d.h.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.eFT.getPaddingLeft()) - this.eFT.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.f.ds60)), i);
        this.eFT.setMaxImageWidth(min);
        this.eFT.setMaxImageHeight((int) (min * 1.618f));
        this.eFT.setTextSize(TbConfig.getContentSize());
        this.eFT.k(z, false);
        this.eFT.setVoiceViewRes(d.j.voice_play_btn_new);
        this.cMa = view.findViewById(d.h.divider_bottom_first_floor);
        this.aoU = (TbImageView) view.findViewById(d.h.user_head_mask);
        this.eKy = (ThreadSkinView) view.findViewById(d.h.pb_item_thread_skin);
        this.eJV = (LinearLayout) view.findViewById(d.h.pb_list_content);
        this.eGp = (TextView) view.findViewById(d.h.pb_item_tail_content);
        this.eKA = view.findViewById(d.h.link_thread_divider);
        this.eKB = (BaseWebView) view.findViewById(d.h.link_thread_webview);
    }
}
