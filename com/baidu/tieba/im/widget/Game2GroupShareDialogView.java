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
    private EditText gQI;
    private BarImageView hKB;
    private TextView hKC;
    protected TextView hKD;
    private ShareFromGameCenterMsgData hKE;
    private TbImageView hpx;
    private TextView hpy;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.gQI;
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
        this.hKC = (TextView) findViewById(R.id.share_title_view);
        this.gQI = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.hpx = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.hKB = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.hpy = (TextView) findViewById(R.id.game_to_group_share_desc);
        am.setViewTextColor(this.hKC, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.gQI, R.color.cp_cont_b, 2);
        this.gQI.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setViewTextColor(this.hpy, R.color.cp_cont_f, 1);
        this.gQI.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.hKD = (TextView) findViewById(R.id.game_to_group_share);
        am.setViewTextColor(this.hKD, R.color.cp_cont_c, 1);
        bLK();
    }

    public void bLK() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.gQI != null) {
            return k.charSequence2String(this.gQI.getText(), null);
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
        this.hKE = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.hKC.setText(this.hKE.getTitle());
        this.hpx.setTag(this.hKE.getImageUrl());
        this.hpx.startLoad(this.hKE.getImageUrl(), 17, false);
        this.hKB.setVisibility(0);
        this.hKB.setTag(this.hKE.getShareSourceIcon());
        this.hKB.startLoad(this.hKE.getShareSourceIcon(), 17, false);
        this.hpy.setText(this.hKE.getContent());
        this.hKD.setText("来自" + this.hKE.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.hKC.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.hpx.setTag(shareFromPBMsgData.getImageUrl());
        this.hpx.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.hKB.setVisibility(8);
        this.hpy.setText(shareFromPBMsgData.getContent());
    }
}
