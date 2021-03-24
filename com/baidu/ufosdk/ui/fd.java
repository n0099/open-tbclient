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
    public Context f23267a;

    /* renamed from: b  reason: collision with root package name */
    public JSONArray f23268b;

    /* renamed from: c  reason: collision with root package name */
    public int f23269c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23270d;

    public fd(Context context, JSONArray jSONArray, int i, boolean z) {
        this.f23270d = false;
        this.f23267a = context;
        this.f23268b = jSONArray;
        this.f23269c = i;
        this.f23270d = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public String getItem(int i) {
        try {
            return ((JSONObject) this.f23268b.get(i)).getString("name");
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f23268b.length();
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
            LinearLayout linearLayout2 = new LinearLayout(this.f23267a);
            linearLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            TextView textView3 = new TextView(this.f23267a);
            textView3.setTextColor(-16777216);
            textView3.setTextSize(com.baidu.ufosdk.b.R);
            textView3.setGravity(16);
            textView3.setSingleLine(true);
            textView3.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f23267a, 10.0f), com.baidu.ufosdk.f.i.a(this.f23267a, 5.0f), 0, com.baidu.ufosdk.f.i.a(this.f23267a, 5.0f));
            linearLayout2.addView(textView3, layoutParams);
            feVar.f23271a = textView3;
            linearLayout2.setTag(feVar);
            linearLayout = linearLayout2;
        } else {
            linearLayout = view;
            feVar = (fe) view.getTag();
        }
        try {
            jSONObject = (JSONObject) this.f23268b.get(i);
        } catch (JSONException e2) {
            e2.printStackTrace();
            feVar.f23271a.setText("");
        }
        if (this.f23269c == 0) {
            feVar.f23271a.setText(jSONObject.getString("question"));
            feVar.f23271a.setSingleLine(true);
            if (this.f23270d) {
                textView2 = feVar.f23271a;
                textView2.setTextColor(-13421773);
                return linearLayout;
            }
            textView = feVar.f23271a;
            textView.setTextColor(-12814593);
            return linearLayout;
        }
        feVar.f23271a.setText(jSONObject.getString("name"));
        feVar.f23271a.setSingleLine(true);
        if (this.f23270d) {
            textView2 = feVar.f23271a;
            textView2.setTextColor(-13421773);
            return linearLayout;
        }
        textView = feVar.f23271a;
        textView.setTextColor(-12814593);
        return linearLayout;
    }
}
