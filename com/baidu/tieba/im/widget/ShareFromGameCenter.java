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
    private TextView fIL;
    private ShareFromGameCenterMsgData gKS;
    private HeadImageView gKZ;
    private Button gLa;
    private TbImageView gLb;
    private LinearLayout gLc;
    private LinearLayout gLd;
    private TextView gLe;
    private LinearLayout gvY;
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
        this.gLc = (LinearLayout) findViewById(R.id.share_info_layout);
        this.gLd = (LinearLayout) findViewById(R.id.game_share_content);
        this.gvY = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.fIL = (TextView) findViewById(R.id.game_desc);
        this.gKZ = (HeadImageView) findViewById(R.id.game_img);
        this.gKZ.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.gKZ.setAutoChangeStyle(false);
        this.gLa = (Button) findViewById(R.id.accept_invite_button);
        this.gLb = (TbImageView) findViewById(R.id.tail_icon);
        this.gLb.setDefaultResource(R.drawable.icon);
        this.gLb.setAutoChangeStyle(false);
        this.gLe = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.gKS = shareFromGameCenterMsgData;
            mo(z);
        }
    }

    private void mo(boolean z) {
        if (z) {
            this.gLc.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
            this.fIL.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
            this.fIL.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
            this.gLc.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.g(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.g(getContext(), R.dimen.ds48);
            this.gvY.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.gKS.getTitle());
        this.gKZ.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.gKZ.setAutoChangeStyle(false);
        this.gKZ.startLoad(this.gKS.getImageUrl(), 10, false);
        this.fIL.setText(this.gKS.getContent());
        this.gLa.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
        this.gLa.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.gKS.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.g(getContext(), R.dimen.ds60));
            int g = l.g(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(g, l.g(getContext(), R.dimen.ds18), g, g);
            this.gLa.setLayoutParams(layoutParams2);
            this.gLa.setVisibility(0);
            this.gLa.setText(this.gKS.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int g2 = l.g(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(g2, l.g(getContext(), R.dimen.ds20), g2, g2);
            this.gLa.setVisibility(8);
            this.gLd.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.gKS.getShareSource())) {
            this.gvY.setVisibility(8);
        }
        this.gLe.setText(this.gKS.getShareSource());
        this.gLb.setDefaultResource(R.drawable.icon);
        this.gLb.setAutoChangeStyle(false);
        this.gLb.startLoad(this.gKS.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.Ef(this.gKS.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.gvY;
    }

    public LinearLayout getContentBody() {
        return this.gLc;
    }

    public ImageView getTiebaIcon() {
        return this.gLb;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.gLb = tbImageView;
    }
}
