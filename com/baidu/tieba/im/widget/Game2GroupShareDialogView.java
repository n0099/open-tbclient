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
    private EditText gLu;
    private BarImageView hEZ;
    private TextView hFa;
    protected TextView hFb;
    private ShareFromGameCenterMsgData hFc;
    private TbImageView hjU;
    private TextView hjV;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.gLu;
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
        this.hFa = (TextView) findViewById(R.id.share_title_view);
        this.gLu = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.hjU = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.hEZ = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.hjV = (TextView) findViewById(R.id.game_to_group_share_desc);
        am.setViewTextColor(this.hFa, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.gLu, R.color.cp_cont_b, 2);
        this.gLu.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setViewTextColor(this.hjV, R.color.cp_cont_f, 1);
        this.gLu.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.hFb = (TextView) findViewById(R.id.game_to_group_share);
        am.setViewTextColor(this.hFb, R.color.cp_cont_c, 1);
        bJg();
    }

    public void bJg() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.gLu != null) {
            return k.charSequence2String(this.gLu.getText(), null);
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
        this.hFc = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.hFa.setText(this.hFc.getTitle());
        this.hjU.setTag(this.hFc.getImageUrl());
        this.hjU.startLoad(this.hFc.getImageUrl(), 17, false);
        this.hEZ.setVisibility(0);
        this.hEZ.setTag(this.hFc.getShareSourceIcon());
        this.hEZ.startLoad(this.hFc.getShareSourceIcon(), 17, false);
        this.hjV.setText(this.hFc.getContent());
        this.hFb.setText("来自" + this.hFc.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.hFa.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.hjU.setTag(shareFromPBMsgData.getImageUrl());
        this.hjU.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.hEZ.setVisibility(8);
        this.hjV.setText(shareFromPBMsgData.getContent());
    }
}
