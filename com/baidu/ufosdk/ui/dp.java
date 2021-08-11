package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public final class dp implements AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackListActivity f59468a;

    public dp(FeedbackListActivity feedbackListActivity) {
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
        this.f59468a = feedbackListActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        List list;
        du duVar;
        List list2;
        List list3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            list = this.f59468a.f59305e;
            ((Map) list.get(i2)).put("newmsg", "0");
            duVar = this.f59468a.u;
            duVar.notifyDataSetChanged();
            Intent intent = new Intent();
            intent.setClass(this.f59468a, FeedbackInputActivity.class);
            list2 = this.f59468a.f59305e;
            intent.putExtra("msgid", (String) ((Map) list2.get(i2)).get("id"));
            list3 = this.f59468a.f59305e;
            intent.putExtra("appid", (String) ((Map) list3.get(i2)).get("appid"));
            intent.putExtra("fromList", true);
            intent.putExtra("fromEdit", false);
            if (com.baidu.ufosdk.f.h.a()) {
                return;
            }
            this.f59468a.startActivity(intent);
        }
    }
}
