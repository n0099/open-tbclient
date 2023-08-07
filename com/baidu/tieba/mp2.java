package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.jr2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes7.dex */
public class mp2 extends to2<jr2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jr2.a h;

    /* loaded from: classes7.dex */
    public class a implements jr2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(mp2 mp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mp2Var};
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
    public mp2(@NonNull jr2 jr2Var) {
        super(jr2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jr2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((vo2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        jr2Var.Y(aVar);
        this.a.a(new zp2());
        this.a.a(new aq2());
        this.a.a(new bq2());
        this.a.a(new dq2());
        this.a.a(new fq2());
        this.a.a(new gq2());
        this.a.a(new hq2());
        this.a.a(new iq2());
        this.a.a(new jq2());
        this.a.a(new kq2());
        this.a.a(new cq2());
        this.a.a(new eq2());
        this.a.a(new mq2());
        this.a.a(new nq2());
        this.a.a(new oq2());
        this.a.a(new qq2());
        this.a.a(new pq2());
        this.a.a(new rq2());
        this.a.a(new sq2());
        this.a.a(new tq2());
        this.a.a(new uq2());
        this.a.a(new vq2());
        this.a.a(new wq2());
        this.a.a(new xq2());
        this.a.a(new yq2());
        this.a.a(new zq2());
        this.a.a(new ar2());
        this.a.a(new br2());
        this.a.a(new cr2());
        this.a.a(new dr2());
        this.a.a(new er2());
        this.a.a(new gr2());
        this.a.a(new fr2());
        this.a.a(new lq2());
    }

    @Override // com.baidu.tieba.to2, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, command) == null) {
            if (command == null) {
                str = "";
            } else {
                str = command.what;
            }
            if (((jr2) this.c).q()) {
                y72.i("InlineRtcRoomController", "isReleased command：" + str);
                return;
            }
            y72.i("InlineRtcRoomController", "authorize type：" + ((jr2) this.c).a() + " command：" + str);
            super.sendCommand(command);
        }
    }
}
