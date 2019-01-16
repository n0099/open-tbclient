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
    private LinearLayout aKk;
    private TbImageView eIH;
    private EditText ekM;
    private TextView eld;
    private BarImageView fdG;
    private TextView fdH;
    protected TextView fdI;
    private ShareFromGameCenterMsgData fdJ;

    public EditText getChatMsgView() {
        return this.ekM;
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
        this.aKk = (LinearLayout) findViewById(e.g.game_to_group_share_dialog_content);
        this.fdH = (TextView) findViewById(e.g.share_title_view);
        this.ekM = (EditText) findViewById(e.g.game_to_group_share_chat_msg);
        this.eIH = (TbImageView) findViewById(e.g.game_to_group_share_img);
        this.fdG = (BarImageView) findViewById(e.g.game_to_group_share_icon);
        this.eld = (TextView) findViewById(e.g.game_to_group_share_desc);
        al.c(this.fdH, e.d.cp_cont_b, 1);
        al.c(this.ekM, e.d.cp_cont_b, 2);
        this.ekM.setHintTextColor(al.getColor(e.d.cp_cont_e));
        al.c(this.eld, e.d.cp_cont_f, 1);
        this.ekM.setPadding(context.getResources().getDimensionPixelSize(e.C0210e.ds20), 0, 0, 0);
        this.fdI = (TextView) findViewById(e.g.game_to_group_share);
        al.c(this.fdI, e.d.cp_cont_c, 1);
        aJl();
    }

    public void aJl() {
        this.aKk.setFocusable(true);
        this.aKk.setFocusableInTouchMode(true);
        this.aKk.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.ekM != null) {
            return k.a(this.ekM.getText(), null);
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
        this.fdJ = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.fdH.setText(this.fdJ.getTitle());
        this.eIH.setTag(this.fdJ.getImageUrl());
        this.eIH.startLoad(this.fdJ.getImageUrl(), 17, false);
        this.fdG.setVisibility(0);
        this.fdG.setTag(this.fdJ.getShareSourceIcon());
        this.fdG.startLoad(this.fdJ.getShareSourceIcon(), 17, false);
        this.eld.setText(this.fdJ.getContent());
        this.fdI.setText("来自" + this.fdJ.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.fdH.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.eIH.setTag(shareFromPBMsgData.getImageUrl());
        this.eIH.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.fdG.setVisibility(8);
        this.eld.setText(shareFromPBMsgData.getContent());
    }
}
