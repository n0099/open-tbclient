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
    private LinearLayout aDv;
    private TextView aJE;
    private TbImageView bXN;
    private EditText bwN;
    private BarImageView crn;
    private TextView cro;
    protected TextView crp;
    private ShareFromGameCenterMsgData crq;

    public EditText getChatMsgView() {
        return this.bwN;
    }

    public b(Context context) {
        super(context);
        aq(context);
    }

    private void aq(Context context) {
        LayoutInflater.from(context).inflate(t.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aDv = (LinearLayout) findViewById(t.g.game_to_group_share_dialog_content);
        this.cro = (TextView) findViewById(t.g.share_title_view);
        this.bwN = (EditText) findViewById(t.g.game_to_group_share_chat_msg);
        this.bXN = (TbImageView) findViewById(t.g.game_to_group_share_img);
        this.crn = (BarImageView) findViewById(t.g.game_to_group_share_icon);
        this.aJE = (TextView) findViewById(t.g.game_to_group_share_desc);
        at.b(this.cro, t.d.cp_cont_b, 1);
        at.b(this.bwN, t.d.cp_cont_b, 2);
        this.bwN.setHintTextColor(at.getColor(t.d.cp_cont_e));
        at.b(this.aJE, t.d.cp_cont_f, 1);
        this.bwN.setPadding(context.getResources().getDimensionPixelSize(t.e.ds20), 0, 0, 0);
        this.crp = (TextView) findViewById(t.g.game_to_group_share);
        at.b(this.crp, t.d.cp_cont_c, 1);
        Uo();
    }

    public void Uo() {
        this.aDv.setFocusable(true);
        this.aDv.setFocusableInTouchMode(true);
        this.aDv.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bwN != null) {
            return j.a(this.bwN.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.crq = shareFromGameCenterMsgData;
        xo();
    }

    private void xo() {
        this.cro.setText(this.crq.getTitle());
        this.bXN.setTag(this.crq.getImageUrl());
        this.bXN.c(this.crq.getImageUrl(), 17, false);
        this.crn.setTag(this.crq.getShareSourceIcon());
        this.crn.c(this.crq.getShareSourceIcon(), 17, false);
        this.aJE.setText(this.crq.getContent());
        this.crp.setText("来自" + this.crq.getShareSource());
    }
}
