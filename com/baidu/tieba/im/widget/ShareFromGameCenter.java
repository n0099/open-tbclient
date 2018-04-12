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
    private LinearLayout dUb;
    private ShareFromGameCenterMsgData eiY;
    private TextView ejf;
    private HeadImageView ejg;
    private Button ejh;
    private TbImageView eji;
    private LinearLayout ejj;
    private LinearLayout ejk;
    private TextView ejl;
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
        this.ejj = (LinearLayout) findViewById(d.g.share_info_layout);
        this.ejk = (LinearLayout) findViewById(d.g.game_share_content);
        this.dUb = (LinearLayout) findViewById(d.g.small_tail);
        this.mTitle = (TextView) findViewById(d.g.game_title);
        this.ejf = (TextView) findViewById(d.g.game_desc);
        this.ejg = (HeadImageView) findViewById(d.g.game_img);
        this.ejg.setDefaultResource(d.f.pic_avatar_ba_140);
        this.ejg.setAutoChangeStyle(false);
        this.ejh = (Button) findViewById(d.g.accept_invite_button);
        this.eji = (TbImageView) findViewById(d.g.tail_icon);
        this.eji.setDefaultResource(d.f.icon);
        this.eji.setAutoChangeStyle(false);
        this.ejl = (TextView) findViewById(d.g.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.eiY = shareFromGameCenterMsgData;
            hA(z);
        }
    }

    private void hA(boolean z) {
        if (z) {
            this.ejj.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0126d.cp_cont_g));
            this.ejf.setTextColor(this.mContext.getResources().getColor(d.C0126d.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0126d.cp_cont_b));
            this.ejf.setTextColor(this.mContext.getResources().getColor(d.C0126d.cp_cont_f));
            this.ejj.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.e(getContext(), d.e.ds14), 0, 0, 0);
            layoutParams.height = l.e(getContext(), d.e.ds48);
            this.dUb.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.eiY.getTitle());
        this.ejg.setDefaultResource(d.f.pic_avatar_ba_140);
        this.ejg.setAutoChangeStyle(false);
        this.ejg.startLoad(this.eiY.getImageUrl(), 10, false);
        this.ejf.setText(this.eiY.getContent());
        this.ejh.setTextColor(this.mContext.getResources().getColor(d.C0126d.cp_cont_b));
        this.ejh.setBackgroundResource(d.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.eiY.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.e(getContext(), d.e.ds60));
            int e = l.e(getContext(), d.e.ds30);
            layoutParams2.setMargins(e, l.e(getContext(), d.e.ds18), e, e);
            this.ejh.setLayoutParams(layoutParams2);
            this.ejh.setVisibility(0);
            this.ejh.setText(this.eiY.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int e2 = l.e(getContext(), d.e.ds30);
            layoutParams3.setMargins(e2, l.e(getContext(), d.e.ds20), e2, e2);
            this.ejh.setVisibility(8);
            this.ejk.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.eiY.getShareSource())) {
            this.dUb.setVisibility(8);
        }
        this.ejl.setText(this.eiY.getShareSource());
        this.eji.setDefaultResource(d.f.icon);
        this.eji.setAutoChangeStyle(false);
        this.eji.startLoad(this.eiY.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.ta(this.eiY.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.dUb;
    }

    public LinearLayout getContentBody() {
        return this.ejj;
    }

    public ImageView getTiebaIcon() {
        return this.eji;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.eji = tbImageView;
    }
}
