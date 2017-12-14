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
    private LinearLayout dHd;
    private ShareFromGameCenterMsgData dVW;
    private TextView dWd;
    private HeadImageView dWe;
    private Button dWf;
    private TbImageView dWg;
    private LinearLayout dWh;
    private LinearLayout dWi;
    private TextView dWj;
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
        this.dWh = (LinearLayout) findViewById(d.g.share_info_layout);
        this.dWi = (LinearLayout) findViewById(d.g.game_share_content);
        this.dHd = (LinearLayout) findViewById(d.g.small_tail);
        this.mTitle = (TextView) findViewById(d.g.game_title);
        this.dWd = (TextView) findViewById(d.g.game_desc);
        this.dWe = (HeadImageView) findViewById(d.g.game_img);
        this.dWe.setDefaultResource(d.f.pic_avatar_ba_140);
        this.dWe.setAutoChangeStyle(false);
        this.dWf = (Button) findViewById(d.g.accept_invite_button);
        this.dWg = (TbImageView) findViewById(d.g.tail_icon);
        this.dWg.setDefaultResource(d.f.icon);
        this.dWg.setAutoChangeStyle(false);
        this.dWj = (TextView) findViewById(d.g.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.dVW = shareFromGameCenterMsgData;
            hg(z);
        }
    }

    private void hg(boolean z) {
        if (z) {
            this.dWh.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0096d.cp_cont_g));
            this.dWd.setTextColor(this.mContext.getResources().getColor(d.C0096d.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0096d.cp_cont_b));
            this.dWd.setTextColor(this.mContext.getResources().getColor(d.C0096d.cp_cont_f));
            this.dWh.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.f(getContext(), d.e.ds14), 0, 0, 0);
            layoutParams.height = l.f(getContext(), d.e.ds48);
            this.dHd.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.dVW.getTitle());
        this.dWe.setDefaultResource(d.f.pic_avatar_ba_140);
        this.dWe.setAutoChangeStyle(false);
        this.dWe.startLoad(this.dVW.getImageUrl(), 10, false);
        this.dWd.setText(this.dVW.getContent());
        this.dWf.setTextColor(this.mContext.getResources().getColor(d.C0096d.cp_cont_b));
        this.dWf.setBackgroundResource(d.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.dVW.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.f(getContext(), d.e.ds60));
            int f = l.f(getContext(), d.e.ds30);
            layoutParams2.setMargins(f, l.f(getContext(), d.e.ds18), f, f);
            this.dWf.setLayoutParams(layoutParams2);
            this.dWf.setVisibility(0);
            this.dWf.setText(this.dVW.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int f2 = l.f(getContext(), d.e.ds30);
            layoutParams3.setMargins(f2, l.f(getContext(), d.e.ds20), f2, f2);
            this.dWf.setVisibility(8);
            this.dWi.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.dVW.getShareSource())) {
            this.dHd.setVisibility(8);
        }
        this.dWj.setText(this.dVW.getShareSource());
        this.dWg.setDefaultResource(d.f.icon);
        this.dWg.setAutoChangeStyle(false);
        this.dWg.startLoad(this.dVW.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.tl(this.dVW.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.dHd;
    }

    public LinearLayout getContentBody() {
        return this.dWh;
    }

    public ImageView getTiebaIcon() {
        return this.dWg;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.dWg = tbImageView;
    }
}
