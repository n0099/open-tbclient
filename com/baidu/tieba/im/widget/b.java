package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b extends LinearLayout {
    private LinearLayout aKN;
    private TextView aRs;
    private EditText cyP;
    private TbImageView dcX;
    private BarImageView dyt;
    private TextView dyu;
    protected TextView dyv;
    private ShareFromGameCenterMsgData dyw;

    public EditText getChatMsgView() {
        return this.cyP;
    }

    public b(Context context) {
        super(context);
        bk(context);
    }

    private void bk(Context context) {
        LayoutInflater.from(context).inflate(d.j.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aKN = (LinearLayout) findViewById(d.h.game_to_group_share_dialog_content);
        this.dyu = (TextView) findViewById(d.h.share_title_view);
        this.cyP = (EditText) findViewById(d.h.game_to_group_share_chat_msg);
        this.dcX = (TbImageView) findViewById(d.h.game_to_group_share_img);
        this.dyt = (BarImageView) findViewById(d.h.game_to_group_share_icon);
        this.aRs = (TextView) findViewById(d.h.game_to_group_share_desc);
        ai.c(this.dyu, d.e.cp_cont_b, 1);
        ai.c(this.cyP, d.e.cp_cont_b, 2);
        this.cyP.setHintTextColor(ai.getColor(d.e.cp_cont_e));
        ai.c(this.aRs, d.e.cp_cont_f, 1);
        this.cyP.setPadding(context.getResources().getDimensionPixelSize(d.f.ds20), 0, 0, 0);
        this.dyv = (TextView) findViewById(d.h.game_to_group_share);
        ai.c(this.dyv, d.e.cp_cont_c, 1);
        ajD();
    }

    public void ajD() {
        this.aKN.setFocusable(true);
        this.aKN.setFocusableInTouchMode(true);
        this.aKN.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cyP != null) {
            return j.a(this.cyP.getText(), null);
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
        this.dyw = shareFromGameCenterMsgData;
        wG();
    }

    private void wG() {
        this.dyu.setText(this.dyw.getTitle());
        this.dcX.setTag(this.dyw.getImageUrl());
        this.dcX.c(this.dyw.getImageUrl(), 17, false);
        this.dyt.setVisibility(0);
        this.dyt.setTag(this.dyw.getShareSourceIcon());
        this.dyt.c(this.dyw.getShareSourceIcon(), 17, false);
        this.aRs.setText(this.dyw.getContent());
        this.dyv.setText("来自" + this.dyw.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.dyu.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.dcX.setTag(shareFromPBMsgData.getImageUrl());
        this.dcX.c(shareFromPBMsgData.getImageUrl(), 17, false);
        this.dyt.setVisibility(8);
        this.aRs.setText(shareFromPBMsgData.getContent());
    }
}
