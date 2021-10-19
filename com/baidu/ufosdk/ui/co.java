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
/* loaded from: classes8.dex */
public final class co implements AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f59954a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ cg f59955b;

    /* renamed from: c  reason: collision with root package name */
    public int f59956c;

    /* renamed from: d  reason: collision with root package name */
    public String f59957d;

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
        this.f59955b = cgVar;
        this.f59954a = i2;
        this.f59956c = 0;
        this.f59957d = "";
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f59955b.f59943a.H) {
            return;
        }
        com.baidu.ufosdk.f.c.a("FeedbackInputActiviy --> FeedbackInput item clicked! " + i2);
        if (((Integer) ((Map) this.f59955b.f59943a.f59844h.get(this.f59954a)).get("subtype")).intValue() == 0) {
            com.baidu.ufosdk.f.c.a("FeedbackInputActiviy clicked! -- > \n" + ((Map) this.f59955b.f59943a.f59844h.get(this.f59954a)).get("content").toString());
            try {
                JSONObject jSONObject = (JSONObject) ((JSONArray) ((Map) this.f59955b.f59943a.f59844h.get(this.f59954a)).get("content")).get(i2);
                this.f59956c = jSONObject.getInt("qid");
                this.f59957d = jSONObject.getString("question");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            new Thread(new cp(this)).start();
            return;
        }
        JSONArray jSONArray = null;
        try {
            JSONObject jSONObject2 = (JSONObject) ((JSONArray) ((Map) this.f59955b.f59943a.f59844h.get(this.f59954a)).get("content")).get(i2);
            i3 = jSONObject2.getInt("id");
            try {
                if (jSONObject2.has("extra_fields")) {
                    jSONArray = jSONObject2.getJSONArray("extra_fields");
                }
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                com.baidu.ufosdk.f.c.a("FeedbackInputActiviy clicked!-- product_type : " + i3 + "msgId" + this.f59955b.f59943a.f59841e);
                Intent intent = new Intent();
                intent.setClass(this.f59955b.f59943a, FeedbackEditActivity.class);
                intent.putExtra("feedback_channel", com.baidu.ufosdk.b.f59723j);
                intent.putExtra("product_type", i3);
                if (jSONArray != null) {
                }
                intent.putExtra("msgid", this.f59955b.f59943a.f59841e);
                intent.putExtra("data_array", r6);
                intent.putExtra("im_content", this.f59955b.f59943a.A);
                intent.putExtra("come_from", 0);
                this.f59955b.f59943a.startActivity(intent);
            }
        } catch (Exception e4) {
            e = e4;
            i3 = 0;
        }
        com.baidu.ufosdk.f.c.a("FeedbackInputActiviy clicked!-- product_type : " + i3 + "msgId" + this.f59955b.f59943a.f59841e);
        Intent intent2 = new Intent();
        intent2.setClass(this.f59955b.f59943a, FeedbackEditActivity.class);
        intent2.putExtra("feedback_channel", com.baidu.ufosdk.b.f59723j);
        intent2.putExtra("product_type", i3);
        String jSONArray2 = (jSONArray != null || jSONArray.length() <= 0) ? "" : jSONArray.toString();
        intent2.putExtra("msgid", this.f59955b.f59943a.f59841e);
        intent2.putExtra("data_array", jSONArray2);
        intent2.putExtra("im_content", this.f59955b.f59943a.A);
        intent2.putExtra("come_from", 0);
        this.f59955b.f59943a.startActivity(intent2);
    }
}
