package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.jj2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes5.dex */
public class mh2 extends tg2<jj2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jj2.a h;

    /* loaded from: classes5.dex */
    public class a implements jj2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(mh2 mh2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mh2Var};
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
    public mh2(@NonNull jj2 jj2Var) {
        super(jj2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jj2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((vg2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        jj2Var.Z(aVar);
        this.a.a(new zh2());
        this.a.a(new ai2());
        this.a.a(new bi2());
        this.a.a(new di2());
        this.a.a(new fi2());
        this.a.a(new gi2());
        this.a.a(new hi2());
        this.a.a(new ii2());
        this.a.a(new ji2());
        this.a.a(new ki2());
        this.a.a(new ci2());
        this.a.a(new ei2());
        this.a.a(new mi2());
        this.a.a(new ni2());
        this.a.a(new oi2());
        this.a.a(new qi2());
        this.a.a(new pi2());
        this.a.a(new ri2());
        this.a.a(new si2());
        this.a.a(new ti2());
        this.a.a(new ui2());
        this.a.a(new vi2());
        this.a.a(new wi2());
        this.a.a(new xi2());
        this.a.a(new yi2());
        this.a.a(new zi2());
        this.a.a(new aj2());
        this.a.a(new bj2());
        this.a.a(new cj2());
        this.a.a(new dj2());
        this.a.a(new ej2());
        this.a.a(new gj2());
        this.a.a(new fj2());
        this.a.a(new li2());
    }

    @Override // com.baidu.tieba.tg2, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, command) == null) {
            String str = command == null ? "" : command.what;
            if (((jj2) this.c).q()) {
                yz1.i("InlineRtcRoomController", "isReleased command：" + str);
                return;
            }
            yz1.i("InlineRtcRoomController", "authorize type：" + ((jj2) this.c).a() + " command：" + str);
            super.sendCommand(command);
        }
    }
}
