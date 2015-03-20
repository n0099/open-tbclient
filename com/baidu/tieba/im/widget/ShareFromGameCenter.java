package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.k;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private TextView aKt;
    private LinearLayout aZZ;
    private ShareFromGameCenterMsgData bog;
    private HeadImageView boh;
    private Button boi;
    private TbImageView boj;
    private LinearLayout bok;
    private LinearLayout bol;
    private TextView bom;
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
        com.baidu.adp.lib.g.b.hH().inflate(getContext(), w.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.bok = (LinearLayout) findViewById(v.share_info_layout);
        this.bol = (LinearLayout) findViewById(v.game_share_content);
        this.aZZ = (LinearLayout) findViewById(v.small_tail);
        this.mTitle = (TextView) findViewById(v.game_title);
        this.aKt = (TextView) findViewById(v.game_desc);
        this.boh = (HeadImageView) findViewById(v.game_img);
        this.boh.setDefaultResource(u.pic_avatar_ba_140);
        this.boh.setAutoChangeStyle(false);
        this.boi = (Button) findViewById(v.accept_invite_button);
        this.boj = (TbImageView) findViewById(v.tail_icon);
        this.boj.setDefaultResource(u.icon);
        this.boj.setAutoChangeStyle(false);
        this.bom = (TextView) findViewById(v.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.bog = shareFromGameCenterMsgData;
            cZ(z);
        }
    }

    private void cZ(boolean z) {
        if (z) {
            this.bok.setBackgroundDrawable(this.mContext.getResources().getDrawable(u.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(s.cp_cont_g));
            this.aKt.setTextColor(this.mContext.getResources().getColor(s.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(s.cp_cont_b));
            this.aKt.setTextColor(this.mContext.getResources().getColor(s.cp_cont_f));
            this.bok.setBackgroundDrawable(this.mContext.getResources().getDrawable(u.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(n.d(getContext(), t.ds14), 0, 0, 0);
            layoutParams.height = n.d(getContext(), t.ds48);
            this.aZZ.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.bog.getTitle());
        this.boh.setDefaultResource(u.pic_avatar_ba_140);
        this.boh.setAutoChangeStyle(false);
        this.boh.c(this.bog.getImageUrl(), 10, false);
        this.aKt.setText(this.bog.getContent());
        this.boi.setTextColor(this.mContext.getResources().getColor(s.cp_cont_b));
        this.boi.setBackgroundResource(u.btn_appdownload);
        if (!TextUtils.isEmpty(this.bog.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, n.d(getContext(), t.ds60));
            int d = n.d(getContext(), t.ds30);
            layoutParams2.setMargins(d, n.d(getContext(), t.ds18), d, d);
            this.boi.setLayoutParams(layoutParams2);
            this.boi.setVisibility(0);
            this.boi.setText(this.bog.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int d2 = n.d(getContext(), t.ds30);
            layoutParams3.setMargins(d2, n.d(getContext(), t.ds20), d2, d2);
            this.boi.setVisibility(8);
            this.bol.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.bog.getShareSource())) {
            this.aZZ.setVisibility(8);
        }
        this.bom.setText(this.bog.getShareSource());
        this.boj.setDefaultResource(u.icon);
        this.boj.setAutoChangeStyle(false);
        this.boj.c(this.bog.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", k.iM(this.bog.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.aZZ;
    }

    public LinearLayout getContentBody() {
        return this.bok;
    }

    public ImageView getTiebaIcon() {
        return this.boj;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.boj = tbImageView;
    }
}
