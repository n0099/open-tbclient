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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private TextView dUn;
    private LinearLayout eEB;
    private LinearLayout eTA;
    private LinearLayout eTB;
    private TextView eTC;
    private ShareFromGameCenterMsgData eTq;
    private HeadImageView eTx;
    private Button eTy;
    private TbImageView eTz;
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
        LayoutInflater.from(getContext()).inflate(e.h.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.eTA = (LinearLayout) findViewById(e.g.share_info_layout);
        this.eTB = (LinearLayout) findViewById(e.g.game_share_content);
        this.eEB = (LinearLayout) findViewById(e.g.small_tail);
        this.mTitle = (TextView) findViewById(e.g.game_title);
        this.dUn = (TextView) findViewById(e.g.game_desc);
        this.eTx = (HeadImageView) findViewById(e.g.game_img);
        this.eTx.setDefaultResource(e.f.pic_avatar_ba_140);
        this.eTx.setAutoChangeStyle(false);
        this.eTy = (Button) findViewById(e.g.accept_invite_button);
        this.eTz = (TbImageView) findViewById(e.g.tail_icon);
        this.eTz.setDefaultResource(e.f.icon);
        this.eTz.setAutoChangeStyle(false);
        this.eTC = (TextView) findViewById(e.g.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.eTq = shareFromGameCenterMsgData;
            iT(z);
        }
    }

    private void iT(boolean z) {
        if (z) {
            this.eTA.setBackgroundDrawable(this.mContext.getResources().getDrawable(e.f.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_g));
            this.dUn.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_b));
            this.dUn.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_f));
            this.eTA.setBackgroundDrawable(this.mContext.getResources().getDrawable(e.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.h(getContext(), e.C0200e.ds14), 0, 0, 0);
            layoutParams.height = l.h(getContext(), e.C0200e.ds48);
            this.eEB.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.eTq.getTitle());
        this.eTx.setDefaultResource(e.f.pic_avatar_ba_140);
        this.eTx.setAutoChangeStyle(false);
        this.eTx.startLoad(this.eTq.getImageUrl(), 10, false);
        this.dUn.setText(this.eTq.getContent());
        this.eTy.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_b));
        this.eTy.setBackgroundResource(e.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.eTq.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.h(getContext(), e.C0200e.ds60));
            int h = l.h(getContext(), e.C0200e.ds30);
            layoutParams2.setMargins(h, l.h(getContext(), e.C0200e.ds18), h, h);
            this.eTy.setLayoutParams(layoutParams2);
            this.eTy.setVisibility(0);
            this.eTy.setText(this.eTq.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int h2 = l.h(getContext(), e.C0200e.ds30);
            layoutParams3.setMargins(h2, l.h(getContext(), e.C0200e.ds20), h2, h2);
            this.eTy.setVisibility(8);
            this.eTB.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.eTq.getShareSource())) {
            this.eEB.setVisibility(8);
        }
        this.eTC.setText(this.eTq.getShareSource());
        this.eTz.setDefaultResource(e.f.icon);
        this.eTz.setAutoChangeStyle(false);
        this.eTz.startLoad(this.eTq.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.vn(this.eTq.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.eEB;
    }

    public LinearLayout getContentBody() {
        return this.eTA;
    }

    public ImageView getTiebaIcon() {
        return this.eTz;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.eTz = tbImageView;
    }
}
