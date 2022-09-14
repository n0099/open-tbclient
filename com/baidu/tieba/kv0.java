package com.baidu.tieba;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class kv0 implements CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnVideoSizeChangedListener, CyberPlayerManager.OnMediaSourceChangedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pv0 a;

    public kv0() {
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

    public void a(@Nullable pv0 pv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pv0Var) == null) {
            this.a = pv0Var;
        }
    }

    public final int b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i != 701) {
                if (i != 702) {
                    if (i != 904) {
                        if (i != 910) {
                            if (i != 924) {
                                if (i != 946) {
                                    if (i != 5000) {
                                        if (i != 10009) {
                                            if (i != 10103) {
                                                if (i != 936) {
                                                    if (i != 937) {
                                                        if (i != 955) {
                                                            if (i != 956) {
                                                                if (i != 11004) {
                                                                    if (i != 11005) {
                                                                        if (i != 12005) {
                                                                            if (i != 12006) {
                                                                                return i;
                                                                            }
                                                                            return 12006;
                                                                        }
                                                                        return 12005;
                                                                    }
                                                                    return 11005;
                                                                }
                                                                return 11004;
                                                            }
                                                            return 956;
                                                        }
                                                        return 955;
                                                    }
                                                    return 937;
                                                }
                                                return 936;
                                            }
                                            return 10103;
                                        }
                                        return 10009;
                                    }
                                    return 5000;
                                }
                                return 946;
                            }
                            return 924;
                        }
                        return 910;
                    }
                    return 904;
                }
                return 702;
            }
            return 701;
        }
        return invokeI.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i) {
        pv0 pv0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || (pv0Var = this.a) == null) {
            return;
        }
        pv0Var.onBufferingUpdate(i);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        pv0 pv0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (pv0Var = this.a) == null) {
            return;
        }
        pv0Var.onCompletion();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048580, this, i, i2, obj)) == null) {
            pv0 pv0Var = this.a;
            if (pv0Var != null) {
                return pv0Var.onError(i, i2, obj);
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048581, this, i, i2, obj)) == null) {
            if (this.a != null) {
                return this.a.onInfo(b(i), i2, obj);
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048582, this, i, i2, obj)) == null) {
            pv0 pv0Var = this.a;
            if (pv0Var != null) {
                return pv0Var.onMediaSourceChanged(i, i2, obj);
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        pv0 pv0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (pv0Var = this.a) == null) {
            return;
        }
        pv0Var.onPrepared();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        pv0 pv0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (pv0Var = this.a) == null) {
            return;
        }
        pv0Var.onSeekComplete();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        pv0 pv0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048585, this, i, i2, i3, i4) == null) || (pv0Var = this.a) == null) {
            return;
        }
        pv0Var.onVideoSizeChanged(i, i2, i3, i4);
    }
}
