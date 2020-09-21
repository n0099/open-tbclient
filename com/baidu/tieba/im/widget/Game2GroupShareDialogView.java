package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class Game2GroupShareDialogView extends LinearLayout {
    private TbImageView eSz;
    private EditText iGS;
    private BarImageView jIK;
    private TextView jIL;
    protected TextView jIM;
    private ShareFromGameCenterMsgData jIN;
    private TextView jly;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.iGS;
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
        this.jIL = (TextView) findViewById(R.id.share_title_view);
        this.iGS = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.eSz = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.jIK = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.jly = (TextView) findViewById(R.id.game_to_group_share_desc);
        ap.setViewTextColor(this.jIL, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.iGS, R.color.cp_cont_b, 2);
        this.iGS.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        ap.setViewTextColor(this.jly, R.color.cp_cont_f, 1);
        this.iGS.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.jIM = (TextView) findViewById(R.id.game_to_group_share);
        ap.setViewTextColor(this.jIM, R.color.cp_cont_c, 1);
        cyh();
    }

    public void cyh() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.iGS != null) {
            return k.charSequence2String(this.iGS.getText(), null);
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
        this.jIN = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.jIL.setText(this.jIN.getTitle());
        this.eSz.setTag(this.jIN.getImageUrl());
        this.eSz.startLoad(this.jIN.getImageUrl(), 17, false);
        this.jIK.setVisibility(0);
        this.jIK.setTag(this.jIN.getShareSourceIcon());
        this.jIK.startLoad(this.jIN.getShareSourceIcon(), 17, false);
        this.jly.setText(this.jIN.getContent());
        this.jIM.setText("来自" + this.jIN.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.jIL.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.eSz.setTag(shareFromPBMsgData.getImageUrl());
        this.eSz.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.jIK.setVisibility(8);
        this.jly.setText(shareFromPBMsgData.getContent());
    }
}
