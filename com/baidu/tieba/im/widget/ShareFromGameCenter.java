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
    private ShareFromGameCenterMsgData hKG;
    private HeadImageView hKN;
    private Button hKO;
    private TbImageView hKP;
    private LinearLayout hKQ;
    private LinearLayout hKR;
    private TextView hKS;
    private LinearLayout hvM;
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
        this.hKQ = (LinearLayout) findViewById(R.id.share_info_layout);
        this.hKR = (LinearLayout) findViewById(R.id.game_share_content);
        this.hvM = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.alh = (TextView) findViewById(R.id.game_desc);
        this.hKN = (HeadImageView) findViewById(R.id.game_img);
        this.hKN.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.hKN.setAutoChangeStyle(false);
        this.hKO = (Button) findViewById(R.id.accept_invite_button);
        this.hKP = (TbImageView) findViewById(R.id.tail_icon);
        this.hKP.setDefaultResource(R.drawable.tb_launcher_icon);
        this.hKP.setAutoChangeStyle(false);
        this.hKS = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.hKG = shareFromGameCenterMsgData;
            nV(z);
        }
    }

    private void nV(boolean z) {
        if (z) {
            this.hKQ.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
            this.alh.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
            this.alh.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
            this.hKQ.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.getDimens(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.getDimens(getContext(), R.dimen.ds48);
            this.hvM.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.hKG.getTitle());
        this.hKN.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.hKN.setAutoChangeStyle(false);
        this.hKN.startLoad(this.hKG.getImageUrl(), 10, false);
        this.alh.setText(this.hKG.getContent());
        this.hKO.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
        this.hKO.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.hKG.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds60));
            int dimens = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(dimens, l.getDimens(getContext(), R.dimen.ds18), dimens, dimens);
            this.hKO.setLayoutParams(layoutParams2);
            this.hKO.setVisibility(0);
            this.hKO.setText(this.hKG.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int dimens2 = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(dimens2, l.getDimens(getContext(), R.dimen.ds20), dimens2, dimens2);
            this.hKO.setVisibility(8);
            this.hKR.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.hKG.getShareSource())) {
            this.hvM.setVisibility(8);
        }
        this.hKS.setText(this.hKG.getShareSource());
        this.hKP.setDefaultResource(R.drawable.tb_launcher_icon);
        this.hKP.setAutoChangeStyle(false);
        this.hKP.startLoad(this.hKG.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.Jl(this.hKG.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.hvM;
    }

    public LinearLayout getContentBody() {
        return this.hKQ;
    }

    public ImageView getTiebaIcon() {
        return this.hKP;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.hKP = tbImageView;
    }
}
