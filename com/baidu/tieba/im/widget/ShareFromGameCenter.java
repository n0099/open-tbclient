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
    private TextView aiP;
    private LinearLayout jHD;
    private ShareFromGameCenterMsgData jXK;
    private HeadImageView jXR;
    private Button jXS;
    private TbImageView jXT;
    private LinearLayout jXU;
    private LinearLayout jXV;
    private TextView jXW;
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
        this.jXU = (LinearLayout) findViewById(R.id.share_info_layout);
        this.jXV = (LinearLayout) findViewById(R.id.game_share_content);
        this.jHD = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.aiP = (TextView) findViewById(R.id.game_desc);
        this.jXR = (HeadImageView) findViewById(R.id.game_img);
        this.jXR.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.jXR.setAutoChangeStyle(false);
        this.jXS = (Button) findViewById(R.id.accept_invite_button);
        this.jXT = (TbImageView) findViewById(R.id.tail_icon);
        this.jXT.setDefaultResource(R.drawable.tb_launcher_icon);
        this.jXT.setAutoChangeStyle(false);
        this.jXW = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.jXK = shareFromGameCenterMsgData;
            rP(z);
        }
    }

    private void rP(boolean z) {
        if (z) {
            this.jXU.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
            this.aiP.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
            this.aiP.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
            this.jXU.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.getDimens(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.getDimens(getContext(), R.dimen.ds48);
            this.jHD.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.jXK.getTitle());
        this.jXR.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.jXR.setAutoChangeStyle(false);
        this.jXR.startLoad(this.jXK.getImageUrl(), 10, false);
        this.aiP.setText(this.jXK.getContent());
        this.jXS.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
        this.jXS.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.jXK.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds60));
            int dimens = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(dimens, l.getDimens(getContext(), R.dimen.ds18), dimens, dimens);
            this.jXS.setLayoutParams(layoutParams2);
            this.jXS.setVisibility(0);
            this.jXS.setText(this.jXK.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int dimens2 = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(dimens2, l.getDimens(getContext(), R.dimen.ds20), dimens2, dimens2);
            this.jXS.setVisibility(8);
            this.jXV.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.jXK.getShareSource())) {
            this.jHD.setVisibility(8);
        }
        this.jXW.setText(this.jXK.getShareSource());
        this.jXT.setDefaultResource(R.drawable.tb_launcher_icon);
        this.jXT.setAutoChangeStyle(false);
        this.jXT.startLoad(this.jXK.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.Si(this.jXK.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.jHD;
    }

    public LinearLayout getContentBody() {
        return this.jXU;
    }

    public ImageView getTiebaIcon() {
        return this.jXT;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.jXT = tbImageView;
    }
}
