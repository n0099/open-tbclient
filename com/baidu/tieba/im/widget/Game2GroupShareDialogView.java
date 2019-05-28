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
    private EditText fQJ;
    private BarImageView gKP;
    private TextView gKQ;
    protected TextView gKR;
    private ShareFromGameCenterMsgData gKS;
    private TbImageView gpL;
    private TextView gpM;

    public EditText getChatMsgView() {
        return this.fQJ;
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
        this.gKQ = (TextView) findViewById(R.id.share_title_view);
        this.fQJ = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.gpL = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.gKP = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.gpM = (TextView) findViewById(R.id.game_to_group_share_desc);
        al.f(this.gKQ, R.color.cp_cont_b, 1);
        al.f(this.fQJ, R.color.cp_cont_b, 2);
        this.fQJ.setHintTextColor(al.getColor(R.color.cp_cont_e));
        al.f(this.gpM, R.color.cp_cont_f, 1);
        this.fQJ.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.gKR = (TextView) findViewById(R.id.game_to_group_share);
        al.f(this.gKR, R.color.cp_cont_c, 1);
        brA();
    }

    public void brA() {
        this.bMZ.setFocusable(true);
        this.bMZ.setFocusableInTouchMode(true);
        this.bMZ.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.fQJ != null) {
            return k.a(this.fQJ.getText(), null);
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
        this.gKS = shareFromGameCenterMsgData;
        Jf();
    }

    private void Jf() {
        this.gKQ.setText(this.gKS.getTitle());
        this.gpL.setTag(this.gKS.getImageUrl());
        this.gpL.startLoad(this.gKS.getImageUrl(), 17, false);
        this.gKP.setVisibility(0);
        this.gKP.setTag(this.gKS.getShareSourceIcon());
        this.gKP.startLoad(this.gKS.getShareSourceIcon(), 17, false);
        this.gpM.setText(this.gKS.getContent());
        this.gKR.setText("来自" + this.gKS.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.gKQ.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.gpL.setTag(shareFromPBMsgData.getImageUrl());
        this.gpL.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.gKP.setVisibility(8);
        this.gpM.setText(shareFromPBMsgData.getContent());
    }
}
