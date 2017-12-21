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
    private LinearLayout dHh;
    private ShareFromGameCenterMsgData dWa;
    private TextView dWh;
    private HeadImageView dWi;
    private Button dWj;
    private TbImageView dWk;
    private LinearLayout dWl;
    private LinearLayout dWm;
    private TextView dWn;
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
        this.dWl = (LinearLayout) findViewById(d.g.share_info_layout);
        this.dWm = (LinearLayout) findViewById(d.g.game_share_content);
        this.dHh = (LinearLayout) findViewById(d.g.small_tail);
        this.mTitle = (TextView) findViewById(d.g.game_title);
        this.dWh = (TextView) findViewById(d.g.game_desc);
        this.dWi = (HeadImageView) findViewById(d.g.game_img);
        this.dWi.setDefaultResource(d.f.pic_avatar_ba_140);
        this.dWi.setAutoChangeStyle(false);
        this.dWj = (Button) findViewById(d.g.accept_invite_button);
        this.dWk = (TbImageView) findViewById(d.g.tail_icon);
        this.dWk.setDefaultResource(d.f.icon);
        this.dWk.setAutoChangeStyle(false);
        this.dWn = (TextView) findViewById(d.g.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.dWa = shareFromGameCenterMsgData;
            hg(z);
        }
    }

    private void hg(boolean z) {
        if (z) {
            this.dWl.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0095d.cp_cont_g));
            this.dWh.setTextColor(this.mContext.getResources().getColor(d.C0095d.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0095d.cp_cont_b));
            this.dWh.setTextColor(this.mContext.getResources().getColor(d.C0095d.cp_cont_f));
            this.dWl.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.f(getContext(), d.e.ds14), 0, 0, 0);
            layoutParams.height = l.f(getContext(), d.e.ds48);
            this.dHh.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.dWa.getTitle());
        this.dWi.setDefaultResource(d.f.pic_avatar_ba_140);
        this.dWi.setAutoChangeStyle(false);
        this.dWi.startLoad(this.dWa.getImageUrl(), 10, false);
        this.dWh.setText(this.dWa.getContent());
        this.dWj.setTextColor(this.mContext.getResources().getColor(d.C0095d.cp_cont_b));
        this.dWj.setBackgroundResource(d.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.dWa.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.f(getContext(), d.e.ds60));
            int f = l.f(getContext(), d.e.ds30);
            layoutParams2.setMargins(f, l.f(getContext(), d.e.ds18), f, f);
            this.dWj.setLayoutParams(layoutParams2);
            this.dWj.setVisibility(0);
            this.dWj.setText(this.dWa.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int f2 = l.f(getContext(), d.e.ds30);
            layoutParams3.setMargins(f2, l.f(getContext(), d.e.ds20), f2, f2);
            this.dWj.setVisibility(8);
            this.dWm.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.dWa.getShareSource())) {
            this.dHh.setVisibility(8);
        }
        this.dWn.setText(this.dWa.getShareSource());
        this.dWk.setDefaultResource(d.f.icon);
        this.dWk.setAutoChangeStyle(false);
        this.dWk.startLoad(this.dWa.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.tl(this.dWa.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.dHh;
    }

    public LinearLayout getContentBody() {
        return this.dWl;
    }

    public ImageView getTiebaIcon() {
        return this.dWk;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.dWk = tbImageView;
    }
}
