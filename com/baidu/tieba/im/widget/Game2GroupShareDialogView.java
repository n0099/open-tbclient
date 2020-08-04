package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class Game2GroupShareDialogView extends LinearLayout {
    private TbImageView iNO;
    private TextView iNP;
    private EditText ilo;
    private BarImageView jld;
    private TextView jle;
    protected TextView jlf;
    private ShareFromGameCenterMsgData jlg;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.ilo;
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
        this.jle = (TextView) findViewById(R.id.share_title_view);
        this.ilo = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.iNO = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.jld = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.iNP = (TextView) findViewById(R.id.game_to_group_share_desc);
        ao.setViewTextColor(this.jle, R.color.cp_cont_b, 1);
        ao.setViewTextColor(this.ilo, R.color.cp_cont_b, 2);
        this.ilo.setHintTextColor(ao.getColor(R.color.cp_cont_e));
        ao.setViewTextColor(this.iNP, R.color.cp_cont_f, 1);
        this.ilo.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.jlf = (TextView) findViewById(R.id.game_to_group_share);
        ao.setViewTextColor(this.jlf, R.color.cp_cont_c, 1);
        ckj();
    }

    public void ckj() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.ilo != null) {
            return k.charSequence2String(this.ilo.getText(), null);
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
        this.jlg = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.jle.setText(this.jlg.getTitle());
        this.iNO.setTag(this.jlg.getImageUrl());
        this.iNO.startLoad(this.jlg.getImageUrl(), 17, false);
        this.jld.setVisibility(0);
        this.jld.setTag(this.jlg.getShareSourceIcon());
        this.jld.startLoad(this.jlg.getShareSourceIcon(), 17, false);
        this.iNP.setText(this.jlg.getContent());
        this.jlf.setText("来自" + this.jlg.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.jle.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.iNO.setTag(shareFromPBMsgData.getImageUrl());
        this.iNO.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.jld.setVisibility(8);
        this.iNP.setText(shareFromPBMsgData.getContent());
    }
}
