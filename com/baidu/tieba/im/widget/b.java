package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private TextView aOR;
    private LinearLayout ame;
    private TbImageView cMu;
    private EditText cjG;
    private BarImageView dhV;
    private TextView dhW;
    protected TextView dhX;
    private ShareFromGameCenterMsgData dhY;

    public EditText getChatMsgView() {
        return this.cjG;
    }

    public b(Context context) {
        super(context);
        bp(context);
    }

    private void bp(Context context) {
        LayoutInflater.from(context).inflate(w.j.game_to_group_share_dialog, this);
        setOrientation(1);
        this.ame = (LinearLayout) findViewById(w.h.game_to_group_share_dialog_content);
        this.dhW = (TextView) findViewById(w.h.share_title_view);
        this.cjG = (EditText) findViewById(w.h.game_to_group_share_chat_msg);
        this.cMu = (TbImageView) findViewById(w.h.game_to_group_share_img);
        this.dhV = (BarImageView) findViewById(w.h.game_to_group_share_icon);
        this.aOR = (TextView) findViewById(w.h.game_to_group_share_desc);
        aq.c(this.dhW, w.e.cp_cont_b, 1);
        aq.c(this.cjG, w.e.cp_cont_b, 2);
        this.cjG.setHintTextColor(aq.getColor(w.e.cp_cont_e));
        aq.c(this.aOR, w.e.cp_cont_f, 1);
        this.cjG.setPadding(context.getResources().getDimensionPixelSize(w.f.ds20), 0, 0, 0);
        this.dhX = (TextView) findViewById(w.h.game_to_group_share);
        aq.c(this.dhX, w.e.cp_cont_c, 1);
        aem();
    }

    public void aem() {
        this.ame.setFocusable(true);
        this.ame.setFocusableInTouchMode(true);
        this.ame.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cjG != null) {
            return j.a(this.cjG.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.dhY = shareFromGameCenterMsgData;
        we();
    }

    private void we() {
        this.dhW.setText(this.dhY.getTitle());
        this.cMu.setTag(this.dhY.getImageUrl());
        this.cMu.c(this.dhY.getImageUrl(), 17, false);
        this.dhV.setVisibility(0);
        this.dhV.setTag(this.dhY.getShareSourceIcon());
        this.dhV.c(this.dhY.getShareSourceIcon(), 17, false);
        this.aOR.setText(this.dhY.getContent());
        this.dhX.setText("来自" + this.dhY.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dhW.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.cMu.setTag(shareFromPBMsgData.getImageUrl());
        this.cMu.c(shareFromPBMsgData.getImageUrl(), 17, false);
        this.dhV.setVisibility(8);
        this.aOR.setText(shareFromPBMsgData.getContent());
    }
}
