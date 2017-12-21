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
    private LinearLayout aMw;
    private TextView aWs;
    private TbImageView dAV;
    private BarImageView dVX;
    private TextView dVY;
    protected TextView dVZ;
    private ShareFromGameCenterMsgData dWa;
    private EditText ddU;

    public EditText getChatMsgView() {
        return this.ddU;
    }

    public b(Context context) {
        super(context);
        bt(context);
    }

    private void bt(Context context) {
        LayoutInflater.from(context).inflate(d.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aMw = (LinearLayout) findViewById(d.g.game_to_group_share_dialog_content);
        this.dVY = (TextView) findViewById(d.g.share_title_view);
        this.ddU = (EditText) findViewById(d.g.game_to_group_share_chat_msg);
        this.dAV = (TbImageView) findViewById(d.g.game_to_group_share_img);
        this.dVX = (BarImageView) findViewById(d.g.game_to_group_share_icon);
        this.aWs = (TextView) findViewById(d.g.game_to_group_share_desc);
        aj.c(this.dVY, d.C0095d.cp_cont_b, 1);
        aj.c(this.ddU, d.C0095d.cp_cont_b, 2);
        this.ddU.setHintTextColor(aj.getColor(d.C0095d.cp_cont_e));
        aj.c(this.aWs, d.C0095d.cp_cont_f, 1);
        this.ddU.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        this.dVZ = (TextView) findViewById(d.g.game_to_group_share);
        aj.c(this.dVZ, d.C0095d.cp_cont_c, 1);
        arn();
    }

    public void arn() {
        this.aMw.setFocusable(true);
        this.aMw.setFocusableInTouchMode(true);
        this.aMw.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.ddU != null) {
            return k.a(this.ddU.getText(), null);
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
        this.dWa = shareFromGameCenterMsgData;
        wp();
    }

    private void wp() {
        this.dVY.setText(this.dWa.getTitle());
        this.dAV.setTag(this.dWa.getImageUrl());
        this.dAV.startLoad(this.dWa.getImageUrl(), 17, false);
        this.dVX.setVisibility(0);
        this.dVX.setTag(this.dWa.getShareSourceIcon());
        this.dVX.startLoad(this.dWa.getShareSourceIcon(), 17, false);
        this.aWs.setText(this.dWa.getContent());
        this.dVZ.setText("来自" + this.dWa.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dVY.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.dAV.setTag(shareFromPBMsgData.getImageUrl());
        this.dAV.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.dVX.setVisibility(8);
        this.aWs.setText(shareFromPBMsgData.getContent());
    }
}
