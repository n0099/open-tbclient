package com.baidu.tieba.im.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private TextView aCJ;
    private TbImageView bIH;
    private BarImageView bII;
    private TextView bIJ;
    protected TextView bIK;
    private ShareFromGameCenterMsgData bIL;
    private EditText bdH;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.bdH;
    }

    public b(Context context) {
        super(context);
        at(context);
    }

    private void at(Context context) {
        LayoutInflater.from(context).inflate(i.g.game_to_group_share_dialog, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(i.f.game_to_group_share_dialog_content);
        this.bIJ = (TextView) findViewById(i.f.share_title_view);
        this.bdH = (EditText) findViewById(i.f.game_to_group_share_chat_msg);
        this.bIH = (TbImageView) findViewById(i.f.game_to_group_share_img);
        this.bII = (BarImageView) findViewById(i.f.game_to_group_share_icon);
        this.aCJ = (TextView) findViewById(i.f.game_to_group_share_desc);
        an.b(this.bIJ, i.c.cp_cont_b, 1);
        an.b(this.bdH, i.c.cp_cont_b, 2);
        this.bdH.setHintTextColor(an.getColor(i.c.cp_cont_e));
        an.b(this.aCJ, i.c.cp_cont_f, 1);
        this.bdH.setPadding(context.getResources().getDimensionPixelSize(i.d.ds20), 0, 0, 0);
        this.bIK = (TextView) findViewById(i.f.game_to_group_share);
        an.b(this.bIK, i.c.cp_cont_c, 1);
        NZ();
    }

    public void NZ() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bdH != null) {
            return j.a(this.bdH.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.bIL = shareFromGameCenterMsgData;
        vt();
    }

    private void vt() {
        this.bIJ.setText(this.bIL.getTitle());
        this.bIH.setTag(this.bIL.getImageUrl());
        this.bIH.d(this.bIL.getImageUrl(), 17, false);
        this.bII.setTag(this.bIL.getShareSourceIcon());
        this.bII.d(this.bIL.getShareSourceIcon(), 17, false);
        this.aCJ.setText(this.bIL.getContent());
        this.bIK.setText("来自" + this.bIL.getShareSource());
    }
}
