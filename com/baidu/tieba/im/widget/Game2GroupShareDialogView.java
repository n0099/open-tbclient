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
    private EditText hQX;
    private BarImageView iKR;
    private TextView iKS;
    protected TextView iKT;
    private ShareFromGameCenterMsgData iKU;
    private TbImageView ipN;
    private TextView ipO;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.hQX;
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
        this.iKS = (TextView) findViewById(R.id.share_title_view);
        this.hQX = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.ipN = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.iKR = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.ipO = (TextView) findViewById(R.id.game_to_group_share_desc);
        am.setViewTextColor(this.iKS, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.hQX, R.color.cp_cont_b, 2);
        this.hQX.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setViewTextColor(this.ipO, R.color.cp_cont_f, 1);
        this.hQX.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.iKT = (TextView) findViewById(R.id.game_to_group_share);
        am.setViewTextColor(this.iKT, R.color.cp_cont_c, 1);
        cde();
    }

    public void cde() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.hQX != null) {
            return k.charSequence2String(this.hQX.getText(), null);
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
        this.iKU = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.iKS.setText(this.iKU.getTitle());
        this.ipN.setTag(this.iKU.getImageUrl());
        this.ipN.startLoad(this.iKU.getImageUrl(), 17, false);
        this.iKR.setVisibility(0);
        this.iKR.setTag(this.iKU.getShareSourceIcon());
        this.iKR.startLoad(this.iKU.getShareSourceIcon(), 17, false);
        this.ipO.setText(this.iKU.getContent());
        this.iKT.setText("来自" + this.iKU.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.iKS.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.ipN.setTag(shareFromPBMsgData.getImageUrl());
        this.ipN.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.iKR.setVisibility(8);
        this.ipO.setText(shareFromPBMsgData.getContent());
    }
}
