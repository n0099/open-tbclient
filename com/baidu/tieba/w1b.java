package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes8.dex */
public class w1b implements k0b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public y1b a;
    public x1b b;
    public MainTabActivity c;
    public eza d;

    public w1b(@NonNull MainTabActivity mainTabActivity, @NonNull eza ezaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, ezaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = mainTabActivity;
        this.d = ezaVar;
        this.a = new y1b(mainTabActivity.getPageContext(), ezaVar, mainTabActivity, false);
    }

    @Override // com.baidu.tieba.k0b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.a);
            v05.g(linkedList);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(this.a);
            x1b x1bVar = new x1b(this.c, this.d, "source_from_theme");
            this.b = x1bVar;
            linkedList.add(x1bVar);
            v05.g(linkedList);
        }
    }
}
