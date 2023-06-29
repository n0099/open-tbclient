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
/* loaded from: classes7.dex */
public class r9a implements e8a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public y9a a;
    public a65 b;
    public x9a c;
    public w9a d;
    public u9a e;
    public s9a f;
    public v9a g;
    public t9a h;
    public MainTabActivity i;
    public e7a j;
    public boolean k;

    public r9a(@NonNull MainTabActivity mainTabActivity, @NonNull e7a e7aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, e7aVar};
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
        this.j = e7aVar;
        this.a = new y9a(mainTabActivity.getPageContext(), e7aVar, mainTabActivity, false);
        this.b = new a65(mainTabActivity.getPageContext());
        this.c = new x9a(mainTabActivity, e7aVar);
        this.d = new w9a(mainTabActivity, e7aVar);
        this.g = new v9a(mainTabActivity, e7aVar);
        this.h = new t9a(mainTabActivity, e7aVar);
        this.e = new u9a(mainTabActivity, e7aVar);
    }

    @Override // com.baidu.tieba.e8a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (LooperBlockSwitch.getIsOn()) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(this.a);
                x55.g(linkedList);
            } else if (!this.k) {
            } else {
                ks8.m = false;
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(this.h);
                linkedList2.add(this.a);
                x55.g(linkedList2);
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
        x55.g(linkedList);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.a);
            if (!LooperBlockSwitch.getIsOn()) {
                linkedList.add(this.c);
                linkedList.add(this.d);
                linkedList.add(this.h);
                linkedList.add(this.b);
                linkedList.add(this.g);
            }
            s9a s9aVar = new s9a(this.i, this.j, "source_from_theme");
            this.f = s9aVar;
            linkedList.add(s9aVar);
            x55.g(linkedList);
            this.k = true;
        }
    }
}
