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
    private ShareFromGameCenterMsgData dJj;
    private TextView dJq;
    private HeadImageView dJr;
    private Button dJs;
    private TbImageView dJt;
    private LinearLayout dJu;
    private LinearLayout dJv;
    private TextView dJw;
    private LinearLayout dtZ;
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
        this.dJu = (LinearLayout) findViewById(d.h.share_info_layout);
        this.dJv = (LinearLayout) findViewById(d.h.game_share_content);
        this.dtZ = (LinearLayout) findViewById(d.h.small_tail);
        this.mTitle = (TextView) findViewById(d.h.game_title);
        this.dJq = (TextView) findViewById(d.h.game_desc);
        this.dJr = (HeadImageView) findViewById(d.h.game_img);
        this.dJr.setDefaultResource(d.g.pic_avatar_ba_140);
        this.dJr.setAutoChangeStyle(false);
        this.dJs = (Button) findViewById(d.h.accept_invite_button);
        this.dJt = (TbImageView) findViewById(d.h.tail_icon);
        this.dJt.setDefaultResource(d.g.icon);
        this.dJt.setAutoChangeStyle(false);
        this.dJw = (TextView) findViewById(d.h.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.dJj = shareFromGameCenterMsgData;
            gX(z);
        }
    }

    private void gX(boolean z) {
        if (z) {
            this.dJu.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.g.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_g));
            this.dJq.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_b));
            this.dJq.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_f));
            this.dJu.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.g.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(k.f(getContext(), d.f.ds14), 0, 0, 0);
            layoutParams.height = k.f(getContext(), d.f.ds48);
            this.dtZ.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.dJj.getTitle());
        this.dJr.setDefaultResource(d.g.pic_avatar_ba_140);
        this.dJr.setAutoChangeStyle(false);
        this.dJr.c(this.dJj.getImageUrl(), 10, false);
        this.dJq.setText(this.dJj.getContent());
        this.dJs.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_b));
        this.dJs.setBackgroundResource(d.g.btn_appdownload);
        if (!TextUtils.isEmpty(this.dJj.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, k.f(getContext(), d.f.ds60));
            int f = k.f(getContext(), d.f.ds30);
            layoutParams2.setMargins(f, k.f(getContext(), d.f.ds18), f, f);
            this.dJs.setLayoutParams(layoutParams2);
            this.dJs.setVisibility(0);
            this.dJs.setText(this.dJj.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int f2 = k.f(getContext(), d.f.ds30);
            layoutParams3.setMargins(f2, k.f(getContext(), d.f.ds20), f2, f2);
            this.dJs.setVisibility(8);
            this.dJv.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.dJj.getShareSource())) {
            this.dtZ.setVisibility(8);
        }
        this.dJw.setText(this.dJj.getShareSource());
        this.dJt.setDefaultResource(d.g.icon);
        this.dJt.setAutoChangeStyle(false);
        this.dJt.c(this.dJj.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.sm(this.dJj.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.dtZ;
    }

    public LinearLayout getContentBody() {
        return this.dJu;
    }

    public ImageView getTiebaIcon() {
        return this.dJt;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.dJt = tbImageView;
    }
}
