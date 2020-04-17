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
    private EditText hCe;
    private TbImageView iaU;
    private TextView iaV;
    private BarImageView iwf;
    private TextView iwg;
    protected TextView iwh;
    private ShareFromGameCenterMsgData iwi;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.hCe;
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
        this.iwg = (TextView) findViewById(R.id.share_title_view);
        this.hCe = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.iaU = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.iwf = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.iaV = (TextView) findViewById(R.id.game_to_group_share_desc);
        am.setViewTextColor(this.iwg, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.hCe, R.color.cp_cont_b, 2);
        this.hCe.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setViewTextColor(this.iaV, R.color.cp_cont_f, 1);
        this.hCe.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.iwh = (TextView) findViewById(R.id.game_to_group_share);
        am.setViewTextColor(this.iwh, R.color.cp_cont_c, 1);
        bWH();
    }

    public void bWH() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.hCe != null) {
            return k.charSequence2String(this.hCe.getText(), null);
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
        this.iwi = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.iwg.setText(this.iwi.getTitle());
        this.iaU.setTag(this.iwi.getImageUrl());
        this.iaU.startLoad(this.iwi.getImageUrl(), 17, false);
        this.iwf.setVisibility(0);
        this.iwf.setTag(this.iwi.getShareSourceIcon());
        this.iwf.startLoad(this.iwi.getShareSourceIcon(), 17, false);
        this.iaV.setText(this.iwi.getContent());
        this.iwh.setText("来自" + this.iwi.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.iwg.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.iaU.setTag(shareFromPBMsgData.getImageUrl());
        this.iaU.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.iwf.setVisibility(8);
        this.iaV.setText(shareFromPBMsgData.getContent());
    }
}
