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
    private LinearLayout cQT;
    private ShareFromGameCenterMsgData dgj;
    private TextView dgq;
    private HeadImageView dgr;
    private Button dgs;
    private TbImageView dgt;
    private LinearLayout dgu;
    private LinearLayout dgv;
    private TextView dgw;
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
        this.dgu = (LinearLayout) findViewById(w.h.share_info_layout);
        this.dgv = (LinearLayout) findViewById(w.h.game_share_content);
        this.cQT = (LinearLayout) findViewById(w.h.small_tail);
        this.mTitle = (TextView) findViewById(w.h.game_title);
        this.dgq = (TextView) findViewById(w.h.game_desc);
        this.dgr = (HeadImageView) findViewById(w.h.game_img);
        this.dgr.setDefaultResource(w.g.pic_avatar_ba_140);
        this.dgr.setAutoChangeStyle(false);
        this.dgs = (Button) findViewById(w.h.accept_invite_button);
        this.dgt = (TbImageView) findViewById(w.h.tail_icon);
        this.dgt.setDefaultResource(w.g.icon);
        this.dgt.setAutoChangeStyle(false);
        this.dgw = (TextView) findViewById(w.h.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.dgj = shareFromGameCenterMsgData;
            gh(z);
        }
    }

    private void gh(boolean z) {
        if (z) {
            this.dgu.setBackgroundDrawable(this.mContext.getResources().getDrawable(w.g.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_g));
            this.dgq.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_b));
            this.dgq.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_f));
            this.dgu.setBackgroundDrawable(this.mContext.getResources().getDrawable(w.g.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(k.g(getContext(), w.f.ds14), 0, 0, 0);
            layoutParams.height = k.g(getContext(), w.f.ds48);
            this.cQT.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.dgj.getTitle());
        this.dgr.setDefaultResource(w.g.pic_avatar_ba_140);
        this.dgr.setAutoChangeStyle(false);
        this.dgr.c(this.dgj.getImageUrl(), 10, false);
        this.dgq.setText(this.dgj.getContent());
        this.dgs.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_b));
        this.dgs.setBackgroundResource(w.g.btn_appdownload);
        if (!TextUtils.isEmpty(this.dgj.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, k.g(getContext(), w.f.ds60));
            int g = k.g(getContext(), w.f.ds30);
            layoutParams2.setMargins(g, k.g(getContext(), w.f.ds18), g, g);
            this.dgs.setLayoutParams(layoutParams2);
            this.dgs.setVisibility(0);
            this.dgs.setText(this.dgj.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int g2 = k.g(getContext(), w.f.ds30);
            layoutParams3.setMargins(g2, k.g(getContext(), w.f.ds20), g2, g2);
            this.dgs.setVisibility(8);
            this.dgv.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.dgj.getShareSource())) {
            this.cQT.setVisibility(8);
        }
        this.dgw.setText(this.dgj.getShareSource());
        this.dgt.setDefaultResource(w.g.icon);
        this.dgt.setAutoChangeStyle(false);
        this.dgt.c(this.dgj.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", m.qk(this.dgj.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.cQT;
    }

    public LinearLayout getContentBody() {
        return this.dgu;
    }

    public ImageView getTiebaIcon() {
        return this.dgt;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.dgt = tbImageView;
    }
}
