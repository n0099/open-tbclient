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
    private LinearLayout cSK;
    private ShareFromGameCenterMsgData dhY;
    private TextView dif;
    private HeadImageView dig;
    private Button dih;
    private TbImageView dii;
    private LinearLayout dij;
    private LinearLayout dik;
    private TextView dil;
    private Context mContext;
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
        LayoutInflater.from(getContext()).inflate(w.j.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.dij = (LinearLayout) findViewById(w.h.share_info_layout);
        this.dik = (LinearLayout) findViewById(w.h.game_share_content);
        this.cSK = (LinearLayout) findViewById(w.h.small_tail);
        this.mTitle = (TextView) findViewById(w.h.game_title);
        this.dif = (TextView) findViewById(w.h.game_desc);
        this.dig = (HeadImageView) findViewById(w.h.game_img);
        this.dig.setDefaultResource(w.g.pic_avatar_ba_140);
        this.dig.setAutoChangeStyle(false);
        this.dih = (Button) findViewById(w.h.accept_invite_button);
        this.dii = (TbImageView) findViewById(w.h.tail_icon);
        this.dii.setDefaultResource(w.g.icon);
        this.dii.setAutoChangeStyle(false);
        this.dil = (TextView) findViewById(w.h.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.dhY = shareFromGameCenterMsgData;
            gf(z);
        }
    }

    private void gf(boolean z) {
        if (z) {
            this.dij.setBackgroundDrawable(this.mContext.getResources().getDrawable(w.g.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_g));
            this.dif.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_b));
            this.dif.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_f));
            this.dij.setBackgroundDrawable(this.mContext.getResources().getDrawable(w.g.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(k.g(getContext(), w.f.ds14), 0, 0, 0);
            layoutParams.height = k.g(getContext(), w.f.ds48);
            this.cSK.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.dhY.getTitle());
        this.dig.setDefaultResource(w.g.pic_avatar_ba_140);
        this.dig.setAutoChangeStyle(false);
        this.dig.c(this.dhY.getImageUrl(), 10, false);
        this.dif.setText(this.dhY.getContent());
        this.dih.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_b));
        this.dih.setBackgroundResource(w.g.btn_appdownload);
        if (!TextUtils.isEmpty(this.dhY.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, k.g(getContext(), w.f.ds60));
            int g = k.g(getContext(), w.f.ds30);
            layoutParams2.setMargins(g, k.g(getContext(), w.f.ds18), g, g);
            this.dih.setLayoutParams(layoutParams2);
            this.dih.setVisibility(0);
            this.dih.setText(this.dhY.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int g2 = k.g(getContext(), w.f.ds30);
            layoutParams3.setMargins(g2, k.g(getContext(), w.f.ds20), g2, g2);
            this.dih.setVisibility(8);
            this.dik.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.dhY.getShareSource())) {
            this.cSK.setVisibility(8);
        }
        this.dil.setText(this.dhY.getShareSource());
        this.dii.setDefaultResource(w.g.icon);
        this.dii.setAutoChangeStyle(false);
        this.dii.c(this.dhY.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", m.qt(this.dhY.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.cSK;
    }

    public LinearLayout getContentBody() {
        return this.dij;
    }

    public ImageView getTiebaIcon() {
        return this.dii;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.dii = tbImageView;
    }
}
