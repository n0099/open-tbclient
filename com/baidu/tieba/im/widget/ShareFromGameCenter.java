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
    private TextView aSh;
    private TextView bmR;
    private LinearLayout ccw;
    private TextView crA;
    private ShareFromGameCenterMsgData crq;
    private HeadImageView crv;
    private Button crw;
    private TbImageView crx;
    private LinearLayout cry;
    private LinearLayout crz;
    private Context mContext;

    public ShareFromGameCenter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        pU();
    }

    public ShareFromGameCenter(Context context) {
        super(context);
        this.mContext = context;
        pU();
    }

    public void pU() {
        LayoutInflater.from(getContext()).inflate(t.h.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.cry = (LinearLayout) findViewById(t.g.share_info_layout);
        this.crz = (LinearLayout) findViewById(t.g.game_share_content);
        this.ccw = (LinearLayout) findViewById(t.g.small_tail);
        this.aSh = (TextView) findViewById(t.g.game_title);
        this.bmR = (TextView) findViewById(t.g.game_desc);
        this.crv = (HeadImageView) findViewById(t.g.game_img);
        this.crv.setDefaultResource(t.f.pic_avatar_ba_140);
        this.crv.setAutoChangeStyle(false);
        this.crw = (Button) findViewById(t.g.accept_invite_button);
        this.crx = (TbImageView) findViewById(t.g.tail_icon);
        this.crx.setDefaultResource(t.f.icon);
        this.crx.setAutoChangeStyle(false);
        this.crA = (TextView) findViewById(t.g.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.crq = shareFromGameCenterMsgData;
            er(z);
        }
    }

    private void er(boolean z) {
        if (z) {
            this.cry.setBackgroundDrawable(this.mContext.getResources().getDrawable(t.f.selector_msg_text_bubble_me));
            this.aSh.setTextColor(this.mContext.getResources().getColor(t.d.cp_cont_g));
            this.bmR.setTextColor(this.mContext.getResources().getColor(t.d.cp_cont_g));
        } else {
            this.aSh.setTextColor(this.mContext.getResources().getColor(t.d.cp_cont_b));
            this.bmR.setTextColor(this.mContext.getResources().getColor(t.d.cp_cont_f));
            this.cry.setBackgroundDrawable(this.mContext.getResources().getDrawable(t.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(k.c(getContext(), t.e.ds14), 0, 0, 0);
            layoutParams.height = k.c(getContext(), t.e.ds48);
            this.ccw.setLayoutParams(layoutParams);
        }
        this.aSh.setText(this.crq.getTitle());
        this.crv.setDefaultResource(t.f.pic_avatar_ba_140);
        this.crv.setAutoChangeStyle(false);
        this.crv.c(this.crq.getImageUrl(), 10, false);
        this.bmR.setText(this.crq.getContent());
        this.crw.setTextColor(this.mContext.getResources().getColor(t.d.cp_cont_b));
        this.crw.setBackgroundResource(t.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.crq.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, k.c(getContext(), t.e.ds60));
            int c = k.c(getContext(), t.e.ds30);
            layoutParams2.setMargins(c, k.c(getContext(), t.e.ds18), c, c);
            this.crw.setLayoutParams(layoutParams2);
            this.crw.setVisibility(0);
            this.crw.setText(this.crq.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int c2 = k.c(getContext(), t.e.ds30);
            layoutParams3.setMargins(c2, k.c(getContext(), t.e.ds20), c2, c2);
            this.crw.setVisibility(8);
            this.crz.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.crq.getShareSource())) {
            this.ccw.setVisibility(8);
        }
        this.crA.setText(this.crq.getShareSource());
        this.crx.setDefaultResource(t.f.icon);
        this.crx.setAutoChangeStyle(false);
        this.crx.c(this.crq.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", n.oc(this.crq.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.ccw;
    }

    public LinearLayout getContentBody() {
        return this.cry;
    }

    public ImageView getTiebaIcon() {
        return this.crx;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.crx = tbImageView;
    }
}
