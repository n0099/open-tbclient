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
    private TextView aiQ;
    private LinearLayout jUc;
    private ShareFromGameCenterMsgData kkk;
    private HeadImageView kkr;
    private Button kks;
    private TbImageView kkt;
    private LinearLayout kku;
    private LinearLayout kkv;
    private TextView kkw;
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
        this.kku = (LinearLayout) findViewById(R.id.share_info_layout);
        this.kkv = (LinearLayout) findViewById(R.id.game_share_content);
        this.jUc = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.aiQ = (TextView) findViewById(R.id.game_desc);
        this.kkr = (HeadImageView) findViewById(R.id.game_img);
        this.kkr.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.kkr.setAutoChangeStyle(false);
        this.kks = (Button) findViewById(R.id.accept_invite_button);
        this.kkt = (TbImageView) findViewById(R.id.tail_icon);
        this.kkt.setDefaultResource(R.drawable.tb_launcher_icon);
        this.kkt.setAutoChangeStyle(false);
        this.kkw = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.kkk = shareFromGameCenterMsgData;
            sh(z);
        }
    }

    private void sh(boolean z) {
        if (z) {
            this.kku.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
            this.aiQ.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
            this.aiQ.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
            this.kku.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.getDimens(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.getDimens(getContext(), R.dimen.ds48);
            this.jUc.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.kkk.getTitle());
        this.kkr.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.kkr.setAutoChangeStyle(false);
        this.kkr.startLoad(this.kkk.getImageUrl(), 10, false);
        this.aiQ.setText(this.kkk.getContent());
        this.kks.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
        this.kks.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.kkk.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds60));
            int dimens = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(dimens, l.getDimens(getContext(), R.dimen.ds18), dimens, dimens);
            this.kks.setLayoutParams(layoutParams2);
            this.kks.setVisibility(0);
            this.kks.setText(this.kkk.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int dimens2 = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(dimens2, l.getDimens(getContext(), R.dimen.ds20), dimens2, dimens2);
            this.kks.setVisibility(8);
            this.kkv.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.kkk.getShareSource())) {
            this.jUc.setVisibility(8);
        }
        this.kkw.setText(this.kkk.getShareSource());
        this.kkt.setDefaultResource(R.drawable.tb_launcher_icon);
        this.kkt.setAutoChangeStyle(false);
        this.kkt.startLoad(this.kkk.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.SH(this.kkk.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.jUc;
    }

    public LinearLayout getContentBody() {
        return this.kku;
    }

    public ImageView getTiebaIcon() {
        return this.kkt;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.kkt = tbImageView;
    }
}
