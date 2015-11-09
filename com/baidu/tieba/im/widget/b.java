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
    private TextView aBD;
    private TbImageView bJc;
    private BarImageView bJd;
    private TextView bJe;
    protected TextView bJf;
    private ShareFromGameCenterMsgData bJg;
    private EditText bem;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.bem;
    }

    public b(Context context) {
        super(context);
        as(context);
    }

    private void as(Context context) {
        LayoutInflater.from(context).inflate(i.g.game_to_group_share_dialog, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(i.f.game_to_group_share_dialog_content);
        this.bJe = (TextView) findViewById(i.f.share_title_view);
        this.bem = (EditText) findViewById(i.f.game_to_group_share_chat_msg);
        this.bJc = (TbImageView) findViewById(i.f.game_to_group_share_img);
        this.bJd = (BarImageView) findViewById(i.f.game_to_group_share_icon);
        this.aBD = (TextView) findViewById(i.f.game_to_group_share_desc);
        an.b(this.bJe, i.c.cp_cont_b, 1);
        an.b(this.bem, i.c.cp_cont_b, 2);
        this.bem.setHintTextColor(an.getColor(i.c.cp_cont_e));
        an.b(this.aBD, i.c.cp_cont_f, 1);
        this.bem.setPadding(context.getResources().getDimensionPixelSize(i.d.ds20), 0, 0, 0);
        this.bJf = (TextView) findViewById(i.f.game_to_group_share);
        an.b(this.bJf, i.c.cp_cont_c, 1);
        Ov();
    }

    public void Ov() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bem != null) {
            return j.a(this.bem.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.bJg = shareFromGameCenterMsgData;
        vx();
    }

    private void vx() {
        this.bJe.setText(this.bJg.getTitle());
        this.bJc.setTag(this.bJg.getImageUrl());
        this.bJc.d(this.bJg.getImageUrl(), 17, false);
        this.bJd.setTag(this.bJg.getShareSourceIcon());
        this.bJd.d(this.bJg.getShareSourceIcon(), 17, false);
        this.aBD.setText(this.bJg.getContent());
        this.bJf.setText("来自" + this.bJg.getShareSource());
    }
}
