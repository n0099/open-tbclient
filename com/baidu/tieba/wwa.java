package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.ar.core.InstallActivity;
import com.google.ar.core.exceptions.UnavailableException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* loaded from: classes7.dex */
public class wwa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public final /* synthetic */ InstallActivity b;

    public wwa(InstallActivity installActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {installActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = installActivity;
        this.a = false;
    }

    public void b(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
            synchronized (this.b) {
                if (this.a) {
                    return;
                }
                this.a = true;
                this.b.d = com.google.ar.core.p.CANCELLED;
                boolean z = exc instanceof UnavailableException;
                this.b.j(exc);
            }
        }
    }

    public void a(com.google.ar.core.p pVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) {
            synchronized (this.b) {
                if (!this.a) {
                    this.b.d = pVar;
                    int ordinal = pVar.ordinal();
                    if (ordinal != 0) {
                        if (ordinal == 1) {
                            this.b.j(new UnavailableUserDeclinedInstallationException());
                        } else if (ordinal == 2) {
                            z = this.b.g;
                            if (!z) {
                                this.b.i();
                            }
                            this.b.j(null);
                        }
                        this.a = true;
                    }
                }
            }
        }
    }
}
