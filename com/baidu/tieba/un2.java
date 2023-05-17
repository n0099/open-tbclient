package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.rp2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes7.dex */
public class un2 extends bn2<rp2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rp2.a h;

    /* loaded from: classes7.dex */
    public class a implements rp2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(un2 un2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {un2Var};
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
    public un2(@NonNull rp2 rp2Var) {
        super(rp2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rp2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((dn2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        rp2Var.Y(aVar);
        this.a.a(new ho2());
        this.a.a(new io2());
        this.a.a(new jo2());
        this.a.a(new lo2());
        this.a.a(new no2());
        this.a.a(new oo2());
        this.a.a(new po2());
        this.a.a(new qo2());
        this.a.a(new ro2());
        this.a.a(new so2());
        this.a.a(new ko2());
        this.a.a(new mo2());
        this.a.a(new uo2());
        this.a.a(new vo2());
        this.a.a(new wo2());
        this.a.a(new yo2());
        this.a.a(new xo2());
        this.a.a(new zo2());
        this.a.a(new ap2());
        this.a.a(new bp2());
        this.a.a(new cp2());
        this.a.a(new dp2());
        this.a.a(new ep2());
        this.a.a(new fp2());
        this.a.a(new gp2());
        this.a.a(new hp2());
        this.a.a(new ip2());
        this.a.a(new jp2());
        this.a.a(new kp2());
        this.a.a(new lp2());
        this.a.a(new mp2());
        this.a.a(new op2());
        this.a.a(new np2());
        this.a.a(new to2());
    }

    @Override // com.baidu.tieba.bn2, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, command) == null) {
            if (command == null) {
                str = "";
            } else {
                str = command.what;
            }
            if (((rp2) this.c).q()) {
                g62.i("InlineRtcRoomController", "isReleased command：" + str);
                return;
            }
            g62.i("InlineRtcRoomController", "authorize type：" + ((rp2) this.c).a() + " command：" + str);
            super.sendCommand(command);
        }
    }
}
