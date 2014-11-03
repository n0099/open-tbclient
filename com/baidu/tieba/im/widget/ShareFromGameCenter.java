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
    private TextView JN;
    private LinearLayout aSY;
    private TextView aqa;
    private ShareFromGameCenterMsgData bfA;
    private HeadImageView bjW;
    private Button bjX;
    private TbImageView bjY;
    private LinearLayout bjZ;
    private LinearLayout bka;
    private TextView bkb;
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
        this.bjZ = (LinearLayout) findViewById(v.share_info_layout);
        this.bka = (LinearLayout) findViewById(v.game_share_content);
        this.aSY = (LinearLayout) findViewById(v.small_tail);
        this.JN = (TextView) findViewById(v.game_title);
        this.aqa = (TextView) findViewById(v.game_desc);
        this.bjW = (HeadImageView) findViewById(v.game_img);
        this.bjW.setDefaultResource(u.pic_avatar_ba_140);
        this.bjW.setAutoChangeStyle(false);
        this.bjX = (Button) findViewById(v.accept_invite_button);
        this.bjY = (TbImageView) findViewById(v.tail_icon);
        this.bjY.setDefaultResource(u.icon);
        this.bjY.setAutoChangeStyle(false);
        this.bkb = (TextView) findViewById(v.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.bfA = shareFromGameCenterMsgData;
            du(z);
        }
    }

    private void du(boolean z) {
        if (z) {
            this.bjZ.setBackgroundDrawable(this.mContext.getResources().getDrawable(u.selector_msg_text_bubble_me));
        } else {
            this.bjZ.setBackgroundDrawable(this.mContext.getResources().getDrawable(u.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(m.c(getContext(), t.ds14), 0, 0, 0);
            layoutParams.height = m.c(getContext(), t.ds48);
            this.aSY.setLayoutParams(layoutParams);
        }
        this.JN.setText(this.bfA.getTitle());
        this.bjW.setDefaultResource(u.pic_avatar_ba_140);
        this.bjW.setAutoChangeStyle(false);
        this.bjW.c(this.bfA.getImageUrl(), 10, false);
        this.aqa.setText(this.bfA.getContent());
        if (!TextUtils.isEmpty(this.bfA.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, m.c(getContext(), t.ds60));
            int c = m.c(getContext(), t.ds30);
            layoutParams2.setMargins(c, m.c(getContext(), t.ds18), c, c);
            this.bjX.setLayoutParams(layoutParams2);
            this.bjX.setVisibility(0);
            this.bjX.setText(this.bfA.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int c2 = m.c(getContext(), t.ds30);
            layoutParams3.setMargins(c2, m.c(getContext(), t.ds20), c2, c2);
            this.bjX.setVisibility(8);
            this.bka.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.bfA.getShareSource())) {
            this.aSY.setVisibility(8);
        }
        this.bkb.setText(this.bfA.getShareSource());
        this.bjY.setDefaultResource(u.icon);
        this.bjY.setAutoChangeStyle(false);
        this.bjY.c(this.bfA.getShareSourceIcon(), 10, false);
    }

    public LinearLayout getTail() {
        return this.aSY;
    }

    public LinearLayout getContentBody() {
        return this.bjZ;
    }

    public ImageView getTiebaIcon() {
        return this.bjY;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.bjY = tbImageView;
    }
}
