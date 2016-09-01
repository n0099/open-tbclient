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
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.n;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private TextView aYh;
    private LinearLayout cWS;
    private ShareFromGameCenterMsgData dmg;
    private TextView dml;
    private HeadImageView dmm;
    private Button dmn;
    private TbImageView dmo;
    private LinearLayout dmp;
    private LinearLayout dmq;
    private TextView dmr;
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
        LayoutInflater.from(getContext()).inflate(t.h.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.dmp = (LinearLayout) findViewById(t.g.share_info_layout);
        this.dmq = (LinearLayout) findViewById(t.g.game_share_content);
        this.cWS = (LinearLayout) findViewById(t.g.small_tail);
        this.aYh = (TextView) findViewById(t.g.game_title);
        this.dml = (TextView) findViewById(t.g.game_desc);
        this.dmm = (HeadImageView) findViewById(t.g.game_img);
        this.dmm.setDefaultResource(t.f.pic_avatar_ba_140);
        this.dmm.setAutoChangeStyle(false);
        this.dmn = (Button) findViewById(t.g.accept_invite_button);
        this.dmo = (TbImageView) findViewById(t.g.tail_icon);
        this.dmo.setDefaultResource(t.f.icon);
        this.dmo.setAutoChangeStyle(false);
        this.dmr = (TextView) findViewById(t.g.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.dmg = shareFromGameCenterMsgData;
            gg(z);
        }
    }

    private void gg(boolean z) {
        if (z) {
            this.dmp.setBackgroundDrawable(this.mContext.getResources().getDrawable(t.f.selector_msg_text_bubble_me));
            this.aYh.setTextColor(this.mContext.getResources().getColor(t.d.cp_cont_g));
            this.dml.setTextColor(this.mContext.getResources().getColor(t.d.cp_cont_g));
        } else {
            this.aYh.setTextColor(this.mContext.getResources().getColor(t.d.cp_cont_b));
            this.dml.setTextColor(this.mContext.getResources().getColor(t.d.cp_cont_f));
            this.dmp.setBackgroundDrawable(this.mContext.getResources().getDrawable(t.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(k.e(getContext(), t.e.ds14), 0, 0, 0);
            layoutParams.height = k.e(getContext(), t.e.ds48);
            this.cWS.setLayoutParams(layoutParams);
        }
        this.aYh.setText(this.dmg.getTitle());
        this.dmm.setDefaultResource(t.f.pic_avatar_ba_140);
        this.dmm.setAutoChangeStyle(false);
        this.dmm.c(this.dmg.getImageUrl(), 10, false);
        this.dml.setText(this.dmg.getContent());
        this.dmn.setTextColor(this.mContext.getResources().getColor(t.d.cp_cont_b));
        this.dmn.setBackgroundResource(t.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.dmg.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, k.e(getContext(), t.e.ds60));
            int e = k.e(getContext(), t.e.ds30);
            layoutParams2.setMargins(e, k.e(getContext(), t.e.ds18), e, e);
            this.dmn.setLayoutParams(layoutParams2);
            this.dmn.setVisibility(0);
            this.dmn.setText(this.dmg.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int e2 = k.e(getContext(), t.e.ds30);
            layoutParams3.setMargins(e2, k.e(getContext(), t.e.ds20), e2, e2);
            this.dmn.setVisibility(8);
            this.dmq.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.dmg.getShareSource())) {
            this.cWS.setVisibility(8);
        }
        this.dmr.setText(this.dmg.getShareSource());
        this.dmo.setDefaultResource(t.f.icon);
        this.dmo.setAutoChangeStyle(false);
        this.dmo.c(this.dmg.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", n.rb(this.dmg.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.cWS;
    }

    public LinearLayout getContentBody() {
        return this.dmp;
    }

    public ImageView getTiebaIcon() {
        return this.dmo;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.dmo = tbImageView;
    }
}
