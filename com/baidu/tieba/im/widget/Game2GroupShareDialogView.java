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
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class Game2GroupShareDialogView extends LinearLayout {
    private LinearLayout axD;
    private TextView dKF;
    private EditText dKn;
    private BarImageView eCU;
    private TextView eCV;
    protected TextView eCW;
    private ShareFromGameCenterMsgData eCX;
    private TbImageView ehK;

    public EditText getChatMsgView() {
        return this.dKn;
    }

    public Game2GroupShareDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        by(context);
    }

    public Game2GroupShareDialogView(Context context) {
        super(context);
        by(context);
    }

    private void by(Context context) {
        LayoutInflater.from(context).inflate(f.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.axD = (LinearLayout) findViewById(f.g.game_to_group_share_dialog_content);
        this.eCV = (TextView) findViewById(f.g.share_title_view);
        this.dKn = (EditText) findViewById(f.g.game_to_group_share_chat_msg);
        this.ehK = (TbImageView) findViewById(f.g.game_to_group_share_img);
        this.eCU = (BarImageView) findViewById(f.g.game_to_group_share_icon);
        this.dKF = (TextView) findViewById(f.g.game_to_group_share_desc);
        am.c(this.eCV, f.d.cp_cont_b, 1);
        am.c(this.dKn, f.d.cp_cont_b, 2);
        this.dKn.setHintTextColor(am.getColor(f.d.cp_cont_e));
        am.c(this.dKF, f.d.cp_cont_f, 1);
        this.dKn.setPadding(context.getResources().getDimensionPixelSize(f.e.ds20), 0, 0, 0);
        this.eCW = (TextView) findViewById(f.g.game_to_group_share);
        am.c(this.eCW, f.d.cp_cont_c, 1);
        aBl();
    }

    public void aBl() {
        this.axD.setFocusable(true);
        this.axD.setFocusableInTouchMode(true);
        this.axD.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dKn != null) {
            return k.a(this.dKn.getText(), null);
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
        this.eCX = shareFromGameCenterMsgData;
        Ap();
    }

    private void Ap() {
        this.eCV.setText(this.eCX.getTitle());
        this.ehK.setTag(this.eCX.getImageUrl());
        this.ehK.startLoad(this.eCX.getImageUrl(), 17, false);
        this.eCU.setVisibility(0);
        this.eCU.setTag(this.eCX.getShareSourceIcon());
        this.eCU.startLoad(this.eCX.getShareSourceIcon(), 17, false);
        this.dKF.setText(this.eCX.getContent());
        this.eCW.setText("来自" + this.eCX.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.eCV.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.ehK.setTag(shareFromPBMsgData.getImageUrl());
        this.ehK.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.eCU.setVisibility(8);
        this.dKF.setText(shareFromPBMsgData.getContent());
    }
}
