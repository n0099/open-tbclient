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
    private LinearLayout aMV;
    private TbImageView dOS;
    private EditText duU;
    private TextView dvm;
    private BarImageView ejZ;
    private TextView eka;
    protected TextView ekb;
    private ShareFromGameCenterMsgData ekc;

    public EditText getChatMsgView() {
        return this.duU;
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
        this.aMV = (LinearLayout) findViewById(d.g.game_to_group_share_dialog_content);
        this.eka = (TextView) findViewById(d.g.share_title_view);
        this.duU = (EditText) findViewById(d.g.game_to_group_share_chat_msg);
        this.dOS = (TbImageView) findViewById(d.g.game_to_group_share_img);
        this.ejZ = (BarImageView) findViewById(d.g.game_to_group_share_icon);
        this.dvm = (TextView) findViewById(d.g.game_to_group_share_desc);
        ak.c(this.eka, d.C0126d.cp_cont_b, 1);
        ak.c(this.duU, d.C0126d.cp_cont_b, 2);
        this.duU.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
        ak.c(this.dvm, d.C0126d.cp_cont_f, 1);
        this.duU.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        this.ekb = (TextView) findViewById(d.g.game_to_group_share);
        ak.c(this.ekb, d.C0126d.cp_cont_c, 1);
        avP();
    }

    public void avP() {
        this.aMV.setFocusable(true);
        this.aMV.setFocusableInTouchMode(true);
        this.aMV.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.duU != null) {
            return k.a(this.duU.getText(), null);
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
        this.ekc = shareFromGameCenterMsgData;
        wK();
    }

    private void wK() {
        this.eka.setText(this.ekc.getTitle());
        this.dOS.setTag(this.ekc.getImageUrl());
        this.dOS.startLoad(this.ekc.getImageUrl(), 17, false);
        this.ejZ.setVisibility(0);
        this.ejZ.setTag(this.ekc.getShareSourceIcon());
        this.ejZ.startLoad(this.ekc.getShareSourceIcon(), 17, false);
        this.dvm.setText(this.ekc.getContent());
        this.ekb.setText("来自" + this.ekc.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.eka.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.dOS.setTag(shareFromPBMsgData.getImageUrl());
        this.dOS.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.ejZ.setVisibility(8);
        this.dvm.setText(shareFromPBMsgData.getContent());
    }
}
