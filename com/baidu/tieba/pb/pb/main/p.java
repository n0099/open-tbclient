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
    public TbImageView aou;
    public View cUo;
    public TbImageView crs;
    public View eFY;
    public View eFZ;
    public TextView eGE;
    public TextView eGG;
    public TextView eGH;
    public TextView eGI;
    public TextView eGJ;
    public LinearLayout eGK;
    public TbRichTextView eGi;
    public PbGiftListView eGl;
    public TbImageView eKK;
    public ThreadSkinView eKL;
    public TextView eKM;
    public View eKN;
    public BaseWebView eKO;
    public LinearLayout eKh;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.eGK = (LinearLayout) view.findViewById(d.h.belong_ba);
        this.eKM = (TextView) view.findViewById(d.h.belong_bar_direction);
        this.eGG = (TextView) view.findViewById(d.h.belong_ba_btn1);
        this.eGH = (TextView) view.findViewById(d.h.belong_ba_btn2);
        this.eGI = (TextView) view.findViewById(d.h.belong_ba_btn3);
        this.eGJ = (TextView) view.findViewById(d.h.belong_ba_btn4);
        this.eGi = (TbRichTextView) view.findViewById(d.h.richText);
        this.eGl = (PbGiftListView) view.findViewById(d.h.gift_list_view);
        this.eFY = view;
        this.eFZ = view.findViewById(d.h.new_pb_list_item_blank_top);
        this.eGi.Jk();
        this.eGi.setImageViewStretch(true);
        this.crs = (TbImageView) view.findViewById(d.h.game_activity_banner);
        this.eKK = (TbImageView) view.findViewById(d.h.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.k.ad(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.eGi.getPaddingLeft()) - this.eGi.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.f.ds60)), i);
        this.eGi.setMaxImageWidth(min);
        this.eGi.setMaxImageHeight((int) (min * 1.618f));
        this.eGi.setTextSize(TbConfig.getContentSize());
        this.eGi.l(z, false);
        this.eGi.setVoiceViewRes(d.j.voice_play_btn_new);
        this.cUo = view.findViewById(d.h.divider_bottom_first_floor);
        this.aou = (TbImageView) view.findViewById(d.h.user_head_mask);
        this.eKL = (ThreadSkinView) view.findViewById(d.h.pb_item_thread_skin);
        this.eKh = (LinearLayout) view.findViewById(d.h.pb_list_content);
        this.eGE = (TextView) view.findViewById(d.h.pb_item_tail_content);
        this.eKN = view.findViewById(d.h.link_thread_divider);
        this.eKO = (BaseWebView) view.findViewById(d.h.link_thread_webview);
    }
}
