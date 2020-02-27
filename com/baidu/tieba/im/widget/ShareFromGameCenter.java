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
    private TextView alh;
    private ShareFromGameCenterMsgData hKE;
    private HeadImageView hKL;
    private Button hKM;
    private TbImageView hKN;
    private LinearLayout hKO;
    private LinearLayout hKP;
    private TextView hKQ;
    private LinearLayout hvK;
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
        this.hKO = (LinearLayout) findViewById(R.id.share_info_layout);
        this.hKP = (LinearLayout) findViewById(R.id.game_share_content);
        this.hvK = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.alh = (TextView) findViewById(R.id.game_desc);
        this.hKL = (HeadImageView) findViewById(R.id.game_img);
        this.hKL.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.hKL.setAutoChangeStyle(false);
        this.hKM = (Button) findViewById(R.id.accept_invite_button);
        this.hKN = (TbImageView) findViewById(R.id.tail_icon);
        this.hKN.setDefaultResource(R.drawable.tb_launcher_icon);
        this.hKN.setAutoChangeStyle(false);
        this.hKQ = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.hKE = shareFromGameCenterMsgData;
            nV(z);
        }
    }

    private void nV(boolean z) {
        if (z) {
            this.hKO.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
            this.alh.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
            this.alh.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
            this.hKO.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.getDimens(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.getDimens(getContext(), R.dimen.ds48);
            this.hvK.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.hKE.getTitle());
        this.hKL.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.hKL.setAutoChangeStyle(false);
        this.hKL.startLoad(this.hKE.getImageUrl(), 10, false);
        this.alh.setText(this.hKE.getContent());
        this.hKM.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
        this.hKM.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.hKE.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds60));
            int dimens = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(dimens, l.getDimens(getContext(), R.dimen.ds18), dimens, dimens);
            this.hKM.setLayoutParams(layoutParams2);
            this.hKM.setVisibility(0);
            this.hKM.setText(this.hKE.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int dimens2 = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(dimens2, l.getDimens(getContext(), R.dimen.ds20), dimens2, dimens2);
            this.hKM.setVisibility(8);
            this.hKP.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.hKE.getShareSource())) {
            this.hvK.setVisibility(8);
        }
        this.hKQ.setText(this.hKE.getShareSource());
        this.hKN.setDefaultResource(R.drawable.tb_launcher_icon);
        this.hKN.setAutoChangeStyle(false);
        this.hKN.startLoad(this.hKE.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.Jl(this.hKE.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.hvK;
    }

    public LinearLayout getContentBody() {
        return this.hKO;
    }

    public ImageView getTiebaIcon() {
        return this.hKN;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.hKN = tbImageView;
    }
}
