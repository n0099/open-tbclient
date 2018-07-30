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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class Game2GroupShareDialogView extends LinearLayout {
    private LinearLayout axG;
    private TextView dKJ;
    private EditText dKr;
    private BarImageView eCY;
    private TextView eCZ;
    protected TextView eDa;
    private ShareFromGameCenterMsgData eDb;
    private TbImageView ehN;

    public EditText getChatMsgView() {
        return this.dKr;
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
        LayoutInflater.from(context).inflate(d.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.axG = (LinearLayout) findViewById(d.g.game_to_group_share_dialog_content);
        this.eCZ = (TextView) findViewById(d.g.share_title_view);
        this.dKr = (EditText) findViewById(d.g.game_to_group_share_chat_msg);
        this.ehN = (TbImageView) findViewById(d.g.game_to_group_share_img);
        this.eCY = (BarImageView) findViewById(d.g.game_to_group_share_icon);
        this.dKJ = (TextView) findViewById(d.g.game_to_group_share_desc);
        am.c(this.eCZ, d.C0140d.cp_cont_b, 1);
        am.c(this.dKr, d.C0140d.cp_cont_b, 2);
        this.dKr.setHintTextColor(am.getColor(d.C0140d.cp_cont_e));
        am.c(this.dKJ, d.C0140d.cp_cont_f, 1);
        this.dKr.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        this.eDa = (TextView) findViewById(d.g.game_to_group_share);
        am.c(this.eDa, d.C0140d.cp_cont_c, 1);
        aBo();
    }

    public void aBo() {
        this.axG.setFocusable(true);
        this.axG.setFocusableInTouchMode(true);
        this.axG.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dKr != null) {
            return k.a(this.dKr.getText(), null);
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
        this.eDb = shareFromGameCenterMsgData;
        Ar();
    }

    private void Ar() {
        this.eCZ.setText(this.eDb.getTitle());
        this.ehN.setTag(this.eDb.getImageUrl());
        this.ehN.startLoad(this.eDb.getImageUrl(), 17, false);
        this.eCY.setVisibility(0);
        this.eCY.setTag(this.eDb.getShareSourceIcon());
        this.eCY.startLoad(this.eDb.getShareSourceIcon(), 17, false);
        this.dKJ.setText(this.eDb.getContent());
        this.eDa.setText("来自" + this.eDb.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.eCZ.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.ehN.setTag(shareFromPBMsgData.getImageUrl());
        this.ehN.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.eCY.setVisibility(8);
        this.dKJ.setText(shareFromPBMsgData.getContent());
    }
}
