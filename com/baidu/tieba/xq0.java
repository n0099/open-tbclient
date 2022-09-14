package com.baidu.tieba;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class xq0 implements vq0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final oq0 b;
    public sq0 c;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b implements tr0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xq0 a;

        public b(xq0 xq0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xq0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xq0Var;
        }

        @Override // com.baidu.tieba.tr0
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.c == null) {
                return;
            }
            this.a.c.a(i);
        }

        @Override // com.baidu.tieba.tr0
        public void onBufferEnd() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.c == null) {
                return;
            }
            this.a.c.onBufferEnd();
        }

        @Override // com.baidu.tieba.tr0
        public void onBufferStart() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.c == null) {
                return;
            }
            this.a.c.onBufferStart();
        }

        @Override // com.baidu.tieba.tr0
        public void onEnd(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || this.a.c == null) {
                return;
            }
            this.a.c.onEnd(i);
        }

        @Override // com.baidu.tieba.tr0
        public void onError(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIIL(1048580, this, i, i2, str) == null) || this.a.c == null) {
                return;
            }
            this.a.c.onError(i, i2, str);
        }

        @Override // com.baidu.tieba.tr0
        public void onInfo(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) || this.a.c == null) {
                return;
            }
            this.a.c.onInfo(i, i2);
        }

        @Override // com.baidu.tieba.tr0
        public void onPause() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.a.c == null) {
                return;
            }
            this.a.c.onPause();
        }

        @Override // com.baidu.tieba.tr0
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.a.c == null) {
                return;
            }
            this.a.c.onPrepared();
        }

        @Override // com.baidu.tieba.tr0
        public void onResume() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.a.c == null) {
                return;
            }
            this.a.c.onResume();
        }

        @Override // com.baidu.tieba.tr0
        public void onSeekEnd() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.a.c == null) {
                return;
            }
            this.a.c.onSeekEnd();
        }

        @Override // com.baidu.tieba.tr0
        public void onStart() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.a.c == null) {
                return;
            }
            this.a.c.onStart();
        }

        @Override // com.baidu.tieba.tr0
        public void onUpdateProgress(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIII(1048587, this, i, i2, i3) == null) || this.a.c == null) {
                return;
            }
            this.a.c.onUpdateProgress(i, i2, i3);
        }

        @Override // com.baidu.tieba.tr0
        public void onVideoSizeChanged(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) || this.a.c == null) {
                return;
            }
            this.a.c.onVideoSizeChanged(i, i2);
        }

        public /* synthetic */ b(xq0 xq0Var, a aVar) {
            this(xq0Var);
        }
    }

    public xq0(oq0 oq0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oq0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = oq0Var;
        oq0Var.y0(new b(this, null));
    }

    @Override // com.baidu.tieba.vq0
    public void a(sq0 sq0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sq0Var) == null) {
            this.c = sq0Var;
        }
    }

    @Override // com.baidu.tieba.vq0
    public void attachToContainer(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) {
            this.b.f(viewGroup);
        }
    }

    @Override // com.baidu.tieba.rq0
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b.D() : invokeV.intValue;
    }

    @Override // com.baidu.tieba.vq0
    public void c(@NonNull wo0 wo0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, wo0Var) == null) {
            BdVideoSeries c = o31.c(wo0Var.g);
            IVideoUpdateStrategy n1 = this.b.n1();
            if (c != null) {
                c.setVideoAd(f(wo0Var.f));
                c.setStartPosition(n1.h() ? 0 : -1);
                c.setPlayLoop(n1.e());
                this.b.A1(c);
            } else if (mq0.f()) {
                throw new IllegalArgumentException("Invalid video info");
            }
        }
    }

    @Override // com.baidu.tieba.vq0
    public void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVideoUpdateStrategy) == null) {
            this.b.z1(iVideoUpdateStrategy);
        }
    }

    public final BdVideoAd f(yo0 yo0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, yo0Var)) == null) {
            if (yo0Var == null) {
                return null;
            }
            BdVideoAd.b bVar = new BdVideoAd.b();
            bVar.b(yo0Var);
            bVar.c(true);
            return bVar.a();
        }
        return (BdVideoAd) invokeL.objValue;
    }

    @Override // com.baidu.tieba.rq0
    public boolean isPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b.W() : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.rq0
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.b.Y() : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tq0
    public void mute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.b.c0(z);
        }
    }

    @Override // com.baidu.tieba.tq0
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b.e0();
        }
    }

    @Override // com.baidu.tieba.vq0
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.g0();
        }
    }

    @Override // com.baidu.tieba.tq0
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.b.l0();
        }
    }

    @Override // com.baidu.tieba.tq0
    public void setVideoScalingMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.b.B0(i);
        }
    }

    @Override // com.baidu.tieba.tq0
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.b.K0();
        }
    }

    @Override // com.baidu.tieba.tq0
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.b.L0();
        }
    }
}
