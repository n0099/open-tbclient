package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
final class co implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f5782a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ cg f5783b;
    private int c = 0;
    private String d = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(cg cgVar, int i) {
        this.f5783b = cgVar;
        this.f5782a = i;
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
        if (this.f5783b.f5771a.H) {
            return;
        }
        com.baidu.ufosdk.f.c.a("FeedbackInputActiviy --> FeedbackInput item clicked! " + i);
        if (((Integer) ((Map) this.f5783b.f5771a.h.get(this.f5782a)).get("subtype")).intValue() == 0) {
            com.baidu.ufosdk.f.c.a("FeedbackInputActiviy clicked! -- > \n" + ((Map) this.f5783b.f5771a.h.get(this.f5782a)).get("content").toString());
            try {
                JSONObject jSONObject2 = (JSONObject) ((JSONArray) ((Map) this.f5783b.f5771a.h.get(this.f5782a)).get("content")).get(i);
                this.c = jSONObject2.getInt(MapBundleKey.MapObjKey.OBJ_QID);
                this.d = jSONObject2.getString("question");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            new Thread(new cp(this)).start();
            return;
        }
        try {
            jSONObject = (JSONObject) ((JSONArray) ((Map) this.f5783b.f5771a.h.get(this.f5782a)).get("content")).get(i);
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
            com.baidu.ufosdk.f.c.a("FeedbackInputActiviy clicked!-- product_type : " + i2 + "msgId" + this.f5783b.f5771a.e);
            Intent intent = new Intent();
            intent.setClass(this.f5783b.f5771a, FeedbackEditActivity.class);
            intent.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
            intent.putExtra("product_type", i2);
            if (jSONArray != null) {
            }
            intent.putExtra("msgid", this.f5783b.f5771a.e);
            intent.putExtra("data_array", r0);
            intent.putExtra("im_content", this.f5783b.f5771a.A);
            intent.putExtra("come_from", 0);
            this.f5783b.f5771a.startActivity(intent);
        }
        if (jSONObject.has("extra_fields")) {
            jSONArray = jSONObject.getJSONArray("extra_fields");
            com.baidu.ufosdk.f.c.a("FeedbackInputActiviy clicked!-- product_type : " + i2 + "msgId" + this.f5783b.f5771a.e);
            Intent intent2 = new Intent();
            intent2.setClass(this.f5783b.f5771a, FeedbackEditActivity.class);
            intent2.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
            intent2.putExtra("product_type", i2);
            String jSONArray2 = (jSONArray != null || jSONArray.length() <= 0) ? "" : jSONArray.toString();
            intent2.putExtra("msgid", this.f5783b.f5771a.e);
            intent2.putExtra("data_array", jSONArray2);
            intent2.putExtra("im_content", this.f5783b.f5771a.A);
            intent2.putExtra("come_from", 0);
            this.f5783b.f5771a.startActivity(intent2);
        }
        jSONArray = null;
        com.baidu.ufosdk.f.c.a("FeedbackInputActiviy clicked!-- product_type : " + i2 + "msgId" + this.f5783b.f5771a.e);
        Intent intent22 = new Intent();
        intent22.setClass(this.f5783b.f5771a, FeedbackEditActivity.class);
        intent22.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
        intent22.putExtra("product_type", i2);
        if (jSONArray != null) {
        }
        intent22.putExtra("msgid", this.f5783b.f5771a.e);
        intent22.putExtra("data_array", jSONArray2);
        intent22.putExtra("im_content", this.f5783b.f5771a.A);
        intent22.putExtra("come_from", 0);
        this.f5783b.f5771a.startActivity(intent22);
    }
}
