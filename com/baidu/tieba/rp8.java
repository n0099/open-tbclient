package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.base.core.repo.MsgProcessor;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.TbSysMsg;
import com.baidu.tieba.im.lib.socket.msg.data.BubbleInfo;
import com.baidu.tieba.im.lib.socket.msg.data.EnableDegradeUserData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
/* loaded from: classes8.dex */
public abstract class rp8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MsgProcessor a;

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public abstract BubbleInfo f();

    public abstract List<EnableDegradeUserData> i();

    public abstract TbBaseMsg.c j();

    public abstract List<EnableDegradeUserData> m();

    public abstract long n();

    public abstract int q();

    @JvmOverloads
    public final <T extends TbBaseMsg> void u(T tbMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, tbMsg) == null) {
            Intrinsics.checkNotNullParameter(tbMsg, "tbMsg");
            w(this, tbMsg, null, 2, null);
        }
    }

    public rp8() {
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
        this.a = new MsgProcessor();
    }

    public final MsgProcessor b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (MsgProcessor) invokeV.objValue;
    }

    public static /* synthetic */ void w(rp8 rp8Var, TbBaseMsg tbBaseMsg, MsgProcessor.d dVar, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                dVar = MsgProcessor.d.a.d(MsgProcessor.d.g, false, 0, 3, null);
            }
            rp8Var.v(tbBaseMsg, dVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendMsg");
    }

    public final void B(MsgProcessor.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.a.K(bVar);
        }
    }

    public final void D(MsgProcessor.e<? extends TbSysMsg> eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            this.a.L(eVar);
        }
    }

    public final void r(Pair<? extends Object, ? extends Class<? extends BaseItem<? extends TbBaseMsg>>> pair) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, pair) == null) {
            Intrinsics.checkNotNullParameter(pair, "pair");
            this.a.G(pair);
        }
    }

    public final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return aw8.b(zv8.a()) + TbBaseMsg.Companion.a() + Random.Default.nextLong();
        }
        return (String) invokeV.objValue;
    }

    @JvmOverloads
    public final <T extends TbBaseMsg> void v(T tbMsg, MsgProcessor.d source) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, tbMsg, source) == null) {
            Intrinsics.checkNotNullParameter(tbMsg, "tbMsg");
            Intrinsics.checkNotNullParameter(source, "source");
            tbMsg.setSessionId(n());
            tbMsg.setMsgId(TbBaseMsg.Companion.a());
            tbMsg.setMsgKey(k());
            if (tbMsg.isMockSender()) {
                this.a.C(tbMsg, source);
                return;
            }
            sv4 t = sv4.t();
            tbMsg.setUserId(t.j());
            String m = t.m();
            Intrinsics.checkNotNullExpressionValue(m, "am.currentAccountNameShow");
            tbMsg.setUserName(m);
            String r = t.r();
            Intrinsics.checkNotNullExpressionValue(r, "am.currentPortrait");
            tbMsg.setPortrait(r);
            tbMsg.setRole(q());
            tbMsg.setSendClient("android");
            tbMsg.setForumExt(j());
            BubbleInfo f = f();
            if (f != null && !f.isExpired()) {
                tbMsg.setBubbleInfo(f);
            }
            tbMsg.setEnableDegradeUserDataList(i());
            tbMsg.setSecondDegradeUserDataList(m());
            tbMsg.setLocalMsgId(true);
            d();
            this.a.C(tbMsg, source);
        }
    }
}
