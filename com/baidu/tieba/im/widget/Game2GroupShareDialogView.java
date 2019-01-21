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
    private LinearLayout aKl;
    private TbImageView eII;
    private EditText ekN;
    private TextView ele;
    private BarImageView fdH;
    private TextView fdI;
    protected TextView fdJ;
    private ShareFromGameCenterMsgData fdK;

    public EditText getChatMsgView() {
        return this.ekN;
    }

    public Game2GroupShareDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cr(context);
    }

    public Game2GroupShareDialogView(Context context) {
        super(context);
        cr(context);
    }

    private void cr(Context context) {
        LayoutInflater.from(context).inflate(e.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aKl = (LinearLayout) findViewById(e.g.game_to_group_share_dialog_content);
        this.fdI = (TextView) findViewById(e.g.share_title_view);
        this.ekN = (EditText) findViewById(e.g.game_to_group_share_chat_msg);
        this.eII = (TbImageView) findViewById(e.g.game_to_group_share_img);
        this.fdH = (BarImageView) findViewById(e.g.game_to_group_share_icon);
        this.ele = (TextView) findViewById(e.g.game_to_group_share_desc);
        al.c(this.fdI, e.d.cp_cont_b, 1);
        al.c(this.ekN, e.d.cp_cont_b, 2);
        this.ekN.setHintTextColor(al.getColor(e.d.cp_cont_e));
        al.c(this.ele, e.d.cp_cont_f, 1);
        this.ekN.setPadding(context.getResources().getDimensionPixelSize(e.C0210e.ds20), 0, 0, 0);
        this.fdJ = (TextView) findViewById(e.g.game_to_group_share);
        al.c(this.fdJ, e.d.cp_cont_c, 1);
        aJl();
    }

    public void aJl() {
        this.aKl.setFocusable(true);
        this.aKl.setFocusableInTouchMode(true);
        this.aKl.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.ekN != null) {
            return k.a(this.ekN.getText(), null);
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
        this.fdK = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.fdI.setText(this.fdK.getTitle());
        this.eII.setTag(this.fdK.getImageUrl());
        this.eII.startLoad(this.fdK.getImageUrl(), 17, false);
        this.fdH.setVisibility(0);
        this.fdH.setTag(this.fdK.getShareSourceIcon());
        this.fdH.startLoad(this.fdK.getShareSourceIcon(), 17, false);
        this.ele.setText(this.fdK.getContent());
        this.fdJ.setText("来自" + this.fdK.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.fdI.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.eII.setTag(shareFromPBMsgData.getImageUrl());
        this.eII.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.fdH.setVisibility(8);
        this.ele.setText(shareFromPBMsgData.getContent());
    }
}
