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
    private EditText gQK;
    private BarImageView hKD;
    private TextView hKE;
    protected TextView hKF;
    private ShareFromGameCenterMsgData hKG;
    private TextView hpA;
    private TbImageView hpz;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.gQK;
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
        this.hKE = (TextView) findViewById(R.id.share_title_view);
        this.gQK = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.hpz = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.hKD = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.hpA = (TextView) findViewById(R.id.game_to_group_share_desc);
        am.setViewTextColor(this.hKE, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.gQK, R.color.cp_cont_b, 2);
        this.gQK.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setViewTextColor(this.hpA, R.color.cp_cont_f, 1);
        this.gQK.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.hKF = (TextView) findViewById(R.id.game_to_group_share);
        am.setViewTextColor(this.hKF, R.color.cp_cont_c, 1);
        bLM();
    }

    public void bLM() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.gQK != null) {
            return k.charSequence2String(this.gQK.getText(), null);
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
        this.hKG = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.hKE.setText(this.hKG.getTitle());
        this.hpz.setTag(this.hKG.getImageUrl());
        this.hpz.startLoad(this.hKG.getImageUrl(), 17, false);
        this.hKD.setVisibility(0);
        this.hKD.setTag(this.hKG.getShareSourceIcon());
        this.hKD.startLoad(this.hKG.getShareSourceIcon(), 17, false);
        this.hpA.setText(this.hKG.getContent());
        this.hKF.setText("来自" + this.hKG.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.hKE.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.hpz.setTag(shareFromPBMsgData.getImageUrl());
        this.hpz.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.hKD.setVisibility(8);
        this.hpA.setText(shareFromPBMsgData.getContent());
    }
}
