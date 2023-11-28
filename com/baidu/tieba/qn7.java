package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class qn7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static final class a extends ar6<t95> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ql7 b;
        public final /* synthetic */ Function0<Unit> c;
        public final /* synthetic */ BdUniqueId d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ql7 ql7Var, Function0<Unit> function0, BdUniqueId bdUniqueId, Class<t95> cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ql7Var, function0, bdUniqueId, cls};
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
            this.b = ql7Var;
            this.c = function0;
            this.d = bdUniqueId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ar6
        public void onEvent(t95 event) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
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
                    if (this.b.m(str)) {
                        this.c.invoke();
                    }
                    this.b.h((JSONObject) event.a(), this.d);
                } else if (Intrinsics.areEqual(event.b(), "frs_fun_ad")) {
                    this.c.invoke();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ql7 a;
        public final /* synthetic */ Function0<Unit> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ql7 ql7Var, Function0<Unit> function0) {
            super(2016331);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ql7Var, function0};
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
            this.a = ql7Var;
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

    public qn7() {
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

    public final void a(BdUniqueId busId, ql7 feedModel, Function0<Unit> deleteCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, busId, feedModel, deleteCallback) == null) {
            Intrinsics.checkNotNullParameter(busId, "busId");
            Intrinsics.checkNotNullParameter(feedModel, "feedModel");
            Intrinsics.checkNotNullParameter(deleteCallback, "deleteCallback");
            xq6.b().b(new wq6(busId, Reflection.getOrCreateKotlinClass(oj7.class)), new a(feedModel, deleteCallback, busId, t95.class));
            b bVar = new b(feedModel, deleteCallback);
            bVar.setTag(busId);
            MessageManager.getInstance().registerListener(bVar);
        }
    }
}
