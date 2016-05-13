package com.baidu.tieba.im.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private TextView aFL;
    private LinearLayout azz;
    private TbImageView bYs;
    private EditText bwz;
    private BarImageView csk;
    private TextView csl;
    protected TextView csm;
    private ShareFromGameCenterMsgData csn;

    public EditText getChatMsgView() {
        return this.bwz;
    }

    public b(Context context) {
        super(context);
        ar(context);
    }

    private void ar(Context context) {
        LayoutInflater.from(context).inflate(t.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.azz = (LinearLayout) findViewById(t.g.game_to_group_share_dialog_content);
        this.csl = (TextView) findViewById(t.g.share_title_view);
        this.bwz = (EditText) findViewById(t.g.game_to_group_share_chat_msg);
        this.bYs = (TbImageView) findViewById(t.g.game_to_group_share_img);
        this.csk = (BarImageView) findViewById(t.g.game_to_group_share_icon);
        this.aFL = (TextView) findViewById(t.g.game_to_group_share_desc);
        at.c(this.csl, t.d.cp_cont_b, 1);
        at.c(this.bwz, t.d.cp_cont_b, 2);
        this.bwz.setHintTextColor(at.getColor(t.d.cp_cont_e));
        at.c(this.aFL, t.d.cp_cont_f, 1);
        this.bwz.setPadding(context.getResources().getDimensionPixelSize(t.e.ds20), 0, 0, 0);
        this.csm = (TextView) findViewById(t.g.game_to_group_share);
        at.c(this.csm, t.d.cp_cont_c, 1);
        Uo();
    }

    public void Uo() {
        this.azz.setFocusable(true);
        this.azz.setFocusableInTouchMode(true);
        this.azz.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bwz != null) {
            return j.a(this.bwz.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.csn = shareFromGameCenterMsgData;
        uY();
    }

    private void uY() {
        this.csl.setText(this.csn.getTitle());
        this.bYs.setTag(this.csn.getImageUrl());
        this.bYs.c(this.csn.getImageUrl(), 17, false);
        this.csk.setTag(this.csn.getShareSourceIcon());
        this.csk.c(this.csn.getShareSourceIcon(), 17, false);
        this.aFL.setText(this.csn.getContent());
        this.csm.setText("来自" + this.csn.getShareSource());
    }
}
