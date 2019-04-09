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
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private TextView fsp;
    private LinearLayout geL;
    private ShareFromGameCenterMsgData gtE;
    private HeadImageView gtL;
    private Button gtM;
    private TbImageView gtN;
    private LinearLayout gtO;
    private LinearLayout gtP;
    private TextView gtQ;
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
        this.gtO = (LinearLayout) findViewById(d.g.share_info_layout);
        this.gtP = (LinearLayout) findViewById(d.g.game_share_content);
        this.geL = (LinearLayout) findViewById(d.g.small_tail);
        this.mTitle = (TextView) findViewById(d.g.game_title);
        this.fsp = (TextView) findViewById(d.g.game_desc);
        this.gtL = (HeadImageView) findViewById(d.g.game_img);
        this.gtL.setDefaultResource(d.f.pic_avatar_ba_140);
        this.gtL.setAutoChangeStyle(false);
        this.gtM = (Button) findViewById(d.g.accept_invite_button);
        this.gtN = (TbImageView) findViewById(d.g.tail_icon);
        this.gtN.setDefaultResource(d.f.icon);
        this.gtN.setAutoChangeStyle(false);
        this.gtQ = (TextView) findViewById(d.g.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.gtE = shareFromGameCenterMsgData;
            lz(z);
        }
    }

    private void lz(boolean z) {
        if (z) {
            this.gtO.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0277d.cp_cont_g));
            this.fsp.setTextColor(this.mContext.getResources().getColor(d.C0277d.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0277d.cp_cont_b));
            this.fsp.setTextColor(this.mContext.getResources().getColor(d.C0277d.cp_cont_f));
            this.gtO.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.h(getContext(), d.e.ds14), 0, 0, 0);
            layoutParams.height = l.h(getContext(), d.e.ds48);
            this.geL.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.gtE.getTitle());
        this.gtL.setDefaultResource(d.f.pic_avatar_ba_140);
        this.gtL.setAutoChangeStyle(false);
        this.gtL.startLoad(this.gtE.getImageUrl(), 10, false);
        this.fsp.setText(this.gtE.getContent());
        this.gtM.setTextColor(this.mContext.getResources().getColor(d.C0277d.cp_cont_b));
        this.gtM.setBackgroundResource(d.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.gtE.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.h(getContext(), d.e.ds60));
            int h = l.h(getContext(), d.e.ds30);
            layoutParams2.setMargins(h, l.h(getContext(), d.e.ds18), h, h);
            this.gtM.setLayoutParams(layoutParams2);
            this.gtM.setVisibility(0);
            this.gtM.setText(this.gtE.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int h2 = l.h(getContext(), d.e.ds30);
            layoutParams3.setMargins(h2, l.h(getContext(), d.e.ds20), h2, h2);
            this.gtM.setVisibility(8);
            this.gtP.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.gtE.getShareSource())) {
            this.geL.setVisibility(8);
        }
        this.gtQ.setText(this.gtE.getShareSource());
        this.gtN.setDefaultResource(d.f.icon);
        this.gtN.setAutoChangeStyle(false);
        this.gtN.startLoad(this.gtE.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.CJ(this.gtE.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.geL;
    }

    public LinearLayout getContentBody() {
        return this.gtO;
    }

    public ImageView getTiebaIcon() {
        return this.gtN;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.gtN = tbImageView;
    }
}
