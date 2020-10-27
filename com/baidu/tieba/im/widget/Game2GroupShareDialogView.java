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
    private TbImageView fng;
    private TextView jMV;
    private EditText jif;
    private BarImageView kkh;
    private TextView kki;
    protected TextView kkj;
    private ShareFromGameCenterMsgData kkk;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.jif;
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
        this.kki = (TextView) findViewById(R.id.share_title_view);
        this.jif = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.fng = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.kkh = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.jMV = (TextView) findViewById(R.id.game_to_group_share_desc);
        ap.setViewTextColor(this.kki, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.jif, R.color.cp_cont_b, 2);
        this.jif.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        ap.setViewTextColor(this.jMV, R.color.cp_cont_f, 1);
        this.jif.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.kkj = (TextView) findViewById(R.id.game_to_group_share);
        ap.setViewTextColor(this.kkj, R.color.cp_cont_c, 1);
        cEL();
    }

    public void cEL() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.jif != null) {
            return k.charSequence2String(this.jif.getText(), null);
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
        this.kkk = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.kki.setText(this.kkk.getTitle());
        this.fng.setTag(this.kkk.getImageUrl());
        this.fng.startLoad(this.kkk.getImageUrl(), 17, false);
        this.kkh.setVisibility(0);
        this.kkh.setTag(this.kkk.getShareSourceIcon());
        this.kkh.startLoad(this.kkk.getShareSourceIcon(), 17, false);
        this.jMV.setText(this.kkk.getContent());
        this.kkj.setText("来自" + this.kkk.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.kki.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.fng.setTag(shareFromPBMsgData.getImageUrl());
        this.fng.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.kkh.setVisibility(8);
        this.jMV.setText(shareFromPBMsgData.getContent());
    }
}
