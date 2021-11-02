package com.baidu.ufosdk.ui;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes10.dex */
public final class bq implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f56842a;

    public bq(FeedbackInputActivity feedbackInputActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackInputActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56842a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        List list;
        List list2;
        List list3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            FeedbackInputActivity feedbackInputActivity = this.f56842a;
            if (feedbackInputActivity.D) {
                return;
            }
            list = feedbackInputActivity.at;
            list.remove(((Integer) view.getTag()).intValue());
            list2 = this.f56842a.at;
            if (list2.size() == 1) {
                byte[] a2 = com.baidu.ufosdk.f.m.a(this.f56842a.getApplicationContext());
                if (a2 == null) {
                    return;
                }
                list3 = this.f56842a.at;
                list3.set(0, a2);
            }
            this.f56842a.a(false);
        }
    }
}
