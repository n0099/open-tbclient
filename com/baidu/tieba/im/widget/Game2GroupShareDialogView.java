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
    private EditText gOI;
    private BarImageView hIC;
    private TextView hID;
    protected TextView hIE;
    private ShareFromGameCenterMsgData hIF;
    private TbImageView hnx;
    private TextView hny;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.gOI;
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
        this.hID = (TextView) findViewById(R.id.share_title_view);
        this.gOI = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.hnx = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.hIC = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.hny = (TextView) findViewById(R.id.game_to_group_share_desc);
        am.setViewTextColor(this.hID, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.gOI, R.color.cp_cont_b, 2);
        this.gOI.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.setViewTextColor(this.hny, R.color.cp_cont_f, 1);
        this.gOI.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.hIE = (TextView) findViewById(R.id.game_to_group_share);
        am.setViewTextColor(this.hIE, R.color.cp_cont_c, 1);
        bKi();
    }

    public void bKi() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.gOI != null) {
            return k.charSequence2String(this.gOI.getText(), null);
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
        this.hIF = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.hID.setText(this.hIF.getTitle());
        this.hnx.setTag(this.hIF.getImageUrl());
        this.hnx.startLoad(this.hIF.getImageUrl(), 17, false);
        this.hIC.setVisibility(0);
        this.hIC.setTag(this.hIF.getShareSourceIcon());
        this.hIC.startLoad(this.hIF.getShareSourceIcon(), 17, false);
        this.hny.setText(this.hIF.getContent());
        this.hIE.setText("来自" + this.hIF.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.hID.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.hnx.setTag(shareFromPBMsgData.getImageUrl());
        this.hnx.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.hIC.setVisibility(8);
        this.hny.setText(shareFromPBMsgData.getContent());
    }
}
