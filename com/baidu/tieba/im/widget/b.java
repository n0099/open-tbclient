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
    private TextView aOS;
    private LinearLayout amo;
    private TbImageView cGW;
    private EditText cds;
    private TextView dcA;
    protected TextView dcB;
    private ShareFromGameCenterMsgData dcC;
    private BarImageView dcz;

    public EditText getChatMsgView() {
        return this.cds;
    }

    public b(Context context) {
        super(context);
        bp(context);
    }

    private void bp(Context context) {
        LayoutInflater.from(context).inflate(w.j.game_to_group_share_dialog, this);
        setOrientation(1);
        this.amo = (LinearLayout) findViewById(w.h.game_to_group_share_dialog_content);
        this.dcA = (TextView) findViewById(w.h.share_title_view);
        this.cds = (EditText) findViewById(w.h.game_to_group_share_chat_msg);
        this.cGW = (TbImageView) findViewById(w.h.game_to_group_share_img);
        this.dcz = (BarImageView) findViewById(w.h.game_to_group_share_icon);
        this.aOS = (TextView) findViewById(w.h.game_to_group_share_desc);
        aq.c(this.dcA, w.e.cp_cont_b, 1);
        aq.c(this.cds, w.e.cp_cont_b, 2);
        this.cds.setHintTextColor(aq.getColor(w.e.cp_cont_e));
        aq.c(this.aOS, w.e.cp_cont_f, 1);
        this.cds.setPadding(context.getResources().getDimensionPixelSize(w.f.ds20), 0, 0, 0);
        this.dcB = (TextView) findViewById(w.h.game_to_group_share);
        aq.c(this.dcB, w.e.cp_cont_c, 1);
        adj();
    }

    public void adj() {
        this.amo.setFocusable(true);
        this.amo.setFocusableInTouchMode(true);
        this.amo.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cds != null) {
            return j.a(this.cds.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.dcC = shareFromGameCenterMsgData;
        wh();
    }

    private void wh() {
        this.dcA.setText(this.dcC.getTitle());
        this.cGW.setTag(this.dcC.getImageUrl());
        this.cGW.c(this.dcC.getImageUrl(), 17, false);
        this.dcz.setTag(this.dcC.getShareSourceIcon());
        this.dcz.c(this.dcC.getShareSourceIcon(), 17, false);
        this.aOS.setText(this.dcC.getContent());
        this.dcB.setText("来自" + this.dcC.getShareSource());
    }
}
