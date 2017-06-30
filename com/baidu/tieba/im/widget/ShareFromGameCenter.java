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
    private LinearLayout daG;
    private ShareFromGameCenterMsgData dpU;
    private TextView dqb;
    private HeadImageView dqc;
    private Button dqd;
    private TbImageView dqe;
    private LinearLayout dqf;
    private LinearLayout dqg;
    private TextView dqh;
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
        this.dqf = (LinearLayout) findViewById(w.h.share_info_layout);
        this.dqg = (LinearLayout) findViewById(w.h.game_share_content);
        this.daG = (LinearLayout) findViewById(w.h.small_tail);
        this.mTitle = (TextView) findViewById(w.h.game_title);
        this.dqb = (TextView) findViewById(w.h.game_desc);
        this.dqc = (HeadImageView) findViewById(w.h.game_img);
        this.dqc.setDefaultResource(w.g.pic_avatar_ba_140);
        this.dqc.setAutoChangeStyle(false);
        this.dqd = (Button) findViewById(w.h.accept_invite_button);
        this.dqe = (TbImageView) findViewById(w.h.tail_icon);
        this.dqe.setDefaultResource(w.g.icon);
        this.dqe.setAutoChangeStyle(false);
        this.dqh = (TextView) findViewById(w.h.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.dpU = shareFromGameCenterMsgData;
            gx(z);
        }
    }

    private void gx(boolean z) {
        if (z) {
            this.dqf.setBackgroundDrawable(this.mContext.getResources().getDrawable(w.g.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_g));
            this.dqb.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_b));
            this.dqb.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_f));
            this.dqf.setBackgroundDrawable(this.mContext.getResources().getDrawable(w.g.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(k.g(getContext(), w.f.ds14), 0, 0, 0);
            layoutParams.height = k.g(getContext(), w.f.ds48);
            this.daG.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.dpU.getTitle());
        this.dqc.setDefaultResource(w.g.pic_avatar_ba_140);
        this.dqc.setAutoChangeStyle(false);
        this.dqc.c(this.dpU.getImageUrl(), 10, false);
        this.dqb.setText(this.dpU.getContent());
        this.dqd.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_b));
        this.dqd.setBackgroundResource(w.g.btn_appdownload);
        if (!TextUtils.isEmpty(this.dpU.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, k.g(getContext(), w.f.ds60));
            int g = k.g(getContext(), w.f.ds30);
            layoutParams2.setMargins(g, k.g(getContext(), w.f.ds18), g, g);
            this.dqd.setLayoutParams(layoutParams2);
            this.dqd.setVisibility(0);
            this.dqd.setText(this.dpU.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int g2 = k.g(getContext(), w.f.ds30);
            layoutParams3.setMargins(g2, k.g(getContext(), w.f.ds20), g2, g2);
            this.dqd.setVisibility(8);
            this.dqg.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.dpU.getShareSource())) {
            this.daG.setVisibility(8);
        }
        this.dqh.setText(this.dpU.getShareSource());
        this.dqe.setDefaultResource(w.g.icon);
        this.dqe.setAutoChangeStyle(false);
        this.dqe.c(this.dpU.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", m.rr(this.dpU.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.daG;
    }

    public LinearLayout getContentBody() {
        return this.dqf;
    }

    public ImageView getTiebaIcon() {
        return this.dqe;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.dqe = tbImageView;
    }
}
