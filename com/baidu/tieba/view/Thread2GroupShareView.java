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
import d.b.c.e.p.k;
/* loaded from: classes5.dex */
public final class Thread2GroupShareView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f21903e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f21904f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f21905g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f21906h;
    public TextView i;
    public ShareFromPBMsgData j;

    public Thread2GroupShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public void a() {
        this.f21903e.setFocusable(true);
        this.f21903e.setFocusableInTouchMode(true);
        this.f21903e.requestFocus();
    }

    public final void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.thread_to_group_share_view, this);
        setOrientation(1);
        this.f21903e = (LinearLayout) findViewById(R.id.share_content);
        this.i = (TextView) findViewById(R.id.share_title_view);
        this.f21904f = (EditText) findViewById(R.id.chat_msg);
        this.f21905g = (TbImageView) findViewById(R.id.chat_group_img);
        this.f21906h = (TextView) findViewById(R.id.chat_group_desc);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f21904f, R.color.CAM_X0105, 2);
        SkinManager.setViewTextColor(this.f21906h, R.color.CAM_X0106, 1);
        this.f21904f.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        this.f21904f.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        a();
    }

    public void c(String str, boolean z) {
        TbImageView tbImageView = this.f21905g;
        if (tbImageView != null) {
            tbImageView.W(str, z ? 17 : 18, false);
        }
    }

    public final void d() {
        this.i.setText(this.j.getTitle());
        this.f21905g.setTag(this.j.getImageUrl());
        this.f21906h.setText(this.j.getContent());
    }

    public EditText getChatMsgView() {
        return this.f21904f;
    }

    public String getLeaveMsg() {
        EditText editText = this.f21904f;
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
