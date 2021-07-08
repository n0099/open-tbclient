package com.baidu.ufosdk.ui;

import android.view.View;
import android.widget.TextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public final class dy implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackReportActivity f23587a;

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
        this.f23587a = feedbackReportActivity;
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
            z = this.f23587a.B;
            if (z) {
                return;
            }
            list = this.f23587a.x;
            list.remove(((Integer) view.getTag()).intValue());
            list2 = this.f23587a.x;
            if (list2.size() == 1) {
                byte[] b2 = com.baidu.ufosdk.f.m.b(this.f23587a.getApplicationContext());
                if (b2 == null) {
                    return;
                }
                list4 = this.f23587a.x;
                list4.set(0, b2);
            }
            bArr = this.f23587a.j;
            if (bArr != null) {
                list3 = this.f23587a.x;
                bArr2 = this.f23587a.j;
                if (!list3.contains(bArr2)) {
                    textView = this.f23587a.r;
                    textView.setText("上传截图");
                }
            }
            this.f23587a.c();
        }
    }
}
