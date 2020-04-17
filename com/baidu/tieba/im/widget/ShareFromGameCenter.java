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
    private TextView aDI;
    private LinearLayout ihl;
    private ShareFromGameCenterMsgData iwi;
    private HeadImageView iwp;
    private Button iwq;
    private TbImageView iwr;
    private LinearLayout iws;
    private LinearLayout iwt;
    private TextView iwu;
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
        this.iws = (LinearLayout) findViewById(R.id.share_info_layout);
        this.iwt = (LinearLayout) findViewById(R.id.game_share_content);
        this.ihl = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.aDI = (TextView) findViewById(R.id.game_desc);
        this.iwp = (HeadImageView) findViewById(R.id.game_img);
        this.iwp.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.iwp.setAutoChangeStyle(false);
        this.iwq = (Button) findViewById(R.id.accept_invite_button);
        this.iwr = (TbImageView) findViewById(R.id.tail_icon);
        this.iwr.setDefaultResource(R.drawable.tb_launcher_icon);
        this.iwr.setAutoChangeStyle(false);
        this.iwu = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.iwi = shareFromGameCenterMsgData;
            pf(z);
        }
    }

    private void pf(boolean z) {
        if (z) {
            this.iws.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
            this.aDI.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
            this.aDI.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
            this.iws.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.getDimens(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.getDimens(getContext(), R.dimen.ds48);
            this.ihl.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.iwi.getTitle());
        this.iwp.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.iwp.setAutoChangeStyle(false);
        this.iwp.startLoad(this.iwi.getImageUrl(), 10, false);
        this.aDI.setText(this.iwi.getContent());
        this.iwq.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
        this.iwq.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.iwi.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds60));
            int dimens = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(dimens, l.getDimens(getContext(), R.dimen.ds18), dimens, dimens);
            this.iwq.setLayoutParams(layoutParams2);
            this.iwq.setVisibility(0);
            this.iwq.setText(this.iwi.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int dimens2 = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(dimens2, l.getDimens(getContext(), R.dimen.ds20), dimens2, dimens2);
            this.iwq.setVisibility(8);
            this.iwt.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.iwi.getShareSource())) {
            this.ihl.setVisibility(8);
        }
        this.iwu.setText(this.iwi.getShareSource());
        this.iwr.setDefaultResource(R.drawable.tb_launcher_icon);
        this.iwr.setAutoChangeStyle(false);
        this.iwr.startLoad(this.iwi.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.KV(this.iwi.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.ihl;
    }

    public LinearLayout getContentBody() {
        return this.iws;
    }

    public ImageView getTiebaIcon() {
        return this.iwr;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.iwr = tbImageView;
    }
}
