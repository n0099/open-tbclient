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
    private LinearLayout aMp;
    private TextView aWm;
    private BarImageView dUO;
    private TextView dUP;
    protected TextView dUQ;
    private ShareFromGameCenterMsgData dUR;
    private EditText dcJ;
    private TbImageView dzN;

    public EditText getChatMsgView() {
        return this.dcJ;
    }

    public b(Context context) {
        super(context);
        bw(context);
    }

    private void bw(Context context) {
        LayoutInflater.from(context).inflate(d.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aMp = (LinearLayout) findViewById(d.g.game_to_group_share_dialog_content);
        this.dUP = (TextView) findViewById(d.g.share_title_view);
        this.dcJ = (EditText) findViewById(d.g.game_to_group_share_chat_msg);
        this.dzN = (TbImageView) findViewById(d.g.game_to_group_share_img);
        this.dUO = (BarImageView) findViewById(d.g.game_to_group_share_icon);
        this.aWm = (TextView) findViewById(d.g.game_to_group_share_desc);
        aj.c(this.dUP, d.C0082d.cp_cont_b, 1);
        aj.c(this.dcJ, d.C0082d.cp_cont_b, 2);
        this.dcJ.setHintTextColor(aj.getColor(d.C0082d.cp_cont_e));
        aj.c(this.aWm, d.C0082d.cp_cont_f, 1);
        this.dcJ.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        this.dUQ = (TextView) findViewById(d.g.game_to_group_share);
        aj.c(this.dUQ, d.C0082d.cp_cont_c, 1);
        ard();
    }

    public void ard() {
        this.aMp.setFocusable(true);
        this.aMp.setFocusableInTouchMode(true);
        this.aMp.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dcJ != null) {
            return k.a(this.dcJ.getText(), null);
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
        this.dUR = shareFromGameCenterMsgData;
        wr();
    }

    private void wr() {
        this.dUP.setText(this.dUR.getTitle());
        this.dzN.setTag(this.dUR.getImageUrl());
        this.dzN.startLoad(this.dUR.getImageUrl(), 17, false);
        this.dUO.setVisibility(0);
        this.dUO.setTag(this.dUR.getShareSourceIcon());
        this.dUO.startLoad(this.dUR.getShareSourceIcon(), 17, false);
        this.aWm.setText(this.dUR.getContent());
        this.dUQ.setText("来自" + this.dUR.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dUP.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.dzN.setTag(shareFromPBMsgData.getImageUrl());
        this.dzN.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.dUO.setVisibility(8);
        this.aWm.setText(shareFromPBMsgData.getContent());
    }
}
