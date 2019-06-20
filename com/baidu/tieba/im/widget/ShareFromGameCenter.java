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
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private TextView fIN;
    private ShareFromGameCenterMsgData gKU;
    private HeadImageView gLb;
    private Button gLc;
    private TbImageView gLd;
    private LinearLayout gLe;
    private LinearLayout gLf;
    private TextView gLg;
    private LinearLayout gwa;
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
        LayoutInflater.from(getContext()).inflate(R.layout.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.gLe = (LinearLayout) findViewById(R.id.share_info_layout);
        this.gLf = (LinearLayout) findViewById(R.id.game_share_content);
        this.gwa = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.fIN = (TextView) findViewById(R.id.game_desc);
        this.gLb = (HeadImageView) findViewById(R.id.game_img);
        this.gLb.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.gLb.setAutoChangeStyle(false);
        this.gLc = (Button) findViewById(R.id.accept_invite_button);
        this.gLd = (TbImageView) findViewById(R.id.tail_icon);
        this.gLd.setDefaultResource(R.drawable.icon);
        this.gLd.setAutoChangeStyle(false);
        this.gLg = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.gKU = shareFromGameCenterMsgData;
            mp(z);
        }
    }

    private void mp(boolean z) {
        if (z) {
            this.gLe.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
            this.fIN.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
            this.fIN.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
            this.gLe.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.g(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.g(getContext(), R.dimen.ds48);
            this.gwa.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.gKU.getTitle());
        this.gLb.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.gLb.setAutoChangeStyle(false);
        this.gLb.startLoad(this.gKU.getImageUrl(), 10, false);
        this.fIN.setText(this.gKU.getContent());
        this.gLc.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
        this.gLc.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.gKU.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.g(getContext(), R.dimen.ds60));
            int g = l.g(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(g, l.g(getContext(), R.dimen.ds18), g, g);
            this.gLc.setLayoutParams(layoutParams2);
            this.gLc.setVisibility(0);
            this.gLc.setText(this.gKU.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int g2 = l.g(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(g2, l.g(getContext(), R.dimen.ds20), g2, g2);
            this.gLc.setVisibility(8);
            this.gLf.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.gKU.getShareSource())) {
            this.gwa.setVisibility(8);
        }
        this.gLg.setText(this.gKU.getShareSource());
        this.gLd.setDefaultResource(R.drawable.icon);
        this.gLd.setAutoChangeStyle(false);
        this.gLd.startLoad(this.gKU.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.Eh(this.gKU.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.gwa;
    }

    public LinearLayout getContentBody() {
        return this.gLe;
    }

    public ImageView getTiebaIcon() {
        return this.gLd;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.gLd = tbImageView;
    }
}
