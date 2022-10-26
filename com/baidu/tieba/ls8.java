package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class ls8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ss8 a;
    public jv4 b;
    public rs8 c;
    public qs8 d;
    public ns8 e;
    public os8 f;
    public ts8 g;
    public ps8 h;
    public ms8 i;
    public boolean j;

    public ls8(MainTabActivity mainTabActivity, eq8 eq8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, eq8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = false;
        this.a = new ss8(mainTabActivity.getPageContext(), eq8Var, mainTabActivity, false);
        this.b = new jv4(mainTabActivity.getPageContext());
        this.c = new rs8(mainTabActivity, eq8Var);
        this.d = new qs8(mainTabActivity, eq8Var);
        this.f = new os8(mainTabActivity, eq8Var);
        this.g = new ts8(mainTabActivity, eq8Var);
        this.h = new ps8(mainTabActivity, eq8Var);
        this.i = new ms8(mainTabActivity, eq8Var);
        this.e = new ns8(mainTabActivity, eq8Var);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.j) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(this.i);
        linkedList.add(this.c);
        linkedList.add(this.d);
        linkedList.add(this.e);
        gv4.g(linkedList);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !this.j) {
            return;
        }
        tf7.m = false;
        LinkedList linkedList = new LinkedList();
        linkedList.add(this.i);
        linkedList.add(this.a);
        gv4.g(linkedList);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.a);
            linkedList.add(this.c);
            linkedList.add(this.d);
            linkedList.add(this.i);
            linkedList.add(this.b);
            linkedList.add(this.h);
            linkedList.add(this.f);
            linkedList.add(this.g);
            gv4.g(linkedList);
            this.j = true;
        }
    }
}
