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
public class kx8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rx8 a;
    public fw4 b;
    public qx8 c;
    public px8 d;
    public nx8 e;
    public lx8 f;
    public lx8 g;
    public lx8 h;
    public ox8 i;
    public mx8 j;
    public MainTabActivity k;
    public av8 l;
    public boolean m;

    public kx8(@NonNull MainTabActivity mainTabActivity, @NonNull av8 av8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, av8Var};
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
        this.l = av8Var;
        this.a = new rx8(mainTabActivity.getPageContext(), av8Var, mainTabActivity, false);
        this.b = new fw4(mainTabActivity.getPageContext());
        this.c = new qx8(mainTabActivity, av8Var);
        this.d = new px8(mainTabActivity, av8Var);
        this.i = new ox8(mainTabActivity, av8Var);
        this.j = new mx8(mainTabActivity, av8Var);
        this.e = new nx8(mainTabActivity, av8Var);
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
        nk7.m = false;
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
            lx8 lx8Var = new lx8(this.k, this.l, "source_from_help");
            this.f = lx8Var;
            linkedList.add(lx8Var);
            lx8 lx8Var2 = new lx8(this.k, this.l, "source_from_virtual_image");
            this.g = lx8Var2;
            linkedList.add(lx8Var2);
            lx8 lx8Var3 = new lx8(this.k, this.l, "source_from_theme");
            this.h = lx8Var3;
            linkedList.add(lx8Var3);
            cw4.g(linkedList);
            this.m = true;
        }
    }
}
