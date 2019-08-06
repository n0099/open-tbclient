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
    private TextView fOz;
    private LinearLayout gDd;
    private ShareFromGameCenterMsgData gRW;
    private HeadImageView gSd;
    private Button gSe;
    private TbImageView gSf;
    private LinearLayout gSg;
    private LinearLayout gSh;
    private TextView gSi;
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
        this.gSg = (LinearLayout) findViewById(R.id.share_info_layout);
        this.gSh = (LinearLayout) findViewById(R.id.game_share_content);
        this.gDd = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.fOz = (TextView) findViewById(R.id.game_desc);
        this.gSd = (HeadImageView) findViewById(R.id.game_img);
        this.gSd.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.gSd.setAutoChangeStyle(false);
        this.gSe = (Button) findViewById(R.id.accept_invite_button);
        this.gSf = (TbImageView) findViewById(R.id.tail_icon);
        this.gSf.setDefaultResource(R.drawable.icon);
        this.gSf.setAutoChangeStyle(false);
        this.gSi = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.gRW = shareFromGameCenterMsgData;
            mD(z);
        }
    }

    private void mD(boolean z) {
        if (z) {
            this.gSg.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
            this.fOz.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
            this.fOz.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
            this.gSg.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.g(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.g(getContext(), R.dimen.ds48);
            this.gDd.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.gRW.getTitle());
        this.gSd.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.gSd.setAutoChangeStyle(false);
        this.gSd.startLoad(this.gRW.getImageUrl(), 10, false);
        this.fOz.setText(this.gRW.getContent());
        this.gSe.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
        this.gSe.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.gRW.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.g(getContext(), R.dimen.ds60));
            int g = l.g(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(g, l.g(getContext(), R.dimen.ds18), g, g);
            this.gSe.setLayoutParams(layoutParams2);
            this.gSe.setVisibility(0);
            this.gSe.setText(this.gRW.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int g2 = l.g(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(g2, l.g(getContext(), R.dimen.ds20), g2, g2);
            this.gSe.setVisibility(8);
            this.gSh.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.gRW.getShareSource())) {
            this.gDd.setVisibility(8);
        }
        this.gSi.setText(this.gRW.getShareSource());
        this.gSf.setDefaultResource(R.drawable.icon);
        this.gSf.setAutoChangeStyle(false);
        this.gSf.startLoad(this.gRW.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.EV(this.gRW.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.gDd;
    }

    public LinearLayout getContentBody() {
        return this.gSg;
    }

    public ImageView getTiebaIcon() {
        return this.gSf;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.gSf = tbImageView;
    }
}
