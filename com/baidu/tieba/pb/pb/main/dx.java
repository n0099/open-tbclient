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
public class dx extends z.a {
    public TbImageView alY;
    public TbImageView bWj;
    public View cvI;
    public PbGiftListView ekC;
    public TextView ekV;
    public TextView ekX;
    public TextView ekY;
    public TextView ekZ;
    public View ekp;
    public View ekq;
    public TbRichTextView ekz;
    public TextView ela;
    public LinearLayout elb;
    public TbImageView eoU;
    public ThreadSkinView eoV;
    public TextView eoW;
    public View eoX;
    public BaseWebView eoY;
    public LinearLayout eos;
    public int mSkinType;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [73=5] */
    public dx(TbPageContext tbPageContext, View view, boolean z, int i) {
        super(view);
        this.mSkinType = 3;
        this.elb = (LinearLayout) view.findViewById(w.h.belong_ba);
        this.eoW = (TextView) view.findViewById(w.h.belong_bar_direction);
        this.ekX = (TextView) view.findViewById(w.h.belong_ba_btn1);
        this.ekY = (TextView) view.findViewById(w.h.belong_ba_btn2);
        this.ekZ = (TextView) view.findViewById(w.h.belong_ba_btn3);
        this.ela = (TextView) view.findViewById(w.h.belong_ba_btn4);
        this.ekz = (TbRichTextView) view.findViewById(w.h.richText);
        this.ekC = (PbGiftListView) view.findViewById(w.h.gift_list_view);
        this.ekp = view;
        this.ekq = view.findViewById(w.h.new_pb_list_item_blank_top);
        this.ekz.Il();
        this.ekz.setImageViewStretch(true);
        this.bWj = (TbImageView) view.findViewById(w.h.game_activity_banner);
        this.eoU = (TbImageView) view.findViewById(w.h.game_activity_banner);
        int min = Math.min(((((com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - this.ekz.getPaddingLeft()) - this.ekz.getPaddingRight()) - ((int) TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds60)), i);
        this.ekz.setMaxImageWidth(min);
        this.ekz.setMaxImageHeight((int) (min * 1.618f));
        this.ekz.setTextSize(TbConfig.getContentSize());
        this.ekz.j(z, false);
        this.ekz.setVoiceViewRes(w.j.voice_play_btn_new);
        this.cvI = view.findViewById(w.h.divider_bottom_first_floor);
        this.alY = (TbImageView) view.findViewById(w.h.user_head_mask);
        this.eoV = (ThreadSkinView) view.findViewById(w.h.pb_item_thread_skin);
        this.eos = (LinearLayout) view.findViewById(w.h.pb_list_content);
        this.ekV = (TextView) view.findViewById(w.h.pb_item_tail_content);
        this.eoX = view.findViewById(w.h.link_thread_divider);
        this.eoY = (BaseWebView) view.findViewById(w.h.link_thread_webview);
    }
}
