package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class xf7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static ArrayList<MetaData> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921689, mc7.class);
            if (runTask != null && runTask.getData() != null) {
                return ((mc7) runTask.getData()).b();
            }
            return new ArrayList<>();
        }
        return (ArrayList) invokeV.objValue;
    }
}
