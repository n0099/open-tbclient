package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class kl7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a extends pq6<o95> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xj7 b;
        public final /* synthetic */ Function0<Unit> c;
        public final /* synthetic */ BdUniqueId d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(xj7 xj7Var, Function0<Unit> function0, BdUniqueId bdUniqueId, Class<o95> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xj7Var, function0, bdUniqueId, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xj7Var;
            this.c = function0;
            this.d = bdUniqueId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pq6
        public void onEvent(o95 event) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (Intrinsics.areEqual(event.b(), "frs_post")) {
                    JSONObject jSONObject = (JSONObject) event.a();
                    if (jSONObject != null) {
                        str = jSONObject.optString("tid");
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        return;
                    }
                    if (this.b.l(str)) {
                        this.c.invoke();
                    }
                    this.b.h((JSONObject) event.a(), this.d);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xj7 a;
        public final /* synthetic */ Function0<Unit> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(xj7 xj7Var, Function0<Unit> function0) {
            super(2016331);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xj7Var, function0};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xj7Var;
            this.b = function0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                str = (String) data;
            } else {
                str = null;
            }
            if (str != null && this.a.d(str)) {
                this.b.invoke();
            }
        }
    }

    public kl7() {
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

    public final void a(BdUniqueId busId, xj7 feedModel, Function0<Unit> deleteCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, busId, feedModel, deleteCallback) == null) {
            Intrinsics.checkNotNullParameter(busId, "busId");
            Intrinsics.checkNotNullParameter(feedModel, "feedModel");
            Intrinsics.checkNotNullParameter(deleteCallback, "deleteCallback");
            mq6.b().b(new lq6(busId, Reflection.getOrCreateKotlinClass(zh7.class)), new a(feedModel, deleteCallback, busId, o95.class));
            b bVar = new b(feedModel, deleteCallback);
            bVar.setTag(busId);
            MessageManager.getInstance().registerListener(bVar);
        }
    }
}
