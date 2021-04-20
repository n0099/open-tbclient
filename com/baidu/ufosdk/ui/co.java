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
    public final /* synthetic */ int f22811a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ cg f22812b;

    /* renamed from: c  reason: collision with root package name */
    public int f22813c = 0;

    /* renamed from: d  reason: collision with root package name */
    public String f22814d = "";

    public co(cg cgVar, int i) {
        this.f22812b = cgVar;
        this.f22811a = i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int i2;
        JSONObject jSONObject;
        if (this.f22812b.f22800a.H) {
            return;
        }
        com.baidu.ufosdk.f.c.a("FeedbackInputActiviy --> FeedbackInput item clicked! " + i);
        if (((Integer) ((Map) this.f22812b.f22800a.f22707h.get(this.f22811a)).get("subtype")).intValue() == 0) {
            com.baidu.ufosdk.f.c.a("FeedbackInputActiviy clicked! -- > \n" + ((Map) this.f22812b.f22800a.f22707h.get(this.f22811a)).get("content").toString());
            try {
                JSONObject jSONObject2 = (JSONObject) ((JSONArray) ((Map) this.f22812b.f22800a.f22707h.get(this.f22811a)).get("content")).get(i);
                this.f22813c = jSONObject2.getInt("qid");
                this.f22814d = jSONObject2.getString("question");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            new Thread(new cp(this)).start();
            return;
        }
        JSONArray jSONArray = null;
        try {
            jSONObject = (JSONObject) ((JSONArray) ((Map) this.f22812b.f22800a.f22707h.get(this.f22811a)).get("content")).get(i);
            i2 = jSONObject.getInt("id");
        } catch (Exception e3) {
            e = e3;
            i2 = 0;
        }
        try {
            if (jSONObject.has("extra_fields")) {
                jSONArray = jSONObject.getJSONArray("extra_fields");
            }
        } catch (Exception e4) {
            e = e4;
            e.printStackTrace();
            com.baidu.ufosdk.f.c.a("FeedbackInputActiviy clicked!-- product_type : " + i2 + "msgId" + this.f22812b.f22800a.f22704e);
            Intent intent = new Intent();
            intent.setClass(this.f22812b.f22800a, FeedbackEditActivity.class);
            intent.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
            intent.putExtra("product_type", i2);
            if (jSONArray != null) {
            }
            intent.putExtra("msgid", this.f22812b.f22800a.f22704e);
            intent.putExtra("data_array", r4);
            intent.putExtra("im_content", this.f22812b.f22800a.A);
            intent.putExtra("come_from", 0);
            this.f22812b.f22800a.startActivity(intent);
        }
        com.baidu.ufosdk.f.c.a("FeedbackInputActiviy clicked!-- product_type : " + i2 + "msgId" + this.f22812b.f22800a.f22704e);
        Intent intent2 = new Intent();
        intent2.setClass(this.f22812b.f22800a, FeedbackEditActivity.class);
        intent2.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
        intent2.putExtra("product_type", i2);
        String jSONArray2 = (jSONArray != null || jSONArray.length() <= 0) ? "" : jSONArray.toString();
        intent2.putExtra("msgid", this.f22812b.f22800a.f22704e);
        intent2.putExtra("data_array", jSONArray2);
        intent2.putExtra("im_content", this.f22812b.f22800a.A);
        intent2.putExtra("come_from", 0);
        this.f22812b.f22800a.startActivity(intent2);
    }
}
