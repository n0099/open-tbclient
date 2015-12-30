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
    private TextView aFP;
    private TbImageView bJM;
    private EditText boI;
    private BarImageView cci;
    private TextView ccj;
    protected TextView cck;
    private ShareFromGameCenterMsgData ccl;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.boI;
    }

    public b(Context context) {
        super(context);
        as(context);
    }

    private void as(Context context) {
        LayoutInflater.from(context).inflate(n.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(n.g.game_to_group_share_dialog_content);
        this.ccj = (TextView) findViewById(n.g.share_title_view);
        this.boI = (EditText) findViewById(n.g.game_to_group_share_chat_msg);
        this.bJM = (TbImageView) findViewById(n.g.game_to_group_share_img);
        this.cci = (BarImageView) findViewById(n.g.game_to_group_share_icon);
        this.aFP = (TextView) findViewById(n.g.game_to_group_share_desc);
        as.b(this.ccj, n.d.cp_cont_b, 1);
        as.b(this.boI, n.d.cp_cont_b, 2);
        this.boI.setHintTextColor(as.getColor(n.d.cp_cont_e));
        as.b(this.aFP, n.d.cp_cont_f, 1);
        this.boI.setPadding(context.getResources().getDimensionPixelSize(n.e.ds20), 0, 0, 0);
        this.cck = (TextView) findViewById(n.g.game_to_group_share);
        as.b(this.cck, n.d.cp_cont_c, 1);
        Qt();
    }

    public void Qt() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.boI != null) {
            return j.a(this.boI.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.ccl = shareFromGameCenterMsgData;
        vN();
    }

    private void vN() {
        this.ccj.setText(this.ccl.getTitle());
        this.bJM.setTag(this.ccl.getImageUrl());
        this.bJM.d(this.ccl.getImageUrl(), 17, false);
        this.cci.setTag(this.ccl.getShareSourceIcon());
        this.cci.d(this.ccl.getShareSourceIcon(), 17, false);
        this.aFP.setText(this.ccl.getContent());
        this.cck.setText("来自" + this.ccl.getShareSource());
    }
}
