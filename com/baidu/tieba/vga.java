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
public class vga implements ifa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cha a;
    public f55 b;
    public bha c;
    public aha d;
    public yga e;
    public wga f;
    public zga g;
    public xga h;
    public MainTabActivity i;
    public iea j;
    public boolean k;

    public vga(@NonNull MainTabActivity mainTabActivity, @NonNull iea ieaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, ieaVar};
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
        this.j = ieaVar;
        this.a = new cha(mainTabActivity.getPageContext(), ieaVar, mainTabActivity, false);
        this.b = new f55(mainTabActivity.getPageContext());
        this.c = new bha(mainTabActivity, ieaVar);
        this.d = new aha(mainTabActivity, ieaVar);
        this.g = new zga(mainTabActivity, ieaVar);
        this.h = new xga(mainTabActivity, ieaVar);
        this.e = new yga(mainTabActivity, ieaVar);
    }

    @Override // com.baidu.tieba.ifa
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (LooperBlockSwitch.getIsOn()) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(this.a);
                c55.g(linkedList);
            } else if (!this.k) {
            } else {
                kw8.m = false;
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(this.h);
                linkedList2.add(this.a);
                c55.g(linkedList2);
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
        c55.g(linkedList);
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
            wga wgaVar = new wga(this.i, this.j, "source_from_theme");
            this.f = wgaVar;
            linkedList.add(wgaVar);
            c55.g(linkedList);
            this.k = true;
        }
    }
}
