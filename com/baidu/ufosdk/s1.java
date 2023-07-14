package com.baidu.ufosdk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class s1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "https://ufosdk.baidu.com/";
    public static final String[] b;
    public static final String c;
    public static final String d;
    public static final String e;
    public static final String f;
    public static final String g;
    public static final String h;
    public static final String i;
    public static final String j;
    public static final String k;
    public static final String l;
    public static final String m;
    public static final String n;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1174244952, "Lcom/baidu/ufosdk/s1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1174244952, "Lcom/baidu/ufosdk/s1;");
                return;
            }
        }
        b = new String[]{"ufosdk.baidu.com"};
        r0 = a + "?m=Web&a=getnfaqlist";
        String str = a + "?m=Index&a=getProductType";
        c = a + "?m=Index&a=getmsgbyclient";
        d = a + "?m=Index&a=recordEvaluation";
        e = a + "?m=Index&a=getallmsgbyclientid";
        f = a + "?m=Index&a=postmsg";
        g = a + "?m=Index&a=postclientinfo";
        String str2 = a + "?m=Index&a=gethisbyclient";
        h = a + "?m=Index&a=getHisByClientCrossProductLine";
        i = a + "?m=Index&a=newmsgnotice";
        String str3 = a + "?m=Index&a=getmsglistcount";
        j = a + "?m=Index&a=delmsgbyid";
        String str4 = a + "/?m=Index&a=getRobotQList";
        k = a + "?m=Index&a=getEvaluationConf";
        l = a + "?m=Index&a=recordDiscontent";
        m = a + "?m=Index&a=getEvaluationToast";
        n = a + "api?m=Customer&a=coludSwitch";
    }
}
