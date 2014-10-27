package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private TextView JM;
    private LinearLayout aSK;
    private TextView apR;
    private ShareFromGameCenterMsgData bfm;
    private HeadImageView bjI;
    private Button bjJ;
    private TbImageView bjK;
    private LinearLayout bjL;
    private LinearLayout bjM;
    private TextView bjN;
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
        b.ek().inflate(getContext(), w.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.bjL = (LinearLayout) findViewById(v.share_info_layout);
        this.bjM = (LinearLayout) findViewById(v.game_share_content);
        this.aSK = (LinearLayout) findViewById(v.small_tail);
        this.JM = (TextView) findViewById(v.game_title);
        this.apR = (TextView) findViewById(v.game_desc);
        this.bjI = (HeadImageView) findViewById(v.game_img);
        this.bjI.setDefaultResource(u.pic_avatar_ba_140);
        this.bjI.setAutoChangeStyle(false);
        this.bjJ = (Button) findViewById(v.accept_invite_button);
        this.bjK = (TbImageView) findViewById(v.tail_icon);
        this.bjK.setDefaultResource(u.icon);
        this.bjK.setAutoChangeStyle(false);
        this.bjN = (TextView) findViewById(v.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.bfm = shareFromGameCenterMsgData;
            du(z);
        }
    }

    private void du(boolean z) {
        if (z) {
            this.bjL.setBackgroundDrawable(this.mContext.getResources().getDrawable(u.selector_msg_text_bubble_me));
        } else {
            this.bjL.setBackgroundDrawable(this.mContext.getResources().getDrawable(u.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(m.c(getContext(), t.ds14), 0, 0, 0);
            layoutParams.height = m.c(getContext(), t.ds48);
            this.aSK.setLayoutParams(layoutParams);
        }
        this.JM.setText(this.bfm.getTitle());
        this.bjI.setDefaultResource(u.pic_avatar_ba_140);
        this.bjI.setAutoChangeStyle(false);
        this.bjI.c(this.bfm.getImageUrl(), 10, false);
        this.apR.setText(this.bfm.getContent());
        if (!TextUtils.isEmpty(this.bfm.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, m.c(getContext(), t.ds60));
            int c = m.c(getContext(), t.ds30);
            layoutParams2.setMargins(c, m.c(getContext(), t.ds18), c, c);
            this.bjJ.setLayoutParams(layoutParams2);
            this.bjJ.setVisibility(0);
            this.bjJ.setText(this.bfm.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int c2 = m.c(getContext(), t.ds30);
            layoutParams3.setMargins(c2, m.c(getContext(), t.ds20), c2, c2);
            this.bjJ.setVisibility(8);
            this.bjM.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.bfm.getShareSource())) {
            this.aSK.setVisibility(8);
        }
        this.bjN.setText(this.bfm.getShareSource());
        this.bjK.setDefaultResource(u.icon);
        this.bjK.setAutoChangeStyle(false);
        this.bjK.c(this.bfm.getShareSourceIcon(), 10, false);
    }

    public LinearLayout getTail() {
        return this.aSK;
    }

    public LinearLayout getContentBody() {
        return this.bjL;
    }

    public ImageView getTiebaIcon() {
        return this.bjK;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.bjK = tbImageView;
    }
}
