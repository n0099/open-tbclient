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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private LinearLayout eOA;
    private TextView eOB;
    private ShareFromGameCenterMsgData eOo;
    private TextView eOv;
    private HeadImageView eOw;
    private Button eOx;
    private TbImageView eOy;
    private LinearLayout eOz;
    private LinearLayout ezt;
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
        this.eOz = (LinearLayout) findViewById(d.g.share_info_layout);
        this.eOA = (LinearLayout) findViewById(d.g.game_share_content);
        this.ezt = (LinearLayout) findViewById(d.g.small_tail);
        this.mTitle = (TextView) findViewById(d.g.game_title);
        this.eOv = (TextView) findViewById(d.g.game_desc);
        this.eOw = (HeadImageView) findViewById(d.g.game_img);
        this.eOw.setDefaultResource(d.f.pic_avatar_ba_140);
        this.eOw.setAutoChangeStyle(false);
        this.eOx = (Button) findViewById(d.g.accept_invite_button);
        this.eOy = (TbImageView) findViewById(d.g.tail_icon);
        this.eOy.setDefaultResource(d.f.icon);
        this.eOy.setAutoChangeStyle(false);
        this.eOB = (TextView) findViewById(d.g.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.eOo = shareFromGameCenterMsgData;
            hV(z);
        }
    }

    private void hV(boolean z) {
        if (z) {
            this.eOz.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0140d.cp_cont_g));
            this.eOv.setTextColor(this.mContext.getResources().getColor(d.C0140d.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0140d.cp_cont_b));
            this.eOv.setTextColor(this.mContext.getResources().getColor(d.C0140d.cp_cont_f));
            this.eOz.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.t(getContext(), d.e.ds14), 0, 0, 0);
            layoutParams.height = l.t(getContext(), d.e.ds48);
            this.ezt.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.eOo.getTitle());
        this.eOw.setDefaultResource(d.f.pic_avatar_ba_140);
        this.eOw.setAutoChangeStyle(false);
        this.eOw.startLoad(this.eOo.getImageUrl(), 10, false);
        this.eOv.setText(this.eOo.getContent());
        this.eOx.setTextColor(this.mContext.getResources().getColor(d.C0140d.cp_cont_b));
        this.eOx.setBackgroundResource(d.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.eOo.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.t(getContext(), d.e.ds60));
            int t = l.t(getContext(), d.e.ds30);
            layoutParams2.setMargins(t, l.t(getContext(), d.e.ds18), t, t);
            this.eOx.setLayoutParams(layoutParams2);
            this.eOx.setVisibility(0);
            this.eOx.setText(this.eOo.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int t2 = l.t(getContext(), d.e.ds30);
            layoutParams3.setMargins(t2, l.t(getContext(), d.e.ds20), t2, t2);
            this.eOx.setVisibility(8);
            this.eOA.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.eOo.getShareSource())) {
            this.ezt.setVisibility(8);
        }
        this.eOB.setText(this.eOo.getShareSource());
        this.eOy.setDefaultResource(d.f.icon);
        this.eOy.setAutoChangeStyle(false);
        this.eOy.startLoad(this.eOo.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.sT(this.eOo.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.ezt;
    }

    public LinearLayout getContentBody() {
        return this.eOz;
    }

    public ImageView getTiebaIcon() {
        return this.eOy;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.eOy = tbImageView;
    }
}
