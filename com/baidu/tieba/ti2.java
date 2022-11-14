package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.qk2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes6.dex */
public class ti2 extends ai2<qk2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qk2.a h;

    /* loaded from: classes6.dex */
    public class a implements qk2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(ti2 ti2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ti2Var};
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
    public ti2(@NonNull qk2 qk2Var) {
        super(qk2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qk2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ci2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        qk2Var.Y(aVar);
        this.a.a(new gj2());
        this.a.a(new hj2());
        this.a.a(new ij2());
        this.a.a(new kj2());
        this.a.a(new mj2());
        this.a.a(new nj2());
        this.a.a(new oj2());
        this.a.a(new pj2());
        this.a.a(new qj2());
        this.a.a(new rj2());
        this.a.a(new jj2());
        this.a.a(new lj2());
        this.a.a(new tj2());
        this.a.a(new uj2());
        this.a.a(new vj2());
        this.a.a(new xj2());
        this.a.a(new wj2());
        this.a.a(new yj2());
        this.a.a(new zj2());
        this.a.a(new ak2());
        this.a.a(new bk2());
        this.a.a(new ck2());
        this.a.a(new dk2());
        this.a.a(new ek2());
        this.a.a(new fk2());
        this.a.a(new gk2());
        this.a.a(new hk2());
        this.a.a(new ik2());
        this.a.a(new jk2());
        this.a.a(new kk2());
        this.a.a(new lk2());
        this.a.a(new nk2());
        this.a.a(new mk2());
        this.a.a(new sj2());
    }

    @Override // com.baidu.tieba.ai2, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, command) == null) {
            if (command == null) {
                str = "";
            } else {
                str = command.what;
            }
            if (((qk2) this.c).q()) {
                f12.i("InlineRtcRoomController", "isReleased command：" + str);
                return;
            }
            f12.i("InlineRtcRoomController", "authorize type：" + ((qk2) this.c).a() + " command：" + str);
            super.sendCommand(command);
        }
    }
}
