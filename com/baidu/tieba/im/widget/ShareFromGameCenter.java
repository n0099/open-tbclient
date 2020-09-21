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
    private TextView aix;
    private ShareFromGameCenterMsgData jIN;
    private HeadImageView jIU;
    private Button jIV;
    private TbImageView jIW;
    private LinearLayout jIX;
    private LinearLayout jIY;
    private TextView jIZ;
    private LinearLayout jsG;
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
        this.jIX = (LinearLayout) findViewById(R.id.share_info_layout);
        this.jIY = (LinearLayout) findViewById(R.id.game_share_content);
        this.jsG = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.aix = (TextView) findViewById(R.id.game_desc);
        this.jIU = (HeadImageView) findViewById(R.id.game_img);
        this.jIU.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.jIU.setAutoChangeStyle(false);
        this.jIV = (Button) findViewById(R.id.accept_invite_button);
        this.jIW = (TbImageView) findViewById(R.id.tail_icon);
        this.jIW.setDefaultResource(R.drawable.tb_launcher_icon);
        this.jIW.setAutoChangeStyle(false);
        this.jIZ = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.jIN = shareFromGameCenterMsgData;
            rj(z);
        }
    }

    private void rj(boolean z) {
        if (z) {
            this.jIX.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
            this.aix.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
            this.aix.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
            this.jIX.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.getDimens(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.getDimens(getContext(), R.dimen.ds48);
            this.jsG.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.jIN.getTitle());
        this.jIU.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.jIU.setAutoChangeStyle(false);
        this.jIU.startLoad(this.jIN.getImageUrl(), 10, false);
        this.aix.setText(this.jIN.getContent());
        this.jIV.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
        this.jIV.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.jIN.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds60));
            int dimens = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(dimens, l.getDimens(getContext(), R.dimen.ds18), dimens, dimens);
            this.jIV.setLayoutParams(layoutParams2);
            this.jIV.setVisibility(0);
            this.jIV.setText(this.jIN.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int dimens2 = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(dimens2, l.getDimens(getContext(), R.dimen.ds20), dimens2, dimens2);
            this.jIV.setVisibility(8);
            this.jIY.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.jIN.getShareSource())) {
            this.jsG.setVisibility(8);
        }
        this.jIZ.setText(this.jIN.getShareSource());
        this.jIW.setDefaultResource(R.drawable.tb_launcher_icon);
        this.jIW.setAutoChangeStyle(false);
        this.jIW.startLoad(this.jIN.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.Ru(this.jIN.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.jsG;
    }

    public LinearLayout getContentBody() {
        return this.jIX;
    }

    public ImageView getTiebaIcon() {
        return this.jIW;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.jIW = tbImageView;
    }
}
