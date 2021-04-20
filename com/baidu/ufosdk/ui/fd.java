package com.baidu.ufosdk.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class fd extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f22953a;

    /* renamed from: b  reason: collision with root package name */
    public JSONArray f22954b;

    /* renamed from: c  reason: collision with root package name */
    public int f22955c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22956d;

    public fd(Context context, JSONArray jSONArray, int i, boolean z) {
        this.f22956d = false;
        this.f22953a = context;
        this.f22954b = jSONArray;
        this.f22955c = i;
        this.f22956d = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public String getItem(int i) {
        try {
            return ((JSONObject) this.f22954b.get(i)).getString("name");
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f22954b.length();
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        LinearLayout linearLayout;
        fe feVar;
        JSONObject jSONObject;
        TextView textView;
        TextView textView2;
        if (view == null) {
            feVar = new fe();
            LinearLayout linearLayout2 = new LinearLayout(this.f22953a);
            linearLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            TextView textView3 = new TextView(this.f22953a);
            textView3.setTextColor(-16777216);
            textView3.setTextSize(com.baidu.ufosdk.b.R);
            textView3.setGravity(16);
            textView3.setSingleLine(true);
            textView3.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f22953a, 10.0f), com.baidu.ufosdk.f.i.a(this.f22953a, 5.0f), 0, com.baidu.ufosdk.f.i.a(this.f22953a, 5.0f));
            linearLayout2.addView(textView3, layoutParams);
            feVar.f22957a = textView3;
            linearLayout2.setTag(feVar);
            linearLayout = linearLayout2;
        } else {
            linearLayout = view;
            feVar = (fe) view.getTag();
        }
        try {
            jSONObject = (JSONObject) this.f22954b.get(i);
        } catch (JSONException e2) {
            e2.printStackTrace();
            feVar.f22957a.setText("");
        }
        if (this.f22955c == 0) {
            feVar.f22957a.setText(jSONObject.getString("question"));
            feVar.f22957a.setSingleLine(true);
            if (this.f22956d) {
                textView2 = feVar.f22957a;
                textView2.setTextColor(-13421773);
                return linearLayout;
            }
            textView = feVar.f22957a;
            textView.setTextColor(-12814593);
            return linearLayout;
        }
        feVar.f22957a.setText(jSONObject.getString("name"));
        feVar.f22957a.setSingleLine(true);
        if (this.f22956d) {
            textView2 = feVar.f22957a;
            textView2.setTextColor(-13421773);
            return linearLayout;
        }
        textView = feVar.f22957a;
        textView.setTextColor(-12814593);
        return linearLayout;
    }
}
