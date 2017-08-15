package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private LinearLayout aMd;
    private TextView aSF;
    private EditText cCh;
    private BarImageView dBI;
    private TextView dBJ;
    protected TextView dBK;
    private ShareFromGameCenterMsgData dBL;
    private TbImageView dgo;

    public EditText getChatMsgView() {
        return this.cCh;
    }

    public b(Context context) {
        super(context);
        bk(context);
    }

    private void bk(Context context) {
        LayoutInflater.from(context).inflate(d.j.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aMd = (LinearLayout) findViewById(d.h.game_to_group_share_dialog_content);
        this.dBJ = (TextView) findViewById(d.h.share_title_view);
        this.cCh = (EditText) findViewById(d.h.game_to_group_share_chat_msg);
        this.dgo = (TbImageView) findViewById(d.h.game_to_group_share_img);
        this.dBI = (BarImageView) findViewById(d.h.game_to_group_share_icon);
        this.aSF = (TextView) findViewById(d.h.game_to_group_share_desc);
        ai.c(this.dBJ, d.e.cp_cont_b, 1);
        ai.c(this.cCh, d.e.cp_cont_b, 2);
        this.cCh.setHintTextColor(ai.getColor(d.e.cp_cont_e));
        ai.c(this.aSF, d.e.cp_cont_f, 1);
        this.cCh.setPadding(context.getResources().getDimensionPixelSize(d.f.ds20), 0, 0, 0);
        this.dBK = (TextView) findViewById(d.h.game_to_group_share);
        ai.c(this.dBK, d.e.cp_cont_c, 1);
        akw();
    }

    public void akw() {
        this.aMd.setFocusable(true);
        this.aMd.setFocusableInTouchMode(true);
        this.aMd.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cCh != null) {
            return j.a(this.cCh.getText(), null);
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
        this.dBL = shareFromGameCenterMsgData;
        wP();
    }

    private void wP() {
        this.dBJ.setText(this.dBL.getTitle());
        this.dgo.setTag(this.dBL.getImageUrl());
        this.dgo.c(this.dBL.getImageUrl(), 17, false);
        this.dBI.setVisibility(0);
        this.dBI.setTag(this.dBL.getShareSourceIcon());
        this.dBI.c(this.dBL.getShareSourceIcon(), 17, false);
        this.aSF.setText(this.dBL.getContent());
        this.dBK.setText("来自" + this.dBL.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dBJ.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.dgo.setTag(shareFromPBMsgData.getImageUrl());
        this.dgo.c(shareFromPBMsgData.getImageUrl(), 17, false);
        this.dBI.setVisibility(8);
        this.aSF.setText(shareFromPBMsgData.getContent());
    }
}
