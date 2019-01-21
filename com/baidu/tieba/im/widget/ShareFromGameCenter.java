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
    private LinearLayout eOU;
    private TextView eeo;
    private ShareFromGameCenterMsgData fdK;
    private HeadImageView fdR;
    private Button fdS;
    private TbImageView fdT;
    private LinearLayout fdU;
    private LinearLayout fdV;
    private TextView fdW;
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
        this.fdU = (LinearLayout) findViewById(e.g.share_info_layout);
        this.fdV = (LinearLayout) findViewById(e.g.game_share_content);
        this.eOU = (LinearLayout) findViewById(e.g.small_tail);
        this.mTitle = (TextView) findViewById(e.g.game_title);
        this.eeo = (TextView) findViewById(e.g.game_desc);
        this.fdR = (HeadImageView) findViewById(e.g.game_img);
        this.fdR.setDefaultResource(e.f.pic_avatar_ba_140);
        this.fdR.setAutoChangeStyle(false);
        this.fdS = (Button) findViewById(e.g.accept_invite_button);
        this.fdT = (TbImageView) findViewById(e.g.tail_icon);
        this.fdT.setDefaultResource(e.f.icon);
        this.fdT.setAutoChangeStyle(false);
        this.fdW = (TextView) findViewById(e.g.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.fdK = shareFromGameCenterMsgData;
            iZ(z);
        }
    }

    private void iZ(boolean z) {
        if (z) {
            this.fdU.setBackgroundDrawable(this.mContext.getResources().getDrawable(e.f.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_g));
            this.eeo.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_b));
            this.eeo.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_f));
            this.fdU.setBackgroundDrawable(this.mContext.getResources().getDrawable(e.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.h(getContext(), e.C0210e.ds14), 0, 0, 0);
            layoutParams.height = l.h(getContext(), e.C0210e.ds48);
            this.eOU.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.fdK.getTitle());
        this.fdR.setDefaultResource(e.f.pic_avatar_ba_140);
        this.fdR.setAutoChangeStyle(false);
        this.fdR.startLoad(this.fdK.getImageUrl(), 10, false);
        this.eeo.setText(this.fdK.getContent());
        this.fdS.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_b));
        this.fdS.setBackgroundResource(e.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.fdK.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.h(getContext(), e.C0210e.ds60));
            int h = l.h(getContext(), e.C0210e.ds30);
            layoutParams2.setMargins(h, l.h(getContext(), e.C0210e.ds18), h, h);
            this.fdS.setLayoutParams(layoutParams2);
            this.fdS.setVisibility(0);
            this.fdS.setText(this.fdK.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int h2 = l.h(getContext(), e.C0210e.ds30);
            layoutParams3.setMargins(h2, l.h(getContext(), e.C0210e.ds20), h2, h2);
            this.fdS.setVisibility(8);
            this.fdV.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.fdK.getShareSource())) {
            this.eOU.setVisibility(8);
        }
        this.fdW.setText(this.fdK.getShareSource());
        this.fdT.setDefaultResource(e.f.icon);
        this.fdT.setAutoChangeStyle(false);
        this.fdT.startLoad(this.fdK.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.wh(this.fdK.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.eOU;
    }

    public LinearLayout getContentBody() {
        return this.fdU;
    }

    public ImageView getTiebaIcon() {
        return this.fdT;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.fdT = tbImageView;
    }
}
