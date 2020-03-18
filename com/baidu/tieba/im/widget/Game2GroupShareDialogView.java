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
    private EditText gSd;
    private BarImageView hMp;
    private TextView hMq;
    protected TextView hMr;
    private ShareFromGameCenterMsgData hMs;
    private TbImageView hrl;
    private TextView hrm;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.gSd;
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
        this.hMq = (TextView) findViewById(R.id.share_title_view);
        this.gSd = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.hrl = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.hMp = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.hrm = (TextView) findViewById(R.id.game_to_group_share_desc);
        am.setViewTextColor(this.hMq, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.gSd, R.color.cp_cont_b, 2);
        this.gSd.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setViewTextColor(this.hrm, R.color.cp_cont_f, 1);
        this.gSd.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.hMr = (TextView) findViewById(R.id.game_to_group_share);
        am.setViewTextColor(this.hMr, R.color.cp_cont_c, 1);
        bMb();
    }

    public void bMb() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.gSd != null) {
            return k.charSequence2String(this.gSd.getText(), null);
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
        this.hMs = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.hMq.setText(this.hMs.getTitle());
        this.hrl.setTag(this.hMs.getImageUrl());
        this.hrl.startLoad(this.hMs.getImageUrl(), 17, false);
        this.hMp.setVisibility(0);
        this.hMp.setTag(this.hMs.getShareSourceIcon());
        this.hMp.startLoad(this.hMs.getShareSourceIcon(), 17, false);
        this.hrm.setText(this.hMs.getContent());
        this.hMr.setText("来自" + this.hMs.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.hMq.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.hrl.setTag(shareFromPBMsgData.getImageUrl());
        this.hrl.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.hMp.setVisibility(8);
        this.hrm.setText(shareFromPBMsgData.getContent());
    }
}
