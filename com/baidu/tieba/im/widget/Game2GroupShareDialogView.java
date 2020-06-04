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
    private EditText hRK;
    private BarImageView iLE;
    private TextView iLF;
    protected TextView iLG;
    private ShareFromGameCenterMsgData iLH;
    private TbImageView iqA;
    private TextView iqB;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.hRK;
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
        this.iLF = (TextView) findViewById(R.id.share_title_view);
        this.hRK = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.iqA = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.iLE = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.iqB = (TextView) findViewById(R.id.game_to_group_share_desc);
        am.setViewTextColor(this.iLF, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.hRK, R.color.cp_cont_b, 2);
        this.hRK.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setViewTextColor(this.iqB, R.color.cp_cont_f, 1);
        this.hRK.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.iLG = (TextView) findViewById(R.id.game_to_group_share);
        am.setViewTextColor(this.iLG, R.color.cp_cont_c, 1);
        cdm();
    }

    public void cdm() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.hRK != null) {
            return k.charSequence2String(this.hRK.getText(), null);
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
        this.iLH = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.iLF.setText(this.iLH.getTitle());
        this.iqA.setTag(this.iLH.getImageUrl());
        this.iqA.startLoad(this.iLH.getImageUrl(), 17, false);
        this.iLE.setVisibility(0);
        this.iLE.setTag(this.iLH.getShareSourceIcon());
        this.iLE.startLoad(this.iLH.getShareSourceIcon(), 17, false);
        this.iqB.setText(this.iLH.getContent());
        this.iLG.setText("来自" + this.iLH.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.iLF.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.iqA.setTag(shareFromPBMsgData.getImageUrl());
        this.iqA.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.iLE.setVisibility(8);
        this.iqB.setText(shareFromPBMsgData.getContent());
    }
}
