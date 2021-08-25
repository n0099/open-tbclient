package com.baidu.ufosdk.ui;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class df implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f59655a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f59656b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f59657c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FeedbackListActivity f59658d;

    public df(FeedbackListActivity feedbackListActivity, Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackListActivity, context, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59658d = feedbackListActivity;
        this.f59655a = context;
        this.f59656b = str;
        this.f59657c = str2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View view2;
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            view2 = this.f59658d.w;
            view2.setVisibility(0);
            new Thread(new dg(this)).start();
            popupWindow = this.f59658d.z;
            if (popupWindow.isShowing()) {
                popupWindow2 = this.f59658d.z;
                popupWindow2.dismiss();
            }
        }
    }
}
