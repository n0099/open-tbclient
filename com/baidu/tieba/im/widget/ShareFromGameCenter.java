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
    private TextView dTg;
    private LinearLayout eDh;
    private ShareFromGameCenterMsgData eRX;
    private HeadImageView eSe;
    private Button eSf;
    private TbImageView eSg;
    private LinearLayout eSh;
    private LinearLayout eSi;
    private TextView eSj;
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
        this.eSh = (LinearLayout) findViewById(e.g.share_info_layout);
        this.eSi = (LinearLayout) findViewById(e.g.game_share_content);
        this.eDh = (LinearLayout) findViewById(e.g.small_tail);
        this.mTitle = (TextView) findViewById(e.g.game_title);
        this.dTg = (TextView) findViewById(e.g.game_desc);
        this.eSe = (HeadImageView) findViewById(e.g.game_img);
        this.eSe.setDefaultResource(e.f.pic_avatar_ba_140);
        this.eSe.setAutoChangeStyle(false);
        this.eSf = (Button) findViewById(e.g.accept_invite_button);
        this.eSg = (TbImageView) findViewById(e.g.tail_icon);
        this.eSg.setDefaultResource(e.f.icon);
        this.eSg.setAutoChangeStyle(false);
        this.eSj = (TextView) findViewById(e.g.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.eRX = shareFromGameCenterMsgData;
            iK(z);
        }
    }

    private void iK(boolean z) {
        if (z) {
            this.eSh.setBackgroundDrawable(this.mContext.getResources().getDrawable(e.f.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_g));
            this.dTg.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_b));
            this.dTg.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_f));
            this.eSh.setBackgroundDrawable(this.mContext.getResources().getDrawable(e.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.h(getContext(), e.C0175e.ds14), 0, 0, 0);
            layoutParams.height = l.h(getContext(), e.C0175e.ds48);
            this.eDh.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.eRX.getTitle());
        this.eSe.setDefaultResource(e.f.pic_avatar_ba_140);
        this.eSe.setAutoChangeStyle(false);
        this.eSe.startLoad(this.eRX.getImageUrl(), 10, false);
        this.dTg.setText(this.eRX.getContent());
        this.eSf.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_b));
        this.eSf.setBackgroundResource(e.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.eRX.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.h(getContext(), e.C0175e.ds60));
            int h = l.h(getContext(), e.C0175e.ds30);
            layoutParams2.setMargins(h, l.h(getContext(), e.C0175e.ds18), h, h);
            this.eSf.setLayoutParams(layoutParams2);
            this.eSf.setVisibility(0);
            this.eSf.setText(this.eRX.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int h2 = l.h(getContext(), e.C0175e.ds30);
            layoutParams3.setMargins(h2, l.h(getContext(), e.C0175e.ds20), h2, h2);
            this.eSf.setVisibility(8);
            this.eSi.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.eRX.getShareSource())) {
            this.eDh.setVisibility(8);
        }
        this.eSj.setText(this.eRX.getShareSource());
        this.eSg.setDefaultResource(e.f.icon);
        this.eSg.setAutoChangeStyle(false);
        this.eSg.startLoad(this.eRX.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.vi(this.eRX.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.eDh;
    }

    public LinearLayout getContentBody() {
        return this.eSh;
    }

    public ImageView getTiebaIcon() {
        return this.eSg;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.eSg = tbImageView;
    }
}
