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
    private TextView aNY;
    private LinearLayout cIX;
    private ShareFromGameCenterMsgData cYg;
    private TextView cYl;
    private HeadImageView cYm;
    private Button cYn;
    private TbImageView cYo;
    private LinearLayout cYp;
    private LinearLayout cYq;
    private TextView cYr;
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
        LayoutInflater.from(getContext()).inflate(r.h.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.cYp = (LinearLayout) findViewById(r.g.share_info_layout);
        this.cYq = (LinearLayout) findViewById(r.g.game_share_content);
        this.cIX = (LinearLayout) findViewById(r.g.small_tail);
        this.aNY = (TextView) findViewById(r.g.game_title);
        this.cYl = (TextView) findViewById(r.g.game_desc);
        this.cYm = (HeadImageView) findViewById(r.g.game_img);
        this.cYm.setDefaultResource(r.f.pic_avatar_ba_140);
        this.cYm.setAutoChangeStyle(false);
        this.cYn = (Button) findViewById(r.g.accept_invite_button);
        this.cYo = (TbImageView) findViewById(r.g.tail_icon);
        this.cYo.setDefaultResource(r.f.icon);
        this.cYo.setAutoChangeStyle(false);
        this.cYr = (TextView) findViewById(r.g.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.cYg = shareFromGameCenterMsgData;
            gn(z);
        }
    }

    private void gn(boolean z) {
        if (z) {
            this.cYp.setBackgroundDrawable(this.mContext.getResources().getDrawable(r.f.selector_msg_text_bubble_me));
            this.aNY.setTextColor(this.mContext.getResources().getColor(r.d.cp_cont_g));
            this.cYl.setTextColor(this.mContext.getResources().getColor(r.d.cp_cont_g));
        } else {
            this.aNY.setTextColor(this.mContext.getResources().getColor(r.d.cp_cont_b));
            this.cYl.setTextColor(this.mContext.getResources().getColor(r.d.cp_cont_f));
            this.cYp.setBackgroundDrawable(this.mContext.getResources().getDrawable(r.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(k.e(getContext(), r.e.ds14), 0, 0, 0);
            layoutParams.height = k.e(getContext(), r.e.ds48);
            this.cIX.setLayoutParams(layoutParams);
        }
        this.aNY.setText(this.cYg.getTitle());
        this.cYm.setDefaultResource(r.f.pic_avatar_ba_140);
        this.cYm.setAutoChangeStyle(false);
        this.cYm.c(this.cYg.getImageUrl(), 10, false);
        this.cYl.setText(this.cYg.getContent());
        this.cYn.setTextColor(this.mContext.getResources().getColor(r.d.cp_cont_b));
        this.cYn.setBackgroundResource(r.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.cYg.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, k.e(getContext(), r.e.ds60));
            int e = k.e(getContext(), r.e.ds30);
            layoutParams2.setMargins(e, k.e(getContext(), r.e.ds18), e, e);
            this.cYn.setLayoutParams(layoutParams2);
            this.cYn.setVisibility(0);
            this.cYn.setText(this.cYg.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int e2 = k.e(getContext(), r.e.ds30);
            layoutParams3.setMargins(e2, k.e(getContext(), r.e.ds20), e2, e2);
            this.cYn.setVisibility(8);
            this.cYq.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.cYg.getShareSource())) {
            this.cIX.setVisibility(8);
        }
        this.cYr.setText(this.cYg.getShareSource());
        this.cYo.setDefaultResource(r.f.icon);
        this.cYo.setAutoChangeStyle(false);
        this.cYo.c(this.cYg.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", m.qr(this.cYg.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.cIX;
    }

    public LinearLayout getContentBody() {
        return this.cYp;
    }

    public ImageView getTiebaIcon() {
        return this.cYo;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.cYo = tbImageView;
    }
}
