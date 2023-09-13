package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.base.BdPageContext;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class oja {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static VoiceManager a(Context context) {
        InterceptResult invokeL;
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context instanceof VoiceManager.i) {
                return ((VoiceManager.i) context).R0();
            }
            if ((m9.a(context) instanceof BdPageContext) && (tbPageContext = (TbPageContext) m9.a(context)) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.i)) {
                return ((VoiceManager.i) tbPageContext.getOrignalPage()).R0();
            }
            return null;
        }
        return (VoiceManager) invokeL.objValue;
    }

    public static VoiceManager b(Context context) {
        InterceptResult invokeL;
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context instanceof VoiceManager.j) {
                return ((VoiceManager.j) context).H0();
            }
            if ((m9.a(context) instanceof BdPageContext) && (tbPageContext = (TbPageContext) m9.a(context)) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) {
                return ((VoiceManager.j) tbPageContext.getOrignalPage()).H0();
            }
            return null;
        }
        return (VoiceManager) invokeL.objValue;
    }
}
