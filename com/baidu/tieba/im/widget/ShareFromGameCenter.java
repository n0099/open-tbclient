package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.o;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.util.k;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private TextView aMK;
    private LinearLayout bcW;
    private ShareFromGameCenterMsgData brc;
    private HeadImageView brd;
    private Button bre;
    private TbImageView brf;
    private LinearLayout brg;
    private LinearLayout brh;
    private TextView bri;
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
        com.baidu.adp.lib.g.b.hr().inflate(getContext(), r.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.brg = (LinearLayout) findViewById(q.share_info_layout);
        this.brh = (LinearLayout) findViewById(q.game_share_content);
        this.bcW = (LinearLayout) findViewById(q.small_tail);
        this.mTitle = (TextView) findViewById(q.game_title);
        this.aMK = (TextView) findViewById(q.game_desc);
        this.brd = (HeadImageView) findViewById(q.game_img);
        this.brd.setDefaultResource(p.pic_avatar_ba_140);
        this.brd.setAutoChangeStyle(false);
        this.bre = (Button) findViewById(q.accept_invite_button);
        this.brf = (TbImageView) findViewById(q.tail_icon);
        this.brf.setDefaultResource(p.icon);
        this.brf.setAutoChangeStyle(false);
        this.bri = (TextView) findViewById(q.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.brc = shareFromGameCenterMsgData;
            di(z);
        }
    }

    private void di(boolean z) {
        if (z) {
            this.brg.setBackgroundDrawable(this.mContext.getResources().getDrawable(p.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(n.cp_cont_g));
            this.aMK.setTextColor(this.mContext.getResources().getColor(n.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(n.cp_cont_b));
            this.aMK.setTextColor(this.mContext.getResources().getColor(n.cp_cont_f));
            this.brg.setBackgroundDrawable(this.mContext.getResources().getDrawable(p.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(com.baidu.adp.lib.util.n.d(getContext(), o.ds14), 0, 0, 0);
            layoutParams.height = com.baidu.adp.lib.util.n.d(getContext(), o.ds48);
            this.bcW.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.brc.getTitle());
        this.brd.setDefaultResource(p.pic_avatar_ba_140);
        this.brd.setAutoChangeStyle(false);
        this.brd.c(this.brc.getImageUrl(), 10, false);
        this.aMK.setText(this.brc.getContent());
        this.bre.setTextColor(this.mContext.getResources().getColor(n.cp_cont_b));
        this.bre.setBackgroundResource(p.btn_appdownload);
        if (!TextUtils.isEmpty(this.brc.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.n.d(getContext(), o.ds60));
            int d = com.baidu.adp.lib.util.n.d(getContext(), o.ds30);
            layoutParams2.setMargins(d, com.baidu.adp.lib.util.n.d(getContext(), o.ds18), d, d);
            this.bre.setLayoutParams(layoutParams2);
            this.bre.setVisibility(0);
            this.bre.setText(this.brc.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int d2 = com.baidu.adp.lib.util.n.d(getContext(), o.ds30);
            layoutParams3.setMargins(d2, com.baidu.adp.lib.util.n.d(getContext(), o.ds20), d2, d2);
            this.bre.setVisibility(8);
            this.brh.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.brc.getShareSource())) {
            this.bcW.setVisibility(8);
        }
        this.bri.setText(this.brc.getShareSource());
        this.brf.setDefaultResource(p.icon);
        this.brf.setAutoChangeStyle(false);
        this.brf.c(this.brc.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", k.jJ(this.brc.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.bcW;
    }

    public LinearLayout getContentBody() {
        return this.brg;
    }

    public ImageView getTiebaIcon() {
        return this.brf;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.brf = tbImageView;
    }
}
