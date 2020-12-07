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
    private EditText jCr;
    private BarImageView kEj;
    private TextView kEk;
    protected TextView kEl;
    private ShareFromGameCenterMsgData kEm;
    private TextView khg;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.jCr;
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
        this.kEk = (TextView) findViewById(R.id.share_title_view);
        this.jCr = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.fzX = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.kEj = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.khg = (TextView) findViewById(R.id.game_to_group_share_desc);
        ap.setViewTextColor(this.kEk, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.jCr, R.color.CAM_X0105, 2);
        this.jCr.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        ap.setViewTextColor(this.khg, R.color.CAM_X0106, 1);
        this.jCr.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.kEl = (TextView) findViewById(R.id.game_to_group_share);
        ap.setViewTextColor(this.kEl, R.color.CAM_X0108, 1);
        cMg();
    }

    public void cMg() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.jCr != null) {
            return k.charSequence2String(this.jCr.getText(), null);
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
        this.kEm = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.kEk.setText(this.kEm.getTitle());
        this.fzX.setTag(this.kEm.getImageUrl());
        this.fzX.startLoad(this.kEm.getImageUrl(), 17, false);
        this.kEj.setVisibility(0);
        this.kEj.setTag(this.kEm.getShareSourceIcon());
        this.kEj.startLoad(this.kEm.getShareSourceIcon(), 17, false);
        this.khg.setText(this.kEm.getContent());
        this.kEl.setText("来自" + this.kEm.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.kEk.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("https://tieba-fe.gz.bcebos.com/yunying/tieba_logo.jpg");
        }
        this.fzX.setTag(shareFromPBMsgData.getImageUrl());
        this.fzX.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.kEj.setVisibility(8);
        this.khg.setText(shareFromPBMsgData.getContent());
    }
}
