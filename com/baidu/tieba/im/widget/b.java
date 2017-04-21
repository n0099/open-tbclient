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
    private LinearLayout aIA;
    private TextView aOz;
    private TbImageView cMT;
    private EditText cgw;
    private ShareFromGameCenterMsgData diA;
    private BarImageView dix;
    private TextView diy;
    protected TextView diz;

    public EditText getChatMsgView() {
        return this.cgw;
    }

    public b(Context context) {
        super(context);
        bm(context);
    }

    private void bm(Context context) {
        LayoutInflater.from(context).inflate(w.j.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aIA = (LinearLayout) findViewById(w.h.game_to_group_share_dialog_content);
        this.diy = (TextView) findViewById(w.h.share_title_view);
        this.cgw = (EditText) findViewById(w.h.game_to_group_share_chat_msg);
        this.cMT = (TbImageView) findViewById(w.h.game_to_group_share_img);
        this.dix = (BarImageView) findViewById(w.h.game_to_group_share_icon);
        this.aOz = (TextView) findViewById(w.h.game_to_group_share_desc);
        aq.c(this.diy, w.e.cp_cont_b, 1);
        aq.c(this.cgw, w.e.cp_cont_b, 2);
        this.cgw.setHintTextColor(aq.getColor(w.e.cp_cont_e));
        aq.c(this.aOz, w.e.cp_cont_f, 1);
        this.cgw.setPadding(context.getResources().getDimensionPixelSize(w.f.ds20), 0, 0, 0);
        this.diz = (TextView) findViewById(w.h.game_to_group_share);
        aq.c(this.diz, w.e.cp_cont_c, 1);
        afA();
    }

    public void afA() {
        this.aIA.setFocusable(true);
        this.aIA.setFocusableInTouchMode(true);
        this.aIA.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cgw != null) {
            return j.a(this.cgw.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.diA = shareFromGameCenterMsgData;
        wU();
    }

    private void wU() {
        this.diy.setText(this.diA.getTitle());
        this.cMT.setTag(this.diA.getImageUrl());
        this.cMT.c(this.diA.getImageUrl(), 17, false);
        this.dix.setTag(this.diA.getShareSourceIcon());
        this.dix.c(this.diA.getShareSourceIcon(), 17, false);
        this.aOz.setText(this.diA.getContent());
        this.diz.setText("来自" + this.diA.getShareSource());
    }
}
