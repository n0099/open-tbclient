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
    private TextView fNL;
    private LinearLayout gCl;
    private ShareFromGameCenterMsgData gRe;
    private HeadImageView gRl;
    private Button gRm;
    private TbImageView gRn;
    private LinearLayout gRo;
    private LinearLayout gRp;
    private TextView gRq;
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
        this.gRo = (LinearLayout) findViewById(R.id.share_info_layout);
        this.gRp = (LinearLayout) findViewById(R.id.game_share_content);
        this.gCl = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.fNL = (TextView) findViewById(R.id.game_desc);
        this.gRl = (HeadImageView) findViewById(R.id.game_img);
        this.gRl.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.gRl.setAutoChangeStyle(false);
        this.gRm = (Button) findViewById(R.id.accept_invite_button);
        this.gRn = (TbImageView) findViewById(R.id.tail_icon);
        this.gRn.setDefaultResource(R.drawable.icon);
        this.gRn.setAutoChangeStyle(false);
        this.gRq = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.gRe = shareFromGameCenterMsgData;
            mD(z);
        }
    }

    private void mD(boolean z) {
        if (z) {
            this.gRo.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
            this.fNL.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
            this.fNL.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
            this.gRo.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.g(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.g(getContext(), R.dimen.ds48);
            this.gCl.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.gRe.getTitle());
        this.gRl.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.gRl.setAutoChangeStyle(false);
        this.gRl.startLoad(this.gRe.getImageUrl(), 10, false);
        this.fNL.setText(this.gRe.getContent());
        this.gRm.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
        this.gRm.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.gRe.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.g(getContext(), R.dimen.ds60));
            int g = l.g(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(g, l.g(getContext(), R.dimen.ds18), g, g);
            this.gRm.setLayoutParams(layoutParams2);
            this.gRm.setVisibility(0);
            this.gRm.setText(this.gRe.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int g2 = l.g(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(g2, l.g(getContext(), R.dimen.ds20), g2, g2);
            this.gRm.setVisibility(8);
            this.gRp.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.gRe.getShareSource())) {
            this.gCl.setVisibility(8);
        }
        this.gRq.setText(this.gRe.getShareSource());
        this.gRn.setDefaultResource(R.drawable.icon);
        this.gRn.setAutoChangeStyle(false);
        this.gRn.startLoad(this.gRe.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.EU(this.gRe.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.gCl;
    }

    public LinearLayout getContentBody() {
        return this.gRo;
    }

    public ImageView getTiebaIcon() {
        return this.gRn;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.gRn = tbImageView;
    }
}
