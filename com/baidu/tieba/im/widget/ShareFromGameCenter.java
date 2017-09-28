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
    private TextView dFF;
    private HeadImageView dFG;
    private Button dFH;
    private TbImageView dFI;
    private LinearLayout dFJ;
    private LinearLayout dFK;
    private TextView dFL;
    private ShareFromGameCenterMsgData dFy;
    private LinearLayout dqp;
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
        this.dFJ = (LinearLayout) findViewById(d.h.share_info_layout);
        this.dFK = (LinearLayout) findViewById(d.h.game_share_content);
        this.dqp = (LinearLayout) findViewById(d.h.small_tail);
        this.mTitle = (TextView) findViewById(d.h.game_title);
        this.dFF = (TextView) findViewById(d.h.game_desc);
        this.dFG = (HeadImageView) findViewById(d.h.game_img);
        this.dFG.setDefaultResource(d.g.pic_avatar_ba_140);
        this.dFG.setAutoChangeStyle(false);
        this.dFH = (Button) findViewById(d.h.accept_invite_button);
        this.dFI = (TbImageView) findViewById(d.h.tail_icon);
        this.dFI.setDefaultResource(d.g.icon);
        this.dFI.setAutoChangeStyle(false);
        this.dFL = (TextView) findViewById(d.h.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.dFy = shareFromGameCenterMsgData;
            gK(z);
        }
    }

    private void gK(boolean z) {
        if (z) {
            this.dFJ.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.g.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_g));
            this.dFF.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_b));
            this.dFF.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_f));
            this.dFJ.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.g.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.f(getContext(), d.f.ds14), 0, 0, 0);
            layoutParams.height = l.f(getContext(), d.f.ds48);
            this.dqp.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.dFy.getTitle());
        this.dFG.setDefaultResource(d.g.pic_avatar_ba_140);
        this.dFG.setAutoChangeStyle(false);
        this.dFG.c(this.dFy.getImageUrl(), 10, false);
        this.dFF.setText(this.dFy.getContent());
        this.dFH.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_b));
        this.dFH.setBackgroundResource(d.g.btn_appdownload);
        if (!TextUtils.isEmpty(this.dFy.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.f(getContext(), d.f.ds60));
            int f = l.f(getContext(), d.f.ds30);
            layoutParams2.setMargins(f, l.f(getContext(), d.f.ds18), f, f);
            this.dFH.setLayoutParams(layoutParams2);
            this.dFH.setVisibility(0);
            this.dFH.setText(this.dFy.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int f2 = l.f(getContext(), d.f.ds30);
            layoutParams3.setMargins(f2, l.f(getContext(), d.f.ds20), f2, f2);
            this.dFH.setVisibility(8);
            this.dFK.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.dFy.getShareSource())) {
            this.dqp.setVisibility(8);
        }
        this.dFL.setText(this.dFy.getShareSource());
        this.dFI.setDefaultResource(d.g.icon);
        this.dFI.setAutoChangeStyle(false);
        this.dFI.c(this.dFy.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.rW(this.dFy.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.dqp;
    }

    public LinearLayout getContentBody() {
        return this.dFJ;
    }

    public ImageView getTiebaIcon() {
        return this.dFI;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.dFI = tbImageView;
    }
}
