package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class jx8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qx8 a;
    public fw4 b;
    public px8 c;
    public ox8 d;
    public mx8 e;
    public kx8 f;
    public kx8 g;
    public kx8 h;
    public nx8 i;
    public lx8 j;
    public MainTabActivity k;
    public zu8 l;
    public boolean m;

    public jx8(@NonNull MainTabActivity mainTabActivity, @NonNull zu8 zu8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, zu8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.k = mainTabActivity;
        this.l = zu8Var;
        this.a = new qx8(mainTabActivity.getPageContext(), zu8Var, mainTabActivity, false);
        this.b = new fw4(mainTabActivity.getPageContext());
        this.c = new px8(mainTabActivity, zu8Var);
        this.d = new ox8(mainTabActivity, zu8Var);
        this.i = new nx8(mainTabActivity, zu8Var);
        this.j = new lx8(mainTabActivity, zu8Var);
        this.e = new mx8(mainTabActivity, zu8Var);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.m) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(this.j);
        linkedList.add(this.c);
        linkedList.add(this.d);
        linkedList.add(this.e);
        cw4.g(linkedList);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !this.m) {
            return;
        }
        mk7.m = false;
        LinkedList linkedList = new LinkedList();
        linkedList.add(this.j);
        linkedList.add(this.a);
        cw4.g(linkedList);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.a);
            linkedList.add(this.c);
            linkedList.add(this.d);
            linkedList.add(this.j);
            linkedList.add(this.b);
            linkedList.add(this.i);
            kx8 kx8Var = new kx8(this.k, this.l, "source_from_help");
            this.f = kx8Var;
            linkedList.add(kx8Var);
            kx8 kx8Var2 = new kx8(this.k, this.l, "source_from_virtual_image");
            this.g = kx8Var2;
            linkedList.add(kx8Var2);
            kx8 kx8Var3 = new kx8(this.k, this.l, "source_from_theme");
            this.h = kx8Var3;
            linkedList.add(kx8Var3);
            cw4.g(linkedList);
            this.m = true;
        }
    }
}
