package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class co implements AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f57794a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ cg f57795b;

    /* renamed from: c  reason: collision with root package name */
    public int f57796c;

    /* renamed from: d  reason: collision with root package name */
    public String f57797d;

    public co(cg cgVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cgVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57795b = cgVar;
        this.f57794a = i2;
        this.f57796c = 0;
        this.f57797d = "";
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i2, long j) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f57795b.f57783a.H) {
            return;
        }
        com.baidu.ufosdk.f.c.a("FeedbackInputActiviy --> FeedbackInput item clicked! " + i2);
        if (((Integer) ((Map) this.f57795b.f57783a.f57687h.get(this.f57794a)).get("subtype")).intValue() == 0) {
            com.baidu.ufosdk.f.c.a("FeedbackInputActiviy clicked! -- > \n" + ((Map) this.f57795b.f57783a.f57687h.get(this.f57794a)).get("content").toString());
            try {
                JSONObject jSONObject = (JSONObject) ((JSONArray) ((Map) this.f57795b.f57783a.f57687h.get(this.f57794a)).get("content")).get(i2);
                this.f57796c = jSONObject.getInt("qid");
                this.f57797d = jSONObject.getString("question");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            new Thread(new cp(this)).start();
            return;
        }
        JSONArray jSONArray = null;
        try {
            JSONObject jSONObject2 = (JSONObject) ((JSONArray) ((Map) this.f57795b.f57783a.f57687h.get(this.f57794a)).get("content")).get(i2);
            i3 = jSONObject2.getInt("id");
            try {
                if (jSONObject2.has("extra_fields")) {
                    jSONArray = jSONObject2.getJSONArray("extra_fields");
                }
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                com.baidu.ufosdk.f.c.a("FeedbackInputActiviy clicked!-- product_type : " + i3 + "msgId" + this.f57795b.f57783a.f57684e);
                Intent intent = new Intent();
                intent.setClass(this.f57795b.f57783a, FeedbackEditActivity.class);
                intent.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
                intent.putExtra("product_type", i3);
                if (jSONArray != null) {
                }
                intent.putExtra("msgid", this.f57795b.f57783a.f57684e);
                intent.putExtra("data_array", r6);
                intent.putExtra("im_content", this.f57795b.f57783a.A);
                intent.putExtra("come_from", 0);
                this.f57795b.f57783a.startActivity(intent);
            }
        } catch (Exception e4) {
            e = e4;
            i3 = 0;
        }
        com.baidu.ufosdk.f.c.a("FeedbackInputActiviy clicked!-- product_type : " + i3 + "msgId" + this.f57795b.f57783a.f57684e);
        Intent intent2 = new Intent();
        intent2.setClass(this.f57795b.f57783a, FeedbackEditActivity.class);
        intent2.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
        intent2.putExtra("product_type", i3);
        String jSONArray2 = (jSONArray != null || jSONArray.length() <= 0) ? "" : jSONArray.toString();
        intent2.putExtra("msgid", this.f57795b.f57783a.f57684e);
        intent2.putExtra("data_array", jSONArray2);
        intent2.putExtra("im_content", this.f57795b.f57783a.A);
        intent2.putExtra("come_from", 0);
        this.f57795b.f57783a.startActivity(intent2);
    }
}
