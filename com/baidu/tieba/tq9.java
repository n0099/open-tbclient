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
public class tq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zq9 a;
    public w05 b;
    public yq9 c;
    public xq9 d;
    public vq9 e;
    public wq9 f;
    public uq9 g;
    public MainTabActivity h;
    public boolean i;

    public tq9(@NonNull MainTabActivity mainTabActivity, @NonNull jo9 jo9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, jo9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = false;
        this.h = mainTabActivity;
        this.a = new zq9(mainTabActivity.getPageContext(), jo9Var, mainTabActivity, false);
        this.b = new w05(mainTabActivity.getPageContext());
        this.c = new yq9(mainTabActivity, jo9Var);
        this.d = new xq9(mainTabActivity, jo9Var);
        this.f = new wq9(mainTabActivity, jo9Var);
        this.g = new uq9(mainTabActivity, jo9Var);
        this.e = new vq9(mainTabActivity, jo9Var);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || LooperBlockSwitch.getIsOn() || !this.i) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(this.g);
        linkedList.add(this.c);
        linkedList.add(this.d);
        linkedList.add(this.e);
        t05.g(linkedList);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (LooperBlockSwitch.getIsOn()) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(this.a);
                t05.g(linkedList);
            } else if (!this.i) {
            } else {
                qc8.m = false;
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(this.g);
                linkedList2.add(this.a);
                t05.g(linkedList2);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (LooperBlockSwitch.getIsOn()) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(this.a);
                t05.g(linkedList);
                return;
            }
            LinkedList linkedList2 = new LinkedList();
            linkedList2.add(this.a);
            linkedList2.add(this.c);
            linkedList2.add(this.d);
            linkedList2.add(this.g);
            linkedList2.add(this.b);
            linkedList2.add(this.f);
            t05.g(linkedList2);
            this.i = true;
        }
    }
}
