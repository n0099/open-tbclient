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
/* loaded from: classes2.dex */
public class Game2GroupShareDialogView extends LinearLayout {
    private TbImageView ePE;
    private EditText izr;
    private BarImageView jAc;
    private TextView jAd;
    protected TextView jAe;
    private ShareFromGameCenterMsgData jAf;
    private TextView jcM;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.izr;
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
        this.jAd = (TextView) findViewById(R.id.share_title_view);
        this.izr = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.ePE = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.jAc = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.jcM = (TextView) findViewById(R.id.game_to_group_share_desc);
        ap.setViewTextColor(this.jAd, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.izr, R.color.cp_cont_b, 2);
        this.izr.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        ap.setViewTextColor(this.jcM, R.color.cp_cont_f, 1);
        this.izr.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.jAe = (TextView) findViewById(R.id.game_to_group_share);
        ap.setViewTextColor(this.jAe, R.color.cp_cont_c, 1);
        cuN();
    }

    public void cuN() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.izr != null) {
            return k.charSequence2String(this.izr.getText(), null);
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
        this.jAf = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.jAd.setText(this.jAf.getTitle());
        this.ePE.setTag(this.jAf.getImageUrl());
        this.ePE.startLoad(this.jAf.getImageUrl(), 17, false);
        this.jAc.setVisibility(0);
        this.jAc.setTag(this.jAf.getShareSourceIcon());
        this.jAc.startLoad(this.jAf.getShareSourceIcon(), 17, false);
        this.jcM.setText(this.jAf.getContent());
        this.jAe.setText("来自" + this.jAf.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.jAd.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.ePE.setTag(shareFromPBMsgData.getImageUrl());
        this.ePE.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.jAc.setVisibility(8);
        this.jcM.setText(shareFromPBMsgData.getContent());
    }
}
