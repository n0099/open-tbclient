package com.baidu.ufosdk.ui;

import android.widget.TextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class dt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f56936a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f56937b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f56938c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f56939d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ FeedbackListActivity f56940e;

    public dt(FeedbackListActivity feedbackListActivity) {
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
        this.f56940e = feedbackListActivity;
    }
}
