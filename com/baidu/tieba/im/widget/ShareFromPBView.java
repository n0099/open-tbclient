package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public final class ShareFromPBView extends LinearLayout {
    private TextView a;
    private HeadImageView b;
    private TextView c;
    private ShareFromPBMsgData d;

    public ShareFromPBView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ShareFromPBView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(w.share_from_pb_view, this);
        setOrientation(1);
        this.a = (TextView) findViewById(v.chat_title);
        this.b = (HeadImageView) findViewById(v.chat_group_img);
        this.c = (TextView) findViewById(v.chat_group_desc);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.d = shareFromPBMsgData;
        b();
    }

    private void b() {
        this.a.setText(this.d.getTitle());
        this.b.setDefaultResource(u.pic_avatar_ba_140);
        this.b.setTag(this.d.getImageUrl());
        this.c.setText(this.d.getContent());
    }
}
