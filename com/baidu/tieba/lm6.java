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
/* loaded from: classes5.dex */
public class lm6 extends gx4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;
    public List<km6> e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947947732, "Lcom/baidu/tieba/lm6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947947732, "Lcom/baidu/tieba/lm6;");
                return;
            }
        }
        BdUniqueId.gen();
    }

    public lm6() {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public List<km6> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (List) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e.add(new km6(TbadkApplication.getInst().getString(R.string.interested_class_name_game), R.drawable.obfuscated_res_0x7f080830));
            this.e.add(new km6(TbadkApplication.getInst().getString(R.string.interested_class_name_comic), R.drawable.obfuscated_res_0x7f08082c));
            this.e.add(new km6(TbadkApplication.getInst().getString(R.string.interested_class_name_sport), R.drawable.obfuscated_res_0x7f080838));
            this.e.add(new km6(TbadkApplication.getInst().getString(R.string.interested_class_name_digita), R.drawable.obfuscated_res_0x7f08082d));
            this.e.add(new km6(TbadkApplication.getInst().getString(R.string.interested_class_name_entertainment), R.drawable.obfuscated_res_0x7f080839));
            this.e.add(new km6(TbadkApplication.getInst().getString(R.string.interested_class_name_moviezong), R.drawable.obfuscated_res_0x7f080833));
            this.e.add(new km6(TbadkApplication.getInst().getString(R.string.interested_class_name_campus), R.drawable.obfuscated_res_0x7f08082e));
            this.e.add(new km6(TbadkApplication.getInst().getString(R.string.interested_class_name_motion), R.drawable.obfuscated_res_0x7f08082f));
            this.e.add(new km6(TbadkApplication.getInst().getString(R.string.interested_class_name_local), R.drawable.obfuscated_res_0x7f080835));
            this.e.add(new km6(TbadkApplication.getInst().getString(R.string.interested_class_name_science), R.drawable.obfuscated_res_0x7f080834));
            this.e.add(new km6(TbadkApplication.getInst().getString(R.string.interested_class_name_history), R.drawable.obfuscated_res_0x7f080831));
            this.e.add(new km6(TbadkApplication.getInst().getString(R.string.interested_class_name_novel), R.drawable.obfuscated_res_0x7f080832));
            this.e.add(new km6(TbadkApplication.getInst().getString(R.string.interested_class_name_industry), R.drawable.obfuscated_res_0x7f080837));
            this.e.add(new km6(TbadkApplication.getInst().getString(R.string.interested_class_name_music), R.drawable.obfuscated_res_0x7f080836));
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.d = str;
        }
    }
}
