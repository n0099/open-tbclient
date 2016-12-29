package com.baidu.tieba.im.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private LinearLayout aDV;
    private TextView aKd;
    private TbImageView bDA;
    private EditText bDz;
    private BarImageView cYd;
    private TextView cYe;
    protected TextView cYf;
    private ShareFromGameCenterMsgData cYg;

    public EditText getChatMsgView() {
        return this.bDz;
    }

    public b(Context context) {
        super(context);
        aN(context);
    }

    private void aN(Context context) {
        LayoutInflater.from(context).inflate(r.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aDV = (LinearLayout) findViewById(r.g.game_to_group_share_dialog_content);
        this.cYe = (TextView) findViewById(r.g.share_title_view);
        this.bDz = (EditText) findViewById(r.g.game_to_group_share_chat_msg);
        this.bDA = (TbImageView) findViewById(r.g.game_to_group_share_img);
        this.cYd = (BarImageView) findViewById(r.g.game_to_group_share_icon);
        this.aKd = (TextView) findViewById(r.g.game_to_group_share_desc);
        ar.c(this.cYe, r.d.cp_cont_b, 1);
        ar.c(this.bDz, r.d.cp_cont_b, 2);
        this.bDz.setHintTextColor(ar.getColor(r.d.cp_cont_e));
        ar.c(this.aKd, r.d.cp_cont_f, 1);
        this.bDz.setPadding(context.getResources().getDimensionPixelSize(r.e.ds20), 0, 0, 0);
        this.cYf = (TextView) findViewById(r.g.game_to_group_share);
        ar.c(this.cYf, r.d.cp_cont_c, 1);
        Yp();
    }

    public void Yp() {
        this.aDV.setFocusable(true);
        this.aDV.setFocusableInTouchMode(true);
        this.aDV.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bDz != null) {
            return j.a(this.bDz.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.cYg = shareFromGameCenterMsgData;
        wg();
    }

    private void wg() {
        this.cYe.setText(this.cYg.getTitle());
        this.bDA.setTag(this.cYg.getImageUrl());
        this.bDA.c(this.cYg.getImageUrl(), 17, false);
        this.cYd.setTag(this.cYg.getShareSourceIcon());
        this.cYd.c(this.cYg.getShareSourceIcon(), 17, false);
        this.aKd.setText(this.cYg.getContent());
        this.cYf.setText("来自" + this.cYg.getShareSource());
    }
}
