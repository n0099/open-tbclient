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
    private TbImageView dNL;
    private EditText dtM;
    private TextView due;
    private BarImageView eiS;
    private TextView eiT;
    protected TextView eiU;
    private ShareFromGameCenterMsgData eiV;

    public EditText getChatMsgView() {
        return this.dtM;
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
        this.eiT = (TextView) findViewById(d.g.share_title_view);
        this.dtM = (EditText) findViewById(d.g.game_to_group_share_chat_msg);
        this.dNL = (TbImageView) findViewById(d.g.game_to_group_share_img);
        this.eiS = (BarImageView) findViewById(d.g.game_to_group_share_icon);
        this.due = (TextView) findViewById(d.g.game_to_group_share_desc);
        ak.c(this.eiT, d.C0126d.cp_cont_b, 1);
        ak.c(this.dtM, d.C0126d.cp_cont_b, 2);
        this.dtM.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
        ak.c(this.due, d.C0126d.cp_cont_f, 1);
        this.dtM.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        this.eiU = (TextView) findViewById(d.g.game_to_group_share);
        ak.c(this.eiU, d.C0126d.cp_cont_c, 1);
        avQ();
    }

    public void avQ() {
        this.aMU.setFocusable(true);
        this.aMU.setFocusableInTouchMode(true);
        this.aMU.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dtM != null) {
            return k.a(this.dtM.getText(), null);
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
        this.eiV = shareFromGameCenterMsgData;
        wL();
    }

    private void wL() {
        this.eiT.setText(this.eiV.getTitle());
        this.dNL.setTag(this.eiV.getImageUrl());
        this.dNL.startLoad(this.eiV.getImageUrl(), 17, false);
        this.eiS.setVisibility(0);
        this.eiS.setTag(this.eiV.getShareSourceIcon());
        this.eiS.startLoad(this.eiV.getShareSourceIcon(), 17, false);
        this.due.setText(this.eiV.getContent());
        this.eiU.setText("来自" + this.eiV.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.eiT.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.dNL.setTag(shareFromPBMsgData.getImageUrl());
        this.dNL.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.eiS.setVisibility(8);
        this.due.setText(shareFromPBMsgData.getContent());
    }
}
