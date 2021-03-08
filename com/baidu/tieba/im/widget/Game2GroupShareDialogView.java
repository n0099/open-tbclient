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
    private TbImageView fIH;
    private EditText jTj;
    private TextView kAm;
    private BarImageView kPk;
    private TextView kPl;
    protected TextView kPm;
    private ShareFromGameCenterMsgData kPn;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.jTj;
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
        this.kPl = (TextView) findViewById(R.id.share_title_view);
        this.jTj = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.fIH = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.kPk = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.kAm = (TextView) findViewById(R.id.game_to_group_share_desc);
        ap.setViewTextColor(this.kPl, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.jTj, R.color.CAM_X0105, 2);
        this.jTj.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        ap.setViewTextColor(this.kAm, R.color.CAM_X0106, 1);
        this.jTj.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.kPm = (TextView) findViewById(R.id.game_to_group_share);
        ap.setViewTextColor(this.kPm, R.color.CAM_X0108, 1);
        cNu();
    }

    public void cNu() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.jTj != null) {
            return k.charSequence2String(this.jTj.getText(), null);
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
        this.kPn = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.kPl.setText(this.kPn.getTitle());
        this.fIH.setTag(this.kPn.getImageUrl());
        this.fIH.startLoad(this.kPn.getImageUrl(), 17, false);
        this.kPk.setVisibility(0);
        this.kPk.setTag(this.kPn.getShareSourceIcon());
        this.kPk.startLoad(this.kPn.getShareSourceIcon(), 17, false);
        this.kAm.setText(this.kPn.getContent());
        this.kPm.setText("来自" + this.kPn.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.kPl.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("https://tieba-fe.gz.bcebos.com/yunying/tieba_logo.jpg");
        }
        this.fIH.setTag(shareFromPBMsgData.getImageUrl());
        this.fIH.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.kPk.setVisibility(8);
        this.kAm.setText(shareFromPBMsgData.getContent());
    }
}
