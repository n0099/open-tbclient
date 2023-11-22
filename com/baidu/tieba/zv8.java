package com.baidu.tieba;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
@JvmName(name = "TbBaseMsgExt")
/* loaded from: classes9.dex */
public final class zv8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final long a(TbBaseMsg tbBaseMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbBaseMsg)) == null) {
            Intrinsics.checkNotNullParameter(tbBaseMsg, "<this>");
            TbBaseMsg.c forumExt = tbBaseMsg.getForumExt();
            if (forumExt != null) {
                return forumExt.a();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static final CharSequence b(TbBaseMsg tbBaseMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbBaseMsg)) == null) {
            Intrinsics.checkNotNullParameter(tbBaseMsg, "<this>");
            String string = TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0423);
            Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(R.st…_reply_msg_prefix_format)");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(string, Arrays.copyOf(new Object[]{tbBaseMsg.getUserName()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        return (CharSequence) invokeL.objValue;
    }
}
