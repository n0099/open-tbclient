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
    private LinearLayout bOb;
    private EditText fVI;
    private BarImageView gRb;
    private TextView gRc;
    protected TextView gRd;
    private ShareFromGameCenterMsgData gRe;
    private TbImageView gvZ;
    private TextView gwa;

    public EditText getChatMsgView() {
        return this.fVI;
    }

    public Game2GroupShareDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ap(context);
    }

    public Game2GroupShareDialogView(Context context) {
        super(context);
        ap(context);
    }

    private void ap(Context context) {
        LayoutInflater.from(context).inflate(R.layout.game_to_group_share_dialog, this);
        setOrientation(1);
        this.bOb = (LinearLayout) findViewById(R.id.game_to_group_share_dialog_content);
        this.gRc = (TextView) findViewById(R.id.share_title_view);
        this.fVI = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.gvZ = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.gRb = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.gwa = (TextView) findViewById(R.id.game_to_group_share_desc);
        am.f(this.gRc, R.color.cp_cont_b, 1);
        am.f(this.fVI, R.color.cp_cont_b, 2);
        this.fVI.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.f(this.gwa, R.color.cp_cont_f, 1);
        this.fVI.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.gRd = (TextView) findViewById(R.id.game_to_group_share);
        am.f(this.gRd, R.color.cp_cont_c, 1);
        btD();
    }

    public void btD() {
        this.bOb.setFocusable(true);
        this.bOb.setFocusableInTouchMode(true);
        this.bOb.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.fVI != null) {
            return k.a(this.fVI.getText(), null);
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
        this.gRe = shareFromGameCenterMsgData;
        JS();
    }

    private void JS() {
        this.gRc.setText(this.gRe.getTitle());
        this.gvZ.setTag(this.gRe.getImageUrl());
        this.gvZ.startLoad(this.gRe.getImageUrl(), 17, false);
        this.gRb.setVisibility(0);
        this.gRb.setTag(this.gRe.getShareSourceIcon());
        this.gRb.startLoad(this.gRe.getShareSourceIcon(), 17, false);
        this.gwa.setText(this.gRe.getContent());
        this.gRd.setText("来自" + this.gRe.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.gRc.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.gvZ.setTag(shareFromPBMsgData.getImageUrl());
        this.gvZ.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.gRb.setVisibility(8);
        this.gwa.setText(shareFromPBMsgData.getContent());
    }
}
