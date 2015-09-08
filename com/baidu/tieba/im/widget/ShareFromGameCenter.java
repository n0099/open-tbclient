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
import com.baidu.tieba.tbadkCore.util.l;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private TextView aQj;
    private TextView aWs;
    private Button bFA;
    private TbImageView bFB;
    private LinearLayout bFC;
    private LinearLayout bFD;
    private TextView bFE;
    private ShareFromGameCenterMsgData bFy;
    private HeadImageView bFz;
    private LinearLayout bru;
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
        this.bFC = (LinearLayout) findViewById(i.f.share_info_layout);
        this.bFD = (LinearLayout) findViewById(i.f.game_share_content);
        this.bru = (LinearLayout) findViewById(i.f.small_tail);
        this.aQj = (TextView) findViewById(i.f.game_title);
        this.aWs = (TextView) findViewById(i.f.game_desc);
        this.bFz = (HeadImageView) findViewById(i.f.game_img);
        this.bFz.setDefaultResource(i.e.pic_avatar_ba_140);
        this.bFz.setAutoChangeStyle(false);
        this.bFA = (Button) findViewById(i.f.accept_invite_button);
        this.bFB = (TbImageView) findViewById(i.f.tail_icon);
        this.bFB.setDefaultResource(i.e.icon);
        this.bFB.setAutoChangeStyle(false);
        this.bFE = (TextView) findViewById(i.f.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.bFy = shareFromGameCenterMsgData;
            dr(z);
        }
    }

    private void dr(boolean z) {
        if (z) {
            this.bFC.setBackgroundDrawable(this.mContext.getResources().getDrawable(i.e.selector_msg_text_bubble_me));
            this.aQj.setTextColor(this.mContext.getResources().getColor(i.c.cp_cont_g));
            this.aWs.setTextColor(this.mContext.getResources().getColor(i.c.cp_cont_g));
        } else {
            this.aQj.setTextColor(this.mContext.getResources().getColor(i.c.cp_cont_b));
            this.aWs.setTextColor(this.mContext.getResources().getColor(i.c.cp_cont_f));
            this.bFC.setBackgroundDrawable(this.mContext.getResources().getDrawable(i.e.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(k.d(getContext(), i.d.ds14), 0, 0, 0);
            layoutParams.height = k.d(getContext(), i.d.ds48);
            this.bru.setLayoutParams(layoutParams);
        }
        this.aQj.setText(this.bFy.getTitle());
        this.bFz.setDefaultResource(i.e.pic_avatar_ba_140);
        this.bFz.setAutoChangeStyle(false);
        this.bFz.d(this.bFy.getImageUrl(), 10, false);
        this.aWs.setText(this.bFy.getContent());
        this.bFA.setTextColor(this.mContext.getResources().getColor(i.c.cp_cont_b));
        this.bFA.setBackgroundResource(i.e.btn_appdownload);
        if (!TextUtils.isEmpty(this.bFy.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, k.d(getContext(), i.d.ds60));
            int d = k.d(getContext(), i.d.ds30);
            layoutParams2.setMargins(d, k.d(getContext(), i.d.ds18), d, d);
            this.bFA.setLayoutParams(layoutParams2);
            this.bFA.setVisibility(0);
            this.bFA.setText(this.bFy.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int d2 = k.d(getContext(), i.d.ds30);
            layoutParams3.setMargins(d2, k.d(getContext(), i.d.ds20), d2, d2);
            this.bFA.setVisibility(8);
            this.bFD.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.bFy.getShareSource())) {
            this.bru.setVisibility(8);
        }
        this.bFE.setText(this.bFy.getShareSource());
        this.bFB.setDefaultResource(i.e.icon);
        this.bFB.setAutoChangeStyle(false);
        this.bFB.d(this.bFy.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", l.lh(this.bFy.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.bru;
    }

    public LinearLayout getContentBody() {
        return this.bFC;
    }

    public ImageView getTiebaIcon() {
        return this.bFB;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.bFB = tbImageView;
    }
}
