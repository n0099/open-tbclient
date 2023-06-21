package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.ks2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes7.dex */
public class nq2 extends up2<ks2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ks2.a h;

    /* loaded from: classes7.dex */
    public class a implements ks2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(nq2 nq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nq2Var};
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nq2(@NonNull ks2 ks2Var) {
        super(ks2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ks2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((wp2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        ks2Var.Y(aVar);
        this.a.a(new ar2());
        this.a.a(new br2());
        this.a.a(new cr2());
        this.a.a(new er2());
        this.a.a(new gr2());
        this.a.a(new hr2());
        this.a.a(new ir2());
        this.a.a(new jr2());
        this.a.a(new kr2());
        this.a.a(new lr2());
        this.a.a(new dr2());
        this.a.a(new fr2());
        this.a.a(new nr2());
        this.a.a(new or2());
        this.a.a(new pr2());
        this.a.a(new rr2());
        this.a.a(new qr2());
        this.a.a(new sr2());
        this.a.a(new tr2());
        this.a.a(new ur2());
        this.a.a(new vr2());
        this.a.a(new wr2());
        this.a.a(new xr2());
        this.a.a(new yr2());
        this.a.a(new zr2());
        this.a.a(new as2());
        this.a.a(new bs2());
        this.a.a(new cs2());
        this.a.a(new ds2());
        this.a.a(new es2());
        this.a.a(new fs2());
        this.a.a(new hs2());
        this.a.a(new gs2());
        this.a.a(new mr2());
    }

    @Override // com.baidu.tieba.up2, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, command) == null) {
            if (command == null) {
                str = "";
            } else {
                str = command.what;
            }
            if (((ks2) this.c).q()) {
                z82.i("InlineRtcRoomController", "isReleased command：" + str);
                return;
            }
            z82.i("InlineRtcRoomController", "authorize type：" + ((ks2) this.c).a() + " command：" + str);
            super.sendCommand(command);
        }
    }
}
