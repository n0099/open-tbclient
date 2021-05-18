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
    public Context f22919a;

    /* renamed from: b  reason: collision with root package name */
    public JSONArray f22920b;

    /* renamed from: c  reason: collision with root package name */
    public int f22921c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22922d;

    public fd(Context context, JSONArray jSONArray, int i2, boolean z) {
        this.f22922d = false;
        this.f22919a = context;
        this.f22920b = jSONArray;
        this.f22921c = i2;
        this.f22922d = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public String getItem(int i2) {
        try {
            return ((JSONObject) this.f22920b.get(i2)).getString("name");
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f22920b.length();
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
            LinearLayout linearLayout2 = new LinearLayout(this.f22919a);
            linearLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            TextView textView3 = new TextView(this.f22919a);
            textView3.setTextColor(-16777216);
            textView3.setTextSize(com.baidu.ufosdk.b.R);
            textView3.setGravity(16);
            textView3.setSingleLine(true);
            textView3.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f22919a, 10.0f), com.baidu.ufosdk.f.i.a(this.f22919a, 5.0f), 0, com.baidu.ufosdk.f.i.a(this.f22919a, 5.0f));
            linearLayout2.addView(textView3, layoutParams);
            feVar.f22923a = textView3;
            linearLayout2.setTag(feVar);
            linearLayout = linearLayout2;
        } else {
            linearLayout = view;
            feVar = (fe) view.getTag();
        }
        try {
            jSONObject = (JSONObject) this.f22920b.get(i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
            feVar.f22923a.setText("");
        }
        if (this.f22921c == 0) {
            feVar.f22923a.setText(jSONObject.getString("question"));
            feVar.f22923a.setSingleLine(true);
            if (this.f22922d) {
                textView2 = feVar.f22923a;
                textView2.setTextColor(-13421773);
                return linearLayout;
            }
            textView = feVar.f22923a;
            textView.setTextColor(-12814593);
            return linearLayout;
        }
        feVar.f22923a.setText(jSONObject.getString("name"));
        feVar.f22923a.setSingleLine(true);
        if (this.f22922d) {
            textView2 = feVar.f22923a;
            textView2.setTextColor(-13421773);
            return linearLayout;
        }
        textView = feVar.f22923a;
        textView.setTextColor(-12814593);
        return linearLayout;
    }
}
