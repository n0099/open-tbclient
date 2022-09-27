package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class s77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static le5 a(int i, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, cls)) == null) {
            try {
                le5 le5Var = new le5(i, cls.newInstance());
                MessageManager.getInstance().registerTask(le5Var);
                return le5Var;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (InstantiationException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (le5) invokeIL.objValue;
    }

    public static me5 b(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), cls, Boolean.valueOf(z)})) == null) {
            me5 me5Var = new me5(i);
            me5Var.setResponsedClass(cls);
            me5Var.h(z);
            me5Var.setParallel(TiebaIMConfig.getParallel());
            MessageManager.getInstance().registerTask(me5Var);
            return me5Var;
        }
        return (me5) invokeCommon.objValue;
    }
}
