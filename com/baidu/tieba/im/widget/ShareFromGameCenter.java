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
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private TextView fsD;
    private LinearLayout geX;
    private ShareFromGameCenterMsgData gtQ;
    private HeadImageView gtX;
    private Button gtY;
    private TbImageView gtZ;
    private LinearLayout gua;
    private LinearLayout gub;
    private TextView guc;
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
        LayoutInflater.from(getContext()).inflate(d.h.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.gua = (LinearLayout) findViewById(d.g.share_info_layout);
        this.gub = (LinearLayout) findViewById(d.g.game_share_content);
        this.geX = (LinearLayout) findViewById(d.g.small_tail);
        this.mTitle = (TextView) findViewById(d.g.game_title);
        this.fsD = (TextView) findViewById(d.g.game_desc);
        this.gtX = (HeadImageView) findViewById(d.g.game_img);
        this.gtX.setDefaultResource(d.f.pic_avatar_ba_140);
        this.gtX.setAutoChangeStyle(false);
        this.gtY = (Button) findViewById(d.g.accept_invite_button);
        this.gtZ = (TbImageView) findViewById(d.g.tail_icon);
        this.gtZ.setDefaultResource(d.f.icon);
        this.gtZ.setAutoChangeStyle(false);
        this.guc = (TextView) findViewById(d.g.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.gtQ = shareFromGameCenterMsgData;
            lz(z);
        }
    }

    private void lz(boolean z) {
        if (z) {
            this.gua.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0277d.cp_cont_g));
            this.fsD.setTextColor(this.mContext.getResources().getColor(d.C0277d.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0277d.cp_cont_b));
            this.fsD.setTextColor(this.mContext.getResources().getColor(d.C0277d.cp_cont_f));
            this.gua.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.h(getContext(), d.e.ds14), 0, 0, 0);
            layoutParams.height = l.h(getContext(), d.e.ds48);
            this.geX.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.gtQ.getTitle());
        this.gtX.setDefaultResource(d.f.pic_avatar_ba_140);
        this.gtX.setAutoChangeStyle(false);
        this.gtX.startLoad(this.gtQ.getImageUrl(), 10, false);
        this.fsD.setText(this.gtQ.getContent());
        this.gtY.setTextColor(this.mContext.getResources().getColor(d.C0277d.cp_cont_b));
        this.gtY.setBackgroundResource(d.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.gtQ.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.h(getContext(), d.e.ds60));
            int h = l.h(getContext(), d.e.ds30);
            layoutParams2.setMargins(h, l.h(getContext(), d.e.ds18), h, h);
            this.gtY.setLayoutParams(layoutParams2);
            this.gtY.setVisibility(0);
            this.gtY.setText(this.gtQ.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int h2 = l.h(getContext(), d.e.ds30);
            layoutParams3.setMargins(h2, l.h(getContext(), d.e.ds20), h2, h2);
            this.gtY.setVisibility(8);
            this.gub.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.gtQ.getShareSource())) {
            this.geX.setVisibility(8);
        }
        this.guc.setText(this.gtQ.getShareSource());
        this.gtZ.setDefaultResource(d.f.icon);
        this.gtZ.setAutoChangeStyle(false);
        this.gtZ.startLoad(this.gtQ.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.CK(this.gtQ.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.geX;
    }

    public LinearLayout getContentBody() {
        return this.gua;
    }

    public ImageView getTiebaIcon() {
        return this.gtZ;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.gtZ = tbImageView;
    }
}
