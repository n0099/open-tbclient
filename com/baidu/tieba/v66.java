package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class v66 extends ep4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;
    public List<u66> e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948192787, "Lcom/baidu/tieba/v66;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948192787, "Lcom/baidu/tieba/v66;");
                return;
            }
        }
        BdUniqueId.gen();
    }

    public v66() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        f(13);
        this.e = new ArrayList();
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.d : (String) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e.add(new u66(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0924), R.drawable.obfuscated_res_0x7f0807c0));
            this.e.add(new u66(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f091a), R.drawable.obfuscated_res_0x7f0807bc));
            this.e.add(new u66(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0934), R.drawable.obfuscated_res_0x7f0807c8));
            this.e.add(new u66(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f091c), R.drawable.obfuscated_res_0x7f0807bd));
            this.e.add(new u66(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f091e), R.drawable.obfuscated_res_0x7f0807c9));
            this.e.add(new u66(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f092e), R.drawable.obfuscated_res_0x7f0807c3));
            this.e.add(new u66(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0918), R.drawable.obfuscated_res_0x7f0807be));
            this.e.add(new u66(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f092c), R.drawable.obfuscated_res_0x7f0807bf));
            this.e.add(new u66(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f092a), R.drawable.obfuscated_res_0x7f0807c5));
            this.e.add(new u66(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0931), R.drawable.obfuscated_res_0x7f0807c4));
            this.e.add(new u66(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0925), R.drawable.obfuscated_res_0x7f0807c1));
            this.e.add(new u66(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0930), R.drawable.obfuscated_res_0x7f0807c2));
            this.e.add(new u66(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0926), R.drawable.obfuscated_res_0x7f0807c7));
            this.e.add(new u66(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f092f), R.drawable.obfuscated_res_0x7f0807c6));
        }
    }

    public List<u66> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : (List) invokeV.objValue;
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.d = str;
        }
    }
}
