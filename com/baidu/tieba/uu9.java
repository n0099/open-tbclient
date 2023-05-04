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
/* loaded from: classes6.dex */
public class uu9 implements gt9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bv9 a;
    public o15 b;
    public av9 c;
    public zu9 d;
    public xu9 e;
    public vu9 f;
    public yu9 g;
    public wu9 h;
    public MainTabActivity i;
    public gs9 j;
    public boolean k;

    public uu9(@NonNull MainTabActivity mainTabActivity, @NonNull gs9 gs9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, gs9Var};
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
        this.j = gs9Var;
        this.a = new bv9(mainTabActivity.getPageContext(), gs9Var, mainTabActivity, false);
        this.b = new o15(mainTabActivity.getPageContext());
        this.c = new av9(mainTabActivity, gs9Var);
        this.d = new zu9(mainTabActivity, gs9Var);
        this.g = new yu9(mainTabActivity, gs9Var);
        this.h = new wu9(mainTabActivity, gs9Var);
        this.e = new xu9(mainTabActivity, gs9Var);
    }

    @Override // com.baidu.tieba.gt9
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (LooperBlockSwitch.getIsOn()) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(this.a);
                l15.g(linkedList);
            } else if (!this.k) {
            } else {
                gf8.m = false;
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(this.h);
                linkedList2.add(this.a);
                l15.g(linkedList2);
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
        l15.g(linkedList);
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
            vu9 vu9Var = new vu9(this.i, this.j, "source_from_theme");
            this.f = vu9Var;
            linkedList.add(vu9Var);
            l15.g(linkedList);
            this.k = true;
        }
    }
}
