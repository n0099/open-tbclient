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
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class Game2GroupShareDialogView extends LinearLayout {
    private EditText fXK;
    private BarImageView gRM;
    private TextView gRN;
    protected TextView gRO;
    private ShareFromGameCenterMsgData gRP;
    private TbImageView gwF;
    private TextView gwG;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.fXK;
    }

    public Game2GroupShareDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI(context);
    }

    public Game2GroupShareDialogView(Context context) {
        super(context);
        initUI(context);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.game_to_group_share_dialog, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(R.id.game_to_group_share_dialog_content);
        this.gRN = (TextView) findViewById(R.id.share_title_view);
        this.fXK = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.gwF = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.gRM = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.gwG = (TextView) findViewById(R.id.game_to_group_share_desc);
        am.setViewTextColor(this.gRN, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.fXK, R.color.cp_cont_b, 2);
        this.fXK.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setViewTextColor(this.gwG, R.color.cp_cont_f, 1);
        this.fXK.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.gRO = (TextView) findViewById(R.id.game_to_group_share);
        am.setViewTextColor(this.gRO, R.color.cp_cont_c, 1);
        brG();
    }

    public void brG() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.fXK != null) {
            return k.charSequence2String(this.fXK.getText(), null);
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
        this.gRP = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.gRN.setText(this.gRP.getTitle());
        this.gwF.setTag(this.gRP.getImageUrl());
        this.gwF.startLoad(this.gRP.getImageUrl(), 17, false);
        this.gRM.setVisibility(0);
        this.gRM.setTag(this.gRP.getShareSourceIcon());
        this.gRM.startLoad(this.gRP.getShareSourceIcon(), 17, false);
        this.gwG.setText(this.gRP.getContent());
        this.gRO.setText("来自" + this.gRP.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.gRN.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.gwF.setTag(shareFromPBMsgData.getImageUrl());
        this.gwF.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.gRM.setVisibility(8);
        this.gwG.setText(shareFromPBMsgData.getContent());
    }
}
