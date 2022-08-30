package com.baidu.webkit.internal;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class Statistics implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int kTypeWhiteScreen = 12302;
    public static final int kTypeWhiteScreenForAsyncSearch = 12304;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface Client extends INoProGuard {
        boolean onCommitRecord(Record record);
    }

    /* loaded from: classes6.dex */
    public interface Record extends INoProGuard {
        int getType();

        String getUrl();

        String toJSON();
    }

    public Statistics() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
