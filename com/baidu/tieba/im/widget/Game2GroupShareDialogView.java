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
    private TbImageView fzX;
    private EditText jCt;
    private BarImageView kEl;
    private TextView kEm;
    protected TextView kEn;
    private ShareFromGameCenterMsgData kEo;
    private TextView khi;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.jCt;
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
        this.kEm = (TextView) findViewById(R.id.share_title_view);
        this.jCt = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.fzX = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.kEl = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.khi = (TextView) findViewById(R.id.game_to_group_share_desc);
        ap.setViewTextColor(this.kEm, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.jCt, R.color.CAM_X0105, 2);
        this.jCt.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        ap.setViewTextColor(this.khi, R.color.CAM_X0106, 1);
        this.jCt.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.kEn = (TextView) findViewById(R.id.game_to_group_share);
        ap.setViewTextColor(this.kEn, R.color.CAM_X0108, 1);
        cMh();
    }

    public void cMh() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.jCt != null) {
            return k.charSequence2String(this.jCt.getText(), null);
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
        this.kEo = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.kEm.setText(this.kEo.getTitle());
        this.fzX.setTag(this.kEo.getImageUrl());
        this.fzX.startLoad(this.kEo.getImageUrl(), 17, false);
        this.kEl.setVisibility(0);
        this.kEl.setTag(this.kEo.getShareSourceIcon());
        this.kEl.startLoad(this.kEo.getShareSourceIcon(), 17, false);
        this.khi.setText(this.kEo.getContent());
        this.kEn.setText("来自" + this.kEo.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.kEm.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("https://tieba-fe.gz.bcebos.com/yunying/tieba_logo.jpg");
        }
        this.fzX.setTag(shareFromPBMsgData.getImageUrl());
        this.fzX.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.kEl.setVisibility(8);
        this.khi.setText(shareFromPBMsgData.getContent());
    }
}
