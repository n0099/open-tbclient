package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class Game2GroupShareDialogView extends LinearLayout {
    private LinearLayout aMU;
    private TbImageView dNO;
    private EditText dtP;
    private TextView duh;
    private BarImageView eiV;
    private TextView eiW;
    protected TextView eiX;
    private ShareFromGameCenterMsgData eiY;

    public EditText getChatMsgView() {
        return this.dtP;
    }

    public Game2GroupShareDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bo(context);
    }

    public Game2GroupShareDialogView(Context context) {
        super(context);
        bo(context);
    }

    private void bo(Context context) {
        LayoutInflater.from(context).inflate(d.i.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aMU = (LinearLayout) findViewById(d.g.game_to_group_share_dialog_content);
        this.eiW = (TextView) findViewById(d.g.share_title_view);
        this.dtP = (EditText) findViewById(d.g.game_to_group_share_chat_msg);
        this.dNO = (TbImageView) findViewById(d.g.game_to_group_share_img);
        this.eiV = (BarImageView) findViewById(d.g.game_to_group_share_icon);
        this.duh = (TextView) findViewById(d.g.game_to_group_share_desc);
        ak.c(this.eiW, d.C0126d.cp_cont_b, 1);
        ak.c(this.dtP, d.C0126d.cp_cont_b, 2);
        this.dtP.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
        ak.c(this.duh, d.C0126d.cp_cont_f, 1);
        this.dtP.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        this.eiX = (TextView) findViewById(d.g.game_to_group_share);
        ak.c(this.eiX, d.C0126d.cp_cont_c, 1);
        avQ();
    }

    public void avQ() {
        this.aMU.setFocusable(true);
        this.aMU.setFocusableInTouchMode(true);
        this.aMU.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dtP != null) {
            return k.a(this.dtP.getText(), null);
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
        this.eiY = shareFromGameCenterMsgData;
        wL();
    }

    private void wL() {
        this.eiW.setText(this.eiY.getTitle());
        this.dNO.setTag(this.eiY.getImageUrl());
        this.dNO.startLoad(this.eiY.getImageUrl(), 17, false);
        this.eiV.setVisibility(0);
        this.eiV.setTag(this.eiY.getShareSourceIcon());
        this.eiV.startLoad(this.eiY.getShareSourceIcon(), 17, false);
        this.duh.setText(this.eiY.getContent());
        this.eiX.setText("来自" + this.eiY.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.eiW.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.dNO.setTag(shareFromPBMsgData.getImageUrl());
        this.dNO.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.eiV.setVisibility(8);
        this.duh.setText(shareFromPBMsgData.getContent());
    }
}
