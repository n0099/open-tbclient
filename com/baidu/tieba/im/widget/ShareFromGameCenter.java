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
    private LinearLayout egs;
    private TextView evA;
    private HeadImageView evB;
    private Button evC;
    private TbImageView evD;
    private LinearLayout evE;
    private LinearLayout evF;
    private TextView evG;
    private ShareFromGameCenterMsgData evt;
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
        this.evE = (LinearLayout) findViewById(d.g.share_info_layout);
        this.evF = (LinearLayout) findViewById(d.g.game_share_content);
        this.egs = (LinearLayout) findViewById(d.g.small_tail);
        this.mTitle = (TextView) findViewById(d.g.game_title);
        this.evA = (TextView) findViewById(d.g.game_desc);
        this.evB = (HeadImageView) findViewById(d.g.game_img);
        this.evB.setDefaultResource(d.f.pic_avatar_ba_140);
        this.evB.setAutoChangeStyle(false);
        this.evC = (Button) findViewById(d.g.accept_invite_button);
        this.evD = (TbImageView) findViewById(d.g.tail_icon);
        this.evD.setDefaultResource(d.f.icon);
        this.evD.setAutoChangeStyle(false);
        this.evG = (TextView) findViewById(d.g.tail_game_from);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.evt = shareFromGameCenterMsgData;
            hH(z);
        }
    }

    private void hH(boolean z) {
        if (z) {
            this.evE.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_me));
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0141d.cp_cont_g));
            this.evA.setTextColor(this.mContext.getResources().getColor(d.C0141d.cp_cont_g));
        } else {
            this.mTitle.setTextColor(this.mContext.getResources().getColor(d.C0141d.cp_cont_b));
            this.evA.setTextColor(this.mContext.getResources().getColor(d.C0141d.cp_cont_f));
            this.evE.setBackgroundDrawable(this.mContext.getResources().getDrawable(d.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(l.e(getContext(), d.e.ds14), 0, 0, 0);
            layoutParams.height = l.e(getContext(), d.e.ds48);
            this.egs.setLayoutParams(layoutParams);
        }
        this.mTitle.setText(this.evt.getTitle());
        this.evB.setDefaultResource(d.f.pic_avatar_ba_140);
        this.evB.setAutoChangeStyle(false);
        this.evB.startLoad(this.evt.getImageUrl(), 10, false);
        this.evA.setText(this.evt.getContent());
        this.evC.setTextColor(this.mContext.getResources().getColor(d.C0141d.cp_cont_b));
        this.evC.setBackgroundResource(d.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.evt.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, l.e(getContext(), d.e.ds60));
            int e = l.e(getContext(), d.e.ds30);
            layoutParams2.setMargins(e, l.e(getContext(), d.e.ds18), e, e);
            this.evC.setLayoutParams(layoutParams2);
            this.evC.setVisibility(0);
            this.evC.setText(this.evt.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int e2 = l.e(getContext(), d.e.ds30);
            layoutParams3.setMargins(e2, l.e(getContext(), d.e.ds20), e2, e2);
            this.evC.setVisibility(8);
            this.evF.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.evt.getShareSource())) {
            this.egs.setVisibility(8);
        }
        this.evG.setText(this.evt.getShareSource());
        this.evD.setDefaultResource(d.f.icon);
        this.evD.setAutoChangeStyle(false);
        this.evD.startLoad(this.evt.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", com.baidu.tieba.tbadkCore.util.b.tX(this.evt.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.egs;
    }

    public LinearLayout getContentBody() {
        return this.evE;
    }

    public ImageView getTiebaIcon() {
        return this.evD;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.evD = tbImageView;
    }
}
