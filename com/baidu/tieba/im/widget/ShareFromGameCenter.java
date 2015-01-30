package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.k;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private LinearLayout aVT;
    private TextView awk;
    private ShareFromGameCenterMsgData bqI;
    private HeadImageView bqJ;
    private Button bqK;
    private TbImageView bqL;
    private LinearLayout bqM;
    private LinearLayout bqN;
    private TextView bqO;
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
        com.baidu.adp.lib.g.b.ei().inflate(getContext(), x.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.bqM = (LinearLayout) findViewById(w.share_info_layout);
        this.bqN = (LinearLayout) findViewById(w.game_share_content);
        this.aVT = (LinearLayout) findViewById(w.small_tail);
        this.mTitle = (TextView) findViewById(w.game_title);
        this.awk = (TextView) findViewById(w.game_desc);
        this.bqJ = (HeadImageView) findViewById(w.game_img);
        this.bqJ.setDefaultResource(v.pic_avatar_ba_140);
        this.bqJ.setAutoChangeStyle(false);
        this.bqK = (Button) findViewById(w.accept_invite_button);
        this.bqL = (TbImageView) findViewById(w.tail_icon);
        this.bqL.setDefaultResource(v.icon);
        this.bqL.setAutoChangeStyle(false);
        this.bqO = (TextView) findViewById(w.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.bqI = shareFromGameCenterMsgData;
            dm(z);
        }
    }

    private void dm(boolean z) {
        if (z) {
            this.bqM.setBackgroundDrawable(this.mContext.getResources().getDrawable(v.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(t.cp_cont_g));
            this.awk.setTextColor(this.mContext.getResources().getColor(t.cp_cont_g));
            this.bqK.setTextColor(this.mContext.getResources().getColor(t.cp_cont_b));
            this.bqK.setBackgroundResource(v.btn_appdownload);
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(t.cp_cont_b));
            this.awk.setTextColor(this.mContext.getResources().getColor(t.cp_cont_f));
            this.bqK.setBackgroundResource(v.frs_praise_btn_bg);
            this.bqK.setTextColor(this.mContext.getResources().getColor(t.cp_cont_i));
            this.bqM.setBackgroundDrawable(this.mContext.getResources().getDrawable(v.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.d(getContext(), u.ds14), 0, 0, 0);
            layoutParams.height = l.d(getContext(), u.ds48);
            this.aVT.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.bqI.getTitle());
        this.bqJ.setDefaultResource(v.pic_avatar_ba_140);
        this.bqJ.setAutoChangeStyle(false);
        this.bqJ.d(this.bqI.getImageUrl(), 10, false);
        this.awk.setText(this.bqI.getContent());
        if (!TextUtils.isEmpty(this.bqI.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.d(getContext(), u.ds60));
            int d = l.d(getContext(), u.ds30);
            layoutParams2.setMargins(d, l.d(getContext(), u.ds18), d, d);
            this.bqK.setLayoutParams(layoutParams2);
            this.bqK.setVisibility(0);
            this.bqK.setText(this.bqI.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int d2 = l.d(getContext(), u.ds30);
            layoutParams3.setMargins(d2, l.d(getContext(), u.ds20), d2, d2);
            this.bqK.setVisibility(8);
            this.bqN.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.bqI.getShareSource())) {
            this.aVT.setVisibility(8);
        }
        this.bqO.setText(this.bqI.getShareSource());
        this.bqL.setDefaultResource(v.icon);
        this.bqL.setAutoChangeStyle(false);
        this.bqL.d(this.bqI.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", k.iu(this.bqI.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.aVT;
    }

    public LinearLayout getContentBody() {
        return this.bqM;
    }

    public ImageView getTiebaIcon() {
        return this.bqL;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.bqL = tbImageView;
    }
}
