package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private LinearLayout aLH;
    private TextView aSn;
    private EditText cJr;
    private BarImageView dJg;
    private TextView dJh;
    protected TextView dJi;
    private ShareFromGameCenterMsgData dJj;
    private TbImageView dnN;

    public EditText getChatMsgView() {
        return this.cJr;
    }

    public b(Context context) {
        super(context);
        bt(context);
    }

    private void bt(Context context) {
        LayoutInflater.from(context).inflate(d.j.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aLH = (LinearLayout) findViewById(d.h.game_to_group_share_dialog_content);
        this.dJh = (TextView) findViewById(d.h.share_title_view);
        this.cJr = (EditText) findViewById(d.h.game_to_group_share_chat_msg);
        this.dnN = (TbImageView) findViewById(d.h.game_to_group_share_img);
        this.dJg = (BarImageView) findViewById(d.h.game_to_group_share_icon);
        this.aSn = (TextView) findViewById(d.h.game_to_group_share_desc);
        aj.c(this.dJh, d.e.cp_cont_b, 1);
        aj.c(this.cJr, d.e.cp_cont_b, 2);
        this.cJr.setHintTextColor(aj.getColor(d.e.cp_cont_e));
        aj.c(this.aSn, d.e.cp_cont_f, 1);
        this.cJr.setPadding(context.getResources().getDimensionPixelSize(d.f.ds20), 0, 0, 0);
        this.dJi = (TextView) findViewById(d.h.game_to_group_share);
        aj.c(this.dJi, d.e.cp_cont_c, 1);
        amj();
    }

    public void amj() {
        this.aLH.setFocusable(true);
        this.aLH.setFocusableInTouchMode(true);
        this.aLH.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cJr != null) {
            return j.a(this.cJr.getText(), null);
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
        this.dJj = shareFromGameCenterMsgData;
        wO();
    }

    private void wO() {
        this.dJh.setText(this.dJj.getTitle());
        this.dnN.setTag(this.dJj.getImageUrl());
        this.dnN.c(this.dJj.getImageUrl(), 17, false);
        this.dJg.setVisibility(0);
        this.dJg.setTag(this.dJj.getShareSourceIcon());
        this.dJg.c(this.dJj.getShareSourceIcon(), 17, false);
        this.aSn.setText(this.dJj.getContent());
        this.dJi.setText("来自" + this.dJj.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dJh.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.dnN.setTag(shareFromPBMsgData.getImageUrl());
        this.dnN.c(shareFromPBMsgData.getImageUrl(), 17, false);
        this.dJg.setVisibility(8);
        this.aSn.setText(shareFromPBMsgData.getContent());
    }
}
