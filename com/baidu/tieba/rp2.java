package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tieba.or2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes7.dex */
public class rp2 extends yo2<or2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public or2.a h;

    /* loaded from: classes7.dex */
    public class a implements or2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(rp2 rp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp2Var};
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
    public rp2(@NonNull or2 or2Var) {
        super(or2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {or2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ap2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        or2Var.Y(aVar);
        this.a.a(new eq2());
        this.a.a(new fq2());
        this.a.a(new gq2());
        this.a.a(new iq2());
        this.a.a(new kq2());
        this.a.a(new lq2());
        this.a.a(new mq2());
        this.a.a(new nq2());
        this.a.a(new oq2());
        this.a.a(new pq2());
        this.a.a(new hq2());
        this.a.a(new jq2());
        this.a.a(new rq2());
        this.a.a(new sq2());
        this.a.a(new tq2());
        this.a.a(new vq2());
        this.a.a(new uq2());
        this.a.a(new wq2());
        this.a.a(new xq2());
        this.a.a(new yq2());
        this.a.a(new zq2());
        this.a.a(new ar2());
        this.a.a(new br2());
        this.a.a(new cr2());
        this.a.a(new dr2());
        this.a.a(new er2());
        this.a.a(new fr2());
        this.a.a(new gr2());
        this.a.a(new hr2());
        this.a.a(new ir2());
        this.a.a(new jr2());
        this.a.a(new lr2());
        this.a.a(new kr2());
        this.a.a(new qq2());
    }

    @Override // com.baidu.tieba.yo2, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, command) == null) {
            if (command == null) {
                str = "";
            } else {
                str = command.what;
            }
            if (((or2) this.c).q()) {
                d82.i("InlineRtcRoomController", "isReleased command：" + str);
                return;
            }
            d82.i("InlineRtcRoomController", "authorize type：" + ((or2) this.c).a() + " command：" + str);
            super.sendCommand(command);
        }
    }
}
