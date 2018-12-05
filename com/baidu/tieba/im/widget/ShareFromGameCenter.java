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
    private LinearLayout eLq;
    private TextView eaQ;
    private ShareFromGameCenterMsgData faf;
    private HeadImageView fam;
    private Button fan;
    private TbImageView fao;
    private LinearLayout fap;
    private LinearLayout faq;
    private TextView far;
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
        this.fap = (LinearLayout) findViewById(e.g.share_info_layout);
        this.faq = (LinearLayout) findViewById(e.g.game_share_content);
        this.eLq = (LinearLayout) findViewById(e.g.small_tail);
        this.mTitle = (TextView) findViewById(e.g.game_title);
        this.eaQ = (TextView) findViewById(e.g.game_desc);
        this.fam = (HeadImageView) findViewById(e.g.game_img);
        this.fam.setDefaultResource(e.f.pic_avatar_ba_140);
        this.fam.setAutoChangeStyle(false);
        this.fan = (Button) findViewById(e.g.accept_invite_button);
        this.fao = (TbImageView) findViewById(e.g.tail_icon);
        this.fao.setDefaultResource(e.f.icon);
        this.fao.setAutoChangeStyle(false);
        this.far = (TextView) findViewById(e.g.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.faf = shareFromGameCenterMsgData;
            iW(z);
        }
    }

    private void iW(boolean z) {
        if (z) {
            this.fap.setBackgroundDrawable(this.mContext.getResources().getDrawable(e.f.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_g));
            this.eaQ.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_b));
            this.eaQ.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_f));
            this.fap.setBackgroundDrawable(this.mContext.getResources().getDrawable(e.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.h(getContext(), e.C0210e.ds14), 0, 0, 0);
            layoutParams.height = l.h(getContext(), e.C0210e.ds48);
            this.eLq.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.faf.getTitle());
        this.fam.setDefaultResource(e.f.pic_avatar_ba_140);
        this.fam.setAutoChangeStyle(false);
        this.fam.startLoad(this.faf.getImageUrl(), 10, false);
        this.eaQ.setText(this.faf.getContent());
        this.fan.setTextColor(this.mContext.getResources().getColor(e.d.cp_cont_b));
        this.fan.setBackgroundResource(e.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.faf.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.h(getContext(), e.C0210e.ds60));
            int h = l.h(getContext(), e.C0210e.ds30);
            layoutParams2.setMargins(h, l.h(getContext(), e.C0210e.ds18), h, h);
            this.fan.setLayoutParams(layoutParams2);
            this.fan.setVisibility(0);
            this.fan.setText(this.faf.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int h2 = l.h(getContext(), e.C0210e.ds30);
            layoutParams3.setMargins(h2, l.h(getContext(), e.C0210e.ds20), h2, h2);
            this.fan.setVisibility(8);
            this.faq.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.faf.getShareSource())) {
            this.eLq.setVisibility(8);
        }
        this.far.setText(this.faf.getShareSource());
        this.fao.setDefaultResource(e.f.icon);
        this.fao.setAutoChangeStyle(false);
        this.fao.startLoad(this.faf.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.vO(this.faf.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.eLq;
    }

    public LinearLayout getContentBody() {
        return this.fap;
    }

    public ImageView getTiebaIcon() {
        return this.fao;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.fao = tbImageView;
    }
}
