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
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.n;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private TextView aOG;
    private TextView biq;
    private LinearLayout cdb;
    private ShareFromGameCenterMsgData csn;
    private HeadImageView css;
    private Button cst;
    private TbImageView csu;
    private LinearLayout csv;
    private LinearLayout csw;
    private TextView csx;
    private Context mContext;

    public ShareFromGameCenter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        nq();
    }

    public ShareFromGameCenter(Context context) {
        super(context);
        this.mContext = context;
        nq();
    }

    public void nq() {
        LayoutInflater.from(getContext()).inflate(t.h.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.csv = (LinearLayout) findViewById(t.g.share_info_layout);
        this.csw = (LinearLayout) findViewById(t.g.game_share_content);
        this.cdb = (LinearLayout) findViewById(t.g.small_tail);
        this.aOG = (TextView) findViewById(t.g.game_title);
        this.biq = (TextView) findViewById(t.g.game_desc);
        this.css = (HeadImageView) findViewById(t.g.game_img);
        this.css.setDefaultResource(t.f.pic_avatar_ba_140);
        this.css.setAutoChangeStyle(false);
        this.cst = (Button) findViewById(t.g.accept_invite_button);
        this.csu = (TbImageView) findViewById(t.g.tail_icon);
        this.csu.setDefaultResource(t.f.icon);
        this.csu.setAutoChangeStyle(false);
        this.csx = (TextView) findViewById(t.g.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.csn = shareFromGameCenterMsgData;
            eT(z);
        }
    }

    private void eT(boolean z) {
        if (z) {
            this.csv.setBackgroundDrawable(this.mContext.getResources().getDrawable(t.f.selector_msg_text_bubble_me));
            this.aOG.setTextColor(this.mContext.getResources().getColor(t.d.cp_cont_g));
            this.biq.setTextColor(this.mContext.getResources().getColor(t.d.cp_cont_g));
        } else {
            this.aOG.setTextColor(this.mContext.getResources().getColor(t.d.cp_cont_b));
            this.biq.setTextColor(this.mContext.getResources().getColor(t.d.cp_cont_f));
            this.csv.setBackgroundDrawable(this.mContext.getResources().getDrawable(t.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(k.c(getContext(), t.e.ds14), 0, 0, 0);
            layoutParams.height = k.c(getContext(), t.e.ds48);
            this.cdb.setLayoutParams(layoutParams);
        }
        this.aOG.setText(this.csn.getTitle());
        this.css.setDefaultResource(t.f.pic_avatar_ba_140);
        this.css.setAutoChangeStyle(false);
        this.css.c(this.csn.getImageUrl(), 10, false);
        this.biq.setText(this.csn.getContent());
        this.cst.setTextColor(this.mContext.getResources().getColor(t.d.cp_cont_b));
        this.cst.setBackgroundResource(t.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.csn.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, k.c(getContext(), t.e.ds60));
            int c = k.c(getContext(), t.e.ds30);
            layoutParams2.setMargins(c, k.c(getContext(), t.e.ds18), c, c);
            this.cst.setLayoutParams(layoutParams2);
            this.cst.setVisibility(0);
            this.cst.setText(this.csn.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int c2 = k.c(getContext(), t.e.ds30);
            layoutParams3.setMargins(c2, k.c(getContext(), t.e.ds20), c2, c2);
            this.cst.setVisibility(8);
            this.csw.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.csn.getShareSource())) {
            this.cdb.setVisibility(8);
        }
        this.csx.setText(this.csn.getShareSource());
        this.csu.setDefaultResource(t.f.icon);
        this.csu.setAutoChangeStyle(false);
        this.csu.c(this.csn.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", n.nZ(this.csn.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.cdb;
    }

    public LinearLayout getContentBody() {
        return this.csv;
    }

    public ImageView getTiebaIcon() {
        return this.csu;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.csu = tbImageView;
    }
}
