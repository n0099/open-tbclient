package com.bun.miitmdid.supplier.h.a;

import android.database.ContentObserver;
import android.os.Handler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class c extends ContentObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f61208a;

    /* renamed from: b  reason: collision with root package name */
    public int f61209b;

    /* renamed from: c  reason: collision with root package name */
    public b f61210c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i2, String str) {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Handler) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61210c = bVar;
        this.f61209b = i2;
        this.f61208a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            b bVar = this.f61210c;
            if (bVar != null) {
                bVar.a(this.f61209b, this.f61208a);
            } else {
                com.bun.miitmdid.utils.a.b("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
            }
        }
    }
}
