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
    private TextView aic;
    private ShareFromGameCenterMsgData jAl;
    private HeadImageView jAs;
    private Button jAt;
    private TbImageView jAu;
    private LinearLayout jAv;
    private LinearLayout jAw;
    private TextView jAx;
    private LinearLayout jkc;
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
        this.jAv = (LinearLayout) findViewById(R.id.share_info_layout);
        this.jAw = (LinearLayout) findViewById(R.id.game_share_content);
        this.jkc = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.aic = (TextView) findViewById(R.id.game_desc);
        this.jAs = (HeadImageView) findViewById(R.id.game_img);
        this.jAs.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.jAs.setAutoChangeStyle(false);
        this.jAt = (Button) findViewById(R.id.accept_invite_button);
        this.jAu = (TbImageView) findViewById(R.id.tail_icon);
        this.jAu.setDefaultResource(R.drawable.tb_launcher_icon);
        this.jAu.setAutoChangeStyle(false);
        this.jAx = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.jAl = shareFromGameCenterMsgData;
            rb(z);
        }
    }

    private void rb(boolean z) {
        if (z) {
            this.jAv.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
            this.aic.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
            this.aic.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
            this.jAv.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.getDimens(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.getDimens(getContext(), R.dimen.ds48);
            this.jkc.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.jAl.getTitle());
        this.jAs.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.jAs.setAutoChangeStyle(false);
        this.jAs.startLoad(this.jAl.getImageUrl(), 10, false);
        this.aic.setText(this.jAl.getContent());
        this.jAt.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
        this.jAt.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.jAl.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds60));
            int dimens = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(dimens, l.getDimens(getContext(), R.dimen.ds18), dimens, dimens);
            this.jAt.setLayoutParams(layoutParams2);
            this.jAt.setVisibility(0);
            this.jAt.setText(this.jAl.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int dimens2 = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(dimens2, l.getDimens(getContext(), R.dimen.ds20), dimens2, dimens2);
            this.jAt.setVisibility(8);
            this.jAw.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.jAl.getShareSource())) {
            this.jkc.setVisibility(8);
        }
        this.jAx.setText(this.jAl.getShareSource());
        this.jAu.setDefaultResource(R.drawable.tb_launcher_icon);
        this.jAu.setAutoChangeStyle(false);
        this.jAu.startLoad(this.jAl.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.QU(this.jAl.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.jkc;
    }

    public LinearLayout getContentBody() {
        return this.jAv;
    }

    public ImageView getTiebaIcon() {
        return this.jAu;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.jAu = tbImageView;
    }
}
