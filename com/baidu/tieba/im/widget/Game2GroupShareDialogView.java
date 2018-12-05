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
    private LinearLayout aJG;
    private TbImageView eFe;
    private TextView ehG;
    private EditText ehp;
    private BarImageView fac;
    private TextView fad;
    protected TextView fae;
    private ShareFromGameCenterMsgData faf;

    public EditText getChatMsgView() {
        return this.ehp;
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
        this.aJG = (LinearLayout) findViewById(e.g.game_to_group_share_dialog_content);
        this.fad = (TextView) findViewById(e.g.share_title_view);
        this.ehp = (EditText) findViewById(e.g.game_to_group_share_chat_msg);
        this.eFe = (TbImageView) findViewById(e.g.game_to_group_share_img);
        this.fac = (BarImageView) findViewById(e.g.game_to_group_share_icon);
        this.ehG = (TextView) findViewById(e.g.game_to_group_share_desc);
        al.c(this.fad, e.d.cp_cont_b, 1);
        al.c(this.ehp, e.d.cp_cont_b, 2);
        this.ehp.setHintTextColor(al.getColor(e.d.cp_cont_e));
        al.c(this.ehG, e.d.cp_cont_f, 1);
        this.ehp.setPadding(context.getResources().getDimensionPixelSize(e.C0210e.ds20), 0, 0, 0);
        this.fae = (TextView) findViewById(e.g.game_to_group_share);
        al.c(this.fae, e.d.cp_cont_c, 1);
        aHY();
    }

    public void aHY() {
        this.aJG.setFocusable(true);
        this.aJG.setFocusableInTouchMode(true);
        this.aJG.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.ehp != null) {
            return k.a(this.ehp.getText(), null);
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
        this.faf = shareFromGameCenterMsgData;
        updateUI();
    }

    private void updateUI() {
        this.fad.setText(this.faf.getTitle());
        this.eFe.setTag(this.faf.getImageUrl());
        this.eFe.startLoad(this.faf.getImageUrl(), 17, false);
        this.fac.setVisibility(0);
        this.fac.setTag(this.faf.getShareSourceIcon());
        this.fac.startLoad(this.faf.getShareSourceIcon(), 17, false);
        this.ehG.setText(this.faf.getContent());
        this.fae.setText("来自" + this.faf.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.fad.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.eFe.setTag(shareFromPBMsgData.getImageUrl());
        this.eFe.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.fac.setVisibility(8);
        this.ehG.setText(shareFromPBMsgData.getContent());
    }
}
