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
    private LinearLayout dIA;
    private TextView dIB;
    private ShareFromGameCenterMsgData dIo;
    private TextView dIv;
    private HeadImageView dIw;
    private Button dIx;
    private TbImageView dIy;
    private LinearLayout dIz;
    private LinearLayout dte;
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
        LayoutInflater.from(getContext()).inflate(d.j.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.dIz = (LinearLayout) findViewById(d.h.share_info_layout);
        this.dIA = (LinearLayout) findViewById(d.h.game_share_content);
        this.dte = (LinearLayout) findViewById(d.h.small_tail);
        this.mTitle = (TextView) findViewById(d.h.game_title);
        this.dIv = (TextView) findViewById(d.h.game_desc);
        this.dIw = (HeadImageView) findViewById(d.h.game_img);
        this.dIw.setDefaultResource(d.g.pic_avatar_ba_140);
        this.dIw.setAutoChangeStyle(false);
        this.dIx = (Button) findViewById(d.h.accept_invite_button);
        this.dIy = (TbImageView) findViewById(d.h.tail_icon);
        this.dIy.setDefaultResource(d.g.icon);
        this.dIy.setAutoChangeStyle(false);
        this.dIB = (TextView) findViewById(d.h.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.dIo = shareFromGameCenterMsgData;
            gW(z);
        }
    }

    private void gW(boolean z) {
        if (z) {
            this.dIz.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.g.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_g));
            this.dIv.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_b));
            this.dIv.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_f));
            this.dIz.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.g.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(k.g(getContext(), d.f.ds14), 0, 0, 0);
            layoutParams.height = k.g(getContext(), d.f.ds48);
            this.dte.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.dIo.getTitle());
        this.dIw.setDefaultResource(d.g.pic_avatar_ba_140);
        this.dIw.setAutoChangeStyle(false);
        this.dIw.c(this.dIo.getImageUrl(), 10, false);
        this.dIv.setText(this.dIo.getContent());
        this.dIx.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_b));
        this.dIx.setBackgroundResource(d.g.btn_appdownload);
        if (!TextUtils.isEmpty(this.dIo.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, k.g(getContext(), d.f.ds60));
            int g = k.g(getContext(), d.f.ds30);
            layoutParams2.setMargins(g, k.g(getContext(), d.f.ds18), g, g);
            this.dIx.setLayoutParams(layoutParams2);
            this.dIx.setVisibility(0);
            this.dIx.setText(this.dIo.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int g2 = k.g(getContext(), d.f.ds30);
            layoutParams3.setMargins(g2, k.g(getContext(), d.f.ds20), g2, g2);
            this.dIx.setVisibility(8);
            this.dIA.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.dIo.getShareSource())) {
            this.dte.setVisibility(8);
        }
        this.dIB.setText(this.dIo.getShareSource());
        this.dIy.setDefaultResource(d.g.icon);
        this.dIy.setAutoChangeStyle(false);
        this.dIy.c(this.dIo.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.sk(this.dIo.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.dte;
    }

    public LinearLayout getContentBody() {
        return this.dIz;
    }

    public ImageView getTiebaIcon() {
        return this.dIy;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.dIy = tbImageView;
    }
}
