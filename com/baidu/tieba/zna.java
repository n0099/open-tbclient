package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.uo9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class zna {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ShareItem a;
    public uo9 b;
    public final a c;

    /* loaded from: classes9.dex */
    public static final class a implements uo9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zna a;

        @Override // com.baidu.tieba.uo9.a
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public a(zna znaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {znaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = znaVar;
        }

        @Override // com.baidu.tieba.uo9.a
        public void a(to9 data) {
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

    public zna() {
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
        uo9 uo9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (uo9Var = this.b) != null) {
            uo9Var.c();
        }
    }

    public final void d(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, shareItem) == null) {
            Intrinsics.checkNotNullParameter(shareItem, "shareItem");
            this.a = shareItem;
            uo9 uo9Var = this.b;
            if (uo9Var != null) {
                uo9Var.a(shareItem);
            }
        }
    }

    public final void b(Context context) {
        BdUniqueId uniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            BdPageContext<?> a2 = a5.a(context);
            if (a2 != null && (uniqueId = a2.getUniqueId()) != null) {
                Intrinsics.checkNotNullExpressionValue(uniqueId, "uniqueId");
                uo9 uo9Var = new uo9(uniqueId);
                this.b = uo9Var;
                Intrinsics.checkNotNull(uo9Var);
                uo9Var.g(this.c);
            }
        }
    }
}
