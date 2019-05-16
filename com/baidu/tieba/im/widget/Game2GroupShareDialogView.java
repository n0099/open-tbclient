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
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class Game2GroupShareDialogView extends LinearLayout {
    private LinearLayout bMZ;
    private EditText fQI;
    private BarImageView gKO;
    private TextView gKP;
    protected TextView gKQ;
    private ShareFromGameCenterMsgData gKR;
    private TbImageView gpK;
    private TextView gpL;

    public EditText getChatMsgView() {
        return this.fQI;
    }

    public Game2GroupShareDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ap(context);
    }

    public Game2GroupShareDialogView(Context context) {
        super(context);
        ap(context);
    }

    private void ap(Context context) {
        LayoutInflater.from(context).inflate(R.layout.game_to_group_share_dialog, this);
        setOrientation(1);
        this.bMZ = (LinearLayout) findViewById(R.id.game_to_group_share_dialog_content);
        this.gKP = (TextView) findViewById(R.id.share_title_view);
        this.fQI = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.gpK = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.gKO = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.gpL = (TextView) findViewById(R.id.game_to_group_share_desc);
        al.f(this.gKP, R.color.cp_cont_b, 1);
        al.f(this.fQI, R.color.cp_cont_b, 2);
        this.fQI.setHintTextColor(al.getColor(R.color.cp_cont_e));
        al.f(this.gpL, R.color.cp_cont_f, 1);
        this.fQI.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.gKQ = (TextView) findViewById(R.id.game_to_group_share);
        al.f(this.gKQ, R.color.cp_cont_c, 1);
        brx();
    }

    public void brx() {
        this.bMZ.setFocusable(true);
        this.bMZ.setFocusableInTouchMode(true);
        this.bMZ.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.fQI != null) {
            return k.a(this.fQI.getText(), null);
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
        this.gKR = shareFromGameCenterMsgData;
        Jf();
    }

    private void Jf() {
        this.gKP.setText(this.gKR.getTitle());
        this.gpK.setTag(this.gKR.getImageUrl());
        this.gpK.startLoad(this.gKR.getImageUrl(), 17, false);
        this.gKO.setVisibility(0);
        this.gKO.setTag(this.gKR.getShareSourceIcon());
        this.gKO.startLoad(this.gKR.getShareSourceIcon(), 17, false);
        this.gpL.setText(this.gKR.getContent());
        this.gKQ.setText("来自" + this.gKR.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.gKP.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.gpK.setTag(shareFromPBMsgData.getImageUrl());
        this.gpK.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.gKO.setVisibility(8);
        this.gpL.setText(shareFromPBMsgData.getContent());
    }
}
