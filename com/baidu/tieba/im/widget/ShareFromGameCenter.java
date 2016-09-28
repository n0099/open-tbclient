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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.util.n;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private TextView aMI;
    private LinearLayout cYp;
    private ShareFromGameCenterMsgData dnD;
    private TextView dnI;
    private HeadImageView dnJ;
    private Button dnK;
    private TbImageView dnL;
    private LinearLayout dnM;
    private LinearLayout dnN;
    private TextView dnO;
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
        LayoutInflater.from(getContext()).inflate(r.h.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.dnM = (LinearLayout) findViewById(r.g.share_info_layout);
        this.dnN = (LinearLayout) findViewById(r.g.game_share_content);
        this.cYp = (LinearLayout) findViewById(r.g.small_tail);
        this.aMI = (TextView) findViewById(r.g.game_title);
        this.dnI = (TextView) findViewById(r.g.game_desc);
        this.dnJ = (HeadImageView) findViewById(r.g.game_img);
        this.dnJ.setDefaultResource(r.f.pic_avatar_ba_140);
        this.dnJ.setAutoChangeStyle(false);
        this.dnK = (Button) findViewById(r.g.accept_invite_button);
        this.dnL = (TbImageView) findViewById(r.g.tail_icon);
        this.dnL.setDefaultResource(r.f.icon);
        this.dnL.setAutoChangeStyle(false);
        this.dnO = (TextView) findViewById(r.g.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.dnD = shareFromGameCenterMsgData;
            gj(z);
        }
    }

    private void gj(boolean z) {
        if (z) {
            this.dnM.setBackgroundDrawable(this.mContext.getResources().getDrawable(r.f.selector_msg_text_bubble_me));
            this.aMI.setTextColor(this.mContext.getResources().getColor(r.d.cp_cont_g));
            this.dnI.setTextColor(this.mContext.getResources().getColor(r.d.cp_cont_g));
        } else {
            this.aMI.setTextColor(this.mContext.getResources().getColor(r.d.cp_cont_b));
            this.dnI.setTextColor(this.mContext.getResources().getColor(r.d.cp_cont_f));
            this.dnM.setBackgroundDrawable(this.mContext.getResources().getDrawable(r.f.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(k.e(getContext(), r.e.ds14), 0, 0, 0);
            layoutParams.height = k.e(getContext(), r.e.ds48);
            this.cYp.setLayoutParams(layoutParams);
        }
        this.aMI.setText(this.dnD.getTitle());
        this.dnJ.setDefaultResource(r.f.pic_avatar_ba_140);
        this.dnJ.setAutoChangeStyle(false);
        this.dnJ.c(this.dnD.getImageUrl(), 10, false);
        this.dnI.setText(this.dnD.getContent());
        this.dnK.setTextColor(this.mContext.getResources().getColor(r.d.cp_cont_b));
        this.dnK.setBackgroundResource(r.f.btn_appdownload);
        if (!TextUtils.isEmpty(this.dnD.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, k.e(getContext(), r.e.ds60));
            int e = k.e(getContext(), r.e.ds30);
            layoutParams2.setMargins(e, k.e(getContext(), r.e.ds18), e, e);
            this.dnK.setLayoutParams(layoutParams2);
            this.dnK.setVisibility(0);
            this.dnK.setText(this.dnD.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int e2 = k.e(getContext(), r.e.ds30);
            layoutParams3.setMargins(e2, k.e(getContext(), r.e.ds20), e2, e2);
            this.dnK.setVisibility(8);
            this.dnN.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.dnD.getShareSource())) {
            this.cYp.setVisibility(8);
        }
        this.dnO.setText(this.dnD.getShareSource());
        this.dnL.setDefaultResource(r.f.icon);
        this.dnL.setAutoChangeStyle(false);
        this.dnL.c(this.dnD.getShareSourceIcon(), 10, false);
        TiebaStatic.eventStat(this.mContext, "game_show", "show", 1, "dev_id", n.rq(this.dnD.getShareSourceUrl()), "ref_id", "2000801");
    }

    public LinearLayout getTail() {
        return this.cYp;
    }

    public LinearLayout getContentBody() {
        return this.dnM;
    }

    public ImageView getTiebaIcon() {
        return this.dnL;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.dnL = tbImageView;
    }
}
