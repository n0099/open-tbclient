package com.baidu.tts;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes9.dex */
public class x0 implements ThreadFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public int c;

    public x0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = str2;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
            this.c++;
            StringBuilder sb = new StringBuilder();
            sb.append(this.b);
            if (!TextUtils.isEmpty(this.a)) {
                sb.append("-");
                sb.append(this.a);
            }
            sb.append("(");
            sb.append(this.c);
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            String sb2 = sb.toString();
            i2 i2Var = new i2(runnable, sb2);
            LoggerProxy.d("NameThreadFactory", "threadName=" + sb2);
            return i2Var;
        }
        return (Thread) invokeL.objValue;
    }
}
