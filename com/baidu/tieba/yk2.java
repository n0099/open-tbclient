package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.vm2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes9.dex */
public class yk2 extends fk2<vm2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vm2.a h;

    /* loaded from: classes9.dex */
    public class a implements vm2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(yk2 yk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yk2Var};
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
    public yk2(@NonNull vm2 vm2Var) {
        super(vm2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vm2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((hk2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        vm2Var.Y(aVar);
        this.a.a(new ll2());
        this.a.a(new ml2());
        this.a.a(new nl2());
        this.a.a(new pl2());
        this.a.a(new rl2());
        this.a.a(new sl2());
        this.a.a(new tl2());
        this.a.a(new ul2());
        this.a.a(new vl2());
        this.a.a(new wl2());
        this.a.a(new ol2());
        this.a.a(new ql2());
        this.a.a(new yl2());
        this.a.a(new zl2());
        this.a.a(new am2());
        this.a.a(new cm2());
        this.a.a(new bm2());
        this.a.a(new dm2());
        this.a.a(new em2());
        this.a.a(new fm2());
        this.a.a(new gm2());
        this.a.a(new hm2());
        this.a.a(new im2());
        this.a.a(new jm2());
        this.a.a(new km2());
        this.a.a(new lm2());
        this.a.a(new mm2());
        this.a.a(new nm2());
        this.a.a(new om2());
        this.a.a(new pm2());
        this.a.a(new qm2());
        this.a.a(new sm2());
        this.a.a(new rm2());
        this.a.a(new xl2());
    }

    @Override // com.baidu.tieba.fk2, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, command) == null) {
            if (command == null) {
                str = "";
            } else {
                str = command.what;
            }
            if (((vm2) this.c).q()) {
                k32.i("InlineRtcRoomController", "isReleased command：" + str);
                return;
            }
            k32.i("InlineRtcRoomController", "authorize type：" + ((vm2) this.c).a() + " command：" + str);
            super.sendCommand(command);
        }
    }
}
