package com.baidu.tieba.statemachine.base;

import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.jca;
import com.baidu.tieba.kca;
import com.baidu.tieba.lca;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.mca;
import com.baidu.tieba.nca;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0013J\b\u0010\u0016\u001a\u00020\u000fH\u0002J\u0006\u0010\u0017\u001a\u00020\u000fJ\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0013J\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR#\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/baidu/tieba/statemachine/base/BaseStateMachine;", "", "baseStateMap", "Lcom/baidu/tieba/statemachine/base/BaseStateMap;", "(Lcom/baidu/tieba/statemachine/base/BaseStateMap;)V", "curState", "Lcom/baidu/tieba/statemachine/base/State;", "getCurState", "()Lcom/baidu/tieba/statemachine/base/State;", "setCurState", "(Lcom/baidu/tieba/statemachine/base/State;)V", "doAction", "Lkotlin/Function1;", "", "Lcom/baidu/tieba/statemachine/base/Action;", "", "getDoAction", "()Lkotlin/jvm/functions/Function1;", "stateChangedListeners", "Lcom/baidu/tieba/statemachine/base/OnStateChangedListener;", "addStateChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "checkInvalidListeners", "reInit", "removeStateChangedListener", "sendEvent", "event", "Lcom/baidu/tieba/statemachine/base/Event;", "start", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public class BaseStateMachine {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final kca a;
    public nca b;
    public List<mca> c;
    public final Function1<List<jca>, Unit> d;

    public BaseStateMachine(kca baseStateMap) {
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

    public final void a(mca listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, listener) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            if (this.c == null) {
                this.c = new ArrayList();
            }
            b();
            List<mca> list = this.c;
            if (list != null) {
                list.add(listener);
            }
        }
    }

    public final void e(mca listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, listener) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            listener.c(false);
        }
    }

    public final void b() {
        List<mca> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (list = this.c) != null) {
            Iterator<mca> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().a()) {
                    it.remove();
                }
            }
        }
    }

    public final nca c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (nca) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b = this.a.a();
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.e("State Machine", "State Machine ReInt! Start State: " + this.b.getClass().getSimpleName());
        }
    }

    public final void f(lca event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            HashMap<lca, nca> hashMap = this.a.getMap().get(this.b);
            if (hashMap == null) {
                DefaultLog.getInstance().e("State Machine", "Illegal state!");
                return;
            }
            nca ncaVar = hashMap.get(event);
            if (ncaVar == null) {
                DefaultLog.getInstance().e("State Machine", "Illegal event!");
                return;
            }
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.e("State Machine", "Current State: " + this.b.getClass().getSimpleName() + "  Current Event: " + event.getClass().getSimpleName());
            this.d.invoke(event.a());
            this.b = ncaVar;
            TbLog defaultLog2 = DefaultLog.getInstance();
            defaultLog2.e("State Machine", "Next State: " + this.b.getClass().getSimpleName());
            this.d.invoke(this.b.b());
            List<mca> list = this.c;
            if (list != null) {
                for (mca mcaVar : list) {
                    if (mcaVar.a()) {
                        mcaVar.b(this.b);
                    }
                }
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.d.invoke(this.b.b());
            List<mca> list = this.c;
            if (list != null) {
                for (mca mcaVar : list) {
                    if (mcaVar.a()) {
                        mcaVar.b(this.b);
                    }
                }
            }
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.e("State Machine", "Start State: " + this.b.getClass().getSimpleName());
        }
    }
}
