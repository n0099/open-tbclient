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
    private LinearLayout aAJ;
    private TextView dRP;
    private EditText dRx;
    private BarImageView eKl;
    private TextView eKm;
    protected TextView eKn;
    private ShareFromGameCenterMsgData eKo;
    private TbImageView epd;

    public EditText getChatMsgView() {
        return this.dRx;
    }

    public Game2GroupShareDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cf(context);
    }

    public Game2GroupShareDialogView(Context context) {
        super(context);
        cf(context);
    }

    private void cf(Context context) {
        LayoutInflater.from(context).inflate(e.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aAJ = (LinearLayout) findViewById(e.g.game_to_group_share_dialog_content);
        this.eKm = (TextView) findViewById(e.g.share_title_view);
        this.dRx = (EditText) findViewById(e.g.game_to_group_share_chat_msg);
        this.epd = (TbImageView) findViewById(e.g.game_to_group_share_img);
        this.eKl = (BarImageView) findViewById(e.g.game_to_group_share_icon);
        this.dRP = (TextView) findViewById(e.g.game_to_group_share_desc);
        al.c(this.eKm, e.d.cp_cont_b, 1);
        al.c(this.dRx, e.d.cp_cont_b, 2);
        this.dRx.setHintTextColor(al.getColor(e.d.cp_cont_e));
        al.c(this.dRP, e.d.cp_cont_f, 1);
        this.dRx.setPadding(context.getResources().getDimensionPixelSize(e.C0141e.ds20), 0, 0, 0);
        this.eKn = (TextView) findViewById(e.g.game_to_group_share);
        al.c(this.eKn, e.d.cp_cont_c, 1);
        aDw();
    }

    public void aDw() {
        this.aAJ.setFocusable(true);
        this.aAJ.setFocusableInTouchMode(true);
        this.aAJ.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dRx != null) {
            return k.a(this.dRx.getText(), null);
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
        this.eKo = shareFromGameCenterMsgData;
        Bp();
    }

    private void Bp() {
        this.eKm.setText(this.eKo.getTitle());
        this.epd.setTag(this.eKo.getImageUrl());
        this.epd.startLoad(this.eKo.getImageUrl(), 17, false);
        this.eKl.setVisibility(0);
        this.eKl.setTag(this.eKo.getShareSourceIcon());
        this.eKl.startLoad(this.eKo.getShareSourceIcon(), 17, false);
        this.dRP.setText(this.eKo.getContent());
        this.eKn.setText("来自" + this.eKo.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.eKm.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.epd.setTag(shareFromPBMsgData.getImageUrl());
        this.epd.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.eKl.setVisibility(8);
        this.dRP.setText(shareFromPBMsgData.getContent());
    }
}
