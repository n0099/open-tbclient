package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class wb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static zu5 a(int i, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, cls)) == null) {
            try {
                zu5 zu5Var = new zu5(i, cls.newInstance());
                MessageManager.getInstance().registerTask(zu5Var);
                return zu5Var;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (InstantiationException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (zu5) invokeIL.objValue;
    }

    public static av5 b(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), cls, Boolean.valueOf(z)})) == null) {
            av5 av5Var = new av5(i);
            av5Var.setResponsedClass(cls);
            av5Var.h(z);
            av5Var.setParallel(TiebaIMConfig.getParallel());
            MessageManager.getInstance().registerTask(av5Var);
            return av5Var;
        }
        return (av5) invokeCommon.objValue;
    }
}
