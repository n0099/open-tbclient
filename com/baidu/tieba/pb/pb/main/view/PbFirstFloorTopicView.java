package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class PbFirstFloorTopicView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public Context f19836e;

    /* renamed from: f  reason: collision with root package name */
    public int f19837f;

    /* renamed from: g  reason: collision with root package name */
    public int f19838g;

    /* renamed from: h  reason: collision with root package name */
    public int f19839h;

    public PbFirstFloorTopicView(Context context) {
        super(context);
        this.f19836e = null;
        c(context);
    }

    public final LinearLayout a() {
        LinearLayout linearLayout = new LinearLayout(this.f19836e);
        SkinManager.setBackgroundColor(linearLayout, R.color.transparent);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(this.f19839h, -2));
        linearLayout.setGravity(17);
        addView(linearLayout);
        return linearLayout;
    }

    public final void b(LinearLayout linearLayout, String str) {
        TextView textView = new TextView(this.f19836e);
        textView.setText(str);
        textView.setGravity(17);
        SkinManager.setBackgroundColor(textView, R.color.CAM_X0204);
        SkinManager.setViewTextColor(textView, R.color.black_alpha100);
        textView.setTextSize(0, getResources().getDimension(R.dimen.ds28));
        textView.setTypeface(null, 1);
        textView.setMinLines(1);
        textView.setMaxLines(1);
        textView.setWidth(this.f19837f);
        textView.setOnClickListener(this);
        linearLayout.addView(textView);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        int i = this.f19838g;
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
    }

    public final void c(Context context) {
        setOrientation(1);
        this.f19836e = context;
        this.f19838g = l.g(context, R.dimen.ds8);
        this.f19839h = l.k(this.f19836e);
        this.f19837f = l.k(this.f19836e) / 2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (textView.getText() != null) {
                textView.getText().toString();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeAllViews();
        super.onDetachedFromWindow();
    }

    public void setData(ArrayList<String> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        if (getChildCount() > 0) {
            removeAllViews();
        }
        int count = ListUtils.getCount(arrayList);
        LinearLayout linearLayout = null;
        for (int i = 0; i < count; i++) {
            if (i % 2 == 0) {
                linearLayout = a();
            } else if (linearLayout != null) {
                b(linearLayout, (String) ListUtils.getItem(arrayList, i - 1));
                b(linearLayout, (String) ListUtils.getItem(arrayList, i));
            }
        }
        if (linearLayout == null || linearLayout.getChildCount() != 0) {
            return;
        }
        this.f19837f = this.f19839h;
        b(linearLayout, (String) ListUtils.getItem(arrayList, count - 1));
    }

    public PbFirstFloorTopicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19836e = null;
        c(context);
    }

    public PbFirstFloorTopicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19836e = null;
        c(context);
    }
}
