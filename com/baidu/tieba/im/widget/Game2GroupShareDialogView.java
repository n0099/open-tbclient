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
    private LinearLayout bOg;
    private EditText fWy;
    private BarImageView gRT;
    private TextView gRU;
    protected TextView gRV;
    private ShareFromGameCenterMsgData gRW;
    private TbImageView gwR;
    private TextView gwS;

    public EditText getChatMsgView() {
        return this.fWy;
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
        this.bOg = (LinearLayout) findViewById(R.id.game_to_group_share_dialog_content);
        this.gRU = (TextView) findViewById(R.id.share_title_view);
        this.fWy = (EditText) findViewById(R.id.game_to_group_share_chat_msg);
        this.gwR = (TbImageView) findViewById(R.id.game_to_group_share_img);
        this.gRT = (BarImageView) findViewById(R.id.game_to_group_share_icon);
        this.gwS = (TextView) findViewById(R.id.game_to_group_share_desc);
        am.f(this.gRU, R.color.cp_cont_b, 1);
        am.f(this.fWy, R.color.cp_cont_b, 2);
        this.fWy.setHintTextColor(am.getColor(R.color.cp_cont_e));
        am.f(this.gwS, R.color.cp_cont_f, 1);
        this.fWy.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        this.gRV = (TextView) findViewById(R.id.game_to_group_share);
        am.f(this.gRV, R.color.cp_cont_c, 1);
        btQ();
    }

    public void btQ() {
        this.bOg.setFocusable(true);
        this.bOg.setFocusableInTouchMode(true);
        this.bOg.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.fWy != null) {
            return k.a(this.fWy.getText(), null);
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
        this.gRW = shareFromGameCenterMsgData;
        JS();
    }

    private void JS() {
        this.gRU.setText(this.gRW.getTitle());
        this.gwR.setTag(this.gRW.getImageUrl());
        this.gwR.startLoad(this.gRW.getImageUrl(), 17, false);
        this.gRT.setVisibility(0);
        this.gRT.setTag(this.gRW.getShareSourceIcon());
        this.gRT.startLoad(this.gRW.getShareSourceIcon(), 17, false);
        this.gwS.setText(this.gRW.getContent());
        this.gRV.setText("来自" + this.gRW.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.gRU.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.gwR.setTag(shareFromPBMsgData.getImageUrl());
        this.gwR.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.gRT.setVisibility(8);
        this.gwS.setText(shareFromPBMsgData.getContent());
    }
}
