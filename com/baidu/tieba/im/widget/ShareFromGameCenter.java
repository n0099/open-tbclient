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
    private LinearLayout iUX;
    private ShareFromGameCenterMsgData jlg;
    private HeadImageView jln;
    private Button jlo;
    private TbImageView jlp;
    private LinearLayout jlq;
    private LinearLayout jlr;
    private TextView jls;
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
        this.jlq = (LinearLayout) findViewById(R.id.share_info_layout);
        this.jlr = (LinearLayout) findViewById(R.id.game_share_content);
        this.iUX = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.agR = (TextView) findViewById(R.id.game_desc);
        this.jln = (HeadImageView) findViewById(R.id.game_img);
        this.jln.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.jln.setAutoChangeStyle(false);
        this.jlo = (Button) findViewById(R.id.accept_invite_button);
        this.jlp = (TbImageView) findViewById(R.id.tail_icon);
        this.jlp.setDefaultResource(R.drawable.tb_launcher_icon);
        this.jlp.setAutoChangeStyle(false);
        this.jls = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.jlg = shareFromGameCenterMsgData;
            qt(z);
        }
    }

    private void qt(boolean z) {
        if (z) {
            this.jlq.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
            this.agR.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
            this.agR.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
            this.jlq.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.getDimens(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.getDimens(getContext(), R.dimen.ds48);
            this.iUX.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.jlg.getTitle());
        this.jln.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.jln.setAutoChangeStyle(false);
        this.jln.startLoad(this.jlg.getImageUrl(), 10, false);
        this.agR.setText(this.jlg.getContent());
        this.jlo.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
        this.jlo.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.jlg.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds60));
            int dimens = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(dimens, l.getDimens(getContext(), R.dimen.ds18), dimens, dimens);
            this.jlo.setLayoutParams(layoutParams2);
            this.jlo.setVisibility(0);
            this.jlo.setText(this.jlg.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int dimens2 = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(dimens2, l.getDimens(getContext(), R.dimen.ds20), dimens2, dimens2);
            this.jlo.setVisibility(8);
            this.jlr.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.jlg.getShareSource())) {
            this.iUX.setVisibility(8);
        }
        this.jls.setText(this.jlg.getShareSource());
        this.jlp.setDefaultResource(R.drawable.tb_launcher_icon);
        this.jlp.setAutoChangeStyle(false);
        this.jlp.startLoad(this.jlg.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.NW(this.jlg.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.iUX;
    }

    public LinearLayout getContentBody() {
        return this.jlq;
    }

    public ImageView getTiebaIcon() {
        return this.jlp;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.jlp = tbImageView;
    }
}
