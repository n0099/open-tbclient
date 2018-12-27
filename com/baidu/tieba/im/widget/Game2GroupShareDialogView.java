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
    private LinearLayout aJI;
    private TbImageView eHV;
    private EditText ekg;
    private TextView ekx;
    private BarImageView fcT;
    private TextView fcU;
    protected TextView fcV;
    private ShareFromGameCenterMsgData fcW;

    public EditText getChatMsgView() {
        return this.ekg;
    }

    public Game2GroupShareDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cr(context);
    }

    public Game2GroupShareDialogView(Context context) {
        super(context);
        cr(context);
    }

    private void cr(Context context) {
        LayoutInflater.from(context).inflate(e.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aJI = (LinearLayout) findViewById(e.g.game_to_group_share_dialog_content);
        this.fcU = (TextView) findViewById(e.g.share_title_view);
        this.ekg = (EditText) findViewById(e.g.game_to_group_share_chat_msg);
        this.eHV = (TbImageView) findViewById(e.g.game_to_group_share_img);
        this.fcT = (BarImageView) findViewById(e.g.game_to_group_share_icon);
        this.ekx = (TextView) findViewById(e.g.game_to_group_share_desc);
        al.c(this.fcU, e.d.cp_cont_b, 1);
        al.c(this.ekg, e.d.cp_cont_b, 2);
        this.ekg.setHintTextColor(al.getColor(e.d.cp_cont_e));
        al.c(this.ekx, e.d.cp_cont_f, 1);
        this.ekg.setPadding(context.getResources().getDimensionPixelSize(e.C0210e.ds20), 0, 0, 0);
        this.fcV = (TextView) findViewById(e.g.game_to_group_share);
        al.c(this.fcV, e.d.cp_cont_c, 1);
        aIN();
    }

    public void aIN() {
        this.aJI.setFocusable(true);
        this.aJI.setFocusableInTouchMode(true);
        this.aJI.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.ekg != null) {
            return k.a(this.ekg.getText(), null);
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
        this.fcW = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.fcU.setText(this.fcW.getTitle());
        this.eHV.setTag(this.fcW.getImageUrl());
        this.eHV.startLoad(this.fcW.getImageUrl(), 17, false);
        this.fcT.setVisibility(0);
        this.fcT.setTag(this.fcW.getShareSourceIcon());
        this.fcT.startLoad(this.fcW.getShareSourceIcon(), 17, false);
        this.ekx.setText(this.fcW.getContent());
        this.fcV.setText("来自" + this.fcW.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.fcU.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.eHV.setTag(shareFromPBMsgData.getImageUrl());
        this.eHV.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.fcT.setVisibility(8);
        this.ekx.setText(shareFromPBMsgData.getContent());
    }
}
