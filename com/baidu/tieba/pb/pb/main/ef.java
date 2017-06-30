package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.view.PbGiftListView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ef extends z.a {
    public TbImageView amQ;
    public View cDv;
    public TbImageView cer;
    public PbGiftListView etB;
    public TextView etU;
    public TextView etW;
    public TextView etX;
    public TextView etY;
    public TextView etZ;
    public View eto;
    public View etp;
    public TbRichTextView ety;
    public LinearLayout eua;
    public LinearLayout exy;
    public TbImageView eya;
    public ThreadSkinView eyb;
    public TextView eyc;
    public View eyd;
    public BaseWebView eye;
    public int mSkinType;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [73=5] */
    public ef(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.eua = (LinearLayout) view.findViewById(w.h.belong_ba);
        this.eyc = (TextView) view.findViewById(w.h.belong_bar_direction);
        this.etW = (TextView) view.findViewById(w.h.belong_ba_btn1);
        this.etX = (TextView) view.findViewById(w.h.belong_ba_btn2);
        this.etY = (TextView) view.findViewById(w.h.belong_ba_btn3);
        this.etZ = (TextView) view.findViewById(w.h.belong_ba_btn4);
        this.ety = (TbRichTextView) view.findViewById(w.h.richText);
        this.etB = (PbGiftListView) view.findViewById(w.h.gift_list_view);
        this.eto = view;
        this.etp = view.findViewById(w.h.new_pb_list_item_blank_top);
        this.ety.IJ();
        this.ety.setImageViewStretch(true);
        this.cer = (TbImageView) view.findViewById(w.h.game_activity_banner);
        this.eya = (TbImageView) view.findViewById(w.h.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.ety.getPaddingLeft()) - this.ety.getPaddingRight()) - ((int) TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds60)), i);
        this.ety.setMaxImageWidth(min);
        this.ety.setMaxImageHeight((int) (min * 1.618f));
        this.ety.setTextSize(TbConfig.getContentSize());
        this.ety.k(z, false);
        this.ety.setVoiceViewRes(w.j.voice_play_btn_new);
        this.cDv = view.findViewById(w.h.divider_bottom_first_floor);
        this.amQ = (TbImageView) view.findViewById(w.h.user_head_mask);
        this.eyb = (ThreadSkinView) view.findViewById(w.h.pb_item_thread_skin);
        this.exy = (LinearLayout) view.findViewById(w.h.pb_list_content);
        this.etU = (TextView) view.findViewById(w.h.pb_item_tail_content);
        this.eyd = view.findViewById(w.h.link_thread_divider);
        this.eye = (BaseWebView) view.findViewById(w.h.link_thread_webview);
    }
}
