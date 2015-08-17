package com.baidu.tieba.im.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private TextView aLO;
    private EditText bEM;
    private TbImageView bEN;
    private BarImageView bEO;
    private TextView bEP;
    protected TextView bEQ;
    private ShareFromGameCenterMsgData bER;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.bEM;
    }

    public b(Context context) {
        super(context);
        aB(context);
    }

    private void aB(Context context) {
        LayoutInflater.from(context).inflate(i.g.game_to_group_share_dialog, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(i.f.game_to_group_share_dialog_content);
        this.bEP = (TextView) findViewById(i.f.share_title_view);
        this.bEM = (EditText) findViewById(i.f.game_to_group_share_chat_msg);
        this.bEN = (TbImageView) findViewById(i.f.game_to_group_share_img);
        this.bEO = (BarImageView) findViewById(i.f.game_to_group_share_icon);
        this.aLO = (TextView) findViewById(i.f.game_to_group_share_desc);
        al.b(this.bEP, i.c.cp_cont_b, 1);
        al.b(this.bEM, i.c.cp_cont_b, 2);
        this.bEM.setHintTextColor(al.getColor(i.c.cp_cont_e));
        al.b(this.aLO, i.c.cp_cont_f, 1);
        this.bEM.setPadding(context.getResources().getDimensionPixelSize(i.d.ds20), 0, 0, 0);
        this.bEQ = (TextView) findViewById(i.f.game_to_group_share);
        al.b(this.bEQ, i.c.cp_cont_c, 1);
        WR();
    }

    public void WR() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bEM != null) {
            return j.a(this.bEM.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.bER = shareFromGameCenterMsgData;
        vz();
    }

    private void vz() {
        this.bEP.setText(this.bER.getTitle());
        this.bEN.setTag(this.bER.getImageUrl());
        this.bEN.d(this.bER.getImageUrl(), 17, false);
        this.bEO.setTag(this.bER.getShareSourceIcon());
        this.bEO.d(this.bER.getShareSourceIcon(), 17, false);
        this.aLO.setText(this.bER.getContent());
        this.bEQ.setText("来自" + this.bER.getShareSource());
    }
}
