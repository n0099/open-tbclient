package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public final class de extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackListActivity f60000a;

    public de(FeedbackListActivity feedbackListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackListActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60000a = feedbackListActivity;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            super.handleMessage(message);
            com.baidu.ufosdk.f.c.b("FeedbackListActivity -> msg.what = " + message.what);
            if (message.what == 0) {
                com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this.f60000a);
                dVar.d(dVar.d() + 1);
                linearLayout3 = this.f60000a.f59848b;
                linearLayout3.setVisibility(8);
                linearLayout4 = this.f60000a.f59849c;
                linearLayout4.setVisibility(0);
                this.f60000a.f59851e = (List) message.obj;
                int i2 = 0;
                while (true) {
                    list = this.f60000a.f59851e;
                    if (i2 >= list.size()) {
                        break;
                    }
                    list3 = this.f60000a.f59851e;
                    if (!((String) ((Map) list3.get(i2)).get("newmsg")).equals("0")) {
                        handler = this.f60000a.A;
                        handler.obtainMessage(2, Integer.valueOf(i2)).sendToTarget();
                        break;
                    }
                    i2++;
                }
                list2 = this.f60000a.f59851e;
                if (list2.size() == 0) {
                    textView3 = this.f60000a.s;
                    textView3.setVisibility(0);
                } else {
                    textView2 = this.f60000a.s;
                    textView2.setVisibility(8);
                }
                duVar = this.f60000a.u;
                duVar.notifyDataSetChanged();
            }
            if (message.what == 1) {
                linearLayout = this.f60000a.f59849c;
                linearLayout.setVisibility(8);
                Context applicationContext = this.f60000a.getApplicationContext();
                textView = this.f60000a.f59850d;
                com.baidu.ufosdk.f.i.a(applicationContext, textView);
                linearLayout2 = this.f60000a.f59848b;
                linearLayout2.setVisibility(0);
                view = this.f60000a.v;
                view.setVisibility(8);
            }
            if (message.what == 2) {
                listView = this.f60000a.t;
                listView.setSelection(Integer.parseInt(message.obj.toString()));
            }
        }
    }
}
