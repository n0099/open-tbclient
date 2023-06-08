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
public class o3a implements a2a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v3a a;
    public w55 b;
    public u3a c;
    public t3a d;
    public r3a e;
    public p3a f;
    public s3a g;
    public q3a h;
    public MainTabActivity i;
    public a1a j;
    public boolean k;

    public o3a(@NonNull MainTabActivity mainTabActivity, @NonNull a1a a1aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, a1aVar};
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
        this.j = a1aVar;
        this.a = new v3a(mainTabActivity.getPageContext(), a1aVar, mainTabActivity, false);
        this.b = new w55(mainTabActivity.getPageContext());
        this.c = new u3a(mainTabActivity, a1aVar);
        this.d = new t3a(mainTabActivity, a1aVar);
        this.g = new s3a(mainTabActivity, a1aVar);
        this.h = new q3a(mainTabActivity, a1aVar);
        this.e = new r3a(mainTabActivity, a1aVar);
    }

    @Override // com.baidu.tieba.a2a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (LooperBlockSwitch.getIsOn()) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(this.a);
                t55.g(linkedList);
            } else if (!this.k) {
            } else {
                cn8.m = false;
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(this.h);
                linkedList2.add(this.a);
                t55.g(linkedList2);
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
        t55.g(linkedList);
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
            p3a p3aVar = new p3a(this.i, this.j, "source_from_theme");
            this.f = p3aVar;
            linkedList.add(p3aVar);
            t55.g(linkedList);
            this.k = true;
        }
    }
}
