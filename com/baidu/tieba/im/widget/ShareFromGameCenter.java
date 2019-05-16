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
    private TextView fIK;
    private ShareFromGameCenterMsgData gKR;
    private HeadImageView gKY;
    private Button gKZ;
    private TbImageView gLa;
    private LinearLayout gLb;
    private LinearLayout gLc;
    private TextView gLd;
    private LinearLayout gvX;
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
        this.gLb = (LinearLayout) findViewById(R.id.share_info_layout);
        this.gLc = (LinearLayout) findViewById(R.id.game_share_content);
        this.gvX = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.fIK = (TextView) findViewById(R.id.game_desc);
        this.gKY = (HeadImageView) findViewById(R.id.game_img);
        this.gKY.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.gKY.setAutoChangeStyle(false);
        this.gKZ = (Button) findViewById(R.id.accept_invite_button);
        this.gLa = (TbImageView) findViewById(R.id.tail_icon);
        this.gLa.setDefaultResource(R.drawable.icon);
        this.gLa.setAutoChangeStyle(false);
        this.gLd = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.gKR = shareFromGameCenterMsgData;
            mo(z);
        }
    }

    private void mo(boolean z) {
        if (z) {
            this.gLb.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
            this.fIK.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
            this.fIK.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
            this.gLb.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.g(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.g(getContext(), R.dimen.ds48);
            this.gvX.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.gKR.getTitle());
        this.gKY.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.gKY.setAutoChangeStyle(false);
        this.gKY.startLoad(this.gKR.getImageUrl(), 10, false);
        this.fIK.setText(this.gKR.getContent());
        this.gKZ.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
        this.gKZ.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.gKR.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.g(getContext(), R.dimen.ds60));
            int g = l.g(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(g, l.g(getContext(), R.dimen.ds18), g, g);
            this.gKZ.setLayoutParams(layoutParams2);
            this.gKZ.setVisibility(0);
            this.gKZ.setText(this.gKR.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int g2 = l.g(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(g2, l.g(getContext(), R.dimen.ds20), g2, g2);
            this.gKZ.setVisibility(8);
            this.gLc.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.gKR.getShareSource())) {
            this.gvX.setVisibility(8);
        }
        this.gLd.setText(this.gKR.getShareSource());
        this.gLa.setDefaultResource(R.drawable.icon);
        this.gLa.setAutoChangeStyle(false);
        this.gLa.startLoad(this.gKR.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.Ef(this.gKR.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.gvX;
    }

    public LinearLayout getContentBody() {
        return this.gLb;
    }

    public ImageView getTiebaIcon() {
        return this.gLa;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.gLa = tbImageView;
    }
}
