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
    private LinearLayout dVf;
    private ShareFromGameCenterMsgData ekc;
    private TextView ekj;
    private HeadImageView ekk;
    private Button ekl;
    private TbImageView ekm;
    private LinearLayout ekn;
    private LinearLayout eko;
    private TextView ekp;
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
        this.ekn = (LinearLayout) findViewById(d.g.share_info_layout);
        this.eko = (LinearLayout) findViewById(d.g.game_share_content);
        this.dVf = (LinearLayout) findViewById(d.g.small_tail);
        this.mTitle = (TextView) findViewById(d.g.game_title);
        this.ekj = (TextView) findViewById(d.g.game_desc);
        this.ekk = (HeadImageView) findViewById(d.g.game_img);
        this.ekk.setDefaultResource(d.f.pic_avatar_ba_140);
        this.ekk.setAutoChangeStyle(false);
        this.ekl = (Button) findViewById(d.g.accept_invite_button);
        this.ekm = (TbImageView) findViewById(d.g.tail_icon);
        this.ekm.setDefaultResource(d.f.icon);
        this.ekm.setAutoChangeStyle(false);
        this.ekp = (TextView) findViewById(d.g.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.ekc = shareFromGameCenterMsgData;
            hB(z);
        }
    }

    private void hB(boolean z) {
        if (z) {
            this.ekn.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0126d.cp_cont_g));
            this.ekj.setTextColor(this.mContext.getResources().getColor(d.C0126d.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0126d.cp_cont_b));
            this.ekj.setTextColor(this.mContext.getResources().getColor(d.C0126d.cp_cont_f));
            this.ekn.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.e(getContext(), d.e.ds14), 0, 0, 0);
            layoutParams.height = l.e(getContext(), d.e.ds48);
            this.dVf.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.ekc.getTitle());
        this.ekk.setDefaultResource(d.f.pic_avatar_ba_140);
        this.ekk.setAutoChangeStyle(false);
        this.ekk.startLoad(this.ekc.getImageUrl(), 10, false);
        this.ekj.setText(this.ekc.getContent());
        this.ekl.setTextColor(this.mContext.getResources().getColor(d.C0126d.cp_cont_b));
        this.ekl.setBackgroundResource(d.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.ekc.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.e(getContext(), d.e.ds60));
            int e = l.e(getContext(), d.e.ds30);
            layoutParams2.setMargins(e, l.e(getContext(), d.e.ds18), e, e);
            this.ekl.setLayoutParams(layoutParams2);
            this.ekl.setVisibility(0);
            this.ekl.setText(this.ekc.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int e2 = l.e(getContext(), d.e.ds30);
            layoutParams3.setMargins(e2, l.e(getContext(), d.e.ds20), e2, e2);
            this.ekl.setVisibility(8);
            this.eko.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.ekc.getShareSource())) {
            this.dVf.setVisibility(8);
        }
        this.ekp.setText(this.ekc.getShareSource());
        this.ekm.setDefaultResource(d.f.icon);
        this.ekm.setAutoChangeStyle(false);
        this.ekm.startLoad(this.ekc.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.td(this.ekc.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.dVf;
    }

    public LinearLayout getContentBody() {
        return this.ekn;
    }

    public ImageView getTiebaIcon() {
        return this.ekm;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.ekm = tbImageView;
    }
}
