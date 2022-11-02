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
public class vt8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cu8 a;
    public cw4 b;
    public bu8 c;
    public au8 d;
    public yt8 e;
    public wt8 f;
    public wt8 g;
    public wt8 h;
    public zt8 i;
    public xt8 j;
    public MainTabActivity k;
    public or8 l;
    public boolean m;

    public vt8(@NonNull MainTabActivity mainTabActivity, @NonNull or8 or8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, or8Var};
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
        this.l = or8Var;
        this.a = new cu8(mainTabActivity.getPageContext(), or8Var, mainTabActivity, false);
        this.b = new cw4(mainTabActivity.getPageContext());
        this.c = new bu8(mainTabActivity, or8Var);
        this.d = new au8(mainTabActivity, or8Var);
        this.i = new zt8(mainTabActivity, or8Var);
        this.j = new xt8(mainTabActivity, or8Var);
        this.e = new yt8(mainTabActivity, or8Var);
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
        zv4.g(linkedList);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || !this.m) {
            return;
        }
        dh7.m = false;
        LinkedList linkedList = new LinkedList();
        linkedList.add(this.j);
        linkedList.add(this.a);
        zv4.g(linkedList);
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
            wt8 wt8Var = new wt8(this.k, this.l, "source_from_help");
            this.f = wt8Var;
            linkedList.add(wt8Var);
            wt8 wt8Var2 = new wt8(this.k, this.l, "source_from_virtual_image");
            this.g = wt8Var2;
            linkedList.add(wt8Var2);
            wt8 wt8Var3 = new wt8(this.k, this.l, "source_from_theme");
            this.h = wt8Var3;
            linkedList.add(wt8Var3);
            zv4.g(linkedList);
            this.m = true;
        }
    }
}
