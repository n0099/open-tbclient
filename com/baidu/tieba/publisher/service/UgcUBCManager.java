package com.baidu.tieba.publisher.service;

import android.util.Log;
import com.baidu.ubc.Flow;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class UgcUBCManager implements com.baidu.ubc.a {
    @Override // com.baidu.ubc.a
    public void onEvent(String str) {
    }

    @Override // com.baidu.ubc.a
    public void onEvent(String str, String str2) {
        Log.d("UgcUBCManager", "onEvent id:" + str + " value:" + str2);
    }

    @Override // com.baidu.ubc.a
    public void k(String str, JSONObject jSONObject) {
    }

    @Override // com.baidu.ubc.a
    public Flow GT(String str) {
        return new FlowExt(str);
    }

    @Override // com.baidu.ubc.a
    public Flow p(String str, JSONObject jSONObject) {
        return null;
    }

    @Override // com.baidu.ubc.a
    public void a(Flow flow) {
        ((FlowExt) flow).cyx();
    }

    @Override // com.baidu.ubc.a
    public void a(Flow flow, String str, String str2) {
    }

    @Override // com.baidu.ubc.a
    public void a(Flow flow, String str, String str2, long j) {
    }

    @Override // com.baidu.ubc.a
    public void a(Flow flow, String str) {
    }

    @Override // com.baidu.ubc.a
    public void a(Flow flow, Map<String, String> map) {
    }

    @Override // com.baidu.ubc.a
    public void b(Flow flow, String str) {
        ((FlowExt) flow).GU(str);
    }

    @Override // com.baidu.ubc.a
    public void a(Flow flow, String str, JSONObject jSONObject) {
    }

    @Override // com.baidu.ubc.a
    public void c(Flow flow, String str) {
    }

    @Override // com.baidu.ubc.a
    public void b(Flow flow) {
    }

    /* loaded from: classes11.dex */
    class FlowExt extends Flow {
        public String id;

        private void Ly() {
            Log.d("UgcUBCManager", "Flow id:" + this.id + " beginFlow");
        }

        public void GU(String str) {
            Log.d("UgcUBCManager", "Flow id:" + this.id + " setValueWithDuration value:" + str);
        }

        public void cyx() {
            Log.d("UgcUBCManager", "Flow id:" + this.id + " endFlow");
        }

        public FlowExt(String str) {
            this.id = str;
            Ly();
        }
    }
}
