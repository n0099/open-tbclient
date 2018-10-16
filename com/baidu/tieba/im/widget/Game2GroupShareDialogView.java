package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class Game2GroupShareDialogView extends LinearLayout {
    private LinearLayout aFq;
    private TextView dZJ;
    private EditText dZs;
    private BarImageView eRU;
    private TextView eRV;
    protected TextView eRW;
    private ShareFromGameCenterMsgData eRX;
    private TbImageView ewS;

    public EditText getChatMsgView() {
        return this.dZs;
    }

    public Game2GroupShareDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cs(context);
    }

    public Game2GroupShareDialogView(Context context) {
        super(context);
        cs(context);
    }

    private void cs(Context context) {
        LayoutInflater.from(context).inflate(e.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aFq = (LinearLayout) findViewById(e.g.game_to_group_share_dialog_content);
        this.eRV = (TextView) findViewById(e.g.share_title_view);
        this.dZs = (EditText) findViewById(e.g.game_to_group_share_chat_msg);
        this.ewS = (TbImageView) findViewById(e.g.game_to_group_share_img);
        this.eRU = (BarImageView) findViewById(e.g.game_to_group_share_icon);
        this.dZJ = (TextView) findViewById(e.g.game_to_group_share_desc);
        al.c(this.eRV, e.d.cp_cont_b, 1);
        al.c(this.dZs, e.d.cp_cont_b, 2);
        this.dZs.setHintTextColor(al.getColor(e.d.cp_cont_e));
        al.c(this.dZJ, e.d.cp_cont_f, 1);
        this.dZs.setPadding(context.getResources().getDimensionPixelSize(e.C0175e.ds20), 0, 0, 0);
        this.eRW = (TextView) findViewById(e.g.game_to_group_share);
        al.c(this.eRW, e.d.cp_cont_c, 1);
        aGO();
    }

    public void aGO() {
        this.aFq.setFocusable(true);
        this.aFq.setFocusableInTouchMode(true);
        this.aFq.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dZs != null) {
            return k.a(this.dZs.getText(), null);
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
        this.eRX = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.eRV.setText(this.eRX.getTitle());
        this.ewS.setTag(this.eRX.getImageUrl());
        this.ewS.startLoad(this.eRX.getImageUrl(), 17, false);
        this.eRU.setVisibility(0);
        this.eRU.setTag(this.eRX.getShareSourceIcon());
        this.eRU.startLoad(this.eRX.getShareSourceIcon(), 17, false);
        this.dZJ.setText(this.eRX.getContent());
        this.eRW.setText("来自" + this.eRX.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.eRV.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.ewS.setTag(shareFromPBMsgData.getImageUrl());
        this.ewS.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.eRU.setVisibility(8);
        this.dZJ.setText(shareFromPBMsgData.getContent());
    }
}
