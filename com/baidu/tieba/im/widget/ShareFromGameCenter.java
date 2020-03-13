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
    private TextView ali;
    private ShareFromGameCenterMsgData hKS;
    private HeadImageView hKZ;
    private Button hLa;
    private TbImageView hLb;
    private LinearLayout hLc;
    private LinearLayout hLd;
    private TextView hLe;
    private LinearLayout hvY;
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
        this.hLc = (LinearLayout) findViewById(R.id.share_info_layout);
        this.hLd = (LinearLayout) findViewById(R.id.game_share_content);
        this.hvY = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.ali = (TextView) findViewById(R.id.game_desc);
        this.hKZ = (HeadImageView) findViewById(R.id.game_img);
        this.hKZ.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.hKZ.setAutoChangeStyle(false);
        this.hLa = (Button) findViewById(R.id.accept_invite_button);
        this.hLb = (TbImageView) findViewById(R.id.tail_icon);
        this.hLb.setDefaultResource(R.drawable.tb_launcher_icon);
        this.hLb.setAutoChangeStyle(false);
        this.hLe = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.hKS = shareFromGameCenterMsgData;
            nV(z);
        }
    }

    private void nV(boolean z) {
        if (z) {
            this.hLc.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
            this.ali.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
            this.ali.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
            this.hLc.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.getDimens(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.getDimens(getContext(), R.dimen.ds48);
            this.hvY.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.hKS.getTitle());
        this.hKZ.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.hKZ.setAutoChangeStyle(false);
        this.hKZ.startLoad(this.hKS.getImageUrl(), 10, false);
        this.ali.setText(this.hKS.getContent());
        this.hLa.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
        this.hLa.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.hKS.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds60));
            int dimens = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(dimens, l.getDimens(getContext(), R.dimen.ds18), dimens, dimens);
            this.hLa.setLayoutParams(layoutParams2);
            this.hLa.setVisibility(0);
            this.hLa.setText(this.hKS.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int dimens2 = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(dimens2, l.getDimens(getContext(), R.dimen.ds20), dimens2, dimens2);
            this.hLa.setVisibility(8);
            this.hLd.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.hKS.getShareSource())) {
            this.hvY.setVisibility(8);
        }
        this.hLe.setText(this.hKS.getShareSource());
        this.hLb.setDefaultResource(R.drawable.tb_launcher_icon);
        this.hLb.setAutoChangeStyle(false);
        this.hLb.startLoad(this.hKS.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.Jm(this.hKS.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.hvY;
    }

    public LinearLayout getContentBody() {
        return this.hLc;
    }

    public ImageView getTiebaIcon() {
        return this.hLb;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.hLb = tbImageView;
    }
}
