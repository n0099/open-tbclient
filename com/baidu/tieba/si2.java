package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.pk2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes5.dex */
public class si2 extends zh2<pk2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pk2.a h;

    /* loaded from: classes5.dex */
    public class a implements pk2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(si2 si2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {si2Var};
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
    public si2(@NonNull pk2 pk2Var) {
        super(pk2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pk2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((bi2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        pk2Var.Y(aVar);
        this.a.a(new fj2());
        this.a.a(new gj2());
        this.a.a(new hj2());
        this.a.a(new jj2());
        this.a.a(new lj2());
        this.a.a(new mj2());
        this.a.a(new nj2());
        this.a.a(new oj2());
        this.a.a(new pj2());
        this.a.a(new qj2());
        this.a.a(new ij2());
        this.a.a(new kj2());
        this.a.a(new sj2());
        this.a.a(new tj2());
        this.a.a(new uj2());
        this.a.a(new wj2());
        this.a.a(new vj2());
        this.a.a(new xj2());
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
        this.a.a(new mk2());
        this.a.a(new lk2());
        this.a.a(new rj2());
    }

    @Override // com.baidu.tieba.zh2, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, command) == null) {
            if (command == null) {
                str = "";
            } else {
                str = command.what;
            }
            if (((pk2) this.c).q()) {
                e12.i("InlineRtcRoomController", "isReleased command：" + str);
                return;
            }
            e12.i("InlineRtcRoomController", "authorize type：" + ((pk2) this.c).a() + " command：" + str);
            super.sendCommand(command);
        }
    }
}
