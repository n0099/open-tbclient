package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class co implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f22774a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ cg f22775b;

    /* renamed from: c  reason: collision with root package name */
    public int f22776c = 0;

    /* renamed from: d  reason: collision with root package name */
    public String f22777d = "";

    public co(cg cgVar, int i2) {
        this.f22775b = cgVar;
        this.f22774a = i2;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i2, long j) {
        int i3;
        JSONObject jSONObject;
        if (this.f22775b.f22763a.H) {
            return;
        }
        com.baidu.ufosdk.f.c.a("FeedbackInputActiviy --> FeedbackInput item clicked! " + i2);
        if (((Integer) ((Map) this.f22775b.f22763a.f22667h.get(this.f22774a)).get("subtype")).intValue() == 0) {
            com.baidu.ufosdk.f.c.a("FeedbackInputActiviy clicked! -- > \n" + ((Map) this.f22775b.f22763a.f22667h.get(this.f22774a)).get("content").toString());
            try {
                JSONObject jSONObject2 = (JSONObject) ((JSONArray) ((Map) this.f22775b.f22763a.f22667h.get(this.f22774a)).get("content")).get(i2);
                this.f22776c = jSONObject2.getInt("qid");
                this.f22777d = jSONObject2.getString("question");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            new Thread(new cp(this)).start();
            return;
        }
        JSONArray jSONArray = null;
        try {
            jSONObject = (JSONObject) ((JSONArray) ((Map) this.f22775b.f22763a.f22667h.get(this.f22774a)).get("content")).get(i2);
            i3 = jSONObject.getInt("id");
        } catch (Exception e3) {
            e = e3;
            i3 = 0;
        }
        try {
            if (jSONObject.has("extra_fields")) {
                jSONArray = jSONObject.getJSONArray("extra_fields");
            }
        } catch (Exception e4) {
            e = e4;
            e.printStackTrace();
            com.baidu.ufosdk.f.c.a("FeedbackInputActiviy clicked!-- product_type : " + i3 + "msgId" + this.f22775b.f22763a.f22664e);
            Intent intent = new Intent();
            intent.setClass(this.f22775b.f22763a, FeedbackEditActivity.class);
            intent.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
            intent.putExtra("product_type", i3);
            if (jSONArray != null) {
            }
            intent.putExtra("msgid", this.f22775b.f22763a.f22664e);
            intent.putExtra("data_array", r4);
            intent.putExtra("im_content", this.f22775b.f22763a.A);
            intent.putExtra("come_from", 0);
            this.f22775b.f22763a.startActivity(intent);
        }
        com.baidu.ufosdk.f.c.a("FeedbackInputActiviy clicked!-- product_type : " + i3 + "msgId" + this.f22775b.f22763a.f22664e);
        Intent intent2 = new Intent();
        intent2.setClass(this.f22775b.f22763a, FeedbackEditActivity.class);
        intent2.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
        intent2.putExtra("product_type", i3);
        String jSONArray2 = (jSONArray != null || jSONArray.length() <= 0) ? "" : jSONArray.toString();
        intent2.putExtra("msgid", this.f22775b.f22763a.f22664e);
        intent2.putExtra("data_array", jSONArray2);
        intent2.putExtra("im_content", this.f22775b.f22763a.A);
        intent2.putExtra("come_from", 0);
        this.f22775b.f22763a.startActivity(intent2);
    }
}
