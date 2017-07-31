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
    private LinearLayout aMc;
    private TextView aSE;
    private EditText cAj;
    private TbImageView deq;
    private BarImageView dzL;
    private TextView dzM;
    protected TextView dzN;
    private ShareFromGameCenterMsgData dzO;

    public EditText getChatMsgView() {
        return this.cAj;
    }

    public b(Context context) {
        super(context);
        bk(context);
    }

    private void bk(Context context) {
        LayoutInflater.from(context).inflate(d.j.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aMc = (LinearLayout) findViewById(d.h.game_to_group_share_dialog_content);
        this.dzM = (TextView) findViewById(d.h.share_title_view);
        this.cAj = (EditText) findViewById(d.h.game_to_group_share_chat_msg);
        this.deq = (TbImageView) findViewById(d.h.game_to_group_share_img);
        this.dzL = (BarImageView) findViewById(d.h.game_to_group_share_icon);
        this.aSE = (TextView) findViewById(d.h.game_to_group_share_desc);
        ai.c(this.dzM, d.e.cp_cont_b, 1);
        ai.c(this.cAj, d.e.cp_cont_b, 2);
        this.cAj.setHintTextColor(ai.getColor(d.e.cp_cont_e));
        ai.c(this.aSE, d.e.cp_cont_f, 1);
        this.cAj.setPadding(context.getResources().getDimensionPixelSize(d.f.ds20), 0, 0, 0);
        this.dzN = (TextView) findViewById(d.h.game_to_group_share);
        ai.c(this.dzN, d.e.cp_cont_c, 1);
        ajQ();
    }

    public void ajQ() {
        this.aMc.setFocusable(true);
        this.aMc.setFocusableInTouchMode(true);
        this.aMc.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cAj != null) {
            return j.a(this.cAj.getText(), null);
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
        this.dzO = shareFromGameCenterMsgData;
        wP();
    }

    private void wP() {
        this.dzM.setText(this.dzO.getTitle());
        this.deq.setTag(this.dzO.getImageUrl());
        this.deq.c(this.dzO.getImageUrl(), 17, false);
        this.dzL.setVisibility(0);
        this.dzL.setTag(this.dzO.getShareSourceIcon());
        this.dzL.c(this.dzO.getShareSourceIcon(), 17, false);
        this.aSE.setText(this.dzO.getContent());
        this.dzN.setText("来自" + this.dzO.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dzM.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.deq.setTag(shareFromPBMsgData.getImageUrl());
        this.deq.c(shareFromPBMsgData.getImageUrl(), 17, false);
        this.dzL.setVisibility(8);
        this.aSE.setText(shareFromPBMsgData.getContent());
    }
}
