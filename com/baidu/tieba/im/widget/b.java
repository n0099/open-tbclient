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
    private LinearLayout aLK;
    private TextView aSq;
    private EditText cIx;
    private BarImageView dIl;
    private TextView dIm;
    protected TextView dIn;
    private ShareFromGameCenterMsgData dIo;
    private TbImageView dmS;

    public EditText getChatMsgView() {
        return this.cIx;
    }

    public b(Context context) {
        super(context);
        bs(context);
    }

    private void bs(Context context) {
        LayoutInflater.from(context).inflate(d.j.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aLK = (LinearLayout) findViewById(d.h.game_to_group_share_dialog_content);
        this.dIm = (TextView) findViewById(d.h.share_title_view);
        this.cIx = (EditText) findViewById(d.h.game_to_group_share_chat_msg);
        this.dmS = (TbImageView) findViewById(d.h.game_to_group_share_img);
        this.dIl = (BarImageView) findViewById(d.h.game_to_group_share_icon);
        this.aSq = (TextView) findViewById(d.h.game_to_group_share_desc);
        aj.c(this.dIm, d.e.cp_cont_b, 1);
        aj.c(this.cIx, d.e.cp_cont_b, 2);
        this.cIx.setHintTextColor(aj.getColor(d.e.cp_cont_e));
        aj.c(this.aSq, d.e.cp_cont_f, 1);
        this.cIx.setPadding(context.getResources().getDimensionPixelSize(d.f.ds20), 0, 0, 0);
        this.dIn = (TextView) findViewById(d.h.game_to_group_share);
        aj.c(this.dIn, d.e.cp_cont_c, 1);
        alY();
    }

    public void alY() {
        this.aLK.setFocusable(true);
        this.aLK.setFocusableInTouchMode(true);
        this.aLK.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cIx != null) {
            return j.a(this.cIx.getText(), null);
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
        this.dIo = shareFromGameCenterMsgData;
        wO();
    }

    private void wO() {
        this.dIm.setText(this.dIo.getTitle());
        this.dmS.setTag(this.dIo.getImageUrl());
        this.dmS.c(this.dIo.getImageUrl(), 17, false);
        this.dIl.setVisibility(0);
        this.dIl.setTag(this.dIo.getShareSourceIcon());
        this.dIl.c(this.dIo.getShareSourceIcon(), 17, false);
        this.aSq.setText(this.dIo.getContent());
        this.dIn.setText("来自" + this.dIo.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dIm.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.dmS.setTag(shareFromPBMsgData.getImageUrl());
        this.dmS.c(shareFromPBMsgData.getImageUrl(), 17, false);
        this.dIl.setVisibility(8);
        this.aSq.setText(shareFromPBMsgData.getContent());
    }
}
