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
    private LinearLayout bCE;
    private TextView bMB;
    private EditText dZb;
    private BarImageView eOl;
    private TextView eOm;
    protected TextView eOn;
    private ShareFromGameCenterMsgData eOo;
    private TbImageView ete;

    public EditText getChatMsgView() {
        return this.dZb;
    }

    public b(Context context) {
        super(context);
        bA(context);
    }

    private void bA(Context context) {
        LayoutInflater.from(context).inflate(d.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.bCE = (LinearLayout) findViewById(d.g.game_to_group_share_dialog_content);
        this.eOm = (TextView) findViewById(d.g.share_title_view);
        this.dZb = (EditText) findViewById(d.g.game_to_group_share_chat_msg);
        this.ete = (TbImageView) findViewById(d.g.game_to_group_share_img);
        this.eOl = (BarImageView) findViewById(d.g.game_to_group_share_icon);
        this.bMB = (TextView) findViewById(d.g.game_to_group_share_desc);
        aj.e(this.eOm, d.C0140d.cp_cont_b, 1);
        aj.e(this.dZb, d.C0140d.cp_cont_b, 2);
        this.dZb.setHintTextColor(aj.getColor(d.C0140d.cp_cont_e));
        aj.e(this.bMB, d.C0140d.cp_cont_f, 1);
        this.dZb.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        this.eOn = (TextView) findViewById(d.g.game_to_group_share);
        aj.e(this.eOn, d.C0140d.cp_cont_c, 1);
        aAU();
    }

    public void aAU() {
        this.bCE.setFocusable(true);
        this.bCE.setFocusableInTouchMode(true);
        this.bCE.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dZb != null) {
            return k.a(this.dZb.getText(), null);
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
        this.eOo = shareFromGameCenterMsgData;
        Ea();
    }

    private void Ea() {
        this.eOm.setText(this.eOo.getTitle());
        this.ete.setTag(this.eOo.getImageUrl());
        this.ete.startLoad(this.eOo.getImageUrl(), 17, false);
        this.eOl.setVisibility(0);
        this.eOl.setTag(this.eOo.getShareSourceIcon());
        this.eOl.startLoad(this.eOo.getShareSourceIcon(), 17, false);
        this.bMB.setText(this.eOo.getContent());
        this.eOn.setText("来自" + this.eOo.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.eOm.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.ete.setTag(shareFromPBMsgData.getImageUrl());
        this.ete.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.eOl.setVisibility(8);
        this.bMB.setText(shareFromPBMsgData.getContent());
    }
}
