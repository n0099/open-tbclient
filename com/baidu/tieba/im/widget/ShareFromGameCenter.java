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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private LinearLayout ekl;
    private ShareFromGameCenterMsgData ezk;
    private TextView ezr;
    private HeadImageView ezs;
    private Button ezt;
    private TbImageView ezu;
    private LinearLayout ezv;
    private LinearLayout ezw;
    private TextView ezx;
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
        LayoutInflater.from(getContext()).inflate(d.i.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.ezv = (LinearLayout) findViewById(d.g.share_info_layout);
        this.ezw = (LinearLayout) findViewById(d.g.game_share_content);
        this.ekl = (LinearLayout) findViewById(d.g.small_tail);
        this.mTitle = (TextView) findViewById(d.g.game_title);
        this.ezr = (TextView) findViewById(d.g.game_desc);
        this.ezs = (HeadImageView) findViewById(d.g.game_img);
        this.ezs.setDefaultResource(d.f.pic_avatar_ba_140);
        this.ezs.setAutoChangeStyle(false);
        this.ezt = (Button) findViewById(d.g.accept_invite_button);
        this.ezu = (TbImageView) findViewById(d.g.tail_icon);
        this.ezu.setDefaultResource(d.f.icon);
        this.ezu.setAutoChangeStyle(false);
        this.ezx = (TextView) findViewById(d.g.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.ezk = shareFromGameCenterMsgData;
            hR(z);
        }
    }

    private void hR(boolean z) {
        if (z) {
            this.ezv.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0142d.cp_cont_g));
            this.ezr.setTextColor(this.mContext.getResources().getColor(d.C0142d.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0142d.cp_cont_b));
            this.ezr.setTextColor(this.mContext.getResources().getColor(d.C0142d.cp_cont_f));
            this.ezv.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.e(getContext(), d.e.ds14), 0, 0, 0);
            layoutParams.height = l.e(getContext(), d.e.ds48);
            this.ekl.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.ezk.getTitle());
        this.ezs.setDefaultResource(d.f.pic_avatar_ba_140);
        this.ezs.setAutoChangeStyle(false);
        this.ezs.startLoad(this.ezk.getImageUrl(), 10, false);
        this.ezr.setText(this.ezk.getContent());
        this.ezt.setTextColor(this.mContext.getResources().getColor(d.C0142d.cp_cont_b));
        this.ezt.setBackgroundResource(d.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.ezk.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.e(getContext(), d.e.ds60));
            int e = l.e(getContext(), d.e.ds30);
            layoutParams2.setMargins(e, l.e(getContext(), d.e.ds18), e, e);
            this.ezt.setLayoutParams(layoutParams2);
            this.ezt.setVisibility(0);
            this.ezt.setText(this.ezk.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int e2 = l.e(getContext(), d.e.ds30);
            layoutParams3.setMargins(e2, l.e(getContext(), d.e.ds20), e2, e2);
            this.ezt.setVisibility(8);
            this.ezw.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.ezk.getShareSource())) {
            this.ekl.setVisibility(8);
        }
        this.ezx.setText(this.ezk.getShareSource());
        this.ezu.setDefaultResource(d.f.icon);
        this.ezu.setAutoChangeStyle(false);
        this.ezu.startLoad(this.ezk.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.tX(this.ezk.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.ekl;
    }

    public LinearLayout getContentBody() {
        return this.ezv;
    }

    public ImageView getTiebaIcon() {
        return this.ezu;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.ezu = tbImageView;
    }
}
