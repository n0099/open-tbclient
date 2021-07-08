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
/* loaded from: classes5.dex */
public final class da {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f23535a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f23536b;

    /* renamed from: c  reason: collision with root package name */
    public ListView f23537c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f23538d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f23539e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f23540f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f23541g;

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
