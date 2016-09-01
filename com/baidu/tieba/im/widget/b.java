package com.baidu.tieba.im.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private LinearLayout aEo;
    private TextView aKu;
    private TbImageView cRC;
    private EditText chp;
    private BarImageView dmd;
    private TextView dme;
    protected TextView dmf;
    private ShareFromGameCenterMsgData dmg;

    public EditText getChatMsgView() {
        return this.chp;
    }

    public b(Context context) {
        super(context);
        aE(context);
    }

    private void aE(Context context) {
        LayoutInflater.from(context).inflate(t.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aEo = (LinearLayout) findViewById(t.g.game_to_group_share_dialog_content);
        this.dme = (TextView) findViewById(t.g.share_title_view);
        this.chp = (EditText) findViewById(t.g.game_to_group_share_chat_msg);
        this.cRC = (TbImageView) findViewById(t.g.game_to_group_share_img);
        this.dmd = (BarImageView) findViewById(t.g.game_to_group_share_icon);
        this.aKu = (TextView) findViewById(t.g.game_to_group_share_desc);
        av.c(this.dme, t.d.cp_cont_b, 1);
        av.c(this.chp, t.d.cp_cont_b, 2);
        this.chp.setHintTextColor(av.getColor(t.d.cp_cont_e));
        av.c(this.aKu, t.d.cp_cont_f, 1);
        this.chp.setPadding(context.getResources().getDimensionPixelSize(t.e.ds20), 0, 0, 0);
        this.dmf = (TextView) findViewById(t.g.game_to_group_share);
        av.c(this.dmf, t.d.cp_cont_c, 1);
        afO();
    }

    public void afO() {
        this.aEo.setFocusable(true);
        this.aEo.setFocusableInTouchMode(true);
        this.aEo.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.chp != null) {
            return j.a(this.chp.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.dmg = shareFromGameCenterMsgData;
        wc();
    }

    private void wc() {
        this.dme.setText(this.dmg.getTitle());
        this.cRC.setTag(this.dmg.getImageUrl());
        this.cRC.c(this.dmg.getImageUrl(), 17, false);
        this.dmd.setTag(this.dmg.getShareSourceIcon());
        this.dmd.c(this.dmg.getShareSourceIcon(), 17, false);
        this.aKu.setText(this.dmg.getContent());
        this.dmf.setText("来自" + this.dmg.getShareSource());
    }
}
