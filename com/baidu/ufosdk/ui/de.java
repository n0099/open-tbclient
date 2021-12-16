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
/* loaded from: classes13.dex */
public final class de extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ FeedbackListActivity a;

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
        this.a = feedbackListActivity;
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
                com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this.a);
                dVar.d(dVar.d() + 1);
                linearLayout3 = this.a.f52163b;
                linearLayout3.setVisibility(8);
                linearLayout4 = this.a.f52164c;
                linearLayout4.setVisibility(0);
                this.a.f52166e = (List) message.obj;
                int i2 = 0;
                while (true) {
                    list = this.a.f52166e;
                    if (i2 >= list.size()) {
                        break;
                    }
                    list3 = this.a.f52166e;
                    if (!((String) ((Map) list3.get(i2)).get("newmsg")).equals("0")) {
                        handler = this.a.A;
                        handler.obtainMessage(2, Integer.valueOf(i2)).sendToTarget();
                        break;
                    }
                    i2++;
                }
                list2 = this.a.f52166e;
                if (list2.size() == 0) {
                    textView3 = this.a.s;
                    textView3.setVisibility(0);
                } else {
                    textView2 = this.a.s;
                    textView2.setVisibility(8);
                }
                duVar = this.a.u;
                duVar.notifyDataSetChanged();
            }
            if (message.what == 1) {
                linearLayout = this.a.f52164c;
                linearLayout.setVisibility(8);
                Context applicationContext = this.a.getApplicationContext();
                textView = this.a.f52165d;
                com.baidu.ufosdk.f.i.a(applicationContext, textView);
                linearLayout2 = this.a.f52163b;
                linearLayout2.setVisibility(0);
                view = this.a.v;
                view.setVisibility(8);
            }
            if (message.what == 2) {
                listView = this.a.t;
                listView.setSelection(Integer.parseInt(message.obj.toString()));
            }
        }
    }
}
