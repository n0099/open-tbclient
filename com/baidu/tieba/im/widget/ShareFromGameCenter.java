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
    private TextView aUB;
    private LinearLayout bKn;
    private ShareFromGameCenterMsgData bYl;
    private HeadImageView bYq;
    private Button bYr;
    private TbImageView bYs;
    private LinearLayout bYt;
    private LinearLayout bYu;
    private TextView bYv;
    private TextView bbA;
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
        LayoutInflater.from(getContext()).inflate(n.g.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.bYt = (LinearLayout) findViewById(n.f.share_info_layout);
        this.bYu = (LinearLayout) findViewById(n.f.game_share_content);
        this.bKn = (LinearLayout) findViewById(n.f.small_tail);
        this.aUB = (TextView) findViewById(n.f.game_title);
        this.bbA = (TextView) findViewById(n.f.game_desc);
        this.bYq = (HeadImageView) findViewById(n.f.game_img);
        this.bYq.setDefaultResource(n.e.pic_avatar_ba_140);
        this.bYq.setAutoChangeStyle(false);
        this.bYr = (Button) findViewById(n.f.accept_invite_button);
        this.bYs = (TbImageView) findViewById(n.f.tail_icon);
        this.bYs.setDefaultResource(n.e.icon);
        this.bYs.setAutoChangeStyle(false);
        this.bYv = (TextView) findViewById(n.f.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.bYl = shareFromGameCenterMsgData;
            dO(z);
        }
    }

    private void dO(boolean z) {
        if (z) {
            this.bYt.setBackgroundDrawable(this.mContext.getResources().getDrawable(n.e.selector_msg_text_bubble_me));
            this.aUB.setTextColor(this.mContext.getResources().getColor(n.c.cp_cont_g));
            this.bbA.setTextColor(this.mContext.getResources().getColor(n.c.cp_cont_g));
        } else {
            this.aUB.setTextColor(this.mContext.getResources().getColor(n.c.cp_cont_b));
            this.bbA.setTextColor(this.mContext.getResources().getColor(n.c.cp_cont_f));
            this.bYt.setBackgroundDrawable(this.mContext.getResources().getDrawable(n.e.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(k.d(getContext(), n.d.ds14), 0, 0, 0);
            layoutParams.height = k.d(getContext(), n.d.ds48);
            this.bKn.setLayoutParams(layoutParams);
        }
        this.aUB.setText(this.bYl.getTitle());
        this.bYq.setDefaultResource(n.e.pic_avatar_ba_140);
        this.bYq.setAutoChangeStyle(false);
        this.bYq.d(this.bYl.getImageUrl(), 10, false);
        this.bbA.setText(this.bYl.getContent());
        this.bYr.setTextColor(this.mContext.getResources().getColor(n.c.cp_cont_b));
        this.bYr.setBackgroundResource(n.e.btn_appdownload);
        if (!TextUtils.isEmpty(this.bYl.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, k.d(getContext(), n.d.ds60));
            int d = k.d(getContext(), n.d.ds30);
            layoutParams2.setMargins(d, k.d(getContext(), n.d.ds18), d, d);
            this.bYr.setLayoutParams(layoutParams2);
            this.bYr.setVisibility(0);
            this.bYr.setText(this.bYl.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int d2 = k.d(getContext(), n.d.ds30);
            layoutParams3.setMargins(d2, k.d(getContext(), n.d.ds20), d2, d2);
            this.bYr.setVisibility(8);
            this.bYu.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.bYl.getShareSource())) {
            this.bKn.setVisibility(8);
        }
        this.bYv.setText(this.bYl.getShareSource());
        this.bYs.setDefaultResource(n.e.icon);
        this.bYs.setAutoChangeStyle(false);
        this.bYs.d(this.bYl.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.n.mC(this.bYl.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.bKn;
    }

    public LinearLayout getContentBody() {
        return this.bYt;
    }

    public ImageView getTiebaIcon() {
        return this.bYs;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.bYs = tbImageView;
    }
}
