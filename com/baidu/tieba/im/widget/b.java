package com.baidu.tieba.im.widget;

import android.content.Context;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.o;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private TextView aEo;
    private EditText bqX;
    private TbImageView bqY;
    private BarImageView bqZ;
    private TextView bra;
    protected TextView brb;
    private ShareFromGameCenterMsgData brc;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.bqX;
    }

    public b(Context context) {
        super(context);
        az(context);
    }

    private void az(Context context) {
        com.baidu.adp.lib.g.b.hr().inflate(context, r.game_to_group_share_dialog, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(q.game_to_group_share_dialog_content);
        this.bra = (TextView) findViewById(q.share_title_view);
        this.bqX = (EditText) findViewById(q.game_to_group_share_chat_msg);
        this.bqY = (TbImageView) findViewById(q.game_to_group_share_img);
        this.bqZ = (BarImageView) findViewById(q.game_to_group_share_icon);
        this.aEo = (TextView) findViewById(q.game_to_group_share_desc);
        ay.b(this.bra, n.cp_cont_b, 1);
        ay.b(this.bqX, n.cp_cont_b, 2);
        this.bqX.setHintTextColor(ay.getColor(n.cp_cont_e));
        ay.b(this.aEo, n.cp_cont_f, 1);
        this.bqX.setPadding(context.getResources().getDimensionPixelSize(o.ds20), 0, 0, 0);
        this.brb = (TextView) findViewById(q.game_to_group_share);
        ay.b(this.brb, n.cp_cont_c, 1);
        Vj();
    }

    public void Vj() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bqX != null) {
            return m.a(this.bqX.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.brc = shareFromGameCenterMsgData;
        uv();
    }

    private void uv() {
        this.bra.setText(this.brc.getTitle());
        this.bqY.setTag(this.brc.getImageUrl());
        this.bqY.c(this.brc.getImageUrl(), 17, false);
        this.bqZ.setTag(this.brc.getShareSourceIcon());
        this.bqZ.c(this.brc.getShareSourceIcon(), 17, false);
        this.aEo.setText(this.brc.getContent());
        this.brb.setText("来自" + this.brc.getShareSource());
    }
}
