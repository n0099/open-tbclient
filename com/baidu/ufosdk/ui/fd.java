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
    public Context f22848a;

    /* renamed from: b  reason: collision with root package name */
    public JSONArray f22849b;

    /* renamed from: c  reason: collision with root package name */
    public int f22850c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22851d;

    public fd(Context context, JSONArray jSONArray, int i2, boolean z) {
        this.f22851d = false;
        this.f22848a = context;
        this.f22849b = jSONArray;
        this.f22850c = i2;
        this.f22851d = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public String getItem(int i2) {
        try {
            return ((JSONObject) this.f22849b.get(i2)).getString("name");
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f22849b.length();
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        LinearLayout linearLayout;
        fe feVar;
        JSONObject jSONObject;
        TextView textView;
        TextView textView2;
        if (view == null) {
            feVar = new fe();
            LinearLayout linearLayout2 = new LinearLayout(this.f22848a);
            linearLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            TextView textView3 = new TextView(this.f22848a);
            textView3.setTextColor(-16777216);
            textView3.setTextSize(com.baidu.ufosdk.b.R);
            textView3.setGravity(16);
            textView3.setSingleLine(true);
            textView3.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f22848a, 10.0f), com.baidu.ufosdk.f.i.a(this.f22848a, 5.0f), 0, com.baidu.ufosdk.f.i.a(this.f22848a, 5.0f));
            linearLayout2.addView(textView3, layoutParams);
            feVar.f22852a = textView3;
            linearLayout2.setTag(feVar);
            linearLayout = linearLayout2;
        } else {
            linearLayout = view;
            feVar = (fe) view.getTag();
        }
        try {
            jSONObject = (JSONObject) this.f22849b.get(i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
            feVar.f22852a.setText("");
        }
        if (this.f22850c == 0) {
            feVar.f22852a.setText(jSONObject.getString("question"));
            feVar.f22852a.setSingleLine(true);
            if (this.f22851d) {
                textView2 = feVar.f22852a;
                textView2.setTextColor(-13421773);
                return linearLayout;
            }
            textView = feVar.f22852a;
            textView.setTextColor(-12814593);
            return linearLayout;
        }
        feVar.f22852a.setText(jSONObject.getString("name"));
        feVar.f22852a.setSingleLine(true);
        if (this.f22851d) {
            textView2 = feVar.f22852a;
            textView2.setTextColor(-13421773);
            return linearLayout;
        }
        textView = feVar.f22852a;
        textView.setTextColor(-12814593);
        return linearLayout;
    }
}
