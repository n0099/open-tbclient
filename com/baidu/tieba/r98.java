package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.task.TbSocketMessageTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class r98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ps5 a(int i, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, cls)) == null) {
            try {
                ps5 ps5Var = new ps5(i, cls.newInstance());
                MessageManager.getInstance().registerTask(ps5Var);
                return ps5Var;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (InstantiationException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (ps5) invokeIL.objValue;
    }

    public static TbSocketMessageTask b(int i, Class<? extends SocketResponsedMessage> cls, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), cls, Boolean.valueOf(z)})) == null) {
            TbSocketMessageTask tbSocketMessageTask = new TbSocketMessageTask(i);
            tbSocketMessageTask.setResponsedClass(cls);
            tbSocketMessageTask.setNeedCompress(z);
            tbSocketMessageTask.setParallel(TiebaIMConfig.getParallel());
            MessageManager.getInstance().registerTask(tbSocketMessageTask);
            return tbSocketMessageTask;
        }
        return (TbSocketMessageTask) invokeCommon.objValue;
    }
}
