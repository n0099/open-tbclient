package com.baidu.tieba.statemachine.base;

import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.aw9;
import com.baidu.tieba.bw9;
import com.baidu.tieba.cw9;
import com.baidu.tieba.dw9;
import com.baidu.tieba.wq8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0016\u001a\u00020\u000fJ\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR#\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0011\"\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/baidu/tieba/statemachine/base/BaseStateMachine;", "", "baseStateMap", "Lcom/baidu/tieba/statemachine/base/BaseStateMap;", "(Lcom/baidu/tieba/statemachine/base/BaseStateMap;)V", "curState", "Lcom/baidu/tieba/statemachine/base/State;", "getCurState", "()Lcom/baidu/tieba/statemachine/base/State;", "setCurState", "(Lcom/baidu/tieba/statemachine/base/State;)V", "doAction", "Lkotlin/Function1;", "", "Lcom/baidu/tieba/statemachine/base/Action;", "", "getDoAction", "()Lkotlin/jvm/functions/Function1;", "stateChangedListener", "getStateChangedListener", "setStateChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "reInit", "sendEvent", "event", "Lcom/baidu/tieba/statemachine/base/Event;", "start", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public class BaseStateMachine {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final bw9 a;
    public dw9 b;
    public Function1<? super dw9, Unit> c;
    public final Function1<List<aw9>, Unit> d;

    public BaseStateMachine(bw9 baseStateMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseStateMap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(baseStateMap, "baseStateMap");
        this.a = baseStateMap;
        this.b = baseStateMap.a();
        this.d = BaseStateMachine$doAction$1.INSTANCE;
    }

    public final dw9 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (dw9) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b = this.a.a();
            wq8 defaultLog = DefaultLog.getInstance();
            defaultLog.b("State Machine", "State Machine ReInt! Start State: " + this.b.getClass().getSimpleName());
        }
    }

    public final void c(cw9 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            HashMap<cw9, dw9> hashMap = this.a.getMap().get(this.b);
            if (hashMap == null) {
                DefaultLog.getInstance().b("State Machine", "Illegal state!");
                return;
            }
            dw9 dw9Var = hashMap.get(event);
            if (dw9Var == null) {
                DefaultLog.getInstance().b("State Machine", "Illegal event!");
                return;
            }
            wq8 defaultLog = DefaultLog.getInstance();
            defaultLog.b("State Machine", "Current State: " + this.b.getClass().getSimpleName() + "  Current Event: " + event.getClass().getSimpleName());
            this.d.invoke(event.a());
            this.b = dw9Var;
            wq8 defaultLog2 = DefaultLog.getInstance();
            defaultLog2.b("State Machine", "Next State: " + this.b.getClass().getSimpleName());
            this.d.invoke(this.b.b());
            Function1<? super dw9, Unit> function1 = this.c;
            if (function1 != null) {
                function1.invoke(this.b);
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.d.invoke(this.b.b());
            Function1<? super dw9, Unit> function1 = this.c;
            if (function1 != null) {
                function1.invoke(this.b);
            }
            wq8 defaultLog = DefaultLog.getInstance();
            defaultLog.b("State Machine", "Start State: " + this.b.getClass().getSimpleName());
        }
    }
}
