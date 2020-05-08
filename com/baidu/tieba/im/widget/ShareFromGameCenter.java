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
    private TextView aDO;
    private LinearLayout ihr;
    private TextView iwA;
    private ShareFromGameCenterMsgData iwo;
    private HeadImageView iwv;
    private Button iww;
    private TbImageView iwx;
    private LinearLayout iwy;
    private LinearLayout iwz;
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
        this.iwy = (LinearLayout) findViewById(R.id.share_info_layout);
        this.iwz = (LinearLayout) findViewById(R.id.game_share_content);
        this.ihr = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.aDO = (TextView) findViewById(R.id.game_desc);
        this.iwv = (HeadImageView) findViewById(R.id.game_img);
        this.iwv.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.iwv.setAutoChangeStyle(false);
        this.iww = (Button) findViewById(R.id.accept_invite_button);
        this.iwx = (TbImageView) findViewById(R.id.tail_icon);
        this.iwx.setDefaultResource(R.drawable.tb_launcher_icon);
        this.iwx.setAutoChangeStyle(false);
        this.iwA = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.iwo = shareFromGameCenterMsgData;
            pf(z);
        }
    }

    private void pf(boolean z) {
        if (z) {
            this.iwy.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
            this.aDO.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
            this.aDO.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
            this.iwy.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.getDimens(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.getDimens(getContext(), R.dimen.ds48);
            this.ihr.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.iwo.getTitle());
        this.iwv.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.iwv.setAutoChangeStyle(false);
        this.iwv.startLoad(this.iwo.getImageUrl(), 10, false);
        this.aDO.setText(this.iwo.getContent());
        this.iww.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
        this.iww.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.iwo.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds60));
            int dimens = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(dimens, l.getDimens(getContext(), R.dimen.ds18), dimens, dimens);
            this.iww.setLayoutParams(layoutParams2);
            this.iww.setVisibility(0);
            this.iww.setText(this.iwo.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int dimens2 = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(dimens2, l.getDimens(getContext(), R.dimen.ds20), dimens2, dimens2);
            this.iww.setVisibility(8);
            this.iwz.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.iwo.getShareSource())) {
            this.ihr.setVisibility(8);
        }
        this.iwA.setText(this.iwo.getShareSource());
        this.iwx.setDefaultResource(R.drawable.tb_launcher_icon);
        this.iwx.setAutoChangeStyle(false);
        this.iwx.startLoad(this.iwo.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.KY(this.iwo.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.ihr;
    }

    public LinearLayout getContentBody() {
        return this.iwy;
    }

    public ImageView getTiebaIcon() {
        return this.iwx;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.iwx = tbImageView;
    }
}
