package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import android.util.Base64;
import android.widget.EditText;
import android.widget.Toast;
import com.baidu.ufosdk.UfoSDK;
import com.tencent.connect.common.Constants;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public final class eh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackReportActivity f22897a;

    public eh(FeedbackReportActivity feedbackReportActivity) {
        this.f22897a = feedbackReportActivity;
    }

    /* JADX WARN: Incorrect condition in loop: B:8:0x006a */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        List list;
        List list2;
        String str;
        EditText editText;
        EditText editText2;
        Handler handler;
        List list3;
        String str2;
        EditText editText3;
        EditText editText4;
        Handler handler2;
        list = this.f22897a.x;
        if (list.size() <= 1) {
            FeedbackReportActivity feedbackReportActivity = this.f22897a;
            Context applicationContext = feedbackReportActivity.getApplicationContext();
            String str3 = UfoSDK.clientid;
            str2 = this.f22897a.z;
            StringBuilder sb = new StringBuilder();
            sb.append(com.baidu.ufosdk.b.l);
            editText3 = this.f22897a.t;
            sb.append(editText3.getText().toString());
            sb.append(com.baidu.ufosdk.b.m);
            String sb2 = sb.toString();
            editText4 = this.f22897a.u;
            String obj = editText4.getText().toString();
            handler2 = this.f22897a.K;
            feedbackReportActivity.a(applicationContext, str3, str2, sb2, obj, null, handler2);
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list2.size() - 1; i++) {
            list3 = this.f22897a.x;
            jSONArray.put(Base64.encodeToString((byte[]) list3.get(i), 0));
        }
        if (jSONArray.toString().length() >= 2097152) {
            Toast.makeText(this.f22897a, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_QQFAVORITES), 0).show();
            return;
        }
        FeedbackReportActivity feedbackReportActivity2 = this.f22897a;
        Context applicationContext2 = feedbackReportActivity2.getApplicationContext();
        String str4 = UfoSDK.clientid;
        str = this.f22897a.z;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(com.baidu.ufosdk.b.l);
        editText = this.f22897a.t;
        sb3.append(editText.getText().toString());
        sb3.append(com.baidu.ufosdk.b.m);
        String sb4 = sb3.toString();
        editText2 = this.f22897a.u;
        String obj2 = editText2.getText().toString();
        String jSONArray2 = jSONArray.toString();
        handler = this.f22897a.K;
        feedbackReportActivity2.a(applicationContext2, str4, str, sb4, obj2, jSONArray2, handler);
    }
}
