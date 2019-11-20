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
    private EditText fWT;
    private BarImageView gQV;
    private TextView gQW;
    protected TextView gQX;
    private ShareFromGameCenterMsgData gQY;
    private TbImageView gvO;
    private TextView gvP;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.fWT;
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
        this.gQW = (TextView) findViewById(R.id.share_title_view);
        this.fWT = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.gvO = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.gQV = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.gvP = (TextView) findViewById(R.id.game_to_group_share_desc);
        am.setViewTextColor(this.gQW, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.fWT, R.color.cp_cont_b, 2);
        this.fWT.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setViewTextColor(this.gvP, R.color.cp_cont_f, 1);
        this.fWT.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.gQX = (TextView) findViewById(R.id.game_to_group_share);
        am.setViewTextColor(this.gQX, R.color.cp_cont_c, 1);
        brE();
    }

    public void brE() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.fWT != null) {
            return k.charSequence2String(this.fWT.getText(), null);
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
        this.gQY = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.gQW.setText(this.gQY.getTitle());
        this.gvO.setTag(this.gQY.getImageUrl());
        this.gvO.startLoad(this.gQY.getImageUrl(), 17, false);
        this.gQV.setVisibility(0);
        this.gQV.setTag(this.gQY.getShareSourceIcon());
        this.gQV.startLoad(this.gQY.getShareSourceIcon(), 17, false);
        this.gvP.setText(this.gQY.getContent());
        this.gQX.setText("来自" + this.gQY.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.gQW.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.gvO.setTag(shareFromPBMsgData.getImageUrl());
        this.gvO.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.gQV.setVisibility(8);
        this.gvP.setText(shareFromPBMsgData.getContent());
    }
}
