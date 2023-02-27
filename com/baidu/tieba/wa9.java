package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class wa9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public db9 a;
    public k25 b;
    public cb9 c;
    public bb9 d;
    public za9 e;
    public xa9 f;
    public xa9 g;
    public xa9 h;
    public ab9 i;
    public ya9 j;
    public MainTabActivity k;
    public m89 l;
    public boolean m;

    public wa9(@NonNull MainTabActivity mainTabActivity, @NonNull m89 m89Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, m89Var};
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
        this.l = m89Var;
        this.a = new db9(mainTabActivity.getPageContext(), m89Var, mainTabActivity, false);
        this.b = new k25(mainTabActivity.getPageContext());
        this.c = new cb9(mainTabActivity, m89Var);
        this.d = new bb9(mainTabActivity, m89Var);
        this.i = new ab9(mainTabActivity, m89Var);
        this.j = new ya9(mainTabActivity, m89Var);
        this.e = new za9(mainTabActivity, m89Var);
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
        h25.g(linkedList);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !this.m) {
            return;
        }
        zw7.m = false;
        LinkedList linkedList = new LinkedList();
        linkedList.add(this.j);
        linkedList.add(this.a);
        h25.g(linkedList);
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
            xa9 xa9Var = new xa9(this.k, this.l, "source_from_help");
            this.f = xa9Var;
            linkedList.add(xa9Var);
            xa9 xa9Var2 = new xa9(this.k, this.l, "source_from_virtual_image");
            this.g = xa9Var2;
            linkedList.add(xa9Var2);
            xa9 xa9Var3 = new xa9(this.k, this.l, "source_from_theme");
            this.h = xa9Var3;
            linkedList.add(xa9Var3);
            h25.g(linkedList);
            this.m = true;
        }
    }
}
