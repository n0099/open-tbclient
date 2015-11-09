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
    private TextView aPy;
    private TextView aWk;
    private ShareFromGameCenterMsgData bJg;
    private HeadImageView bJl;
    private Button bJm;
    private TbImageView bJn;
    private LinearLayout bJo;
    private LinearLayout bJp;
    private TextView bJq;
    private LinearLayout bvh;
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
        this.bJo = (LinearLayout) findViewById(i.f.share_info_layout);
        this.bJp = (LinearLayout) findViewById(i.f.game_share_content);
        this.bvh = (LinearLayout) findViewById(i.f.small_tail);
        this.aPy = (TextView) findViewById(i.f.game_title);
        this.aWk = (TextView) findViewById(i.f.game_desc);
        this.bJl = (HeadImageView) findViewById(i.f.game_img);
        this.bJl.setDefaultResource(i.e.pic_avatar_ba_140);
        this.bJl.setAutoChangeStyle(false);
        this.bJm = (Button) findViewById(i.f.accept_invite_button);
        this.bJn = (TbImageView) findViewById(i.f.tail_icon);
        this.bJn.setDefaultResource(i.e.icon);
        this.bJn.setAutoChangeStyle(false);
        this.bJq = (TextView) findViewById(i.f.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.bJg = shareFromGameCenterMsgData;
            dt(z);
        }
    }

    private void dt(boolean z) {
        if (z) {
            this.bJo.setBackgroundDrawable(this.mContext.getResources().getDrawable(i.e.selector_msg_text_bubble_me));
            this.aPy.setTextColor(this.mContext.getResources().getColor(i.c.cp_cont_g));
            this.aWk.setTextColor(this.mContext.getResources().getColor(i.c.cp_cont_g));
        } else {
            this.aPy.setTextColor(this.mContext.getResources().getColor(i.c.cp_cont_b));
            this.aWk.setTextColor(this.mContext.getResources().getColor(i.c.cp_cont_f));
            this.bJo.setBackgroundDrawable(this.mContext.getResources().getDrawable(i.e.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(k.d(getContext(), i.d.ds14), 0, 0, 0);
            layoutParams.height = k.d(getContext(), i.d.ds48);
            this.bvh.setLayoutParams(layoutParams);
        }
        this.aPy.setText(this.bJg.getTitle());
        this.bJl.setDefaultResource(i.e.pic_avatar_ba_140);
        this.bJl.setAutoChangeStyle(false);
        this.bJl.d(this.bJg.getImageUrl(), 10, false);
        this.aWk.setText(this.bJg.getContent());
        this.bJm.setTextColor(this.mContext.getResources().getColor(i.c.cp_cont_b));
        this.bJm.setBackgroundResource(i.e.btn_appdownload);
        if (!TextUtils.isEmpty(this.bJg.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, k.d(getContext(), i.d.ds60));
            int d = k.d(getContext(), i.d.ds30);
            layoutParams2.setMargins(d, k.d(getContext(), i.d.ds18), d, d);
            this.bJm.setLayoutParams(layoutParams2);
            this.bJm.setVisibility(0);
            this.bJm.setText(this.bJg.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int d2 = k.d(getContext(), i.d.ds30);
            layoutParams3.setMargins(d2, k.d(getContext(), i.d.ds20), d2, d2);
            this.bJm.setVisibility(8);
            this.bJp.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.bJg.getShareSource())) {
            this.bvh.setVisibility(8);
        }
        this.bJq.setText(this.bJg.getShareSource());
        this.bJn.setDefaultResource(i.e.icon);
        this.bJn.setAutoChangeStyle(false);
        this.bJn.d(this.bJg.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", n.lO(this.bJg.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.bvh;
    }

    public LinearLayout getContentBody() {
        return this.bJo;
    }

    public ImageView getTiebaIcon() {
        return this.bJn;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.bJn = tbImageView;
    }
}
