package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.helper.ProgressHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class x79 extends ProgressHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BDVideoPlayer a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x79(@NonNull BDVideoPlayer bDVideoPlayer) {
        super(bDVideoPlayer);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bDVideoPlayer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BDVideoPlayer) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bDVideoPlayer;
    }

    public final void callPlayerBack(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) && i2 > 0) {
            this.a.getPlayerCallbackManager().onUpdateProgress(i, (i3 * 100) / i2, i2);
        }
    }

    @Override // com.baidu.searchbox.player.helper.ProgressHelper, com.baidu.searchbox.player.helper.ITimerTask
    public void doTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int position = this.a.getPosition();
            int durationMs = this.a.getDurationMs();
            int bufferingPosition = this.a.getBufferingPosition();
            int positionMs = this.a.getPositionMs();
            this.a.getControlEventTrigger().syncPos(position, durationMs, bufferingPosition);
            callPlayerBack(positionMs, durationMs, bufferingPosition);
        }
    }
}
