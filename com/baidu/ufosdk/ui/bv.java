package com.baidu.ufosdk.ui;

import android.text.ClipboardManager;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class bv implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f56847a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PopupWindow f56848b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f56849c;

    public bv(FeedbackInputActivity feedbackInputActivity, View view, PopupWindow popupWindow) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackInputActivity, view, popupWindow};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56849c = feedbackInputActivity;
        this.f56847a = view;
        this.f56848b = popupWindow;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            ((ClipboardManager) this.f56849c.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setText(((TextView) this.f56847a).getText().toString());
            this.f56848b.dismiss();
        }
    }
}
