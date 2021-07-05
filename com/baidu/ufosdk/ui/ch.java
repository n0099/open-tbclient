package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class ch implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ cg f23395a;

    public ch(cg cgVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cgVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23395a = cgVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            try {
                FeedbackInputActivity.f23290a = com.baidu.ufosdk.f.i.a(((ImageView) view).getDrawable());
                this.f23395a.f23393a.startActivity(new Intent(this.f23395a.f23393a, FeedbackImageViewFlipperActivity.class));
            } catch (Exception unused) {
            }
        }
    }
}
