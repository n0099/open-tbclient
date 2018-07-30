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
    private ShareFromGameCenterMsgData eDb;
    private TextView eDi;
    private HeadImageView eDj;
    private Button eDk;
    private TbImageView eDl;
    private LinearLayout eDm;
    private LinearLayout eDn;
    private TextView eDo;
    private LinearLayout eod;
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
        this.eDm = (LinearLayout) findViewById(d.g.share_info_layout);
        this.eDn = (LinearLayout) findViewById(d.g.game_share_content);
        this.eod = (LinearLayout) findViewById(d.g.small_tail);
        this.mTitle = (TextView) findViewById(d.g.game_title);
        this.eDi = (TextView) findViewById(d.g.game_desc);
        this.eDj = (HeadImageView) findViewById(d.g.game_img);
        this.eDj.setDefaultResource(d.f.pic_avatar_ba_140);
        this.eDj.setAutoChangeStyle(false);
        this.eDk = (Button) findViewById(d.g.accept_invite_button);
        this.eDl = (TbImageView) findViewById(d.g.tail_icon);
        this.eDl.setDefaultResource(d.f.icon);
        this.eDl.setAutoChangeStyle(false);
        this.eDo = (TextView) findViewById(d.g.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.eDb = shareFromGameCenterMsgData;
            hU(z);
        }
    }

    private void hU(boolean z) {
        if (z) {
            this.eDm.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0140d.cp_cont_g));
            this.eDi.setTextColor(this.mContext.getResources().getColor(d.C0140d.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0140d.cp_cont_b));
            this.eDi.setTextColor(this.mContext.getResources().getColor(d.C0140d.cp_cont_f));
            this.eDm.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.f(getContext(), d.e.ds14), 0, 0, 0);
            layoutParams.height = l.f(getContext(), d.e.ds48);
            this.eod.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.eDb.getTitle());
        this.eDj.setDefaultResource(d.f.pic_avatar_ba_140);
        this.eDj.setAutoChangeStyle(false);
        this.eDj.startLoad(this.eDb.getImageUrl(), 10, false);
        this.eDi.setText(this.eDb.getContent());
        this.eDk.setTextColor(this.mContext.getResources().getColor(d.C0140d.cp_cont_b));
        this.eDk.setBackgroundResource(d.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.eDb.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.f(getContext(), d.e.ds60));
            int f = l.f(getContext(), d.e.ds30);
            layoutParams2.setMargins(f, l.f(getContext(), d.e.ds18), f, f);
            this.eDk.setLayoutParams(layoutParams2);
            this.eDk.setVisibility(0);
            this.eDk.setText(this.eDb.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int f2 = l.f(getContext(), d.e.ds30);
            layoutParams3.setMargins(f2, l.f(getContext(), d.e.ds20), f2, f2);
            this.eDk.setVisibility(8);
            this.eDn.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.eDb.getShareSource())) {
            this.eod.setVisibility(8);
        }
        this.eDo.setText(this.eDb.getShareSource());
        this.eDl.setDefaultResource(d.f.icon);
        this.eDl.setAutoChangeStyle(false);
        this.eDl.startLoad(this.eDb.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.tV(this.eDb.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.eod;
    }

    public LinearLayout getContentBody() {
        return this.eDm;
    }

    public ImageView getTiebaIcon() {
        return this.eDl;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.eDl = tbImageView;
    }
}
