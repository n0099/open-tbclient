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
    private LinearLayout aLO;
    private TextView aTl;
    private EditText cTB;
    private BarImageView dNa;
    private TextView dNb;
    protected TextView dNc;
    private ShareFromGameCenterMsgData dNd;
    private TbImageView dsa;

    public EditText getChatMsgView() {
        return this.cTB;
    }

    public b(Context context) {
        super(context);
        br(context);
    }

    private void br(Context context) {
        LayoutInflater.from(context).inflate(d.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aLO = (LinearLayout) findViewById(d.g.game_to_group_share_dialog_content);
        this.dNb = (TextView) findViewById(d.g.share_title_view);
        this.cTB = (EditText) findViewById(d.g.game_to_group_share_chat_msg);
        this.dsa = (TbImageView) findViewById(d.g.game_to_group_share_img);
        this.dNa = (BarImageView) findViewById(d.g.game_to_group_share_icon);
        this.aTl = (TextView) findViewById(d.g.game_to_group_share_desc);
        aj.c(this.dNb, d.C0080d.cp_cont_b, 1);
        aj.c(this.cTB, d.C0080d.cp_cont_b, 2);
        this.cTB.setHintTextColor(aj.getColor(d.C0080d.cp_cont_e));
        aj.c(this.aTl, d.C0080d.cp_cont_f, 1);
        this.cTB.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        this.dNc = (TextView) findViewById(d.g.game_to_group_share);
        aj.c(this.dNc, d.C0080d.cp_cont_c, 1);
        apj();
    }

    public void apj() {
        this.aLO.setFocusable(true);
        this.aLO.setFocusableInTouchMode(true);
        this.aLO.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cTB != null) {
            return k.a(this.cTB.getText(), null);
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
        this.dNd = shareFromGameCenterMsgData;
        wn();
    }

    private void wn() {
        this.dNb.setText(this.dNd.getTitle());
        this.dsa.setTag(this.dNd.getImageUrl());
        this.dsa.startLoad(this.dNd.getImageUrl(), 17, false);
        this.dNa.setVisibility(0);
        this.dNa.setTag(this.dNd.getShareSourceIcon());
        this.dNa.startLoad(this.dNd.getShareSourceIcon(), 17, false);
        this.aTl.setText(this.dNd.getContent());
        this.dNc.setText("来自" + this.dNd.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dNb.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.dsa.setTag(shareFromPBMsgData.getImageUrl());
        this.dsa.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.dNa.setVisibility(8);
        this.aTl.setText(shareFromPBMsgData.getContent());
    }
}
