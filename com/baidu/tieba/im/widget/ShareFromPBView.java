package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public final class ShareFromPBView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f18136e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f18137f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f18138g;

    /* renamed from: h  reason: collision with root package name */
    public ShareFromPBMsgData f18139h;

    public ShareFromPBView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.share_from_pb_view, this);
        setOrientation(1);
        this.f18136e = (TextView) findViewById(R.id.chat_title);
        this.f18137f = (HeadImageView) findViewById(R.id.chat_group_img);
        this.f18138g = (TextView) findViewById(R.id.chat_group_desc);
    }

    public final void b() {
        this.f18136e.setText(this.f18139h.getTitle());
        this.f18137f.setPlaceHolder(1);
        this.f18137f.setAutoChangeStyle(false);
        this.f18137f.W(this.f18139h.getImageUrl(), 10, false);
        this.f18138g.setText(this.f18139h.getContent());
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.f18139h = shareFromPBMsgData;
        b();
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.f18136e.setTextColor(getContext().getResources().getColor(R.color.CAM_X0105));
            this.f18138g.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            return;
        }
        this.f18136e.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.f18138g.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
    }

    public ShareFromPBView(Context context) {
        super(context);
        a();
    }
}
