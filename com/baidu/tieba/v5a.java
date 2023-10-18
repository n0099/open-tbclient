package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.t79;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class v5a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ShareItem a;
    public t79 b;
    public final a c;

    /* loaded from: classes8.dex */
    public static final class a implements t79.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v5a a;

        @Override // com.baidu.tieba.t79.a
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public a(v5a v5aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v5aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v5aVar;
        }

        @Override // com.baidu.tieba.t79.a
        public void a(s79 data) {
            boolean z;
            ShareItem shareItem;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                String a = data.a();
                if (a.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z && (shareItem = this.a.a) != null) {
                    shareItem.setShareToken(a);
                }
            }
        }
    }

    public v5a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new a(this);
    }

    public final void c() {
        t79 t79Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (t79Var = this.b) != null) {
            t79Var.c();
        }
    }

    public final void d(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, shareItem) == null) {
            Intrinsics.checkNotNullParameter(shareItem, "shareItem");
            this.a = shareItem;
            t79 t79Var = this.b;
            if (t79Var != null) {
                t79Var.a(shareItem);
            }
        }
    }

    public final void b(Context context) {
        BdUniqueId uniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            BdPageContext<?> a2 = k4.a(context);
            if (a2 != null && (uniqueId = a2.getUniqueId()) != null) {
                Intrinsics.checkNotNullExpressionValue(uniqueId, "uniqueId");
                t79 t79Var = new t79(uniqueId);
                this.b = t79Var;
                Intrinsics.checkNotNull(t79Var);
                t79Var.g(this.c);
            }
        }
    }
}
