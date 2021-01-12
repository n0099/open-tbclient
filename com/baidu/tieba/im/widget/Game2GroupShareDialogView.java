package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class Game2GroupShareDialogView extends LinearLayout {
    private TbImageView fEW;
    private EditText jKp;
    private BarImageView kEP;
    private TextView kEQ;
    protected TextView kER;
    private ShareFromGameCenterMsgData kES;
    private TextView kpP;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.jKp;
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
        this.kEQ = (TextView) findViewById(R.id.share_title_view);
        this.jKp = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.fEW = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.kEP = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.kpP = (TextView) findViewById(R.id.game_to_group_share_desc);
        ao.setViewTextColor(this.kEQ, R.color.CAM_X0105, 1);
        ao.setViewTextColor(this.jKp, R.color.CAM_X0105, 2);
        this.jKp.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        ao.setViewTextColor(this.kpP, R.color.CAM_X0106, 1);
        this.jKp.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.kER = (TextView) findViewById(R.id.game_to_group_share);
        ao.setViewTextColor(this.kER, R.color.CAM_X0108, 1);
        cLt();
    }

    public void cLt() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.jKp != null) {
            return k.charSequence2String(this.jKp.getText(), null);
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
        this.kES = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.kEQ.setText(this.kES.getTitle());
        this.fEW.setTag(this.kES.getImageUrl());
        this.fEW.startLoad(this.kES.getImageUrl(), 17, false);
        this.kEP.setVisibility(0);
        this.kEP.setTag(this.kES.getShareSourceIcon());
        this.kEP.startLoad(this.kES.getShareSourceIcon(), 17, false);
        this.kpP.setText(this.kES.getContent());
        this.kER.setText("来自" + this.kES.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.kEQ.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("https://tieba-fe.gz.bcebos.com/yunying/tieba_logo.jpg");
        }
        this.fEW.setTag(shareFromPBMsgData.getImageUrl());
        this.fEW.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.kEP.setVisibility(8);
        this.kpP.setText(shareFromPBMsgData.getContent());
    }
}
