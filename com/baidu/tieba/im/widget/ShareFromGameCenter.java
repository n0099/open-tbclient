package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.n;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private TextView aPr;
    private LinearLayout bRT;
    private TextView bif;
    private ShareFromGameCenterMsgData cgL;
    private HeadImageView cgQ;
    private Button cgR;
    private TbImageView cgS;
    private LinearLayout cgT;
    private LinearLayout cgU;
    private TextView cgV;
    private Context mContext;

    public ShareFromGameCenter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        qD();
    }

    public ShareFromGameCenter(Context context) {
        super(context);
        this.mContext = context;
        qD();
    }

    public void qD() {
        LayoutInflater.from(getContext()).inflate(t.h.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.cgT = (LinearLayout) findViewById(t.g.share_info_layout);
        this.cgU = (LinearLayout) findViewById(t.g.game_share_content);
        this.bRT = (LinearLayout) findViewById(t.g.small_tail);
        this.aPr = (TextView) findViewById(t.g.game_title);
        this.bif = (TextView) findViewById(t.g.game_desc);
        this.cgQ = (HeadImageView) findViewById(t.g.game_img);
        this.cgQ.setDefaultResource(t.f.pic_avatar_ba_140);
        this.cgQ.setAutoChangeStyle(false);
        this.cgR = (Button) findViewById(t.g.accept_invite_button);
        this.cgS = (TbImageView) findViewById(t.g.tail_icon);
        this.cgS.setDefaultResource(t.f.icon);
        this.cgS.setAutoChangeStyle(false);
        this.cgV = (TextView) findViewById(t.g.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.cgL = shareFromGameCenterMsgData;
            dV(z);
        }
    }

    private void dV(boolean z) {
        if (z) {
            this.cgT.setBackgroundDrawable(this.mContext.getResources().getDrawable(t.f.selector_msg_text_bubble_me));
            this.aPr.setTextColor(this.mContext.getResources().getColor(t.d.cp_cont_g));
            this.bif.setTextColor(this.mContext.getResources().getColor(t.d.cp_cont_g));
        } else {
            this.aPr.setTextColor(this.mContext.getResources().getColor(t.d.cp_cont_b));
            this.bif.setTextColor(this.mContext.getResources().getColor(t.d.cp_cont_f));
            this.cgT.setBackgroundDrawable(this.mContext.getResources().getDrawable(t.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(k.c(getContext(), t.e.ds14), 0, 0, 0);
            layoutParams.height = k.c(getContext(), t.e.ds48);
            this.bRT.setLayoutParams(layoutParams);
        }
        this.aPr.setText(this.cgL.getTitle());
        this.cgQ.setDefaultResource(t.f.pic_avatar_ba_140);
        this.cgQ.setAutoChangeStyle(false);
        this.cgQ.d(this.cgL.getImageUrl(), 10, false);
        this.bif.setText(this.cgL.getContent());
        this.cgR.setTextColor(this.mContext.getResources().getColor(t.d.cp_cont_b));
        this.cgR.setBackgroundResource(t.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.cgL.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, k.c(getContext(), t.e.ds60));
            int c = k.c(getContext(), t.e.ds30);
            layoutParams2.setMargins(c, k.c(getContext(), t.e.ds18), c, c);
            this.cgR.setLayoutParams(layoutParams2);
            this.cgR.setVisibility(0);
            this.cgR.setText(this.cgL.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int c2 = k.c(getContext(), t.e.ds30);
            layoutParams3.setMargins(c2, k.c(getContext(), t.e.ds20), c2, c2);
            this.cgR.setVisibility(8);
            this.cgU.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.cgL.getShareSource())) {
            this.bRT.setVisibility(8);
        }
        this.cgV.setText(this.cgL.getShareSource());
        this.cgS.setDefaultResource(t.f.icon);
        this.cgS.setAutoChangeStyle(false);
        this.cgS.d(this.cgL.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", n.mQ(this.cgL.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.bRT;
    }

    public LinearLayout getContentBody() {
        return this.cgT;
    }

    public ImageView getTiebaIcon() {
        return this.cgS;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.cgS = tbImageView;
    }
}
