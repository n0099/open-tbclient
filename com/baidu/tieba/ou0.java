package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.StatisticsEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ou0 extends lu0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ou0() {
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

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c(nu0.w(StatisticsEvent.ACTION_PLAYER_PAUSE));
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c(nu0.w(StatisticsEvent.ACTION_PLAYER_RESUME));
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c(nu0.w(StatisticsEvent.ACTION_PLAYER_START));
        }
    }

    public void d(int i, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, obj) == null) {
            ru0 w = nu0.w(StatisticsEvent.ACTION_PLAYER_ERROR);
            w.n(2, String.valueOf(obj));
            w.n(4, Integer.valueOf(i2));
            c(w);
        }
    }

    public void e(int i, int i2, Object obj) {
        ru0 w;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj) == null) {
            if (i != 701) {
                if (i != 702) {
                    if (i != 904 && i != 956) {
                        if (i != 10009) {
                            if (i != 11004) {
                                if (i != 11005) {
                                    w = null;
                                } else {
                                    w = nu0.w(StatisticsEvent.ACTION_ERROR_RETRY_END);
                                }
                            } else {
                                w = nu0.w(StatisticsEvent.ACTION_ERROR_RETRY_START);
                                w.n(4, Integer.valueOf(i2));
                            }
                        } else {
                            w = nu0.w("statistics_player_carlton");
                            w.n(2, String.valueOf(obj));
                        }
                    } else {
                        w = nu0.w(StatisticsEvent.ACTION_PLAYER_FIRST_FRAME_DISPLAY);
                        w.n(2, String.valueOf(obj));
                    }
                } else {
                    w = nu0.w(StatisticsEvent.ACTION_BUFFER_END);
                }
            } else {
                w = nu0.w(StatisticsEvent.ACTION_BUFFER_START);
            }
            if (w != null) {
                c(w);
            }
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            ru0 w = nu0.w(StatisticsEvent.ACTION_PLAYER_COMPLETE);
            w.n(1, Integer.valueOf(i));
            c(w);
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            ru0 w = nu0.w(StatisticsEvent.ACTION_PLAYER_STOP);
            w.n(1, Integer.valueOf(i));
            c(w);
        }
    }
}
