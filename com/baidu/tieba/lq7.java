package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.player.ExtAction;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.plugin.AbsPlugin;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class lq7 extends AbsPlugin {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.searchbox.player.plugin.AbsPlugin, com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerEventNotify(VideoEvent event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lq7(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new int[]{1, 4};
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.plugin.AbsPlugin, com.baidu.searchbox.player.interfaces.INeuron
    @SuppressLint({"WrongConstant"})
    public void onSystemEventNotify(VideoEvent event) {
        boolean isStop;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            String action = event.getAction();
            if (action.hashCode() == 1822725860 && action.equals(SystemEvent.ACTION_VOLUME_CHANGED)) {
                BDVideoPlayer bindPlayer = getBindPlayer();
                boolean z = true;
                if (bindPlayer == null) {
                    isStop = true;
                } else {
                    isStop = bindPlayer.isStop();
                }
                if (!isStop) {
                    BDVideoPlayer bindPlayer2 = getBindPlayer();
                    if (bindPlayer2 != null) {
                        z = bindPlayer2.isComplete();
                    }
                    if (!z) {
                        ExtAction extAction = new ExtAction(event.getAction());
                        extAction.put(5, Integer.valueOf(event.getIntExtra(5)));
                        BDVideoPlayer bindPlayer3 = getBindPlayer();
                        if (bindPlayer3 != null) {
                            bindPlayer3.onInfo(0, 0, extAction);
                        }
                    }
                }
            }
        }
    }
}
