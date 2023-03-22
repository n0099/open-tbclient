package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class mi8 implements gn {
    public static /* synthetic */ Interceptable $ic;
    public static BdUniqueId j;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public int c;
    public int d;
    public boolean e;
    public String f;
    public String g;
    public boolean h;
    public List<String> i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947973741, "Lcom/baidu/tieba/mi8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947973741, "Lcom/baidu/tieba/mi8;");
                return;
            }
        }
        j = BdUniqueId.gen();
    }

    @Override // com.baidu.tieba.gn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return j;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public mi8(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumData};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = false;
        if (forumData == null) {
            return;
        }
        this.a = forumData.getName();
        this.b = forumData.getImage_url();
        this.c = forumData.getPost_num();
        this.d = forumData.getMember_num();
        this.f = forumData.getId();
        this.h = forumData.isLike() == 1;
    }

    public mi8(iz4 iz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iz4Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.e = false;
        if (iz4Var == null) {
            return;
        }
        this.a = iz4Var.b;
        this.b = iz4Var.c;
        this.c = iz4Var.g;
        this.d = iz4Var.h;
        this.f = iz4Var.a;
        this.h = iz4Var.e();
        this.i = iz4Var.f();
    }
}
