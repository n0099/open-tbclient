package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.e.b;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
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
        b.a().a(getContext(), v.share_from_pb_view, this);
        setOrientation(1);
        this.a = (TextView) findViewById(u.chat_title);
        this.b = (HeadImageView) findViewById(u.chat_group_img);
        this.c = (TextView) findViewById(u.chat_group_desc);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.d = shareFromPBMsgData;
        b();
    }

    private void b() {
        this.a.setText(this.d.getTitle());
        this.b.setDefaultResource(t.icon_default_ba_120);
        this.b.setAutoChangeStyle(false);
        this.b.a(this.d.getImageUrl(), 10, false);
        this.c.setText(this.d.getContent());
    }
}
