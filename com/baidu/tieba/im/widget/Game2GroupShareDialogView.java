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
    private LinearLayout bFu;
    private TbImageView fYI;
    private TextView fYJ;
    private EditText fzZ;
    private BarImageView gtN;
    private TextView gtO;
    protected TextView gtP;
    private ShareFromGameCenterMsgData gtQ;

    public EditText getChatMsgView() {
        return this.fzZ;
    }

    public Game2GroupShareDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aX(context);
    }

    public Game2GroupShareDialogView(Context context) {
        super(context);
        aX(context);
    }

    private void aX(Context context) {
        LayoutInflater.from(context).inflate(d.h.game_to_group_share_dialog, this);
        setOrientation(1);
        this.bFu = (LinearLayout) findViewById(d.g.game_to_group_share_dialog_content);
        this.gtO = (TextView) findViewById(d.g.share_title_view);
        this.fzZ = (EditText) findViewById(d.g.game_to_group_share_chat_msg);
        this.fYI = (TbImageView) findViewById(d.g.game_to_group_share_img);
        this.gtN = (BarImageView) findViewById(d.g.game_to_group_share_icon);
        this.fYJ = (TextView) findViewById(d.g.game_to_group_share_desc);
        al.d(this.gtO, d.C0236d.cp_cont_b, 1);
        al.d(this.fzZ, d.C0236d.cp_cont_b, 2);
        this.fzZ.setHintTextColor(al.getColor(d.C0236d.cp_cont_e));
        al.d(this.fYJ, d.C0236d.cp_cont_f, 1);
        this.fzZ.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        this.gtP = (TextView) findViewById(d.g.game_to_group_share);
        al.d(this.gtP, d.C0236d.cp_cont_c, 1);
        bkh();
    }

    public void bkh() {
        this.bFu.setFocusable(true);
        this.bFu.setFocusableInTouchMode(true);
        this.bFu.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.fzZ != null) {
            return k.a(this.fzZ.getText(), null);
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
        this.gtQ = shareFromGameCenterMsgData;
        GR();
    }

    private void GR() {
        this.gtO.setText(this.gtQ.getTitle());
        this.fYI.setTag(this.gtQ.getImageUrl());
        this.fYI.startLoad(this.gtQ.getImageUrl(), 17, false);
        this.gtN.setVisibility(0);
        this.gtN.setTag(this.gtQ.getShareSourceIcon());
        this.gtN.startLoad(this.gtQ.getShareSourceIcon(), 17, false);
        this.fYJ.setText(this.gtQ.getContent());
        this.gtP.setText("来自" + this.gtQ.getShareSource());
    }

    public void setShareData(ShareFromPBMsgData shareFromPBMsgData) {
        this.gtO.setText(shareFromPBMsgData.getTitle());
        if (TextUtils.isEmpty(shareFromPBMsgData.getImageUrl())) {
            shareFromPBMsgData.setImageUrl("http://imgsrc.baidu.com/forum/w%3D580/sign=c2b802eddc62853592e0d229a0ee76f2/7fe6706134a85edfd459863c40540923dc547534.jpg");
        }
        this.fYI.setTag(shareFromPBMsgData.getImageUrl());
        this.fYI.startLoad(shareFromPBMsgData.getImageUrl(), 17, false);
        this.gtN.setVisibility(8);
        this.fYJ.setText(shareFromPBMsgData.getContent());
    }
}
