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
    private LinearLayout aKW;
    private TextView aSZ;
    private EditText cJV;
    private BarImageView dFh;
    private TextView dFi;
    protected TextView dFj;
    private ShareFromGameCenterMsgData dFk;
    private TbImageView djQ;

    public EditText getChatMsgView() {
        return this.cJV;
    }

    public b(Context context) {
        super(context);
        br(context);
    }

    private void br(Context context) {
        LayoutInflater.from(context).inflate(d.j.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aKW = (LinearLayout) findViewById(d.h.game_to_group_share_dialog_content);
        this.dFi = (TextView) findViewById(d.h.share_title_view);
        this.cJV = (EditText) findViewById(d.h.game_to_group_share_chat_msg);
        this.djQ = (TbImageView) findViewById(d.h.game_to_group_share_img);
        this.dFh = (BarImageView) findViewById(d.h.game_to_group_share_icon);
        this.aSZ = (TextView) findViewById(d.h.game_to_group_share_desc);
        aj.c(this.dFi, d.e.cp_cont_b, 1);
        aj.c(this.cJV, d.e.cp_cont_b, 2);
        this.cJV.setHintTextColor(aj.getColor(d.e.cp_cont_e));
        aj.c(this.aSZ, d.e.cp_cont_f, 1);
        this.cJV.setPadding(context.getResources().getDimensionPixelSize(d.f.ds20), 0, 0, 0);
        this.dFj = (TextView) findViewById(d.h.game_to_group_share);
        aj.c(this.dFj, d.e.cp_cont_c, 1);
        ami();
    }

    public void ami() {
        this.aKW.setFocusable(true);
        this.aKW.setFocusableInTouchMode(true);
        this.aKW.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cJV != null) {
            return k.a(this.cJV.getText(), null);
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
        this.dFk = shareFromGameCenterMsgData;
        wg();
    }

    private void wg() {
        this.dFi.setText(this.dFk.getTitle());
        this.djQ.setTag(this.dFk.getImageUrl());
        this.djQ.c(this.dFk.getImageUrl(), 17, false);
        this.dFh.setVisibility(0);
        this.dFh.setTag(this.dFk.getShareSourceIcon());
        this.dFh.c(this.dFk.getShareSourceIcon(), 17, false);
        this.aSZ.setText(this.dFk.getContent());
        this.dFj.setText("来自" + this.dFk.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dFi.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.djQ.setTag(shareFromPBMsgData.getImageUrl());
        this.djQ.c(shareFromPBMsgData.getImageUrl(), 17, false);
        this.dFh.setVisibility(8);
        this.aSZ.setText(shareFromPBMsgData.getContent());
    }
}
