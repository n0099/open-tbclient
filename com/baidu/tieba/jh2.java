package com.baidu.tieba;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.lh2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class jh2 extends gh2<lh2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final lh2.f h;

    /* loaded from: classes4.dex */
    public class a implements lh2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jh2 a;

        public a(jh2 jh2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jh2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jh2Var;
        }

        @Override // com.baidu.tieba.lh2.f
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onCustomKeyboardHide", null);
        }

        @Override // com.baidu.tieba.lh2.f
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onCustomKeyboardShow", Integer.valueOf(i));
        }

        @Override // com.baidu.tieba.lh2.f
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "committext", str);
        }

        @Override // com.baidu.tieba.lh2.f
        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "deletebutton", new KeyEvent(0, 67));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jh2(@NonNull lh2 lh2Var) {
        super(lh2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lh2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ih2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        lh2Var.D0(aVar);
        this.a.a(new qh2());
        this.a.a(new mh2());
        this.a.a(new ph2());
        this.a.a(new oh2());
        this.a.a(new nh2());
    }
}
