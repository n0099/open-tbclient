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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class Game2GroupShareDialogView extends LinearLayout {
    private LinearLayout aUT;
    private EditText dEh;
    private TextView dEz;
    private TbImageView eae;
    private BarImageView evq;
    private TextView evr;
    protected TextView evs;
    private ShareFromGameCenterMsgData evt;

    public EditText getChatMsgView() {
        return this.dEh;
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
        LayoutInflater.from(context).inflate(d.i.game_to_group_share_dialog, this);
        setOrientation(1);
        this.aUT = (LinearLayout) findViewById(d.g.game_to_group_share_dialog_content);
        this.evr = (TextView) findViewById(d.g.share_title_view);
        this.dEh = (EditText) findViewById(d.g.game_to_group_share_chat_msg);
        this.eae = (TbImageView) findViewById(d.g.game_to_group_share_img);
        this.evq = (BarImageView) findViewById(d.g.game_to_group_share_icon);
        this.dEz = (TextView) findViewById(d.g.game_to_group_share_desc);
        al.c(this.evr, d.C0141d.cp_cont_b, 1);
        al.c(this.dEh, d.C0141d.cp_cont_b, 2);
        this.dEh.setHintTextColor(al.getColor(d.C0141d.cp_cont_e));
        al.c(this.dEz, d.C0141d.cp_cont_f, 1);
        this.dEh.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        this.evs = (TextView) findViewById(d.g.game_to_group_share);
        al.c(this.evs, d.C0141d.cp_cont_c, 1);
        azY();
    }

    public void azY() {
        this.aUT.setFocusable(true);
        this.aUT.setFocusableInTouchMode(true);
        this.aUT.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dEh != null) {
            return k.a(this.dEh.getText(), null);
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
        this.evt = shareFromGameCenterMsgData;
        Al();
    }

    private void Al() {
        this.evr.setText(this.evt.getTitle());
        this.eae.setTag(this.evt.getImageUrl());
        this.eae.startLoad(this.evt.getImageUrl(), 17, false);
        this.evq.setVisibility(0);
        this.evq.setTag(this.evt.getShareSourceIcon());
        this.evq.startLoad(this.evt.getShareSourceIcon(), 17, false);
        this.dEz.setText(this.evt.getContent());
        this.evs.setText("来自" + this.evt.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.evr.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.eae.setTag(shareFromPBMsgData.getImageUrl());
        this.eae.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.evq.setVisibility(8);
        this.dEz.setText(shareFromPBMsgData.getContent());
    }
}
