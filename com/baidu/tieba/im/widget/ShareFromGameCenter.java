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
    private LinearLayout dFZ;
    private ShareFromGameCenterMsgData dUR;
    private TextView dUY;
    private HeadImageView dUZ;
    private Button dVa;
    private TbImageView dVb;
    private LinearLayout dVc;
    private LinearLayout dVd;
    private TextView dVe;
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
        this.dVc = (LinearLayout) findViewById(d.g.share_info_layout);
        this.dVd = (LinearLayout) findViewById(d.g.game_share_content);
        this.dFZ = (LinearLayout) findViewById(d.g.small_tail);
        this.mTitle = (TextView) findViewById(d.g.game_title);
        this.dUY = (TextView) findViewById(d.g.game_desc);
        this.dUZ = (HeadImageView) findViewById(d.g.game_img);
        this.dUZ.setDefaultResource(d.f.pic_avatar_ba_140);
        this.dUZ.setAutoChangeStyle(false);
        this.dVa = (Button) findViewById(d.g.accept_invite_button);
        this.dVb = (TbImageView) findViewById(d.g.tail_icon);
        this.dVb.setDefaultResource(d.f.icon);
        this.dVb.setAutoChangeStyle(false);
        this.dVe = (TextView) findViewById(d.g.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.dUR = shareFromGameCenterMsgData;
            hf(z);
        }
    }

    private void hf(boolean z) {
        if (z) {
            this.dVc.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0082d.cp_cont_g));
            this.dUY.setTextColor(this.mContext.getResources().getColor(d.C0082d.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0082d.cp_cont_b));
            this.dUY.setTextColor(this.mContext.getResources().getColor(d.C0082d.cp_cont_f));
            this.dVc.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.f(getContext(), d.e.ds14), 0, 0, 0);
            layoutParams.height = l.f(getContext(), d.e.ds48);
            this.dFZ.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.dUR.getTitle());
        this.dUZ.setDefaultResource(d.f.pic_avatar_ba_140);
        this.dUZ.setAutoChangeStyle(false);
        this.dUZ.startLoad(this.dUR.getImageUrl(), 10, false);
        this.dUY.setText(this.dUR.getContent());
        this.dVa.setTextColor(this.mContext.getResources().getColor(d.C0082d.cp_cont_b));
        this.dVa.setBackgroundResource(d.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.dUR.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.f(getContext(), d.e.ds60));
            int f = l.f(getContext(), d.e.ds30);
            layoutParams2.setMargins(f, l.f(getContext(), d.e.ds18), f, f);
            this.dVa.setLayoutParams(layoutParams2);
            this.dVa.setVisibility(0);
            this.dVa.setText(this.dUR.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int f2 = l.f(getContext(), d.e.ds30);
            layoutParams3.setMargins(f2, l.f(getContext(), d.e.ds20), f2, f2);
            this.dVa.setVisibility(8);
            this.dVd.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.dUR.getShareSource())) {
            this.dFZ.setVisibility(8);
        }
        this.dVe.setText(this.dUR.getShareSource());
        this.dVb.setDefaultResource(d.f.icon);
        this.dVb.setAutoChangeStyle(false);
        this.dVb.startLoad(this.dUR.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.tg(this.dUR.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.dFZ;
    }

    public LinearLayout getContentBody() {
        return this.dVc;
    }

    public ImageView getTiebaIcon() {
        return this.dVb;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.dVb = tbImageView;
    }
}
