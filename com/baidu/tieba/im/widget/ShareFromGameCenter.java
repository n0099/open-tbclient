package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.tbadkCore.util.m;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private LinearLayout cNm;
    private ShareFromGameCenterMsgData dcC;
    private TextView dcJ;
    private HeadImageView dcK;
    private Button dcL;
    private TbImageView dcM;
    private LinearLayout dcN;
    private LinearLayout dcO;
    private TextView dcP;
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
        LayoutInflater.from(getContext()).inflate(w.j.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.dcN = (LinearLayout) findViewById(w.h.share_info_layout);
        this.dcO = (LinearLayout) findViewById(w.h.game_share_content);
        this.cNm = (LinearLayout) findViewById(w.h.small_tail);
        this.mTitle = (TextView) findViewById(w.h.game_title);
        this.dcJ = (TextView) findViewById(w.h.game_desc);
        this.dcK = (HeadImageView) findViewById(w.h.game_img);
        this.dcK.setDefaultResource(w.g.pic_avatar_ba_140);
        this.dcK.setAutoChangeStyle(false);
        this.dcL = (Button) findViewById(w.h.accept_invite_button);
        this.dcM = (TbImageView) findViewById(w.h.tail_icon);
        this.dcM.setDefaultResource(w.g.icon);
        this.dcM.setAutoChangeStyle(false);
        this.dcP = (TextView) findViewById(w.h.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.dcC = shareFromGameCenterMsgData;
            fS(z);
        }
    }

    private void fS(boolean z) {
        if (z) {
            this.dcN.setBackgroundDrawable(this.mContext.getResources().getDrawable(w.g.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_g));
            this.dcJ.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_b));
            this.dcJ.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_f));
            this.dcN.setBackgroundDrawable(this.mContext.getResources().getDrawable(w.g.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(k.g(getContext(), w.f.ds14), 0, 0, 0);
            layoutParams.height = k.g(getContext(), w.f.ds48);
            this.cNm.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.dcC.getTitle());
        this.dcK.setDefaultResource(w.g.pic_avatar_ba_140);
        this.dcK.setAutoChangeStyle(false);
        this.dcK.c(this.dcC.getImageUrl(), 10, false);
        this.dcJ.setText(this.dcC.getContent());
        this.dcL.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_b));
        this.dcL.setBackgroundResource(w.g.btn_appdownload);
        if (!TextUtils.isEmpty(this.dcC.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, k.g(getContext(), w.f.ds60));
            int g = k.g(getContext(), w.f.ds30);
            layoutParams2.setMargins(g, k.g(getContext(), w.f.ds18), g, g);
            this.dcL.setLayoutParams(layoutParams2);
            this.dcL.setVisibility(0);
            this.dcL.setText(this.dcC.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int g2 = k.g(getContext(), w.f.ds30);
            layoutParams3.setMargins(g2, k.g(getContext(), w.f.ds20), g2, g2);
            this.dcL.setVisibility(8);
            this.dcO.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.dcC.getShareSource())) {
            this.cNm.setVisibility(8);
        }
        this.dcP.setText(this.dcC.getShareSource());
        this.dcM.setDefaultResource(w.g.icon);
        this.dcM.setAutoChangeStyle(false);
        this.dcM.c(this.dcC.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", m.qf(this.dcC.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.cNm;
    }

    public LinearLayout getContentBody() {
        return this.dcN;
    }

    public ImageView getTiebaIcon() {
        return this.dcM;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.dcM = tbImageView;
    }
}
