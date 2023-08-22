package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog.impl.ResponsesPanelControllerImpl;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.data.Reaction;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class xl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ResponsesPanelControllerImpl a;
    public List<Reaction> b;

    /* loaded from: classes8.dex */
    public static final class a implements eo5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xl8 a;
        public final /* synthetic */ int b;

        public a(xl8 xl8Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xl8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xl8Var;
            this.b = i;
        }

        @Override // com.baidu.tieba.eo5
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
                        this.a.b().i(arrayList);
                    }
                } else {
                    Intrinsics.checkNotNull(list);
                    for (String str : list) {
                        arrayList.add(new Reaction("", str));
                    }
                }
                this.a.b().i(arrayList);
            }
        }
    }

    public xl8(ResponsesPanelControllerImpl controller) {
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

    public final void c(fn8 process, Reaction reaction, BaseMsg msg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, process, reaction, msg) == null) {
            Intrinsics.checkNotNullParameter(process, "process");
            Intrinsics.checkNotNullParameter(reaction, "reaction");
            Intrinsics.checkNotNullParameter(msg, "msg");
            go8.g(process, reaction, msg, 1);
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            int abs = Math.abs(1 - go8.a());
            on5.b().e(context, true, -abs, new a(this, abs));
        }
    }

    public final void e(List<Reaction> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.b = list;
        }
    }
}
