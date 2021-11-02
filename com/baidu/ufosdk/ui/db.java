package com.baidu.ufosdk.ui;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class db {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f56901a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f56902b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f56903c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f56904d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f56905e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f56906f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56907g;

    /* renamed from: h  reason: collision with root package name */
    public i f56908h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f56909i;
    public TextView j;

    public db() {
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
