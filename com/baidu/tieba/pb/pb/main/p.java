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
    public TbImageView aos;
    public View cVi;
    public TbImageView csk;
    public View eGS;
    public View eGT;
    public TextView eHA;
    public TextView eHB;
    public TextView eHC;
    public TextView eHD;
    public LinearLayout eHE;
    public TbRichTextView eHc;
    public PbGiftListView eHf;
    public TextView eHy;
    public TbImageView eLE;
    public ThreadSkinView eLF;
    public TextView eLG;
    public View eLH;
    public BaseWebView eLI;
    public LinearLayout eLb;
    public int mSkinType;

    public p(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.eHE = (LinearLayout) view.findViewById(d.h.belong_ba);
        this.eLG = (TextView) view.findViewById(d.h.belong_bar_direction);
        this.eHA = (TextView) view.findViewById(d.h.belong_ba_btn1);
        this.eHB = (TextView) view.findViewById(d.h.belong_ba_btn2);
        this.eHC = (TextView) view.findViewById(d.h.belong_ba_btn3);
        this.eHD = (TextView) view.findViewById(d.h.belong_ba_btn4);
        this.eHc = (TbRichTextView) view.findViewById(d.h.richText);
        this.eHf = (PbGiftListView) view.findViewById(d.h.gift_list_view);
        this.eGS = view;
        this.eGT = view.findViewById(d.h.new_pb_list_item_blank_top);
        this.eHc.Jk();
        this.eHc.setImageViewStretch(true);
        this.csk = (TbImageView) view.findViewById(d.h.game_activity_banner);
        this.eLE = (TbImageView) view.findViewById(d.h.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.k.ae(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.eHc.getPaddingLeft()) - this.eHc.getPaddingRight()) - ((int) TbadkCoreApplication.getInst().getResources().getDimension(d.f.ds60)), i);
        this.eHc.setMaxImageWidth(min);
        this.eHc.setMaxImageHeight((int) (min * 1.618f));
        this.eHc.setTextSize(TbConfig.getContentSize());
        this.eHc.l(z, false);
        this.eHc.setVoiceViewRes(d.j.voice_play_btn_new);
        this.cVi = view.findViewById(d.h.divider_bottom_first_floor);
        this.aos = (TbImageView) view.findViewById(d.h.user_head_mask);
        this.eLF = (ThreadSkinView) view.findViewById(d.h.pb_item_thread_skin);
        this.eLb = (LinearLayout) view.findViewById(d.h.pb_list_content);
        this.eHy = (TextView) view.findViewById(d.h.pb_item_tail_content);
        this.eLH = view.findViewById(d.h.link_thread_divider);
        this.eLI = (BaseWebView) view.findViewById(d.h.link_thread_webview);
    }
}
