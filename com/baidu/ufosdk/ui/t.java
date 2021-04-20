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
public final class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f22983a;

    public t(FeedbackEditActivity feedbackEditActivity) {
        this.f22983a = feedbackEditActivity;
    }

    /* JADX WARN: Incorrect condition in loop: B:7:0x006a */
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
        list = this.f22983a.q;
        boolean z = false;
        if (list.size() <= 0) {
            FeedbackEditActivity feedbackEditActivity = this.f22983a;
            Context applicationContext = feedbackEditActivity.getApplicationContext();
            String str3 = UfoSDK.clientid;
            str2 = this.f22983a.t;
            StringBuilder sb = new StringBuilder();
            sb.append(com.baidu.ufosdk.b.l);
            editText3 = this.f22983a.m;
            sb.append(editText3.getText().toString());
            sb.append(com.baidu.ufosdk.b.m);
            String sb2 = sb.toString();
            editText4 = this.f22983a.n;
            String obj = editText4.getText().toString();
            handler3 = this.f22983a.af;
            z = feedbackEditActivity.a(applicationContext, str3, str2, sb2, obj, null, handler3);
        } else {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < list2.size(); i++) {
                list3 = this.f22983a.q;
                jSONArray.put(Base64.encodeToString((byte[]) list3.get(i), 0));
            }
            if (jSONArray.toString().length() < 2097152) {
                FeedbackEditActivity feedbackEditActivity2 = this.f22983a;
                Context applicationContext2 = feedbackEditActivity2.getApplicationContext();
                String str4 = UfoSDK.clientid;
                str = this.f22983a.t;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(com.baidu.ufosdk.b.l);
                editText = this.f22983a.m;
                sb3.append(editText.getText().toString());
                sb3.append(com.baidu.ufosdk.b.m);
                String sb4 = sb3.toString();
                editText2 = this.f22983a.n;
                String obj2 = editText2.getText().toString();
                String jSONArray2 = jSONArray.toString();
                handler = this.f22983a.af;
                z = feedbackEditActivity2.a(applicationContext2, str4, str, sb4, obj2, jSONArray2, handler);
            } else {
                Toast.makeText(this.f22983a, com.baidu.ufosdk.f.s.a(Constants.VIA_REPORT_TYPE_QQFAVORITES), 0).show();
            }
        }
        if (z) {
            return;
        }
        handler2 = this.f22983a.af;
        handler2.obtainMessage(13).sendToTarget();
    }
}
