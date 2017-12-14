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
    private LinearLayout aMt;
    private TextView aWo;
    private TbImageView dAR;
    private BarImageView dVT;
    private TextView dVU;
    protected TextView dVV;
    private ShareFromGameCenterMsgData dVW;
    private EditText ddQ;

    public EditText getChatMsgView() {
        return this.ddQ;
    }

    public b(Context context) {
        super(context);
        bt(context);
    }

    private void bt(Context context) {
        LayoutInflater.from(context).inflate(d.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aMt = (LinearLayout) findViewById(d.g.game_to_group_share_dialog_content);
        this.dVU = (TextView) findViewById(d.g.share_title_view);
        this.ddQ = (EditText) findViewById(d.g.game_to_group_share_chat_msg);
        this.dAR = (TbImageView) findViewById(d.g.game_to_group_share_img);
        this.dVT = (BarImageView) findViewById(d.g.game_to_group_share_icon);
        this.aWo = (TextView) findViewById(d.g.game_to_group_share_desc);
        aj.c(this.dVU, d.C0096d.cp_cont_b, 1);
        aj.c(this.ddQ, d.C0096d.cp_cont_b, 2);
        this.ddQ.setHintTextColor(aj.getColor(d.C0096d.cp_cont_e));
        aj.c(this.aWo, d.C0096d.cp_cont_f, 1);
        this.ddQ.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        this.dVV = (TextView) findViewById(d.g.game_to_group_share);
        aj.c(this.dVV, d.C0096d.cp_cont_c, 1);
        arn();
    }

    public void arn() {
        this.aMt.setFocusable(true);
        this.aMt.setFocusableInTouchMode(true);
        this.aMt.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.ddQ != null) {
            return k.a(this.ddQ.getText(), null);
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
        this.dVW = shareFromGameCenterMsgData;
        wp();
    }

    private void wp() {
        this.dVU.setText(this.dVW.getTitle());
        this.dAR.setTag(this.dVW.getImageUrl());
        this.dAR.startLoad(this.dVW.getImageUrl(), 17, false);
        this.dVT.setVisibility(0);
        this.dVT.setTag(this.dVW.getShareSourceIcon());
        this.dVT.startLoad(this.dVW.getShareSourceIcon(), 17, false);
        this.aWo.setText(this.dVW.getContent());
        this.dVV.setText("来自" + this.dVW.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dVU.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.dAR.setTag(shareFromPBMsgData.getImageUrl());
        this.dAR.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.dVT.setVisibility(8);
        this.aWo.setText(shareFromPBMsgData.getContent());
    }
}
