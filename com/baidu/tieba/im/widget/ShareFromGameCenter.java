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
    private TextView ajF;
    private ShareFromGameCenterMsgData kES;
    private HeadImageView kEZ;
    private Button kFa;
    private TbImageView kFb;
    private LinearLayout kFc;
    private LinearLayout kFd;
    private TextView kFe;
    private LinearLayout kwp;
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
        this.kFc = (LinearLayout) findViewById(R.id.share_info_layout);
        this.kFd = (LinearLayout) findViewById(R.id.game_share_content);
        this.kwp = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.ajF = (TextView) findViewById(R.id.game_desc);
        this.kEZ = (HeadImageView) findViewById(R.id.game_img);
        this.kEZ.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.kEZ.setAutoChangeStyle(false);
        this.kFa = (Button) findViewById(R.id.accept_invite_button);
        this.kFb = (TbImageView) findViewById(R.id.tail_icon);
        this.kFb.setDefaultResource(R.drawable.tb_launcher_icon);
        this.kFb.setAutoChangeStyle(false);
        this.kFe = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.kES = shareFromGameCenterMsgData;
            sS(z);
        }
    }

    private void sS(boolean z) {
        if (z) {
            this.kFc.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0111));
            this.ajF.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0111));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0105));
            this.ajF.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0106));
            this.kFc.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.getDimens(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.getDimens(getContext(), R.dimen.ds48);
            this.kwp.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.kES.getTitle());
        this.kEZ.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.kEZ.setAutoChangeStyle(false);
        this.kEZ.startLoad(this.kES.getImageUrl(), 10, false);
        this.ajF.setText(this.kES.getContent());
        this.kFa.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0105));
        this.kFa.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.kES.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds60));
            int dimens = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(dimens, l.getDimens(getContext(), R.dimen.ds18), dimens, dimens);
            this.kFa.setLayoutParams(layoutParams2);
            this.kFa.setVisibility(0);
            this.kFa.setText(this.kES.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int dimens2 = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(dimens2, l.getDimens(getContext(), R.dimen.ds20), dimens2, dimens2);
            this.kFa.setVisibility(8);
            this.kFd.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.kES.getShareSource())) {
            this.kwp.setVisibility(8);
        }
        this.kFe.setText(this.kES.getShareSource());
        this.kFb.setDefaultResource(R.drawable.tb_launcher_icon);
        this.kFb.setAutoChangeStyle(false);
        this.kFb.startLoad(this.kES.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.SA(this.kES.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.kwp;
    }

    public LinearLayout getContentBody() {
        return this.kFc;
    }

    public ImageView getTiebaIcon() {
        return this.kFb;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.kFb = tbImageView;
    }
}
