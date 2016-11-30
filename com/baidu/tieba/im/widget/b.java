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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private LinearLayout aEC;
    private TextView aKM;
    private EditText bXp;
    private TbImageView bXq;
    private BarImageView dtj;
    private TextView dtk;
    protected TextView dtl;
    private ShareFromGameCenterMsgData dtm;

    public EditText getChatMsgView() {
        return this.bXp;
    }

    public b(Context context) {
        super(context);
        aO(context);
    }

    private void aO(Context context) {
        LayoutInflater.from(context).inflate(r.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aEC = (LinearLayout) findViewById(r.g.game_to_group_share_dialog_content);
        this.dtk = (TextView) findViewById(r.g.share_title_view);
        this.bXp = (EditText) findViewById(r.g.game_to_group_share_chat_msg);
        this.bXq = (TbImageView) findViewById(r.g.game_to_group_share_img);
        this.dtj = (BarImageView) findViewById(r.g.game_to_group_share_icon);
        this.aKM = (TextView) findViewById(r.g.game_to_group_share_desc);
        at.c(this.dtk, r.d.cp_cont_b, 1);
        at.c(this.bXp, r.d.cp_cont_b, 2);
        this.bXp.setHintTextColor(at.getColor(r.d.cp_cont_e));
        at.c(this.aKM, r.d.cp_cont_f, 1);
        this.bXp.setPadding(context.getResources().getDimensionPixelSize(r.e.ds20), 0, 0, 0);
        this.dtl = (TextView) findViewById(r.g.game_to_group_share);
        at.c(this.dtl, r.d.cp_cont_c, 1);
        adV();
    }

    public void adV() {
        this.aEC.setFocusable(true);
        this.aEC.setFocusableInTouchMode(true);
        this.aEC.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bXp != null) {
            return j.a(this.bXp.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.dtm = shareFromGameCenterMsgData;
        ww();
    }

    private void ww() {
        this.dtk.setText(this.dtm.getTitle());
        this.bXq.setTag(this.dtm.getImageUrl());
        this.bXq.c(this.dtm.getImageUrl(), 17, false);
        this.dtj.setTag(this.dtm.getShareSourceIcon());
        this.dtj.c(this.dtm.getShareSourceIcon(), 17, false);
        this.aKM.setText(this.dtm.getContent());
        this.dtl.setText("来自" + this.dtm.getShareSource());
    }
}
