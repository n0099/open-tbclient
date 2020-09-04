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
    private TbImageView ePI;
    private EditText izx;
    private BarImageView jAi;
    private TextView jAj;
    protected TextView jAk;
    private ShareFromGameCenterMsgData jAl;
    private TextView jcS;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.izx;
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
        this.jAj = (TextView) findViewById(R.id.share_title_view);
        this.izx = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.ePI = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.jAi = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.jcS = (TextView) findViewById(R.id.game_to_group_share_desc);
        ap.setViewTextColor(this.jAj, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.izx, R.color.cp_cont_b, 2);
        this.izx.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        ap.setViewTextColor(this.jcS, R.color.cp_cont_f, 1);
        this.izx.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.jAk = (TextView) findViewById(R.id.game_to_group_share);
        ap.setViewTextColor(this.jAk, R.color.cp_cont_c, 1);
        cuO();
    }

    public void cuO() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.izx != null) {
            return k.charSequence2String(this.izx.getText(), null);
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
        this.jAl = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.jAj.setText(this.jAl.getTitle());
        this.ePI.setTag(this.jAl.getImageUrl());
        this.ePI.startLoad(this.jAl.getImageUrl(), 17, false);
        this.jAi.setVisibility(0);
        this.jAi.setTag(this.jAl.getShareSourceIcon());
        this.jAi.startLoad(this.jAl.getShareSourceIcon(), 17, false);
        this.jcS.setText(this.jAl.getContent());
        this.jAk.setText("来自" + this.jAl.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.jAj.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.ePI.setTag(shareFromPBMsgData.getImageUrl());
        this.ePI.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.jAi.setVisibility(8);
        this.jcS.setText(shareFromPBMsgData.getContent());
    }
}
