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
import com.baidu.tieba.tbadkCore.util.n;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private TextView aSZ;
    private TextView bFn;
    private LinearLayout cLn;
    private HeadImageView daE;
    private Button daF;
    private TbImageView daG;
    private LinearLayout daH;
    private LinearLayout daI;
    private TextView daJ;
    private ShareFromGameCenterMsgData daz;
    private Context mContext;

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
        LayoutInflater.from(getContext()).inflate(u.h.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.daH = (LinearLayout) findViewById(u.g.share_info_layout);
        this.daI = (LinearLayout) findViewById(u.g.game_share_content);
        this.cLn = (LinearLayout) findViewById(u.g.small_tail);
        this.aSZ = (TextView) findViewById(u.g.game_title);
        this.bFn = (TextView) findViewById(u.g.game_desc);
        this.daE = (HeadImageView) findViewById(u.g.game_img);
        this.daE.setDefaultResource(u.f.pic_avatar_ba_140);
        this.daE.setAutoChangeStyle(false);
        this.daF = (Button) findViewById(u.g.accept_invite_button);
        this.daG = (TbImageView) findViewById(u.g.tail_icon);
        this.daG.setDefaultResource(u.f.icon);
        this.daG.setAutoChangeStyle(false);
        this.daJ = (TextView) findViewById(u.g.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.daz = shareFromGameCenterMsgData;
            fK(z);
        }
    }

    private void fK(boolean z) {
        if (z) {
            this.daH.setBackgroundDrawable(this.mContext.getResources().getDrawable(u.f.selector_msg_text_bubble_me));
            this.aSZ.setTextColor(this.mContext.getResources().getColor(u.d.cp_cont_g));
            this.bFn.setTextColor(this.mContext.getResources().getColor(u.d.cp_cont_g));
        } else {
            this.aSZ.setTextColor(this.mContext.getResources().getColor(u.d.cp_cont_b));
            this.bFn.setTextColor(this.mContext.getResources().getColor(u.d.cp_cont_f));
            this.daH.setBackgroundDrawable(this.mContext.getResources().getDrawable(u.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(k.c(getContext(), u.e.ds14), 0, 0, 0);
            layoutParams.height = k.c(getContext(), u.e.ds48);
            this.cLn.setLayoutParams(layoutParams);
        }
        this.aSZ.setText(this.daz.getTitle());
        this.daE.setDefaultResource(u.f.pic_avatar_ba_140);
        this.daE.setAutoChangeStyle(false);
        this.daE.c(this.daz.getImageUrl(), 10, false);
        this.bFn.setText(this.daz.getContent());
        this.daF.setTextColor(this.mContext.getResources().getColor(u.d.cp_cont_b));
        this.daF.setBackgroundResource(u.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.daz.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, k.c(getContext(), u.e.ds60));
            int c = k.c(getContext(), u.e.ds30);
            layoutParams2.setMargins(c, k.c(getContext(), u.e.ds18), c, c);
            this.daF.setLayoutParams(layoutParams2);
            this.daF.setVisibility(0);
            this.daF.setText(this.daz.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int c2 = k.c(getContext(), u.e.ds30);
            layoutParams3.setMargins(c2, k.c(getContext(), u.e.ds20), c2, c2);
            this.daF.setVisibility(8);
            this.daI.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.daz.getShareSource())) {
            this.cLn.setVisibility(8);
        }
        this.daJ.setText(this.daz.getShareSource());
        this.daG.setDefaultResource(u.f.icon);
        this.daG.setAutoChangeStyle(false);
        this.daG.c(this.daz.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", n.qr(this.daz.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.cLn;
    }

    public LinearLayout getContentBody() {
        return this.daH;
    }

    public ImageView getTiebaIcon() {
        return this.daG;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.daG = tbImageView;
    }
}
