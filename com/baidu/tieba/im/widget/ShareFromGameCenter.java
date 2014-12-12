package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.k;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private LinearLayout aUA;
    private TextView avk;
    private ShareFromGameCenterMsgData bpk;
    private HeadImageView bpl;
    private Button bpm;
    private TbImageView bpn;
    private LinearLayout bpo;
    private LinearLayout bpp;
    private TextView bpq;
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
        com.baidu.adp.lib.g.b.ek().inflate(getContext(), x.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.bpo = (LinearLayout) findViewById(w.share_info_layout);
        this.bpp = (LinearLayout) findViewById(w.game_share_content);
        this.aUA = (LinearLayout) findViewById(w.small_tail);
        this.mTitle = (TextView) findViewById(w.game_title);
        this.avk = (TextView) findViewById(w.game_desc);
        this.bpl = (HeadImageView) findViewById(w.game_img);
        this.bpl.setDefaultResource(v.pic_avatar_ba_140);
        this.bpl.setAutoChangeStyle(false);
        this.bpm = (Button) findViewById(w.accept_invite_button);
        this.bpn = (TbImageView) findViewById(w.tail_icon);
        this.bpn.setDefaultResource(v.icon);
        this.bpn.setAutoChangeStyle(false);
        this.bpq = (TextView) findViewById(w.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.bpk = shareFromGameCenterMsgData;
            dh(z);
        }
    }

    private void dh(boolean z) {
        if (z) {
            this.bpo.setBackgroundDrawable(this.mContext.getResources().getDrawable(v.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(t.cp_cont_g));
            this.avk.setTextColor(this.mContext.getResources().getColor(t.cp_cont_g));
            this.bpm.setTextColor(this.mContext.getResources().getColor(t.cp_cont_b));
            this.bpm.setBackgroundResource(v.btn_appdownload);
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(t.cp_cont_b));
            this.avk.setTextColor(this.mContext.getResources().getColor(t.cp_cont_f));
            this.bpm.setBackgroundResource(v.frs_praise_btn_bg);
            this.bpm.setTextColor(this.mContext.getResources().getColor(t.cp_cont_i));
            this.bpo.setBackgroundDrawable(this.mContext.getResources().getDrawable(v.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.d(getContext(), u.ds14), 0, 0, 0);
            layoutParams.height = l.d(getContext(), u.ds48);
            this.aUA.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.bpk.getTitle());
        this.bpl.setDefaultResource(v.pic_avatar_ba_140);
        this.bpl.setAutoChangeStyle(false);
        this.bpl.d(this.bpk.getImageUrl(), 10, false);
        this.avk.setText(this.bpk.getContent());
        if (!TextUtils.isEmpty(this.bpk.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.d(getContext(), u.ds60));
            int d = l.d(getContext(), u.ds30);
            layoutParams2.setMargins(d, l.d(getContext(), u.ds18), d, d);
            this.bpm.setLayoutParams(layoutParams2);
            this.bpm.setVisibility(0);
            this.bpm.setText(this.bpk.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int d2 = l.d(getContext(), u.ds30);
            layoutParams3.setMargins(d2, l.d(getContext(), u.ds20), d2, d2);
            this.bpm.setVisibility(8);
            this.bpp.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.bpk.getShareSource())) {
            this.aUA.setVisibility(8);
        }
        this.bpq.setText(this.bpk.getShareSource());
        this.bpn.setDefaultResource(v.icon);
        this.bpn.setAutoChangeStyle(false);
        this.bpn.d(this.bpk.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", k.in(this.bpk.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.aUA;
    }

    public LinearLayout getContentBody() {
        return this.bpo;
    }

    public ImageView getTiebaIcon() {
        return this.bpn;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.bpn = tbImageView;
    }
}
