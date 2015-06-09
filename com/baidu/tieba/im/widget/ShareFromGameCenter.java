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
    private TextView aML;
    private LinearLayout bcX;
    private ShareFromGameCenterMsgData brd;
    private HeadImageView bre;
    private Button brf;
    private TbImageView brg;
    private LinearLayout brh;
    private LinearLayout bri;
    private TextView brj;
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
        this.brh = (LinearLayout) findViewById(q.share_info_layout);
        this.bri = (LinearLayout) findViewById(q.game_share_content);
        this.bcX = (LinearLayout) findViewById(q.small_tail);
        this.mTitle = (TextView) findViewById(q.game_title);
        this.aML = (TextView) findViewById(q.game_desc);
        this.bre = (HeadImageView) findViewById(q.game_img);
        this.bre.setDefaultResource(p.pic_avatar_ba_140);
        this.bre.setAutoChangeStyle(false);
        this.brf = (Button) findViewById(q.accept_invite_button);
        this.brg = (TbImageView) findViewById(q.tail_icon);
        this.brg.setDefaultResource(p.icon);
        this.brg.setAutoChangeStyle(false);
        this.brj = (TextView) findViewById(q.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.brd = shareFromGameCenterMsgData;
            di(z);
        }
    }

    private void di(boolean z) {
        if (z) {
            this.brh.setBackgroundDrawable(this.mContext.getResources().getDrawable(p.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(n.cp_cont_g));
            this.aML.setTextColor(this.mContext.getResources().getColor(n.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(n.cp_cont_b));
            this.aML.setTextColor(this.mContext.getResources().getColor(n.cp_cont_f));
            this.brh.setBackgroundDrawable(this.mContext.getResources().getDrawable(p.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(com.baidu.adp.lib.util.n.d(getContext(), o.ds14), 0, 0, 0);
            layoutParams.height = com.baidu.adp.lib.util.n.d(getContext(), o.ds48);
            this.bcX.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.brd.getTitle());
        this.bre.setDefaultResource(p.pic_avatar_ba_140);
        this.bre.setAutoChangeStyle(false);
        this.bre.c(this.brd.getImageUrl(), 10, false);
        this.aML.setText(this.brd.getContent());
        this.brf.setTextColor(this.mContext.getResources().getColor(n.cp_cont_b));
        this.brf.setBackgroundResource(p.btn_appdownload);
        if (!TextUtils.isEmpty(this.brd.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.n.d(getContext(), o.ds60));
            int d = com.baidu.adp.lib.util.n.d(getContext(), o.ds30);
            layoutParams2.setMargins(d, com.baidu.adp.lib.util.n.d(getContext(), o.ds18), d, d);
            this.brf.setLayoutParams(layoutParams2);
            this.brf.setVisibility(0);
            this.brf.setText(this.brd.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int d2 = com.baidu.adp.lib.util.n.d(getContext(), o.ds30);
            layoutParams3.setMargins(d2, com.baidu.adp.lib.util.n.d(getContext(), o.ds20), d2, d2);
            this.brf.setVisibility(8);
            this.bri.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.brd.getShareSource())) {
            this.bcX.setVisibility(8);
        }
        this.brj.setText(this.brd.getShareSource());
        this.brg.setDefaultResource(p.icon);
        this.brg.setAutoChangeStyle(false);
        this.brg.c(this.brd.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", k.jJ(this.brd.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.bcX;
    }

    public LinearLayout getContentBody() {
        return this.brh;
    }

    public ImageView getTiebaIcon() {
        return this.brg;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.brg = tbImageView;
    }
}
