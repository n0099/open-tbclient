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
/* loaded from: classes8.dex */
public class vx6 extends e25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;
    public List<ux6> e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948256213, "Lcom/baidu/tieba/vx6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948256213, "Lcom/baidu/tieba/vx6;");
                return;
            }
        }
        BdUniqueId.gen();
    }

    public vx6() {
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
        d(13);
        this.e = new ArrayList();
    }

    public List<ux6> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (List) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e.add(new ux6(TbadkApplication.getInst().getString(R.string.interested_class_name_game), R.drawable.obfuscated_res_0x7f080999));
            this.e.add(new ux6(TbadkApplication.getInst().getString(R.string.interested_class_name_comic), R.drawable.obfuscated_res_0x7f080995));
            this.e.add(new ux6(TbadkApplication.getInst().getString(R.string.interested_class_name_sport), R.drawable.obfuscated_res_0x7f0809a1));
            this.e.add(new ux6(TbadkApplication.getInst().getString(R.string.interested_class_name_digita), R.drawable.obfuscated_res_0x7f080996));
            this.e.add(new ux6(TbadkApplication.getInst().getString(R.string.interested_class_name_entertainment), R.drawable.obfuscated_res_0x7f0809a2));
            this.e.add(new ux6(TbadkApplication.getInst().getString(R.string.interested_class_name_moviezong), R.drawable.obfuscated_res_0x7f08099c));
            this.e.add(new ux6(TbadkApplication.getInst().getString(R.string.interested_class_name_campus), R.drawable.obfuscated_res_0x7f080997));
            this.e.add(new ux6(TbadkApplication.getInst().getString(R.string.interested_class_name_motion), R.drawable.obfuscated_res_0x7f080998));
            this.e.add(new ux6(TbadkApplication.getInst().getString(R.string.interested_class_name_local), R.drawable.obfuscated_res_0x7f08099e));
            this.e.add(new ux6(TbadkApplication.getInst().getString(R.string.interested_class_name_science), R.drawable.obfuscated_res_0x7f08099d));
            this.e.add(new ux6(TbadkApplication.getInst().getString(R.string.interested_class_name_history), R.drawable.obfuscated_res_0x7f08099a));
            this.e.add(new ux6(TbadkApplication.getInst().getString(R.string.interested_class_name_novel), R.drawable.obfuscated_res_0x7f08099b));
            this.e.add(new ux6(TbadkApplication.getInst().getString(R.string.interested_class_name_industry), R.drawable.obfuscated_res_0x7f0809a0));
            this.e.add(new ux6(TbadkApplication.getInst().getString(R.string.interested_class_name_music), R.drawable.obfuscated_res_0x7f08099f));
        }
    }

    public void setTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.d = str;
        }
    }
}
