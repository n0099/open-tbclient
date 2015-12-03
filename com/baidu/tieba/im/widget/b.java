package com.baidu.tieba.im.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private TextView aEp;
    private TbImageView bGf;
    private BarImageView bYi;
    private TextView bYj;
    protected TextView bYk;
    private ShareFromGameCenterMsgData bYl;
    private EditText bkR;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.bkR;
    }

    public b(Context context) {
        super(context);
        as(context);
    }

    private void as(Context context) {
        LayoutInflater.from(context).inflate(n.g.game_to_group_share_dialog, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(n.f.game_to_group_share_dialog_content);
        this.bYj = (TextView) findViewById(n.f.share_title_view);
        this.bkR = (EditText) findViewById(n.f.game_to_group_share_chat_msg);
        this.bGf = (TbImageView) findViewById(n.f.game_to_group_share_img);
        this.bYi = (BarImageView) findViewById(n.f.game_to_group_share_icon);
        this.aEp = (TextView) findViewById(n.f.game_to_group_share_desc);
        as.b(this.bYj, n.c.cp_cont_b, 1);
        as.b(this.bkR, n.c.cp_cont_b, 2);
        this.bkR.setHintTextColor(as.getColor(n.c.cp_cont_e));
        as.b(this.aEp, n.c.cp_cont_f, 1);
        this.bkR.setPadding(context.getResources().getDimensionPixelSize(n.d.ds20), 0, 0, 0);
        this.bYk = (TextView) findViewById(n.f.game_to_group_share);
        as.b(this.bYk, n.c.cp_cont_c, 1);
        Qb();
    }

    public void Qb() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bkR != null) {
            return j.a(this.bkR.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.bYl = shareFromGameCenterMsgData;
        wd();
    }

    private void wd() {
        this.bYj.setText(this.bYl.getTitle());
        this.bGf.setTag(this.bYl.getImageUrl());
        this.bGf.d(this.bYl.getImageUrl(), 17, false);
        this.bYi.setTag(this.bYl.getShareSourceIcon());
        this.bYi.d(this.bYl.getShareSourceIcon(), 17, false);
        this.aEp.setText(this.bYl.getContent());
        this.bYk.setText("来自" + this.bYl.getShareSource());
    }
}
