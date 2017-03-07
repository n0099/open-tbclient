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
    private LinearLayout aIi;
    private TextView aOh;
    private TbImageView cMd;
    private EditText cfF;
    private BarImageView dhJ;
    private TextView dhK;
    protected TextView dhL;
    private ShareFromGameCenterMsgData dhM;

    public EditText getChatMsgView() {
        return this.cfF;
    }

    public b(Context context) {
        super(context);
        bs(context);
    }

    private void bs(Context context) {
        LayoutInflater.from(context).inflate(w.j.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aIi = (LinearLayout) findViewById(w.h.game_to_group_share_dialog_content);
        this.dhK = (TextView) findViewById(w.h.share_title_view);
        this.cfF = (EditText) findViewById(w.h.game_to_group_share_chat_msg);
        this.cMd = (TbImageView) findViewById(w.h.game_to_group_share_img);
        this.dhJ = (BarImageView) findViewById(w.h.game_to_group_share_icon);
        this.aOh = (TextView) findViewById(w.h.game_to_group_share_desc);
        aq.c(this.dhK, w.e.cp_cont_b, 1);
        aq.c(this.cfF, w.e.cp_cont_b, 2);
        this.cfF.setHintTextColor(aq.getColor(w.e.cp_cont_e));
        aq.c(this.aOh, w.e.cp_cont_f, 1);
        this.cfF.setPadding(context.getResources().getDimensionPixelSize(w.f.ds20), 0, 0, 0);
        this.dhL = (TextView) findViewById(w.h.game_to_group_share);
        aq.c(this.dhL, w.e.cp_cont_c, 1);
        aeF();
    }

    public void aeF() {
        this.aIi.setFocusable(true);
        this.aIi.setFocusableInTouchMode(true);
        this.aIi.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cfF != null) {
            return j.a(this.cfF.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.dhM = shareFromGameCenterMsgData;
        wy();
    }

    private void wy() {
        this.dhK.setText(this.dhM.getTitle());
        this.cMd.setTag(this.dhM.getImageUrl());
        this.cMd.c(this.dhM.getImageUrl(), 17, false);
        this.dhJ.setTag(this.dhM.getShareSourceIcon());
        this.dhJ.c(this.dhM.getShareSourceIcon(), 17, false);
        this.aOh.setText(this.dhM.getContent());
        this.dhL.setText("来自" + this.dhM.getShareSource());
    }
}
