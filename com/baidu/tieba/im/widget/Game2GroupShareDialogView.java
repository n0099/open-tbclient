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
    private LinearLayout aGg;
    private BarImageView eTn;
    private TextView eTo;
    protected TextView eTp;
    private ShareFromGameCenterMsgData eTq;
    private EditText eaM;
    private TextView ebd;
    private TbImageView eyo;

    public EditText getChatMsgView() {
        return this.eaM;
    }

    public Game2GroupShareDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cn(context);
    }

    public Game2GroupShareDialogView(Context context) {
        super(context);
        cn(context);
    }

    private void cn(Context context) {
        LayoutInflater.from(context).inflate(e.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aGg = (LinearLayout) findViewById(e.g.game_to_group_share_dialog_content);
        this.eTo = (TextView) findViewById(e.g.share_title_view);
        this.eaM = (EditText) findViewById(e.g.game_to_group_share_chat_msg);
        this.eyo = (TbImageView) findViewById(e.g.game_to_group_share_img);
        this.eTn = (BarImageView) findViewById(e.g.game_to_group_share_icon);
        this.ebd = (TextView) findViewById(e.g.game_to_group_share_desc);
        al.c(this.eTo, e.d.cp_cont_b, 1);
        al.c(this.eaM, e.d.cp_cont_b, 2);
        this.eaM.setHintTextColor(al.getColor(e.d.cp_cont_e));
        al.c(this.ebd, e.d.cp_cont_f, 1);
        this.eaM.setPadding(context.getResources().getDimensionPixelSize(e.C0200e.ds20), 0, 0, 0);
        this.eTp = (TextView) findViewById(e.g.game_to_group_share);
        al.c(this.eTp, e.d.cp_cont_c, 1);
        aGm();
    }

    public void aGm() {
        this.aGg.setFocusable(true);
        this.aGg.setFocusableInTouchMode(true);
        this.aGg.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.eaM != null) {
            return k.a(this.eaM.getText(), null);
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
        this.eTq = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.eTo.setText(this.eTq.getTitle());
        this.eyo.setTag(this.eTq.getImageUrl());
        this.eyo.startLoad(this.eTq.getImageUrl(), 17, false);
        this.eTn.setVisibility(0);
        this.eTn.setTag(this.eTq.getShareSourceIcon());
        this.eTn.startLoad(this.eTq.getShareSourceIcon(), 17, false);
        this.ebd.setText(this.eTq.getContent());
        this.eTp.setText("来自" + this.eTq.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.eTo.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.eyo.setTag(shareFromPBMsgData.getImageUrl());
        this.eyo.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.eTn.setVisibility(8);
        this.ebd.setText(shareFromPBMsgData.getContent());
    }
}
