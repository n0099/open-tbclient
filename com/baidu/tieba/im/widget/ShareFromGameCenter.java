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
    private TextView dTh;
    private LinearLayout eDi;
    private ShareFromGameCenterMsgData eRY;
    private HeadImageView eSf;
    private Button eSg;
    private TbImageView eSh;
    private LinearLayout eSi;
    private LinearLayout eSj;
    private TextView eSk;
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
        this.eSi = (LinearLayout) findViewById(e.g.share_info_layout);
        this.eSj = (LinearLayout) findViewById(e.g.game_share_content);
        this.eDi = (LinearLayout) findViewById(e.g.small_tail);
        this.mTitle = (TextView) findViewById(e.g.game_title);
        this.dTh = (TextView) findViewById(e.g.game_desc);
        this.eSf = (HeadImageView) findViewById(e.g.game_img);
        this.eSf.setDefaultResource(e.f.pic_avatar_ba_140);
        this.eSf.setAutoChangeStyle(false);
        this.eSg = (Button) findViewById(e.g.accept_invite_button);
        this.eSh = (TbImageView) findViewById(e.g.tail_icon);
        this.eSh.setDefaultResource(e.f.icon);
        this.eSh.setAutoChangeStyle(false);
        this.eSk = (TextView) findViewById(e.g.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.eRY = shareFromGameCenterMsgData;
            iK(z);
        }
    }

    private void iK(boolean z) {
        if (z) {
            this.eSi.setBackgroundDrawable(this.mContext.getResources().getDrawable(e.f.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_g));
            this.dTh.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_b));
            this.dTh.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_f));
            this.eSi.setBackgroundDrawable(this.mContext.getResources().getDrawable(e.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.h(getContext(), e.C0175e.ds14), 0, 0, 0);
            layoutParams.height = l.h(getContext(), e.C0175e.ds48);
            this.eDi.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.eRY.getTitle());
        this.eSf.setDefaultResource(e.f.pic_avatar_ba_140);
        this.eSf.setAutoChangeStyle(false);
        this.eSf.startLoad(this.eRY.getImageUrl(), 10, false);
        this.dTh.setText(this.eRY.getContent());
        this.eSg.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_b));
        this.eSg.setBackgroundResource(e.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.eRY.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.h(getContext(), e.C0175e.ds60));
            int h = l.h(getContext(), e.C0175e.ds30);
            layoutParams2.setMargins(h, l.h(getContext(), e.C0175e.ds18), h, h);
            this.eSg.setLayoutParams(layoutParams2);
            this.eSg.setVisibility(0);
            this.eSg.setText(this.eRY.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int h2 = l.h(getContext(), e.C0175e.ds30);
            layoutParams3.setMargins(h2, l.h(getContext(), e.C0175e.ds20), h2, h2);
            this.eSg.setVisibility(8);
            this.eSj.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.eRY.getShareSource())) {
            this.eDi.setVisibility(8);
        }
        this.eSk.setText(this.eRY.getShareSource());
        this.eSh.setDefaultResource(e.f.icon);
        this.eSh.setAutoChangeStyle(false);
        this.eSh.startLoad(this.eRY.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.vi(this.eRY.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.eDi;
    }

    public LinearLayout getContentBody() {
        return this.eSi;
    }

    public ImageView getTiebaIcon() {
        return this.eSh;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.eSh = tbImageView;
    }
}
