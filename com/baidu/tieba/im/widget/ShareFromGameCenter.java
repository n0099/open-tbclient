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
    private LinearLayout eOT;
    private TextView een;
    private ShareFromGameCenterMsgData fdJ;
    private HeadImageView fdQ;
    private Button fdR;
    private TbImageView fdS;
    private LinearLayout fdT;
    private LinearLayout fdU;
    private TextView fdV;
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
        this.fdT = (LinearLayout) findViewById(e.g.share_info_layout);
        this.fdU = (LinearLayout) findViewById(e.g.game_share_content);
        this.eOT = (LinearLayout) findViewById(e.g.small_tail);
        this.mTitle = (TextView) findViewById(e.g.game_title);
        this.een = (TextView) findViewById(e.g.game_desc);
        this.fdQ = (HeadImageView) findViewById(e.g.game_img);
        this.fdQ.setDefaultResource(e.f.pic_avatar_ba_140);
        this.fdQ.setAutoChangeStyle(false);
        this.fdR = (Button) findViewById(e.g.accept_invite_button);
        this.fdS = (TbImageView) findViewById(e.g.tail_icon);
        this.fdS.setDefaultResource(e.f.icon);
        this.fdS.setAutoChangeStyle(false);
        this.fdV = (TextView) findViewById(e.g.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.fdJ = shareFromGameCenterMsgData;
            iZ(z);
        }
    }

    private void iZ(boolean z) {
        if (z) {
            this.fdT.setBackgroundDrawable(this.mContext.getResources().getDrawable(e.f.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_g));
            this.een.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_b));
            this.een.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_f));
            this.fdT.setBackgroundDrawable(this.mContext.getResources().getDrawable(e.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.h(getContext(), e.C0210e.ds14), 0, 0, 0);
            layoutParams.height = l.h(getContext(), e.C0210e.ds48);
            this.eOT.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.fdJ.getTitle());
        this.fdQ.setDefaultResource(e.f.pic_avatar_ba_140);
        this.fdQ.setAutoChangeStyle(false);
        this.fdQ.startLoad(this.fdJ.getImageUrl(), 10, false);
        this.een.setText(this.fdJ.getContent());
        this.fdR.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_b));
        this.fdR.setBackgroundResource(e.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.fdJ.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.h(getContext(), e.C0210e.ds60));
            int h = l.h(getContext(), e.C0210e.ds30);
            layoutParams2.setMargins(h, l.h(getContext(), e.C0210e.ds18), h, h);
            this.fdR.setLayoutParams(layoutParams2);
            this.fdR.setVisibility(0);
            this.fdR.setText(this.fdJ.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int h2 = l.h(getContext(), e.C0210e.ds30);
            layoutParams3.setMargins(h2, l.h(getContext(), e.C0210e.ds20), h2, h2);
            this.fdR.setVisibility(8);
            this.fdU.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.fdJ.getShareSource())) {
            this.eOT.setVisibility(8);
        }
        this.fdV.setText(this.fdJ.getShareSource());
        this.fdS.setDefaultResource(e.f.icon);
        this.fdS.setAutoChangeStyle(false);
        this.fdS.startLoad(this.fdJ.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.wh(this.fdJ.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.eOT;
    }

    public LinearLayout getContentBody() {
        return this.fdT;
    }

    public ImageView getTiebaIcon() {
        return this.fdS;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.fdS = tbImageView;
    }
}
