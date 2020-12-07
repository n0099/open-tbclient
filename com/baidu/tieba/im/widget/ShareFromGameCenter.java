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
    private TextView ajU;
    private ShareFromGameCenterMsgData kEm;
    private HeadImageView kEt;
    private Button kEu;
    private TbImageView kEv;
    private LinearLayout kEw;
    private LinearLayout kEx;
    private TextView kEy;
    private LinearLayout kon;
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
        this.kEw = (LinearLayout) findViewById(R.id.share_info_layout);
        this.kEx = (LinearLayout) findViewById(R.id.game_share_content);
        this.kon = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.ajU = (TextView) findViewById(R.id.game_desc);
        this.kEt = (HeadImageView) findViewById(R.id.game_img);
        this.kEt.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.kEt.setAutoChangeStyle(false);
        this.kEu = (Button) findViewById(R.id.accept_invite_button);
        this.kEv = (TbImageView) findViewById(R.id.tail_icon);
        this.kEv.setDefaultResource(R.drawable.tb_launcher_icon);
        this.kEv.setAutoChangeStyle(false);
        this.kEy = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.kEm = shareFromGameCenterMsgData;
            sV(z);
        }
    }

    private void sV(boolean z) {
        if (z) {
            this.kEw.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0111));
            this.ajU.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0111));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0105));
            this.ajU.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0106));
            this.kEw.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.getDimens(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.getDimens(getContext(), R.dimen.ds48);
            this.kon.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.kEm.getTitle());
        this.kEt.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.kEt.setAutoChangeStyle(false);
        this.kEt.startLoad(this.kEm.getImageUrl(), 10, false);
        this.ajU.setText(this.kEm.getContent());
        this.kEu.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0105));
        this.kEu.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.kEm.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds60));
            int dimens = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(dimens, l.getDimens(getContext(), R.dimen.ds18), dimens, dimens);
            this.kEu.setLayoutParams(layoutParams2);
            this.kEu.setVisibility(0);
            this.kEu.setText(this.kEm.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int dimens2 = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(dimens2, l.getDimens(getContext(), R.dimen.ds20), dimens2, dimens2);
            this.kEu.setVisibility(8);
            this.kEx.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.kEm.getShareSource())) {
            this.kon.setVisibility(8);
        }
        this.kEy.setText(this.kEm.getShareSource());
        this.kEv.setDefaultResource(R.drawable.tb_launcher_icon);
        this.kEv.setAutoChangeStyle(false);
        this.kEv.startLoad(this.kEm.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.TY(this.kEm.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.kon;
    }

    public LinearLayout getContentBody() {
        return this.kEw;
    }

    public ImageView getTiebaIcon() {
        return this.kEv;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.kEv = tbImageView;
    }
}
