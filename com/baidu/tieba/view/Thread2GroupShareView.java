package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
/* loaded from: classes5.dex */
public final class Thread2GroupShareView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f22569e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f22570f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f22571g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f22572h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f22573i;
    public ShareFromPBMsgData j;

    public Thread2GroupShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public void a() {
        this.f22569e.setFocusable(true);
        this.f22569e.setFocusableInTouchMode(true);
        this.f22569e.requestFocus();
    }

    public final void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.thread_to_group_share_view, this);
        setOrientation(1);
        this.f22569e = (LinearLayout) findViewById(R.id.share_content);
        this.f22573i = (TextView) findViewById(R.id.share_title_view);
        this.f22570f = (EditText) findViewById(R.id.chat_msg);
        this.f22571g = (TbImageView) findViewById(R.id.chat_group_img);
        this.f22572h = (TextView) findViewById(R.id.chat_group_desc);
        SkinManager.setViewTextColor(this.f22573i, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f22570f, R.color.CAM_X0105, 2);
        SkinManager.setViewTextColor(this.f22572h, R.color.CAM_X0106, 1);
        this.f22570f.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        this.f22570f.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        a();
    }

    public void c(String str, boolean z) {
        TbImageView tbImageView = this.f22571g;
        if (tbImageView != null) {
            tbImageView.V(str, z ? 17 : 18, false);
        }
    }

    public final void d() {
        this.f22573i.setText(this.j.getTitle());
        this.f22571g.setTag(this.j.getImageUrl());
        this.f22572h.setText(this.j.getContent());
    }

    public EditText getChatMsgView() {
        return this.f22570f;
    }

    public String getLeaveMsg() {
        EditText editText = this.f22570f;
        if (editText != null) {
            return k.charSequence2String(editText.getText(), null);
        }
        return null;
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        this.j = shareFromPBMsgData;
        d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public Thread2GroupShareView(Context context) {
        super(context);
        b(context);
    }
}
