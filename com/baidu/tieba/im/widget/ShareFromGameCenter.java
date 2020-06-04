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
    private TextView aJn;
    private ShareFromGameCenterMsgData iLH;
    private HeadImageView iLO;
    private Button iLP;
    private TbImageView iLQ;
    private LinearLayout iLR;
    private LinearLayout iLS;
    private TextView iLT;
    private LinearLayout iwN;
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
        this.iLR = (LinearLayout) findViewById(R.id.share_info_layout);
        this.iLS = (LinearLayout) findViewById(R.id.game_share_content);
        this.iwN = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.aJn = (TextView) findViewById(R.id.game_desc);
        this.iLO = (HeadImageView) findViewById(R.id.game_img);
        this.iLO.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.iLO.setAutoChangeStyle(false);
        this.iLP = (Button) findViewById(R.id.accept_invite_button);
        this.iLQ = (TbImageView) findViewById(R.id.tail_icon);
        this.iLQ.setDefaultResource(R.drawable.tb_launcher_icon);
        this.iLQ.setAutoChangeStyle(false);
        this.iLT = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.iLH = shareFromGameCenterMsgData;
            pB(z);
        }
    }

    private void pB(boolean z) {
        if (z) {
            this.iLR.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
            this.aJn.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
            this.aJn.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
            this.iLR.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.getDimens(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.getDimens(getContext(), R.dimen.ds48);
            this.iwN.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.iLH.getTitle());
        this.iLO.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.iLO.setAutoChangeStyle(false);
        this.iLO.startLoad(this.iLH.getImageUrl(), 10, false);
        this.aJn.setText(this.iLH.getContent());
        this.iLP.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
        this.iLP.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.iLH.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds60));
            int dimens = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(dimens, l.getDimens(getContext(), R.dimen.ds18), dimens, dimens);
            this.iLP.setLayoutParams(layoutParams2);
            this.iLP.setVisibility(0);
            this.iLP.setText(this.iLH.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int dimens2 = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(dimens2, l.getDimens(getContext(), R.dimen.ds20), dimens2, dimens2);
            this.iLP.setVisibility(8);
            this.iLS.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.iLH.getShareSource())) {
            this.iwN.setVisibility(8);
        }
        this.iLT.setText(this.iLH.getShareSource());
        this.iLQ.setDefaultResource(R.drawable.tb_launcher_icon);
        this.iLQ.setAutoChangeStyle(false);
        this.iLQ.startLoad(this.iLH.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.MM(this.iLH.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.iwN;
    }

    public LinearLayout getContentBody() {
        return this.iLR;
    }

    public ImageView getTiebaIcon() {
        return this.iLQ;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.iLQ = tbImageView;
    }
}
