package com.baidu.tieba.im.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private LinearLayout aCL;
    private TextView aIK;
    private EditText bYj;
    private TbImageView cKs;
    private BarImageView dfs;
    private TextView dft;
    protected TextView dfu;
    private ShareFromGameCenterMsgData dfv;

    public EditText getChatMsgView() {
        return this.bYj;
    }

    public b(Context context) {
        super(context);
        aT(context);
    }

    private void aT(Context context) {
        LayoutInflater.from(context).inflate(r.j.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aCL = (LinearLayout) findViewById(r.h.game_to_group_share_dialog_content);
        this.dft = (TextView) findViewById(r.h.share_title_view);
        this.bYj = (EditText) findViewById(r.h.game_to_group_share_chat_msg);
        this.cKs = (TbImageView) findViewById(r.h.game_to_group_share_img);
        this.dfs = (BarImageView) findViewById(r.h.game_to_group_share_icon);
        this.aIK = (TextView) findViewById(r.h.game_to_group_share_desc);
        ap.c(this.dft, r.e.cp_cont_b, 1);
        ap.c(this.bYj, r.e.cp_cont_b, 2);
        this.bYj.setHintTextColor(ap.getColor(r.e.cp_cont_e));
        ap.c(this.aIK, r.e.cp_cont_f, 1);
        this.bYj.setPadding(context.getResources().getDimensionPixelSize(r.f.ds20), 0, 0, 0);
        this.dfu = (TextView) findViewById(r.h.game_to_group_share);
        ap.c(this.dfu, r.e.cp_cont_c, 1);
        adF();
    }

    public void adF() {
        this.aCL.setFocusable(true);
        this.aCL.setFocusableInTouchMode(true);
        this.aCL.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bYj != null) {
            return j.a(this.bYj.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.dfv = shareFromGameCenterMsgData;
        wb();
    }

    private void wb() {
        this.dft.setText(this.dfv.getTitle());
        this.cKs.setTag(this.dfv.getImageUrl());
        this.cKs.c(this.dfv.getImageUrl(), 17, false);
        this.dfs.setTag(this.dfv.getShareSourceIcon());
        this.dfs.c(this.dfv.getShareSourceIcon(), 17, false);
        this.aIK.setText(this.dfv.getContent());
        this.dfu.setText("来自" + this.dfv.getShareSource());
    }
}
