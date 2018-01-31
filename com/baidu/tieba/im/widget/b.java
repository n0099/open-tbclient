package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private LinearLayout bAA;
    private TextView bKx;
    private EditText dVn;
    private BarImageView eJW;
    private TextView eJX;
    protected TextView eJY;
    private ShareFromGameCenterMsgData eJZ;
    private TbImageView eoR;

    public EditText getChatMsgView() {
        return this.dVn;
    }

    public b(Context context) {
        super(context);
        bB(context);
    }

    private void bB(Context context) {
        LayoutInflater.from(context).inflate(d.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.bAA = (LinearLayout) findViewById(d.g.game_to_group_share_dialog_content);
        this.eJX = (TextView) findViewById(d.g.share_title_view);
        this.dVn = (EditText) findViewById(d.g.game_to_group_share_chat_msg);
        this.eoR = (TbImageView) findViewById(d.g.game_to_group_share_img);
        this.eJW = (BarImageView) findViewById(d.g.game_to_group_share_icon);
        this.bKx = (TextView) findViewById(d.g.game_to_group_share_desc);
        aj.e(this.eJX, d.C0108d.cp_cont_b, 1);
        aj.e(this.dVn, d.C0108d.cp_cont_b, 2);
        this.dVn.setHintTextColor(aj.getColor(d.C0108d.cp_cont_e));
        aj.e(this.bKx, d.C0108d.cp_cont_f, 1);
        this.dVn.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        this.eJY = (TextView) findViewById(d.g.game_to_group_share);
        aj.e(this.eJY, d.C0108d.cp_cont_c, 1);
        azD();
    }

    public void azD() {
        this.bAA.setFocusable(true);
        this.bAA.setFocusableInTouchMode(true);
        this.bAA.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dVn != null) {
            return k.a(this.dVn.getText(), null);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.eJZ = shareFromGameCenterMsgData;
        DG();
    }

    private void DG() {
        this.eJX.setText(this.eJZ.getTitle());
        this.eoR.setTag(this.eJZ.getImageUrl());
        this.eoR.startLoad(this.eJZ.getImageUrl(), 17, false);
        this.eJW.setVisibility(0);
        this.eJW.setTag(this.eJZ.getShareSourceIcon());
        this.eJW.startLoad(this.eJZ.getShareSourceIcon(), 17, false);
        this.bKx.setText(this.eJZ.getContent());
        this.eJY.setText("来自" + this.eJZ.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.eJX.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.eoR.setTag(shareFromPBMsgData.getImageUrl());
        this.eoR.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.eJW.setVisibility(8);
        this.bKx.setText(shareFromPBMsgData.getContent());
    }
}
