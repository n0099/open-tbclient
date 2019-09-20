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
    private LinearLayout bOF;
    private EditText fYp;
    private BarImageView gTM;
    private TextView gTN;
    protected TextView gTO;
    private ShareFromGameCenterMsgData gTP;
    private TbImageView gyI;
    private TextView gyJ;

    public EditText getChatMsgView() {
        return this.fYp;
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
        this.bOF = (LinearLayout) findViewById(R.id.game_to_group_share_dialog_content);
        this.gTN = (TextView) findViewById(R.id.share_title_view);
        this.fYp = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.gyI = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.gTM = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.gyJ = (TextView) findViewById(R.id.game_to_group_share_desc);
        am.f(this.gTN, R.color.cp_cont_b, 1);
        am.f(this.fYp, R.color.cp_cont_b, 2);
        this.fYp.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.f(this.gyJ, R.color.cp_cont_f, 1);
        this.fYp.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.gTO = (TextView) findViewById(R.id.game_to_group_share);
        am.f(this.gTO, R.color.cp_cont_c, 1);
        buE();
    }

    public void buE() {
        this.bOF.setFocusable(true);
        this.bOF.setFocusableInTouchMode(true);
        this.bOF.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.fYp != null) {
            return k.a(this.fYp.getText(), null);
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
        this.gTP = shareFromGameCenterMsgData;
        JW();
    }

    private void JW() {
        this.gTN.setText(this.gTP.getTitle());
        this.gyI.setTag(this.gTP.getImageUrl());
        this.gyI.startLoad(this.gTP.getImageUrl(), 17, false);
        this.gTM.setVisibility(0);
        this.gTM.setTag(this.gTP.getShareSourceIcon());
        this.gTM.startLoad(this.gTP.getShareSourceIcon(), 17, false);
        this.gyJ.setText(this.gTP.getContent());
        this.gTO.setText("来自" + this.gTP.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.gTN.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.gyI.setTag(shareFromPBMsgData.getImageUrl());
        this.gyI.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.gTM.setVisibility(8);
        this.gyJ.setText(shareFromPBMsgData.getContent());
    }
}
