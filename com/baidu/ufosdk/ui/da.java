package com.baidu.ufosdk.ui;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public final class da {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f52210b;

    /* renamed from: c  reason: collision with root package name */
    public ListView f52211c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f52212d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f52213e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f52214f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f52215g;

    public da() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
