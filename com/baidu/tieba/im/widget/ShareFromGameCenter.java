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
    private LinearLayout eOh;
    private TextView edH;
    private ShareFromGameCenterMsgData fcW;
    private HeadImageView fdd;
    private Button fde;
    private TbImageView fdf;
    private LinearLayout fdg;
    private LinearLayout fdh;
    private TextView fdi;
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
        this.fdg = (LinearLayout) findViewById(e.g.share_info_layout);
        this.fdh = (LinearLayout) findViewById(e.g.game_share_content);
        this.eOh = (LinearLayout) findViewById(e.g.small_tail);
        this.mTitle = (TextView) findViewById(e.g.game_title);
        this.edH = (TextView) findViewById(e.g.game_desc);
        this.fdd = (HeadImageView) findViewById(e.g.game_img);
        this.fdd.setDefaultResource(e.f.pic_avatar_ba_140);
        this.fdd.setAutoChangeStyle(false);
        this.fde = (Button) findViewById(e.g.accept_invite_button);
        this.fdf = (TbImageView) findViewById(e.g.tail_icon);
        this.fdf.setDefaultResource(e.f.icon);
        this.fdf.setAutoChangeStyle(false);
        this.fdi = (TextView) findViewById(e.g.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.fcW = shareFromGameCenterMsgData;
            iZ(z);
        }
    }

    private void iZ(boolean z) {
        if (z) {
            this.fdg.setBackgroundDrawable(this.mContext.getResources().getDrawable(e.f.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_g));
            this.edH.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_b));
            this.edH.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_f));
            this.fdg.setBackgroundDrawable(this.mContext.getResources().getDrawable(e.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.h(getContext(), e.C0210e.ds14), 0, 0, 0);
            layoutParams.height = l.h(getContext(), e.C0210e.ds48);
            this.eOh.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.fcW.getTitle());
        this.fdd.setDefaultResource(e.f.pic_avatar_ba_140);
        this.fdd.setAutoChangeStyle(false);
        this.fdd.startLoad(this.fcW.getImageUrl(), 10, false);
        this.edH.setText(this.fcW.getContent());
        this.fde.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_b));
        this.fde.setBackgroundResource(e.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.fcW.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.h(getContext(), e.C0210e.ds60));
            int h = l.h(getContext(), e.C0210e.ds30);
            layoutParams2.setMargins(h, l.h(getContext(), e.C0210e.ds18), h, h);
            this.fde.setLayoutParams(layoutParams2);
            this.fde.setVisibility(0);
            this.fde.setText(this.fcW.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int h2 = l.h(getContext(), e.C0210e.ds30);
            layoutParams3.setMargins(h2, l.h(getContext(), e.C0210e.ds20), h2, h2);
            this.fde.setVisibility(8);
            this.fdh.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.fcW.getShareSource())) {
            this.eOh.setVisibility(8);
        }
        this.fdi.setText(this.fcW.getShareSource());
        this.fdf.setDefaultResource(e.f.icon);
        this.fdf.setAutoChangeStyle(false);
        this.fdf.startLoad(this.fcW.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.vR(this.fcW.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.eOh;
    }

    public LinearLayout getContentBody() {
        return this.fdg;
    }

    public ImageView getTiebaIcon() {
        return this.fdf;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.fdf = tbImageView;
    }
}
