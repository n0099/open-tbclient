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
    private TextView aja;
    private ShareFromGameCenterMsgData hIF;
    private HeadImageView hIM;
    private Button hIN;
    private TbImageView hIO;
    private LinearLayout hIP;
    private LinearLayout hIQ;
    private TextView hIR;
    private LinearLayout htL;
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
        this.hIP = (LinearLayout) findViewById(R.id.share_info_layout);
        this.hIQ = (LinearLayout) findViewById(R.id.game_share_content);
        this.htL = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.aja = (TextView) findViewById(R.id.game_desc);
        this.hIM = (HeadImageView) findViewById(R.id.game_img);
        this.hIM.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.hIM.setAutoChangeStyle(false);
        this.hIN = (Button) findViewById(R.id.accept_invite_button);
        this.hIO = (TbImageView) findViewById(R.id.tail_icon);
        this.hIO.setDefaultResource(R.drawable.tb_launcher_icon);
        this.hIO.setAutoChangeStyle(false);
        this.hIR = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.hIF = shareFromGameCenterMsgData;
            nT(z);
        }
    }

    private void nT(boolean z) {
        if (z) {
            this.hIP.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
            this.aja.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
            this.aja.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
            this.hIP.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.getDimens(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.getDimens(getContext(), R.dimen.ds48);
            this.htL.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.hIF.getTitle());
        this.hIM.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.hIM.setAutoChangeStyle(false);
        this.hIM.startLoad(this.hIF.getImageUrl(), 10, false);
        this.aja.setText(this.hIF.getContent());
        this.hIN.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
        this.hIN.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.hIF.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds60));
            int dimens = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(dimens, l.getDimens(getContext(), R.dimen.ds18), dimens, dimens);
            this.hIN.setLayoutParams(layoutParams2);
            this.hIN.setVisibility(0);
            this.hIN.setText(this.hIF.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int dimens2 = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(dimens2, l.getDimens(getContext(), R.dimen.ds20), dimens2, dimens2);
            this.hIN.setVisibility(8);
            this.hIQ.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.hIF.getShareSource())) {
            this.htL.setVisibility(8);
        }
        this.hIR.setText(this.hIF.getShareSource());
        this.hIO.setDefaultResource(R.drawable.tb_launcher_icon);
        this.hIO.setAutoChangeStyle(false);
        this.hIO.startLoad(this.hIF.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.IY(this.hIF.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.htL;
    }

    public LinearLayout getContentBody() {
        return this.hIP;
    }

    public ImageView getTiebaIcon() {
        return this.hIO;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.hIO = tbImageView;
    }
}
