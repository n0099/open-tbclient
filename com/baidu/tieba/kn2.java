package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.hp2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes5.dex */
public class kn2 extends rm2<hp2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hp2.a h;

    /* loaded from: classes5.dex */
    public class a implements hp2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(kn2 kn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kn2Var};
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
    public kn2(@NonNull hp2 hp2Var) {
        super(hp2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hp2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((tm2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        hp2Var.Y(aVar);
        this.a.a(new xn2());
        this.a.a(new yn2());
        this.a.a(new zn2());
        this.a.a(new bo2());
        this.a.a(new do2());
        this.a.a(new eo2());
        this.a.a(new fo2());
        this.a.a(new go2());
        this.a.a(new ho2());
        this.a.a(new io2());
        this.a.a(new ao2());
        this.a.a(new co2());
        this.a.a(new ko2());
        this.a.a(new lo2());
        this.a.a(new mo2());
        this.a.a(new oo2());
        this.a.a(new no2());
        this.a.a(new po2());
        this.a.a(new qo2());
        this.a.a(new ro2());
        this.a.a(new so2());
        this.a.a(new to2());
        this.a.a(new uo2());
        this.a.a(new vo2());
        this.a.a(new wo2());
        this.a.a(new xo2());
        this.a.a(new yo2());
        this.a.a(new zo2());
        this.a.a(new ap2());
        this.a.a(new bp2());
        this.a.a(new cp2());
        this.a.a(new ep2());
        this.a.a(new dp2());
        this.a.a(new jo2());
    }

    @Override // com.baidu.tieba.rm2, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, command) == null) {
            if (command == null) {
                str = "";
            } else {
                str = command.what;
            }
            if (((hp2) this.c).q()) {
                w52.i("InlineRtcRoomController", "isReleased command：" + str);
                return;
            }
            w52.i("InlineRtcRoomController", "authorize type：" + ((hp2) this.c).a() + " command：" + str);
            super.sendCommand(command);
        }
    }
}
