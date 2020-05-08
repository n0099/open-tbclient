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
    private EditText hCk;
    private TbImageView iba;
    private TextView ibb;
    private BarImageView iwl;
    private TextView iwm;
    protected TextView iwn;
    private ShareFromGameCenterMsgData iwo;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.hCk;
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
        this.iwm = (TextView) findViewById(R.id.share_title_view);
        this.hCk = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.iba = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.iwl = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.ibb = (TextView) findViewById(R.id.game_to_group_share_desc);
        am.setViewTextColor(this.iwm, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.hCk, R.color.cp_cont_b, 2);
        this.hCk.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setViewTextColor(this.ibb, R.color.cp_cont_f, 1);
        this.hCk.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.iwn = (TextView) findViewById(R.id.game_to_group_share);
        am.setViewTextColor(this.iwn, R.color.cp_cont_c, 1);
        bWF();
    }

    public void bWF() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.hCk != null) {
            return k.charSequence2String(this.hCk.getText(), null);
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
        this.iwo = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.iwm.setText(this.iwo.getTitle());
        this.iba.setTag(this.iwo.getImageUrl());
        this.iba.startLoad(this.iwo.getImageUrl(), 17, false);
        this.iwl.setVisibility(0);
        this.iwl.setTag(this.iwo.getShareSourceIcon());
        this.iwl.startLoad(this.iwo.getShareSourceIcon(), 17, false);
        this.ibb.setText(this.iwo.getContent());
        this.iwn.setText("来自" + this.iwo.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.iwm.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.iba.setTag(shareFromPBMsgData.getImageUrl());
        this.iba.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.iwl.setVisibility(8);
        this.ibb.setText(shareFromPBMsgData.getContent());
    }
}
