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
    private TextView aMb;
    private EditText bFt;
    private TbImageView bFu;
    private BarImageView bFv;
    private TextView bFw;
    protected TextView bFx;
    private ShareFromGameCenterMsgData bFy;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.bFt;
    }

    public b(Context context) {
        super(context);
        aA(context);
    }

    private void aA(Context context) {
        LayoutInflater.from(context).inflate(i.g.game_to_group_share_dialog, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(i.f.game_to_group_share_dialog_content);
        this.bFw = (TextView) findViewById(i.f.share_title_view);
        this.bFt = (EditText) findViewById(i.f.game_to_group_share_chat_msg);
        this.bFu = (TbImageView) findViewById(i.f.game_to_group_share_img);
        this.bFv = (BarImageView) findViewById(i.f.game_to_group_share_icon);
        this.aMb = (TextView) findViewById(i.f.game_to_group_share_desc);
        al.b(this.bFw, i.c.cp_cont_b, 1);
        al.b(this.bFt, i.c.cp_cont_b, 2);
        this.bFt.setHintTextColor(al.getColor(i.c.cp_cont_e));
        al.b(this.aMb, i.c.cp_cont_f, 1);
        this.bFt.setPadding(context.getResources().getDimensionPixelSize(i.d.ds20), 0, 0, 0);
        this.bFx = (TextView) findViewById(i.f.game_to_group_share);
        al.b(this.bFx, i.c.cp_cont_c, 1);
        WT();
    }

    public void WT() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bFt != null) {
            return j.a(this.bFt.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.bFy = shareFromGameCenterMsgData;
        vE();
    }

    private void vE() {
        this.bFw.setText(this.bFy.getTitle());
        this.bFu.setTag(this.bFy.getImageUrl());
        this.bFu.d(this.bFy.getImageUrl(), 17, false);
        this.bFv.setTag(this.bFy.getShareSourceIcon());
        this.bFv.d(this.bFy.getShareSourceIcon(), 17, false);
        this.aMb.setText(this.bFy.getContent());
        this.bFx.setText("来自" + this.bFy.getShareSource());
    }
}
