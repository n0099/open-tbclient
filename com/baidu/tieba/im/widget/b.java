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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private LinearLayout aDM;
    private TextView aJT;
    private TbImageView cSt;
    private EditText chn;
    private BarImageView dnA;
    private TextView dnB;
    protected TextView dnC;
    private ShareFromGameCenterMsgData dnD;

    public EditText getChatMsgView() {
        return this.chn;
    }

    public b(Context context) {
        super(context);
        aC(context);
    }

    private void aC(Context context) {
        LayoutInflater.from(context).inflate(r.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aDM = (LinearLayout) findViewById(r.g.game_to_group_share_dialog_content);
        this.dnB = (TextView) findViewById(r.g.share_title_view);
        this.chn = (EditText) findViewById(r.g.game_to_group_share_chat_msg);
        this.cSt = (TbImageView) findViewById(r.g.game_to_group_share_img);
        this.dnA = (BarImageView) findViewById(r.g.game_to_group_share_icon);
        this.aJT = (TextView) findViewById(r.g.game_to_group_share_desc);
        av.c(this.dnB, r.d.cp_cont_b, 1);
        av.c(this.chn, r.d.cp_cont_b, 2);
        this.chn.setHintTextColor(av.getColor(r.d.cp_cont_e));
        av.c(this.aJT, r.d.cp_cont_f, 1);
        this.chn.setPadding(context.getResources().getDimensionPixelSize(r.e.ds20), 0, 0, 0);
        this.dnC = (TextView) findViewById(r.g.game_to_group_share);
        av.c(this.dnC, r.d.cp_cont_c, 1);
        agc();
    }

    public void agc() {
        this.aDM.setFocusable(true);
        this.aDM.setFocusableInTouchMode(true);
        this.aDM.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.chn != null) {
            return j.a(this.chn.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.dnD = shareFromGameCenterMsgData;
        ws();
    }

    private void ws() {
        this.dnB.setText(this.dnD.getTitle());
        this.cSt.setTag(this.dnD.getImageUrl());
        this.cSt.c(this.dnD.getImageUrl(), 17, false);
        this.dnA.setTag(this.dnD.getShareSourceIcon());
        this.dnA.c(this.dnD.getShareSourceIcon(), 17, false);
        this.aJT.setText(this.dnD.getContent());
        this.dnC.setText("来自" + this.dnD.getShareSource());
    }
}
