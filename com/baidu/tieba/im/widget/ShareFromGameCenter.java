package com.baidu.tieba.im.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.e.b;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class ShareFromGameCenter extends LinearLayout {
    private TextView a;
    private TextView b;
    private HeadImageView c;
    private Button d;
    private TbImageView e;
    private LinearLayout f;
    private LinearLayout g;
    private LinearLayout h;
    private TextView i;
    private ShareFromGameCenterMsgData j;
    private Context k;

    public ShareFromGameCenter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = context;
        a();
    }

    public ShareFromGameCenter(Context context) {
        super(context);
        this.k = context;
        a();
    }

    public void a() {
        b.a().a(getContext(), v.share_from_game_center_pic_and_word, this);
        setOrientation(1);
        this.f = (LinearLayout) findViewById(u.share_info_layout);
        this.h = (LinearLayout) findViewById(u.game_share_content);
        this.g = (LinearLayout) findViewById(u.small_tail);
        this.a = (TextView) findViewById(u.game_title);
        this.b = (TextView) findViewById(u.game_desc);
        this.c = (HeadImageView) findViewById(u.game_img);
        this.c.setDefaultResource(t.pic_avatar_ba_140);
        this.c.setAutoChangeStyle(false);
        this.d = (Button) findViewById(u.accept_invite_button);
        this.e = (TbImageView) findViewById(u.tail_icon);
        this.e.setDefaultResource(t.icon);
        this.e.setAutoChangeStyle(false);
        this.i = (TextView) findViewById(u.tail_game_from);
    }

    public void a(ShareFromGameCenterMsgData shareFromGameCenterMsgData, boolean z) {
        if (shareFromGameCenterMsgData != null) {
            this.j = shareFromGameCenterMsgData;
            a(z);
        }
    }

    private void a(boolean z) {
        if (z) {
            this.f.setBackgroundDrawable(this.k.getResources().getDrawable(t.selector_msg_text_bubble_me));
        } else {
            this.f.setBackgroundDrawable(this.k.getResources().getDrawable(t.selector_msg_text_bubble_other));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(j.c(getContext(), s.ds14), 0, 0, 0);
            layoutParams.height = j.c(getContext(), s.ds48);
            this.g.setLayoutParams(layoutParams);
        }
        this.a.setText(this.j.getTitle());
        this.c.setDefaultResource(t.pic_avatar_ba_140);
        this.c.setAutoChangeStyle(false);
        this.c.a(this.j.getImageUrl(), 10, false);
        this.b.setText(this.j.getContent());
        if (!TextUtils.isEmpty(this.j.getButton())) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, j.c(getContext(), s.ds60));
            int c = j.c(getContext(), s.ds30);
            layoutParams2.setMargins(c, j.c(getContext(), s.ds18), c, c);
            this.d.setLayoutParams(layoutParams2);
            this.d.setVisibility(0);
            this.d.setText(this.j.getButton());
        } else {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            int c2 = j.c(getContext(), s.ds30);
            layoutParams3.setMargins(c2, j.c(getContext(), s.ds20), c2, c2);
            this.d.setVisibility(8);
            this.h.setLayoutParams(layoutParams3);
        }
        if (TextUtils.isEmpty(this.j.getShareSource())) {
            this.g.setVisibility(8);
        }
        this.i.setText(this.j.getShareSource());
        this.e.setDefaultResource(t.icon);
        this.e.setAutoChangeStyle(false);
        this.e.a(this.j.getShareSourceIcon(), 10, false);
    }

    public LinearLayout getTail() {
        return this.g;
    }

    public LinearLayout getContentBody() {
        return this.f;
    }

    public ImageView getTiebaIcon() {
        return this.e;
    }

    public void setTiebaIcon(TbImageView tbImageView) {
        this.e = tbImageView;
    }
}
