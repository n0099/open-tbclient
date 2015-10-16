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
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.util.n;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private TextView aPq;
    private TextView aWc;
    private ShareFromGameCenterMsgData bIL;
    private HeadImageView bIQ;
    private Button bIR;
    private TbImageView bIS;
    private LinearLayout bIT;
    private LinearLayout bIU;
    private TextView bIV;
    private LinearLayout buJ;
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
        LayoutInflater.from(getContext()).inflate(i.g.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.bIT = (LinearLayout) findViewById(i.f.share_info_layout);
        this.bIU = (LinearLayout) findViewById(i.f.game_share_content);
        this.buJ = (LinearLayout) findViewById(i.f.small_tail);
        this.aPq = (TextView) findViewById(i.f.game_title);
        this.aWc = (TextView) findViewById(i.f.game_desc);
        this.bIQ = (HeadImageView) findViewById(i.f.game_img);
        this.bIQ.setDefaultResource(i.e.pic_avatar_ba_140);
        this.bIQ.setAutoChangeStyle(false);
        this.bIR = (Button) findViewById(i.f.accept_invite_button);
        this.bIS = (TbImageView) findViewById(i.f.tail_icon);
        this.bIS.setDefaultResource(i.e.icon);
        this.bIS.setAutoChangeStyle(false);
        this.bIV = (TextView) findViewById(i.f.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.bIL = shareFromGameCenterMsgData;
            dr(z);
        }
    }

    private void dr(boolean z) {
        if (z) {
            this.bIT.setBackgroundDrawable(this.mContext.getResources().getDrawable(i.e.selector_msg_text_bubble_me));
            this.aPq.setTextColor(this.mContext.getResources().getColor(i.c.cp_cont_g));
            this.aWc.setTextColor(this.mContext.getResources().getColor(i.c.cp_cont_g));
        } else {
            this.aPq.setTextColor(this.mContext.getResources().getColor(i.c.cp_cont_b));
            this.aWc.setTextColor(this.mContext.getResources().getColor(i.c.cp_cont_f));
            this.bIT.setBackgroundDrawable(this.mContext.getResources().getDrawable(i.e.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(k.d(getContext(), i.d.ds14), 0, 0, 0);
            layoutParams.height = k.d(getContext(), i.d.ds48);
            this.buJ.setLayoutParams(layoutParams);
        }
        this.aPq.setText(this.bIL.getTitle());
        this.bIQ.setDefaultResource(i.e.pic_avatar_ba_140);
        this.bIQ.setAutoChangeStyle(false);
        this.bIQ.d(this.bIL.getImageUrl(), 10, false);
        this.aWc.setText(this.bIL.getContent());
        this.bIR.setTextColor(this.mContext.getResources().getColor(i.c.cp_cont_b));
        this.bIR.setBackgroundResource(i.e.btn_appdownload);
        if (!TextUtils.isEmpty(this.bIL.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, k.d(getContext(), i.d.ds60));
            int d = k.d(getContext(), i.d.ds30);
            layoutParams2.setMargins(d, k.d(getContext(), i.d.ds18), d, d);
            this.bIR.setLayoutParams(layoutParams2);
            this.bIR.setVisibility(0);
            this.bIR.setText(this.bIL.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int d2 = k.d(getContext(), i.d.ds30);
            layoutParams3.setMargins(d2, k.d(getContext(), i.d.ds20), d2, d2);
            this.bIR.setVisibility(8);
            this.bIU.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.bIL.getShareSource())) {
            this.buJ.setVisibility(8);
        }
        this.bIV.setText(this.bIL.getShareSource());
        this.bIS.setDefaultResource(i.e.icon);
        this.bIS.setAutoChangeStyle(false);
        this.bIS.d(this.bIL.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", n.lI(this.bIL.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.buJ;
    }

    public LinearLayout getContentBody() {
        return this.bIT;
    }

    public ImageView getTiebaIcon() {
        return this.bIS;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.bIS = tbImageView;
    }
}
