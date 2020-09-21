package com.baidu.ufosdk.ui;

import android.content.Context;
import android.support.v4.view.ViewCompat;
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
/* loaded from: classes21.dex */
public final class fd extends BaseAdapter {
    private Context a;
    private JSONArray b;
    private int c;
    private boolean d;

    public fd(Context context, JSONArray jSONArray, int i, boolean z) {
        this.d = false;
        this.a = context;
        this.b = jSONArray;
        this.c = i;
        this.d = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public String getItem(int i) {
        try {
            return ((JSONObject) this.b.get(i)).getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.b.length();
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        fe feVar;
        LinearLayout linearLayout;
        if (view == null) {
            fe feVar2 = new fe();
            LinearLayout linearLayout2 = new LinearLayout(this.a);
            linearLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            TextView textView = new TextView(this.a);
            textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            textView.setTextSize(com.baidu.ufosdk.b.R);
            textView.setGravity(16);
            textView.setSingleLine(true);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.a, 10.0f), com.baidu.ufosdk.f.i.a(this.a, 5.0f), 0, com.baidu.ufosdk.f.i.a(this.a, 5.0f));
            linearLayout2.addView(textView, layoutParams);
            feVar2.a = textView;
            linearLayout2.setTag(feVar2);
            feVar = feVar2;
            linearLayout = linearLayout2;
        } else {
            feVar = (fe) view.getTag();
            linearLayout = view;
        }
        try {
            JSONObject jSONObject = (JSONObject) this.b.get(i);
            if (this.c == 0) {
                feVar.a.setText(jSONObject.getString("question"));
                feVar.a.setSingleLine(true);
                if (this.d) {
                    feVar.a.setTextColor(-13421773);
                } else {
                    feVar.a.setTextColor(-12814593);
                }
            } else {
                feVar.a.setText(jSONObject.getString("name"));
                feVar.a.setSingleLine(true);
                if (this.d) {
                    feVar.a.setTextColor(-13421773);
                } else {
                    feVar.a.setTextColor(-12814593);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            feVar.a.setText("");
        }
        return linearLayout;
    }
}
