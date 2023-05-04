package com.baidu.tieba;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes7.dex */
public class xp2 extends rl2<iq2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AudioManager b;

    @Override // com.baidu.tieba.rl2
    @NonNull
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "setVolume" : (String) invokeV.objValue;
    }

    public xp2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rl2
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull iq2 iq2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, command, iq2Var) != null) || command.obj == null) {
            return;
        }
        if (!iq2Var.P()) {
            d(iq2Var, command.what, "Not Set!! Volume: " + command.obj, false);
            return;
        }
        Object obj = command.obj;
        if (obj instanceof Double) {
            try {
                double doubleValue = ((Double) obj).doubleValue();
                d(iq2Var, command.what, "Volume: " + command.obj, false);
                if (doubleValue > 1.0d) {
                    doubleValue = 1.0d;
                }
                if (doubleValue < 0.0d) {
                    doubleValue = 0.0d;
                }
                f(doubleValue, iq2Var.getContext());
            } catch (Exception unused) {
                if (rl2.a) {
                    Log.e(b(), "setVolume param type error");
                }
            }
        }
    }

    public final void f(double d, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d), context}) == null) {
            if (this.b == null) {
                this.b = (AudioManager) context.getSystemService("audio");
            }
            AudioManager audioManager = this.b;
            if (audioManager == null) {
                return;
            }
            int round = (int) Math.round(audioManager.getStreamMaxVolume(3) * d);
            if (round == this.b.getStreamVolume(3)) {
                if (rl2.a) {
                    Log.d("【InlineCommand】", "Setting same volume level, ignore : (" + round + SmallTailInfo.EMOTION_SUFFIX);
                    return;
                }
                return;
            }
            if (d > 0.0d && round == 0) {
                round = 1;
            }
            if (rl2.a) {
                Log.d("【InlineCommand】", "setVolumeInt" + round);
            }
            this.b.setStreamVolume(3, round, 0);
        }
    }
}
