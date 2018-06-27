package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class Game2GroupShareDialogView extends LinearLayout {
    private LinearLayout aya;
    private EditText dHC;
    private TextView dHU;
    private TbImageView edX;
    private BarImageView ezh;
    private TextView ezi;
    protected TextView ezj;
    private ShareFromGameCenterMsgData ezk;

    public EditText getChatMsgView() {
        return this.dHC;
    }

    public Game2GroupShareDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bx(context);
    }

    public Game2GroupShareDialogView(Context context) {
        super(context);
        bx(context);
    }

    private void bx(Context context) {
        LayoutInflater.from(context).inflate(d.i.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aya = (LinearLayout) findViewById(d.g.game_to_group_share_dialog_content);
        this.ezi = (TextView) findViewById(d.g.share_title_view);
        this.dHC = (EditText) findViewById(d.g.game_to_group_share_chat_msg);
        this.edX = (TbImageView) findViewById(d.g.game_to_group_share_img);
        this.ezh = (BarImageView) findViewById(d.g.game_to_group_share_icon);
        this.dHU = (TextView) findViewById(d.g.game_to_group_share_desc);
        am.c(this.ezi, d.C0142d.cp_cont_b, 1);
        am.c(this.dHC, d.C0142d.cp_cont_b, 2);
        this.dHC.setHintTextColor(am.getColor(d.C0142d.cp_cont_e));
        am.c(this.dHU, d.C0142d.cp_cont_f, 1);
        this.dHC.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        this.ezj = (TextView) findViewById(d.g.game_to_group_share);
        am.c(this.ezj, d.C0142d.cp_cont_c, 1);
        aAF();
    }

    public void aAF() {
        this.aya.setFocusable(true);
        this.aya.setFocusableInTouchMode(true);
        this.aya.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dHC != null) {
            return k.a(this.dHC.getText(), null);
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
        this.ezk = shareFromGameCenterMsgData;
        AB();
    }

    private void AB() {
        this.ezi.setText(this.ezk.getTitle());
        this.edX.setTag(this.ezk.getImageUrl());
        this.edX.startLoad(this.ezk.getImageUrl(), 17, false);
        this.ezh.setVisibility(0);
        this.ezh.setTag(this.ezk.getShareSourceIcon());
        this.ezh.startLoad(this.ezk.getShareSourceIcon(), 17, false);
        this.dHU.setText(this.ezk.getContent());
        this.ezj.setText("来自" + this.ezk.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.ezi.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.edX.setTag(shareFromPBMsgData.getImageUrl());
        this.edX.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.ezh.setVisibility(8);
        this.dHU.setText(shareFromPBMsgData.getContent());
    }
}
