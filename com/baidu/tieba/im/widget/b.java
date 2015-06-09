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
    private TextView aEp;
    private EditText bqY;
    private TbImageView bqZ;
    private BarImageView bra;
    private TextView brb;
    protected TextView brc;
    private ShareFromGameCenterMsgData brd;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.bqY;
    }

    public b(Context context) {
        super(context);
        az(context);
    }

    private void az(Context context) {
        com.baidu.adp.lib.g.b.hr().inflate(context, r.game_to_group_share_dialog, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(q.game_to_group_share_dialog_content);
        this.brb = (TextView) findViewById(q.share_title_view);
        this.bqY = (EditText) findViewById(q.game_to_group_share_chat_msg);
        this.bqZ = (TbImageView) findViewById(q.game_to_group_share_img);
        this.bra = (BarImageView) findViewById(q.game_to_group_share_icon);
        this.aEp = (TextView) findViewById(q.game_to_group_share_desc);
        ay.b(this.brb, n.cp_cont_b, 1);
        ay.b(this.bqY, n.cp_cont_b, 2);
        this.bqY.setHintTextColor(ay.getColor(n.cp_cont_e));
        ay.b(this.aEp, n.cp_cont_f, 1);
        this.bqY.setPadding(context.getResources().getDimensionPixelSize(o.ds20), 0, 0, 0);
        this.brc = (TextView) findViewById(q.game_to_group_share);
        ay.b(this.brc, n.cp_cont_c, 1);
        Vk();
    }

    public void Vk() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bqY != null) {
            return m.a(this.bqY.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.brd = shareFromGameCenterMsgData;
        uv();
    }

    private void uv() {
        this.brb.setText(this.brd.getTitle());
        this.bqZ.setTag(this.brd.getImageUrl());
        this.bqZ.c(this.brd.getImageUrl(), 17, false);
        this.bra.setTag(this.brd.getShareSourceIcon());
        this.bra.c(this.brd.getShareSourceIcon(), 17, false);
        this.aEp.setText(this.brd.getContent());
        this.brc.setText("来自" + this.brd.getShareSource());
    }
}
