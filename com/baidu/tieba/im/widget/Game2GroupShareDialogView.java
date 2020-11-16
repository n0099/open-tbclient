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
    private TbImageView fsj;
    private TextView jTC;
    private EditText joP;
    private BarImageView kqN;
    private TextView kqO;
    protected TextView kqP;
    private ShareFromGameCenterMsgData kqQ;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.joP;
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
        this.kqO = (TextView) findViewById(R.id.share_title_view);
        this.joP = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.fsj = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.kqN = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.jTC = (TextView) findViewById(R.id.game_to_group_share_desc);
        ap.setViewTextColor(this.kqO, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.joP, R.color.CAM_X0105, 2);
        this.joP.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        ap.setViewTextColor(this.jTC, R.color.CAM_X0106, 1);
        this.joP.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.kqP = (TextView) findViewById(R.id.game_to_group_share);
        ap.setViewTextColor(this.kqP, R.color.CAM_X0108, 1);
        cGR();
    }

    public void cGR() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.joP != null) {
            return k.charSequence2String(this.joP.getText(), null);
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
        this.kqQ = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.kqO.setText(this.kqQ.getTitle());
        this.fsj.setTag(this.kqQ.getImageUrl());
        this.fsj.startLoad(this.kqQ.getImageUrl(), 17, false);
        this.kqN.setVisibility(0);
        this.kqN.setTag(this.kqQ.getShareSourceIcon());
        this.kqN.startLoad(this.kqQ.getShareSourceIcon(), 17, false);
        this.jTC.setText(this.kqQ.getContent());
        this.kqP.setText("来自" + this.kqQ.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.kqO.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.fsj.setTag(shareFromPBMsgData.getImageUrl());
        this.fsj.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.kqN.setVisibility(8);
        this.jTC.setText(shareFromPBMsgData.getContent());
    }
}
