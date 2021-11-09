package com.baidu.ufosdk.ui;

import android.view.View;
import android.widget.TextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes10.dex */
public final class dy implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackReportActivity f56945a;

    public dy(FeedbackReportActivity feedbackReportActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackReportActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56945a = feedbackReportActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        List list;
        List list2;
        byte[] bArr;
        List list3;
        byte[] bArr2;
        TextView textView;
        List list4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            z = this.f56945a.B;
            if (z) {
                return;
            }
            list = this.f56945a.x;
            list.remove(((Integer) view.getTag()).intValue());
            list2 = this.f56945a.x;
            if (list2.size() == 1) {
                byte[] b2 = com.baidu.ufosdk.f.m.b(this.f56945a.getApplicationContext());
                if (b2 == null) {
                    return;
                }
                list4 = this.f56945a.x;
                list4.set(0, b2);
            }
            bArr = this.f56945a.j;
            if (bArr != null) {
                list3 = this.f56945a.x;
                bArr2 = this.f56945a.j;
                if (!list3.contains(bArr2)) {
                    textView = this.f56945a.r;
                    textView.setText("上传截图");
                }
            }
            this.f56945a.c();
        }
    }
}
