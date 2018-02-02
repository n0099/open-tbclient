package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private ShareFromGameCenterMsgData eJZ;
    private TextView eKg;
    private HeadImageView eKh;
    private Button eKi;
    private TbImageView eKj;
    private LinearLayout eKk;
    private LinearLayout eKl;
    private TextView eKm;
    private LinearLayout evg;
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
        LayoutInflater.from(getContext()).inflate(d.h.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.eKk = (LinearLayout) findViewById(d.g.share_info_layout);
        this.eKl = (LinearLayout) findViewById(d.g.game_share_content);
        this.evg = (LinearLayout) findViewById(d.g.small_tail);
        this.mTitle = (TextView) findViewById(d.g.game_title);
        this.eKg = (TextView) findViewById(d.g.game_desc);
        this.eKh = (HeadImageView) findViewById(d.g.game_img);
        this.eKh.setDefaultResource(d.f.pic_avatar_ba_140);
        this.eKh.setAutoChangeStyle(false);
        this.eKi = (Button) findViewById(d.g.accept_invite_button);
        this.eKj = (TbImageView) findViewById(d.g.tail_icon);
        this.eKj.setDefaultResource(d.f.icon);
        this.eKj.setAutoChangeStyle(false);
        this.eKm = (TextView) findViewById(d.g.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.eJZ = shareFromGameCenterMsgData;
            hL(z);
        }
    }

    private void hL(boolean z) {
        if (z) {
            this.eKk.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0108d.cp_cont_g));
            this.eKg.setTextColor(this.mContext.getResources().getColor(d.C0108d.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0108d.cp_cont_b));
            this.eKg.setTextColor(this.mContext.getResources().getColor(d.C0108d.cp_cont_f));
            this.eKk.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.s(getContext(), d.e.ds14), 0, 0, 0);
            layoutParams.height = l.s(getContext(), d.e.ds48);
            this.evg.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.eJZ.getTitle());
        this.eKh.setDefaultResource(d.f.pic_avatar_ba_140);
        this.eKh.setAutoChangeStyle(false);
        this.eKh.startLoad(this.eJZ.getImageUrl(), 10, false);
        this.eKg.setText(this.eJZ.getContent());
        this.eKi.setTextColor(this.mContext.getResources().getColor(d.C0108d.cp_cont_b));
        this.eKi.setBackgroundResource(d.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.eJZ.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.s(getContext(), d.e.ds60));
            int s = l.s(getContext(), d.e.ds30);
            layoutParams2.setMargins(s, l.s(getContext(), d.e.ds18), s, s);
            this.eKi.setLayoutParams(layoutParams2);
            this.eKi.setVisibility(0);
            this.eKi.setText(this.eJZ.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int s2 = l.s(getContext(), d.e.ds30);
            layoutParams3.setMargins(s2, l.s(getContext(), d.e.ds20), s2, s2);
            this.eKi.setVisibility(8);
            this.eKl.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.eJZ.getShareSource())) {
            this.evg.setVisibility(8);
        }
        this.eKm.setText(this.eJZ.getShareSource());
        this.eKj.setDefaultResource(d.f.icon);
        this.eKj.setAutoChangeStyle(false);
        this.eKj.startLoad(this.eJZ.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.sM(this.eJZ.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.evg;
    }

    public LinearLayout getContentBody() {
        return this.eKk;
    }

    public ImageView getTiebaIcon() {
        return this.eKj;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.eKj = tbImageView;
    }
}
