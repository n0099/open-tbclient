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
    private TextView aKD;
    private LinearLayout bap;
    private LinearLayout boA;
    private LinearLayout boB;
    private TextView boC;
    private ShareFromGameCenterMsgData bow;
    private HeadImageView box;
    private Button boy;
    private TbImageView boz;
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
        this.boA = (LinearLayout) findViewById(v.share_info_layout);
        this.boB = (LinearLayout) findViewById(v.game_share_content);
        this.bap = (LinearLayout) findViewById(v.small_tail);
        this.mTitle = (TextView) findViewById(v.game_title);
        this.aKD = (TextView) findViewById(v.game_desc);
        this.box = (HeadImageView) findViewById(v.game_img);
        this.box.setDefaultResource(u.pic_avatar_ba_140);
        this.box.setAutoChangeStyle(false);
        this.boy = (Button) findViewById(v.accept_invite_button);
        this.boz = (TbImageView) findViewById(v.tail_icon);
        this.boz.setDefaultResource(u.icon);
        this.boz.setAutoChangeStyle(false);
        this.boC = (TextView) findViewById(v.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.bow = shareFromGameCenterMsgData;
            cX(z);
        }
    }

    private void cX(boolean z) {
        if (z) {
            this.boA.setBackgroundDrawable(this.mContext.getResources().getDrawable(u.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(s.cp_cont_g));
            this.aKD.setTextColor(this.mContext.getResources().getColor(s.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(s.cp_cont_b));
            this.aKD.setTextColor(this.mContext.getResources().getColor(s.cp_cont_f));
            this.boA.setBackgroundDrawable(this.mContext.getResources().getDrawable(u.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(n.d(getContext(), t.ds14), 0, 0, 0);
            layoutParams.height = n.d(getContext(), t.ds48);
            this.bap.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.bow.getTitle());
        this.box.setDefaultResource(u.pic_avatar_ba_140);
        this.box.setAutoChangeStyle(false);
        this.box.c(this.bow.getImageUrl(), 10, false);
        this.aKD.setText(this.bow.getContent());
        this.boy.setTextColor(this.mContext.getResources().getColor(s.cp_cont_b));
        this.boy.setBackgroundResource(u.btn_appdownload);
        if (!TextUtils.isEmpty(this.bow.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, n.d(getContext(), t.ds60));
            int d = n.d(getContext(), t.ds30);
            layoutParams2.setMargins(d, n.d(getContext(), t.ds18), d, d);
            this.boy.setLayoutParams(layoutParams2);
            this.boy.setVisibility(0);
            this.boy.setText(this.bow.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int d2 = n.d(getContext(), t.ds30);
            layoutParams3.setMargins(d2, n.d(getContext(), t.ds20), d2, d2);
            this.boy.setVisibility(8);
            this.boB.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.bow.getShareSource())) {
            this.bap.setVisibility(8);
        }
        this.boC.setText(this.bow.getShareSource());
        this.boz.setDefaultResource(u.icon);
        this.boz.setAutoChangeStyle(false);
        this.boz.c(this.bow.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", k.iP(this.bow.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.bap;
    }

    public LinearLayout getContentBody() {
        return this.boA;
    }

    public ImageView getTiebaIcon() {
        return this.boz;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.boz = tbImageView;
    }
}
