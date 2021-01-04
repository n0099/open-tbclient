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
    private TbImageView fJD;
    private EditText jOV;
    private BarImageView kJu;
    private TextView kJv;
    protected TextView kJw;
    private ShareFromGameCenterMsgData kJx;
    private TextView kuu;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.jOV;
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
        this.kJv = (TextView) findViewById(R.id.share_title_view);
        this.jOV = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.fJD = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.kJu = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.kuu = (TextView) findViewById(R.id.game_to_group_share_desc);
        ao.setViewTextColor(this.kJv, R.color.CAM_X0105, 1);
        ao.setViewTextColor(this.jOV, R.color.CAM_X0105, 2);
        this.jOV.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        ao.setViewTextColor(this.kuu, R.color.CAM_X0106, 1);
        this.jOV.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.kJw = (TextView) findViewById(R.id.game_to_group_share);
        ao.setViewTextColor(this.kJw, R.color.CAM_X0108, 1);
        cPk();
    }

    public void cPk() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.jOV != null) {
            return k.charSequence2String(this.jOV.getText(), null);
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
        this.kJx = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.kJv.setText(this.kJx.getTitle());
        this.fJD.setTag(this.kJx.getImageUrl());
        this.fJD.startLoad(this.kJx.getImageUrl(), 17, false);
        this.kJu.setVisibility(0);
        this.kJu.setTag(this.kJx.getShareSourceIcon());
        this.kJu.startLoad(this.kJx.getShareSourceIcon(), 17, false);
        this.kuu.setText(this.kJx.getContent());
        this.kJw.setText("来自" + this.kJx.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.kJv.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("https://tieba-fe.gz.bcebos.com/yunying/tieba_logo.jpg");
        }
        this.fJD.setTag(shareFromPBMsgData.getImageUrl());
        this.fJD.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.kJu.setVisibility(8);
        this.kuu.setText(shareFromPBMsgData.getContent());
    }
}
