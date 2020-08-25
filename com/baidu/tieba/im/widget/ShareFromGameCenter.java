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
/* loaded from: classes2.dex */
public class ShareFromGameCenter extends LinearLayout {
    private TextView aia;
    private ShareFromGameCenterMsgData jAf;
    private HeadImageView jAm;
    private Button jAn;
    private TbImageView jAo;
    private LinearLayout jAp;
    private LinearLayout jAq;
    private TextView jAr;
    private LinearLayout jjW;
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
        this.jAp = (LinearLayout) findViewById(R.id.share_info_layout);
        this.jAq = (LinearLayout) findViewById(R.id.game_share_content);
        this.jjW = (LinearLayout) findViewById(R.id.small_tail);
        this.mTitle = (TextView) findViewById(R.id.game_title);
        this.aia = (TextView) findViewById(R.id.game_desc);
        this.jAm = (HeadImageView) findViewById(R.id.game_img);
        this.jAm.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.jAm.setAutoChangeStyle(false);
        this.jAn = (Button) findViewById(R.id.accept_invite_button);
        this.jAo = (TbImageView) findViewById(R.id.tail_icon);
        this.jAo.setDefaultResource(R.drawable.tb_launcher_icon);
        this.jAo.setAutoChangeStyle(false);
        this.jAr = (TextView) findViewById(R.id.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.jAf = shareFromGameCenterMsgData;
            qZ(z);
        }
    }

    private void qZ(boolean z) {
        if (z) {
            this.jAp.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
            this.aia.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
            this.aia.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_f));
            this.jAp.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.getDimens(getContext(), R.dimen.ds14), 0, 0, 0);
            layoutParams.height = l.getDimens(getContext(), R.dimen.ds48);
            this.jjW.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.jAf.getTitle());
        this.jAm.setDefaultResource(R.drawable.pic_avatar_ba_140);
        this.jAm.setAutoChangeStyle(false);
        this.jAm.startLoad(this.jAf.getImageUrl(), 10, false);
        this.aia.setText(this.jAf.getContent());
        this.jAn.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_b));
        this.jAn.setBackgroundResource(R.drawable.btn_appdownload);
        if (!TextUtils.isEmpty(this.jAf.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds60));
            int dimens = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams2.setMargins(dimens, l.getDimens(getContext(), R.dimen.ds18), dimens, dimens);
            this.jAn.setLayoutParams(layoutParams2);
            this.jAn.setVisibility(0);
            this.jAn.setText(this.jAf.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int dimens2 = l.getDimens(getContext(), R.dimen.ds30);
            layoutParams3.setMargins(dimens2, l.getDimens(getContext(), R.dimen.ds20), dimens2, dimens2);
            this.jAn.setVisibility(8);
            this.jAq.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.jAf.getShareSource())) {
            this.jjW.setVisibility(8);
        }
        this.jAr.setText(this.jAf.getShareSource());
        this.jAo.setDefaultResource(R.drawable.tb_launcher_icon);
        this.jAo.setAutoChangeStyle(false);
        this.jAo.startLoad(this.jAf.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.QU(this.jAf.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.jjW;
    }

    public LinearLayout getContentBody() {
        return this.jAp;
    }

    public ImageView getTiebaIcon() {
        return this.jAo;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.jAo = tbImageView;
    }
}
