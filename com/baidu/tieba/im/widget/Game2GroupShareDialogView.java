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
    private EditText jRA;
    private BarImageView kNi;
    private TextView kNj;
    protected TextView kNk;
    private ShareFromGameCenterMsgData kNl;
    private TextView kyk;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.jRA;
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
        this.kNj = (TextView) findViewById(R.id.share_title_view);
        this.jRA = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.fHi = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.kNi = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.kyk = (TextView) findViewById(R.id.game_to_group_share_desc);
        ap.setViewTextColor(this.kNj, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.jRA, R.color.CAM_X0105, 2);
        this.jRA.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        ap.setViewTextColor(this.kyk, R.color.CAM_X0106, 1);
        this.jRA.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.kNk = (TextView) findViewById(R.id.game_to_group_share);
        ap.setViewTextColor(this.kNk, R.color.CAM_X0108, 1);
        cNo();
    }

    public void cNo() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.jRA != null) {
            return k.charSequence2String(this.jRA.getText(), null);
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
        this.kNl = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.kNj.setText(this.kNl.getTitle());
        this.fHi.setTag(this.kNl.getImageUrl());
        this.fHi.startLoad(this.kNl.getImageUrl(), 17, false);
        this.kNi.setVisibility(0);
        this.kNi.setTag(this.kNl.getShareSourceIcon());
        this.kNi.startLoad(this.kNl.getShareSourceIcon(), 17, false);
        this.kyk.setText(this.kNl.getContent());
        this.kNk.setText("来自" + this.kNl.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.kNj.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("https://tieba-fe.gz.bcebos.com/yunying/tieba_logo.jpg");
        }
        this.fHi.setTag(shareFromPBMsgData.getImageUrl());
        this.fHi.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.kNi.setVisibility(8);
        this.kyk.setText(shareFromPBMsgData.getContent());
    }
}
