package com.baidu.ufosdk.ui;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes9.dex */
public final class q implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f57964a;

    public q(FeedbackEditActivity feedbackEditActivity) {
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
        this.f57964a = feedbackEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        List list2;
        HashMap hashMap;
        List list3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            z = this.f57964a.v;
            if (z) {
                return;
            }
            list = this.f57964a.q;
            if (list.size() < 3) {
                FeedbackEditActivity feedbackEditActivity = this.f57964a;
                list2 = feedbackEditActivity.q;
                list2.size();
                FeedbackEditActivity.s(feedbackEditActivity);
                return;
            }
            com.baidu.ufosdk.f.c.a("picShotLayout3 --> to browse picture!");
            hashMap = this.f57964a.r;
            String str = (String) hashMap.get("2");
            if (str != null && str.length() != 0) {
                FeedbackEditActivity.a(this.f57964a, str, 2);
                return;
            }
            FeedbackEditActivity feedbackEditActivity2 = this.f57964a;
            list3 = feedbackEditActivity2.q;
            feedbackEditActivity2.a((byte[]) list3.get(2), false, 2);
        }
    }
}
