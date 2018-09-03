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
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private ShareFromGameCenterMsgData eCX;
    private TextView eDe;
    private HeadImageView eDf;
    private Button eDg;
    private TbImageView eDh;
    private LinearLayout eDi;
    private LinearLayout eDj;
    private TextView eDk;
    private LinearLayout enZ;
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
        LayoutInflater.from(getContext()).inflate(f.h.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.eDi = (LinearLayout) findViewById(f.g.share_info_layout);
        this.eDj = (LinearLayout) findViewById(f.g.game_share_content);
        this.enZ = (LinearLayout) findViewById(f.g.small_tail);
        this.mTitle = (TextView) findViewById(f.g.game_title);
        this.eDe = (TextView) findViewById(f.g.game_desc);
        this.eDf = (HeadImageView) findViewById(f.g.game_img);
        this.eDf.setDefaultResource(f.C0146f.pic_avatar_ba_140);
        this.eDf.setAutoChangeStyle(false);
        this.eDg = (Button) findViewById(f.g.accept_invite_button);
        this.eDh = (TbImageView) findViewById(f.g.tail_icon);
        this.eDh.setDefaultResource(f.C0146f.icon);
        this.eDh.setAutoChangeStyle(false);
        this.eDk = (TextView) findViewById(f.g.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.eCX = shareFromGameCenterMsgData;
            hU(z);
        }
    }

    private void hU(boolean z) {
        if (z) {
            this.eDi.setBackgroundDrawable(this.mContext.getResources().getDrawable(f.C0146f.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(f.d.cp_cont_g));
            this.eDe.setTextColor(this.mContext.getResources().getColor(f.d.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(f.d.cp_cont_b));
            this.eDe.setTextColor(this.mContext.getResources().getColor(f.d.cp_cont_f));
            this.eDi.setBackgroundDrawable(this.mContext.getResources().getDrawable(f.C0146f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.f(getContext(), f.e.ds14), 0, 0, 0);
            layoutParams.height = l.f(getContext(), f.e.ds48);
            this.enZ.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.eCX.getTitle());
        this.eDf.setDefaultResource(f.C0146f.pic_avatar_ba_140);
        this.eDf.setAutoChangeStyle(false);
        this.eDf.startLoad(this.eCX.getImageUrl(), 10, false);
        this.eDe.setText(this.eCX.getContent());
        this.eDg.setTextColor(this.mContext.getResources().getColor(f.d.cp_cont_b));
        this.eDg.setBackgroundResource(f.C0146f.btn_appdownload);
        if (!TextUtils.isEmpty(this.eCX.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.f(getContext(), f.e.ds60));
            int f = l.f(getContext(), f.e.ds30);
            layoutParams2.setMargins(f, l.f(getContext(), f.e.ds18), f, f);
            this.eDg.setLayoutParams(layoutParams2);
            this.eDg.setVisibility(0);
            this.eDg.setText(this.eCX.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int f2 = l.f(getContext(), f.e.ds30);
            layoutParams3.setMargins(f2, l.f(getContext(), f.e.ds20), f2, f2);
            this.eDg.setVisibility(8);
            this.eDj.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.eCX.getShareSource())) {
            this.enZ.setVisibility(8);
        }
        this.eDk.setText(this.eCX.getShareSource());
        this.eDh.setDefaultResource(f.C0146f.icon);
        this.eDh.setAutoChangeStyle(false);
        this.eDh.startLoad(this.eCX.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.tZ(this.eCX.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.enZ;
    }

    public LinearLayout getContentBody() {
        return this.eDi;
    }

    public ImageView getTiebaIcon() {
        return this.eDh;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.eDh = tbImageView;
    }
}
