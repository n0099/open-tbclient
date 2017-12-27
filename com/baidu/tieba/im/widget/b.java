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
    private LinearLayout bAj;
    private TextView bKh;
    private EditText dQe;
    private BarImageView eIb;
    private TextView eIc;
    protected TextView eId;
    private ShareFromGameCenterMsgData eIe;
    private TbImageView emX;

    public EditText getChatMsgView() {
        return this.dQe;
    }

    public b(Context context) {
        super(context);
        bE(context);
    }

    private void bE(Context context) {
        LayoutInflater.from(context).inflate(d.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.bAj = (LinearLayout) findViewById(d.g.game_to_group_share_dialog_content);
        this.eIc = (TextView) findViewById(d.g.share_title_view);
        this.dQe = (EditText) findViewById(d.g.game_to_group_share_chat_msg);
        this.emX = (TbImageView) findViewById(d.g.game_to_group_share_img);
        this.eIb = (BarImageView) findViewById(d.g.game_to_group_share_icon);
        this.bKh = (TextView) findViewById(d.g.game_to_group_share_desc);
        aj.e(this.eIc, d.C0108d.cp_cont_b, 1);
        aj.e(this.dQe, d.C0108d.cp_cont_b, 2);
        this.dQe.setHintTextColor(aj.getColor(d.C0108d.cp_cont_e));
        aj.e(this.bKh, d.C0108d.cp_cont_f, 1);
        this.dQe.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        this.eId = (TextView) findViewById(d.g.game_to_group_share);
        aj.e(this.eId, d.C0108d.cp_cont_c, 1);
        ayt();
    }

    public void ayt() {
        this.bAj.setFocusable(true);
        this.bAj.setFocusableInTouchMode(true);
        this.bAj.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dQe != null) {
            return k.a(this.dQe.getText(), null);
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
        this.eIe = shareFromGameCenterMsgData;
        DN();
    }

    private void DN() {
        this.eIc.setText(this.eIe.getTitle());
        this.emX.setTag(this.eIe.getImageUrl());
        this.emX.startLoad(this.eIe.getImageUrl(), 17, false);
        this.eIb.setVisibility(0);
        this.eIb.setTag(this.eIe.getShareSourceIcon());
        this.eIb.startLoad(this.eIe.getShareSourceIcon(), 17, false);
        this.bKh.setText(this.eIe.getContent());
        this.eId.setText("来自" + this.eIe.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.eIc.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.emX.setTag(shareFromPBMsgData.getImageUrl());
        this.emX.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.eIb.setVisibility(8);
        this.bKh.setText(shareFromPBMsgData.getContent());
    }
}
