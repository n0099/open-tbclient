package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PbFirstFloorTopicView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public Context f20006e;

    /* renamed from: f  reason: collision with root package name */
    public int f20007f;

    /* renamed from: g  reason: collision with root package name */
    public int f20008g;

    /* renamed from: h  reason: collision with root package name */
    public int f20009h;

    public PbFirstFloorTopicView(Context context) {
        super(context);
        this.f20006e = null;
        c(context);
    }

    public final LinearLayout a() {
        LinearLayout linearLayout = new LinearLayout(this.f20006e);
        SkinManager.setBackgroundColor(linearLayout, R.color.transparent);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(this.f20009h, -2));
        linearLayout.setGravity(17);
        addView(linearLayout);
        return linearLayout;
    }

    public final void b(LinearLayout linearLayout, String str) {
        TextView textView = new TextView(this.f20006e);
        textView.setText(str);
        textView.setGravity(17);
        SkinManager.setBackgroundColor(textView, R.color.CAM_X0204);
        SkinManager.setViewTextColor(textView, R.color.black_alpha100);
        textView.setTextSize(0, getResources().getDimension(R.dimen.ds28));
        textView.setTypeface(null, 1);
        textView.setMinLines(1);
        textView.setMaxLines(1);
        textView.setWidth(this.f20007f);
        textView.setOnClickListener(this);
        linearLayout.addView(textView);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        int i2 = this.f20008g;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i2;
    }

    public final void c(Context context) {
        setOrientation(1);
        this.f20006e = context;
        this.f20008g = l.g(context, R.dimen.ds8);
        this.f20009h = l.k(this.f20006e);
        this.f20007f = l.k(this.f20006e) / 2;
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
        for (int i2 = 0; i2 < count; i2++) {
            if (i2 % 2 == 0) {
                linearLayout = a();
            } else if (linearLayout != null) {
                b(linearLayout, (String) ListUtils.getItem(arrayList, i2 - 1));
                b(linearLayout, (String) ListUtils.getItem(arrayList, i2));
            }
        }
        if (linearLayout == null || linearLayout.getChildCount() != 0) {
            return;
        }
        this.f20007f = this.f20009h;
        b(linearLayout, (String) ListUtils.getItem(arrayList, count - 1));
    }

    public PbFirstFloorTopicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20006e = null;
        c(context);
    }

    public PbFirstFloorTopicView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20006e = null;
        c(context);
    }
}
