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
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private TextView dLk;
    private TextView eKA;
    private ShareFromGameCenterMsgData eKo;
    private HeadImageView eKv;
    private Button eKw;
    private TbImageView eKx;
    private LinearLayout eKy;
    private LinearLayout eKz;
    private LinearLayout evt;
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
        LayoutInflater.from(getContext()).inflate(e.h.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.eKy = (LinearLayout) findViewById(e.g.share_info_layout);
        this.eKz = (LinearLayout) findViewById(e.g.game_share_content);
        this.evt = (LinearLayout) findViewById(e.g.small_tail);
        this.mTitle = (TextView) findViewById(e.g.game_title);
        this.dLk = (TextView) findViewById(e.g.game_desc);
        this.eKv = (HeadImageView) findViewById(e.g.game_img);
        this.eKv.setDefaultResource(e.f.pic_avatar_ba_140);
        this.eKv.setAutoChangeStyle(false);
        this.eKw = (Button) findViewById(e.g.accept_invite_button);
        this.eKx = (TbImageView) findViewById(e.g.tail_icon);
        this.eKx.setDefaultResource(e.f.icon);
        this.eKx.setAutoChangeStyle(false);
        this.eKA = (TextView) findViewById(e.g.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.eKo = shareFromGameCenterMsgData;
            is(z);
        }
    }

    private void is(boolean z) {
        if (z) {
            this.eKy.setBackgroundDrawable(this.mContext.getResources().getDrawable(e.f.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_g));
            this.dLk.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_b));
            this.dLk.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_f));
            this.eKy.setBackgroundDrawable(this.mContext.getResources().getDrawable(e.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.h(getContext(), e.C0141e.ds14), 0, 0, 0);
            layoutParams.height = l.h(getContext(), e.C0141e.ds48);
            this.evt.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.eKo.getTitle());
        this.eKv.setDefaultResource(e.f.pic_avatar_ba_140);
        this.eKv.setAutoChangeStyle(false);
        this.eKv.startLoad(this.eKo.getImageUrl(), 10, false);
        this.dLk.setText(this.eKo.getContent());
        this.eKw.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_b));
        this.eKw.setBackgroundResource(e.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.eKo.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.h(getContext(), e.C0141e.ds60));
            int h = l.h(getContext(), e.C0141e.ds30);
            layoutParams2.setMargins(h, l.h(getContext(), e.C0141e.ds18), h, h);
            this.eKw.setLayoutParams(layoutParams2);
            this.eKw.setVisibility(0);
            this.eKw.setText(this.eKo.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int h2 = l.h(getContext(), e.C0141e.ds30);
            layoutParams3.setMargins(h2, l.h(getContext(), e.C0141e.ds20), h2, h2);
            this.eKw.setVisibility(8);
            this.eKz.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.eKo.getShareSource())) {
            this.evt.setVisibility(8);
        }
        this.eKA.setText(this.eKo.getShareSource());
        this.eKx.setDefaultResource(e.f.icon);
        this.eKx.setAutoChangeStyle(false);
        this.eKx.startLoad(this.eKo.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.uG(this.eKo.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.evt;
    }

    public LinearLayout getContentBody() {
        return this.eKy;
    }

    public ImageView getTiebaIcon() {
        return this.eKx;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.eKx = tbImageView;
    }
}
