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
/* loaded from: classes8.dex */
final class de extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackListActivity f5525a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public de(FeedbackListActivity feedbackListActivity) {
        this.f5525a = feedbackListActivity;
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
            com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this.f5525a);
            dVar.d(dVar.d() + 1);
            linearLayout3 = this.f5525a.f5419b;
            linearLayout3.setVisibility(8);
            linearLayout4 = this.f5525a.c;
            linearLayout4.setVisibility(0);
            this.f5525a.e = (List) message.obj;
            int i = 0;
            while (true) {
                list = this.f5525a.e;
                if (i >= list.size()) {
                    break;
                }
                list3 = this.f5525a.e;
                if (!((String) ((Map) list3.get(i)).get("newmsg")).equals("0")) {
                    handler = this.f5525a.A;
                    handler.obtainMessage(2, Integer.valueOf(i)).sendToTarget();
                    break;
                }
                i++;
            }
            list2 = this.f5525a.e;
            if (list2.size() == 0) {
                textView3 = this.f5525a.s;
                textView3.setVisibility(0);
            } else {
                textView2 = this.f5525a.s;
                textView2.setVisibility(8);
            }
            duVar = this.f5525a.u;
            duVar.notifyDataSetChanged();
        }
        if (message.what == 1) {
            linearLayout = this.f5525a.c;
            linearLayout.setVisibility(8);
            Context applicationContext = this.f5525a.getApplicationContext();
            textView = this.f5525a.d;
            com.baidu.ufosdk.f.i.a(applicationContext, textView);
            linearLayout2 = this.f5525a.f5419b;
            linearLayout2.setVisibility(0);
            view = this.f5525a.v;
            view.setVisibility(8);
        }
        if (message.what == 2) {
            listView = this.f5525a.t;
            listView.setSelection(Integer.parseInt(message.obj.toString()));
        }
    }
}
