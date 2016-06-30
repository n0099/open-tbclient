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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private LinearLayout aAr;
    private TextView aGn;
    private EditText bUf;
    private TbImageView cDg;
    private TextView cXA;
    protected TextView cXB;
    private ShareFromGameCenterMsgData cXC;
    private BarImageView cXz;

    public EditText getChatMsgView() {
        return this.bUf;
    }

    public b(Context context) {
        super(context);
        ar(context);
    }

    private void ar(Context context) {
        LayoutInflater.from(context).inflate(u.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aAr = (LinearLayout) findViewById(u.g.game_to_group_share_dialog_content);
        this.cXA = (TextView) findViewById(u.g.share_title_view);
        this.bUf = (EditText) findViewById(u.g.game_to_group_share_chat_msg);
        this.cDg = (TbImageView) findViewById(u.g.game_to_group_share_img);
        this.cXz = (BarImageView) findViewById(u.g.game_to_group_share_icon);
        this.aGn = (TextView) findViewById(u.g.game_to_group_share_desc);
        av.c(this.cXA, u.d.cp_cont_b, 1);
        av.c(this.bUf, u.d.cp_cont_b, 2);
        this.bUf.setHintTextColor(av.getColor(u.d.cp_cont_e));
        av.c(this.aGn, u.d.cp_cont_f, 1);
        this.bUf.setPadding(context.getResources().getDimensionPixelSize(u.e.ds20), 0, 0, 0);
        this.cXB = (TextView) findViewById(u.g.game_to_group_share);
        av.c(this.cXB, u.d.cp_cont_c, 1);
        aaB();
    }

    public void aaB() {
        this.aAr.setFocusable(true);
        this.aAr.setFocusableInTouchMode(true);
        this.aAr.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bUf != null) {
            return j.a(this.bUf.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.cXC = shareFromGameCenterMsgData;
        uY();
    }

    private void uY() {
        this.cXA.setText(this.cXC.getTitle());
        this.cDg.setTag(this.cXC.getImageUrl());
        this.cDg.c(this.cXC.getImageUrl(), 17, false);
        this.cXz.setTag(this.cXC.getShareSourceIcon());
        this.cXz.c(this.cXC.getShareSourceIcon(), 17, false);
        this.aGn.setText(this.cXC.getContent());
        this.cXB.setText("来自" + this.cXC.getShareSource());
    }
}
