package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.data.Reaction;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog.impl.ResponsesPanelControllerImpl;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class zr8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ResponsesPanelControllerImpl a;
    public List<Reaction> b;

    /* loaded from: classes9.dex */
    public static final class a implements bp5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zr8 a;
        public final /* synthetic */ int b;

        public a(zr8 zr8Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zr8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zr8Var;
            this.b = i;
        }

        @Override // com.baidu.tieba.bp5
        public void a(List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                ArrayList arrayList = new ArrayList();
                if (ListUtils.isEmpty(list)) {
                    if (!ListUtils.isEmpty(this.a.a())) {
                        List<Reaction> a = this.a.a();
                        Intrinsics.checkNotNull(a);
                        int size = a.size();
                        if (size > this.b) {
                            List<Reaction> a2 = this.a.a();
                            Intrinsics.checkNotNull(a2);
                            arrayList.addAll(a2.subList(0, this.b));
                        } else {
                            List<Reaction> a3 = this.a.a();
                            Intrinsics.checkNotNull(a3);
                            arrayList.addAll(a3.subList(0, size));
                        }
                        this.a.b().g(arrayList);
                    }
                } else {
                    Intrinsics.checkNotNull(list);
                    for (String str : list) {
                        arrayList.add(new Reaction("", str));
                    }
                }
                this.a.b().g(arrayList);
            }
        }
    }

    public zr8(ResponsesPanelControllerImpl controller) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {controller};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.a = controller;
    }

    public final List<Reaction> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public final ResponsesPanelControllerImpl b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (ResponsesPanelControllerImpl) invokeV.objValue;
    }

    public final void c(tf8 process, Reaction reaction, BaseItem<? extends TbBaseMsg> msg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, process, reaction, msg) == null) {
            Intrinsics.checkNotNullParameter(process, "process");
            Intrinsics.checkNotNullParameter(reaction, "reaction");
            Intrinsics.checkNotNullParameter(msg, "msg");
            oo8.g(process, reaction, msg, 1);
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            int abs = Math.abs(1 - oo8.a());
            lo5.b().e(context, true, -abs, new a(this, abs));
        }
    }

    public final void e(List<Reaction> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.b = list;
        }
    }
}
