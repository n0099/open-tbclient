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
    private EditText gQW;
    private BarImageView hKP;
    private TextView hKQ;
    protected TextView hKR;
    private ShareFromGameCenterMsgData hKS;
    private TbImageView hpL;
    private TextView hpM;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.gQW;
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
        this.hKQ = (TextView) findViewById(R.id.share_title_view);
        this.gQW = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.hpL = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.hKP = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.hpM = (TextView) findViewById(R.id.game_to_group_share_desc);
        am.setViewTextColor(this.hKQ, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.gQW, R.color.cp_cont_b, 2);
        this.gQW.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setViewTextColor(this.hpM, R.color.cp_cont_f, 1);
        this.gQW.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.hKR = (TextView) findViewById(R.id.game_to_group_share);
        am.setViewTextColor(this.hKR, R.color.cp_cont_c, 1);
        bLN();
    }

    public void bLN() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.gQW != null) {
            return k.charSequence2String(this.gQW.getText(), null);
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
        this.hKS = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.hKQ.setText(this.hKS.getTitle());
        this.hpL.setTag(this.hKS.getImageUrl());
        this.hpL.startLoad(this.hKS.getImageUrl(), 17, false);
        this.hKP.setVisibility(0);
        this.hKP.setTag(this.hKS.getShareSourceIcon());
        this.hKP.startLoad(this.hKS.getShareSourceIcon(), 17, false);
        this.hpM.setText(this.hKS.getContent());
        this.hKR.setText("来自" + this.hKS.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.hKQ.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.hpL.setTag(shareFromPBMsgData.getImageUrl());
        this.hpL.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.hKP.setVisibility(8);
        this.hpM.setText(shareFromPBMsgData.getContent());
    }
}
