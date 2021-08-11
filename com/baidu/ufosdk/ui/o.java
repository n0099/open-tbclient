package com.baidu.ufosdk.ui;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public final class o implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f59579a;

    public o(FeedbackEditActivity feedbackEditActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackEditActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59579a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        HashMap hashMap;
        List list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            z = this.f59579a.v;
            if (z) {
                return;
            }
            list = this.f59579a.q;
            if (list.size() <= 0) {
                FeedbackEditActivity.s(this.f59579a);
                return;
            }
            com.baidu.ufosdk.f.c.a("picShotLayout1--> to browse picture!");
            hashMap = this.f59579a.r;
            String str = (String) hashMap.get("0");
            if (str != null && str.length() != 0) {
                FeedbackEditActivity.a(this.f59579a, str, 0);
                return;
            }
            FeedbackEditActivity feedbackEditActivity = this.f59579a;
            list2 = feedbackEditActivity.q;
            feedbackEditActivity.a((byte[]) list2.get(0), false, 0);
        }
    }
}
