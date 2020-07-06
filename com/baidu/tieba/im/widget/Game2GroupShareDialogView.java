package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class Game2GroupShareDialogView extends LinearLayout {
    private TbImageView iHH;
    private TextView iHI;
    private EditText ifm;
    private BarImageView jcG;
    private TextView jcH;
    protected TextView jcI;
    private ShareFromGameCenterMsgData jcJ;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.ifm;
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
        this.jcH = (TextView) findViewById(R.id.share_title_view);
        this.ifm = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.iHH = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.jcG = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.iHI = (TextView) findViewById(R.id.game_to_group_share_desc);
        an.setViewTextColor(this.jcH, R.color.cp_cont_b, 1);
        an.setViewTextColor(this.ifm, R.color.cp_cont_b, 2);
        this.ifm.setHintTextColor(an.getColor(R.color.cp_cont_e));
        an.setViewTextColor(this.iHI, R.color.cp_cont_f, 1);
        this.ifm.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.jcI = (TextView) findViewById(R.id.game_to_group_share);
        an.setViewTextColor(this.jcI, R.color.cp_cont_c, 1);
        cgK();
    }

    public void cgK() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.ifm != null) {
            return k.charSequence2String(this.ifm.getText(), null);
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
        this.jcJ = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.jcH.setText(this.jcJ.getTitle());
        this.iHH.setTag(this.jcJ.getImageUrl());
        this.iHH.startLoad(this.jcJ.getImageUrl(), 17, false);
        this.jcG.setVisibility(0);
        this.jcG.setTag(this.jcJ.getShareSourceIcon());
        this.jcG.startLoad(this.jcJ.getShareSourceIcon(), 17, false);
        this.iHI.setText(this.jcJ.getContent());
        this.jcI.setText("来自" + this.jcJ.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.jcH.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.iHH.setTag(shareFromPBMsgData.getImageUrl());
        this.iHH.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.jcG.setVisibility(8);
        this.iHI.setText(shareFromPBMsgData.getContent());
    }
}
