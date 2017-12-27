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
    private ShareFromGameCenterMsgData eIe;
    private TextView eIl;
    private HeadImageView eIm;
    private Button eIn;
    private TbImageView eIo;
    private LinearLayout eIp;
    private LinearLayout eIq;
    private TextView eIr;
    private LinearLayout etn;
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
        this.eIp = (LinearLayout) findViewById(d.g.share_info_layout);
        this.eIq = (LinearLayout) findViewById(d.g.game_share_content);
        this.etn = (LinearLayout) findViewById(d.g.small_tail);
        this.mTitle = (TextView) findViewById(d.g.game_title);
        this.eIl = (TextView) findViewById(d.g.game_desc);
        this.eIm = (HeadImageView) findViewById(d.g.game_img);
        this.eIm.setDefaultResource(d.f.pic_avatar_ba_140);
        this.eIm.setAutoChangeStyle(false);
        this.eIn = (Button) findViewById(d.g.accept_invite_button);
        this.eIo = (TbImageView) findViewById(d.g.tail_icon);
        this.eIo.setDefaultResource(d.f.icon);
        this.eIo.setAutoChangeStyle(false);
        this.eIr = (TextView) findViewById(d.g.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.eIe = shareFromGameCenterMsgData;
            hF(z);
        }
    }

    private void hF(boolean z) {
        if (z) {
            this.eIp.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0108d.cp_cont_g));
            this.eIl.setTextColor(this.mContext.getResources().getColor(d.C0108d.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0108d.cp_cont_b));
            this.eIl.setTextColor(this.mContext.getResources().getColor(d.C0108d.cp_cont_f));
            this.eIp.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.s(getContext(), d.e.ds14), 0, 0, 0);
            layoutParams.height = l.s(getContext(), d.e.ds48);
            this.etn.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.eIe.getTitle());
        this.eIm.setDefaultResource(d.f.pic_avatar_ba_140);
        this.eIm.setAutoChangeStyle(false);
        this.eIm.startLoad(this.eIe.getImageUrl(), 10, false);
        this.eIl.setText(this.eIe.getContent());
        this.eIn.setTextColor(this.mContext.getResources().getColor(d.C0108d.cp_cont_b));
        this.eIn.setBackgroundResource(d.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.eIe.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.s(getContext(), d.e.ds60));
            int s = l.s(getContext(), d.e.ds30);
            layoutParams2.setMargins(s, l.s(getContext(), d.e.ds18), s, s);
            this.eIn.setLayoutParams(layoutParams2);
            this.eIn.setVisibility(0);
            this.eIn.setText(this.eIe.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int s2 = l.s(getContext(), d.e.ds30);
            layoutParams3.setMargins(s2, l.s(getContext(), d.e.ds20), s2, s2);
            this.eIn.setVisibility(8);
            this.eIq.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.eIe.getShareSource())) {
            this.etn.setVisibility(8);
        }
        this.eIr.setText(this.eIe.getShareSource());
        this.eIo.setDefaultResource(d.f.icon);
        this.eIo.setAutoChangeStyle(false);
        this.eIo.startLoad(this.eIe.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.tk(this.eIe.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.etn;
    }

    public LinearLayout getContentBody() {
        return this.eIp;
    }

    public ImageView getTiebaIcon() {
        return this.eIo;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.eIo = tbImageView;
    }
}
