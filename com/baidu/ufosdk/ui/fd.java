package com.baidu.ufosdk.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class fd extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f5591a;

    /* renamed from: b  reason: collision with root package name */
    private JSONArray f5592b;
    private int c;
    private boolean d;

    public fd(Context context, JSONArray jSONArray, int i, boolean z) {
        this.d = false;
        this.f5591a = context;
        this.f5592b = jSONArray;
        this.c = i;
        this.d = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public String getItem(int i) {
        try {
            return ((JSONObject) this.f5592b.get(i)).getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f5592b.length();
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
            LinearLayout linearLayout2 = new LinearLayout(this.f5591a);
            linearLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            TextView textView = new TextView(this.f5591a);
            textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            textView.setTextSize(com.baidu.ufosdk.b.R);
            textView.setGravity(16);
            textView.setSingleLine(true);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(com.baidu.ufosdk.f.i.a(this.f5591a, 10.0f), com.baidu.ufosdk.f.i.a(this.f5591a, 5.0f), 0, com.baidu.ufosdk.f.i.a(this.f5591a, 5.0f));
            linearLayout2.addView(textView, layoutParams);
            feVar2.f5593a = textView;
            linearLayout2.setTag(feVar2);
            feVar = feVar2;
            linearLayout = linearLayout2;
        } else {
            feVar = (fe) view.getTag();
            linearLayout = view;
        }
        try {
            JSONObject jSONObject = (JSONObject) this.f5592b.get(i);
            if (this.c == 0) {
                feVar.f5593a.setText(jSONObject.getString("question"));
                feVar.f5593a.setSingleLine(true);
                if (this.d) {
                    feVar.f5593a.setTextColor(-13421773);
                } else {
                    feVar.f5593a.setTextColor(-12814593);
                }
            } else {
                feVar.f5593a.setText(jSONObject.getString("name"));
                feVar.f5593a.setSingleLine(true);
                if (this.d) {
                    feVar.f5593a.setTextColor(-13421773);
                } else {
                    feVar.f5593a.setTextColor(-12814593);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            feVar.f5593a.setText("");
        }
        return linearLayout;
    }
}
