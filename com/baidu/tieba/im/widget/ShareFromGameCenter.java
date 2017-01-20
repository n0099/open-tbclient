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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.util.m;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private TextView aNb;
    private LinearLayout cQe;
    private TextView dfA;
    private HeadImageView dfB;
    private Button dfC;
    private TbImageView dfD;
    private LinearLayout dfE;
    private LinearLayout dfF;
    private TextView dfG;
    private ShareFromGameCenterMsgData dfv;
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
        LayoutInflater.from(getContext()).inflate(r.j.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.dfE = (LinearLayout) findViewById(r.h.share_info_layout);
        this.dfF = (LinearLayout) findViewById(r.h.game_share_content);
        this.cQe = (LinearLayout) findViewById(r.h.small_tail);
        this.aNb = (TextView) findViewById(r.h.game_title);
        this.dfA = (TextView) findViewById(r.h.game_desc);
        this.dfB = (HeadImageView) findViewById(r.h.game_img);
        this.dfB.setDefaultResource(r.g.pic_avatar_ba_140);
        this.dfB.setAutoChangeStyle(false);
        this.dfC = (Button) findViewById(r.h.accept_invite_button);
        this.dfD = (TbImageView) findViewById(r.h.tail_icon);
        this.dfD.setDefaultResource(r.g.icon);
        this.dfD.setAutoChangeStyle(false);
        this.dfG = (TextView) findViewById(r.h.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.dfv = shareFromGameCenterMsgData;
            gq(z);
        }
    }

    private void gq(boolean z) {
        if (z) {
            this.dfE.setBackgroundDrawable(this.mContext.getResources().getDrawable(r.g.selector_msg_text_bubble_me));
            this.aNb.setTextColor(this.mContext.getResources().getColor(r.e.cp_cont_g));
            this.dfA.setTextColor(this.mContext.getResources().getColor(r.e.cp_cont_g));
        } else {
            this.aNb.setTextColor(this.mContext.getResources().getColor(r.e.cp_cont_b));
            this.dfA.setTextColor(this.mContext.getResources().getColor(r.e.cp_cont_f));
            this.dfE.setBackgroundDrawable(this.mContext.getResources().getDrawable(r.g.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(k.e(getContext(), r.f.ds14), 0, 0, 0);
            layoutParams.height = k.e(getContext(), r.f.ds48);
            this.cQe.setLayoutParams(layoutParams);
        }
        this.aNb.setText(this.dfv.getTitle());
        this.dfB.setDefaultResource(r.g.pic_avatar_ba_140);
        this.dfB.setAutoChangeStyle(false);
        this.dfB.c(this.dfv.getImageUrl(), 10, false);
        this.dfA.setText(this.dfv.getContent());
        this.dfC.setTextColor(this.mContext.getResources().getColor(r.e.cp_cont_b));
        this.dfC.setBackgroundResource(r.g.btn_appdownload);
        if (!TextUtils.isEmpty(this.dfv.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, k.e(getContext(), r.f.ds60));
            int e = k.e(getContext(), r.f.ds30);
            layoutParams2.setMargins(e, k.e(getContext(), r.f.ds18), e, e);
            this.dfC.setLayoutParams(layoutParams2);
            this.dfC.setVisibility(0);
            this.dfC.setText(this.dfv.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int e2 = k.e(getContext(), r.f.ds30);
            layoutParams3.setMargins(e2, k.e(getContext(), r.f.ds20), e2, e2);
            this.dfC.setVisibility(8);
            this.dfF.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.dfv.getShareSource())) {
            this.cQe.setVisibility(8);
        }
        this.dfG.setText(this.dfv.getShareSource());
        this.dfD.setDefaultResource(r.g.icon);
        this.dfD.setAutoChangeStyle(false);
        this.dfD.c(this.dfv.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", m.qL(this.dfv.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.cQe;
    }

    public LinearLayout getContentBody() {
        return this.dfE;
    }

    public ImageView getTiebaIcon() {
        return this.dfD;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.dfD = tbImageView;
    }
}
