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
import com.baidu.tieba.tbadkCore.util.m;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private TextView aSO;
    private LinearLayout cSw;
    private ShareFromGameCenterMsgData dhM;
    private TextView dhR;
    private HeadImageView dhS;
    private Button dhT;
    private TbImageView dhU;
    private LinearLayout dhV;
    private LinearLayout dhW;
    private TextView dhX;
    private Context mContext;

    public ShareFromGameCenter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initUI();
    }

    public ShareFromGameCenter(Context context) {
        super(context);
        this.mContext = context;
        initUI();
    }

    public void initUI() {
        LayoutInflater.from(getContext()).inflate(w.j.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.dhV = (LinearLayout) findViewById(w.h.share_info_layout);
        this.dhW = (LinearLayout) findViewById(w.h.game_share_content);
        this.cSw = (LinearLayout) findViewById(w.h.small_tail);
        this.aSO = (TextView) findViewById(w.h.game_title);
        this.dhR = (TextView) findViewById(w.h.game_desc);
        this.dhS = (HeadImageView) findViewById(w.h.game_img);
        this.dhS.setDefaultResource(w.g.pic_avatar_ba_140);
        this.dhS.setAutoChangeStyle(false);
        this.dhT = (Button) findViewById(w.h.accept_invite_button);
        this.dhU = (TbImageView) findViewById(w.h.tail_icon);
        this.dhU.setDefaultResource(w.g.icon);
        this.dhU.setAutoChangeStyle(false);
        this.dhX = (TextView) findViewById(w.h.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.dhM = shareFromGameCenterMsgData;
            gh(z);
        }
    }

    private void gh(boolean z) {
        if (z) {
            this.dhV.setBackgroundDrawable(this.mContext.getResources().getDrawable(w.g.selector_msg_text_bubble_me));
            this.aSO.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_g));
            this.dhR.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_g));
        } else {
            this.aSO.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_b));
            this.dhR.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_f));
            this.dhV.setBackgroundDrawable(this.mContext.getResources().getDrawable(w.g.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(k.g(getContext(), w.f.ds14), 0, 0, 0);
            layoutParams.height = k.g(getContext(), w.f.ds48);
            this.cSw.setLayoutParams(layoutParams);
        }
        this.aSO.setText(this.dhM.getTitle());
        this.dhS.setDefaultResource(w.g.pic_avatar_ba_140);
        this.dhS.setAutoChangeStyle(false);
        this.dhS.c(this.dhM.getImageUrl(), 10, false);
        this.dhR.setText(this.dhM.getContent());
        this.dhT.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_b));
        this.dhT.setBackgroundResource(w.g.btn_appdownload);
        if (!TextUtils.isEmpty(this.dhM.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, k.g(getContext(), w.f.ds60));
            int g = k.g(getContext(), w.f.ds30);
            layoutParams2.setMargins(g, k.g(getContext(), w.f.ds18), g, g);
            this.dhT.setLayoutParams(layoutParams2);
            this.dhT.setVisibility(0);
            this.dhT.setText(this.dhM.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int g2 = k.g(getContext(), w.f.ds30);
            layoutParams3.setMargins(g2, k.g(getContext(), w.f.ds20), g2, g2);
            this.dhT.setVisibility(8);
            this.dhW.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.dhM.getShareSource())) {
            this.cSw.setVisibility(8);
        }
        this.dhX.setText(this.dhM.getShareSource());
        this.dhU.setDefaultResource(w.g.icon);
        this.dhU.setAutoChangeStyle(false);
        this.dhU.c(this.dhM.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", m.pT(this.dhM.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.cSw;
    }

    public LinearLayout getContentBody() {
        return this.dhV;
    }

    public ImageView getTiebaIcon() {
        return this.dhU;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.dhU = tbImageView;
    }
}
