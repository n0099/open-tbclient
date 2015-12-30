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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private TextView aOn;
    private LinearLayout bNU;
    private TextView bfz;
    private ShareFromGameCenterMsgData ccl;
    private HeadImageView ccq;
    private Button ccr;
    private TbImageView ccs;
    private LinearLayout cct;
    private LinearLayout ccu;
    private TextView ccv;
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
        LayoutInflater.from(getContext()).inflate(n.h.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.cct = (LinearLayout) findViewById(n.g.share_info_layout);
        this.ccu = (LinearLayout) findViewById(n.g.game_share_content);
        this.bNU = (LinearLayout) findViewById(n.g.small_tail);
        this.aOn = (TextView) findViewById(n.g.game_title);
        this.bfz = (TextView) findViewById(n.g.game_desc);
        this.ccq = (HeadImageView) findViewById(n.g.game_img);
        this.ccq.setDefaultResource(n.f.pic_avatar_ba_140);
        this.ccq.setAutoChangeStyle(false);
        this.ccr = (Button) findViewById(n.g.accept_invite_button);
        this.ccs = (TbImageView) findViewById(n.g.tail_icon);
        this.ccs.setDefaultResource(n.f.icon);
        this.ccs.setAutoChangeStyle(false);
        this.ccv = (TextView) findViewById(n.g.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.ccl = shareFromGameCenterMsgData;
            dO(z);
        }
    }

    private void dO(boolean z) {
        if (z) {
            this.cct.setBackgroundDrawable(this.mContext.getResources().getDrawable(n.f.selector_msg_text_bubble_me));
            this.aOn.setTextColor(this.mContext.getResources().getColor(n.d.cp_cont_g));
            this.bfz.setTextColor(this.mContext.getResources().getColor(n.d.cp_cont_g));
        } else {
            this.aOn.setTextColor(this.mContext.getResources().getColor(n.d.cp_cont_b));
            this.bfz.setTextColor(this.mContext.getResources().getColor(n.d.cp_cont_f));
            this.cct.setBackgroundDrawable(this.mContext.getResources().getDrawable(n.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(k.d(getContext(), n.e.ds14), 0, 0, 0);
            layoutParams.height = k.d(getContext(), n.e.ds48);
            this.bNU.setLayoutParams(layoutParams);
        }
        this.aOn.setText(this.ccl.getTitle());
        this.ccq.setDefaultResource(n.f.pic_avatar_ba_140);
        this.ccq.setAutoChangeStyle(false);
        this.ccq.d(this.ccl.getImageUrl(), 10, false);
        this.bfz.setText(this.ccl.getContent());
        this.ccr.setTextColor(this.mContext.getResources().getColor(n.d.cp_cont_b));
        this.ccr.setBackgroundResource(n.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.ccl.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, k.d(getContext(), n.e.ds60));
            int d = k.d(getContext(), n.e.ds30);
            layoutParams2.setMargins(d, k.d(getContext(), n.e.ds18), d, d);
            this.ccr.setLayoutParams(layoutParams2);
            this.ccr.setVisibility(0);
            this.ccr.setText(this.ccl.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int d2 = k.d(getContext(), n.e.ds30);
            layoutParams3.setMargins(d2, k.d(getContext(), n.e.ds20), d2, d2);
            this.ccr.setVisibility(8);
            this.ccu.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.ccl.getShareSource())) {
            this.bNU.setVisibility(8);
        }
        this.ccv.setText(this.ccl.getShareSource());
        this.ccs.setDefaultResource(n.f.icon);
        this.ccs.setAutoChangeStyle(false);
        this.ccs.d(this.ccl.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.n.mz(this.ccl.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.bNU;
    }

    public LinearLayout getContentBody() {
        return this.cct;
    }

    public ImageView getTiebaIcon() {
        return this.ccs;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.ccs = tbImageView;
    }
}
