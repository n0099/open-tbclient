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
    private TbImageView fsZ;
    private TextView jSS;
    private EditText jod;
    private BarImageView kqd;
    private TextView kqe;
    protected TextView kqf;
    private ShareFromGameCenterMsgData kqg;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.jod;
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
        this.kqe = (TextView) findViewById(R.id.share_title_view);
        this.jod = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.fsZ = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.kqd = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.jSS = (TextView) findViewById(R.id.game_to_group_share_desc);
        ap.setViewTextColor(this.kqe, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.jod, R.color.cp_cont_b, 2);
        this.jod.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        ap.setViewTextColor(this.jSS, R.color.cp_cont_f, 1);
        this.jod.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.kqf = (TextView) findViewById(R.id.game_to_group_share);
        ap.setViewTextColor(this.kqf, R.color.cp_cont_c, 1);
        cHm();
    }

    public void cHm() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.jod != null) {
            return k.charSequence2String(this.jod.getText(), null);
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
        this.kqg = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.kqe.setText(this.kqg.getTitle());
        this.fsZ.setTag(this.kqg.getImageUrl());
        this.fsZ.startLoad(this.kqg.getImageUrl(), 17, false);
        this.kqd.setVisibility(0);
        this.kqd.setTag(this.kqg.getShareSourceIcon());
        this.kqd.startLoad(this.kqg.getShareSourceIcon(), 17, false);
        this.jSS.setText(this.kqg.getContent());
        this.kqf.setText("来自" + this.kqg.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.kqe.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.fsZ.setTag(shareFromPBMsgData.getImageUrl());
        this.fsZ.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.kqd.setVisibility(8);
        this.jSS.setText(shareFromPBMsgData.getContent());
    }
}
