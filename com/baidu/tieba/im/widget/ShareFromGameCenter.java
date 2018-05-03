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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private LinearLayout dTY;
    private ShareFromGameCenterMsgData eiV;
    private TextView ejc;
    private HeadImageView ejd;
    private Button eje;
    private TbImageView ejf;
    private LinearLayout ejg;
    private LinearLayout ejh;
    private TextView eji;
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
        LayoutInflater.from(getContext()).inflate(d.i.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.ejg = (LinearLayout) findViewById(d.g.share_info_layout);
        this.ejh = (LinearLayout) findViewById(d.g.game_share_content);
        this.dTY = (LinearLayout) findViewById(d.g.small_tail);
        this.mTitle = (TextView) findViewById(d.g.game_title);
        this.ejc = (TextView) findViewById(d.g.game_desc);
        this.ejd = (HeadImageView) findViewById(d.g.game_img);
        this.ejd.setDefaultResource(d.f.pic_avatar_ba_140);
        this.ejd.setAutoChangeStyle(false);
        this.eje = (Button) findViewById(d.g.accept_invite_button);
        this.ejf = (TbImageView) findViewById(d.g.tail_icon);
        this.ejf.setDefaultResource(d.f.icon);
        this.ejf.setAutoChangeStyle(false);
        this.eji = (TextView) findViewById(d.g.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.eiV = shareFromGameCenterMsgData;
            hA(z);
        }
    }

    private void hA(boolean z) {
        if (z) {
            this.ejg.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0126d.cp_cont_g));
            this.ejc.setTextColor(this.mContext.getResources().getColor(d.C0126d.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0126d.cp_cont_b));
            this.ejc.setTextColor(this.mContext.getResources().getColor(d.C0126d.cp_cont_f));
            this.ejg.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.e(getContext(), d.e.ds14), 0, 0, 0);
            layoutParams.height = l.e(getContext(), d.e.ds48);
            this.dTY.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.eiV.getTitle());
        this.ejd.setDefaultResource(d.f.pic_avatar_ba_140);
        this.ejd.setAutoChangeStyle(false);
        this.ejd.startLoad(this.eiV.getImageUrl(), 10, false);
        this.ejc.setText(this.eiV.getContent());
        this.eje.setTextColor(this.mContext.getResources().getColor(d.C0126d.cp_cont_b));
        this.eje.setBackgroundResource(d.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.eiV.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.e(getContext(), d.e.ds60));
            int e = l.e(getContext(), d.e.ds30);
            layoutParams2.setMargins(e, l.e(getContext(), d.e.ds18), e, e);
            this.eje.setLayoutParams(layoutParams2);
            this.eje.setVisibility(0);
            this.eje.setText(this.eiV.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int e2 = l.e(getContext(), d.e.ds30);
            layoutParams3.setMargins(e2, l.e(getContext(), d.e.ds20), e2, e2);
            this.eje.setVisibility(8);
            this.ejh.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.eiV.getShareSource())) {
            this.dTY.setVisibility(8);
        }
        this.eji.setText(this.eiV.getShareSource());
        this.ejf.setDefaultResource(d.f.icon);
        this.ejf.setAutoChangeStyle(false);
        this.ejf.startLoad(this.eiV.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.ta(this.eiV.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.dTY;
    }

    public LinearLayout getContentBody() {
        return this.ejg;
    }

    public ImageView getTiebaIcon() {
        return this.ejf;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.ejf = tbImageView;
    }
}
