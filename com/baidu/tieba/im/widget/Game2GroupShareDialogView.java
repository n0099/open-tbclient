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
    private LinearLayout bNa;
    private EditText fQL;
    private BarImageView gKR;
    private TextView gKS;
    protected TextView gKT;
    private ShareFromGameCenterMsgData gKU;
    private TbImageView gpN;
    private TextView gpO;

    public EditText getChatMsgView() {
        return this.fQL;
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
        this.bNa = (LinearLayout) findViewById(R.id.game_to_group_share_dialog_content);
        this.gKS = (TextView) findViewById(R.id.share_title_view);
        this.fQL = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.gpN = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.gKR = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.gpO = (TextView) findViewById(R.id.game_to_group_share_desc);
        al.f(this.gKS, R.color.cp_cont_b, 1);
        al.f(this.fQL, R.color.cp_cont_b, 2);
        this.fQL.setHintTextColor(al.getColor(R.color.cp_cont_e));
        al.f(this.gpO, R.color.cp_cont_f, 1);
        this.fQL.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.gKT = (TextView) findViewById(R.id.game_to_group_share);
        al.f(this.gKT, R.color.cp_cont_c, 1);
        brC();
    }

    public void brC() {
        this.bNa.setFocusable(true);
        this.bNa.setFocusableInTouchMode(true);
        this.bNa.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.fQL != null) {
            return k.a(this.fQL.getText(), null);
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
        this.gKU = shareFromGameCenterMsgData;
        Jf();
    }

    private void Jf() {
        this.gKS.setText(this.gKU.getTitle());
        this.gpN.setTag(this.gKU.getImageUrl());
        this.gpN.startLoad(this.gKU.getImageUrl(), 17, false);
        this.gKR.setVisibility(0);
        this.gKR.setTag(this.gKU.getShareSourceIcon());
        this.gKR.startLoad(this.gKU.getShareSourceIcon(), 17, false);
        this.gpO.setText(this.gKU.getContent());
        this.gKT.setText("来自" + this.gKU.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.gKS.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.gpN.setTag(shareFromPBMsgData.getImageUrl());
        this.gpN.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.gKR.setVisibility(8);
        this.gpO.setText(shareFromPBMsgData.getContent());
    }
}
