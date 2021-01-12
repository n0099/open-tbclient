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
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class eh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackReportActivity f5558a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eh(FeedbackReportActivity feedbackReportActivity) {
        this.f5558a = feedbackReportActivity;
    }

    /* JADX WARN: Incorrect condition in loop: B:8:0x0070 */
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
        list = this.f5558a.x;
        if (list.size() <= 1) {
            FeedbackReportActivity feedbackReportActivity = this.f5558a;
            Context applicationContext = this.f5558a.getApplicationContext();
            String str3 = UfoSDK.clientid;
            str2 = this.f5558a.z;
            StringBuilder append = new StringBuilder().append(com.baidu.ufosdk.b.l);
            editText3 = this.f5558a.t;
            String sb = append.append(editText3.getText().toString()).append(com.baidu.ufosdk.b.m).toString();
            editText4 = this.f5558a.u;
            String obj = editText4.getText().toString();
            handler2 = this.f5558a.K;
            feedbackReportActivity.a(applicationContext, str3, str2, sb, obj, null, handler2);
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list2.size() - 1; i++) {
            list3 = this.f5558a.x;
            jSONArray.put(Base64.encodeToString((byte[]) list3.get(i), 0));
        }
        if (jSONArray.toString().length() >= 2097152) {
            Toast.makeText(this.f5558a, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_QQFAVORITES), 0).show();
            return;
        }
        FeedbackReportActivity feedbackReportActivity2 = this.f5558a;
        Context applicationContext2 = this.f5558a.getApplicationContext();
        String str4 = UfoSDK.clientid;
        str = this.f5558a.z;
        StringBuilder append2 = new StringBuilder().append(com.baidu.ufosdk.b.l);
        editText = this.f5558a.t;
        String sb2 = append2.append(editText.getText().toString()).append(com.baidu.ufosdk.b.m).toString();
        editText2 = this.f5558a.u;
        String obj2 = editText2.getText().toString();
        String jSONArray2 = jSONArray.toString();
        handler = this.f5558a.K;
        feedbackReportActivity2.a(applicationContext2, str4, str, sb2, obj2, jSONArray2, handler);
    }
}
