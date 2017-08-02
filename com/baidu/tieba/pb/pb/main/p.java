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
    public TbImageView anB;
    public View cKF;
    public TbImageView ckd;
    public TbRichTextView eEG;
    public PbGiftListView eEJ;
    public View eEw;
    public View eEx;
    public TextView eFc;
    public TextView eFe;
    public TextView eFf;
    public TextView eFg;
    public TextView eFh;
    public LinearLayout eFi;
    public LinearLayout eII;
    public TbImageView eJk;
    public ThreadSkinView eJl;
    public TextView eJm;
    public View eJn;
    public BaseWebView eJo;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.eFi = (LinearLayout) view.findViewById(d.h.belong_ba);
        this.eJm = (TextView) view.findViewById(d.h.belong_bar_direction);
        this.eFe = (TextView) view.findViewById(d.h.belong_ba_btn1);
        this.eFf = (TextView) view.findViewById(d.h.belong_ba_btn2);
        this.eFg = (TextView) view.findViewById(d.h.belong_ba_btn3);
        this.eFh = (TextView) view.findViewById(d.h.belong_ba_btn4);
        this.eEG = (TbRichTextView) view.findViewById(d.h.richText);
        this.eEJ = (PbGiftListView) view.findViewById(d.h.gift_list_view);
        this.eEw = view;
        this.eEx = view.findViewById(d.h.new_pb_list_item_blank_top);
        this.eEG.IV();
        this.eEG.setImageViewStretch(true);
        this.ckd = (TbImageView) view.findViewById(d.h.game_activity_banner);
        this.eJk = (TbImageView) view.findViewById(d.h.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.k.af(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.eEG.getPaddingLeft()) - this.eEG.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.f.ds60)), i);
        this.eEG.setMaxImageWidth(min);
        this.eEG.setMaxImageHeight((int) (min * 1.618f));
        this.eEG.setTextSize(TbConfig.getContentSize());
        this.eEG.k(z, false);
        this.eEG.setVoiceViewRes(d.j.voice_play_btn_new);
        this.cKF = view.findViewById(d.h.divider_bottom_first_floor);
        this.anB = (TbImageView) view.findViewById(d.h.user_head_mask);
        this.eJl = (ThreadSkinView) view.findViewById(d.h.pb_item_thread_skin);
        this.eII = (LinearLayout) view.findViewById(d.h.pb_list_content);
        this.eFc = (TextView) view.findViewById(d.h.pb_item_tail_content);
        this.eJn = view.findViewById(d.h.link_thread_divider);
        this.eJo = (BaseWebView) view.findViewById(d.h.link_thread_webview);
    }
}
