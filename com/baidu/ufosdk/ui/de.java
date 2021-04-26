package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class de extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackListActivity f23574a;

    public de(FeedbackListActivity feedbackListActivity) {
        this.f23574a = feedbackListActivity;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        ListView listView;
        LinearLayout linearLayout;
        TextView textView;
        LinearLayout linearLayout2;
        View view;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        List list;
        List list2;
        TextView textView2;
        du duVar;
        TextView textView3;
        List list3;
        Handler handler;
        super.handleMessage(message);
        com.baidu.ufosdk.f.c.b("FeedbackListActivity -> msg.what = " + message.what);
        if (message.what == 0) {
            com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this.f23574a);
            dVar.d(dVar.d() + 1);
            linearLayout3 = this.f23574a.f23425b;
            linearLayout3.setVisibility(8);
            linearLayout4 = this.f23574a.f23426c;
            linearLayout4.setVisibility(0);
            this.f23574a.f23428e = (List) message.obj;
            int i2 = 0;
            while (true) {
                list = this.f23574a.f23428e;
                if (i2 >= list.size()) {
                    break;
                }
                list3 = this.f23574a.f23428e;
                if (!((String) ((Map) list3.get(i2)).get("newmsg")).equals("0")) {
                    handler = this.f23574a.A;
                    handler.obtainMessage(2, Integer.valueOf(i2)).sendToTarget();
                    break;
                }
                i2++;
            }
            list2 = this.f23574a.f23428e;
            if (list2.size() == 0) {
                textView3 = this.f23574a.s;
                textView3.setVisibility(0);
            } else {
                textView2 = this.f23574a.s;
                textView2.setVisibility(8);
            }
            duVar = this.f23574a.u;
            duVar.notifyDataSetChanged();
        }
        if (message.what == 1) {
            linearLayout = this.f23574a.f23426c;
            linearLayout.setVisibility(8);
            Context applicationContext = this.f23574a.getApplicationContext();
            textView = this.f23574a.f23427d;
            com.baidu.ufosdk.f.i.a(applicationContext, textView);
            linearLayout2 = this.f23574a.f23425b;
            linearLayout2.setVisibility(0);
            view = this.f23574a.v;
            view.setVisibility(8);
        }
        if (message.what == 2) {
            listView = this.f23574a.t;
            listView.setSelection(Integer.parseInt(message.obj.toString()));
        }
    }
}
