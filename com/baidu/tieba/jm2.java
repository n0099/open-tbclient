package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.go2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes5.dex */
public class jm2 extends ql2<go2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public go2.a h;

    /* loaded from: classes5.dex */
    public class a implements go2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(jm2 jm2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm2Var};
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
    public jm2(@NonNull go2 go2Var) {
        super(go2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {go2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((sl2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        go2Var.Y(aVar);
        this.a.a(new wm2());
        this.a.a(new xm2());
        this.a.a(new ym2());
        this.a.a(new an2());
        this.a.a(new cn2());
        this.a.a(new dn2());
        this.a.a(new en2());
        this.a.a(new fn2());
        this.a.a(new gn2());
        this.a.a(new hn2());
        this.a.a(new zm2());
        this.a.a(new bn2());
        this.a.a(new jn2());
        this.a.a(new kn2());
        this.a.a(new ln2());
        this.a.a(new nn2());
        this.a.a(new mn2());
        this.a.a(new on2());
        this.a.a(new pn2());
        this.a.a(new qn2());
        this.a.a(new rn2());
        this.a.a(new sn2());
        this.a.a(new tn2());
        this.a.a(new un2());
        this.a.a(new vn2());
        this.a.a(new wn2());
        this.a.a(new xn2());
        this.a.a(new yn2());
        this.a.a(new zn2());
        this.a.a(new ao2());
        this.a.a(new bo2());
        this.a.a(new do2());
        this.a.a(new co2());
        this.a.a(new in2());
    }

    @Override // com.baidu.tieba.ql2, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, command) == null) {
            if (command == null) {
                str = "";
            } else {
                str = command.what;
            }
            if (((go2) this.c).q()) {
                v42.i("InlineRtcRoomController", "isReleased command：" + str);
                return;
            }
            v42.i("InlineRtcRoomController", "authorize type：" + ((go2) this.c).a() + " command：" + str);
            super.sendCommand(command);
        }
    }
}
