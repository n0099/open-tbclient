package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddLinkActivityConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class lfb implements nfb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final TbPageContext<?> a;
    @NonNull
    public final peb b;

    public lfb(@NonNull TbPageContext<?> tbPageContext, @NonNull peb pebVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, pebVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.b = pebVar;
    }

    @Override // com.baidu.tieba.yd5
    public void S(xd5 xd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xd5Var) == null) {
            int i = xd5Var.a;
            if (i != 14 && i != 48) {
                if (i == 60) {
                    this.b.u();
                    return;
                } else if (i != 12 && i != 13 && i != 46 && i != 49) {
                    if (i == 21) {
                        this.b.i();
                        ldb.b(this.a.getPageActivity(), 5);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddLinkActivityConfig(this.a.getPageActivity(), 25049, "", true, null)));
                        return;
                    } else if (i == 24) {
                        this.b.z(xd5Var);
                        return;
                    } else if (i == 3) {
                        this.b.z(xd5Var);
                        return;
                    } else if (i == 16) {
                        this.b.z(xd5Var);
                        return;
                    } else if (i == 43) {
                        ldb.b(this.a.getPageActivity(), 4);
                        SharedPrefHelper.getInstance().putBoolean("hot_topic_has_click", true);
                        this.b.C(new xd5(2, 26, null));
                        this.b.p(true);
                        this.b.m();
                        return;
                    } else if (i == 10) {
                        this.b.z(xd5Var);
                        return;
                    } else if (i == 11) {
                        this.b.z(xd5Var);
                        return;
                    } else if (i == 25) {
                        this.b.z(xd5Var);
                        return;
                    } else if (i == 22) {
                        this.b.z(xd5Var);
                        return;
                    } else if (i == 59) {
                        this.b.z(xd5Var);
                        return;
                    } else if (i == 61) {
                        this.b.z(xd5Var);
                        return;
                    } else if (i == 69) {
                        this.b.v();
                        return;
                    } else if (i == 55) {
                        Object obj = xd5Var.c;
                        if (obj instanceof Boolean) {
                            this.b.k(((Boolean) obj).booleanValue());
                            return;
                        }
                        return;
                    } else if (i == 66) {
                        Object obj2 = xd5Var.c;
                        if (obj2 instanceof Boolean) {
                            this.b.y(((Boolean) obj2).booleanValue());
                            return;
                        }
                        return;
                    } else if (i == 74) {
                        this.b.z(xd5Var);
                        return;
                    } else if (i == 77) {
                        this.b.z(xd5Var);
                        return;
                    } else {
                        return;
                    }
                } else {
                    this.b.x(new int[]{10, 34});
                    this.b.j();
                    return;
                }
            }
            ldb.b(this.a.getPageActivity(), 1);
            this.b.r();
        }
    }
}
