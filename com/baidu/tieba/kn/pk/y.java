package com.baidu.tieba.kn.pk;

import android.view.View;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public String f1309a;
    public int b;
    public long c;
    public long d;
    public boolean e;
    public View f;

    public y a(JSONObject jSONObject) {
        this.f1309a = jSONObject.optString("user_name");
        this.b = jSONObject.optInt("vote_number");
        this.c = jSONObject.optLong("time");
        return this;
    }

    public static LinkedList<y> a(JSONArray jSONArray) {
        LinkedList<y> linkedList = new LinkedList<>();
        if (jSONArray == null) {
            return linkedList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                linkedList.addLast(new y().a(optJSONObject));
            }
        }
        return linkedList;
    }
}
