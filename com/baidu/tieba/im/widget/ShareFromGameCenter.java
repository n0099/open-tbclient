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
    private TextView aPf;
    private TextView aVR;
    private ShareFromGameCenterMsgData bIA;
    private HeadImageView bIF;
    private Button bIG;
    private TbImageView bIH;
    private LinearLayout bII;
    private LinearLayout bIJ;
    private TextView bIK;
    private LinearLayout buy;
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
        this.bII = (LinearLayout) findViewById(i.f.share_info_layout);
        this.bIJ = (LinearLayout) findViewById(i.f.game_share_content);
        this.buy = (LinearLayout) findViewById(i.f.small_tail);
        this.aPf = (TextView) findViewById(i.f.game_title);
        this.aVR = (TextView) findViewById(i.f.game_desc);
        this.bIF = (HeadImageView) findViewById(i.f.game_img);
        this.bIF.setDefaultResource(i.e.pic_avatar_ba_140);
        this.bIF.setAutoChangeStyle(false);
        this.bIG = (Button) findViewById(i.f.accept_invite_button);
        this.bIH = (TbImageView) findViewById(i.f.tail_icon);
        this.bIH.setDefaultResource(i.e.icon);
        this.bIH.setAutoChangeStyle(false);
        this.bIK = (TextView) findViewById(i.f.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.bIA = shareFromGameCenterMsgData;
            dr(z);
        }
    }

    private void dr(boolean z) {
        if (z) {
            this.bII.setBackgroundDrawable(this.mContext.getResources().getDrawable(i.e.selector_msg_text_bubble_me));
            this.aPf.setTextColor(this.mContext.getResources().getColor(i.c.cp_cont_g));
            this.aVR.setTextColor(this.mContext.getResources().getColor(i.c.cp_cont_g));
        } else {
            this.aPf.setTextColor(this.mContext.getResources().getColor(i.c.cp_cont_b));
            this.aVR.setTextColor(this.mContext.getResources().getColor(i.c.cp_cont_f));
            this.bII.setBackgroundDrawable(this.mContext.getResources().getDrawable(i.e.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(k.d(getContext(), i.d.ds14), 0, 0, 0);
            layoutParams.height = k.d(getContext(), i.d.ds48);
            this.buy.setLayoutParams(layoutParams);
        }
        this.aPf.setText(this.bIA.getTitle());
        this.bIF.setDefaultResource(i.e.pic_avatar_ba_140);
        this.bIF.setAutoChangeStyle(false);
        this.bIF.d(this.bIA.getImageUrl(), 10, false);
        this.aVR.setText(this.bIA.getContent());
        this.bIG.setTextColor(this.mContext.getResources().getColor(i.c.cp_cont_b));
        this.bIG.setBackgroundResource(i.e.btn_appdownload);
        if (!TextUtils.isEmpty(this.bIA.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, k.d(getContext(), i.d.ds60));
            int d = k.d(getContext(), i.d.ds30);
            layoutParams2.setMargins(d, k.d(getContext(), i.d.ds18), d, d);
            this.bIG.setLayoutParams(layoutParams2);
            this.bIG.setVisibility(0);
            this.bIG.setText(this.bIA.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int d2 = k.d(getContext(), i.d.ds30);
            layoutParams3.setMargins(d2, k.d(getContext(), i.d.ds20), d2, d2);
            this.bIG.setVisibility(8);
            this.bIJ.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.bIA.getShareSource())) {
            this.buy.setVisibility(8);
        }
        this.bIK.setText(this.bIA.getShareSource());
        this.bIH.setDefaultResource(i.e.icon);
        this.bIH.setAutoChangeStyle(false);
        this.bIH.d(this.bIA.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", n.lF(this.bIA.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.buy;
    }

    public LinearLayout getContentBody() {
        return this.bII;
    }

    public ImageView getTiebaIcon() {
        return this.bIH;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.bIH = tbImageView;
    }
}
