package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class pm0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public String a;
    @NonNull
    public String b;
    @NonNull
    public String c;
    public Long d;
    @NonNull
    public String e;
    public boolean f;
    @Nullable
    public String g;
    @Nullable
    public String h;

    public pm0(@NonNull String str, @NonNull String str2, @NonNull Long l, @NonNull String str3, @NonNull String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, l, str3, str4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = -1L;
        this.f = false;
        this.a = str;
        this.b = str2;
        this.d = l;
        this.c = str3;
        this.e = str4;
    }
}
