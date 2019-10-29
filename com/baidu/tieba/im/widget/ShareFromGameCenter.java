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
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private TextView aaF;
    private LinearLayout gCU;
    private ShareFromGameCenterMsgData gRP;
    private HeadImageView gRW;
    private Button gRX;
    private TbImageView gRY;
    private LinearLayout gRZ;
    private LinearLayout gSa;
    private TextView gSb;
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
        this.gRZ = (LinearLayout) findViewById(R.id.share_info_layout);
        this.gSa = (LinearLayout) findViewById(R.id.game_share_content);
        this.gCU = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.aaF = (TextView) findViewById(R.id.game_desc);
        this.gRW = (HeadImageView) findViewById(R.id.game_img);
        this.gRW.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.gRW.setAutoChangeStyle(false);
        this.gRX = (Button) findViewById(R.id.accept_invite_button);
        this.gRY = (TbImageView) findViewById(R.id.tail_icon);
        this.gRY.setDefaultResource(R.drawable.icon);
        this.gRY.setAutoChangeStyle(false);
        this.gSb = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.gRP = shareFromGameCenterMsgData;
            mu(z);
        }
    }

    private void mu(boolean z) {
        if (z) {
            this.gRZ.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
            this.aaF.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
            this.aaF.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
            this.gRZ.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.getDimens(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.getDimens(getContext(), R.dimen.ds48);
            this.gCU.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.gRP.getTitle());
        this.gRW.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.gRW.setAutoChangeStyle(false);
        this.gRW.startLoad(this.gRP.getImageUrl(), 10, false);
        this.aaF.setText(this.gRP.getContent());
        this.gRX.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
        this.gRX.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.gRP.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds60));
            int dimens = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(dimens, l.getDimens(getContext(), R.dimen.ds18), dimens, dimens);
            this.gRX.setLayoutParams(layoutParams2);
            this.gRX.setVisibility(0);
            this.gRX.setText(this.gRP.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int dimens2 = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(dimens2, l.getDimens(getContext(), R.dimen.ds20), dimens2, dimens2);
            this.gRX.setVisibility(8);
            this.gSa.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.gRP.getShareSource())) {
            this.gCU.setVisibility(8);
        }
        this.gSb.setText(this.gRP.getShareSource());
        this.gRY.setDefaultResource(R.drawable.icon);
        this.gRY.setAutoChangeStyle(false);
        this.gRY.startLoad(this.gRP.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.DZ(this.gRP.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.gCU;
    }

    public LinearLayout getContentBody() {
        return this.gRZ;
    }

    public ImageView getTiebaIcon() {
        return this.gRY;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.gRY = tbImageView;
    }
}
