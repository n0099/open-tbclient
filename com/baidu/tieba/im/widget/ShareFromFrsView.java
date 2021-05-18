package com.baidu.tieba.im.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
/* loaded from: classes4.dex */
public class ShareFromFrsView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f17458e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f17459f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17460g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17461h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f17462i;
    public TextView j;
    public Context k;
    public ShareFromFrsMsgData l;

    public ShareFromFrsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = context;
        b();
    }

    public final String a(String str) {
        return k.cutString(str, 8) + this.k.getString(R.string.forum);
    }

    public final void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.share_from_frs_view, this);
        this.f17458e = (TextView) findViewById(R.id.frs_name);
        this.f17459f = (HeadImageView) findViewById(R.id.frs_img);
        this.f17461h = (TextView) findViewById(R.id.frs_member_num);
        this.j = (TextView) findViewById(R.id.frs_post_num);
        this.f17460g = (TextView) findViewById(R.id.frs_member_num_label);
        this.f17462i = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public final void c() {
        this.f17458e.setText(a(this.l.getName()));
        this.f17459f.setPlaceHolder(1);
        this.f17459f.setAutoChangeStyle(false);
        this.f17459f.V(this.l.getImageUrl(), 10, false);
        this.f17461h.setText(StringHelper.numFormatOver10000(this.l.getMemberNum()));
        this.j.setText(StringHelper.numFormatOver10000(this.l.getPostNum()));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.l = shareFromFrsMsgData;
        c();
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.f17458e.setTextColor(getContext().getResources().getColor(R.color.CAM_X0105));
            this.f17461h.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.j.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.f17460g.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.f17462i.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            return;
        }
        this.f17458e.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.f17461h.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.j.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.f17460g.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.f17462i.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
    }

    public ShareFromFrsView(Context context) {
        super(context);
        this.k = context;
        b();
    }
}
