package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private LinearLayout aJF;
    private TextView aQj;
    private TbImageView cUr;
    private EditText crG;
    private BarImageView dpR;
    private TextView dpS;
    protected TextView dpT;
    private ShareFromGameCenterMsgData dpU;

    public EditText getChatMsgView() {
        return this.crG;
    }

    public b(Context context) {
        super(context);
        bj(context);
    }

    private void bj(Context context) {
        LayoutInflater.from(context).inflate(w.j.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aJF = (LinearLayout) findViewById(w.h.game_to_group_share_dialog_content);
        this.dpS = (TextView) findViewById(w.h.share_title_view);
        this.crG = (EditText) findViewById(w.h.game_to_group_share_chat_msg);
        this.cUr = (TbImageView) findViewById(w.h.game_to_group_share_img);
        this.dpR = (BarImageView) findViewById(w.h.game_to_group_share_icon);
        this.aQj = (TextView) findViewById(w.h.game_to_group_share_desc);
        as.c(this.dpS, w.e.cp_cont_b, 1);
        as.c(this.crG, w.e.cp_cont_b, 2);
        this.crG.setHintTextColor(as.getColor(w.e.cp_cont_e));
        as.c(this.aQj, w.e.cp_cont_f, 1);
        this.crG.setPadding(context.getResources().getDimensionPixelSize(w.f.ds20), 0, 0, 0);
        this.dpT = (TextView) findViewById(w.h.game_to_group_share);
        as.c(this.dpT, w.e.cp_cont_c, 1);
        aia();
    }

    public void aia() {
        this.aJF.setFocusable(true);
        this.aJF.setFocusableInTouchMode(true);
        this.aJF.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.crG != null) {
            return j.a(this.crG.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.dpU = shareFromGameCenterMsgData;
        ww();
    }

    private void ww() {
        this.dpS.setText(this.dpU.getTitle());
        this.cUr.setTag(this.dpU.getImageUrl());
        this.cUr.c(this.dpU.getImageUrl(), 17, false);
        this.dpR.setVisibility(0);
        this.dpR.setTag(this.dpU.getShareSourceIcon());
        this.dpR.c(this.dpU.getShareSourceIcon(), 17, false);
        this.aQj.setText(this.dpU.getContent());
        this.dpT.setText("来自" + this.dpU.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dpS.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.cUr.setTag(shareFromPBMsgData.getImageUrl());
        this.cUr.c(shareFromPBMsgData.getImageUrl(), 17, false);
        this.dpR.setVisibility(8);
        this.aQj.setText(shareFromPBMsgData.getContent());
    }
}
