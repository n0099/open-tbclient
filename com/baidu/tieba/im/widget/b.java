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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private LinearLayout aBh;
    private TextView aHe;
    private EditText bWf;
    private TbImageView cFV;
    private BarImageView dav;
    private TextView daw;
    protected TextView dax;
    private ShareFromGameCenterMsgData daz;

    public EditText getChatMsgView() {
        return this.bWf;
    }

    public b(Context context) {
        super(context);
        ar(context);
    }

    private void ar(Context context) {
        LayoutInflater.from(context).inflate(u.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aBh = (LinearLayout) findViewById(u.g.game_to_group_share_dialog_content);
        this.daw = (TextView) findViewById(u.g.share_title_view);
        this.bWf = (EditText) findViewById(u.g.game_to_group_share_chat_msg);
        this.cFV = (TbImageView) findViewById(u.g.game_to_group_share_img);
        this.dav = (BarImageView) findViewById(u.g.game_to_group_share_icon);
        this.aHe = (TextView) findViewById(u.g.game_to_group_share_desc);
        av.c(this.daw, u.d.cp_cont_b, 1);
        av.c(this.bWf, u.d.cp_cont_b, 2);
        this.bWf.setHintTextColor(av.getColor(u.d.cp_cont_e));
        av.c(this.aHe, u.d.cp_cont_f, 1);
        this.bWf.setPadding(context.getResources().getDimensionPixelSize(u.e.ds20), 0, 0, 0);
        this.dax = (TextView) findViewById(u.g.game_to_group_share);
        av.c(this.dax, u.d.cp_cont_c, 1);
        abd();
    }

    public void abd() {
        this.aBh.setFocusable(true);
        this.aBh.setFocusableInTouchMode(true);
        this.aBh.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bWf != null) {
            return j.a(this.bWf.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.daz = shareFromGameCenterMsgData;
        uY();
    }

    private void uY() {
        this.daw.setText(this.daz.getTitle());
        this.cFV.setTag(this.daz.getImageUrl());
        this.cFV.c(this.daz.getImageUrl(), 17, false);
        this.dav.setTag(this.daz.getShareSourceIcon());
        this.dav.c(this.daz.getShareSourceIcon(), 17, false);
        this.aHe.setText(this.daz.getContent());
        this.dax.setText("来自" + this.daz.getShareSource());
    }
}
