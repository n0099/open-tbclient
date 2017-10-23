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
    private ShareFromGameCenterMsgData dFk;
    private TextView dFr;
    private HeadImageView dFs;
    private Button dFt;
    private TbImageView dFu;
    private LinearLayout dFv;
    private LinearLayout dFw;
    private TextView dFx;
    private LinearLayout dqc;
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
        this.dFv = (LinearLayout) findViewById(d.h.share_info_layout);
        this.dFw = (LinearLayout) findViewById(d.h.game_share_content);
        this.dqc = (LinearLayout) findViewById(d.h.small_tail);
        this.mTitle = (TextView) findViewById(d.h.game_title);
        this.dFr = (TextView) findViewById(d.h.game_desc);
        this.dFs = (HeadImageView) findViewById(d.h.game_img);
        this.dFs.setDefaultResource(d.g.pic_avatar_ba_140);
        this.dFs.setAutoChangeStyle(false);
        this.dFt = (Button) findViewById(d.h.accept_invite_button);
        this.dFu = (TbImageView) findViewById(d.h.tail_icon);
        this.dFu.setDefaultResource(d.g.icon);
        this.dFu.setAutoChangeStyle(false);
        this.dFx = (TextView) findViewById(d.h.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.dFk = shareFromGameCenterMsgData;
            gJ(z);
        }
    }

    private void gJ(boolean z) {
        if (z) {
            this.dFv.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.g.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_g));
            this.dFr.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_b));
            this.dFr.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_f));
            this.dFv.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.g.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.f(getContext(), d.f.ds14), 0, 0, 0);
            layoutParams.height = l.f(getContext(), d.f.ds48);
            this.dqc.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.dFk.getTitle());
        this.dFs.setDefaultResource(d.g.pic_avatar_ba_140);
        this.dFs.setAutoChangeStyle(false);
        this.dFs.c(this.dFk.getImageUrl(), 10, false);
        this.dFr.setText(this.dFk.getContent());
        this.dFt.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_b));
        this.dFt.setBackgroundResource(d.g.btn_appdownload);
        if (!TextUtils.isEmpty(this.dFk.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.f(getContext(), d.f.ds60));
            int f = l.f(getContext(), d.f.ds30);
            layoutParams2.setMargins(f, l.f(getContext(), d.f.ds18), f, f);
            this.dFt.setLayoutParams(layoutParams2);
            this.dFt.setVisibility(0);
            this.dFt.setText(this.dFk.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int f2 = l.f(getContext(), d.f.ds30);
            layoutParams3.setMargins(f2, l.f(getContext(), d.f.ds20), f2, f2);
            this.dFt.setVisibility(8);
            this.dFw.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.dFk.getShareSource())) {
            this.dqc.setVisibility(8);
        }
        this.dFx.setText(this.dFk.getShareSource());
        this.dFu.setDefaultResource(d.g.icon);
        this.dFu.setAutoChangeStyle(false);
        this.dFu.c(this.dFk.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.rV(this.dFk.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.dqc;
    }

    public LinearLayout getContentBody() {
        return this.dFv;
    }

    public ImageView getTiebaIcon() {
        return this.dFu;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.dFu = tbImageView;
    }
}
