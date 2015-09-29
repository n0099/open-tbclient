package com.baidu.tieba.im.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private TextView aCy;
    private ShareFromGameCenterMsgData bIA;
    private TbImageView bIw;
    private BarImageView bIx;
    private TextView bIy;
    protected TextView bIz;
    private EditText bdw;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.bdw;
    }

    public b(Context context) {
        super(context);
        at(context);
    }

    private void at(Context context) {
        LayoutInflater.from(context).inflate(i.g.game_to_group_share_dialog, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(i.f.game_to_group_share_dialog_content);
        this.bIy = (TextView) findViewById(i.f.share_title_view);
        this.bdw = (EditText) findViewById(i.f.game_to_group_share_chat_msg);
        this.bIw = (TbImageView) findViewById(i.f.game_to_group_share_img);
        this.bIx = (BarImageView) findViewById(i.f.game_to_group_share_icon);
        this.aCy = (TextView) findViewById(i.f.game_to_group_share_desc);
        am.b(this.bIy, i.c.cp_cont_b, 1);
        am.b(this.bdw, i.c.cp_cont_b, 2);
        this.bdw.setHintTextColor(am.getColor(i.c.cp_cont_e));
        am.b(this.aCy, i.c.cp_cont_f, 1);
        this.bdw.setPadding(context.getResources().getDimensionPixelSize(i.d.ds20), 0, 0, 0);
        this.bIz = (TextView) findViewById(i.f.game_to_group_share);
        am.b(this.bIz, i.c.cp_cont_c, 1);
        Od();
    }

    public void Od() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bdw != null) {
            return j.a(this.bdw.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.bIA = shareFromGameCenterMsgData;
        vw();
    }

    private void vw() {
        this.bIy.setText(this.bIA.getTitle());
        this.bIw.setTag(this.bIA.getImageUrl());
        this.bIw.d(this.bIA.getImageUrl(), 17, false);
        this.bIx.setTag(this.bIA.getShareSourceIcon());
        this.bIx.d(this.bIA.getShareSourceIcon(), 17, false);
        this.aCy.setText(this.bIA.getContent());
        this.bIz.setText("来自" + this.bIA.getShareSource());
    }
}
