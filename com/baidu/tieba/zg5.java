package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.log.DefaultLog;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class zg5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final String a(String spriteTalk, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, spriteTalk, i)) == null) {
            Intrinsics.checkNotNullParameter(spriteTalk, "spriteTalk");
            return "tiebaapp://router/portal?params={\"page\":\"im/funnySprite\",\"pageParams\":{\"spriteType\": \"" + i + "\",spriteTalk: \"" + spriteTalk + "\"}}";
        }
        return (String) invokeLI.objValue;
    }

    public static final void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, null, i) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_REQUEST_SPRITE_LOOP);
            httpMessage.addParam("scene", i);
            httpMessage.addParam("sprite_uk", q45.m().s("key_funny_sprite_uk", ""));
            httpMessage.addParam("version", q45.m().s("key_sprite_speech_version", ""));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            vg8 defaultLog = DefaultLog.getInstance();
            defaultLog.c("SpriteTip", "tryRequestFirstTip isShowSpriteDialog:" + TbSingleton.getInstance().isShowSpriteDialog);
            if (!TbSingleton.getInstance().isShowSpriteDialog) {
                return;
            }
            b(3);
            TbSingleton.getInstance().isShowSpriteDialog = false;
        }
    }
}
