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
    private TextView aiV;
    private LinearLayout kaJ;
    private ShareFromGameCenterMsgData kqQ;
    private HeadImageView kqX;
    private Button kqY;
    private TbImageView kqZ;
    private LinearLayout kra;
    private LinearLayout krb;
    private TextView krc;
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
        this.kra = (LinearLayout) findViewById(R.id.share_info_layout);
        this.krb = (LinearLayout) findViewById(R.id.game_share_content);
        this.kaJ = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.aiV = (TextView) findViewById(R.id.game_desc);
        this.kqX = (HeadImageView) findViewById(R.id.game_img);
        this.kqX.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.kqX.setAutoChangeStyle(false);
        this.kqY = (Button) findViewById(R.id.accept_invite_button);
        this.kqZ = (TbImageView) findViewById(R.id.tail_icon);
        this.kqZ.setDefaultResource(R.drawable.tb_launcher_icon);
        this.kqZ.setAutoChangeStyle(false);
        this.krc = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.kqQ = shareFromGameCenterMsgData;
            st(z);
        }
    }

    private void st(boolean z) {
        if (z) {
            this.kra.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0111));
            this.aiV.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0111));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0105));
            this.aiV.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0106));
            this.kra.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.getDimens(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.getDimens(getContext(), R.dimen.ds48);
            this.kaJ.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.kqQ.getTitle());
        this.kqX.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.kqX.setAutoChangeStyle(false);
        this.kqX.startLoad(this.kqQ.getImageUrl(), 10, false);
        this.aiV.setText(this.kqQ.getContent());
        this.kqY.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0105));
        this.kqY.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.kqQ.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds60));
            int dimens = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(dimens, l.getDimens(getContext(), R.dimen.ds18), dimens, dimens);
            this.kqY.setLayoutParams(layoutParams2);
            this.kqY.setVisibility(0);
            this.kqY.setText(this.kqQ.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int dimens2 = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(dimens2, l.getDimens(getContext(), R.dimen.ds20), dimens2, dimens2);
            this.kqY.setVisibility(8);
            this.krb.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.kqQ.getShareSource())) {
            this.kaJ.setVisibility(8);
        }
        this.krc.setText(this.kqQ.getShareSource());
        this.kqZ.setDefaultResource(R.drawable.tb_launcher_icon);
        this.kqZ.setAutoChangeStyle(false);
        this.kqZ.startLoad(this.kqQ.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.SJ(this.kqQ.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.kaJ;
    }

    public LinearLayout getContentBody() {
        return this.kra;
    }

    public ImageView getTiebaIcon() {
        return this.kqZ;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.kqZ = tbImageView;
    }
}
