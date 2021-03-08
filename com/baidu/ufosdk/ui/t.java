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
public final class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackEditActivity f3795a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FeedbackEditActivity feedbackEditActivity) {
        this.f3795a = feedbackEditActivity;
    }

    /* JADX WARN: Incorrect condition in loop: B:10:0x007f */
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
        Handler handler2;
        String str2;
        EditText editText3;
        EditText editText4;
        Handler handler3;
        boolean z = false;
        list = this.f3795a.q;
        if (list.size() <= 0) {
            FeedbackEditActivity feedbackEditActivity = this.f3795a;
            Context applicationContext = this.f3795a.getApplicationContext();
            String str3 = UfoSDK.clientid;
            str2 = this.f3795a.t;
            StringBuilder append = new StringBuilder().append(com.baidu.ufosdk.b.l);
            editText3 = this.f3795a.m;
            String sb = append.append(editText3.getText().toString()).append(com.baidu.ufosdk.b.m).toString();
            editText4 = this.f3795a.n;
            String obj = editText4.getText().toString();
            handler3 = this.f3795a.af;
            z = feedbackEditActivity.a(applicationContext, str3, str2, sb, obj, null, handler3);
        } else {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < list2.size(); i++) {
                list3 = this.f3795a.q;
                jSONArray.put(Base64.encodeToString((byte[]) list3.get(i), 0));
            }
            if (jSONArray.toString().length() < 2097152) {
                FeedbackEditActivity feedbackEditActivity2 = this.f3795a;
                Context applicationContext2 = this.f3795a.getApplicationContext();
                String str4 = UfoSDK.clientid;
                str = this.f3795a.t;
                StringBuilder append2 = new StringBuilder().append(com.baidu.ufosdk.b.l);
                editText = this.f3795a.m;
                String sb2 = append2.append(editText.getText().toString()).append(com.baidu.ufosdk.b.m).toString();
                editText2 = this.f3795a.n;
                String obj2 = editText2.getText().toString();
                String jSONArray2 = jSONArray.toString();
                handler = this.f3795a.af;
                z = feedbackEditActivity2.a(applicationContext2, str4, str, sb2, obj2, jSONArray2, handler);
            } else {
                Toast.makeText(this.f3795a, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_QQFAVORITES), 0).show();
            }
        }
        if (z) {
            return;
        }
        handler2 = this.f3795a.af;
        handler2.obtainMessage(13).sendToTarget();
    }
}
