package com.baidu.tieba.im.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private LinearLayout aIy;
    private TextView aOx;
    private TbImageView cKC;
    private EditText cef;
    private BarImageView dgg;
    private TextView dgh;
    protected TextView dgi;
    private ShareFromGameCenterMsgData dgj;

    public EditText getChatMsgView() {
        return this.cef;
    }

    public b(Context context) {
        super(context);
        bm(context);
    }

    private void bm(Context context) {
        LayoutInflater.from(context).inflate(w.j.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aIy = (LinearLayout) findViewById(w.h.game_to_group_share_dialog_content);
        this.dgh = (TextView) findViewById(w.h.share_title_view);
        this.cef = (EditText) findViewById(w.h.game_to_group_share_chat_msg);
        this.cKC = (TbImageView) findViewById(w.h.game_to_group_share_img);
        this.dgg = (BarImageView) findViewById(w.h.game_to_group_share_icon);
        this.aOx = (TextView) findViewById(w.h.game_to_group_share_desc);
        aq.c(this.dgh, w.e.cp_cont_b, 1);
        aq.c(this.cef, w.e.cp_cont_b, 2);
        this.cef.setHintTextColor(aq.getColor(w.e.cp_cont_e));
        aq.c(this.aOx, w.e.cp_cont_f, 1);
        this.cef.setPadding(context.getResources().getDimensionPixelSize(w.f.ds20), 0, 0, 0);
        this.dgi = (TextView) findViewById(w.h.game_to_group_share);
        aq.c(this.dgi, w.e.cp_cont_c, 1);
        aez();
    }

    public void aez() {
        this.aIy.setFocusable(true);
        this.aIy.setFocusableInTouchMode(true);
        this.aIy.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cef != null) {
            return j.a(this.cef.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.dgj = shareFromGameCenterMsgData;
        wU();
    }

    private void wU() {
        this.dgh.setText(this.dgj.getTitle());
        this.cKC.setTag(this.dgj.getImageUrl());
        this.cKC.c(this.dgj.getImageUrl(), 17, false);
        this.dgg.setTag(this.dgj.getShareSourceIcon());
        this.dgg.c(this.dgj.getShareSourceIcon(), 17, false);
        this.aOx.setText(this.dgj.getContent());
        this.dgi.setText("来自" + this.dgj.getShareSource());
    }
}
