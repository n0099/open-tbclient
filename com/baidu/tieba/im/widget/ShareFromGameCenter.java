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
    private ShareFromGameCenterMsgData iKU;
    private HeadImageView iLb;
    private Button iLc;
    private TbImageView iLd;
    private LinearLayout iLe;
    private LinearLayout iLf;
    private TextView iLg;
    private LinearLayout iwa;
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
        this.iLe = (LinearLayout) findViewById(R.id.share_info_layout);
        this.iLf = (LinearLayout) findViewById(R.id.game_share_content);
        this.iwa = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.aJn = (TextView) findViewById(R.id.game_desc);
        this.iLb = (HeadImageView) findViewById(R.id.game_img);
        this.iLb.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.iLb.setAutoChangeStyle(false);
        this.iLc = (Button) findViewById(R.id.accept_invite_button);
        this.iLd = (TbImageView) findViewById(R.id.tail_icon);
        this.iLd.setDefaultResource(R.drawable.tb_launcher_icon);
        this.iLd.setAutoChangeStyle(false);
        this.iLg = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.iKU = shareFromGameCenterMsgData;
            pB(z);
        }
    }

    private void pB(boolean z) {
        if (z) {
            this.iLe.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
            this.aJn.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
            this.aJn.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
            this.iLe.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.getDimens(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.getDimens(getContext(), R.dimen.ds48);
            this.iwa.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.iKU.getTitle());
        this.iLb.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.iLb.setAutoChangeStyle(false);
        this.iLb.startLoad(this.iKU.getImageUrl(), 10, false);
        this.aJn.setText(this.iKU.getContent());
        this.iLc.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
        this.iLc.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.iKU.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds60));
            int dimens = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(dimens, l.getDimens(getContext(), R.dimen.ds18), dimens, dimens);
            this.iLc.setLayoutParams(layoutParams2);
            this.iLc.setVisibility(0);
            this.iLc.setText(this.iKU.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int dimens2 = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(dimens2, l.getDimens(getContext(), R.dimen.ds20), dimens2, dimens2);
            this.iLc.setVisibility(8);
            this.iLf.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.iKU.getShareSource())) {
            this.iwa.setVisibility(8);
        }
        this.iLg.setText(this.iKU.getShareSource());
        this.iLd.setDefaultResource(R.drawable.tb_launcher_icon);
        this.iLd.setAutoChangeStyle(false);
        this.iLd.startLoad(this.iKU.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.ML(this.iKU.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.iwa;
    }

    public LinearLayout getContentBody() {
        return this.iLe;
    }

    public ImageView getTiebaIcon() {
        return this.iLd;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.iLd = tbImageView;
    }
}
