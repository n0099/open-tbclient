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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.util.m;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private TextView aOH;
    private LinearLayout dec;
    private ShareFromGameCenterMsgData dtm;
    private TextView dtr;
    private HeadImageView dts;
    private Button dtt;
    private TbImageView dtu;
    private LinearLayout dtv;
    private LinearLayout dtw;
    private TextView dtx;
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
        LayoutInflater.from(getContext()).inflate(r.h.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.dtv = (LinearLayout) findViewById(r.g.share_info_layout);
        this.dtw = (LinearLayout) findViewById(r.g.game_share_content);
        this.dec = (LinearLayout) findViewById(r.g.small_tail);
        this.aOH = (TextView) findViewById(r.g.game_title);
        this.dtr = (TextView) findViewById(r.g.game_desc);
        this.dts = (HeadImageView) findViewById(r.g.game_img);
        this.dts.setDefaultResource(r.f.pic_avatar_ba_140);
        this.dts.setAutoChangeStyle(false);
        this.dtt = (Button) findViewById(r.g.accept_invite_button);
        this.dtu = (TbImageView) findViewById(r.g.tail_icon);
        this.dtu.setDefaultResource(r.f.icon);
        this.dtu.setAutoChangeStyle(false);
        this.dtx = (TextView) findViewById(r.g.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.dtm = shareFromGameCenterMsgData;
            gD(z);
        }
    }

    private void gD(boolean z) {
        if (z) {
            this.dtv.setBackgroundDrawable(this.mContext.getResources().getDrawable(r.f.selector_msg_text_bubble_me));
            this.aOH.setTextColor(this.mContext.getResources().getColor(r.d.cp_cont_g));
            this.dtr.setTextColor(this.mContext.getResources().getColor(r.d.cp_cont_g));
        } else {
            this.aOH.setTextColor(this.mContext.getResources().getColor(r.d.cp_cont_b));
            this.dtr.setTextColor(this.mContext.getResources().getColor(r.d.cp_cont_f));
            this.dtv.setBackgroundDrawable(this.mContext.getResources().getDrawable(r.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(k.e(getContext(), r.e.ds14), 0, 0, 0);
            layoutParams.height = k.e(getContext(), r.e.ds48);
            this.dec.setLayoutParams(layoutParams);
        }
        this.aOH.setText(this.dtm.getTitle());
        this.dts.setDefaultResource(r.f.pic_avatar_ba_140);
        this.dts.setAutoChangeStyle(false);
        this.dts.c(this.dtm.getImageUrl(), 10, false);
        this.dtr.setText(this.dtm.getContent());
        this.dtt.setTextColor(this.mContext.getResources().getColor(r.d.cp_cont_b));
        this.dtt.setBackgroundResource(r.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.dtm.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, k.e(getContext(), r.e.ds60));
            int e = k.e(getContext(), r.e.ds30);
            layoutParams2.setMargins(e, k.e(getContext(), r.e.ds18), e, e);
            this.dtt.setLayoutParams(layoutParams2);
            this.dtt.setVisibility(0);
            this.dtt.setText(this.dtm.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int e2 = k.e(getContext(), r.e.ds30);
            layoutParams3.setMargins(e2, k.e(getContext(), r.e.ds20), e2, e2);
            this.dtt.setVisibility(8);
            this.dtw.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.dtm.getShareSource())) {
            this.dec.setVisibility(8);
        }
        this.dtx.setText(this.dtm.getShareSource());
        this.dtu.setDefaultResource(r.f.icon);
        this.dtu.setAutoChangeStyle(false);
        this.dtu.c(this.dtm.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", m.rL(this.dtm.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.dec;
    }

    public LinearLayout getContentBody() {
        return this.dtv;
    }

    public ImageView getTiebaIcon() {
        return this.dtu;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.dtu = tbImageView;
    }
}
