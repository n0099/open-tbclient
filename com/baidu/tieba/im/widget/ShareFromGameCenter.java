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
    private ShareFromGameCenterMsgData dNd;
    private TextView dNk;
    private HeadImageView dNl;
    private Button dNm;
    private TbImageView dNn;
    private LinearLayout dNo;
    private LinearLayout dNp;
    private TextView dNq;
    private LinearLayout dyl;
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
        this.dNo = (LinearLayout) findViewById(d.g.share_info_layout);
        this.dNp = (LinearLayout) findViewById(d.g.game_share_content);
        this.dyl = (LinearLayout) findViewById(d.g.small_tail);
        this.mTitle = (TextView) findViewById(d.g.game_title);
        this.dNk = (TextView) findViewById(d.g.game_desc);
        this.dNl = (HeadImageView) findViewById(d.g.game_img);
        this.dNl.setDefaultResource(d.f.pic_avatar_ba_140);
        this.dNl.setAutoChangeStyle(false);
        this.dNm = (Button) findViewById(d.g.accept_invite_button);
        this.dNn = (TbImageView) findViewById(d.g.tail_icon);
        this.dNn.setDefaultResource(d.f.icon);
        this.dNn.setAutoChangeStyle(false);
        this.dNq = (TextView) findViewById(d.g.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.dNd = shareFromGameCenterMsgData;
            gL(z);
        }
    }

    private void gL(boolean z) {
        if (z) {
            this.dNo.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0080d.cp_cont_g));
            this.dNk.setTextColor(this.mContext.getResources().getColor(d.C0080d.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0080d.cp_cont_b));
            this.dNk.setTextColor(this.mContext.getResources().getColor(d.C0080d.cp_cont_f));
            this.dNo.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.f(getContext(), d.e.ds14), 0, 0, 0);
            layoutParams.height = l.f(getContext(), d.e.ds48);
            this.dyl.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.dNd.getTitle());
        this.dNl.setDefaultResource(d.f.pic_avatar_ba_140);
        this.dNl.setAutoChangeStyle(false);
        this.dNl.startLoad(this.dNd.getImageUrl(), 10, false);
        this.dNk.setText(this.dNd.getContent());
        this.dNm.setTextColor(this.mContext.getResources().getColor(d.C0080d.cp_cont_b));
        this.dNm.setBackgroundResource(d.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.dNd.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.f(getContext(), d.e.ds60));
            int f = l.f(getContext(), d.e.ds30);
            layoutParams2.setMargins(f, l.f(getContext(), d.e.ds18), f, f);
            this.dNm.setLayoutParams(layoutParams2);
            this.dNm.setVisibility(0);
            this.dNm.setText(this.dNd.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int f2 = l.f(getContext(), d.e.ds30);
            layoutParams3.setMargins(f2, l.f(getContext(), d.e.ds20), f2, f2);
            this.dNm.setVisibility(8);
            this.dNp.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.dNd.getShareSource())) {
            this.dyl.setVisibility(8);
        }
        this.dNq.setText(this.dNd.getShareSource());
        this.dNn.setDefaultResource(d.f.icon);
        this.dNn.setAutoChangeStyle(false);
        this.dNn.startLoad(this.dNd.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.sJ(this.dNd.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.dyl;
    }

    public LinearLayout getContentBody() {
        return this.dNo;
    }

    public ImageView getTiebaIcon() {
        return this.dNn;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.dNn = tbImageView;
    }
}
