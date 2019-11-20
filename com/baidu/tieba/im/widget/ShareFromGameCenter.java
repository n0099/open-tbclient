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
    private TextView aan;
    private LinearLayout gCd;
    private ShareFromGameCenterMsgData gQY;
    private HeadImageView gRf;
    private Button gRg;
    private TbImageView gRh;
    private LinearLayout gRi;
    private LinearLayout gRj;
    private TextView gRk;
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
        this.gRi = (LinearLayout) findViewById(R.id.share_info_layout);
        this.gRj = (LinearLayout) findViewById(R.id.game_share_content);
        this.gCd = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.aan = (TextView) findViewById(R.id.game_desc);
        this.gRf = (HeadImageView) findViewById(R.id.game_img);
        this.gRf.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.gRf.setAutoChangeStyle(false);
        this.gRg = (Button) findViewById(R.id.accept_invite_button);
        this.gRh = (TbImageView) findViewById(R.id.tail_icon);
        this.gRh.setDefaultResource(R.drawable.icon);
        this.gRh.setAutoChangeStyle(false);
        this.gRk = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.gQY = shareFromGameCenterMsgData;
            mu(z);
        }
    }

    private void mu(boolean z) {
        if (z) {
            this.gRi.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
            this.aan.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
            this.aan.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
            this.gRi.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.getDimens(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.getDimens(getContext(), R.dimen.ds48);
            this.gCd.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.gQY.getTitle());
        this.gRf.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.gRf.setAutoChangeStyle(false);
        this.gRf.startLoad(this.gQY.getImageUrl(), 10, false);
        this.aan.setText(this.gQY.getContent());
        this.gRg.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
        this.gRg.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.gQY.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds60));
            int dimens = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(dimens, l.getDimens(getContext(), R.dimen.ds18), dimens, dimens);
            this.gRg.setLayoutParams(layoutParams2);
            this.gRg.setVisibility(0);
            this.gRg.setText(this.gQY.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int dimens2 = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(dimens2, l.getDimens(getContext(), R.dimen.ds20), dimens2, dimens2);
            this.gRg.setVisibility(8);
            this.gRj.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.gQY.getShareSource())) {
            this.gCd.setVisibility(8);
        }
        this.gRk.setText(this.gQY.getShareSource());
        this.gRh.setDefaultResource(R.drawable.icon);
        this.gRh.setAutoChangeStyle(false);
        this.gRh.startLoad(this.gQY.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.DZ(this.gQY.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.gCd;
    }

    public LinearLayout getContentBody() {
        return this.gRi;
    }

    public ImageView getTiebaIcon() {
        return this.gRh;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.gRh = tbImageView;
    }
}
