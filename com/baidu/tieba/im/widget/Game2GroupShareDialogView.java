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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class Game2GroupShareDialogView extends LinearLayout {
    private LinearLayout bFz;
    private TbImageView fYw;
    private TextView fYx;
    private EditText fzM;
    private BarImageView gtB;
    private TextView gtC;
    protected TextView gtD;
    private ShareFromGameCenterMsgData gtE;

    public EditText getChatMsgView() {
        return this.fzM;
    }

    public Game2GroupShareDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aX(context);
    }

    public Game2GroupShareDialogView(Context context) {
        super(context);
        aX(context);
    }

    private void aX(Context context) {
        LayoutInflater.from(context).inflate(d.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.bFz = (LinearLayout) findViewById(d.g.game_to_group_share_dialog_content);
        this.gtC = (TextView) findViewById(d.g.share_title_view);
        this.fzM = (EditText) findViewById(d.g.game_to_group_share_chat_msg);
        this.fYw = (TbImageView) findViewById(d.g.game_to_group_share_img);
        this.gtB = (BarImageView) findViewById(d.g.game_to_group_share_icon);
        this.fYx = (TextView) findViewById(d.g.game_to_group_share_desc);
        al.d(this.gtC, d.C0277d.cp_cont_b, 1);
        al.d(this.fzM, d.C0277d.cp_cont_b, 2);
        this.fzM.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
        al.d(this.fYx, d.C0277d.cp_cont_f, 1);
        this.fzM.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        this.gtD = (TextView) findViewById(d.g.game_to_group_share);
        al.d(this.gtD, d.C0277d.cp_cont_c, 1);
        bkf();
    }

    public void bkf() {
        this.bFz.setFocusable(true);
        this.bFz.setFocusableInTouchMode(true);
        this.bFz.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.fzM != null) {
            return k.a(this.fzM.getText(), null);
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
        this.gtE = shareFromGameCenterMsgData;
        GP();
    }

    private void GP() {
        this.gtC.setText(this.gtE.getTitle());
        this.fYw.setTag(this.gtE.getImageUrl());
        this.fYw.startLoad(this.gtE.getImageUrl(), 17, false);
        this.gtB.setVisibility(0);
        this.gtB.setTag(this.gtE.getShareSourceIcon());
        this.gtB.startLoad(this.gtE.getShareSourceIcon(), 17, false);
        this.fYx.setText(this.gtE.getContent());
        this.gtD.setText("来自" + this.gtE.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.gtC.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.fYw.setTag(shareFromPBMsgData.getImageUrl());
        this.fYw.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.gtB.setVisibility(8);
        this.fYx.setText(shareFromPBMsgData.getContent());
    }
}
