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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private LinearLayout djm;
    private TextView dyD;
    private HeadImageView dyE;
    private Button dyF;
    private TbImageView dyG;
    private LinearLayout dyH;
    private LinearLayout dyI;
    private TextView dyJ;
    private ShareFromGameCenterMsgData dyw;
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
        LayoutInflater.from(getContext()).inflate(d.j.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.dyH = (LinearLayout) findViewById(d.h.share_info_layout);
        this.dyI = (LinearLayout) findViewById(d.h.game_share_content);
        this.djm = (LinearLayout) findViewById(d.h.small_tail);
        this.mTitle = (TextView) findViewById(d.h.game_title);
        this.dyD = (TextView) findViewById(d.h.game_desc);
        this.dyE = (HeadImageView) findViewById(d.h.game_img);
        this.dyE.setDefaultResource(d.g.pic_avatar_ba_140);
        this.dyE.setAutoChangeStyle(false);
        this.dyF = (Button) findViewById(d.h.accept_invite_button);
        this.dyG = (TbImageView) findViewById(d.h.tail_icon);
        this.dyG.setDefaultResource(d.g.icon);
        this.dyG.setAutoChangeStyle(false);
        this.dyJ = (TextView) findViewById(d.h.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.dyw = shareFromGameCenterMsgData;
            gL(z);
        }
    }

    private void gL(boolean z) {
        if (z) {
            this.dyH.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.g.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_g));
            this.dyD.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_b));
            this.dyD.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_f));
            this.dyH.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.g.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(k.g(getContext(), d.f.ds14), 0, 0, 0);
            layoutParams.height = k.g(getContext(), d.f.ds48);
            this.djm.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.dyw.getTitle());
        this.dyE.setDefaultResource(d.g.pic_avatar_ba_140);
        this.dyE.setAutoChangeStyle(false);
        this.dyE.c(this.dyw.getImageUrl(), 10, false);
        this.dyD.setText(this.dyw.getContent());
        this.dyF.setTextColor(this.mContext.getResources().getColor(d.e.cp_cont_b));
        this.dyF.setBackgroundResource(d.g.btn_appdownload);
        if (!TextUtils.isEmpty(this.dyw.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, k.g(getContext(), d.f.ds60));
            int g = k.g(getContext(), d.f.ds30);
            layoutParams2.setMargins(g, k.g(getContext(), d.f.ds18), g, g);
            this.dyF.setLayoutParams(layoutParams2);
            this.dyF.setVisibility(0);
            this.dyF.setText(this.dyw.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int g2 = k.g(getContext(), d.f.ds30);
            layoutParams3.setMargins(g2, k.g(getContext(), d.f.ds20), g2, g2);
            this.dyF.setVisibility(8);
            this.dyI.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.dyw.getShareSource())) {
            this.djm.setVisibility(8);
        }
        this.dyJ.setText(this.dyw.getShareSource());
        this.dyG.setDefaultResource(d.g.icon);
        this.dyG.setAutoChangeStyle(false);
        this.dyG.c(this.dyw.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.sd(this.dyw.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.djm;
    }

    public LinearLayout getContentBody() {
        return this.dyH;
    }

    public ImageView getTiebaIcon() {
        return this.dyG;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.dyG = tbImageView;
    }
}
