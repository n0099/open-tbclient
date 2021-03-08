package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
final class co implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f3715a;
    final /* synthetic */ cg b;
    private int c = 0;
    private String d = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(cg cgVar, int i) {
        this.b = cgVar;
        this.f3715a = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0123  */
    @Override // android.widget.AdapterView.OnItemClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int i2;
        JSONArray jSONArray;
        JSONObject jSONObject;
        if (this.b.f3707a.H) {
            return;
        }
        com.baidu.ufosdk.f.c.a("FeedbackInputActiviy --> FeedbackInput item clicked! " + i);
        if (((Integer) ((Map) this.b.f3707a.h.get(this.f3715a)).get("subtype")).intValue() == 0) {
            com.baidu.ufosdk.f.c.a("FeedbackInputActiviy clicked! -- > \n" + ((Map) this.b.f3707a.h.get(this.f3715a)).get("content").toString());
            try {
                JSONObject jSONObject2 = (JSONObject) ((JSONArray) ((Map) this.b.f3707a.h.get(this.f3715a)).get("content")).get(i);
                this.c = jSONObject2.getInt("qid");
                this.d = jSONObject2.getString("question");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            new Thread(new cp(this)).start();
            return;
        }
        try {
            jSONObject = (JSONObject) ((JSONArray) ((Map) this.b.f3707a.h.get(this.f3715a)).get("content")).get(i);
            i2 = jSONObject.getInt("id");
        } catch (Exception e2) {
            e = e2;
            i2 = 0;
        }
        try {
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            jSONArray = null;
            com.baidu.ufosdk.f.c.a("FeedbackInputActiviy clicked!-- product_type : " + i2 + "msgId" + this.b.f3707a.e);
            Intent intent = new Intent();
            intent.setClass(this.b.f3707a, FeedbackEditActivity.class);
            intent.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
            intent.putExtra("product_type", i2);
            if (jSONArray != null) {
            }
            intent.putExtra("msgid", this.b.f3707a.e);
            intent.putExtra("data_array", r0);
            intent.putExtra("im_content", this.b.f3707a.A);
            intent.putExtra("come_from", 0);
            this.b.f3707a.startActivity(intent);
        }
        if (jSONObject.has("extra_fields")) {
            jSONArray = jSONObject.getJSONArray("extra_fields");
            com.baidu.ufosdk.f.c.a("FeedbackInputActiviy clicked!-- product_type : " + i2 + "msgId" + this.b.f3707a.e);
            Intent intent2 = new Intent();
            intent2.setClass(this.b.f3707a, FeedbackEditActivity.class);
            intent2.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
            intent2.putExtra("product_type", i2);
            String jSONArray2 = (jSONArray != null || jSONArray.length() <= 0) ? "" : jSONArray.toString();
            intent2.putExtra("msgid", this.b.f3707a.e);
            intent2.putExtra("data_array", jSONArray2);
            intent2.putExtra("im_content", this.b.f3707a.A);
            intent2.putExtra("come_from", 0);
            this.b.f3707a.startActivity(intent2);
        }
        jSONArray = null;
        com.baidu.ufosdk.f.c.a("FeedbackInputActiviy clicked!-- product_type : " + i2 + "msgId" + this.b.f3707a.e);
        Intent intent22 = new Intent();
        intent22.setClass(this.b.f3707a, FeedbackEditActivity.class);
        intent22.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
        intent22.putExtra("product_type", i2);
        if (jSONArray != null) {
        }
        intent22.putExtra("msgid", this.b.f3707a.e);
        intent22.putExtra("data_array", jSONArray2);
        intent22.putExtra("im_content", this.b.f3707a.A);
        intent22.putExtra("come_from", 0);
        this.b.f3707a.startActivity(intent22);
    }
}
