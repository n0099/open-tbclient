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
    private TextView aju;
    private LinearLayout kEv;
    private ShareFromGameCenterMsgData kMX;
    private HeadImageView kNe;
    private Button kNf;
    private TbImageView kNg;
    private LinearLayout kNh;
    private LinearLayout kNi;
    private TextView kNj;
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
        this.kNh = (LinearLayout) findViewById(R.id.share_info_layout);
        this.kNi = (LinearLayout) findViewById(R.id.game_share_content);
        this.kEv = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.aju = (TextView) findViewById(R.id.game_desc);
        this.kNe = (HeadImageView) findViewById(R.id.game_img);
        this.kNe.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.kNe.setAutoChangeStyle(false);
        this.kNf = (Button) findViewById(R.id.accept_invite_button);
        this.kNg = (TbImageView) findViewById(R.id.tail_icon);
        this.kNg.setDefaultResource(R.drawable.tb_launcher_icon);
        this.kNg.setAutoChangeStyle(false);
        this.kNj = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.kMX = shareFromGameCenterMsgData;
            tf(z);
        }
    }

    private void tf(boolean z) {
        if (z) {
            this.kNh.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0111));
            this.aju.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0111));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0105));
            this.aju.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0106));
            this.kNh.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.getDimens(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.getDimens(getContext(), R.dimen.ds48);
            this.kEv.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.kMX.getTitle());
        this.kNe.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.kNe.setAutoChangeStyle(false);
        this.kNe.startLoad(this.kMX.getImageUrl(), 10, false);
        this.aju.setText(this.kMX.getContent());
        this.kNf.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0105));
        this.kNf.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.kMX.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds60));
            int dimens = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(dimens, l.getDimens(getContext(), R.dimen.ds18), dimens, dimens);
            this.kNf.setLayoutParams(layoutParams2);
            this.kNf.setVisibility(0);
            this.kNf.setText(this.kMX.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int dimens2 = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(dimens2, l.getDimens(getContext(), R.dimen.ds20), dimens2, dimens2);
            this.kNf.setVisibility(8);
            this.kNi.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.kMX.getShareSource())) {
            this.kEv.setVisibility(8);
        }
        this.kNj.setText(this.kMX.getShareSource());
        this.kNg.setDefaultResource(R.drawable.tb_launcher_icon);
        this.kNg.setAutoChangeStyle(false);
        this.kNg.startLoad(this.kMX.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.Tx(this.kMX.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.kEv;
    }

    public LinearLayout getContentBody() {
        return this.kNh;
    }

    public ImageView getTiebaIcon() {
        return this.kNg;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.kNg = tbImageView;
    }
}
