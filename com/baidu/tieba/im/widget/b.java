package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private LinearLayout bAs;
    private TextView bKp;
    private EditText dUS;
    private BarImageView eJB;
    private TextView eJC;
    protected TextView eJD;
    private ShareFromGameCenterMsgData eJE;
    private TbImageView eow;

    public EditText getChatMsgView() {
        return this.dUS;
    }

    public b(Context context) {
        super(context);
        bE(context);
    }

    private void bE(Context context) {
        LayoutInflater.from(context).inflate(d.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.bAs = (LinearLayout) findViewById(d.g.game_to_group_share_dialog_content);
        this.eJC = (TextView) findViewById(d.g.share_title_view);
        this.dUS = (EditText) findViewById(d.g.game_to_group_share_chat_msg);
        this.eow = (TbImageView) findViewById(d.g.game_to_group_share_img);
        this.eJB = (BarImageView) findViewById(d.g.game_to_group_share_icon);
        this.bKp = (TextView) findViewById(d.g.game_to_group_share_desc);
        aj.e(this.eJC, d.C0107d.cp_cont_b, 1);
        aj.e(this.dUS, d.C0107d.cp_cont_b, 2);
        this.dUS.setHintTextColor(aj.getColor(d.C0107d.cp_cont_e));
        aj.e(this.bKp, d.C0107d.cp_cont_f, 1);
        this.dUS.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        this.eJD = (TextView) findViewById(d.g.game_to_group_share);
        aj.e(this.eJD, d.C0107d.cp_cont_c, 1);
        azy();
    }

    public void azy() {
        this.bAs.setFocusable(true);
        this.bAs.setFocusableInTouchMode(true);
        this.bAs.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dUS != null) {
            return k.a(this.dUS.getText(), null);
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
        this.eJE = shareFromGameCenterMsgData;
        DE();
    }

    private void DE() {
        this.eJC.setText(this.eJE.getTitle());
        this.eow.setTag(this.eJE.getImageUrl());
        this.eow.startLoad(this.eJE.getImageUrl(), 17, false);
        this.eJB.setVisibility(0);
        this.eJB.setTag(this.eJE.getShareSourceIcon());
        this.eJB.startLoad(this.eJE.getShareSourceIcon(), 17, false);
        this.bKp.setText(this.eJE.getContent());
        this.eJD.setText("来自" + this.eJE.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.eJC.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.eow.setTag(shareFromPBMsgData.getImageUrl());
        this.eow.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.eJB.setVisibility(8);
        this.bKp.setText(shareFromPBMsgData.getContent());
    }
}
