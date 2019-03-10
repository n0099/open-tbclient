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
    private TextView fsE;
    private LinearLayout geY;
    private ShareFromGameCenterMsgData gtR;
    private HeadImageView gtY;
    private Button gtZ;
    private TbImageView gua;
    private LinearLayout gub;
    private LinearLayout guc;
    private TextView gud;
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
        this.gub = (LinearLayout) findViewById(d.g.share_info_layout);
        this.guc = (LinearLayout) findViewById(d.g.game_share_content);
        this.geY = (LinearLayout) findViewById(d.g.small_tail);
        this.mTitle = (TextView) findViewById(d.g.game_title);
        this.fsE = (TextView) findViewById(d.g.game_desc);
        this.gtY = (HeadImageView) findViewById(d.g.game_img);
        this.gtY.setDefaultResource(d.f.pic_avatar_ba_140);
        this.gtY.setAutoChangeStyle(false);
        this.gtZ = (Button) findViewById(d.g.accept_invite_button);
        this.gua = (TbImageView) findViewById(d.g.tail_icon);
        this.gua.setDefaultResource(d.f.icon);
        this.gua.setAutoChangeStyle(false);
        this.gud = (TextView) findViewById(d.g.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.gtR = shareFromGameCenterMsgData;
            lz(z);
        }
    }

    private void lz(boolean z) {
        if (z) {
            this.gub.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0236d.cp_cont_g));
            this.fsE.setTextColor(this.mContext.getResources().getColor(d.C0236d.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0236d.cp_cont_b));
            this.fsE.setTextColor(this.mContext.getResources().getColor(d.C0236d.cp_cont_f));
            this.gub.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.h(getContext(), d.e.ds14), 0, 0, 0);
            layoutParams.height = l.h(getContext(), d.e.ds48);
            this.geY.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.gtR.getTitle());
        this.gtY.setDefaultResource(d.f.pic_avatar_ba_140);
        this.gtY.setAutoChangeStyle(false);
        this.gtY.startLoad(this.gtR.getImageUrl(), 10, false);
        this.fsE.setText(this.gtR.getContent());
        this.gtZ.setTextColor(this.mContext.getResources().getColor(d.C0236d.cp_cont_b));
        this.gtZ.setBackgroundResource(d.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.gtR.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.h(getContext(), d.e.ds60));
            int h = l.h(getContext(), d.e.ds30);
            layoutParams2.setMargins(h, l.h(getContext(), d.e.ds18), h, h);
            this.gtZ.setLayoutParams(layoutParams2);
            this.gtZ.setVisibility(0);
            this.gtZ.setText(this.gtR.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int h2 = l.h(getContext(), d.e.ds30);
            layoutParams3.setMargins(h2, l.h(getContext(), d.e.ds20), h2, h2);
            this.gtZ.setVisibility(8);
            this.guc.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.gtR.getShareSource())) {
            this.geY.setVisibility(8);
        }
        this.gud.setText(this.gtR.getShareSource());
        this.gua.setDefaultResource(d.f.icon);
        this.gua.setAutoChangeStyle(false);
        this.gua.startLoad(this.gtR.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.CM(this.gtR.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.geY;
    }

    public LinearLayout getContentBody() {
        return this.gub;
    }

    public ImageView getTiebaIcon() {
        return this.gua;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.gua = tbImageView;
    }
}
