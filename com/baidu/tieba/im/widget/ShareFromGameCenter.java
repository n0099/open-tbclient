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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private ShareFromGameCenterMsgData dBL;
    private HeadImageView dBS;
    private Button dBT;
    private TbImageView dBU;
    private LinearLayout dBV;
    private LinearLayout dBW;
    private TextView dBX;
    private LinearLayout dmB;
    private Context mContext;
    private TextView mDesc;
    private TextView mTitle;

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
        LayoutInflater.from(getContext()).inflate(d.j.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.dBV = (LinearLayout) findViewById(d.h.share_info_layout);
        this.dBW = (LinearLayout) findViewById(d.h.game_share_content);
        this.dmB = (LinearLayout) findViewById(d.h.small_tail);
        this.mTitle = (TextView) findViewById(d.h.game_title);
        this.mDesc = (TextView) findViewById(d.h.game_desc);
        this.dBS = (HeadImageView) findViewById(d.h.game_img);
        this.dBS.setDefaultResource(d.g.pic_avatar_ba_140);
        this.dBS.setAutoChangeStyle(false);
        this.dBT = (Button) findViewById(d.h.accept_invite_button);
        this.dBU = (TbImageView) findViewById(d.h.tail_icon);
        this.dBU.setDefaultResource(d.g.icon);
        this.dBU.setAutoChangeStyle(false);
        this.dBX = (TextView) findViewById(d.h.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.dBL = shareFromGameCenterMsgData;
            gO(z);
        }
    }

    private void gO(boolean z) {
        if (z) {
            this.dBV.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.g.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_g));
            this.mDesc.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_b));
            this.mDesc.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_f));
            this.dBV.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.g.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(k.g(getContext(), d.f.ds14), 0, 0, 0);
            layoutParams.height = k.g(getContext(), d.f.ds48);
            this.dmB.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.dBL.getTitle());
        this.dBS.setDefaultResource(d.g.pic_avatar_ba_140);
        this.dBS.setAutoChangeStyle(false);
        this.dBS.c(this.dBL.getImageUrl(), 10, false);
        this.mDesc.setText(this.dBL.getContent());
        this.dBT.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_b));
        this.dBT.setBackgroundResource(d.g.btn_appdownload);
        if (!TextUtils.isEmpty(this.dBL.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, k.g(getContext(), d.f.ds60));
            int g = k.g(getContext(), d.f.ds30);
            layoutParams2.setMargins(g, k.g(getContext(), d.f.ds18), g, g);
            this.dBT.setLayoutParams(layoutParams2);
            this.dBT.setVisibility(0);
            this.dBT.setText(this.dBL.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int g2 = k.g(getContext(), d.f.ds30);
            layoutParams3.setMargins(g2, k.g(getContext(), d.f.ds20), g2, g2);
            this.dBT.setVisibility(8);
            this.dBW.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.dBL.getShareSource())) {
            this.dmB.setVisibility(8);
        }
        this.dBX.setText(this.dBL.getShareSource());
        this.dBU.setDefaultResource(d.g.icon);
        this.dBU.setAutoChangeStyle(false);
        this.dBU.c(this.dBL.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.sp(this.dBL.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.dmB;
    }

    public LinearLayout getContentBody() {
        return this.dBV;
    }

    public ImageView getTiebaIcon() {
        return this.dBU;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.dBU = tbImageView;
    }
}
