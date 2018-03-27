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
    private LinearLayout bCu;
    private TextView bMr;
    private EditText dZg;
    private BarImageView eOp;
    private TextView eOq;
    protected TextView eOr;
    private ShareFromGameCenterMsgData eOs;
    private TbImageView eti;

    public EditText getChatMsgView() {
        return this.dZg;
    }

    public b(Context context) {
        super(context);
        bA(context);
    }

    private void bA(Context context) {
        LayoutInflater.from(context).inflate(d.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.bCu = (LinearLayout) findViewById(d.g.game_to_group_share_dialog_content);
        this.eOq = (TextView) findViewById(d.g.share_title_view);
        this.dZg = (EditText) findViewById(d.g.game_to_group_share_chat_msg);
        this.eti = (TbImageView) findViewById(d.g.game_to_group_share_img);
        this.eOp = (BarImageView) findViewById(d.g.game_to_group_share_icon);
        this.bMr = (TextView) findViewById(d.g.game_to_group_share_desc);
        aj.e(this.eOq, d.C0141d.cp_cont_b, 1);
        aj.e(this.dZg, d.C0141d.cp_cont_b, 2);
        this.dZg.setHintTextColor(aj.getColor(d.C0141d.cp_cont_e));
        aj.e(this.bMr, d.C0141d.cp_cont_f, 1);
        this.dZg.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        this.eOr = (TextView) findViewById(d.g.game_to_group_share);
        aj.e(this.eOr, d.C0141d.cp_cont_c, 1);
        aAV();
    }

    public void aAV() {
        this.bCu.setFocusable(true);
        this.bCu.setFocusableInTouchMode(true);
        this.bCu.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dZg != null) {
            return k.a(this.dZg.getText(), null);
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
        this.eOs = shareFromGameCenterMsgData;
        Ea();
    }

    private void Ea() {
        this.eOq.setText(this.eOs.getTitle());
        this.eti.setTag(this.eOs.getImageUrl());
        this.eti.startLoad(this.eOs.getImageUrl(), 17, false);
        this.eOp.setVisibility(0);
        this.eOp.setTag(this.eOs.getShareSourceIcon());
        this.eOp.startLoad(this.eOs.getShareSourceIcon(), 17, false);
        this.bMr.setText(this.eOs.getContent());
        this.eOr.setText("来自" + this.eOs.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.eOq.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.eti.setTag(shareFromPBMsgData.getImageUrl());
        this.eti.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.eOp.setVisibility(8);
        this.bMr.setText(shareFromPBMsgData.getContent());
    }
}
