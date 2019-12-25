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
    private TextView ais;
    private ShareFromGameCenterMsgData hFc;
    private HeadImageView hFj;
    private Button hFk;
    private TbImageView hFl;
    private LinearLayout hFm;
    private LinearLayout hFn;
    private TextView hFo;
    private LinearLayout hqi;
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
        this.hFm = (LinearLayout) findViewById(R.id.share_info_layout);
        this.hFn = (LinearLayout) findViewById(R.id.game_share_content);
        this.hqi = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.ais = (TextView) findViewById(R.id.game_desc);
        this.hFj = (HeadImageView) findViewById(R.id.game_img);
        this.hFj.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.hFj.setAutoChangeStyle(false);
        this.hFk = (Button) findViewById(R.id.accept_invite_button);
        this.hFl = (TbImageView) findViewById(R.id.tail_icon);
        this.hFl.setDefaultResource(R.drawable.tb_launcher_icon);
        this.hFl.setAutoChangeStyle(false);
        this.hFo = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.hFc = shareFromGameCenterMsgData;
            nH(z);
        }
    }

    private void nH(boolean z) {
        if (z) {
            this.hFm.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
            this.ais.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
            this.ais.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
            this.hFm.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.getDimens(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.getDimens(getContext(), R.dimen.ds48);
            this.hqi.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.hFc.getTitle());
        this.hFj.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.hFj.setAutoChangeStyle(false);
        this.hFj.startLoad(this.hFc.getImageUrl(), 10, false);
        this.ais.setText(this.hFc.getContent());
        this.hFk.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
        this.hFk.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.hFc.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds60));
            int dimens = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(dimens, l.getDimens(getContext(), R.dimen.ds18), dimens, dimens);
            this.hFk.setLayoutParams(layoutParams2);
            this.hFk.setVisibility(0);
            this.hFk.setText(this.hFc.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int dimens2 = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(dimens2, l.getDimens(getContext(), R.dimen.ds20), dimens2, dimens2);
            this.hFk.setVisibility(8);
            this.hFn.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.hFc.getShareSource())) {
            this.hqi.setVisibility(8);
        }
        this.hFo.setText(this.hFc.getShareSource());
        this.hFl.setDefaultResource(R.drawable.tb_launcher_icon);
        this.hFl.setAutoChangeStyle(false);
        this.hFl.startLoad(this.hFc.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.IO(this.hFc.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.hqi;
    }

    public LinearLayout getContentBody() {
        return this.hFm;
    }

    public ImageView getTiebaIcon() {
        return this.hFl;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.hFl = tbImageView;
    }
}
