package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public final class ShareFromPBView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f17378e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f17379f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17380g;

    /* renamed from: h  reason: collision with root package name */
    public ShareFromPBMsgData f17381h;

    public ShareFromPBView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.share_from_pb_view, this);
        setOrientation(1);
        this.f17378e = (TextView) findViewById(R.id.chat_title);
        this.f17379f = (HeadImageView) findViewById(R.id.chat_group_img);
        this.f17380g = (TextView) findViewById(R.id.chat_group_desc);
    }

    public final void b() {
        this.f17378e.setText(this.f17381h.getTitle());
        this.f17379f.setPlaceHolder(1);
        this.f17379f.setAutoChangeStyle(false);
        this.f17379f.V(this.f17381h.getImageUrl(), 10, false);
        this.f17380g.setText(this.f17381h.getContent());
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.f17381h = shareFromPBMsgData;
        b();
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.f17378e.setTextColor(getContext().getResources().getColor(R.color.CAM_X0105));
            this.f17380g.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            return;
        }
        this.f17378e.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.f17380g.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
    }

    public ShareFromPBView(Context context) {
        super(context);
        a();
    }
}
