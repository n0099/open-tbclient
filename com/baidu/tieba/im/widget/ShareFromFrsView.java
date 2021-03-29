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
import d.b.b.e.p.k;
/* loaded from: classes3.dex */
public class ShareFromFrsView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f18128e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f18129f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f18130g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18131h;
    public TextView i;
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
        this.f18128e = (TextView) findViewById(R.id.frs_name);
        this.f18129f = (HeadImageView) findViewById(R.id.frs_img);
        this.f18131h = (TextView) findViewById(R.id.frs_member_num);
        this.j = (TextView) findViewById(R.id.frs_post_num);
        this.f18130g = (TextView) findViewById(R.id.frs_member_num_label);
        this.i = (TextView) findViewById(R.id.frs_post_num_label);
    }

    public final void c() {
        this.f18128e.setText(a(this.l.getName()));
        this.f18129f.setPlaceHolder(1);
        this.f18129f.setAutoChangeStyle(false);
        this.f18129f.W(this.l.getImageUrl(), 10, false);
        this.f18131h.setText(StringHelper.numFormatOver10000(this.l.getMemberNum()));
        this.j.setText(StringHelper.numFormatOver10000(this.l.getPostNum()));
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.l = shareFromFrsMsgData;
        c();
    }

    public void setIsLeft(boolean z) {
        if (z) {
            this.f18128e.setTextColor(getContext().getResources().getColor(R.color.CAM_X0105));
            this.f18131h.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.j.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.f18130g.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            this.i.setTextColor(getContext().getResources().getColor(R.color.CAM_X0106));
            return;
        }
        this.f18128e.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.f18131h.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.j.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.f18130g.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
        this.i.setTextColor(getContext().getResources().getColor(R.color.CAM_X0111));
    }

    public ShareFromFrsView(Context context) {
        super(context);
        this.k = context;
        b();
    }
}
