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
    private LinearLayout aLj;
    private TextView aTm;
    private EditText cKh;
    private BarImageView dFv;
    private TextView dFw;
    protected TextView dFx;
    private ShareFromGameCenterMsgData dFy;
    private TbImageView dkd;

    public EditText getChatMsgView() {
        return this.cKh;
    }

    public b(Context context) {
        super(context);
        bs(context);
    }

    private void bs(Context context) {
        LayoutInflater.from(context).inflate(d.j.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aLj = (LinearLayout) findViewById(d.h.game_to_group_share_dialog_content);
        this.dFw = (TextView) findViewById(d.h.share_title_view);
        this.cKh = (EditText) findViewById(d.h.game_to_group_share_chat_msg);
        this.dkd = (TbImageView) findViewById(d.h.game_to_group_share_img);
        this.dFv = (BarImageView) findViewById(d.h.game_to_group_share_icon);
        this.aTm = (TextView) findViewById(d.h.game_to_group_share_desc);
        aj.c(this.dFw, d.e.cp_cont_b, 1);
        aj.c(this.cKh, d.e.cp_cont_b, 2);
        this.cKh.setHintTextColor(aj.getColor(d.e.cp_cont_e));
        aj.c(this.aTm, d.e.cp_cont_f, 1);
        this.cKh.setPadding(context.getResources().getDimensionPixelSize(d.f.ds20), 0, 0, 0);
        this.dFx = (TextView) findViewById(d.h.game_to_group_share);
        aj.c(this.dFx, d.e.cp_cont_c, 1);
        amn();
    }

    public void amn() {
        this.aLj.setFocusable(true);
        this.aLj.setFocusableInTouchMode(true);
        this.aLj.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cKh != null) {
            return k.a(this.cKh.getText(), null);
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
        this.dFy = shareFromGameCenterMsgData;
        wn();
    }

    private void wn() {
        this.dFw.setText(this.dFy.getTitle());
        this.dkd.setTag(this.dFy.getImageUrl());
        this.dkd.c(this.dFy.getImageUrl(), 17, false);
        this.dFv.setVisibility(0);
        this.dFv.setTag(this.dFy.getShareSourceIcon());
        this.dFv.c(this.dFy.getShareSourceIcon(), 17, false);
        this.aTm.setText(this.dFy.getContent());
        this.dFx.setText("来自" + this.dFy.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dFw.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.dkd.setTag(shareFromPBMsgData.getImageUrl());
        this.dkd.c(shareFromPBMsgData.getImageUrl(), 17, false);
        this.dFv.setVisibility(8);
        this.aTm.setText(shareFromPBMsgData.getContent());
    }
}
