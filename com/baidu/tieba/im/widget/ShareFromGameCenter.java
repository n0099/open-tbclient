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
    private ShareFromGameCenterMsgData eJE;
    private TextView eJL;
    private HeadImageView eJM;
    private Button eJN;
    private TbImageView eJO;
    private LinearLayout eJP;
    private LinearLayout eJQ;
    private TextView eJR;
    private LinearLayout euL;
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
        this.eJP = (LinearLayout) findViewById(d.g.share_info_layout);
        this.eJQ = (LinearLayout) findViewById(d.g.game_share_content);
        this.euL = (LinearLayout) findViewById(d.g.small_tail);
        this.mTitle = (TextView) findViewById(d.g.game_title);
        this.eJL = (TextView) findViewById(d.g.game_desc);
        this.eJM = (HeadImageView) findViewById(d.g.game_img);
        this.eJM.setDefaultResource(d.f.pic_avatar_ba_140);
        this.eJM.setAutoChangeStyle(false);
        this.eJN = (Button) findViewById(d.g.accept_invite_button);
        this.eJO = (TbImageView) findViewById(d.g.tail_icon);
        this.eJO.setDefaultResource(d.f.icon);
        this.eJO.setAutoChangeStyle(false);
        this.eJR = (TextView) findViewById(d.g.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.eJE = shareFromGameCenterMsgData;
            hI(z);
        }
    }

    private void hI(boolean z) {
        if (z) {
            this.eJP.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0107d.cp_cont_g));
            this.eJL.setTextColor(this.mContext.getResources().getColor(d.C0107d.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0107d.cp_cont_b));
            this.eJL.setTextColor(this.mContext.getResources().getColor(d.C0107d.cp_cont_f));
            this.eJP.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.s(getContext(), d.e.ds14), 0, 0, 0);
            layoutParams.height = l.s(getContext(), d.e.ds48);
            this.euL.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.eJE.getTitle());
        this.eJM.setDefaultResource(d.f.pic_avatar_ba_140);
        this.eJM.setAutoChangeStyle(false);
        this.eJM.startLoad(this.eJE.getImageUrl(), 10, false);
        this.eJL.setText(this.eJE.getContent());
        this.eJN.setTextColor(this.mContext.getResources().getColor(d.C0107d.cp_cont_b));
        this.eJN.setBackgroundResource(d.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.eJE.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.s(getContext(), d.e.ds60));
            int s = l.s(getContext(), d.e.ds30);
            layoutParams2.setMargins(s, l.s(getContext(), d.e.ds18), s, s);
            this.eJN.setLayoutParams(layoutParams2);
            this.eJN.setVisibility(0);
            this.eJN.setText(this.eJE.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int s2 = l.s(getContext(), d.e.ds30);
            layoutParams3.setMargins(s2, l.s(getContext(), d.e.ds20), s2, s2);
            this.eJN.setVisibility(8);
            this.eJQ.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.eJE.getShareSource())) {
            this.euL.setVisibility(8);
        }
        this.eJR.setText(this.eJE.getShareSource());
        this.eJO.setDefaultResource(d.f.icon);
        this.eJO.setAutoChangeStyle(false);
        this.eJO.startLoad(this.eJE.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.sE(this.eJE.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.euL;
    }

    public LinearLayout getContentBody() {
        return this.eJP;
    }

    public ImageView getTiebaIcon() {
        return this.eJO;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.eJO = tbImageView;
    }
}
