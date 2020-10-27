package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes22.dex */
final class co implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f3807a;
    final /* synthetic */ cg b;
    private int c = 0;
    private String d = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(cg cgVar, int i) {
        this.b = cgVar;
        this.f3807a = i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        Exception exc;
        int i2;
        int i3;
        JSONArray jSONArray;
        JSONObject jSONObject;
        int i4;
        if (this.b.f3799a.H) {
            return;
        }
        com.baidu.ufosdk.f.c.a("FeedbackInputActiviy --> FeedbackInput item clicked! " + i);
        if (((Integer) ((Map) this.b.f3799a.h.get(this.f3807a)).get("subtype")).intValue() == 0) {
            com.baidu.ufosdk.f.c.a("FeedbackInputActiviy clicked! -- > \n" + ((Map) this.b.f3799a.h.get(this.f3807a)).get("content").toString());
            try {
                JSONObject jSONObject2 = (JSONObject) ((JSONArray) ((Map) this.b.f3799a.h.get(this.f3807a)).get("content")).get(i);
                this.c = jSONObject2.getInt(MapBundleKey.MapObjKey.OBJ_QID);
                this.d = jSONObject2.getString("question");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            new Thread(new cp(this)).start();
            return;
        }
        try {
            jSONObject = (JSONObject) ((JSONArray) ((Map) this.b.f3799a.h.get(this.f3807a)).get("content")).get(i);
            i4 = jSONObject.getInt("id");
        } catch (Exception e2) {
            exc = e2;
            i2 = 0;
        }
        try {
            jSONArray = jSONObject.has("extra_fields") ? jSONObject.getJSONArray("extra_fields") : null;
            i3 = i4;
        } catch (Exception e3) {
            i2 = i4;
            exc = e3;
            exc.printStackTrace();
            i3 = i2;
            jSONArray = null;
            com.baidu.ufosdk.f.c.a("FeedbackInputActiviy clicked!-- product_type : " + i3 + "msgId" + this.b.f3799a.e);
            Intent intent = new Intent();
            intent.setClass(this.b.f3799a, FeedbackEditActivity.class);
            intent.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
            intent.putExtra("product_type", i3);
            if (jSONArray != null) {
            }
            intent.putExtra("msgid", this.b.f3799a.e);
            intent.putExtra("data_array", r0);
            intent.putExtra("im_content", this.b.f3799a.A);
            intent.putExtra("come_from", 0);
            this.b.f3799a.startActivity(intent);
        }
        com.baidu.ufosdk.f.c.a("FeedbackInputActiviy clicked!-- product_type : " + i3 + "msgId" + this.b.f3799a.e);
        Intent intent2 = new Intent();
        intent2.setClass(this.b.f3799a, FeedbackEditActivity.class);
        intent2.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
        intent2.putExtra("product_type", i3);
        String jSONArray2 = (jSONArray != null || jSONArray.length() <= 0) ? "" : jSONArray.toString();
        intent2.putExtra("msgid", this.b.f3799a.e);
        intent2.putExtra("data_array", jSONArray2);
        intent2.putExtra("im_content", this.b.f3799a.A);
        intent2.putExtra("come_from", 0);
        this.b.f3799a.startActivity(intent2);
    }
}
