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
    private TextView alt;
    private Button hMA;
    private TbImageView hMB;
    private LinearLayout hMC;
    private LinearLayout hMD;
    private TextView hME;
    private ShareFromGameCenterMsgData hMs;
    private HeadImageView hMz;
    private LinearLayout hxy;
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
        this.hMC = (LinearLayout) findViewById(R.id.share_info_layout);
        this.hMD = (LinearLayout) findViewById(R.id.game_share_content);
        this.hxy = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.alt = (TextView) findViewById(R.id.game_desc);
        this.hMz = (HeadImageView) findViewById(R.id.game_img);
        this.hMz.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.hMz.setAutoChangeStyle(false);
        this.hMA = (Button) findViewById(R.id.accept_invite_button);
        this.hMB = (TbImageView) findViewById(R.id.tail_icon);
        this.hMB.setDefaultResource(R.drawable.tb_launcher_icon);
        this.hMB.setAutoChangeStyle(false);
        this.hME = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.hMs = shareFromGameCenterMsgData;
            ob(z);
        }
    }

    private void ob(boolean z) {
        if (z) {
            this.hMC.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
            this.alt.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
            this.alt.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
            this.hMC.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.getDimens(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.getDimens(getContext(), R.dimen.ds48);
            this.hxy.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.hMs.getTitle());
        this.hMz.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.hMz.setAutoChangeStyle(false);
        this.hMz.startLoad(this.hMs.getImageUrl(), 10, false);
        this.alt.setText(this.hMs.getContent());
        this.hMA.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
        this.hMA.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.hMs.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds60));
            int dimens = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(dimens, l.getDimens(getContext(), R.dimen.ds18), dimens, dimens);
            this.hMA.setLayoutParams(layoutParams2);
            this.hMA.setVisibility(0);
            this.hMA.setText(this.hMs.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int dimens2 = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(dimens2, l.getDimens(getContext(), R.dimen.ds20), dimens2, dimens2);
            this.hMA.setVisibility(8);
            this.hMD.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.hMs.getShareSource())) {
            this.hxy.setVisibility(8);
        }
        this.hME.setText(this.hMs.getShareSource());
        this.hMB.setDefaultResource(R.drawable.tb_launcher_icon);
        this.hMB.setAutoChangeStyle(false);
        this.hMB.startLoad(this.hMs.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.Jl(this.hMs.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.hxy;
    }

    public LinearLayout getContentBody() {
        return this.hMC;
    }

    public ImageView getTiebaIcon() {
        return this.hMB;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.hMB = tbImageView;
    }
}
