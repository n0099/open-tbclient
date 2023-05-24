package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.switchs.LooperBlockSwitch;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class xw9 implements jv9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ex9 a;
    public x25 b;
    public dx9 c;
    public cx9 d;
    public ax9 e;
    public yw9 f;
    public bx9 g;
    public zw9 h;
    public MainTabActivity i;
    public ju9 j;
    public boolean k;

    public xw9(@NonNull MainTabActivity mainTabActivity, @NonNull ju9 ju9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, ju9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = false;
        this.i = mainTabActivity;
        this.j = ju9Var;
        this.a = new ex9(mainTabActivity.getPageContext(), ju9Var, mainTabActivity, false);
        this.b = new x25(mainTabActivity.getPageContext());
        this.c = new dx9(mainTabActivity, ju9Var);
        this.d = new cx9(mainTabActivity, ju9Var);
        this.g = new bx9(mainTabActivity, ju9Var);
        this.h = new zw9(mainTabActivity, ju9Var);
        this.e = new ax9(mainTabActivity, ju9Var);
    }

    @Override // com.baidu.tieba.jv9
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (LooperBlockSwitch.getIsOn()) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(this.a);
                u25.g(linkedList);
            } else if (!this.k) {
            } else {
                ch8.m = false;
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(this.h);
                linkedList2.add(this.a);
                u25.g(linkedList2);
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || LooperBlockSwitch.getIsOn() || !this.k) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(this.h);
        linkedList.add(this.c);
        linkedList.add(this.d);
        linkedList.add(this.e);
        u25.g(linkedList);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.a);
            if (LooperBlockSwitch.getIsOn()) {
                linkedList.add(this.c);
                linkedList.add(this.d);
                linkedList.add(this.h);
                linkedList.add(this.b);
                linkedList.add(this.g);
            }
            yw9 yw9Var = new yw9(this.i, this.j, "source_from_theme");
            this.f = yw9Var;
            linkedList.add(yw9Var);
            u25.g(linkedList);
            this.k = true;
        }
    }
}
