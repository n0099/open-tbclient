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
/* loaded from: classes4.dex */
public class l86 extends jr4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;
    public List<k86> e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947896799, "Lcom/baidu/tieba/l86;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947896799, "Lcom/baidu/tieba/l86;");
                return;
            }
        }
        BdUniqueId.gen();
    }

    public l86() {
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
            this.e.add(new k86(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0937), R.drawable.obfuscated_res_0x7f0807da));
            this.e.add(new k86(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f092d), R.drawable.obfuscated_res_0x7f0807d6));
            this.e.add(new k86(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0947), R.drawable.obfuscated_res_0x7f0807e2));
            this.e.add(new k86(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f092f), R.drawable.obfuscated_res_0x7f0807d7));
            this.e.add(new k86(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0931), R.drawable.obfuscated_res_0x7f0807e3));
            this.e.add(new k86(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0941), R.drawable.obfuscated_res_0x7f0807dd));
            this.e.add(new k86(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f092b), R.drawable.obfuscated_res_0x7f0807d8));
            this.e.add(new k86(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f093f), R.drawable.obfuscated_res_0x7f0807d9));
            this.e.add(new k86(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f093d), R.drawable.obfuscated_res_0x7f0807df));
            this.e.add(new k86(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0944), R.drawable.obfuscated_res_0x7f0807de));
            this.e.add(new k86(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0938), R.drawable.obfuscated_res_0x7f0807db));
            this.e.add(new k86(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0943), R.drawable.obfuscated_res_0x7f0807dc));
            this.e.add(new k86(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0939), R.drawable.obfuscated_res_0x7f0807e1));
            this.e.add(new k86(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0942), R.drawable.obfuscated_res_0x7f0807e0));
        }
    }

    public List<k86> j() {
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
