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
    private LinearLayout aVS;
    private TextView awh;
    private ShareFromGameCenterMsgData bqH;
    private HeadImageView bqI;
    private Button bqJ;
    private TbImageView bqK;
    private LinearLayout bqL;
    private LinearLayout bqM;
    private TextView bqN;
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
        this.bqL = (LinearLayout) findViewById(w.share_info_layout);
        this.bqM = (LinearLayout) findViewById(w.game_share_content);
        this.aVS = (LinearLayout) findViewById(w.small_tail);
        this.mTitle = (TextView) findViewById(w.game_title);
        this.awh = (TextView) findViewById(w.game_desc);
        this.bqI = (HeadImageView) findViewById(w.game_img);
        this.bqI.setDefaultResource(v.pic_avatar_ba_140);
        this.bqI.setAutoChangeStyle(false);
        this.bqJ = (Button) findViewById(w.accept_invite_button);
        this.bqK = (TbImageView) findViewById(w.tail_icon);
        this.bqK.setDefaultResource(v.icon);
        this.bqK.setAutoChangeStyle(false);
        this.bqN = (TextView) findViewById(w.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.bqH = shareFromGameCenterMsgData;
            dm(z);
        }
    }

    private void dm(boolean z) {
        if (z) {
            this.bqL.setBackgroundDrawable(this.mContext.getResources().getDrawable(v.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(t.cp_cont_g));
            this.awh.setTextColor(this.mContext.getResources().getColor(t.cp_cont_g));
            this.bqJ.setTextColor(this.mContext.getResources().getColor(t.cp_cont_b));
            this.bqJ.setBackgroundResource(v.btn_appdownload);
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(t.cp_cont_b));
            this.awh.setTextColor(this.mContext.getResources().getColor(t.cp_cont_f));
            this.bqJ.setBackgroundResource(v.frs_praise_btn_bg);
            this.bqJ.setTextColor(this.mContext.getResources().getColor(t.cp_cont_i));
            this.bqL.setBackgroundDrawable(this.mContext.getResources().getDrawable(v.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.d(getContext(), u.ds14), 0, 0, 0);
            layoutParams.height = l.d(getContext(), u.ds48);
            this.aVS.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.bqH.getTitle());
        this.bqI.setDefaultResource(v.pic_avatar_ba_140);
        this.bqI.setAutoChangeStyle(false);
        this.bqI.d(this.bqH.getImageUrl(), 10, false);
        this.awh.setText(this.bqH.getContent());
        if (!TextUtils.isEmpty(this.bqH.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.d(getContext(), u.ds60));
            int d = l.d(getContext(), u.ds30);
            layoutParams2.setMargins(d, l.d(getContext(), u.ds18), d, d);
            this.bqJ.setLayoutParams(layoutParams2);
            this.bqJ.setVisibility(0);
            this.bqJ.setText(this.bqH.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int d2 = l.d(getContext(), u.ds30);
            layoutParams3.setMargins(d2, l.d(getContext(), u.ds20), d2, d2);
            this.bqJ.setVisibility(8);
            this.bqM.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.bqH.getShareSource())) {
            this.aVS.setVisibility(8);
        }
        this.bqN.setText(this.bqH.getShareSource());
        this.bqK.setDefaultResource(v.icon);
        this.bqK.setAutoChangeStyle(false);
        this.bqK.d(this.bqH.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", k.is(this.bqH.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.aVS;
    }

    public LinearLayout getContentBody() {
        return this.bqL;
    }

    public ImageView getTiebaIcon() {
        return this.bqK;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.bqK = tbImageView;
    }
}
