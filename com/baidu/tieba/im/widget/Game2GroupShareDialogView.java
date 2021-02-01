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
    private TbImageView fHi;
    private EditText jRm;
    private BarImageView kMU;
    private TextView kMV;
    protected TextView kMW;
    private ShareFromGameCenterMsgData kMX;
    private TextView kxW;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.jRm;
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
        this.kMV = (TextView) findViewById(R.id.share_title_view);
        this.jRm = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.fHi = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.kMU = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.kxW = (TextView) findViewById(R.id.game_to_group_share_desc);
        ap.setViewTextColor(this.kMV, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.jRm, R.color.CAM_X0105, 2);
        this.jRm.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        ap.setViewTextColor(this.kxW, R.color.CAM_X0106, 1);
        this.jRm.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.kMW = (TextView) findViewById(R.id.game_to_group_share);
        ap.setViewTextColor(this.kMW, R.color.CAM_X0108, 1);
        cNh();
    }

    public void cNh() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.jRm != null) {
            return k.charSequence2String(this.jRm.getText(), null);
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
        this.kMX = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.kMV.setText(this.kMX.getTitle());
        this.fHi.setTag(this.kMX.getImageUrl());
        this.fHi.startLoad(this.kMX.getImageUrl(), 17, false);
        this.kMU.setVisibility(0);
        this.kMU.setTag(this.kMX.getShareSourceIcon());
        this.kMU.startLoad(this.kMX.getShareSourceIcon(), 17, false);
        this.kxW.setText(this.kMX.getContent());
        this.kMW.setText("来自" + this.kMX.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.kMV.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("https://tieba-fe.gz.bcebos.com/yunying/tieba_logo.jpg");
        }
        this.fHi.setTag(shareFromPBMsgData.getImageUrl());
        this.fHi.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.kMU.setVisibility(8);
        this.kxW.setText(shareFromPBMsgData.getContent());
    }
}
