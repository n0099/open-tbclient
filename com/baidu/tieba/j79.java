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
public class j79 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public q79 a;
    public d15 b;
    public p79 c;
    public o79 d;
    public m79 e;
    public k79 f;
    public k79 g;
    public k79 h;
    public n79 i;
    public l79 j;
    public MainTabActivity k;
    public z49 l;
    public boolean m;

    public j79(@NonNull MainTabActivity mainTabActivity, @NonNull z49 z49Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, z49Var};
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
        this.l = z49Var;
        this.a = new q79(mainTabActivity.getPageContext(), z49Var, mainTabActivity, false);
        this.b = new d15(mainTabActivity.getPageContext());
        this.c = new p79(mainTabActivity, z49Var);
        this.d = new o79(mainTabActivity, z49Var);
        this.i = new n79(mainTabActivity, z49Var);
        this.j = new l79(mainTabActivity, z49Var);
        this.e = new m79(mainTabActivity, z49Var);
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
        a15.g(linkedList);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !this.m) {
            return;
        }
        ut7.m = false;
        LinkedList linkedList = new LinkedList();
        linkedList.add(this.j);
        linkedList.add(this.a);
        a15.g(linkedList);
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
            k79 k79Var = new k79(this.k, this.l, "source_from_help");
            this.f = k79Var;
            linkedList.add(k79Var);
            k79 k79Var2 = new k79(this.k, this.l, "source_from_virtual_image");
            this.g = k79Var2;
            linkedList.add(k79Var2);
            k79 k79Var3 = new k79(this.k, this.l, "source_from_theme");
            this.h = k79Var3;
            linkedList.add(k79Var3);
            a15.g(linkedList);
            this.m = true;
        }
    }
}
