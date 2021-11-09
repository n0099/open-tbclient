package com.baidu.ufosdk.ui;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class bm implements eu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ er f56835a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f56836b;

    public bm(FeedbackInputActivity feedbackInputActivity, er erVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackInputActivity, erVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56836b = feedbackInputActivity;
        this.f56835a = erVar;
    }

    @Override // com.baidu.ufosdk.ui.eu
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f56835a.dismiss();
            this.f56836b.s.setVisibility(0);
            this.f56836b.s.bringToFront();
            new Thread(new bp(this)).start();
        }
    }

    @Override // com.baidu.ufosdk.ui.eu
    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (str == null || str.trim().length() == 0) {
                this.f56835a.dismiss();
                FeedbackInputActivity feedbackInputActivity = this.f56836b;
                feedbackInputActivity.D = true;
                feedbackInputActivity.J.setTextColor(com.baidu.ufosdk.b.y);
                this.f56836b.E.setEnabled(false);
                this.f56836b.s.setVisibility(0);
                this.f56836b.s.bringToFront();
                new Thread(new bo(this)).start();
                return;
            }
            this.f56835a.dismiss();
            FeedbackInputActivity feedbackInputActivity2 = this.f56836b;
            feedbackInputActivity2.D = true;
            feedbackInputActivity2.J.setTextColor(com.baidu.ufosdk.b.y);
            this.f56836b.E.setEnabled(false);
            this.f56836b.s.setVisibility(0);
            this.f56836b.s.bringToFront();
            new Thread(new bn(this, str)).start();
        }
    }
}
