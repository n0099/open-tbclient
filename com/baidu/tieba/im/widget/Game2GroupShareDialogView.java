package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class Game2GroupShareDialogView extends LinearLayout {
    private LinearLayout aFq;
    private TextView dZK;
    private EditText dZt;
    private BarImageView eRV;
    private TextView eRW;
    protected TextView eRX;
    private ShareFromGameCenterMsgData eRY;
    private TbImageView ewT;

    public EditText getChatMsgView() {
        return this.dZt;
    }

    public Game2GroupShareDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cs(context);
    }

    public Game2GroupShareDialogView(Context context) {
        super(context);
        cs(context);
    }

    private void cs(Context context) {
        LayoutInflater.from(context).inflate(e.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aFq = (LinearLayout) findViewById(e.g.game_to_group_share_dialog_content);
        this.eRW = (TextView) findViewById(e.g.share_title_view);
        this.dZt = (EditText) findViewById(e.g.game_to_group_share_chat_msg);
        this.ewT = (TbImageView) findViewById(e.g.game_to_group_share_img);
        this.eRV = (BarImageView) findViewById(e.g.game_to_group_share_icon);
        this.dZK = (TextView) findViewById(e.g.game_to_group_share_desc);
        al.c(this.eRW, e.d.cp_cont_b, 1);
        al.c(this.dZt, e.d.cp_cont_b, 2);
        this.dZt.setHintTextColor(al.getColor(e.d.cp_cont_e));
        al.c(this.dZK, e.d.cp_cont_f, 1);
        this.dZt.setPadding(context.getResources().getDimensionPixelSize(e.C0175e.ds20), 0, 0, 0);
        this.eRX = (TextView) findViewById(e.g.game_to_group_share);
        al.c(this.eRX, e.d.cp_cont_c, 1);
        aGO();
    }

    public void aGO() {
        this.aFq.setFocusable(true);
        this.aFq.setFocusableInTouchMode(true);
        this.aFq.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dZt != null) {
            return k.a(this.dZt.getText(), null);
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
        this.eRY = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.eRW.setText(this.eRY.getTitle());
        this.ewT.setTag(this.eRY.getImageUrl());
        this.ewT.startLoad(this.eRY.getImageUrl(), 17, false);
        this.eRV.setVisibility(0);
        this.eRV.setTag(this.eRY.getShareSourceIcon());
        this.eRV.startLoad(this.eRY.getShareSourceIcon(), 17, false);
        this.dZK.setText(this.eRY.getContent());
        this.eRX.setText("来自" + this.eRY.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.eRW.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.ewT.setTag(shareFromPBMsgData.getImageUrl());
        this.ewT.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.eRV.setVisibility(8);
        this.dZK.setText(shareFromPBMsgData.getContent());
    }
}
