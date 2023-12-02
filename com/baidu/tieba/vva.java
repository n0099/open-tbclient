package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.task.TbSocketMessageTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vva {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948255624, "Lcom/baidu/tieba/vva;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948255624, "Lcom/baidu/tieba/vva;");
        }
    }

    public static String a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i)) == null) {
            return TbConfig.SERVER_ADDRESS + str + "?cmd=" + i;
        }
        return (String) invokeLI.objValue;
    }

    public static oq5 b(int i, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i, cls)) == null) {
            try {
                oq5 oq5Var = new oq5(i, cls.newInstance());
                MessageManager.getInstance().registerTask(oq5Var);
                return oq5Var;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (InstantiationException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (oq5) invokeIL.objValue;
    }

    public static TbHttpMessageTask c(int i, int i2, String str, Class<? extends HttpResponsedMessage> cls, boolean z, boolean z2, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, cls, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(i2, a(str, i));
            tbHttpMessageTask.setIsNeedLogin(z);
            tbHttpMessageTask.setIsNeedTbs(z2);
            tbHttpMessageTask.setIsNeedAddCommenParam(z3);
            tbHttpMessageTask.setIsUseCurrentBDUSS(z4);
            tbHttpMessageTask.setResponsedClass(cls);
            MessageManager.getInstance().unRegisterTask(i2);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            return tbHttpMessageTask;
        }
        return (TbHttpMessageTask) invokeCommon.objValue;
    }

    public static void d(int i, int i2, String str, Class<? extends HttpResponsedMessage> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, cls}) == null) {
            c(i2, i, str, cls, false, true, true, false);
        }
    }

    public static TbSocketMessageTask h(int i, Class<? extends SocketResponsedMessage> cls, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Integer.valueOf(i), cls, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            return g(i, cls, z, SocketMessageTask.DupLicateMode.NONE, z2);
        }
        return (TbSocketMessageTask) invokeCommon.objValue;
    }

    public static TbHttpMessageTask e(int i, String str, Class<? extends HttpResponsedMessage> cls, boolean z, boolean z2, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Integer.valueOf(i), str, cls, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(i, TbConfig.SERVER_ADDRESS + str);
            tbHttpMessageTask.setIsNeedLogin(z);
            tbHttpMessageTask.setIsNeedTbs(z2);
            tbHttpMessageTask.setIsNeedAddCommenParam(z3);
            tbHttpMessageTask.setIsUseCurrentBDUSS(z4);
            tbHttpMessageTask.setResponsedClass(cls);
            MessageManager.getInstance().unRegisterTask(i);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            return tbHttpMessageTask;
        }
        return (TbHttpMessageTask) invokeCommon.objValue;
    }

    public static TbSocketMessageTask f(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Integer.valueOf(i), cls, Boolean.valueOf(z)})) == null) {
            return g(i, cls, z, SocketMessageTask.DupLicateMode.NONE, true);
        }
        return (TbSocketMessageTask) invokeCommon.objValue;
    }

    public static TbSocketMessageTask g(int i, Class<? extends SocketResponsedMessage> cls, boolean z, SocketMessageTask.DupLicateMode dupLicateMode, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i), cls, Boolean.valueOf(z), dupLicateMode, Boolean.valueOf(z2)})) == null) {
            TbSocketMessageTask tbSocketMessageTask = new TbSocketMessageTask(i);
            tbSocketMessageTask.setResponsedClass(cls);
            tbSocketMessageTask.setNeedCompress(z);
            tbSocketMessageTask.setDupLicateMode(dupLicateMode);
            tbSocketMessageTask.setRetry(a);
            MessageManager.getInstance().unRegisterTask(i);
            MessageManager.getInstance().registerTask(tbSocketMessageTask);
            tbSocketMessageTask.setNeedEncrypt(z2);
            return tbSocketMessageTask;
        }
        return (TbSocketMessageTask) invokeCommon.objValue;
    }
}
