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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private LinearLayout aCx;
    private TextView aGI;
    private TbImageView bNv;
    private EditText brF;
    private BarImageView cgI;
    private TextView cgJ;
    protected TextView cgK;
    private ShareFromGameCenterMsgData cgL;

    public EditText getChatMsgView() {
        return this.brF;
    }

    public b(Context context) {
        super(context);
        at(context);
    }

    private void at(Context context) {
        LayoutInflater.from(context).inflate(t.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aCx = (LinearLayout) findViewById(t.g.game_to_group_share_dialog_content);
        this.cgJ = (TextView) findViewById(t.g.share_title_view);
        this.brF = (EditText) findViewById(t.g.game_to_group_share_chat_msg);
        this.bNv = (TbImageView) findViewById(t.g.game_to_group_share_img);
        this.cgI = (BarImageView) findViewById(t.g.game_to_group_share_icon);
        this.aGI = (TextView) findViewById(t.g.game_to_group_share_desc);
        ar.b(this.cgJ, t.d.cp_cont_b, 1);
        ar.b(this.brF, t.d.cp_cont_b, 2);
        this.brF.setHintTextColor(ar.getColor(t.d.cp_cont_e));
        ar.b(this.aGI, t.d.cp_cont_f, 1);
        this.brF.setPadding(context.getResources().getDimensionPixelSize(t.e.ds20), 0, 0, 0);
        this.cgK = (TextView) findViewById(t.g.game_to_group_share);
        ar.b(this.cgK, t.d.cp_cont_c, 1);
        Sx();
    }

    public void Sx() {
        this.aCx.setFocusable(true);
        this.aCx.setFocusableInTouchMode(true);
        this.aCx.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.brF != null) {
            return j.a(this.brF.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.cgL = shareFromGameCenterMsgData;
        wV();
    }

    private void wV() {
        this.cgJ.setText(this.cgL.getTitle());
        this.bNv.setTag(this.cgL.getImageUrl());
        this.bNv.d(this.cgL.getImageUrl(), 17, false);
        this.cgI.setTag(this.cgL.getShareSourceIcon());
        this.cgI.d(this.cgL.getShareSourceIcon(), 17, false);
        this.aGI.setText(this.cgL.getContent());
        this.cgK.setText("来自" + this.cgL.getShareSource());
    }
}
