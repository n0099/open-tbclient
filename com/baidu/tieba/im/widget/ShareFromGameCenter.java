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
    private TextView dAa;
    private LinearLayout dkE;
    private ShareFromGameCenterMsgData dzO;
    private HeadImageView dzV;
    private Button dzW;
    private TbImageView dzX;
    private LinearLayout dzY;
    private LinearLayout dzZ;
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
        this.dzY = (LinearLayout) findViewById(d.h.share_info_layout);
        this.dzZ = (LinearLayout) findViewById(d.h.game_share_content);
        this.dkE = (LinearLayout) findViewById(d.h.small_tail);
        this.mTitle = (TextView) findViewById(d.h.game_title);
        this.mDesc = (TextView) findViewById(d.h.game_desc);
        this.dzV = (HeadImageView) findViewById(d.h.game_img);
        this.dzV.setDefaultResource(d.g.pic_avatar_ba_140);
        this.dzV.setAutoChangeStyle(false);
        this.dzW = (Button) findViewById(d.h.accept_invite_button);
        this.dzX = (TbImageView) findViewById(d.h.tail_icon);
        this.dzX.setDefaultResource(d.g.icon);
        this.dzX.setAutoChangeStyle(false);
        this.dAa = (TextView) findViewById(d.h.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.dzO = shareFromGameCenterMsgData;
            gL(z);
        }
    }

    private void gL(boolean z) {
        if (z) {
            this.dzY.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.g.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_g));
            this.mDesc.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_b));
            this.mDesc.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_f));
            this.dzY.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.g.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(k.g(getContext(), d.f.ds14), 0, 0, 0);
            layoutParams.height = k.g(getContext(), d.f.ds48);
            this.dkE.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.dzO.getTitle());
        this.dzV.setDefaultResource(d.g.pic_avatar_ba_140);
        this.dzV.setAutoChangeStyle(false);
        this.dzV.c(this.dzO.getImageUrl(), 10, false);
        this.mDesc.setText(this.dzO.getContent());
        this.dzW.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_b));
        this.dzW.setBackgroundResource(d.g.btn_appdownload);
        if (!TextUtils.isEmpty(this.dzO.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, k.g(getContext(), d.f.ds60));
            int g = k.g(getContext(), d.f.ds30);
            layoutParams2.setMargins(g, k.g(getContext(), d.f.ds18), g, g);
            this.dzW.setLayoutParams(layoutParams2);
            this.dzW.setVisibility(0);
            this.dzW.setText(this.dzO.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int g2 = k.g(getContext(), d.f.ds30);
            layoutParams3.setMargins(g2, k.g(getContext(), d.f.ds20), g2, g2);
            this.dzW.setVisibility(8);
            this.dzZ.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.dzO.getShareSource())) {
            this.dkE.setVisibility(8);
        }
        this.dAa.setText(this.dzO.getShareSource());
        this.dzX.setDefaultResource(d.g.icon);
        this.dzX.setAutoChangeStyle(false);
        this.dzX.c(this.dzO.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.si(this.dzO.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.dkE;
    }

    public LinearLayout getContentBody() {
        return this.dzY;
    }

    public ImageView getTiebaIcon() {
        return this.dzX;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.dzX = tbImageView;
    }
}
