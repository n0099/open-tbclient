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
    private TextView agR;
    private LinearLayout iUV;
    private ShareFromGameCenterMsgData jle;
    private HeadImageView jll;
    private Button jlm;
    private TbImageView jln;
    private LinearLayout jlo;
    private LinearLayout jlp;
    private TextView jlq;
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
        this.jlo = (LinearLayout) findViewById(R.id.share_info_layout);
        this.jlp = (LinearLayout) findViewById(R.id.game_share_content);
        this.iUV = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.agR = (TextView) findViewById(R.id.game_desc);
        this.jll = (HeadImageView) findViewById(R.id.game_img);
        this.jll.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.jll.setAutoChangeStyle(false);
        this.jlm = (Button) findViewById(R.id.accept_invite_button);
        this.jln = (TbImageView) findViewById(R.id.tail_icon);
        this.jln.setDefaultResource(R.drawable.tb_launcher_icon);
        this.jln.setAutoChangeStyle(false);
        this.jlq = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.jle = shareFromGameCenterMsgData;
            qt(z);
        }
    }

    private void qt(boolean z) {
        if (z) {
            this.jlo.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
            this.agR.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
            this.agR.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
            this.jlo.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.getDimens(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.getDimens(getContext(), R.dimen.ds48);
            this.iUV.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.jle.getTitle());
        this.jll.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.jll.setAutoChangeStyle(false);
        this.jll.startLoad(this.jle.getImageUrl(), 10, false);
        this.agR.setText(this.jle.getContent());
        this.jlm.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
        this.jlm.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.jle.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds60));
            int dimens = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(dimens, l.getDimens(getContext(), R.dimen.ds18), dimens, dimens);
            this.jlm.setLayoutParams(layoutParams2);
            this.jlm.setVisibility(0);
            this.jlm.setText(this.jle.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int dimens2 = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(dimens2, l.getDimens(getContext(), R.dimen.ds20), dimens2, dimens2);
            this.jlm.setVisibility(8);
            this.jlp.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.jle.getShareSource())) {
            this.iUV.setVisibility(8);
        }
        this.jlq.setText(this.jle.getShareSource());
        this.jln.setDefaultResource(R.drawable.tb_launcher_icon);
        this.jln.setAutoChangeStyle(false);
        this.jln.startLoad(this.jle.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.NW(this.jle.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.iUV;
    }

    public LinearLayout getContentBody() {
        return this.jlo;
    }

    public ImageView getTiebaIcon() {
        return this.jln;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.jln = tbImageView;
    }
}
