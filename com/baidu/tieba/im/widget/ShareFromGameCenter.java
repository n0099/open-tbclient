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
    private LinearLayout kEJ;
    private ShareFromGameCenterMsgData kNl;
    private HeadImageView kNs;
    private Button kNt;
    private TbImageView kNu;
    private LinearLayout kNv;
    private LinearLayout kNw;
    private TextView kNx;
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
        this.kNv = (LinearLayout) findViewById(R.id.share_info_layout);
        this.kNw = (LinearLayout) findViewById(R.id.game_share_content);
        this.kEJ = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.aju = (TextView) findViewById(R.id.game_desc);
        this.kNs = (HeadImageView) findViewById(R.id.game_img);
        this.kNs.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.kNs.setAutoChangeStyle(false);
        this.kNt = (Button) findViewById(R.id.accept_invite_button);
        this.kNu = (TbImageView) findViewById(R.id.tail_icon);
        this.kNu.setDefaultResource(R.drawable.tb_launcher_icon);
        this.kNu.setAutoChangeStyle(false);
        this.kNx = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.kNl = shareFromGameCenterMsgData;
            tf(z);
        }
    }

    private void tf(boolean z) {
        if (z) {
            this.kNv.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0111));
            this.aju.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0111));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0105));
            this.aju.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0106));
            this.kNv.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.getDimens(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.getDimens(getContext(), R.dimen.ds48);
            this.kEJ.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.kNl.getTitle());
        this.kNs.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.kNs.setAutoChangeStyle(false);
        this.kNs.startLoad(this.kNl.getImageUrl(), 10, false);
        this.aju.setText(this.kNl.getContent());
        this.kNt.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0105));
        this.kNt.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.kNl.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds60));
            int dimens = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(dimens, l.getDimens(getContext(), R.dimen.ds18), dimens, dimens);
            this.kNt.setLayoutParams(layoutParams2);
            this.kNt.setVisibility(0);
            this.kNt.setText(this.kNl.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int dimens2 = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(dimens2, l.getDimens(getContext(), R.dimen.ds20), dimens2, dimens2);
            this.kNt.setVisibility(8);
            this.kNw.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.kNl.getShareSource())) {
            this.kEJ.setVisibility(8);
        }
        this.kNx.setText(this.kNl.getShareSource());
        this.kNu.setDefaultResource(R.drawable.tb_launcher_icon);
        this.kNu.setAutoChangeStyle(false);
        this.kNu.startLoad(this.kNl.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.TJ(this.kNl.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.kEJ;
    }

    public LinearLayout getContentBody() {
        return this.kNv;
    }

    public ImageView getTiebaIcon() {
        return this.kNu;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.kNu = tbImageView;
    }
}
