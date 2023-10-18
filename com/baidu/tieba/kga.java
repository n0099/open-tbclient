package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.base.BdPageContext;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class kga {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static VoiceManager a(Context context) {
        InterceptResult invokeL;
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context instanceof VoiceManager.i) {
                return ((VoiceManager.i) context).N0();
            }
            if ((k4.a(context) instanceof BdPageContext) && (tbPageContext = (TbPageContext) k4.a(context)) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.i)) {
                return ((VoiceManager.i) tbPageContext.getOrignalPage()).N0();
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
                return ((VoiceManager.j) context).O0();
            }
            if ((k4.a(context) instanceof BdPageContext) && (tbPageContext = (TbPageContext) k4.a(context)) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) {
                return ((VoiceManager.j) tbPageContext.getOrignalPage()).O0();
            }
            return null;
        }
        return (VoiceManager) invokeL.objValue;
    }
}
