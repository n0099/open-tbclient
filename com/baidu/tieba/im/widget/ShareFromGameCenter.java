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
    private TextView akM;
    private LinearLayout kGL;
    private ShareFromGameCenterMsgData kPn;
    private HeadImageView kPu;
    private Button kPv;
    private TbImageView kPw;
    private LinearLayout kPx;
    private LinearLayout kPy;
    private TextView kPz;
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
        this.kPx = (LinearLayout) findViewById(R.id.share_info_layout);
        this.kPy = (LinearLayout) findViewById(R.id.game_share_content);
        this.kGL = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.akM = (TextView) findViewById(R.id.game_desc);
        this.kPu = (HeadImageView) findViewById(R.id.game_img);
        this.kPu.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.kPu.setAutoChangeStyle(false);
        this.kPv = (Button) findViewById(R.id.accept_invite_button);
        this.kPw = (TbImageView) findViewById(R.id.tail_icon);
        this.kPw.setDefaultResource(R.drawable.tb_launcher_icon);
        this.kPw.setAutoChangeStyle(false);
        this.kPz = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.kPn = shareFromGameCenterMsgData;
            tf(z);
        }
    }

    private void tf(boolean z) {
        if (z) {
            this.kPx.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0111));
            this.akM.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0111));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0105));
            this.akM.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0106));
            this.kPx.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.getDimens(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.getDimens(getContext(), R.dimen.ds48);
            this.kGL.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.kPn.getTitle());
        this.kPu.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.kPu.setAutoChangeStyle(false);
        this.kPu.startLoad(this.kPn.getImageUrl(), 10, false);
        this.akM.setText(this.kPn.getContent());
        this.kPv.setTextColor(this.mContext.getResources().getColor(R.color.CAM_X0105));
        this.kPv.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.kPn.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds60));
            int dimens = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(dimens, l.getDimens(getContext(), R.dimen.ds18), dimens, dimens);
            this.kPv.setLayoutParams(layoutParams2);
            this.kPv.setVisibility(0);
            this.kPv.setText(this.kPn.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int dimens2 = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(dimens2, l.getDimens(getContext(), R.dimen.ds20), dimens2, dimens2);
            this.kPv.setVisibility(8);
            this.kPy.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.kPn.getShareSource())) {
            this.kGL.setVisibility(8);
        }
        this.kPz.setText(this.kPn.getShareSource());
        this.kPw.setDefaultResource(R.drawable.tb_launcher_icon);
        this.kPw.setAutoChangeStyle(false);
        this.kPw.startLoad(this.kPn.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.TQ(this.kPn.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.kGL;
    }

    public LinearLayout getContentBody() {
        return this.kPx;
    }

    public ImageView getTiebaIcon() {
        return this.kPw;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.kPw = tbImageView;
    }
}
