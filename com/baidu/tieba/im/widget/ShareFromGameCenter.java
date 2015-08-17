package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.util.l;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private TextView aPV;
    private TextView aWb;
    private ShareFromGameCenterMsgData bER;
    private HeadImageView bES;
    private Button bET;
    private TbImageView bEU;
    private LinearLayout bEV;
    private LinearLayout bEW;
    private TextView bEX;
    private LinearLayout bqO;
    private Context mContext;

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
        LayoutInflater.from(getContext()).inflate(i.g.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.bEV = (LinearLayout) findViewById(i.f.share_info_layout);
        this.bEW = (LinearLayout) findViewById(i.f.game_share_content);
        this.bqO = (LinearLayout) findViewById(i.f.small_tail);
        this.aPV = (TextView) findViewById(i.f.game_title);
        this.aWb = (TextView) findViewById(i.f.game_desc);
        this.bES = (HeadImageView) findViewById(i.f.game_img);
        this.bES.setDefaultResource(i.e.pic_avatar_ba_140);
        this.bES.setAutoChangeStyle(false);
        this.bET = (Button) findViewById(i.f.accept_invite_button);
        this.bEU = (TbImageView) findViewById(i.f.tail_icon);
        this.bEU.setDefaultResource(i.e.icon);
        this.bEU.setAutoChangeStyle(false);
        this.bEX = (TextView) findViewById(i.f.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.bER = shareFromGameCenterMsgData;
            dl(z);
        }
    }

    private void dl(boolean z) {
        if (z) {
            this.bEV.setBackgroundDrawable(this.mContext.getResources().getDrawable(i.e.selector_msg_text_bubble_me));
            this.aPV.setTextColor(this.mContext.getResources().getColor(i.c.cp_cont_g));
            this.aWb.setTextColor(this.mContext.getResources().getColor(i.c.cp_cont_g));
        } else {
            this.aPV.setTextColor(this.mContext.getResources().getColor(i.c.cp_cont_b));
            this.aWb.setTextColor(this.mContext.getResources().getColor(i.c.cp_cont_f));
            this.bEV.setBackgroundDrawable(this.mContext.getResources().getDrawable(i.e.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(k.d(getContext(), i.d.ds14), 0, 0, 0);
            layoutParams.height = k.d(getContext(), i.d.ds48);
            this.bqO.setLayoutParams(layoutParams);
        }
        this.aPV.setText(this.bER.getTitle());
        this.bES.setDefaultResource(i.e.pic_avatar_ba_140);
        this.bES.setAutoChangeStyle(false);
        this.bES.d(this.bER.getImageUrl(), 10, false);
        this.aWb.setText(this.bER.getContent());
        this.bET.setTextColor(this.mContext.getResources().getColor(i.c.cp_cont_b));
        this.bET.setBackgroundResource(i.e.btn_appdownload);
        if (!TextUtils.isEmpty(this.bER.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, k.d(getContext(), i.d.ds60));
            int d = k.d(getContext(), i.d.ds30);
            layoutParams2.setMargins(d, k.d(getContext(), i.d.ds18), d, d);
            this.bET.setLayoutParams(layoutParams2);
            this.bET.setVisibility(0);
            this.bET.setText(this.bER.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int d2 = k.d(getContext(), i.d.ds30);
            layoutParams3.setMargins(d2, k.d(getContext(), i.d.ds20), d2, d2);
            this.bET.setVisibility(8);
            this.bEW.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.bER.getShareSource())) {
            this.bqO.setVisibility(8);
        }
        this.bEX.setText(this.bER.getShareSource());
        this.bEU.setDefaultResource(i.e.icon);
        this.bEU.setAutoChangeStyle(false);
        this.bEU.d(this.bER.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", l.kC(this.bER.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.bqO;
    }

    public LinearLayout getContentBody() {
        return this.bEV;
    }

    public ImageView getTiebaIcon() {
        return this.bEU;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.bEU = tbImageView;
    }
}
