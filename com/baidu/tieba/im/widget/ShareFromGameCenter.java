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
    private ShareFromGameCenterMsgData dMY;
    private TextView dNf;
    private HeadImageView dNg;
    private Button dNh;
    private TbImageView dNi;
    private LinearLayout dNj;
    private LinearLayout dNk;
    private TextView dNl;
    private LinearLayout dxR;
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
        this.dNj = (LinearLayout) findViewById(d.g.share_info_layout);
        this.dNk = (LinearLayout) findViewById(d.g.game_share_content);
        this.dxR = (LinearLayout) findViewById(d.g.small_tail);
        this.mTitle = (TextView) findViewById(d.g.game_title);
        this.dNf = (TextView) findViewById(d.g.game_desc);
        this.dNg = (HeadImageView) findViewById(d.g.game_img);
        this.dNg.setDefaultResource(d.f.pic_avatar_ba_140);
        this.dNg.setAutoChangeStyle(false);
        this.dNh = (Button) findViewById(d.g.accept_invite_button);
        this.dNi = (TbImageView) findViewById(d.g.tail_icon);
        this.dNi.setDefaultResource(d.f.icon);
        this.dNi.setAutoChangeStyle(false);
        this.dNl = (TextView) findViewById(d.g.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.dMY = shareFromGameCenterMsgData;
            gF(z);
        }
    }

    private void gF(boolean z) {
        if (z) {
            this.dNj.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0080d.cp_cont_g));
            this.dNf.setTextColor(this.mContext.getResources().getColor(d.C0080d.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0080d.cp_cont_b));
            this.dNf.setTextColor(this.mContext.getResources().getColor(d.C0080d.cp_cont_f));
            this.dNj.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.f(getContext(), d.e.ds14), 0, 0, 0);
            layoutParams.height = l.f(getContext(), d.e.ds48);
            this.dxR.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.dMY.getTitle());
        this.dNg.setDefaultResource(d.f.pic_avatar_ba_140);
        this.dNg.setAutoChangeStyle(false);
        this.dNg.startLoad(this.dMY.getImageUrl(), 10, false);
        this.dNf.setText(this.dMY.getContent());
        this.dNh.setTextColor(this.mContext.getResources().getColor(d.C0080d.cp_cont_b));
        this.dNh.setBackgroundResource(d.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.dMY.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.f(getContext(), d.e.ds60));
            int f = l.f(getContext(), d.e.ds30);
            layoutParams2.setMargins(f, l.f(getContext(), d.e.ds18), f, f);
            this.dNh.setLayoutParams(layoutParams2);
            this.dNh.setVisibility(0);
            this.dNh.setText(this.dMY.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int f2 = l.f(getContext(), d.e.ds30);
            layoutParams3.setMargins(f2, l.f(getContext(), d.e.ds20), f2, f2);
            this.dNh.setVisibility(8);
            this.dNk.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.dMY.getShareSource())) {
            this.dxR.setVisibility(8);
        }
        this.dNl.setText(this.dMY.getShareSource());
        this.dNi.setDefaultResource(d.f.icon);
        this.dNi.setAutoChangeStyle(false);
        this.dNi.startLoad(this.dMY.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.sD(this.dMY.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.dxR;
    }

    public LinearLayout getContentBody() {
        return this.dNj;
    }

    public ImageView getTiebaIcon() {
        return this.dNi;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.dNi = tbImageView;
    }
}
