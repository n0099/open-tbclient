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
    private TextView aSd;
    private TextView bEd;
    private LinearLayout cIx;
    private ShareFromGameCenterMsgData cXC;
    private HeadImageView cXH;
    private Button cXI;
    private TbImageView cXJ;
    private LinearLayout cXK;
    private LinearLayout cXL;
    private TextView cXM;
    private Context mContext;

    public ShareFromGameCenter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        nl();
    }

    public ShareFromGameCenter(Context context) {
        super(context);
        this.mContext = context;
        nl();
    }

    public void nl() {
        LayoutInflater.from(getContext()).inflate(u.h.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.cXK = (LinearLayout) findViewById(u.g.share_info_layout);
        this.cXL = (LinearLayout) findViewById(u.g.game_share_content);
        this.cIx = (LinearLayout) findViewById(u.g.small_tail);
        this.aSd = (TextView) findViewById(u.g.game_title);
        this.bEd = (TextView) findViewById(u.g.game_desc);
        this.cXH = (HeadImageView) findViewById(u.g.game_img);
        this.cXH.setDefaultResource(u.f.pic_avatar_ba_140);
        this.cXH.setAutoChangeStyle(false);
        this.cXI = (Button) findViewById(u.g.accept_invite_button);
        this.cXJ = (TbImageView) findViewById(u.g.tail_icon);
        this.cXJ.setDefaultResource(u.f.icon);
        this.cXJ.setAutoChangeStyle(false);
        this.cXM = (TextView) findViewById(u.g.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.cXC = shareFromGameCenterMsgData;
            fH(z);
        }
    }

    private void fH(boolean z) {
        if (z) {
            this.cXK.setBackgroundDrawable(this.mContext.getResources().getDrawable(u.f.selector_msg_text_bubble_me));
            this.aSd.setTextColor(this.mContext.getResources().getColor(u.d.cp_cont_g));
            this.bEd.setTextColor(this.mContext.getResources().getColor(u.d.cp_cont_g));
        } else {
            this.aSd.setTextColor(this.mContext.getResources().getColor(u.d.cp_cont_b));
            this.bEd.setTextColor(this.mContext.getResources().getColor(u.d.cp_cont_f));
            this.cXK.setBackgroundDrawable(this.mContext.getResources().getDrawable(u.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(k.c(getContext(), u.e.ds14), 0, 0, 0);
            layoutParams.height = k.c(getContext(), u.e.ds48);
            this.cIx.setLayoutParams(layoutParams);
        }
        this.aSd.setText(this.cXC.getTitle());
        this.cXH.setDefaultResource(u.f.pic_avatar_ba_140);
        this.cXH.setAutoChangeStyle(false);
        this.cXH.c(this.cXC.getImageUrl(), 10, false);
        this.bEd.setText(this.cXC.getContent());
        this.cXI.setTextColor(this.mContext.getResources().getColor(u.d.cp_cont_b));
        this.cXI.setBackgroundResource(u.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.cXC.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, k.c(getContext(), u.e.ds60));
            int c = k.c(getContext(), u.e.ds30);
            layoutParams2.setMargins(c, k.c(getContext(), u.e.ds18), c, c);
            this.cXI.setLayoutParams(layoutParams2);
            this.cXI.setVisibility(0);
            this.cXI.setText(this.cXC.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int c2 = k.c(getContext(), u.e.ds30);
            layoutParams3.setMargins(c2, k.c(getContext(), u.e.ds20), c2, c2);
            this.cXI.setVisibility(8);
            this.cXL.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.cXC.getShareSource())) {
            this.cIx.setVisibility(8);
        }
        this.cXM.setText(this.cXC.getShareSource());
        this.cXJ.setDefaultResource(u.f.icon);
        this.cXJ.setAutoChangeStyle(false);
        this.cXJ.c(this.cXC.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", n.pH(this.cXC.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.cIx;
    }

    public LinearLayout getContentBody() {
        return this.cXK;
    }

    public ImageView getTiebaIcon() {
        return this.cXJ;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.cXJ = tbImageView;
    }
}
