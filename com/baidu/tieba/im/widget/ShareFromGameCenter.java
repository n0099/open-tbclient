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
    private TextView akw;
    private LinearLayout kAU;
    private HeadImageView kJE;
    private Button kJF;
    private TbImageView kJG;
    private LinearLayout kJH;
    private LinearLayout kJI;
    private TextView kJJ;
    private ShareFromGameCenterMsgData kJx;
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
        this.kJH = (LinearLayout) findViewById(R.id.share_info_layout);
        this.kJI = (LinearLayout) findViewById(R.id.game_share_content);
        this.kAU = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.akw = (TextView) findViewById(R.id.game_desc);
        this.kJE = (HeadImageView) findViewById(R.id.game_img);
        this.kJE.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.kJE.setAutoChangeStyle(false);
        this.kJF = (Button) findViewById(R.id.accept_invite_button);
        this.kJG = (TbImageView) findViewById(R.id.tail_icon);
        this.kJG.setDefaultResource(R.drawable.tb_launcher_icon);
        this.kJG.setAutoChangeStyle(false);
        this.kJJ = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.kJx = shareFromGameCenterMsgData;
            sW(z);
        }
    }

    private void sW(boolean z) {
        if (z) {
            this.kJH.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0111));
            this.akw.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0111));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0105));
            this.akw.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0106));
            this.kJH.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.getDimens(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.getDimens(getContext(), R.dimen.ds48);
            this.kAU.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.kJx.getTitle());
        this.kJE.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.kJE.setAutoChangeStyle(false);
        this.kJE.startLoad(this.kJx.getImageUrl(), 10, false);
        this.akw.setText(this.kJx.getContent());
        this.kJF.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0105));
        this.kJF.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.kJx.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds60));
            int dimens = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(dimens, l.getDimens(getContext(), R.dimen.ds18), dimens, dimens);
            this.kJF.setLayoutParams(layoutParams2);
            this.kJF.setVisibility(0);
            this.kJF.setText(this.kJx.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int dimens2 = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(dimens2, l.getDimens(getContext(), R.dimen.ds20), dimens2, dimens2);
            this.kJF.setVisibility(8);
            this.kJI.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.kJx.getShareSource())) {
            this.kAU.setVisibility(8);
        }
        this.kJJ.setText(this.kJx.getShareSource());
        this.kJG.setDefaultResource(R.drawable.tb_launcher_icon);
        this.kJG.setAutoChangeStyle(false);
        this.kJG.startLoad(this.kJx.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.TH(this.kJx.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.kAU;
    }

    public LinearLayout getContentBody() {
        return this.kJH;
    }

    public ImageView getTiebaIcon() {
        return this.kJG;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.kJG = tbImageView;
    }
}
