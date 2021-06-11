package com.baidu.tieba.pb.chosen.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
/* loaded from: classes5.dex */
public final class ShareThreadView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f18907e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f18908f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f18909g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18910h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f18911i;

    public ShareThreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public void a() {
        this.f18907e.setFocusable(true);
        this.f18907e.setFocusableInTouchMode(true);
        this.f18907e.requestFocus();
    }

    public final void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.thread_to_group_share_view, this);
        setOrientation(1);
        this.f18907e = (LinearLayout) findViewById(R.id.share_content);
        TextView textView = (TextView) findViewById(R.id.share_title_view);
        this.f18911i = textView;
        SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
        this.f18908f = (EditText) findViewById(R.id.chat_msg);
        this.f18909g = (TbImageView) findViewById(R.id.chat_group_img);
        this.f18910h = (TextView) findViewById(R.id.chat_group_desc);
        SkinManager.setViewTextColor(this.f18908f, R.color.CAM_X0105, 2);
        SkinManager.setViewTextColor(this.f18910h, R.color.CAM_X0106, 1);
        this.f18908f.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
        this.f18908f.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        a();
    }

    public void c(String str, boolean z) {
        TbImageView tbImageView = this.f18909g;
        if (tbImageView != null) {
            tbImageView.U(str, z ? 17 : 18, false);
        }
    }

    public EditText getChatMsgView() {
        return this.f18908f;
    }

    public String getLeaveMsg() {
        EditText editText = this.f18908f;
        if (editText != null) {
            return k.charSequence2String(editText.getText(), null);
        }
        return null;
    }

    public void setDesc(String str) {
        TextView textView = this.f18910h;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTitle(String str) {
        TextView textView = this.f18911i;
        if (textView != null) {
            textView.setText(str);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public ShareThreadView(Context context) {
        super(context);
        b(context);
    }
}
