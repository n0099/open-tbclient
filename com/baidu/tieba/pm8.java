package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class pm8 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final String e;
    public static final String f;
    public static final String g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948066958, "Lcom/baidu/tieba/pm8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948066958, "Lcom/baidu/tieba/pm8;");
                return;
            }
        }
        a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0932);
        b = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0934);
        c = TbadkCoreApplication.getInst().getString(R.string.group_chat_group_had_close);
        d = TbadkCoreApplication.getInst().getString(R.string.group_chat_no_speak_all);
        e = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f094c);
        f = TbadkCoreApplication.getInst().getString(R.string.group_chat_no_speak_person);
        g = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0940);
    }
}
