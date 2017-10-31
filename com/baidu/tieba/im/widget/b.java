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
    private LinearLayout aLG;
    private TextView aTd;
    private EditText cTh;
    private BarImageView dMV;
    private TextView dMW;
    protected TextView dMX;
    private ShareFromGameCenterMsgData dMY;
    private TbImageView drG;

    public EditText getChatMsgView() {
        return this.cTh;
    }

    public b(Context context) {
        super(context);
        br(context);
    }

    private void br(Context context) {
        LayoutInflater.from(context).inflate(d.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aLG = (LinearLayout) findViewById(d.g.game_to_group_share_dialog_content);
        this.dMW = (TextView) findViewById(d.g.share_title_view);
        this.cTh = (EditText) findViewById(d.g.game_to_group_share_chat_msg);
        this.drG = (TbImageView) findViewById(d.g.game_to_group_share_img);
        this.dMV = (BarImageView) findViewById(d.g.game_to_group_share_icon);
        this.aTd = (TextView) findViewById(d.g.game_to_group_share_desc);
        aj.c(this.dMW, d.C0080d.cp_cont_b, 1);
        aj.c(this.cTh, d.C0080d.cp_cont_b, 2);
        this.cTh.setHintTextColor(aj.getColor(d.C0080d.cp_cont_e));
        aj.c(this.aTd, d.C0080d.cp_cont_f, 1);
        this.cTh.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        this.dMX = (TextView) findViewById(d.g.game_to_group_share);
        aj.c(this.dMX, d.C0080d.cp_cont_c, 1);
        aoT();
    }

    public void aoT() {
        this.aLG.setFocusable(true);
        this.aLG.setFocusableInTouchMode(true);
        this.aLG.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cTh != null) {
            return k.a(this.cTh.getText(), null);
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
        this.dMY = shareFromGameCenterMsgData;
        wn();
    }

    private void wn() {
        this.dMW.setText(this.dMY.getTitle());
        this.drG.setTag(this.dMY.getImageUrl());
        this.drG.startLoad(this.dMY.getImageUrl(), 17, false);
        this.dMV.setVisibility(0);
        this.dMV.setTag(this.dMY.getShareSourceIcon());
        this.dMV.startLoad(this.dMY.getShareSourceIcon(), 17, false);
        this.aTd.setText(this.dMY.getContent());
        this.dMX.setText("来自" + this.dMY.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dMW.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.drG.setTag(shareFromPBMsgData.getImageUrl());
        this.drG.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.dMV.setVisibility(8);
        this.aTd.setText(shareFromPBMsgData.getContent());
    }
}
