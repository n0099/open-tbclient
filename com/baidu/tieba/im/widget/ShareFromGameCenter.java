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
    private HeadImageView eOA;
    private Button eOB;
    private TbImageView eOC;
    private LinearLayout eOD;
    private LinearLayout eOE;
    private TextView eOF;
    private ShareFromGameCenterMsgData eOs;
    private TextView eOz;
    private LinearLayout ezx;
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
        this.eOD = (LinearLayout) findViewById(d.g.share_info_layout);
        this.eOE = (LinearLayout) findViewById(d.g.game_share_content);
        this.ezx = (LinearLayout) findViewById(d.g.small_tail);
        this.mTitle = (TextView) findViewById(d.g.game_title);
        this.eOz = (TextView) findViewById(d.g.game_desc);
        this.eOA = (HeadImageView) findViewById(d.g.game_img);
        this.eOA.setDefaultResource(d.f.pic_avatar_ba_140);
        this.eOA.setAutoChangeStyle(false);
        this.eOB = (Button) findViewById(d.g.accept_invite_button);
        this.eOC = (TbImageView) findViewById(d.g.tail_icon);
        this.eOC.setDefaultResource(d.f.icon);
        this.eOC.setAutoChangeStyle(false);
        this.eOF = (TextView) findViewById(d.g.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.eOs = shareFromGameCenterMsgData;
            ia(z);
        }
    }

    private void ia(boolean z) {
        if (z) {
            this.eOD.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0141d.cp_cont_g));
            this.eOz.setTextColor(this.mContext.getResources().getColor(d.C0141d.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0141d.cp_cont_b));
            this.eOz.setTextColor(this.mContext.getResources().getColor(d.C0141d.cp_cont_f));
            this.eOD.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.t(getContext(), d.e.ds14), 0, 0, 0);
            layoutParams.height = l.t(getContext(), d.e.ds48);
            this.ezx.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.eOs.getTitle());
        this.eOA.setDefaultResource(d.f.pic_avatar_ba_140);
        this.eOA.setAutoChangeStyle(false);
        this.eOA.startLoad(this.eOs.getImageUrl(), 10, false);
        this.eOz.setText(this.eOs.getContent());
        this.eOB.setTextColor(this.mContext.getResources().getColor(d.C0141d.cp_cont_b));
        this.eOB.setBackgroundResource(d.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.eOs.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.t(getContext(), d.e.ds60));
            int t = l.t(getContext(), d.e.ds30);
            layoutParams2.setMargins(t, l.t(getContext(), d.e.ds18), t, t);
            this.eOB.setLayoutParams(layoutParams2);
            this.eOB.setVisibility(0);
            this.eOB.setText(this.eOs.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int t2 = l.t(getContext(), d.e.ds30);
            layoutParams3.setMargins(t2, l.t(getContext(), d.e.ds20), t2, t2);
            this.eOB.setVisibility(8);
            this.eOE.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.eOs.getShareSource())) {
            this.ezx.setVisibility(8);
        }
        this.eOF.setText(this.eOs.getShareSource());
        this.eOC.setDefaultResource(d.f.icon);
        this.eOC.setAutoChangeStyle(false);
        this.eOC.startLoad(this.eOs.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.sT(this.eOs.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.ezx;
    }

    public LinearLayout getContentBody() {
        return this.eOD;
    }

    public ImageView getTiebaIcon() {
        return this.eOC;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.eOC = tbImageView;
    }
}
