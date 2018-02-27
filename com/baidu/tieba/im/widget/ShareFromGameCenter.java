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
    private ShareFromGameCenterMsgData eOc;
    private TextView eOj;
    private HeadImageView eOk;
    private Button eOl;
    private TbImageView eOm;
    private LinearLayout eOn;
    private LinearLayout eOo;
    private TextView eOp;
    private LinearLayout ezh;
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
        this.eOn = (LinearLayout) findViewById(d.g.share_info_layout);
        this.eOo = (LinearLayout) findViewById(d.g.game_share_content);
        this.ezh = (LinearLayout) findViewById(d.g.small_tail);
        this.mTitle = (TextView) findViewById(d.g.game_title);
        this.eOj = (TextView) findViewById(d.g.game_desc);
        this.eOk = (HeadImageView) findViewById(d.g.game_img);
        this.eOk.setDefaultResource(d.f.pic_avatar_ba_140);
        this.eOk.setAutoChangeStyle(false);
        this.eOl = (Button) findViewById(d.g.accept_invite_button);
        this.eOm = (TbImageView) findViewById(d.g.tail_icon);
        this.eOm.setDefaultResource(d.f.icon);
        this.eOm.setAutoChangeStyle(false);
        this.eOp = (TextView) findViewById(d.g.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.eOc = shareFromGameCenterMsgData;
            hV(z);
        }
    }

    private void hV(boolean z) {
        if (z) {
            this.eOn.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0141d.cp_cont_g));
            this.eOj.setTextColor(this.mContext.getResources().getColor(d.C0141d.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0141d.cp_cont_b));
            this.eOj.setTextColor(this.mContext.getResources().getColor(d.C0141d.cp_cont_f));
            this.eOn.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.t(getContext(), d.e.ds14), 0, 0, 0);
            layoutParams.height = l.t(getContext(), d.e.ds48);
            this.ezh.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.eOc.getTitle());
        this.eOk.setDefaultResource(d.f.pic_avatar_ba_140);
        this.eOk.setAutoChangeStyle(false);
        this.eOk.startLoad(this.eOc.getImageUrl(), 10, false);
        this.eOj.setText(this.eOc.getContent());
        this.eOl.setTextColor(this.mContext.getResources().getColor(d.C0141d.cp_cont_b));
        this.eOl.setBackgroundResource(d.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.eOc.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.t(getContext(), d.e.ds60));
            int t = l.t(getContext(), d.e.ds30);
            layoutParams2.setMargins(t, l.t(getContext(), d.e.ds18), t, t);
            this.eOl.setLayoutParams(layoutParams2);
            this.eOl.setVisibility(0);
            this.eOl.setText(this.eOc.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int t2 = l.t(getContext(), d.e.ds30);
            layoutParams3.setMargins(t2, l.t(getContext(), d.e.ds20), t2, t2);
            this.eOl.setVisibility(8);
            this.eOo.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.eOc.getShareSource())) {
            this.ezh.setVisibility(8);
        }
        this.eOp.setText(this.eOc.getShareSource());
        this.eOm.setDefaultResource(d.f.icon);
        this.eOm.setAutoChangeStyle(false);
        this.eOm.startLoad(this.eOc.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.sT(this.eOc.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.ezh;
    }

    public LinearLayout getContentBody() {
        return this.eOn;
    }

    public ImageView getTiebaIcon() {
        return this.eOm;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.eOm = tbImageView;
    }
}
