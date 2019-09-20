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
    private TextView fQp;
    private LinearLayout gEU;
    private ShareFromGameCenterMsgData gTP;
    private HeadImageView gTW;
    private Button gTX;
    private TbImageView gTY;
    private LinearLayout gTZ;
    private LinearLayout gUa;
    private TextView gUb;
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
        this.gTZ = (LinearLayout) findViewById(R.id.share_info_layout);
        this.gUa = (LinearLayout) findViewById(R.id.game_share_content);
        this.gEU = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.fQp = (TextView) findViewById(R.id.game_desc);
        this.gTW = (HeadImageView) findViewById(R.id.game_img);
        this.gTW.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.gTW.setAutoChangeStyle(false);
        this.gTX = (Button) findViewById(R.id.accept_invite_button);
        this.gTY = (TbImageView) findViewById(R.id.tail_icon);
        this.gTY.setDefaultResource(R.drawable.icon);
        this.gTY.setAutoChangeStyle(false);
        this.gUb = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.gTP = shareFromGameCenterMsgData;
            mG(z);
        }
    }

    private void mG(boolean z) {
        if (z) {
            this.gTZ.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
            this.fQp.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
            this.fQp.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
            this.gTZ.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.g(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.g(getContext(), R.dimen.ds48);
            this.gEU.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.gTP.getTitle());
        this.gTW.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.gTW.setAutoChangeStyle(false);
        this.gTW.startLoad(this.gTP.getImageUrl(), 10, false);
        this.fQp.setText(this.gTP.getContent());
        this.gTX.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
        this.gTX.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.gTP.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.g(getContext(), R.dimen.ds60));
            int g = l.g(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(g, l.g(getContext(), R.dimen.ds18), g, g);
            this.gTX.setLayoutParams(layoutParams2);
            this.gTX.setVisibility(0);
            this.gTX.setText(this.gTP.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int g2 = l.g(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(g2, l.g(getContext(), R.dimen.ds20), g2, g2);
            this.gTX.setVisibility(8);
            this.gUa.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.gTP.getShareSource())) {
            this.gEU.setVisibility(8);
        }
        this.gUb.setText(this.gTP.getShareSource());
        this.gTY.setDefaultResource(R.drawable.icon);
        this.gTY.setAutoChangeStyle(false);
        this.gTY.startLoad(this.gTP.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", SmsLoginView.StatEvent.LOGIN_SHOW, 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.Fv(this.gTP.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.gEU;
    }

    public LinearLayout getContentBody() {
        return this.gTZ;
    }

    public ImageView getTiebaIcon() {
        return this.gTY;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.gTY = tbImageView;
    }
}
