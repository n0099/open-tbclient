package com.baidu.tieba;

import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlSchemaJumpHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, context, str) == null) {
            UrlSchemaJumpHelper.jumpGameAlbum(context, str);
        }
    }

    public static void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, str) == null) {
            UrlSchemaJumpHelper.jumpGameGodsPage(context, str);
        }
    }

    public static void c(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, str) == null) {
            UrlSchemaJumpHelper.jumpGameOrderPage(context, str);
        }
    }

    public static void d(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, str) == null) {
            UrlSchemaJumpHelper.jumpGameSkillDetail(context, str);
        }
    }

    public static void e(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, z) == null) {
            UrlSchemaJumpHelper.jumpPersonChat(context, str, z);
        }
    }

    public static Ringtone f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            Ringtone ringtone = RingtoneManager.getRingtone(TbadkCoreApplication.getInst(), RingtoneManager.getDefaultUri(2));
            ringtone.play();
            return ringtone;
        }
        return (Ringtone) invokeV.objValue;
    }
}
