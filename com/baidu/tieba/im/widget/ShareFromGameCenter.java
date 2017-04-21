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
    private LinearLayout cTk;
    private ShareFromGameCenterMsgData diA;
    private TextView diH;
    private HeadImageView diI;
    private Button diJ;
    private TbImageView diK;
    private LinearLayout diL;
    private LinearLayout diM;
    private TextView diN;
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
        this.diL = (LinearLayout) findViewById(w.h.share_info_layout);
        this.diM = (LinearLayout) findViewById(w.h.game_share_content);
        this.cTk = (LinearLayout) findViewById(w.h.small_tail);
        this.mTitle = (TextView) findViewById(w.h.game_title);
        this.diH = (TextView) findViewById(w.h.game_desc);
        this.diI = (HeadImageView) findViewById(w.h.game_img);
        this.diI.setDefaultResource(w.g.pic_avatar_ba_140);
        this.diI.setAutoChangeStyle(false);
        this.diJ = (Button) findViewById(w.h.accept_invite_button);
        this.diK = (TbImageView) findViewById(w.h.tail_icon);
        this.diK.setDefaultResource(w.g.icon);
        this.diK.setAutoChangeStyle(false);
        this.diN = (TextView) findViewById(w.h.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.diA = shareFromGameCenterMsgData;
            gr(z);
        }
    }

    private void gr(boolean z) {
        if (z) {
            this.diL.setBackgroundDrawable(this.mContext.getResources().getDrawable(w.g.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_g));
            this.diH.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_b));
            this.diH.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_f));
            this.diL.setBackgroundDrawable(this.mContext.getResources().getDrawable(w.g.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(k.g(getContext(), w.f.ds14), 0, 0, 0);
            layoutParams.height = k.g(getContext(), w.f.ds48);
            this.cTk.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.diA.getTitle());
        this.diI.setDefaultResource(w.g.pic_avatar_ba_140);
        this.diI.setAutoChangeStyle(false);
        this.diI.c(this.diA.getImageUrl(), 10, false);
        this.diH.setText(this.diA.getContent());
        this.diJ.setTextColor(this.mContext.getResources().getColor(w.e.cp_cont_b));
        this.diJ.setBackgroundResource(w.g.btn_appdownload);
        if (!TextUtils.isEmpty(this.diA.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, k.g(getContext(), w.f.ds60));
            int g = k.g(getContext(), w.f.ds30);
            layoutParams2.setMargins(g, k.g(getContext(), w.f.ds18), g, g);
            this.diJ.setLayoutParams(layoutParams2);
            this.diJ.setVisibility(0);
            this.diJ.setText(this.diA.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int g2 = k.g(getContext(), w.f.ds30);
            layoutParams3.setMargins(g2, k.g(getContext(), w.f.ds20), g2, g2);
            this.diJ.setVisibility(8);
            this.diM.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.diA.getShareSource())) {
            this.cTk.setVisibility(8);
        }
        this.diN.setText(this.diA.getShareSource());
        this.diK.setDefaultResource(w.g.icon);
        this.diK.setAutoChangeStyle(false);
        this.diK.c(this.diA.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", m.ql(this.diA.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.cTk;
    }

    public LinearLayout getContentBody() {
        return this.diL;
    }

    public ImageView getTiebaIcon() {
        return this.diK;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.diK = tbImageView;
    }
}
