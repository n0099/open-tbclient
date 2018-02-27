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
    private LinearLayout bCr;
    private TextView bMo;
    private EditText dYP;
    private BarImageView eNZ;
    private TextView eOa;
    protected TextView eOb;
    private ShareFromGameCenterMsgData eOc;
    private TbImageView esR;

    public EditText getChatMsgView() {
        return this.dYP;
    }

    public b(Context context) {
        super(context);
        bA(context);
    }

    private void bA(Context context) {
        LayoutInflater.from(context).inflate(d.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.bCr = (LinearLayout) findViewById(d.g.game_to_group_share_dialog_content);
        this.eOa = (TextView) findViewById(d.g.share_title_view);
        this.dYP = (EditText) findViewById(d.g.game_to_group_share_chat_msg);
        this.esR = (TbImageView) findViewById(d.g.game_to_group_share_img);
        this.eNZ = (BarImageView) findViewById(d.g.game_to_group_share_icon);
        this.bMo = (TextView) findViewById(d.g.game_to_group_share_desc);
        aj.e(this.eOa, d.C0141d.cp_cont_b, 1);
        aj.e(this.dYP, d.C0141d.cp_cont_b, 2);
        this.dYP.setHintTextColor(aj.getColor(d.C0141d.cp_cont_e));
        aj.e(this.bMo, d.C0141d.cp_cont_f, 1);
        this.dYP.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        this.eOb = (TextView) findViewById(d.g.game_to_group_share);
        aj.e(this.eOb, d.C0141d.cp_cont_c, 1);
        aAT();
    }

    public void aAT() {
        this.bCr.setFocusable(true);
        this.bCr.setFocusableInTouchMode(true);
        this.bCr.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dYP != null) {
            return k.a(this.dYP.getText(), null);
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
        this.eOc = shareFromGameCenterMsgData;
        DZ();
    }

    private void DZ() {
        this.eOa.setText(this.eOc.getTitle());
        this.esR.setTag(this.eOc.getImageUrl());
        this.esR.startLoad(this.eOc.getImageUrl(), 17, false);
        this.eNZ.setVisibility(0);
        this.eNZ.setTag(this.eOc.getShareSourceIcon());
        this.eNZ.startLoad(this.eOc.getShareSourceIcon(), 17, false);
        this.bMo.setText(this.eOc.getContent());
        this.eOb.setText("来自" + this.eOc.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.eOa.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.esR.setTag(shareFromPBMsgData.getImageUrl());
        this.esR.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.eNZ.setVisibility(8);
        this.bMo.setText(shareFromPBMsgData.getContent());
    }
}
